import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> intgenerator = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i=1; i <= 10; i++) {
            intgenerator.add(rand.nextInt(20) + 1);
        }
        return intgenerator;
    }

    public String getRandomLettersWithArray() {
        Random rand = new Random();
        String alphbet ="abcdefghijklmnopqrstuvwxyz";
        String[] alphbetArray = new String[26];
        for(int i=0; i<26; i++) {
            alphbetArray[i] = String.valueOf(alphbet.charAt(i));
        }
        return alphbetArray[rand.nextInt(26)];
    }

    public String getRandomLetterWithoutArray() {
        Random rand = new Random();
        String alphabet ="abcdefghijklmnopqrstuvwxyz";
        char randomChar = alphabet.charAt(rand.nextInt(26));
        return String.valueOf(randomChar);
    }

    public String generatePassword() {
        String password ="";
        for(int i = 0; i< 8; i++) {
            password = password + getRandomLettersWithArray();
        }
        return password;
        
    }

    public ArrayList<String> getNewPasswordSet(int size) {
        ArrayList<String> newpassword = new ArrayList<String>();
        for(int i =0; i< size; i++) {
            newpassword.add(generatePassword());
        }
        return newpassword;
    }

    public ArrayList<Object> bonusShuffleArray(int sizes) {
        ArrayList<Object> shuffleArray = new ArrayList<Object>();
        for(int i =0; i< sizes; i++) {
            shuffleArray.add(getTenRolls());
            shuffleArray.add(getRandomLettersWithArray());
            shuffleArray.add(generatePassword());
            shuffleArray.add(getNewPasswordSet(sizes));
        }
        return shuffleArray;
    }
}
