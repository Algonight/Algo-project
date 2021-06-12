package bfs;

import unweightedGraph.Edge;
import unweightedGraph.Graph;

import java.util.*;

public class BFSShortestPaths {
    private static Queue<Integer> stack;
    private List<Integer> path;
    private boolean[] visited;
    private int[] previous;

    public List<Integer> bfs(Graph G, int start, int goal){
        int vertices = G.getVertices();
        List<List<Edge>> adjacencyList = G.getAdjacencyList();

        visited = new boolean[vertices];
        previous = new int[vertices];
        Arrays.fill(previous, -1);
        stack = new ArrayDeque<>();
        path = new ArrayList<>();

        visited[start] = true;
        stack.add(start);

        while(stack.size() != 0){
            int v = stack.poll();

            for (Edge edge : adjacencyList.get(v)){
                int n = edge.getDestination();
                if (!visited[n]){
                    visited[n] = true;
                    previous[n] = v;
                    stack.add(n);
                }
                if (n == goal){
                    path.add(n);
                    while (previous[n] != -1){
                        path.add(0, previous[n]);
                        n = previous[n];
                    }
                    return path;
                }
            }
        }
        return null;
    }
}
