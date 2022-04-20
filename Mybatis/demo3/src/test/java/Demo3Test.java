import mappers.DynamicMapper;
import mappers.ResMapMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Department;
import pojo.Employee;

import java.util.ArrayList;
import java.util.List;

public class Demo3Test {

    @Test
    void testResMap1(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        ResMapMapper resMapMapper = session.getMapper(ResMapMapper.class);

        Employee employee = resMapMapper.getEmp(1);
        System.out.println(employee);
    }

    @Test
    void testResMap2(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        ResMapMapper resMapMapper = session.getMapper(ResMapMapper.class);

        Employee employee = resMapMapper.getEmpAndDeptName2(1);
        System.out.println(employee);
    }

    @Test
    void testResMap3(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        ResMapMapper resMapMapper = session.getMapper(ResMapMapper.class);

        Employee employee = resMapMapper.getEmpByStep(1);
        System.out.println(employee);
    }

    @Test
    void testResMapOneMore1(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        ResMapMapper resMapMapper = session.getMapper(ResMapMapper.class);

        Department department = resMapMapper.getDept(1);
        System.out.println(department);
    }

    @Test
    void testResMapOneMore2(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        ResMapMapper resMapMapper = session.getMapper(ResMapMapper.class);

        Department department = resMapMapper.getDeptByStep(2);
        System.out.println(department);
    }

    @Test
    void testDynamicIf(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        DynamicMapper dynamicMapper = session.getMapper(DynamicMapper.class);

        Employee employee = new Employee();
        employee.setEid(1);
        employee.setEmpName("Sarah");
        Employee result = dynamicMapper.getIfEmp(employee);
        System.out.println(result);
    }

    @Test
    void testDynamicWhere(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        DynamicMapper dynamicMapper = session.getMapper(DynamicMapper.class);

        Employee employee = new Employee();
        employee.setEid(1);
        employee.setAge(22);
        Employee result = dynamicMapper.getIfEmp(employee);
        System.out.println(result);
    }

    @Test
    void testDynamicChoose(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        DynamicMapper dynamicMapper = session.getMapper(DynamicMapper.class);

        Employee employee = new Employee();
        Employee result = dynamicMapper.getChooseEmp(employee);
        System.out.println(result);
    }

    @Test
    void testDynamicForeach1(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        DynamicMapper dynamicMapper = session.getMapper(DynamicMapper.class);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(null,"a1",23,'男',"123@qq.com"));
        employees.add(new Employee(null,"a2",23,'男',"123@qq.com"));
        employees.add(new Employee(null,"a3",23,'男',"123@qq.com"));
        dynamicMapper.insertEmps(employees);
    }

    @Test
    void testDynamicForeach2(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        DynamicMapper dynamicMapper = session.getMapper(DynamicMapper.class);

        dynamicMapper.deleteEmps(new int[]{7,8,9});
    }
}
