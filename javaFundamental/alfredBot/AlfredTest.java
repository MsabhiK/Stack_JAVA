//package alfredBot;

public class AlfredTest {
    public static void main(String[] args){
        AlfredQuotes quotes = new AlfredQuotes();


        String test = quotes.basicGreeting();
        

        String guest = quotes.guestGreeting("Hela");
        

        String dateAnounce = quotes.dateAnnouncement();
        

        String alexisTest = quotes.respondBeforeAlexis("Alexis! Play some low-fi beats.");
        String alfredTest = quotes.respondBeforeAlexis("I can't find my yo-yo. Maybe Alfred will know where it is.");
        String notRelevantTest = quotes.respondBeforeAlexis("Maybe that's what Batman is about. Not winning. But failing..");

        String guestspec = quotes.greetingSpecial("EVENING", "Mounir");


        //TEST:
        System.out.println(test);
        System.out.println(guest);
        System.out.println(dateAnounce);
        System.out.println("*************************************");
        System.out.println(alexisTest);
        System.out.println(alfredTest);
        System.out.println(notRelevantTest);
        System.out.println("*************************************");
        System.out.println(guestspec);
    }
}
