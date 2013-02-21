<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/css.css">
    <link href="<%=basePath%>css/AdminCss.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/jquery-ui-css.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery-ui.js"></script>
	<!--打印控件-->

<script language="javascript" src="<%=basePath %>js/LodopFuncs.js"></script>

<script type="text/javascript">
	$(function()
		{
			$("#tabs").tabs({
				select:tabSelect
			});
				
		})
	function tabSelect(event,tabObje)
	{	
		switch(tabObje.index)
		{	
				
			case 0:talentnewly(true);break;
			case 1:talentbytype(true);break;
			case 2:talentbyage(true);break;
			case 3:talentbyeducation(true);break;
			case 4:talentbypost(true);break;
		}
	}
	function talentnewly(NonExport)
	{	
		var Year=$("#year1").val();
		if(Year==undefined)
		{
			Year=0;
		}
		if(NonExport)
		{
		$.post("<%=basePath%>report/talent!Talentnewly.do",
		{
			year:Year
		},
		function(data)
			{
				$("#tabs-1").html(data);
			}
		)
		}
		else
		{
			window.location.href="report/Tdownload!Talentnewly.do?Export=true&year="+Year;
		}
	}
	function talentbytype(NonExport)
	{		
	
		var Year=$("#year2").val();
		if(Year==undefined)
		{
			Year=0;
		}
		var Talenttype=$("#talenttype").val();
		if(Talenttype==undefined)
		{
			Talenttype=0;
		}
		if(NonExport)
		{
		$.post("<%=basePath%>report/talent!Talentbytype.do",
		{
			year:Year,
			talenttype:Talenttype
		},
		function(data)
			{	
				$("#tabs-2").html(data);
			}
		);
		}
		else
		{
			window.location.href="report/Tdownload!Talentbytype.do?Export=true&year="+Year+"&talenttype="+Talenttype;
		}
	}
	function talentbyage(NonExport)
	{	
		var Year=$("#year3").val();
		if(Year==undefined)
		{
			Year=0;
		}
		var Talentage=$("#talentage").val();
		if(Talentage==undefined)
		{
			Talentage=0;
		}
		if(NonExport)
		{
		$.post("<%=basePath%>report/talent!Talentbyage.do",
		{
			year:Year,
			talentage:Talentage
		},
			function(data)
			{	
				
				$("#tabs-3").html(data);
			}
		)
		}
		else
		{
			window.location.href="report/Tdownload!Talentbyage.do?Export=true&year="+Year+"&talentage="+Talentage;
		}
		
	}
	function talentbyeducation(NonExport)
	{
		var Year=$("#year4").val();
		if(Year==undefined)
		{
			Year=0;
		}
		var Talenteducation=$("#talenteducation").val();
		if(Talenteducation==undefined)
		{
			Talenteducation=0;
		}
		if(NonExport)
		{
			$.post("<%=basePath%>report/talent!Talentbyeducation.do",
			{
				year:Year,
				talenteducation:Talenteducation
			},
				function(data)
				{	
					$("#tabs-4").html(data);
				}
			)
		}
		else
		{
			window.location.href="report/Tdownload!Talentbyeducation.do?Export=true&year="+Year+"&talenteducation="+Talenteducation;
		}
		
	}
	function talentbypost(NonExport)
	{
		var Year=$("#year5").val();
		if(Year==undefined)
		{
			Year=0;
		}
		var Talentpost=$("#talentpost").val();
		if(Talentpost==undefined)
		{
			Talentpost=0;
		}
		if(NonExport)
		{
		$.post("<%=basePath%>report/talent!Talentbypost.do",
		{
			year:Year,
			talentpost:Talentpost
		},
	
			function(data)
			{	
				$("#tabs-5").html(data);
			}
		)
		}
		else
		{
			window.location.href="report/Tdownload!Talentbypost.do?Export=true&year="+Year+"&talentpost="+Talentpost;
		}
	}
	$(talentnewly)
</script>

  </head>
  
  <body class="bb">
 
<div id="tabs" >
	<ul >
		<li ><a href="#tabs-1" onClick="">年度新增人才信息汇总</a></li>
	  	<li ><a href="#tabs-2" onClick="">年度人才行业统计分析</a></li>
		<li ><a href="#tabs-3" onClick="">年度人才年龄分析</a></li>
        <li ><a href="#tabs-4" onClick="">年度人才学历结构分析</a></li>
        <li ><a href="#tabs-5" onClick="">年度人才职称结构分析</a></li>
 
	</ul>
	<div id="tabs-1" style="text-align: center;" >
	<img src="<%=basePath%>img/ajax-loader.gif" align="middle" />
    </div>
	<div id="tabs-2" style="text-align: center;" >
    <img src="<%=basePath%>img/ajax-loader.gif" align="middle" />
    </div>
    <div id="tabs-3" style="text-align: center;" >
    <img src="<%=basePath%>img/ajax-loader.gif" align="middle" />
    </div>
	<div id="tabs-4" style="text-align: center;" >
    <img src="<%=basePath%>img/ajax-loader.gif" align="middle" />
    </div>
    <div id="tabs-5" style="text-align: center;" >
   <img src="<%=basePath%>img/ajax-loader.gif" align="middle" />
    </div>
</div>
</body>
</html>
<object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
       <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
</object>
<script type="text/javascript">
var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));
</script>