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
${pageJavaScripStar}<form name="produceForm" id="frmEdit" method="post"  action="${btnEditCommandArgument}" >

<table border="0" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr>
    <td>
企业项目编号
    </td>
    <td>
<input name="enterpriseProjectid" type="text" id="txtEnterpriseProjectidEdit" value="${EnterpriseProjectid}" title="企业项目编号" size="8" maxlength="8" />
    </td>
  </tr>
  <tr>
    <td>
项目编号
    </td>
    <td>
<input name="projectid" type="text" id="txtProjectidEdit" value="${Projectid}" title="项目编号" size="50" maxlength="50" />
    </td>
  </tr>
  <tr>
    <td>
企业编号
    </td>
    <td>
<input name="enterpriseid" type="text" id="txtEnterpriseidEdit" value="${Enterpriseid}" title="企业编号" size="50" maxlength="50" />
    </td>
  </tr>
  <tr>
    <td>
所在地址
    </td>
    <td>
<input name="address" type="text" id="txtAddressEdit" value="${Address}" title="所在地址" size="60" maxlength="100" />
    </td>
  </tr>
  <tr>
    <td>
项目资金
    </td>
    <td>
<input name="funds" type="text" id="txtFundsEdit" value="${Funds}" title="项目资金" size="20" maxlength="20" />
    </td>
  </tr>
  <tr>
    <td>
计划投资
    </td>
    <td>
<input name="planinvest" type="text" id="txtPlaninvestEdit" value="${Planinvest}" title="计划投资" size="20" maxlength="20" />
    </td>
  </tr>
  <tr>
    <td>
投入资金
    </td>
    <td>
<input name="investfunds" type="text" id="txtInvestfundsEdit" value="${Investfunds}" title="投入资金" size="20" maxlength="20" />
    </td>
  </tr>
  <tr>
    <td>
投资方式编号
    </td>
    <td>
<input name="investstyleid" type="text" id="txtInveststyleidEdit" value="${Investstyleid}" title="投资方式编号" size="8" maxlength="8" />
    </td>
  </tr>
  <tr>
    <td>
资金类别编号
    </td>
    <td>
<input name="fundtypeid" type="text" id="txtFundtypeidEdit" value="${Fundtypeid}" title="资金类别编号" size="8" maxlength="8" />
    </td>
  </tr>
  <tr>
    <td>
资金来源编号
    </td>
    <td>
<input name="foundsourceid" type="text" id="txtFoundsourceidEdit" value="${Foundsourceid}" title="资金来源编号" size="8" maxlength="8" />
    </td>
  </tr>
  <tr>
    <td>
完成时间
    </td>
    <td>
<input name="completetime" type="text" id="txtCompletetimeEdit" value="${Completetime}" title="完成时间" size="10" maxlength="20" />
    </td>
  </tr>
  <tr>
    <td>
经营状况
    </td>
    <td>
<input name="state" type="text" id="txtStateEdit" value="${State}" title="经营状况" size="50" maxlength="50" />
    </td>
  </tr>
  <tr>
    <td>
计划进度
    </td>
    <td>
<input name="planstate" type="text" id="txtPlanstateEdit" value="${Planstate}" title="计划进度" size="60" maxlength="500" />
    </td>
  </tr>
  <tr>
    <td>
项目进度编号
    </td>
    <td>
<input name="projectscheduleid" type="text" id="txtProjectscheduleidEdit" value="${Projectscheduleid}" title="项目进度编号" size="8" maxlength="8" />
    </td>
  </tr>
  <tr>
    <td>
当前存在问题
    </td>
    <td>
<input name="problem" type="text" id="txtProblemEdit" value="${Problem}" title="当前存在问题" size="60" maxlength="500" />
    </td>
  </tr>
  <tr>
    <td>
项目简介
    </td>
    <td>
<input name="briefintroduce" type="text" id="txtBriefintroduceEdit" value="${Briefintroduce}" title="项目简介" size="60" maxlength="500" />
    </td>
  </tr>
  <tr>
    <td>
项目图片
    </td>
    <td>
<input name="pic" type="text" id="txtPicEdit" value="${Pic}" title="项目图片" size="60" maxlength="100" />
    </td>
  </tr>
  <tr>
    <td>
是否是续建
    </td>
    <td>
<input name="isStill" type="text" id="txtIsStillEdit" value="${IsStill}" title="是否是续建" size="8" maxlength="8" />
    </td>
  </tr>
  <tr>
    <td>
是否完成
    </td>
    <td>
<input name="isComplete" type="text" id="txtIsCompleteEdit" value="${IsComplete}" title="是否完成" size="8" maxlength="8" />
    </td>
  </tr>
  <tr>
    <td colspan="2" align="center">
    <input type="submit" name="btnSubmit" id="btnSubmit" value="${btnEditText}" onclick="if (checkForm()) {return true;} return false;"/>
    <input type="button" name="btnReturn" id="btnReturn" value="返回" onclick="window.location.href=window.location.pathname + '?${pageListUrl}'" />
    </td>
  </tr>
</table>

</form>
${pageJavaScripEnd}
	</body>
</html>
