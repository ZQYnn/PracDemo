package web.pack.service;


import web.pack.domain.Numbers;

import java.util.List;

public interface numbersService {

    public List<Numbers> findNumbers(String dormid);
    public Numbers findNumberbyid(String stuid);
    public void update(Numbers numbers);
    public  void add(Numbers numbers);
    public void del(String stuid);
    public void delSelecteduser(String [] uids);

}
