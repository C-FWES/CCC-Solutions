//package WinningScore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int app3 = scanner.nextInt() * 3;
        int app2 = scanner.nextInt() * 2;
        int app1 = scanner.nextInt();
        int b3 = scanner.nextInt() * 3;
        int b2 = scanner.nextInt() * 2;
        int b1 = scanner.nextInt();
        scanner.close();

        int apples = app3 + app2 + app1;
        int bananas = b3 + b2 + b1;
        if (apples > bananas) {
            System.out.println("A");
        }
        else if (bananas > apples) {
            System.out.println("B");
        }
        else {
            System.out.println("T");
        }
    }
}
