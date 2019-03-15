package by.timey.speller.controller;

import static by.timey.speller.view.Viewer.*;

import by.timey.speller.dao.impl.WordTranslationDAO;
import by.timey.speller.dao.util.ConnectionUtil;
import by.timey.speller.model.WordTranslation;
import by.timey.speller.service.Checker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Speller
 * Creating by Тимей since 24.03.18.
 */
public class Speller {

    public static void main(String[] args) {

//      WordTranslation wordTranslation = new WordTranslation();
//      wordTranslation.setId(1L);
//      wordTranslation.setWord("deliver");
//
//      Set<String> translation = new HashSet<>();
//      translation.add("доставить");
//      translation.add("поставлять");
//      translation.add("доставлять");
//      wordTranslation.setTranslation(translation);
//
//      WordTranslationDAO wordTranslationDAO
//          = new WordTranslationDAO(ConnectionUtil.getFactory());
//
//      wordTranslationDAO.create(wordTranslation);
//      wordTranslationDAO.readById(1L);



//
//        String spellChoice;
//        String classDirectory = PathFinder.getClassDirectory();
//        String line;
//        String inputWord;
//        int correctAnswers = 0;
//        int incorrectAnswers = 0;
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader fileReader = new BufferedReader(new FileReader(classDirectory + "\\Spell.txt"));
//
//        cleanScreen();
//
//        printHeader();
//        reader.readLine();
//
//        cleanScreen();
//
//        print("�������� ��� ���������:");
//
//        while (true) {
//
//            print("Foreign to Russian - 0, Russian to Foreign - 1");
//            spellChoice = reader.readLine();
//            if (spellChoice.equals("0")) {
//                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//                System.out.flush();
//                print("TRANSLATE FROM ENGLISH INTO RUSSIAN \n");
//                break;
//
//            } else {
//                if (spellChoice.equals("1")) {
//                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//                    System.out.flush();
//                    print("TRANSLATE FROM RUSSIAN INTO ENGLISH \n");
//                    break;
//
//                } else print("����� ��� ��������, �����! \n");
//            }
//        }
//
//        WordsMap map = new WordsMap(spellChoice.equals("1"));
//
//           LineNumberReader lineNumber = new LineNumberReader(fileReader);
//
//        while ((line = lineNumber.readLine()) != null) {
//            map.createMap(line);
//            printWithColon(map.getKey());
//            inputWord = reader.readLine();
//
//            if (Checker.check(inputWord, map.getValue())) {
//                correctAnswers++;
//                printMsgCorrect();
//            } else {
//                incorrectAnswers++;
//                printMsgIncorrect(map.getValue());
//            }
//        }
//
//            print("���������: " + correctAnswers);
//            print("�����������: " + incorrectAnswers + "\n");
//
//            if (correctAnswers == 0) {
//                print("�� ������������� ����!");
//            }
//            if (incorrectAnswers == 0) {
//                print("�� ����� �����!");
//            }
//
//        reader.readLine();
//        reader.close();
//        fileReader.close();
    }
}
