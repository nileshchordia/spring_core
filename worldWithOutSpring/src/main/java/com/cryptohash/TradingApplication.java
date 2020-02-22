package com.cryptohash;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class TradingApplication {

    public static void main(String[] args) {
        User user = new User("nilesh", "nilesh@cryptohash");
        System.out.println("user.getEmail() = " + user.getEmail());
        System.out.println("DB Transaction Open ?"+TransactionSynchronizationManager.isActualTransactionActive());
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.register(user);
        System.out.println("DB Transaction Open ?"+TransactionSynchronizationManager.isActualTransactionActive());
    }

}
