import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    private static String[] text;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("data.txt"); //Instance file has path name of data
        scan = new Scanner(file);

        String inputFromFile = "";

        while (scan.hasNextLine())    // checks if theres more lines in the file
        {
            inputFromFile += scan.nextLine();  // adds each line to the inputFromFile string.
        }

        text = inputFromFile.split(" ");  // Creates and array of strings, where each element is a single word from the file.
        System.out.println(text.length);

        printWordsStartingWith("Ø");

        printWordsOfLength(3);

        printLongestWord();

        printWordsWithLessThanTwoVocals();

        printFirstHalfOfEachWord();

        printMostFrequentLetter();
    }

    private static void printWordsOfLength(int l) {
        boolean wordisvalid = true;

        for (String s : text) {
            if (s.length() == l) {
                if (s.contains(",") || s.contains(".")) {
                    wordisvalid = false;
                }

                if (wordisvalid) {
                    System.out.println(s);
                }
            }
        }
    }

    private static void printWordsStartingWith(String pattern) {
        for (String s : text) // for each word in text
        {
            if (s.startsWith(pattern) || s.startsWith(pattern.toLowerCase())) {
                System.out.println(s);
            }
        }
    }

    //TODO Task 1
    //Prints the longest of the Words
    private static void printLongestWord() {
        int counter = 0;
        String longestWord = "";

        //For each loop that goes through each word and overrides longesWord with the longest word in the file
        for (String t : text) {
            if (t.length() > counter) {
                counter = t.length();
                longestWord = t;
            }
        }

        System.out.println("Longest word: " + longestWord);
    }

    //TODO Task 1
    //Prints each word that has less than 2 vowels
    private static void printWordsWithLessThanTwoVocals() {
        int vowelsCounter = 0;

        /* For each loop that goes through each word in the Data file
        and prints out every word that has less than 2 vocals */
        for (String t : text) {
            for (int i = 0; i < t.length(); i++) {
                char ch = t.charAt(i);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                        || ch == 'y' || ch == 'æ' || ch == 'ø' || ch == 'å') {
                    vowelsCounter++;
                    //System.out.println("Vowels Counter: " + vowelsCounter);
                }
            }
            if (vowelsCounter < 2) {
                System.out.println("Word with Less than 2 Vocals: " + t);
                vowelsCounter = 0;
            } else if (vowelsCounter >= 2) {
                vowelsCounter = 0;
            }
        }
    }

    //TODO Task 2
    //Prints the first half of each word
    private static void printFirstHalfOfEachWord() {
        for (String s : text) {
            String half = s.substring(0, s.length() / 2);
            System.out.println("The first half of the word " + s + " is: " + half);
        }

    }

    //TODO Task 3
    private static void printMostFrequentLetter() {
        char ch[] = new char[text.length];
        for (String s : text) {
            for (int i = 0; i < text.length; i++) {
                ch[i] = s.charAt(i);
            }
        }

        for (char c : ch) {
            System.out.println(c);
        }
    }
}
