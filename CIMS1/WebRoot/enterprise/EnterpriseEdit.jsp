<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/AdminCss.css" />
        <link rel="stylesheet" type="text/css" href="<%=basePath %>css/css.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="<%=basePath %>js/colorwinglib.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery-ui.js"></script>
	</head>
	<body style=" text-align:center">
${pageJavaScripStar}<form name="produceForm" id="frmEdit" method="post"  action="${btnEditCommandArgument}" >
  <table border="0" cellpadding="0" cellspacing="0" id="tbEdit" align="center" >
    <tr><td colspan="10" style="font:+5; color:#black;text-align:center" height="30">文化企业信息${title }</td></tr>
    <tr>
      <td style="width:8%;border:1px solid #cedff7;"> 统计人员 </td>
      <td style="width:12%"><select name="peopleid1" style="width:95%" id="peopleid1" title="填表人员">
${AdminIDEdit}
      </select>
      <s:if test="#request.Peopleid1!=null">
       <script type="text/javascript">document.getElementById('peopleid1').value='${Peopleid1}';</script>
      </s:if>
     </td>
      <td style="width:9%"> 填表人员 </td>
      <td style="width:12%"><select name="peopleid2" style="width:95%" id="peopleid2" title="统计人员"> 
${AdminIDEdit}
      </select>   
         <s:if test="#request.Peopleid2!=null">
         <script type="text/javascript">document.getElementById('peopleid2').value='${Peopleid2}';</script>
         </s:if>     
      </td>
      <td style="width:9%"> 登录人员 </td>
      <td><label><s:property value='#session.AdminUserInfoadminname' /></label>
       <input name="adminid" type="hidden" id="txtAdminidEdit"  title="登录人员" size="8" maxlength="8"
value="<s:property value='#session.AdminUserInfodatabaseadminid' />"
 />   
      </td>
      <td style="width:6%"> 部  门 </td>
      <td>
${AdminUserInfosectorname}
        <input name="sectorid" type="hidden" id="txtSectoridEdit" value="<s:property value='#session.AdminUserInfosectorid' />" title="部门编号" size="8" maxlength="8" />
        </td>
      <td style="width:9%"> 登录时间 </td>
      <td>
      
       <label>${requestScope.Logintime}</label>
        </td>
    </tr>
  </table>
  <table border="0" align="center" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr>
    <td> 企业编号 </td>
    
    <td>
    <input name="databaseenterpriseid" type="hidden" value="${Databaseenterpriseid }" id="databaseenterpriseid"/>
    <input name="enterpriseid" type="text" id="txtEnterpriseidEdit" value="${Enterpriseid}" onblur="validateno()" title="企业编号" size="20" maxlength="8" />
    <div id="validateno" style="color: red;display: none;"></div>
    </td>
    <td> 企业名称 </td>
    <td><input name="enterprisename" type="text" id="txtEnterprisenameEdit" value="${Enterprisename}" onblur="validatename()" title="企业名称" size="20" maxlength="50" />
    <div id="validatename" style="color: red;display: none;"></div>
    </td>
    <td> 法人 </td>
    <td><input name="legalperson" type="text" id="txtLegalpersonEdit" value="${Legalperson}" title="法人" size="20" maxlength="50" /></td>
    </tr>
  <tr>
    <td> 行业类型 </td>
    <td><select name="businesstypeid" id="dropBusinesstypeidEdit" title="行业类型" style="width:154px">
${BusinesstypeidEdit}
    </select>
    <s:if test="#request.Businesstypeid!=null">
      <script type="text/javascript">document.getElementById('dropBusinesstypeidEdit').value='${Businesstypeid}';</script>
    </s:if>
      </td>
    <td>  企业性质${Businesstypeid} </td>
    <td><select name="qualityid" id="dropQualityidEdit" title="企业性质" style="width:154px">
${QualityidEdit}
      </select>
        <s:if test="#request.Businesstypeid!=null">
         <script type="text/javascript">document.getElementById('dropQualityidEdit').value='${Qualityid}';</script>
        </s:if>
     
      </td>
    <td>所属区域</td>
    <td><select name="regionid" id="dropRegionidEdit" title="所属区域" style="width:154px">
