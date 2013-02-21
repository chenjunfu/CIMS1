<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/css.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/AdminCss.css" />
        <link rel="stylesheet" type="text/css" href="<%=basePath %>css/smoothness/jquery-ui.css"/>
        <link rel="stylesheet" type="text/css" href="<%=basePath %>css/jquery1.9.2/jquery-ui.css"/>
		<script type="text/javascript" src="<%=basePath %>js/colorwinglib.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery-ui.js"></script>
	<style type="text/css">
		input { border: 1px solid #bebebe; }
#tbEditk
{
	padding: 5px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;

	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
	border-right-color: #cedff7;
	border-bottom-color: #cedff7;
	border-left-color: #cedff7;
	width:100%;
	text-align:center;
	margin:0px;
	padding:0px;
}
#tbEditk tr
{
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-bottom-style: solid;
	border-left-style: solid;
	border-bottom-color: #b0d8f2;
	border-left-color: #b0d8f2;
	background-color: #f0f7fc;
	margin:0px;
	padding:0px;
}
#tbEditk input
{
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-bottom-style: solid;
	border-left-style: solid;
	border-bottom-color: #b0d8f2;
	border-left-color: #b0d8f2;
	background-color: #f0f7fc;
}
#tbEditk tr td {
	border-top-width: 1px;
	border-right-width: 1px;
	margin:0px;
	padding:0px;
	border-top-style: solid;
	border-right-style: solid;
	border-top-color: #b0d8f2;
	border-right-color: #b0d8f2;
	padding: 5px;
	text-align: left;
	font-size: 14px;
}
</style>
<script>

	$(function(){
	$("#upload").dialog({
	 autoOpen:false,
	 modal: true,
	 width:540,
	 position: [380,70],
	 buttons:{ 
                "上传":function(){ 
                  $("#frmEditPic").submit();
                }, 
                "关闭": function() { 
                    $("#upload").dialog("close"); 
                } 
            } 
	})
	})

</script>
	
	</head>
	<body >
${pageJavaScripStar}
<form name="produceForm" id="frmEdit" method="post"  action="${btnEditCommandArgument}"  enctype="multipart/form-data">
<table border="0" cellpadding="0" cellspacing="0" id="tbEdit" align="center">
<tr>
<td colspan="10" style="font:+5;height:30px; text-align:center ;border-left: 1px solid #cedff7;"  >产业项目信息${title }</td>
</tr>
  <tr >
       <td style="width:8%;border: 1px solid #cedff7;"   >
统计人员
    </td>
    <td style="width:12%;border-bottom: 1px solid #cedff7;">

<select name="databasepeopleid2" id="dropDatabasepeopleid2Edit" title="统计人员" style="width:95%">
${Databasepeopleid2Edit}
</select>
<s:if test="#request.Databasepeopleid2!=null">
<script type="text/javascript">document.getElementById('dropDatabasepeopleid2Edit').value='${Databasepeopleid2}';</script>   
</s:if>

 </td>
  
    <td style="width:9%;border-bottom: 1px solid #cedff7;">
填表人员
    </td>
    <td style="width:12%;border-bottom: 1px solid #cedff7;">
<select name="databasepeopleid1" id="dropDatabasepeopleid1Edit" title="填表人员" style="width:95%">
${Databasepeopleid1Edit}
</select>
<s:if test="#request.Databasepeopleid1!=null">
<script type="text/javascript">document.getElementById('dropDatabasepeopleid1Edit').value='${Databasepeopleid1}';</script>
</s:if>
</td>
 

 
    <td style="width:9%;border-bottom: 1px solid #cedff7;"> 登录人员 </td>
    <td style="border-bottom: 1px solid #cedff7;"><s:property value='#session.AdminUserInfoadminname' />
    <input name="adminid" type="hidden" value="<s:property value='#session.AdminUserInfodatabaseadminid' />" title="部门编号" size="8" maxlength="8" />
    </td>
    <td style="width:6%;border-bottom: 1px solid #cedff7;"> 部 门 </td>
    <td style="border-bottom: 1px solid #cedff7;">
    
