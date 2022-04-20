package lecture.more;

import lecture.bean.Customers;
import lecture.statement.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.time.LocalDate;

public class BlobTest {

    @Test
    void testBlob1(){
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream fis = null;
        {
            try {
                conn = JDBCUtils.getConnection();
                String sql = "insert into customers(name, email, birth, photo) values(?,?,?,?)";
                ps = conn.prepareStatement(sql);

                ps.setString(1, "徐海强");
                ps.setString(2, "xhq@11.com");
                ps.setObject(3, LocalDate.of(2011,2,3));
                //插入Blob类数据
                fis = new FileInputStream("C:\\Users\\Sarah Cheung\\Pictures\\eg.jpg");
                ps.setBlob(4, fis);

                ps.execute();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                JDBCUtils.closeResource(conn,ps);
            }
        }
    }

    @Test
    void testBlob2(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is  = null;
        OutputStream os = null;

        try{
            conn = JDBCUtils.getConnection();
            String sql = "SELECT id, name, email, birth, photo FROM customers WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, 22);

            rs = ps.executeQuery();
            if(rs.next()){
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                Date birth = rs.getDate(4);
                Customers cust = new Customers(id, name, email, birth);
                System.out.println(cust);

                //读取Blob数据
                Blob blob = rs.getBlob(5);
                is = blob.getBinaryStream();
                os = new FileOutputStream("copy.jpg");
                int len = 0;
                byte[] buffer = new byte[1024];
                while((len = is.read(buffer)) != -1){
                    os.write(buffer, 0, len);
                }
            }

        } catch(Exception e){
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);

            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
