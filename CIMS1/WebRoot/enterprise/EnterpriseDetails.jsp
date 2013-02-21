<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'EnterpriseDateils.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/AdminCss.css" />
        <link rel="stylesheet" type="text/css" href="<%=basePath %>css/css.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="<%=basePath %>js/colorwinglib.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery-ui.js"></script>
  </head>
  <body>
  <table border="0" cellpadding="0" cellspacing="0" id="tbList" align="center" style="width:80%">
    <tr><td colspan="10" style="font:+5; color:#black;text-align:center" height="30">文化企业信息详细</td></tr>
    <tr>
      <td style="width:8%;border:1px solid #cedff7;"> 统计人员 </td>
      <td style="width:12%" class="DetailsValue">${PeoplenameByPeopleid1 }
     </td>
      <td style="width:9%"> 填表人员 </td>
      <td style="width:12%" class="DetailsValue">${PeoplenameByPeopleid2 }
      </td>
      <td style="width:9%"> 登录人员 </td>
      <td class="DetailsValue">${TruenameByAdminid } 
      </td>
      <td style="width:6%"> 部  门 </td>
      <td class="DetailsValue">
		${SectornameBySectorid }

        </td>
      <td style="width:9%"> 登录时间 </td>
      <td class="DetailsValue">
      
       <label >${Logintime}</label>
        </td>
    </tr>
  </table>
  <table border="0" align="center" cellpadding="0" cellspacing="0" id="tbEdit" style="table-layout: fixed;">
  <tr >

 	 <td width="10%">企业编号</td>
    <td style="width:23%" class="DetailsValue" >${Enterpriseid }</td>


  <td width="10%"> 企业名称 </td>
    <td style="width:23%" class="DetailsValue">${Enterprisename }</td>
 

  <td width="10%">法人 </td>
    <td style="width:23%" class="DetailsValue">${Legalperson }</td>

    </tr>
    
 
    
  <tr >

 	 <td width="10%">行业类型</td>
    <td style="width:23%" class="DetailsValue">${ProfessionByBusinessTypeId}</td>


  <td width="10%"> 企业性质 </td>
    <td style="width:23%" class="DetailsValue">${Qualityname }</td>


  <td width="10%">所属区域</td>
    <td style="width:23%" class="DetailsValue">${Regionid }</td>

    </tr>
    
      <tr >

 	 <td width="10%">就业人数</td>
    <td style="width:23%" class="DetailsValue">${Employnumber }</td>


  <td width="10%"> 年产值 </td>
    <td style="width:23%" class="DetailsValue">${Producevalue}</td>
 

  <td width="10%">利润 </td>
    <td style="width:23%" class="DetailsValue">${Profit}</td>

    </tr>
    
      <tr >

 	 <td width="10%">注册资金</td>
    <td style="width:23%" class="DetailsValue"> ${Registfund}</td>


  <td width="10%"> 总投资 </td>
    <td style="width:23%" class="DetailsValue">${Toalinvest}</td>
 

  <td width="10%">占地面积  </td>
    <td style="width:23%" class="DetailsValue">${Area}</td>

    </tr>
    
    
        <tr >

 	 <td width="10%">工商登记号</td>
    <td style="width:23%" class="DetailsValue">${Enterprisecode}</td>


  <td width="10%"> 产品专利号 </td>
    <td style="width:23%" class="DetailsValue">${Partentcode}</td>


  <td width="10%">创建时间  </td>
    <td style="width:23%" class="DetailsValue">${Createtime}</td>

    </tr>


  <tr>

  	<td width="10%">企业注册地址</td>
  	<td  class="DetailsValue">${Registaddress}</td>
	<td width="10%">联系人</td>
  	<td  class="DetailsValue">${Contact}</td>
  	<td width="10%">联系电话</td>
  	<td  class="DetailsValue">${Linkphone }</td>
  
  </tr>
  
  <tr >

  		<td width="10%">企业地址 </td> 
    	<td style="text-align: left;vertical-align: top;"  colspan="5" class="DetailsValue">${Address}</td>

  </tr>
<tr>
  		<td width="10%">经营范围</td>
    	<td style="text-align: left;vertical-align: top;" colspan="5"  class="DetailsValue">${Scope}</td>

  </tr>
   <tr >
  
  		<td width="10%"> 产品特色</td>
    	<td style="text-align: left;vertical-align: top;" colspan="5" class="DetailsValue">${Feature}</td>

  </tr>
     <tr >
  
  		<td width="10%"> 获得荣誉</td>
    	<td style="text-align: left;vertical-align: top;" colspan="5" class="DetailsValue">${Obtainhonor}</td>
  	
  </tr>
     <tr >
 
  		<td width="10%"> 社会效益</td>
    	<td style="text-align: left;vertical-align: top;" colspan="5" class="DetailsValue">${Socialbenefit}</td>
  	
  </tr>
  <tr>
    <td colspan="6" align="center">
    <div align="center">
    <input type="button" name="button" id="btnReturn" value="" onclick="window.location.href='${pageListUrl}'" /></div>
      </td>
  </tr>
</table>
  </body>
</html>
