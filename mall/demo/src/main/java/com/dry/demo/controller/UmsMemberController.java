package com.dry.demo.controller;

import com.dry.demo.common.api.CommonResult;
import com.dry.demo.service.RedisService;
import com.dry.demo.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员登录注册管理
 * 根据电话号码返回验证码
 */
@RestController
@RequestMapping("/sso")
@Api (tags = "UmsMemberController", description = "会员信息管理")
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    public CommonResult generateAuthCode(@RequestParam String telephone){
        // return CommonResult.failed("确实有问题");
        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation("验证验证码是否正确")
    @RequestMapping(value ="/verifyAuthCode", method = RequestMethod.GET)
    public CommonResult verifyAuthCode(@RequestParam String telephone,
                                       @RequestParam String authCode){
        return umsMemberService.verifyAuthCode(telephone, authCode);
    }

}
