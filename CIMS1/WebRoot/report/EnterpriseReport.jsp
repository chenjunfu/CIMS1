<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
   
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="<%=basePath %>css/css.css">
<link href="<%=basePath %>css/AdminCss.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/jquery-ui-css.css">
<script type="text/javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-ui.js"></script>
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
			case 0:newlyenterprise(true);break;
			case 1:statistics(true);break;
			case 2:enterpriseByType(true);break;
			case 3:enterpriseByRegion(true);break;
		}
	}
	function statistics(NonExprot)
	{	
		var Createtime1="";
		Createtime1=$("#txtCreatetime1List").val();
		var Createtime2="";
		Createtime2=$("#txtCreatetime2List").val();
		if(NonExprot)
		{
		$.post("report/enterprise!AnnualSummary.do",
		{
			createtime1:Createtime1,
			createtime2:Createtime2
		},
			function(data)
			{
				$("#AnnualSummary").html(data);
			}
		);
		}
		else
		{	
		
			window.location.href='report/Edownload!ExportAnnualSummary.do?createtime1='+Createtime1+'&createtime2='+Createtime2;
		}
	}
	function newlyenterprise(NonExprot)
	{	
		var Createtime1="";
		 Createtime1=$("#txtCreatetime3List").val();
		var Createtime2="";
		Createtime2=$("#txtCreatetime4List").val();
		if(NonExprot)
		{
		$.post("report/enterprise!newlyenterprise.do",
		{
		createtime1:Createtime1,
		createtime2:Createtime2
		},
			function(data)
			{	
				$("#newlyenterprise").html(data);
			}
		);
		}
		else
		{
			window.location.href='report/Edownload!Exportnewlyenterprise.do?createtime1='+Createtime1+'&createtime2='+Createtime2;
		}
	}
	function enterpriseByType(NonExport)
	{	
		var Createtime1="";
		 Createtime1=$("#txtCreatetime5List").val();
		var Createtime2="";
		Createtime2=$("#txtCreatetime6List").val();
		var enterpriseType="";
		enterpriseType=$("#enterprisetype").val();
		if(enterpriseType==undefined)
		{
			enterpriseType=0;
		}
		if(NonExport)
		{
		$.post("report/enterprise!enterpriseByType.do",
		{
		createtime1:Createtime1,
		createtime2:Createtime2,
		enterprisetype:enterpriseType
		},
			function(data)
			{	

				$("#enterpriseByType").html(data);
			}
		);
		}
		else
		{
			window.location.href='report/Edownload!ExportenterpriseByType.do?createtime1='+Createtime1+'&createtime2='+Createtime2+'&enterprisetype='+enterpriseType;
		}
		
	}
	function enterpriseByRegion(NonExport)
	{
		var Createtime1="";
		 Createtime1=$("#txtCreatetime7List").val();
		var Createtime2="";
		Createtime2=$("#txtCreatetime8List").val();
		var enterpriseRegion="";
		enterpriseRegion=$("#enterpriseregion").val();
		if(enterpriseRegion==undefined)
		{
			enterpriseRegion=0;
		}
		if(NonExport)
		{
		$.post("report/enterprise!enterpriseByRegion.do",
		{
		createtime1:Createtime1,
		createtime2:Createtime2,
		enterpriseregion:enterpriseRegion
		},
			function(data)
			{	
				$("#enterpriseByRegion").html(data);
			}
		);
		}
		else
		{
				window.location.href='report/Edownload!ExportEnterpriseByRegion.do?createtime1='+Createtime1+'&createtime2='+Createtime2+'&enterpriseregion='+enterpriseRegion;
		}
		
	}
	$(newlyenterprise)
</script>
	
	</head>
<body><div id="tabs" style="text-align: center;">
<ul>
	<li><a href="#tabs-1">年度新增企业汇总</a></li>
	<li><a href="#tabs-2">企业年度汇总</a></li>
	<li><a href="#tabs-3">按行业统计企业总量</a></li>
	<li><a href="#tabs-4">按地区统计企业总量</a></li>
</ul>
<div id="tabs-1"><div id="newlyenterprise" style="text-align: center">
<img src="<%=basePath %>img/ajax-loader.gif" align="middle" />
</div></div>

<!--
 年度新增企业汇总
--><div id="tabs-2"><div id="AnnualSummary" style="text-align: center">
<img src="<%=basePath %>img/ajax-loader.gif" align="middle" />
</div></div>




<!--  
    按行业统计企业总量
--><div id="tabs-3"><div id="enterpriseByType" style="text-align: center">
<img src="<%=basePath %>img/ajax-loader.gif" align="middle" />
</div></div>

<!--    
    按地区统计企业总量
--><div id="tabs-4"><div id="enterpriseByRegion" style="text-align: center">
<img src="<%=basePath %>img/ajax-loader.gif" align="middle" />
</div></div>
</div>
    </body>
</html>
<object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
  <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
</object>
<script type="text/javascript">
var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));
</script>

