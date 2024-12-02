import java.util.ArrayList;

public class TestPuzzleJava {
    public static void main(String[] args) {
        
        PuzzleJava generator = new PuzzleJava();

        ArrayList<Integer> RandomRolls = generator.getTenRolls();
        System.out.println(RandomRolls);

        System.out.println(generator.getRandomLettersWithArray());

        System.out.println(generator.getRandomLetterWithoutArray());

        System.out.println(generator.generatePassword());

        ArrayList<String> newPasswordArrayList = generator.getNewPasswordSet(12);
        System.out.println(newPasswordArrayList);

        ArrayList<Object> shuffledArray = generator.bonusShuffleArray(4);
        System.out.println(shuffledArray);
    }
}
