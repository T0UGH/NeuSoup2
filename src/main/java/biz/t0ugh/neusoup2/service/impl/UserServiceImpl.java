package biz.t0ugh.neusoup2.service.impl;

import biz.t0ugh.neusoup2.mapper.UserMapper;
import biz.t0ugh.neusoup2.pojo.User;
import biz.t0ugh.neusoup2.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean login(User user) {
        User dbUser = userMapper.getUser(user.getUserId());
        return dbUser.getUserPassword().equals(user.getUserPassword());
    }

    @Override
    public int register(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public User getUser(int userId) {
        return userMapper.getUser(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userMapper.deleteUser(user);
    }
}
