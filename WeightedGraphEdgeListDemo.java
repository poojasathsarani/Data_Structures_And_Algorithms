import java.util.ArrayList;
import java.util.List;

class WeightedEdge {
    int source;
    int destination;
    int weight;

    public WeightedEdge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class WeightedGraphEdgeList {
    private List<WeightedEdge> edgeList;
    private int vertices;

    public WeightedGraphEdgeList(int vertices) {
        this.vertices = vertices;
        edgeList = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight) {
        // Validate the vertices
        if (source < 0 || source >= vertices || destination < 0 || destination >= vertices) {
            System.out.println("Error: Invalid edge between " + source + " and " + destination);
            return;
        }
        Edge edge = new Edge(source, destination, weight);
        edgeList.add(edge);
    }

    public void printGraph() {
        System.out.println("Edge List with Weights:");
        for (WeightedEdge edge : edgeList) {
            System.out.println("Source: " + edge.source + " -> Destination: " + edge.destination + " (Weight: " + edge.weight + ")");
        }
    }
}

public class WeightedGraphEdgeListDemo {
    public static void main(String[] args) {
        WeightedGraphEdgeList graph = new WeightedGraphEdgeList(5);

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
