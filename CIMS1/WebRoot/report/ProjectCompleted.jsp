<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
 function PrintProComplete() { 

    var chartTitle=$("#ProComcharttitle").text();

    PrintSet(chartTitle,"ProCompleteDiv");

    LODOP.PREVIEW();
  };
</script>
<div style="width: 100%;height: 100%">
<table border="0" cellpadding="0" cellspacing="0" id="tbListSelect" >
  <tr>
    <td width="50%" style="border-right: 0px"> 年限：
   <select name="year" id="year3">
     ${YearSelect }
   </select>
   <script>
   	document.getElementById("year3").value='${year}'
   </script>
  </td>
  

    <td width="50%" align="right" style="border-left: 0px;text-align: right;" >
      <input type="button"  id="btnGenerate"   onClick="projectcompleted(true);"   /> 
       <input type="button"   id="btnPrint" onClick="PrintProComplete();"   /> 
      <input type="button"   id="btnExcel" onclick="projectcompleted(false)"  /> 
    </td>
  </tr>
</table>

<div id="ProCompleteDiv">
<table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
          <tr>
			<td style="text-align: center; border: 0px" colspan="8" ><b id="ProComcharttitle">年度完成项目汇总表</b></td>   
			</tr>
            <tr>
            	<td width="8%">
            		     序号
            	</td>

                <td width="12%">
                    	项目名称
                </td>
                <td width="14%">
                    	项目类型
                </td >
                <td width="12%">
                   	         所属地区
                </td >
                <td width="14%">
                    	项目内容
                </td>
                <td width="12%">
                    	总投资
                </td>
                <td width="12%">
                	          开始时间
                </td>
                <td width="12%">
                		完成时间
                </td>
               
            </tr>
            </thead>
		<s:iterator var="iteList" value="#request.coll" status="sta">
			
           <tr>
           	  <td>&nbsp;${sta.count}</td>
           	  <td>&nbsp;${iteList.projectname }</td>
           	  <td>&nbsp;${iteList.objProfessionInfoByIndustryid.businesstypename}</td>
           	  <td>&nbsp;${iteList.objRegionsInfoByRegionid.regionname }</td>
           	  <td>&nbsp;${iteList.procontent }</td>
           	  <td>&nbsp;<s:text name="format.money"><s:param value="#request.iteList.totalinvest"></s:param></s:text></td>
           	  <td>&nbsp;${iteList.createtime.shortDate}</td>
           	  <td>&nbsp;${iteList.completetime.shortDate }</td>
           </tr>
            </s:iterator>
		<tr><td>合计</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;<s:text name="format.money"><s:param value="#request.info.value"></s:param></s:text></td><td>&nbsp;</td><td>&nbsp;</td></tr>
            </table>

</div>

${pageDetails}

    </div>
<script type="text/javascript">
<!--

-->
</script>


