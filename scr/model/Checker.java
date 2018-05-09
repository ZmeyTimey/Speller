package model;

import view.Helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by “ËÏÓÌ on 29.03.18.
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

            Keys  = (ArrayList<String>)entry.getKey();
            Words = (ArrayList<String>)entry.getValue();

            Helper.ArrayOut(Keys);
            System.out.print(": ");

            vyserword = in.next();

            for (int i = 0; i < Words.size(); i++) {
                if (vyserword.equals(Words.get(i))) {
                    Check = true;
                }
            }

            if (Check) {
                check[1]++;
                System.out.println("\n---------------------------------------------------");
                System.out.println("***¬≈–ÕŒ!***");
                System.out.println("---------------------------------------------------\n");
            } else {
                check[0]++;
                System.out.println("\n---------------------------------------------------");
                System.out.print("*Õ≈ œ–¿¬ƒ¿! ƒŒÀ∆ÕŒ ¡€“‹ “¿ : ");
                Helper.ArrayOut(Words);
                System.out.println("*");
                System.out.println("---------------------------------------------------\n");
            }
        }
        return check;
    }
}
