package com.zzf.zpmp.controller;

import com.google.common.collect.Maps;
import com.zzf.zpmp.annotation.LogAnnotation;
import com.zzf.zpmp.entity.SysUserEntity;
import com.zzf.zpmp.mapper.SysUserDao;
import com.zzf.zpmp.response.BaseResponse;
import com.zzf.zpmp.response.StatusCode;
import com.zzf.zpmp.service.SysUserService;
import com.zzf.zpmp.shiro.ShiroUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/sys/user")
public class SysUesrController extends AbstractController{
    @Autowired
    private SysUserService service;
    //获取用户当前信息
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public BaseResponse info(){
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        Map<String,Object> rmap = Maps.newHashMap();
        try {
            rmap.put("user",getUser());
        }catch (Exception e){
            return new BaseResponse(StatusCode.Fail);
        }
        baseResponse.setData(rmap);
        return baseResponse;
    }
    //修改密码
    @RequestMapping(value = "/password",method = RequestMethod.POST)
    @LogAnnotation("修改登录密码")
    public BaseResponse updatePassword(String password,String newPassword){
        if(StringUtils.isBlank(password)){
                return new BaseResponse(StatusCode.OldPasswordNotMatch);
        }else if(StringUtils.isBlank(newPassword)){
            return new BaseResponse(StatusCode.PasswordCanNotBlank);
        }
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        try {
            SysUserEntity entity=getUser();
            final String salt = entity.getSalt();
            String oldPsd = ShiroUtil.sha256(password,salt);
            if (!entity.getPassword().equals(oldPsd)){
                return new BaseResponse(StatusCode.OldPasswordNotMatch);
            }
            String newPsd=ShiroUtil.sha256(newPassword,salt);
            //执行更新密码的逻辑
            log.info("~~~~旧密码正确，开始更新新的密码~~~~");
            service.updatePassword(entity.getUserId(),oldPsd,newPsd);
        }catch (Exception e){
            return new BaseResponse(StatusCode.Fail);
        }
        return baseResponse;
    }
}
