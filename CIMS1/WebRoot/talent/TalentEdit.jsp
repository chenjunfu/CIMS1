<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
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
		<script type="text/javascript" src="<%=basePath %>js/c02City.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/c02_select2.js"></script>
	</head>
	<body>
${pageJavaScripStar}
${pageJavaScripNoPrives}
<form name="produceForm" id="frmEdit" method="post"  action="${btnEditCommandArgument}" >

<table border="0" cellpadding="0" cellspacing="0" id="tbEdit" align="center">
<tr><td colspan="10" style="font:+5; color:#black;text-align:center" height="30">文化人才信息${title }</td></tr>
<tr>
    <td style="width:8%;border:1px solid #cedff7;">
统计人员  </td>
    <td style="width:12%">
<select name="databasepeopleid1" style="width:95%" id="dropDatabasepeopleid1Edit" title="统计人员">
${AdminIDEdit}
</select>
<s:if test="#request.Databasepeopleid1!=null">
<script type="text/javascript">document.getElementById('dropDatabasepeopleid1Edit').value='${Databasepeopleid1}';</script>
</s:if>
</td>
 
    <td style="width:9%">
填表人员    </td>
    <td style="width:12%">
<select name="databasepeopleid2" style="width:95%" id="dropDatabasepeopleid2Edit" title="填表人员">
${AdminIDEdit}
</select>
<s:if test="#request.Databasepeopleid2!=null">
<script type="text/javascript">document.getElementById('dropDatabasepeopleid2Edit').value='${Databasepeopleid2}';</script> 
</s:if>
   </td>
  
    <td style="width:9%">
登录人员    </td>
    <td>
<s:property value="#session.AdminUserInfoadminname" />
  
 
 <input name="adminid" type="hidden" id="txtAdminidEdit"  title="登录人员" size="8" maxlength="8"
value="<s:property value="#session.AdminUserInfodatabaseadminid" />"
 />   
 
 </td>
  
    <td style="width:6%">
部  门    </td>
    <td>
${AdminUserInfosectorname}
<input name="sectorid" type="hidden" id="txtAdminidEdit"  title="" size="8" maxlength="8"
value="<s:property value="#session.AdminUserInfosectorid" />"
 /> 

 </td>
  
    <td style="width:9%">
登录时间 </td>
    <td>

<label>${Logintime}</label>
</td>
  </tr>
</table>


<table border="0" cellpadding="0" cellspacing="0" id="tbEdit" align="center" >
  <tr>
      <td> 编号 </td>
    <td>
    <input type="hidden" name="databasetalentid" value="${Databasetalentid }" id="databasetalentid" />
    <input type="text" name="talentid" value="${Talentid }" id="txtTalentidEdit" onblur="validateno()"/>
    <div id="validateno" style="color: red;display: none;"></div>
    </td>
    <td> 姓名 </td>
    <td>
    <input name="talentname" type="text" id="txtTalentnameEdit" value="${Talentname}" title="姓名" size="20" maxlength="50" /></td>
    <td> 性别 </td>
    <td align="left"><label>
      <input type="radio" checked="checked" value="1" name="sex" />
      男　 </label>
        <label>
        <input type="radio" id="sex2" value="2" name="sex"  />
          女 </label>
          </td>
          <s:if test="#request.Sex==2">
           <script type="text/javascript">
          	 $("#sex2").attr({checked:"checked"})
          </script>
          </s:if>
         
      </tr>
  <tr>
    <td> 出生日期 </td>
    <td><input name="birthday" type="text" id="txtBirthdayEdit" value="${Birthday}" title="出生日期" size="20" maxlength="20" /></td>
    <td> 籍贯 </td>
    <td><input name="nativeplace" type="text" id="txtNativeplaceEdit" value="${Nativeplace}" title="籍贯" size="20" maxlength="50" />    </td>
    <td> 民族 </td>
    <td><select name="nationid"  style="width:154px" id="dropNationidEdit" title="民族">
      
${NationidEdit}

    </select>
    <s:if test="#request.Nationid!=null">
            <script type="text/javascript">document.getElementById('dropNationidEdit').value='${Nationid}';</script>  
    </s:if>
  </td>
  </tr>
  <tr>
    <td> 省份 </td>
    <td><select name="provinceid"  style="width:154px" id="dropProvinceidEdit" title="省份">
${ProvinceidEdit}
    </select>
    <s:if test="#request.Provinceid!=null">
    <script type="text/javascript">document.getElementById('dropProvinceidEdit').value='${Provinceid}';</script>
    </s:if>
   
        </td>
    <td> 地区 </td>
    <td><select name="cityid"  style="width:154px" id="dropCityidEdit" title="用户地区">
