package web.pack.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import web.pack.domain.user;
import web.pack.service.UserService;
import web.pack.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码字符
        request.setCharacterEncoding("utf-8");

        // 获取更改信息参数
        Map<String, String[]> map = request.getParameterMap();

        user users = new user();

        //通过Beanutils方法封装数据获取 对应数据
        try {
            BeanUtils.populate(users, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService service = new UserServiceImpl();

        service.update(users);
        //重定向 到userlistservlte中实现数据的传输
        response.sendRedirect(request.getContextPath()+"/userlistservlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
