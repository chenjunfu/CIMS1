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
		<link rel="stylesheet" type="text/css" href="../css/AdminCss.css" />
		<link rel="stylesheet" type="text/css" href="../css/css.css" />
		<link rel="stylesheet" type="text/css" href="../css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="../js/colorwinglib.js"></script>
		<script type="text/javascript" src="../js/jquery.js"></script>
		<script type="text/javascript" src="../js/jquery-ui.js"></script>
	<script type="text/javascript">
		function setInsert()
		{
			$('#pagetype').val("insert");
			$("#qualitydatabaseid").val("");
			$("#txtQualityidEdit").val("");
			$("#txtQualitynameEdit").val("");
			$("#add").val("添加");
		}
	</script>
	</head>
  
<body class="bb" >

	${pageJavaScripStar}

<form action="../enterprise/EnterpristQuality.do" method="post"  >
<input type="hidden" value="<s:property value="#request.pagetype" default="insert" ></s:property>" name="pagetype" id="pagetype" />
<input type="hidden" class="toEdit" name="qualitydatabaseid" id="qualitydatabaseid" value="${Qualitydatabaseid }"/>

	<table style="width: 100%" border="0" cellpadding="0" cellspacing="0" id="tbEdit">
		<tr>
		
		<td width="33%" style="text-align: center;">企业性质编号<br><input class="toEdit" type="text" name="qualityid" id="txtQualityidEdit"  value="${Qualityid }" title="编号"/></td>
		<td width="33%" style="text-align: center;">企业性质名称<br>&nbsp;&nbsp;&nbsp;<input class="toEdit" type="text" name="qualityname" value="${Qualityname }" id="txtQualitynameEdit" title="名称"/></td>
			
		<td width="33%" style="text-align: center;">
	<s:if test="#request.pagetype=='update'">
    <input type="submit" name="btnSubmit" id="add" value="保存" onclick="return checkForm()"/>
    </s:if>
    <s:else>
    <input type="submit" name="btnSubmit" id="add" value="添加" onclick="return checkForm()"/>
    </s:else>
	<input type="button" name="btnSubmit" id="" value="取消" onclick="setInsert()"/></td>
	</tr>
	</table>
</form>
<div style="width: 100%;" id="divlist">
	 <table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr>
            	<th width="33%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=QualityID&OrderByItemDESC=${pageListOrderByItemDESCNo}">编号</a>
                </th>
                <th width="33%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=QualityName&OrderByItemDESC=${pageListOrderByItemDESCNo}">名称</a>
                </th>
                <th width="33%">
                操作
                </th>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.EnterpristQualityList">
            <tr>
            
             <td>
             <label title="qualityid" >${iteList.qualityid}</label>
              <input type="hidden" name="qualitydatabaseid" value="${iteList.qualitydatabaseid}" />
             <input type="hidden" name="qualityid" value="${iteList.qualityid}" />
                </td>
                <td>
                <label title="qualityname">${iteList.qualityname}</label>
                <input type="hidden" name="qualityname" value="${iteList.qualityname}" />
               
                </td>
                <td>
                        <input id="editBut" type="button"  onclick="ToEdit(this)" value="编辑"/>
                        <input type="button" onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&${pageListUrl}&qualitydatabaseid=${iteList.qualitydatabaseid}'}" value="删除" />
                </td>
            </tr>
		</s:iterator>
		<tr>
				<td style="text-align: center;" colspan="3"> ${pageDetails }</td>
			</tr>
            </table>
</div>
${pageJavaScripEnd}

	</body>
	
	

</html>
<script type="text/javascript" language="javascript" src="tableColor.js"></script>
<script type="text/javascript">
function checkForm()
{
    //企业性质名称
    if(document.getElementById("txtQualityidEdit") && document.getElementById("txtQualityidEdit").value == "")
    {
        alert("企业性质编号不能为空");
        document.getElementById("txtQualityidEdit").focus();
        return false;
    }
    if(document.getElementById("txtQualityidEdit") && getLength(document.getElementById("txtQualityidEdit")) > 50 )
    {
        alert("企业性质编号的长度不能为大于50");
        document.getElementById("txtQualityidEdit").focus();
        return false;
    }
     if(document.getElementById("txtQualityidEdit") && isNaN(document.getElementById("txtQualityidEdit").value) )
    {
        alert("企业性质编号必须为数字 ");
        document.getElementById("txtQualityidEdit").focus();
        return false;
    }
    if(document.getElementById("txtQualitynameEdit") && document.getElementById("txtQualitynameEdit").value == "")
    {
        alert("企业性质名称不能为空");
        document.getElementById("txtQualitynameEdit").focus();
        return false;
    }
    if(document.getElementById("txtQualitynameEdit") && getLength(document.getElementById("txtQualitynameEdit")) > 50 )
    {
        alert("企业性质名称的长度不能为大于50");
        document.getElementById("txtQualitynameEdit").focus();
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
