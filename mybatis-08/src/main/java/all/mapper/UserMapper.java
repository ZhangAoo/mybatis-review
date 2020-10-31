package all.mapper;

import all.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * 只要开启了二级缓存，在同一个Mapper下就有效
 * 所有的数据都会先放到一级缓存中
 * 只有当会话提交，或者关闭时，才会提交到二级缓存中
 */
public interface UserMapper {
    User queryUserById(@Param("id") int id);
}
