<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>menu</title>
<link rel="stylesheet" href="skin/css/base.css" type="text/css" />
<link rel="stylesheet" href="skin/css/menu.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script language='javascript'>var curopenItem = '1';</script>
<script language="javascript" type="text/javascript" src="skin/js/frame/menu.js"></script>
<base target="main" />
</head>
<body target="main">
<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
  <tr>
    <td style='padding-left:3px;padding-top:8px' valign="top">
	<!-- Item  Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items1_1")'><b>UAT2发布管理</b></dt>
        <dd style='display:block' class='sitem' id='items1_1'>
          <ul class='sitemu'>
           
            <li><a href='../FileServlet?project=gpo' target='main'>主系统_GPO_PAY</a> </li>
            <li><a href='../FileServlet?project=cp' target='main'>彩票系统_CP</a> </li>
            <li><a href='../FileServlet?project=ty' target='main'>体育系统_TY</a> </li>     
            <li><a href='project-file.html' target='main'>附件管理</a> </li>
          </ul>
        </dd>
      </dl>
      <!-- Item  End -->
	<!-- Item  Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items2_1")'><b>UAT1发布管理</b></dt>
        <dd style='display:none' class='sitem' id='items2_1'>
          <ul class='sitemu'>
            <li><a href='task-add.html' target='main'>创建任务</a> </li>
            <li><a href='task.html' target='main'>任务信息</a> </li>
            <li><a href='task-my.html' target='main'>我的任务</a> </li>
          </ul>
        </dd>
      </dl>
      <!-- Item  End -->
	<!-- Item  Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items5_1")'><b>权限管理</b></dt>
        <dd style='display:none' class='sitem' id='items5_1'>
          <ul class='sitemu'>
            <li><a href='user.html' target='main'>人员管理</a> </li>
            <li><a href='role.html' target='main'>角色管理</a> </li>
          </ul>
        </dd>
      </dl>
      <!-- Item  End -->
	<!-- Item  Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items6_1")'><b>我的信息</b></dt>
        <dd style='display:none' class='sitem' id='items6_1'>
          <ul class='sitemu'>
            <li><a href='info.html' target='main'>信息查看</a> </li>
            <li><a href='modpassword.html' target='main'>修改密码</a> </li>
          </ul>
        </dd>
      </dl>
      <!-- Item  End -->
    
	  </td>
  </tr>
</table>
</body>
</html>