package com.yun.ui.action.ajax;

import java.util.Date;

public class SystemAdminForAdmin
{


	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。
	 * 在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，
	 * 如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012121909282873980L;

	// [start] Methods 全局变量
    /**
	 * 当前的页面列表数量
    */
	public int pageSize = com.yun.configuration.WebConfig.PAGE_SIZE;//当前的页面列表数量

    /**
	 * 页面分割的参数
    */
	public String pageParameter = "page";//页面分割的参数


	/**
	 * request请求对象
	 */
	javax.servlet.http.HttpServletRequest request = null;
	/**
	 * response响应对象
	 */
	javax.servlet.http.HttpServletResponse response = null;
	/**
	 * 向文本输出流打印对象的格式化表示形式。
	 */
	java.io.PrintWriter out = null;

	// [end]
	// [start] getpageListUrl
	private String getpageListUrl()
	{
        int pageIndex = com.colorwinglib.Requests.GetInt(request, pageParameter, 1);//当前的页数
        String pageListOrderByItem = com.colorwinglib.Requests.GetString(request, "OrderByItem", "DatabaseAdminID");//排序排序的字段名
        String pageListOrderByItemDESC = com.colorwinglib.Requests.GetString(request, "OrderByItemDESC", "DESC");//排序排序的顺序 DESC ASC
        String pageListOrderByItemDESCNo = pageListOrderByItemDESC.toLowerCase().equals("desc") ? "asc" : "desc";//排序排序的顺序 DESC ASC 的反顺序
        String pageListUrlOrderBy = String.format("%s=%s", pageParameter, pageIndex);//排序的?后的地址 (注意，这里一般要根据实际情况修改)
        String pageListUrl = String.format("%s&OrderByItem=%s&OrderByItemDESC=%s", pageListUrlOrderBy, pageListOrderByItem, pageListOrderByItemDESC);//显示列表的?后的地址 (注意，这里一般要根据实际情况修改)


		request.setAttribute("pageListOrderByItem", pageListOrderByItem);
		request.setAttribute("pageListOrderByItemDESC", pageListOrderByItemDESC);
		request.setAttribute("pageListOrderByItemDESCNo", pageListOrderByItemDESCNo);
		request.setAttribute("pageListUrlOrderBy", pageListUrlOrderBy);
		request.setAttribute("pageListUrl", pageListUrl);

		return pageListUrl;
	}
	// [end]

	// [start] execute
	public String execute() throws Exception
	{
		// 首先执行父类的execute程序，可以初始化一些公共函数，不过这要你自己来实现一个父类，然后继承父类
		//super.execute();
		//com.opensymphony.xwork2.ActionContext ctx = com.opensymphony.xwork2.ActionContext.getContext();
		this.request = org.apache.struts2.ServletActionContext.getRequest();
		this.response = org.apache.struts2.ServletActionContext.getResponse();

		String af = null;
		response.setCharacterEncoding("utf-8");//设定使用utf-8编码显示
		this.out = response.getWriter();
		String pageListUrl = getpageListUrl();
    
    // 表主键字段
		int Databaseadminid =  com.colorwinglib.Requests.GetInt(request, "databaseadminid",0);//人员ID  数据类型:int
    


		String pagetype = com.colorwinglib.Requests.GetString(request, "pagetype").toLowerCase();
		if (pagetype.equals("insert"))// 执行添加数据写入数据库
		{
			insert();
		}
		else if (pagetype.equals("gotoupdate"))// 转到更新数据页面显示更新数据的输入框
		{
			ItemCommandEdit();
		}
		else if (pagetype.equals("update"))// 更新数据库
		{
			update();
		}
		else if (pagetype.equals("delete"))// 删除数据库中的数据
		{
			delete();
		}
		else if (pagetype.equals("details"))// 转到显示详细地址页面
		{
			ItemCommandDetails();
		}
		else// 显示数据列表
		{
			//DrpInit();
			ListShow();
		}
		return null;
    }
	// [end]
    

