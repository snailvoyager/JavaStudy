package functional.chap09;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluationTest {
    public static void main(String[] args) {
        if (returnTrue() || returnFalse()) {    //뒤에 함수 미실행
            System.out.println("true");
        }

        if (or(returnTrue(), returnFalse())) {  //둘다 실행
            System.out.println("true2");
        }

        if (lazyOr(() -> returnTrue(), () -> returnFalse())) {  //첫번째만 실행
            System.out.println("true3");
        }

        Stream<Integer> integerStream = Stream.of(3, -2, 5, 8, -3, 10)
                .filter(x -> x > 0)
                .peek(x -> System.out.println("peeking " + x))  //종결 처리에서 한번에 처리
                .filter(x -> x % 2 == 0);
        System.out.println("Before collect");

        List<Integer> integers = integerStream.collect(Collectors.toList());
        System.out.println("After collect : " + integers);
    }

    public static boolean lazyOr(Supplier<Boolean> x, Supplier<Boolean> y) {
        return x.get() || y.get();
    }
    public static boolean or(boolean x, boolean y) {
        return x || y;
    }

    public static boolean returnTrue() {
        System.out.println("Returning true");
        return true;
    }

    public static boolean returnFalse() {
        System.out.println("Returning false");
        return false;
    }
}
