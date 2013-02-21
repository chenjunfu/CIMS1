<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
	width:475px;
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
<form name="produceForm" id="frmEditPic" method="post" enctype="multipart/form-data" action="cultureproduce/Projectpic.do?pagetype=insert" >

<table border="0" cellpadding="0" cellspacing="0" id="tbEditk" style="border: 0px solid; margin: 0px;padding: 0px">
  <tr>
  	
    <td style="border-left: 1px solid #cedff7;"  width="167" align="center" ><div align="center">
    
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
  <tr>
   <td colspan="4" style="border-left: 1px solid #cedff7;">
   <div  style="display:block;vertical-align:top;top:0">
   <div align="center"  >
      <table width="85%" cellpadding="0" cellspacing="0" id="tbEditk">
        <tr>
          <td width="13%"> 项目图片1 </td>
          <td  width="46%"><input type="file" name="filepic" id="filePic" size="40" />
            <input name="pic" type="hidden" id="hidPicEdit" value="${Pic}" title="项目图片" size="60" maxlength="100" />
            ${PicHtml} </td>
        </tr></table>
        </div>
    </div>
    </td>
    </tr>
  <tr>
    <td colspan="4">
    <div id="mulite" style="display:none;vertical-align:top;top:0">
      <div align="center"  >
        <table cellpadding="0" cellspacing="0" id="tbEditk" width="85%">
          <tr>
            <td width="13%" style="border-left: 1px solid #cedff7;" >项目图片2</td>
            <td width="46%" ><input type="file" name="filepic1" id="filePic1" size="40" />
              <input name="pic1" type="hidden" id="hidPicEdit" value="" title="项目图片" size="60" maxlength="100" />
              ${PicHtml} </td>
            </tr>
          <tr>
            <td style="border-left: 1px solid #cedff7;">项目图片3 </td>
            <td><input type="file" name="filepic2" id="filePic2" size="40" />
              <input name="pic2" type="hidden" id="hidPicEdit" value="${Pic}" title="项目图片" size="60" maxlength="100" />
              ${PicHtml} </td>
            </tr>
          <tr>
            <td style="border-left: 1px solid #cedff7;">项目图片4 </td>
            <td><input type="file" name="filepic3" id="filePic3" size="40" />
              <input name="pic3" type="hidden" id="hidPicEdit" value="${Pic}" title="项目图片" size="60" maxlength="100" />
              ${PicHtml} </td>
            </tr>
          <tr>
            <td style="border-left: 1px solid #cedff7;">项目图片5 </td>
            <td><input type="file" name="filepic4" id="filePic4" size="40" />
              <input name="pic4" type="hidden" id="hidPicEdit" value="${Pic}" title="项目图片" size="60" maxlength="100" />
              ${PicHtml} </td>
            </tr>
        </table>
      </div>
    </div></td>
    </tr>

</table>

</form>