<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
			$("#regiondatabaseid").val("");
			$("#regionid").val("");
			$("#txtRegionnameEdit").val("");
			$("#dropPartherregionsidEdit").val("");
			$("#txtDepthEdit").val("");
		}
	</script>
	</head>
    ${pageJavaScripStar}
    ${pageJavaScripEnd}
<body class="bb">

<form action="Regions.do" method="post">
<input type="hidden" value="<s:property value="#request.pagetype" default="insert" ></s:property>" name="pagetype" id="pagetype" />

  <table style="width: 100%" border="0" cellpadding="0" cellspacing="0" id="tbEdit" >
  <tr>
    <td width="20%" style="text-align: center;"> 区域编号&nbsp;&nbsp;
    <br />
    <input name="regiondatabaseid" id="regiondatabaseid" value="${ Regiondatabaseid}" class="toEdit" type="hidden"/>
    <input name="regionid"   class="toEdit" type="text" id="regionid" value="${Regionid }" title="titlename" size="20" maxlength="20" />
    </td>
     <td width="20%" style="text-align: center;">  区域名称
    <input name="regionname"  class="toEdit" type="text" id="txtRegionnameEdit" value="${Regionname }" title="regionname" size="20" maxlength="20" />
    </td>
     <td width="20%" style="text-align: center;">  区域从属
    <input name="partherregionsid"  class="toEdit" type="text" id="dropPartherregionsidEdit" value="${Partherregionsid }" title="partherregionsid" size="20" maxlength="20" />
    </td>
     <td width="20%" style="text-align: center;">  区域层级
    <input name="depth"  class="toEdit" type="text" id="txtDepthEdit" value="${Depth }" title="depth" size="20" maxlength="20" />
    </td>
    <td width="20%" style="text-align: center;">
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
             
            	<th width="20%">
            		 &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=regionid&OrderByItemDESC=${pageListOrderByItemDESCNo}">编号</a>
            	</th>
                <th width="20%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=regionname&OrderByItemDESC=${pageListOrderByItemDESCNo}">名称</a>
                </th>
               <th width="20%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=partherregionsid&OrderByItemDESC=${pageListOrderByItemDESCNo}">从属区域</a>
                </th>
                <th width="20%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Depth&OrderByItemDESC=${pageListOrderByItemDESCNo}">层级</a>
                </th>
               
                <th width="20%"  >
                操作
                </th>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.RegionsList">
            <tr>
				
				<td >
					<input type="hidden" name="regiondatabaseid" value="${iteList.regiondatabaseid }"/>
					 <label title="regionid">${iteList.regionid}</label>
					 <input type="hidden" name="regionid" value="${iteList.regionid}" />
				</td>
				
                <td >
                	<label title="regionname">${iteList.regionname}</label>
                	<input type="hidden" name="regionname" value="${iteList.regionname}" />
                </td>
                 <td >
                	<label title="partherregionsid">${iteList.partherregionsid}</label>
                	<input type="hidden" name="partherregionsid" value="${iteList.partherregionsid}" />
                </td>
                 <td >
                	<label title="depth">${iteList.depth}</label>
                	<input type="hidden" name="depth" value="${iteList.depth}" />
                </td>
                <td>
                        <input id="editBut" type="button"  onclick="ToEdit(this)" value="编辑"/>
                        <input id="editBut" type="button" onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&${pageListUrl}&regiondatabaseid=${iteList.regiondatabaseid}'}" value="删除" />
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
		$("#showid").text($("#regionid").val());
		
	}
	
</script>
	
	
<script type="text/javascript">
function checkForm()
{
    //ReginID
    if(document.getElementById("regionid") && document.getElementById("regionid").value == "")
    {
        alert("区域编号不能为空");
        document.getElementById("regionid").focus();
        return false;
    }
    if(document.getElementById("regionid") && getLength(document.getElementById("regionid")) > 50 )
    {
        alert("区域编号的长度不能为大于50");
        document.getElementById("regionid").focus();
        return false;
    }
    //RegionName
    if(document.getElementById("txtRegionnameEdit") && document.getElementById("txtRegionnameEdit").value == "")
    {
        alert("区域名称不能为空");
        document.getElementById("txtRegionnameEdit").focus();
        return false;
    }
    if(document.getElementById("txtRegionnameEdit") && getLength(document.getElementById("txtRegionnameEdit")) > 50 )
    {
        alert("区域名称的长度不能为大于50");
        document.getElementById("txtRegionnameEdit").focus();
        return false;
    }
    
    //Depth
    if(document.getElementById("txtDepthEdit") && document.getElementById("txtDepthEdit").value == "")
    {
        alert("层级不能为空");
        document.getElementById("txtDepthEdit").focus();
        return false;
    }
    if(document.getElementById("txtDepthEdit") && !patternInteger.test(document.getElementById("txtDepthEdit").value))
    {
        alert("层级只能填写整数");
        document.getElementById("txtDepthEdit").focus();
        return false;
    }
	  return true;
}
</script>

 