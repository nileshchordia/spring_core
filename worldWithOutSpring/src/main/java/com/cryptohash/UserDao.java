package com.cryptohash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

@Component
public class UserDao {

//    private final DataSource dataSource;
//    @Autowired
//    private TempDataSource dataSource;

    @Autowired
    private DataSource dataSource;

/*    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    /*@Autowired
    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    public void save(User user) {
        System.out.println("save to DB user.getName() = " + user.getName() + "  " + dataSource);
    }
}
