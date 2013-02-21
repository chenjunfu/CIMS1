<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript"><!--
 function PrintProStatistics() { 
 	var style="<link rel='stylesheet' type='text/css' href='<%=basePath %>css/css.css'>"
			style+=  "<link href='<%=basePath %>css/AdminCss.css' type='text/css' rel='stylesheet'>"
			style+=  "<link rel='stylesheet' type='text/css' href='<%=basePath %>css/jquery-ui-css.css'>"
			style+="<link href='<%=basePath %>css/PrintStatistics.css' type='text/css' rel='stylesheet'>"
  	//var PrintArea=document.getElementById("contentDiv").innerHTML;
	var targetTable=$("#contentDiv").children("table").first().clone(true);
	$(targetTable).children("thead").children("tr").first().attr({height:"150px;"});

	//$(targetTable.children("thead").children("tr").children("td")).each(function(){
	//		$(this).removeAttr("width");
	//		$(this).attr({height:"100px"})
	//})
	var PrintArea=$(targetTable).html();
	PrintArea=PrintArea.replace(new RegExp("￥","g"), "");
	PrintArea="<table id='tbPrint' style='border:2px solid black;border-top:0px;border-right:0px;width:100%' cellpadding='0' cellspacing='0' >"+PrintArea+"</table>"
    var chartTitle=$("#showyear1").text();
    var tabletitle="<table border='0' cellpadding='0' cellspacing='0' id='tbPrint' style='border:0px;'  ><tr><th style='border:0px;' >"+chartTitle+"</th></tr></table>";
    LODOP.PRINT_INIT(chartTitle);
    //LODOP.SET_PRINT_PAGESIZE(0,0,0,"A0");
    LODOP.ADD_PRINT_TABLE("%2","%5",'90%',"90%",style+PrintArea);
    LODOP.SET_PRINT_STYLEA(0,"TableHeightScope",0);	
	LODOP.ADD_PRINT_TEXT(3,553,135,20,"总页号：第#页/共&页");
	LODOP.SET_PRINT_STYLEA(0,"ItemType",2);
	LODOP.SET_PRINT_STYLEA(0,"Horient",1);	
	LODOP.ADD_PRINT_TEXT(3,"47%",196,20,chartTitle);
	LODOP.SET_PRINT_STYLEA(0,"ItemType",1);	
    //LODOP.SET_PRINT_MODE("PRINT_PAGE_PERCENT","Full-Width");
    LODOP.PREVIEW();
  };
--></script>
<div id="ListSelect" style="position: relative;width: 99%" >
<table border="0" cellpadding="0" cellspacing="0" id="tbListSelect"  width="100%"  >
<thead>
  <tr>
    <td  style="border-right: 0px" width="33%"> 年限：
   <select name="year" id="year2">
     ${YearSelect}
   </select>
   <script>
  		 document.getElementById("year2").value='${year}'
   </script>
  </td>
  <td width="33%" style="border-right: 0px;text-align: center;"><div id="showyear1" style="font-weight: bold;color: #003e98;"><%=new Date().getYear()+1900%>文化产业项目汇总表</div></td>

    <td  width="33%"  align="right" style="border-left: 0px;text-align: right; " >
      <input type="button"   id="btnGenerate"   onClick="statistics(true);"  /> 
       <input type="button"  id="btnPrint" onClick="PrintProStatistics();"   /> 
      <input type="button"   id="btnExcel" onclick="statistics(false);" /> 
    </td>
  </tr>
  </thead>
</table>
</div>
<div id="contentDiv" style="position: relative; visible;" >

