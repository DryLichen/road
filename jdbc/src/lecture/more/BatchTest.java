package lecture.more;

import lecture.statement.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.Instant;

public class BatchTest {

    //层次一，使用Statement
    @Test
    void test1() throws Exception{
        Connection conn = JDBCUtils.getConnection();
        Statement st = conn.createStatement();
        for(int i = 0;i <= 10000;i++){
            String sql = "insert into goods(name) values('name_" + i + "')";
            st.execute(sql);
        }
    }

    //use the ps
    @Test
    void test2() throws Exception{
        long start = Instant.now().toEpochMilli();

        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into goods(name) values(?)";
        PreparedStatement pst = conn.prepareStatement(sql);

        for(int i = 0;i <= 10000;i++){
            pst.setObject(1, "name_" + i);
            pst.execute();
        }
        long end = Instant.now().toEpochMilli();
        System.out.println("花费时间为(ms)：" + (end - start));

        JDBCUtils.closeResource(conn, pst);
    }

    //use batch()
    @Test
    void test3() throws Exception{
        long start = Instant.now().toEpochMilli();

        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into goods(name) values(?)";
        PreparedStatement pst = conn.prepareStatement(sql);

        for(int i = 0;i <= 10000;i++){
            pst.setObject(1, "name_" + i);

            pst.addBatch();
            if(i % 500 == 0){
                pst.executeBatch();
                pst.clearBatch();
            }
        }

        long end = Instant.now().toEpochMilli();
        System.out.println("花费时间为(ms)：" + (end - start));

        JDBCUtils.closeResource(conn, pst);
    }

    //使用Connection 的 setAutoCommit(false) / commit()
    @Test
    void test4() throws Exception{
        long start = Instant.now().toEpochMilli();

        Connection conn = JDBCUtils.getConnection();
        conn.setAutoCommit(false);
        String sql = "insert into goods(name) values(?)";
        PreparedStatement pst = conn.prepareStatement(sql);

        for(int i = 0;i <= 10000;i++){
            pst.setObject(1, "name_" + i);

            pst.addBatch();
            if(i % 500 == 0){
                pst.executeBatch();
                pst.clearBatch();
            }
        }

        conn.commit();

        long end = Instant.now().toEpochMilli();
        System.out.println("花费时间为(ms)：" + (end - start));
        JDBCUtils.closeResource(conn, pst);
    }
}
