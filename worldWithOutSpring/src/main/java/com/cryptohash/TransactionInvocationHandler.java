package com.cryptohash;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {

    private UserService userService;

    public TransactionInvocationHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Open up database connection");
        Object result = method.invoke(userService, args);
        System.out.println("Close database connection");
        return result;
    }
}
