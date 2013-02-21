<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
 function PrintNewly() { 

  	var charttitle=$("#newlytitle").text();
  	
    PrintSet(charttitle,"NewlyProDiv")
    LODOP.PREVIEW();
  };
</script>
<div id="divlist" style="width: 100%;height: 100%">
<table border="0" cellpadding="0" cellspacing="0" id="tbListSelect" width="100%" >
  <tr>
    <td width="50%" style="border-right: 0px"> 年限：
   <select name="year" id="year1">
     ${YearSelect }
   </select>
   <script>
   	document.getElementById("year1").value=${year}
   </script>
  </td>
    <td width="50%" align="right" style="border-left: 0px;text-align: right;" >
      <input type="button"   id="btnGenerate"   onClick="projectnewly(true);"  /> 
       <input type="button"    id="btnPrint" onClick="PrintNewly();" /> 
      <input type="button"   id="btnExcel" onclick="projectnewly(false);"  /> 
    </td>
  </tr>
</table>
<div id="NewlyProDiv">
<table border="0" cellpadding="0" cellspacing="0" id="tbList" >
            <thead>
          <tr>
			<td style="text-align: center; border: 0px" colspan="8" ><b id="newlytitle">年度新增项目汇总表</b></td>
			</tr>
            <tr>
            	<td width="6%">
            		     序号
            	</td>

                <td width="12%">
                    	项目名称
                </td>
                <td width="10%">
                    	项目类型
                </td>
                <td width="10%">
                   	         所属地区
                </td>
                <td width="23%">
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
           	  <td>&nbsp;${sta.count }</td>
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



