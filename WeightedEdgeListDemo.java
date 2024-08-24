import java.util.ArrayList;
import java.util.List;

// Edge class to represent an edge between two vertices with a weight
class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

// Graph class that holds a list of weighted edges
class Graph {
    private List<Edge> edgeList; // List of edges
    private int vertices; // Number of vertices

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        edgeList = new ArrayList<>();
    }

    // Method to add a weighted edge to the graph
    public void addEdge(int source, int destination, int weight) {
        // Validate the vertices
        if (source < 0 || source >= vertices || destination < 0 || destination >= vertices) {
            System.out.println("Error: Invalid edge between " + source + " and " + destination);
            return;
        }
        Edge edge = new Edge(source, destination, weight);
        edgeList.add(edge);
    }

    // Method to print all edges in the graph
    public void printGraph() {
        System.out.println("Edge List with Weights:");
        for (Edge edge : edgeList) {
            System.out.println("Source: " + edge.source + " -> Destination: " + edge.destination + " (Weight: " + edge.weight + ")");
        }
    }

    // Method to get the list of edges
    public List<Edge> getEdgeList() {
        return edgeList;
    }
}

public class WeightedEdgeListDemo {
    public static void main(String[] args) {
        // Create a graph with 5 vertices
        Graph graph = new Graph(5);

        // Add weighted edges to the graph
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 5);
        graph.addEdge(1, 2, 6);
        graph.addEdge(1, 3, 15);
        graph.addEdge(1, 4, 7);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 11);

        // Print the edge list representation of the graph with weights
        graph.printGraph();
    }
}
