<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SystemParameterEdit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/AdminCss.css" />
		<link rel="stylesheet" type="text/css" href="css/css.css" />
		<link rel="stylesheet" type="text/css" href="css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="js/colorwinglib.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>
		<style type="text/css">
		td{
			width: 50%;
			}
		</style>
  </head>
  
  <body>

    ${pageJavaScripStar}
<form action="SystemParameter.do?pagetype=update" method="post">
<table border="0"  cellpadding="0" cellspacing="0" id="tbEdit" align="center" style="width:40%">
  <tr> </tr>
  <tr>
    <td colspan="2" style="font:+5; color:#black;text-align:center;border-left: 1px solid #cedff7;" height="30" >系统参数信息</td>
  </tr>
  <tr>
  <td style="border-left: 1px solid #cedff7;"> 单位名称 </td>
      <td><input type="text" name="unitname" value="${unitname }" size="30"/>
      </td>
    </tr><tr>
      <td style="border-left: 1px solid #cedff7;">  部门 </td>
      <td><input name="dept" value="${dept }"/></td>
  </tr>
      <tr>
        <td style="border-left: 1px solid #cedff7;"> 地址 </td>
        <td><input name="address" value="${address }"/></td>
      </tr>
      <tr><td style="text-align: center;border-left: 1px solid #cedff7;" colspan="2"><div><input id="btnText" type="submit" value="保存" /></div></td></tr>
</table>

</form>
${pageJavaScripEnd}
  </body>
</html>
