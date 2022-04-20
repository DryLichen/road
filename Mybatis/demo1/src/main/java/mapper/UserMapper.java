package mapper;

import bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    // 1.添加用户信息，实体类参数
    int insertUser(User user);

    // 2.删除用户信息
    int deleteUser(Integer id);

    // 3.修改用户名及密码
    int updateUser(String username, String password, Integer id);

    int updateUser2(Map<String, Object> map);

    // 4.查询单个对象
    User getUserById(@Param("id") Integer id);

    // 5.查询集合对象
    List<User> getUserList();
}
