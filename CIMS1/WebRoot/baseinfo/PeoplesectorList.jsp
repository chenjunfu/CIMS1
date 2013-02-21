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

		<link rel="stylesheet" type="text/css" href="/css/css.css" />
		<link rel="stylesheet" type="text/css" href="/css/AdminCss.css" />
		
		<script type="text/javascript" src="/js/colorwinglib.js"></script>
		<script type="text/javascript" src="/js/jquery.js"></script>
		<script type="text/javascript" src="/js/jquery-ui.js"></script>

	</head>
	<body>

    <input type="button" name="btnGoToEdit" id="btnGoToEdit" value="" onclick="window.location.href=window.location.pathname + '?pagetype=gotoinsert&${pageListUrl}'" />
	${pageJavaScripNoPrives}
    <div id="divlist">
            <table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=PeopleSectorID&OrderByItemDESC=${pageListOrderByItemDESCNo}">部门编号</a>                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=PeopleSectorName&OrderByItemDESC=${pageListOrderByItemDESCNo}">部门名称</a>                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Adress&OrderByItemDESC=${pageListOrderByItemDESCNo}">办公住址</a>                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Phone&OrderByItemDESC=${pageListOrderByItemDESCNo}">电话</a>                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=DatabaseUnitID&OrderByItemDESC=${pageListOrderByItemDESCNo}">单位</a></td>
                <td>
                操作                </td>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.PeoplesectorList">
            <tr>
                <td>
			&nbsp;${iteList.peoplesectorid}                </td>
                <td>
			&nbsp;${iteList.peoplesectorname}                </td>
                <td>
			&nbsp;${iteList.adress}                </td>
                <td>
			&nbsp;${iteList.phone}                </td>
                <td>
			&nbsp;${iteList.objUnitInfoByDatabaseunitid.unitname}               </td>
                <td>
                        <a href="?pagetype=Details&${pageListUrl}&databasepeoplesectorid=${iteList.databasepeoplesectorid}">显示详细</a>
                        <a href="?pagetype=gotoupdate&${pageListUrl}&databasepeoplesectorid=${iteList.databasepeoplesectorid}">编辑</a>
                        <a onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&${pageListUrl}&databasepeoplesectorid=${iteList.databasepeoplesectorid}'}" href="#">删除</a>                </td>
            </tr>
		</s:iterator>
            </table>
${pageDetails}
<script type="text/javascript" language="javascript" src="tableColor.js"></script>
    </div>

	</body>
</html>
