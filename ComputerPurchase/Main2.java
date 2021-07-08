package ComputerPurchase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static class Spec {
        String compName;
        int ram;
        int cpuSpeed;
        int diskDrive;
        int perf;

        public int getPerf() {
            return perf;
        }

        public void setPerf(int perf) {
            this.perf = perf;
        }


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

        public Spec(String compName, int ram, int cpuSpeed, int diskDrive) {
            this.compName = compName;
            this.ram = ram;
            this.cpuSpeed = cpuSpeed;
            this.diskDrive = diskDrive;
            this.perf = (2 * ram) + (3 * cpuSpeed) + diskDrive;
        }

        public boolean greaterThan(Spec other) {
            return this.perf > other.getPerf() || this.perf == other.getPerf() && this.compName.compareTo(other.getCompName()) > 0;
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
        Spec[] computers = new Spec[n];
        String line;
        while ((line = br.readLine()) != null && count > 0) {
            String[] s = line.split(" ");
            int ram = Integer.parseInt(s[1]);
            int cpuSpeed = Integer.parseInt(s[2]);
            int diskDrive = Integer.parseInt(s[3]);
            computers[i] = new Spec(s[0], ram, cpuSpeed, diskDrive);
            i++;
            count--;
        }

        if (computers.length == 1) {
            System.out.println(computers[0].getCompName());
            return;
        }

        Spec first = computers[0];
        Spec second = computers[1];

        if (second.greaterThan(first)) {
            Spec temp = first;
            first = second;
            second = temp;
        }


        for (int j = 2; j < computers.length; j++) {
            Spec current = computers[j];
            int temp = -1;
            Spec tempComp;

            if (current.greaterThan(first)) {
                tempComp = first;
                first = current;
                second = tempComp;
            } else if (current.greaterThan(second)) {
                second = current;

            }
        }


        System.out.println(first.getCompName());
        System.out.println(second.getCompName());
    }


}
