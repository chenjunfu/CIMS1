package com.yun.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Pager
{
	// [start] PageType 分页类型
	/**
	 * 分页类型
	 *
	 */
	public enum PageType
	{
		/**
		 * 模式0 [第一页] [上一页] [下一页] [最后一页] 转到
		 */
		Default,
		/**
		 * 模式1 (下拉框)
		 */
		Select,
		/**
		 * 模式2 (数字)
		 */
		Number,
		/**
		 * 模式3 (当前5页数字＋[第一页] [上一页] [1] [2] [3] [4] [5] [下一页] [最后一页])
		 */
		NumberAndDefault,
		/**
		 * 模式4 (自定义左右选图片)
		 */
		LeftAndRight
	}

	// [end]

	// [start] LastNextPage 分页显示
	/**
	 * 使用字符串的分页函数
	 *
	 * @param page 分页字符串的标识字符
	 * @param intPageSize 每页显示的条数
	 * @param intRecordCount 总条数
	 * @param CurrentPageName 当前的页面
	 * @param div_style 最外层Div的样式
	 * @param pageType 分页模式
	 */
	public static String LastNextPage(HttpServletRequest request, HttpServletResponse response, String page, int intPageSize, int intRecordCount)
	{
		return LastNextPage(request, response, page, intPageSize, intRecordCount, "", "", PageType.Default);
	}

	// [end]

	// [start] LastNextPage 分页显示
	/**
	 * 使用字符串的分页函数
	 *
	 * @param page 分页字符串的标识字符
	 * @param intPageSize 每页显示的条数
	 * @param intRecordCount 总条数
	 * @param CurrentPageName 当前的页面
	 * @param div_style 最外层Div的样式
	 * @param pageType 分页模式
	 */
	public static String LastNextPage(HttpServletRequest request, HttpServletResponse response, String page, int intPageSize, int intRecordCount, PageType pageType)
	{
		return LastNextPage(request, response, page, intPageSize, intRecordCount, "", "", pageType);
	}

	// [end]

	// [start] LastNextPage 分页显示
	/**
	 * 使用字符串的分页函数
	 *
	 * @param page 分页字符串的标识字符
	 * @param intPageSize 每页显示的条数
	 * @param intRecordCount 总条数
	 * @param CurrentPageName 当前的页面
	 * @param div_style 最外层Div的样式
	 * @param pageType 分页模式
	 */
	public static String LastNextPage(HttpServletRequest request, HttpServletResponse response, String page, int intPageSize, int intRecordCount, String CurrentPageName)
	{

		return LastNextPage(request, response, page, intPageSize, intRecordCount, CurrentPageName, "", PageType.Default);
	}

	// [end]

	// [start] LastNextPage 分页显示
	/**
	 * 使用字符串的分页函数
	 *
	 * @param page 分页字符串的标识字符
	 * @param intPageSize 每页显示的条数
	 * @param intRecordCount 总条数
	 * @param CurrentPageName 当前的页面
	 * @param div_style 最外层Div的样式
	 * @param pageType 分页模式
	 */
	public static String LastNextPage(HttpServletRequest request, HttpServletResponse response, String page, int intPageSize, int intRecordCount, String CurrentPageName, PageType pageType)
	{

		return LastNextPage(request, response, page, intPageSize, intRecordCount, CurrentPageName, "", pageType);
	}

	// [end]

	// [start] LastNextPage 分页显示
	/**
	 * 使用字符串的分页函数
	 *
	 * @param page 分页字符串的标识字符
	 * @param intPageSize 每页显示的条数
	 * @param intRecordCount 总条数
	 * @param CurrentPageName 当前的页面
	 * @param div_style 最外层Div的样式
	 * @param pageType 分页模式
	 */
	public static String LastNextPage(HttpServletRequest request, HttpServletResponse response, String page, int intPageSize, int intRecordCount, String CurrentPageName, String div_style, PageType pageType)
	{

		// int intCurrIndex =
		// System.Convert.ToInt32(System.Web.HttpContext.Current.Request.QueryString[page]);
		int intCurrIndex = com.colorwinglib.Requests.GetInt(request, page, 1);

		int pagecount;
		if ((intRecordCount % intPageSize) > 0)
		{
			pagecount = (int) ((int) (intRecordCount / intPageSize + 1));
		}
		else
		{
			pagecount = (int) (intRecordCount / intPageSize);
		}
		if (intCurrIndex == 0)
		{
			intCurrIndex = 1;
		}
		String temp = "";
		CurrentPageName = CurrentPageName == "" ? request.getServletPath() : CurrentPageName;
		String host = request.getProtocol();
		// String action = "http://" + request.getRemoteHost() +
		// CurrentPageName;
		String action = request.getRequestURL().toString();

		String[] query = { "" };
		if (request.getQueryString() != null)
			query = request.getQueryString().split("&");
		StringBuilder sbStrtemp = new StringBuilder(100);
		for (String x : query)
		{
			if (x.length() > 0)
			{
				String[] a = x.split("=");
				if (a.length == 2 && a[0].toLowerCase().equals(page.toLowerCase()) == false)
				{
					// temp = temp + a[0] + "=" + a[1] + "&";
					if (a.length > 1)
						sbStrtemp.append(a[0]).append("=").append(a[1]).append("&");
					else
						sbStrtemp.append(a[0]).append("=&");
				}
			}
		}
		temp = sbStrtemp.toString();

		StringBuilder sbStr = new StringBuilder(3000);
		div_style = div_style.length() == 0 ? "width:100%" : div_style;
		sbStr.append("<div  id=\"page\"style=\"").append(div_style).append("\">\n");
		sbStr.append(String.format("			总共<b>%s</b>页<b>%s</b>条数据 第 <b>%s</b> 页\n", pagecount, intRecordCount, intCurrIndex));
		switch (pageType)
		{
		// 模式0 [第一页] [上一页] [下一页] [最后一页] 转到
		case Default:
			// 模式0
			if (intCurrIndex <= 1)
			{
				sbStr.append("			[第一页] [上一页] \n");
			}
			else
			{
				sbStr.append(String.format("[<a href=\"%s?%s%s=1\">第一页</a>] \n", action, temp, page));
				sbStr.append(String.format("[<a href=\"%s?%s%s=%s\">上一页</a>] \n", action, temp, page, intCurrIndex - 1));
			}
			if (intCurrIndex >= pagecount)
			{
				sbStr.append("[下一页] [最后一页]\n");
			}
			else
			{
				sbStr.append(String.format("[<a href=\"%s?%s%s=%s\">下一页</a>] \n", action, temp, page, intCurrIndex + 1));
				sbStr.append(String.format("[<a href=\"%s?%s%s=%s\">最后一页</a>]\n", action, temp, page, pagecount));
			}
			sbStr.append("<input type=\"text\" value=\"").append(intCurrIndex).append("\" name=\"intCurrIndex\"  onKeyUp=\"intCurrIndexChange(this.value)\" onKeyDown=\"if(event.keyCode==13){if(doCheck()){event.returnValue=false;gotoPage();}else{event.returnValue=false;}}\" style=\"width:30px;\" />\n");
			sbStr.append("<input type=\"Button\" name=\"ColorWingGotoPage\" value=\"转到\" onClick=\"gotoPage()\" />\n");

			sbStr.append("</div>\n");// 结束div
			sbStr.append("<script type=\"text/javascript\">\n");
			sbStr.append("function intCurrIndexChange(topage){var objs=document.getElementsByName(\n");
			sbStr.append("\"intCurrIndex\");for(var i=0;i<objs.length;i++)objs[i].value=topage;}function\n");
			sbStr.append("getintCurrIndex(){var objs=document.getElementsByName(\"intCurrIndex\");for(var i\n");
			sbStr.append("=0;i<objs.length;i++)return objs[i];}function doCheck(){var r=new RegExp(\n");
			sbStr.append("\"^\\\\s*(\\\\d+)\\\\s*$\");if(r.test(getintCurrIndex().value)){if(RegExp. $1<1||\n");
			sbStr.append("RegExp. $1>").append(pagecount).append("){alert(\"页数超出范围！\");getintCurrIndex().select();return false;}\n");
			sbStr.append("return true;}alert(\"页索引无效！\");getintCurrIndex().select();return false;}\n");
			sbStr.append("function gotoPage(){if(doCheck(getintCurrIndex())){location.href=BuildUrlString\n");
			sbStr.append("('").append(page).append("',getintCurrIndex().value)}}function BuildUrlString(key,value){var _key=\n");
			sbStr.append("key.toLowerCase();var prms=location.search;if(prms.length==0)return\n");
			sbStr.append("location.pathname+\"?\"+_key+\"=\"+value;var params=prms.substring(1).split(\"&\");\n");
			sbStr.append("var newparam=\"\";var found=false;for(i=0;i<params.length;i++){if(params[i].split\n");
			sbStr.append("(\"=\")[0].toLowerCase()==_key){params[i]=_key+\"=\"+value;found=true;break;}}if(\n");
			sbStr.append("found)return location.pathname+\"?\"+params.join(\"&\");else return location+\"&\"+\n");
			sbStr.append("_key+\"=\"+value;}\n");
			sbStr.append("</script>\n");

			break;
		case Select:
			// 模式1
			sbStr.append("<select name=\"toPage\" onchange=\"window.location.href=this.value;\\n");
			for (int i = 1; i <= pagecount; i++)
			{
				sbStr.append(String.format("<option value=\"%s?%s%s=%s\"%4$s>页面: %3$s / %5$s</option>\n", action, temp, page, i, i == intCurrIndex ? "selected=\"selected\"" : "", pagecount));
			}

			sbStr.append("</option>");
			sbStr.append("</div>\n");// 结束div

			break;
		case Number:
			// 模式2
			for (int i = 1; i <= pagecount; i++)
			{
				sbStr.append(String.format("[<a href=\"%s?%s%s=%s\">%3$s</a>] ", action, temp, page, i));
			}
			sbStr.append("</div>\n");// 结束div

			break;
		case NumberAndDefault:

			// 模式0
			if (intCurrIndex <= 1)
			{
				sbStr.append("			[第一页] [上一页] \n");
			}
			else
			{
				sbStr.append(String.format("[<a href=\"%s?%s%s=1\">第一页</a>] \n", action, temp, page));
				sbStr.append(String.format("[<a href=\"%s?%s%s=%s\">上一页</a>] \n", action, temp, page, intCurrIndex - 1));
			}
			// 模式2
			int star = 0;
			int end = pagecount;
			star = intCurrIndex - 2 < 1 ? 1 : intCurrIndex - 2;
			end = star + 4 > pagecount ? pagecount : star + 4;
			for (int i = star; i <= end; i++)
			{
				if (intCurrIndex == i)
				{
					// sbStr.append(String.format("[{3}] ", action, temp, page,
					// i));
					sbStr.append(String.format("[%s] ", i));
				}
				else
				{
					sbStr.append(String.format("[<a href=\"%s?%s%s=%s\">%s</a>] ", action, temp, page, i, i));
				}
			}

			if (intCurrIndex >= pagecount)
			{
				sbStr.append("[下一页] [最后一页]\n");
			}
			else
			{
				sbStr.append(String.format("[<a href=\"%s?%s%s=%s\">下一页</a>] \n", action, temp, page, intCurrIndex + 1));
				sbStr.append(String.format("[<a href=\"%s?%s%s=%s\">最后一页</a>]\n", action, temp, page, pagecount));
			}
			sbStr.append("<input type=\"text\" value=\"").append(intCurrIndex).append("\" name=\"intCurrIndex\"  onKeyUp=\"intCurrIndexChange(this.value)\" onKeyDown=\"if(event.keyCode==13){if(doCheck()){event.returnValue=false;gotoPage();}else{event.returnValue=false;}}\" style=\"width:30px;\" />\n");
			sbStr.append("<input type=\"Button\" name=\"ColorWingGotoPage\" value=\"转到\" onClick=\"gotoPage()\" />\n");

			sbStr.append("</div>\n");// 结束div
			sbStr.append("<script type=\"text/javascript\">\n");
			sbStr.append("function intCurrIndexChange(topage){var objs=document.getElementsByName(\n");
			sbStr.append("\"intCurrIndex\");for(var i=0;i<objs.length;i++)objs[i].value=topage;}function\n");
			sbStr.append("getintCurrIndex(){var objs=document.getElementsByName(\"intCurrIndex\");for(var i\n");
			sbStr.append("=0;i<objs.length;i++)return objs[i];}function doCheck(){var r=new RegExp(\n");
			sbStr.append("\"^\\\\s*(\\\\d+)\\\\s*$\");if(r.test(getintCurrIndex().value)){if(RegExp. $1<1||\n");
			sbStr.append("RegExp. $1>").append(pagecount).append("){alert(\"页数超出范围！\");getintCurrIndex().select();return false;}\n");
			sbStr.append("return true;}alert(\"页索引无效！\");getintCurrIndex().select();return false;}\n");
			sbStr.append("function gotoPage(){if(doCheck(getintCurrIndex())){location.href=BuildUrlString\n");
			sbStr.append("('").append(page).append("',getintCurrIndex().value)}}function BuildUrlString(key,value){var _key=\n");
			sbStr.append("key.toLowerCase();var prms=location.search;if(prms.length==0)return\n");
			sbStr.append("location.pathname+\"?\"+_key+\"=\"+value;var params=prms.substring(1).split(\"&\");\n");
			sbStr.append("var newparam=\"\";var found=false;for(i=0;i<params.length;i++){if(params[i].split\n");
			sbStr.append("(\"=\")[0].toLowerCase()==_key){params[i]=_key+\"=\"+value;found=true;break;}}if(\n");
			sbStr.append("found)return location.pathname+\"?\"+params.join(\"&\");else return location+\"&\"+\n");
			sbStr.append("_key+\"=\"+value;}\n");
			sbStr.append("</script>\n");

			break;
		}
		return sbStr.toString();
	}

	// [end]

	// [start] LastNextPageByAjax 分页显示
	/**
	 * 使用字符串的分页函数
	 *
	 * @param page 分页字符串的标识字符
	 * @param intPageSize 每页显示的条数
	 * @param intRecordCount 总条数
	 * @param CurrentPageName 当前的页面
	 * @param div_style 最外层Div的样式
	 * @param pageType 分页模式
	 */
	public static String LastNextPageByAjax(HttpServletRequest request, HttpServletResponse response, String page, int intPageSize, int intRecordCount)
	{
		return LastNextPageByAjax(request, response, page, intPageSize, intRecordCount, "", "", PageType.Default);
	}

	// [end]

	// [start] LastNextPageByAjax 分页显示
	/**
	 * 使用字符串的分页函数
	 *
	 * @param page 分页字符串的标识字符
	 * @param intPageSize 每页显示的条数
	 * @param intRecordCount 总条数
	 * @param CurrentPageName 当前的页面
	 * @param div_style 最外层Div的样式
	 * @param pageType 分页模式
	 */
	public static String LastNextPageByAjax(HttpServletRequest request, HttpServletResponse response, String page, int intPageSize, int intRecordCount, PageType pageType)
	{
		return LastNextPageByAjax(request, response, page, intPageSize, intRecordCount, "", "", pageType);
	}

	// [end]

	// [start] LastNextPageByAjax 分页显示
	/**
	 * 使用字符串的分页函数
	 *
	 * @param page 分页字符串的标识字符
	 * @param intPageSize 每页显示的条数
	 * @param intRecordCount 总条数
	 * @param CurrentPageName 当前的页面
	 * @param div_style 最外层Div的样式
	 * @param pageType 分页模式
	 */
	public static String LastNextPageByAjax(HttpServletRequest request, HttpServletResponse response, String page, int intPageSize, int intRecordCount, String CurrentPageName)
	{

		return LastNextPageByAjax(request, response, page, intPageSize, intRecordCount, CurrentPageName, "", PageType.Default);
	}

	// [end]

	// [start] LastNextPageByAjax 分页显示
	/**
	 * 使用字符串的分页函数
	 *
	 * @param page 分页字符串的标识字符
	 * @param intPageSize 每页显示的条数
	 * @param intRecordCount 总条数
	 * @param CurrentPageName 当前的页面
	 * @param div_style 最外层Div的样式
	 * @param pageType 分页模式
	 */
	public static String LastNextPageByAjax(HttpServletRequest request, HttpServletResponse response, String page, int intPageSize, int intRecordCount, String CurrentPageName, PageType pageType)
	{

		return LastNextPageByAjax(request, response, page, intPageSize, intRecordCount, CurrentPageName, "", pageType);
	}

	// [end]

	// [start] LastNextPageByAjax 分页显示
	/**
	 * 使用字符串的分页函数
	 *
	 * @param page
	 *            分页字符串的标识字符
	 * @param intPageSize
	 *            每页显示的条数
	 * @param intRecordCount
	 *            总条数
	 * @param CurrentPageName
	 *            当前的页面
	 * @param div_style
	 *            最外层Div的样式
	 * @param pageType
	 *            分页模式
	 */
	public static String LastNextPageByAjax(HttpServletRequest request, HttpServletResponse response, String page, int intPageSize, int intRecordCount, String CurrentPageName, String div_style, PageType pageType)
	{

		// int intCurrIndex =
		// System.Convert.ToInt32(System.Web.HttpContext.Current.Request.QueryString[page]);
		int intCurrIndex = com.colorwinglib.Requests.GetInt(request, page, 1);

		int pagecount;
		if ((intRecordCount % intPageSize) > 0)
		{
			pagecount = (int) ((int) (intRecordCount / intPageSize + 1));
		}
		else
		{
			pagecount = (int) (intRecordCount / intPageSize);
		}
		if (intCurrIndex == 0)
		{
			intCurrIndex = 1;
		}
		String temp = "";
		//CurrentPageName = CurrentPageName == "" ? request.getServletPath() : CurrentPageName;
		CurrentPageName = CurrentPageName == "" ? "ajaxPage" : CurrentPageName;
		String host = request.getProtocol();
		// String action = "http://" + request.getRemoteHost() +
		// CurrentPageName;
		String action = request.getRequestURL().toString();

		String[] query = { "" };
		if (request.getQueryString() != null)
			query = request.getQueryString().split("&");
		StringBuilder sbStrtemp = new StringBuilder(100);
		for (String x : query)
		{
			if (x.length() > 0)
			{
				String[] a = x.split("=");
				if (a.length == 2 && a[0].toLowerCase().equals(page.toLowerCase()) == false)
				{
					// temp = temp + a[0] + "=" + a[1] + "&";
					if (a.length > 1)
						sbStrtemp.append(a[0]).append("=").append(a[1]).append("&");
					else
						sbStrtemp.append(a[0]).append("=&");
				}
			}
		}
		temp = sbStrtemp.toString();

		StringBuilder sbStr = new StringBuilder(3000);
		div_style = div_style.length() == 0 ? "width:100%" : div_style;
		sbStr.append("<div  id=\"page\"style=\"").append(div_style).append("\">\n");
		sbStr.append(String.format("			总共<b>%s</b>页<b>%s</b>条数据 第 <b>%s</b> 页\n", pagecount, intRecordCount, intCurrIndex));
		switch (pageType)
		{
		// 模式0 [第一页] [上一页] [下一页] [最后一页] 转到
		case Default:
			// 模式0
			if (intCurrIndex <= 1)
			{
				sbStr.append("			[第一页] [上一页] \n");
			}
			else
			{
				sbStr.append(String.format("[<a href=\"javascript:" + CurrentPageName + "('%s?%s%s=1')\">第一页</a>] \n", action, temp, page));
				sbStr.append(String.format("[<a href=\"javascript:" + CurrentPageName + "('%s?%s%s=%s')\">上一页</a>] \n", action, temp, page, intCurrIndex - 1));
			}
			if (intCurrIndex >= pagecount)
			{
				sbStr.append("[下一页] [最后一页]\n");
			}
			else
			{
				sbStr.append(String.format("[<a href=\"javascript:" + CurrentPageName + "('%s?%s%s=%s')\">下一页</a>] \n", action, temp, page, intCurrIndex + 1));
				sbStr.append(String.format("[<a href=\"javascript:" + CurrentPageName + "('%s?%s%s=%s')\">最后一页</a>]\n", action, temp, page, pagecount));
			}
			// sbStr.append("<input type=\"text\" value=\"").append(intCurrIndex).append("\" name=\"intCurrIndex\" onKeyUp=\"intCurrIndexChange(this.value)\" onKeyDown=\"if(event.keyCode==13){if(doCheck()){event.returnValue=false;gotoPage();}else{event.returnValue=false;}}\" style=\"width:30px;\" />\n");
			// sbStr.append("<input type=\"Button\" name=\"ColorWingGotoPage\" value=\"转到\" onClick=\"gotoPage()\" />\n");

			sbStr.append("</div>\n");// 结束div
			// sbStr.append("<script type=\"text/javascript\">\n");
			// sbStr.append("function intCurrIndexChange(topage){var objs=document.getElementsByName(\n");
			// sbStr.append("\"intCurrIndex\");for(var i=0;i<objs.length;i++)objs[i].value=topage;}function\n");
			// sbStr.append("getintCurrIndex(){var objs=document.getElementsByName(\"intCurrIndex\");for(var i\n");
			// sbStr.append("=0;i<objs.length;i++)return objs[i];}function doCheck(){var r=new RegExp(\n");
			// sbStr.append("\"^\\\\s*(\\\\d+)\\\\s*$\");if(r.test(getintCurrIndex().value)){if(RegExp. $1<1||\n");
			// sbStr.append("RegExp. $1>").append(pagecount).append("){alert(\"页数超出范围！\");getintCurrIndex().select();return false;}\n");
			// sbStr.append("return true;}alert(\"页索引无效！\");getintCurrIndex().select();return false;}\n");
			// sbStr.append("function gotoPage(){if(doCheck(getintCurrIndex())){location.href=BuildUrlString\n");
			// sbStr.append("('").append(page).append("',getintCurrIndex().value)}}function BuildUrlString(key,value){var _key=\n");
			// sbStr.append("key.toLowerCase();var prms=location.search;if(prms.length==0)return\n");
			// sbStr.append("location.pathname+\"?\"+_key+\"=\"+value;var params=prms.substring(1).split(\"&\");\n");
			// sbStr.append("var newparam=\"\";var found=false;for(i=0;i<params.length;i++){if(params[i].split\n");
			// sbStr.append("(\"=\")[0].toLowerCase()==_key){params[i]=_key+\"=\"+value;found=true;break;}}if(\n");
			// sbStr.append("found)return location.pathname+\"?\"+params.join(\"&\");else return location+\"&\"+\n");
			// sbStr.append("_key+\"=\"+value;}\n");
			// sbStr.append("</script>\n");

			break;
		case Select:
			// 模式1
			sbStr.append("<select name=\"toPage\" onchange=\"" + CurrentPageName + "(this.value);\\n");
			for (int i = 1; i <= pagecount; i++)
			{
				sbStr.append(String.format("<option value=\"%s?%s%s=%s\"%4$s>页面: %3$s / %5$s</option>\n", action, temp, page, i, i == intCurrIndex ? "selected=\"selected\"" : "", pagecount));
			}

			sbStr.append("</option>");
			sbStr.append("</div>\n");// 结束div

			break;
		case Number:
			// 模式2
			for (int i = 1; i <= pagecount; i++)
			{
				sbStr.append(String.format("[<a href=\"javascript:" + CurrentPageName + "('%s?%s%s=%s')\">%3$s</a>] ", action, temp, page, i));
			}
			sbStr.append("</div>\n");// 结束div

			break;
		case NumberAndDefault:

			// 模式0
			if (intCurrIndex <= 1)
			{
				sbStr.append("			[第一页] [上一页] \n");
			}
			else
			{
				sbStr.append(String.format("[<a href=\"javascript:" + CurrentPageName + "('%s?%s%s=1')\">第一页</a>] \n", action, temp, page));
				sbStr.append(String.format("[<a href=\"javascript:" + CurrentPageName + "('%s?%s%s=%s')\">上一页</a>] \n", action, temp, page, intCurrIndex - 1));
			}
			// 模式2
			int star = 0;
			int end = pagecount;
			star = intCurrIndex - 2 < 1 ? 1 : intCurrIndex - 2;
			end = star + 4 > pagecount ? pagecount : star + 4;
			for (int i = star; i <= end; i++)
			{
				if (intCurrIndex == i)
				{
					// sbStr.append(String.format("[{3}] ", action, temp, page,
					// i));
					sbStr.append(String.format("[%s] ", i));
				}
				else
				{
					sbStr.append(String.format("[<a href=\"javascript:" + CurrentPageName + "('%s?%s%s=%s')\">%s</a>] ", action, temp, page, i, i));
				}
			}

			if (intCurrIndex >= pagecount)
			{
				sbStr.append("[下一页] [最后一页]\n");
			}
			else
			{
				sbStr.append(String.format("[<a href=\"javascript:" + CurrentPageName + "('%s?%s%s=%s')\">下一页</a>] \n", action, temp, page, intCurrIndex + 1));
				sbStr.append(String.format("[<a href=\"javascript:" + CurrentPageName + "('%s?%s%s=%s')\">最后一页</a>]\n", action, temp, page, pagecount));
			}
			// sbStr.append("<input type=\"text\" value=\"").append(intCurrIndex).append("\" name=\"intCurrIndex\" onKeyUp=\"intCurrIndexChange(this.value)\" onKeyDown=\"if(event.keyCode==13){if(doCheck()){event.returnValue=false;gotoPage();}else{event.returnValue=false;}}\" style=\"width:30px;\" />\n");
			// sbStr.append("<input type=\"Button\" name=\"ColorWingGotoPage\" value=\"转到\" onClick=\"gotoPage()\" />\n");

			sbStr.append("</div>\n");// 结束div
			// sbStr.append("<script type=\"text/javascript\">\n");
			// sbStr.append("function intCurrIndexChange(topage){var objs=document.getElementsByName(\n");
			// sbStr.append("\"intCurrIndex\");for(var i=0;i<objs.length;i++)objs[i].value=topage;}function\n");
			// sbStr.append("getintCurrIndex(){var objs=document.getElementsByName(\"intCurrIndex\");for(var i\n");
			// sbStr.append("=0;i<objs.length;i++)return objs[i];}function doCheck(){var r=new RegExp(\n");
			// sbStr.append("\"^\\\\s*(\\\\d+)\\\\s*$\");if(r.test(getintCurrIndex().value)){if(RegExp. $1<1||\n");
			// sbStr.append("RegExp. $1>").append(pagecount).append("){alert(\"页数超出范围！\");getintCurrIndex().select();return false;}\n");
			// sbStr.append("return true;}alert(\"页索引无效！\");getintCurrIndex().select();return false;}\n");
			// sbStr.append("function gotoPage(){if(doCheck(getintCurrIndex())){location.href=BuildUrlString\n");
			// sbStr.append("('").append(page).append("',getintCurrIndex().value)}}function BuildUrlString(key,value){var _key=\n");
			// sbStr.append("key.toLowerCase();var prms=location.search;if(prms.length==0)return\n");
			// sbStr.append("location.pathname+\"?\"+_key+\"=\"+value;var params=prms.substring(1).split(\"&\");\n");
			// sbStr.append("var newparam=\"\";var found=false;for(i=0;i<params.length;i++){if(params[i].split\n");
			// sbStr.append("(\"=\")[0].toLowerCase()==_key){params[i]=_key+\"=\"+value;found=true;break;}}if(\n");
			// sbStr.append("found)return location.pathname+\"?\"+params.join(\"&\");else return location+\"&\"+\n");
			// sbStr.append("_key+\"=\"+value;}\n");
			// sbStr.append("</script>\n");

			break;
		case LeftAndRight:
			
			break;
		}
		
		return sbStr.toString();
	}

	// [end]

	// [start] 分页代码生成 适合静态页面
	/**
	 * 分页代码生成 适合静态页面
	 *
	 * @param pageIndex页码
	 * @param pageSize页面大小
	 * @param recordCount页面记录数
	 * @param pageNum显示的页数
	 * @param prefix页面前缀例如Article_
	 * @param suffix页面后缀例如.html
	 * @param cssClass页码的ClassName
	 * @param selectedClassName当前页面的
	 *            css 的className
	 */
	public static String Pager2(int pageIndex, int pageSize, int recordCount, int pageNum, String prefix, String suffix, String cssClass, String selectedClassName)
	{
		int pageCount = 1;
		if (recordCount % pageSize == 0)
			pageCount = recordCount / pageSize;
		else
			pageCount = recordCount / pageSize + 1;
		int beginPageIndex = 1;
		int endPageIndex = pageCount;
		StringBuilder sb = new StringBuilder();
		int pageHalf = pageNum / 2;
		if (pageHalf >= pageIndex)
		{
			beginPageIndex = 1;
		}
		else
		{
			beginPageIndex = pageIndex - pageHalf;

		}
		// MessageBox.Show(pageCount.toString());
		// MessageBox.Show(pageHalf.toString());
		endPageIndex = pageIndex + pageHalf;
		if (endPageIndex > pageCount)
			endPageIndex = pageCount;
		if (pageIndex > pageHalf + 1)
		{
			sb.append(String.format(" <a href='%s?%s' class='PageBegin'>&lt;&lt;</a> ", prefix, suffix));
		}
		if (pageIndex >= 2)
		{
			sb.append(String.format("<a href='%s?%s%s' class='PagePrefix'>&lt;</a>", prefix, pageIndex - 1 <= 1 ? "1" : (pageIndex - 1), suffix));
		}
		// MessageBox.Show(endPageIndex.toString());
		for (int i = beginPageIndex; i <= endPageIndex; i++)
		{
			if (i != pageIndex)
			{
				if (i >= 2)
				{
					if (cssClass == null || cssClass.length() <= 0)
					{
						sb.append(String.format(" <a href='%s?%s%s'>%s</a> ", prefix, i, suffix, i));
					}
					else
					{
						sb.append(String.format(" <a href='%s?%s%s' class='%s'>%s</a> ", prefix, i, suffix, cssClass, i));
					}
				}
				else
				{
					if (cssClass == null || cssClass.length() <= 0)
					{
						sb.append(String.format(" <a href='%s?%s'>%s</a> ", prefix, suffix, "1"));
					}
					else
					{
						sb.append(String.format(" <a href='%s?%s' class='%s'>%s</a> ", prefix, suffix, cssClass, i));
					}
				}
			}
			else
			{
				if (selectedClassName == null || selectedClassName.length() <= 0)
				{
					sb.append(String.format(" <span>%s</span> ", i));
				}
				else
				{
					sb.append(String.format(" <span class='%s'>{1}</span> ", selectedClassName, i));
				}
			}
		}
		if (pageIndex < endPageIndex)
		{
			sb.append(String.format(" <a href='%s?%s%s' class='PageNext'>&gt;</a> ", prefix, (pageIndex + 1), suffix));
		}
		if (endPageIndex < pageCount)
		{
			sb.append(String.format(" <a href='%s?%s%s' class='PageEnd'>&gt;&gt;</a> ", prefix, pageCount, suffix));
		}
		sb.append(String.format(" <span class='pagerinfo'>共%s条 分%s页</span>", recordCount, pageCount));
		return sb.toString();
	}

	// [end]

	// [start] LastNextPage 分页显示
	/**
	 * 使用字符串的分页函数
	 *
	 * @param page分页字符串的标识字符
	 * @param intPageSize每页显示的条数
	 * @param intRecordCount总条数
	 */
	public static String getCurrentlyPage(HttpServletRequest request, String pagetype, String pagetypeNewValue)
	{
		String action = request.getRequestURL().toString();

		String[] query = { "" };
		if (request.getQueryString() != null)
			query = request.getQueryString().split("&");
		StringBuilder sbStrtemp = new StringBuilder(100);
		for (String x : query)
		{
			if (x != "")
			{
				String[] a = x.split("=");
				if (a.length == 2 && a[0].toLowerCase().equals(pagetype.toLowerCase()) == false)
				{
					// temp = temp + a[0] + "=" + a[1] + "&";
					if (a.length > 1)
						sbStrtemp.append(a[0]).append("=").append(a[1]).append("&");
					else
						sbStrtemp.append(a[0]).append("=&");
				}
			}
		}
		return action + "?" + pagetype + "=" + pagetypeNewValue + "&" + sbStrtemp.toString();
	}
	// [end]
	
	//获得reqeust的  params
	//[START]
	public static String getCurrentlyParams(HttpServletRequest request)
	{
		String action = request.getRequestURL().toString();
		
		String[] query = { "" };
		if (request.getQueryString() != null)
		{	
			
			String QueryString=request.getQueryString();
			int start=QueryString.indexOf("?");
			if(start!=-1)
			{
				QueryString=QueryString.substring(QueryString.indexOf("?")+1,QueryString.length());
			}
			query = QueryString.split("&");
		}
		StringBuilder sbStrtemp = new StringBuilder(100);
		for (String x : query)
		{	
			if (x != "")
			{
				String[] a = x.split("=");
				if (a.length == 2 && a[0].toLowerCase().equals("pagetype") == false&& !a[0].equals("OrderByItem")&& !a[0].equals("OrderByItemDESC")&& !a[0].equals("page")&&!a[0].equals("databaseenterpriseid")&&!a[0].equals("databaseprojectid")&&!a[0].equals("databasetalentid"))
				{
					// temp = temp + a[0] + "=" + a[1] + "&";
					if (a.length > 1)
						sbStrtemp.append(a[0]).append("=").append(a[1]).append("&");
					else
						sbStrtemp.append(a[0]).append("=&");
				}
			}
		}
		
		return action + "?"+ sbStrtemp.toString();
	}
}