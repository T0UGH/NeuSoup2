package biz.t0ugh.neusoup2;

import biz.t0ugh.neusoup2.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Neusoup2ApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads(){
        Assertions.assertNotNull(userService);
    }
}
