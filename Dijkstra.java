import java.util.*;

public class Dijkstra {
    private int numVertices;
    private int[][] graph;

    public Dijkstra(int[][] graph) {
        this.numVertices = graph.length;
        this.graph = graph;
    }

    public void dijkstra(int startVertex) {
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{startVertex, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0];
            int distance = current[1];

            if (visited[vertex]) continue;
            visited[vertex] = true;

            for (int i = 0; i < numVertices; i++) {
                if (graph[vertex][i] > 0 && !visited[i]) {
                    int newDist = distance + graph[vertex][i];
                    if (newDist < distances[i]) {
                        distances[i] = newDist;
                        pq.add(new int[]{i, newDist});
                    }
                }
            }
        }

        System.out.println("Shortest distances from vertex " + startVertex + ":");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("To vertex " + i + ": " + distances[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 0, 0, 20},
            {10, 0, 30, 0, 0},
            {0, 30, 0, 40, 0},
            {0, 0, 40, 0, 50},
            {20, 0, 0, 50, 0}
        };

        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.dijkstra(0);
    }
}
