package web.pack.service;

import web.pack.domain.Dorm;

import java.util.List;
import java.util.Map;

/**
 * @author zqynn
 * @date 2019/12/16- 9:43
 **/
public interface dormService {

    public List<Dorm> findAll();
    public Dorm findDormbyid(String dormid);
    public void update(Dorm dorm);
    public void addDorm(Dorm dorm);
    public void delteDorm(String dormid);
    public List<Dorm> findCondition(Map<String, String[]> map);
}
