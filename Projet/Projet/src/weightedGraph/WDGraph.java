package weightedGraph;
import java.util.ArrayList;
import java.util.List;

public class WDGraph {
    int vertices;

    public int getVertices() {
        return vertices;
    }

    List<List<DirectedEdge>> adjacencyList;

    public List<List<DirectedEdge>> getAdjacencyList() {
        return adjacencyList;
    }

    public WDGraph(int vertices) {
        this.vertices = vertices;

        adjacencyList = new ArrayList<>();

        for (int i = 0; i < vertices; i++){
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, double weight) {
        DirectedEdge edge = new DirectedEdge(source, destination, weight);

        adjacencyList.get(source).add(edge);

        DirectedEdge edge2 = new DirectedEdge(destination, source, weight);

        adjacencyList.get(destination).add(edge2);
    }

    public void printGraph(){
        for(int i = 0; i < adjacencyList.size(); i++) {
            System.out.print("head : " + (i) );
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                System.out.print(" -> "+adjacencyList.get(i).get(j).to() + " with : " + adjacencyList.get(i).get(j).weight());
            }
            System.out.println();
        }
        System.out.println();
    }
}