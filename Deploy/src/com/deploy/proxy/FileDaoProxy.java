package com.deploy.proxy;

import java.util.LinkedList;
import java.util.List;

import com.deploy.dao.FileDao;
import com.deploy.impl.FileDaoImpl;
import com.deploy.util.DatabaseConnection;
import com.deploy.vo.DeployFile;

public class FileDaoProxy implements FileDao {
    private DatabaseConnection dbc=null;//定义数据库连接
    private FileDao dao=null;//定义DAO接口
    public FileDaoProxy(){
    	try {
			dbc=new DatabaseConnection();//实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
    	dao=new FileDaoImpl(dbc.getConnection());
    	
    }
	@Override
	public List<DeployFile> getFileInfo(String platform) throws Exception {
		List<DeployFile> list = new LinkedList<>();
		try {
			list=dao.getFileInfo(platform);
		} catch (Exception e) {
			throw e;
		}finally{
			dbc.close();
		}
		return list;
	}
	@Override
	public int getTotalCount(String platform) throws Exception {
		int totalcount = 0;
		
		
		return totalcount;
	}
	@Override
	public int getPages(String platform) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
