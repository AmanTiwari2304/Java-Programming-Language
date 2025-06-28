package Graph.Part3;

import java.util.ArrayList;
import java.util.Stack;

import Graph.Part3.TopologicalSorting.Edge;

public class TopologicalSorting {
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

    public static void topSort(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topSortUtil(graph, i, visited, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> s){
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topSortUtil(graph, e.dest, visited, s);
            }
            
        }
        s.push(curr);
    }


    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }
}
