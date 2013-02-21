<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
 function PrintTalentNewly() { 
 
  	var newlytitle=$("#talnewlytitle").text();
	PrintSet(newlytitle,"talNewlyDiv");
    LODOP.PREVIEW();
  };
</script>
<div style="width: 100%;height: 100%">
<table border="0" cellpadding="0" cellspacing="0" id="tbListSelect" >
  <tr>
    <td width="50%" style="border-right: 0px"> 年限：
   <select name="year" id="year1">
     ${YearSelect}
   </select>
   <script>
   	document.getElementById("year1").value=${year}
   </script>
  </td>
    <td width="50%" align="right" style="border-left: 0px;text-align: right;" >
      <input type="button"   id="btnGenerate"   onClick="talentnewly(true);"   /> 
       <input type="button"    id="btnPrint" onClick="PrintTalentNewly();"   /> 
      <input type="button"   id="btnExcel" onclick="talentnewly(false);"  /> 
    </td>
  </tr>
</table>
 
<div id="talNewlyDiv">
<table border="0" cellpadding="0" cellspacing="0" id="tbList">
            <thead>
            <tr>
              <td colspan="7"><div align="center" id="talnewlytitle">年度新增文化人才统计</div></td>
              </tr>
            <tr>
                <td>
                    &nbsp;序号
                </td>
                <td>
                    &nbsp;姓名
                </td>
                <td>&nbsp;姓别</td>
                <td>&nbsp;年龄</td>
                <td>&nbsp;学历</td>
                <td>&nbsp;专业</td>
                <td>&nbsp;职称</td>
              					 
               
            </tr>
            </thead>
		
            <tbody>
            <s:iterator id="talents" value="#request.coll" status="sta">
            	<tr>
                <td>
                 &nbsp;${sta.count }
                </td>
                <td > 
                &nbsp;${talentname}
                </td>
                <td>&nbsp;${sexlabel }</td>
                <td>&nbsp; <s:property value="(new java.util.Date().getYear()-birthday.getYear())"/></td>
                <td>&nbsp;${objEducationInfoByEducationid.educationname }</td>
                <td>&nbsp;${objMajorInfoByMajorid.majorname}</td>
                <td>&nbsp;${objPostInfoByPosttitleid.titlename}</td>
            </tr>
            </s:iterator>
            <tr><td>合计</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
            </tbody></table>


    </div>
</div>


         