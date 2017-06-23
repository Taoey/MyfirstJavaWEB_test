package session.loginout;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class cookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//response.sendRedirect(request.getContextPath().toString());		
		Cookie cs[]=request.getCookies();
		Cookie findCookie=null;
		if(cs!=null){
			for(Cookie c : cs){
				if("lastTime".equals(c.getName())){
					findCookie=c;
				}
			}
		}
		if(findCookie==null){
			response.getWriter().write("您是第一次访问本网站!");
		}else {
			Long lastTime = Long.parseLong(findCookie.getValue());
			response.getWriter().write("您上次访问时间是:"+ new Date(lastTime).toLocaleString());
		}
		
		Date date = new Date();
		Cookie c = new Cookie("lastTime",date.getTime()+"");
		c.setMaxAge(3600*24*30);
		c.setPath(request.getContextPath());
		//c.setDomain(".baidu.com");
		response.addCookie(c);
		
		
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
