package top.rocyuan.entity;

public class User {
    private Integer id;
    private String userName;
    private String password;
    private String nickName;
    private String avatar;
    private Integer sex;
    private Integer age;
    private String addTime;
    private String updateTime;

    public User(Integer id, String userName, String password, String nickName, String avatar, String addTime, String updateTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.avatar = avatar;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }

    public User() {
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
