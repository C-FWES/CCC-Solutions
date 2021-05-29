package Gates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Gates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int p = Integer.parseInt(s);
        int[] arrivals = new int[p];
        String line;
        int index = 0;
        while ((line = br.readLine()) != null && p > 0) {
            arrivals[index] = Integer.parseInt(line);
            index++;
            p -= 1;
        }
        boolean[] gates = new boolean[g];
        int planeNumber = 0;
        check:
        {
            for (int i = 0; i < arrivals.length; i++) {
                int gateIndex = arrivals[i] - 1;
                while (gates[gateIndex]) {
                    gateIndex--;
                    if (gateIndex < 0) {
                        break check;
                    }
                }
                gates[gateIndex] = true;
                planeNumber++;

            }
        }
        System.out.println(planeNumber);
    }
}

