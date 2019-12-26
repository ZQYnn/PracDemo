package web.pack.dao;

import web.pack.domain.Numbers;

import java.util.List;

/**
 * @author zqynn
 * @date 2019/12/16- 9:42
 **/
public interface numbersDao {
    public List<Numbers> findNumbers(String dormid);
    public Numbers findNumberByid(String stuid);
    public void update(Numbers numbers);
    public void add(Numbers numbers);
    public void delNumbers(String stuid);

}
