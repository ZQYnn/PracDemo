package web.pack.numberServlet;

import org.apache.commons.beanutils.BeanUtils;
import web.pack.domain.Numbers;
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


@WebServlet("/updateNumberServlet")
public class updateNumberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String dromid = request.getParameter("dormid");

        Map<String, String[]> map = request.getParameterMap();
        Numbers numbers = new Numbers();
        try {
            BeanUtils.populate(numbers, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        numbersService service = new numbersServiceImpl();
        service.update(numbers);
        response.sendRedirect(request.getContextPath()+"/findNumbersServlet?dormid=" + dromid);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
