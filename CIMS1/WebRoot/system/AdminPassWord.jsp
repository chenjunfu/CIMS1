<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	
	<%@page import="com.yun.ui.action.UserLook" %>
	<%	
		
		UserLook userlook = new UserLook(request,response);
		if(userlook.getAdminname().equals(""))
		{
			response.sendRedirect("../loginOut.jsp");
			return;
		}
		userlook.seePageY("19");
	%>

		<title><%=com.yun.configuration.WebConfig.WEB_TITLE %></title>

		<link rel="stylesheet" type="text/css" href="../css/AdminCss.css" />
		<link rel="stylesheet" type="text/css" href="../css/css.css" />
		<link rel="stylesheet" type="text/css" href="../css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="../js/colorwinglib.js"></script>
		<script type="text/javascript" src="../js/jquery.js"></script>
		<script type="text/javascript" src="../js/jquery-ui.js"></script>
	<style type="text/css">
		
	</style>
	</head>
	<body>

    
    <form id="form3" name="form3" method="post" action="SystemAdmin.do?pagetype=modifypw&databaseadminid=<%=userlook.getDatabaseadminid()%>">
      <table border="0" cellpadding="0" cellspacing="0" id="tbEdit" align="center" style="width: 30%;top: 0px" >
	  <tr><td colspan="2" style="font:+5; color:#black;text-align:center;border-left: 1px solid #cedff7;" height="30">用户密码修改</td></tr>
  <tr >
    <td style="border-left: 1px solid #cedff7;">
用户名    </td>
    <td>
<input name="adminname" type="text" id="txtAdminidEdit" style="width:50%"  title="登录人员" size="8" maxlength="8"
value="<s:property value="#session.AdminUserInfoadminname" />"
 />    
 
 <input name="adminid" type="hidden" id="txtAdminidEdit"  title="登录人员" size="8" maxlength="8"
value="<s:property value="#session.AdminUserInfoadminid" />"
 />   
 
 </td>
  </tr>
  <tr>
    <td style="border-left: 1px solid #cedff7;">
原始密码</td>
    <td><input name="oldpassword" type="password" class="textfield" style="width:50%" id="textfield2" size="50" /></td>
  </tr>
  <tr>
    <td style="border-left: 1px solid #cedff7;">
新密码    </td>
    <td>
<input name="password" type="password" id="txtPasswordEdit" style="width:50%" title="密码" size="50" maxlength="128" class="textfield"/>    </td>
  </tr>
  <tr>
    <td width="50%" style="border-left: 1px solid #cedff7;">
重新输入密码    </td>
    <td>
	<input name="password2" type="password" id="txtPasswordEdit2" style="width:50%" title="密码" size="50" maxlength="128" class="textfield" />
</td>
  </tr>
  <tr>
    <td colspan="2" align="center" style="border-left: 1px solid #cedff7;">
      <p><div align="center">
        <input name="Submit" type="submit" id="btnModify" onclick="if (checkForm()) {return true;} return false;"  value="" />    </div>
        </p></td>
  </tr>
</table>
		</form>

	</body>
	${pageJavaScripEnd}
	${pageJavaScripStar}
</html>


<script type="text/javascript">
function checkForm()
{

	if(document.getElementById("textfield2") && document.getElementById("textfield2").value == "")
    {
        alert("原始密码不能为空");
        document.getElementById("textfield2").focus();
        return false;
    }
    
    //密码
    if(document.getElementById("txtPasswordEdit") && document.getElementById("txtPasswordEdit").value == "")
    {
        alert("新密码不能为空");
        document.getElementById("txtPasswordEdit").focus();
        return false;
    }
    if(document.getElementById("txtPasswordEdit") && document.getElementById("txtPasswordEdit").value.length<6)
    {
        alert("新密码不能少于6位!");
        document.getElementById("txtPasswordEdit").focus();
        return false;
    }
    if(document.getElementById("txtPasswordEdit") && getLength(document.getElementById("txtPasswordEdit")) > 128 )
    {
        alert("新密码的长度不能为大于128");
        document.getElementById("txtPasswordEdit").focus();
        return false;
    }
    if(document.getElementById("txtPasswordEdit") && !patternPassWord.test(document.getElementById("txtPasswordEdit").value))
    {
        alert("请输入安全的密码!");
        document.getElementById("txtPasswordEdit").focus();
        return false;
    }
    if(document.getElementById("txtPasswordEdit") && document.getElementById("txtPasswordEdit").value!=document.getElementById("txtPasswordEdit2").value){
        alert("密码两次输入不同!");
        document.getElementById("txtPasswordEditRe").focus();
        return false;
    }
	  return true;
}
</script>
