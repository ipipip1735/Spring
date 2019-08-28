package dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2019/8/28 13:52.
 */
public class PersonMapper implements RowMapper<Person> {

    public PersonMapper() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println("~~" + getClass().getSimpleName() + ".mapRow~~");
        System.out.println("rs is " + rs);
        System.out.println("rowNum is " + rowNum);

        System.out.println("person_name is " + rs.getString("person_name"));
        System.out.println("person_age is " + rs.getInt("person_age"));
        System.out.println("person_sex is " + rs.getBoolean("person_sex"));

        Person person = new Person();
        person.setPerson_name(rs.getString("person_name"));
        person.setPerson_age(rs.getInt("person_age"));
        person.setPerson_sex(rs.getBoolean("person_sex"));

        return person;
    }
}
