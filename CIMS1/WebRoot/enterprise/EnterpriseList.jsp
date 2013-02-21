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
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="<%=basePath %>js/colorwinglib.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery-ui.js"></script>

<script>
$("#txtLogintimeEdit").datepicker({changeMonth: true,changeYear: true});
</script>
	</head>
	<body>
	<div >
    <table border="0" cellpadding="0" cellspacing="0" id="tbListSelect" >
    <%--<tr>
        <td colspan="9" align="center">&nbsp;</td>
      </tr>--%>
	  <tr><td colspan="12" style="font:+5; color:#black;text-align:center" height="30">文化企业信息查询</td></tr>
      <tr>
        <td> 企业名称
        
         </td>
        <td><input name="enterprisename" type="text" id="txtEnterprisenameList" value="${Enterprisename}" title="企业名称" size="20" maxlength="50" /></td>
        <td>法人 </td>
        <td><input name="legalperson" type="text" id="txtLegalpersonList" value="${Legalperson}" title="法人" size="20" maxlength="50" /></td>
        <td> 行业类型 </td>
        <td><select name="businesstypeid" id="dropBusinesstypeidList" title="行业类型" style="width:150px">
          <option value="">全部</option>
          
          
${BusinesstypeidList}

        
        </select></td>
        <td>所属区域 </td>
        <td><select name="regionid" id="dropRegionidList" title="所属区域" style="width:150px">
          <option value="">全部</option>
          
          
${RegionidList}

        
        </select></td>
        <td style="text-align: center;"><input type="button" id="btnQuery" style="background-image: url('<%=basePath %>img/xg9.jpg');" value="" onclick="search()"  /></td>
      </tr>
      
      <script type="text/javascript">
function search()
{
	var locationHref=window.location.pathname + "?state=1";
	try{locationHref += "&enterprisenames=" +  encodeURI(document.getElementById("txtEnterprisenameList").value);}catch (ex){}//企业名称
	try{locationHref += "&businesstypeids=" +  encodeURI(document.getElementById("dropBusinesstypeidList").value);}catch (ex){}//行业类型
	try{locationHref += "&legalpersons=" +  encodeURI(document.getElementById("txtLegalpersonList").value);}catch (ex){}//法人
	try{locationHref += "&regionids=" +  encodeURI(document.getElementById("dropRegionidList").value);}catch (ex){}//所属区域
	locationHref += "&s=" + new Date().getTime();
	window.location.href = locationHref;
}


try{document.getElementById("txtEnterprisenameList").value = "<%= new String(com.colorwinglib.Requests.GetString(request,"enterprisenames","").getBytes("ISO-8859-1"),"utf-8") %>";}catch (ex){}
try{document.getElementById("dropBusinesstypeidList").value = "<%= com.colorwinglib.Requests.GetString(request,"businesstypeids") %>";}catch (ex){}
try{document.getElementById("txtLegalpersonList").value = "<%= new String(com.colorwinglib.Requests.GetString(request,"legalpersons").getBytes("ISO-8859-1"),"utf-8") %>";}catch (ex){}
try{document.getElementById("dropRegionidList").value = "<%= com.colorwinglib.Requests.GetString(request,"regionids") %>";}catch (ex){}

    </script>
    </table>
    </div>
    <%--<input type="button" name="btnGoToEdit" id="btnGoToEdit" value=" " onclick="window.location.href=window.location.pathname + '?pagetype=gotoinsert&${pageListUrl}'" />--%>
    <div id="divlist" >
            <table border="0" cellpadding="0" cellspacing="0" id="tbList"  style="width:100%;">
             <thead>
            <tr>
              <td width="50px"> 操作 </td>
                <td width="80px">
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=EnterpriseID&OrderByItemDESC=${pageListOrderByItemDESCNo}">企业编号</a>
                </td>
                <td width="150px">
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=EnterpriseName&OrderByItemDESC=${pageListOrderByItemDESCNo}">企业名称</a>
                </td>
                <td width="150px">
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=BusinessTypeID&OrderByItemDESC=${pageListOrderByItemDESCNo}">行业类型</a>
                </td>
           
                <td  width="100px" >
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=RegionID&OrderByItemDESC=${pageListOrderByItemDESCNo}">所属区域</a>
                </td>
                <td  width="80px">
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=ToalInvest&OrderByItemDESC=${pageListOrderByItemDESCNo}">总投资</a>
                </td>
                <td  >
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=QualityID&OrderByItemDESC=${pageListOrderByItemDESCNo}">企业性质</a>
                </td>
                <td >
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=EmployNumber&OrderByItemDESC=${pageListOrderByItemDESCNo}">就业人数</a>
                </td >
                <td >
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=ProduceValue&OrderByItemDESC=${pageListOrderByItemDESCNo}">年产值</a>
                </td>
                <td >
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=Profit&OrderByItemDESC=${pageListOrderByItemDESCNo}">利润</a>
                </td>
                <td width="100px" >
                    &nbsp;<a href="${pageListUrlOrderBy}&OrderByItem=SocialBenefit&OrderByItemDESC=${pageListOrderByItemDESCNo}">社会效益</a>
                </td>

                <td  width="100px" >
                    &nbsp;<a href="${pageListUrlOrderBy}OrderByItem=LoginTime&OrderByItemDESC=${pageListOrderByItemDESCNo}">登录时间</a>
                </td>
              </tr>
            </thead>
		<s:iterator id="iteList" value="#request.EnterpriseList">
            <tr>
              <td><a href="${pageListUrl}&pagetype=Details&databaseenterpriseid=${iteList.databaseenterpriseid}">详情</a>
  
              </td>
                <td>
			&nbsp;${iteList.enterpriseid}
                </td>
                <td>
			&nbsp;${iteList.enterprisename}
                </td>
                <td>
			&nbsp;${iteList.objProfessionInfoByBusinesstypeid.businesstypename} 
                </td>

                <td>
			&nbsp;${iteList.objRegionsInfoByRegionid.regionname}
                </td>
                <td>
			&nbsp;${iteList.toalinvest}
                </td>
                <td>
			&nbsp;${iteList.objEnterpristQualityInfoByQualityid.qualityname}
                </td>
                <td>
			&nbsp;${iteList.employnumber}
                </td>
                <td>
			&nbsp;${iteList.producevalue}
                </td>
                <td>
			&nbsp;${iteList.profit}
                </td>
                <td>
			&nbsp;${iteList.socialbenefit}
                </td>

                <td>
			&nbsp;${iteList.logintime.shortDate}
                </td>
            </tr>
		</s:iterator>
		<tr><td colspan="12">${pageDetails}</td></tr>
            </table>

<script type="text/javascript" language="javascript" src="tableColor.js"></script>
    </div>

	</body>
</html>
<script>

$(function() { 
$(window).scroll(function() { 
var left= $(window).scrollLeft(); 
$("#ListSelect").css({ left:left + "px" }); 
}); 
}); 

</script>