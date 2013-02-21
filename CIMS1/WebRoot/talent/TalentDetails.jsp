<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'TalentDetails1.jsp' starting page</title>
    
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
		<script type="text/javascript" src="<%=basePath %>js/c02City.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/c02_select2.js"></script>
  </head>
  
  <body>
<form name="produceForm" id="frmEdit" method="post"  action="${btnEditCommandArgument}" >

<table border="0" cellpadding="0" cellspacing="0" id="tbEdit" align="center">
<tr><td colspan="10" style="font:+5; color:#black;text-align:center" height="30">文化人才信息详细</td></tr>
<tr>
    <td style="width:8%;border:1px solid #cedff7;">
统计人员  </td>
    <td style="width:12%" class="DetailsValue">
${PeoplenameByDatabasepeopleid1}
</td>
 
    <td style="width:9%">
填表人员    </td>
    <td style="width:12%" class="DetailsValue">
${PeoplenameByDatabasepeopleid2}
   </td>
  
    <td style="width:9%">
登录人员    </td>
    <td class="DetailsValue">
${AdminName }
 </td>
  
    <td style="width:6%">
部  门    </td>
    <td class="DetailsValue">
${SectornameBySectorid}

 </td>
  
    <td style="width:9%">
登录时间 </td>
    <td class="DetailsValue">

<label>${Logintime}</label>
</td>
  </tr>
</table>


<table border="0" cellpadding="0" cellspacing="0" id="tbEdit" align="center" style="table-layout: fixed; width: 80%">
  <tr>
      <td width="10%"> 编号 </td>
    <td width="23%" class="DetailsValue">
    ${Talentid }</td>
    <td width="10%"> 姓名 </td>
    <td width="23%" class="DetailsValue">
    ${Talentname}</td>
    <td width="10%"> 性别 </td>
    <td align="left" width="23%" class="DetailsValue">
    ${Sexlabel }
          </td>
          
         
      </tr>
  <tr>
    <td width="100px"> 出生日期 </td>
    <td class="DetailsValue">${Birthday}</td>
    <td width="100px"> 籍贯 </td>
    <td class="DetailsValue">${Nativeplace}    </td>
    <td width="100px"> 民族 </td>
    <td class="DetailsValue">
    ${NationnameByNationid }
  </td>
  </tr>
  <tr>
    <td width="100px"> 省份 </td>
    <td class="DetailsValue">${CitynameByProvince }
        </td>
    <td width="100px"> 地区 </td>
    <td class="DetailsValue">${CitynameByCityid }
      </td>
     <td width="100px"> 人才所属行业 </td>
    <td class="DetailsValue">
  ${TalentprofessionnameByTalentprofessionid }
     </td>
    </tr>
  <tr>
    <td width="100px"> 学位 </td>
    <td width="100px" class="DetailsValue">${DegreenameByDegreeid }
          </td>
    <td width="100px"> 专业 </td>
    <td class="DetailsValue">${MajornameByMajorid }
        </td>
    <td width="100px"> 学历 </td>
    <td class="DetailsValue">${EducationnameByEducationid }
         </td>
 
  </tr>
  <tr>
    <td width="100px"> 手机 </td>
    <td class="DetailsValue">${Movephone}</td>
    <td width="100px"> 邮箱 </td>
    <td class="DetailsValue">${Email}  </td>
	
	<td width="100px"> 职称 </td>
    <td class="DetailsValue">
    ${TitlenameByPosttitleid }
 </td>
	 </tr>
  	<tr>
    <td width="100px"> 工作单位 </td>
    <td class="DetailsValue">${Workunit}    </td>
    <td width="100px"> 现在住址 </td>
    <td class="DetailsValue">${Adress}    </td>
	<td width="100px"> 政治面貌 </td>
    <td class="DetailsValue">${Politicsstatus}   </td>
	 
  </tr>
  
  <tr>
    <td width="100px"> 工作经历 </td>
    <td colspan="5" class="DetailsValue">${Workexperience}</td>
  </tr>
  <tr>
    <td width="100px"> 个人学习经历 </td>
    <td colspan="5" class="DetailsValue">${Learnexperience}</td>
  </tr>
  <tr>
    <td width="100px"> 业绩 </td>
    <td colspan="5" class="DetailsValue">${Acheivement}</td>
  </tr>
  <tr>
    <td width="100px"> 荣誉 </td>
    <td colspan="5" class="DetailsValue">${Honor}  </td>
  </tr>
  <tr>
    <td width="100px"> 专长 </td>
    <td colspan="5" class="DetailsValue">${Skills}   </td>
  </tr>
  <tr>
    <td colspan="6" align="center"><div align="center">

      <input type="button" name="btnReturn" id="btnReturn" value="" onclick="window.location.href='${pageListUrl}&pagetype=select'" />
    </div></td>
  </tr>
</table>
</form>
  </body>
</html>
