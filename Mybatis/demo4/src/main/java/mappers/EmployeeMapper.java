package mappers;

import java.util.List;
import pojo.Employee;

public interface EmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbg.generated Sun Mar 20 23:01:14 CST 2022
     */
    int deleteByPrimaryKey(Integer eid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbg.generated Sun Mar 20 23:01:14 CST 2022
     */
    int insert(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbg.generated Sun Mar 20 23:01:14 CST 2022
     */
    Employee selectByPrimaryKey(Integer eid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbg.generated Sun Mar 20 23:01:14 CST 2022
     */
    List<Employee> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbg.generated Sun Mar 20 23:01:14 CST 2022
     */
    int updateByPrimaryKey(Employee record);
}