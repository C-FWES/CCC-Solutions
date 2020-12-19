import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int m = 0;
        int n = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        String[][] room = new String[m][n];
        int x = 0;
        String line;
        try {
            while ((line = br.readLine()) != null && x < m) {
                String[] tokens = line.split("\\s");

                room[x] = tokens;

                x++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int origin = Integer.parseInt(room[0][0]);
        int exit = Integer.parseInt(room[m - 1][n - 1]);
        int[] comparedCoordinates = {m, n};
        //Check if can jump to exit from beginning
        boolean check = checkIfCanExitFromLast(origin, comparedCoordinates);
        if (check) {
            System.out.println("yes");
        }

        Set<Position> positionSet = new HashSet<>();
        Map<Integer, List<Position>> positionMap = new HashMap<>();
        int maximumPosition = m * n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Integer position = Integer.parseInt(room[i][j]);
                if (position > maximumPosition) {
                    continue;
                }
                List<Position> positions = positionMap.get(position);
                if (positions != null) {
                    positions.add(new Position(i, j));
                }
                else {
                    List<Position> point = new ArrayList<>();
                    point.add(new Position(i, j));
                    positionMap.put(position, point);
                }
            }
        }

       boolean canEscape = getEscapeRoute( m, n, positionMap, positionSet);
       if (canEscape) {
           System.out.println("yes");
       }
       else {
           System.out.println("no");
       }



    }

    public static boolean checkIfCanExitFromLast(int origin, int[] comparedCoordinates) {
        int coordinateM = comparedCoordinates[0] + 1;
        int coordinateN = comparedCoordinates[1]+ 1;
        return coordinateM * coordinateN == origin;
    }

    public static boolean getEscapeRoute(int m, int n, Map<Integer, List<Position>> positionMap, Set<Position> positionSet) {
        int nextPoint = m * n;


        List<Position> positions = positionMap.get(nextPoint);

        if (positions != null) {
            for (Position position : positions) {
                if (position.getmPos() == 0 && position.getnPos() == 0) {
                    return true;
                }

                if (positionSet.contains(position)) {
                    continue;
                }
                else {
                    positionSet.add(position);
                }
                boolean result = getEscapeRoute(position.getmPos() + 1, position.getnPos() + 1, positionMap, positionSet);
                if (result) {
                    return true;

                }
            }
        }


        return false;
    }
    

    static class Position {
        public int mPos;
        public int nPos;

        public Position(int mPos, int nPos) {
            this.mPos = mPos;
            this.nPos = nPos;
        }

        public int getmPos() {
            return mPos;
        }

        public int getnPos() {
            return nPos;
        }

        @Override
        public int hashCode() {
            return mPos + 31 * nPos;
        }

    }

}

