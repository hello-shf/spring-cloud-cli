package com.shf.service.impl;

import com.shf.dao.UserDao;
import com.shf.entity.user.TUser;
import com.shf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/1 15:49
 * @Version V1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public TUser findOneByName(String username) {
        return userDao.findOneByName(username);
    }
}
