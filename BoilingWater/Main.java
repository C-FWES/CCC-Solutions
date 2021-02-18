package BoilingWater;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int boilingTemp = sc.nextInt();
        //P = 5 × B − 400
        int p = 0;
        p = 5*boilingTemp - 400;
        if (p == 100) {
            System.out.println(p);
            System.out.println(0);
        }
        else if (p > 100) {
            System.out.println(p);
            System.out.println(-1);
        }
        else if (p < 100) {
            System.out.println(p);
            System.out.println(1);
        }
    }
}
