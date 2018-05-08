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

        System.setProperty("console.encoding","cp866");

        int[] result = new int[2];

        Map<ArrayList<String>,ArrayList<String>> map = WordsMapCreator.mapCr();

           result = Checker.check(map);
            System.out.println("Dobrze: " + result[1]);
            System.out.println("Gówno: " + result[0]);

            if (result[0] == 0) {
                System.out.println("Jesteś boski!");
            }
            if (result[1] == 0) {
                System.out.println("Jesteś gównem!");
            }
                }

    }
