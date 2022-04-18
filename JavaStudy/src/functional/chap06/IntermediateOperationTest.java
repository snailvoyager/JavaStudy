package functional.chap06;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperationTest {
    public static void main(String[] args) {
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

        List<String> emails = users.stream()
                .filter(user -> !user.isVerified())
                .map(User::getEmailAddress)
                .collect(Collectors.toList());
        System.out.println(emails);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101)
                .setCreatedAt(now.minusHours(4));
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(103)
                .setCreatedAt(now.minusHours(1));
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(102)
                .setCreatedAt(now.minusHours(36));
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(104)
                .setCreatedAt(now.minusHours(15));
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(101)
                .setCreatedAt(now.minusHours(10));

        List<Order> orders = Arrays.asList(order1,order2,order3,order4,order5);

        List<Long> errorCreatedUsers = orders.stream()
                .filter(user -> user.getStatus() == Order.OrderStatus.ERROR)
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());
        System.out.println(errorCreatedUsers);

        List<Order> oneDaysOrders = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .filter(order -> order.getCreatedAt().isAfter(now.minusHours(24)))
                .collect(Collectors.toList());
        System.out.println(oneDaysOrders);
    }
}
