package BitManipulation;

public class BitManipulation {
    public static void basicsOfBit(){
        System.out.println(2&3);
        System.out.println(5|6);
        System.out.println(3^9);
        System.out.println(~5);
        System.out.println(~0);
        System.out.println(5<<2);
        System.out.println(6>>1);
    }

    public static void oddOrEven(int n) {
        int bitMask = 1;
        if ((n & bitMask )== 0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitMask = 1<<i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i){
        int bitMask = 1<<i;
        return (n | bitMask);
    }

    public static int clearIthBit(int n, int i){
        int bitMask = 1<<i;
        return (n & ~bitMask);
    }

    public static int updateIthBit(int n, int i, int newBit){
        if (newBit == 0) {
            return clearIthBit(n, i);
        } else {
            return setIthBit(n, i);
        }
    }

    public static int clearIBits(int n, int i){
        int bitMask = -1<<i;
        return n&bitMask;
    }

    public static int clearRangeOfBits(int n, int i, int j){
        int bitMask = ((~0)<<(j+1)) | ((1<<i) -1) ;
        return n&bitMask;
    }

    public static boolean isPowerOfTwo(int n){
        return (n & (n-1)) == 0;
    }
    
    public static int countSetBits(int n){
        int count = 0 ;
        while (n > 0) {
            if((n & 1) != 0){ // check LSB
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int fastExpo(int a, int n) {
        int ans = 1;

        while (n > 0) {
            if ((n & 1) != 0) {
               ans = ans * a; 
            }
            a = a * a;
            n = n>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        // basicsOfBit();
        // oddOrEven(5);
        // System.out.println(getIthBit(10, 2));
        // System.out.println(setIthBit(10, 2));
        // System.out.println(clearIthBit(10, 1));
        // System.out.println(updateIthBit(10, 3, 0));
        // System.out.println(clearIBits(15, 2));
        // System.out.println(clearRangeOfBits(10, 2, 5));
        // System.out.println(isPowerOfTwo(8));
        // System.out.println(countSetBits(15));
        System.out.println(fastExpo(5,3));
    }
}
