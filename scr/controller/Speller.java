package controller;

import model.Checker;
import model.PathFinder;
import model.WordsMapCreator;
import java.io.*;
import java.util.*;
/**
 * ���������-speller
 * ������������ ��� �������� ������ ����������� ���� � ��������������.
 * Creating by ����� since 24.03.18.
 * �������������� �� ������ ����������� ��� � ������������� � ���� ������ ��� ���������� ������ ������ ���������!
 */
public class Speller {

    public static void main(String[] args) throws Exception {

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.flush();

        int[] result = new int[2];

        Map<ArrayList<String>,ArrayList<String>> map = WordsMapCreator.mapCr();

           result = Checker.check(map);
            System.out.println("���������: " + result[1]);
            System.out.println("�����������: " + result[0] + "\n");

            if (result[0] == 0) {
                System.out.println("�� ������������� ����!");
            }
            if (result[1] == 0) {
                System.out.println("�� ����� �����!");
            }

        System.in.read();
                }

    }
