<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
 function PrintByRegion() { 

    PrintSet("按地区统计企业总量","ByRegionDiv");
    LODOP.PREVIEW();
  };
</script>
<div style="width: 100%;height: 100%">
<table border="0" cellpadding="0" cellspacing="0" id="tbListSelect" >
 
  <tr>
    <td width="30%" style="border-right: 0px"> 创立时间
   <input name="createtime" type="text" id="txtCreatetime7List" value="<s:date name="createtime1" format="yyyy-MM-dd"/>" title="创立时间" size="15" maxlength="20" />
至
  <input name="createtime" type="text" id="txtCreatetime8List" value="<s:date name="createtime2" format="yyyy-MM-dd"/>" title="创立时间" size="15" maxlength="20" />

  </td>
    <td width="30%" style="border-left: 0px;border-right: 0px"> 所属区域：
    <select name="region" id="enterpriseregion" title="所属区域">
      <option value="0" selected="selected">全部</option>
	${RegionidList}
    </select>
      <script type="text/javascript">document.getElementById('enterpriseregion').value='${enterpriseregion}';</script></td>
    <td width="45%" align="right" style="border-left: 0px ;text-align: right;" >
		<input type="button" id="btnGenerate" onClick="enterpriseByRegion(true);"  />
      	<input type="button" id="btnPrint" onClick="PrintByRegion();"  />
      	<input type="button" id="btnExcel" onclick="enterpriseByRegion(false)" /> 
		
    </td>
  </tr>
</table>

<div id="ByRegionDiv">
<table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
          <tr>
			<td style="text-align: center; border: 0px" colspan="6" ><b> 按地区统计企业总量</b></td>
			
   
			</tr>
            <tr>
            	<td>
            			序号
            	</td>

                <td>
                    	所属区域
                </td>
                <td>
                    	企业名称
                </td>
                <td>
                   	   	注册资金
                </td>
                <td>
                    	就业人数
                </td>
                <td>
                    	创立时间
                </td>
               
            </tr>
            </thead>
            <tbody>
		<s:iterator var="AllList" value="#request.EnterpriseListByType" status="sta">
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
                <td>
			&nbsp;${iteList.enterprisename}
                </td>
                <s:if test="#iteList.registfund!=0">
                	<td>
            &nbsp;
				<s:text name="format.money">
				<s:param value="#request.iteList.registfund"></s:param>
			</s:text>
                </td>
                </s:if>
                <s:else>
                <td>
                &nbsp;
                </td>
                </s:else>
                <s:if test="#iteList.employnumber!=0">
                <td>
           			 &nbsp;${iteList.employnumber }
                </td>
                </s:if>
				<s:else>
					<td>&nbsp;</td>
				</s:else>
                <s:if test="#iteList.databaseenterpriseid!=0">
                <td>
			&nbsp;${iteList.createtime.shortDate}
                </td>
                </s:if>
                <s:else>
                	<td>&nbsp;</td>
                </s:else>
               
               
            </tr>
            </s:iterator>
		</s:iterator>
	

		<tr><td>合计</td><td>&nbsp;</td><td>&nbsp;${count }</td><td>&nbsp;<s:text name="format.money"><s:param value="#request.register"></s:param></s:text></td><td>&nbsp;${peoplecount}</td><td>&nbsp;</td></tr>
		<tr><td colspan="6"><img src="<%=basePath %>chart/enterprisebyregion.do?regionid=${enterpriseregion}&createtime1=<s:date name="#request.createtime1"/>&createtime2=<s:date name="#request.createtime2"/>" alt="正在生成图形" /></td></tr>
         	</tbody>
            </table>
</div>
${pageDetails}
    </div>
<script type="text/javascript">
<!--
	$("#txtCreatetime7List").datepicker({changeMonth: true,changeYear: true});
	$("#txtCreatetime8List").datepicker({changeMonth: true,changeYear: true});
-->
</script>

