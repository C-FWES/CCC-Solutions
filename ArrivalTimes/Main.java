package ArrivalTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String leaveTime = sc.nextLine();
        char[] digits = leaveTime.toCharArray();
        int sevenAm = 420;
        int tenAm = 600;
        int threePm = 900;
        int sevenPm = 1140;
        int startingTime = convertStartingTime(digits);
        int originalTime = startingTime;
        int timeIfSlowed = 240;
        int accumulatedTime = 0;
        while (timeIfSlowed > 0) {
            if (isInRange(sevenAm, tenAm, threePm, sevenPm, startingTime)) {
                timeIfSlowed -= 1;
            }
            else {
                timeIfSlowed -= 2;
            }
            accumulatedTime+=1;
            startingTime+=1;
        }

        int finalTime = accumulatedTime+originalTime;
        String arriveTime = convertToTimeFormat(finalTime);
        System.out.println(arriveTime);
    }

    public static int convertStartingTime(char[] digits) {
        int startingTime = 0;
        String minutes = digits[3] + String.valueOf(digits[4]);
        if (digits[0] == '0') { //07:20
            int hours = Integer.parseInt(String.valueOf(digits[1])) * 60;
            startingTime = hours + Integer.parseInt(minutes);
        }
        else { //13:40
            String hours = digits[0] + String.valueOf(digits[1]);
            startingTime = Integer.parseInt(hours) * 60 + Integer.parseInt(minutes);
            }
        return startingTime;

    }

    public static String convertToTimeFormat(int finalTime) {
        String hours = String.valueOf((finalTime / 60) % 24);
        String minutes = String.valueOf(finalTime % 60);
        if (Integer.parseInt(hours) < 10) {
            hours = "0" + hours;
        }
        if (Integer.parseInt(minutes) < 10) {
            minutes = "0" + minutes;
        }

        String time = hours + ":" + minutes;

        return time;
    }

    public static boolean isInRange(int seven, int ten, int three, int sevenPm, int startTime) {
        if (startTime >= seven && startTime < ten) {
            return true;
        }
        else if (startTime >= three && startTime < sevenPm) {
            return true;
        }
        else {
            return false;
        }
    }
}
