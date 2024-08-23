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

    // Function to remove an edge from the graph
    private void removeEdge(int source, int destination) {
        adjList[source].remove((Integer) destination);
        adjList[destination].remove((Integer) source);
    }

    // Function to count vertices reachable from 'v' using DFS
    private int DFSCount(int v, boolean[] visited) {
        visited[v] = true;
        int count = 1;
        for (int adj : adjList[v]) {
            if (!visited[adj]) {
                count += DFSCount(adj, visited);
            }
        }
        return count;
    }

    // Function to check if edge u-v is a valid next edge in Eulerian path or circuit
    private boolean isValidNextEdge(int u, int v) {
        // Count the number of vertices reachable from u
        int count1 = DFSCount(u, new boolean[vertices]);

        // Remove edge u-v and count vertices reachable from u
        removeEdge(u, v);
        int count2 = DFSCount(u, new boolean[vertices]);

        // Add the edge back to the graph
        addEdge(u, v);

        // If removing the edge reduces the number of reachable vertices, it is a bridge
        return count1 == count2;
    }

    // Function to print Eulerian path or circuit using Fleury's algorithm
    public void printEulerianPathOrCircuit() {
        // Start at a vertex with an odd degree (if any) or any vertex if all have even degrees
        int u = 0;
        for (int i = 0; i < vertices; i++) {
            if (adjList[i].size() % 2 != 0) {
                u = i;
                break;
            }
        }

        // Print the Eulerian path or circuit
        printEulerianPathOrCircuitUtil(u);
        System.out.println();
    }

    // Recursive function to print Eulerian path or circuit starting from vertex u
    private void printEulerianPathOrCircuitUtil(int u) {
        for (int i = 0; i < adjList[u].size(); i++) {
            int v = adjList[u].get(i);

            // If edge u-v is not a bridge, include it in the path
            if (isValidNextEdge(u, v)) {
                System.out.print(u + "-" + v + " ");
                removeEdge(u, v);
                printEulerianPathOrCircuitUtil(v);
            }
        }
    }
}

public class FleuryAlgorithmDemo {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);

        System.out.println("Eulerian Path or Circuit:");
        graph.printEulerianPathOrCircuit();
    }
}
