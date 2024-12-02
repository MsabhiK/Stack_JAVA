import java.util.HashMap;
import java.util.Set;

public class TrackList_assign {
    
    public static void main(String[] args) {

        HashMap<String, String> userTrack = new HashMap<String, String>();

        userTrack.put("Modern Talking - Cheri Cheri Lady", "Oh, I cannot explain. Every time, it's the same. Oh, I feel that it's real, take my heart. I've been lonely too long");
        userTrack.put("Unstoppable", "All smiles. I know what it takes to fool this town");
        userTrack.put("Dance Monkey", "Ooh I see you, see you, see you every time");
        userTrack.put("Calm Down", "I see thios fine girl for my party, she wear vellow");

        String parolString = userTrack.get("Modern Talking - Cheri Cheri Lady");
        System.out.println("Your best Track: " + parolString);
        System.out.println("-------------------------------------------------------------------------------------------");

        //  OR // get the keys by using the keySet method
        Set<String> keys = userTrack.keySet();
        for(String key : keys) {
            System.out.println("Title: " + key);
            System.out.println("Parol: " + userTrack.get(key));
            System.out.println("-------------------------------------------------------------------------------------------");
        }
    }
}
