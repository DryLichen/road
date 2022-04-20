package com.dry.admin.controller;


import com.dry.admin.bean.User;
import com.dry.admin.exception.TooManyUserException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @RequestMapping(value = "/basic_table", method = RequestMethod.GET)
    public String basic_table(){
        //测试错误处理
        // int a = 100/0;
        return "table/basic_table";
    }

    @RequestMapping(value = "/dynamic_table", method = RequestMethod.GET)
    public String dynamic_table(Model model){
        /**
         *  1.测试错误处理
         */
        // List<User> userList = Arrays.asList(new User("fnkafa", "fauigf324"),
        //                                     new User("fnkafa", "fauigf324"),
        //                                     new User("fnkafa", "fauigf324"),
        //                                     new User("fnkafa", "fauigf324"));
        // model.addAttribute("users", userList);
        //
        // if(userList.size() > 3){
        //     throw new TooManyUserException("用户过多");
        // }

        /**
         *  2.测试数据库查询
         */


        return "table/dynamic_table";
    }

    @RequestMapping(value = "/editable_table", method = RequestMethod.GET)
    public String editable_table(){
        return "table/editable_table";
    }

    @RequestMapping(value = "/responsive_table", method = RequestMethod.GET)
    public String responsive_table(){
        return "table/responsive_table";
    }
}
