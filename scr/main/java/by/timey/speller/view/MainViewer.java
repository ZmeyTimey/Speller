package by.timey.speller.view;

import java.io.IOException;

/**
 * Created by ����� on 31.03.18.
 *
 */
public class MainViewer {

    public static void print(Object msg) {
        System.out.println(msg);
    }

    public static void printArrayOut(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }

    public static void printWithColon(String word) {
        System.out.print(word + ": ");
    }

    public static void printMsgCorrect() {
        print("\n---------------------------------------------------------------------------------");
        print("***Верно!***");
        print("---------------------------------------------------------------------------------\n");
    }

    public static void printMsgIncorrect(String[] arr) {
        System.out.println("\n---------------------------------------------------------------------------------");
        System.out.print("*Неверно! Вот как надо: ");
        printArrayOut(arr);
        System.out.println("*");
        System.out.println("---------------------------------------------------------------------------------\n");
    }

    public static void printHeader() {
        print("***Program SPELLER v.0.5***");
        print("******Created by Timey******");
        print("*********2018 Minsk*********");
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
}
