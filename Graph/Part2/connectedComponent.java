package Graph.Part2;

import java.util.*;

import Graph.Part2.connectedComponent.Edge;

public class connectedComponent {
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

        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 2, 1));

        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        
    }

    public static void dfsUtil(ArrayList<Edge> graph[], boolean visited[], int curr){
        visited[curr] = true;
        System.out.println(curr);

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfsUtil(graph, visited, e.dest);
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfsUtil(graph, visited, i);
            }
        } 
    }

    public static void bfsUtil(ArrayList<Edge> graph[], boolean visited[], int source){
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!visited[curr]) {
                visited[curr] = true;
                System.out.println(curr);
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void bfs(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                bfsUtil(graph, visited, i);
            }
        }
    }
    public static void main(String[] args) {
        int N = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[N];
        createGraph(graph);
        // dfs(graph);
        bfs(graph);
        
    }
}
