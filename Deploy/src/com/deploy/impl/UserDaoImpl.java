package com.deploy.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.deploy.dao.UserDao;
import com.deploy.vo.User;

public class UserDaoImpl implements UserDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean findLogin(User user) throws Exception {
		boolean flag = false;
		try {
			String sql = "select name from users where name = ? and loginpwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getName());
			pstmt.setString(2, user.getPassword());
		    ResultSet rs = pstmt.executeQuery();
		    if (rs.next()) {
		    	user.setName(rs.getString(1));//取得用户名
		    	flag=true;  
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
		return flag;
	}
	
	public Map<String, String> getUserInfo(User user) throws Exception {
		
		Map<String, String> userinfo = new HashMap<String, String>();
		try {
			String sql = "select * from users where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getName());
		    ResultSet rs = pstmt.executeQuery();
		    if (rs.next()) {
		    	user.setName(rs.getString(1));//取得用户名
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
		return userinfo;
		
		
	}
}
