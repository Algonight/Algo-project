package graphClustering;

import bfs.BFSShortestPaths;
import tools.ReadFile;
import unweightedGraph.Graph;

public class Main {
    public static void main(String[] args) {
        ReadFile rd = new ReadFile();
        Graph G = rd.initializeGraphFromImport("graph.txt");
        G.printGraph();

        GraphClustering.printAllShortestPaths(G);
    }
}
