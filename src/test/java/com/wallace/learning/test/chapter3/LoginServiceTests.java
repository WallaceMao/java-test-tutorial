package com.wallace.learning.test.chapter3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Mockito.*;

/**
 * @author Wallace Mao
 * Date: 2019-03-05 13:20
 */
public class LoginServiceTests {
    private static LoginService loginService;

    @BeforeEach
    private void beforeEach() {
        loginService = new LoginService();
    }

    @Test
    void testMockRedisManager() {
        final String USER_NAME = "Wallace";
        final String PHONE_NUMBER = "13099998888";
        final String CODE = "9876";
        final String FAKE_CODE = "0011";
        RedisManager manager = mock(RedisManager.class);
        //  模拟返回值
        when(manager.getPoolSize()).thenReturn(9999);
        when(manager.getVal(PHONE_NUMBER))
                .thenReturn(CODE)  // 第一次返回
                .thenReturn(FAKE_CODE);  // 第二次返回
        loginService.setRedisManager(manager);

        User user = loginService.login(USER_NAME, PHONE_NUMBER, CODE);
        assertThat(user).isNotNull();
        assertThat(user).hasFieldOrPropertyWithValue("phoneNumber", PHONE_NUMBER);
        assertThat(user).hasFieldOrPropertyWithValue("userName", USER_NAME);
        assertThat(user).hasFieldOrPropertyWithValue("admin", false);
        //  验证getValue方法被调用了一次
        verify(manager, times(1)).getVal(PHONE_NUMBER);

        User user2 = loginService.login(USER_NAME, PHONE_NUMBER, CODE);
        assertThat(user2).isNull();
        verify(manager, times(2)).getVal(PHONE_NUMBER);
    }

    @Test
    void testSpyRedisManager() {
        final String USER_NAME = "Wallace";
        final String PHONE_NUMBER = "13099998888";
        final String CODE = "9876";
        final String FAKE_CODE = "0011";
        RedisManager manager = spy(new RedisManager());
        doReturn(CODE).doReturn(FAKE_CODE).when(manager).getVal(PHONE_NUMBER);
        loginService.setRedisManager(manager);

        User user = loginService.login(USER_NAME, PHONE_NUMBER, CODE);
        assertThat(user).isNotNull();
        assertThat(user).hasFieldOrPropertyWithValue("phoneNumber", PHONE_NUMBER);
        assertThat(user).hasFieldOrPropertyWithValue("userName", USER_NAME);
        assertThat(user).hasFieldOrPropertyWithValue("admin", false);
        //  验证getValue方法被调用了一次
        verify(manager, times(1)).getVal(PHONE_NUMBER);

        User user2 = loginService.login(USER_NAME, PHONE_NUMBER, CODE);
        assertThat(user2).isNull();
        verify(manager, times(2)).getVal(PHONE_NUMBER);
    }
}
