package com.catatoes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String word = read.next();

        char[][] grid = {
                {'s', 'o', 'u', 'l', 'b', 'n', 't', 'r'},
                {'p', 'w', 'o', 'l', 'p', 'o', 'e', 'l'},
                {'r', 'l', 'a', 'f', 'a', 'w', 's', 'k'},
                {'k', 'c', 'e', 'l', 'o', 'r', 'm', 'r'},
                {'k', 'r', 'n', 't', 'l', 'e', 'g', 'a'},
                {'r', 'o', 'a', 't', 'r', 'o', 's', 'h'},
                {'i', 'b', 'o', 'd', 'r', 'o', 'w', 's'},
                {'u', 't', 'e', 'r', 'c', 'o', 'm', 'p'},
        };
        int[][] location = new int[100][2];
        int n = 0; //number of letters that match the first letter in the word
        boolean f = false;

        //search for the first letter
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    location[n][0] = i;
                    location[n][1] = j;
                    n++;
                }
            }
        }

        outerloop:
        for (int i = 0; i < n; i++) {

            int I = location[i][0];
            int J = location[i][1];

            //searching horizontally left to right
            for (int k = 1; k < word.length(); k++) {

                I = (I + 1) % 7;

                if (grid[I][J] != word.charAt(k)) {
                    I = location[i][0];
                    J = location[i][1];
                    break;
                } else if (word.length() - 1 == k) {
                    f = true;
                    System.out.println("Found vertically, up to down at index: " + location[i][0] + ", " + location[i][1]);
                    break outerloop;
                }
            }

            //searching horizontally right to left
            for (int k = 1; k < word.length(); k++) {

                I = ((I - 1) % 7 + 7) % 7;

                if (grid[I][J] != word.charAt(k)) {
                    I = location[i][0];
                    J = location[i][1];
                    break;
                } else if (word.length() - 1 == k) {
                    f = true;
                    System.out.println("Found vertically, bottom to top at index: " + location[i][0] + ", " + location[i][1]);
                    break outerloop;
                }
            }

            //searching vertically downwards
            for (int k = 1; k < word.length(); k++) {

                J = (J + 1) % 7;

                if (grid[I][J] != word.charAt(k)) {
                    I = location[i][0];
                    J = location[i][1];
                    break;
                } else if (word.length() - 1 == k) {
                    f = true;
                    System.out.println("Found horizontally, left to right at index: " + location[i][0] + ", " + location[i][1]);
                    break outerloop;
                }
            }
            //searching vertically upwards

            for (int k = 1; k < word.length(); k++) {

                J = ((J - 1) % 7 + 7) % 7;


                if (grid[I][J] != word.charAt(k)) {
                    I = location[i][0];
                    J = location[i][1];
                    break;

                } else if (word.length() - 1 == k) {

                    f = true;
                    System.out.println("Found horizontally, right to left at index: " + location[i][0] + ", " + location[i][1]);
                    break outerloop;

                }
            }

            //searching diagonally downwards

            for (int k = 1; k < word.length(); k++) {

                I = I + 1;
                J = J + 1;

                if (I > 7) {
                    I = I - J;
                    J = 0;
                }
                if (J > 7) {
                    J = J - I;
                    I = 0;
                }


                if (grid[(I)][(J)] != word.charAt(k)) {
                    I = location[i][0];
                    J = location[i][1];
                    break;
                } else if (word.length() - 1 == k) {
                    f = true;
                    System.out.println("Found diagonally, downwards at index: " + location[i][0] + ", " + location[i][1]);
                    break outerloop;
                }
            }


            //searching diagonally upwards
            for (int k = 1; k < word.length(); k++) {

                I = I - 1;
                J = J - 1;

                if (I < 0) {
                    I = I + J;
                    J = 7;
                }
                if (J < 0) {
                    J = J + I;
                    I = 7;
                }

                if (grid[(I)][(J)] != word.charAt(k)) {
                    break;
                } else if (word.length() - 1 == k) {
                    f = true;
                    System.out.println("Found diagonally, upwards at index: " + location[i][0] + ", " + location[i][1]);
                    break outerloop;
                }
            }
        }

        if (!f) {
            System.out.println("NOT FOUND! :(");
        }
    }
}