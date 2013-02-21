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
		<link rel="stylesheet" type="text/css" href="/css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="/js/colorwinglib.js"></script>
		<script type="text/javascript" src="/js/jquery.js"></script>
		<script type="text/javascript" src="/js/jquery-ui.js"></script>

	</head>
	<body>
${pageJavaScripStar}
<table border="0" cellpadding="0" cellspacing="0" id="tbDetails">
  <tr>
    <td>
人才编号
    </td>
    <td>
    <label id="labTalentidDetails">${Talentid}</label>
    </td>
  </tr>
  <tr>
    <td>
姓名
    </td>
    <td>
    <label id="labTalentnameDetails">${Talentname}</label>
    </td>
  </tr>
  <tr>
    <td>
出生日期
    </td>
    <td>
    <label id="labBirthdayDetails">${Birthday}</label>
    </td>
  </tr>
  <tr>
    <td>
民族编号
    </td>
    <td>
    <label id="labNationidDetails">${Nationid}</label>
    </td>
  </tr>
  <tr>
    <td>
性别
    </td>
    <td>
    <label id="labSexDetails">${Sex}</label>
    </td>
  </tr>
  <tr>
    <td>
政治面貌
    </td>
    <td>
    <label id="labPoliticsstatusDetails">${Politicsstatus}</label>
    </td>
  </tr>
  <tr>
    <td>
毕业院校
    </td>
    <td>
    <label id="labGraduateschoolDetails">${Graduateschool}</label>
    </td>
  </tr>
  <tr>
    <td>
省份
    </td>
    <td>
    <label id="labProvinceDetails">${Province}</label>
    </td>
  </tr>
  <tr>
    <td>
城市
    </td>
    <td>
    <label id="labCityDetails">${City}</label>
    </td>
  </tr>
  <tr>
    <td>
学历编号
    </td>
    <td>
    <label id="labEducationidDetails">${Educationid}</label>
    </td>
  </tr>
  <tr>
    <td>
专业编号
    </td>
    <td>
    <label id="labMajoridDetails">${Majorid}</label>
    </td>
  </tr>
  <tr>
    <td>
专长编号
    </td>
    <td>
    <label id="labSkillidDetails">${Skillid}</label>
    </td>
  </tr>
  <tr>
    <td>
职称级别编号
    </td>
    <td>
    <label id="labPosttitleidDetails">${Posttitleid}</label>
    </td>
  </tr>
  <tr>
    <td>
职务
    </td>
    <td>
    <label id="labDutiesDetails">${Duties}</label>
    </td>
  </tr>
  <tr>
    <td>
电话
    </td>
    <td>
    <label id="labPhoneDetails">${Phone}</label>
    </td>
  </tr>
  <tr>
    <td>
手机
    </td>
    <td>
    <label id="labMovephoneDetails">${Movephone}</label>
    </td>
  </tr>
  <tr>
    <td>
邮箱
    </td>
    <td>
    <label id="labEmailDetails">${Email}</label>
    </td>
  </tr>
  <tr>
    <td>
住址
    </td>
    <td>
    <label id="labAddressDetails">${Address}</label>
    </td>
  </tr>
  <tr>
    <td>
个人学习经历
    </td>
    <td>
    <label id="labLearnexperienceDetails">${Learnexperience}</label>
    </td>
  </tr>
  <tr>
    <td>
工作单位
    </td>
    <td>
    <label id="labWorkunitDetails">${Workunit}</label>
    </td>
  </tr>
  <tr>
    <td>
主要工作经历
    </td>
    <td>
    <label id="labWorkexperienceDetails">${Workexperience}</label>
    </td>
  </tr>
  <tr>
    <td>
业绩
    </td>
    <td>
    <label id="labAcheivementDetails">${Acheivement}</label>
    </td>
  </tr>
  <tr>
    <td>
荣誉
    </td>
    <td>
    <label id="labHonorDetails">${Honor}</label>
    </td>
  </tr>
  <tr>
    <td>
人才成果编号
    </td>
    <td>
    <label id="labTalentachievementidDetails">${Talentachievementid}</label>
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
