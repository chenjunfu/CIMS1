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
		<link rel="stylesheet" type="text/css" href="../css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="../js/colorwinglib.js"></script>
		<script type="text/javascript" src="../js/jquery.js"></script>
		<script type="text/javascript" src="../js/jquery-ui.js"></script>
	
	</head>

<body class="bb">
<!---- 层5 ---->
<div id="dialogEducationOpen">
<form action="Major.do" method="post">
<input type="hidden" value="insert" name="pagetype" id="pagetype" />
<input type="hidden" class="toEdit" name="majorid"/>
  <h3 align="center">年龄段</h3><table width="200" border="0" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr>
    <td width="120"> 范围</td>
    <td><input name="majorname"  class="toEdit" type="text" id="txtEducationnameEdit" value="" title="MajorName" size="20" maxlength="20" />
          <input type="submit" name="btnSubmit" id="btnReturn" value="添加" onclick=""/>
          <input type="reset" name="btnSubmit" id="btnReturn" value="取消" onclick="$(':submit').val('添加')"/></td>
    </tr>
    </table>
    </form>
	
  <div style="width: 95%;border: solid 1px;" id="divlist">
	 <table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr>
                <td width="33%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=MajorName&OrderByItemDESC=${pageListOrderByItemDESCNo}">名称</a>
                </td>
                <td width="33%">
                操作
                </td>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.MajorList">
            <tr>

                <td>

             <input type="hidden" name="Majorid" value="${iteList.majorid}" />
                
                <label title="marjorname">${iteList.majorname}</label>
                <input type="hidden" name="majorname" value="${iteList.majorname}" />
               
                </td>
                <td>
                        <input type="button"  onclick="ToEdit(this)" value="编辑"/>
                        <input type="button" onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&${pageListUrl}&majorid=${iteList.majorid}'}" value="删除" />
                </td>
            </tr>
		</s:iterator>
            </table>
</div>

</div>

	</body>
	${pageJavaScripEnd}
	
</html>


<script type="text/javascript">
function checkForm()
{
    //EducationName
    if(document.getElementById("txtEducationnameEdit") && document.getElementById("txtEducationnameEdit").value == "")
    {
        alert("EducationName不能为空");
        document.getElementById("txtEducationnameEdit").focus();
        return false;
    }
    if(document.getElementById("txtEducationnameEdit") && getLength(document.getElementById("txtEducationnameEdit")) > 50 )
    {
        alert("EducationName的长度不能为大于50");
        document.getElementById("txtEducationnameEdit").focus();
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
		$("#btnReturn").val("保存")
	}
	
</script>




