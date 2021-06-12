package weightedGraph;

import java.util.Comparator;

public class Node implements Comparator<Node> {
    public int node;
    public double cost;

    public Node(){

    }

    public Node(int node, double cost){
        this.node = node;
        this.cost = cost;
    }


    @Override
    public int compare(Node v1, Node v2) {
        if (v1.cost < v2.cost)
            return -1;
        if (v1.cost > v2.cost)
            return 1;
        return 0;
    }
}
