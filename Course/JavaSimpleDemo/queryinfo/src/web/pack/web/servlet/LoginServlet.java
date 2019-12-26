package web.pack.web.servlet;


import org.apache.commons.beanutils.BeanUtils;
import web.pack.domain.admin;
import web.pack.domain.user;
import web.pack.service.UserService;
import web.pack.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //2.获取验证码数据
        String verifycodes = request.getParameter("verifycode");
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        // 确保验证码的一次行
        session.removeAttribute("CHECKCODE_SERVER");


        //3 .验证码的校验
        if (!checkcode_server.equalsIgnoreCase(verifycodes)){
            // 如果提示的信息不正确
            request.setAttribute("login_msg","请输入正确的验证吗");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;

        }
        Map<String, String[]> map = request.getParameterMap();

        //4.封装user 对象 使用 Apache 中的common方法

        admin admins= new admin();
        try {
            BeanUtils.populate(admins,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
      // 5使用Service进行查询
        UserService service = new UserServiceImpl();
         admin loginuser =service.adminLogin(admins);

        if (loginuser != null){
            // 登录信息 提示
            // 客户信息存到session 中
            session.setAttribute("users",loginuser);
            //重定向页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            //提示信息
            request.setAttribute("login_msg","账号或者密码错误");
            //跳转登录remain
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
