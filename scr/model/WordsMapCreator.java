package model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Тимон on 27.03.18.
 *
 */
public class WordsMapCreator {

    public static Map<ArrayList<String>,ArrayList<String>> createMap(boolean kindOfSpelling) throws Exception {

        String line;
        String classDirectory = PathFinder.getClassDirectory();
        BufferedReader reader = new BufferedReader(new FileReader(classDirectory + "\\Spell.txt"));

                Map<ArrayList<String>, ArrayList<String>> map = new HashMap<ArrayList<String>, ArrayList<String>>();
                LineNumberReader lineNumber = new LineNumberReader(reader);


                while ((line = lineNumber.readLine()) != null) {
                    ArrayList<String> KeyArray = new ArrayList<String>();
                    ArrayList<String> ValueArray = new ArrayList<String>();
                    String parts[] = line.split("-");
                    String words[] = parts[1].split(", ");

                   // if (FirstDel) {parts[0] = Helper.removeCharAt(parts[0], 0);
                     //   FirstDel = false;}

                    if (kindOfSpelling) {
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