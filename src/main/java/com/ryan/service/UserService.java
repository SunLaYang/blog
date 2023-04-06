package com.ryan.service;

import com.ryan.po.User;

public interface UserService {
    User checkUser(String username, String password);
}