${AdminUserInfosectorname}

    <input name="sectorid" type="hidden" id="txtSectoridEdit" value="<s:property value='#session.AdminUserInfosectorid' />" title="部门编号" size="8" maxlength="8" /></td>
    <td style="width:9%;border-bottom: 1px solid #cedff7;"> 登录时间 </td>
    <td style="border-bottom: 1px solid #cedff7;">

    <label  title="登录时间">${Logintime} </label>
    
    </td>
    </tr>
</table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="tbEdit"  >
  <tr>
    <td width="10%" style="border-left: 1px solid #cedff7;">
      项目编号
      </td>
    <td width="20%">
      <input name="projectid" type="text" id="txtProjectidEdit" onblur="validateno()" value="${Projectid}" 　 title="项目编号" size="20" maxlength="20" />
      <div id="validateno" style="color: red;display: none;"></div>
      </td>
    <td width="13%" >项目名称 </td>
    <td width="20%" colspan="2"><input name="projectname" type="text" id="txtProjectnameEdit" onblur="validatename()" value="${Projectname}" title="项目名称" size="20" maxlength="50" />
    <div id="validatename" style="color: red;display: none;"></div>
    </td>
    <td width="10%" >
经营单位
    </td>
    <td width="23%" colspan="2">
<select name="databaseenterpriseid" id="dropDatabaseenterpriseidEdit" title="经营单位" style="width:154px">
${DatabaseenterpriseidEdit}
</select>
<s:if test="#request.Databaseenterpriseid!=null">
<script type="text/javascript">document.getElementById('dropDatabaseenterpriseidEdit').value='${Databaseenterpriseid}';</script> 
</s:if>
   </td>
  </tr>
  <tr>
    <td width="10%" style="border-left: 1px solid #cedff7;">
  建设性质
      </td>
    <td width="23%" >
     <select name="proquality" id="dropProqualityEdit" title="建设性质" style="width:154px">
${ProqualityEdit}
</select>
<s:if test="#request.Proquality!=null">
<script type="text/javascript">document.getElementById('dropProqualityEdit').value='${Proquality}';</script>
</s:if>
</td>
      <td width="10%">
产业类别
    </td>
    <td width="23%" colspan="2">
<select name="industryid" id="dropIndustryidEdit" title="产业类别" style="width:154px">
${IndustryidEdit}
</select>
<s:if test="#request.Industryid!=null">
<script type="text/javascript">document.getElementById('dropIndustryidEdit').value='${Industryid}';</script>
</s:if>
</td>
    
    
      <td width="10%">
主管单位
    </td>
    <td width="23%" colspan="2">
<select name="dutyunitid" id="dropDutyunitidEdit" title="主管单位" style="width:154px">
${DutyunitidEdit}
</select>
<s:if test="#request.Dutyunitid!=null">
<script type="text/javascript">document.getElementById('dropDutyunitidEdit').value='${Dutyunitid}';</script>
</s:if>

    </td> </tr>
  <tr>
    <td width="10%">
所属区域
    </td>
    <td width="23%">
<select name="regionid" id="dropRegionidEdit" title="所属区域" style="width:154px">
${RegionidEdit}
</select>
<s:if test="#request.Regionid!=null">
<script type="text/javascript">document.getElementById('dropRegionidEdit').value='${Regionid}';</script>
</s:if>
</td>


    <td width="10%">地址</td>
    <td width="23%" colspan="2"><input name="address" type="text" id="txtAddressEdit" value="${Address}" title="所在地址" size="20" maxlength="100" /></td>
     <td width="10%" > 经营状况 </td>
    <td width="23%" colspan="2"><input name="state" type="text" id="txtStateEdit" value="${State}" title="经营状况" size="20" maxlength="100" /></td>
  </tr>
  
  
  
  <tr>
    <td width="10%" style="border-left: 1px solid #cedff7;" > 创建时间 </td>
    <td width="23%"><input name="createtime" type="text" id="txtCreatetimeEdit" value="${Createtime}" title="创建时间" size="20" maxlength="20" />
    <script type="text/javascript">
