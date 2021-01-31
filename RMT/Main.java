package RMT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmq = br.readLine().split("\\s");
        int n = Integer.parseInt(nmq[0]);//Station number
        int m = Integer.parseInt(nmq[1]);//Lines
        int q = Integer.parseInt(nmq[2]);
        int count = q;
        String[] subwayStationLines2 = br.readLine().split("\\s");
        int[] subwayStationLines = new int[subwayStationLines2.length];
        for (int i = 0; i < subwayStationLines2.length; i++) {
            subwayStationLines[i] = Integer.parseInt(subwayStationLines2[i]);
        }

        String[] subwayStationPassengers2 = br.readLine().split("\\s");
        int[] subwayStationPassengers = new int[subwayStationPassengers2.length];
        for (int i = 0; i < subwayStationLines2.length; i++) {
            subwayStationPassengers[i] = Integer.parseInt(subwayStationPassengers2[i]);
        }

        LinkedList<String[]> actions = new LinkedList<>();

        String line;
        try {
            while (count > 0 && (line = br.readLine()) != null) {
                String[] tokens = line.split("\\s");
                actions.add(tokens);
                count--;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Map<Integer, List<Integer>> stationLines = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int currentLine = subwayStationLines[i];
            List<Integer> lineIndex = stationLines.get(currentLine);
            if (lineIndex == null) {
                lineIndex = new ArrayList<>();
                stationLines.put(currentLine, lineIndex);
            }

            lineIndex.add(i);
        }


        for (String[] action : actions) {
            if (action[0].equals("1")) {
                int result = completeSurvey(action, subwayStationLines, subwayStationPassengers);

                System.out.println(result);

            } else if (action[0].equals("2")) {
                operateLine(action, subwayStationLines, subwayStationPassengers, stationLines);
            }
        }
    }

    public static int completeSurvey(String[] survey, int[] subwayStationLines, int[] subwayStationPassengers) {
        int surveyResult = 0;
        int startSurvey = Integer.parseInt(survey[1]) - 1;
        int endSurvey = Integer.parseInt(survey[2]);
        for (int i = startSurvey; i < endSurvey; i++) {
            surveyResult += subwayStationPassengers[i];
        }
        return surveyResult;
    }

    public static void operateLine(String[] operation, int[] subwayStationLines, int[] subwayStationPassengers, Map<Integer, List<Integer>> stationLines) {
        List<Integer> indexes = stationLines.get(Integer.parseInt(operation[1]));
        int temp = subwayStationPassengers[indexes.get(indexes.size() - 1)]; // The passenger of the Last station of this line

        for (int i = indexes.size() - 1; i > 0; i--) {
            subwayStationPassengers[indexes.get(i)] = subwayStationPassengers[indexes.get(i - 1)];
        }
        subwayStationPassengers[indexes.get(0)] = temp;
    }

}