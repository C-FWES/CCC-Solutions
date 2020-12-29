package CyclicShifts;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String t = scanner.next();
        String s = scanner.next();
        scanner.close();
        doesContain(t, s);
    }

    public static void doesContain(String t, String s) {
        int searchedSum = 0;
        for (char c : s.toCharArray()) {
            searchedSum+=c;
        }

        int windowEnd = s.length();
        for (int i = 0; i < t.length() - s.length(); i++) {
            char[] c = Arrays.copyOfRange(t.toCharArray(), i, windowEnd);
            int windowSum = 0;
            for (char c1 : c) {
                windowSum += c1;
            }
            windowEnd++;

            if (windowSum == searchedSum) {
                System.out.println("yes");
                break;
            }
            if (i == t.length() - s.length() - 1 && windowSum != searchedSum) {
                System.out.println("no");
            }

        }

//        System.out.println("no");

    }


}