//编辑页面初始化日期控件
$("#txtCreatetimeEdit").datepicker({changeMonth: true,changeYear: true}); //创建时间


</script>
    </td>
     <td  width="10%"> 计划完成时间 </td>
    <td width="23%" colspan="2"><input name="plantime" type="text" id="txtPlantimeEdit" value="${Plantime}" title="计划完成时间" size="20" maxlength="20" />
     <script type="text/javascript">
//编辑页面初始化日期控件

$("#txtPlantimeEdit").datepicker({changeMonth: true,changeYear: true}); //完成时间

</script>
    </td>
         <td width="10%"> 完成时间 </td>
    <td colspan="2" width="23%" ><input name="completetime" type="text" id="txtCompletetimeEdit" value="${Completetime}" title="完成时间" size="20" maxlength="20" />
     <script type="text/javascript">
//编辑页面初始化日期控件

$("#txtCompletetimeEdit").datepicker({changeMonth: true,changeYear: true}); //完成时间

</script>
    </td>
  </tr>
  
  <tr>
    <td width="10%" style="border-left: 1px solid #cedff7;">
      总投资
      </td>
    <td width="20%">
      <input name="totalinvest" type="text" id="txtTotalinvestEdit" value="${Totalinvest}" title="实际投入资金" size="20"  maxlength="20" />
      </td>
    <td width="13%" >实际投资 </td>
    <td width="20%" colspan="2"><input name="realinvest" type="text" id="txtRealinvestEdit" value="${Realinvest}" title="实际投入" size="20"   maxlength="50" /></td>
    <td width="20%" >
截止去年年底完成投资
    </td>
    <td width="23%" colspan="2">
<input name="yearinvest" type="text" id="txtYearinvestEdit" value="${Yearinvest}" title="截止去年年底完成投资" size="20"   maxlength="50" />
    </td>
  </tr>
  
  <tr>
    <td width="10%" style="border-left: 1px solid #cedff7;">
    <font>年计划投资</font>
      </td>
    <td width="20%">
      <input name="planinvest" type="text" id="txtPlaninvestEdit" value="${Planinvest}" title="今年计划投资" size="20"  maxlength="50" />
      </td>
    <td width="13%" >&nbsp;</td>
    <td width="20%" colspan="2">&nbsp;</td>
    <td width="10%" >
&nbsp;
    </td>
    <td width="23%" colspan="2">
&nbsp;
   </td>
  </tr>
  <tr><td colspan="8" style="text-align: center;border-left: 1px solid #cedff7; padding: 0px">资金来源</td></tr>
<tr >
    <td style="border:1px solid #cedff7 ;border-bottom: 0px ;border-right: 0px;border-left: 1px solid #cedff7;text-align: left;"> 政府投资 </td>
    <td style="border:1px solid #cedff7 ;border-bottom: 0px ;border-right: 0px"><input name="publicinvest" type="text" id="txtPublicinvestEdit" value="${Publicinvest}" title="政府投资" size="20" maxlength="60" /></td>
    <td style="border:1px solid #cedff7 ;border-bottom: 0px ;border-right: 0px;text-align: left;"> 自筹 </td>
    <td style="border:1px solid #cedff7 ;border-bottom: 0px ;border-right: 0px" colspan="2"><input name="selfinvest" type="text" id="txtSelfinvestEdit" value="${Selfinvest}" title="自筹" size="20" maxlength="60" /></td>
    <td style="border:1px solid #cedff7 ;text-align: left;border-bottom: 0px ;border-right: 0px"> 银行贷款 </td>
    <td style="border:1px solid #cedff7 ;border-right:1px solid #cedff7 ;border-bottom: 0px ;border-right: 1px solid #cedff7;" colspan="2"><input name="bankloan" type="text" id="txtBankloanEdit" value="${Bankloan}" title="银行" size="20" maxlength="60" /></td>
  </tr>
