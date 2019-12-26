package web.pack.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import web.pack.dao.numbersDao;
import web.pack.domain.Numbers;
import web.pack.utils.JDBCUtils;

import java.util.List;


public class numbersDaoimpl implements numbersDao{
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Numbers> findNumbers(String dormid) {
        String sql = "select * from numbers where dormid = ?";
        return  template.query(sql,new BeanPropertyRowMapper<Numbers>(Numbers.class), dormid);
    }

    @Override
    public Numbers findNumberByid(String stuid) {
        String sql = "select * from numbers where stuid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Numbers>(Numbers.class), stuid);
    }

    @Override
    public void update(Numbers numbers) {
        String sql = "update numbers set  name = ?, gender = ?, age = ? , dormid = ? where  stuid = ?";
        template.update(sql,numbers.getName(), numbers.getGender(), numbers.getAge(), numbers.getDormid(), numbers.getStuid());
    }
    
    @Override
    public void add(Numbers numbers) {
        String sql = "insert into numbers values (?,?,?,?,?)";
        template.update(sql, numbers.getStuid(), numbers.getName(), numbers.getGender(),numbers.getAge(),numbers.getDormid() );
    }

    @Override
    public void delNumbers(String stuid) {
        String sql = "delete from numbers where stuid = ?";
        template.update(sql, stuid);
    }
}
