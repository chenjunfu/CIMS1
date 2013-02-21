<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
 function PrintTalentByType() { 
 
  	var newlytitle=$("#TalentByTypetitle").text();
 	PrintSet(newlytitle,"TalentByTypeDiv");
    LODOP.PREVIEW();
  };
</script>
<div style="width: 100%;height: 100%">
 <table border="0" cellpadding="0" cellspacing="0" id="tbListSelect" >
  <tr>
<td width="30%" style="border-right: 0px"> 年限：
  <select name="year" id="year2">
  ${YearSelect }
  </select>
  <script type="text/javascript">document.getElementById('year2').value='${year}';</script>
  </td>
    <td width="30%" style="border-left: 0px;border-right: 0px"> 类型：
    <select name="talenttype" id="talenttype" title="类型">
      <option value="0" selected="selected">全部</option>
		${talenttypelist}
    </select>
    <script type="text/javascript">document.getElementById('talenttype').value='${talenttype}';</script>
     </td>
    <td width="45%" align="right" style="border-left: 0px;text-align: right;" >
      <input type="button"   id="btnGenerate"   onClick="talentbytype(true);"   /> 
       <input type="button"    id="btnPrint" onClick="PrintTalentByType();"   /> 
      <input type="button"   id="btnExcel" onclick="talentbytype(false);" /> 
    </td>
  </tr>
</table>


<div id="TalentByTypeDiv">
<table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr>
              <td colspan="4"><div align="center" id="TalentByTypetitle">年度人才行业统计</div></td>
              </tr>
            <tr>
                <td>序号
                </td>
                <td>
                    &nbsp;行业类别
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
            <s:iterator var="iteList" value="#request.infos" status="sta">
            	<tr>
                <td>
			&nbsp;${sta.count}
                </td>
                <td>&nbsp;${iteList.itemname }</td>
                
                <s:if test="#iteList.count!=0">
                	<td>&nbsp;${iteList.count }</td>
                </s:if>
                <s:else>
                <td>
					&nbsp;
                </td>
                </s:else>
                <s:if test="#iteList.count!=0">
                	<td>&nbsp;${iteList.percent}%</td>
                </s:if>
                <s:else>
                <td>
					&nbsp;
                </td>
                </s:else>
                
                
               
            </tr>
		
        
		
            </s:iterator>
            
		
            <tr>
                <td>
			&nbsp;合计
                </td>
                <td>&nbsp;</td>
                <td>
			&nbsp;${info.number }</td>
                <td>&nbsp;100%</td>
                
               
            </tr>
		
            </tbody></table>


    </div>


   
</div>
   


