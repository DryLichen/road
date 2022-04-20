package com.dry.admin.controller;


import com.dry.admin.bean.Employee;
import com.dry.admin.bean.User;
import com.dry.admin.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    EmployeeService employeeService;

    @ResponseBody
    @GetMapping("/employee")
    public Employee getEmp(){
        return employeeService.getEmpByEid(1);
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    // 账号密码输入正确后跳转至主页面
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String main(User user, HttpSession session, Model model){
        if(!StringUtils.isEmpty(user.getUsername()) && "123456".equals(user.getPassword())){
            session.setAttribute("loginUser", user);
            return "redirect:/main.html";
        } else {
            model.addAttribute("message", "账号密码错误");
            return "login";
        }
    }

    // 防止重复提交登录请求
    @RequestMapping(value = "/main.html", method = RequestMethod.GET)
    public String mainPage(HttpSession session, Model model){
        // if(session.getAttribute("loginUser") != null){
        //     return "main";
        // } else {
        //     model.addAttribute("message", "请重新登录");
        //     return "login";
        // }

        return "main";
    }
}
