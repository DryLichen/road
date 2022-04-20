package exer;

import lecture.statement.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class Test1 {
    //章节练习题2-1,插入一个新的学生信息
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入考生的详细信息: ");
        System.out.println("Type: ");
        int type = scan.nextInt();
        System.out.println("IDCard: ");
        String id = scan.next();
        System.out.println("ExamCard: ");
        String ec = scan.next();
        System.out.println("StudentName: ");
        String sn = scan.next();
        System.out.println("Location: ");
        String loc = scan.next();
        System.out.println("Grade: ");
        int grade = scan.nextInt();

        CrudUtils cu = new CrudUtils();
        String sql = "INSERT INTO examstudent(Type, IDCard, ExamCard, StudentName, Location, Grade) VALUES (?,?,?,?,?,?)";
        int count = cu.update(sql, type, id, ec, sn, loc, grade);
        if(count > 0){
            System.out.println("信息录入成功");
        }else {
            System.out.println("添加失败");
        }
    }
}
