import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String h = "";
        String n = "";
        try (InputStreamReader in = new InputStreamReader( new BufferedInputStream(System.in));
             BufferedReader buffer = new BufferedReader(in)) {
            n = buffer.readLine();
            h = buffer.readLine();
            buffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int permutations = findPermutations(h, n);
        System.out.println(permutations);


    }

    public static int findPermutations(String h, String n) {
        if (n.length() > h.length()) {
            return 0;
        }



        Set<Character> comparedCharacters = new HashSet<>();
        int windowSize = n.length();
        Set<String> permuted = new HashSet<>();
        char[] comparedPermutation = n.toCharArray();

        Arrays.sort(comparedPermutation);
        String sortedTarget = new String(comparedPermutation);

        int targetSum = 0;
        for (char c : comparedPermutation) {
            comparedCharacters.add(c);
            targetSum += c;
        }
        targetSum *= -1;


        boolean previousMatch = false;
        int windowSum = 0;
        for (int i = 0; i < h.length() - windowSize + 1; i++) {
           if (i == 0) {
                for (int j = i; j < i + windowSize; j++) {
                    windowSum += h.charAt(j);

                }
            }
            else {
                char previousFirstChar = h.charAt(i - 1);
                char lastChar = h.charAt(i + windowSize - 1);

               windowSum -= previousFirstChar;
               windowSum += lastChar;

                if(previousFirstChar == lastChar) {
                    if(previousMatch) {
                        String windowString = h.substring(i, i+windowSize);
                        permuted.add(windowString);
                    }
                    continue;
                } else {
                    if(previousMatch) {
                        previousMatch = false;
                        continue;
                    }
                }
            }

            if (windowSum + targetSum == 0) {
                String windowString = h.substring(i, i+windowSize);

                Set<Character> windowsSet = new HashSet<>();
                for (Character character : windowString.toCharArray()) {
                    windowsSet.add(character);
                }

                if(windowsSet.equals(comparedCharacters)) {

                    char[] windowsChar = windowString.toCharArray();
                    Arrays.sort(windowsChar);
                    if (new String(windowsChar).equals(sortedTarget)) {
                        permuted.add(windowString);
                        previousMatch = true;
                        continue;
                    }
                }
            }

            previousMatch = false;
        }

        return permuted.size();
    }
}
