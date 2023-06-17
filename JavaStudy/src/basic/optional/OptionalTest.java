package basic.optional;

import java.util.*;

public class OptionalTest {

    public static void main(String[] args) {
        //Optional 생성
        Optional<String> optional = Optional.empty();   //빈 Optinal
        System.out.println(optional);   //Optional.empty
        System.out.println(optional.isPresent());   //false

        Optional<String> notNullOptinal = Optional.of("is not null");   //null이 아닌 경우. null 입력 시 NPE
        System.out.println(notNullOptinal.get());

        Optional<String> nullableOptional = Optional.ofNullable(null);  //null 일 수도 있는 경우
        nullableOptional = Optional.of("string");
        System.out.println(nullableOptional.orElse("is null"));

        //null 검사후 null 일 경우 새로운 객체 생성
        List<String> list = (List<String>) Optional.ofNullable(null).orElseGet(() -> new ArrayList<String>());

        //Primitive Optional
        OptionalInt optionalInt = OptionalInt.of(3);
        System.out.println(optionalInt.getAsInt());

        OptionalDouble optionalDouble = OptionalDouble.of(0.1);
        System.out.println(optionalDouble.getAsDouble());

        OptionalLong optionalLong = OptionalLong.of(1000L);
        System.out.println(optionalLong.getAsLong());

        Optional<String> optionalValue = Optional.of("Hello");
        optionalValue.ifPresent(value -> System.out.println("Value: " + value));    //값이 존재할 때 consumer 수행
    }
}
