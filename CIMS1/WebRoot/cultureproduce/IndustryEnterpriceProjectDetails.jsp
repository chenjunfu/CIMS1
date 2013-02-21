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
${pageJavaScripStar}
<table border="0" cellpadding="0" cellspacing="0" id="tbDetails">
  <tr>
    <td>
企业项目编号
    </td>
    <td>
    <label id="labEnterpriseProjectidDetails">${EnterpriseProjectid}</label>
    </td>
  </tr>
  <tr>
    <td>
项目编号
    </td>
    <td>
    <label id="labProjectidDetails">${Projectid}</label>
    </td>
  </tr>
  <tr>
    <td>
企业编号
    </td>
    <td>
    <label id="labEnterpriseidDetails">${Enterpriseid}</label>
    </td>
  </tr>
  <tr>
    <td>
所在地址
    </td>
    <td>
    <label id="labAddressDetails">${Address}</label>
    </td>
  </tr>
  <tr>
    <td>
项目资金
    </td>
    <td>
    <label id="labFundsDetails">${Funds}</label>
    </td>
  </tr>
  <tr>
    <td>
计划投资
    </td>
    <td>
    <label id="labPlaninvestDetails">${Planinvest}</label>
    </td>
  </tr>
  <tr>
    <td>
投入资金
    </td>
    <td>
    <label id="labInvestfundsDetails">${Investfunds}</label>
    </td>
  </tr>
  <tr>
    <td>
投资方式编号
    </td>
    <td>
    <label id="labInveststyleidDetails">${Investstyleid}</label>
    </td>
  </tr>
  <tr>
    <td>
资金类别编号
    </td>
    <td>
    <label id="labFundtypeidDetails">${Fundtypeid}</label>
    </td>
  </tr>
  <tr>
    <td>
资金来源编号
    </td>
    <td>
    <label id="labFoundsourceidDetails">${Foundsourceid}</label>
    </td>
  </tr>
  <tr>
    <td>
完成时间
    </td>
    <td>
    <label id="labCompletetimeDetails">${Completetime}</label>
    </td>
  </tr>
  <tr>
    <td>
经营状况
    </td>
    <td>
    <label id="labStateDetails">${State}</label>
    </td>
  </tr>
  <tr>
    <td>
计划进度
    </td>
    <td>
    <label id="labPlanstateDetails">${Planstate}</label>
    </td>
  </tr>
  <tr>
    <td>
项目进度编号
    </td>
    <td>
    <label id="labProjectscheduleidDetails">${Projectscheduleid}</label>
    </td>
  </tr>
  <tr>
    <td>
当前存在问题
    </td>
    <td>
    <label id="labProblemDetails">${Problem}</label>
    </td>
  </tr>
  <tr>
    <td>
项目简介
    </td>
    <td>
    <label id="labBriefintroduceDetails">${Briefintroduce}</label>
    </td>
  </tr>
  <tr>
    <td>
项目图片
    </td>
    <td>
    <label id="labPicDetails">${Pic}</label>
    </td>
  </tr>
  <tr>
    <td>
是否是续建
    </td>
    <td>
    <label id="labIsStillDetails">${IsStill}</label>
    </td>
  </tr>
  <tr>
    <td>
是否完成
    </td>
    <td>
    <label id="labIsCompleteDetails">${IsComplete}</label>
    </td>
  </tr>
  <tr>
    <td colspan="2" align="center">
    <input type="button" name="button" id="button2" value="返回" onclick="window.location.href=window.location.pathname + '?${pageListUrl}'" />
    </td>
  </tr>
</table>

${pageJavaScripEnd}
	</body>
</html>
