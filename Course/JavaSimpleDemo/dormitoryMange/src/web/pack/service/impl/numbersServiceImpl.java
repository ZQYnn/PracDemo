package web.pack.service.impl;

import web.pack.dao.impl.numbersDaoimpl;
import web.pack.dao.numbersDao;
import web.pack.domain.Numbers;
import web.pack.service.numbersService;

import java.util.List;

/**
 * @author zqynn
 * @date 2019/12/16- 9:49
 **/
public class numbersServiceImpl implements numbersService{
    numbersDao dao = new numbersDaoimpl();
    @Override
    public List<Numbers> findNumbers(String dormid) {
        return dao.findNumbers(dormid);
    }


    @Override
    public Numbers findNumberbyid(String stuid) {
        return dao.findNumberByid(stuid);
    }

    @Override
    public void update(Numbers numbers) {
        dao.update(numbers);
    }

    @Override
    public void add(Numbers numbers) {
        dao.add(numbers);
    }

    @Override
    public void del(String stuid) {
        dao.delNumbers(stuid);
    }

    @Override
    public void delSelecteduser(String[] uids) {
        for (String s : uids){
            dao.delNumbers(s);
        }
    }
}
