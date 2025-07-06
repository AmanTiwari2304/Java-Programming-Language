public class Disjoint {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    // initailization
    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x){ // find x means finding leader of x;
        if(par[x] == x){
            return x;
        }
        return par[x] = find(par[x]); // path compression
    }

    public static void union(int a, int b){
        // always leader(par) add with leader
        int parA = find(a);//leader of a
        int parB = find(b); //leader of b
        if (rank[parA] == rank[parB]) {
            par[parB] = parA; //joint b on a 
            rank[parA]++;
        }else if(rank[parA] < rank[parB]){
            par[parA] = parB; // joint a on b
        }else{
            par[parB] = parA; // joint b on a
        }
    }

    public static void main(String[] args) {
        init();
        union(1, 3);
        System.out.println("Find 3 : " + find(3));
        union(2, 4);
        System.out.println("Find 4 : " + find(4));
        union(3, 6);
        System.out.println("Find 6 : " + find(6));
        union(1, 4);
        System.out.println("Find 4 : " + find(4) + " Rank of 1 is " + rank[1]);
        union(1, 5);
        System.out.println("Find 5 : " + find(5));
    }
}
