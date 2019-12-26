package web.pack.dromServlet;

import web.pack.domain.Dorm;
import web.pack.service.dormService;
import web.pack.service.impl.dormServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet("/findDormconditionServlet")
public class findDormconditionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 获取对应的map
        Map<String, String[]> map = request.getParameterMap();
        dormService service = new dormServiceImpl();
        List<Dorm> conditiondorm = service.findCondition(map);
        request.removeAttribute("dorms");
        request.setAttribute("dorms", conditiondorm);
        request.getRequestDispatcher("/list.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
