package com.dry.demo.mapper;

import com.dry.demo.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色管理
 */
public interface UmsAdminAndRoleMapper {
    //获取用户所有权限(包括 +- 权限)
    List<UmsPermission> getPermissionList(@Param("adminId") long adminId);
}
