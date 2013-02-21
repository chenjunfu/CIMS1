<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'IndustryProjectDetails1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/css.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/AdminCss.css" />
        <link rel="stylesheet" type="text/css" href="<%=basePath %>css/smoothness/jquery-ui.css"/>
        <link rel="stylesheet" type="text/css" href="<%=basePath %>css/jquery1.9.2/jquery-ui.css"/>
		<script type="text/javascript" src="<%=basePath %>js/colorwinglib.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery-ui.js"></script>

  </head>
  <body>
  	
<table border="0" cellpadding="0" cellspacing="0" id="tbEdit" align="center" style="width: 80%">
<tr>
<td colspan="10" style="font:+5;height:30px; text-align:center ;border-left: 1px solid #cedff7;"  >产业项目信息详细</td>
</tr>
  <tr >
       <td style="width:8%;border: 1px solid #cedff7;"   >
统计人员
    </td>
    <td style="width:12%;border-bottom: 1px solid #cedff7;" class="DetailsValue">
${Databasepeopleid2}
 </td>
  
    <td style="width:9%;border-bottom: 1px solid #cedff7;">
填表人员
    </td>
    <td style="width:12%;border-bottom: 1px solid #cedff7;" class="DetailsValue">
${Databasepeopleid1}
</td> 
    <td style="width:9%;border-bottom: 1px solid #cedff7;"> 登录人员 </td>
    <td style="border-bottom: 1px solid #cedff7;" class="DetailsValue">${Adminid}
    </td>
    <td style="width:6%;border-bottom: 1px solid #cedff7;"> 部 门 </td>
    <td style="border-bottom: 1px solid #cedff7;" class="DetailsValue">    
${Sectorid}
    <input name="sectorid" type="hidden" id="txtSectoridEdit" value="<s:property value='#session.AdminUserInfosectorid' />" title="部门编号" size="8" maxlength="8" /></td>
    <td style="width:12%;border-bottom: 1px solid #cedff7;"> 登录时间 </td>
    <td style="border-bottom: 1px solid #cedff7;" class="DetailsValue">
	${Logintime}  
    </td>
    </tr>
</table>





<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="tbEdit" style="table-layout: fixed;"  >
<tr>

<td width="10%" >项目编号</td>
<td width="23%" class="DetailsValue">${Projectid}</td>

<td width="10%">项目名称</td>
<td width="23%" class="DetailsValue">${Projectname}</td>

<td width="12%">经营单位</td>
<td width="21%" class="DetailsValue">${Databaseenterpriseid}</td>

</tr>

<tr>

<td width="10%">建设性质</td>
<td class="DetailsValue">${ProqulinameByProquality}</td>


<td width="10%">产业类别</td>
<td class="DetailsValue">${BusinesstypenameByIndustryid}</td>



<td width="12%">主管单位</td>
<td class="DetailsValue">${UnitnameByDutyunitid}</td>

</tr>


<tr>


<td width="10%">所属区域</td>
<td class="DetailsValue">${RegionnameByRegionid}</td>


<td width="10%">地址</td>
<td class="DetailsValue">${Address}</td>



<td width="12%">经营状况 </td>
<td class="DetailsValue">${State}</td>

</tr>


<tr>

<td width="10%">创建时间</td>
<td class="DetailsValue">${Createtime}</td>


<td width="10%">计划完成时间</td>
<td class="DetailsValue">${Plantime}</td>



<td width="12%">完成时间  </td>
<td class="DetailsValue">${Completetime}</td>
</tr>



<tr>


<td width="10%">总投资</td>
<td class="DetailsValue">${Totalinvest}</td>


<td width="10%">实际投资</td>
<td class="DetailsValue">${Realinvest}</td>


<td width="12%">截止去年年底完成投资  </td>
<td class="DetailsValue">${Yearinvest}</td>

</tr>

<tr>
 

<td width="10%">年计划投资</td>
<td class="DetailsValue">&nbsp;${Planinvest}</td>


<td width="10%">&nbsp;</td>
<td>&nbsp;</td>



<td width="12%">&nbsp;  </td>
<td>&nbsp;</td>
</tr>


<tr><td colspan="6" style="text-align: center;border-left: 1px solid #cedff7; padding: 5px">资金来源</td></tr>

<tr>
 

<td width="10%">政府投资</td>
<td class="DetailsValue">&nbsp;${Publicinvest}</td>


<td width="10%">&nbsp;自筹</td>
<td class="DetailsValue">&nbsp;${Selfinvest }</td>



<td width="12%">&nbsp;银行贷款   </td>
<td class="DetailsValue">&nbsp;${Bankloan }</td>

</tr>


<tr><td colspan="6" style="text-align: center;border-left: 1px solid #cedff7;">项目前期进展情况</td></tr>
 
  
  <tr>
  	<td colspan="6" style="border:1px solid #cedff77;border-left: 1px solid #cedff7;padding: 0px">
  	<table cellpadding="0" cellspacing="0"  style="height: 100%;width: 100% ;border:0px solid #cedff7; " >
  	<tr>
  	<td style="border: 0px solid;border-right:1px solid #cedff7;" width="10%" ><font >审批核准备案</font></td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%"  class="DetailsValue">
${Shb}
</td>
  	<td style="border: 0px solid;border-right:1px solid #cedff7;" width="10%" >规划选址</td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%" class="DetailsValue">${Ghxz}
</td>
  	<td style="border: 0px solid;border-right:1px solid #cedff7;" width="10%" >环评批复</td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%" class="DetailsValue">${Hppf}

