package controller;

import static view.Viewer.*;

import model.Checker;
import model.PathFinder;
import model.WordsMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * Программа-speller
 * Используется для проверки знания иностранных слов и словосочетаний.
 * Creating by Тимей since 24.03.18.
 * Мастурбировать на данный программный код и прилагающиеся к нему классы без разрешения автора строго запрещено!
 */
public class Speller {

    public static void main(String[] args) throws Exception {

        String spellChoice;
        String classDirectory = PathFinder.getClassDirectory();
        String line;
        String inputWord;
        int correctAnswers = 0;
        int incorrectAnswers = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(classDirectory + "\\Spell.txt"));


        cleanScreen();

        printHeader();
        reader.readLine();

        cleanScreen();

        print("ВЫБЕРИТЕ ВИД СПЕЛЛИНГА:");

        while (true) {

            print("Foreign to Russian - 0, Russian to Foreign - 1");
            spellChoice = reader.readLine();
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

        WordsMap map = new WordsMap(spellChoice.equals("1"));

           LineNumberReader lineNumber = new LineNumberReader(fileReader);

        while ((line = lineNumber.readLine()) != null) {
            map.createMap(line);
            printWithColon(map.getKey());
            inputWord = reader.readLine();

            if (Checker.check(inputWord, map.getValue())) {
                correctAnswers++;
                printMsgCorrect();
            } else {
                incorrectAnswers++;
                printMsgIncorrect(map.getValue());
            }
        }

            print("Правильно: " + correctAnswers);
            print("Неправильно: " + incorrectAnswers + "\n");

            if (correctAnswers == 0) {
                print("ТЫ НЕЧЕЛОВЕЧЕСКИ КРУТ!");
            }
            if (incorrectAnswers == 0) {
                print("ТЫ КУСОК ГОВНА!");
            }

        reader.readLine();
        reader.close();
        fileReader.close();
                }

    }
