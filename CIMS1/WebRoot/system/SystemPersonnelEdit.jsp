<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'SystemPersonnel.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		
	


		<link rel="stylesheet" type="text/css" href="css/AdminCss.css" />
		<link rel="stylesheet" type="text/css" href="css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="js/colorwinglib.js" charset="utf-8" ></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>
		<script src="js/tree/tree.js" type="text/javascript"></script>
		<script>  
			function initradio(rName,rValue){  
			var rObj = document.getElementsByName(rName);  
				for(var i = 0;i < rObj.length;i++){  
						if(rObj[i].value == rValue){  
							rObj[i].checked =  'checked';  
						}  
				 }  
			 }  
		</script>  
		<style type="text/css">
			
			.btnSubmit{
      background:url(img/btn/tj1.jpg) no-repeat;
	  height:27px; 
	  width:71px;
	  border:none;
	  padding-left:17px;
	   cursor:pointer;
	  }	

/*表格样式begin*/
#tbList1{
        width:100%;
		border-left:#a4bedc solid 1px;
		border-top:#a4bedc solid 1px;
		border-collapse:collapse; 
		}
/*表格样式dataList的caption样式*/
#tbList1 caption{
        font-size:14px; 
		font-weight:bold; 
		color:#003a9f; 
		height:25px; 
		padding-top:8px;
		}
/*表格样式dataList的thead样式*/
#tbList1 thead th{ 
        height:30px;
		border-right:#a4bedc solid 1px;
		border-right:#a4bedc solid 1px;
		border-bottom:#a4bedc solid 1px; 
		background-image:url(images/tdbg.jpg);
	    background-repeat:repeat-x;
		font-size:14px; 
		color:#fff;
		line-height:30px;
		font-weight:bold;
		}
#tbList1 thead th a{
        color:#FFFFFF;
		}	
#tbList1 thead th a:hover{
        color:#FFFFFF;
		text-decoration:underline;
		}
#tbList1 thead th a:visited{
        color:#FFFFFF;
		}					

#tbList1 tbody td{
        height:25px;
        width:25%;
		border-right:#a4bedc solid 1px;
		border-bottom:#a4bedc solid 1px;
		vertical-align:bottom; 
		font-size:12px; 
		color:#000; 
		text-align:left;
		line-height:23px;
		padding:5px;
		}
#tbList1 tbody td select{
        float:left;
		}
#tbList1 tbody td textarea{
        float:left;
		margin-top:5px;
		}
/*表格样式dataList的tfoot样式*/
#tbList1 tfoot td{
        border-right:#a4bedc solid 1px; 
		border-bottom:#a4bedc solid 1px; 
		background-color: #f2f2f2; 
		height:30px; 
		text-align:center;
		}
/*表格样式dataList的a样式*/	
#tbList1 tr td a{	
        color: #c75f3e;
	   text-decoration: underline;
      }	
#tbList1 tr td a:hover{	
        color: #000;
	   text-decoration: underline;
      }	
#tbList1 tr td a:visited{	
        color: #c75f3e;
	   text-decoration: underline;
      }		  	  
/*表格样式end*/

		.tree{
		width:100%;
		height:100%;
		float:left;
		border: 1px solid;
		margin: 0px;
		padding: 0px;
		border-color: #A4BEDC;
		background-color:#FFF;
		}
		.tree a
		{
		cursor: pointer;
		}
		.tree img{
		border: 0px;
		}

		</style>
		
		
		
  </head>
  
  <body style="padding: 0px;margin: 0px;height:90%">
<table style="width: 100%;height: 100%;">
<tr>
<td style="width: 140px;padding :5px;margin-top: 0px;border: 1px solid; vertical-align: top;height: 100%;border-color: #A4BEDC;background-color:#A4BEDC">
 <div class="tree"  >
<script type="text/javascript"  >
	var Tree = new Array;
	${SystemConfigTree}
