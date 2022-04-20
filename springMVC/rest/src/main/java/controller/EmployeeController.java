package controller;

import bean.Employee;
import dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    //查询所有员工信息并显示到员工信息首页
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String employee(Model model){
        Collection<Employee> collection = employeeDao.getAll();
        model.addAttribute("employeeList", collection);
        return "employeeInfo";
    }

    //按id跳转到更新页面
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }

    //执行更新操作
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    //渲染并跳转到添加页面
    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public String toAdd(){
        return "employee_add";
    }

    //执行添加操作
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String add(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    //按id删除某员工并跳转回员工信息首页
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }
}
