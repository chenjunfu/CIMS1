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
			$("#pagetype").val("insert");
			$("#add").val("添加");
			$("#titledatabaseid").val("");
			$("#titleid").val("");
			$("#txtPostnameEdit").val("");
			$("#txtPostDescriptEdit").val("");
			$("#txtPostFartherEdit").val("");
			$("#txtPostDepthEdit").val("");
		}
	</script>
	</head>

<body class="bb">

${pageJavaScripStar}
${pageJavaScripEnd}
<form action="Post.do" method="post">
<input type="hidden" value="<s:property value="#request.pagetype" default="insert" ></s:property>" name="pagetype" id="pagetype" />

  <table style="width: 100%" border="0" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr>
    <td width="16%"  style="text-align: center;"> 职位编号 <br/>
    <input name="titledatabaseid"  type="hidden" class="toEdit" id="titledatabaseid" value="${Titledatabaseid }"/>
    <input name="titleid"   class="toEdit" type="text" id="titleid" value="${Titleid }" title="titlename" size="20" maxlength="20" />
    </td>
     <td width="16%"  style="text-align: center;">  职位名称
    <input name="titlename"  class="toEdit" type="text" id="txtPostnameEdit" value="${Titlename }" title="titlename" size="20" maxlength="20" />
    </td>
     <td width="16%"  style="text-align: center;">   职位描述 
    <input name="description"  class="toEdit" type="text" id="txtPostDescriptEdit" value="${ Description}" title="titlename" size="20" maxlength="20" />
    </td>
     <td width="16%"  style="text-align: center;">  职位从属
    <input name="farthertitleid"  class="toEdit" type="text" id="txtPostFartherEdit" value="${Farthertitleid }" title="titlename" size="20" maxlength="20" />
    </td>
     <td width="16%"  style="text-align: center;">    职位层级
    <input name="depth"  class="toEdit" type="text" id="txtPostDepthEdit" value="${Depth }" title="titlename" size="20" maxlength="20" />
    </td>
    <td  width="16%" style="text-align: center;">
          <s:if test="#request.pagetype=='update'">
    <input type="submit" name="btnSubmit" id="add" value="保存" onclick="return checkForm()"/>
    </s:if>
    <s:else>
    <input type="submit" name="btnSubmit" id="add" value="添加" onclick="return checkForm()"/>
    </s:else>
          <input type="button" name="btnSubmit"   value="取消" onclick="setInsert()"/></td>
    </tr>
    </table>
    </form>
	
  <div style="width: 100%;" id="divlist">
	 <table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr>
             
            	<th width="16%">
            		 &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=titleid&OrderByItemDESC=${pageListOrderByItemDESCNo}">编号</a>
            	</th>
                <th width="16%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=titlename&OrderByItemDESC=${pageListOrderByItemDESCNo}">名称</a>
                </th>
                <th width="16%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=description&OrderByItemDESC=${pageListOrderByItemDESCNo}">描述</a>
                </th>
               <th width="16%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=farthertitleid&OrderByItemDESC=${pageListOrderByItemDESCNo}">从属职位</a>
                </th>
                <th width="16%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Depth&OrderByItemDESC=${pageListOrderByItemDESCNo}">层级</a>
                </th>
               
                <th width="16%">
                操作
                </th>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.PostList">
            <tr>
				
				<td >
					<input type="hidden" name="titledatabaseid" value="${iteList.titledatabaseid }" />
					 <label title="titleid">${iteList.titleid}</label>
					 <input type="hidden" name="titleid" value="${iteList.titleid}" />
				</td>
				
                <td >
                	<label title="titlename">${iteList.titlename}</label>
                	<input type="hidden" name="titlename" value="${iteList.titlename}" />
                </td>
                 <td >
                	<label  title="description">${iteList.description}</label>
                	<input type="hidden" name="farthertitleid" value="${iteList.description}" />
                </td>
                 <td >
                	<label title="farthertitleid">${iteList.farthertitleid}</label>
                	<input type="hidden" name="farthertitleid" value="${iteList.farthertitleid}" />
                </td>
                 <td >
                	<label title="depth">${iteList.depth}</label>
                	<input type="hidden" name="depth" value="${iteList.depth}" />
                </td>
                <td>
                        <input id="editBut" type="button"  onclick="ToEdit(this)" value="编辑"/>
                        <input id="editBut" type="button" onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&${pageListUrl}&titledatabaseid=${iteList.titledatabaseid}'}" value="删除" />
                </td>
            </tr>
		</s:iterator>
			<tr>
				<td style="text-align: center;" colspan="6"> ${pageDetails }</td>
			</tr>
            </table>
           


</div>

	</body>

	
</html>


<script type="text/javascript">
function checkForm()
{
     if(document.getElementById("titleid") && document.getElementById("titleid").value == "")
    {
        alert("职称编号不能为空");
        document.getElementById("titleid").focus();
        return false;
    }
    if(document.getElementById("titleid") && getLength(document.getElementById("titleid")) > 50 )
    {
        alert("职称编号的长度不能为大于50");
        document.getElementById("titleid").focus();
        return false;
    }
   
    if(document.getElementById("txtPostnameEdit") && document.getElementById("txtPostnameEdit").value == "")
    {
        alert("职称名称不能为空");
        document.getElementById("txtPostnameEdit").focus();
        return false;
    }
    if(document.getElementById("txtPostnameEdit") && getLength(document.getElementById("txtPostnameEdit")) > 50 )
    {
        alert("职称名称的长度不能为大于50");
        document.getElementById("txtPostnameEdit").focus();
        return false;
    }
    
    if(document.getElementById("txtPostDescriptEdit") && document.getElementById("txtPostDescriptEdit").value == "")
    {
        alert("职称描述不能为空");
        document.getElementById("txtPostDescriptEdit").focus();
        return false;
    }
    if(document.getElementById("txtPostDescriptEdit") && getLength(document.getElementById("txtPostDescriptEdit")) > 50 )
    {
        alert("职称描述的长度不能为大于50");
        document.getElementById("txtPostDescriptEdit").focus();
        return false;
    }

    if(document.getElementById("txtPostFartherEdit") && getLength(document.getElementById("txtPostFartherEdit")) > 50 )
    {
        alert("上级职称的长度不能为大于50");
        document.getElementById("txtPostFartherEdit").focus();
        return false;
    }
    if(document.getElementById("txtPostFartherEdit") && isNaN(document.getElementById("txtPostFartherEdit").value) )
    {
        alert("上级职称必须为数字 ");
        document.getElementById("txtPostFartherEdit").focus();
        return false;
    }
    
    if(document.getElementById("txtPostDepthEdit") && getLength(document.getElementById("txtPostDepthEdit")) > 50 )
    {
        alert("职称深度的长度不能为大于50");
        document.getElementById("txtPostDepthEdit").focus();
        return false;
    }
     if(document.getElementById("txtPostFartherEdit") && isNaN(document.getElementById("txtPostFartherEdit").value) )
    {
        alert("职称深度必须为数字 ");
        document.getElementById("txtPostFartherEdit").focus();
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




