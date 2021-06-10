package ReturningHome;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> directions = new ArrayList<>(5);
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("SCHOOL")) {
                break;
            }
            directions.add(line);
        }
        int size = directions.size();
        int j = 0;
        List<String> newDirections = new ArrayList<>(5);
        for (int i = size-1; i >= 0; i-=2) {
            String dir = directions.get(i);
            if (dir.equals("R")) {
                if (i == 0) {
                    newDirections.add(j, "Turn LEFT into your HOME.");
                }
                else {
                    String location = directions.get(i-1);
                    newDirections.add(j, "Turn LEFT onto " + location + " street.");
                    j++;
                }
            }
            else if (dir.equals("L")) {
                if (i == 0) {
                    newDirections.add(j, "Turn RIGHT into your HOME.");
                }
                else {
                    String location = directions.get(i-1);
                    newDirections.add(j, "Turn RIGHT onto " + location + " street.");
                    j++;
                }
            }
        }

        for (int i = 0; i < newDirections.size(); i++) {
            System.out.println(newDirections.get(i));
        }
    }
}
