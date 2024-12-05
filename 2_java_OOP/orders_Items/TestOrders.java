import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
        
        // Menu items
        Item item1 = new Item();
        item1.name = "Express";
        item1.price = 1.8;

        Item item2 = new Item();
        item2.name = "Cappucin";
        item2.price = 2.2;

        Item item3 = new Item();
        item3.name = "Directe";
        item3.price = 3.0;

        Item item4 = new Item();
        item4.name = "Thé vert";
        item4.price = 1.5;
    
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        order1.name = "Cindhuri";
        System.out.printf("order1 %s de somme: %.2f\n ", order1.name, order1.total);

        Order order2 = new Order();
        order2.name = "Jimmy";

        Order order3 = new Order();
        order3.name = "Noah";

        Order order4 = new Order();
        order4.name = "Sam";
    
        // Application Simulations
        order2.items.add(item1);
        order2.ready = true;
        order2.total += item1.price;

        order3.items.add(item2);
        order3.total += item2.price;

        order4.items.add(item3);
        order4.total += item3.price * 2;

        order1.items.add(item4);
        order1.ready = true;
        order1.total += item4.price;


        // Use this example code to test various orders' updates
        System.out.printf("Order2 Name: %s\n", order2.name);
        System.out.printf("Total order2: %s dt\n", order2.total);
        System.out.printf("Ready order2: %s\n", order2.ready);
        System.out.println("-------------------------------------------------------------------");

        System.out.printf("Order3 Name: %s\n", order3.name);
        System.out.printf("Total order3: %s dt\n", order3.total);
        System.out.printf("Ready order3: %s\n", order3.ready);
        System.out.println("-------------------------------------------------------------------");

        System.out.printf("Order4 Name: %s\n", order4.name);
        System.out.printf("Total order4: %s dt\n", order4.total);
        System.out.printf("Ready order4: %s\n", order4.ready);
        System.out.println("-------------------------------------------------------------------");

        System.out.printf("Order1 Name: %s\n", order1.name);
        System.out.printf("Total order1: %s dt\n", order1.total);
        System.out.printf("Ready order1: %s\n", order1.ready);
        System.out.println("-------------------------------------------------------------------");

    }
}

