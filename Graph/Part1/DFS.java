package Graph.Part1;

import java.util.ArrayList;

import Graph.Part1.AdjacencyList.Edge;

public class DFS {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
        
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 vertices
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1 vertices
        graph[1].add(new Edge(1, 1, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2 vertices
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3 vertices
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4 vertices
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5 vertices
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6 vertices
        graph[6].add(new Edge(6, 5, 1));

    }

    public static void dfs(ArrayList<Edge> graph[],boolean visited[], int curr){
        visited[curr] = true;
        System.out.println(curr);

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfs(graph, visited, e.dest);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[], boolean visited[], int sc, int dt){
        visited[sc] = true;
        // Base Case
        if (sc == dt) {
            return true;
        }

        for (int i = 0; i < graph[sc].size(); i++) {
           Edge e = graph[sc].get(i);
           if (!visited[e.dest] && hasPath(graph, visited, e.dest, dt)) {
                return true;
            } 
        }

        return false;
    } 
    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean visited[] = new boolean[graph.length];
        int source = 0;
        // dfs(graph, visited, source);

        int sc = 0, dt = 5;
        System.out.println(hasPath(graph, visited, sc, dt));
    }
}
