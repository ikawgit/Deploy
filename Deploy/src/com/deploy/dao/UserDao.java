package com.deploy.dao;

import java.util.Map;

import com.deploy.vo.User;

public interface UserDao {
	
	public boolean findLogin(User user) throws Exception;

	public Map<String, String> getUserInfo(User user) throws Exception;
}
