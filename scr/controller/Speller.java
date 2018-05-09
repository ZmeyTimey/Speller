package controller;

import static view.Viewer.*;

import model.Checker;
import model.WordsMapCreator;
import java.util.*;

/**
 * Программа-speller
 * Используется для проверки знания иностранных слов и словосочетаний.
 * Creating by Тимей since 24.03.18.
 * Мастурбировать на данный программный код и прилагающиеся к нему классы без разрешения автора строго запрещено!
 */
public class Speller {

    public static void main(String[] args) throws Exception {

        int[] result;
        String spellChoice;
        Scanner scan = new Scanner(System.in);

        cleanScreen();

        printHeader();
        scan.nextLine();

        cleanScreen();

        print("ВЫБЕРИТЕ ВИД СПЕЛЛИНГА:");

        while (true) {

            print("Foreign to Russian - 0, Russian to Foreign - 1");
            spellChoice = scan.nextLine();
            if (spellChoice.equals("0")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.flush();
                print("TRANSLATE FROM ENGLISH INTO RUSSIAN \n");
                break;

            } else {
                if (spellChoice.equals("1")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.flush();
                    print("TRANSLATE FROM RUSSIAN INTO ENGLISH \n");
                    break;

                } else print("ЧИТАЙ ЧТО НАПИСАНО, ДЯТЕЛ! \n");
            }
        }

        Map<ArrayList<String>,ArrayList<String>> map = WordsMapCreator.createMap(spellChoice.equals("1"));

           result = Checker.check(map);
            print("Правильно: " + result[1]);
            print("Неправильно: " + result[0] + "\n");

            if (result[0] == 0) {
                print("ТЫ НЕЧЕЛОВЕЧЕСКИ КРУТ!");
            }
            if (result[1] == 0) {
                print("ТЫ КУСОК ГОВНА!");
            }

        scan.nextLine();
                }

    }
