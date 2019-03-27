package by.timey.speller.util;

import java.util.Set;


public class Checker {

    public static boolean check(String userWord, Set<String> translations) {

        for (String translation : translations) {
            if (userWord.equals(translation)) {
                return true;
            }
        }
        return false;
    }
}
