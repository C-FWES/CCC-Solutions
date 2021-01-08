package OccupyParking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String day1 = sc.next();
        String day2 = sc.next();
        char[] c1 = day1.toCharArray();
        char[] c2 = day2.toCharArray();
        sc.close();
        int count = 0;
        for (int i = 0; i < n; i++) {
                if (c1[i] == 'C' && c2[i] == 'C') {
                    count++;
                }

        }

        System.out.println(count);
    }
}
