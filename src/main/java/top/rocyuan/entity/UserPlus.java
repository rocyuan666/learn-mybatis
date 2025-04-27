package top.rocyuan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/*
Lombok 常用注解

@Getter  生成所有属性的 getter 方法
@Setter  生成非 final 属性的 setter 方法
@ToString  生成 toString 方法，用于返回包含类中所有字段的字符串表示
@AllArgsConstructor  生成全参构造方法
@NoArgsConstructor  生成无参构造方法
@RequiredArgsConstructor  为类中所有带有 final 修饰符的字段或者被 @NonNull 注解的字段生成一个包含这些字段的构造函数
@EqualsAndHashCode  自动生成 equals 和 hashCode 方法，用于比较对象是否相等和计算对象的哈希码

@Data  相当于加了 @Getter、@Setter、@ToString、@EqualsAndHashCode、@RequiredArgsConstructor
*/

/*
mybatis-plus 实体类注解
@TableName 声明表名
@TableId 声明主键字段 type 指定主键字段类型：
    IdType.AUTO（数据库自增）
    IdType.ASSIGN_ID（默认的，雪花算法生成唯一 ID）
    IdType.ASSIGN_UUID（使用 UUID 生成唯一 ID）
    IdType.NONE（未设置主键类型，MyBatis-Plus 不会主动处理主键生成，需要自己手动设置主键值）
    IdType.INPUT（手动输入，插入数据前要手动设置主键值，MyBatis-Plus 会使用你设置的值作为主键。）
@TableField 声明其他字段
*/

@Data
@TableName("roc_user")
public class UserPlus {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("user_name")
    private String userName;

    private String password;

    @TableField("nick_name")
    private String nickName;

    private String avatar;

    private Integer sex;

    private Integer age;

    @TableField("add_time")
    private String addTime;

    @TableField("update_time")
    private String updateTime;
}
