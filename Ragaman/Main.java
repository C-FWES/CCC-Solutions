package Ragaman;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();
        if (isAnagram(first, second)) {
            System.out.println("A");
        }
        else {
            System.out.println("N");
        }

    }

    public static boolean isAnagram(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        char[] firstCharacters = first.toCharArray();
        char[] secondCharacters = second.toCharArray();
        Map<Character, Integer> firstCount = new HashMap<>();
        Map<Character, Integer> secondCount = new HashMap<>();

        for (int i = 0; i < firstCharacters.length; i++) {
            if (firstCount.containsKey(firstCharacters[i])) {
                firstCount.put(firstCharacters[i], firstCount.get(firstCharacters[i]) + 1);
            }
            else {
                firstCount.put(firstCharacters[i], 1);
            }

            if (secondCount.containsKey(secondCharacters[i])) {
                secondCount.put(secondCharacters[i], secondCount.get(secondCharacters[i]) + 1);
            }
            else {
                secondCount.put(secondCharacters[i], 1);
            }
        }


        for (Character character : secondCount.keySet()) {
            if (character != '*' && secondCount.get(character) > firstCount.get(character)) {
                return false;
            }
        }

        return true;
    }
}
