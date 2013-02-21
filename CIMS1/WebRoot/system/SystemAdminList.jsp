<%@ page language="java" import="java.util.*,com.yun.ui.action.UserLook" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title><%=com.yun.configuration.WebConfig.WEB_TITLE %></title>
		<link rel="stylesheet" type="text/css" href="css/public.css" />
		<link rel="stylesheet" type="text/css" href="css/css.css" />
		<link rel="stylesheet" type="text/css" href="css/AdminCss.css" />
		
		<script type="text/javascript" src="js/colorwinglib.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>
	
	<script>
	
		function SetPersonnelByNo()
		{	
		        
		        
		        if($("#personno").find("option:selected").val()!="请选择")
		        {
		       	 	$("#personname").val($("#personno").val());
					$("#personsexset").val($("#personno").val());
					$("#personsectorset").val($("#personno").val());
					$("#databaseid").val($("#personno").val());
				
				
				
					$("#showpersonname").text($("#personname").find("option:selected").text());
				
				
					$("#sexlist").val($("#personsexset").find("option:selected").text());
					$("#showpersonsex").text($("#sexlist").find("option:selected").text());
				
				
					$("#personsector").val($("#personsectorset").find("option:selected").text());
					$("#showpersonsectorid").text($("#personsector").find("option:selected").text());
					
					$("#databaseadminid").val($("#databaseid").val());
					
					
					$("#adminpassword1").val("");
		        	$("#adminname").val("");
		        	$("#adminpassword2").val("");
					$("#adminpassword1").removeAttr("disabled")
		        	$("#adminname").removeAttr("disabled")
		        	$("#adminpassword2").removeAttr("disabled")
		        	$("#addbut").removeAttr("disabled")
		        	$("#roles").removeAttr("disabled")
		        	$("#adminname").focus();
		        	
		        	
		        }
		        else
		        {
		        	canceladd();
		        }
		        
			 	
						
		}
		
		function canceladd()
		{
			$("#databaseadminid").val("");
			$("#showpersonname").text("");
			$("#showpersonsex").text("");
			$("#showpersonsectorid").text("");
			$("#adminname").attr({disabled:"disabled"});
			$("#adminpassword1").attr({disabled:"disabled"});
			$("#adminpassword2").attr({disabled:"disabled"});
			$("#roles").attr({disabled:"disabled"});
			$("#addbut").attr({disabled:"disabled"});
			
		}
	</script>
	<script type="text/javascript">
		//删除用户为系统人员
		function delUser(id,state)
		{	
			if(!confirm('确定删除?'))
			{
				return;
			}
			if(state==1)
			{
				state=2;
			}
			else
			{
				state=1;
			}
			if(id==undefined)
			{
				id=0;
			}
			$.post("ajax/Systemadminforadmin.do",
			{
				pagetype:'update',
				databaseadminid:id,
				isDel:state
			},
			function(data){
				   var messageID = 0;//1-正确消息、2-出错消息
   	        var message = "";
   	        eval(data);
   	        if(messageID !=0)
   	        {
   	           //成功后刷新页面，只是更新的话删除这理的if语句
   	           if(messageID ==1)
   	           {	
   	               alert(message);
   	              location.reload();
   	           }
   	          
			}

		}
		)
		}
		//禁用用户 
		function disUser(id,state)
		{
		if(state==1)
			{
				state=2;
			}
			else
			{
				state=1;
			}

			if(id==undefined)
			{
				id=0;
			}
			$.post("ajax/Systemadminforadmin.do",
			{
				pagetype:'update',
				databaseadminid:id,
				isUse:state
			},
			function(data){
			var messageID = 0;//1-正确消息、2-出错消息
   	        var message = "";
   	        eval(data);
   	        if(messageID !=0)
   	        {
   	           //成功后刷新页面，只是更新的话删除这理的if语句
   	           if(messageID ==1)
   	           {	
   	           	  alert(message);
   	              location.reload();
   	           }
   	           
			}

		}
		)
		}
		
		//设置用户权限
		function setCompetence(id)
		{
			location.href='SystemAdmin.do?pagetype=setcompetence&databaseadminid='+id;
		}
	</script>
	</head>
	<body>
	<%
	UserLook userlook=new UserLook(request,response);
	request.setAttribute("userlook",userlook);
	 %>
	${pageJavaScripNoPrives}
	<div>
	<div style="display:none;">
		<select id="personsexset">
			${NoUseSex }
		</select>
		<select id="personsectorset">
			${NoUseSector}
		</select>
		<select  id="personsector" >
			${SectoridList}
		</select>
		<select name="truename"  id="personname">
			${NoUseName}
		</select>	
		<select id="sexlist" >
			${SexList}
		</select>
		<select  id="databaseid">
			${NoUseDatabaseID }
		</select>
	</div>
		<table border="0" cellpadding="0" cellspacing="0" id="tbEdit"  style="width: 100%;table-layout: auto">
		 <form action="SystemAdmin.do?pagetype=update" method="post" id="form1">
		 <thead>
		 	<tr><th colspan="9">用户设置:</th></tr>
		 </thead>
		
		<tr>
		<td style="width: 90px" >
			编号:
			<input type="hidden" name="databaseadminid" id="databaseadminid"/>
			<select name="adminid"  style="width:40px" id="personno" onchange="SetPersonnelByNo()" >

			<option value="请选择">
				<font size="1">--</font>
			</option>
				${NoUseID}
			</select>	
		</td>
		<td style="width: 90px">
			姓名:
				<label id="showpersonname"></label>
		</td>
		<td style="width: 90px" >
			性别:
			<label id="showpersonsex"></label>
		</td>
		<td style="width: 90px" >
			部门:
			<label id="showpersonsectorid"></label>
		</td>
		<td style="text-align: left;width: 130px">帐号:
		<input type="text" name="adminname" size="11" id="adminname" disabled="disabled"/>
		</td>
		<td style="text-align: left;width: 130px">密码:<input type="text" name="adminpassword" id="adminpassword1"  size="11" disabled="disabled"/></td>
		<td style="text-align: left;width: 160px">确认密码:<input type="text" id="adminpassword2" size="11" disabled="disabled"/></td>
		<td style="text-align: left;width: 110px">角色:<select name="rolesid" style="width:70px" id="roles" disabled="disabled">${RolesidEdit}</select></td>
		<td style="text-align: center;" ><input type="submit" value="添加"  id="addbut" onclick="return checkPassword()" disabled="disabled"/> <input type="reset" value="取消" onclick="canceladd()"/>  </td>
		</tr>
		</form >
		</table>
	</div>
	<div id="divlist">
            <table border="0" cellpadding="0" cellspacing="0" id="tbEdit"  style="width: 100%;table-layout: auto;">
            <thead>
            <tr>
                <td style="text-align:center;width: 90px">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=AdminID&OrderByItemDESC=${pageListOrderByItemDESCNo}">人员编号</a>                </td>
                <td style="text-align:center;width: 90px">
                      
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=TrueName&OrderByItemDESC=${pageListOrderByItemDESCNo}">姓名</a>             </td>
                <td style="text-align:center;width: 90px">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Sex&OrderByItemDESC=${pageListOrderByItemDESCNo}">性别</a>                </td>
                <td style="text-align:center;width: 90px">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=SectorID&OrderByItemDESC=${pageListOrderByItemDESCNo}">部门</a>                </td>
                <td style="text-align:center;width: 130px">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=AdminName&OrderByItemDESC=${pageListOrderByItemDESCNo}">帐号</a>       </td>
                <td style="text-align:center;width: 130px">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=AdminPassWord&OrderByItemDESC=${pageListOrderByItemDESCNo}">密码</a>                </td>
                <td style="text-align:center;width: 160px">
                    &nbsp;<a href="?pagetype=list&${pageListUrlOrderBy}&OrderByItem=Is_Use&OrderByItemDESC=${pageListOrderByItemDESCNo}">确认密码</a>                </td>
                <td style="text-align:center;width: 110px">
                    &nbsp;<a href="">角色</a></td>
                <td style="text-align:center">
          			      操作 
          		</td>
            </tr>
            </thead>
     
		<s:iterator id="iteList" value="#request.SystemAdminList">
   <form action="SystemAdmin.do?pagetype=update" method="post" id="form2">
            <tr>		
                <td>
			&nbsp;${iteList.adminid}
				<input type="hidden" name="databaseadminid" value="${iteList.databaseadminid}"/>
				<input  type="hidden" name="adminid" value="${iteList.adminid }"/>
				<input type="hidden" name="adminname" value="${iteList.adminname }"/>
				<input type="hidden" id="adminpasswordtbackup" name="adminpasswordtbackup" value="${iteList.adminpassword }"/>
				<input type="hidden" id="isusebackup" name="isusebackup" value="${iteList.isUse }"/>
				<input type="hidden" id="rolesidbackup" name="rolesidbackup" value="${iteList.rolesid }"/>
			  </td>
			           <td>
			&nbsp;${iteList.truename}                </td>
        
                <td>
			&nbsp;${iteList.sexlabel}                </td>
			  <td>
			&nbsp;${iteList.objSystemSectorInfoBySectorid.sectorname}                </td>
             <td>
			&nbsp;${iteList.adminname}                </td>
                <td style="text-align: center;">
				<div class="showdiv">${iteList.adminpassword}</div>                
				<div  class="editdiv" style="display: none;"><input id="adminpassword3" name="adminpassword"  size="9" value="${iteList.adminpassword }"/></div>
			</td>
                <td style="text-align: center;">
                
			 	<div class="showdiv">${iteList.adminpassword}</div>
				<div class="editdiv" style="display: none;">
					<input id="adminpassword4" name="adminpassword4"  size="9" value="${iteList.adminpassword }"/>
				</div>
			 </td>
                <td style="text-align: center;">
			<div class="showdiv"> ${iteList.objSystemRolesInfoByRolesid.rolesname}</div>
			<div class="editdiv" style="display: none;">
				<select name="rolesid" id="rolesid">
					${RolesidEdit}
				</select>
			</div>                
				</td>
			       <td style="text-align: center;">
				    <input type="submit" id="operation" value="编辑" onclick="return opera(this)"/>
				    <s:if test="#request.userlook.seePageN('25')">
       				 <input type="button" value="权限" onclick="setCompetence('${iteList.databaseadminid}')"/>
        			</s:if>
				  	<s:if test="#iteList.isUse==1">
				  		<input type="button" value="禁用" onclick="disUser('${iteList.databaseadminid}','${iteList.isUse}')"/>
				  	</s:if>
				  	<s:else>
				  		<input type="button" value="启用" onclick="disUser('${iteList.databaseadminid}','${iteList.isUse}')"/>
				  	</s:else>
				    <input type="button" value="删除" onclick="delUser('${iteList.databaseadminid}','${iteList.isDel}')"/>
				    <input  type="button" onclick="ListItem(this)" value="取消"/>
				  </td> 
            </tr>
            </form>
		</s:iterator>
			<tr><td colspan="9" style="text-align: center;">${pageDetails}</td></tr>
            </table>


    </div>

	</body>
