<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function search(){
		
	}


</script>
<title>主系统_GPO_PAY</title>
<link rel="stylesheet" type="text/css" href="./pages/skin/css/base.css">
</head>
<body leftmargin="8" topmargin="8" background='./pages/skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="./pages/skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:UAT2>>GPO
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='project-file-add.html';" value='更新代码包' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='' method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='./pages/skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
        <td width='70'>
        	任务单号：
        </td>
        <td width='160'>
          	<input type='text' name='keyword' value='' style='width:120px' />
        </td>
        <td width='110'>
    		<select name='orderby' style='width:120px'>
            <option value='id'>排序...</option>
            <option value='pubdate'>构建时间</option>
            <option value='pubdate'>发布时间</option>
      	</select>
        </td>
        <td>
          &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="./pages/skin/images/frame/search.gif" width="45" height="20" border="0" class="np" onclick="search(); reture false;"/>
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
<!--  内容列表   -->
<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="./pages/skin/images/tbg.gif">&nbsp;附件列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="5%">序号</td>
	<td width="8%">单号</td>
	<td width="10%">发布平台</td>
	<td width="8%">附件个数</td>
	<td width="8%">文件时间戳</td>
	<td width="8%">发布状态</td>
	<td width="8%">发布时间</td>
	<td width="13%">操作</td>
</tr>

<c:forEach items="${filelist}" var="file" varStatus="liststatus">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>${liststatus.index + 1}</td>
	<td>${file.issuename}</td>
	<td>${file.project}</td>
	<td>3</td>
	<td>${file.comptime}</td>
	<td>${file.status}</td>
	<td>${file.deploytime}</td>
	<td><a href="#">下载</a> |<a href="#">删除</a> |<a href="./pages/project-file-edit.html">编辑</a> | <a href="./pages/project-file-look.html">查看详情</a></td>
</tr>
</c:forEach> 

<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="" class="coolbg">全选</a>
	<a href="" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="" class="coolbg">&nbsp;删除&nbsp;</a>
	<a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center">
	<input type="button" value="首页" onclick="firstpage(1)" />
	<input type="button" value="上一页" onclick="" />
	
	<input type="button" value="下一页" onclick="" />
    <input type="button" value="末页" onclick="" />
	
	</td>
</tr>
</table>

</form>
  

</body>
</html>