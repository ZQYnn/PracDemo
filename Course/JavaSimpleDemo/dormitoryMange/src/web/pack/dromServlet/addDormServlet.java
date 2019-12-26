package web.pack.dromServlet;

import org.apache.commons.beanutils.BeanUtils;
import web.pack.domain.Dorm;
import web.pack.service.dormService;
import web.pack.service.impl.dormServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/addDormServlet")
public class addDormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取参数
        Map<String, String[]> map = request.getParameterMap();

        // 封装对象
        Dorm dorm = new Dorm();
        try {
            BeanUtils.populate(dorm,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //添加对象
        dormService service = new dormServiceImpl();
        service.addDorm(dorm);
        response.sendRedirect(request.getContextPath()+"dormListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
