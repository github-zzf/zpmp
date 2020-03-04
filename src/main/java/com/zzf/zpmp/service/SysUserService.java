package com.zzf.zpmp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzf.zpmp.entity.SysUserEntity;

import java.util.Map;

/**
 * Created by Administrator on 2019/7/31.
 */
public interface SysUserService extends IService<SysUserEntity> {

    //修改密码
    boolean updatePassword(Long userId, String oldPassword, String newPassword);

}
































