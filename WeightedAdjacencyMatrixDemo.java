import java.util.Arrays;

class WeightedGraph {
    private int[][] adjMatrix;
    private int vertices;

    // Constructor
    public WeightedGraph(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];

        // Initialize the matrix with a large value to represent no edge
        for (int[] row : adjMatrix) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
    }

    // Add a weighted edge
    public void addEdge(int source, int destination, int weight) {
        adjMatrix[source][destination] = weight;
        adjMatrix[destination][source] = weight; // For undirected graph
    }

    // Remove an edge
    public void removeEdge(int source, int destination) {
        adjMatrix[source][destination] = Integer.MAX_VALUE;
        adjMatrix[destination][source] = Integer.MAX_VALUE; // For undirected graph
    }

    // Print the adjacency matrix
    public void printGraph() {
        System.out.println("Adjacency Matrix with Weights:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (adjMatrix[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(adjMatrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

public class WeightedAdjacencyMatrixDemo {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(5);

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 5);
        graph.addEdge(1, 2, 6);
        graph.addEdge(1, 3, 15);
        graph.addEdge(1, 4, 7);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 11);

        graph.printGraph();
    }
}
