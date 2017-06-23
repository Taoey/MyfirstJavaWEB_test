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
		request.setCharacterEncoding("utf-8");//������ύ������ɵı���������
		response.setContentType("text/html;charset=utf-8");
		//��ȡ�û�������,�û���Ϊ�û�������
		String name=request.getParameter("log");
		String password=request.getParameter("pwd");		
		
		try {
			if(UserDao.valiNamepsw(name, password)){
				//�ض�����ҳ
				String userName=UserDao.getName(name);
				request.getSession().setAttribute("user", userName);
				
				response.sendRedirect(request.getContextPath()+"/index.jsp");
				return;//д�ض������ʱ��ϰ�ߣ���д���ض����дreturn����ֹ�ض���֮��Ĵ�����Ȼִ��
				
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
