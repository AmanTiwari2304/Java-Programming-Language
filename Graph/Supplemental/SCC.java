package Graph.Supplemental;

import java.util.ArrayList;
import java.util.Stack;

public class SCC {
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
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // 1 vertices
        graph[1].add(new Edge(1, 0));        

        // 2 vertices
        graph[2].add(new Edge(2, 1));

        // 3 vertices
        graph[3].add(new Edge(3, 4));

    }

    public static void topSort(ArrayList<Edge> graph[], boolean visited[], Stack<Integer> s, int curr){
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topSort(graph, visited, s, e.dest);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> transpose[], boolean visited[], int curr){
        visited[curr] = true;
        System.out.print(curr+" ");

        for (int i = 0; i < transpose[curr].size(); i++) {
            Edge e = transpose[curr].get(i);
            if (!visited[e.dest]) {
                dfs(transpose, visited, e.dest);
            }
        }
    }

    public static void kosarajuAlgo(ArrayList<Edge> graph[], int V){
        // Step 1 :- Topological sorting
        boolean visited[] = new boolean[V];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topSort(graph, visited, s, i);
            }
        }

        // Step 2 : Transpose graph
        @SuppressWarnings("unchecked")
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            visited[i] = false; // make visited array false so that we can reuse it
            transpose[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3 : Dfs
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!visited[curr]) {
                System.out.println();
                dfs(transpose, visited, curr);
            }
        }

        
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        kosarajuAlgo(graph, V);
    }
}
