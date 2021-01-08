package TelemarketerOrNot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        int n4 = sc.nextInt();
        sc.close();

        if ((n1 == 8 || n1 == 9) && (n2 == n3) && (n4 == 8 || n4 == 9)) {
            System.out.println("ignore");
        }
        else {
            System.out.println("answer");
        }
    }
}
