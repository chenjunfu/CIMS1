<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
 function PrintProTotalInvest() { 
    var chartTitle=$("#ProTotalInvestTitle").text();
    PrintSet(chartTitle,"ProTotalInvestDiv");
    LODOP.PREVIEW();
  };
</script>
<div style="width: 100%;height: 100%">
<table border="0" cellpadding="0" cellspacing="0" id="tbListSelect" >
  <tr>
    <td width="50%" style="border-right: 0px"> 年限：
   <select name="year" id="year4">
     ${YearSelect }
   </select>
   <script>
   	document.getElementById("year4").value='${year}'
   </script>
  </td>
  

    <td width="50%" align="right" style="border-left: 0px;text-align: right;" >
      <input type="button"   id="btnGenerate"  onClick="totalinvest(true);"  /> 
      <input type="button"   id="btnPrint" onClick="PrintProTotalInvest();"   /> 
      <input type="button"  id="btnExcel" onclick="totalinvest(false)"  /> 
    </td>
  </tr>
</table>

<div id="ProTotalInvestDiv">
<table border="0" cellpadding="0" cellspacing="0" id="tbList" >
            <thead>
          <tr>
			<td style="text-align: center; border: 0px" colspan="8" ><b id="ProTotalInvestTitle" >年度项目投资总额统计分析表</b></td>
			      
			</tr>
            <tr>
            	<td>
            		    序号
            	</td>

                <td>
                    	项目名称
                </td>
                <td  >
                                                        开始时间
                </td>
                <td>
                	  结束时间
                </td>
                <td>	
                   	         计划总投资
                </td>
                <td>
                                                              今年计划投资
                </td>
                <td>
                     	实际已完成投资
                </td>
                <td> 
                	          今年已完成投资
                </td>
               
            </tr>
            </thead>
		<s:iterator var="iteList" value="#request.coll" status="sta">
			
           <tr>
           	  <td>&nbsp;${sta.count}</td>
           	  <td>&nbsp;${iteList.projectname }</td>
           	  <td>&nbsp;${iteList.createtime.shortDate}</td>
           	  <td>&nbsp;${iteList.completetime.shortDate }</td>
           	  <td>&nbsp;<s:text name="format.money"><s:param value="#request.iteList.totalinvest"></s:param></s:text></td>
           	  <td>&nbsp;<s:text name="format.money"><s:param value="#request.iteList.planinvest"></s:param></s:text></td>
           	  <td>&nbsp;<s:text name="format.money"><s:param value="#request.iteList.realinvest"></s:param></s:text></td>
           	  <td>&nbsp;<s:text name="format.money"><s:param value="#request.iteList.realinvest-#request.iteList.yearinvest"></s:param></s:text></td>
           </tr>
            </s:iterator>
		<tr><td>&nbsp;合计</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;<s:text name="format.money"><s:param value="#request.info.values['total']"></s:param></s:text></td><td>&nbsp;<s:text name="format.money"><s:param value="#request.info.values['plan']"></s:param></s:text></td><td>&nbsp;<s:text name="format.money"><s:param value="#request.info.values['real']"></s:param></s:text></td><td>&nbsp;<s:text name="format.money"><s:param value="#request.info.values['yearinvest']"></s:param></s:text></td></tr>
            </table>

</div>

${pageDetails}
    </div>



