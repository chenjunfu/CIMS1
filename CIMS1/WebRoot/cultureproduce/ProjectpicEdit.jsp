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

		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/css.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath %>css/AdminCss.css" />
		<script type="text/javascript" src="<%=basePath %>js/colorwinglib.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery-ui.js"></script>
<style type="text/css">
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
	width:800px;
	text-align:center;
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
}
#tbEditk tr td {
	border-top-width: 1px;
	border-right-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-top-color: #b0d8f2;
	border-right-color: #b0d8f2;
	padding: 5px;
	text-align: left;
	font-size: 14px;
}

</style>
	</head>
	<body class="bb">
<form name="produceForm" id="frmEdit" method="post" enctype="multipart/form-data" action="cultureproduce/Projectpic.do?pagetype=insert" >
<table>
 <tr width="30px">
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
   
   
  </tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" id="tbEditk">
  <tr>
  
    <td width="161" align="center" ><div align="center">
      <input name="radio" type="radio" id="danfile" value="1" checked="checked" onclick="multile();"/>
      <label for="danfile">单文件上传</label>
    </div></td>
    <td width="603"  align="left">&nbsp;
      <input name="radio" type="radio" value="2" onclick="multile();" />
      <label for="danfile1">多文件上传</label></td>
       <script type="text/javascript">
	  function multile(){
		 if(document.getElementsByName("radio").item(0).checked){
			 document.getElementById("mulite").style.display="none";
		 }else{
			 document.getElementById("mulite").style.display="";
		 }
	  }
	  </script>    </tr>
  <tr><td colspan="2">
    <div align="center" style="border:none">
      <table width="85%">
        <tr>
          <td width="13%"> 项目图片1 </td>
          <td  width="46%"><input type="file" name="filepic" id="filePic" size="40" />
            <input name="pic" type="hidden" id="hidPicEdit" value="${Pic}" title="项目图片" size="60" maxlength="100" />
            ${PicHtml} </td>
        </tr></table>
    </div></td>
    </tr>
  <tr>
    <td colspan="4"><div id="mulite" style="display:none;vertical-align:top;top:0">
      <div align="center"  >
        <table align="" width="85%">
          <tr>
            <td width="13%" >项目图片2</td>
            <td width="46%" ><input type="file" name="filepic1" id="filePic1" size="40" />
              <input name="pic1" type="hidden" id="hidPicEdit" value="" title="项目图片" size="60" maxlength="100" />
              ${PicHtml} </td>
            </tr>
          <tr>
            <td>项目图片3 </td>
            <td><input type="file" name="filepic2" id="filePic2" size="40" />
              <input name="pic2" type="hidden" id="hidPicEdit" value="${Pic}" title="项目图片" size="60" maxlength="100" />
              ${PicHtml} </td>
            </tr>
          <tr>
            <td>项目图片4 </td>
            <td><input type="file" name="filepic3" id="filePic3" size="40" />
              <input name="pic3" type="hidden" id="hidPicEdit" value="${Pic}" title="项目图片" size="60" maxlength="100" />
              ${PicHtml} </td>
            </tr>
          <tr>
            <td>项目图片5 </td>
            <td><input type="file" name="filepic4" id="filePic4" size="40" />
              <input name="pic4" type="hidden" id="hidPicEdit" value="${Pic}" title="项目图片" size="60" maxlength="100" />
              ${PicHtml} </td>
            </tr>
        </table>
      </div>
    </div></td>
    </tr>
  <tr>
    <td colspan="4" align="center">
    <div align="center">
    <input type="submit" name="btnSubmit" id="btnSubmit" value="上传" onclick="if (checkForm()) {return true;} return false;"/>
    <input type="button" name="btnReturn" id="btnReturn" value="" onclick="window.close();" /></div>
    </td>
  </tr>
</table>

</form>

	</body>
</html>
