package functional.chap06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapTest {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(3, 6, -9);
        Stream<Integer> numberStream = numberList.stream()
                .map(x -> x * 2);
        System.out.println(numberStream.collect(Collectors.toList()));

        Stream<Integer> numberListStream = numberList.stream();
        Stream<String> strStream = numberListStream.map(x -> "Number is " + x);
        System.out.println(strStream.collect(Collectors.toList()));

        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@mail.com");

        User user2 = new User()
                .setId(201)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@mail.com");

        User user3 = new User()
                .setId(301)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("charlie@mail.com");

        List<User> users = Arrays.asList(user1, user2, user3);
        List<String> emailAddresses = users.stream()
            .map(User::getEmailAddress)     // email만 추출
            .collect(Collectors.toList());
        System.out.println(emailAddresses);


        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101);

        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(103);
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(102);
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(104);
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(101);

        List<Order> orders = Arrays.asList(order1,order2,order3,order4,order5);
        List<Long> createdUserIds = orders.stream()
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());
        System.out.println(createdUserIds);
    }
}
