package Graph.Part3;

import java.util.ArrayList;

public class PrintPath {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
        
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertices
        graph[0].add(new Edge(0, 3));

        // 2 vertices
        graph[2].add(new Edge(2, 3));

        // 3 vertices
        graph[3].add(new Edge(3, 1));

        // 4 vertices
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        // 5 vertices
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        
    }

    public static void printAllPath(ArrayList<Edge> graph[],int sc, int dt, String path){
        if (sc == dt) {
            System.out.println(path+dt);
        }
        for (int i = 0; i < graph[sc].size(); i++) {
            Edge e = graph[sc].get(i);
            printAllPath(graph, e.dest, dt, path+sc);
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph); 
        int sc = 5, dt = 1;
        String path = "";
        printAllPath(graph, sc, dt, path);

    }
}
