package web.pack.web.servlet;

import web.pack.domain.user;
import web.pack.service.UserService;
import web.pack.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet("/findConditionServlet")
public class findConditionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 获取对应的map
        Map<String, String[]> map = request.getParameterMap();
        UserService service = new UserServiceImpl();
        List<user> conditionuser = service.findCondition(map);
        request.removeAttribute("users");
        request.setAttribute("users", conditionuser);

        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
