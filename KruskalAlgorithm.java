import java.util.*;

class Edge implements Comparable<Edge> {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // Comparator function used for sorting edges based on their weight
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class Graph {
    int vertices;
    List<Edge> allEdges = new ArrayList<>();

    public Graph(int vertices) {
        this.vertices = vertices;
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        allEdges.add(edge);
    }

    public void kruskalMST() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));

        // Add all edges to the priority queue
        pq.addAll(allEdges);

        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        List<Edge> mst = new ArrayList<>();

        // Process vertices - 1 edges
        int index = 0;
        while (index < vertices - 1) {
            Edge edge = pq.remove();
            int x_set = find(parent, edge.source);
            int y_set = find(parent, edge.destination);

            // Check if the selected edge is creating a cycle or not
            if (x_set != y_set) {
                mst.add(edge);
                index++;
                union(parent, x_set, y_set);
            }
        }

        // Print the MST
        System.out.println("Minimum Spanning Tree:");
        for (int i = 0; i < mst.size(); i++) {
            Edge edge = mst.get(i);
            System.out.println("Edge: " + edge.source + " - " + edge.destination + " with weight: " + edge.weight);
        }
    }

    // Function to find the parent of a vertex
    public int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex)
            return find(parent, parent[vertex]);
        return vertex;
    }

    // Function to perform union of two subsets
    public void union(int[] parent, int x, int y) {
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);
        parent[y_set_parent] = x_set_parent;
    }
}

public class KruskalAlgorithm {
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

        graph.kruskalMST();
    }
}
