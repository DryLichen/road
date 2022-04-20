package thymeleaf.myssm;

import org.apache.commons.dbutils.DbUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDAO<T> {
    //增删改
    public int update(Connection connection, String sql, Object... args){
        PreparedStatement ps = null;

        try{
            ps = connection.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(ps);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    //检索单条数据
    public <T> T getInstance(Connection connection, Class<T> tClass, String sql, Object... args){
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = connection.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();

            while (rs.next()){
                T t = tClass.getConstructor().newInstance();
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsCount = rsmd.getColumnCount();

                for(int i = 0;i < columnsCount;i ++){
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Field field = tClass.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                DbUtils.close(ps);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    //检索数据列表
    public <T> List<T> getList(Connection connection, Class<T> tClass, String sql, Object... args){
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = connection.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            ArrayList<T> arrayList = new ArrayList<T>();

            while (rs.next()){
                T t = tClass.getConstructor().newInstance();
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsCount = rsmd.getColumnCount();

                for(int i = 0;i < columnsCount;i ++){
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Field field = tClass.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                arrayList.add(t);
            }

            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                DbUtils.close(ps);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    //特殊检索，如group函数等
    public <T> T getValue(Connection connection, String sql, Object... args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = connection.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            while (rs.next()){
                return (T) rs.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                DbUtils.close(ps);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
