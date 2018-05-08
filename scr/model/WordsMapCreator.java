package model;

import view.Helper;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Тимон on 27.03.18.
 *
 */
public class WordsMapCreator {

    public static Map<ArrayList<String>,ArrayList<String>> mapCr() throws Exception {

        String line = "";
        Scanner in = new Scanner(System.in);
        String spellChoice;
        Boolean FirstDel = true;
        //String classDirectory = PathFinder.getClassDirectory();
        String classDirectory = "E:\\Data\\ProgramsJava\\Executable";
        BufferedReader reader = new BufferedReader(new FileReader(classDirectory + "\\Speller\\Spell.txt"));

                Map<ArrayList<String>, ArrayList<String>> map = new HashMap<ArrayList<String>, ArrayList<String>>();
                LineNumberReader lineNumber = new LineNumberReader(reader);

        System.out.println("Выберите вид спеллинга:");

        while (true) {
            System.out.println("Foreign to Russian - 0, Russian to Foreign - 1");
            spellChoice = in.nextLine();
            if (spellChoice.equals("0")) {
                break;
            } else {
                if (spellChoice.equals("1")) {
                    break;
                } else System.out.println("Читай,что написано, дятел!");
            }
        }
                while ((line = lineNumber.readLine()) != null) {
                    ArrayList<String> KeyArray = new ArrayList<String>();
                    ArrayList<String> ValueArray = new ArrayList<String>();
                    String parts[] = line.split("-");
                    String words[] = parts[1].split(", ");
                    if (FirstDel) {parts[0] = Helper.removeCharAt(parts[0], 0);
                        FirstDel = false;}
                    if (spellChoice.equals("1")) {
                        for (int i = 0; i < words.length; i++) {
                            KeyArray.add(i, words[i]);
                        }
                        ValueArray.add(0, parts[0]);
                    }
                    else {
                        for (int i = 0; i < words.length; i++) {
                            ValueArray.add(i, words[i]);
                        }
                        KeyArray.add(0, parts[0]);
                    }
                    map.put(KeyArray, ValueArray);
                }
        return map;
    }

}