package ComputerPurchase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    static class spec {
        String compName;
        int ram;

        public int getPerf() {
            return perf;
        }

        public void setPerf(int perf) {
            this.perf = perf;
        }

        int perf;


        public String getCompName() {
            return compName;
        }

        public int getRam() {
            return ram;
        }

        public int getCpuSpeed() {
            return cpuSpeed;
        }

        public int getDiskDrive() {
            return diskDrive;
        }

        int cpuSpeed;
        int diskDrive;

        public spec(String compName, int ram, int cpuSpeed, int diskDrive) {
            this.compName = compName;
            this.ram = ram;
            this.cpuSpeed = cpuSpeed;
            this.diskDrive = diskDrive;
        }

    }

    static class sortByPerf implements Comparator<spec> {
        public int compare(spec a, spec b) {
            return b.getPerf() - a.getPerf();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            return;
        }
        int count = n;
        int i = 0;
        spec[] computers = new spec[n];
        String line;
        while ((line = br.readLine()) != null && count > 0) {
            String[] s = line.split(" ");
           computers[i] = new spec(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
           i++;
           count--;
        }

        if (computers.length == 1) {
            System.out.println(computers[0].getCompName());
            return;
        }

        List<spec> topComputers = new ArrayList<>(2);
        topComputers.add(new spec("", -1, -1, -1));
        topComputers.add(new spec("", -1, -1, -1));
        for (int j = 1; j < computers.length; j++) {
            spec current = computers[j];
            spec prev = computers[j-1];
            int currentPerformance = (2*current.getRam()) + (3*current.getCpuSpeed()) + current.getDiskDrive();
            int previousPerformance = (2*prev.getRam()) + (3*prev.getCpuSpeed()) + prev.getDiskDrive();
            current.setPerf(currentPerformance);
            prev.setPerf(previousPerformance);
            boolean canFitCurrent = current.getPerf() > topComputers.get(0).getPerf() || current.getPerf() > topComputers.get(1).getPerf();
            boolean canFitPrev = prev.getPerf() > topComputers.get(0).getPerf() || prev.getPerf() > topComputers.get(1).getPerf();

            if (currentPerformance > previousPerformance && canFitCurrent) {
                if (currentPerformance > topComputers.get(0).getPerf()) {
                    topComputers.set(0, current);
                }
                else {
                    topComputers.set(1, current);
                }
                int index = topComputers.indexOf(current);
                topComputers.get(index).setPerf(currentPerformance);
            }
            else if (previousPerformance > currentPerformance && canFitPrev) {
                if (previousPerformance > topComputers.get(0).getPerf()) {
                    topComputers.set(0, prev);
                }
                else {
                    topComputers.set(1, prev);
                }
                int index = topComputers.indexOf(prev);
                topComputers.get(index).setPerf(previousPerformance);
            }
            else if (currentPerformance == previousPerformance) {
                if (prev.getCompName().compareTo(current.getCompName()) > 0 && canFitPrev) {
                    if (previousPerformance > topComputers.get(0).getPerf()) {
                        topComputers.set(0, prev);
                    }
                    else {
                        topComputers.set(1, prev);
                    }
                    int index = topComputers.indexOf(prev);
                    topComputers.get(index).setPerf(previousPerformance);
                }
                else if (canFitCurrent) {
                    if (currentPerformance > topComputers.get(0).getPerf()) {
                        topComputers.set(0, current);
                    }
                    else {
                        topComputers.set(1, current);
                    }

                        int index = topComputers.indexOf(current);
                    topComputers.get(index).setPerf(currentPerformance);
                }
            }
        }

        Collections.sort(topComputers, new sortByPerf());

        for (spec topComputer : topComputers) {
            System.out.println(topComputer.getCompName());
        }
    }
}
