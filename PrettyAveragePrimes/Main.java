package PrettyAveragePrimes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> inputs = new ArrayList<>();
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in)) {
            String line;
            int total = Integer.parseInt(buffer.readLine());
            while (total > 0 && (line = buffer.readLine()) != null) {
                inputs.add(Integer.parseInt(line));
                total--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        getPrimes(inputs);
    }

    public static void getPrimes(List<Integer> inputs) {
        List<List<Integer>> goodPrimes = new ArrayList<>();
        for (Integer n : inputs) {
            int j = n * 2 - 2;
            int doubleN = n*2 - 1;
            if (j > 1) {
                for (int i = 2; i < doubleN; i++) {
                    if (isPrime(i) && isPrime(j)) {
                        List<Integer> primes = new ArrayList<>();
                        primes.add(i);
                        primes.add(j);
                        goodPrimes.add(primes);
                        break;
                    }
                    j--;
                }
            }
        }
        for (List<Integer> goodPrime : goodPrimes) {
            System.out.print(goodPrime.get(0) + " ");
            System.out.print(goodPrime.get(1));
            System.out.println();
        }


    }

    public static boolean isPrime(int number) {
        if (number % 2 == 0) {
            return false;
        }
        
        int end = Math.floor(Math.sqrt(number));
        for (int i = 3; i <= end; i = i + 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
