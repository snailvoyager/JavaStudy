package functional.chap07;

import functional.chap07.model.User;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        User user1 = new User()
                .setId(1001)
                .setName("Alice")
                .setVerified(false);
        User user2 = new User()
                .setId(1001)
                .setName("Alice")
                .setEmailAddress("alice@gmail.co.kr")
                .setVerified(false);

        //System.out.println("same ? : " + userEquals(user1, user2)); //NPE

        String someEmail = "some@email.com";
        String nullEmail = null;

        Optional<String> maybeEmail = Optional.of(someEmail);
        Optional<String> maybeEmail2 = Optional.empty();
        Optional<String> maybeEmail3 = Optional.ofNullable(someEmail);
        Optional<String> maybeEmail4 = Optional.ofNullable(nullEmail);

        String email = maybeEmail.get();
        System.out.println(email);

        if (maybeEmail2.isPresent()) {
            System.out.println(maybeEmail2.get());
        }

        String defaultEmail = "default@email.com";
        String email3 = maybeEmail2.orElse(defaultEmail);
        System.out.println(email3);
        String email4 = maybeEmail2.orElseGet(() -> defaultEmail);
        System.out.println(email4);
        //String email5 = maybeEmail2.orElseThrow(() -> new RuntimeException("email not present"));

        Optional<User> maybeUser = Optional.ofNullable(maybeGetUser(true));
        maybeUser.ifPresent(u -> System.out.println(u));

        Optional<Integer> maybeId = Optional.ofNullable(maybeGetUser(true))
                .map(user -> user.getId());
        maybeId.ifPresent(System.out::println);

        String userName = Optional.ofNullable(maybeGetUser(false))
                .map(User::getName)
                .map(name -> "The name is " + name)
                .orElse("Name is empty");
        System.out.println(userName);

        Optional<Optional<String>> userEmail = Optional.ofNullable(maybeGetUser(false))     //Optional of Optional
                .map(User::getEmailAddress);

        Optional<String> userEmail2 = Optional.ofNullable(maybeGetUser(true))
                .flatMap(User::getEmailAddress);
        userEmail2.ifPresent(System.out::println);
    }

    public static boolean userEquals(User user1, User user2) {
        return user1.getId() == user2.getId()
                && user1.getName().equals(user2.getName())
                && user1.getEmailAddress().equals(user2.getEmailAddress())
                && user1.isVerified() == user2.isVerified();
    }

    public static User maybeGetUser(boolean returnUser) {
        if (returnUser) {
            return new User()
                    .setId(1001)
                    .setName("Alice")
                    .setEmailAddress("email@email.com")
                    .setVerified(false);
        }
        return null;
    }
}
