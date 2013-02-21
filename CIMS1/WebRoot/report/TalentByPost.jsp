<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

<body>
<script type="text/javascript">
 function PrintTalentByPost() { 
  
  	var newlytitle=$("#TalentByPosttitle").text();
   	PrintSet(newlytitle,"TalentByPostDiv");
   	console.log($("#TalentByPostDiv").html());
    LODOP.PREVIEW();
  };
</script>
<div style="width: 100%;height: 100%">
  <table border="0" cellpadding="0" cellspacing="0" id="tbListSelect" >
 
  <tr>
<td width="30%" style="border-right: 0px"> 年限：
  <select name="year" id="year5">
  ${YearSelect}
  </select>
  <script type="text/javascript">document.getElementById('year5').value='${year}';</script>
  </td>
    <td width="30%" style="border-left: 0px;border-right: 0px"> 职称：
    <select name="talentpost" id="talentpost" title="职称">
      <option value="0" selected="selected">全部</option>
	${posttypelist}
    </select>
    <script type="text/javascript">document.getElementById('talentpost').value='${talentpost}';</script>
     </td>
    <td width="45%" align="right" style="border-left: 0px;text-align: right;" >
      <input type="button"   id="btnGenerate"   onClick="talentbypost(true);"   /> 
      <input type="button"  id="btnPrint" onClick="PrintTalentByPost();"   /> 
      <input type="button"   id="btnExcel" onclick="talentbypost(false);"  /> 
    </td>
  </tr>
</table>
      
<div id="TalentByPostDiv">
<table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr>
              <td colspan="4"><div align="center" id="TalentByPosttitle">年度人才职称结构分析</div></td>
              </tr>
            <tr>
              <td width="25%">&nbsp;序号</td>
                <td width="25%">&nbsp;职称</td>
                <td width="25%">&nbsp;人数</td>
                <td width="25%">&nbsp;比例</td>
            </tr>
            </thead>
            <tbody>
		 <s:iterator value="#request.infos" status="sta">
            	<tr>
                <td>&nbsp;${sta.count }</td>
                <td>${itemname }</td>
              	<s:if test="count!=0">
              	  <td>&nbsp;${count}</td>
              	</s:if>
              	<s:else>
              	<td>&nbsp;</td>
              	</s:else>
                <s:if test="count!=0">
              	  <td>&nbsp;${percent }%</td>
             	</s:if>
              	<s:else>
              	<td>&nbsp;</td>
             	 </s:else>
                </tr>
            </s:iterator>
            
            <tr>
                <td>
			&nbsp;合计
                </td>
                <td>&nbsp;</td>
                <td> &nbsp;${info.number}</td>
                <td>&nbsp;100%</td>
                </tr>
            </tbody></table>
    </div>
</div>
</body>
  </html>


 