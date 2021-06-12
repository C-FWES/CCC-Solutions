package ComputerPurchase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
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
            int perf = (2*Integer.parseInt(s[1])) + (3*Integer.parseInt(s[2])) + Integer.parseInt(s[3]);
            computers[i].setPerf(perf);
            i++;
            count--;
        }

        if (computers.length == 1) {
            System.out.println(computers[0].getCompName());
            return;
        }

        spec first = computers[0];
        spec second = computers[1];
        int firstPerf;
        int secondPerf;
        String firstChoiceName = first.getCompName(); //fastest
        String secondChoiceName = second.getCompName(); // secondPlace
        firstPerf = first.getPerf();
        secondPerf = second.getPerf();
        if (firstPerf <= secondPerf) {
            if (firstPerf == secondPerf) {
                if (firstChoiceName.compareTo(secondChoiceName) > 0) {
                    spec temp = first;
                    first = second;
                    second = temp;
                }
            }
            else {
                spec temp = first;
                first = second;
                second = temp;
            }
        }

        for (int j = 2; j < computers.length; j++) {
            spec current = computers[j];
            int currentPerformance = current.getPerf();
            secondPerf = second.getPerf();
            firstPerf = first.getPerf();
            String currentCompName = current.getCompName();
            firstChoiceName = first.getCompName();
            secondChoiceName = second.getCompName();
            int temp = -1;
            spec tempComp;

            if (currentPerformance >= secondPerf) {
                if (currentPerformance >= firstPerf) {
                    if (currentPerformance == firstPerf) {
                        if (firstChoiceName.compareTo(currentCompName) > 0) {
                            tempComp = first;
                            first = current;
                            second = tempComp;
                        }
                        else {
                            second = current;
                        }
                    }
                    else {
                        tempComp = first;
                        first = current;
                        second = tempComp;
                    }
                }
                else {
                    if (currentPerformance == secondPerf) {
                        if (secondChoiceName.compareTo(currentCompName) > 0) {
                            second = current;
                        }
                    }
                    else {
                        second = current;
                    }
                }
            }

        }

        System.out.println(first.getCompName());
        System.out.println(second.getCompName());
    }


}
