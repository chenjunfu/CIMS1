<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"	prefix="s" %>
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
		<style type="text/css">
		</style>
	</head>
	<body>
${pageJavaScripStar}<form name="produceForm" id="frmEdit" method="post"  action="${btnEditCommandArgument}"  >

<table border="0" cellpadding="0" cellspacing="0" id="tbEdit" align="center">
<thead>
	<th colspan="4">角色编辑

	
	</th>
</thead>
  <tr>
    <td>
角色编号
    </td>
    <td>
<input name="rolesid" type="text" id="txtRolesidEdit" value="${Rolesid}" title="角色编号" size="20" maxlength="8" />
  
    </td>
 
    <td>
角色名称
    </td>
    <td>
<input name="rolesname" type="text" id="txtRolesnameEdit" value="${Rolesname}" title="角色名称" size="20" maxlength="50" />
    </td>
  </tr>
  <tr>
    <td>
描述
    </td>
    <td>
<input name="description" type="text" id="txtDescriptionEdit" value="${Description}" title="描述" size="20" maxlength="500" />
    </td>

    <td>
启用标志
    </td>
    <td>
<select name="isUse" style="width:100px" id="dropIsUseEdit" title="启用标志"> 
${IsUseEdit}
</select>
<script type="text/javascript">document.getElementById('dropIsUseEdit').value='${IsUse}';</script>    </td>
  </tr>
  
<!-- 权限  -->

 <tr  style="border: 0px solid;">
 <td colspan="4" style="margin: 0px;padding: 0px;border: 0px solid;"  >
<table width="100%" cellpadding="0" cellspacing="0" style="margin: 0px;width: 100%;border: 0px solid;" id="tbEdit">
 <tr><td colspan="5" style="text-align: center; border: 0px solid;">权限设置</td></tr>
 <tr style="text-align: center;">
 <td style="border-bottom: 1px solid #a4bedc;" >&nbsp;文化企业信息</td><td>&nbsp;产业项目信息</td><td>&nbsp;文化人才信息</td><td>&nbsp;基本信息</td><td style="border-right: 0px solid;">&nbsp;系统信息</td>
 </tr>
 <tr  >
<!--企业权限 -->
 <td  style="margin: 0px;padding: 0px;border:1px solid #a4bedc; border-right: 0px solid; vertical-align: top;">
 <table  width="100%" cellpadding="0" cellspacing="0" style="margin: 0px;width: 100%;border: 0px solid;" id="tbEdit" >
<s:iterator var="competenceitem" value="systemcompetenceforenterprise">
	<tr style="border: 0px solid;text-align: center;" ><td style="border: 0px solid; " >${competenceitem.competencename }:</td ><td style="border: 0px solid; ">
	<s:if test="comparaToStr(#request.Competenceid,#request.competenceitem.databasecompetenceid)">
	  <input type="checkbox" checked="checked" name="competenceid" value="${competenceitem.databasecompetenceid}"/>
	</s:if>
	<s:else>
	<input type="checkbox" name="competenceid" value="${competenceitem.databasecompetenceid}"/>
	</s:else>
	</td></tr>
</s:iterator> 
</table>
 &nbsp;</td>
 
<!--项目权限 -->
<td  style="margin: 0px;padding: 0px;border:1px solid #a4bedc; border-right: 0px solid;vertical-align: top;">
 <table  width="100%" cellpadding="0" cellspacing="0" style="margin: 0px;width: 100%;border: 0px solid;" id="tbEdit" >
<s:iterator var="competenceitem" value="systemcompetenceforproject">
	<tr style="border: 0px solid;text-align: center;"><td style="border: 0px solid; " >${competenceitem.competencename }:</td><td style="border: 0px solid; ">
<s:if test="comparaToStr(#request.Competenceid,#request.competenceitem.databasecompetenceid)">
	<input type="checkbox" checked="checked" name="competenceid" value="${competenceitem.databasecompetenceid}"/>
	</s:if>
	<s:else>
	<input type="checkbox" name="competenceid" value="${competenceitem.databasecompetenceid}"/>
	</s:else>

