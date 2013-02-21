<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@page import="com.yun.ui.action.UserLook" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'centerview.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
img {
	 border-width:0px 0px 0px 0px
}
</style>
  </head>
  
  <body>
  	<%
		UserLook userlook = new UserLook(request,response);
		request.setAttribute("userlook",userlook);
		%>
   <table width="80%" align="center" >
   <tr height="120px" ><td colspan="4"></td></tr>
   <tr align="center">
    <s:if test="#request.userlook.seePageN('3')">
     <td id="lou"><a href="enterprise/Enterprise.do" ><img src="btnimg/lou.png" id="aa"  onMouseOver="syleimag('lou')" onMouseOut="quxiao('lou')"/></a></td>
    </s:if>
    <s:else>
     <td id="lou"><img src="btnimg/lou.png" id="aa" /></td>
    </s:else>
   	<s:if test="#request.userlook.seePageN('8')">
   	 <td id="pro"><a href="cultureproduce/IndustryProject.do" ><img src="btnimg/procject.png" onMouseOver="syleimag('pro')" onMouseOut="quxiao('pro')"/></a></td>
   	</s:if>
   	<s:else>
   	 <td id="pro"><img src="btnimg/procject.png" /></td>
   	</s:else>
      <s:if test="#request.userlook.seePageN('13')">
      <td id="persion"><a href="Talent.do?pagetype=select&whole=yes"  ><img src="btnimg/persion.png" onMouseOut="quxiao('persion')" onMouseOver="syleimag('persion')"/></a></td>
      </s:if>
      <s:else>
      <td id="persion"><img src="btnimg/persion.png" /></td>
      </s:else>
     
   
   </tr>
   <tr align="center">
   	 <td>企业信息库</td>
     <td>产业项目信息库</td>
     <td>文化人才信息库</td>
     </tr>
   </table>
  </body>
</html>
<script type="text/javascript">
function syleimag(element){
document.getElementById(element).style.background="grey";
}
function quxiao(element){
document.getElementById(element).style.background="white";	
}
</script>