import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Edge {
    int destination;
    int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

class WeightedGraphList {
    private List<List<Edge>> adjList;
    private int vertices;

    public WeightedGraphList(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        adjList.get(source).add(new Edge(destination, weight));
        // Uncomment the next line if the graph is undirected
        // adjList.get(destination).add(new Edge(source, weight));
    }

    public void printGraph() {
        System.out.println("Adjacency List with Weights:");
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge edge : adjList.get(i)) {
                System.out.print("-> " + edge.destination + " (Weight: " + edge.weight + ") ");
            }
            System.out.println();
        }
    }
}

public class WeightedGraphListDemo {
    public static void main(String[] args) {
        WeightedGraphList graph = new WeightedGraphList(5);

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
