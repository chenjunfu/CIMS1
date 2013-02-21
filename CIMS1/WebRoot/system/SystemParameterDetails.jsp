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

		<link rel="stylesheet" type="text/css" href="css/AdminCss.css" />
		<link rel="stylesheet" type="text/css" href="css/css.css" />
		<link rel="stylesheet" type="text/css" href="css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="js/colorwinglib.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>
		<style type="">
		
			td{
			width: 50%;
			}
		</style>
	</head>
	<body >
${pageJavaScripStar}
<table border="0"  cellpadding="0" cellspacing="0" id="tbEdit" align="center" style="width:40%">
  <tr> </tr>
  <tr>
    <td colspan="2" style="font:+5; color:#black;text-align:center;border-left: 1px solid #cedff7;" height="30">系统参数信息</td>
  </tr>
  <td style="border-left: 1px solid #cedff7;" > 单位名称 </td>
      <td><label id="labAdminidDetails">${unitname }</label>
      </td>
    </tr><tr>
      <td style="border-left: 1px solid #cedff7;"> 部门 </td>
      <td><label id="labAdminnameDetails">${dept}</label></td>
      <tr>
        <td style="border-left: 1px solid #cedff7;"> 地址 </td>
        <td><label id="labSectornameDetails">${address }</label></td>
        
      </tr>
      
 <tr><td style="text-align: center;border-left: 1px solid #cedff7;"  colspan="2"><input type="button" id="btnModify" value="" onclick="window.location.href='SystemParameter.do?pagetype=gotoupdate'"/></td></tr>
</table>
${pageJavaScripEnd}
	</body>
</html>
