package by.timey.speller.service;


import java.io.IOException;


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
