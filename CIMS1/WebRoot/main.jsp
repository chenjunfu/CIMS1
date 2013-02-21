<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@page import="com.yun.configuration.WebConfig"%>
<%@page import="com.yun.ui.action.UserLook" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    <title><%=WebConfig.WEB_TITLE %></title>
	<%
		UserLook userlook = new UserLook(request,response);
		request.setAttribute("userlook",userlook);
		if(userlook.getAdminname().equals(""))
		{
			request.getRequestDispatcher("index.jsp").forward(request,response);
			return;
		}
	%>
	
	<link rel="stylesheet" type="text/css" href="css/main.css"></link>
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
    <script type="text/javascript">
        	$(document).ready(function(){
  
  			$('li.mainlevel').mouseover(function(){
 			 $(this).children('ul').stop(true,true).slideDown();//you can give it a speed
  			});
 			 $('li.mainlevel').mouseleave(function(){
  			$(this).children('ul').slideUp(100);
  			});
  			
		});
		
		
    </script>

  </head>
  
 <body >

<div class="time" style="position: absolute; top: 82px; left: 17px; width: 370px; height: 25px; z-index:900">
    今天是：
<label  id="localtime" style="color:Black; vertical-align: middle; line-height: 20px;"></label>
<script type="text/javascript">
function showLocale(objD)
{
	var str,colorhead,colorfoot;
	var yy = objD.getYear();
	if(yy<1900) yy = yy+1900;
	var MM = objD.getMonth()+1;
	if(MM<10) MM = '0' + MM;
	var dd = objD.getDate();
	if(dd<10) dd = '0' + dd;
	var hh = objD.getHours();
	if(hh<10) hh = '0' + hh;
	var mm = objD.getMinutes();
	if(mm<10) mm = '0' + mm;
	var ss = objD.getSeconds();
	if(ss<10) ss = '0' + ss;
	var ww = objD.getDay();
	if  ( ww==0 )  colorhead="<font color=\"Black\">";
	if  ( ww > 0 && ww < 6 )  colorhead="<font color=\"Black\">";
	if  ( ww==6 )  colorhead="<font color=\"Black\">";
	if  (ww==0)  ww="星期日";
	if  (ww==1)  ww="星期一";
	if  (ww==2)  ww="星期二";
	if  (ww==3)  ww="星期三";
	if  (ww==4)  ww="星期四";
	if  (ww==5)  ww="星期五";
	if  (ww==6)  ww="星期六";
	colorfoot="</font>"
	str = colorhead + yy + "-" + MM + "-" + dd + " " + hh + ":" + mm + ":" + ss + "  " + ww + colorfoot;
	return(str);
}
function tick()
{
	var today;
	today = new Date();
	document.getElementById("localtime").innerHTML = showLocale(today);
	window.setTimeout("tick()", 1000);
}
tick();
</script>
</div>
<img alt=""  width="100%" src="img/top_img.jpg" style="height: 70px" />
<div style="position: absolute; top: 45px; right: 20px; width: 350px; height: %4; ">
<table width="100%">
<tr>
<!-- 刷新  -->
<td class="style21">
<a href="main.jsp" class="ahref" hidefocus="true" shape="default"  >
<img alt="" style="border:0;vertical-align: middle" src="img/refresh.jpg" hspace="0"
        vspace="0" /><font color="#3666af"> 刷新</font>
</a>
</td>
<!-- 帮助  -->
<td class="style18">
<a href="main.jsp" class="ahref" hidefocus="true" shape="default" 
        ><img alt="" src="img/question.gif" hspace="0" style="border:0;vertical-align: middle" 
        vspace="0" /><font color="#3666af"> 在线帮助手册</font>
</a>
</td>


<!-- 注销  -->
<td class="style20">
<a href="Login.do?loginout=1" class="ahref" hidefocus="true" shape="default" >
<img alt="" src="img/zhuxiao.jpg" hspace="0" style="border:0;vertical-align: middle" 
        vspace="0" /><font color="#3666af"> 注销</font>
</a>
</td>
<!-- 退出  -->
<td>
<a href="Login.do?loginout=1" class="ahref" hidefocus="true" shape="default" 
        ><img alt="" src="img/shut.jpg" hspace="0" style="border:0;vertical-align: middle" 
        vspace="0" /><font color="#3666af"> 退出</font>
</a>
</td>
</tr>
</table>
</div>

