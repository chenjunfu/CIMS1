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

		<link rel="stylesheet" type="text/css" href="/css/AdminCss.css" />
		<link rel="stylesheet" type="text/css" href="/css/css.css" />
		<link rel="stylesheet" type="text/css" href="/css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="/js/colorwinglib.js"></script>
		<script type="text/javascript" src="/js/jquery.js"></script>
		<script type="text/javascript" src="/js/jquery-ui.js"></script>

	</head>
	<body>
${pageJavaScripStar}
<form name="produceForm" id="frmEdit" method="post"  action="${btnEditCommandArgument}">

<table border="0" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr>
    <td>
部门编号    </td>
    <td>
<input name="peoplesectorid" type="text" id="txtPeoplesectoridEdit" value="${Peoplesectorid}" title="部门编号" size="20" maxlength="8" />    </td>
  </tr>
  <tr>
    <td>
部门名称    </td>
    <td>
<input name="peoplesectorname" type="text" id="txtPeoplesectornameEdit" value="${Peoplesectorname}" title="部门名称" size="50" maxlength="50" />    </td>
  </tr>
  <tr>
    <td>
办公住址    </td>
    <td>
<input name="adress" type="text" id="txtAdressEdit" value="${Adress}" title="办公住址" size="50" maxlength="50" />    </td>
  </tr>
  <tr>
    <td>
电话    </td>
    <td>
<input name="phone" type="text" id="txtPhoneEdit" value="${Phone}" title="电话" size="20" maxlength="20" />    </td>
  </tr>
  <tr>
    <td>
单位</td>
    <td>
<select name="databaseunitid" style="width:19%" id="dropDatabaseunitidEdit" title="单位编号">
${DatabaseunitidEdit}
</select>
<script type="text/javascript">document.getElementById('dropDatabaseunitidEdit').value='${Databaseunitid}';</script>    </td>
  <
  </tr>
  <tr>
    <td colspan="2" align="center"><div align="center">
    <input type="submit" name="btnSubmit" id="btnSubmit" value="保存" onclick="if (checkForm()) {return true;} return false;"/>
    <input type="button" name="btnReturn" id="btnReturn" value="返回" onclick="window.location.href=window.location.pathname + '?${pageListUrl}'" />  </div>  </td>
  </tr>
</table>

</form>
${pageJavaScripEnd}
	</body>
</html>
