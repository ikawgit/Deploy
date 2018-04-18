package com.deploy.servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deploy.proxy.FileDaoProxy;
import com.deploy.vo.DeployFile;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class FileServlet extends HttpServlet{
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
		
		List<DeployFile> list = new LinkedList<>();
		FileDaoProxy filedaoproxy = new FileDaoProxy();
		try {
			list = filedaoproxy.getFileInfo("gpo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		//String result = JSONArray.fromObject(list).toString();
		//System.out.println(result);
		//response.getWriter().write(result);
		request.setAttribute("filelist", list);
		request.getRequestDispatcher("./pages/project-gpo-file.jsp").forward(request,response);
	}
	
	private void cpDeploy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<DeployFile> list = new LinkedList<>();
		FileDaoProxy filedaoproxy = new FileDaoProxy();
		
		try {
			list = filedaoproxy.getFileInfo("cp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("filelist", list);
		request.getRequestDispatcher("./pages/project-cp-file.jsp").forward(request,response);
	}
	
	private void tyDeploy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<DeployFile> list = new LinkedList<>();
		FileDaoProxy filedaoproxy = new FileDaoProxy();
		try {
			list = filedaoproxy.getFileInfo("ty");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String result = JSONObject.fromObject(list).toString();
		System.out.println(result);
		response.getWriter().write(result);
		//request.setAttribute("filelist", list);
		//request.getRequestDispatcher("./pages/project-ty-file.jsp").forward(request,response);		
	}
}

