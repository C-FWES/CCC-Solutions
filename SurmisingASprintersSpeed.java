import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Observation> observations1 = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s");
            observations1.add(new Observation(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));
        }


        scanner.close();

        observations1.sort(Comparator.comparing(o -> o.time));

        int timeDiff = 0;
        int meterDiff = 0;
        double temp = 0;
        double maxDivided = 0;
        for (int i = 0; i < observations1.size() - 1; i++) {
            timeDiff = observations1.get(i + 1).time - observations1.get(i).time;

            meterDiff = Math.abs(observations1.get(i + 1).spot - observations1.get(i).spot);

            temp = 1.0 * meterDiff / timeDiff;

            if (temp > maxDivided) {
                maxDivided = temp;
            }
        }


        System.out.println(maxDivided);
    }


    static class Observation {
        public int time;
        public int spot;

        public Observation(int time, int spot) {
            this.time = time;
            this.spot = spot;
        }


    }


}
