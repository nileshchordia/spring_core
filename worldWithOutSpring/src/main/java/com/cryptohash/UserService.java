package com.cryptohash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;


@Component
@Transactional
//@Service
public class UserService{


    /**
     * field injector
     */
    @Autowired  //@Inject ..@Resource
    private MailService mailService;

    @Autowired
    private UserDao userDao;


    /**
     * setter injector
     * @param mailService
     */

    /*@Autowired
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    /**
     * it is  a construtor injection
     * @param
     * @param
     */
    /*public UserService(MailService mailService, UserDao userDao) {
        this.mailService = mailService;
        this.userDao = userDao;
    }*/



    public void register(User user){
        System.out.println("DB Transaction Open ?"+TransactionSynchronizationManager.isActualTransactionActive());
        userDao.save(user);
        mailService.sendWelcomeMail(user);
        System.out.println("DB Transaction Open ?"+TransactionSynchronizationManager.isActualTransactionActive());



        //1.save the data to DB
        //2.send the welcome mail
        //3.balance check
    }

    public void closeAccount(User user){
        System.out.println("Close Account  "+ user.getEmail());

    }

}
