package mappers;

import org.apache.ibatis.annotations.Param;
import pojo.Employee;

import java.util.List;

public interface DynamicMapper {
    // 测试if标签
    Employee getIfEmp(Employee employee);

    // 测试 where if
    Employee getWhereEmp(Employee employee);

    // 测试choose
    Employee getChooseEmp(Employee employee);

    // 测试 for each
    int insertEmps(@Param("emps") List<Employee> employees);
    int deleteEmps(@Param("eids") int[] eids);
}
