package ShiftySum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] shifted = new int[k];
        int sum = 0;
        int shiftedNumber = n;
        for (int i = 0; i < k; i++) {
            shiftedNumber = shiftedNumber * 10;
            shifted[i] = shiftedNumber;
            sum += shifted[i];
        }

        System.out.println(sum + n);


    }
}
