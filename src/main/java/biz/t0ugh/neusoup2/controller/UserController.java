package biz.t0ugh.neusoup2.controller;

import biz.t0ugh.neusoup2.pojo.User;
import biz.t0ugh.neusoup2.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/user/login")
    public User login(User user){
        if(userService.login(user))
            return user;
        else
            // TODO: 2020/2/14 此处要加入异常判定类
            return null;
    }

    @PostMapping("/user")
    public User register(User user){
        userService.register(user);
        return user;
    }

    @DeleteMapping("/user")
    public User deleteUser(User user){
        userService.deleteUser(user);
        return user;
    }

    @PutMapping("/user")
    public User updateUser(User user){
        userService.updateUser(user);
        return user;
    }
}
