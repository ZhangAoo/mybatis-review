package all.mapper;

import all.pojo.User;
import all.utils.MybatisUtils;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

/**
 * 一级缓存是默认开启的，只在一次SqlSession中有效，也就是拿到连接到关闭连接这个区段
 * 一级缓存相当于一个 Map
 */

public class UserMapperTest extends TestCase {
    public void test01(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);

//        sqlSession.clearCache();//手动清理缓存
        sqlSession.close();//一级缓存关闭后 ，将数据保存入二级缓存，再次会话请求直接会进入二级缓存

        System.out.println("-------------------------");

        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.queryUserById(1);
        System.out.println(user1);
        System.out.println(user==user1);


        sqlSession.close();
    }


}