package Epidemiology;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        scanner.close();
        multiplyPeople(p, n, r);


    }

    public static void multiplyPeople(int p, int n, int r) {
        int days = 0;
        int total = n;
        int dayInfect = n;
        while (total <= p) {
            days+=1;
            total += dayInfect*r;
            dayInfect *= r;
        }
        System.out.println(days);
    }
}
