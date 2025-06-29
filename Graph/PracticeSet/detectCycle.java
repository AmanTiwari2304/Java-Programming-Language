package Graph.PracticeSet;

import java.util.*;

import Graph.PracticeSet.detectCycle.Edge;
import Graph.PracticeSet.detectCycle.Pair;

// detect cycle using BFS
public class detectCycle {
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

        // 1 vertices
        graph[1].add(new Edge(1, 5));
        graph[1].add(new Edge(1, 9));

        // 2 vertices
        graph[2].add(new Edge(2, 4));
        graph[2].add(new Edge(2, 5));

        // 4 vertices
        graph[4].add(new Edge(4, 2));

        // 5 vertices
        graph[5].add(new Edge(5, 1));
        graph[5].add(new Edge(5, 2));
        graph[5].add(new Edge(5, 9));

        // 9 vertices
        graph[9].add(new Edge(9, 1));
        graph[9].add(new Edge(9, 5));

    }

    static class Pair {
        int node;
        int parent;

        public Pair(int n, int p){
            this.node = n;
            this.parent = p;
        }
        
    }

    public static boolean isCycle(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (bfs(graph, visited, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean bfs(ArrayList<Edge> graph[], boolean visited[], int curr){
        visited[curr] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(curr, -1));
        while (!q.isEmpty()) {
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.poll();

            for (int i = 0; i < graph[node].size(); i++) {
                Edge e = graph[node].get(i);
                if (!visited[e.dest]) {
                    visited[e.dest] = true;
                    q.add(new Pair(e.dest, node));
                }else{
                    if (e.dest != parent) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int V =  10;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V]; 
        createGraph(graph);

        System.out.println(isCycle(graph));
    }
}
