public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double drip_coffee = 2.5;
        double latte = 4.0;
        double cappuccino = 3.0;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
        
    
        // Example:
/*Cindhuri ordered a coffee. Based on her order status, print the correct status message to the console. */
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        System.out.println(customer1 + pendingMessage);

/*Noah ordered a cappucino. Use an if statement to check the status of his order and print the correct status message. 
If it is ready, also print the message to display the total. 
Note: Outcomes may be different depending on what you assigned as the status. */
        System.out.println("\n");
        System.out.println(generalGreeting + customer4);
        if(isReadyOrder4) {
            System.out.println(customer4 + " " + readyMessage);
            System.out.println(displayTotalMessage + " " + cappuccino);
        }
        else {
            System.out.println(customer4 + pendingMessage);
        }

/*Sam just ordered 2 lattes, print the message to display their total. Next, 
use an if statement to print the appropriate order status message. 
Change the isReady flag value from true to false or vice versa in order to test your control logic (if-statement). */
        System.out.println("\n");
        System.out.println(customer2 + ":" + displayTotalMessage + " " + latte * 2);
        if(isReadyOrder2) {
            System.out.println(customer2 + " " + readyMessage);
        }
        else {
            System.out.println(customer2 + pendingMessage);
        }
/*Jimmy just realized he was charged for a coffee but had ordered a latte. 
Print the total message with the new calculated total (what he owes) to make up the difference.*/
        System.out.println("\n");
        System.out.println("Rest to pay for " + customer3 + ":" + displayTotalMessage + " " + (latte - drip_coffee));

/*Try changing the price values for each drink and isReady flags (booleans), 
to test if all of your logic works, even when prices and statuses are changed. */
    }
}