</script>
</div>
</td>
<td style="vertical-align: top;" >
<div id="edit" style="float: right;width:100%; height: 100%" >
		<table border="0" cellpadding="0" cellspacing="0" id="tbList1"  style="width: 100%" > 
		<thead> <tr><th style="text-align: center;" colspan="4">人员设置</th></tr></thead>
	  <tr >
		<td>
	人员编号 </td>
		<td>
		<div id="showid" class="show" ></div>
		<div id="perid" style="display: none;">
		
	<input name="adminid" type="text" id="txtAdminidEdit" onblur="validateid()" value="${Adminid}" title="人员编号" size="15" maxlength="20" /> <div id="adminidmessage" style="color: red;display: none;float: right;"></div>
	<input name="databaseadminid" type="hidden" id="txtdatabaseadminidEdit" value="${Databaseadminid}" title="人员编号" size="15" maxlength="8" /> 
	   </div>
	   </td>
	   
	  	<td>
	姓名    </td>
		<td>
		<div id="showname" class="show"></div>
		<div style="display: none;">
	<input name="truename" type="text" id="txtTruenameEdit" value="${Truename}" title="姓名" size="15" maxlength="50" />  </div>  </td>
	
	</tr>
	
	
	  <tr >
		<td>
	性别    </td>
		<td align="left">
		<div id="showsex" class="show"></div>
		<div style="display: none;">
		<input type="radio" value="1" name="sex" />
					男　　 
					  
					  <input type="radio" value="2" name="sex" />
						女 
						
						<input type="hidden" value="" name="hiddensex" id="hiddensex" />
						</div>
						</td>
	 
	
		<td>
	工号    </td>
		<td>
		<div id="showworkno" class="show"></div>
		<div style="display: none;">
	<input name="workno" type="text" id="txtWorknoEdit" value="${Workno}" title="工号" size="15" maxlength="50" onblur="validateworkno()" /><div id="adminworknomessage" style="color: red;display: none;float: right;"></div> </div>   </td>
	  </tr>
	  
	  
	  <tr >
		<td >
	联系EMAIL    </td>
		<td>
		<div id="showemail" class="show"></div>
		<div style="display: none;">
	<input name="email" type="text" id="txtEmailEdit" value="${Email}" title="联系EMAIL" size="15" maxlength="50" /></div>    </td>
	  
		<td>
	移动电话    </td>
	
		<td>
		<div id="showphone" class="show"></div>
		<div style="display: none;">
	<input name="movephone" type="text" id="txtMovephoneEdit" value="${Movephone}" title="移动电话" size="15" maxlength="50" /> </div>   </td>
	 
		</tr>
		
		<tr style="width: 100%" >
	<td>
	电话    </td>
		<td>
		<div id="showtel" class="show"></div>
		<div style="display: none;">
	<input name="phone" type="text" id="txtPhoneEdit" value="${Phone}" title="电话" size="15" maxlength="50" /> </div>   </td>
	 

		<td>
	部门   </td>
		<td  >
	<div id="showsector" class="show"></div>
	<div style="display: none; " id="sectordiv">
	<select  name="sectorid2" id="dropSectoridEdit2"   title="部门编号"  >
	 ${SectoridList }
	</select>
	<script type="text/javascript">document.getElementById('dropSectoridEdit2').value='${Sectorid}';
	</script>  
	</div>
	</td>
	</tr>
		
	  <tr >
		<td>
	通讯地址    </td>
		<td  >
		
		<div id="showadd" class="show"></div>
		<div style="display: none;" >
	<input name="address" type="text" id="txtAddressEdit" value="${Address}" title="通讯地址" size="15" maxlength="100" /> </div>   </td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	  </tr>
	
	  <tr >
		<td colspan="4" align="center">
		<div align="center">
		<input type="submit" name="btnSubmit" class="btnSubmit"   id="btnSubmitIns" value="添加" onclick="addperson();cleartext()"/>

		<input type="submit" name="btnSubmitEdit" class="btnSubmit" id="btnSubmitUp" value="修改" onclick="editperson(this)"/>
		    <input type="button" name="btnReturn" class="btnSubmit" id="" value="取消" onclick="cancel();" /> 

		<input type="button" name="btnSubmit"  class="btnSubmit" id="btnSubmitDel" value="删除" onclick="delAdmin();"/>   </div> </td>
	  </tr>
	</table>

	</div>
