package exer;

import lecture.statement.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class CrudUtils {
    public int update(String sql, Object... args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            for(int i = 0;i < args.length;i++){
                preparedStatement.setObject(i + 1, args[i]);
            }

            return preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection, preparedStatement);
        }

        return 0;
    }

    public <T> T retrieve(Class<T> clazz, String sql, String... args){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try{
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);

            for(int i = 0;i < args.length;i++){
                pst.setObject(i + 1, args[i]);
            }

            rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            if(rs.next()){
                T t = clazz.getConstructor().newInstance();
                for(int i = 0;i < rsmd.getColumnCount();i++){
                    Object columnVal = rs.getObject(i + 1);

                    Field field = clazz.getDeclaredField(rsmd.getColumnLabel(i + 1));
                    field.setAccessible(true);
                    field.set(t, columnVal);
                }

                return t;
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, pst, rs);
        }

        return null;
    }
}
