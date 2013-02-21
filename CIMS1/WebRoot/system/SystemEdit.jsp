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

		<title><%=com.yun.configuration.WebConfig.WEB_TITLE %></title>

		<link rel="stylesheet" type="text/css" href="css/css.css" />
		<link rel="stylesheet" type="text/css" href="css/public.css" />
		<link rel="stylesheet" type="text/css" href="css/smoothness/jquery-ui.css" />
		<link rel="stylesheet" type="text/css" href="css/smoothness/jquery-ui-1.7.custom.css">

		<script type="text/javascript" src="js/colorwinglib.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>
		
		<script type="text/javascript">
	$(function() {
		$("#tabs").tabs();
		$("#txtUserExpTimeEdit").datepicker();
		$("#txtPassExpTimeEdit").datepicker();
	});</script>
	
	<script>  
			function initradio(rName,rValue){  
			var rObj = document.getElementsByName(rName);  
				for(var i = 0;i < rObj.length;i++){  
						if(rObj[i].value == rValue){  
							rObj[i].checked =  'checked';  
						}  
				 }  
			 }  
		</script>  
		
	</head>
	<body class="bb">
	
	${pageJavaScripStar}
	<form name="produceForm" id="frmEdit" method="post"  action="${btnEditCommandArgument}" >

<div id="tabs">
	<ul>
		<li><a href="#tabs-1">部门信息</a></li>
		<li><a href="#tabs-2">人员信息</a></li>
	</ul>
	
	
	<div id="tabs-1">
			<table border="0" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr>
    <td>
部门名称    </td>
    <td>
<input name="sectorname" type="text" id="txtSectornameEdit" value="${Sectorname}" title="部门名称" size="30" maxlength="50" />    </td>
  
    <td>
部门描述    </td>
    <td><input name="description" type="text" id="txtDescriptionEdit" value="${Description}" title="部门描述" size="30" maxlength="500" /></td>
  </tr>
  <tr>
    <td>
启用标志    </td>
    <td>
<select name="isUse" id="dropIsUseEdit" style="width:30%" title="启用标志">
${IsUseEdit}
</select>
<script type="text/javascript">document.getElementById('dropIsUseEdit').value='${IsUse}';</script>    </td>
  
    <td>
是否删除    </td>
    <td>
<select name="isDel" id="dropIsDelEdit"  style="width:30%" title="是否删除">
${IsDelEdit}
</select>
<script type="text/javascript">document.getElementById('dropIsDelEdit').value='${IsDel}';</script>    </td>
  </tr>
  <tr>
    
  </tr>
  <tr>
    <td colspan="4" align="center"><div align="center">
    <input type="submit" name="btnSubmit" id="btnSubmit" value="保存" onclick="if (checkForm()) {return true;} return false;"/>
    <input type="button" name="btnReturn" id="btnReturn" value="返回" onclick="window.location.href=window.location.pathname + '?${pageListUrl}'" /> </div>   </td>
  </tr>
</table>
	</div>
	
	
	<div id="tabs-2">
			
			<table border="0" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr>
    <td>
人员编号    </td>
    <td>
<input name="adminid" type="text" id="txtAdminidEdit" value="${Adminid}" title="人员编号" size="20" maxlength="8" />    </td>
  
    <td>
帐号    </td>
    <td>
<input name="adminname" type="text" id="txtAdminnameEdit" value="${Adminname}" title="帐号" size="20" maxlength="50" />    </td>
  
    <td>
密码    </td>
    <td>
<input name="adminpassword" type="text" id="txtAdminpasswordEdit" value="${Adminpassword}" title="密码" size="20" maxlength="50" />    </td>
  </tr>
  <tr>
  
    <td>
性别    </td>
    <td align="left"><label><input type="radio" value="0" name="sex" />
                男　　 </label>
                  <label>
                  <input type="radio" value="1" name="sex" />
                    女 </label></td>
 
    <td>
姓名    </td>
    <td>
<input name="truename" type="text" id="txtTruenameEdit" value="${Truename}" title="姓名" size="20" maxlength="50" />    </td>
  
    <td>
工号    </td>
    <td>
<input name="workno" type="text" id="txtWorknoEdit" value="${Workno}" title="工号" size="20" maxlength="50" />    </td>
  </tr>
  <tr>
    <td>
联系EMAIL    </td>
    <td>
<input name="email" type="text" id="txtEmailEdit" value="${Email}" title="联系EMAIL" size="20" maxlength="50" />    </td>
  
    <td>
移动电话    </td>

    <td>
<input name="movephone" type="text" id="txtMovephoneEdit" value="${Movephone}" title="移动电话" size="20" maxlength="50" />    </td>
 
    <td>
电话    </td>
    <td>
<input name="phone" type="text" id="txtPhoneEdit" value="${Phone}" title="电话" size="20" maxlength="50" />    </td>
 </tr><tr>
    <td>
MSN    </td>
    <td>
<input name="msn" type="text" id="txtMsnEdit" value="${Msn}" title="MSN" size="20" maxlength="50" />    </td>
  
    <td>
角色    </td>
    <td>
<select name="rolesid" id="dropRolesidEdit" style="width:75%" title="角色编号">
${RolesidEdit}
</select>
<script type="text/javascript">document.getElementById('dropRolesidEdit').value='${Rolesid}';</script>    </td>
  
    <td>
部门    </td>
    <td>
<select name="sectorid2" id="dropSectoridEdit" style="width:75%" title="部门编号">
${SectoridEdit}
</select>
<script type="text/javascript">document.getElementById('dropSectoridEdit').value='${Sectorid}';</script>    </td>
   </tr>
   
   <tr>
    <td>
限定IP    </td>
    <td>
<input name="limitIp" type="text" id="txtLimitIpEdit" value="${LimitIp}" title="限定IP" size="20" maxlength="50" />    </td>
  
    <td>是否删除 </td>
    <td>
<select name="isDel2" id="dropIsDelEdit" style="width:75%" title="是否删除">
${IsDelEdit}
</select>
<script type="text/javascript">document.getElementById('dropIsDelEdit').value='${IsDel}';</script>    </td>
  
  
    <td>启用标志</td>
    <td>
<select name="isUse2" id="dropIsUseEdit" style="width:75%" title="启用标志">
${IsUseEdit}
</select>
<script type="text/javascript">document.getElementById('dropIsUseEdit').value='${IsUse}';</script>    </td>
 </tr>
  <tr>
    <td>
人员描述    </td>
    <td colspan="5">
<input name="description2" type="text" id="txtDescriptionEdit" value="${Description}" title="人员描述" size="100" maxlength="500" />    </td>
  </tr>
  <tr>
    <td>
通讯地址    </td>
    <td colspan="5"><input name="address" type="text" id="txtAddressEdit" value="${Address}" title="通讯地址" size="100" maxlength="50" /></td>
  </tr>
  
  
  <tr>
    <td colspan="6" align="center"><div align="center">
    <input type="submit" name="btnSubmit" id="btnSubmit" value="保存" onclick="if (checkForm2()) {return true;} return false;"/>
    <input type="button" name="btnReturn" id="btnReturn" value="返回" onclick="window.location.href=window.location.pathname + '?${pageListUrl}'" />   </div> </td>
  </tr>
</table>
	</div>
	
	</body>
	${pageJavaScripEnd}
</html>

<script>
	initradio("sex","${Sex}");
</script>

