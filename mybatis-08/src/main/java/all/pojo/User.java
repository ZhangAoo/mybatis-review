package all.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 *     二级缓存没有定义参数，没有策略eviction，
 *   会报异常Error serializing object.Cause: java.io.NotSerializableException: all.pojo.User
 *     需要在实体类中序列化
 */
@Data
public class User implements Serializable {
    private int id;
    private String name;
    private String password;
}
