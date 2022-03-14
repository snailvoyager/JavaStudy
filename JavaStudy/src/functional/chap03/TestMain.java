package functional.chap03;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TestMain {
    public static void main(String[] args) {
        Function<Integer, Integer> myAdder = new Adder();       // 사용할 때마다 객체 생성해야함
        System.out.println(myAdder.apply(5));

        Function<Integer, Integer> addFunction = x -> x + 10;
        System.out.println(addFunction.apply(5));

        BiFunction<Integer, Integer, Integer> addBiFunction = (x, y) -> x + y;
        System.out.println(addBiFunction.apply(7,8));

        TriFunction<Integer, Integer, Integer, Integer> addTriFunction = (x, y, z) -> x + y + z;
        System.out.println(addTriFunction.apply(2, 3, 5));
    }
}
