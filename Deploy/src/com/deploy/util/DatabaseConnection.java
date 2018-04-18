/** 
*功能 定义数据库操作类
*作者 林炳文（ling20081005@126.com 博客：http://blog.csdn.net/evankaka） 
*时间 2015.4.22
*/
package com.deploy.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class DatabaseConnection {

	private static final String DBDRIVER="com.mysql.jdbc.Driver";
	private static final String DBURL="jdbc:mysql://localhost:3306/deploy?useSSL=false";
	private static final String DBUSER="root";
	private static final String DBPASS="123456";
    private Connection connection=null;
    
    public DatabaseConnection() {   	
    	try{
    		//数据库操作可能出现异常
    		Class.forName(DBDRIVER);
    		connection=DriverManager.getConnection(DBURL,DBUSER,DBPASS);	
    	}catch(Exception exception ){
    		exception.printStackTrace();
    	} finally {
		}
    }
    
    public Connection getConnection(){
    	return connection;
    }
    
    public void close() throws Exception{
    	if(connection!=null){
    		try {
    			connection.close();			
			} catch (Exception e) {
				throw e;
			}
    	}
    	
    }

}
