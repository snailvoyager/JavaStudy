package functional.chap04;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> myStringSupplier = () -> "hello world";
        System.out.println(myStringSupplier.get());     //get()이 단 하나의 abstract method

        Supplier<Double> myRandomDoubleSupplier = () -> Math.random();
        System.out.println(myRandomDoubleSupplier.get());
        System.out.println(myRandomDoubleSupplier.get());
        System.out.println(myRandomDoubleSupplier.get());

        printRandomDoubles(myRandomDoubleSupplier, 3);      //1급객체로 함수의 매개변수로 넘길 수 있다
    }

    public static void printRandomDoubles(Supplier<Double> randomSupplier, int count) {
        for (int i=0; i<count; i++) {
            System.out.println(randomSupplier.get());
        }
    }
}
