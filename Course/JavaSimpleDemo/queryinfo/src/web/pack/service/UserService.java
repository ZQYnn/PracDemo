package web.pack.service;


import web.pack.domain.admin;
import web.pack.domain.user;
import java.util.List;
import java.util.Map;

public interface UserService {
    //定义用户查询的接口
    public List<user> findAll();
    // 实现登录的
    public user login(user user);
    public admin adminLogin(admin admin);
    public void adduser(user user);
    public void  delByid(int id);
    public void update(user users);
    public user findUserByid(String id);
    public void delSelecteduser(String [] uids);
    public List<user> findCondition(Map<String, String[]> map );
}
