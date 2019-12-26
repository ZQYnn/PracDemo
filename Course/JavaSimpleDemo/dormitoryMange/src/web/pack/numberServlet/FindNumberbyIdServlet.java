package web.pack.numberServlet;

import web.pack.domain.Numbers;
import web.pack.service.impl.numbersServiceImpl;
import web.pack.service.numbersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/FindNumberbyIdServlet")
public class FindNumberbyIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String stuid = request.getParameter("stuid");
        numbersService service = new numbersServiceImpl();
        Numbers number = service.findNumberbyid(stuid);
        request.setAttribute("number", number);
        //转发页面
        request.getRequestDispatcher("/updateNum.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
