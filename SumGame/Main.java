package SumGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] swiftsRuns = s1.split("\\s");
        String[] sephamoresRuns = s2.split("\\s");
        int swiftsTotal = 0;
        int sephamoreTotal = 0;
        int k = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            swiftsTotal += Integer.parseInt(swiftsRuns[i]);
            sephamoreTotal += Integer.parseInt(sephamoresRuns[i]);
            if (sephamoreTotal == swiftsTotal) {
                max = i + 1;
            }
        }
        System.out.println(max);
    }
}
