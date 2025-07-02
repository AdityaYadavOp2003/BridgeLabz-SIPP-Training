package JavaConstructor.Level1;

import java.util.Scanner;

public class Circle {
    double radius;
    public Circle(){
        this(4);
    }
    public Circle(double radius){
        this.radius=radius;
    }
    void displayChainConstructor(){
        System.out.println(radius);
    }

    public static void main(String[] args) {
        Circle c1=new Circle();
        Circle c2=new Circle(88.9);
        c1.displayChainConstructor();
        c2.displayChainConstructor();

    }
}
