package com.deploy.dao;

import java.util.List;

import com.deploy.vo.DeployFile;

public interface FileDao {
	
	public List<DeployFile> getFileInfo(String platform) throws Exception;
	
	public int getTotalCount(String platform) throws Exception;
	
	public int getPages(String platform) throws Exception;

}
