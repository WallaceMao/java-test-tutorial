package com.wallace.learning.test.chapter3;

/**
 * @author Wallace Mao
 * Date: 2019-03-05 12:56
 */
public class LoginService {
    private RedisManager redisManager;

    public User login(String userName, String phoneNumber, String validateCode) {
        String code = redisManager.getVal(phoneNumber);
        if (code == null || !code.equals(validateCode)) {
            return null;
        }
        return getDefaultUser(userName, phoneNumber);
    }

    public RedisManager getRedisManager() {
        return redisManager;
    }

    public void setRedisManager(RedisManager redisManager) {
        this.redisManager = redisManager;
    }

    private User getDefaultUser(String userName, String phoneNumber) {
        User u = new User();
        u.setUserName(userName);
        u.setAdmin(false);
        u.setAvatar("https://xxxxx/a/b/c/d.png");
        u.setPhoneNumber(phoneNumber);
        return u;
    }
}
