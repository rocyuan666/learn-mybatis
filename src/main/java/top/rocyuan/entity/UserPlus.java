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
