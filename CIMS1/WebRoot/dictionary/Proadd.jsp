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
			$("#pagetype").val("insert");
			$("#add").val("添加");
			$("#proadddatabaseid").val("");
			$("#txtproaddidEdit").val("");
			$("#txtproaddnameEdit").val("");
		}
	</script>
	</head>

<body class="bb">
<!---- 层5 ---->

${pageJavaScripStar}
${pageJavaScripEnd}
<form action="Proadd.do" method="post">
<input type="hidden" value="<s:property value="#request.pagetype" default="insert" ></s:property>" name="pagetype" id="pagetype" />
 <table style="width: 100%" border="0" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr>
    <td  align="left" style="text-align: center;">规划选址编号<br/>
    <input name="proadddatabaseid" class="toEdit" type="hidden"  id="proadddatabaseid"  value="${Proadddatabaseid }"/>
    	<input type="text" class="toEdit" name="proaddid" id="txtproaddidEdit" value="${ Proaddid}"/>
    </td>
    <td  align="left" style="text-align: center;">规划选址名称
    <br>
    <input name="proaddname"  class="toEdit" type="text" id="txtproaddnameEdit" value="${Proaddname }" title="proaddName" size="20" maxlength="20" />
    </td>
    <td style="text-align: center;">
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
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=proaddName&OrderByItemDESC=${pageListOrderByItemDESCNo}">编号</a>
                </th>
                <th width="33%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=proaddName&OrderByItemDESC=${pageListOrderByItemDESCNo}">名称</a>
                </th>
                <th width="33%">
                操作
                </th>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.ProaddList">
            <tr>
				
				 <td>
				 <input  type="hidden" name="proadddatabaseid" value="${iteList.proadddatabaseid }"/>
             	<input type="hidden" name="proaddid" value="${iteList.proaddid}" />
                <label title="marjorid">${iteList.proaddid}</label> 
                </td>
                <td>
                <label title="marjorname">${iteList.proaddname}</label>
                <input type="hidden" name="proaddname" value="${iteList.proaddname}" />
               
                </td>
                <td>
                        <input type="button"  onclick="ToEdit(this)" value="编辑"  id="editBut"/>
                        <input type="button" onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&${pageListUrl}&proadddatabaseid=${iteList.proadddatabaseid}'}" value="删除" />
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
   
    //专业编号
    if(document.getElementById("txtproaddidEdit") && document.getElementById("txtproaddidEdit").value == "")
    {
        alert("规划选址编号不能为空");
        document.getElementById("txtproaddidEdit").focus();
        return false;
    }
    if(document.getElementById("txtproaddidEdit") && !patternInteger.test(document.getElementById("txtproaddidEdit").value))
    {
        alert("规划选址编号只能填写整数");
        document.getElementById("txtproaddidEdit").focus();
        return false;
    }
    //专业名称
    if(document.getElementById("txtproaddnameEdit") && document.getElementById("txtproaddnameEdit").value == "")
    {
        alert("规划选址名称不能为空");
        document.getElementById("txtproaddnameEdit").focus();
        return false;
    }
    if(document.getElementById("txtproaddnameEdit") && getLength(document.getElementById("txtproaddnameEdit")) > 50 )
    {
        alert("规划选址名称的长度不能为大于50");
        document.getElementById("txtproaddnameEdit").focus();
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
		$("#add").val("保存");
		
	}
	
</script>




