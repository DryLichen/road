package pojo;

import java.util.List;

public class Department {
    private Integer did;
    private String deptName;
    private List<Employee> empList;

    public Department() {
    }

    public Department(Integer did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", empList=" + empList +
                '}';
    }
}
