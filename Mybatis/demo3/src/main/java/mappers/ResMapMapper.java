package mappers;

import org.apache.ibatis.annotations.Param;
import pojo.Department;
import pojo.Employee;

public interface ResMapMapper {

    // 查询employee，测试驼峰处理
    Employee getEmp(@Param("eid") Integer eid);

    // 1.查询职工表的部门姓名字段,用级联属性
    Employee getEmpAndDeptName1(@Param("eid") Integer eid);

    // 2.查询职工表的部门姓名字段，用association
    Employee getEmpAndDeptName2(@Param("eid") Integer eid);

    // 3.查询职工表的部门姓名字段，分步查询
    Employee getEmpByStep(@Param("eid") Integer eid);
    Department getDeptByDid(@Param("did") Integer did);



    /**********************************************************/

    // 1.查询部门中的员工信息，使用collection
    Department getDept(@Param("did") Integer did);

    // 2.查询部门中的员工信息，分步查询
    Department getDeptByStep(@Param("did") Integer did);
    Employee getEmpByDid(@Param("did") Integer did);
}
