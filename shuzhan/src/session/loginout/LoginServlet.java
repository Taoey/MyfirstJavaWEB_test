package session.loginout;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//解决表单提交乱码造成的表单错误问题
		response.setContentType("text/html;charset=utf-8");
		//获取用户名密码,用户名为用户邮箱名
		String name=request.getParameter("log");
		String password=request.getParameter("pwd");		
		
		try {
			if(UserDao.valiNamepsw(name, password)){
				//重定向到主页
				String userName=UserDao.getName(name);
				request.getSession().setAttribute("user", userName);
				
				response.sendRedirect(request.getContextPath()+"/index.jsp");
				return;//写重定向代码时的习惯，即写完重定向就写return，防止重定向之后的代码仍然执行
				
			}else{
				response.sendRedirect(request.getContextPath()+"/html/passError.html");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
