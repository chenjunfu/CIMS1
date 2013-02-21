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
	
	</head>

<body class="bb" >
<!---- 层5 ---->
${pageJavaScripStar}
${pageJavaScripEnd}

<form action="Degree.do" method="post">

<input type="hidden" value="<s:property value="#request.pagetype" default="insert" ></s:property>" name="pagetype" id="pagetype" />
  <table style="width: 100%" width="100%" border="0" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr>
  	 <td align="left" style="text-align: center;"> 学位编号<br/>
  	<input name="degreedatabaseid" type="hidden"  class="toEdit" value="${Degreedatabaseid }" id="databsedegreeid" />	 
   	<input name="degreeid"  class="toEdit" type="text" id="txtDegreeidEdit" value="${Degreeid }" title="Educationid" size="20" maxlength="20" />
    </td>
   	 <td align="left" style="text-align: center;"> 学位名称
   	 <br><input name="degreename"  class="toEdit" type="text" id="txtDegreenameEdit" value="${Degreename }" title="EducationName" size="20" maxlength="20" />
    </td>
    <td style="text-align: center;">
    <s:if test="#request.pagetype=='update'">
    <input type="submit" name="btnSubmit" id="add" value="保存" onclick="return checkForm()"/>
    </s:if>
    <s:else>
    <input type="submit" name="btnSubmit" id="add" value="添加" onclick="return checkForm()"/>
    </s:else>
          <input type="button" name="btnSubmit" id="" value="取消" onclick="setInsert()"/>
    </td>
    </tr>
    </table>
    </form>
	
  <div style="width: 100%;" id="divlist" >
	 <table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr>
           		<th width="33%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=DegreeID&OrderByItemDESC=${pageListOrderByItemDESCNo}">编号</a>
                </th>
                <th width="33%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=DegreeName&OrderByItemDESC=${pageListOrderByItemDESCNo}">名称</a>
                </th>
                <th width="33%">
                操作
                </th>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.DegreeList">
            <tr>
				<td width="33%" >
				<input type="hidden" name="degreedatabaseid" value="${iteList.degreedatabaseid }"/>
           		<input type="hidden" name="degreeid" value="${iteList.degreeid}" />
                <label title="degreeid">${iteList.degreeid}</label>

                </td>
                <td width="33%">
                <label title="degreename">${iteList.degreename}</label>
                <input type="hidden" name="degreeyname" value="${iteList.degreename}" />
                </td>
                <td width="33%">
                        <input type="button"  onclick="ToEdit(this)" value="编辑" id="editBut"/>
                        <input type="button" onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&${pageListUrl}&degreedatabaseid=${iteList.degreedatabaseid}'}" value="删除" />
                </td>
            
		</s:iterator>
		</tr>
            	<tr>
				<td style="text-align: center;" colspan="3"> ${pageDetails }</td>
			</tr>
            </table>
</div>
<script type="text/javascript">
function checkForm()
{
   
    //DegreeID
    if(document.getElementById("txtDegreeidEdit") && document.getElementById("txtDegreeidEdit").value == "")
    {
        alert("学位编号不能为空");
        document.getElementById("txtDegreeidEdit").focus();
        return false;
    }
    if(document.getElementById("txtDegreeidEdit") && !patternInteger.test(document.getElementById("txtDegreeidEdit").value))
    {
        alert("学位编号只能填写整数");
        document.getElementById("txtDegreeidEdit").focus();
        return false;
    }
    //DegreeName
    if(document.getElementById("txtDegreenameEdit") && document.getElementById("txtDegreenameEdit").value == "")
    {
        alert("学位名称不能为空");
        document.getElementById("txtDegreenameEdit").focus();
        return false;
    }
    if(document.getElementById("txtDegreenameEdit") && getLength(document.getElementById("txtDegreenameEdit")) > 50 )
    {
        alert("学位名称的长度不能为大于50");
        document.getElementById("txtDegreenameEdit").focus();
        return false;
    }
	  return true;
}
</script>



	</body>
	
	
</html>
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
		$("#add").val("保存");
	}
	function setInsert()
	{	
		$("#pagetype").val("insert")
		$("#add").val("添加");
		$("#databsedegreeid").val("");
		$("#txtDegreeidEdit").val("");
		$("#txtDegreenameEdit").val("");
		
	}
</script>




