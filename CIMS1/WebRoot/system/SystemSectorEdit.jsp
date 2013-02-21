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

	</head>
	<body>
${pageJavaScripStar}<form name="produceForm" id="frmEdit" method="post"  action="${btnEditCommandArgument}" >

<table border="0" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr>
    <td>
部门名称1    </td>
    <td>
<input name="sectorname" type="text" id="txtSectornameEdit" value="${Sectorname}" title="部门名称" size="30" maxlength="50" />    </td>
  </tr>
  <tr>
    <td>
部门描述    </td>
    <td><input name="description" type="text" id="txtDescriptionEdit" value="${Description}" title="部门描述" size="30" maxlength="500" /></td>
  </tr>
  <tr>
    <td>
启用标志    </td>
    <td>
<select name="isUse" id="dropIsUseEdit" style="width:20%" title="启用标志">
${IsUseEdit}
</select>
<script type="text/javascript">document.getElementById('dropIsUseEdit').value='${IsUse}';</script>    </td>
  </tr>
  <tr>
    <td>
是否删除    </td>
    <td>
<select name="isDel" id="dropIsDelEdit"  style="width:20%" title="是否删除">
${IsDelEdit}
</select>
<script type="text/javascript">document.getElementById('dropIsDelEdit').value='${IsDel}';</script>    </td>
  </tr>
  <tr>
    <td>
排序    </td>
    <td>
<input name="sorts" type="text" id="txtSortsEdit" value="${Sorts}" title="排序" size="8" maxlength="60" />    </td>
  </tr>
  <tr>
    <td colspan="2" align="center"><div align="center">
    <input type="submit" name="btnSubmit" id="btnSubmit" value="保存" onclick="if (checkForm()) {return true;} return false;"/>
    <input type="button" name="btnReturn" id="btnReturn" value="返回" onclick="window.location.href=window.location.pathname + '?${pageListUrl}'" /> </div>   </td>
  </tr>
</table>

</form>
${pageJavaScripEnd}
	</body>
</html>
