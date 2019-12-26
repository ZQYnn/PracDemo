package web.pack.dao.impl;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import web.pack.domain.Dorm;
import web.pack.utils.JDBCUtils;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zqynn
 * @date 2019/12/16- 10:13
 **/
public class dormDaoimplTest {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    public void findAll() {
        String sql = "select * from dorm";
        List<Dorm> dorms = template.query(sql, new BeanPropertyRowMapper<Dorm>(Dorm.class));
        for (Dorm d :dorms){
            System.out.println(d.toString());
        }

    }
}