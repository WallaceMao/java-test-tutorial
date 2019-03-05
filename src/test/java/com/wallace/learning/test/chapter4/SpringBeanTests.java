package com.wallace.learning.test.chapter4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Wallace Mao
 * Date: 2019-03-05 14:45
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class SpringBeanTests {
    @Autowired
    private UserService userService;

    @Test
    void testUserSayHi() {
        final String USER_NAME = "Wallace";
        String response = userService.sayHi(USER_NAME);
        assertThat(response).containsOnlyOnce(USER_NAME);
    }
}
