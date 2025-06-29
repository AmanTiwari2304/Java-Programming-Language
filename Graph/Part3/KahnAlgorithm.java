package Graph.Part3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnAlgorithm {
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
    public static void calIndeg(ArrayList<Edge> graph[], int indeg[]){
        for (int i = 0; i < indeg.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length]; 
        calIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }
}