<tr><td colspan="8" style="text-align: center;border-left: 1px solid #cedff7;">项目前期进展情况</td></tr>
  
  
  <tr>
  	<td colspan="8" style="border:1px solid #cedff77;border-left: 1px solid #cedff7;padding: 0px"><table cellpadding="0" cellspacing="0"  style="height: 100%;width: 100% ;border:0px solid #cedff7; " >
  	<tr>
  	<td style="border: 0px solid;" width="10%" ><font >审批核准备案</font></td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%" ><select name="shb" id="dropShbEdit" title="审批,核准,备案" style="width:123px">
${ShbEdit}
</select>
<s:if test="#request.Shb!=null">
<script type="text/javascript">document.getElementById('dropShbEdit').value='${Shb}'; </script>
</s:if>



</td>
  	<td style="border: 0px solid;" width="10%" >规划选址</td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%"><select name="ghxz" id="dropGhxzEdit" title="规划选址" style="width:123px" >
${GhxzEdit}
</select>
<s:if test="#request.Ghxz!=null">
<script type="text/javascript">document.getElementById('dropGhxzEdit').value='${Ghxz}';</script>
</s:if>
</td>
  	<td style="border: 0px solid;" width="10%" >环评批复</td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%"><select name="hppf" id="dropHppfEdit" title="环评批复" style="width:123px">
${HppfEdit}
</select>
<s:if test="#request.Hppf!=null">
<script type="text/javascript">document.getElementById('dropHppfEdit').value='${Hppf}';</script>
</s:if>

</td>
  	<td style="border: 0px solid;" width="10%" >土地批准</td>
  	<td style="border: 0px solid;" width="15%">
  	<select name="tdpz" id="dropTdpzEdit" title="土地批准" style="width:123px">
${TdpzEdit}
</select>
<s:if test="#request.Tdpz!=null">
<script type="text/javascript">document.getElementById('dropTdpzEdit').value='${Tdpz}';</script>
</s:if>
</td>
  </tr>
  </table>
  </td>
</tr>

  <tr>
  	<td colspan="8" style="border:1px solid #cedff77;border-left: 1px solid #cedff7;padding: 0px"><table cellpadding="0" cellspacing="0"  style="height: 100%;width: 100% ;border:0px solid #cedff7; " >
  	<tr>
  	<td style="border: 0px solid;" width="10%" ><font >审批文号</font></td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%" ><input size="15" name="shbno" value="${Shbno}"  />

</td>
  	<td style="border: 0px solid;" width="10%" >规划选址文号</td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%"><input size="15" name="ghxzno" value="${Ghxzno}" />
</td>
  	<td style="border: 0px solid;" width="10%" >环评批复文号</td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%"><input size="15" name="hppfno" value="${Hppfno }" />
</td>
  	<td style="border: 0px solid;" width="10%" >土地批准文号</td>
  	<td style="border: 0px solid;" width="15%"><input  size="15" name="tdpzno"  value="${Tdpzno }"/></td>
  </tr>
  </table>
</td></tr>
  
  
  <tr>
  	<td colspan="8" style="border:1px solid #cedff77;border-left: 1px solid #cedff7;padding: 0px"><table cellpadding="0" cellspacing="0"  style="height: 100%;width: 100% ;border:0px solid #cedff7; " >
  	<tr>
  	<td style="border: 0px solid;" width="10%" >计划进度</td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%"><input name="planprogress" type="text" id="txtPlanprogressEdit" value="${Planprogress}" title="计划进度" size="15" maxlength="100" /></td>
  	<td style="border: 0px solid;" width="10%" >实际进度</td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%"><input name="realprogress" type="text" id="txtRealprogressEdit" value="${Realprogress}" title="实际进度" size="15" maxlength="50" /></td>
  	<td style="border: 0px solid;" width="10%" >联系人</td>
  	<td style="border: 0px solid;border-right: 1px solid #cedff7;" width="15%"><input name="linkman" type="text" id="txtLinkmanEdit" value="${Linkman}" title="联系人" size="15" maxlength="50" /></td>
  	<td style="border: 0px solid;" width="10%" >联系手机</td>
  	<td style="border: 0px solid;" width="15%"><input name="phone" type="text" id="txtPhoneEdit" value="${Phone}" title="联系电话" size="15" maxlength="50" /></td>
  </tr>
  	
  	</table></td>
  </tr>
 
  <tr>
    <td  style="border-left: 1px solid #cedff7;"> 项目内容 </td>
    <td colspan="7">
      
      <textarea name="procontent" id="txtProcontentEdit" cols="45" rows="5" title="项目内容" style="width:80%">${Procontent}</textarea></td>
  </tr>
  <tr>
    <td style="border-left: 1px solid #cedff7;"> 备注</td>
    <td colspan="7">
      <textarea name="comment" id="txtCommentEdit" cols="45" rows="5" title="项目备注" style="width:80%">${Comment}</textarea></td>
  </tr>
  <tr>
    <td style="border-left: 1px solid #cedff7;"> 项目特色 </td>
    <td colspan="7">
      
      <textarea name="feature" id="txtFeatureEdit" cols="45" rows="5" title="项目特色" style="width:80%">${Feature}</textarea></td>
  </tr> 
	
	<tr>
	<td  style="border: 0px solid;padding: 0px;" colspan="8">
