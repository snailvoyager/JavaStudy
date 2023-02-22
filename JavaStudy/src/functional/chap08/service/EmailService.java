package functional.chap08.service;

import functional.chap08.model.User;

public class EmailService {
    public void sendPlayWithFriendsEmail(User user) {
        user.getEmailAddress().ifPresent(email -> System.out.println("Sending 'Play With Friends' email to " + email));
    }

    public void sendMakeMoreFriendsEmail(User user) {
        user.getEmailAddress().ifPresent(email -> System.out.println("Sending 'Make More Friends' email to " + email));
    }

    public void sendVerifyYourEmail(User user) {
        user.getEmailAddress().ifPresent(email -> System.out.println("Sending 'Verify YourEmail' email to " + email));
    }
}
