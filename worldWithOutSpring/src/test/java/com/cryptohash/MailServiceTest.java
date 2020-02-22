package com.cryptohash;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

class MailServiceTest {

    @Test
    void sendWelcomeMail() {
        MailService mailService = new MailService("localhostnew",786,"nil@crypto");
        IMailService proxiedMailService = (IMailService) Proxy.newProxyInstance(MailService.class.getClassLoader(), new Class[]{IMailService.class}, new MailTransactionInvocationHandler(mailService));
        proxiedMailService.sendWelcomeMail(new User("nil","nil@crypto"));
    }
}