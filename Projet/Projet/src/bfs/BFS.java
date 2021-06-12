package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import unweightedGraph.*;

public class BFS {

    private static Queue<Integer> stack = new ArrayDeque<>();
    private static final String name = "BFS";

    public List<Integer> bfs(Graph G, int startingNode){

        int vertices = G.getVertices();
        List<List<Edge>> adjacencyList = G.getAdjacencyList();

        List<Integer> path = new ArrayList<>();
        boolean visited[] = new boolean[vertices];

        visited[startingNode] = true;
        stack.add(startingNode);
        path.add(startingNode);

        while (stack.size()!=0){
            int v = stack.poll();

            for (Edge edge : adjacencyList.get(v)){
                //Get the connected node and explore it if not already visited
                int n = edge.getDestination();
                if(!visited[n]){
                    visited[n] = true;
                    stack.add(n);
                    path.add(n);
                }
            }
        }
        return path;
    }

    public int cc(Graph G){
        //TODO à revoir
        return 0;
    }

    public String getName() {
        return name;
    }
}
