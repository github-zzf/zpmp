package com.zzf.zpmp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysLoginController{
    @RequestMapping("login.html")
    public String login() {
        return "login";
    }
}
