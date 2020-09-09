package bind;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Administrator on 2019/9/9 17:53.
 */
public class Car {
    private int price;
    private String owner;

    //    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @DateTimeFormat(pattern = "yyyyMMdd")
    Date date;


    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate localDate;

    public void setDate(Date date) {
        System.out.println("~~" + getClass().getSimpleName() + ".setDate~~");
        System.out.println(date.getClass());
        this.date = date;
    }

    public Date getDate() {
        System.out.println("~~" + getClass().getSimpleName() + ".getDate~~");
        return date;
    }

    public void setPrice(int price) {
        System.out.println("~~" + getClass().getSimpleName() + ".setPrice~~");

        this.price = price;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public String getOwner() {
        return owner;
    }


    public Car() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
        price = -1;
        owner = "xx";
    }


}
