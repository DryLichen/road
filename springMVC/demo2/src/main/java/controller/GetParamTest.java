package controller;

import bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


@Controller
public class GetParamTest {

    //使用原生的ServletAPI获取request参数
    @RequestMapping("/testAPI")
    public String testAPI(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + " ; password: " + password);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("username: " + username + " ; password: " + password);
        return "success";
    }

    @RequestMapping("/testMore")
    public String testMore(@RequestParam(value = "username") String username,
                           String password,
                           @RequestParam(value = "gender", defaultValue = "female") String gender,
                           String[] hobby,
                           @CookieValue(value = "JSESSIONID", required = false) String JSESSIONID){
        System.out.println("username: " + username + " ; password: " + password + " ; gender: " + gender);
        System.out.println("hobby: " + Arrays.toString(hobby));
        System.out.println("JSESSIONID: " + JSESSIONID);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }
}
