package com.cryptohash;

import org.h2.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class ApplicationContextConfiguration {

    @Bean //@Value for reading data from properties file
    public MailService mailService(){
        return new MailService("localhost",465,"nilesh");
    }

    /*@Bean
    public UserDao userDao(){
        return new UserDao(getDataSource());
    }*/

    /*@Bean
    public UserService userService(){
        return new UserService();
    }*/

    @Bean
    public DataSource dataSource(){
        SimpleDriverDataSource ds = new SimpleDriverDataSource();
        ds.setDriver(new Driver());
        ds.setUrl("jdbc:h2:mem:");
        return ds;
    }

    @Bean
    public TransactionManager txManager(){
        return new DataSourceTransactionManager(dataSource());

    }
    /*private DataSource getDataSource() {
        return new DataSource() {
            public Connection getConnection() throws SQLException {
                return null;
            }

            public Connection getConnection(String username, String password) throws SQLException {
                return null;
            }

            public <T> T unwrap(Class<T> iface) throws SQLException {
                return null;
            }

            public boolean isWrapperFor(Class<?> iface) throws SQLException {
                return false;
            }

            public PrintWriter getLogWriter() throws SQLException {
                return null;
            }

            public void setLogWriter(PrintWriter out) throws SQLException {

            }

            public void setLoginTimeout(int seconds) throws SQLException {

            }

            public int getLoginTimeout() throws SQLException {
                return 0;
            }

            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                return null;
            }
        };
    }*/
}
