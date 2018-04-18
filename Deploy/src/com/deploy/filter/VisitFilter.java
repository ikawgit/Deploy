package com.deploy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deploy.vo.User;

/**
 * 如果用户没有登录，返回登录界面
 * @author bojiangzhou
 *
 */
public class VisitFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rep;
		
		User user = (User) request.getSession().getAttribute("user");
		
		String contextPath = request.getContextPath();
		//System.out.println(contextPath);//"/Deploy"
		
		String uri = request.getRequestURI();
		//System.out.println(uri);//"/Deploy/pages/login.jsp"
		uri = uri.substring(uri.lastIndexOf("/")+1, uri.length());
		//System.out.println(uri);//"login.jsp"
		
		if(!uri.contains("login.jsp")) {
			
			if(user == null){
				response.sendRedirect(contextPath+"/pages/login.jsp");
			} else{
				chain.doFilter(request, response);
			}
		}
		else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
