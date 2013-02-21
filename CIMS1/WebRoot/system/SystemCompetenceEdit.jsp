﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

	</head>
	<body>
${pageJavaScripStar}<form name="produceForm" id="frmEdit" method="post"  action="${btnEditCommandArgument}" >

<table border="0" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr>
    <td>
权限编号    </td>
    <td>
<input name="competenceid" type="text" id="txtCompetenceidEdit" value="${Competenceid}" title="权限编号" size="20" maxlength="8" />    </td>
  </tr>
  <tr>
    <td>
权限名称    </td>
    <td>
<input name="competencename" type="text" id="txtCompetencenameEdit" value="${Competencename}" title="权限名称" size="20" maxlength="50" />    </td>
  </tr>
  <tr>
    <td>
权限描述    </td>
    <td>
<input name="description" type="text" id="txtDescriptionEdit" value="${Description}" title="权限描述" size="60" maxlength="500" />    </td>
  </tr>
  <tr>
    <td>
启用标志    </td>
    <td>
<select name="isUse" id="dropIsUseEdit"  style="width:15%" title="启用标志">
${IsUseEdit}
</select>
<script type="text/javascript">document.getElementById('dropIsUseEdit').value='${IsUse}';</script>    </td>
  </tr>
  <tr>
    <td colspan="2" align="center">
    <input type="submit" name="btnSubmit" id="btnSubmit" value="保存" onclick="if (checkForm()) {return true;} return false;"/>
    <input type="button" name="btnReturn" id="btnReturn" value="取消" onclick="window.location.href=window.location.pathname + '?${pageListUrl}'" />    </td>
  </tr>
</table>

</form>
${pageJavaScripEnd}
	</body>
</html>
