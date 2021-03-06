package com.cryptohash;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

//@Component
@Service
public class TempDataSource {
    public DataSource getDataSource() {
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
    }

}