<table border="0" cellpadding="0" cellspacing="0" id="tbEditk" style="border: 0px solid; margin: 0px;padding: 0px" align="center">
<tr>
   <td colspan="4" style="border-left: 1px solid #cedff7;">
   <div  style="display:block;vertical-align:top;top:0">
   <div align="left"  >
      <table width="85%" cellpadding="0" cellspacing="0" id="tbEditk">
        <tr>
          <td style="border-left: 1px solid #cedff7;"  width="13%" align="center" ><div align="center">
      <input name="databaseprojectid" type="hidden" value="${Databaseprojectid }"/>
      <input name="radio" type="radio" id="danfile" value="1" checked="checked" onclick="multile();"/>
      <label for="danfile">单文件上传</label>
    </div></td>    
  <td width="46%"  align="left" style="border-left: 0px solid #cedff7;" >&nbsp;
      <input name="radio" type="radio" value="2" onclick="multile();" />
      <label for="danfile1">多文件上传</label></td>
      
        </tr></table>
        </div>
    </div>
    </td>
    </tr>
  <tr>
   <td colspan="4" style="border-left: 1px solid #cedff7;">
   <div  style="display:block;vertical-align:top;top:0">
   <div align="left"  >
      <table width="85%" cellpadding="0" cellspacing="0" id="tbEditk">
        <tr>
          <td width="13%"> 项目图片1 </td>
          <td  width="46%"><input type="file" name="pic" id="filePic" size="40" />
            </td>
        </tr></table>
        </div>
    </div>
    </td>
    </tr>
  <tr>
    <td colspan="4" style="border-left: 1px solid #cedff7;">
    <div id="mulite" style="display:none;vertical-align:top;top:0">
      <div align="left"  >
        <table cellpadding="0" cellspacing="0" id="tbEditk" width="85%">
          <tr>
            <td width="13%" style="border-left: 1px solid #cedff7;" >项目图片2</td>
            <td width="46%" ><input type="file" name="pic" id="filePic1" size="40" />
           </td>
            </tr>
          <tr>
            <td style="border-left: 1px solid #cedff7;">项目图片3 </td>
            <td><input type="file" name="pic" id="Pic" size="40" />
           </td>
            </tr>
          <tr>
            <td style="border-left: 1px solid #cedff7;">项目图片4 </td>
            <td><input type="file" name="pic" id="Pic" size="40" />
               </td>
            </tr>
          <tr>
            <td style="border-left: 1px solid #cedff7;">项目图片5 </td>
            <td><input type="file" name="pic" id="Pic" size="40" />
              </td>
            </tr>
        </table>
      </div>
    </div>
    </td>
    </tr>
