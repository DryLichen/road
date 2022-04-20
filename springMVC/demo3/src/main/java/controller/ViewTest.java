package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewTest {

    @RequestMapping("/testTh")
    public String testTh(){
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testTh";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testTh";
    }
}
