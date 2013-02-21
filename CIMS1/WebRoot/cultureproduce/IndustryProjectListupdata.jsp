<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title><%=com.yun.configuration.WebConfig.WEB_TITLE %></title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/smoothness/jquery-ui.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/css.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/AdminCss.css" />
		<script type="text/javascript" src="<%=basePath %>js/colorwinglib.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery-ui.js"></script>

	</head>
	<body>
<div   >
<table border="0" cellpadding="0" cellspacing="0" id="tbListSelect">
<tr>
  <td colspan="11" style="font:+5; color:#black;text-align:center" height="30">产业项目信息变更</td></tr>
  <tr>
    <td>
项目名称
    </td>
    <td>
  <input name="projectname" type="text" id="txtProjectnameList" value="${Projectname}" title="项目名称" size="20" maxlength="50" />
    </td>
    <td> 所属区域 </td>
    <td><select name="regionid" id="dropRegionidList" title="所属区域" style="width:150px;">
      <option value="">全部</option>
      
${RegionidList}

    </select>
      <script type="text/javascript">document.getElementById('dropRegionidList').value='${Regionid}';</script></td>
    <td> 主管单位 </td>
    <td><select name="dutyunitid" id="dropDutyunitidList" title="主管单位" style="width:150px;">
      <option value="">全部</option>
      
${DutyunitidList}

    </select>
      <script type="text/javascript">document.getElementById('dropDutyunitidList').value='${Dutyunitid}';</script></td>
    <td> 产业类别 </td>
    <td><select name="industryid" id="dropIndustryidList" title="产业类别" style="width:150px;">
      <option value="">全部</option>
      
${IndustryidList}

    </select>
      <script type="text/javascript">document.getElementById('dropIndustryidList').value='${Industryid}';</script></td>
    <td> 创建时间 </td>
    <td><input name="createtime" type="text" id="txtCreatetimeList" value="${Createtime}" title="创建时间" size="10" maxlength="20" />
    <script type="text/javascript">
//列表页面初始化日期控件
$("#txtCreatetimeList").datepicker({changeMonth: true,changeYear: true}); //创建时间
</script>
    </td>
    <td style="text-align: center;"><input type="button" id="btnSearch" value="" onclick="search()" />
    </td>
  </tr>
<script type="text/javascript">
function search()
{	

	var locationHref=window.location.pathname + "?pagetype=updata&getdata=1";
	try{locationHref += "&projectnames=" +  encodeURI(document.getElementById("txtProjectnameList").value);}catch (ex){}//项目名称
	try{locationHref += "&regionids=" +  encodeURI(document.getElementById("dropRegionidList").value);}catch (ex){}//所属区域
	try{locationHref += "&dutyunitids=" +  encodeURI(document.getElementById("dropDutyunitidList").value);}catch (ex){}//主管单位
	try{locationHref += "&industryids=" +  encodeURI(document.getElementById("dropIndustryidList").value);}catch (ex){}//产业类别
	try{locationHref += "&createtimes=" +  encodeURI(document.getElementById("txtCreatetimeList").value);}catch (ex){}//创建时间
	locationHref += "&s=" + new Date().getTime();
	window.location.href = locationHref;
}
try{document.getElementById("txtProjectnameList").value = "<%=new String( com.colorwinglib.Requests.GetString(request,"projectnames").getBytes("ISO-8859-1"),"utf-8") %>";}catch (ex){}
try{document.getElementById("dropRegionidList").value = "<%= com.colorwinglib.Requests.GetString(request,"regionids") %>";}catch (ex){}
try{document.getElementById("dropDutyunitidList").value = "<%= com.colorwinglib.Requests.GetString(request,"dutyunitids") %>";}catch (ex){}
try{document.getElementById("dropIndustryidList").value = "<%= com.colorwinglib.Requests.GetString(request,"industryids") %>";}catch (ex){}
try{document.getElementById("txtCreatetimeList").value = "<%= com.colorwinglib.Requests.GetString(request,"createtimes") %>";}catch (ex){}

