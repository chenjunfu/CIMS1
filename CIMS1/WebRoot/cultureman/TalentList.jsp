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

		<link rel="stylesheet" type="text/css" href="/css/AdminCss.css" />
		<link rel="stylesheet" type="text/css" href="css/css.css" />
		<link rel="stylesheet" type="text/css" href="/css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="/js/colorwinglib.js"></script>
		<script type="text/javascript" src="/js/jquery.js"></script>
		<script type="text/javascript" src="/js/jquery-ui.js"></script>

	</head>
	<body>

<table border="0" cellpadding="0" cellspacing="0" id="tbListSelect">
  <tr><td colspan="12" align="center" style="font:+1; color:#0033ff" height="30">文化人才信息查询</font></td></tr>
  
  <tr>
    <td width="5%">
姓名    </td>
    <td width="10%">
<input name="talentname" type="text" id="txtTalentnameList" value="${Talentname}" title="姓名" size="15" maxlength="50" />    </td>
  
    <td width="5%">民族</td>
    <td width="10%"><select name="select3" id="select3" title="民族" style="width:100px">       
${EducationidEdit}
      </select>
        <script type="text/javascript">document.getElementById('dropEducationidEdit').value='${Educationid}';</script>        </td>
 
    <td width="5%">
专业    </td>
    <td width="10%"><select name="skillid" id="dropSkillidList" title="专长编号" style="width:80px">
      <option value=""></option>
      
${SkillidList}

    </select>
    <script type="text/javascript">document.getElementById('dropSkillidList').value='${Skillid}';</script>    </td>
	<td width="5%">学历</td>
    <td width="10%"><select name="skillid" id="dropSkillidList" title="专长编号" style="width:80px">
      <option value=""></option>
      
${SkillidList}

    </select>
    <script type="text/javascript">document.getElementById('dropSkillidList').value='${Skillid}';</script>    </td>
  
    <td width="5%">
职称</td>
    <td width="10%"><select name="posttitleid" id="dropPosttitleidList" title="职称级别编号" style="width:80px">
      <option value="">全部</option>
      
${PosttitleidList}

    </select>
    <script type="text/javascript">document.getElementById('dropPosttitleidList').value='${Posttitleid}';</script>    </td>
 
    <td colspan="2" align="center"><img src="/img/xg1.jpg" name="button" id="button" value="搜索" onclick="search()" /></td>
  </tr>
<script type="text/javascript">
function search()
{
	var locationHref=window.location.pathname + "?";
	try{locationHref += "&talentnames=" +  encodeURI(document.getElementById("txtTalentnameList").value);}catch (ex){}//姓名
	try{locationHref += "&birthday1s=" +  encodeURI(document.getElementById("txtBirthday1List").value);}catch (ex){}//出生日期
	try{locationHref += "&birthday2s=" +  encodeURI(document.getElementById("txtBirthday2List").value);}catch (ex){}//出生日期
	try{locationHref += "&sexs=" +  encodeURI(document.getElementById("txtSexList").value);}catch (ex){}//性别
	try{locationHref += "&politicsstatuss=" +  encodeURI(document.getElementById("txtPoliticsstatusList").value);}catch (ex){}//政治面貌
	try{locationHref += "&skillids=" +  encodeURI(document.getElementById("dropSkillidList").value);}catch (ex){}//专长编号
	try{locationHref += "&posttitleids=" +  encodeURI(document.getElementById("dropPosttitleidList").value);}catch (ex){}//职称级别编号
	locationHref += "&s=" + new Date().getTime();
	window.location.href = locationHref;
}
try{document.getElementById("txtTalentnameList").value = "<%= com.colorwinglib.Requests.GetString(request,"talentnames") %>";}catch (ex){}
try{document.getElementById("txtBirthday1List").value = "<%= com.colorwinglib.Requests.GetString(request,"birthday1s") %>";}catch (ex){}
try{document.getElementById("txtBirthday2List").value = "<%= com.colorwinglib.Requests.GetString(request,"birthday2s") %>";}catch (ex){}
try{document.getElementById("txtSexList").value = "<%= com.colorwinglib.Requests.GetString(request,"sexs") %>";}catch (ex){}
try{document.getElementById("txtPoliticsstatusList").value = "<%= com.colorwinglib.Requests.GetString(request,"politicsstatuss") %>";}catch (ex){}
try{document.getElementById("dropSkillidList").value = "<%= com.colorwinglib.Requests.GetString(request,"skillids") %>";}catch (ex){}
try{document.getElementById("dropPosttitleidList").value = "<%= com.colorwinglib.Requests.GetString(request,"posttitleids") %>";}catch (ex){}

</script>
</table>
    <div id="divlist">
            <table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr>
			<td>
                操作                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=TalentName&OrderByItemDESC=${pageListOrderByItemDESCNo}">姓名</a>                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Birthday&OrderByItemDESC=${pageListOrderByItemDESCNo}">出生日期</a>                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Sex&OrderByItemDESC=${pageListOrderByItemDESCNo}">性别</a>                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=PoliticsStatus&OrderByItemDESC=${pageListOrderByItemDESCNo}">政治面貌</a>                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=WorkUnit&OrderByItemDESC=${pageListOrderByItemDESCNo}">工作单位</a>                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=WorkExperience&OrderByItemDESC=${pageListOrderByItemDESCNo}">主要工作经历</a>                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Acheivement&OrderByItemDESC=${pageListOrderByItemDESCNo}">业绩</a>                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Honor&OrderByItemDESC=${pageListOrderByItemDESCNo}">荣誉</a>                </td>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.TalentList">
            <tr>
			<td>
			<a onclick="window.open('?pagetype=gotoupdate&amp;${pageListUrl}&amp;talentid=${iteList.talentid}','Microsoft','height=500,width=1100,location=no,status =no,titlebar = no,toolbar =no,scrollbars = yes') "href="#">查询</a>
             </td>
                <td>
			&nbsp;${iteList.talentname}                </td>
                <td>
			&nbsp;${iteList.birthday.shortDate}                </td>
                <td>
			&nbsp;${iteList.sex}                </td>
                <td>
			&nbsp;${iteList.politicsstatus}                </td>
                <td>
			&nbsp;${iteList.workunit}                </td>
                <td>
			&nbsp;${iteList.workexperience}                </td>
                <td>
			&nbsp;${iteList.acheivement}                </td>
                <td>
			&nbsp;${iteList.honor}                </td>
            </tr>
		</s:iterator>
            </table>
${pageDetails}
<script type="text/javascript" language="javascript" src="tableColor.js"></script>
    </div>

	</body>
</html>


<script type="text/javascript">
//列表页面初始化日期控件
$("#txtBirthday1List").datepicker({changeMonth: true,changeYear: true}); //出生日期
$("#txtBirthday2List").datepicker({changeMonth: true,changeYear: true}); //出生日期
</script>

