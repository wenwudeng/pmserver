package com.xmut.pmserver.service;

import com.xmut.pmserver.pojo.User;


public interface UserService {
    /**
     * 登录
     * @param phone 登录账号
     * @param password 登录密码
     * @return 账号密码正确：1；密码错误：0；账号不存在：-1
     */
    int login(String phone,String password);

    /**
     * 注册
     * @param phone 账号
     * @param password 密码
     * @param verifyCode 验证码
     * @return 注册成功：true；注册失败:false
     */
    int register(String phone,String password,String verifyCode);

    /**
     * 指定id显示个人资料
     * @param id 指定id
     * @return User对象
     */
   User getInfoById(int id);


    /**
     * 指定phone显示个人资料
     * @param phone
     * @return
     */
    User getInfoByPhone(String phone);

    /**
     * 修改个人资料
     * @param id
     * @param photo
     * @param userName
     * @param gender
     * @param city
     * @param profile
     * @param pet
     */
    int editInfo(int id , String userName,String photo,  String gender, String city, String profile,String pet);
}
