import java.util.*;

public class BFS {
    private List<LinkedList<Integer>> adjList;

    public BFS(List<LinkedList<Integer>> adjList) {
        this.adjList = adjList;
    }

    public void bfs(int startVertex) {
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : adjList.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
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

        BFS bfs = new BFS(adjList);
        System.out.println("BFS starting from vertex 0:");
        bfs.bfs(0);
    }
}
