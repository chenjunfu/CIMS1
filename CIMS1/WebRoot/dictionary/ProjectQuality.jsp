<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<title><%=com.yun.configuration.WebConfig.WEB_TITLE %></title>

		<link rel="stylesheet" type="text/css" href="css/public.css" />
		<link rel="stylesheet" type="text/css" href="css/AdminCss.css" />
		
		<link rel="stylesheet" type="text/css" href="css/css.css" />
		<link rel="stylesheet" type="text/css" href="css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="js/colorwinglib.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>
		<script type="text/javascript">
		function setInsert()
		{
			$('#pagetype').val("insert");
			$("#proqulidatabaseid").val("");
			$("#txtproquliidEdit").val("");
			$("#txtproqulinameEdit").val("");
			$("#add").val("添加");
		}
	</script>
	</head>

<body class="bb">
<!---- 层5 ---->

${pageJavaScripStar}
${pageJavaScripEnd}
<s:form action="ProjectQuality" method="post" namespace="/">
<input type="hidden" value="<s:property value="#request.pagetype" default="insert" ></s:property>" name="pagetype" id="pagetype" />
 <table style="width: 100%" border="0" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr>
    <td  align="left" style="text-align: center;">项目性质编号<br/>
   
   
    <s:if test="objProjectQualityInfo.proquliid!=0">
     <input type="hidden" name="objProjectQualityInfo.proqulidatabaseid" value="${objProjectQualityInfo.proqulidatabaseid}" id="proqulidatabaseid" class="toEdit" > </input>
    <input type="text" class="toEdit" name="objProjectQualityInfo.proquliid"  value="${objProjectQualityInfo.proquliid }" id="txtproquliidEdit"/>
    </s:if>
    <s:else>
    <input type="hidden" name="objProjectQualityInfo.proqulidatabaseid" value="" id="proqulidatabaseid" class="toEdit" > </input>
    <input type="text" class="toEdit" name="objProjectQualityInfo.proquliid"  value="" id="txtproquliidEdit"/>
    </s:else>
    	
    </td>
    <td  align="left" style="text-align: center;">项目性质名称
    <br>
    <input name="objProjectQualityInfo.proquliname"   class="toEdit" type="text" id="txtproqulinameEdit" value="${objProjectQualityInfo.proquliname }" title="proquliName" size="20" maxlength="20" />
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
    </s:form>
	
  <div style="width: 100%;" id="divlist">
	 <table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr>
           		 <th width="33%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=objproquliInfo.proquliName&OrderByItemDESC=${pageListOrderByItemDESCNo}">编号</a>
                </th>
                <th width="33%">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=proquliName&OrderByItemDESC=${pageListOrderByItemDESCNo}">名称</a>
                </th>
                <th width="33%">
                操作
                </th>
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.ProjectQualityList">
            <tr>
				
				 <td>
				 <input  type="hidden" name="objproquliInfo.proqulidatabaseid" value="${iteList.proqulidatabaseid }"/>
             	<input type="hidden" name="objproquliInfo.proquliid" value="${iteList.proquliid}" />
                <label title="marjorid">${iteList.proquliid}</label> 
                </td>
                <td>
                <label title="marjorname">${iteList.proquliname}</label>
                <input type="hidden" name="objproquliInfo.proquliname" value="${iteList.proquliname}" />
               
                </td>
                <td>
                        <input type="button"  onclick="ToEdit(this)" value="编辑"  id="editBut"/>
                        <input type="button" onclick="if (confirm('你确定删除本条信息么？')) { window.location.href=window.location.pathname + '?pagetype=delete&${pageListUrl}&proqulidatabaseid=${iteList.proqulidatabaseid}'}" value="删除" />
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
    if(document.getElementById("txtproquliidEdit") && document.getElementById("txtproquliidEdit").value == "")
    {
        alert("项目性质编号不能为空");
        document.getElementById("txtproquliidEdit").focus();
        return false;
    }
    if(document.getElementById("txtproquliidEdit") && !patternInteger.test(document.getElementById("txtproquliidEdit").value))
    {
        alert("项目性质编号只能填写整数");
        document.getElementById("txtproquliidEdit").focus();
        return false;
    }
    //专业名称
    if(document.getElementById("txtproqulinameEdit") && document.getElementById("txtproqulinameEdit").value == "")
    {
        alert("项目性质名称不能为空");
        document.getElementById("txtproqulinameEdit").focus();
        return false;
    }
    if(document.getElementById("txtproqulinameEdit") && getLength(document.getElementById("txtproqulinameEdit")) > 50 )
    {
        alert("项目性质名称的长度不能为大于50");
        document.getElementById("txtproqulinameEdit").focus();
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




