//package SwappingSeats;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class Main {
//
//    public static void main(String[] args) {
//        String table = "";
//        try (InputStreamReader in = new InputStreamReader(System.in);
//             BufferedReader buffer = new BufferedReader(in)) {
//            table = buffer.readLine();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        int swaps = swapSeats(table);
//        System.out.println(swaps);
//    }
//
//    public static int swapSeats(String table) {
//        Map<Character, Integer> groupMap = new HashMap<>();
//        for (char c : table.toCharArray()) {
//            if (groupMap.containsKey(c)) {
//                groupMap.put(c, groupMap.get(c) + 1);
//            } else {
//                groupMap.put(c, 1);
//            }
//        }
//
//        boolean hasC = groupMap.containsKey('C');
//
//
//        int swaps = 0;
//        int swapStartPoint;
//        String mode = "";
//
//        if (hasC) {
//
//            char[] groupList = {'A', 'B', 'C'};
//            int[] startABC = getStartingPoint(groupMap, groupList, table); //0 = maxcount, 1 = index
//
//            groupList = new char[]{'A', 'C', 'B'};
//
//            int[] startACB = getStartingPoint(groupMap, groupList, table);
//            if (startABC[0] >= startACB[0]) {
//                swapStartPoint = startABC[1];
//                mode = "ABC";
//            } else {
//                swapStartPoint = startACB[1];
//                mode = "ACB";
//            }
//
//
//
//            return getSwap(groupMap, swapStartPoint, table, mode);
//        }
//        else {
//            char[] groupList = {'A', 'B'};
//            int[] startAB = getStartingPoint(groupMap, groupList, table); //0 = maxcount, 1 = index
//            swapStartPoint = startAB[1];
//
//            return getSwapAB(groupMap, swapStartPoint, table);
//
//        }
//    }
//
//    public static int getSwap(Map<Character, Integer> groupMap, int swapStartPoint, String table, String mode) {
//        int swaps = 0;
//        List<Character> aGroup, bGroup, cGroup;
//        //ABC Order
//        String bestString = (table + table).substring(swapStartPoint, swapStartPoint + table.length());
//        if (mode.equals("ABC")) {
//            int aStart = 0;
//            int aEnd = groupMap.get('A');
//            aGroup = bestString.substring(aStart, aEnd).chars().mapToObj(c -> (char) c).filter(c -> c!='A').collect(Collectors.toList());
//            int bStart = aEnd;
//            int bEnd = aEnd + groupMap.get('B');
//            bGroup = bestString.substring(bStart, bEnd).chars().mapToObj(c -> (char) c).filter(c -> c!='B').collect(Collectors.toList());
//            int cStart = bEnd;
//            int cEnd = bEnd + groupMap.get('C');
//            cGroup = bestString.substring(cStart, cEnd).chars().mapToObj(c -> (char) c).filter(c -> c!='C').collect(Collectors.toList());
//        }
//        else {
//            int aStart = 0;
//            int aEnd = groupMap.get('A');
//            aGroup = bestString.substring(aStart, aEnd).chars().mapToObj(c -> (char) c).filter(c -> c!='A').collect(Collectors.toList());
//            int cStart = aEnd;
//            int cEnd = aEnd + groupMap.get('C');
//            cGroup = bestString.substring(cStart, cEnd).chars().mapToObj(c -> (char) c).filter(c -> c!='C').collect(Collectors.toList());
//            int bStart = cEnd;
//            int bEnd = cEnd + groupMap.get('B');
//            bGroup = bestString.substring(bStart, bEnd).chars().mapToObj(c -> (char) c).filter(c -> c!='B').collect(Collectors.toList());
//        }
//
//        int aInB = 0;
//        int bInA = 0;
//        int cInA = 0;
//        int aInC = 0;
//
////        while ((aInB = bGroup.indexOf('A')) >-1  && (bInA = aGroup.indexOf('B')) > -1) {
//        while ((aInB = indexOf(bGroup, 'A', aInB)) >-1  && (bInA = indexOf(aGroup, 'B', bInA)) > -1) {
////            bGroup.remove(aInB);
////            bGroup.add('B');
//            bGroup.set(aInB, 'B');
////            aGroup.remove(bInA);
////            aGroup.add('A');
//            aGroup.set(bInA, 'A');
//            swaps++;
//        }
//
//
//         aInB = 0;
//         bInA = 0;
//         cInA = 0;
//         aInC = 0;
////        while ((aInC = cGroup.indexOf('A')) >-1  && (cInA = aGroup.indexOf('C')) > -1) {
//        while ((aInC = indexOf(cGroup, 'A', aInC)) >-1  && (cInA = indexOf(aGroup, 'C', cInA)) > -1) {
////            cGroup.remove(aInC);
////            cGroup.add('C');
//            cGroup.set(aInC, 'C');
////            aGroup.remove(cInA);
////            aGroup.add('A');
//            aGroup.set(cInA, 'A');
//            swaps++;
//        }
//
//        aInB = 0;
//        bInA = 0;
//        cInA = 0;
//        aInC = 0;
//
////        while ((aInB = bGroup.indexOf('A')) >-1  && (cInA = aGroup.indexOf('C')) > -1) {
//        while ((aInB = indexOf(bGroup, 'A', aInB)) >-1  && (cInA = indexOf(aGroup, 'C', cInA)) > -1) {
////            bGroup.remove(aInB);
////            bGroup.add('C');
//            bGroup.set(aInB, 'C');
//
////            aGroup.remove(cInA);
////            aGroup.add('A');
//            aGroup.set(cInA, 'A');
//            swaps++;
//        }
//
//        aInB = 0;
//        bInA = 0;
//        cInA = 0;
//        aInC = 0;
////        while ((aInC = cGroup.indexOf('A')) >-1  && (bInA = aGroup.indexOf('B')) > -1) {
//        while ((aInC = indexOf(cGroup, 'A', aInC)) >-1  && (bInA = indexOf(aGroup, 'B', bInA)) > -1) {
////            cGroup.remove(aInC);
////            cGroup.add('B');
//            cGroup.set(aInC, 'B');
//
////            aGroup.remove(bInA);
////            aGroup.add('A');
//            aGroup.set(bInA, 'A');
//            swaps++;
//        }
//
//        for (Character character : cGroup) {
//            if (character == 'B') {
//                swaps++;
//            }
//        }
//
//
//        return swaps;
//    }
//
//    public static int indexOf(List<Character> groupList, char character, int start) {
//        int index = -1;
//        for (int i = start; i < groupList.size(); i++) {
//            if (character == groupList.get(i)) {
//                index = i;
//                break;
//            }
//        }
//
//
//        return index;
//    }
//
//    public static int getSwapAB(Map<Character, Integer> groupMap, int swapStartPoint, String table) {
//
//        int swaps = 0;
//        //ABC Order
//        String bestString = (table + table).substring(swapStartPoint, swapStartPoint + table.length());
//        int aStart = 0;
//        int aEnd = groupMap.get('A');
//        List<Character> aGroup = bestString.substring(aStart, aEnd).chars().mapToObj(c -> (char) c).collect(Collectors.toList());
//        int bStart = aEnd;
//        int bEnd = aEnd + groupMap.get('B');
//        List<Character> bGroup = bestString.substring(bStart, bEnd).chars().mapToObj(c -> (char) c).collect(Collectors.toList());
//
//        for (Character character : aGroup) {
//            if (character == 'B') {
//                swaps++;
//            }
//        }
//
//
//        return swaps;
//    }
//
//
//    public static int[] getStartingPoint(Map<Character, Integer> groupMap, char[] groupList, String table) {
//        int max = 0;
//        char[] repeatedTable = (table + table).toCharArray();
//        int bestStartingPoint = 0;
//        int sum = 0;
//        for (int i = 0; i < table.length(); i++) {
//            int lastIndex = 0;
//
//            for (char groupLetter : groupList) {
//                int value = groupMap.get(groupLetter);
//
//                if (i == 0) {
//
//                    for (int j = lastIndex; j < lastIndex + value; j++) {
//                        if (repeatedTable[j + i] == groupLetter) {
//                            sum += 1;
//                        }
//                    }
//                }
//                else {
//                    char previousCharactacter = repeatedTable[lastIndex - 1 + i];
//                    char lastCharacter = repeatedTable[lastIndex + value - 1 + i];
//                    if (previousCharactacter != lastCharacter) {
//                        if (previousCharactacter == groupLetter) {
//                            sum--;
//                        }
//                        if (lastCharacter == groupLetter) {
//                            sum++;
//                        }
//                    }
//                }
//
//
//
//                lastIndex += value;
//
//            }
//
//            if (sum > max) {
//                max = sum;
//                bestStartingPoint = i;
//            }
//        }
//
//        return new int[]{max, bestStartingPoint};
//    }
//
//
//}
