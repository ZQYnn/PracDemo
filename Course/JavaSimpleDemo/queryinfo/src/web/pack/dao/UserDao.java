package web.pack.dao;

import web.pack.domain.admin;
import web.pack.domain.user;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<user> findAll();
    public user findUserByUsernameAndPassword(String username, String password);
    public admin adminLogin(String username, String password);
    public void adduser(user user);
    public void delByid(int id);
    public void update(user users);
    public user findUserByid(int id);
    public List<user> findCondition(Map<String, String[]> map);



}
