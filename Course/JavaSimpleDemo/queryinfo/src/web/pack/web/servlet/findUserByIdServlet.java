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



@WebServlet("/findUserByIdServlet")
public class findUserByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码集合
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");

        //通过service方式实现id查询
        UserService service = new UserServiceImpl();
        user users = service.findUserByid(id);

        //request设置作用域
        request.setAttribute("user", users);

        //将users信息转发到update.jsp页面中
        request.getRequestDispatcher("/update.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
