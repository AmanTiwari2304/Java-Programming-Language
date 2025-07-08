package Graph.Supplemental;

import java.util.*;


public class TarjanBridgeAlgo {
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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // 1 vertices
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));         

        // 2 vertices
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        // 3 vertices
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        // 4 vertices
        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // 5 vertices
        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));

    }

    public static void dfs(ArrayList<Edge> graph[], boolean visited[], int curr, int par, 
                            int dt[], int low[], int time){
        
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neighbor = e.dest;

            if (neighbor == par) {
                continue;
            }else if (!visited[neighbor]) {
                dfs(graph, visited, neighbor, curr, dt, low, time);
                low[curr] = Math.min(low[curr], low[neighbor]);
                if (dt[curr] < low[neighbor]) {
                    System.out.println("Bridge from " + e.src + " --- " + e.dest);
                }
            }else{
                low[curr] = Math.min(low[curr], dt[neighbor]);
            }
        }
    }

    public static void tarjanBridgeAlgo(ArrayList<Edge> graph[], int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i, -1,  dt, low, time);
            }
        }
     }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        tarjanBridgeAlgo(graph, V);
    }
}
