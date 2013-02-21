<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="height:100%">
	<head>

		<title><%=com.yun.configuration.WebConfig.WEB_TITLE %></title>
			
		
		<link rel="stylesheet" type="text/css" href="css/AdminCss.css" />
		<link rel="stylesheet" type="text/css" href="css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="js/colorwinglib.js" charset="utf-8"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>
		
		
	
		<script src="<%=basePath %>js/tree/tree.js" type="text/javascript"></script>
		
		
		<script>  
			function initradio(rName,rValue){  
			var rObj = document.getElementsByName(rName);  
				for(var i = 0;i < rObj.length;i++){  
						if(rObj[i].value == rValue){  
							rObj[i].checked =  'checked';  
						}  
				 }  
			 }  
			 

		</script><style type="text/css">

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
<td style="width: 140px;padding :5px;margin-top: 0px;border: 1px solid; vertical-align: top;height: 100%;border-color: #A4BEDC;background-color:#A4BEDC"><div class="tree"   >
<script type="text/javascript" >
	var Tree = new Array;
	${SystemConfigTree}
createTree(Tree,null,1);
</script>
</div></td>
<td style="vertical-align: top;"><div id="dialogSector" style="float: right;width:100%;height: 100%;"  >
<div id="edit"   >
			<table border="0" cellpadding="0" cellspacing="0" id="tbList1" style="width: 100%;"> 
  	<thead><tr><th colspan="4" style="text-align: center;">系统部门编辑</th></tr></thead>
  <tr >
  
  <td >
部门编号   </td>
    <td >
    <div id="showsectorid" class="show" ></div>
		<div  style="width: 100%;height: 100%;display: none;">
    <input name="sectorid" type="text" id="txtSectoridEdit" onblur="validateid()" /><div id="sectormessage" style="display:none;color: red;float: right;"></div>
    </div> </td>
 <td >
部门名称   </td>
    <td >
    <div id="showname" class="show" ></div>
		<div id="perid" style="width: 100%;height: 100%;display: none;">
<input name="sectorname" type="text" id="txtSectornameEdit" value="${Sectorname}" title="部门名称" size="20" maxlength="50" />  
<input name="sectordatabaseid" type="hidden" id="txtSectordatabaseidEdit" title="部门" size="20" maxlength="50" /> </div> </td>
  </tr>
  <tr>
  <td >
部门地址   </td>
    <td >
    <div id="showaddress" class="show" ></div>
		<div  style="width: 100%;height: 100%;display: none;">
    <input name="address" type="text" id="txtAddressEdit" /></div> </td>
  
  <td >
部门电话   </td>
    <td >
    <div id="showphone" class="show" ></div>
		<div  style="width: 100%;height: 100%;display: none;">
    <input name="phone" type="text" id="txtPhoneEdit" /></div> </td>
    </tr>
  <tr>
    <td >
部门描述   </td>

    <td  colspan="3">
    <div id="showdescript" class="show" ></div>
		<div  style="width: 100%;height: 100%;display: none;">
    <input name="description" type="hidden"  value="${Description}" title="部门描述" size="20" maxlength="500" />
		<textarea rows="5" cols="45" name="description" id="txtDescriptionEdit" >
			
		</textarea>	
 </div> </td>
 </tr>

  <tr>
    <td colspan="4" align="center" style="width: 100%">
    <div  style="text-align: center;"  >
    	<input type="button"  name="btnSubmit" class="btnSubmit" id="btnSubmitIns" value="添加 " onclick="addSector()"/>
    	<input type="button" name="btnSubmit" class="btnSubmit" id="btnSubmitUp" value="修改" onclick="editSector(this)"/>
    	<input type="button" name="btnReturn" class="btnSubmit" id="" value="取消" onclick="cancel();" />
   		<input type="button" name="btnSubmit" class="btnSubmit" id="btnSubmitDel" value="删除" onclick="delSector(); "/>
	</div>  
	 </td>
  </tr>
</table>
	</div>
	
	</div></td>
</tr>
</table>



	
	
	
	</body>
	${pageJavaScripEnd}
	${pageJavaScripStar}
	
