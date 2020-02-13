package biz.t0ugh.neusoup2.service.impl;

import biz.t0ugh.neusoup2.Neusoup2ApplicationTests;
import biz.t0ugh.neusoup2.pojo.User;
import biz.t0ugh.neusoup2.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

public class UserServiceImplTests extends Neusoup2ApplicationTests {
    @Resource
    UserService userService;

    private User user;

    @BeforeEach
    public void init() {
        user = new User();
        user.setUserName("小明");
        user.setUserPassword("password");
        user.setUserAvator("avator");
        user.setUserSex(1);
        user.setUserNote("note");
    }

    @Test
    void testFlow(){
        userService.register(user);
        Assertions.assertNotEquals(0, user.getUserId());

        Assertions.assertTrue(userService.login(user));
        user.setUserPassword("wordpass");
        Assertions.assertFalse(userService.login(user));
        user.setUserPassword("password");

        User dbUser = userService.getUser(user.getUserId());
        Assertions.assertNotNull(dbUser);

        String updateNote = "noteAndNote";
        user.setUserNote(updateNote);
        userService.updateUser(user);
        Assertions.assertEquals(updateNote, user.getUserNote());

        userService.deleteUser(user);
        dbUser = userService.getUser(user.getUserId());
        Assertions.assertNull(dbUser);
    }
}
