
import java.util.ArrayList;

public class Order_const {
    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Items_const> items; // defaults to null

    // CONSTRUCTORS
    public Order_const() {
        this.name = "Guest";
        this.items = new ArrayList<>();
    }

    public Order_const(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    //getters
    public String getName() {
        return name;
    }

    public ArrayList<Items_const> getItems() {
        return items;
    }

    public boolean getReady() {
        return ready;
    }
    
    // setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setItems(ArrayList<Items_const> items) {
        this.items = items;
    }
    public void setReady(boolean ready) {
        this.ready = ready;
    }

    // method addItem:
    public void addItem(Items_const item) {
        items.add(item);
    }
    
    public String getStatusMessage() {
        if(this.ready){
            return "Your order is ready.";
        }
        else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    // method getOrderTotal
    public double getOrderTotal() {
        double total =0;
        for(Items_const item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // display
    public void display() {
        System.out.println("Customer Name: " + this.name);
        for(Items_const item : items) {
            System.out.println("Café Name: " + item.getName() + " Price: " + item.getPrice());
        }
        System.out.println("Total Price (DT): " + getOrderTotal());
    }

}
