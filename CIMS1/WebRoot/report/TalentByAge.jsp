<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
 function PrintTalentByAge() { 
  
  	var newlytitle=$("#TalentByAgetitle").text();
   PrintSet(newlytitle,"TalentByAgeDiv");
    LODOP.PREVIEW();
  };
</script>
<div style="width: 100%;height: 100%">
 <table border="0" cellpadding="0" cellspacing="0" id="tbListSelect" >
 
  <tr>
<td width="30%" style="border-right: 0px"> 年限
  <select name="year" id="year3">
  ${YearSelect}
  </select>
  <script type="text/javascript">document.getElementById('year3').value='${year}';</script>
  </td>
    <td width="30%" style="border-left: 0px;border-right: 0px"> 年龄：
    <select name="talentage" id="talentage" title="年龄">
      <option value="0" selected="selected">全部</option>
	${agerangelist}
    </select>
     <script type="text/javascript">document.getElementById('talentage').value='${talentage}';</script>
    <td width="45%" align="right" style="border-left: 0px;text-align: right;" >
      <input type="button"   id="btnGenerate"  onClick="talentbyage(true);"  /> 
       <input type="button"  id="btnPrint" onClick="PrintTalentByAge();"  /> 
      <input type="button"   id="btnExcel" onclick="talentbyage(false);" /> 
    </td>
  </tr>
</table>

        



	

<div id="TalentByAgeDiv">
<table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr>
              <td colspan="4"><div align="center">年度人才年龄分析</div></td>
              </tr>
            <tr>
                <td>序号
                </td>
                <td>年龄断</a>
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
                <td>
			&nbsp;${sta.count }
                </td>
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
                <td> &nbsp;${info.number }</td>
                <td>100%</td>
                </tr>
		
            </tbody>
            <tr>
            <td colspan="4"><img src="<%=basePath %>chart/talentage.do?end=<s:date name="#request.end"/>" alt="正在生成图形"/></td>
            </tr>
            </table>


    </div>
</div>
   





