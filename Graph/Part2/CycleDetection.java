package Graph.Part2;

import java.util.ArrayList;

import Recursion.recursionAdvance;

public class CycleDetection {
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
        graph[2].add(new Edge(2, 4));

        // 3 vertices
        graph[3].add(new Edge(3, 0));

        // 4 vertices
        graph[4].add(new Edge(4, 2));
        
    }

    public static boolean detectCycle(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(graph, visited, i, -1)) {
                    return true; 
                    // return true if cycle exists in any part of the component
                }
            }
        }
         
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean visited[], int curr, int par){
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // Case 1: If already visited and not coming from parent, cycle exists
            if (visited[e.dest] && e.dest != par) {
                return true;
            }

            // Case 2: If not visited, continue DFS
            else if (!visited[e.dest]) {
                if (detectCycleUtil(graph, visited, e.dest, curr)) {
                    return true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int V =  5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V]; 
        createGraph(graph);

        System.out.println(detectCycle(graph));
    }
}
