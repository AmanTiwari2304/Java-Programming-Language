package OOPS;

public class OOPS {

    public static void main(String[] args) {
        // Pen p1 = new Pen(); // created a pen object called p1
        // p1.setColor("blue");
        // System.out.println(p1.getColor());
        // p1.setTip(5);
        // System.out.println(p1.tip);
        // // p1.setColor("Yellow");
        // p1.color = "Yellow";
        // System.out.println(p1.color);

        // BankAccount user1 = new BankAccount();
        // user1.username = "AmanTiwari" ;
        // user1.setPassword("abcdeffg");
        // System.out.println(user1.username);

        // Dog dobby = new Dog();
        // dobby.isEat();
        // dobby.legs = 4;
        // System.out.println(dobby.legs);


        // Calculator calc = new Calculator();
        // System.out.println(calc.sum(5, 6));
        // System.out.println(calc.sum((float)5.3, (float)6.6));
        // System.out.println(calc.sum(5, 6, 6));


        // Car Tata = new Car();
        // Tata.run();
        // Tata.fuel();

        // Bike Hero = new Bike();
        // Hero.run();
        // Hero.fuel(); 

        // FlyingCars jagota = new FlyingCars();
        // Vehicle -> Cars -> FlyingCar

        Queen q = new Queen();
        q.moves();
    }
    
}

 class BankAccount {
    public String username;
    private String password;
    public void setPassword(String pwd){
        password = pwd;
    }
    
}

class Pen  {
    String color;
    int tip;

    String getColor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }

    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip){
        tip = newTip;
    }
}

class Student {
    String name;
    int age;
    float percentage;

    void calcPercentage(int phy, int chem, int math) {
        percentage = (phy + chem + math) / 3;
    }
}

// Base Class
class Animal {
    String color;

    void isEat(){
        System.out.println("Yes eats");
    }

    void isBreathe(){
        System.out.println("Yes breathe");
    }
}

// Derived Class  
class Fish extends Animal{
    int fins;

    void swim(){
        System.out.println("Swimming is there main properties");
    }
}

class Mammal extends Animal{
    int legs;
}

class Dog extends Mammal{
    String breed;
}


// Method Overloading 
class Calculator {
    int sum (int a, int b){
        return a + b; 
    }

    float sum (float a, float b){
        return a + b;
    }

    int sum (int a, int b, int c){
        return a + b + c; 
    }
}

// Abstract Class :-
abstract class Vehicle{

    Vehicle(){
        System.out.println("Vehicle constructor called");
    }
    void run() {  // Non Abstract method (function)
        System.out.println("All vehicle should run"); //Implementation of this function
    }

    abstract void fuel(); //We don't add implementation of this funtion and it's neccassary to add it in all the dereived class
    
}

class Car extends Vehicle{

    Car(){
        System.out.println("Car Constructor called");
    }
    @Override
    void fuel() {
        System.out.println("Mostly With Disel");
    }
}

class FlyingCars extends Car{
    FlyingCars(){
        System.out.println("Flying Car Constructor called");
    }
}

class Bike extends Vehicle{
    @Override
    void fuel() {
        System.out.println("They use Petrol");
    }
}

// InterFace 

interface chessPlayer {
    void moves();
   
}

class Queen implements chessPlayer {
    public void moves() {
        System.out.println("Left, Right, Up, Down, Diagonal (in all 4 directions ) ");
    }
}

class Rook implements chessPlayer {
    public void moves() {
        System.out.println("Left, Right, Up, Down,  ) ");
    }
}

class King implements chessPlayer {
    public void moves() {
        System.out.println("Left, Right, Up, Down, Diagonal -(One Step) ");
    }
}

