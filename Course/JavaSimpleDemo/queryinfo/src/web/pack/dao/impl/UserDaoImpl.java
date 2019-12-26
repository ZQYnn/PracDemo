package web.pack.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import web.pack.dao.UserDao;
import web.pack.domain.admin;
import web.pack.domain.user;
import web.pack.utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 **/
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<user> findAll() {
        //使用JDBC 实现数据库的连接操作
        String sql = "select * from user";
        List<user> users = template.query(sql, new BeanPropertyRowMapper<user>(user.class));
        return users;
    }
    @Override
    public user findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            user users = template.queryForObject(sql, new BeanPropertyRowMapper<user>(user.class), username, password);
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public admin adminLogin(String username, String password) {
        try {
            String sql = "select * from admin where username = ? and password  = ?";
            admin admin = template.queryForObject(sql, new BeanPropertyRowMapper<admin>(admin.class), username, password);
            return admin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void adduser(user user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        //2.执行sql
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());

    }

    @Override
    public void delByid(int id) {
        //1.定义sql
        String sql = "delete from user where id = ?";
        //2.执行sql
        template.update(sql, id);
    }

    //更新数据信息
    @Override
    public void update(user user) {
            String sql = "update user set name = ?,gender = ? ,age = ? , address = ? , qq = ?, email = ? where id = ?";
            template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public user findUserByid(int id) {
        String sql = "select * from user where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<user>(user.class), id);
    }

    @Override
    //通过查询添加的数据信息 实现对sql 语句的拼接
    public List<user> findCondition(Map<String, String[]> map) {
        // 建立动态sql 语句 实现
        String sql = "select * from user where 1 = 1";
        // stringbuilder实现数据的拼接
        StringBuilder sb = new StringBuilder(sql);
        List<Object> params = new ArrayList<>();
        //遍历map中的集合
        Set<String> keySet = map.keySet();
        for (String key :keySet){
            //获取value的值
           String value = map.get(key)[0];
           if (value != null && !"".equals(value)){
               sb.append(" and  " + key + " like ?");
               params.add("%" + value + "%");
           }
        }
        System.out.println(sb.toString());
        System.out.println(params);
       return template.query(sb.toString(), new BeanPropertyRowMapper<user>(user.class), params.toArray());
    }


}
