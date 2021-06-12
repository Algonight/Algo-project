package graphClustering;

import bfs.BFSShortestPaths;
import unweightedGraph.Edge;
import unweightedGraph.Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphClustering {

    public static void printAllShortestPaths(Graph G){

        List<List<Integer>> pathList = new ArrayList<>();
        BFSShortestPaths bfsShortestPaths = new BFSShortestPaths();
        int vertices = G.getVertices();

        for (int i = 0; i < vertices; i++ ) {
            for (int j = i + 1; j < vertices; j++) {
                List<Integer> currentPath = bfsShortestPaths.bfs(G, i, j);
                pathList.add(currentPath);
                System.out.print("source : " + i + " destination : " + j + " -> ");
                System.out.println(currentPath);
            }
        }
        setClusteringScore(G, pathList);
        G.printGraphClustering();
    }

    public static void setClusteringScore(Graph G, List<List<Integer>> pathList){
        List<List<Edge>> adjacencyList = G.getAdjacencyList();
        for(List<Integer> path : pathList){
            for(int i = 1; i < path.size(); i++){
                int source = path.get(i - 1);
                int dest = path.get(i);
                for (Edge edge : adjacencyList.get(source)){
                    if (edge.isThisEdge(dest)){
                        edge.addClusteringScore();
                    }
                }
            }
        }
    }

}
