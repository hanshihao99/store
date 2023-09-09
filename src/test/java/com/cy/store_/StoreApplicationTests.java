package com.cy.store_;

import com.cy.store_.entity.BaseEntity;
import com.cy.store_.entity.User;
import com.cy.store_.mapper.TUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {


    @Autowired
    private TUserMapper userMapper;

    @Test
    void contextLoads() {
    }
    @Autowired
    private DataSource dataSource;

    @Test
    void getConnection() throws SQLException {
        // HikariProxyConnection@401194142 wrapping com.mysql.cj.jdbc.ConnectionImpl@36b9cb99
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void getName(){
        User user = new User();
        user.setUsername("韩少飞");
        user.setPassword("HelloWo");
        user.setPhone("13335425123");
        Integer inset = userMapper.inset(user);
        System.out.println(inset);
    }


}
