package com.xmut.pmserver.service.impl;

import com.xmut.pmserver.mapper.UserMapper;
import com.xmut.pmserver.pojo.User;
import com.xmut.pmserver.service.UserService;
import com.xmut.pmserver.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    UserMapper userMapper;

    /*登录查询*/
    @Override
    public int login(String phone, String password) {
        System.out.println(phone+password);
        User user = userMapper.loginByPhone(phone);
        System.out.println("登陆查询"+user);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return user.getUserid();
            }else {
                return 0;
            }
        }
        return -1;
    }

    /*注册*/
    @Override
    public int register(String phone, String password, String verifyCode) {
        String code = "10086";
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        user.setUserName(Utils.generateName());
        user.setGender("男");
        user.setCity("请点击头像填写地址");
        user.setProfile("请点击头像完善个人资料");
        user.setPet("请点击头像完善个人资料");
        user.setPhoto("http://47.101.171.252:81/static/1936aba4-f834-4e88-9017-2b37f1817442.png");
        user.setTime(Utils.getRegisterDate());
        if (verifyCode.equals(code)) {
            userMapper.register(user);
            System.out.println("用户注册"+user);
            return user.getUserid();
        }

        return -1;
    }

    @Override
    public User getInfoById(int id) {
        User user = userMapper.getInfoById(id);
        if (user != null) {
            return user;
        }
        return null;
    }

    /*显示个人信息*/
    @Override
    public User getInfoByPhone(String phone) {
        User user = userMapper.getInfoByPhone(phone);
        System.out.println(user.getUserid());
        System.out.println("按号码查询个人信息"+user);
        if (user != null) {
            return user;
        }
        return null;
    }

    /*修改个人信息*/
    @Override
    public  int editInfo(int userId, String photo, String userName, String gender, String city, String profile,String pet) {
        User user = new User(userId, city, gender, userName, photo, profile,pet);
        System.out.println("修改个人信息"+user);
        return userMapper.editInfo(user);
    }


}
