//package VoronoiVillages;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        List<Double> villages = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            villages.add((double) sc.nextInt());
        }

        Collections.sort(villages);
        getLowestSize(villages);

    }

    public static void getLowestSize(List<Double> villages) {
        NumberFormat df = new DecimalFormat("#0.0");
        double currentSize = 0.0;
        double lowestSize = Double.MAX_VALUE;
        for (int i = 1; i < villages.size() - 1; i++) {
            currentSize = ((villages.get(i) - villages.get(i - 1)) / 2) + ((villages.get(i + 1) - villages.get(i)) / 2);
            if (currentSize < lowestSize) {
                lowestSize = currentSize;
            }
        }
        System.out.println(df.format(lowestSize));
    }
}
