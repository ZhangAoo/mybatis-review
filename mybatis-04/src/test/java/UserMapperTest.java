import all.mapper.UserMapper;
import all.pojo.User;
import all.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = mapper.getUserList();
//        for (User user : userList) {
//            System.out.println(user);
//        }

//        User user = mapper.getById(1);
//        System.out.println(user);

        mapper.addUser(new User("吼吼","159753"));
        sqlSession.close();
    }
}
