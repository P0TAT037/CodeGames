package com.catatoes;

import java.util.Scanner;

/**
 *
 * @author P0TAT037, Siko69
 */

public class EuclidsGame {

    static int gcd(int m, int n){

        if(n > m) {
            int tmp = m;
            m = n;
            n = tmp;
        }

        while(n != 0) {
            int tmp = m;

            if(n > m) {
               m = n;
               n = tmp;
               tmp = m;
            }

            m = n;
            n = tmp-n;
        }

        return m;
    }

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        int x, y;
        int key;

        System.out.print("Please, Enter the first number : ");
        x = read.nextInt();

        System.out.print("Please, Enter the second number : ");
        y = read.nextInt();

        key = Math.max(x,y)/gcd(x, y);

        if(key % 2 == 0) {
            System.out.println("Player 1 wins");
        } else {
            System.out.println("Player 2 wins");
        }
    }
}