</td>
</tr>
</table>

  </body>
</html>


<script> 	
		
	
			function cancel()
			{	
				$("#adminworknomessage").text("");
				$("#adminworknomessage").css({display:"none"});
				$("#adminidmessage").text("");
				$("#adminidmessage").css({display:"none"});
				if($("#txtdatabaseadminidEdit").val()=="")
				{		
					
					display();
					$("#btnSubmitIns").removeAttr("disabled");
   					$("#btnSubmitDel").removeAttr("disabled");
					return;
				}	
				ItemCommandEditAdmin($("#txtdatabaseadminidEdit").val());
			}
			function addperson()
			{
				if($("#perid").css("display")=="none")
				{	
					cleartext();
					showInput();
					$("#btnSubmitDel").attr({"disabled":"disabled"});
				}
				else
				{
					if(returnAddOrUp2("insert"))
					{
						display();
					}
				}
			}
			function editperson(obj)
			{
				if($("#perid").css("display")=="none")
				{		
					
					showInput();
					$("#btnSubmitIns").attr({ "disabled": "disabled" });
					$("#btnSubmitDel").attr({ "disabled": "disabled" });
					$("#btnSubmitUp").attr({ "value": "保存" });
				}
				else
				{
					if(returnAddOrUp2("update"))
					{
						display();
						$("#btnSubmitIns").removeAttr("disabled");
						$("#btnSubmitUp").attr({ "value": "修改" });
					}
				}
			}
	 		function cleartext()
			{		
			
				$("#edit :text").each(function()
					{
					
						$(this).val("");
					}
				)
				
			}
			function showInput()
			{	
				$("#edit input").each(function()
				
					{
						$(this).parent().css({display:"block"})
					}
				)
				$(".show").each(function()
					{
						$(this).css({display:"none"})
					}
				
				)
			
				$("#sectordiv").css({display:"block"})
				$("#isuserdiv").css({display:"block"})
				
			}
			function display()
			{	
				$("#sectordiv").css({display:"none"});
				$("#isuserdiv").css({display:"none"})
				$("#edit input").each(function()
				
					{	
						$(this).parent().css({display:"none"})
					}
				)
				$("#edit :button").each(function()
				
					{	
						$(this).parent().css({display:"block"})
					}
				)
				$(".show").each(function()
					{
						$(this).css({display:"block"})
					}
				
				)
				
			}
			
function radiovalue(rName){  
	var rObj = document.getElementsByName(rName);  
	for(var i = 0;i < rObj.length;i++){  
		if(rObj[i].checked ==  true){  
			document.getElementById("hiddensex").value = rObj[i].value;
		}  
	}  
}  
</script>  

<script type="text/javascript">

