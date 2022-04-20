package com.dry.demo.controller;

import com.dry.demo.common.api.CommonResult;
import com.dry.demo.mbg.model.UmsAdmin;
import com.dry.demo.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * 后台管理员账号管理
 */
@RestController
@Api(tags = "UmsAdminController", value = "后台管理员管理")
@RequestMapping("/admin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService umsAdminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdmin){
        UmsAdmin admin = umsAdminService.register(umsAdmin);
        if(admin == null){
            return CommonResult.failed();
        }

        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "用户登录以后返回 token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestParam String username, @RequestParam String password){

    }

    @ApiOperation(value = "获取用户所有权限，包括 +- 权限")
    public CommonResult getPermissionList(){

    }
}
