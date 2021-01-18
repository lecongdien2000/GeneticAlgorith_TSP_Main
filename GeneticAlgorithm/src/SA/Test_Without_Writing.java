package SA;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Test_Without_Writing {
    public static void main(String[] args) throws IOException {
        File file = new File("dataset/eil51.tsp");
        ArrayList<City> cities;
        cities = new Map().readTest(file);
        Sa sa = new Sa();
        long time =  System.currentTimeMillis();
        System.out.println("Result: " + sa.sa(cities));
        System.out.println((System.currentTimeMillis() - time)/1000);
        System.out.println("2nd:");
        
        sa = new Sa();
        time =  System.currentTimeMillis();
        System.out.println("Result: " + sa.sa(cities));
        System.out.println((System.currentTimeMillis() - time)/1000);
       
 
    }
}
