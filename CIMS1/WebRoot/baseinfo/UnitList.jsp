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

		<link rel="stylesheet" type="text/css" href="css/css.css" />
		<link rel="stylesheet" type="text/css" href="css/AdminCss.css" />
		
		<script type="text/javascript" src="js/colorwinglib.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>

	</head>
	<body>

   
	${pageJavaScripNoPrives}
	<div style="text-align: center;width: 100%;height: 100%;">
    <div id="divlist" style="width: 80%; position: relative;left: 10%" >
            <table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=UnitID&OrderByItemDESC=${pageListOrderByItemDESCNo}">单位编号</a>                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=UnitName&OrderByItemDESC=${pageListOrderByItemDESCNo}">单位名称</a>                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Adress&OrderByItemDESC=${pageListOrderByItemDESCNo}">单位地址</a>                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Phone&OrderByItemDESC=${pageListOrderByItemDESCNo}">联系电话</a>                </td>
                <td>
                操作                </td>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.UnitList">
            <tr>
                <td>
			&nbsp;${iteList.unitid}                </td>
                <td>
			&nbsp;${iteList.unitname}                </td>
                <td>
			&nbsp;${iteList.adress}                </td>
                <td>
			&nbsp;${iteList.phone}                </td>
                <td>
                        <a href="?pagetype=Details&${pageListUrl}&databaseunitid=${iteList.databaseunitid}">显示详细</a>
                        <a href="?pagetype=gotoupdate&${pageListUrl}&databaseunitid=${iteList.databaseunitid}">编辑</a>
                        <a onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&${pageListUrl}&databaseunitid=${iteList.databaseunitid}'}" href="#">删除</a>                </td>
            </tr>
		</s:iterator>
		<tr><td colspan="5" style="text-align: center;"> <input type="button" name="btnGoToEdit" id="btnGoToEdit" value="" onclick="window.location.href=window.location.pathname + '?pagetype=gotoinsert&${pageListUrl}'" /></td></tr>
            </table>
${pageDetails}
<script type="text/javascript" language="javascript" src="tableColor.js"></script>
    </div>
</div>
	</body>
</html>
