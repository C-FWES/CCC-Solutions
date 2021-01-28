package FavoriteTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int duration = sc.nextInt();
        int sequences = 0;
//        int time = 1200;
        int minutes = 0;
        String stringMins = "";
        int hours = 12;
        int remainder = duration % 720;
            for (int i = 0; i < remainder; i++) {
                minutes++;
                if (minutes >= 60) {
                    minutes -= 60;
                    if (hours + 1 < 13) {
                        hours += 1;
                    } else {
                        hours = (hours + 1) % 12;
                    }
                }
                if (minutes < 10 && String.valueOf(hours).length() == 1) {
                    stringMins = "0" + String.valueOf(minutes);
                    char[] minute = stringMins.toCharArray();
                    if (isArithmeticSequence3Digits(hours, Integer.parseInt(String.valueOf(minute[0])), Integer.parseInt(String.valueOf(minute[1])))) {
                        sequences+=1;
                    }
                }
                else if (minutes < 10 && String.valueOf(hours).length() > 1) {
                    stringMins = "0" + String.valueOf(minutes);
                    char[] minute = stringMins.toCharArray();
                    char[] hour = String.valueOf(hours).toCharArray();
                    if (isArithmeticSequence(Integer.parseInt(String.valueOf(hour[0])), Integer.parseInt(String.valueOf(hour[1])), Integer.parseInt(String.valueOf(minute[0])), Integer.parseInt(String.valueOf(minute[1])))) {
                        sequences+=1;
                    }
                }
                else if (String.valueOf(hours).length() == 1) {
                    char[] minute = String.valueOf(minutes).toCharArray();
                    if (isArithmeticSequence3Digits(hours, Integer.parseInt(String.valueOf(minute[0])), Integer.parseInt(String.valueOf(minute[1])))) {
                        sequences+=1;
                    }
                }
                else {
                    char[] minute = String.valueOf(minutes).toCharArray();
                    char[] hour = String.valueOf(hours).toCharArray();
                    if (isArithmeticSequence(Integer.parseInt(String.valueOf(hour[0])), Integer.parseInt(String.valueOf(hour[1])), Integer.parseInt(String.valueOf(minute[0])), Integer.parseInt(String.valueOf(minute[1])))) {
                        sequences+=1;
                    }
            }
        }
            sequences+=31*(duration/720);
        System.out.println(sequences);
    }

    public static boolean isArithmeticSequence(int firstDigit, int secondDigit, int thirdDigit, int fourthDigit) {
        if ((fourthDigit - thirdDigit) == (thirdDigit - secondDigit) && (thirdDigit - secondDigit) == (secondDigit - firstDigit)) {
            return true;
        }
        else {
            return false;
        }

    }

    public static boolean isArithmeticSequence3Digits(int firstDigit, int secondDigit, int thirdDigit) {
        if ((thirdDigit - secondDigit) == (secondDigit - firstDigit)) {
            return true;
        }
        else {
            return false;
        }

    }

}
