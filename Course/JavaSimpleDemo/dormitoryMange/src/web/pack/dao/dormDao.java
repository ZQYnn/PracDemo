package web.pack.dao;

import web.pack.domain.Dorm;

import java.util.List;
import java.util.Map;

/**
 * @author zqynn
 * @date 2019/12/16- 9:42
 **/
public interface dormDao {
    public List<Dorm> findAll();
    public Dorm findDormbyid(String dormid);
    public void update(Dorm dorm);
    public void add(Dorm dorm);
    public List<Dorm> findCondition(Map<String, String[]> map);
    public void delete(String stuid);

}
