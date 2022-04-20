package com.dry.demo.service;

import com.dry.demo.common.api.CommonResult;

/**
 * 会员管理
 */
public interface UmsMemberService {
    //生成验证码
    CommonResult generateAuthCode(String telephone);

    //判断手机号和验证码是否匹配
    CommonResult verifyAuthCode(String telephone, String authCode);
}
