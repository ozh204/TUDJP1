package domain;

import java.sql.Date;

public class Order
{
    private Integer id;
    private double price;
    private Date date;

    public Order()
    {
        super();
    }

    public Order(Date date, double price) {
        this.date = date;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
