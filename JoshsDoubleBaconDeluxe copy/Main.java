package JoshsDoubleBaconDeluxe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> orders = new ArrayList<>();


//        try (InputStreamReader in = new InputStreamReader(new FileInputStream("/Users/wesleyou/Downloads/all_data/senior_data/s5/s5.3-20.in"));
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in)) {
            String line;
            int total = Integer.parseInt(buffer.readLine());
            while (total > 0 && (line = buffer.readLine()) != null) {
                String[] tokens = line.split("\\s");
                for (String token : tokens) {
                    orders.add(Integer.parseInt(token));
                    total--;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<Integer, Double> probMap = new HashMap<>();
        double probability = getProbability(orders, orders.get(0), 1, orders.size(), probMap);
        System.out.println(probability);
    }

    public static double getProbability(List<Integer> orders, int coach, int start, int end, Map<Integer, Double> probabilityMap) {
        int total = end - start + 1;

        double totalSubProperties = 0.0;

        double coachProbability =  1.0 / total;

        for (int i = end - 1; i >= start; i--) {
            Integer item = orders.get(i);

            totalSubProperties += getSubProbability(orders, coach, probabilityMap, item, i);
        }

        totalSubProperties += getSubProbability(orders, coach, probabilityMap, coach, orders.lastIndexOf(coach));


        return totalSubProperties * coachProbability;
    }

    public static double getSubProbability(List<Integer> orders, int coach, Map<Integer, Double> probabilityMap, Integer item, int lastIndex) {
        if (probabilityMap.get(item) != null) {
            return probabilityMap.get(item);
        }

        int joshBurger = orders.get(orders.size() - 1);

        double subProbability = 0.0;

        if (item == coach) {
            subProbability = 1.0;
        }

        else if (item == joshBurger) {
            subProbability = 0.0;
        }

        else if (item.equals(orders.get(orders.size() - 2))) {
            subProbability = 0.5;
        }

        else {
            subProbability = getProbability(orders, coach, lastIndex+1, orders.size(), probabilityMap);

        }

        probabilityMap.put(item, subProbability);
        return subProbability;
    }


}
