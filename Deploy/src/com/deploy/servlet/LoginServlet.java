package com.deploy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deploy.proxy.UserDaoProxy;
import com.deploy.vo.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String msg="";
		
		if(name==""||name==null){ //用户名输入格式问题
			//request.setAttribute("msg", "用户名不能为空");
			//request.getRequestDispatcher("./pages/login.jsp").forward(request,response);
			//return;
			msg = "nameError";
		}

		else if(password==""||password==null){//密码输入格式问题
			//request.setAttribute("msg", "密码名不能为空");
			//request.getRequestDispatcher("./pages/login.jsp").forward(request,response);
			//return;
			msg = "passwordError";
		}
	
		else {
			User user=new User();
			user.setName(name);
			user.setPassword(password);
			UserDaoProxy userDAOProxy=new UserDaoProxy();
			try {
				if(userDAOProxy.findLogin(user)){	
					request.getSession().setAttribute("user", user);
					//request.getSession().setAttribute("username", name);
					msg = "success";
					//request.getRequestDispatcher("/pages/index.jsp").forward(request,response);
				}else {
					//request.setAttribute("msg", "用户名或密码错误");
					//request.getRequestDispatcher("/pages/login.jsp").forward(request,response);
					msg = "notExist";
				}						
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().write(msg);
		response.getWriter().flush();
		response.getWriter().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
