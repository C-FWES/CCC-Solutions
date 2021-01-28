package ExactlyElectrical;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] start = new String[2];
        String[] destination = new String[2];
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        start = s.split("\\s");
        String s2 = sc.nextLine();
        destination = s2.split("\\s");
        int batterys = sc.nextInt();
        int y1 = Integer.parseInt(start[0]);
        int y2 = Integer.parseInt(destination[0]);
        int x1 = Integer.parseInt(start[1]);
        int x2 = Integer.parseInt(destination[1]);

        int shortestDistance = Math.abs(y2 - y1) + Math.abs(x2 - x1);

        if (batterys >= shortestDistance && (batterys - shortestDistance) % 2 == 0) {
            System.out.println("Y");
        }
        else {
            System.out.println("N");
        }

    }
}
