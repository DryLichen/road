package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
    //返回首页
    @RequestMapping("/")
    public String test(){
        return "index";
    }
}