function returnAddOrUp2(strType)
{
	//人员ID

	var Databaseadminids = "";
	if(document.getElementById("txtdatabaseadminidEdit"))
		Databaseadminids = document.getElementById("txtdatabaseadminidEdit").value; //人员ID
	//编号
	var Adminid="";
	 if(document.getElementById("txtAdminidEdit"))
    {
   		Adminid=document.getElementById("txtAdminidEdit").value;
    }
    //

	//姓名
	var Truenames = "";
	if(document.getElementById("txtTruenameEdit"))
		Truenames = document.getElementById("txtTruenameEdit").value; //姓名
	//工号
	var Worknos = "";
	if(document.getElementById("txtWorknoEdit"))
		Worknos = document.getElementById("txtWorknoEdit").value; //工号
	//联系EMAIL
	var Emails = "";
	if(document.getElementById("txtEmailEdit"))
		Emails = document.getElementById("txtEmailEdit").value; //联系EMAIL
	//移动电话
	var Movephones = "";
	if(document.getElementById("txtMovephoneEdit"))
		Movephones = document.getElementById("txtMovephoneEdit").value; //移动电话
	//电话
	var Phones = "";
	if(document.getElementById("txtPhoneEdit"))
		Phones = document.getElementById("txtPhoneEdit").value; //电话

	
	//部门编号
	var Sectorids = "";
	if(document.getElementById("dropSectoridEdit2"))
		Sectorids = document.getElementById("dropSectoridEdit2").value; //部门编号
	
	//通讯地址
	var Addresss = "";
	if(document.getElementById("txtAddressEdit"))
		Addresss = document.getElementById("txtAddressEdit").value; //通讯地址
	
	//是否启用
	var isUser="";
	if(document.getElementById("dropIsUseEdit2"))
		isUser = document.getElementById("dropIsUseEdit2").value;
		
	

	
	
	radiovalue("sex");
	var Sexs = "";
	if(document.getElementById("hiddensex"))
		Sexs = document.getElementById("hiddensex").value;
	 
	if(checkForm2())
    {		

        $.post("ajax/SystemAdmin.do?pagetype=" + strType + "&s=" + new Date().getTime(),
        {
        
        databaseadminid: Databaseadminids, //人员ID    
        sex: Sexs, //性别：1-男、2-女
        truename: Truenames, //姓名
        workno: Worknos, //工号
        email: Emails, //联系EMAIL
        movephone: Movephones, //移动电话
        phone: Phones, //电话
        sectorid: Sectorids, //部门编号
   		address:Addresss,
     	adminid:Adminid
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
   	              //ListShow();
				  $('#dialogAdmin').dialog('close');
   	           }
   	            alert(message);
   	            //location.reload();
   	            if(strType=="insert")
   	            location.reload();
   	            else
				location.href="SystemPersonnel.do?pagetype=tree&target=personnel&default="+Databaseadminids+"";
				return true;
   	        }
   	        else
   	        {
   	        }
           }
        );
	}
}
</script>

