<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
 function PrintTalentByEducation() { 
  
  	var newlytitle=$("#TalentByEducationtitle").text();
    PrintSet(newlytitle,"TalentByEducationDiv");
    LODOP.PREVIEW();
  };
</script>
<div style="width: 100%;height: 100%">
<table border="0" cellpadding="0" cellspacing="0" id="tbListSelect" >
  <tr>
<td width="30%" style="border-right: 0px"> 年限：
  <select name="year" id="year4">
  ${YearSelect }
  </select>
  <script type="text/javascript">document.getElementById('year4').value='${year}';</script>
  </td>
    <td width="30%" style="border-left: 0px;border-right: 0px"> 学历：
    <select name="talenteducation" id="talenteducation" title="学历">
      <option value="0" selected="selected">全部</option>
	${educationtypelist}
    </select>
     <script type="text/javascript">document.getElementById('talenteducation').value='${talenteducation}';</script>
    <td width="45%" align="right" style="border-left: 0px;text-align: right;" >
      <input type="button"  id="btnGenerate"   onClick="talentbyeducation(true);"  /> 
      <input type="button"   id="btnPrint" onClick="PrintTalentByEducation();"   /> 
      <input type="button"  id="btnExcel" onclick="talentbyeducation(false);"  /> 
    </td>
  </tr>
</table>

        






<div id="TalentByEducationDiv">
<table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr>
              <td colspan="4"><div align="center" id="TalentByEducationtitle">年度人才学历结构分析</div></td>
              </tr>
            <tr>
              <td>序号</td>
                <td>
                  &nbsp;学历
                </td>
                <td>
                    &nbsp;人数
                </td>
                <td>
                    &nbsp;比例
                </td>
            </tr>
            </thead>
		
            <tbody>
            <s:iterator value="#request.infos" status="sta">
            	<tr>
                <td>&nbsp;${sta.count }</td>
                <td>${itemname }</td>
              	<s:if test="count!=0">
              	  <td>&nbsp;${count }</td>
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
              <td>&nbsp;${info.number}</td>
              <td>&nbsp;100%</td>
              </tr>
		
            </tbody></table>


    </div>
</div>



         

