package web.pack.dao.impl;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import web.pack.dao.dormDao;
import web.pack.domain.Dorm;


import web.pack.utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zqynn
 * @date 2019/12/16- 9:48
 **/

public class dormDaoimpl implements dormDao{
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Dorm> findAll() {
        String sql = "select * from dorm";
        List<Dorm> dorms = template.query(sql, new BeanPropertyRowMapper<Dorm>(Dorm.class));
        return  dorms;
    }
    @Override
    public Dorm findDormbyid(String dormid) {
        String sql = "select * from dorm where dormid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Dorm>(Dorm.class), dormid);
    }

    @Override
    public void update(Dorm dorm) {
        String sql = "update dorm set name = ? ,level = ?, gender = ?, description = ?, apart = ? where dormid = ?";
        template.update(sql, dorm.getName(), dorm.getLevel(), dorm.getGender(), dorm.getDescription(),dorm.getApart(), dorm.getDormid() );
    }

    @Override
    public void add(Dorm dorm) {
        String sql = "insert into dorm values(?, ?, ?, ?, ?, ?)";
        template.update(sql,dorm.getName(), dorm.getDormid(), dorm.getLevel(), dorm.getGender(), dorm.getDescription(), dorm.getApart());
    }




    @Override
    public List<Dorm> findCondition(Map<String, String[]> map) {
        // 建立动态sql 语句 实现
        String sql = "select * from dorm where 1 = 1";
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
        return template.query(sb.toString(), new BeanPropertyRowMapper<Dorm>(Dorm.class), params.toArray());
    }

    @Override

    public void delete(String dormid) {
        String sql = "delete from dorm where dormid = ?";
        template.update(sql,dormid);
    }

    // 条件的查

}
