package com.zzf.zpmp.service.impl;/**
 * Created by Administrator on 2019/7/31.
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzf.zpmp.entity.SysUserEntity;
import com.zzf.zpmp.mapper.SysUserDao;
import com.zzf.zpmp.service.SysUserService;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/7/31 17:43
 **/
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    //更新密码 ~ 借助于mybatis-plus的方法来实现
    @Override
    public boolean updatePassword(Long userId, String oldPassword, String newPassword) {
        SysUserEntity entity=new SysUserEntity();
        entity.setPassword(newPassword);
        Boolean res=this.update(entity,new QueryWrapper<SysUserEntity>().eq("user_id",userId).eq("password",oldPassword));
        //传统~开始记录日志
        return res;
    }
}















































