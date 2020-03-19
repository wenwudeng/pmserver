package com.xmut.pmserver.contorller;

import com.xmut.pmserver.result.ResponseWrapper;
import com.xmut.pmserver.result.ReturnCode;
import com.xmut.pmserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /*登录*/
    @RequestMapping("/login")
    public ResponseWrapper login(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        int value = userService.login(phone, password);
        if (value == 1) {
            return ResponseWrapper.markSuccess("登录成功");
        } else if (value == 0) {
            return ResponseWrapper.markCustom(false, "3001", "账号或密码错误", ReturnCode.LOGIN_FAIL);
        }
        return ResponseWrapper.markCustom(false, "3002", "账号不存在", ReturnCode.LOGIN_NOTNULL);
    }

    /*注册*/
    @RequestMapping("/register")
    public ResponseWrapper register(@RequestParam String phone, @RequestParam String password,String verifyCode) {
        if (userService.register(phone, password, verifyCode)) {
            return ResponseWrapper.markCustom(true, "3003", "注册成功", ReturnCode.REGISTER_SUCCESS);
        }
        return ResponseWrapper.markCustom(false, "3004", "请重新注册", ReturnCode.REGISTER_FAIL);
    }

    /*根据号码个人信息*/
    @RequestMapping("/showInfo")
    public ResponseWrapper showInfo(@RequestParam String phone) {
         return ResponseWrapper.markCustom(true,"0000","查询成功",userService.getInfoByPhone(phone));
    }

    /*修改个人信息*/
    @RequestMapping("/editInfo")
    public ResponseWrapper editInfo(@RequestParam int userId,@RequestParam(required = false) String photo, @RequestParam(required = false) String userName,
                                    @RequestParam(required = false) String gender,@RequestParam(required = false)String city, @RequestParam(required = false) String profile
                                   , @RequestParam(required = false) String pet) {
        return ResponseWrapper.markCustom(true, "3305", "修改成功", userService.editInfo(userId,userName,photo,gender,city,profile,pet));
    }


}
