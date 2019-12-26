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


@WebServlet("/findDormByIdServlet")
public class findDormByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("dormid");
        dormService service = new dormServiceImpl();
        Dorm dorm = service.findDormbyid(id);
        request.setAttribute("dorm", dorm);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
