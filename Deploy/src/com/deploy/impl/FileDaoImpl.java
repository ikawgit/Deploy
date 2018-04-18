package com.deploy.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.deploy.dao.FileDao;
import com.deploy.vo.DeployFile;

public class FileDaoImpl implements FileDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public FileDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<DeployFile> getFileInfo(String platform) throws Exception {
		List<DeployFile> list = new LinkedList<>();
		try {
			String sql = "select id, issue, platform, project, comptime, status, deploytime, note from files where platform = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,platform);
		    ResultSet rs = pstmt.executeQuery();
		    while (rs.next()) {
		    	DeployFile file = new DeployFile();
		    	file.setFileid(rs.getInt("id"));
		    	file.setIssuename(rs.getString("issue"));
		    	file.setPlatform(rs.getString("platform"));
		    	file.setProject(rs.getString("project"));
		    	file.setComptime(rs.getString("comptime"));
		    	file.setStatus(rs.getString("status"));
		    	file.setDeploytime(rs.getString("deploytime"));
		    	file.setNote(rs.getString("note"));
		    	list.add(file);
		    }
			
		} catch (Exception e) {
			throw e;
		} finally {
			//关闭操作
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (Exception e) {
					throw e;				
				}
			}
		}
		return list;
	}

	@Override
	public int getTotalCount(String platform) throws Exception {
		int totalcount = 0;
		try {
			String sql = "select count(*) from files where platform = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,platform);
		    ResultSet rs = pstmt.executeQuery();
		    while (rs.next()) {
		    	totalcount=rs.getInt(0);
		    }
			
		} catch (Exception e) {
			throw e;
		} finally {
			//关闭操作
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (Exception e) {
					throw e;				
				}
			}
		}
		return totalcount;
	}

	@Override
	public int getPages(String platform) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
