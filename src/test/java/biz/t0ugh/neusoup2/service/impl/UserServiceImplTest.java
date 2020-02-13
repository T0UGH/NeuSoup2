package biz.t0ugh.neusoup2.service.impl;

import biz.t0ugh.neusoup2.pojo.User;
import biz.t0ugh.neusoup2.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

//import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    private User user;

    @Before
    public void init() {
        user = new User();
        user.setUserName("小明");
        user.setUserPassword("password");
        user.setUserAvator("avator");
        user.setUserSex(1);
        user.setUserNote("note");
    }

    @Test
    public void mainTestUser() {
        userService.register(user);
        Assert.assertNotEquals(0, user.getUserId());
        Assert.assertTrue(userService.login(user));
        user.setUserPassword("wordpass");
        Assert.assertFalse(userService.login(user));
        user.setUserPassword("password");
        String updateNote = "noteAndNote";
        user.setUserNote(updateNote);
        userService.updateUser(user);
        Assert.assertEquals(updateNote, user.getUserNote());
        user.setUserNote("note");
        User dbUser = userService.getUser(user.getUserId());
        Assert.assertNotNull(dbUser);
        userService.deleteUser(user);
        dbUser = userService.getUser(user.getUserId());
        Assert.assertNull(dbUser);
    }
}