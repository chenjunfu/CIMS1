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

		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/public.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/css.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/AdminCss.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="<%=basePath %>js/colorwinglib.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery-ui.js"></script>
		<script type="text/javascript">
		function setInsert()
		{
			$('#pagetype').val("insert");
			$("#businessdatabaseid").val("");
			$("#txtBusinesstypeidEdit").val("");
			$("#txtBusinesstypenameEdit").val("");
			$("#add").val("添加");
		}
	</script>
	</head>

    ${pageJavaScripStar}
<body class="bb">

<form action="enterprise/Profession.do" method="post">
<input type="hidden" value="<s:property value="#request.pagetype" default="insert" ></s:property>" name="pagetype" id="pagetype" />

 <table style="width: 100%" border="0" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr>
  <td  align="left" style="text-align: center;"> 行业类别编号
  <br/>
 	 <input type="hidden" name="businessdatabaseid" id="businessdatabaseid"  value="${businessdatabaseid}" class="toEdit"/>
    <input name="businesstypeid"  class="toEdit" type="text" id="txtBusinesstypeidEdit" value="${Businesstypeid }" title="businesstypeid" size="20" maxlength="20" />
    </td>
    <td  align="left" style="text-align: center;"> 行业类别<br>
    <input name="businesstypename"  class="toEdit" type="text" id="txtBusinesstypenameEdit" value="${Businesstypename }" title="businesstypename" size="20" maxlength="20" />
    </td><td style="text-align: center;">
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
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=businesstypeid&OrderByItemDESC=${pageListOrderByItemDESCNo}">编号</a>
                </th>
                <th width="33%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=businesstypename&OrderByItemDESC=${pageListOrderByItemDESCNo}">名称</a>
                </th>
                <th width="33%">
                操作
                </th>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.ProfessionList">
            <tr>
				
				<td>
				<input  type="hidden" name="businessdatabaseid" value="${iteList.businessdatabaseid}"/>
             	<input type="hidden" name="businesstypeid" value="${iteList.businesstypeid}" />
                <label title="businesstypeid">${iteList.businesstypeid}</label>
                
                </td>
                <td>
                <label title="businesstypename">${iteList.businesstypename}</label>
                <input type="hidden" name="businesstypename" value="${iteList.businesstypename}" />
               
                </td>
                <td>
                        <input type="button"  onclick="ToEdit(this)" value="编辑"  id="editBut"/>
                        <input type="button" onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&${pageListUrl}&businessdatabaseid=${iteList.businessdatabaseid}'}" value="删除" />
                </td>
            		</tr>
		</s:iterator>

            	<tr>
				<td style="text-align: center;" colspan="3"> ${pageDetails }</td>
			</tr>
            </table>
</div>


</body>
	${pageJavaScripEnd}
</html>


<script type="text/javascript">
function checkForm()
{
 	
    //企业所属行业ID
    if(document.getElementById("txtBusinesstypeidEdit") && document.getElementById("txtBusinesstypeidEdit").value == "")
    {
        alert("行业ID不能为空");
        document.getElementById("txtBusinesstypeidEdit").focus();
        return false;
    }
    if(document.getElementById("txtBusinesstypeidEdit") && !patternInteger.test(document.getElementById("txtBusinesstypeidEdit").value))
    {
        alert("行业ID只能填写整数");
        document.getElementById("txtBusinesstypeidEdit").focus();
        return false;
    }
    //企业行业类型名称
    if(document.getElementById("txtBusinesstypenameEdit") && document.getElementById("txtBusinesstypenameEdit").value == "")
    {
        alert("行业类型名称不能为空");
        document.getElementById("txtBusinesstypenameEdit").focus();
        return false;
    }
    if(document.getElementById("txtBusinesstypenameEdit") && getLength(document.getElementById("txtBusinesstypenameEdit")) > 50 )
    {
        alert("行业类型名称的长度不能为大于50");
        document.getElementById("txtBusinesstypenameEdit").focus();
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