<div style="background: url(img/top_bar.jpg) 0 0 repeat-x; position:absolute; top: 70px; left:0px; width:100%; height:31px ; z-index:8">
<div style="width: 99%;" id="menu"><!-- 这里不能加样式，否则会出现很蛋疼的效果 -->
        <ul id="nav" style="height:31px; ">
        <s:set value="'1'" scope="request" name="Cvalue"></s:set>
        <li class="mainlevel" id="mainlevel_01"><a style="cursor: default;">系统管理</a>
        <ul id="sub_01">
        <s:if test="#request.userlook.seePageN('22')">
       	   <li><a href="SystemParameter.do?pagetype=Details" target="I1">系统参数设定</a></li>
        </s:if>
             <s:if test="#request.userlook.seePageN('21')">
        <li><a href="SystemSector.do?pagetype=tree" target="I1">部门设置</a></li>
        </s:if>
         <s:if test="#request.userlook.seePageN('20')">
        <li><a href="SystemPersonnel.do?pagetype=tree&target=personnel" target="I1">人员设置</a></li>
        </s:if>
        <s:if test="#request.userlook.seePageN('23')">
        <li><a href="SystemAdmin.do" target="I1">用户设置</a></li>
        </s:if>
        <s:if test="#request.userlook.seePageN('24')">
        <li><a href="SystemRoles.do" target="I1">角色管理</a></li>
        </s:if>




        </ul>
        </li>
        
        <li class="mainlevel" id="Li1"><a style="cursor: default;"  >个人资料</a>
        <ul id="Ul1">
         <s:if test="#request.userlook.seePageN('18')">
        <li><a href="SystemAdmin.do?pagetype=Details&databaseadminid=<%=userlook.getDatabaseadminid()%>" target="I1">个人信息</a></li>
        </s:if>
         <s:if test="#request.userlook.seePageN('19')">
       	<li><a href="system/AdminPassWord.jsp" target="I1">密码修改</a></li>
        </s:if>
        </ul>
        </li>
        
        <li class="mainlevel" id="mainlevel_02"><a style="cursor: default;"  >基础信息设置</a>
        <ul id="sub_02">
        <s:if test="#request.userlook.seePageN('16')">
         <li><a href="dictionary/DictionaryPage.jsp" target="I1">数据字典</a></li>
        </s:if>
        <s:if test="#request.userlook.seePageN('17')">
        <li><a href="Unit.do" target="I1">单位设置</a></li>
        </s:if>
      
       
		
        </ul>
        </li>
        <li class="mainlevel" id="mainlevel_03"><a style="cursor: default;"   >报表分析系统</a>
        <ul id="sub_03">
        <s:if test="#request.userlook.seePageN('4')">
        <li><a href="report/EnterpriseReport.jsp" target="I1">文化企业统计信息</a></li>
        </s:if>
        <s:if test="#request.userlook.seePageN('9')">
        <li><a href="report/ProjectReport.jsp" target="I1">文化项目统计信息</a></li>
        </s:if>
        <s:if test="#request.userlook.seePageN('14')">
        <li><a href="report/TalentReport.jsp" target="I1">文化人才统计信息</a></li>
        </s:if>
        </ul>
</li>
        
        <li class="mainlevel" id="mainlevel_04"><a style="cursor: default;">查询子系统</a>
        <ul id="sub_04">
        <s:if test="#request.userlook.seePageN('3')">
 		<li><a href="enterprise/Enterprise.do" target="I1">文化企业信息查询</a></li>
        </s:if>
        <s:if test="#request.userlook.seePageN('8')">
               <li><a href="cultureproduce/IndustryProject.do" target="I1">产业项目信息查询</a></li>
        </s:if>
        <s:if test="#request.userlook.seePageN('13')">
        <li><a href="Talent.do?pagetype=select&whole=yes" target="I1">文化人才信息查询</a></li>
        </s:if>
       

       
        </ul>
        </li>
        
        <li class="mainlevel" id="mainlevel_05"><a style="cursor: default;"   >登录信息变更</a>
        <ul id="sub_05">
          <s:if test="#request.userlook.seePageN('2')">
         <li><a href="enterprise/Enterprise.do?pagetype=updata" target="I1">文化企业信息变更</a></li>
        </s:if>
          <s:if test="#request.userlook.seePageN('7')">
        <li><a href="cultureproduce/IndustryProject.do?pagetype=updata" target="I1">产业项目信息变更</a></li>
        </s:if>
          <s:if test="#request.userlook.seePageN('12')">
        <li><a href="talent/Talent.do?pagetype=geng" target="I1">文化人才信息变更</a></li>
        </s:if>
       
        
        
        </ul>
        </li>
        
        <li class="mainlevel" id="mainlevel_06"><a style="cursor: default;"   >产业信息录入</a>
        <ul id="sub_06">
           <s:if test="#request.userlook.seePageN('1')">
        <li><a href="enterprise/Enterprise.do?pagetype=gotoinsert" target="I1">文化企业信息录入</a></li>
        </s:if>
           <s:if test="#request.userlook.seePageN('6')">
		<li><a href="cultureproduce/IndustryProject.do?pagetype=gotoinsert" target="I1">产业项目信息录入</a></li>
        </s:if>
        <s:if test="#request.userlook.seePageN('11')">
               <li><a href="talent/Talent.do?pagetype=gotoinsert" target="I1">文化人才信息录入</a></li>
        </s:if>
        </ul>
        </li>
       
       
        <li class="mainlevel" id="mainlevel_07"><a href="main.jsp" >首页</a>
        
        </li>
       
        </ul>
</div>
</div>
<div style="position: absolute; left: 87px; top: 15px; width: 400px; height: 6%">
<img src="img/title.gif" />
</div>

<div style="position: absolute; top: 0px; right: 20px; width: 350px; height: 4%; background:url(img/loginbar.gif);background-repeat: no-repeat;">
<table width="50%"  align="center">
<tr >
<!-- 主页  -->
<td class="style3" style="text-align: right;vertical-align: top;">
   <%=userlook.getAdminname()%>：</td>
<td class="style16" style="vertical-align: top;">
    <font  style="display:block; font-family:微软雅黑; font-size:13px; text-align:left;color:Blue; text-decoration:none " >
    欢迎您！</font></td>
</tr>
</table>

</div>
<div  id="frameBody" style="position:absolute; width:100%; height:81%; left: 0px; top: 103px; z-index:5">
<iframe id="I1" name="I1" height="100%"  width="100%" src="centerview.jsp"  frameborder="0" scrolling="yes" > 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe>
</div>
</body>
</html>