${CityidEdit}
    </select>
     <s:if test="#request.Cityid!=null">
         <script type="text/javascript">document.getElementById('dropCityidEdit').value='${Cityid}';</script>  
     </s:if>
      </td>
     <td> 人才所属行业 </td>
    <td>
    <select name="talentprofessionid" style="width:154px" id="dropTalentprofessionidEdit" title="人才所属行业">
${BusinesstypeidEdit}
    </select>
    <s:if test="#request.Talentprofessionid!=null">
    <script type="text/javascript">document.getElementById('dropTalentprofessionidEdit').value='${Talentprofessionid}';</script>
    </s:if>
     </td>
    </tr>
  <tr>
    <td> 学位 </td>
    <td><select name="degreeid" style="width:154px" id="dropDegreeidEdit" title="学位">
      
${DegreeidEdit}

    </select>
      <s:if test="#request.Degreeid!=null">
      <script type="text/javascript">document.getElementById('dropDegreeidEdit').value='${Degreeid}';</script>  
      </s:if>
          </td>
    <td> 专业 </td>
    <td><select name="majorid" id="dropMajoridEdit"  style="width:154px" title="专业">
      
${MajoridEdit}

    </select>
    <s:if test="#request.Majorid!=null">
    <script type="text/javascript">document.getElementById('dropMajoridEdit').value='${Majorid}';</script>    
    </s:if>
        </td>
    <td> 学历 </td>
    <td><select name="educationid" style="width:154px" id="dropEducationidEdit" title="学历">
      
${EducationidEdit}

    </select>
    <s:if test="#request.Educationid!=null">
     <script type="text/javascript">document.getElementById('dropEducationidEdit').value='${Educationid}';</script>  
    </s:if>
         </td>
 
  </tr>
  <tr>
    <td> 手机 </td>
    <td><input name="movephone" type="text" id="txtMovephoneEdit" value="${Movephone}" title="手机" size="20" maxlength="20" />    </td>
    <td> 邮箱 </td>
    <td><input name="email" type="text" id="txtEmailEdit" value="${Email}" title="邮箱" size="20" maxlength="50" />    </td>
	
	<td> 职称 </td>
    <td >
    <select name="posttitleid"  style="width:154px" id="dropPosttitleidEdit" title="职称">
${PosttitleidEdit}
    </select>
       <s:if test="#request.Educationid!=null">
       
               <script type="text/javascript">document.getElementById('dropPosttitleidEdit').value='${Posttitleid}';</script>   
       </s:if>
 </td>
	 </tr>
  	<tr>
    <td> 工作单位 </td>
    <td ><input name="workunit" type="text" id="txtWorkunitEdit" value="${Workunit}" title="工作单位" size="20" maxlength="100" />    </td>
    <td> 现在住址 </td>
    <td ><input name="adress" type="text" id="txtAdressEdit" value="${Adress}" title="现在住址" size="20" maxlength="100" />    </td>
	<td> 政治面貌 </td>
    <td><input name="politicsstatus" type="text" id="txtPoliticsstatusEdit" value="${Politicsstatus}" title="政治面貌" size="20" maxlength="50" />    </td>
	 
  </tr>
  
  <tr>
    <td> 工作经历 </td>
    <td colspan="5"><textarea name="workexperience" id="txtWorkexperienceEdit" cols="75"  rows="3" title="工作经历">${Workexperience}</textarea>    </td>
  </tr>
  <tr>
    <td> 个人学习经历 </td>
    <td colspan="5"><textarea name="learnexperience" id="txtLearnexperienceEdit" cols="75" rows="3" title="个人学习经历">${Learnexperience}</textarea></td>
  </tr>
  <tr>
    <td> 业绩 </td>
    <td colspan="5"><textarea name="acheivement" id="txtAcheivementEdit" cols="75" rows="3" title="业绩">${Acheivement}</textarea></td>
  </tr>
  <tr>
    <td> 荣誉 </td>
    <td colspan="5"><textarea name="honor" id="txtHonorEdit" cols="75" rows="3" title="荣誉">${Honor}</textarea>    </td>
  </tr>
  <tr>
    <td> 专长 </td>
    <td colspan="5"><textarea name="skills" id="txtSkillsEdit" cols="75" rows="3" title="专长">${Skills}</textarea>    </td>
  </tr>
  <tr>
    <td colspan="6" align="center"><div align="center">
      <input type="submit" name="btnSubmit" id="${btnEditText }" value="" onclick="if (checkForm()) {return true;} return false;"/>
      <input type="button" name="btnReturn" id="btnReturn" value="" onclick="window.location.href='${pageListUrl}'" />
    </div></td>
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
$("#txtBirthdayEdit").datepicker({changeMonth: true,changeYear: true,yearRange:'-60:+0'}); //出生日期

