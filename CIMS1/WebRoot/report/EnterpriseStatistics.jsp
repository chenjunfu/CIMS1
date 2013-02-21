<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
 function myPreview() { 
	    PrintSet("年度企业汇总","divlist");
	    LODOP.PREVIEW();
  }
</script>
<div style="width: 100%;height: 100%" >

<table border="0" cellpadding="0" cellspacing="0" id="tbListSelect" >
 <form action="chart/enterprise!AnnualSummary.do">
  <tr>
    <td width="60%" style="border-right: 0px"> 创立时间：
   <input name="createtime" type="text" id="txtCreatetime1List" value="<s:date name="createtime1" format="yyyy-MM-dd"/>" title="创立时间" size="15" maxlength="20" />
至
  <input name="createtime" type="text" id="txtCreatetime2List" value="<s:date name="createtime2" format="yyyy-MM-dd"/>" title="创立时间" size="15" maxlength="20" />
	
  </td>

<td style="border-left: 0px;text-align: right;" >
      <input type="button"  id="btnGenerate"    onclick="statistics(true);" /> 
      <input type="button"   id="btnPrint" onClick="myPreview()"   /> 
      <input type="button"  id="btnExcel" onclick="statistics(false);"  /> 
    </td>
  </tr>
  </form>
</table>
<div id="divlist">
<table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
          <tr>
			<td style="text-align: center; border: 0px" colspan="7" ><b>年度企业汇总</b></td>

			</tr>
            <tr>
            	<td>
            		序号
            	</td>
                <td>
                  	  企业名称
                </td>
                <td>
                    	行业类型
                </td>
                <td>
                    	创立时间
                </td>
                <td>
                   	   所属区域
                </td>
                <td>
                    	注册资金
                </td>
                <td>
                    	企业性质
                </td>
               
            </tr>
            </thead>
		<s:iterator id="iteList" value="#request.EnterpriseList" status="sta">
            <tr>
            	<td>
            		&nbsp;${sta.count}
            	</td>
                <td>
			&nbsp;${iteList.enterprisename}
                </td>
                <td>
			&nbsp;${iteList.objProfessionInfoByBusinesstypeid.businesstypename}
                </td>
                <td>
			&nbsp;${iteList.createtime.shortDate}
                </td>
                <td>
			&nbsp;${iteList.objRegionsInfoByRegionid.regionname}
                </td>
                <td>
			&nbsp;<s:text name="format.money">
				<s:param value="#request.iteList.registfund"></s:param>
			</s:text>
                </td>
                <td>
			&nbsp;${iteList.objEnterpristQualityInfoByQualityid.qualityname}
                </td>
            </tr>
		</s:iterator>
		<tr><td>合计</td><td>&nbsp;</td><td>&nbsp; </td><td>&nbsp; </td><td>&nbsp; </td><td>&nbsp;<s:text name="format.money"><s:param value="#request.register"></s:param></s:text></td><td>&nbsp; </td></tr>
		
            </table>
</div>



${pageDetails}

    </div>
<script type="text/javascript">

	$("#txtCreatetime1List").datepicker({changeMonth: true,changeYear: true});
	$("#txtCreatetime2List").datepicker({changeMonth: true,changeYear: true});

</script>
