package ColdCompress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> codes = new ArrayList<>();
        int lines = 0;
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in)) {
            lines = Integer.parseInt(buffer.readLine());
            String line;
            while ((line = buffer.readLine()) != null && lines > 0) {
                codes.add(line);
                lines--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        for (String compressed : codes) {
//            LinkedHashMap<Character, Integer> freqMap = new LinkedHashMap<>();
//            for (char c : compressed.toCharArray()) {
//                if (freqMap.containsKey(c)) {
//                    freqMap.put(c, freqMap.get(c) + 1);
//                }
//                else {
//                    freqMap.put(c, 1);
//                }
//            }
//
//            for (Character character : freqMap.keySet()) {
//                System.out.print(freqMap.get(character) + " " + character + " ");
//            }
//            System.out.println();
//        }
        for (String compressed : codes) {
            for (int i = 0; i < compressed.length(); i++) {
                int count = 1;
                while (i + 1 < compressed.length() && compressed.charAt(i) == compressed.charAt(i + 1)) {
                    i++;
                    count++;
                }
                System.out.print(count + " " + compressed.charAt(i) + " ");
            }
            System.out.println();
        }



    }
}
