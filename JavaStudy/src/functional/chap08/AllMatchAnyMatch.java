package functional.chap08;

import functional.chap08.model.Order;
import functional.chap08.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

public class AllMatchAnyMatch {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 9);
        boolean allPositive = numbers.stream()
                .allMatch(number -> number > 0);
        System.out.println("Are all numbers positive : " + allPositive);

        boolean anyNegative = numbers.stream()
                .anyMatch(number -> number < 0);
        System.out.println("Is any number negative : " + anyNegative);

        User user1 = new User()
                .setId(101)
                .setName("Paul")
                .setVerified(true)
                .setEmailAddress("alice@mail.com");

        User user2 = new User()
                .setId(201)
                .setName("David")
                .setVerified(false)
                .setEmailAddress("bob@mail.com");

        User user3 = new User()
                .setId(301)
                .setName("John")
                .setVerified(false)
                .setEmailAddress("charlie@mail.com");

        User user4 = new User()
                .setId(401)
                .setName("Alice")
                .setVerified(false)
                .setEmailAddress("alice@mail.com");

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        boolean areAllUserVerified = users.stream()
                .allMatch(User::isVerified);
        System.out.println(areAllUserVerified);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        user1.setCreatedAt(now.minusDays(2));
        user2.setCreatedAt(now.minusHours(10));
        user3.setCreatedAt(now.minusHours(1));
        user4.setCreatedAt(now.minusHours(27));

        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101)
                .setAmout(BigDecimal.valueOf(5000))
                .setCreatedAt(now.minusHours(4));
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(103)
                .setAmout(BigDecimal.valueOf(3000))
                .setCreatedAt(now.minusHours(1));
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(102)
                .setAmout(BigDecimal.valueOf(4000))
                .setCreatedAt(now.minusHours(36));
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(104)
                .setAmout(BigDecimal.valueOf(7000))
                .setCreatedAt(now.minusHours(15));
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(101)
                .setAmout(BigDecimal.valueOf(6000))
                .setCreatedAt(now.minusHours(10));

        List<Order> orders = Arrays.asList(order1,order2,order3,order4,order5);

        boolean isAnyOrderInErrorStatus = orders.stream()
                .anyMatch(order -> order.getStatus() != Order.OrderStatus.ERROR);
        System.out.println(isAnyOrderInErrorStatus);
    }
}
