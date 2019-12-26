package web.pack.service.impl;

import web.pack.dao.adminDao;
import web.pack.dao.impl.adminDaoimpl;
import web.pack.domain.admin;
import web.pack.service.adminService;

/**
 * @author zqynn
 * @date 2019/12/16- 9:49
 **/
public class adminServiceImpl implements adminService {
    adminDao dao = new adminDaoimpl();
    @Override
    public admin adminLogin(admin admin) {
        return dao.adminLogin(admin.getUsername(), admin.getPassword());
    }
}
