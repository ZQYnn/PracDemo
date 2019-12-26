package web.pack.web.servlet;

import web.pack.service.UserService;
import web.pack.service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/delServlet")
public class delServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过id删除学生信息
        String id = request.getParameter("id");
        //调用service方法实现信息删除
        UserService service = new UserServiceImpl();
        int intid = Integer.parseInt(id);
        service.delByid(intid);
        //跳转到用户列表的页面
        response.sendRedirect(request.getContextPath()+"/userlistservlet");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
