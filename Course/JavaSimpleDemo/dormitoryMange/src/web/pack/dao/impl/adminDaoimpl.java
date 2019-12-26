package web.pack.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import web.pack.dao.adminDao;
import web.pack.domain.admin;
import web.pack.utils.JDBCUtils;


public class adminDaoimpl implements adminDao{
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
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
}
