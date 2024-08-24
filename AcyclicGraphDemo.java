import java.util.*;

class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Integer> adjList[]; // Adjacency List

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    public void addEdge(int source, int destination) {
        adjList[source].add(destination); // Add destination to source's list
    }

    // Function to perform Topological Sort
    public void topologicalSort() {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        // Mark all vertices as not visited (Initially)
        for (int i = 0; i < vertices; i++) {
            visited[i] = false;
        }

        // Call the recursive helper function to store Topological Sort
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Print the contents of the stack (which is the topological order)
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    // A recursive function used by topologicalSort
    private void topologicalSortUtil(int vertex, boolean[] visited, Stack<Integer> stack) {
        // Mark the current node as visited
        visited[vertex] = true;

        // Recur for all the vertices adjacent to this vertex
        for (Integer neighbor : adjList[vertex]) {
            if (!visited[neighbor]) {
                topologicalSortUtil(neighbor, visited, stack);
            }
        }

        // Push the current vertex to the stack which stores the result
        stack.push(vertex);
    }

    // Function to print the adjacency list
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Integer neighbor : adjList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

public class AcyclicGraphDemo {
    public static void main(String[] args) {
        // Create a graph with 6 vertices
        Graph graph = new Graph(6);

        // Add edges to the graph
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        // Print the adjacency list representation of the graph
        graph.printGraph();

        System.out.println("Topological Sort of the graph:");
        graph.topologicalSort();
    }
}
