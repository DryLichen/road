package com.dry.demo.service.impl;

import com.dry.demo.common.utils.JwtTokenUtil;
import com.dry.demo.mapper.UmsAdminAndRoleMapper;
import com.dry.demo.mbg.mapper.UmsAdminMapper;
import com.dry.demo.mbg.model.UmsAdmin;
import com.dry.demo.mbg.model.UmsAdminExample;
import com.dry.demo.mbg.model.UmsPermission;
import com.dry.demo.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UmsAdminMapper umsAdminMapper;
    @Autowired
    private UmsAdminAndRoleMapper umsAdminAndRoleMapper;

    // 根据用户名查询管理员
    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> umsAdminList = umsAdminMapper.selectByExample(example);
        if(umsAdminList != null && umsAdminList.size() > 0){
            return umsAdminList.get(0);
        }
        return null;
    }

    // 注册新管理员
    @Override
    public UmsAdmin register(UmsAdmin umsAdmin) {
        // 1.首先判断用户名是否重复，重复则注册失败
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
        List<UmsAdmin> umsAdminList = umsAdminMapper.selectByExample(example);
        if(umsAdminList.size() > 0){
            return null;
        }

        // 2.插入新管理员
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        // 加密密码
        String encodedPassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodedPassword);
        umsAdminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    // 管理员登录，成功时生成 token
    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if(!passwordEncoder.matches(password, userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            log.warn("登录异常：{}", e);
        }
        return null;
    }

    // 获取管理员所有权限
    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return umsAdminAndRoleMapper.getPermissionList(adminId);
    }
}
