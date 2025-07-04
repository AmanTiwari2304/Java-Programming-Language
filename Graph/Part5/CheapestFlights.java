package Graph.Part5;

import java.util.*;

public class CheapestFlights {
    static class Edge{
        int node;
        int wt;

        public Edge(int n, int wt){
            this.node = n;
            this.wt = wt;
        }
    }

    static class Info{
        int src;
        int cost;
        int stop;

        public Info(int src, int cost, int stop){
            this.src = src;
            this.cost = cost;
            this.stop = stop;
        }
    }
    
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // step 1 : create arraylist
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(v, wt);
            adj.get(u).add(e);
        }

        // initialize distance
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        // Queue creation
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stop > k){
                break;
            }
            int u = curr.src;
            for(Edge neighbor : adj.get(u)){
                int v = neighbor.node;
                int wt = neighbor.wt;

                if(curr.cost + wt < dist[v] && curr.stop <= k){
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stop+1));
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }

        return dist[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int flight[][] = {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}};
        int src = 0, dst = 3, k=1;
        System.out.println("Cheapest Flight price : = " + findCheapestPrice(n, flight, src, dst, k));
    }
}
