package com.dry.admin.service;

import com.dry.admin.bean.Employee;
import com.dry.admin.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public Employee getEmpByEid(Integer eid){
        return employeeMapper.getEmployee(eid);
    }
}
