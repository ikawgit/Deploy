package com.deploy.proxy;

import java.util.HashMap;
import java.util.Map;

import com.deploy.dao.UserDao;
import com.deploy.impl.UserDaoImpl;
import com.deploy.util.DatabaseConnection;
import com.deploy.vo.User;

public class UserDaoProxy implements UserDao {
    private DatabaseConnection dbc=null;//定义数据库连接
    private UserDao dao=null;//定义DAO接口
    public UserDaoProxy(){
    	try {
			dbc=new DatabaseConnection();//实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
    	dao=new UserDaoImpl(dbc.getConnection());
    	
    }
	@Override
	public boolean findLogin(User user) throws Exception {
		boolean flag=false;
		try {
			flag=dao.findLogin(user);//调用真实主题
		} catch (Exception e) {
			throw e;
		}finally{
			dbc.close();
		}
		return flag;
	}
	@Override
	public Map<String, String> getUserInfo(User user) throws Exception {
		Map<String, String> userinfo = new HashMap<String, String>();
		try {
			userinfo=dao.getUserInfo(user);//调用真实主题
		} catch (Exception e) {
			throw e;
		}finally{
			dbc.close();
		}
		return userinfo;
	}
}
