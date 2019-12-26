package web.pack.numberServlet;

import org.apache.commons.beanutils.BeanUtils;
import web.pack.domain.Numbers;
import web.pack.domain.user;
import web.pack.service.impl.numbersServiceImpl;
import web.pack.service.numbersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/addNumberServlet")
public class addNumberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Map<String, String[]> map = request.getParameterMap();

        // 封装对象
        Numbers numbers = new Numbers();
        String dormid = request.getParameter("dormid");
        try {
            BeanUtils.populate(numbers,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        numbersService service = new numbersServiceImpl();
        service.add(numbers);

        response.sendRedirect(request.getContextPath()+"/findNumbersServlet?dormid=" + dormid);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
