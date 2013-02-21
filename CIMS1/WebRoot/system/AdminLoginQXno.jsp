<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title><%=com.yun.configuration.WebConfig.WEB_TITLE %></title>
    <link href="AdminCss.css" rel="stylesheet" type="text/css">
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <table width="60%" border="1" align="center" cellpadding="0" cellspacing="1" bordercolor="#03CCFE">
                <tr>
                    <td height="28" align="center"  style="background-image: url('image/link.gif');" bgcolor="#C1F1FF">&nbsp;
                        </td>
                </tr>
                <tr>
                    <td height="70" align="center" bgcolor="#C1F1FF">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td>&nbsp;
                                    </td>
                                <td>
                                    您没有权限访问，<a href="" onclick="parent.location.href='../main.jsp';">返回首页。</a>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
