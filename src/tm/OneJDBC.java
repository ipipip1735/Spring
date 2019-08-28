package tm;

import dao.Person;
import dao.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.sql.DataSource;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2019/8/28 10:46.
 */
public class OneJDBC {


    private JdbcTemplate jdbcTemplate;


    public OneJDBC() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }


    @Autowired
    public void setDataSource(DataSource dataSource) {
        System.out.println("~~" + getClass().getSimpleName() + ".setDataSource~~");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void query() {
        System.out.println("~~" + getClass().getSimpleName() + ".query~~");
//        System.out.println(TransactionAspectSupport.currentTransactionStatus().hasSavepoint());

//        int rowCount = jdbcTemplate.queryForObject("select count(*) from t_actor", Integer.class);

        //例一：获取记录条数
//        int rowCount = this.jdbcTemplate.queryForObject("select count(*) from mine.mine_person", Integer.class);
//        System.out.println(rowCount);

        //例二：获取记录条数，并给占位符传递参数
//        String sql = "SELECT count(*) FROM mine.mine_person WHERE person_id=?;";
//        int r = jdbcTemplate.queryForObject(sql, Integer.class, 3);
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
//        System.out.println(TransactionAspectSupport.currentTransactionStatus().hasSavepoint());

        //例一
//        String sql = "DELETE FROM mine.mine_person WHERE person_id = 5;";
//        int r = jdbcTemplate.update(sql);
//        System.out.println(r);

        //例二
        String sql = "DELETE FROM mine.mine_person WHERE person_id = ?;";
        Object[] args = new Object[]{2};
        int r = jdbcTemplate.update(sql, 1);
        System.out.println(r);

    }


    public void insert() {
        System.out.println("~~" + getClass().getSimpleName() + ".insert~~");
        String sql = "INSERT INTO mine.mine_person(person_name, person_age, person_sex) VALUES(?,?,?);";
        Random random = new Random();
        Object[] args = new Object[]{"bob" + random.nextInt(120), random.nextInt(120), true};
//        Object[] args = new Object[]{"bob"+random.nextInt(120), random.nextInt(120), random.nextInt(2)};

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

    public void batch() {

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
}
