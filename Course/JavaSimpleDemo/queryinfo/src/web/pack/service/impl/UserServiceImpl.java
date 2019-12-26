package web.pack.service.impl;

import web.pack.dao.UserDao;
import web.pack.dao.impl.UserDaoImpl;
import web.pack.domain.admin;
import web.pack.domain.user;
import web.pack.service.UserService;

import java.util.List;
import java.util.Map;


public class UserServiceImpl implements UserService  {
    private UserDao dao =  new UserDaoImpl();

    @Override
    public List<user> findAll() {
        return dao.findAll();
    }

    @Override
    public user login(user users) {
        return dao.findUserByUsernameAndPassword(users.getUsername(),users.getPassword());
    }

    @Override
    public admin adminLogin(admin admin) {
        return dao.adminLogin(admin.getUsername(), admin.getPassword());
    }

    @Override
    //在dao中添加用户的信息
    public void adduser(user user) {
        dao.adduser(user);
    }

    //使用id的方式删除学生id
    @Override
    public void delByid(int id) {
        dao.delByid(id);
    }

    //更新当前用户信息
    @Override
    public void update(user users) {
        dao.update(users);
    }

    //通过id查询信息
    @Override
    public user findUserByid(String id) {
        return dao.findUserByid(Integer.parseInt(id));
    }

    //删除每个选中的用户信息 通过寻宣布遍历就可
    @Override
    public void delSelecteduser(String[] uids) {
        for (String uid : uids){
            dao.delByid(Integer.parseInt(uid));
        }
    }

    @Override
    public List<user> findCondition(Map<String, String[]> map) {
        return dao.findCondition(map);
    }
}
