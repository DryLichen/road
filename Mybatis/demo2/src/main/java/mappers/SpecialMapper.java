package mappers;

import bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialMapper {

    // 1.模糊查询
    List<User> getFuzzyUser(@Param("fuzzy") String fuzzy);

    // 2.批量删除
    int deleteUsers(@Param("ids") String ids);

    // 3.动态设置表名，展示所有用户信息
    List<User> getAllUser(@Param("tableName") String tableName);

    /**
     * 添加用户信息
     * useGeneratedKeys：设置使用自增的主键
     * keyProperty：因为增删改有统一的返回值是受影响的行数，因此只能将获取的自增的主键放在传输的参数user对象的某个属性中
     */
    int insertUser(User user);
}
