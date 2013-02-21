<%@ page language="java" import="java.util.*,com.yun.ui.action.UserLook" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="height:100%">
<%
UserLook userlook=new UserLook(request,response);
userlook.seePageY("16");
 %>
<script  type="text/javascript">
function movein(tr)
{	tr.cells[1].style.backgroundColor = "#80affb"; //背景颜色
	//tr.style.backgroundColor = "#80affb"; //背景颜色
}
function moveout(tr)
{
	
	tr.cells[1].style.backgroundColor = "#FFF"; //背景颜色
	//tr.style.backgroundColor="#FFF";//白色
}
</script>
<head>
		<title><%=com.yun.configuration.WebConfig.WEB_TITLE %></title>
		<link rel="stylesheet" type="text/css" href="../css/public.css" />
		<link rel="stylesheet" type="text/css" href="../css/css.css" />
		<link rel="stylesheet" type="text/css" href="../css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="../js/colorwinglib.js"></script>
		<script type="text/javascript" src="../js/jquery.js"></script>
		<script type="text/javascript" src="../js/jquery-ui.js"></script>
	</head>
<style type="text/css">
.leftbar
{	
	color: #1E5494;
	font-weight: bold;
	FONT-SIZE: 13px;
	text-align: center; 
	bgcolor:#16ACFF;
	background-image: url('../image/left_tt.gif');
	background-repeat:no-repeat;
	}
.info
{
	font-size:13px;
    color:Black;
    text-decoration: none;
}
.img1{
padding: 0px;
margin: 0px;
}

A:link {
color: #1E5494;font-size:12px ;text-decoration: none;
}
A:visited {
color: #1E5494;font-size:12px ;text-decoration: none;
}
A:hover {
color: #1E5494;font-size:12px ;text-decoration: none;
}
A:active {
color: #1E5494;font-size:12px ;text-decoration: none;
}
    </style>
<body style="height:100%">
	<table  width="100%" style="height:98%">
		<tr>
			<td style="width: 130px;border-right: 1px solid #6697CD;vertical-align: top;" height="100%" >
<div class="leftbar"  >数据字典</div>
<table class="info" >
 
     <tr onmousemove="movein(this)" onmouseout="moveout(this)" >
       <td id="img1" style="width: 2%"><img src="../image/closed.gif"/></td><td ><a href="../enterprise/Profession.do" target="dictionary_main" class="info1"  hideFocus    >行业分类</a></td>
     </tr>
     <tr onmousemove="movein(this)" onmouseout="moveout(this)">
      <td id="img1" style=""  ><img src="../image/closed.gif"/></td><td ><a href="../enterprise/EnterpristQuality.do" target="dictionary_main" class="info1" hideFocus   >企业性质</a></td>
     </tr>
     <tr onmousemove="movein(this)" onmouseout="moveout(this)">
       <td id="img1" style=""  ><img src="../image/closed.gif"/></td><td ><a href="ProjectQuality.do" target="dictionary_main" class="info1" hideFocus   >项目性质</a></td>
     </tr>
     <tr onmousemove="movein(this)" onmouseout="moveout(this)">
       <td id="img1" style=""  ><img src="../image/closed.gif"/></td><td ><a href="Regions.do" target="dictionary_main" class="info1" hideFocus   >区域</a></td>
     </tr>
     <tr onmousemove="movein(this)" onmouseout="moveout(this)">
       <td id="img1" style=""  ><img src="../image/closed.gif"/></td><td ><a href="Education.do" target="dictionary_main" class="info1" hideFocus   >学历</a></td>
     </tr>
     <tr onmousemove="movein(this)" onmouseout="moveout(this)">
       <td id="img1" style=""  ><img src="../image/closed.gif"/></td><td ><a href="Degree.do" target="dictionary_main" class="info1" hideFocus   >学位</a></td>
     </tr>
     <tr onmousemove="movein(this)" onmouseout="moveout(this)">
       <td id="img1" style=""  ><img src="../image/closed.gif"/></td><td ><a href="Major.do" target="dictionary_main" class="info1" hideFocus   >专业</a></td>
     </tr>
   
     <tr onmousemove="movein(this)" onmouseout="moveout(this)">
       <td id="img1" style=""  ><img src="../image/closed.gif"/></td><td ><a href="Nation.do" target="dictionary_main" class="info1"  hideFocus   >民族</a></td>
     </tr>
     <tr onmousemove="movein(this)" onmouseout="moveout(this)">
       <td id="img1" style=""  ><img src="../image/closed.gif"/></td><td ><a href="Post.do" target="dictionary_main" class="info1"  hideFocus  >职称</a></td>
     </tr>
      <tr onmousemove="movein(this)" onmouseout="moveout(this)">
       <td id="img1" style=""  ><img src="../image/closed.gif"/></td><td ><a href="Huanpi.do" target="dictionary_main" class="info1" hideFocus  >环境批复</a></td>
     </tr>
       <tr onmousemove="movein(this)" onmouseout="moveout(this)">
       <td id="img1" style=""  ><img src="../image/closed.gif"/></td><td ><a href="Tupi.do" target="dictionary_main" class="info1" hideFocus  >土地批复</a></td>
     </tr>
       <tr onmousemove="movein(this)" onmouseout="moveout(this)">
       <td id="img1" style=""  ><img src="../image/closed.gif"/></td><td><a href="Shb.do" target="dictionary_main" class="info1" hideFocus  >审批,核准,备案</a></td>
     </tr>
       <tr onmousemove="movein(this)" onmouseout="moveout(this)">
       <td id="img1" style=""><img src="../image/closed.gif"/></td><td ><a href="Proadd.do" target="dictionary_main" class="info1"  hideFocus  >规划选址</a></td>
     </tr>
    

   </table>
</td>
			<td style="height: 100%;"  >
			<iframe id="dictionary_main" name="dictionary_main" height="100%"  width="100%" src="../enterprise/Profession.do" border="0" frameborder="0" style="overflow:auto; height: 100%;"> 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe>
			</td>
		</tr>
	</table>


</body>
	${pageJavaScripEnd}
	
</html>





