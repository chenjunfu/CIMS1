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

		<link rel="stylesheet" type="text/css" href="../css/css.css" />
        <link rel="stylesheet" type="text/css" href="../css/AdminCss.css" />
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
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Enterprise_ProjectID&OrderByItemDESC=${pageListOrderByItemDESCNo}">企业项目编号</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=ProjectID&OrderByItemDESC=${pageListOrderByItemDESCNo}">项目编号</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=EnterpriseID&OrderByItemDESC=${pageListOrderByItemDESCNo}">企业编号</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Address&OrderByItemDESC=${pageListOrderByItemDESCNo}">所在地址</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Funds&OrderByItemDESC=${pageListOrderByItemDESCNo}">项目资金</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Planinvest&OrderByItemDESC=${pageListOrderByItemDESCNo}">计划投资</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=InvestFunds&OrderByItemDESC=${pageListOrderByItemDESCNo}">投入资金</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=InvestStyleID&OrderByItemDESC=${pageListOrderByItemDESCNo}">投资方式编号</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=FundTypeID&OrderByItemDESC=${pageListOrderByItemDESCNo}">资金类别编号</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=FoundSourceID&OrderByItemDESC=${pageListOrderByItemDESCNo}">资金来源编号</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=CompleteTime&OrderByItemDESC=${pageListOrderByItemDESCNo}">完成时间</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=State&OrderByItemDESC=${pageListOrderByItemDESCNo}">经营状况</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=PlanState&OrderByItemDESC=${pageListOrderByItemDESCNo}">计划进度</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=ProjectScheduleID&OrderByItemDESC=${pageListOrderByItemDESCNo}">项目进度编号</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Problem&OrderByItemDESC=${pageListOrderByItemDESCNo}">当前存在问题</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=BriefIntroduce&OrderByItemDESC=${pageListOrderByItemDESCNo}">项目简介</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Pic&OrderByItemDESC=${pageListOrderByItemDESCNo}">项目图片</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Is_Still&OrderByItemDESC=${pageListOrderByItemDESCNo}">是否是续建</a>
                </td>
                <td>
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Is_Complete&OrderByItemDESC=${pageListOrderByItemDESCNo}">是否完成</a>
                </td>
                <td>
                操作
                </td>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.IndustryEnterpriceProjectList">
            <tr>
                <td>
			&nbsp;${iteList.enterpriseProjectid}
                </td>
                <td>
			&nbsp;${iteList.projectid}
                </td>
                <td>
			&nbsp;${iteList.enterpriseid}
                </td>
                <td>
			&nbsp;${iteList.address}
                </td>
                <td>
			&nbsp;${iteList.funds}
                </td>
                <td>
			&nbsp;${iteList.planinvest}
                </td>
                <td>
			&nbsp;${iteList.investfunds}
                </td>
                <td>
			&nbsp;${iteList.investstyleid}
                </td>
                <td>
			&nbsp;${iteList.fundtypeid}
                </td>
                <td>
			&nbsp;${iteList.foundsourceid}
                </td>
                <td>
			&nbsp;${iteList.completetime.shortDate}
                </td>
                <td>
			&nbsp;${iteList.state}
                </td>
                <td>
			&nbsp;${iteList.planstate}
                </td>
                <td>
			&nbsp;${iteList.projectscheduleid}
                </td>
                <td>
			&nbsp;${iteList.problem}
                </td>
                <td>
			&nbsp;${iteList.briefintroduce}
                </td>
                <td>
			&nbsp;${iteList.pic}
                </td>
                <td>
			&nbsp;${iteList.isStill}
                </td>
                <td>
			&nbsp;${iteList.isComplete}
                </td>
                <td>
                        <a href="?pagetype=Details&${pageListUrl}&enterpriseProjectid=${iteList.enterpriseProjectid}">显示详细</a>
                        <a href="?pagetype=gotoupdate&${pageListUrl}&enterpriseProjectid=${iteList.enterpriseProjectid}" target="_new">变更</a>
                        <a onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&${pageListUrl}&enterpriseProjectid=${iteList.enterpriseProjectid}'}" href="#">删除</a>
                </td>
            </tr>
		</s:iterator>
            </table>
${pageDetails}
<script type="text/javascript" language="javascript" src="../js/tableColor.js"></script>
    </div>

	</body>
</html>