</td>
  	<td style="border: 0px solid;border-right:1px solid #cedff7;" width="10%" >土地批准</td>
  	<td style="border: 0px solid;" width="15%" class="DetailsValue">
  	${Tdpz}
</td>
  </tr>
  </table>
  </td>
</tr>

  <tr>
  	<td colspan="6" style="border:1px solid #cedff77;border-left: 1px solid #cedff7;padding: 0px"><table cellpadding="0" cellspacing="0"  style="height: 100%;width: 100% ;border:0px solid #cedff7; " >
  	<tr>
  	<td style="border: 0px solid;border-right:1px solid #cedff7;" width="10%" ><font >审批文号</font></td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%" class="DetailsValue" >${Shbno}

</td>
  	<td style="border: 0px solid;border-right:1px solid #cedff7;" width="10%" >规划选址文号</td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%" class="DetailsValue">${Ghxzno}
</td>
  	<td style="border: 0px solid;border-right:1px solid #cedff7;" width="10%" >环评批复文号</td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%" class="DetailsValue">${Hppfno}
</td>
  	<td style="border: 0px solid;border-right:1px solid #cedff7;" width="10%" >土地批准文号</td>
  	<td style="border: 0px solid;" width="15%" class="DetailsValue">${Tdpzno }</td>
  </tr>
  </table>
</td></tr>
  
  
  <tr>
  	<td colspan="6" style="border:1px solid #cedff77;border-left: 1px solid #cedff7;padding: 0px"><table cellpadding="0" cellspacing="0"  style="height: 100%;width: 100% ;border:0px solid #cedff7; " >
  	<tr>
  	<td style="border: 0px solid;border-right:1px solid #cedff7;" width="10%" >计划进度</td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%" class="DetailsValue">${Planprogress}</td>
  	<td style="border: 0px solid;border-right:1px solid #cedff7;" width="10%" >实际进度</td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%" class="DetailsValue">${Realprogress}</td>
  	<td style="border: 0px solid;border-right:1px solid #cedff7;" width="10%" >联系人</td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%" class="DetailsValue">${Linkman}</td>
  	<td style="border: 0px solid;border-right:1px solid #cedff7;" width="10%" >联系电话</td>
  	<td style="border: 0px solid;" width="15%" class="DetailsValue">${Phone}</td>
  </tr>
  	
  	</table></td>
  </tr>
 
  <tr >
  
  <td width="10%">项目内容</td>
  <td style="vertical-align: top;" colspan="5" class="DetailsValue">${Procontent}</td>
 
  </tr>
  <tr>
  <td width="10%">备注</td>
  <td style="vertical-align: top;"colspan="5" class="DetailsValue"> ${Comment}</td>
  </tr>
  <tr>
  <td width="10%">项目特色</td>
  <td style="vertical-align: top;" colspan="5" class="DetailsValue"> ${Feature}</td>
 
  </tr>
  
  
  
  <tr >
    <td colspan="6" style="border: 0px;margin: 0px;padding: 0px; border-top: 1px solid #cedff7;;">
     <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="table2"  style="margin: 0px;padding: 0px;" >
    <tr>
    <td  style="border: 1px solid #cedff7; border-top: 0px;border-bottom: 0px" valign="top" id="tdlist">
    请稍等，正在加载....
    </td>
    </tr>
    </table>
    </td>
    </tr>
  <tr>
    <td colspan="6" style="border: 1px solid #cedff7;" >
    <div align="center">
      <input type="button" name="btnReturn" id="btnReturn" value="" onclick="window.location.href='${pageListUrl}'" />
      </div>
      </td>
  </tr>
</table>
 <div id="picmax" style=" width:570px; height:300px; position:absolute; text-decoration:inherit;   display:none; ">
   <div align="center" style="vertical-align:middle"><img src="" width="570" height="300"   border="0" id="picmig1" title="" /></div>
 </div>
  </body>
</html>
<script type="text/javascript">
function ListShow()
{
   ajaxPage("<%=basePath%>ajax/Projectpic.do?pagetype=list&databaseprojectid=${Databaseprojectid}&s=" + new Date().getTime());
}

function ajaxPage(Url)
{
    $.get(Url,
           function(data)
           {
               document.getElementById("tdlist").innerHTML = data;
           });
}



function upclick(dataelement,obj)
{	

	var targetTop;
	var targetLeft;
	var baseleft=parseInt($(obj).offset().left);
	var basetop=parseInt($(obj).offset().top);
    var basewidth=parseInt($(obj).width());
    var baseHeight=parseInt($(obj).height());
    var targetWidth=parseInt($("#picmax").css("width"));
    var targetHeight=parseInt($("#picmax").css("height"));

    targetLeft=parseInt((basewidth/2+baseleft)-(targetWidth/2));
    targetTop=parseInt(basetop-300);
   	var imageRight=targetLeft+targetWidth;
   	var ClientWidht=document.body.clientWidth;
   	if(imageRight>ClientWidht)
   	{
   		targetLeft=ClientWidht-targetWidth-20;
   	}
   	if(targetLeft<0)
   	{
   		targetLeft=20;
   	}
	$("#picmax").css({left:targetLeft+"px",top:targetTop+"px"})
	$("#picmax").show();
	$("#picmig1").attr({src:"<%=basePath%>"+dataelement})
}
function closepic(){
$("#picmax").css({display:"none"})

}
ListShow();
</script>

