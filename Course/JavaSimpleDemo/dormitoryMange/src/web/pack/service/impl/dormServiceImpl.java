package web.pack.service.impl;

import web.pack.dao.dormDao;
import web.pack.dao.impl.dormDaoimpl;
import web.pack.domain.Dorm;
import web.pack.service.dormService;

import java.util.List;
import java.util.Map;

/**
 * @author zqynn
 * @date 2019/12/16- 9:50
 **/
public class dormServiceImpl  implements dormService {
    dormDao dao = new dormDaoimpl();
    @Override
    public List<Dorm> findAll() {
        return dao.findAll();
    }
    @Override
    public Dorm findDormbyid(String dormid) {
        return dao.findDormbyid(dormid);
    }

    @Override
    public void update(Dorm dorm) {
        dao.update(dorm);
    }
    @Override
    public void addDorm(Dorm dorm) {
        dao.add(dorm);
    }

    @Override
    public void delteDorm(String dormid) {
        dao.delete(dormid);
    }

    @Override
    public List<Dorm> findCondition(Map<String, String[]> map) {
        return dao.findCondition(map);
    }
}
