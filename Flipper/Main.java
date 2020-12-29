//package Flipper;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String flips = "";
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in)) {
            flips = buffer.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        flipGrid(flips);
    }

    public static void flipGrid(String flips) {
        int[][] grid = new int[2][2];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[1][0] = 3;
        grid[1][1] = 4;

        for (char c : flips.toCharArray()) {
            if (c == 'H') {
                flipHorizontal(grid);
            }
            if (c == 'V') {
                flipVertical(grid);
            }
        }

        System.out.print(grid[0][0] + " ");
        System.out.print(grid[0][1]);
        System.out.println();
        System.out.print(grid[1][0] + " ");
        System.out.print(grid[1][1]);
    }

    public static void flipHorizontal(int[][] grid) {
        int[] rowCopy = {grid[0][0], grid[0][1]};
        grid[0][0] = grid[1][0];
        grid[0][1] = grid[1][1];
        grid[1][0] = rowCopy[0];
        grid[1][1] = rowCopy[1];
    }

    public static void flipVertical(int[][] grid) {
        int[] columCopy = {grid[0][0], grid[1][0]};
        grid[0][0] = grid[0][1];
        grid[1][0] = grid[1][1];
        grid[0][1] = columCopy[0];
        grid[1][1] = columCopy[1];
    }
}