</table>
	</td>
	</tr>
 <script type="text/javascript">
	  function multile(){
		 if(document.getElementsByName("radio").item(0).checked){
			 document.getElementById("mulite").style.display="none";
		 }else{
			 document.getElementById("mulite").style.display="";
		 }
	  }
	  multile();
	  </script>   
  <tr>
    <td colspan="8" style="border: 1px solid #cedff7;" >
    <div align="center">
      <input type="submit" name="btnSubmit" id="${btnEditText}" value="" onclick="if (checkForm()) {return true;} return false;"/>
      <input type="button" name="btnReturn" id="btnReturn" value="" onclick="window.location.href=window.location.pathname + '${pageListUrl}&pagetype=updata'" />
      </div>
      </td>
  </tr>
</table>



</form>


<div id="error" title="错误提示">
</div>
	</body>
</html>
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
<script type="text/javascript">
function checkForm()
{
    //项目编号
    //项目编号
     if($("#validateno").text()!="")
    {
    	alert("项目编号不能使用");
        document.getElementById("txtProjectidEdit").focus();
        return false;
    }
    if(document.getElementById("txtProjectidEdit") && document.getElementById("txtProjectidEdit").value == "")
    {
        alert("项目编号不能为空");
        document.getElementById("txtProjectidEdit").focus();
        return false;
    }
    if(document.getElementById("txtProjectidEdit") && !patternInteger.test(document.getElementById("txtProjectidEdit").value))
    {
        alert("项目编号只能填写整数");
        document.getElementById("txtProjectidEdit").focus();
        return false;
    }
    //项目名称
    if(document.getElementById("txtProjectnameEdit") && document.getElementById("txtProjectnameEdit").value == "")
    {
        alert("项目名称不能为空");
        document.getElementById("txtProjectnameEdit").focus();
        return false;
    }
    if(document.getElementById("txtProjectnameEdit") && getLength(document.getElementById("txtProjectnameEdit")) > 50 )
    {
        alert("项目名称的长度不能为大于50");
        document.getElementById("txtProjectnameEdit").focus();
        return false;
    }
   
    //所在地址
    if(document.getElementById("txtAddressEdit") && document.getElementById("txtAddressEdit").value == "")
    {
        alert("所在地址不能为空");
        document.getElementById("txtAddressEdit").focus();
        return false;
    }
    if(document.getElementById("txtAddressEdit") && getLength(document.getElementById("txtAddressEdit")) > 100 )
    {
        alert("所在地址的长度不能为大于100");
        document.getElementById("txtAddressEdit").focus();
        return false;
    }
     //经营状况
    if(document.getElementById("txtStateEdit") && document.getElementById("txtStateEdit").value == "")
    {
        alert("经营状况不能为空");
        document.getElementById("txtStateEdit").focus();
        return false;
    }
    if(document.getElementById("txtStateEdit") && getLength(document.getElementById("txtStateEdit")) > 50 )
    {
        alert("经营状况的长度不能为大于50");
        document.getElementById("txtStateEdit").focus();
        return false;
    }
    //创建时间
    if(document.getElementById("txtCreatetimeEdit") && document.getElementById("txtCreatetimeEdit").value == "")
    {
        alert("创建时间不能为空");
        document.getElementById("txtCreatetimeEdit").focus();
        return false;
    }
    if(document.getElementById("txtCreatetimeEdit") && !patternDate.test(document.getElementById("txtCreatetimeEdit").value))
    {
        alert("您的创建时间写错了，请修改");
        document.getElementById("txtCreatetimeEdit").focus();
        return false;
    }
    //计划时间
    if(document.getElementById("txtPlantimeEdit") && document.getElementById("txtPlantimeEdit").value == "")
    {
        alert("计划时间不能为空");
        document.getElementById("txtPlantimeEdit").focus();
        return false;
    }
    if(document.getElementById("txtPlantimeEdit") && !patternDate.test(document.getElementById("txtPlantimeEdit").value))
    {
        alert("您的计划时间写错了，请修改");
        document.getElementById("txtPlantimeEdit").focus();
        return false;
    }
    //完成时间
    if(document.getElementById("txtCompletetimeEdit").value!="" && !patternDate.test(document.getElementById("txtCompletetimeEdit").value))
    {
        alert("您的完成时间写错了，请修改");
        document.getElementById("txtCompletetimeEdit").focus();
        return false;
    }
     //总投入资金
    if(document.getElementById("txtTotalinvestEdit") && document.getElementById("txtTotalinvestEdit").value == "")
    {
        alert("总投入资金不能为空");
        document.getElementById("txtTotalinvestEdit").focus();
        return false;
    }
    if(document.getElementById("txtTotalinvestEdit") && !patternDouble.test(document.getElementById("txtTotalinvestEdit").value))
    {
        alert("总投入资金只能填写实数");
        document.getElementById("txtTotalinvestEdit").focus();
        return false;
    }
     //RealInvest
    if(document.getElementById("txtRealinvestEdit") && document.getElementById("txtRealinvestEdit").value == "")
    {
        alert("实际投入不能为空");
        document.getElementById("txtRealinvestEdit").focus();
        return false;
    }
    if(document.getElementById("txtRealinvestEdit") && !patternDouble.test(document.getElementById("txtRealinvestEdit").value))
    {
        alert("实际投入只能填写实数");
        document.getElementById("txtRealinvestEdit").focus();
        return false;
    }
    //截止去年年底完成投入资金
    if(document.getElementById("txtYearinvestEdit") && document.getElementById("txtYearinvestEdit").value == "")
    {
        alert("截止去年年底投入资金不能为空");
        document.getElementById("txtYearinvestEdit").focus();
        return false;
    }
    if(document.getElementById("txtYearinvestEdit") && !patternDouble.test(document.getElementById("txtYearinvestEdit").value))
    {
        alert("截止去年年底投入资金只能填写实数");
        document.getElementById("txtYearinvestEdit").focus();
        return false;
    }
      //计划投入资金
    if(document.getElementById("txtPlaninvestEdit") && document.getElementById("txtPlaninvestEdit").value == "")
    {
        alert("年计划投入资金不能为空");
        document.getElementById("txtPlaninvestEdit").focus();
        return false;
    }
    if(document.getElementById("txtPlaninvestEdit") && !patternDouble.test(document.getElementById("txtPlaninvestEdit").value))
    {
        alert("年计划投入资金只能填写实数");
        document.getElementById("txtPlaninvestEdit").focus();
        return false;
    }
    //政府投资
    if(document.getElementById("txtPublicinvestEdit") && document.getElementById("txtPublicinvestEdit").value == "")
    {
        alert("政府投资不能为空");
        document.getElementById("txtPublicinvestEdit").focus();
        return false;
    }
    if(document.getElementById("txtPublicinvestEdit") && !patternDouble.test(document.getElementById("txtPublicinvestEdit").value))
    {
        alert("政府投资只能填写实数");
        document.getElementById("txtPublicinvestEdit").focus();
        return false;
    }
    //自筹
    if(document.getElementById("txtSelfinvestEdit") && document.getElementById("txtSelfinvestEdit").value == "")
    {
        alert("自筹不能为空");
        document.getElementById("txtSelfinvestEdit").focus();
        return false;
    }
    if(document.getElementById("txtSelfinvestEdit") && !patternDouble.test(document.getElementById("txtSelfinvestEdit").value))
    {
        alert("自筹只能填写实数");
        document.getElementById("txtSelfinvestEdit").focus();
        return false;
    }
    //银行
    if(document.getElementById("txtBankloanEdit") && document.getElementById("txtBankloanEdit").value == "")
    {
        alert("银行不能为空");
        document.getElementById("txtBankloanEdit").focus();
        return false;
    }
    if(document.getElementById("txtBankloanEdit") && !patternDouble.test(document.getElementById("txtBankloanEdit").value))
    {
        alert("银行只能填写实数");
        document.getElementById("txtBankloanEdit").focus();
        return false;
    }
    
     //计划进度
    if(document.getElementById("txtPlanprogressEdit") && document.getElementById("txtPlanprogressEdit").value == "")
    {
        alert("计划进度不能为空");
        document.getElementById("txtPlanprogressEdit").focus();
        return false;
    }
    if(document.getElementById("txtPlanprogressEdit") && getLength(document.getElementById("txtPlanprogressEdit")) > 100 )
    {
        alert("计划进度的长度不能为大于100");
        document.getElementById("txtPlanprogressEdit").focus();
        return false;
    }
    //实际进度
    if(document.getElementById("txtRealprogressEdit") && document.getElementById("txtRealprogressEdit").value == "")
    {
        alert("实际进度不能为空");
        document.getElementById("txtRealprogressEdit").focus();
        return false;
    }
    if(document.getElementById("txtRealprogressEdit") && getLength(document.getElementById("txtRealprogressEdit")) > 50 )
    {
        alert("实际进度的长度不能为大于50");
        document.getElementById("txtRealprogressEdit").focus();
        return false;
    }
    
    //linkman
    if(document.getElementById("txtLinkmanEdit") && document.getElementById("txtLinkmanEdit").value == "")
    {
        alert("联系人不能为空");
        document.getElementById("txtLinkmanEdit").focus();
        return false;
    }
    if(document.getElementById("txtLinkmanEdit") && getLength(document.getElementById("txtLinkmanEdit")) > 50 )
    {
        alert("联系人的长度不能为大于50");
        document.getElementById("txtLinkmanEdit").focus();
        return false;
    }
    //phone
    if(document.getElementById("txtPhoneEdit") && document.getElementById("txtPhoneEdit").value == "")
    {
        alert("联系电话不能为空");
        document.getElementById("txtPhoneEdit").focus();
        return false;
    }
    if(document.getElementById("txtPhoneEdit") && getLength(document.getElementById("txtPhoneEdit")) > 11 )
    {
        alert("联系电话的长度不能为大于11");
        document.getElementById("txtPhoneEdit").focus();
        return false;
    }
    if(document.getElementById("txtPhoneEdit") && !patternMobile.test(document.getElementById("txtPhoneEdit").value))
    {
        alert("您的联系电话写错了，请修改");
        document.getElementById("txtPhoneEdit").focus();
        return false;
    }
    //项目内容
    if(document.getElementById("txtProcontentEdit") && document.getElementById("txtProcontentEdit").value == "")
    {
        alert("项目内容不能为空");
        document.getElementById("txtProcontentEdit").focus();
        return false;
    }
    if(document.getElementById("txtProcontentEdit") && getLength(document.getElementById("txtProcontentEdit")) > 500 )
    {
        alert("项目内容的长度不能为大于500");
        document.getElementById("txtProcontentEdit").focus();
        return false;
    }
  
    //comment
    if(document.getElementById("txtCommentEdit") && document.getElementById("txtCommentEdit").value == "")
    {
        alert("备注不能为空");
        document.getElementById("txtCommentEdit").focus();
        return false;
    }
    if(document.getElementById("txtCommentEdit") && getLength(document.getElementById("txtCommentEdit")) > 200 )
    {
        alert("备注的长度不能为大于200");
        document.getElementById("txtCommentEdit").focus();
        return false;
    }
   
    
    
   
    //项目特色
    if(document.getElementById("txtFeatureEdit") && document.getElementById("txtFeatureEdit").value == "")
    {
        alert("项目特色不能为空");
        document.getElementById("txtFeatureEdit").focus();
        return false;
    }
    if(document.getElementById("txtFeatureEdit") && getLength(document.getElementById("txtFeatureEdit")) > 500 )
    {
        alert("项目特色的长度不能为大于500");
        document.getElementById("txtFeatureEdit").focus();
        return false;
    }

	  return true;
}




function validateno()
{	

 var Projectno=$("#txtProjectidEdit").val();
 if(Projectno&&Projectno!="")
 {	
 	var Databaseprojectid=0;
 	if(!patternInteger.test(Projectno))
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
 	$.post("../ajax/VProjectNo.do",
 		{
 		projectid:Projectno,
 		databaseprojectid:Databaseprojectid
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

 var Projectname=$("#txtProjectnameEdit").val();

 if(Projectname&&Projectname!="")
 {		
 	 	
 
 	var Databaseprojectid=0;
 
 	
 	$.post("../ajax/VProjectName.do",
 		{
 		projectname:Projectname,
 		databaseprojectid:Databaseprojectid
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
</script>


