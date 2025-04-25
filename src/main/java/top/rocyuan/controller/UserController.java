package top.rocyuan.controller;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.rocyuan.entity.User;
import top.rocyuan.mapper.UserMapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    // 查询列表-所有
    @GetMapping("/list")
    public ArrayList<User> list() {
        return userMapper.selectAll();
    }

    // 查询详情
    @GetMapping("/detail")
    public User detail(int id) {
        // return userMapper.selectById(id);
        return userMapper.selectByIdAnnotation(id);
    }

    // 查询列表-多条件查询（3种方式）
    // @GetMapping("/listSearch")
    // public ArrayList<User> list(@RequestParam Integer age, @RequestParam Integer sex, @RequestParam String nickName) {
    //     String _nickName = "%" + nickName + "%";
    //     // 1. 散装参数 @Param 方式
    //     return userMapper.selectByCondition(age, sex, _nickName);
    // }
    // @GetMapping("/listSearch")
    // public ArrayList<User> list(User user) {
    //     if (user.getNickName() != null) {
    //         user.setNickName("%" + user.getNickName() + "%");
    //     }
    //     // 2. User 实体类方式
    //     return userMapper.selectByCondition(user);
    // }
    @GetMapping("/listSearch")
    public ArrayList<User> list(@RequestParam Map<String, Object> map) {
        if (map.get("nickName") != null) {
            map.put("nickName", "%" + map.get("nickName") + "%");
        }
        // 3. Map 方式
        return userMapper.selectByCondition(map);
    }

    // 查询列表-单条件查询
    @GetMapping("/listSearchSingle")
    public ArrayList<User> listSingle(String field, String value) {
        User user = new User();
        if (field != null && value != null) {
            String _value = "%" + value + "%";
            BeanWrapperImpl beanWrapper = new BeanWrapperImpl(user);
            beanWrapper.setPropertyValue(field, _value);
        }
        return userMapper.selectByConditionSingle(user);
    }

    // 添加
    @PostMapping("/add")
    public int add(@RequestBody User user) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        user.setAddTime(format);
        userMapper.add(user);
        // 此时 id 为 null; 需在mybatis xml 中配置: useGeneratedKeys="true" keyProperty="id"
        return user.getId();
    }

    // 修改
    @PutMapping("/update")
    public int update(@RequestBody User user) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        user.setUpdateTime(format);
        userMapper.update(user);
        return user.getId();
    }

    // 删除
    @DeleteMapping("/deleteById")
    public void deleteById(int id) {
        userMapper.deleteById(id);
    }

    @DeleteMapping("/deleteByIds")
    public void deleteByIds(String ids) {
        int[] _ids = Arrays.stream(ids.split(",")).mapToInt(Integer::parseInt).toArray();
        userMapper.deleteByIds(_ids);
    }
}
