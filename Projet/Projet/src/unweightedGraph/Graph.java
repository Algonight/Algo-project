package unweightedGraph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    int vertices;

    public int getVertices() {
        return vertices;
    }

    List<List<Edge>> adjacencyList;

    public List<List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    public Graph(int vertices) {
        this.vertices = vertices;

        adjacencyList = new ArrayList<>();

        for (int i = 0; i < vertices; i++){
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);

        adjacencyList.get(source).add(edge);

        Edge edge2 = new Edge(destination, source, weight);

        adjacencyList.get(destination).add(edge2);
    }

    public void printGraph(){
        for(int i = 0; i < adjacencyList.size(); i++) {
            System.out.print("head : " + (i) );
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                System.out.print(" -> "+adjacencyList.get(i).get(j).getDestination());
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printGraphClustering(){
        System.out.println("\nClustering score");
        for(int i = 0; i < adjacencyList.size(); i++) {
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                if(adjacencyList.get(i).get(j).getDestination() > i)
                System.out.println(i + " : " + adjacencyList.get(i).get(j).getDestination() + " = " + adjacencyList.get(i).get(j).getClusteringScore());
            }
        }
    }
}