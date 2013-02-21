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

		<title>文化人才信息登录</title>

		<link rel="stylesheet" type="text/css" href="/css/AdminCss.css" />
		<link rel="stylesheet" type="text/css" href="/css/smoothness/jquery-ui.css" />
		<script type="text/javascript" src="/js/colorwinglib.js"></script>
		<script type="text/javascript" src="/js/jquery.js"></script>
		<script type="text/javascript" src="/js/jquery-ui.js"></script>

	</head>
<body>
${pageJavaScripStar}<form name="produceForm" id="frmEdit" method="post"  action="${btnEditCommandArgument}" >
  <table border="0" cellpadding="0" cellspacing="0" id="tbEdit">
  <tr><td colspan="10" align="center" style="font:+1; color:#0033ff" height="30">文化人才信息登录</font></td></tr>

    <tr>
      <td width="8%" height="5"> 统计人员 </td>
      <td width="8%"><select name="select" id="select" title="统计人员" style="width:100px">  
${EducationidEdit} 
      </select>      </td>
      <td width="8%"> 填表人员 </td>
      <td width="8%"><select name="select2" id="select2" title="填表人员" style="width:80px">
        
      
${EducationidEdit}

    
      </select>      </td>
    
      <td width="8%"> 登录人员 </td>
      <td width="7%"><input name="talentid" type="text" id="txtTalentidEdit" value="${Talentid}" title="人才编号" size="5" maxlength="8" />      </td>
      <td width="6%"> 部门 </td>
      <td width="8%"><input name="talentid" type="text" id="txtTalentidEdit" value="${Talentid}" title="部门" size="5" maxlength="8" />      </td>
    
      <td width="8%"> 登录时间 </td>
	  <td width="8%">
      <input name="talentid2" type="text" id="talentid" value="${Talentid}" title="登录时间" size="5" maxlength="8" /></td>

    </tr>
  </table></br>
	<table border="0" cellpadding="0" cellspacing="0" id="tbEdit" width="100%">
	
      <tr>
        <td> 姓名 </td>
        <td><input name="talentname" type="text" id="txtTalentnameEdit" value="${Talentname}" title="姓名" size="20" maxlength="20" />        </td>
        <td> 出生日期 </td>
        <td><input name="birthday" type="text" id="txtBirthdayEdit" value="${Birthday}" title="出生日期" size="20" maxlength="20" />        </td>
      </tr>
      <tr>
        <td> 民族</td>
        <td><select name="select3" id="select3" title="民族" style="width:100px">       
${EducationidEdit}
      </select>
        <script type="text/javascript">document.getElementById('dropEducationidEdit').value='${Educationid}';</script>        </td>
        <td> 性别 </td>
        <td align="left"><label><input type="radio" checked="checked" value="0" name="sex" />
                男　　 </label>
                  <label>
                  <input type="radio" value="1" name="sex" />
                    女 </label></td>
      </tr>
      <tr>
        <td> 政治面貌 </td>
        <td><input name="politicsstatus" type="text" id="txtPoliticsstatusEdit" value="${Politicsstatus}" title="政治面貌" size="20" maxlength="50" />        </td>
        <td> 毕业院校 </td>
        <td><input name="graduateschool" type="text" id="txtGraduateschoolEdit" value="${Graduateschool}" title="毕业院校" size="20" maxlength="50" />        </td>
      </tr>
      <tr>
        <td> 省份 </td>
        <td><input name="province" type="text" id="txtProvinceEdit" value="${Province}" title="省份" size="20" maxlength="8" />        </td>
        <td> 城市 </td>
        <td><input name="city" type="text" id="txtCityEdit" value="${City}" title="城市" size="20" maxlength="20" />        </td>
      </tr>
      <tr>
        <td> 学历</td>
        <td><select name="educationid" id="dropEducationidEdit" title="学历" style="width:100px">
          
        
${EducationidEdit}

      
        </select>
            <script type="text/javascript">document.getElementById('dropEducationidEdit').value='${Educationid}';</script>        </td>
        <td> 专业</td>
        <td><select name="majorid" id="dropMajoridEdit" title="专业" style="width:100px">
          
        
${MajoridEdit}

      
        </select>
            <script type="text/javascript">document.getElementById('dropMajoridEdit').value='${Majorid}';</script>        </td>
      </tr>
      <tr>
        <td> 专长</td>
        <td><select name="skillid" id="dropSkillidEdit" title="专长" style="width:100px">
          
        
${SkillidEdit}

      
        </select>
            <script type="text/javascript">document.getElementById('dropSkillidEdit').value='${Skillid}';</script>        </td>
        <td> 职称级别</td>
        <td><select name="posttitleid" id="dropPosttitleidEdit" title="职称级别" style="width:100px">
          
        
${PosttitleidEdit}

      
        </select>
            <script type="text/javascript">document.getElementById('dropPosttitleidEdit').value='${Posttitleid}';</script>        </td>
      </tr>
      <tr>
        <td> 职务 </td>
        <td><input name="duties" type="text" id="txtDutiesEdit" value="${Duties}" title="职务" size="20" maxlength="50" />        </td>
        <td> 电话 </td>
        <td><input name="phone" type="text" id="txtPhoneEdit" value="${Phone}" title="电话" size="20" maxlength="20" />        </td>
      </tr>
      <tr>
        <td> 手机 </td>
        <td><input name="movephone" type="text" id="txtMovephoneEdit" value="${Movephone}" title="手机" size="20" maxlength="20" />        </td>
        <td> 邮箱 </td>
        <td><input name="email" type="text" id="txtEmailEdit" value="${Email}" title="邮箱" size="20" maxlength="50" />        </td>
      </tr>
      <tr>
        <td> 住址 </td>
        <td><input name="address" type="text" id="txtAddressEdit" value="${Address}" title="住址" size="20" maxlength="50" />        </td>
        <td>工作单位</td>
        <td><input name="learnexperience" type="text" id="txtLearnexperienceEdit" value="${Learnexperience}" title="工作单位" size="20" maxlength="200" />        </td>
      </tr>
      <tr>
        <td>个人学习经历</td>
        <td colspan="3"><textarea name="txtSocialbenefitEdit2" cols="40" rows="3" id="txtSocialbenefitEdit" title="个人学习经历"></textarea></td>
	  </tr><tr>
        <td> 主要工作经历 </td>
        <td colspan="3"><textarea name="txtSocialbenefitEdit2" cols="40" rows="3" id="txtSocialbenefitEdit" title="主要工作经历"></textarea></td>
      </tr>
      <tr>
        <td> 业绩 </td>
        <td colspan="3"><textarea name="txtSocialbenefitEdit2" cols="40" rows="3" id="txtSocialbenefitEdit" title="业绩"></textarea></td>
	  </tr><tr>
        <td> 荣誉 </td>
        <td colspan="3"><textarea name="textarea" cols="40" rows="3" id="textarea" title="荣誉"></textarea></td>
		</tr>
      <tr>
        
        <td colspan="5" align="center"><div align="center"><input type="submit" name="btnSubmit" id="btnSubmit" value="保存" onclick="if (checkForm()) {return true;} return false;"/>
        <input name="button" type="button"  id="btnReturn"  onclick="window.location.href=window.location.pathname + '?${pageListUrl}'" value=" " /></div></td>
      </tr>
    </table>
</form>
${pageJavaScripEnd}
</body>
</html>

<script type="text/javascript">
//编辑页面初始化日期控件
$("#txtBirthdayEdit").datepicker({changeMonth: true,changeYear: true}); //出生日期
</script>
