package util;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseUtilTest {


    @Test
    void testConnectDatabase() throws SQLException {

        HikariDataSource dataSource = DatabaseUtil.dataSource();
        Connection connection = dataSource.getConnection();
    }
}