</html>

<script>

function opera(obj)
{	

	if($(obj).val()=="编辑")
	{
		EditItem(obj);
		return false;
	}
	else if($(obj).val()=="保存")
	{	
		return validatePass();
	}
}
function validatePass()
{

	if($("#adminpassword3").val()=="")
	{
		alert("用户密码不能为空");
		$("#adminpassword1").focus();
		return false;
	}
	if($("#adminpassword3").val()!=$("#adminpassword4").val())
	{
		alert("密码输入不一致");
			$("#adminpassword2").focus();
		return false;
		
	}
	return true;
}

function checkPassword()
{
	if($("#adminpassword1").val()=="")
	{
		alert("用户密码不能为空");
		$("#adminpassword1").focus();
		return false;
	}
	if($("#adminpassword1").val()!=$("#adminpassword2").val())
	{
		alert("密码输入不一致");
			$("#adminpassword2").focus();
		return false;
		
	}
}
function EditItem(obj)
{	
							 
	$(obj).parent().parent().find(".editdiv").each(function()
		{
			$(this).css({"display":"block"});
		}
	)
	$(obj).parent().parent().find(".showdiv").each(function()
		{
			$(this).css({"display":"none"});
		}
	)
	$(obj).parent().parent().parent().find(":submit").each(function()
		{
			$(this).attr({disabled:"disabled"});
		}
	)
	$(obj).parent().parent().parent().find(":button").each(function()
		{
			$(this).attr({disabled:"disabled"});
		}
	)
	$(obj).parent().parent().find("#isUse").val($(obj).parent().parent().find("#isusebackup").val());	
	$(obj).parent().parent().find("#rolesid").val($(obj).parent().parent().find("#rolesidbackup").val());	
	$(obj).val("保存");
	$(obj).removeAttr("disabled");
	$(obj).parent().children(":button").each(function(){
	$(this).removeAttr("disabled");
	})
}

function ListItem(obj)
{	
							 
	$(obj).parent().parent().find(".editdiv").each(function()
		{
			$(this).css({"display":"none"});
		}
	)
	$(obj).parent().parent().find(".showdiv").each(function()
		{
			$(this).css({"display":"block"});
		}
	)
	$(obj).parent().parent().find("#adminpassword").val($(obj).parent().parent().find("#adminpasswordtbackup").val());	
	$(obj).parent().parent().find("#isUse").val($(obj).parent().parent().find("#isusebackup").val());	
	$(obj).parent().parent().find("#rolesid").val($(obj).parent().parent().find("#rolesidbackup").val());
	$(obj).parent().parent().parent().find(":submit").each(function()
		{
			$(this).removeAttr("disabled");
		    $(this).val("编辑")
		}
	)
	$(obj).parent().parent().parent().find(":button").each(function()
		{
			$(this).removeAttr("disabled");
		}
	)
}
</script>