<table border="0" cellpadding="0" cellspacing="0" id="tbList" width="100%"  	  >
		<thead>				         
            <tr  id="test">
            	<td id="no" width="50px">
                   	序号
                </td>
                <td id="proname" width="100px">
                   	项目名称
                </td>
                <td id="Cunit" width="100px">
                    	建设单位
                </td>
                <td id="quality" width="100px">
                    		建设性质
                </td>
                <td id="address" width="100px" >
                   			建设地点
                </td>
                <td id="cycle" width="220px">
                			   建设起止年限
                </td>
                <td id="content" width="180px">
                    	建设规模及主要内容
                </td>
                <td id="total" width="100px">
                  		  总投资<font size="1">(万元)</font>
                </td>
                <td  colspan="3" id="found" width="340px" style="margin: 0px;padding: 0px;border-top: 0px;border-right: 0px;height: 50px" >                
                <table width="100%" height="100%" style="margin: 0px;padding: 0px;border-top: 0px;border-right: 0px" cellpadding="0" cellspacing="0">
                <tr><td colspan="3" style="text-align: center;margin: 0px;padding: 0px">&nbsp;资金来源</td></tr>
                <tr>
                <td style="margin: 0px;padding: 0px;width: 113px">&nbsp;政府投资</td>
                <td style="margin: 0px;padding: 0px;width: 113px">&nbsp;银行贷款</td>
                <td style="margin: 0px;padding: 0px;width: 113px">&nbsp;自筹</td></tr>
                </table>
                </td>
                <td id="completed" width="140px">
                  		  截止<%=new Date().getYear()+1900-1%>年底累计完成投资
                </td>
                <td  id="plan" width="100px">
                    <%=new Date().getYear()+1900%>年计划投资
                </td>
				<td colspan="4" id="case" width="500px" style="margin: 0px;padding: 0px;border-top: 0px;border-right: 0px solid;height: 50px" >
				<table  style="margin: 0px;padding: 0px;height: 100%;width: 100%" cellpadding="0" cellspacing="0" >
					<tr><td colspan="4" style="text-align: center;margin: 0px;padding: 0px">&nbsp;项目前期进展情况</td></tr>
					<tr>
					<td style="margin: 0px;padding: 0px;width: 25%">&nbsp;审批,核准,备案</td>
					<td style="margin: 0px;padding: 0px;width: 25%">&nbsp;环评批复</td>
					<td style="margin: 0px;padding: 0px;width: 25%">&nbsp;土地批准</td>
					<td style="margin: 0px;padding: 0px;width: 25%">&nbsp;规划选址</td></tr>
				</table>
                </td>
                <td id="progress" width="100px">
                  		  形象进度
                </td>
                <td id="contact" width="80px">
                 		  联系人
                </td>
                <td id="phone" width="120px">
                  		  联系电话
                </td>
                <td id="comment" width="100px">
                 		  备注
                </td>
               
            </tr>
            </thead>

            
     
		<s:iterator id="iteList" value="#request.coll" status="sta">
			   <tr  style="margin: 0px;padding: 0px" cellpadding="0"  cellspacing="0" style=" margin: 0px;padding: 0px; ">
            	<td>&nbsp;${sta.count}</td>
            	<td>&nbsp;${iteList.projectname }</td>
            	<td>&nbsp;${iteList.objEnterpriseInfoByDatabaseenterpriseid.enterprisename }</td>
            	<td>&nbsp;${iteList.objProjectQualityInfoByProquality.proquliname }</td>
            	<td>&nbsp;${iteList.objRegionsInfoByRegionid.regionname }</td>
            	<td>&nbsp;${iteList.createtime.shortDate} 至
            	<s:if test="#request.iteList.completetime.shortDate!=null">
            		${iteList.completetime.shortDate }
            	</s:if>
            	<s:else>
            	今
            	</s:else>
            	</td>
            	<td>&nbsp;${iteList.procontent}</td>
            	<td>&nbsp;
            		<s:text name="format.money">
            			<s:param value="#request.iteList.totalinvest/10000"></s:param>
            		</s:text>
            		万元
            	</td>
            	
<!--            	<td cellpadding="0" cellspacing="0"  style="margin: 0px;padding: 0px;border-top: 0px;border-right: 0px" >-->
<!--            	<table width="100%" height="100%" style="margin: 0px;padding: 0px" cellpadding="0" cellspacing="0">-->
<!--                <tr>-->
<!--                <td style="margin: 0px;padding: 0px;width: 33%">&nbsp;<s:text name="format.money"><s:param value="#request.iteList.publicinvest"></s:param></s:text></td>-->
<!--                <td style="margin: 0px;padding: 0px;width: 33%">&nbsp;<s:text name="format.money"><s:param value="#request.iteList.bankloan"></s:param></s:text></td>-->
<!--                <td style="margin: 0px;padding: 0px;width: 33%">&nbsp;<s:text name="format.money"><s:param value="#request.iteList.selfinvest"></s:param></s:text></td></tr>-->
<!--                </table> -->
<!--                </td>-->
			            	<td width="113px">&nbsp;<s:text name="format.money"><s:param value="#request.iteList.publicinvest"></s:param></s:text></td>
			            	<td width="113px">&nbsp;<s:text name="format.money"><s:param value="#request.iteList.bankloan"></s:param></s:text></td>
			            	<td width="113px">&nbsp;<s:text name="format.money"><s:param value="#request.iteList.selfinvest"></s:param></s:text></td>
            	<td>&nbsp;<s:text name="format.money"><s:param value="#request.iteList.yearinvest"></s:param></s:text></td>
            	<td>&nbsp;<s:text name="format.money"><s:param value="#request.iteList.planinvest"></s:param></s:text></td>
