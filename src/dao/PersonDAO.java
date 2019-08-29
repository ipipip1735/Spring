package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.StatementCallback;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2019/8/28 10:46.
 */
public class PersonDAO {


    private JdbcTemplate jdbcTemplate;


    public PersonDAO() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }


    @Autowired
    public void setDataSource(DataSource dataSource) {
        System.out.println("~~" + getClass().getSimpleName() + ".setDataSource~~");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void query() {
        System.out.println("~~" + getClass().getSimpleName() + ".query~~");


        //例一：获取记录条数
//        String sql = "SELECT count(*) FROM mine.mine_person";
//        int r = this.jdbcTemplate.queryForObject(sql, Integer.class);
//        System.out.println(r);

        //例二：获取记录条数，并给占位符传递参数
//        String sql = "SELECT count(*) FROM mine.mine_person WHERE person_id=?;";
//        Object[] args = new Object[]{3};
//        int r = jdbcTemplate.queryForObject(sql, Integer.class, args);
//        System.out.println(r);

        //例三：
//        String sql = "SELECT * FROM mine.mine_person WHERE person_id=? LIMIT 1;";
//        Object[] args = new Object[]{10};
//        Person person = jdbcTemplate.queryForObject(sql, args, new PersonMapper());
//        System.out.println(person);

        //例四：：返回对象集合
//        String sql = "SELECT * FROM mine.mine_person";
//        List<Person> persons = jdbcTemplate.query(sql, new PersonMapper());
//        System.out.println(persons);

        //例五：返回多条数据，并传递占位符的值
        String sql = "SELECT * FROM mine.mine_person LIMIT ?";
        Object[] args = new Object[]{2};
        List<Person> persons = jdbcTemplate.query(sql, new PersonMapper(), args);
        System.out.println(persons);


    }

    public void delete() {
        System.out.println("~~" + getClass().getSimpleName() + ".delete~~");
        //例一
//        String sql = "DELETE FROM mine.mine_person WHERE person_id = 5;";
//        int r = jdbcTemplate.update(sql);
//        System.out.println(r);

        //例二
//        String sql = "DELETE FROM mine.mine_person WHERE person_id = ?;";
//        Object[] args = new Object[]{2};
//        int r = jdbcTemplate.update(sql, 1);
//        System.out.println(r);

    }


    public void insert() {
        System.out.println("~~" + getClass().getSimpleName() + ".insert~~");
        String sql = "INSERT INTO mine.mine_person(person_name, person_age, person_sex) VALUES(?,?,?);";
        Random random = new Random();
        Object[] args = new Object[]{"bob" + random.nextInt(120), random.nextInt(120), true};

        int r = jdbcTemplate.update(sql, args);
        System.out.println(r);

    }


    public void update() {
        System.out.println("~~" + getClass().getSimpleName() + ".update~~");

        //方式一
//        String sql = "UPDATE mine.mine_person SET person_sex=false WHERE person_id = 10;";
//        int r = jdbcTemplate.update(sql);
//        System.out.println(r);


        //方式二
        String sql = "UPDATE mine.mine_person SET person_sex=true WHERE person_id = ?;";
        Object[] args = new Object[]{3};
        int r = jdbcTemplate.update(sql, args);
        System.out.println(r);

    }


    public void execute() {
        //方式一
//        Random random = new Random();
//        String sql = "INSERT INTO mine.mine_person(person_name, person_age, person_sex) VALUES('bob" + random.nextInt(100) + "', " + random.nextInt(120) + ", true);";
//        jdbcTemplate.execute(sql);


        //方式二
        StatementCallback statementCallback = new StatementCallback() {
            @Override
            public Object doInStatement(Statement stmt) throws SQLException, DataAccessException {
                System.out.println("~~" + getClass().getSimpleName() + ".doInStatement~~");
                System.out.println("stmt is " + stmt);
                Random random = new Random();

                for (int i = 0; i < 100; i++) {
                    String sql = "INSERT INTO mine.mine_person(person_name, person_age, person_sex) VALUES('bob" + random.nextInt(100) + "', " + random.nextInt(120) + ", true);";
                    stmt.addBatch(sql);
                }

                int[] r = stmt.executeBatch();

                for (int i = 0; i < r.length; i++) {
                    System.out.print(r[i] + ", ");
                }
                return null;
            }
        };
        jdbcTemplate.execute(statementCallback);


        //方式三
        String sql = "INSERT INTO mine.mine_person(person_name, person_age, person_sex) VALUES(?, ?, ?);";
        PreparedStatementCallback action = new PreparedStatementCallback<Person>() {
            @Override
            public Person doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                System.out.println("~~" + getClass().getSimpleName() + ".doInStatement~~");

                Random random = new Random();
                for (int i = 0; i < 100; i++) {
                    ps.setString(1, "mary" + random.nextInt(100));
                    ps.setInt(2, random.nextInt(120));
                    ps.setBoolean(3, random.nextInt(2) == 1 ? true : false);
                    ps.addBatch();
                }
                int[] r = ps.executeBatch();
                for (int i = 0; i < r.length; i++) {
                    System.out.print(r[i] + ", ");
                }

                return null;
            }
        };
        jdbcTemplate.execute(sql, action);

    }

    public void batchInsert() {

        Random random = new Random();
        String[] sqls = new String[]{
                "INSERT INTO mine.mine_person(person_name, person_age, person_sex) VALUES('bob" + random.nextInt(100) + "', " + random.nextInt(120) + ", true);",
                "INSERT INTO mine.mine_person(person_name, person_age, person_sex) VALUES('bob" + random.nextInt(100) + "', " + random.nextInt(120) + ", true);",
        };

        int[] r = jdbcTemplate.batchUpdate(sqls);

        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + ", ");
        }
    }


    public void batchUpdate() {

        List<Person> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 4; i < 20; i++) {
            Person person = new Person();
            person.setPerson_age(random.nextInt(120));
            person.setPerson_sex(random.nextInt(2) == 1 ? true : false);
            person.setPerson_name("mary" + random.nextInt(100));
            person.setPerson_id(i);
            list.add(person);
        }


        String sql = "UPDATE mine.mine_person SET person_name=?, person_age=? WHERE person_id = ?;";

        BatchPreparedStatementSetter pps = new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                System.out.println("~~" + getClass().getSimpleName() + ".setValues~~");
                System.out.println("ps is " + ps);
                System.out.println("i is " + i);

                Person person = list.get(i);
                ps.setString(1, person.getPerson_name());
                ps.setInt(2, person.getPerson_age());
                ps.setInt(3, person.getPerson_id());
            }

            @Override
            public int getBatchSize() {
                System.out.println("~~" + getClass().getSimpleName() + ".getBatchSize~~");
                return list.size();
            }
        };

        int[] r = jdbcTemplate.batchUpdate(sql, pps);

        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + ", ");
        }

    }


}
