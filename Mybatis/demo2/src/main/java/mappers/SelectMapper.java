package mappers;

import bean.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    // 查询单个实体类对象
    User getUserById(@Param("id") Integer id);

    // 查询实体类对象集合
    List<User> getUserList();

    // 查询单个数据：用户记录总数
    int getCount();

    // 查询单条数据到map中
    Map<String, Object> getUserMap(@Param("id") Integer id);

    // 查询多条数据到map中
    List<Map<String, Object>> getUserMapList();

    // 查询多条数据到map中，以id为键，map为值
    @MapKey("username")
    Map<String, Object> getUserMapMaps();
}

