package WhichAlien;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int antenae = Integer.parseInt(br.readLine());
        int eyes = Integer.parseInt(br.readLine());
        List<String> possible = new ArrayList<>();
        //Troy: 3-n, 1-4
        //Vlad: 1-6, 2-n
        //Graeme: 1-2, 1-3
        if (antenae >= 3 && eyes <= 4){
            System.out.println("TroyMartian");
        }
        if (antenae <= 6 && eyes >= 2){
            System.out.println("VladSaturnian");
        }
        if (antenae <= 2 && eyes <= 3){
            System.out.println("GraemeMercurian");
        }

    }
}
