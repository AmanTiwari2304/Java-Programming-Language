package Graph.PracticeSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MotherVertex {
    static class Edge {
        int src;
        int dest;
        
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
        
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static int motherVertex(ArrayList<Edge> graph[], int V){
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            boolean visited[] = new boolean[V];
            if (helper(graph, q, visited, i)) {
                return i;
            }
            
        }
        return -1;
    }

    public static boolean helper(ArrayList<Edge> graph[], Queue<Integer> q, boolean visited[], int source){
        q.add(source);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    if (!visited[e.dest]) {
                        q.add(e.dest);
                    }
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println("Mother Vertex of this graph is : " + motherVertex(graph, V));
    }
}
