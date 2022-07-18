package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static HikariDataSource hikariDataSource;

    static {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/todolist_db");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("");

        //pool
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setMinimumIdle(5);
        hikariConfig.setIdleTimeout(60000);
        hikariConfig.setMaxLifetime(10*60000);
        hikariDataSource = new HikariDataSource(hikariConfig);
    }

    public static HikariDataSource dataSource(){
        return hikariDataSource;
    }

}
