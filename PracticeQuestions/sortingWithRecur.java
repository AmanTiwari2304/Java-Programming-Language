import java.util.*;
public class sortingWithRecur {
    public static void printStr(String[] str){
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]+ " ");
        }
    }

    public static void mergeSortString(String[] str, int si, int ei){
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si)/2;
        mergeSortString(str, si, mid);
        mergeSortString(str, mid+1, ei);
        mergeString(str, si, mid, ei);
    }

    public static void mergeString(String[] str, int si, int mid, int ei){
        String[] temp = new String[ei - si + 1];
        int i = si;
        int j = mid+1; 
        int k = 0;

        while (i<= mid && j <= ei) {
            if (str[i].compareTo(str[j]) <= 0) {
                temp[k] = str[i];
                i++;
            }else{
                temp[k] = str[j];
                j++;
            }
            k++;
        }

        while (i<= mid) {
            temp[k++] = str[i++];
        }

        while (j <= ei) {
            temp[k++] = str[j++];
        }

        for(k=0, i=si; k<temp.length; k++, i++){
            str[i] = temp[k];
        }
          
    }

    // Brute Force approach :
    public static int majorityElement(int arr[]){
        int n = arr.length;
        int majorityCount = n/2;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == arr[i]) {
                    count += 1;
                }
            }
            if (count > majorityCount) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int mostFrequentNumber(int arr[]){
        Arrays.sort(arr);
        int maxFreq = 1;
        int currentFreq = 1;
        int maxElement = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                currentFreq ++;
                
            }else{
                currentFreq = 1;
            }
            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
                maxElement = arr[i];
            }
        }
        return maxElement;
    }

    public static void main(String[] args) {
        // String[] str = {"sun", "earth", "mars", "mercury"};
        // mergeSortString(str, 0, str.length-1);
        // printStr(str);

        // number of time each nuumber occurs 
        int arr[] = {2, 1, 2, 1, 2, 2, 3, 3, 1 ,4, 4};
        // System.out.println("The element in majority is : " + majorityElement(arr));
        System.out.println("The most frequent element is : " + mostFrequentNumber(arr));
    }
}