</script>
<s:if test="#request.Provinceid!=null">
<script type="text/javascript">
var jjlCity=new c02_class_ld(act,"dropProvinceidEdit","dropCityidEdit"); //设置数据源
jjlCity.init("0","${Provinceid}","${Cityid}");//初始化数据源
</script>
</s:if>
<s:else>
<script type="text/javascript">
var jjlCity=new c02_class_ld(act,"dropProvinceidEdit","dropCityidEdit"); //设置数据源
jjlCity.init("0","16","238");//初始化数据源
</script>
</s:else>
<script type="text/javascript">
function checkForm()
{

    //人才编号
    if($("#validateno").text()!="")
    {
    	alert("人才编号不能使用");
        document.getElementById("txtTalentidEdit").focus();
        return false;
    }
    if(document.getElementById("txtTalentidEdit") && document.getElementById("txtTalentidEdit").value == "")
    {
        alert("人才编号不能为空");
        document.getElementById("txtTalentidEdit").focus();
        return false;
    }
    if(document.getElementById("txtTalentidEdit") && !patternInteger.test(document.getElementById("txtTalentidEdit").value))
    {
        alert("人才编号只能填写整数");
        document.getElementById("txtTalentidEdit").focus();
        return false;
    }
    //姓名
    if(document.getElementById("txtTalentnameEdit") && document.getElementById("txtTalentnameEdit").value == "")
    {
        alert("姓名不能为空");
        document.getElementById("txtTalentnameEdit").focus();
        return false;
    }
    if(document.getElementById("txtTalentnameEdit") && getLength(document.getElementById("txtTalentnameEdit")) > 50 )
    {
        alert("姓名的长度不能为大于50");
        document.getElementById("txtTalentnameEdit").focus();
        return false;
    }

    //出生日期
    if(document.getElementById("txtBirthdayEdit") && document.getElementById("txtBirthdayEdit").value == "")
    {
        alert("出生日期不能为空");
        document.getElementById("txtBirthdayEdit").focus();
        return false;
    }
    if(document.getElementById("txtBirthdayEdit") && !patternDate.test(document.getElementById("txtBirthdayEdit").value))
    {
        alert("您的出生日期写错了，请修改");
        document.getElementById("txtBirthdayEdit").focus();
        return false;
    }
  
    //籍贯
    if(document.getElementById("txtNativeplaceEdit") && document.getElementById("txtNativeplaceEdit").value == "")
    {
        alert("籍贯不能为空");
        document.getElementById("txtNativeplaceEdit").focus();
        return false;
    }
    if(document.getElementById("txtNativeplaceEdit") && getLength(document.getElementById("txtNativeplaceEdit")) > 50 )
    {
        alert("籍贯的长度不能为大于50");
        document.getElementById("txtNativeplaceEdit").focus();
        return false;
    }
      //手机
    if(document.getElementById("txtMovephoneEdit") && document.getElementById("txtMovephoneEdit").value == "")
    {
        alert("手机不能为空");
        document.getElementById("txtMovephoneEdit").focus();
        return false;
    }
    if(document.getElementById("txtMovephoneEdit") && getLength(document.getElementById("txtMovephoneEdit")) > 20 )
    {
        alert("手机的长度不能为大于20");
        document.getElementById("txtMovephoneEdit").focus();
        return false;
    }
    if(document.getElementById("txtMovephoneEdit") && !patternMobile.test(document.getElementById("txtMovephoneEdit").value))
    {
        alert("您的手机写错了，请修改");
        document.getElementById("txtMovephoneEdit").focus();
        return false;
    }
        //邮箱
    if(document.getElementById("txtEmailEdit") && document.getElementById("txtEmailEdit").value == "")
    {
        alert("邮箱不能为空");
        document.getElementById("txtEmailEdit").focus();
        return false;
    }
    if(document.getElementById("txtEmailEdit") && getLength(document.getElementById("txtEmailEdit")) > 50 )
    {
        alert("邮箱的长度不能为大于50");
        document.getElementById("txtEmailEdit").focus();
        return false;
    }
    if(document.getElementById("txtEmailEdit") && !patternEmail.test(document.getElementById("txtEmailEdit").value))
    {
        alert("您的邮箱写错了，请修改");
        document.getElementById("txtEmailEdit").focus();
        return false;
    }
     //工作单位
    if(document.getElementById("txtWorkunitEdit") && document.getElementById("txtWorkunitEdit").value == "")
    {
        alert("工作单位不能为空");
        document.getElementById("txtWorkunitEdit").focus();
        return false;
    }
    if(document.getElementById("txtWorkunitEdit") && getLength(document.getElementById("txtWorkunitEdit")) > 50 )
    {
        alert("工作单位的长度不能为大于50");
        document.getElementById("txtWorkunitEdit").focus();
        return false;
    }
    
    
     //现在住址
    if(document.getElementById("txtAdressEdit") && document.getElementById("txtAdressEdit").value == "")
    {
        alert("现在住址不能为空");
        document.getElementById("txtAdressEdit").focus();
        return false;
    }
    if(document.getElementById("txtAdressEdit") && getLength(document.getElementById("txtAdressEdit")) > 50 )
    {
        alert("现在住址的长度不能为大于50");
        document.getElementById("txtAdressEdit").focus();
        return false;
    }

    //政治面貌
    if(document.getElementById("txtPoliticsstatusEdit") && document.getElementById("txtPoliticsstatusEdit").value == "")
    {
        alert("政治面貌不能为空");
        document.getElementById("txtPoliticsstatusEdit").focus();
        return false;
    }
    if(document.getElementById("txtPoliticsstatusEdit") && getLength(document.getElementById("txtPoliticsstatusEdit")) > 50 )
    {
        alert("政治面貌的长度不能为大于50");
        document.getElementById("txtPoliticsstatusEdit").focus();
        return false;
    }
  
  
  
  
   
    //工作经历
    if(document.getElementById("txtWorkexperienceEdit") && document.getElementById("txtWorkexperienceEdit").value == "")
    {
        alert("工作经历不能为空");
        document.getElementById("txtWorkexperienceEdit").focus();
        return false;
    }
    if(document.getElementById("txtWorkexperienceEdit") && getLength(document.getElementById("txtWorkexperienceEdit")) > 200 )
    {
        alert("工作经历的长度不能为大于200");
        document.getElementById("txtWorkexperienceEdit").focus();
        return false;
    }
    //个人学习经历
    if(document.getElementById("txtLearnexperienceEdit") && document.getElementById("txtLearnexperienceEdit").value == "")
    {
        alert("个人学习经历不能为空");
        document.getElementById("txtLearnexperienceEdit").focus();
        return false;
    }
    if(document.getElementById("txtLearnexperienceEdit") && getLength(document.getElementById("txtLearnexperienceEdit")) > 200 )
    {
        alert("个人学习经历的长度不能为大于200");
        document.getElementById("txtLearnexperienceEdit").focus();
        return false;
    }
    //业绩
    if(document.getElementById("txtAcheivementEdit") && document.getElementById("txtAcheivementEdit").value == "")
    {
        alert("业绩不能为空");
        document.getElementById("txtAcheivementEdit").focus();
        return false;
    }
    if(document.getElementById("txtAcheivementEdit") && getLength(document.getElementById("txtAcheivementEdit")) > 200 )
    {
        alert("业绩的长度不能为大于200");
        document.getElementById("txtAcheivementEdit").focus();
        return false;
    }
    //荣誉
    if(document.getElementById("txtHonorEdit") && document.getElementById("txtHonorEdit").value == "")
    {
        alert("荣誉不能为空");
        document.getElementById("txtHonorEdit").focus();
        return false;
    }
    if(document.getElementById("txtHonorEdit") && getLength(document.getElementById("txtHonorEdit")) > 200 )
    {
        alert("荣誉的长度不能为大于200");
        document.getElementById("txtHonorEdit").focus();
        return false;
    }
    //专长
    if(document.getElementById("txtSkillsEdit") && document.getElementById("txtSkillsEdit").value == "")
    {
        alert("专长不能为空");
        document.getElementById("txtSkillsEdit").focus();
        return false;
    }
    if(document.getElementById("txtSkillsEdit") && getLength(document.getElementById("txtSkillsEdit")) > 200 )
    {
        alert("专长的长度不能为大于200");
        document.getElementById("txtSkillsEdit").focus();
        return false;
    }
	  return true;
}


function validateno()
{
 var Talentno=$("#txtTalentidEdit").val();
 if(Talentno&&Talentno!="")
 {	
 	var Databasetalentid=$("#databasetalentid").val();
 	if(!patternInteger.test(Talentno))
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
 	if(Databasetalentid&&Databasetalentid=="")
 	{
 		Databasetalentid=0;
 	}
 	$.post("../ajax/VTalentNo.do",
 		{
 		talentid:Talentno,
 		databasetalentid:Databasetalentid
 		},
 		function(data)
 		{
 			var Message=1;
 			eval(data);
 			if(Message==0)
 			{
 				$('#validateno').text('已经存在');
 				$('#validateno').css({display:"block"})		
 			}
 			else
 			{	
 				$('#validateno').text('');
 				$('#validateno').css({display:"none"})
 			　  
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



</script>





