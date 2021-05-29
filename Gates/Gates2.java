package Gates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gates2 {
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
        int[] gates = new int[g];
        for (int i = 0; i < gates.length; i++) {
            gates[i] = Integer.MAX_VALUE;
        }
//        int[] airplanes = new int[g];
        int planeNumber = 0;
        check:
        {
            for (int i = 0; i < arrivals.length; i++) {
                int gateIndex = arrivals[i] - 1;
                int originalGateIndex = gateIndex;
                while (gates[gateIndex] != Integer.MAX_VALUE) {
                    int previousGateIndex = gateIndex;
                    gateIndex = gates[gateIndex];
                    if (gateIndex < 0) {
                        break check;
                    }
                    gates[previousGateIndex] = gateIndex-1;
                }
                gates[gateIndex] = gateIndex-1;
                gates[originalGateIndex] = gateIndex-1;
                planeNumber++;
//                airplanes[gateIndex] = arrivals[i];
//                System.out.println(originalGateIndex);
//                for (int j = 0; j < airplanes.length; j++) {
//                    System.out.print(airplanes[j]);
//                    System.out.print(" ");
//                }
//                System.out.println();
//                for (int j = 0; j < gates.length; j++) {
//                    System.out.print(gates[j]);
//                    System.out.print(" ");
//                }
//                System.out.println();
            }
        }
        System.out.println(planeNumber);
    }
}