${RegionidEdit}
    </select>
      <s:if test="#request.Businesstypeid!=null">
      <script type="text/javascript">document.getElementById('dropRegionidEdit').value='${Regionid}';</script>
      </s:if>
    
    </td>
    </tr>
  <tr>
    <td>就业人数</td>
    <td>
      <input name="employnumber" type="text" id="txtEmploynumberEdit" value="${Employnumber}" title="就业人数" size="20" maxlength="20" /></td>
    <td> 年产值 </td>
    <td><input name="producevalue" type="text" id="txtProducevalueEdit" value="${Producevalue}" title="年产值" size="20" maxlength="20" /></td>
    <td> 利润 </td>
    <td><input name="profit" type="text" id="txtProfitEdit" value="${Profit}" title="利润" size="20" maxlength="20" /></td>
    </tr>
  <tr>
    <td>注册资金</td>
    <td><input name="registfund" type="text" id="txtRegistfundEdit" value="${Registfund}" title="注册资金" size="20" maxlength="20" /></td>
    <td> 总投资</td>
    <td>
      <input name="toalinvest" type="text" id="txtToalinvestEdit" value="${Toalinvest}" title="总投资" size="20" maxlength="20" /></td>
    <td> 占地面积 </td>
    <td><input name="area" type="text" id="txtAreaEdit" value="${Area}" title="占地面积" size="20" maxlength="20" /></td>
    </tr>
  <tr>
    <td>工商登记号 </td>
    <td ><input name="enterprisecode" type="text" id="txtEnterprisecodeEdit"  onblur="validateEnterpriseCode()" value="${Enterprisecode}" title="工商登记号。例如：100000100000000.x" size="20" maxlength="50" />
    <div id="validateenterprisecode" style="color: red;display: none;"></div>
    </td>
    <td>产品专利号</td>
    <td ><input name="partentcode" type="text" id="txtPartentcodeEdit" onblur="validatePartentCode()" value="${Partentcode}" title="产品专利号。例如：zl00000000001" size="20" maxlength="50" />
      <div id="validatepartentcode" style="color: red;display: none;"></div>
    </td>
    <td>创建时间</td>
    <td><input name="createtime" type="text" id="txtCreatetimeEdit" value="${Createtime}" title="创建时间" size="20" maxlength="50" /></td>
    </tr>
  <tr>
    <td>企业注册地址</td>
    <td  ><input name="registaddress" type="text" id="txtRegistaddressEdit" value="${Registaddress}" title="企业注册地址" size="20" maxlength="80" /></td>
	 <td>联系人 </td>
    <td  ><input name="contact" type="text" id="txtContactEdit" value="${Contact}" title="联系人" size="20" maxlength="80" /></td>
    <td>联系电话 </td>
    <td  ><input name="linkphone" type="text" id="txtLinkphoneEdit" value="${Linkphone}" title="联系电话" size="20" maxlength="80" /></td>
  </tr>
  <tr>
    <td>企业地址 </td>
    <td colspan="5" ><textarea name="address" cols="60" rows="3" id="txtAddressEdit"  title="企业地址"  >${Address}</textarea></td>
  </tr>
  <tr>
    <td>经营范围 </td>
    <td colspan="5"><textarea name="scope" cols="60" rows="3" id="txtScopeEdit" title="经营范围">${Scope}</textarea></td>
    </tr>
  <tr>
    <td>
      产品特色
      </td>
    <td colspan="5"><textarea name="feature" cols="60" rows="3" id="txtFeatureEdit" title="产品特色">${Feature}</textarea>
      </td>
  </tr>
  <tr>
    <td>
获得荣誉
    </td>
    <td colspan="5"><textarea name="obtainhonor" cols="60" rows="3" id="txtObtainhonorEdit" title="获得荣誉">${Obtainhonor}</textarea>
    </td>
    </tr>
  <tr>
    <td>
