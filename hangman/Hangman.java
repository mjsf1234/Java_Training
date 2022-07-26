
import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    public static String[] words = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra" };

    public static String[] gallows = {
            "+---+\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + // if you were wondering, the only way to print '\' is with a trailing escape
                                  // character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n" };

    public static void main(String[] args) {

        double rand = Math.random() * words.length;
        int num = (int) rand;

        String selectedword = words[num];
        String[] selectedWordArray = selectedword.split("");
        // System.out.println("guessed word is " + selectedword);

        int wordLenght = selectedword.length();

        String[] correctGussWordArray = new String[wordLenght];
        String[] incorrectGuessWordArray = new String[6];

        // creating the empty word array
        for (int i = 0; i < wordLenght; i++) {
            correctGussWordArray[i] = "_";
        }

        // creating the empty word array
        for (int i = 0; i < 6; i++) {
            incorrectGuessWordArray[i] = " ";
        }

        int error = 0;
        int matched = 0;

        show(error, correctGussWordArray, incorrectGuessWordArray);

        while (error < 6) {
            System.err.print("\n\nGuess: \t");
            Scanner scan = new Scanner(System.in);
            String guessedWord = scan.nextLine();

            if (guessedWord.length() != 1) {
                System.out.println("\n \t Please enter a valid char");
            } else {

                int index = check(guessedWord, selectedWordArray);

                if (index != -1) {
                    correctGussWordArray[index] = selectedWordArray[index];
                    selectedWordArray[index] = " ";
                    matched++;
                    show(error, correctGussWordArray, incorrectGuessWordArray);
                } else {
                    incorrectGuessWordArray[error] = guessedWord;
                    error++;
                    show(error, correctGussWordArray, incorrectGuessWordArray);
                }
                if (matched == selectedword.length()) {
                    System.out.println("\n\n=====you won=====\n");
                    System.exit(0);
                }
            }
        }
        System.out.println("\n\n:) You looses :)\n");
        System.out.println("/n/n");
    }

    /* check function */
    public static int check(String letter, String[] word) {
        for (int i = 0; i < word.length; i++) {
            if (letter.equals(word[i])) {
                return i;
            }
        }
        return -1;
    }

    /* show gallows */
    public static void showGallow(int error) {
        System.out.println("\n" + gallows[error]);
    }

    public static void showWordArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /* function to print the updated status of the game */
    public static void show(int error, String[] correctGussWordArray, String[] incorrectGuessWordArray) {
        showGallow(error);
        System.out.print("\nword:\t ");
        showWordArray(correctGussWordArray);
        System.out.print("\n\nMisses:\t");
        showWordArray(incorrectGuessWordArray);
    }

}
