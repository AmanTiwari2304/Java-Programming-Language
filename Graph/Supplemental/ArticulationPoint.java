package Graph.Supplemental;

import java.util.ArrayList;

public class ArticulationPoint {
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

    public static void dfs(ArrayList<Edge> graph[], boolean visited[], int dt[], int low[],
                            int time,  int curr, int par, boolean ap[]){
            visited[curr] = true;
            dt[curr] = low[curr] = ++time;
            int children = 0;
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                int neighbor = e.dest;

                if (neighbor == par) {
                    continue;
                }else if (visited[neighbor]) {
                    low[curr] = Math.min(low[curr], dt[neighbor]);
                }else{
                    dfs(graph, visited, dt, low, time, neighbor, curr, ap);
                    low[curr] = Math.min(low[curr], low[neighbor]);
                    if (par != -1 && dt[curr] <= low[neighbor]) {
                        ap[curr] = true;
                    }
                    children++;
                }
            }
            if (par == -1 && children > 1) {
                ap[curr] = true;
            }
        }

    public static void articulationPoint(ArrayList<Edge> graph[], int V){
        int time = 0; 
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean visited[] = new boolean[V];
        boolean ap[] = new boolean[V]; // Articulation point tracker
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
               dfs(graph, visited, dt, low, time, i, -1, ap); 
            }
        }

        for (int i = 0; i < V; i++) {
            if (ap[i]) {
               System.out.println("Articulation Point : " + i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        articulationPoint(graph, V);
    }
}
