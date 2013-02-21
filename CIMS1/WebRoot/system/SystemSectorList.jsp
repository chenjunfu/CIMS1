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
		<link rel="stylesheet" type="text/css" href=css/AdminCss.css" />
		
		<script type="text/javascript" src="js/colorwinglib.js" ></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>

	</head>
	<body>
	
	${pageJavaScripNoPrives}
	<div id="divlist">
            <table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr>
			<td style="text-align:center">
                操作                </td>
                <td style="text-align:center">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=SectorName&OrderByItemDESC=${pageListOrderByItemDESCNo}">部门名称</a>                </td>
                <td style="text-align:center">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Is_Use&OrderByItemDESC=${pageListOrderByItemDESCNo}">启用标志</a>                </td>
                <td style="text-align:center">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Is_Del&OrderByItemDESC=${pageListOrderByItemDESCNo}">是否删除</a>                </td>
                
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.SystemSectorList">
            <tr>
			 <td>
                        <a href="?pagetype=Details&${pageListUrl}&sectorid=${iteList.sectorid}">查看详细</a></td>
                <td>
			&nbsp;${iteList.sectorname}                </td>
                <td>
			&nbsp;${iteList.isUselabel}                </td>
                <td>
			&nbsp;${iteList.isDellabel}                </td>
               
            </tr>
		</s:iterator>
            </table>
${pageDetails}
<script type="text/javascript" language="javascript" src="tableColor.js"></script>
    </div>

	</body>
</html>
