package view;

import java.util.ArrayList;

/**
 * Created by Тимон on 31.03.18.
 *
 */
public class Helper {

    public static void ArrayOut(ArrayList arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (i == arr.size()-1) {
                System.out.print(arr.get(i));
            } else {
            System.out.print(arr.get(i) + ", "); }
        }
    }

    public static String removeCharAt(String str, int pos) {
        return str.substring(0, pos) + str.substring(pos + 1);
    }
}
