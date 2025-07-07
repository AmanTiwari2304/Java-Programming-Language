package Graph.PracticeSet;

import java.util.ArrayList;

public class UnionFind {
    static int n = 10;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }

    public static int find(int x){
        if (par[x] == x) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        }else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        }else{
            par[parB] = parA;
        }
    }

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph){
        graph.add(new Edge(1, 5));
        graph.add(new Edge(1, 9));
        graph.add(new Edge(2, 5));
        graph.add(new Edge(2, 7));
        graph.add(new Edge(5, 1));
        graph.add(new Edge(5, 2));
        graph.add(new Edge(5, 9));
        graph.add(new Edge(7, 2));
        graph.add(new Edge(9, 1));
    }

    public static boolean isCycle(ArrayList<Edge> graph ){
        init();
        for (int i = 0; i < graph.size(); i++) {
            Edge e = graph.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);

            if (parA == parB) {
                return true;
            }
            else{
                union(e.src, e.dest);
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int V = 10;
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);
        System.out.println(isCycle(graph));
    }

}
