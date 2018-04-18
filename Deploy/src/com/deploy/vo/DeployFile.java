package com.deploy.vo;

public class DeployFile {
	private int fileid;	
	private String issuename;
	private String platform;
	private String project;
	private String comptime;
	private String status;
	private String deploytime;
	private String note;
	public int getFileid() {
		return fileid;
	}
	public void setFileid(int id) {
		this.fileid = id;
	}
	public String getIssuename() {
		return issuename;
	}
	public void setIssuename(String issuename) {
		this.issuename = issuename;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getComptime() {
		return comptime;
	}
	public void setComptime(String comptime) {
		this.comptime = comptime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDeploytime() {
		return deploytime;
	}
	public void setDeploytime(String deploytime) {
		this.deploytime = deploytime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
