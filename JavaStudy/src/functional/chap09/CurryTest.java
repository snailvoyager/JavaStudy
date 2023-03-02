package functional.chap09;

import java.util.function.Function;
import java.util.function.Supplier;

public class CurryTest {
    public static void main(String[] args) {
        Supplier<String> supplier = getStringSupplier();    //method가 끝나더라도 변수는 남아있음
        System.out.println(supplier.get());

        Function<Integer, Function<Integer, Integer>>  curriedAdd = x -> y -> x + y;

        Function<Integer, Integer> addThree = curriedAdd.apply(3);
        int result = addThree.apply(10);
        System.out.println(result);
    }

    public static Supplier<String> getStringSupplier() {
        String hello = "Hello";
        Supplier<String> supplier = () -> {
            String world = "World";
            return hello + world;
        };
        return supplier;
    }
}
