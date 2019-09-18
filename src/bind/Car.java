package bind;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2019/9/9 17:53.
 */
public class Car {
    private int price;
    private String owner;

//    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @DateTimeFormat(pattern = "yyyMMdd")
    public Date date;

    public void setDate(Date date) {
        this.date = date;
    }


    public void setPrice(int price) {
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

    public Date getDate() {
        return date;
    }

    public Car() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
        price = -1;
        owner = "xx";
    }
}
