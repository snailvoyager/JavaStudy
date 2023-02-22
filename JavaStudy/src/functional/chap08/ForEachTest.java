package functional.chap08;

import functional.chap08.model.User;
import functional.chap08.service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ForEachTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 2, 1);
        numbers.stream().forEach(number -> System.out.println("The number is " + number));
        numbers.forEach(number -> System.out.println("The number is " + number));

        User user1 = new User()
                .setId(101)
                .setName("Paul")
                .setVerified(true)
                .setEmailAddress("alice@mail.com")
                .setFriendUserIds(Arrays.asList(201, 202, 203, 204, 212, 214, 215));

        User user2 = new User()
                .setId(201)
                .setName("David")
                .setVerified(false)
                .setEmailAddress("bob@mail.com")
                .setFriendUserIds(Arrays.asList(204, 205, 206));

        User user3 = new User()
                .setId(301)
                .setName("John")
                .setVerified(true)
                .setEmailAddress("charlie@mail.com")
                .setFriendUserIds(Arrays.asList(204, 205, 206));

        User user4 = new User()
                .setId(401)
                .setName("Alice")
                .setVerified(false)
                .setEmailAddress("alice@mail.com");
        List<User> users = Arrays.asList(user1, user2, user3, user4);

        EmailService emailService = new EmailService();
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifyYourEmail);

        //stream loop index 사용하기
        IntStream.range(0, users.size()).forEach(i -> {
            User user = users.get(i);
            System.out.println("Do an operation on user " + user.getName() + "at Index " + i);
        });
    }
}
