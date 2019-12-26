package web.pack.domain;

/**
 * @author zqynn
 * @date 2019/12/16- 9:39
 **/
public class Numbers {
    private String stuid;
    private String name;
    private String gender;
    private int age;
    private  String dormid;

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDormid() {
        return dormid;
    }

    public void setDormid(String dormid) {
        this.dormid = dormid;
    }

    @Override
    public String toString() {
        return "numbers{" +
                "stuid='" + stuid + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", dormid='" + dormid + '\'' +
                '}';
    }
}
