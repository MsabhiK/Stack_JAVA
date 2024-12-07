
public class Items_const {
    private String name;
    private double price;

    //constructors---------
    public Items_const() {

    }

    public Items_const(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //getters-------------
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    //setters-------------
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
