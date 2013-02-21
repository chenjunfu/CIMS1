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
<link rel="stylesheet" type="text/css" href="../css/AdminCss.css" />
		<link rel="stylesheet" type="text/css" href="../css/css.css" />
		<link rel="stylesheet" type="text/css" href="../css/jquery-ui.css" />
		<script type="text/javascript" src="../js/colorwinglib.js"></script>
		<script type="text/javascript" src="../js/jquery.js"></script>
		<script type="text/javascript" src="../js/jquery-ui.js"></script>

	</head>
	<body>

    <input type="button" name="btnGoToEdit" id="btnGoToEdit" value="添加" onclick="window.location.href=window.location.pathname + '?pagetype=gotoinsert&${pageListUrl}'" />
    <div id="divlist">
            <table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=IndustryID&OrderByItemDESC=${pageListOrderByItemDESCNo}">产业编号</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=IndustryName&OrderByItemDESC=${pageListOrderByItemDESCNo}">产业名称</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=IndustryDescription&OrderByItemDESC=${pageListOrderByItemDESCNo}">描述</a>
                </td>
                <td>
                操作
                </td>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.IndustryTypeList">
            <tr>
                <td>
			&nbsp;${iteList.industryid}
                </td>
                <td>
			&nbsp;${iteList.industryname}
                </td>
                <td>
			&nbsp;${iteList.industrydescription}
                </td>
                <td>
                        <a href="?pagetype=Details&${pageListUrl}&industryid=${iteList.industryid}">显示详细</a>
                        <a href="?pagetype=gotoupdate&${pageListUrl}&industryid=${iteList.industryid}" target="_new">变更</a>
                        <a onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&${pageListUrl}&industryid=${iteList.industryid}'}" href="#">删除</a>
                </td>
            </tr>
		</s:iterator>
            </table>
${pageDetails}
<script type="text/javascript" language="javascript" src="../js/tableColor.js"></script>
    </div>

	</body>
</html>
