package RuleOfThree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> subCodes = new LinkedHashMap<>();
        String input = null;
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in)) {
            String line;
            int count = 3;
            while ((line = buffer.readLine()) != null && count > -1) {
                if (count == 0) {
                    input = line;
                    break;

                } else {
                    String[] s = line.split("\\s");
                    subCodes.put(s[0], s[1]);
                    count--;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int steps = Integer.parseInt(input.split("\\s")[0]);
        String i = input.split("\\s")[1];
        String f = input.split("\\s")[2];
        List<String[]> sequences = new ArrayList<>();
        List<String> keys = new ArrayList<>(subCodes.keySet());
        int currentSteps = 1;
        boolean found = findSequence(subCodes, steps, i, f, keys, sequences, currentSteps);
        for (int j = sequences.size() - 1; j >= 0; j--) {
            System.out.println(sequences.get(j)[0] + " " + sequences.get(j)[1] + " " + sequences.get(j)[2]);
        }
    }

    public static boolean findSequence(Map<String, String> subCodes, int maximumSteps, String initial, String finalString,  List<String> keys, List<String[]> sequences, int currentSteps ) {
        //Need to remember: Rule number, (1, 2, 3), position index of conversion, and the resulting sequenc
        for (int i = 0; i < initial.length(); i++) {
            for (int j = 0; j < keys.size(); j++) {
                boolean foundRule = initial.startsWith(keys.get(j), i);
                if (foundRule) {
                    String[] sequence = new String[3];
                    sequence[0] = String.valueOf(j+1);
                    sequence[1] = String.valueOf(i+1);
                    String before = "";
                    String after = "";
                    if (i > 0) {
                        before = initial.substring(0, i);
                    }
                    if (i < initial.length() - 1) {
                        after = initial.substring(i + keys.get(j).length(), initial.length());
                    }
                    String newString = before + subCodes.get(keys.get(j)) + after;
                    sequence[2] = newString;

                    if (currentSteps == maximumSteps) {
                        if (!newString.equals(finalString)) {
                            return false;

                        }
                        else {
                            sequences.add(sequence);
                            return true;
                        }
                    }
                    else {
                        boolean found = findSequence(subCodes, maximumSteps, newString, finalString, keys, sequences, currentSteps + 1);
                        if (found) {
                            sequences.add(sequence);
                            return true;
                        }
                    }

                }




            }

        }
        return false;

    }
}
