package tools;

import unweightedGraph.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    private List<List<Integer>> intDatas = new ArrayList<>();
    private List<List<Double>> doubleDatas = new ArrayList<>();

    public List<List<Integer>> readUnweightedGraph(String filePath) {
        try {
            //Read file and interprets the data as a graph
            File graph = new File("src/"+filePath);
            Scanner sc = new Scanner(graph);

            while(sc.hasNextLine()) {
                String data = sc.nextLine();
                String number[] = data.split(" ");
                int u = Integer.parseInt(number[0]);
                int v = Integer.parseInt(number[1]);

                List<Integer> dataInts = new ArrayList<Integer>();
                dataInts.add(u);
                dataInts.add(v);

                this.intDatas.add(dataInts);
            }
            sc.close();
            return this.intDatas;
        }catch (FileNotFoundException e) {
            System.out.println("File not existing");
            e.printStackTrace();
        }
        return null;
    }

    public List<List<Double>> readWeightedGraph(String filePath) {
        try {
            //Read file and interprets the data as a graph
            File graph = new File("src/"+filePath);
            Scanner sc = new Scanner(graph);

            while(sc.hasNextLine()) {
                String data = sc.nextLine();
                String number[] = data.split(" ");
                double u = Double.parseDouble(number[0]);
                double v = Double.parseDouble(number[1]);
                double w = Double.parseDouble(number[2]);

                List<Double> dataInts = new ArrayList<Double>();
                dataInts.add(u);
                dataInts.add(v);
                dataInts.add(w);

                this.doubleDatas.add(dataInts);
            }
            sc.close();
            return this.doubleDatas;
        }catch (FileNotFoundException e) {
            System.out.println("File not existing");
            e.printStackTrace();
        }
        return null;
    }

    public Graph initializeGraphFromImport(String filePath) {

        //Get the datas of the file with ReadFile class
        ReadFile rd = new ReadFile();
        List<List<Integer>> datas = rd.readUnweightedGraph(filePath);
        System.out.println(datas);

        //Get the number of nodes of the graph
        int vertices = 0;
        for (List<Integer> ints : datas) {
            for (int i : ints) {
                if (i > vertices) {
                    vertices = i;
                }
            }
        }
        vertices++; //Add one because we work with 0


        System.out.println("Number of elements in the graph : " + vertices);
        Graph G = new Graph(vertices);

        //Add all the edges in the graph
        for (List<Integer> ints : datas) {
            int u = ints.get(0);
            int v = ints.get(1);
            G.addEdge(u, v, 1);
        }

        return G;
    }
}
