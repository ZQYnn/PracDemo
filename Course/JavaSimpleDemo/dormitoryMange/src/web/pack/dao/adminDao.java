package web.pack.dao;

import web.pack.domain.admin;


/**
 * @author zqynn
 * @date 2019/12/16- 9:45
 **/
public interface adminDao {
    public admin adminLogin(String username, String password);
}
