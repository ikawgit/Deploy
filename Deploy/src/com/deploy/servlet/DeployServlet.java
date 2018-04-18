package com.deploy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeployServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String method = request.getParameter("method");
		String project = request.getParameter("project");
		
		if ("gpo".endsWith(project)) {
			gpoDeploy(request,response);
		} else if("cp".endsWith(project)) {
			cpDeploy(request,response);
		} else if("ty".endsWith(project)) {
			tyDeploy(request,response);
		}
	}
	
	private void gpoDeploy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("./pages/project-gpo-file.jsp").forward(request,response);
	}
	
	private void cpDeploy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("./pages/project-gpo-file.jsp").forward(request,response);
	}
	
	private void tyDeploy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("./pages/project-gpo-file.jsp").forward(request,response);
	}
}

