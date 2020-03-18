package com.xmut.pmserver.service.impl;

import com.xmut.pmserver.mapper.UserMapper;
import com.xmut.pmserver.pojo.User;
import com.xmut.pmserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    UserMapper userMapper;

    /*登录查询*/
    @Override
    public int findUserByPhone(String phone, String password) {
        User user = userMapper.loginByPhone(phone);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return 1;
            }else {
                return 0;
            }
        }
        return -1;
    }

    /*注册*/
    @Override
    public boolean register(String phone, String password, String verifyCode) {
        String code = "10086";
        User user = new User();
        user.setPhone(phone);
        System.out.println("account:"+phone +" "+"密码："+password);
        user.setPassword(password);
        if (verifyCode.equals(code)) {
            userMapper.register(user);
            System.out.println("获取插入id"+user.getUserId());
            return true;
        }

        return false;
    }

    /*显示个人信息*/
    @Override
    public User showMyself(int id) {
        User user = userMapper.getInfo(id);
        System.out.println(user);
        if (user != null) {
            return user;
        }
        return null;
    }

    /*修改个人信息*/
    @Override
    public  int editInfo(int id, String photo, String userName, String gender, String city, String profile,String pet) {
        User user = new User(id, city, gender, userName, photo, profile,pet);
        System.out.println(user);
        return userMapper.editInfo(user);
    }


}
