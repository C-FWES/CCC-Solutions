package ChancesOfWinning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC2013S3_2 {

    public static void main(String[] args) throws IOException {

        // initialize constants
        int t = 0;
        int g = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read T and G
        t = Integer.parseInt(br.readLine()); // Favorite team
        g = Integer.parseInt(br.readLine()); // Number of games already played

        // Holds the games already played
        int[][] playedGames = new int[g][4];

        String line;
        int y = 0;

        try {
            while ((line = br.readLine()) != null && y < g) {
                String[] row = line.split("\\s+");
                int[] intRow = new int[row.length];

                for (int i = 0; i < row.length; i++) {
                    intRow[i] = Integer.parseInt(row[i]);
                }

                playedGames[y] = intRow;
                ++y;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // win, lose, or tie
        // We initialzie a string array gameStatus to hold the results of each game
        // It have six elements to represent there are six possible games
        // first set to F becaues we dont know result yet
        String[] gamesResults = {"f","f","f","f","f","f"};


        // Loops through the games that are already play, so we can update status based on
        // the outcome already know
        for (int i = 0; i < g; i++) {
            int[] currentGame = playedGames[i];
            // get teams and their known points
            int firstTeam = currentGame[0];
            int secondTeam = currentGame[1];
            int firstTeamScore = currentGame[2];
            int secondTeamScore = currentGame[3];

            // Consider the cases when the first team is "1"
            if (firstTeam == 1) {

                if (secondTeam == 2) {
                    // Update the gameResults with "W" if team 1 won
                    if (firstTeamScore > secondTeamScore) {
                        gamesResults[0] = "W";
                    }
                    // update the gameResults with "L" if team 1 lose
                    else if (firstTeamScore < secondTeamScore) {
                        gamesResults[0] = "L";
                    }
                    // update the gameresults with "T" if team 1 and team 2 tie
                    else {
                        gamesResults[0] = "T";
                    }
                }

                // Also consider if the second team is team "3", this updates
                // in index 1 because this is the 2nd possible game pairing
                else if (secondTeam == 3) {
                    if (firstTeamScore > secondTeamScore) {
                        gamesResults[1] = "W";
                    }
                    else if (firstTeamScore < secondTeamScore) {
                        gamesResults[1] = "L";
                    }
                    else {
                        gamesResults[1] = "T";
                    }
                }

                // Also consider if the second team is team "4", this updates in index
                // 2 because this is the 3rd possible game pairing
                else if (secondTeam == 4) {
                    if (firstTeamScore > secondTeamScore) {
                        gamesResults[2] = "W";
                    } else if (firstTeamScore < secondTeamScore) {
                        gamesResults[2] = "L";
                    } else {
                        gamesResults[2] = "T";
                    }
                }

            }

            // If the first team is team "2" instead
            else if (firstTeam == 2) {

                // Update index 3 of gameresults since this will be the
                // 4th possible game pairing
                if (secondTeam == 3) {
                    if (firstTeamScore > secondTeamScore) {
                        gamesResults[3] = "W";
                    }
                    else if (firstTeamScore < secondTeamScore) {
                        gamesResults[3] = "L";
                    }
                    else {
                        gamesResults[3] = "T";
                    }
                }

                // Update index 4 of gameresults since this will be the
                // 5th possible game pairing
                else if (secondTeam == 4) {
                    if (firstTeamScore > secondTeamScore) {
                        gamesResults[4] = "W";
                    }
                    else if (firstTeamScore < secondTeamScore) {
                        gamesResults[4] = "L";
                    }
                    else {
                        gamesResults[4] = "T";
                    }
                }

            }

            // This is the last 6th case, so update index 5
            else if (firstTeam == 3) {
                    if (firstTeamScore > secondTeamScore) {
                        gamesResults[5] = "W";
                    }
                    else if (firstTeamScore < secondTeamScore) {
                        gamesResults[5] = "L";
                    }
                    else {
                        gamesResults[5] = "T";
                    }
            }

        }

        // Create a List gamePossibilities, this is going to hold the number of possibilities
        // for each remaining game
        List<Integer> gamePossbilities = new ArrayList<>();

        // POssibilites are set to 3 (Win, Lose, Tie) if the game has not been nplayed yet,
        // For known game results, we set the possibility to 1. Since thats the only possible
        for (String value: gamesResults) {
            if (value.equals("f")) { // if it is "f" we still dont known
                gamePossbilities.add(3);
            } else {
                gamePossbilities.add(1);
            }
        }

        // Now we create another list called outcomePOssibties stores all possible outcomes of the
        // remaining games
        List<List<String>> outcomePossibilities = new ArrayList<>();

        // We use nested loops to iterate through each possible comibation of outcomes
        // based on the number of the possibles in gamePossibilities
        // six nested loop represent each six game
        for (int i = 0; i < gamePossbilities.get(0); i++) {
            for (int j = 0; j < gamePossbilities.get(1); j++) {
                for (int k = 0; k < gamePossbilities.get(2); k++) {
                    for (int l = 0; l < gamePossbilities.get(3); l++) {
                        for (int m = 0; m < gamePossbilities.get(4); m++) {
                            for (int n = 0; n < gamePossbilities.get(5); n++) {

                                // Create a list newPos represents a possible outcome
                                List<String> newPos = new ArrayList<>();
                                if (gamePossbilities.get(0) == 1) {
                                    // If their is only one possible outcome, append what we already know from gameresults
                                    newPos.add(gamesResults[0]);
                                }
                                // else, we consider all 3 possiblities
                                else if (i == 0) {
                                    newPos.add("W");
                                }
                                else if (i == 1) {
                                    newPos.add("L");
                                }
                                else if (i == 2) {
                                    newPos.add("T");
                                }

                                if (gamePossbilities.get(1) == 1) {
                                    newPos.add(gamesResults[1]);
                                }
                                else if (j == 0) {
                                    newPos.add("W");
                                }
                                else if (j == 1) {
                                    newPos.add("L");
                                }
                                else if (j == 2) {
                                    newPos.add("T");
                                }

                                if (gamePossbilities.get(2) == 1) {
                                    newPos.add(gamesResults[2]);
                                }
                                else if (k == 0) {
                                    newPos.add("W");
                                }
                                else if (k == 1) {
                                    newPos.add("L");
                                }
                                else if (k == 2) {
                                    newPos.add("T");
                                }

                                if (gamePossbilities.get(3) == 1) {
                                    newPos.add(gamesResults[3]);
                                }
                                else if (l == 0) {
                                    newPos.add("W");
                                }
                                else if (l == 1) {
                                    newPos.add("L");
                                }
                                else if (l == 2) {
                                    newPos.add("T");
                                }

                                if (gamePossbilities.get(4) == 1) {
                                    newPos.add(gamesResults[4]);
                                }
                                else if (m == 0) {
                                    newPos.add("W");
                                }
                                else if (m == 1) {
                                    newPos.add("L");
                                }
                                else if (m == 2) {
                                    newPos.add("T");
                                }

                                if (gamePossbilities.get(5) == 1) {
                                    newPos.add(gamesResults[5]);
                                }
                                else if (n == 0) {
                                    newPos.add("W");
                                }
                                else if (n == 1) {
                                    newPos.add("L");
                                }
                                else if (n == 2) {
                                    newPos.add("T");
                                }

                                outcomePossibilities.add(newPos);

                            }
                        }
                    }
                }
            }
        }

        int count = 0;
        for (List<String> outcome : outcomePossibilities) {
            if (winning(outcome, t)) {
                count++;
            }
        }

        System.out.println(count);

    }

    // Check if our faviorite Team is winning
    public static boolean winning(List<String> gamePossibilities, int teamT) {
        int[] scores = {0, 0, 0, 0}; // scores for each team

        if (gamePossibilities.get(0).equals("W")) {
            scores[0] += 3;
        } else if (gamePossibilities.get(0).equals("L")) {
            scores[1] += 3;
        } else {
            scores[0] += 1;
            scores[1] += 1;
        }

        if (gamePossibilities.get(1).equals("W")) {
            scores[0] += 3;
        } else if (gamePossibilities.get(1).equals("L")) {
            scores[2] += 3;
        } else {
            scores[0] += 1;
            scores[2] += 1;
        }

        if (gamePossibilities.get(2).equals("W")) {
            scores[0] += 3;
        } else if (gamePossibilities.get(2).equals("L")) {
            scores[3] += 3;
        } else {
            scores[0] += 1;
            scores[3] += 1;
        }

        if (gamePossibilities.get(3).equals("W")) {
            scores[1] += 3;
        } else if (gamePossibilities.get(3).equals("L")) {
            scores[2] += 3;
        } else {
            scores[1] += 1;
            scores[2] += 1;
        }

        if (gamePossibilities.get(4).equals("W")) {
            scores[1] += 3;
        } else if (gamePossibilities.get(4).equals("L")) {
            scores[3] += 3;
        } else {
            scores[1] += 1;
            scores[3] += 1;
        }

        if (gamePossibilities.get(5).equals("W")) {
            scores[2] += 3;
        } else if (gamePossibilities.get(5).equals("L")) {
            scores[3] += 3;
        } else {
            scores[2] += 1;
            scores[3] += 1;
        }

        if (scores[teamT - 1] == Arrays.stream(scores).max().getAsInt() && countOccurrences(scores, scores[teamT-1]) == 1) {
            return true;
        }

        else {
            return false;
        }
    }

    // This count how many times our favorite team T is inside the array
    public static int countOccurrences(int[] array, int element) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                count++;
            }
        }
        return count;
    }

}
