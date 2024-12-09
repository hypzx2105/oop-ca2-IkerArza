import java.util.*;
import java.io.File;

                                         ///***Resources***///

///https://docs.oracle.com/javase/8/docs/api/
/// https://www.baeldung.com/java-dijkstra
/// https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/



public class Q11 {
    public static void main(String[] args) {
        String file = "Map.txt";
        Map<String, List<Map.Entry<String, Integer>>> map = new HashMap<>();

        try {
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(" ");
                String c1 = line[0];
                String c2 = line[1];
                int d = Integer.parseInt(line[2]);

                map.putIfAbsent(c1, new ArrayList<>());
                map.putIfAbsent(c2, new ArrayList<>());

                map.get(c1).add(new AbstractMap.SimpleEntry<>(c2, d));
                map.get(c2).add(new AbstractMap.SimpleEntry<>(c1, d));
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file);
            return;
        }

        String start = map.keySet().iterator().next();
        System.out.println("Starting from: " + start);

        Map<String, Integer> shortest = findShortest(map, start);

        System.out.println("Shortest distances:");
        for (String city : shortest.keySet()) {
            System.out.println(city + ": " + shortest.get(city));
        }
    }

    private static Map<String, Integer> findShortest(Map<String, List<Map.Entry<String, Integer>>> map, String start) {
        Map<String, Integer> dist = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        pq.add(new AbstractMap.SimpleEntry<>(start, 0));

        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> curr = pq.poll();
            String city = curr.getKey();
            int d = curr.getValue();

            if (!dist.containsKey(city)) {
                dist.put(city, d);
                for (Map.Entry<String, Integer> neighbor : map.getOrDefault(city, new ArrayList<>())) {
                    if (!dist.containsKey(neighbor.getKey())) {
                        pq.add(new AbstractMap.SimpleEntry<>(neighbor.getKey(), d + neighbor.getValue()));
                    }
                }
            }
        }
        return dist;
    }
}

