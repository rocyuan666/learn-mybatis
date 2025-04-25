package top.rocyuan.mapper;

import org.apache.ibatis.annotations.*;
import top.rocyuan.entity.User;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface UserMapper {

    /*
        MyBatis 参数传递，建议使用 @Param 修改 Map 集合中默认的键名！！！
        MyBatis 参数封装：
        - 单个参数：
            1. POJO类型：直接使用，属性名 和 参数占位符名称 一致
            2. Map集合：直接使用，键名 和 参数占位符名称 一致
            3. Collection：封装为 Map 集合，可以使用 @Param 注解，替换 Map 集合中默认的 arg 键名
                默认键名如下：
                map.put("arg0",collection集合);
                map.put("collection",collection集合);
            4. List：封装为 Map 集合，可以使用 @Param 注解，替换 Map 集合中默认的 arg 键名
                默认键名如下：
                map.put("arg0",list集合);
                map.put("collection",list集合);
                map.put("list",list集合);
            5. Array：封装为 Map 集合，可以使用 @Param 注解，替换 Map 集合中默认的 arg 键名（如批量删除地方就是用的 ids 替换了 array）
                默认键名如下：
                map.put("arg0",数组);
                map.put("array",数组);
            6. 其他类型：直接使用
        - 多个参数：封装为 Map 集合,可以使用 @Param 注解，替换 Map 集合中默认的 arg 键名
            默认键名如下：
            map.put("arg0",参数值1)
            map.put("param1",参数值1)
            map.put("param2",参数值2)
            map.put("agr1",参数值2)
            -------- 使用了 @Param("username") 默认的将被修改为如下： --------
            map.put("username",参数值1)
            map.put("param1",参数值1)
            map.put("param2",参数值2)
            map.put("agr1",参数值2)
     */


    /**
     * 查询所有列表，无查询条件
     */
    ArrayList<User> selectAll();

    /**
     * 查询详情
     */
    User selectById(int id);

    /**
     * 查询详情（注解方式）
     * 注解方式不常用！！！
     * 分为：
     * @Select("sql")
     * @Insert("sql")
     * @Delete("sql")
     * @Update("sql")
     *
     */
    @Select("select id, user_name as userName, password, nick_name as nickName, avatar, sex, age, add_time as addTime, update_time as updateTime from roc_user where id = #{id}")
    User selectByIdAnnotation(int id);

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
