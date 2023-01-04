package functional.chap06;

import functional.chap06.model.Order;
import functional.chap06.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterTest {
    public static void main(String[] args) {
        Stream<Integer> numberStream = Stream.of(3, -7, 10, -1);
        Stream<Integer> filteredNumberStream = numberStream.filter(x -> x>0);
        List<Integer> filteredNumberList = filteredNumberStream.collect(Collectors.toList());
        System.out.println(filteredNumberList);

        List<Integer> newFilters = Stream.of(3, -7, 10, -1)
                .filter(x -> x > 0)
                .collect(Collectors.toList());
        System.out.println(newFilters);

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
        List<User> verifiedUsers = users.stream()
                .filter(User::isVerified)
                .collect(Collectors.toList());
        System.out.println(verifiedUsers);

        List<User> unVerifiedUsers = users.stream()
                .filter(user -> !user.isVerified())
                .collect(Collectors.toList());
        System.out.println(unVerifiedUsers);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED);

        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR);
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED);
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR);
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        List<Order> errorOrders = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .collect(Collectors.toList());
        System.out.println(errorOrders);
    }
}
