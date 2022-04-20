package com.dry.demo.service;

import com.dry.demo.mbg.model.UmsAdmin;
import com.dry.demo.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台管理员 Service
 */
public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员对象
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdmin umsAdmin);

    /**
     * 登录功能
     */
    String login(String username, String password);

    /**
     * 获取后台管理员所有权限
     */
    List<UmsPermission> getPermissionList(Long userId);
}
