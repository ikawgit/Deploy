package com.deploy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求的方法
		String method = request.getParameter("method");
	
		if("LoginOut".equals(method)){ //退出系统
			loginOut(request, response);
		} else if("toAdminView".equalsIgnoreCase(method)){
		}
	}
	private void loginOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//退出系统时清除系统登录的用户
		//System.out.println("yes");
		request.getSession().removeAttribute("user");
		String contextPath = request.getContextPath();
		//System.out.println(contextPath);
		//转发到登录界面
		response.sendRedirect(contextPath+"/pages/login.jsp");
		}	
	}