	// [start] 下拉列表初始化
    protected void DrpInit()
    {

        // [start] 性别：1-男、2-女
        StringBuilder sbSex = new StringBuilder(100);
        for (com.yun.bll.itemcollection.ItemInfo itemInfo : com.yun.bll.itemcollection.culture.SystemAdminItemCollection.SexCollection())
        {
            sbSex.append(String.format("<option value=\"%1$s\">%2$s</option>\n", itemInfo.getValue(), itemInfo.getText()));
        }
		request.setAttribute("Sex", 0);// 性别：1-男、2-女 数据类型:int
		request.setAttribute("SexEdit", sbSex.toString());
		request.setAttribute("SexList", sbSex.toString());
        // [end]
        // [start] 启用标志：1-启用、2-未启用
        StringBuilder sbIsUse = new StringBuilder(100);
        for (com.yun.bll.itemcollection.ItemInfo itemInfo : com.yun.bll.itemcollection.culture.SystemAdminItemCollection.IsUseCollection())
        {
            sbIsUse.append(String.format("<option value=\"%1$s\">%2$s</option>\n", itemInfo.getValue(), itemInfo.getText()));
        }
		request.setAttribute("IsUse", 0);// 启用标志：1-启用、2-未启用 数据类型:int
		request.setAttribute("IsUseEdit", sbIsUse.toString());
		request.setAttribute("IsUseList", sbIsUse.toString());
        // [end]
        // [start] 是否删除：1-未删除、2-已删除
        StringBuilder sbIsDel = new StringBuilder(100);
        for (com.yun.bll.itemcollection.ItemInfo itemInfo : com.yun.bll.itemcollection.culture.SystemAdminItemCollection.IsDelCollection())
        {
            sbIsDel.append(String.format("<option value=\"%1$s\">%2$s</option>\n", itemInfo.getValue(), itemInfo.getText()));
        }
		request.setAttribute("IsDel", 0);// 是否删除：1-未删除、2-已删除 数据类型:int
		request.setAttribute("IsDelEdit", sbIsDel.toString());
		request.setAttribute("IsDelList", sbIsDel.toString());
        // [end]
    }
	// [end]

	// [start] ListShow 显示数据列表
    protected void ListShow()
    {
		String pageListUrl = getpageListUrl();
    
        String OrderBy = "";//排序语句
        String pageListOrderByItem = com.colorwinglib.Requests.GetString(request, "OrderByItem", "DatabaseAdminID");//排序排序的字段名
        String pageListOrderByItemDESC = com.colorwinglib.Requests.GetString(request, "OrderByItemDESC", "DESC");//排序排序的顺序 DESC ASC
        if (pageListOrderByItem.length() > 0)
        {
              OrderBy = String.format("%s %s", pageListOrderByItem, pageListOrderByItemDESC);//排序语句
        }
        out.write("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"tbList\">\n");
        out.write("<tr>\n");
        out.write("    <td>\n");
        out.write("    人员ID\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    人员编号\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    帐号\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    密码\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    性别\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    姓名\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    工号\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    联系EMAIL\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    移动电话\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    电话\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    MSN\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    角色编号\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    部门编号\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    人员描述\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    通讯地址\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    限定IP\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    最后登录时间\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    最后登录IP\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    创建时间\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    最后修改时间\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    启用标志\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    是否删除\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    拥有权限\n");
        out.write("    </td>\n");
        out.write("    <td>\n");
        out.write("    操作\n");
        out.write("    </td>\n");
        out.write("</tr>\n");

        int pageIndex = com.colorwinglib.Requests.GetInt(request, pageParameter, 1);//当前的页数
        int pageAll = 0;
        pageAll = com.yun.bll.culture.SystemAdminProvider.GetListPagerBy();
        com.yun.entities.culture.collection.SystemAdminInfoCollection SystemAdminColl = com.yun.bll.culture.SystemAdminProvider.GetListPagerBy(OrderBy,pageIndex, pageSize);
        for (com.yun.entities.culture.SystemAdminInfo objSystemAdminInfo : SystemAdminColl)
        {
            out.write("<tr>\n");
            //人员ID
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getDatabaseadminid()));
            out.write("    </td>\n");

