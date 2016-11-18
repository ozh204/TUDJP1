package domain;

public class Waffle
{
    private String type = "Suchy";
    private double price = 3.5;
    private String topping = "Brak";
    private String sugar = "Nie";
    private String cream = "Nie";
    private String fruit = "Brak";

    public Waffle() {}

    public Waffle(String type, double price)
    {
        this.type = type;
        this.price = price;
    }

    public String getType()
    {
        return type;
    }
    public double getPrice()
    {
        return price;
    }
    public String getSugar()
    {
        return sugar;
    }
    public String getTopping()
    {
        return topping;
    }
    public String getCream()
    {
        return cream;
    }
    public String getFruit()
    {
        return fruit;
    }
}
