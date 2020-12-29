package DogTreats;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int smallTreats = scanner.nextInt();
        int mediumTreats = scanner.nextInt();
        int largeTreats = scanner.nextInt();
        scanner.close();

        int isHappy = 1*smallTreats+2*mediumTreats+3*largeTreats;
        if (isHappy >= 10) {
            System.out.println("happy");
        }
        else {
            System.out.println("sad");
        }
    }
}
