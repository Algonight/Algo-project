
import java.util.*;

public class DijkstraSP {
    boolean[] marked;
    int[] previous;
    double[] distance;
    WDgraph G; // the graph
    int s; // the start node

    DijkstraSP(WDgraph G, int s){
        this.G = G;
        this.s = s;
        this.marked = new boolean[G.getNb_of_nodes()];
        this.previous = new int[G.getNb_of_nodes()];
        this.distance = new double[G.getNb_of_nodes()];


        if(verifyNonNegative()){
            this.DijkstraSP();
        }
        else{
            System.out.println("Error, some weight are negative.");
        }
    }

    public boolean verifyNonNegative(){
        for(int i = 0; i< this.G.nb_of_nodes; i++){
            LinkedList<DirectedEdge> list = this.G.adjList[i];
            for(int j = 0; j < list.size(); j++){
                 if(list.get(j).weight() < 0){
                     return false;
                 }
            }
        }
        return true;
    }

    class Pair implements Comparable<Pair> { // pour utiliser Priority queue dans dijkstra, il  faut un classe qui implémente comparable
        Double weight;
        Integer vertex;

        public Pair(Integer vertex, Double weight) {
            this.weight = weight;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Pair o) {
            return (int)((o.weight)*100);
        }
    }

    public void DijkstraSP(){
        for(int i = 0 ; i < distance.length; i++){
            this.distance[i]  = Double.MAX_VALUE;; //pour symoboliser l'infini
        }
        this.distance[this.s] = 0;

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(); // PriorityQueue is ordering the items by weight. It is a good tool for the Dijkstra algorithm.

        priorityQueue.add(new Pair(this.s, distance[this.s]));

        this.marked[s] = true;

        while(!priorityQueue.isEmpty()){
            int actualVertex = priorityQueue.poll().vertex;

            for(DirectedEdge edge : G.getAdgList(actualVertex)){
                int v = edge.to();

                if(!marked[v])
                {
                    double newDistance = this.distance[actualVertex] + edge.weight();

                    if( newDistance < this.distance[v] ){
                        priorityQueue.remove(v);
                        this.distance[v] = newDistance;
                        this.previous[v] = actualVertex;
                        priorityQueue.add(new Pair(v, distance[v]));
                    }
                }
            }
            marked[actualVertex] = true;
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public double distTo(int v){
        return distance[v];
    }

    Deque<Integer> printSP(int node){
        //prints the shortest path from s to v

        if (hasPathTo(node)) { //si pas de chemin on arrête
            Deque<Integer> stack = new ArrayDeque<Integer>();

            int actual_node = node;

            while(distance[actual_node] != 0){
                stack.addFirst(actual_node);
                actual_node = previous[actual_node];
            }


            stack.addFirst(this.s);
            System.out.println("Shortest path (Dikstra): " + stack + " / total weight = " + distance[node]);
            return stack;
        }
        else{
            return null;
        }
    }

}
