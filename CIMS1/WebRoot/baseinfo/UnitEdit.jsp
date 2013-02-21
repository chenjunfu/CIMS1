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
	<body>
${pageJavaScripStar}<form name="produceForm" id="frmEdit" method="post"  action="${btnEditCommandArgument}" >

<table border="0" cellpadding="0" cellspacing="0" id="tbEdit" align="center" style="width: 50%">
  <tr>
    <td width="50%">
单位编号    </td>
    <td width="50%">
<input name="unitid" type="text" id="txtUnitidEdit" value="${Unitid}" title="单位编号" size="20" maxlength="8" />    </td>
  </tr>
  <tr>
    <td>
单位名称    </td>
    <td>
<input name="unitname" type="text" id="txtUnitnameEdit" value="${Unitname}" title="单位名称" size="20" maxlength="50" />    </td>
  </tr>
  <tr>
    <td>
单位地址    </td>
    <td>
<input name="adress" type="text" id="txtAdressEdit" value="${Adress}" title="单位地址" size="20" maxlength="50" />    </td>
  </tr>
  <tr>
    <td>
联系电话    </td>
    <td>
<input name="phone" type="text" id="txtPhoneEdit" value="${Phone}" title="联系电话" size="20" maxlength="20" />    </td>
  </tr>
  <tr>
    <td  style="text-align: right; border-right: 0px solid ;">
      <input type="submit" name="btnSubmit" id="btnSubmit" value="保存" onclick="if (checkForm()) {return true;} return false;"/>
      &nbsp;&nbsp;&nbsp;&nbsp;
      </td>
      <td style="text-align: left; border-left: 0px solid;"  >
     <input type="button" name="btnReturn" id="btnReturn" value="" onclick="window.location.href=window.location.pathname + '?${pageListUrl}'" /> 
     
    </td>

  </tr>
</table>

</form>
${pageJavaScripEnd}
	</body>
</html>
