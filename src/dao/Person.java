package dao;

/**
 * Created by Administrator on 2019/8/28 13:51.
 */
public class Person {
    private Integer person_id = -1;
    private Integer person_age = -1;
    private Boolean person_sex = false;
    private String person_name = "";
    private String person_ct = "";//创建时间
    private String person_ut = "";//更新时间

    public Integer getPerson_id() {
        return person_id;
    }

    public Integer getPerson_age() {
        return person_age;
    }

    public Boolean getPerson_sex() {
        return person_sex;
    }

    public String getPerson_name() {
        return person_name;
    }

    public String getPerson_ct() {
        return person_ct;
    }

    public String getPerson_ut() {
        return person_ut;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public void setPerson_age(Integer person_age) {
        this.person_age = person_age;
    }

    public void setPerson_sex(Boolean person_sex) {
        this.person_sex = person_sex;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public void setPerson_ct(String person_ct) {
        this.person_ct = person_ct;
    }

    public void setPerson_ut(String person_ut) {
        this.person_ut = person_ut;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_id=" + person_id +
                ", person_age=" + person_age +
                ", person_sex=" + person_sex +
                ", person_name='" + person_name + '\'' +
                ", person_ct='" + person_ct + '\'' +
                ", person_ut='" + person_ut + '\'' +
                '}';
    }
}
