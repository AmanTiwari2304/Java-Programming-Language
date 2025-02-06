public class BitManipulation {
    public static void swappingTwoNumber(){
        int x = 3 , y = 4;
        System.out.println("The value of x = " + x + " and y = " + y + " before swapping");
        x = x^y ; 
        y = x^y ;
        x = x^y ;
        System.out.println("The value of x = " + x + " and y = " + y + " after swapping");
    }

    public static void questionOnNegation(){
        int  x = 6;
        System.out.println(x+" + "+1+" is "+-~x);
        x = -4; 
        System.out.println(x+" + "+1+" is "+-~x);
        x = 0;
        System.out.println(x+" + "+1+" is "+-~x);
    }

    public static void uppercaseToLowercase(){
        for(char ch='A'; ch<='Z'; ch++) {
            System.out.print((char)(ch|' '));
            // prints abcdefghijklmnopqrstuvwxyz
        }
    }

    public static void main(String[] args) {
        // swappingTwoNumber();
        // questionOnNegation();
        uppercaseToLowercase();
    }
}
