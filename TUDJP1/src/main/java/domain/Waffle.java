package domain;

public class Waffle
{
	private Integer id;
	private Integer id_order;
    private String type = "Suchy";
    private double price = 3.5;
    private String topping = "Brak";
    private String sugar = "Nie";
    private String cream = "Nie";
    private String fruit = "Brak";

    public Waffle() {super();}

    public Waffle(String type, Integer id_order, double price, String topping, String sugar, String cream, String fruit)
    {
		super();
		this.type = type;
		this.id_order = id_order;
		this.price = price;
		this.topping = topping;
		this.sugar = sugar;
		this.cream = cream;
		this.fruit = fruit;
	}

	public Integer getId() {
		return id;
	}

	public Integer getId_order() {
		return id_order;
	}

	public void setId_order(Integer id_order) {
		this.id_order = id_order;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	public String getSugar() {
		return sugar;
	}

	public void setSugar(String sugar) {
		this.sugar = sugar;
	}

	public String getCream() {
		return cream;
	}

	public void setCream(String cream) {
		this.cream = cream;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}
}
