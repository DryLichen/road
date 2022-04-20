package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class DomainTest {

    @RequestMapping("/testReqAPI")
    public String testReqAPI(HttpServletRequest request){
        request.setAttribute("testReqDomain", "hello api!");
        return "success";
    }

    @RequestMapping("/testMAV")
    public ModelAndView testMAV(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("testReqDomain", "hello mav!");
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testReqDomain", "hello model!");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        map.put("testReqDomain", "hello map!");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testReqDomain", "hello modelmap!");
        return "success";
    }

    /**
        以下为测试另外两种域对象，均使用原生ServletAPI
     */
    @RequestMapping("/testSeesion")
    public String testSession(HttpSession session){
        session.setAttribute("testSeesionDomain", "hello session!");
        return "success";
    }

    @RequestMapping("/testApp")
    public String testApp(HttpSession session){
        ServletContext context = session.getServletContext();
        context.setAttribute("testAppDomain", "hello application!");
        return "success";
    }
}
