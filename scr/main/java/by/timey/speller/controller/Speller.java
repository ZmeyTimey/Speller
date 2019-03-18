package by.timey.speller.controller;

import by.timey.speller.dao.impl.DictionaryDAO;
import by.timey.speller.dao.util.ConnectionUtil;
import by.timey.speller.model.User;
import by.timey.speller.model.WordTranslation;
import by.timey.speller.service.DictionaryService;
import by.timey.speller.service.UserDictionaryService;
import by.timey.speller.service.UserService;

/**
 * Speller
 * Creating by Тимей since 24.03.18.
 */
public class Speller {

  private static final UserService USER_SERVICE
      = new UserService();
  private static final DictionaryService DICTIONARY_SERVICE
      = new DictionaryService();
  private static final UserDictionaryService USER_DICTIONARY_SERVICE
      = new UserDictionaryService();

    public static void main(String[] args) {



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
