import java.util.*;

class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
        adjList[destination].add(source); // Undirected graph
    }

    // Function to check if the graph is connected
    private boolean isConnected() {
        boolean[] visited = new boolean[vertices];
        int i;
        for (i = 0; i < vertices; i++) {
            if (adjList[i].size() != 0) {
                break;
            }
        }

        if (i == vertices) {
            return true; // No edges in the graph, trivially connected
        }

        DFS(i, visited);

        for (i = 0; i < vertices; i++) {
            if (!visited[i] && adjList[i].size() > 0) {
                return false; // If we find a non-visited vertex with edges, the graph is not connected
            }
        }
        return true;
    }

    // Depth First Search (DFS) for connectivity
    private void DFS(int v, boolean[] visited) {
        visited[v] = true;
        for (int i : adjList[v]) {
            if (!visited[i]) {
                DFS(i, visited);
            }
        }
    }

    // Function to count vertices with odd degrees
    private int getOddDegreeVertexCount() {
        int oddCount = 0;
        for (int i = 0; i < vertices; i++) {
            if (adjList[i].size() % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount;
    }

    // Function to check if the graph is non-Eulerian
    public void checkNonEulerian() {
        if (!isConnected()) {
            System.out.println("Graph is not connected. It is non-Eulerian.");
            return;
        }

        int oddCount = getOddDegreeVertexCount();

        if (oddCount == 0) {
            System.out.println("Graph has an Eulerian Circuit.");
        } else if (oddCount == 2) {
            System.out.println("Graph has an Eulerian Path.");
        } else {
            System.out.println("Graph is non-Eulerian.");
        }
    }
}

public class NonEulerianGraphDemo {
    public static void main(String[] args) {
        Graph graph1 = new Graph(5);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 4);
        graph1.addEdge(4, 1);
        graph1.addEdge(1, 2);
        graph1.checkNonEulerian(); // Should print: Graph is non-Eulerian.

        Graph graph2 = new Graph(5);
        graph2.addEdge(0, 1);
        graph2.addEdge(1, 2);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 4);
        graph2.checkNonEulerian(); // Should print: Graph has an Eulerian Path.

        Graph graph3 = new Graph(5);
        graph3.addEdge(0, 1);
        graph3.addEdge(1, 2);
        graph3.addEdge(2, 0);
        graph3.addEdge(0, 3);
        graph3.addEdge(3, 4);
        graph3.addEdge(4, 0);
        graph3.checkNonEulerian(); // Should print: Graph has an Eulerian Circuit.
    }
}
