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

		<link rel="stylesheet" type="text/css" href="/css/css.css" />
		<link rel="stylesheet" type="text/css" href="/css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="/js/colorwinglib.js"></script>
		<script type="text/javascript" src="/js/jquery.js"></script>
		<script type="text/javascript" src="/js/jquery-ui.js"></script>

	</head>
	<body>
${pageJavaScripStar}
<table border="0" cellpadding="0" cellspacing="0" id="tbDetails">
  <tr>
    <td>
人才成果编号
    </td>
    <td>
    <label id="labTalentachievementidDetails">${Talentachievementid}</label>
    </td>
  </tr>
  <tr>
    <td>
成果
    </td>
    <td>
    <label id="labAchievementDetails">${Achievement}</label>
    </td>
  </tr>
  <tr>
    <td>
人才编号
    </td>
    <td>
    <label id="labTalentidDetails">${Talentid}</label>
    </td>
  </tr>
  <tr>
    <td colspan="2" align="center">
    <input type="button" name="button" id="button2" value="返回" onclick="window.location.href=window.location.pathname + '?${pageListUrl}'" />
    </td>
  </tr>
</table>

${pageJavaScripEnd}
	</body>
</html>
