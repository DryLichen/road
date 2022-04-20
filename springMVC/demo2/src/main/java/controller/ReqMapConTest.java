package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/testReqMap")
public class ReqMapConTest {

    //测试value属性
    @RequestMapping("/test")
    public String testValue(){
        return "success";
    }
    //测试value属性是字符串数组
    @RequestMapping(value = {"/value1", "/value2"})
    public String testValues(){
        return "success";
    }

    @RequestMapping(value = {"/value1", "/value2"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String testMethod(){
        return "success";
    }

    @RequestMapping(value = {"/testParam"}, params = {"username", "password=123456"})
    public String testParam(){
        return "success";
    }

    @RequestMapping(value = {"/testHeader"}, params = {"username", "password=123456"}, headers = {"Host=localhost:8080"})
    public String testHeader(){
        return "success";
    }

    @RequestMapping("/?test")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/testRest/{id}/{username}")
    public String testRest(@PathVariable String id, @PathVariable String username){
        System.out.println("id: " + id + " ; username: " + username);
        return "success";
    }
}
