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
		
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/css.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/AdminCss.css" />
		
		<script type="text/javascript" src="<%=basePath %>js/colorwinglib.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery-ui.js"></script>


	</head>
	<body>
	${pageJavaScripNoPrives}

<table border="0" cellpadding="0" cellspacing="0" id="tbListSelect">
<tr><td colspan="12" style="font:+5; color:#black;text-align:center" height="30">文化人才信息变更</td></tr>
  <tr>
    <td style="width:5%">
姓	名
    </td>
    <td style="width:10%">
<input name="talentname" type="text" id="txtTalentnameList" value="${Talentname}" title="姓名" size="20" maxlength="50" />
    </td>
  
    <td style="width:5%">
民	族
    </td>
    <td style="width:10%">
<select name="nationid" id="dropNationidList" style="width:150px" title="民族">
<option value="">全部</option>
${NationidList}
</select>
<script type="text/javascript">document.getElementById('dropNationidList').value='${Nationid}';</script>    </td>
  
    <td style="width:5%">
学	历
    </td>
    <td style="width:10%">
<select name="educationid" id="dropEducationidList" style="width:150px" title="学历">
<option value="">全部</option>
${EducationidList}
</select>
<script type="text/javascript">document.getElementById('dropEducationidList').value='${Educationid}';</script>    </td>
  
    <td style="width:5%">
专	业
    </td>
    <td style="width:15%">
<select name="majorid" id="dropMajoridList" style="width:150px" title="专业">
<option value="">全部</option>
${MajoridList}
</select>
<script type="text/javascript">document.getElementById('dropMajoridList').value='${Majorid}';</script>    </td>
  
    <td style="width:5%">
职	称
    </td>
    <td style="width:15%">
<select name="posttitleid" id="dropPosttitleidList" style="width:150px" title="职称">
<option value="">全部</option>
${PosttitleidList}
</select>
<script type="text/javascript">document.getElementById('dropPosttitleidList').value='${Posttitleid}';</script>    </td>
 
    <td  style="text-align: center;"><input type="button" id="btnSearch" value="" onclick="search()" /></td>
  </tr>
<script type="text/javascript">
function search()
{
	var locationHref=window.location.pathname + "?state=1";
	try{locationHref += "&talentnames=" +  encodeURI(document.getElementById("txtTalentnameList").value);}catch (ex){}//姓名
	try{locationHref += "&nationids=" +  encodeURI(document.getElementById("dropNationidList").value);}catch (ex){}//民族
	try{locationHref += "&educationids=" +  encodeURI(document.getElementById("dropEducationidList").value);}catch (ex){}//学历
	try{locationHref += "&majorids=" +  encodeURI(document.getElementById("dropMajoridList").value);}catch (ex){}//专业
	try{locationHref += "&posttitleids=" +  encodeURI(document.getElementById("dropPosttitleidList").value);}catch (ex){}//职称
	locationHref += "&s=" + new Date().getTime();
	locationHref += "&whole=" + "yes" ;
	window.location.href = locationHref;
}
try{document.getElementById("txtTalentnameList").value = "<%=new String( com.colorwinglib.Requests.GetString(request,"talentnames").getBytes("ISO-8859-1"),"utf-8")%>";}catch (ex){}
try{document.getElementById("dropNationidList").value = "<%= com.colorwinglib.Requests.GetString(request,"nationids") %>";}catch (ex){}
try{document.getElementById("dropEducationidList").value = "<%= com.colorwinglib.Requests.GetString(request,"educationids") %>";}catch (ex){}
try{document.getElementById("dropMajoridList").value = "<%= com.colorwinglib.Requests.GetString(request,"majorids") %>";}catch (ex){}
try{document.getElementById("dropPosttitleidList").value = "<%= com.colorwinglib.Requests.GetString(request,"posttitleids") %>";}catch (ex){}

</script>
</table>
<div id="divlist">
            <table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr><td style="text-align:center" width="80px">
                操作                </td>
                <td style="text-align:center" width="50px">
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=TalentID&OrderByItemDESC=${pageListOrderByItemDESCNo}">编号</a>                </td>
                <td style="text-align:center" >
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=TalentName&OrderByItemDESC=${pageListOrderByItemDESCNo}">姓名</a>                </td>
                <td style="text-align:center" width="50px">
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=Sex&OrderByItemDESC=${pageListOrderByItemDESCNo}">性别</a>                </td>
                <td style="text-align:center">
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=NationID&OrderByItemDESC=${pageListOrderByItemDESCNo}">民族</a>                </td>
                <td style="text-align:center">
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=NativePlace&OrderByItemDESC=${pageListOrderByItemDESCNo}">籍贯</a>                </td>
                <td style="text-align:center">
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=EducationID&OrderByItemDESC=${pageListOrderByItemDESCNo}">学历</a>                </td>
                <td style="text-align:center">
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=MajorID&OrderByItemDESC=${pageListOrderByItemDESCNo}">专业</a>                </td>
					<td>
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=PostTitleID&OrderByItemDESC=${pageListOrderByItemDESCNo}">职称</a>
                </td>
                <td style="text-align:center">
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=Skills&OrderByItemDESC=${pageListOrderByItemDESCNo}">专长</a>                </td>
              </tr>
            </thead>
		<s:iterator id="iteList" value="#request.TalentList">
            <tr><td>
                        <a href="${pageListUrl}&pagetype=gotoupdate&databasetalentid=${iteList.databasetalentid}">变更</a>   
						<a onclick="if (confirm('你确定删除本条信息么？')) { window.location.href='${pageListUrl}&pagetype=delete&databasetalentid=${iteList.databasetalentid}'}" href="#">删除</a>
                
				</td>
				<td>
				&nbsp;${iteList.talentid }
				</td>
                <td>
			&nbsp;${iteList.talentname}                </td>
                <td>
			&nbsp; ${iteList.sexlabel }   
			           </td>
                <td>
			&nbsp;${iteList.objNationInfoByNationid.nationname}                </td>
                <td>
			&nbsp;${iteList.nativeplace}                </td>
                <td>
			&nbsp;${iteList.objEducationInfoByEducationid.educationname}                </td>
                <td>
			&nbsp;${iteList.objMajorInfoByMajorid.majorname}                </td>
                <td>
			&nbsp;${iteList.objPostInfoByPosttitleid.titlename}
                </td>
				<td>
			&nbsp;${iteList.skills}                </td>
            </tr>
		</s:iterator>
				<tr><td colspan="10">${pageDetails}</td></tr>
            </table>

<script type="text/javascript" language="javascript" src="tableColor.js"></script>
    </div>
${pageJavaScripStar}
	</body>
</html>
