package web.pack.domain;

/**
 * @author zqynn
 * @date 2019/12/16- 9:36
 **/
public class Dorm {
    private String name;
    private String dormid;
    private String level;
    private String gender;
    private String description;
    private String apart;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDormid() {
        return dormid;
    }

    public void setDormid(String dormid) {
        this.dormid = dormid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApart() {
        return apart;
    }

    public void setApart(String apart) {
        this.apart = apart;
    }

    @Override
    public String toString() {
        return "dorm{" +
                "name='" + name + '\'' +
                ", dormid='" + dormid + '\'' +
                ", level='" + level + '\'' +
                ", gender='" + gender + '\'' +
                ", description='" + description + '\'' +
                ", apart='" + apart + '\'' +
                '}';
    }
}
