package controller;

import model.Checker;
import model.PathFinder;
import model.WordsMapCreator;
import java.io.*;
import java.util.*;
/**
 * Программа-speller
 * Используется для проверки знания иностранных слов и словосочетаний.
 * Creating by Тимей since 24.03.18.
 * Мастурбировать на данный программный код и прилагающиеся к нему классы без разрешения автора строго запрещено!
 */
public class Speller {

    public static void main(String[] args) throws Exception {

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.flush();

        int[] result = new int[2];

        Map<ArrayList<String>,ArrayList<String>> map = WordsMapCreator.mapCr();

           result = Checker.check(map);
            System.out.println("Правильно: " + result[1]);
            System.out.println("Неправильно: " + result[0] + "\n");

            if (result[0] == 0) {
                System.out.println("Ты нечеловечески крут!");
            }
            if (result[1] == 0) {
                System.out.println("Ты кусок говна!");
            }

        System.in.read();
                }

    }
