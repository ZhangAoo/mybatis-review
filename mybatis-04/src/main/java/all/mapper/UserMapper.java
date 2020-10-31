package all.mapper;

import all.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUserList();
    //方法存在多个参数，所有的参数前面必须加@Param（"#{}"）
//    @Select("select * from user where id=1")
//    User getById(@Param("id")int id,@Param("name")String name);

    @Select("select * from user where id=1")
    User getById(@Param("id")int id);
    @Insert("insert into user(name,password)values(#{name},#{password})")
    int addUser(User user);
}
