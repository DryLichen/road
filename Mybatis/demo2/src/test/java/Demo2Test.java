import bean.User;
import mappers.SelectMapper;
import mappers.SpecialMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class Demo2Test {
    @Test
    void testSelect(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = session.getMapper(SelectMapper.class);

        User user = selectMapper.getUserById(1);
        System.out.println(user);

        List<User> userList = selectMapper.getUserList();
        System.out.println(userList);

        int count = selectMapper.getCount();
        System.out.println(count);

        Map<String, Object> map = selectMapper.getUserMap(1);
        System.out.println(map);

        List<Map<String, Object>> mapList = selectMapper.getUserMapList();
        System.out.println(mapList);


        Map<String, Object> map1 = selectMapper.getUserMapMaps();
        System.out.println(map1);
    }

    @Test
    void testSpecial(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        SpecialMapper specialMapper = session.getMapper(SpecialMapper.class);

        List<User> userList = specialMapper.getFuzzyUser("a");
        System.out.println(userList);

        System.out.println("number of deleted pieces of data: " + specialMapper.deleteUsers("3,4,5"));

        List<User> userList1 = specialMapper.getAllUser("t_user");
        System.out.println(userList1);
    }

    @Test
    void test2(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        SpecialMapper specialMapper = session.getMapper(SpecialMapper.class);

        User user = new User(null, "Caral", "1111111", 35, "女");
        specialMapper.insertUser(user);
        System.out.println(user);
    }
}
