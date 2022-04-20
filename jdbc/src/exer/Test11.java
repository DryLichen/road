package exer;

import lecture.statement.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class Test11 {
//    public static void main(String[] args) {
//        Test11 test11 = new Test11();
//        Client.show();
//        Student student = test11.search(Client.symbol, Client.id);
//        if(student == null){
//            System.out.println("查无此人！请重新run");
//        }else {
//            System.out.println(student);
//        }
//    }

    /**
     * 练习题2之代码实现2，查询操作
     */
    private Student search(String symbol, String id) {
        CrudUtils cu = new CrudUtils();
        Student stu = null;
        if(symbol.equals("a")){
            String sql1 = "SELECT * FROM examstudent WHERE ExamCard = ?";
            try {
                stu = (Student) cu.retrieve(Class.forName("exer.Student"), sql1, id);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else{
            String sql2 = "SELECT * FROM examstudent WHERE IDCard = ?";
            try {
                stu = (Student) cu.retrieve(Class.forName("exer.Student"), sql2, id);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return stu;
    }

    private int delete(String symbol, String id){
        CrudUtils cu = new CrudUtils();
        int flag = 0;
        if(symbol.equals("a")){
            String sql1 = "DELETE FROM examstudent WHERE ExamCard = ?";
            flag = cu.update(sql1, id);
        } else {
            String sql2 = "DELETE FROM examstudent WHERE IDCard = ?";
            flag = cu.update(sql2, id);
        }
        return flag;
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        Client.show();
        int a = test11.delete(Client.symbol, Client.id);
        if(a > 0){
            System.out.println("删除成功");
        } else {
            System.out.println("查无此人");
        }
    }
}
