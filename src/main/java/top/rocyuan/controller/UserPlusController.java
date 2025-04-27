package top.rocyuan.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.rocyuan.entity.User;
import top.rocyuan.entity.UserPlus;
import top.rocyuan.mapper.UserPlusMapper;
import top.rocyuan.utils.RocUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/*
 条件构造器 QueryWrapper<> 补充：

 等值查询 queryWrapper.eq("user_name", "admin");
 不等值查询 queryWrapper.ne("status", 0);

 范围查询：
 大于 queryWrapper.gt("age", 18);
 大于等于 queryWrapper.ge("age", 18);
 小于 queryWrapper.lt("age", 18);
 小于等于 queryWrapper.le("age", 18);
 范围查询 queryWrapper.between("age", 18, 35);

 模糊查询：
 模糊查询 queryWrapper.like("nick_name", "管理");
 左模糊查询 queryWrapper.likeLeft("nick_name", "管理");
 右模糊查询 queryWrapper.likeRight("nick_name", "管理");

 排序查询：
 升序 queryWrapper.orderByAsc("age");
 降序 queryWrapper.orderByDesc("age");

 逻辑查询：
 AND查询 queryWrapper.eq("user_name", "admin").and(w -> w.gt("age", 20).lt("age", 30));
 OR查询 queryWrapper.eq("status", 1).or().eq("status", 2);

 其他：
 指定列为NULL queryWrapper.isNull("update_time");
 指定列不为NULL queryWrapper.isNotNull("update_time");
 集合中 queryWrapper.in("id", ids);
 */

@RestController
@RequestMapping("userplus")
public class UserPlusController {

    @Autowired
    private UserPlusMapper userPlusMapper;

    // 查询列表-所有
    @GetMapping("/list")
    public List<UserPlus> list() {
        // 不指定任何条件
        QueryWrapper<UserPlus> queryWrapper = new QueryWrapper<>();
        return userPlusMapper.selectList(queryWrapper);
    }

    // 查询详情
    @GetMapping("/detail")
    public UserPlus detail(int id) {
        return userPlusMapper.selectById(id);
    }

    // 查询列表-多条件查询 （QueryWrapper）
    // @GetMapping("listSearch")
    // public List<UserPlus> list(UserPlus userPlus) {
    //     QueryWrapper<UserPlus> queryWrapper = new QueryWrapper<UserPlus>()
    //             .gt("age", userPlus.getAge())
    //             .eq("sex", userPlus.getSex())
    //             .like("nick_name", userPlus.getNickName());
    //     return userPlusMapper.selectList(queryWrapper);
    // }
    
    // 查询列表-多条件查询 （LambdaQueryWrapper）
    @GetMapping("listSearch")
    public List<UserPlus> list(UserPlus userPlus) {
        LambdaQueryWrapper<UserPlus> queryWrapper = new LambdaQueryWrapper<UserPlus>()
                .gt(UserPlus::getAge, userPlus.getAge())
                .eq(UserPlus::getSex, userPlus.getSex())
                .like(UserPlus::getNickName, userPlus.getNickName());
        return userPlusMapper.selectList(queryWrapper);
    }

    // 查询列表-单条件查询
    @GetMapping("/listSearchSingle")
    public List<UserPlus> listSingle(String field, String value) {
        QueryWrapper<UserPlus> queryWrapper = new QueryWrapper<>();
        String _field = RocUtils.camelToSnake(field);
        queryWrapper.like(_field, value);
        return userPlusMapper.selectList(queryWrapper);
    }

    // 添加
    @PostMapping("/add")
    public int add(@RequestBody UserPlus userPlus) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        userPlus.setAddTime(format);
        userPlusMapper.insert(userPlus);
        return userPlus.getId();
    }

    // 修改 基于 updateById
    @PutMapping("/update")
    public int update(@RequestBody UserPlus userPlus) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        userPlus.setUpdateTime(format);
        userPlusMapper.updateById(userPlus);
        return userPlus.getId();
    }

    // 删除
    @DeleteMapping("/deleteById")
    public void deleteById(int id) {
        userPlusMapper.deleteById(id);
    }

    @DeleteMapping("/deleteByIds")
    public void deleteByIds(String ids) {
        // 将逗号分隔的字符串转换为整数列表
        List<Integer> idList = Arrays.stream(ids.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        userPlusMapper.deleteByIds(idList);
    }
}
