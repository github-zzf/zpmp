package com.zzf.zpmp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzf.zpmp.entity.SysMenuEntity;

import java.util.List;

/**
 * Created by Administrator on 2019/8/3.
 */
public interface SysMenuService extends IService<SysMenuEntity> {

    List<SysMenuEntity> queryAll();

    List<SysMenuEntity> queryNotButtonList();

    List<SysMenuEntity> queryByParentId(Long menuId);

    void delete(Long menuId);

    List<SysMenuEntity> getUserMenuList(Long currUserId);
}
