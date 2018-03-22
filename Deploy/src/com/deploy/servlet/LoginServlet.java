package com.deploy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deploy.proxy.UserDaoProxy;
import com.deploy.vo.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name=request.getParameter("name");
	String password=request.getParameter("password");
	//List<String> info=new ArrayList<String>();
	if(name==null||"".equals(name)){ //用户名输入格式问题
		request.setAttribute("msg", "用户名不能为空");
		request.getRequestDispatcher("./login.jsp").forward(request,response);
		return;
	}

	if(password==null||"".equals(password)){//密码输入格式问题
		request.setAttribute("msg", "密码名不能为空");
		request.getRequestDispatcher("./login.jsp").forward(request,response);
		return;
	}
	
	if(name!=null&&password!=null){
		User user=new User();
		user.setName(name);
		user.setPassword(password);
		UserDaoProxy userDAOProxy=new UserDaoProxy();
		try {
			
			if(userDAOProxy.findLogin(user)){	
				request.getSession().setAttribute("username", name);
				request.getRequestDispatcher("./pages/index.jsp").forward(request,response);
			}else {
				request.setAttribute("msg", "用户名或密码错误");
				request.getRequestDispatcher("./login.jsp").forward(request,response);
			}						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
	}
}
