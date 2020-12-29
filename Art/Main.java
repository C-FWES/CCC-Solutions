package Art;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String[]> tokens = new ArrayList<>();
        int count = Integer.parseInt(br.readLine());
        String line;
        try {
            while ((line = br.readLine()) != null && count > 0) {
               tokens.add(line.split(","));
               count--;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] mostRight = getMostRight(tokens);
        String[] mostLeft = getMostLeft(tokens);

        int[] topRightCorner = {Integer.parseInt(mostLeft[0]) + 1, Integer.parseInt(mostRight[1]) + 1};
        int[] bottomLeftCorner = {Integer.parseInt(mostRight[0]) - 1,  Integer.parseInt(mostLeft[1]) - 1};

        System.out.println(bottomLeftCorner[0] + "," + bottomLeftCorner[1]);
        System.out.println(topRightCorner[0] + "," + topRightCorner[1]);


    }

    public static String[] getMostLeft(List<String[]> tokens) {

        String[] mostLeft = new String[2];
        Collections.sort(tokens, Comparator.comparing(strings -> strings[0]));
        Collections.reverse(tokens);
        mostLeft = tokens.get(0);

        return mostLeft;

    }

    public static String[] getMostRight(List<String[]> tokens) {
        String[] mostRight = new String[2];
        Collections.sort(tokens, Comparator.comparing(strings -> strings[0]));
        Collections.sort(tokens, Comparator.comparing(strings -> strings[0]));
        mostRight = tokens.get(0);

        return mostRight;
    }

}
