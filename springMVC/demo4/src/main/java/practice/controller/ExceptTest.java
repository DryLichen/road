package practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptTest {
    @RequestMapping("/testExceptionHandler")
    public String testExcept(){
        System.out.println(10/0);
        return "success";
    }
}
