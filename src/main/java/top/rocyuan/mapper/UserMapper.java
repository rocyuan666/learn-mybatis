package top.rocyuan.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.rocyuan.entity.User;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface UserMapper {

    /**
     * 查询所有列表，无查询条件
     */
    ArrayList<User> selectAll();

    /**
     * 查询详情
     */
    User selectById(int id);

    /**
     * 查询列表 多条件查询
     * 1. 散装参数 @Param 方式
     * 2. User 对象方式
     * 3. Map 方式
     */
    // 1. 散装参数 @Param(field) 方式; field 需要与 xml 中 #{field} field 相同
    // ArrayList<User> selectByCondition(@Param("age") Integer age, @Param("sex") Integer sex, @Param("nickName") String nickName);
    // 2. User 实体类方式; 实体类属性 需要与 xml 中 #{field} field 相同
    // ArrayList<User> selectByCondition(User user);
    // 3. Map 方式; Map 中 key 需要与 xml 中 #{field} field 相同
    ArrayList<User> selectByCondition(Map<String, Object> map);

    /**
     * 查询列表 单条件查询
     */
    ArrayList<User> selectByConditionSingle(User user);

    /**
     * 添加
     */
    void add(User user);

    /**
     * 修改
     */
    void update(User user);

    /**
     * 删除
     */
    void deleteById(int id);

    /**
     * 批量删除
     * 不加 @Param xml 内部 会默认为: array 属性
     */
    void deleteByIds(@Param("ids") int[] ids);
}