社会效益
    </td>
    <td colspan="5"><textarea name="socialbenefit" cols="60" rows="3" id="txtSocialbenefitEdit" title="社会效益">${Socialbenefit}</textarea>
    </td>
    </tr>
  <tr>
    <td colspan="6" align="center">
    <div align="center">
      <input type="submit" name="btnSubmit" id="${btnEditText }" value="" onclick="return checkForm();"/>
    <input type="button" name="button" id="btnReturn" value="" onclick="window.location.href='${pageListUrl}&pagetype=updata'" /></div>
      </td>
  </tr>
</table>

</form>
<div id="error" title="错误提示">
</div>
<script type="text/javascript" >
$(function(){
$("#error").dialog({
autoOpen:false,
width:300,
height:300
});
${pageJavaScripEnd}
})
</script>
	</body>
</html>

<script type="text/javascript">
//编辑页面初始化日期控件
$("#txtCreatetimeEdit").datepicker({changeMonth: true,changeYear: true}); //登录时间
</script>

<script type="text/javascript">
function checkForm()
{
   
    //企业编号
    if($("#validateno").text()!="")
    {
    	alert("企业编号不能使用");
        document.getElementById("txtEnterpriseidEdit").focus();
        return false;
    }
    if(document.getElementById("txtEnterpriseidEdit") && document.getElementById("txtEnterpriseidEdit").value == "")
    {
        alert("企业编号不能为空");
        document.getElementById("txtEnterpriseidEdit").focus();
        return false;
    }
    if(document.getElementById("txtEnterpriseidEdit") && !patternInteger.test(document.getElementById("txtEnterpriseidEdit").value))
    {
        alert("企业编号只能填写整数");
        document.getElementById("txtEnterpriseidEdit").focus();
        return false;
    }
    //企业名称
    
    if(document.getElementById("txtEnterprisenameEdit") && document.getElementById("txtEnterprisenameEdit").value == "")
    {
        alert("企业名称不能为空");
        document.getElementById("txtEnterprisenameEdit").focus();
        return false;
    }
    if(document.getElementById("txtEnterprisenameEdit") && getLength(document.getElementById("txtEnterprisenameEdit")) > 50 )
    {
        alert("企业名称的长度不能为大于50");
        document.getElementById("txtEnterprisenameEdit").focus();
        return false;
    }
    
    //法人
    if(document.getElementById("txtLegalpersonEdit") && document.getElementById("txtLegalpersonEdit").value == "")
    {
        alert("法人不能为空");
        document.getElementById("txtLegalpersonEdit").focus();
        return false;
    }
    if(document.getElementById("txtLegalpersonEdit") && getLength(document.getElementById("txtLegalpersonEdit")) > 50 )
    {
        alert("法人的长度不能为大于50");
        document.getElementById("txtLegalpersonEdit").focus();
        return false;
    }
      //就业人数
    if(document.getElementById("txtEmploynumberEdit") && document.getElementById("txtEmploynumberEdit").value == "")
    {
        alert("就业人数不能为空");
        document.getElementById("txtEmploynumberEdit").focus();
        return false;
    }
    if(document.getElementById("txtEmploynumberEdit") && !patternInteger.test(document.getElementById("txtEmploynumberEdit").value))
    {
        alert("就业人数只能填写整数");
        document.getElementById("txtEmploynumberEdit").focus();
        return false;
    }
      //年产值
    if(document.getElementById("txtProducevalueEdit") && document.getElementById("txtProducevalueEdit").value == "")
    {
        alert("年产值不能为空");
        document.getElementById("txtProducevalueEdit").focus();
        return false;
    }
    if(document.getElementById("txtProducevalueEdit") &&( !patternNumber.test(document.getElementById("txtProducevalueEdit").value)&&!patternDouble.test(document.getElementById("txtProducevalueEdit").value)))
    {
        alert("年产值只能填写整数");
        document.getElementById("txtProducevalueEdit").focus();
        return false;
    }
      //利润
    if(document.getElementById("txtProfitEdit") && document.getElementById("txtProfitEdit").value == "")
    {
        alert("利润不能为空");
        document.getElementById("txtProfitEdit").focus();
        return false;
    }
    if(document.getElementById("txtProfitEdit") && (!patternInteger.test(document.getElementById("txtProfitEdit").value)&&!patternDouble.test(document.getElementById("txtProfitEdit").value)))
    {
        alert("利润只能填写整数");
        document.getElementById("txtProfitEdit").focus();
        return false;
    }
     //注册资金
    if(document.getElementById("txtRegistfundEdit") && document.getElementById("txtRegistfundEdit").value == "")
    {
        alert("注册资金不能为空");
        document.getElementById("txtRegistfundEdit").focus();
        return false;
    }
      if(document.getElementById("txtRegistfundEdit") && (!patternInteger.test(document.getElementById("txtRegistfundEdit").value)&&!patternDouble.test(document.getElementById("txtRegistfundEdit").value)))
    {
        alert("注册资金只能填写整数");
        document.getElementById("txtRegistfundEdit").focus();
        return false;
    }
  
       //总投资
    if(document.getElementById("txtToalinvestEdit") && document.getElementById("txtToalinvestEdit").value == "")
    {
        alert("总投资不能为空");
        document.getElementById("txtToalinvestEdit").focus();
        return false;
    }
    if(document.getElementById("txtToalinvestEdit") && (!patternInteger.test(document.getElementById("txtToalinvestEdit").value)&&!patternDouble.test(document.getElementById("txtToalinvestEdit").value)))
    {
        alert("总投资只能填写整数");
        document.getElementById("txtToalinvestEdit").focus();
        return false;
    }
  
     //占地面积
    if(document.getElementById("txtAreaEdit") && document.getElementById("txtAreaEdit").value == "")
    {
        alert("占地面积不能为空");
        document.getElementById("txtAreaEdit").focus();
        return false;
    }
    if(document.getElementById("txtAreaEdit") && getLength(document.getElementById("txtAreaEdit")) > 20 )
    {
        alert("占地面积的长度不能为大于20");
        document.getElementById("txtAreaEdit").focus();
        return false;
    }
 
    
   
  
   
    //工商登记号
    if(document.getElementById("txtEnterprisecodeEdit") && document.getElementById("txtEnterprisecodeEdit").value == "")
    {
        alert("工商登记号不能为空");
        document.getElementById("txtEnterprisecodeEdit").focus();
        return false;
    }
    if(document.getElementById("txtEnterprisecodeEdit") && getLength(document.getElementById("txtEnterprisecodeEdit")) > 50 )
    {
        alert("工商登记号的长度不能为大于50");
        document.getElementById("txtEnterprisecodeEdit").focus();
        return false;
    }
    //产品专利号
    if(document.getElementById("txtPartentcodeEdit") && document.getElementById("txtPartentcodeEdit").value == "")
    {
        alert("产品专利号不能为空");
        document.getElementById("txtPartentcodeEdit").focus();
        return false;
    }
    if(document.getElementById("txtPartentcodeEdit") && getLength(document.getElementById("txtPartentcodeEdit")) > 50 )
    {
        alert("产品专利号的长度不能为大于50");
        document.getElementById("txtPartentcodeEdit").focus();
        return false;
    }
     //创立时间
    if(document.getElementById("txtCreatetimeEdit") && document.getElementById("txtCreatetimeEdit").value == "")
    {
        alert("创立时间不能为空");
        document.getElementById("txtCreatetimeEdit").focus();
        return false;
    }
    if(document.getElementById("txtCreatetimeEdit") && !patternDate.test(document.getElementById("txtCreatetimeEdit").value))
    {
        alert("您的创立时间写错了，请修改");
        document.getElementById("txtCreatetimeEdit").focus();
        return false;
    }
  
    //企业注册地址
    if(document.getElementById("txtRegistaddressEdit") && document.getElementById("txtRegistaddressEdit").value == "")
    {
        alert("企业注册地址不能为空");
        document.getElementById("txtRegistaddressEdit").focus();
        return false;
    }
    if(document.getElementById("txtRegistaddressEdit") && getLength(document.getElementById("txtRegistaddressEdit")) > 50 )
    {
        alert("企业注册地址的长度不能为大于50");
        document.getElementById("txtRegistaddressEdit").focus();
        return false;
    }
       //联系人
    if(document.getElementById("txtContactEdit") && document.getElementById("txtContactEdit").value == "")
    {
        alert("联系人不能为空");
        document.getElementById("txtContactEdit").focus();
        return false;
    }
    if(document.getElementById("txtContactEdit") && getLength(document.getElementById("txtContactEdit")) > 50 )
    {
        alert("联系人的长度不能为大于50");
        document.getElementById("txtContactEdit").focus();
        return false;
    }
 
      //联系电话
    if(document.getElementById("txtLinkphoneEdit") && document.getElementById("txtLinkphoneEdit").value == "")
    {
        alert("联系电话不能为空");
        document.getElementById("txtLinkphoneEdit").focus();
        return false;
    }
    if(document.getElementById("txtLinkphoneEdit") && getLength(document.getElementById("txtLinkphoneEdit")) > 50 )
    {
        alert("联系电话的长度不能为大于50");
        document.getElementById("txtLinkphoneEdit").focus();
        return false;
    }
    if(document.getElementById("txtLinkphoneEdit") && !patternPhone.test(document.getElementById("txtLinkphoneEdit").value))
    {
        alert("您的联系电话写错了，请修改");
        document.getElementById("txtLinkphoneEdit").focus();
        return false;
    }
    
     //企业地址
    if(document.getElementById("txtAddressEdit") && document.getElementById("txtAddressEdit").value == "")
    {
        alert("企业地址不能为空");
        document.getElementById("txtAddressEdit").focus();
        return false;
    }
    if(document.getElementById("txtAddressEdit") && getLength(document.getElementById("txtAddressEdit")) > 50 )
    {
        alert("企业地址的长度不能为大于50");
        document.getElementById("txtAddressEdit").focus();
        return false;
    }

    //经营范围
    if(document.getElementById("txtScopeEdit") && document.getElementById("txtScopeEdit").value == "")
    {
        alert("经营范围不能为空");
        document.getElementById("txtScopeEdit").focus();
        return false;
    }
    if(document.getElementById("txtScopeEdit") && getLength(document.getElementById("txtScopeEdit")) > 50 )
    {
        alert("经营范围的长度不能为大于50");
        document.getElementById("txtScopeEdit").focus();
        return false;
    }
  
  
    //产品特色
    if(document.getElementById("txtFeatureEdit") && document.getElementById("txtFeatureEdit").value == "")
    {
        alert("产品特色不能为空");
        document.getElementById("txtFeatureEdit").focus();
        return false;
    }
    if(document.getElementById("txtFeatureEdit") && getLength(document.getElementById("txtFeatureEdit")) > 500 )
    {
        alert("产品特色的长度不能为大于500");
        document.getElementById("txtFeatureEdit").focus();
        return false;
    }
    //获得荣誉
    if(document.getElementById("txtObtainhonorEdit") && document.getElementById("txtObtainhonorEdit").value == "")
    {
        alert("获得荣誉不能为空");
        document.getElementById("txtObtainhonorEdit").focus();
        return false;
    }
    if(document.getElementById("txtObtainhonorEdit") && getLength(document.getElementById("txtObtainhonorEdit")) > 500 )
    {
        alert("获得荣誉的长度不能为大于500");
        document.getElementById("txtObtainhonorEdit").focus();
        return false;
    }
    //社会效益
    if(document.getElementById("txtSocialbenefitEdit") && document.getElementById("txtSocialbenefitEdit").value == "")
    {
        alert("社会效益不能为空");
        document.getElementById("txtSocialbenefitEdit").focus();
        return false;
    }
    if(document.getElementById("txtSocialbenefitEdit") && getLength(document.getElementById("txtSocialbenefitEdit")) > 500 )
    {
        alert("社会效益的长度不能为大于500");
        document.getElementById("txtSocialbenefitEdit").focus();
        return false;
    }
	return true;
}

