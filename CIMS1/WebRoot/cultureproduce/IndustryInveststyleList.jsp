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
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=InvestStyleID&OrderByItemDESC=${pageListOrderByItemDESCNo}">投资方式编号</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=InvestStyleName&OrderByItemDESC=${pageListOrderByItemDESCNo}">投资方式名</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=InvestStyleDescription&OrderByItemDESC=${pageListOrderByItemDESCNo}">描述</a>
                </td>
                <td>
                操作
                </td>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.IndustryInveststyleList">
            <tr>
                <td>
			&nbsp;${iteList.investstyleid}
                </td>
                <td>
			&nbsp;${iteList.investstylename}
                </td>
                <td>
			&nbsp;${iteList.investstyledescription}
                </td>
                <td>
                        <a href="?pagetype=Details&${pageListUrl}&investstyleid=${iteList.investstyleid}">显示详细</a>
                        <a href="?pagetype=gotoupdate&${pageListUrl}&investstyleid=${iteList.investstyleid}" target="_blank">变更</a>
                        <a onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&${pageListUrl}&investstyleid=${iteList.investstyleid}'}" href="#">删除</a>
                </td>
            </tr>
		</s:iterator>
            </table>
${pageDetails}
<script type="text/javascript" language="javascript" src="../js/tableColor.js"></script>
    </div>

	</body>
</html>
