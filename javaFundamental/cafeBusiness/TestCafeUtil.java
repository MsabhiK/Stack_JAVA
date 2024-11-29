import java.util.ArrayList;

public class TestCafeUtil {
    public static void main(String[] args){
        CafeUtil cafe = new CafeUtil();

        /*  1/GETSTREAKGOAL */
        System.out.println(cafe.getStreakGoal(12));

        /* 2/ORDER TOTAL TEST */
        System.out.println("----- Order Total Test-----");
        double[] prices = {1.5, 5.5, 4.0, 3.5};
        System.out.printf("Order total: %s \n\n", cafe.getOrderTotal(prices));

        /* DISPLAY MENU TEST */
        System.out.println("----- Display Menu Test-----");
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Drip coffee/Café filtre");
        menu.add("Cappuccino/ Café au crème chantille");
        menu.add("Latte/Direct");
        menu.add("Mocha/Cappucin");
        cafe.displayMenu(menu);

        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
        cafe.addCustomer(customers);
        System.out.println("\n");
        }
        
        // Bonus Ninja 1
        System.out.println("----- Price Chart Test-----");
        cafe.printPriceChart("Columbian Coffee Grounds",15.0, 3);
        cafe.printPriceChart("LAVAZZA Coffe", 6.0, 5);

        // Bonus Ninja 3 Reduce
        System.out.println("----- Price Chart Test After Reduce-----");
        cafe.printPriceChartReduce("Columbian Coffee Grounds",15.0, 3);
        cafe.printPriceChartReduce("LAVAZZA Coffe", 6.0, 5);

        //Bonus Ninja 4 Display menu + prices
        System.out.println("----- Display Menu Test with prices-----");
        ArrayList<String> menus = new ArrayList<String>();
        double[] pricess = {1.5, 5.5, 4.0, 3.5};
        menus.add("Drip coffee/Café filtre");
        menus.add("Cappuccino/ Café au crème chantille");
        menus.add("Latte/Direct");
        menus.add("Mocha/Cappucin");
        cafe.displayMenuPrices(menus, pricess);

    }
    
}