<script type="text/javascript" >
function ItemCommandEditAdmin(Databaseadminid)
{		

   $.get("ajax/SystemAdmin.do?pagetype=details&databaseadminid="+Databaseadminid+"&s=" + new Date().getTime(),
   function(data){
   	var s = new Array();
   	var messageID = 0;//1-正确消息、2-出错消息
   	var message = "";
   	var strUrl = "";//数据的Url编码字段
   	eval(data);
   	if(messageID !=0)
   	{
   	    alert(message);
   	}
   	else
   	{	
   		display();
   		$("#btnSubmitUp").attr({ "value": "修改" });
   		$("#btnSubmitIns").removeAttr("disabled");
   		$("#btnSubmitUp").removeAttr("disabled");
   		$("#btnSubmitDel").removeAttr("disabled");
   		if($("#showid"))
   		{		
   			$("#showid").text(getQueryString("Adminid", strUrl));
   		}
   		if($("#showname"))
   		{	
   		
   			$("#showname").text(getQueryString("Truename", strUrl));
   			
   		}
   			if($("#showsex"))
   		{	
   			var temp=getQueryString("Sex", strUrl);
   			
   			if(temp==1)
   			{
   			$("#showsex").text("男");
   			}
   			else
   			{
   				$("#showsex").text("女");
   			}
   			
   		}
   			if($("#showworkno"))
   		{	
   		
   			$("#showworkno").text(getQueryString("Workno", strUrl));
   			
   		}
   			if($("#showemail"))
   		{	
   		
   			$("#showemail").text(getQueryString("Email", strUrl));
   			
   		}
   			if($("#showphone"))
   		{	
   		
   			$("#showphone").text(getQueryString("Movephone", strUrl));
   			
   		}
   			if($("#showtel"))
   		{	
   		
   			$("#showtel").text(getQueryString("Phone", strUrl));
   			
   		}
  
   			if($("#showadd"))
   		{	
   		
   			$("#showadd").text(getQueryString("Address", strUrl));
   			
   		}
   			if($("#showisuser"))
   		{	
   			var isuser=getQueryString("IsUse", strUrl);
   			if(isuser==1)
   			$("#showisuser").text("启用");
   			else
   			$("#showisuser").text("未启用");
   			
   		}
   		
        if(document.getElementById("txtdatabaseadminidEdit"))
            document.getElementById("txtdatabaseadminidEdit").value = getQueryString("Databaseadminid", strUrl); //人员ID  
        if(document.getElementById("txtAdminidEdit"))
            document.getElementById("txtAdminidEdit").value = getQueryString("Adminid", strUrl); //人员编号
       
        if(document.getElementById("txtAdminnameEdit"))
            document.getElementById("txtAdminnameEdit").value = getQueryString("Adminname", strUrl); //帐号
        if(document.getElementById("txtAdminpasswordEdit"))
            document.getElementById("txtAdminpasswordEdit").value = getQueryString("Adminpassword", strUrl); //密码
        if(document.getElementById("txtTruenameEdit"))
            document.getElementById("txtTruenameEdit").value = getQueryString("Truename", strUrl); //姓名
        if(document.getElementById("txtWorknoEdit"))
            document.getElementById("txtWorknoEdit").value = getQueryString("Workno", strUrl); //工号
        if(document.getElementById("txtEmailEdit"))
            document.getElementById("txtEmailEdit").value = getQueryString("Email", strUrl); //联系EMAIL
        if(document.getElementById("txtMovephoneEdit"))
            document.getElementById("txtMovephoneEdit").value = getQueryString("Movephone", strUrl); //移动电话
        if(document.getElementById("txtPhoneEdit"))
            document.getElementById("txtPhoneEdit").value = getQueryString("Phone", strUrl); //电话
        if(document.getElementById("txtMsnEdit"))
            document.getElementById("txtMsnEdit").value = getQueryString("Msn", strUrl); //MSN
        if(document.getElementById("dropRolesidEdit"))
            document.getElementById("dropRolesidEdit").value = getQueryString("Rolesid", strUrl); //角色编号
        if(document.getElementById("dropSectoridEdit2"))
         {   document.getElementById("dropSectoridEdit2").value = getQueryString("Sectorid", strUrl); 
         	
         	 $("#showsector").text($("#dropSectoridEdit2").find("option:selected").text());
         	
         }//部门编号
          
        if(document.getElementById("txtDescriptionEdit2"))
            document.getElementById("txtDescriptionEdit2").value = getQueryString("Description", strUrl); //人员描述
        if(document.getElementById("txtAddressEdit"))
            document.getElementById("txtAddressEdit").value = getQueryString("Address", strUrl); //通讯地址
        if(document.getElementById("txtLimitIpEdit"))
            document.getElementById("txtLimitIpEdit").value = getQueryString("LimitIp", strUrl); //限定IP
        if(document.getElementById("txtLastLogintimeEdit"))
            document.getElementById("txtLastLogintimeEdit").value = getQueryString("LastLogintime", strUrl); //最后登录时间
        if(document.getElementById("txtLastLoginipEdit"))
            document.getElementById("txtLastLoginipEdit").value = getQueryString("LastLoginip", strUrl); //最后登录IP
        if(document.getElementById("txtCreateTimeEdit"))
            document.getElementById("txtCreateTimeEdit").value = getQueryString("CreateTime", strUrl); //创建时间
        if(document.getElementById("txtLastModifytimeEdit"))
            document.getElementById("txtLastModifytimeEdit").value = getQueryString("LastModifytime", strUrl); //最后修改时间
        if(document.getElementById("dropIsUseEdit2"))
        
            document.getElementById("dropIsUseEdit2").value = getQueryString("IsUse", strUrl); //启用标志：1-启用、2-未启用
        if(document.getElementById("dropIsDelEdit2"))
            document.getElementById("dropIsDelEdit2").value = getQueryString("IsDel", strUrl); //是否删除：1-未删除、2-已删除
			
		var Sex = getQueryString("Sex", strUrl);
			initradio("sex",Sex); 
	       
		//$('#dialogAdmin').dialog('open'); 	
   	}

	});
}
</script>


