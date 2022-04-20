package com.dry.demo.service.impl;

import com.dry.demo.common.api.CommonResult;
import com.dry.demo.service.RedisService;
import com.dry.demo.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * 将自定义的Redis键加上手机号生成一个Redis的key,以验证码为value存入到Redis中，
 * 设置过期时间为自己配置的时间（这里为120s）。
 * 校验验证码时根据手机号码来获取Redis里面存储的验证码，并与传入的验证码进行比对。
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTHCODE;
    @Value("${redis.key.expire.authCode}")
    private Long REDIS_KEY_EXPIRE_AUTHCODE;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0;i < 6;i++){
            sb.append(random.nextInt(10));
        }
        redisService.set(REDIS_KEY_PREFIX_AUTHCODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTHCODE + telephone, REDIS_KEY_EXPIRE_AUTHCODE);

        return CommonResult.success(sb.toString(), "成功获取验证码");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if(!StringUtils.hasLength(authCode)){
            return CommonResult.failed("请输入验证码");
        }
        String trueCode = redisService.get(REDIS_KEY_PREFIX_AUTHCODE + telephone);

        if(authCode.equals(trueCode)){
            return CommonResult.success("验证码校验成功");
        }

        return CommonResult.failed("验证码错误");
    }
}