            //人员编号
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getAdminid()));
            out.write("    </td>\n");

            //帐号
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getAdminname()));
            out.write("    </td>\n");

            //密码
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getAdminpassword()));
            out.write("    </td>\n");

            //性别：1-男、2-女
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getSexlabel()));
            out.write("    </td>\n");

            //姓名
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getTruename()));
            out.write("    </td>\n");

            //工号
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getWorkno()));
            out.write("    </td>\n");

            //联系EMAIL
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getEmail()));
            out.write("    </td>\n");

            //移动电话
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getMovephone()));
            out.write("    </td>\n");

            //电话
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getPhone()));
            out.write("    </td>\n");

            //MSN
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getMsn()));
            out.write("    </td>\n");

            //角色编号
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getRolesid()));
            out.write("    </td>\n");

            //部门编号
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getSectorid()));
            out.write("    </td>\n");

            //人员描述
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getDescription()));
            out.write("    </td>\n");

            //通讯地址
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getAddress()));
            out.write("    </td>\n");

            //限定IP
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getLimitIp()));
            out.write("    </td>\n");

            //最后登录时间
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getLastLogintime()));
            out.write("    </td>\n");

            //最后登录IP
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getLastLoginip()));
            out.write("    </td>\n");

            //创建时间
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getCreateTime()));
            out.write("    </td>\n");

            //最后修改时间
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getLastModifytime()));
            out.write("    </td>\n");

            //启用标志：1-启用、2-未启用
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getIsUselabel()));
            out.write("    </td>\n");

            //是否删除：1-未删除、2-已删除
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getIsDellabel()));
            out.write("    </td>\n");

            //拥有权限
            out.write("    <td>\n");
            out.write(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getCompetence()));
            out.write("    </td>\n");

            out.write("    <td>\n");
            out.write("            <a href=\"SystemAdminDetails.jsp?pagetype=Details&" + pageListUrl + "&databaseadminid=" + com.colorwinglib.StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getDatabaseadminid())) + "\">显示详细</a>\n");
            out.write("            <a href=\"SystemAdminEdit.jsp?pagetype=gotoupdate&" + pageListUrl + "&databaseadminid=" + com.colorwinglib.StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getDatabaseadminid())) + "\">编辑</a>\n");
            out.write("            <a href=\"SystemAdminList.jsp?pagetype=delete&" + pageListUrl + "&databaseadminid=" + com.colorwinglib.StringFormat.UrlEncode(com.colorwinglib.Converts.objToStr(objSystemAdminInfo.getDatabaseadminid())) + "\">删除</a>\n");
            out.write("    </td>\n");
            out.write("</tr>\n");
        }
        out.write("</table>\n");
        //输出分页信息
        String pageDetails = "";
        if (pageAll > pageSize)
            //out.write(com.yun.common.Pager.LastNextPage(request, response, pageParameter, pageSize, pageAll, "实际调用页面.jsp"));
            out.write(com.yun.common.Pager.LastNextPageByAjax(request, response, pageParameter, pageSize, pageAll));
            //out.write(com.yun.common.Pager.LastNextPageByAjax(request, response, pageParameter, pageSize, pageAll, "SystemAdminAjaxPage"));
		//显示数据不存在的消息
		if (pageAll == 0)
		{
			request.setAttribute("tbListHid", "display: none");
			java.util.HashMap<String,Object> valueMap = new java.util.HashMap<String,Object>();
			valueMap.put("text", "系统人员表");
			request.setAttribute("tbListHidShowMessage", com.yun.common.Message.GetMessage(com.yun.common.Message.I0000001, valueMap));
		}
    }
	// [end]
    

	// [start] ItemCommandEdit 转到编辑
    protected void ItemCommandEdit()
    {
    // 表主键字段
		int Databaseadminid =  com.colorwinglib.Requests.GetInt(request, "databaseadminid",0);//人员ID  数据类型:int
    
		String pageListUrl = getpageListUrl();
    
		com.yun.entities.culture.SystemAdminInfo objSystemAdminInfo = com.yun.bll.culture.SystemAdminProvider.GetSystemAdminInfoByDatabaseadminid(Databaseadminid);//实体类
        if (objSystemAdminInfo != null)
        {
				out.write("strUrl=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.ToUrlEncodeLinkString()) + "\";");//数据的Url编码字段
				//out.write("s[0]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getDatabaseadminid()) + "\";");//人员ID  数据类型:int
				//out.write("s[1]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getAdminid()) + "\";");//人员编号  数据类型:int
				//out.write("s[2]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getAdminname()) + "\";");//帐号  数据类型:String
				//out.write("s[3]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getAdminpassword()) + "\";");//密码  数据类型:String
				//out.write("s[4]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getSex()) + "\";");//性别：1-男、2-女  数据类型:int
				//out.write("s[5]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getTruename()) + "\";");//姓名  数据类型:String
				//out.write("s[6]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getWorkno()) + "\";");//工号  数据类型:String
				//out.write("s[7]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getEmail()) + "\";");//联系EMAIL  数据类型:String
				//out.write("s[8]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getMovephone()) + "\";");//移动电话  数据类型:String
				//out.write("s[9]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getPhone()) + "\";");//电话  数据类型:String
				//out.write("s[10]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getMsn()) + "\";");//MSN  数据类型:String
				//out.write("s[11]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getRolesid()) + "\";");//角色编号  数据类型:int
				//out.write("s[12]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getSectorid()) + "\";");//部门编号  数据类型:int
				//out.write("s[13]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getDescription()) + "\";");//人员描述  数据类型:String
				//out.write("s[14]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getAddress()) + "\";");//通讯地址  数据类型:String
				//out.write("s[15]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getLimitIp()) + "\";");//限定IP  数据类型:String
				//out.write("s[16]=\"" + com.colorwinglib.StringFormat.JsEncode(com.colorwinglib.Converts.DateToString(objSystemAdminInfo.getLastLogintime(),"yyyy-MM-dd")) + "\";");//最后登录时间  数据类型:Date
				//out.write("s[17]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getLastLoginip()) + "\";");//最后登录IP  数据类型:String
				//out.write("s[18]=\"" + com.colorwinglib.StringFormat.JsEncode(com.colorwinglib.Converts.DateToString(objSystemAdminInfo.getCreateTime(),"yyyy-MM-dd")) + "\";");//创建时间  数据类型:Date
				//out.write("s[19]=\"" + com.colorwinglib.StringFormat.JsEncode(com.colorwinglib.Converts.DateToString(objSystemAdminInfo.getLastModifytime(),"yyyy-MM-dd")) + "\";");//最后修改时间  数据类型:Date
				//out.write("s[20]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getIsUse()) + "\";");//启用标志：1-启用、2-未启用  数据类型:int
				//out.write("s[21]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getIsDel()) + "\";");//是否删除：1-未删除、2-已删除  数据类型:int
				//out.write("s[22]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getCompetence()) + "\";");//拥有权限  数据类型:String
        }
        else
        {
			if (com.colorwinglib.Requests.GetInt(request, "isFlash") == 1)
			{
			  out.write("messageID=1&message=" + com.yun.common.Message.GetMessage(com.yun.common.Message.I0000005) + "");
			}
			else
			{
			  out.write("messageID = 1;message ='" + com.yun.common.Message.GetMessage(com.yun.common.Message.I0000005) + "';");
			}
        }
    }
	// [end]
    

	// [start] ItemCommandDetails 转到展示
    protected void ItemCommandDetails()
    {
    // 表主键字段
		int Databaseadminid =  com.colorwinglib.Requests.GetInt(request, "databaseadminid",0);//人员ID  数据类型:int
    
		String pageListUrl = getpageListUrl();
    
		com.yun.entities.culture.SystemAdminInfo objSystemAdminInfo = com.yun.bll.culture.SystemAdminProvider.GetSystemAdminInfoByDatabaseadminid(Databaseadminid);//实体类
        if (objSystemAdminInfo != null)
        {
				out.write("strUrl=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.ToUrlEncodeLinkString()) + "\";");//数据的Url编码字段
				//out.write("s[0]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getDatabaseadminid()) + "\";");//人员ID  数据类型:int
				//out.write("s[1]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getAdminid()) + "\";");//人员编号  数据类型:int
				//out.write("s[2]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getAdminname()) + "\";");//帐号  数据类型:String
				//out.write("s[3]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getAdminpassword()) + "\";");//密码  数据类型:String
				//out.write("s[4]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getSex()) + "\";");//性别：1-男、2-女  数据类型:int
				//out.write("s[5]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getTruename()) + "\";");//姓名  数据类型:String
				//out.write("s[6]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getWorkno()) + "\";");//工号  数据类型:String
				//out.write("s[7]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getEmail()) + "\";");//联系EMAIL  数据类型:String
				//out.write("s[8]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getMovephone()) + "\";");//移动电话  数据类型:String
				//out.write("s[9]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getPhone()) + "\";");//电话  数据类型:String
				//out.write("s[10]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getMsn()) + "\";");//MSN  数据类型:String
				//out.write("s[11]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getRolesid()) + "\";");//角色编号  数据类型:int
				//out.write("s[12]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getSectorid()) + "\";");//部门编号  数据类型:int
				//out.write("s[13]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getDescription()) + "\";");//人员描述  数据类型:String
				//out.write("s[14]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getAddress()) + "\";");//通讯地址  数据类型:String
				//out.write("s[15]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getLimitIp()) + "\";");//限定IP  数据类型:String
				//out.write("s[16]=\"" + com.colorwinglib.StringFormat.JsEncode(com.colorwinglib.Converts.DateToString(objSystemAdminInfo.getLastLogintime(),"yyyy-MM-dd")) + "\";");//最后登录时间  数据类型:Date
				//out.write("s[17]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getLastLoginip()) + "\";");//最后登录IP  数据类型:String
				//out.write("s[18]=\"" + com.colorwinglib.StringFormat.JsEncode(com.colorwinglib.Converts.DateToString(objSystemAdminInfo.getCreateTime(),"yyyy-MM-dd")) + "\";");//创建时间  数据类型:Date
				//out.write("s[19]=\"" + com.colorwinglib.StringFormat.JsEncode(com.colorwinglib.Converts.DateToString(objSystemAdminInfo.getLastModifytime(),"yyyy-MM-dd")) + "\";");//最后修改时间  数据类型:Date
				//out.write("s[20]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getIsUse()) + "\";");//启用标志：1-启用、2-未启用  数据类型:int
				//out.write("s[21]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getIsDel()) + "\";");//是否删除：1-未删除、2-已删除  数据类型:int
				//out.write("s[22]=\"" + com.colorwinglib.StringFormat.JsEncode(objSystemAdminInfo.getCompetence()) + "\";");//拥有权限  数据类型:String
        }
        else
        {
			if (com.colorwinglib.Requests.GetInt(request, "isFlash") == 1)
			{
			  out.write("messageID=1&message=" + com.yun.common.Message.GetMessage(com.yun.common.Message.I0000005) + "");
			}
			else
			{
			  out.write("messageID = 1;message ='" + com.yun.common.Message.GetMessage(com.yun.common.Message.I0000005) + "';");
			}
        }
    }
	// [end]
    

	// [start] ServerValidate 服务器验证
    protected boolean ServerValidate()
    {		
    	return true;
//        java.util.HashMap<String,Object> valueMap = new java.util.HashMap<String,Object>();
//        StringBuilder sbStr = new StringBuilder(1024);
//        int i = 1;
//        // [start] 启用标志：1-启用、2-未启用
//        valueMap = new java.util.HashMap<String,Object>();
//        valueMap.put("label_name", "启用标志");
//        if (com.colorwinglib.Requests.GetString(request, "isUse").length() == 0)
//        {
//            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
//            i = i + 1;
//        }
//
//        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "isUse")))
//        {
//            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
//            i = i + 1;
//        }
//
//        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "isUse")),0,9999999))
//        {
//            valueMap.put("param1", 0);
//            valueMap.put("param2", 9999999);
//            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
//            i = i + 1;
//        }
//        // [end]
//        // [start] 是否删除：1-未删除、2-已删除
//        valueMap = new java.util.HashMap<String,Object>();
//        valueMap.put("label_name", "是否删除");
//        if (com.colorwinglib.Requests.GetString(request, "isDel").length() == 0)
//        {
//            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
//            i = i + 1;
//        }
//
//        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "isDel")))
//        {
//            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
//            i = i + 1;
//        }
//
//        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "isDel")),0,9999999))
//        {
//            valueMap.put("param1", 0);
//            valueMap.put("param2", 9999999);
//            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
//            i = i + 1;
//        }
//        // [end]
//      
//
//        if (i-1 > 0)
//        {
//			valueMap = new java.util.HashMap<String, Object>();
//			valueMap.put("n", (i - 1));
//            sbStr.append(com.yun.common.Message.GetMessage(com.yun.common.Message.I0000006, valueMap));
//				out.write(String.format("messageID = 2;message ='%1$s';", com.colorwinglib.StringFormat.JsEncode(sbStr.toString())));
//            return false;
//        }
//        else
//        {
//            return true;
//        }
    }
	// [end]
    

	// [start] insert 添加
    protected void insert()
    {
		String pageListUrl = getpageListUrl();
    
		int Databaseadminid =  com.colorwinglib.Requests.GetInt(request, "databaseadminid",0);//人员ID  数据类型:int
		int Adminid =  com.colorwinglib.Requests.GetInt(request, "adminid",0);//人员编号  数据类型:int
		String Adminname =  com.colorwinglib.Requests.GetString(request, "adminname","");//帐号  数据类型:String
		String Adminpassword =  com.colorwinglib.Requests.GetString(request, "adminpassword","");//密码  数据类型:String

		Date LastModifytime =  com.colorwinglib.Requests.GetDate(request, "lastModifytime",new Date());//最后修改时间  数据类型:Date
		int IsUse =  com.colorwinglib.Requests.GetInt(request, "isUse",0);//启用标志：1-启用、2-未启用  数据类型:int
		int IsDel =  com.colorwinglib.Requests.GetInt(request, "isDel",0);//是否删除：1-未删除、2-已删除  数据类型:int


        //服务器验证
        if (!ServerValidate())
        {
			//进行赋值验证失败时用
			DrpInit();
            return;
        }
        
		com.yun.entities.culture.SystemAdminInfo objSystemAdminInfo = new com.yun.entities.culture.SystemAdminInfo();//实体类
		objSystemAdminInfo.setDatabaseadminid(Databaseadminid);//人员ID  数据类型:int

		
		objSystemAdminInfo.setLastModifytime(LastModifytime);//最后修改时间  数据类型:Date
		objSystemAdminInfo.setIsUse(IsUse);//启用标志：1-启用、2-未启用  数据类型:int
		objSystemAdminInfo.setIsDel(IsDel);//是否删除：1-未删除、2-已删除  数据类型:int
		

        boolean isRun = com.yun.bll.culture.SystemAdminProvider.Insert(objSystemAdminInfo);

		if (isRun)
		{
		if (com.colorwinglib.Requests.GetInt(request, "isFlash") == 1)
		{
				out.write("messageID=1&message=" + com.yun.common.Message.GetMessage(com.yun.common.Message.I0000002) + "");
		}
		else
		{
				out.write("messageID = 1;message ='" + com.yun.common.Message.GetMessage(com.yun.common.Message.I0000002) + "';");
		}
		}
		else
		{
		if (com.colorwinglib.Requests.GetInt(request, "isFlash") == 1)
		{
				out.write("messageID=1&message=" + com.yun.common.Message.GetMessage(com.yun.common.Message.I0000009) + "");
		}
		else
		{
				out.write("messageID = 1;message ='" + com.yun.common.Message.GetMessage(com.yun.common.Message.I0000009) + "';");
		}
		}
        com.yun.bll.culture.SystemAdminProvider.setSystemAdminStatic(null);
    }
	// [end]
    

	// [start] update 更新
    protected void update()
    {	
    	
		String pageListUrl = getpageListUrl();
    
		int Databaseadminid = com.colorwinglib.Requests.GetInt(request, "databaseadminid",0);//人员ID  数据类型:int
		
		Date LastModifytime = com.colorwinglib.Requests.GetDate(request, "lastModifytime",new Date());//最后修改时间  数据类型:Date
		int IsUse = com.colorwinglib.Requests.GetInt(request, "isUse",0);//启用标志：1-启用、2-未启用  数据类型:int
		int IsDel = com.colorwinglib.Requests.GetInt(request, "isDel",0);//是否删除：1-未删除、2-已删除  数据类型:int


        //服务器验证
        if (!ServerValidate())
        {
			//进行赋值验证失败时用
			DrpInit();
            return;
        }


		com.yun.entities.culture.SystemAdminInfo objSystemAdminInfo = com.yun.bll.culture.SystemAdminProvider.GetSystemAdminInfoByDatabaseadminid(Databaseadminid);//实体类
		objSystemAdminInfo.setLastModifytime(LastModifytime);//最后修改时间  数据类型:Date
		if(IsUse!=0)
		{
			objSystemAdminInfo.setIsUse(IsUse);//启用标志：1-启用、2-未启用  数据类型:int
		}
		if(IsDel!=0)
		{
			objSystemAdminInfo.setIsDel(IsDel);//是否删除：1-未删除、2-已删除  数据类型:int
			objSystemAdminInfo.setAdminname("");
			objSystemAdminInfo.setAdminpassword("");
		}
        boolean isRun = com.yun.bll.culture.SystemAdminProvider.UpdateByDatabaseadminid(objSystemAdminInfo);

		if (isRun)
		{
		if (com.colorwinglib.Requests.GetInt(request, "isFlash") == 1)
		{
				out.write("messageID=1&message=" + com.yun.common.Message.GetMessage(com.yun.common.Message.I0000003) + "");
		}
		else
		{
				out.write("messageID = 1;message ='" + com.yun.common.Message.GetMessage(com.yun.common.Message.I0000003) + "';");
		}
		}
		else
		{
		if (com.colorwinglib.Requests.GetInt(request, "isFlash") == 1)
		{
				out.write("messageID=1&message=" + com.yun.common.Message.GetMessage(com.yun.common.Message.I0000011) + "");
		}
		else
		{
				out.write("messageID = 1;message ='" + com.yun.common.Message.GetMessage(com.yun.common.Message.I0000011) + "';");
		}
		}
        com.yun.bll.culture.SystemAdminProvider.setSystemAdminStatic(null);
    }
	// [end]
    

	// [start] delete 删除
    protected void delete()
    {
    // 表主键字段
//		int Databaseadminid =  com.colorwinglib.Requests.GetInt(request, "databaseadminid",0);//人员ID  数据类型:int
//    
//		String pageListUrl = getpageListUrl();
//    
//
//
//		boolean isRun = com.yun.bll.culture.SystemAdminProvider.DeleteByDatabaseadminid(Databaseadminid);//直接删除
//
//        com.yun.bll.culture.SystemAdminProvider.setSystemAdminStatic(null);
//		if (isRun)
//		{
//		if (com.colorwinglib.Requests.GetInt(request, "isFlash") == 1)
//		{
//				out.write("messageID=1&message=" + com.yun.common.Message.GetMessage(com.yun.common.Message.I0000007) + "");
//		}
//		else
//		{
//				out.write("messageID = 1;message ='" + com.yun.common.Message.GetMessage(com.yun.common.Message.I0000007) + "';");
//		}
//		}
//		else
//		{
//		if (com.colorwinglib.Requests.GetInt(request, "isFlash") == 1)
//		{
//				out.write("messageID=1&message=" + com.yun.common.Message.GetMessage(com.yun.common.Message.I0000008) + "");
//		}
//		else
//		{
//				out.write("messageID = 1;message ='" + com.yun.common.Message.GetMessage(com.yun.common.Message.I0000008) + "';");
//		}
//		}
    }
	// [end]
    


}

