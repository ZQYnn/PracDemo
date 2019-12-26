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


@WebServlet("/updatedormServlet")
public class updatedormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数的编码
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();

        Dorm dorm   = new Dorm();
        //通过Beanutils方法封装数据获取 对应数据
        try {
            BeanUtils.populate(dorm, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        dormService service = new dormServiceImpl();
        service.update(dorm);

        response.sendRedirect(request.getContextPath()+"/dormListServlet");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
