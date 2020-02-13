package biz.t0ugh.neusoup2.service.impl;

import biz.t0ugh.neusoup2.Neusoup2ApplicationTests;
import biz.t0ugh.neusoup2.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplTests extends Neusoup2ApplicationTests {
    @Autowired
    UserService userService;

    @Test
    void contextLoads(){
        Assertions.assertNotNull(userService);
    }
}
