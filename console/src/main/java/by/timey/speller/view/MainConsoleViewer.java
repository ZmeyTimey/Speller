package by.timey.speller.view;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import static by.timey.speller.view.ViewConstantStore.*;

/**
 * Created by Timey on 31.03.18.
 * Changed by Timey on 27.03.19.
 */
public final class MainConsoleViewer {

    private MainConsoleViewer() {}

    public static void print(Object msg) {
        System.out.println(msg);
    }

    public static void printWithColon(String word) {
        print(word + ": ");
    }

    public static void printHeader() {
        print(HEADER_VERSION);
        print(HEADER_AUTHOR);
        print(HEADER_YEAR_PLACE);
    }

    public static void printGoodbye() {
        print(MESSAGE_GOODBYE);
    }

    public static void printMsgCorrect() {
        print("\n" + LINE);
        print(MESSAGE_CORRECT);
        print(LINE + "\n");
    }

    public static void printMsgIncorrect(Set<String> correctTranslation) {
        print("\n" + LINE);
        System.out.print(MESSAGE_INCORRECT);
        printCollectionOut(correctTranslation);
        print("*");
        print(LINE + "\n");
    }

    public static void printSpellingCompleteMsg() {
        print(MESSAGE_COMPLETE + "\n");
    }

    public static void printSpellingResults(int correctAnswers,
                                            int incorrectAnswers,
                                            int totalAnswers) {
        print(RESULT_CORRECT_ANSWERS + " " + correctAnswers + "/" + totalAnswers + "\n");

        if (correctAnswers == 0) {
            print(RESULT_FAIL);
        }
        if (incorrectAnswers == 0) {
            print(RESULT_SUCCESS);
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
