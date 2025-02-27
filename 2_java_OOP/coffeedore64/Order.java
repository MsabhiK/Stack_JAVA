import java.util.ArrayList;
// Here we're creating a new data type called order

public class Order {

    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value of false
    private ArrayList<ItemCoffee> items; // defaults to null

    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order(){
        this.name = "Guest";
        this.items = new ArrayList<ItemCoffee>();
    }

    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name){
        this.name = name;
        this.items = new ArrayList<ItemCoffee>();
    }
    
    // ORDER METHODS
    
    	// Most of your code will go here, 
    	// so implement the getters and setters first!

    public void addItem(ItemCoffee item){
        items.add(item);
    }                                                              
    public String getStatusMessage(){
        if(this.ready){
            return "Your order is ready.";
        }
        return "Thank you for waiting, your order will be ready soon.";
    }

    public double getOrderTotal(){
        double total = 0;
        for(ItemCoffee item : items){
            total += item.getPrice();
        }
        return total;
    }

    public void display(){
        System.out.printf("Customer Name: %s\n", this.name);
        for(ItemCoffee item : items){
            System.out.printf("%s - $%.2f\n", item.getName(), item.getPrice());
        }
        System.out.printf("Total: $%.2f\n", getOrderTotal());
    }
    
    // GETTERS & SETTERS
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean getReady(){
        return this.ready;
    }

    public void setReady(boolean ready){
        this.ready = ready;
    }

    public ArrayList<ItemCoffee> getItems(){
        return this.items;
    }

    public void setItems(ArrayList<ItemCoffee> items){
        this.items = items;
    }
}
