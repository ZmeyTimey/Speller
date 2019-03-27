package by.timey.speller.view;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Timey on 31.03.18.
 * Changed by Timey on 27.03.19.
 */
public class MainConsoleViewer {

    public static void print(Object msg) {
        System.out.println(msg);
    }

    public static void printWithColon(String word) {
        print(word + ": ");
    }

    public static void printHeader() {
        print("***Program SPELLER v.0.6***");
        print("******Created by Timey******");
        print("*********2019 Minsk*********");
    }

    public static void printGoodbye() {
        print("GOODBYE!");
    }

    public static void printMsgCorrect() {
        print("\n---------------------------------------------------------------------------------");
        print("***Correct!***");
        print("---------------------------------------------------------------------------------\n");
    }

    public static void printMsgIncorrect(Set<String> correctTranslation) {
        System.out.println("\n---------------------------------------------------------------------------------");
        System.out.print("*Incorrect! Correct answer: ");
        printCollectionOut(correctTranslation);
        System.out.println("*");
        System.out.println("---------------------------------------------------------------------------------\n");
    }

    public static void printSpellingCompleteMsg() {
        print("SPELLING COMPLETE\n");
    }

    public static void printSpellingResults(int correctAnswers,
                                            int incorrectAnswers,
                                            int totalAnswers) {
        print("Correct answers: " + correctAnswers + "/" + totalAnswers + "\n");

        if (correctAnswers == 0) {
            print("You are stupid asshole!");
        }
        if (incorrectAnswers == 0) {
            print("You are GODLIKE!");
        }
    }

    public static void cleanScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.flush();
    }

    public static void printCollectionOut(Collection collection) {

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (iterator.hasNext()) {
                System.out.print(element + ", ");
            } else {
                System.out.print(element);
            }
        }
    }
}
