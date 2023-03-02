package functional.chap08;

import functional.chap08.model.User;
import functional.chap08.service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelTest {
    public static void main(String[] args) {
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

        User user5 = new User()
                .setId(501)
                .setName("Park")
                .setVerified(false)
                .setEmailAddress("Park@mail.com");

        User user6 = new User()
                .setId(601)
                .setName("Kim")
                .setVerified(false)
                .setEmailAddress("Kim@mail.com");
        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);

        long startTime = System.currentTimeMillis();
        EmailService emailService = new EmailService();
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifyYourEmail);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential : " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        users.stream().parallel()       //중간 처리는 순서 보장 X
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifyYourEmail);
        endTime = System.currentTimeMillis();
        System.out.println("Sequential : " + (endTime - startTime) + "ms");

        List<User> processUsers = users.parallelStream()
                .map(user -> {
                    System.out.println("Capitalize user name for user " + user.getId());
                    user.setName(user.getName().toUpperCase());
                    return user;
                })
                .map(user -> {
                    System.out.println("Set 'isVerified' to true for user " + user.getId());
                    user.setVerified(true);
                    return user;
                })
                .collect(Collectors.toList());
        System.out.println(processUsers);
    }
}
