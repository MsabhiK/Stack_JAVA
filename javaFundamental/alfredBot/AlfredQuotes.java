//package alfredBot;

import java.text.DateFormat;
import java.util.Date;

public class AlfredQuotes {
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }

    //******Implement the guestGreeting method, 
    //and test it by first compiling the test file with the javac command and then running the test file with the java command in your terminal.
    public String guestGreeting(String name) {
        String dojo = String.format("Hello %s, lovely to see you. How are you?", name);
        return dojo;
        //return "Hello " + name + ", lovely to see you. How are you?";
    }
//******implement the dateAnnouncement method and test it.
    public String dateAnnouncement() {
        Date date = new Date();
        return"Announcement date is: " + date;
    }

    //****implement the answeringBeforeAlexis method and test it.
    public String respondBeforeAlexis(String conversation) {
        if(conversation.indexOf("Alexis") > -1){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        if(conversation.indexOf("Alfred") > -1){
            return "At your service. As you wish, naturally.";
        }
        return "Right. And with that I shall retire.";
    }

    //*** Ninja BONUS
    public String greetingSpecial(String dayPeriod, String name){
        Date date = new Date();
        String myString = DateFormat.getDateInstance().format(date);
        String greet = String.format("GOOD %s, %s, lovely to see you today: %s. How are you?", dayPeriod, name, myString);
        return greet;
    }
}