function validateno()
{
 var Enterpriseno=$("#txtEnterpriseidEdit").val();
 if(Enterpriseno&&Enterpriseno!="")
 {	
 	var Databaseenterpriseid=$("#databaseenterpriseid").val();
 	if(!patternInteger.test(Enterpriseno))
 	{	
 		$('#validateno').text('必须是数字');
 		$('#validateno').css({display:"block"})

 		return false;
 	}
 	else
 	{
 		$('#validateno').text('');
 		$('#validateno').css({display:""})
 	}
 	if(Databaseenterpriseid&&Databaseenterpriseid=="")
 	{
 		Databaseenterpriseid=0;
 	}
 	$.post("../ajax/VEnterpriseNo.do",
 		{
 		enterpriseid:Enterpriseno,
 		databaseenterpriseid:Databaseenterpriseid
 		},
 		function(data)
 		{
 			var Message=1;
 			eval(data);
 			if(Message==1)
 			{
 				$('#validateno').text('');
 				$('#validateno').css({display:"none"})
 		
 			}
 			else
 			{	
 				$('#validateno').text('已经存在');
 				$('#validateno').css({display:"block"})		
 			　  
 			}
 		}
 		
 	)
 }
 else
 {
 	$('#validateno').text('');
 	$('#validateno').css({display:"none"})
 }
}