</script>
</table>
</div>
<div >
      <table border="0" cellpadding="0" cellspacing="0" id="tbList" style="table-layout:fixed;word-break:break-all; word-wrap:normal;">
            <thead>
            <tr>
              <td width="80px" > 操作 </td>
              <td width="80px">
                  &nbsp;<a href="${pageListUrlOrderBy}&pagetype=updata&OrderByItem=ProjectID&OrderByItemDESC=${pageListOrderByItemDESCNo}">项目编号</a>
                </td>
                <td >
                    &nbsp;<a href="${pageListUrlOrderBy}&pagetype=updata&OrderByItem=ProjectName&OrderByItemDESC=${pageListOrderByItemDESCNo}">项目名称</a>
                </td>
                <td >
                    &nbsp;<a href="${pageListUrlOrderBy}&pagetype=updata&OrderByItem=RegionID&OrderByItemDESC=${pageListOrderByItemDESCNo}">所属区域</a>
                </td>
                <td width="150px" >
                    &nbsp;<a href="${pageListUrlOrderBy}&pagetype=updata&OrderByItem=Address&OrderByItemDESC=${pageListOrderByItemDESCNo}">所在地址</a>
                </td>
                <td >
                    &nbsp;<a href="${pageListUrlOrderBy}&pagetype=updata&OrderByItem=DutyUnitID&OrderByItemDESC=${pageListOrderByItemDESCNo}">主管单位</a>
                </td>
                <td >
                    &nbsp;<a href="${pageListUrlOrderBy}&pagetype=updata&OrderByItem=DatabaseEnterpriseID&OrderByItemDESC=${pageListOrderByItemDESCNo}">经营单位</a>
                </td>
                <td width="150px" >
                    &nbsp;<a href="${pageListUrlOrderBy}&pagetype=updata&OrderByItem=IndustryID&OrderByItemDESC=${pageListOrderByItemDESCNo}">产业类别</a>
                </td>
                <td >
                    &nbsp;<a href="${pageListUrlOrderBy}&pagetype=updata&OrderByItem=TotalInvest&OrderByItemDESC=${pageListOrderByItemDESCNo}">投入资金</a>
                </td>
               
                <td width="100px">
                    &nbsp;<a href="${pageListUrlOrderBy}&pagetype=updata&OrderByItem=CreateTime&OrderByItemDESC=${pageListOrderByItemDESCNo}">创建时间</a>
                </td>
                <td >
                    &nbsp;<a href="${pageListUrlOrderBy}&pagetype=updata&OrderByItem=DatabasePeopleID1&OrderByItemDESC=${pageListOrderByItemDESCNo}">填表人员</a>
                </td>
                <td >
                    &nbsp;<a href="${pageListUrlOrderBy}&pagetype=updata&OrderByItem=DatabasePeopleID2&OrderByItemDESC=${pageListOrderByItemDESCNo}">统计人员</a>
                </td>
              </tr>
            </thead>
		<s:iterator id="iteList" value="#request.IndustryProjectList">
            <tr>
              <td><a href="${pageListUrl}&pagetype=gotoupdate&databaseprojectid=${iteList.databaseprojectid}">变更</a> <a onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&amp;${pageListUrl}&amp;databaseprojectid=${iteList.databaseprojectid}'}" href="#">删除</a></td>
              <td>
			&nbsp;${iteList.projectid}
                </td>
                <td>
			&nbsp;${iteList.projectname}
                </td>
                <td>
			&nbsp;${iteList.objRegionsInfoByRegionid.regionname}
                </td>
                <td>
			&nbsp;${iteList.address}
                </td>
                <td>
			&nbsp;${iteList.objUnitInfoByDutyunitid.unitname}
                </td>
                <td>
			&nbsp;${iteList.objEnterpriseInfoByDatabaseenterpriseid.enterprisename}
                </td>
                <td>
			&nbsp;${iteList.objProfessionInfoByIndustryid.businesstypename}
                </td>
                <td>
			&nbsp;${iteList.totalinvest}
                </td>
               
                <td>
			&nbsp;${iteList.createtime.shortDate}
                </td>
                <td>
			&nbsp;${iteList.objSystemAdminInfoByDatabasepeopleid1.truename}
                </td>
                <td>
			&nbsp;${iteList.objSystemAdminInfoByDatabasepeopleid2.truename}
                </td>
            </tr>
		</s:iterator>
			<tr><td colspan="12">${pageDetails}</td></tr>
            </table>

<script type="text/javascript" language="javascript" src="tableColor.js"></script>
    </div>
${pageJavaScripStar }
	</body>
</html>
