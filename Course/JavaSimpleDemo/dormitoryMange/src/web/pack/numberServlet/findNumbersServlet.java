package web.pack.numberServlet;


import web.pack.domain.Numbers;
import web.pack.service.impl.numbersServiceImpl;
import web.pack.service.numbersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


@WebServlet("/findNumbersServlet")
public class findNumbersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("dormid");
        HttpSession session =  request.getSession();

        session.setAttribute("dromid",id);

        numbersService service  = new numbersServiceImpl();
        List<Numbers> numbers = service.findNumbers(id);
        request.setAttribute("numbers", numbers);

        request.getRequestDispatcher("/NumbersList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
