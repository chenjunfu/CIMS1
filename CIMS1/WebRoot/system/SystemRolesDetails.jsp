<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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

	</head>
	<body class="bb">
${pageJavaScripStar}
	${pageJavaScripStar}
<table border="0" cellpadding="0" cellspacing="0" id="tbDetails">
  <tr>
    <td>
角色编号
    </td>
    <td>
    <label id="labRolesidDetails">${Rolesid}</label>
    </td>
    <td>
角色名称
    </td>
    <td>
    <label id="labRolesnameDetails">${Rolesname}</label>
    </td>
  </tr>
  <tr>
    <td>
描述
    </td>
    <td>
    <label id="labDescriptionDetails">${Description}</label>
    </td>

    <td>
启用标志
    </td>
    <td>
    <label id="labIsUseDetails">${IsUselabel}</label>
    </td>
  </tr>
  <tr>
    <td colspan="2">
拥有权限
    </td>
    <td colspan="2">
    <table cellpadding="4" cellspacing="4">
 		<tr>
 		
    	<s:generator separator="," val="#request.Competenceid">
			<s:iterator status="sta" var="competencedatabaseid">
				<s:if test="#sta.index%5==0">
					</tr><tr>
				</s:if>
				<td><s:property value="%{@com.yun.bll.culture.SystemCompetenceProvider@GetSystemCompetenceInfoByDatabasecompetenceid(#request.competencedatabaseid).competencename}" /></td>
			</s:iterator>
			</s:generator>
    	</tr>
    </table>
    </td>
  </tr>
  <tr>
    <td colspan="4" style="text-align: center;">
    <input type="button" name="button" id="btnReturn" value="" onclick="window.location.href=window.location.pathname + '?${pageListUrl}'" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </td>
  </tr>
</table>
${pageJavaScripEnd}
${pageJavaScripEnd}
	</body>
</html>
