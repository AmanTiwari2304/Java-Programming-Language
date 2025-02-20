package SortingWithRecursion;

public class sorting {
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int arr[], int si, int ei){
        if (si >= ei) {
            return;
        }
        // pivot = last element 
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx-1); //left
        quickSort(arr, pIdx+1, ei); //right
    }

    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1; //to make place for the element smaller than pivot 
        
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

            }
        }

        i++;
        // swap
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void mergeSort(int arr[], int si, int ei){
        // base 
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);

        merge(arr, si, mid, ei);
    } 

    // merging 
    public static void merge(int arr[], int si, int mid, int ei){
        int temp[] = new int [ei - si +1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= ei) {
        if (arr[i]<arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // leftover element of 1st sorted array
        while (i<=mid) {
            temp[k++] = arr[i++];
        }
        // leftover element of 2nd sorted array
        while (j<=ei) {
            temp[k++] = arr[j++];
        }

        // copying in original array
        for (k=0, i=si; k < temp.length; k++,i++) {
            arr[i] = temp[k];
        }

    }


    public static int sortedAndRotatedArray(int arr[], int tar, int si, int ei){
        // Base case
        if (si > ei) {
            return -1;
        }

        // kaam 
        int mid = si + (ei -si)/2; // (si+ei)/2

        // Case found
        if (arr[mid] == tar) {
            return mid;
        }

        // mid on L1 
        if (arr[si] <= arr[mid]) {
            // case a : Left
            if (arr[si] <= tar && tar <= arr[mid]) {
               return sortedAndRotatedArray(arr, tar, si, mid-1);
            }else{
                // case b : right
                return sortedAndRotatedArray(arr, tar, mid+1, ei);
            }
        } else {
            // mid on L2
            if (arr[mid] <= tar && tar <= arr[ei]) {
                // case  c : right
                return sortedAndRotatedArray(arr, tar, mid+1, ei);
            } else {
                // case d : Left
                return sortedAndRotatedArray(arr, tar, si, mid-1);
            }
            
        }

    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 8, 2, 5};
        // quickSort(arr, 0, arr.length -1);
        mergeSort(arr, 0, arr.length -1);
        printArr(arr);

        // int arr[] = {4, 5, 6, 7, 0, 1, 2};
        // int res = sortedAndRotatedArray(arr, 0 , 0, arr.length-1);//he have to return index
        // System.out.println(res);
    }
}
