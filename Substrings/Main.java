package Substrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n];
        String line;
        int count = n;
        int i = 0;
        while ((line = br.readLine()) != null && count > 0) {
            strings[i] = line;
            i+=1;
            count-=1;
        }

        for (String string : strings) {
            System.out.println(buildSuffixArray(string));
        }

    }

    public static int buildSuffixArray(String s) {
        int length = s.length();
        String[] suffixArray = new String[length];
        for (int i = 0; i < length; i++) {
            suffixArray[i] = s.substring(i, length);
        }
        Arrays.sort(suffixArray);
        int substringCount = suffixArray[0].length() + 1;

        for (int i = 1; i < length; i++) {
            int lcp = getLCP(suffixArray[i], suffixArray[i-1]);
            substringCount+=suffixArray[i].length() - lcp;
        }
        return substringCount;
    }

    public static int getLCP(String a, String b) {
        int length = Math.min(a.length(), b.length());
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return i;
            }
        }
        return length;
    }
}
