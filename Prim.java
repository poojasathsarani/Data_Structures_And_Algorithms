import java.util.*;

public class Prim {
    private int numVertices;
    private int[][] graph;

    public Prim(int[][] graph) {
        this.numVertices = graph.length;
        this.graph = graph;
    }

    public void prim() {
        boolean[] inMST = new boolean[numVertices];
        int[] key = new int[numVertices];
        int[] parent = new int[numVertices];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];

            inMST[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (graph[u][v] > 0 && !inMST[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                    pq.add(new int[]{v, key[v]});
                }
            }
        }

        System.out.println("Edges in the Minimum Spanning Tree:");
        for (int i = 1; i < numVertices; i++) {
            System.out.println(parent[i] + " - " + i + ": " + graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        Prim prim = new Prim(graph);
        prim.prim();
    }
}
