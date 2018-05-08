package model;

import view.Helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Тимон on 29.03.18.
 *
 */
public class Checker {

    public static int[] check(Map<ArrayList<String>,ArrayList<String>> map) throws IOException {
        int[] check = new int[2];
        String vyserword;
        Scanner in = new Scanner(System.in);
        ArrayList<String> Keys;
        ArrayList<String> Words;
        for (Map.Entry entry : map.entrySet()) {

            Boolean Check = false;

            Keys = (ArrayList<String>)entry.getKey();
            Words = (ArrayList<String>)entry.getValue();

            Helper.ArrayOut(Keys);

            vyserword = in.nextLine();

            for (int i = 0; i < Words.size(); i++) {
                if (vyserword.equals(Words.get(i))) {
                    Check = true;
                }
            }

            if (Check) {
                check[1]++;
                System.out.println("poprawnie!");
            } else {
                check[0]++;
                System.out.print("Nie Prawda! Tak powinno być: ");
                Helper.ArrayOut(Words);
            }
        }
        return check;
    }
}
