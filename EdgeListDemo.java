import java.util.ArrayList;
import java.util.List;

// Edge class to represent an edge between two vertices
class Edge {
    int source;
    int destination;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }
}

// Graph class that holds a list of edges
class Graph {
    private List<Edge> edgeList; // List of edges
    private int vertices; // Number of vertices

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        edgeList = new ArrayList<>();
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        // Validate the vertices
        if (source < 0 || source >= vertices || destination < 0 || destination >= vertices) {
            System.out.println("Error: Invalid edge between " + source + " and " + destination);
            return;
        }
        Edge edge = new Edge(source, destination);
        edgeList.add(edge);
    }

    // Method to print all edges in the graph
    public void printGraph() {
        System.out.println("Edge List:");
        for (Edge edge : edgeList) {
            System.out.println("Source: " + edge.source + " -> Destination: " + edge.destination);
        }
    }

    // Method to get the list of edges
    public List<Edge> getEdgeList() {
        return edgeList;
    }
}

public class EdgeListDemo {
    public static void main(String[] args) {
        // Create a graph with 5 vertices
        Graph graph = new Graph(5);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Print the edge list representation of the graph
        graph.printGraph();
    }
}
