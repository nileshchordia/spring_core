package com.cryptohash;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MailTransactionInvocationHandler implements InvocationHandler {
    private MailService mailService;

    public MailTransactionInvocationHandler(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(mailService,args);
        return null;
    }
}
