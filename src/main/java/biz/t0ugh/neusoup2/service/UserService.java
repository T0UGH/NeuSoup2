package biz.t0ugh.neusoup2.service;

import biz.t0ugh.neusoup2.pojo.User;

public interface UserService {
    public boolean login(User user);
    public int register(User user);
    public User getUser(int userId);
    public int updateUser(User user);
    public int deleteUser(User user);
}
