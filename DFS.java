import java.util.*;

public class DFS {
    private List<LinkedList<Integer>> adjList;

    public DFS(List<LinkedList<Integer>> adjList) {
        this.adjList = adjList;
    }

    public void dfs(int startVertex) {
        boolean[] visited = new boolean[adjList.size()];
        dfsRecursive(startVertex, visited);
    }

    private void dfsRecursive(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        List<LinkedList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adjList.add(new LinkedList<>());
        }

        adjList.get(0).add(1);
        adjList.get(0).add(4);
        adjList.get(1).add(2);
        adjList.get(2).add(3);
        adjList.get(3).add(4);

        DFS dfs = new DFS(adjList);
        System.out.println("DFS starting from vertex 0:");
        dfs.dfs(0);
    }
}
