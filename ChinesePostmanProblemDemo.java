import java.util.*;

class Graph {
    private int vertices;
    private int[][] adjMatrix;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    public void addEdge(int u, int v, int weight) {
        adjMatrix[u][v] = weight;
        adjMatrix[v][u] = weight; // Undirected graph
    }

    // Function to find all odd degree vertices
    private List<Integer> findOddDegreeVertices() {
        List<Integer> oddDegreeVertices = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            int degree = 0;
            for (int j = 0; j < vertices; j++) {
                if (adjMatrix[i][j] != 0) {
                    degree++;
                }
            }
            if (degree % 2 != 0) {
                oddDegreeVertices.add(i);
            }
        }
        return oddDegreeVertices;
    }

    // Function to find the shortest path between two vertices using Dijkstra's algorithm
    private int dijkstra(int start, int end) {
        int[] dist = new int[vertices];
        boolean[] visited = new boolean[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < vertices; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && adjMatrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + adjMatrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + adjMatrix[u][v];
                }
            }
        }

        return dist[end];
    }

    // Function to find the vertex with the minimum distance value
    private int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Function to solve the Chinese Postman Problem
    public int chinesePostman() {
        List<Integer> oddDegreeVertices = findOddDegreeVertices();

        if (oddDegreeVertices.isEmpty()) {
            // If there are no odd degree vertices, the graph already has an Eulerian circuit
            return eulerianCircuitWeight();
        }

        int minWeightSum = Integer.MAX_VALUE;

        // Generate all pairs of odd degree vertices
        for (int i = 0; i < oddDegreeVertices.size(); i += 2) {
            int u = oddDegreeVertices.get(i);
            for (int j = i + 1; j < oddDegreeVertices.size(); j++) {
                int v = oddDegreeVertices.get(j);
                int weight = dijkstra(u, v);

                // Try to pair u and v and check the total weight
                int weightSum = weight;
                List<Integer> pairedVertices = new ArrayList<>(oddDegreeVertices);
                pairedVertices.remove((Integer) u);
                pairedVertices.remove((Integer) v);

                for (int k = 0; k < pairedVertices.size(); k += 2) {
                    int a = pairedVertices.get(k);
                    int b = pairedVertices.get(k + 1);
                    weightSum += dijkstra(a, b);
                }

                minWeightSum = Math.min(minWeightSum, weightSum);
            }
        }

        // The result is the total weight of the Eulerian circuit plus the minimum weight sum of added edges
        return eulerianCircuitWeight() + minWeightSum;
    }

    // Function to calculate the total weight of the Eulerian circuit
    private int eulerianCircuitWeight() {
        int totalWeight = 0;
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (adjMatrix[i][j] != 0) {
                    totalWeight += adjMatrix[i][j];
                }
            }
        }
        return totalWeight / 2; // Since it's an undirected graph, each edge is counted twice
    }
}

public class ChinesePostmanProblemDemo {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 8);
        graph.addEdge(3, 4, 4);
        graph.addEdge(4, 0, 7);

        System.out.println("Minimum cost to cover all edges: " + graph.chinesePostman());
    }
}
