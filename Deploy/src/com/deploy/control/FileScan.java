package com.deploy.control;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import com.deploy.vo.DeployFile;;

public class FileScan {
	
	/**
     * 需求:从键盘输入接收一个文件夹路径,打印出该文件夹下所有的.java文件名
     * 分析:
     * 从键盘接收一个文件夹路径
     * 1,如果录入的是不存在,给与提示
     * 2,如果录入的是文件路径,给与提示
     * 3,如果是文件夹路径,直接返回
     * 打印出该文件夹下所有的.java文件名
     * 1,获取到该文件夹路径下的所有的文件和文件夹,存储在File数组中
     * 2,遍历数组,对每一个文件或文件夹做判断
     * 3,如果是文件,并且后缀是.java的,就打印
     * 4,如果是文件夹,就递归调用
     */
    public static void main(String[] args) {
    	String path= "D:\\gitproject\\GPO-2473";
    	File dir = new File(path);
    	scan(dir);
    }

    /*
     * 获取文件夹路径下的所.java文件
     * 1,返回值类型 void
     * 2,参数列表File dir
     */
    public static void scan(File dir) {
    	List<DeployFile> dflist = new LinkedList<>();
        //1,获取到该文件夹路径下的所有的文件和文件夹,存储在File数组中
        File[] subFiles = dir.listFiles();
        //2,遍历数组,对每一个文件或文件夹做判断
        for (File subFile : subFiles) {
            //3,如果是文件,并且后缀是.java的,就打印
            if(subFile.isFile() && subFile.getName().endsWith(".zip")) {
                System.out.println(subFile.getName());
                String filename = subFile.getName();
                String[] fileitem = filename.split("_");
                DeployFile dfile = new DeployFile();
                dfile.setPlatform(fileitem[0]);
                dfile.setProject(fileitem[1]);
                dfile.setComptime(fileitem[3]);
                dfile.setIssuename(fileitem[4]);
                dflist.add(dfile);
                System.out.println(dflist);
            //4,如果是文件夹,就递归调用
            }else if (subFile.isDirectory()){
            	scan(subFile);
            }
        }
    }
}
