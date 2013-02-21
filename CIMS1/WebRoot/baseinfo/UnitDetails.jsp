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
		<link rel="stylesheet" type="text/css" href="css/public.css" />
		
		<link rel="stylesheet" type="text/css" href="css/css.css" />
		<link rel="stylesheet" type="text/css" href="css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="js/colorwinglib.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>

	</head>
	<body >
${pageJavaScripStar}
<table border="0" cellpadding="0" cellspacing="0" id="tbEdit" align="center"   style="width: 50%">
  <tr>
    <td>
单位ID
    </td>
    <td>
    <label id="labDatabaseunitidDetails">${Databaseunitid}</label>
    </td>
  </tr>
  <tr>
    <td>
单位编号
    </td>
    <td>
    <label id="labUnitidDetails">${Unitid}</label>
    </td>
  </tr>
  <tr>
    <td>
单位名称
    </td>
    <td>
    <label id="labUnitnameDetails">${Unitname}</label>
    </td>
  </tr>
  <tr>
    <td>
单位地址
    </td>
    <td>
    <label id="labAdressDetails">${Adress}</label>
    </td>
  </tr>
  <tr>
    <td>
联系电话
    </td>
    <td>
    <label id="labPhoneDetails">${Phone}</label>
    </td>
  </tr>
 
  
   <tr>
    <td  style="text-align: right; border-right: 0px solid ;">
      <input type="submit" name="btnSubmit" id="btnSubmit" value="编辑" onclick="javascript:window.location.href='?pagetype=gotoupdate&${pageListUrl}&databaseunitid=${Databaseunitid}'"/>
      &nbsp;&nbsp;&nbsp;&nbsp;
      </td>
      <td style="text-align: left; border-left: 0px solid;"  >
     <input type="button" name="button" id="btnReturn" value="" onclick="window.location.href=window.location.pathname + '?${pageListUrl}'" />
    </td>

  </tr>
</table>

${pageJavaScripEnd}
	</body>
</html>
