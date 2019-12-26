package web.pack.numberServlet;

import web.pack.service.impl.numbersServiceImpl;
import web.pack.service.numbersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/delNumberServlet")
public class delNumberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String stuid = request.getParameter("stuid");
        String dormid = request.getParameter("dormid");
        numbersService service = new numbersServiceImpl();
        service.del(stuid);
        response.sendRedirect(request.getContextPath()+"/findNumbersServlet?dormid=" + dormid);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
