package collection;

import java.util.HashMap;
import java.util.Map;

public class MapDefaultMethod {
    public static void main(String[] args) {
        Map<String, Integer> ageOfFriends = Map.of("A", 27, "B", 21, "C", 25);

        for(Map.Entry<String, Integer> entry : ageOfFriends.entrySet()) {
            String friend = entry.getKey();
            Integer age = entry.getValue();
            System.out.println(friend + " is " + age + " years old.");
        }

        ageOfFriends.forEach((friend, age) -> System.out.println(friend + " is " + age + " years old."));

        ageOfFriends
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey().reversed()) //키를 기준으로 내림차순
                .forEachOrdered(System.out::println);

        System.out.println(ageOfFriends.getOrDefault("D", 0));  //키가 없으면 기본 값 반환

        Map<String, Integer> map = new HashMap<>();
        int value = map.computeIfAbsent("A", key -> 1); //키가 없으면 새로운 값으로 추가
        System.out.println(value);
        System.out.println(map.computeIfAbsent("A", key -> 2)); //키가 존재하면 기존 값 반환

        System.out.println(map.computeIfPresent("A", (k, v) -> 3)); //키가 존재하면 새로운 값으로 추가
        System.out.println(map.computeIfPresent("B", (k, v) -> 4)); //키가 null이 아닐 때만 새로운 값 계산
        System.out.println(map);    //{A=3}

        System.out.println(map.compute("C", (k, v) -> 5));  //제공된 키로 새로운 값 계산하여 추가
        System.out.println(map);    //{A=3, C=5}
        System.out.println(map.compute("C", (k, v) -> 7));
        System.out.println(map);    //{A=3, C=7}

        map.remove("C");    //키가 존재하면 키를 삭제
        System.out.println(map);    //{A=3}

        map.remove("A", 2);     //값이 일치할 때 삭제
        System.out.println(map);    //{A=3}

        map.replaceAll((k, v) -> v * v);    //키가 존재하면 값을 변경
        System.out.println(map);    //{A=9}
    }
}
