package unweightedGraph;

public class Edge {
    int source;
    int destination;
    int weight;
    int clusteringScore;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.clusteringScore = 0;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public void addClusteringScore() {
        this.clusteringScore += 1;
    }

    public int getClusteringScore(){
        return this.clusteringScore;
    }

    public boolean isThisEdge(int dest) {
        return dest == destination;
    }
}
