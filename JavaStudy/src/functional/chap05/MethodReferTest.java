package functional.chap05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferTest {
    public static void main(String[] args) {
        Function<String, Integer> str2int = Integer::parseInt;
        int num = str2int.apply("5");
        System.out.println(num);

        String str = "hello";
        Predicate<String> equalsToHello = str::equals;
        boolean helloEqualsWorld = equalsToHello.test("world");
        System.out.println(helloEqualsWorld);

        System.out.println(calculate(8, 2, (x, y) -> x + y));
        System.out.println(calculate(8, 2, MethodReferTest::multiply));     //static method

        MethodReferTest instance = new MethodReferTest();
        System.out.println(calculate(8, 2, instance::subtract));        //instance method

        instance.myMethod();


        Function<String, Integer> strLength = String::length;
        int length = strLength.apply("hello world");            //instance를 parameter로 넘겨 method를 실행
        System.out.println(length);

        BiPredicate<String, String> strEquals = String::equals;
        System.out.println(strEquals.test("hello", "world"));

        List<User> users = new ArrayList<>();
        users.add(new User(3, "Alice"));
        users.add(new User(1, "Charlie"));
        users.add(new User(2, "Bob"));
        //printUserField(users, (User user) -> user.getId());
        printUserField(users, User::getId);


        BiFunction<Integer, String, User> userCreator = User::new;      //생성자를 바로 지정
        System.out.println(userCreator.apply(3, "Charlie"));

        String[][] inputs = new String[][] {
                {"sedan", "sonata", "hyundai"},
                {"van", "sienna", "toyota"},
                {"sedan", "model s", "tesla"},
                {"suv", "sorrent", "kia"}
        };

        Map<String, BiFunction<String, String, Car>> carTypeToConstructorMap = new HashMap<>();
        carTypeToConstructorMap.put("sedan", Sedan::new);
        carTypeToConstructorMap.put("van", Van::new);
        carTypeToConstructorMap.put("suv", Suv::new);

        List<Car> cars = new ArrayList<>();
        for (int i=0; i<inputs.length; i++) {
            String[] input = inputs[i];
            String carType = input[0];
            String name = input[1];
            String brand = input[2];

            cars.add(carTypeToConstructorMap.get(carType).apply(name, brand));      //carType 별로 객체 생성
        }

        for(Car car : cars) {
            car.drive();
        }
    }

    public static int calculate(int x, int y, BiFunction<Integer, Integer, Integer> operator) {
        return operator.apply(x, y);
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public int subtract (int x, int y) {
        return x - y;
    }

    public void myMethod() {
        System.out.println(this.calculate(10, 3, this::subtract));       //instance method 내에서도 호출 가능
    }

    public static void printUserField(List<User> users, Function<User, Object> getter) {
        for (User user : users) {
            System.out.println(getter.apply(user));
        }
    }
}
