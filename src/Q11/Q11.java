package Q11;

import java.io.*;
import java.util.*;

///https://stackoverflow.com/questions/17480022/java-find-shortest-path-between-2-points-in-a-distance-weighted-map


public class Q11 {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            Map<String, TreeSet<DistanceTo>> graph = new HashMap<>();

            String line;
            String startCity = null;


            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String city1 = parts[0];
                String city2 = parts[1];
                int distance = Integer.parseInt(parts[2]);

                if (startCity == null) {
                    startCity = city1;
                }

                graph.putIfAbsent(city1, new TreeSet<>());
                graph.putIfAbsent(city2, new TreeSet<>());

                graph.get(city1).add(new DistanceTo(city2, distance));
                graph.get(city2).add(new DistanceTo(city1, distance));
            }

            br.close();


        }
}
