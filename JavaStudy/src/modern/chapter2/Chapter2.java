package modern.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Chapter2 {
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) {   //색으로 필터링
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterGreenApplesByColor(List<Apple> inventory, Color color) {    //색을 파라미터화
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterGreenApplesByWeight(List<Apple> inventory, int weight) {    //무게로 필터링
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {   //필터링 부분만 제외하고 중복되는 코드
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory, Color color, int weight) {    //모든 속성을 파라미터 추가
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight
                    && color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {    //컬렉션을 반복하는 로직과 각 요소에 적용할 동작을 분리
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    List<Apple> redApples = filter(inventory, (Apple apple) -> RED.equals(apple.getColor()));   //메서드에 코드/동작 전달하기
    List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);
}
