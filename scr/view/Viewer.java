package view;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Òèìîí on 31.03.18.
 *
 */
public class Viewer {

    public static void print(Object msg) {
        System.out.println(msg);
    }

    public static void arrayOut(ArrayList arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (i == arr.size() - 1) {
                System.out.print(arr.get(i));
            } else {
                System.out.print(arr.get(i) + ", ");
            }
        }
    }

    public static void printColon() {
        System.out.print(": ");
    }

    public static void printMsgCorrect() {
        print("\n---------------------------------------------------------------------------------");
        print("***ÂÅĞÍÎ!***");
        print("---------------------------------------------------------------------------------\n");
    }

    public static void printMsgIncorrect(ArrayList arr) {
        System.out.println("\n---------------------------------------------------------------------------------");
        System.out.print("*ÍÅ ÏĞÀÂÄÀ! ÄÎËÆÍÎ ÁÛÒÜ ÒÀÊ: ");
        arrayOut(arr);
        System.out.println("*");
        System.out.println("---------------------------------------------------------------------------------\n");
    }

    public static void printHeader() {
        print("***Program SPELLER v.0.42***");
        print("******Created by Timey******");
        print("*********2018 Minsk*********");
    }

    public static void cleanScreen() throws Exception {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.flush();
    }
}
