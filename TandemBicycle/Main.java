package TandemBicycle;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int question = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        String dmojistan = sc.nextLine();
        String pegland = sc.nextLine();
        String[] dmoj = dmojistan.split("\\s");
        String[] peg = pegland.split("\\s");
        int[] dmojInt = new int[dmoj.length];
        int[] pegInt = new int[peg.length];
        for (int i = 0; i < n; i++) {
            dmojInt[i] = Integer.parseInt(dmoj[i]);
            pegInt[i] = Integer.parseInt(peg[i]);
        }
        Arrays.sort(dmojInt);
        Arrays.sort(pegInt);
        int result = 0;
        if (question == 1) {
            result = getMinimumTotalSpeed(n, dmojInt, pegInt);
        }

        if (question == 2) {
            result = getMaximumTotalSpeed(n, pegInt, dmojInt);
        }

        System.out.println(result);

    }

    public static int getMinimumTotalSpeed(int n, int[] dmoj, int[] peg) {
        int minimumTotalSpeed = 0;
        for (int i = n - 1; i >= 0; i--) {
            minimumTotalSpeed+=Math.max(dmoj[i], peg[i]);
        }
        return minimumTotalSpeed;
    }

    public static int getMaximumTotalSpeed(int n, int[] peg, int[] dmoj) {
        int maximumTotalSpeed = 0;
        for (int i = 0; i < n; i++) {
            maximumTotalSpeed+=Math.max(dmoj[n - 1 - i], peg[i]);
        }
        return maximumTotalSpeed;
    }

}
