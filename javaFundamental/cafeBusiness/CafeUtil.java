import java.util.ArrayList;

public class CafeUtil {

    //1/ GETSTREAKGOAL************************************************************
    public String getStreakGoal(int numWeeks) {
        String result=" ";
        int sum = 0;
        for (int i=1; i<=numWeeks; i++) {
            sum += i;
        }
        result = String.format("Purchases needed by week %d: %d", numWeeks, sum);
        return result;
    }

    // 2/ GETORDERTOTAL********************************
    public double getOrderTotal(double[] prices) {
        double sum = 0;
        
        for (double price: prices) {
            sum+= price;
        }
        return sum;

    }

    // 3/ DISPLAYMENU************************************************
    public void displayMenu(ArrayList<String> menuItems) {

        for (int id = 0; id < menuItems.size(); id++) {
            System.out.printf("%s %s \n", id, menuItems.get(id));
        }
    }

    // 4/ AddCustomer**********************************
    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s! ", userName);
        System.out.printf("There are %s people ahead of you.\n", customers.size());
        customers.add(userName);
        System.out.println(customers);
    }

    // 5/ BONUS 1 PRINTPRICECHART *************************************
    public void printPriceChart(String product, double price, int maxQuantity){
        System.out.printf("%s\n", product);
        for(int quantity = 1; quantity <= maxQuantity; quantity++) {
            System.out.printf("%s - $%.2f\n", quantity, quantity * price);
        }
        
        System.out.println("");
    }

    // 5/ BONUS 2 PRINTPRICECHARTREDUCE *************************************
    public void printPriceChartReduce(String product, double price, int maxQuantity){
        System.out.printf("%s\n", product);
        for(int quantity = 1; quantity <= maxQuantity; quantity++) {
            double priceReduce = (quantity*price)-((quantity-1)*0.5);
            System.out.printf("%s - $%.2f\n", quantity, priceReduce);
        }
        
        System.out.println("");
    }

    // 6/ BONUS 4 DISPLAYMENUPRICES*********************************
    public void displayMenuPrices(ArrayList<String> menuItems, double[] prices) {

        for (int id = 0; id < menuItems.size(); id++) {
            System.out.printf("%s %s ------- $%.2f \n", id, menuItems.get(id), prices[id]);
        }

    }
}
