package practice.controller;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import practice.bean.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HttpTest {

    /**
        最原始的方法
     */
//    @RequestMapping("/testReqBody")
//    public String testReqBody(HttpServletRequest request){
//        String username = request.getParameter("username");
//        System.out.println(username);
//        return "success";
//    }

    @RequestMapping("/testReqBody")
    public String testReqBody(@RequestBody String requestBody){
        System.out.println("RequestBody: " + requestBody);
        return "success";
    }

    @RequestMapping("/testReqEntity")
    public String testReqEntity(RequestEntity<String> requestEntity){
        System.out.println("Header: " + requestEntity.getHeaders());
        System.out.println("Body: " + requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResBody")
    @ResponseBody
    public String testResBody(){
        return "ok";
    }

    @RequestMapping("/testJson")
    @ResponseBody
    public User testJson(){
        return new User(1001, "z", "123", 28);
    }

    @RequestMapping("/testAjax")
    @ResponseBody
    public String testAjax(String username, String password){
        System.out.println("username: " + username + " ; password: " + password);
        return "hello, ajax!";
    }
}
