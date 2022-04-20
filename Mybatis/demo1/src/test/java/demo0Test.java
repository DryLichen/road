import bean.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo0Test {
    @Test
    void testUser() throws IOException {
        SqlSession session = SqlUtil.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        //执行sql语句
        int count = userMapper.insertUser(new User(null, "王二", "sadkjgf", 35, "男"));
        System.out.println("The amount of data be modified: " + count);
    }

    @Test
    void testDelete(){
        SqlSession session = SqlUtil.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        int count = userMapper.deleteUser(3);
        System.out.println("The amount of data be modified: " + count);
    }

    @Test
    void testUpdate(){
        SqlSession session = SqlUtil.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        int count = userMapper.updateUser("Elio", "000000", 1);
        System.out.println("The amount of data be modified: " + count);
    }

    @Test
    void testUpdate2(){
        SqlSession session = SqlUtil.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "admin");
        map.put("password", "fiuasdftgr342o5");
        map.put("id", 4);
        int count = userMapper.updateUser2(map);
        System.out.println("The amount of data be modified: " + count);
    }

    @Test
    void testGetUserById(){
        SqlSession session = SqlUtil.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = userMapper.getUserById(2);
        System.out.println(user);
    }

    @Test
    void testGetUserList(){
        SqlSession session = SqlUtil.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        List<User> userList = userMapper.getUserList();
        System.out.println(userList);
    }
}
