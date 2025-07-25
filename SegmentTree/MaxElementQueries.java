package SegmentTree;

public class MaxElementQueries {
    static int tree[];

    public static void init(int n){
        tree = new int[4*n];
    }

    public static int buildST(int arr[], int segIdx, int start, int end){ //o(n)
        if(start == end){
            return tree[segIdx] = arr[start];
        }
        
        int mid = (start + end)/2;
        int left = buildST(arr, 2*segIdx+1, start, mid);
        int right = buildST(arr, 2*segIdx+2, mid+1, end);

        return tree[segIdx] = Math.max(left,right);
    }

    public static int maxSumUtil(int segIdx, int si, int sj, int qi, int qj){
        if (qj < si || qi > sj) {// no overlap
            return Integer.MIN_VALUE;
        }

        else if (si >= qi && sj <= qj) {// complete overlap
            return tree[segIdx];
        }

        else{
            int mid = (si+sj)/2;
            int left = maxSumUtil(2*segIdx+1, si, mid, qi, qj);
            int right = maxSumUtil(2*segIdx+2, mid+1, sj, qi, qj);
            tree[segIdx] = Math.max(left, right);
            return tree[segIdx];
        }

    }

    public static int maxSum(int arr[], int qi, int qj){// O(logn)
        int n = arr.length;
        return maxSumUtil(0, 0, n-1, qi, qj);
    }

    public static void updateUtil(int segIdx, int si, int sj, int idx, int newVal){
        if (idx < si || idx > sj) {
            return;
        }

        tree[segIdx] = Math.max(tree[segIdx], newVal);

        if (si != sj) {
            int mid = (si+sj)/2;
            updateUtil(2*segIdx+1, si, mid, idx, newVal);
            updateUtil(2*segIdx+2, mid+1, sj, idx, newVal);
        }
    }


    public static void update(int arr[], int idx, int newVal){
        int n = arr.length;
        arr[idx] = newVal; 
        
        updateUtil(0, 0, n-1, idx, newVal);

    }
    public static void main(String[] args) {
        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;
        init(n);
        System.out.println(buildST(arr, 0, 0, n-1));

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        System.out.println("Max Sum between index 3 to 7 is : "+ maxSum(arr, 3, 7));

        update(arr, 2, 20);

        System.out.println("Max Sum between index 1 to 7 is : "+ maxSum(arr, 1, 7));


    }
}
