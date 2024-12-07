
public class TestOrder_Item_const {
    public static void main(String[] args) {
        
        // Menu items
        Items_const item1 = new Items_const("Express", 1.8);
        Items_const item2 = new Items_const("Cappucin", 2.2);
        Items_const item3 = new Items_const("Directe", 3.0);
        Items_const item4 = new Items_const("Thé vert", 1.5);

        //Create 2 orders for unspecified guests. Do not specify a name.
        Order_const order1 = new Order_const();
        Order_const order2 = new Order_const();

        //Create 3 orders using the overloaded constructor to give each a name for the order.
        Order_const order3 = new Order_const("Cindhuri");
        Order_const order4 = new Order_const("Raphael");
        Order_const order5 = new Order_const("Sophie");

        //Add at least 2 items to each of the orders using the addItem method.
        order1.addItem(item1);
        order1.addItem(item3);
        order1.setReady(true);

        order2.addItem(item2);
        order2.addItem(item4);

        order3.addItem(item4);
        order3.addItem(item4);
        order3.setReady(true);

        order4.addItem(item3);
        order4.addItem(item2);

        order5.addItem(item2);
        order5.addItem(item2);
        order5.addItem(item1);
        order5.setReady(true);

        //Test your getStatusMessage method by setting some orders to ready and printing the messages for each order.
        //Test the total by printing the return value like so: 'System.out.println(order1.getOrderTotal())'.
        System.out.println("Order1: " + order1.getStatusMessage() + " Total: " + order1.getOrderTotal());
        System.out.println("Order2: " + order2.getStatusMessage() + " Total: " + order2.getOrderTotal());
        System.out.println("Order3: " + order3.getStatusMessage() + " Total: " + order3.getOrderTotal());
        System.out.println("Order4: " + order4.getStatusMessage() + " Total: " + order4.getOrderTotal());
        System.out.println("Order5: " + order5.getStatusMessage() + " Total: " + order5.getOrderTotal());

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        order1.display();
        System.out.println("Order1: " + order1.getStatusMessage());
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        order2.display();
        System.out.println("Order2: " + order2.getStatusMessage());
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        order3.display();
        System.out.println("Order3: " + order3.getStatusMessage());
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        order4.display();
        System.out.println("Order4: " + order4.getStatusMessage());
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        order5.display();
        System.out.println("Order5: " + order5.getStatusMessage());
        
    

        
    }
    
}
