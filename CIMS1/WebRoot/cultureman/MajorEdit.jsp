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
${pageJavaScripStar}<form name="produceForm" id="frmEdit" method="post"  action="${btnEditCommandArgument}" >

<table border="0" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr>
    <td>
专业编号
    </td>
    <td>
<input name="majorid" type="text" id="txtMajoridEdit" value="${Majorid}" title="专业编号" size="8" maxlength="8" />
    </td>
  </tr>
  <tr>
    <td>
专业名称
    </td>
    <td>
<input name="majorname" type="text" id="txtMajornameEdit" value="${Majorname}" title="专业名称" size="50" maxlength="50" />
    </td>
  </tr>
  <tr>
    <td>
描述
    </td>
    <td>
<input name="description" type="text" id="txtDescriptionEdit" value="${Description}" title="描述" size="60" maxlength="500" />
    </td>
  </tr>
  <tr>
    <td>
职称编号
    </td>
    <td>
<input name="farthermajorid" type="text" id="txtFarthermajoridEdit" value="${Farthermajorid}" title="职称编号" size="8" maxlength="8" />
    </td>
  </tr>
  <tr>
    <td>
深度
    </td>
    <td>
<input name="depth" type="text" id="txtDepthEdit" value="${Depth}" title="深度" size="8" maxlength="8" />
    </td>
  </tr>
  <tr>
    <td colspan="2" align="center">
    <input type="submit" name="btnSubmit" id="btnSubmit" value="${btnEditText}" onclick="if (checkForm()) {return true;} return false;"/>
    <input type="button" name="btnReturn" id="btnReturn" value="返回" onclick="window.location.href=window.location.pathname + '?${pageListUrl}'" />
    </td>
  </tr>
</table>

</form>
${pageJavaScripEnd}
	</body>
</html>