//验证名称
function validatename()
{	

 var Enterprisename=$("#txtEnterprisenameEdit").val();
 if(Enterprisename&&Enterprisename!="")
 {	
 	var Databaseenterpriseid=$("#databaseenterpriseid").val();
 	if(Databaseenterpriseid&&Databaseenterpriseid=="")
 	{
 		Databaseenterpriseid=0;
 	}
 	
 	$.post("../ajax/VEnterpriseName.do",
 		{
 		enterprisename:Enterprisename,
 		databaseenterpriseid:Databaseenterpriseid
 		},
 		function(data)
 		{
 			var Message=1;
 			eval(data);
 			if(Message==1)
 			{
 				$('#validatename').text('');
 				$('#validatename').css({display:"none"})
 		
 			}
 			else
 			{	
 				$('#validatename').text('已经存在');
 				$('#validatename').css({display:"block"})		
 			　  
 			}
 		}
 		
 	)
 }
 else
 {
 	$('#validatename').text('');
 	$('#validatename').css({display:"none"})
 }
}
//验证EnterpriseCode
function validateEnterpriseCode()
{	

 var Enterprisecode=$("#txtEnterprisecodeEdit").val();
 if(Enterprisecode&&Enterprisecode!="")
 {	
 	var Databaseenterpriseid=$("#databaseenterpriseid").val();
 	if(Databaseenterpriseid&&Databaseenterpriseid=="")
 	{
 		Databaseenterpriseid=0;
 	}
 	
 	$.post("../ajax/VEnterpriseEnterpriseCode.do",
 		{
 		enterprisecode:Enterprisecode,
 		databaseenterpriseid:Databaseenterpriseid
 		},
 		function(data)
 		{
 			var Message=1;
 			eval(data);
 			if(Message==1)
 			{	
 				$('#validateenterprisecode').text('');
 				$('#validateenterprisecode').css({display:"none"})
 		
 			}
 			else
 			{		
 
 				$('#validateenterprisecode').text('已经存在');
 				$('#validateenterprisecode').css({display:"block"})		
 			　  
 			}
 		}
 		
 	)
 }
 else
 {
 	$('#validateenterprisecode').text('');
 	$('#validateenterprisecode').css({display:"none"})
 }
}

//验证PartentCode
function validatePartentCode()
{	

 var Partentcode=$("#txtPartentcodeEdit").val();
 if(Partentcode&&Partentcode!="")
 {	
 	var Databaseenterpriseid=$("#databaseenterpriseid").val();
 	if(Databaseenterpriseid&&Databaseenterpriseid=="")
 	{
 		Databaseenterpriseid=0;
 	}
 	
 	$.post("../ajax/VEnterprisePartentCode.do",
 		{
 		partentcode:Partentcode,
 		databaseenterpriseid:Databaseenterpriseid
 		},
 		function(data)
 		{
 			var Message=1;
 			eval(data);
 			if(Message==1)
 			{
 				$('#validatepartentcode').text('');
 				$('#validatepartentcode').css({display:"none"})
 		
 			}
 			else
 			{	
 				$('#validatepartentcode').text('已经存在');
 				$('#validatepartentcode').css({display:"block"})		
 			　  
 			}
 		}
 		
 	)
 }
 else
 {
 	$('#validatepartentcode').text('');
 	$('#validatepartentcode').css({display:"none"})
 }
}
</script>

