<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
            <table border="0" cellpadding="0" cellspacing="0" id="tbList" style="border: 0px solid #cedff7;border-top: 0px;border-right: 0px" >
            <tr>
            <td style="border-top: 0px;border-right: 0px">
              <% int j=1;%>
		     <s:iterator id="iteList" value="#request.ProjectpicList">
        
           <ul>
             <li class="LeftTrue"> 
              <img src="<%=basePath %>${iteList.picmin}" title="" style="cursor:pointer; " id="picmig" width="100%" height="100%"   border="0" onmouseout="closepic()" onclick="delpic(${iteList.projectpicid})"  onmouseover="upclick('${iteList.pic}',this)" />
             </li>
          </ul> 
		</s:iterator>
        </td>
         </tr>  
        <tr><td style="border: 0px solid #cedff7;"  align="center">${pageDetails}</td></tr>
        </table>