<script type="text/javascript">
function checkForm2()
{
   
    //人员编号
    if(document.getElementById("txtAdminidEdit") && document.getElementById("txtAdminidEdit").value == "")
    {
        alert("人员编号不能为空");
        document.getElementById("txtAdminidEdit").focus();
        return false;
    }
    if(document.getElementById("txtAdminidEdit") && !patternInteger.test(document.getElementById("txtAdminidEdit").value))
    {
        alert("人员编号只能填写整数");
        document.getElementById("txtAdminidEdit").focus();
        return false;
    }
    if($("#adminidmessage").text()!="")
    {
    	alert("人员编号已存在");
        document.getElementById("txtAdminidEdit").focus();
        return false;
    }
    
   
    
    //姓名
    if(document.getElementById("txtTruenameEdit") && document.getElementById("txtTruenameEdit").value == "")
    {
        alert("姓名不能为空");
        document.getElementById("txtTruenameEdit").focus();
        return false;
    }
    if(document.getElementById("txtTruenameEdit") && getLength(document.getElementById("txtTruenameEdit")) > 50 )
    {
        alert("姓名的长度不能为大于50");
        document.getElementById("txtTruenameEdit").focus();
        return false;
    }
    //工号
    if(document.getElementById("txtWorknoEdit") && document.getElementById("txtWorknoEdit").value == "")
    {
        alert("工号不能为空");
        document.getElementById("txtWorknoEdit").focus();
        return false;
    }
    if(document.getElementById("txtWorknoEdit") && getLength(document.getElementById("txtWorknoEdit")) > 50 )
    {
        alert("工号的长度不能为大于50");
        document.getElementById("txtWorknoEdit").focus();
        return false;
    }
    if($("#adminworknomessage").text()!="")
    {
     	alert("工号已存在");
        document.getElementById("txtWorknoEdit").focus();
        return false;
    }
    
  
    //部门编号
    if(document.getElementById("txtSectoridEdit2") && document.getElementById("txtSectoridEdit2").value == "")
    {
        alert("部门编号不能为空");
        document.getElementById("txtSectoridEdit2").focus();
        return false;
    }
    if(document.getElementById("txtSectoridEdit2") && !patternInteger.test(document.getElementById("txtSectoridEdit2").value))
    {
        alert("部门编号只能填写整数");
        document.getElementById("txtSectoridEdit2").focus();
        return false;
    }
   return true;
  
}
</script>

<script type="text/javascript">
function delAdmin(Databaseadminid){
	if(confirm("确定删除?"))
	{
	Databaseadminid=$("#txtdatabaseadminidEdit").val();
	$.get("ajax/SystemAdmin.do?pagetype=delete&databaseadminid=" + Databaseadminid + "&s=" + new Date().getTime(),
   function(data){
   	var s = new Array();
   	var messageID = 0;//1-正确消息、2-出错消息
   	var message = "";
   	eval(data);
   	if(messageID !=0)
   	{
   	    //$('#dialogEdit').dialog('close');
   	    //initList(document.getElementById("dropAcquisitionTypeEdit").value);
   	    alert(message);
		location.reload(); 
   	}

	});
	}
	else
	{}
}
function validateid()
{	
	var DatabaseAdminid=$("#txtdatabaseadminidEdit").val();
	var Adminid=$("#txtAdminidEdit").val();
	$.post("ajax/VadminID.do",
		{adminid:Adminid,
		databaseadminid:DatabaseAdminid
		},
		function(data)
		{
			var message=0;
			eval(data);
			console.log(data);
			console.log(message);
			if(message==0)
			{
				$("#adminidmessage").text("该编号已存在");
				$("#adminidmessage").css({display:"block"})
			}
			else
			{	
				$("#adminidmessage").text("");
				$("#adminidmessage").css({display:"none"})
			}
		}
		);
}
function validateworkno()
{	
	var DatabaseAdminid=$("#txtdatabaseadminidEdit").val();
	var Workno=$("#txtWorknoEdit").val();
	$.post("ajax/Vadminworkno.do",
		{databaseadminid: DatabaseAdminid,
		workno:Workno
		},
		function(data)
		{
			var message=0;
			eval(data);
			console.log(data);
			console.log(message);
			if(message==0)
			{
				$("#adminworknomessage").text("该工号已存在");
				$("#adminworknomessage").css({display:"block"})
			}
			else
			{	
				$("#adminworknomessage").text("");
				$("#adminworknomessage").css({display:"none"})
			}
		}
		);
}
</script>
${defaultItem}
