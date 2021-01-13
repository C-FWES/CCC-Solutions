package Sunflowers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int size = 0;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(buffer.readLine());
        String[][] sunflowerMeasurements = new String[size][size];
        String line;
        int i = 0;
        try {
            while ((line = buffer.readLine()) != null && i < size) {
                String[] tokens = line.split("\\s");
                sunflowerMeasurements[i] = tokens;
                i++;
            }
            buffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        getOriginalTable(sunflowerMeasurements);

    }

    public static void getOriginalTable(String[][] sunflowers) {
        while (!checkRowsAndColums(sunflowers)) {
            sunflowers = clockwiseRotate(sunflowers);
        }

        for (int i = 0; i < sunflowers.length; i++) {
            for (int j = 0; j < sunflowers.length; j++) {
                if (j != 0) {
                    System.out.print(" ");
                }
                System.out.print(sunflowers[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean checkRowsAndColums(String[][] sunflowers) {
        for (int i = 0; i < sunflowers.length; i++) {
            if (!checkRow(sunflowers, i)) {
                return false;
            }
            if (!checkColumn(sunflowers, i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRow(String[][] sunflowers, int sunflowerRowIndex) {
            int lastHeight = Integer.parseInt(sunflowers[sunflowerRowIndex][0]);
            int nextHeight = Integer.parseInt(sunflowers[sunflowerRowIndex][1]);
            if (lastHeight > nextHeight) {
                return false;
            }
            else {
                return true;
            }
    }

    public static boolean checkColumn(String[][] sunflowers, int sunflowerColumnIndex) {
            int lastFlower = Integer.parseInt(sunflowers[0][sunflowerColumnIndex]);
            int nextFlower = Integer.parseInt(sunflowers[1][sunflowerColumnIndex]);
            if (lastFlower > nextFlower) {
                return false;
            }
            else {
                return true;
            }
    }


    public static String[][] clockwiseRotate(String[][] sunflowers) {
        int n = sunflowers.length;
        String[][] rotated = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[i][j] = sunflowers[n - j - 1][i];
            }
        }
        return rotated;
    }
}
