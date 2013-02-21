<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>文化产业信息管理系统</title>

		<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

#bg {
	position: absolute;
	top: 0px;
	left: 0px;
	z-index: -999;
}

.style1 {
	width: 131px;
}
</style>
	</head>
	<body>

		${pageJavaScripStar}
		<form action="Login.do" method="post">

			<div id="bg" style=" height:80; width:100; z-index:1;">
				<img src="img/dongqu1.jpg" height=100 width=100 alt="" />
			</div>

			<script type="text/javascript">
		window.onresize = window.onload = function(){
			var w,h
			if(!!(window.attachEvent && !window.opera))
			{
				h = document.documentElement.offsetHeight-20;
				w = document.documentElement.offsetWidth-20;
				}else{
				h =	window.innerHeight;
				w = window.innerWidth;
			}
			var bgImg = document.getElementById('bg').getElementsByTagName('img')[0];
			bgImg.style.width = (w);
			bgImg.style.height= (h) ;
    	}
   </script>
			<div
				style="width: 30%; height: auto; position: absolute; top: 38%; right: 20%; z-index:10000">
				<table>
					<tr>
						<td align="right">
							<font face="微软雅黑" color="Navy" size="2"><b> 用户名：</b>
							</font>
						</td>
						<td class="style1">
							<input type="text" name="username" id="userame" value="admin"
								style="width: 120px" />
						</td>
					</tr>
					<tr>
						<td align="right">
							<font face="微软雅黑" color="Navy" size="2"> <b>密&nbsp;
									&nbsp;码：</b>
							</font>
						</td>
						<td>
							<input type="password" name="password" id="password"
								value="123456" style="width: 120px" />
							&nbsp;
						</td>
					</tr>
					<tr>
						<td></td>
						<td align="left">
							<input type="submit" class=""
								style="border-width: 2px; width: 72px; text-align: center; color: #FFF; background: url(img/loginbtn.jpg); margin-top: 2px; border-top-style: inherit; border-left-style: inherit; border-right-style: ridge; border-bottom-style: ridge;"
								value="登录" />
						</td>
					</tr>
				</table>
			</div>

		</form>
		${pageJavaScripEnd}
	</body>
</html>
