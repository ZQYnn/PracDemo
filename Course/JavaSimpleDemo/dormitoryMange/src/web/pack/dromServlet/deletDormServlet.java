package web.pack.dromServlet;

import web.pack.domain.Dorm;
import web.pack.domain.Numbers;
import web.pack.service.dormService;
import web.pack.service.impl.dormServiceImpl;
import web.pack.service.impl.numbersServiceImpl;
import web.pack.service.numbersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/deletDormServlet")
public class deletDormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String dormid = request.getParameter("dormid");
        System.out.println("--"+dormid);
        numbersService servicenum = new numbersServiceImpl();
        dormService servicedrom = new dormServiceImpl();
        List<Numbers> numbersList = servicenum.findNumbers(dormid);

        if (numbersList.size() == 0){
            servicedrom.delteDorm(dormid);
            response.sendRedirect(request.getContextPath()+"/dormListServlet");
        }else {
            response.sendRedirect(request.getContextPath()+"/dormListServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
