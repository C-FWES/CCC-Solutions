package BridgeTransport;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CCC13S2 {

    public static void main(String[] args) throws IOException {

        Pair input = readInput();
        List<Integer> carWeights = input.carWeights;
        int maxWeight = input.maxWeight;

        // Calculate maximum number of cars that can be brought across the bridge
        int maxPossibleCars = 0;

        // Check edge cases
        int firstCar = carWeights.get(0);
        // First car is more than max weight so nothing can pass through
        if (firstCar <= maxWeight) {
            ++maxPossibleCars;
        } else {
            System.out.print(maxPossibleCars);
            return;
        }

        // First and second car more than max weight so only one can pass through
        if (firstCar + carWeights.get(1) <= maxWeight) {
            ++maxPossibleCars;
        } else {
            System.out.println(maxPossibleCars);
            return;
        }

        // First and second and third car more than max weight so only two can pass through
        if (firstCar + carWeights.get(1) + carWeights.get(2) <= maxWeight) {
            ++maxPossibleCars;
        } else {
            System.out.println(maxPossibleCars);
            return;
        }

        for (int i = 0; i < carWeights.size() - 3; i++) {
            int carWeight = carWeights.get(i);
            // Calculate sum of weight in sliding window
            if (carWeight + carWeights.get(i + 1) + carWeights.get(i + 2) + carWeights.get(i + 3) <= maxWeight) {
                maxPossibleCars += 1;
            } else {
                System.out.println(maxPossibleCars);
                return;
            }
        }

        System.out.print(maxPossibleCars);
    }

    private record Pair(List<Integer> carWeights, int maxWeight) {

    }

    private static Pair readInput() throws IOException {
        List<Integer> carWeights = new ArrayList<>();

        // Read input
        int maxWeight;
        int numberOfCars;
        try (InputStreamReader in = new InputStreamReader(new BufferedInputStream(System.in));
             BufferedReader buffer = new BufferedReader(in)) {

            maxWeight = Integer.parseInt(buffer.readLine());
            numberOfCars = Integer.parseInt(buffer.readLine());

            for (int i = 0; i < numberOfCars; i++) {
                int carWeight = Integer.parseInt(buffer.readLine());
                carWeights.add(carWeight);
            }
        }
        return new Pair(carWeights, maxWeight);
    }

}
