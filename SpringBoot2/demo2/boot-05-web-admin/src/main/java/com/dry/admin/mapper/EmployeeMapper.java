package com.dry.admin.mapper;

import com.dry.admin.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

// @Mapper
public interface EmployeeMapper {

    public Employee getEmployee(Integer eid);
}
