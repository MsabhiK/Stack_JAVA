import java.util.ArrayList;

public class Exception {
    public static void main(String[] args){
        int[] numbers = {5, 10, 50, 0, 2};
        // Use a for loop to divide 100 by each number and print the quotient
        // Use a try/catch block to prevent a crash due to a zero division error (ArithmeticException)
        // Handle the exception by printing 'Cannot divide by zero.'

        for(int i=0; i<numbers.length; i++) {
            try{
                System.out.println("Division " + i + ": " + 100 / numbers[i]);
            } catch(ArithmeticException e) {
                System.out.println("Division " + i + ": " + "Cannot divide by zero.");
            }
        }
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        for(int i = 0; i < myList.size(); i++) {
            try{
                Integer castedValue = (Integer) myList.get(i);
                System.out.println("Casted value " + i + ": " + castedValue);
            } catch(ClassCastException e) {
                System.out.println("Casting failed for value " + i + ": " + myList.get(i));
            }
        }
        
        


    }
}
