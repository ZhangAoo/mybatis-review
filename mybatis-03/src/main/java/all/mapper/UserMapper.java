package all.mapper;

import all.pojo.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    List<User> getUserLike(String value);

    User getUserById2(Map<String, Object> map);

    List<User> getUserByLimit(HashMap<String, Integer> map);




}
