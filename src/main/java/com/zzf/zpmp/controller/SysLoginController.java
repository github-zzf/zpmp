package com.zzf.zpmp.controller;


import com.zzf.zpmp.response.BaseResponse;
import com.zzf.zpmp.response.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SysLoginController extends AbstractController{
    @RequestMapping(value = "/sys/login",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse login(String username, String password, String captcha) {
        log.info("用户名：{} 密码：{} 验证码:{}",username,password,captcha);
        return  new BaseResponse(StatusCode.Success);
    }
}
