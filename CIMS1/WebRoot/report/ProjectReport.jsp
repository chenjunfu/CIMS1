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
<!--打印控件-->
<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-ui.js"></script>
<script language="javascript" src="<%=basePath %>js/LodopFuncs.js"></script>

	<script>
		$(document).ready(function()
			{	
				$("#tabs").tabs({select:tabSelect});	
			}
		)
		function tabSelect(event,tabObje)
		{	
			switch(tabObje.index)
			{
				case 0:projectnewly(true);break;
				case 1:statistics(true);break;
				case 2:projectcompleted(true); break;
				case 3:totalinvest(true); break;
				case 4:projectbytype(true); break;
				case 5:projectbyregion(true); break;
			
			}
		}	
		
	</script>

  </head>
  
  <body  >
	${pageJavaScripStar}
		

<div id="tabs"  style="position: relative;width: 99%;text-align: center;"     >
	<ul>
		<li><a href="#tab-1">年度新增项目汇总表</a></li>
		<li><a href="#tab-2">年度总项目汇总表</a></li>
		<li><a href="#tab-3">年度完成项目汇总表</a></li>
		<li><a href="#tab-4">年度项目投资总额统计分析表</a></li>
		<li><a href="#tab-5">年度项目行业统计及分析表</a></li>
		<li><a href="#tab-6">年度项目地区统计及分析表</a></li>
	</ul>
	<div id="tab-1" style="text-align: center;"><img src="<%=basePath%>img/ajax-loader.gif" align="middle" /></div>
	<div id="tab-2" style="text-align: center;"><img src="<%=basePath%>img/ajax-loader.gif" align="middle" /></div>
	<div id="tab-3" style="text-align: center;"><img src="<%=basePath%>img/ajax-loader.gif" align="middle" /></div>
	<div id="tab-4" style="text-align: center;"><img src="<%=basePath%>img/ajax-loader.gif" align="middle" /></div>
	<div id="tab-5" style="text-align: center;"><img src="<%=basePath%>img/ajax-loader.gif" align="middle" /></div>
	<div id="tab-6" style="text-align: center;"><img src="<%=basePath%>img/ajax-loader.gif" align="middle" /></div>
</div>



${pageJavaScripEnd}
  </body >
</html>
<script type="text/javascript">

	function projectnewly(NonExport)
	{	
		var Year;
		Year=$("#year1").val(); 
		if(Year==undefined)
		{
			Year=0;
		}
		if(NonExport)
		{
		$.post("<%=basePath%>report/project!ProjectNewLy.do",
		{
		year:Year
		},
		function(data)
		{		
			$("#tab-1").html(data);
		});
		}
		else
		{
			window.location.href='report/Pdownload!ProjectNewLy.do?export=true&year='+Year;
		}
	}
	
	function statistics(NonExport)
	{	
		var Year;
		Year=$("#year2").val(); 
		if(Year==undefined)
		{
			Year=0;
		}
		if(NonExport)
		{
		$.post("<%=basePath%>report/project!Statistics.do",
		{
			year:Year
		},
		function(data)
		{	
			$("#tab-2").html(data);
			$("#showyear1").text($("#year2").val()+'文化产业项目汇总表');
		});
		}
		else
		{
			window.location.href='report/Pdownload!Statistics.do?export=true&year='+Year;
		}
	}

	function projectcompleted(NonExport)
	{
		var Year;
		Year=$("#year3").val();
		if(Year==undefined)
		{
			Year=0;
		}
		if(NonExport)
		{
		$.post("<%=basePath%>report/project!ProjectCompleted.do",
		{
		year:Year
		},
		function(data)
		{
			$("#tab-3").html(data);
		});
		}
		else
		{
			window.location.href='report/Pdownload!ProjectCompleted.do?export=true&year='+Year;
		}
	}
	function totalinvest(NonExport)
	{
		var Year;
		Year=$("#year4").val();
		if(Year==undefined)
		{
			Year=0;
		}
		if(NonExport)
		{
		$.post("<%=basePath%>report/project!ProjectTotalInvest.do",
		{
		year:Year
		},
		function(data)
		{
			$("#tab-4").html(data);
		});
		}
		else
		{
			window.location.href='report/Pdownload!ProjectTotalInvest.do?export=true&year='+Year;
		}
	}
	function projectbytype(NonExport)
	{
		var Year;
		Year=$("#year5").val();
		var ProjectType;
		ProjectType=$("#projecttype").val();
		if(Year==undefined)
		{
			Year=0;
		}
		if(ProjectType==undefined)
		{
			ProjectType=0;
		}
		if(NonExport)
		{
			$.post("<%=basePath%>report/project!ProjectByType.do",
			{
				year:Year,
				projecttype:ProjectType
			},
			function(data)
			{
				$("#tab-5").html(data);
			});
		}
		else
		{	
			
			window.location.replace("report/Pdownload!ProjectByType.do?export=true&year="+Year+"&projecttype="+ProjectType);

		}
	}
	function projectbyregion(NonExport)
	{
		var Year;
		Year=$("#year6").val();
		var ProjectRegion;
		ProjectRegion=$("#projectregion").val();
		if(Year==undefined)
		{
			Year=0;
		}
		if(ProjectRegion==undefined)
		{
			ProjectRegion=0;
		}
		if(NonExport)
		{
		$.post("<%=basePath%>report/project!ProjectByRegion.do",
		{
		year:Year,
		projectregion:ProjectRegion
		},
		function(data)
		{
			$("#tab-6").html(data);
		});
		
		}
		else
		{
			window.location.href="report/Pdownload!ProjectByRegion.do?export=true&year="+Year+"&projectregion="+ProjectRegion;
		}
	}
$(projectnewly);

</script>

          <script >
  	
//设置ContentDIV位置　
$(function(){

$(window).scroll(function() { 
var left= $(window).scrollLeft();

$("#tabs").css({ left:left + "px" });
left=0-left; 
$("#contentDiv").css({left:left + "px" });
}); 
})


</script>
<object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
       <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
</object>
<script type="text/javascript">
var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));
</script>
