package web.pack.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import web.pack.domain.user;
import web.pack.service.UserService;
import web.pack.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/addUserServlet")
public class addUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //获取参数
        Map<String, String[]> map = request.getParameterMap();

        // 封装对象
        user u = new user();
        try {
            BeanUtils.populate(u,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //获取的数据添加
        UserService service = new UserServiceImpl();
        service.adduser(u);
        //在此通过userlistservlet查询学生信息
        response.sendRedirect(request.getContextPath()+"/userlistservlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
