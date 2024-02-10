package collection;

import java.util.Arrays;
import java.util.List;

public class ListOf {
    public static void main(String[] args) {
        List<String> listOf = List.of("A", "B", "C");
        try {
            listOf.add("D"); // UnsupportedOperationException 발생
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot add element to List.of");
        }

        List<String> asList = Arrays.asList("X", "Y", "Z");
        try {
            asList.add("W"); // UnsupportedOperationException 발생
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot add element to Arrays.asList");
        }

        try {
            List<String> listOfNull = List.of("A", null, "C");
        } catch (NullPointerException e) {
            System.out.println("Fail to add null in list");
        }

        List<String> asListWithNull = Arrays.asList("X", null, "Y", "Z");
        System.out.println(asListWithNull); //[X, null, Y, Z]

        // 배열 변화에 대한 동작 비교
        String[] array = {"One", "Two", "Three"};
        List<String> asListFromArray = Arrays.asList(array);
        List<String> listOfFromArray = List.of(array);

        System.out.println("Original array: " + Arrays.toString(array));    //[One, Two, Three]
        System.out.println("List from array: " + asListFromArray);          //[One, Two, Three]
        System.out.println("ListOf from array: " + listOfFromArray);        //[One, Two, Three]

        array[0] = "Zero";

        System.out.println("Modified array: " + Arrays.toString(array));            //[Zero, Two, Three]
        System.out.println("List after array modification: " + asListFromArray);    //[Zero, Two, Three]
        System.out.println("ListOf after array modification: " + listOfFromArray);  //[One, Two, Three]

        asListFromArray.set(0, "1");
        System.out.println("Origin array: " + Arrays.toString(array));    //[1, Two, Three]
        System.out.println("List after array: " + asListFromArray);         //[1, Two, Three]
    }
}
