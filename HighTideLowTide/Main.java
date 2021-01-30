package HighTideLowTide;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split("\\s");

        Integer[] measurements = new Integer[n];
        for (int i = 0; i < n; i++) {
            measurements[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(measurements);

        int highLength = n/2;
        int lowLength = n - highLength;
        LinkedList<Integer> arrangedMeasurements = new LinkedList<>();
        for (int i = lowLength - 1; i >= 0; i--) {
            arrangedMeasurements.add(measurements[i]);
            int j = 2*lowLength - i - 1;

            if (j < measurements.length) {
                arrangedMeasurements.add(measurements[j]);
            }
        }

        for (Integer arrangedMeasurement : arrangedMeasurements) {
            System.out.print(arrangedMeasurement + " ");
        }

    }

}
