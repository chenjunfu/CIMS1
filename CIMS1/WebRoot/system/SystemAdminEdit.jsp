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
	<body >
${pageJavaScripStar}
<form name="produceForm" id="frmEdit" method="post"  action="SystemAdmin.do?pagetype=updataforself" >
<table border="0" cellpadding="0" cellspacing="0" id="tbEdit" align="center">

  <tr>
    <td colspan="8" style="font:+5; color:#black;text-align:center" height="30">用户信息修改
    <input type="hidden" name="databaseadminid" value="${Databaseadminid}"/>
    </td>
  </tr>
  <tr>
  <td> 人员编号 </td>
      <td class="datacon" ><label id="labAdminidDetails">${Adminid}</label>
      </td>
    <td> 帐号 </td>
    <td class="datacon"><label id="labAdminnameDetails">${Adminname}</label>
      </td>
    <td> 角色 </td>
    <td class="datacon"><label id="labRolesnameDetails">${RolesnameByRolesid}</label>
      </td>
    <td> 部门 </td>
    <td class="datacon"><label id="labSectornameDetails">${SectornameBySectorid}</label>
      </td>
  </tr>
  <tr>
    
    <td> 最后登录时间 </td>
    <td class="datacon"><label id="labLastLogintimeDetails">${LastLogintime}</label>
    </td>
    <td> 最后登录IP </td>
    <td class="datacon"><label id="labLastLoginipDetails">${LastLoginip}</label>
    </td>
    <td> 限定IP </td>
    <td class="datacon"><label id="labLimitIpDetails">${LimitIp}</label>
    </td>
    <td> 启用标志 </td>
    <td class="datacon"><label id="labIsUseDetails">${IsUselabel}</label>
    </td>
  </tr>
  <tr>
    <td colspan="8" style="font:+5; color:#black;text-align:center" height="30">人员信息</td>
  </tr>
  <tr>
    <td> 姓名 </td>
    <td colspan="" class="datacon"><label id="labTruenameDetails">${Truename}</label>
    </td>
    <td> 性别 </td>
    <td class="datacon"><label id="labSexDetails">${Sexlabel}</label>
    </td>
    <td> 工号 </td>
    <td class="datacon"><label id="labWorknoDetails">${Workno}</label>
    </td>
   <td> 创建时间 </td>
    <td class="datacon"><label id="labCreateTimeDetails">${CreateTime}</label>
    </td>
  </tr>
  <tr>
    <td> 移动电话 </td>
    <td class="datacon" ><input name="movephone" type="text" id="txtMovephoneEdit" value="${Movephone}" title="移动电话" size="15" maxlength="50" />
    </td>
    <td> 电话 </td>
    <td class="datacon"><input name="phone" type="text" id="txtPhoneEdit" value="${Phone}" title="电话" size="15" maxlength="50" /> 
    </td>
    <td> 联系EMAIL </td>
    <td class="datacon"><input name="email" type="text" id="txtEmailEdit" value="${Email}" title="联系EMAIL" size="15" maxlength="50" />
    </td>
    <td> 通讯地址 </td>
    <td class="datacon"><input name="address" type="text" id="txtAddressEdit" value="${Address}" title="通讯地址" size="15" maxlength="50" />
    </td>
  </tr>
  <tr>
    <td > 人员描述 </td>
    <td class="datacon"><label id="labDescriptionDetails">${Description}</label>
    </td>
    <td > 最后修改时间 </td>
    <td class="datacon"><label id="labLastModifytimeDetails">${LastModifytime}</label>
    </td>
     <td >&nbsp; </td>
    <td class="datacon"><label >&nbsp;</label>
    </td>
     <td >&nbsp; </td>
    <td class="datacon"><label >&nbsp;</label>
    </td>
  </tr>
  
   <tr>
    <td colspan="8" style="text-align: center;" width="100%">
    <table cellpadding="0" cellspacing="0" style="border: 0px solid; margin: 0px; padding: 5px" width="100%">
    	<tr>
    	<td style="text-align: right;padding-right: 50px;border: 0px"><input type="submit" name="btnSubmit" id="btnSubmit" value="保存" onclick="if (checkForm()) {return true;} return false;"/></td>
    	<td style="text-align: left; border: 0px"><input type="button" name="btnReturn" id="btnReturn" value="" onclick="window.location.href='SystemAdmin.do?pagetype=Details&databaseadminid=${Databaseadminid }'" /></td>
    	</tr>
    </table>
    </td>
  </tr>
</table>
${pageJavaScripEnd}
</form>
	</body>
</html>
<script>
$(function setTdbg()
 {
 	$(".datacon").each(function()
 	{
 		$(this).css({"background-color":"white"})
 	}
 	)
 })
 
</script>