<!--            	<td cellpadding="0" cellspacing="0" style="margin: 0px;padding: 0px;border-top: 0px;border-right: 0px solid;" >-->
<!--            	<table style="margin: 0px;padding: 0px;height: 100%;width: 100%" cellpadding="0" cellspacing="0" >-->
<!--		-->
<!--					<tr>-->
<!--					<td style="margin: 0px;padding: 0px;width: 25%">&nbsp;${iteList.objShbInfoByShb.shbname }</td>-->
<!--					<td style="margin: 0px;padding: 0px;width: 25%">&nbsp;${iteList.objHuanpiInfoByHppf.huanpiname }</td>-->
<!--					<td style="margin: 0px;padding: 0px;width: 25%">&nbsp;${iteList.objTupiInfoByTdpz.tupiname }</td>-->
<!--					<td style="margin: 0px;padding: 0px;width: 25%">&nbsp;${iteList.objProaddInfoByGhxz.proaddname }</td></tr>-->
<!--				</table>-->
<!--                </td>-->

				<td>&nbsp;${iteList.objShbInfoByShb.shbname }</td>
				<td>&nbsp;${iteList.objHuanpiInfoByHppf.huanpiname }</td>
				<td>&nbsp;${iteList.objTupiInfoByTdpz.tupiname }</td>
				<td>&nbsp;${iteList.objProaddInfoByGhxz.proaddname }</td>
            	<td>&nbsp;${iteList.realprogress }</td>
            	<td>&nbsp;${iteList.linkman}</td>
            	<td>&nbsp;${iteList.phone}</td>
            	<td>&nbsp;${iteList.comment }</td>
            </tr>
            </s:iterator>
            <tr  style="margin: 0px;padding: 0px" cellpadding="0"  cellspacing="0" style="height: 60px;margin: 0px;padding: 0px;">
            	<td>&nbsp;合计</td>
            	<td>&nbsp;</td>
            	<td>&nbsp;</td>
            	<td>&nbsp;</td>
            	<td>&nbsp;</td>
            	<td>&nbsp;</td>
            	<td>&nbsp;</td>
            	<td >&nbsp;
            	<s:text name="format.money">
            		<s:param value="#request.info.values['totalinvest']/10000"></s:param>
            	</s:text>
            	万元
            	</td>
            	<td colspan="3"  style="margin: 0px;padding: 0px;border-top: 0px;border-right: 0px;height: 60px" >
            		<table width="100%" height="100%" style="margin: 0px;padding: 0px" cellpadding="0" cellspacing="0">
                <tr>
                <td style="margin: 0px;padding: 0px;width: 33%">&nbsp;<s:text name="format.money"><s:param value="#request.info.values['publicinvest']"></s:param></s:text></td>
                <td style="margin: 0px;padding: 0px;width: 33%">&nbsp;<s:text name="format.money"><s:param value="#request.info.values['bankinvest']"></s:param></s:text></td>
                <td style="margin: 0px;padding: 0px;width: 33%">&nbsp;<s:text name="format.money"><s:param value="#request.info.values['selfinvest']"></s:param></s:text></td></tr>
                </table>
                	
                    
                </td>
            	<td>&nbsp;<s:text name="format.money"><s:param value="#request.info.values['yearinvest']"></s:param></s:text></td>
            	<td>&nbsp;<s:text name="format.money"><s:param value="#request.info.values['planinvest']"></s:param></s:text></td>
            	<td colspan="4" width="500px" style="height: 60px;margin: 0px;padding: 0px; border-top: 0px;border-right: 0px solid;" >
            	<table style="margin: 0px;padding: 0px;height: 100%;width: 100%" cellpadding="0" cellspacing="0" >
					<tr>
					<td style="margin: 0px;padding: 0px;width: 25%">&nbsp;</td>
					<td style="margin: 0px;padding: 0px;width: 25%">&nbsp;</td>
					<td style="margin: 0px;padding: 0px;width: 25%">&nbsp;</td>
					<td style="margin: 0px;padding: 0px;width: 25%">&nbsp;</td></tr>
				</table>
                	
                </td>
            	<td>&nbsp;</td>
            	<td>&nbsp;</td>
            	<td>&nbsp;</td>
            	<td>&nbsp;</td>
            </tr>
            </table>
${pageDetails}
          </div>

<script type="text/javascript">

</script>
          
   


  
  