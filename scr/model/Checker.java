package model;


import java.io.IOException;

/**
 * Created by Тимон on 29.03.18.
 *
 */
public class Checker {

    public static boolean check(String userWord, String[] correctWords) throws IOException {
        boolean check = false;
        int i = 0;

            while (i < correctWords.length) {
                if (userWord.equals(correctWords[i])) {
                    check = true;
                }
            }
        return check;
    }
}
