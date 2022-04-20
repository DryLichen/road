package lecture.statement;

import lecture.bean.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PreStateTest {

    @Test
    void testCud(){
        String sql1 = "UPDATE customers SET birth = ? WHERE id = ?";
        String date = "1980-06-06";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate newDate = LocalDate.parse(date, dtf);
        cud(sql1, newDate, 1);
    }

    @Test
    void testRetrieve(){
        String sql = "SELECT order_id as id, order_name as orderName FROM `order` WHERE order_id = ?";
        int id = 2;
        Order retrieve = retrieve(Order.class, sql, id);
        System.out.println(retrieve);
    }

    public void cud(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement pst = null;

        try{
            //1.获取连接
            conn = JDBCUtils.getConnection();

            //2.预编译 ps
            pst = conn.prepareStatement(sql);

            //3.填充占位符
            for(int i = 0;i < args.length;i++){
                pst.setObject(i + 1, args[i]);
            }

            //4.执行
            pst.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn, pst);
        }
    }

    public <T> T retrieve(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try{
            //1.完成prepareStatement
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);

            for(int i = 0;i < args.length;i++){
                pst.setObject(i + 1, args[i]);
            }

            //2.查询数据
            rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            if(rs.next()){
                T t = clazz.getConstructor().newInstance();

                for(int i = 0;i < rsmd.getColumnCount();i++){
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //反射给属性赋值
                    Field f = clazz.getDeclaredField(columnLabel);
                    f.setAccessible(true);
                    f.set(t, columnValue);
                }

                return t;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn, pst, rs);
        }

        return null;
    }
}
