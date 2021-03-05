package Encryption;

public class Encryption {
    static String encryption(String s) {
        s = s.replaceAll("\\s", "");
        if (s.length() == 1) {
            return s;
        }

        int distance = 0;
        double sqrt = Math.sqrt(s.length());
        int floor = (int) Math.floor(sqrt);
        int ceil = (int) Math.ceil(sqrt);

        if (floor == ceil) {
            distance = floor;
        } else {
            if (s.length() <= floor * ceil) {
                distance = ceil;

            } else {
                distance = ceil;
            }
        }

        StringBuilder buildBlocks = new StringBuilder();

        char[] letters = s.toCharArray();
        int i = 0;
        int previousIndex = 0;

        while (previousIndex < distance) {
            buildBlocks.append(letters[previousIndex]);
            i = previousIndex;

            while (i + distance < s.length()) {
                buildBlocks.append(letters[i + distance]);
                i = i + distance;
            }
            buildBlocks.append(' ');
            previousIndex++;

        }

        String encrypted = buildBlocks.toString();
        return encrypted;
    }

    public static void main(String[] args) {
        String s = "have a nice day";
        String encrypted = encryption(s);
        System.out.println(encrypted);

    }
}
