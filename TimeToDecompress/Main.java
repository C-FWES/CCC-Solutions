package TimeToDecompress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in)) {
            String line;
            int total = Integer.parseInt(buffer.readLine());
            while (total > 0 && (line = buffer.readLine()) != null) {
                String[] tokens = line.split("\\s");
                List<String> input = new ArrayList<>();
                for (String s : tokens) {
                    input.add(s);
                }
                total--;
                list.add(input);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (List<String> strings : list) {
            String character = strings.get(1);
            int num = Integer.parseInt(strings.get(0));
            for (int i = 0; i < num; i++) {
                System.out.print(character);
            }
            System.out.println();
        }
    }
}
