import java.util.ArrayList;

public class CoffeeKiosk {

	//Members
	private ArrayList<ItemCoffee> menu;
	private ArrayList<Order> orders;
	
	//Constructor
	public CoffeeKiosk() {
		this.menu = new ArrayList<ItemCoffee>();
		this.orders = new ArrayList<Order>();
	}
	
	public void addMenuItem(String name, double price) {
		ItemCoffee newItem = new ItemCoffee(name, price);
		menu.add(newItem);
		newItem.setIndex(menu.indexOf(newItem));
	}
	
	public void displayMenu() {
		for(ItemCoffee item : menu) {
			//System.out.println(item.getIndex()+" "+ item.getName()+"  ---$"+item.getPrice());
			System.out.printf("%d %s ---$%.2f\n", item.getIndex(), item.getName(), item.getPrice());
		}
	}
    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        Order order = new Order(name);
        // Show the user the menu, so they can choose items to add.
        displayMenu();
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            
            // Get the item object from the menu, and add the item to the order
			try{
				order.addItem(menu.get(Integer.parseInt(itemNumber)));
			}catch(IndexOutOfBoundsException i){
				System.out.println("Invalid input. Please enter a valid menu item index.");
			}catch(NumberFormatException n){
				System.out.println("Invalid input. Please enter a valid menu item index.");
			}
            // Ask them to enter a new item index or q again, and take their input
			System.out.println("Please enter a menu item index or q to quit:");
			itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details 
        order.display();
    }

}
