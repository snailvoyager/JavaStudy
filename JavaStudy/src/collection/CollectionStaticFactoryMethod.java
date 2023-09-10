package collection;

import java.util.List;
import java.util.Map;

public class CollectionStaticFactoryMethod {
    public static void main(String[] args) {
        List<String> friends = List.of("A", "B", "C");
        System.out.println(friends);

        //friends.set(1, "D");    //UnsupportedOperationException
        //friends.add("D");

        Map<String, Integer> ageOfFriends = Map.of("A", 20, "B", 21, "C", 25);
        System.out.println(ageOfFriends);

        ageOfFriends = Map.ofEntries(Map.entry("A", 30),
                Map.entry("B", 31),
                Map.entry("C", 33));
        System.out.println(ageOfFriends);
    }
}
