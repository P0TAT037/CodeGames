package com.catatoes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String word = read.next();

        char[][] grid = new char[10][10];
        int[][] location = new int[100][2];
        int n = 0; //number of letters that match the first letter in the word
        boolean f = false;

        grid[0][0] = 'b';
        grid[0][1] = 'r';
        grid[0][2] = 'u';
        grid[0][3] = 'h';

        //search for the first letter
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    location[n][0] = i;
                    location[n][1] = j;
                    n++;
                }
            }
        }


        for (int i = 0; i < n; i++) {

            int I = location[i][0];
            int J = location[i][1];

            //searching horizontally left to right
            for (int k = 1; k < word.length(); k++) {

                I = (I + 1) % 10;

                if (grid[I][J] != word.charAt(k)) {
                    I = location[i][0];
                    J = location[i][1];
                    break;
                } else if (word.length() - 1 == k) {
                    f = true;
                    System.out.println("Found horizontally, left to right at index: " + location[i][0] + ", " + location[i][1]);
                    break;
                }
            }

            //searching horizontally right to left
            for (int k = 1; k < word.length(); k++) {

                I = (I + 1) % 10;
                I = I - (I - (k - 1));

                if (grid[I][J] != word.charAt(k)) {
                    I = location[i][0];
                    J = location[i][1];
                    break;
                } else if (word.length() - 1 == k) {
                    f = true;
                    System.out.println("Found horizontally, right to left at index: " + location[i][0] + ", " + location[i][1]);
                    break;
                }
            }

            //searching vertically downwards
            for (int k = 1; k < word.length(); k++) {

                J = (J + 1) % 10;

                if (grid[I][J] != word.charAt(k)) {
                    I = location[i][0];
                    J = location[i][1];
                    break;
                } else if (word.length() - 1 == k) {
                    f = true;
                    System.out.println("Found vertically, up to down at index: " + location[i][0] + ", " + location[i][1]);
                    break;
                }
            }

            //searching vertically upwards
            for (int k = 1; k < word.length(); k++) {

                J = (J + 1) % 10;
                J = J - (J - (k - 1));

                if (grid[I][J] != word.charAt(k)) {
                    I = location[i][0];
                    J = location[i][1];
                    break;

                } else if (word.length() - 1 == k) {

                    f = true;
                    System.out.println("Found vertically, bottom to top at index: " + location[i][0] + ", " + location[i][1]);
                    break;

                }
            }

            //searching diagonally downwards
            for (int k = 1; k < word.length(); k++) {

                I = I + k;
                J = J + k;

                if (I > 9) {
                    I = I - J;
                    J = 0;
                }
                if (J > 9) {
                    J = J - I;
                    I = 0;
                }


                if (grid[(I)][(J)] != word.charAt(k)) {
                    break;
                } else if (word.length() - 1 == k) {
                    f = true;
                    System.out.println("Found diagonally, downwards at index: " + location[i][0] + ", " + location[i][1]);
                    break;
                }
            }


            //searching diagonally upwards
            for (int k = 1; k < word.length(); k++) {

                I = I + k;
                J = J + k;

                if (I > 9) {
                    I = I - J;
                    J = 0;
                }
                if (J > 9) {
                    J = J - I;
                    I = 0;
                }

                I = I - (I - (k - 1));
                J = J - (J - (k - 1));

                if (grid[(I)][(J)] != word.charAt(k)) {
                    break;
                } else if (word.length() - 1 == k) {
                    f = true;
                    System.out.println("Found diagonally, upwards at index: " + location[i][0] + ", " + location[i][1]);
                    break;
                }
            }
        }

        if (!f) {
            System.out.println("NOT FOUND! :(");
        }
    }
}