</html>


<script type="text/javascript">
function returnAddOrUp(strType)
{
    //部门DatabaseID
	var Sectordatabaseid = "";
	if(document.getElementById("txtSectordatabaseidEdit"))
	Sectordatabaseid = document.getElementById("txtSectordatabaseidEdit").value; //部门ID
	
	
	//部门ID
	var Sectorid = "";
	if(document.getElementById("txtSectoridEdit"))
	Sectorid = document.getElementById("txtSectoridEdit").value; //部门ID
	
	//部门名称
	var Sectornames = "";
	if(document.getElementById("txtSectornameEdit"))
	Sectornames = document.getElementById("txtSectornameEdit").value; //部门名称
	
	//部门地址
	var Address = "";
	if(document.getElementById("txtAddressEdit"))
	Address = document.getElementById("txtAddressEdit").value; //部门名称
	
	//部门电话
	var Phone = "";
	if(document.getElementById("txtPhoneEdit"))
	Phone = document.getElementById("txtPhoneEdit").value; //部门名称
	
	
	//部门描述
	var Descriptions = "";
	if(document.getElementById("txtDescriptionEdit"))
		Descriptions = document.getElementById("txtDescriptionEdit").value; //部门描述
	
	
	//启用标志
	//var IsUses = "";
	//if(document.getElementById("dropIsUseEdit"))
	//IsUses = document.getElementById("dropIsUseEdit").value; //启用标志：1-启用、2-未启用
	
	if(checkForm())
    {   	
        $.post("ajax/SystemSector.do?pagetype=" + strType + "&sectordatabaseid="+Sectordatabaseid+"&s=" + new Date().getTime(),
        {
     	sectorid:Sectorid,
        sectorname: Sectornames, //部门名称
        description: Descriptions, //部门描述
		address:Address,
		phone:Phone
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
				  //$('#dialogSector').dialog('close');
   	           }
   	           alert(message);
   	           if(strType=="insert")
   	           location.reload();
   	           else
			   window.location.href="?pagetype=tree&default="+Sectordatabaseid+"";
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




<script>
	function cancel()
			{	
				$("#sectormessage").css({display:"none"})
				$("#sectormessage").text("");
				console.log($("#sectordatabaseid").val())
				if($("#sectordatabaseid").val()=="")
				{
					display();
					$("#btnSubmitIns").removeAttr("disabled");
   					$("#btnSubmitDel").removeAttr("disabled");
					return;
				}			
				ItemCommandEditSector($("#txtSectordatabaseidEdit").val());
			}
	function addSector()
			{	
			
				if($("#perid").css("display")=="none")
				{
					cleartext();
					showInput();
					$("#btnSubmitDel").attr({"disabled":"disabled"});
				}
				else
				{	
					var flag=returnAddOrUp('insert');
					if(flag)
					{ 	
						display();
					}
				}
			}
			function editSector(obj)
			{	
				if($("#perid").css("display")=="none")
				{
					
					showInput();
					$("#btnSubmitIns").attr({"disabled": "disabled" });
					$("#btnSubmitUp").attr({ "value": "保存" });
					$("#btnSubmitDel").attr({ "disabled": "disabled" });
					
				}
				else
				{	
					var flag=returnAddOrUp("update");
					if(flag)
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
				$("#txtDescriptionEdit").val("");
				
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

			}
			function display()
			{
				$("#edit input").each(function()
				
					{	
						$(this).parent().css({display:"none"})
					}
				)
		
				$(".show").each(function()
					{
						$(this).css({display:"block"})
					}
				
				)
				$(".btnSubmit").each(function()
					{
						$(this).parent().css({display:"block"})
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


<script type="text/javascript" >
function ItemCommandEditSector(Sectordatabaseid)
{	
    
   $.get("ajax/SystemSector.do?pagetype=details&sectordatabaseid="+Sectordatabaseid+"&s=" + new Date().getTime(),
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
   		$("#btnSubmitDel").removeAttr("disabled");
   		if($("#showname"))
   		{		
   			
   			$("#showname").text(getQueryString("Sectorname", strUrl));
   			
   		}
   		if($("#showsectorid"))
   		{		
   			
   			$("#showsectorid").text(getQueryString("Sectorid", strUrl));
   			
   		}
   		if($("#showaddress"))
   		{		
   			
   			$("#showaddress").text(getQueryString("Address", strUrl));
   			
   		}
   		if($("#showphone"))
   		{		
   			$("#showphone").text(getQueryString("Phone", strUrl));
   		}
   		
   		
   		
   		if($("#showdescript"))
   		{	
   			$("#showdescript").text(getQueryString("Description", strUrl));
   		}
   		
   		 
   		//if($("#showisuse"))
   		//{	
   		//	var isuser=getQueryString("IsUse", strUrl);
   		//	if(isuser==1)
   		//	{
   		//		$("#showisuse").text("启用");
   		//	}
   		//	else
   		//	{
   		//		$("#showisuse").text("未启用");
   		//	}
   		//}
   
   		

        if(document.getElementById("txtSectornameEdit"))
            document.getElementById("txtSectornameEdit").value = getQueryString("Sectorname", strUrl); //部门名称
            
         if(document.getElementById("txtSectordatabaseidEdit"))
            document.getElementById("txtSectordatabaseidEdit").value = getQueryString("Sectordatabaseid", strUrl); //部门名称
            
        if(document.getElementById("txtSectoridEdit"))
            document.getElementById("txtSectoridEdit").value = getQueryString("Sectorid", strUrl); //部门id
  
            
            if(document.getElementById("txtAddressEdit"))
            document.getElementById("txtAddressEdit").value = getQueryString("Address", strUrl); //部门id
            
            if(document.getElementById("txtPhoneEdit"))
            document.getElementById("txtPhoneEdit").value = getQueryString("Phone", strUrl); //部门id
            
          
        if(document.getElementById("txtDescriptionEdit"))
            document.getElementById("txtDescriptionEdit").value = getQueryString("Description", strUrl); //部门描述
            console.log("Edit Item!")

   	}
	
	});
	        
}
</script>

<script type="text/javascript">
function checkForm()
{

    //部门编号
    if(document.getElementById("txtSectoridEdit") && document.getElementById("txtSectoridEdit").value == "")
    {
        alert("部门编号不能为空");
        document.getElementById("txtSectoridEdit").focus();
        return false;
    }
    if(document.getElementById("txtSectoridEdit") && !patternInteger.test(document.getElementById("txtSectoridEdit").value))
    {
        alert("部门编号只能填写整数");
        document.getElementById("txtSectoridEdit").focus();
        return false;
    }
  
    if($("#sectormessage").text()!="")
    {
    	alert("部门编号已存在");
        document.getElementById("txtSectoridEdit").focus();
        return false;
    }
    //部门名称
    if(document.getElementById("txtSectornameEdit") && document.getElementById("txtSectornameEdit").value == "")
    {
        alert("部门名称不能为空");
        document.getElementById("txtSectornameEdit").focus();
        return false;
    }
    if(document.getElementById("txtSectornameEdit") && getLength(document.getElementById("txtSectornameEdit")) > 50 )
    {
        alert("部门名称的长度不能为大于50");
        document.getElementById("txtSectornameEdit").focus();
        return false;
    }
    //部门描述
    if(document.getElementById("txtDescriptionEdit") && document.getElementById("txtDescriptionEdit").value == "")
    {
        alert("部门描述不能为空");
        document.getElementById("txtDescriptionEdit").focus();
        return false;
    }
    if(document.getElementById("txtDescriptionEdit") && getLength(document.getElementById("txtDescriptionEdit")) > 500 )
    {
        alert("部门描述的长度不能为大于500");
        document.getElementById("txtDescriptionEdit").focus();
        return false;
    }
    //Address
    if(document.getElementById("txtAddressEdit") && document.getElementById("txtAddressEdit").value == "")
    {
        alert("Address不能为空");
        document.getElementById("txtAddressEdit").focus();
        return false;
    }
    if(document.getElementById("txtAddressEdit") && getLength(document.getElementById("txtAddressEdit")) > 50 )
    {
        alert("Address的长度不能为大于50");
        document.getElementById("txtAddressEdit").focus();
        return false;
    }
    //Phone
    if(document.getElementById("txtPhoneEdit") && document.getElementById("txtPhoneEdit").value == "")
    {
        alert("Phone不能为空");
        document.getElementById("txtPhoneEdit").focus();
        return false;
    }
    if(document.getElementById("txtPhoneEdit") && getLength(document.getElementById("txtPhoneEdit")) > 20 )
    {
        alert("Phone的长度不能为大于20");
        document.getElementById("txtPhoneEdit").focus();
        return false;
    }
    if(document.getElementById("txtPhoneEdit") && !patternPhone.test(document.getElementById("txtPhoneEdit").value))
    {
        alert("您的Phone写错了，请修改");
        document.getElementById("txtPhoneEdit").focus();
        return false;
    }
    //启用标志：1-启用、2-未启用
    if(document.getElementById("dropIsUseEdit") && document.getElementById("dropIsUseEdit").value == "")
    {
        alert("启用标志不能为空");
        document.getElementById("dropIsUseEdit").focus();
        return false;
    }
    if(document.getElementById("dropIsUseEdit") && !patternInteger.test(document.getElementById("dropIsUseEdit").value))
    {
        alert("启用标志只能填写整数");
        document.getElementById("dropIsUseEdit").focus();
        return false;
    }
    //是否删除：1-未删除、2-已删除
    if(document.getElementById("dropIsDelEdit") && document.getElementById("dropIsDelEdit").value == "")
    {
        alert("是否删除不能为空");
        document.getElementById("dropIsDelEdit").focus();
        return false;
    }
    if(document.getElementById("dropIsDelEdit") && !patternInteger.test(document.getElementById("dropIsDelEdit").value))
    {
        alert("是否删除只能填写整数");
        document.getElementById("dropIsDelEdit").focus();
        return false;
    }
    //DatabaseUnitID
    if(document.getElementById("txtDatabaseunitidEdit") && document.getElementById("txtDatabaseunitidEdit").value == "")
    {
        alert("DatabaseUnitID不能为空");
        document.getElementById("txtDatabaseunitidEdit").focus();
        return false;
    }
    if(document.getElementById("txtDatabaseunitidEdit") && getLength(document.getElementById("txtDatabaseunitidEdit")) > 50 )
    {
        alert("DatabaseUnitID的长度不能为大于50");
        document.getElementById("txtDatabaseunitidEdit").focus();
        return false;
    }
    //排序
    if(document.getElementById("txtSortsEdit") && document.getElementById("txtSortsEdit").value == "")
    {
        alert("排序不能为空");
        document.getElementById("txtSortsEdit").focus();
        return false;
    }
    if(document.getElementById("txtSortsEdit") && !patternDouble.test(document.getElementById("txtSortsEdit").value))
    {
        alert("排序只能填写实数");
        document.getElementById("txtSortsEdit").focus();
        return false;
    }
	  return true;
}
</script>

<script type="text/javascript">


function delSector(Sectorid){
    	
    if(confirm("确定删除?"))
    {
	Sectorid=$("#txtSectordatabaseidEdit").val();
	$.get("ajax/SystemSector.do?pagetype=delete&sectorid=" + Sectorid + "&s=" + new Date().getTime(),
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
	var Sectordatabaseid=$("#txtSectordatabaseidEdit").val();
	var Sectorid=$("#txtSectoridEdit").val();

	$.post("ajax/Vsectorid.do",
	{
		sectordatabaseid:Sectordatabaseid,
		sectorid:Sectorid
	},
	function(data)
	{
		var message=0;
		eval(data);
		if(message==0)
		{	
			$("#sectormessage").css({display:"block"})
			$("#sectormessage").text("编号已存在");
		}
		else
		{
			$("#sectormessage").css({display:"none"})
			$("#sectormessage").text("");
		}
	}
	)
}
</script>

${defaultItem}



 





