package functional.chap04;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {

        Consumer<String> myStringConsumer = str -> System.out.println(str);     //Consumer는 return이 아니더라도 한줄로 표현 가능하면 중괄호 생략 가능
        myStringConsumer.accept("hello");

        List<Integer> integerInputs = Arrays.asList(4, 2 ,3);
        Consumer<Integer> myIntegerProcessor = x -> System.out.println("Processing Integer " + x);
        process(integerInputs, myIntegerProcessor);

        Consumer<Integer> mydifferentIntegerProcessor = x ->
                System.out.println("Processing Integer in different way " + x); //함수는 수정하지 않고 매개변수의 Consumer를 변화하여 다양한 로직 구현 가능
        process(integerInputs, mydifferentIntegerProcessor);

        Consumer<Double> myDoubleProcessor = x -> System.out.println("Processing Double " + x);
        List<Double> doubleInputs = Arrays.asList(1.1, 2.2, 3.3);
        process(doubleInputs, myDoubleProcessor);
    }

    public static <T> void process(List<T> inputs, Consumer<T> processor) {
        for(T input : inputs) {
            processor.accept(input);
        }
    }
}