</td></tr>
</s:iterator> 
</table>
 &nbsp;</td>
<!--人才权限-->
<td  style="margin: 0px;padding: 0px;border:1px solid #a4bedc; border-right: 0px solid;vertical-align: top;">
 <table  width="100%" cellpadding="0" cellspacing="0" style="margin: 0px;width: 100%;border: 0px solid;" id="tbEdit" >
<s:iterator var="competenceitem" value="systemcompetencefortalent">
	<tr style="border: 0px solid;text-align: center;"><td style="border: 0px solid; " >${competenceitem.competencename }:</td><td style="border: 0px solid; ">
<s:if test="comparaToStr(#request.Competenceid,#request.competenceitem.databasecompetenceid)">
	<input type="checkbox" checked="checked" name="competenceid" value="${competenceitem.databasecompetenceid}"/>
	</s:if>
	<s:else>
	<input type="checkbox" name="competenceid" value="${competenceitem.databasecompetenceid}"/>
	</s:else>
</td></tr>
</s:iterator> 
</table>
 &nbsp;</td>
<!--基础信息权限-->
<td  style="margin: 0px;padding: 0px;border:1px solid #a4bedc; border-right: 0px solid;vertical-align: top;">
 <table  width="100%" cellpadding="0" cellspacing="0" style="margin: 0px;width: 100%;border: 0px solid;" id="tbEdit" >
<s:iterator var="competenceitem" value="systemcompetenceforbaseinfo">
	<tr style="border: 0px solid;text-align: center;"><td style="border: 0px solid; " >${competenceitem.competencename }:</td><td style="border: 0px solid; ">
<s:if test="comparaToStr(#request.Competenceid,#request.competenceitem.databasecompetenceid)">
	<input type="checkbox" checked="checked" name="competenceid" value="${competenceitem.databasecompetenceid}"/>
	</s:if>
	<s:else>
	<input type="checkbox" name="competenceid" value="${competenceitem.databasecompetenceid}"/>
	</s:else>
</td></tr>
</s:iterator> 
</table>
 &nbsp;</td>
<!--系统权限-->
  <td  style="margin: 0px;padding: 0px;border:1px solid #a4bedc; border-right: 0px solid;vertical-align: top;">
 <table  width="100%" cellpadding="0" cellspacing="0" style="margin: 0px;width: 100%;border: 0px solid;" id="tbEdit" >
<s:iterator var="competenceitem" value="systemcompetenceforsystem">
	<tr style="border: 0px solid;text-align: center;"><td style="border: 0px solid; " >${competenceitem.competencename }:</td><td style="border: 0px solid; ">
<s:if test="comparaToStr(#request.Competenceid,#request.competenceitem.databasecompetenceid)">
	<input type="checkbox" checked="checked" name="competenceid" value="${competenceitem.databasecompetenceid}"/>
	</s:if>
	<s:else>
	<input type="checkbox" name="competenceid" value="${competenceitem.databasecompetenceid}"/>
	</s:else>
</td></tr>
</s:iterator> 
</table>
 &nbsp;</td>
 </tr>

 </table>
 
 </td></tr>
  <tr>
    <td colspan="4" align="center" style="border-top: 0px solid; margin: 0px;padding: 0px">
    <table cellpadding="0" cellspacing="0" style="border: 0px solid;">
    	<tr><td style="border: 0px solid;"> <input type="submit" name="btnSubmit" id="btnSubmit" value="保存" onclick="if (checkForm()) {return true;} return false;"/></td>
    	
    	<td style="border: 0px solid;"> <input type="button" name="btnReturn" id="btnReturn" value="" style="cursor: pointer;" onclick="window.location.href=window.location.pathname + '?${pageListUrl}'" /></td></tr>
    </table>
   
   
    </td>
  </tr>
</table>
</form>
${pageJavaScripEnd}
	</body>
</html>
