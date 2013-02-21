<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title><%=com.yun.configuration.WebConfig.WEB_TITLE %></title>

		<link rel="stylesheet" type="text/css" href="css/public.css" />
		<link rel="stylesheet" type="text/css" href="css/css.css" />
		<link rel="stylesheet" type="text/css" href="css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="js/colorwinglib.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>
<style type="text/css">
input { border: 1px solid #bebebe; }
</style>
	</head>
	<body> <table border="0" cellpadding="0" cellspacing="0" id="tbEdit" align="center">
            <thead>
            <tr>
                <th width="20%">角色编号</th>
                <th width="20%">
                    &nbsp;角色名称</th>
                <th width="20%">
                    &nbsp;描述 </th>
                <th width="20%">
                    &nbsp;是否启用</th>
                <th width="40%">操作</th>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.SystemRolesList">
		
		<tr>
             <td>&nbsp;${iteList.rolesid}</td>
             <td>&nbsp;${iteList.rolesname}</td>
             <td>&nbsp;${iteList.description}</td>
			 <td>&nbsp;${iteList.isUselabel}</td>  				
             <td style="text-align: center;">
             	 <input id="editBut" type="button"  value="查看" onclick="window.location.href='?pagetype=Details&${pageListUrl}&databaserolesid=${iteList.databaserolesid}'" />
                 <input id="editBut" type="button"  value="编辑" onclick="window.location.href='?pagetype=gotoupdate&${pageListUrl}&databaserolesid=${iteList.databaserolesid}'" />
                 <input id="editBut" type="button"  value="删除" onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&${pageListUrl}&databaserolesid=${iteList.databaserolesid}'}" />  
                </td>                       
            </tr>
		</s:iterator>
            </table>     
            <table width="100%"><tr><td  style="text-align: center;">${pageDetails}</td></tr></table>	

	</body>
</html>

