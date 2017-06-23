package MyServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import session.loginout.UserDao;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");	
		String Email=request.getParameter("Email");
		System.out.println("getcon");
		
		try {
			if(UserDao.valiRegister(Email)){
				UserDao.insertUser(username, password, Email);
				System.out.println("getr");							
				
				response.sendRedirect(request.getContextPath()+"/html/jump.html");
				return;
			}
			else{//信息已被注册
				response.getWriter().write("邮箱已被占用，请重新注册");	
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
