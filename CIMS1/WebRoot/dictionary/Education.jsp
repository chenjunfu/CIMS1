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
		<script type="text/javascript">
			function setInsert()
			{
			$('#pagetype').val("insert");
			$("#educationdatabaseid").val("");
			$("#txtEducationidEdit").val("");
			$("#txtEducationnameEdit").val("");
			$("#add").val("添加");
			}
	
		</script>
	</head>

<body class="bb">
${pageJavaScripStar}
${pageJavaScripEnd}
<!---- 层5 ---->


<form action="Education.do" method="post">
<input type="hidden" value="<s:property value="#request.pagetype" default="insert" ></s:property>" name="pagetype" id="pagetype" />

  <table  style="width: 100%" border="0" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr>
  	<td align="left" style="text-align: center;"> 学历编号<br />
  	
     <input  type="hidden" class="toEdit" name="educationdatabaseid" value="${Educationdatabaseid }" id="educationdatabaseid"/> 
     <input name="educationid"  class="toEdit" type="text" id="txtEducationidEdit" value="${Educationid }" title="EducationID" size="20" maxlength="20" />
     </td>
    <td align="left" style="text-align: center;">学历名称
     <br> <input name="educationname"  class="toEdit" type="text" id="txtEducationnameEdit" value="${Educationname }" title="EducationName" size="20" maxlength="20" />
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
             <th width="33%" >
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=EducationID&OrderByItemDESC=${pageListOrderByItemDESCNo}">编号</a>
                </th>
                <th width="33%" >
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Educationname&OrderByItemDESC=${pageListOrderByItemDESCNo}">名称</a>
                </th>
                <th width="33%">
                操作
                </th>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.EducationList">
            <tr>
				
				<td width="33%">
			<input  type="hidden" name="educationdatabaseid" value="${iteList.educationdatabaseid }"/>
             <input type="hidden" name="educationid" value="${iteList.educationid}" />
                
                <label title="educationid">${iteList.educationid}</label>
                
               
                </td>
                
                <td width="33%">
                <label title="educationname">${iteList.educationname}</label>
                <input type="hidden" name="educationname" value="${iteList.educationname}" />
               
                </td>
                <td width="33%">
                        <input type="button"  id="editBut" onclick="ToEdit(this)" value="编辑"/>
                        <input type="button" onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&${pageListUrl}&educationdatabaseid=${iteList.educationdatabaseid}'}" value="删除" />
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
   
    //学历编号
    if(document.getElementById("txtEducationidEdit") && document.getElementById("txtEducationidEdit").value == "")
    {
        alert("学历编号不能为空");
        document.getElementById("txtEducationidEdit").focus();
        return false;
    }
    if(document.getElementById("txtEducationidEdit") && !patternInteger.test(document.getElementById("txtEducationidEdit").value))
    {
        alert("学历编号只能填写整数");
        document.getElementById("txtEducationidEdit").focus();
        return false;
    }
    //学历名称
    if(document.getElementById("txtEducationnameEdit") && document.getElementById("txtEducationnameEdit").value == "")
    {
        alert("学历名称不能为空");
        document.getElementById("txtEducationnameEdit").focus();
        return false;
    }
    if(document.getElementById("txtEducationnameEdit") && getLength(document.getElementById("txtEducationnameEdit")) > 50 )
    {
        alert("学历名称的长度不能为大于50");
        document.getElementById("txtEducationnameEdit").focus();
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
	
</script>




