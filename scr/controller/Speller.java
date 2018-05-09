package controller;

import static view.Viewer.*;

import model.Checker;
import model.WordsMapCreator;
import java.util.*;

/**
 * ���������-speller
 * ������������ ��� �������� ������ ����������� ���� � ��������������.
 * Creating by ����� since 24.03.18.
 * �������������� �� ������ ����������� ��� � ������������� � ���� ������ ��� ���������� ������ ������ ���������!
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

        print("�������� ��� ���������:");

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

                } else print("����� ��� ��������, �����! \n");
            }
        }

        Map<ArrayList<String>,ArrayList<String>> map = WordsMapCreator.createMap(spellChoice.equals("1"));

           result = Checker.check(map);
            print("���������: " + result[1]);
            print("�����������: " + result[0] + "\n");

            if (result[0] == 0) {
                print("�� ������������� ����!");
            }
            if (result[1] == 0) {
                print("�� ����� �����!");
            }

        scan.nextLine();
                }

    }
