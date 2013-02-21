<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
 function PrintProByRegion() { 
    var chartTitle=$("#ProByRegionTitle").text();
	PrintSet(chartTitle,"ProByRegionDiv");	
    LODOP.PREVIEW();
  };
</script>

<div style="width: 100%;height: 100%">
<table border="0" cellpadding="0" cellspacing="0" id="tbListSelect" >
 
  <tr>
    <td width="30%" style="border-right: 0px"> 年限：
  <select name="year" id="year6">
  ${YearSelect}
  </select>
  <script type="text/javascript">document.getElementById('year6').value='${year}';</script>
  </td>
    <td width="30%" style="border-left: 0px;border-right: 0px"> 类型：
    <select name="projectregion" id="projectregion" title="类型">
      <option value="0" selected="selected">全部</option>
	${projectregionlist}
    </select>
      <script type="text/javascript">document.getElementById('projectregion').value=${projectregion};</script></td>
      <td width="45%" align="right" style="border-left: 0px;text-align: right;" >
      <input type="button"   id="btnGenerate" onClick="projectbyregion(true);"   /> 
       <input type="button"  id="btnPrint" onClick="PrintProByRegion();" /> 
      <input type="button"   id="btnExcel" onclick="projectbyregion(false)"  /> 
    </td>
  </tr>
</table>

<div id="ProByRegionDiv">
<table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
          <tr>
			<td style="text-align: center; border: 0px" colspan="9" ><b id="ProByRegionTitle"> 年度项目地区统计及分析表</b></td>
			</tr>
            <tr>
            	<td>
            			序号
            	</td>
                <td>
                    	地区名称
                </td>
                <td>
                		项目编号
                </td>
                <td>
                    	项目名称
                </td>
                <td>
                   	        开始时间
                </td>
                <td>
                    	完成时间
                </td>
                <td>
                    	计划投资
                </td>
                <td>
                	 	年度投资
                </td>
                <td>
                		比例
                </td>
            </tr>
            </thead>
		<s:iterator var="AllList" value="#request.ProjectList" status="sta">
			<s:iterator var="iteList" value="AllList" status="cur">
            <tr>
           		<s:if test="#cur.first">
            	<td style="border-width: 1px;border-bottom-width: 0px" >
					&nbsp;${sta.count}
                </td>
  				</s:if>
  				<s:else>
  				<td style="border-width: 1px;border-top-width: 0px;border-bottom-width: 0px;">
					&nbsp;
                </td>
                </s:else>
        	<s:if test="#cur.first">
            	<td  style="border-width: 1px;border-bottom-width: 0px;border-left-width:0px;">
					&nbsp;${iteList.objRegionsInfoByRegionid.regionname}
                </td>
  				</s:if>
  				<s:else>
  				<td style="border-width: 1px;border-top-width: 0px;border-bottom-width:0px;border-left-width:0px">
  					&nbsp;
  				</td>
  				</s:else>
  				<s:if test="#iteList.databaseprojectid!=0">
               <td>&nbsp;${iteList.projectid }</td>
               </s:if>
               <s:else>
               <td>&nbsp;</td>
               </s:else>
                <td>
					&nbsp;${iteList.projectname}
                </td>
               <s:if test="#iteList.databaseprojectid!=0">
                	<td>
           		 &nbsp;${iteList.createtime.shortDate }
                </td>
                </s:if>
                <s:else>
                <td>
                &nbsp;
                </td>
                </s:else>
                <s:if test="#iteList.databaseprojectid!=0">
                <td>
           		&nbsp;${iteList.completetime.shortDate }
                </td>
                </s:if>
				<s:else>
					<td>&nbsp;</td>
				</s:else>
                <s:if test="#iteList.databaseprojectid==0">
                <td>&nbsp;</td>
                </s:if>
                <s:else>
                <td>
			&nbsp;<s:text name="format.money"><s:param value="#request.iteList.planinvest"></s:param></s:text>
                </td>
                </s:else>
       
               <s:if test="#iteList.databaseprojectid!=0">
               <td>&nbsp;<s:text name="format.money"><s:param value="#request.iteList.realinvest-#request.iteList.yearinvest"></s:param></s:text></td>
               </s:if>
               <s:else>
               <td>&nbsp;</td>
               </s:else>
               
              <s:if test="#cur.first">
            		<td  style="border-width: 1px;border-bottom-width: 0px;border-left-width:0px;">
            	<s:if test="#iteList.databaseprojectid!=0">
            	
            	<s:set value="#AllList.size" scope="request" name="prosize"></s:set>
           			<fmt:formatNumber value="${(prosize/projectcount)*100}" pattern="#.##" />%
            	</s:if>
            	&nbsp;
                </td>
  			   </s:if>
  			   <s:else>
  				<td style="border-width: 1px;border-top-width: 0px;border-bottom-width:0px;border-left-width:0px">
  					&nbsp;
  				</td>
  				</s:else>
            </tr>
            </s:iterator>
		</s:iterator>
		<tr><td>合计</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;<s:text name="format.money"><s:param value="#request.info.values['plan']"></s:param></s:text></td><td>&nbsp;<s:text name="format.money"><s:param value="#request.info.values['yearinvest']"></s:param></s:text></td><td>&nbsp;100%</td></tr>
                       <tr><td colspan="9"><img src="<%=basePath %>chart/projectbyregion.do?createtime1=<s:date name="#request.end"/>"  alt="正在生成图形"/></td></tr>
            </table>

</div>

${pageDetails}

    </div>
<script type="text/javascript">
<!--
	$("#txtCreatetime5List").datepicker({changeMonth: true,changeYear: true});
	$("#txtCreatetime6List").datepicker({changeMonth: true,changeYear: true});
-->
</script>
