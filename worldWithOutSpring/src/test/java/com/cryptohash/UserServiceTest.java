package com.cryptohash;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

class UserServiceTest {


    @Test
    void closeConnection() {
        UserService userService = new UserService();
        IUserService proxiedUserService = (IUserService) Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{IUserService.class}, new TransactionInvocationHandler(userService));
        proxiedUserService.closeAccount(new User("nilesh","nilesh@email"));
//        new UserService().closeAccount(new User("nilesh","nilesh@email"));
    }
}