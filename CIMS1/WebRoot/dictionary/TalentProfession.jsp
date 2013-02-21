<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title><%=com.yun.configuration.WebConfig.WEB_TITLE %></title>

		<link rel="stylesheet" type="text/css" href="../css/public.css" />
		<link rel="stylesheet" type="text/css" href="../css/css.css" />
		<link rel="stylesheet" type="text/css" href="../css/AdminCss.css" />
		<link rel="stylesheet" type="text/css" href="../css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="../js/colorwinglib.js"></script>
		<script type="text/javascript" src="../js/jquery.js"></script>
		<script type="text/javascript" src="../js/jquery-ui.js"></script>
	
	</head>

<body class="bb">


${pageJavaScripStar}
${pageJavaScripEnd}
<form action="TalentProfession.do" method="post"> 
<input type="hidden" value="insert" name="pagetype" id="pagetype" />


<table style="width: 100%" border="0" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr>
  <td align="left" style="text-align: center;"> 行业ID<br/>
  
  	<input name="talentprofessiondatabaseid" type="hidden" class="toEdit"/>
    <input name="talentprofessionname"  class="toEdit" type="hidden" id="txtTalentprofessionidEdit" value="" title="talentprofessionname" size="20" maxlength="20" />
    </td>
    <td align="left" style="text-align: center;"> 行业名称<br>
    <input name="talentprofessionname"  class="toEdit" type="text" id="txtTalentprofessionnameEdit" value="" title="talentprofessionname" size="20" maxlength="20" />
    </td>
    <td style="text-align: center;">
          <input type="submit" name="btnSubmit" id="add" value="添加" onclick="return checkForm()"/>
          <input type="reset" name="btnSubmit" id="" value="取消" onclick="$(':submit').val('添加')"/></td>
    </tr>
    </table>
    </form>
	
  <div style="width: 100%;" id="divlist">
	 <table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr>
            	 <th width="33%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=talentprofessionname&OrderByItemDESC=${pageListOrderByItemDESCNo}">名称</a>
                </th>
                <th width="33%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=talentprofessionname&OrderByItemDESC=${pageListOrderByItemDESCNo}">名称</a>
                </th>
                <th width="33%">
                操作
                </th>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.TalentProfessionList">
            <tr>
				<td>
				<input type="hidden"   name="talentprofessiondatabaseid" value="${iteList.talentprofessiondatabaseid }"/>
             	<input type="hidden" name="talentprofessionid" value="${iteList.talentprofessionid}" />
                
                <label title="talentprofessionid">${iteList.talentprofessionid}</label>
                
                </td>
                <td>

             	
                <label title="talentprofessionname">${iteList.talentprofessionname}</label>
                <input type="hidden" name="talentprofessionname" value="${iteList.talentprofessionname}" />
               
                </td>
                <td>
                        <input type="button"  onclick="ToEdit(this)" value="编辑"/>
                        <input type="button" onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&${pageListUrl}&talentprofessiondatabaseid=${iteList.talentprofessiondatabaseid}'}" value="删除" />
                </td>
            </tr>
            
		</s:iterator>
		<tr>
				<td style="text-align: center;" colspan="3"> ${pageDetails }</td>
			</tr>
            </table>
</div>



	</body>
	
</html>


<script type="text/javascript">
function checkForm()
{
   
    //人才所属行业
    if(document.getElementById("txtTalentprofessionidEdit") && document.getElementById("txtTalentprofessionidEdit").value == "")
    {
        alert("人才所属行业不能为空");
        document.getElementById("txtTalentprofessionidEdit").focus();
        return false;
    }
    if(document.getElementById("txtTalentprofessionidEdit") && !patternInteger.test(document.getElementById("txtTalentprofessionidEdit").value))
    {
        alert("人才所属行业只能填写整数");
        document.getElementById("txtTalentprofessionidEdit").focus();
        return false;
    }
    //行业类型名称
    if(document.getElementById("txtTalentprofessionnameEdit") && document.getElementById("txtTalentprofessionnameEdit").value == "")
    {
        alert("行业类型名称不能为空");
        document.getElementById("txtTalentprofessionnameEdit").focus();
        return false;
    }
    if(document.getElementById("txtTalentprofessionnameEdit") && getLength(document.getElementById("txtTalentprofessionnameEdit")) > 50 )
    {
        alert("行业类型名称的长度不能为大于50");
        document.getElementById("txtTalentprofessionnameEdit").focus();
        return false;
    }
	  return true;
}
</script>

<script type="text/javascript">
	function ToEdit(Obj)
	{	
		
		var count=0;
		var toEdits=$(".toEdit");
		$(Obj).parent().parent().find(":hidden").each(function()
			{	
				
				$(toEdits[count++]).val($(this).val());
			}
		)
		$("#pagetype").val("update");
		$("#add").val("保存")
		
	}
	
</script>




