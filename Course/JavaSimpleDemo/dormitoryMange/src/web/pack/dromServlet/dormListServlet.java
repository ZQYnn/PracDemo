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


@WebServlet("/dormListServlet")
public class dormListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1调用user service
        dormService service = new dormServiceImpl();
        List<Dorm> dorms = service.findAll();
        //2将list 存入到requst作用域中
        request.setAttribute("dorms", dorms);
        //3转发到jsp 页面中
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
