﻿package com.yun.ui.action.dictionary;

import java.util.Date;

import com.colorwinglib.Requests;
import com.yun.bll.culture.TupiProvider;
import com.yun.configuration.WebConfig;
import com.yun.entities.culture.TupiInfo;
import com.yun.entities.culture.collection.TupiInfoCollection;

public class Tupi
{


	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。
	 * 在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，
	 * 如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120417065950068L;

	// [start] Methods 全局变量
    /**
	 * 当前的页面列表数量
    */
	public int pageSize = WebConfig.PAGE_SIZE;//当前的页面列表数量

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
        String pageListOrderByItem = com.colorwinglib.Requests.GetString(request, "OrderByItem", "TupidatabaseID");//排序排序的字段名
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
		int Tupidatabaseid =  com.colorwinglib.Requests.GetInt(request, "tupidatabaseid",0);//数据库ID  数据类型:int
    


		//页面的名字
		String pageName = "Tupi";
		String pagetype = com.colorwinglib.Requests.GetString(request, "pagetype").toLowerCase();
		if (pagetype.equals("gotoinsert"))// 转到添加数据页面显示添加数据的输入框
		{
			request.setAttribute("btnEditText", "添加数据");
			request.setAttribute("btnEditCommandArgument", com.yun.common.Pager.getCurrentlyPage(request, "pagetype", "insert"));
			DrpInit();
			af = (String.format("%sEdit", pageName));
		}
		else if (pagetype.equals("insert"))// 执行添加数据写入数据库
		{
			request.setAttribute("btnEditText", "添加数据");
			insert();
			ListShow();
			af = (String.format("%sEdit", pageName));
		}
		else if (pagetype.equals("gotoupdate"))// 转到更新数据页面显示更新数据的输入框
		{
			DrpInit();
			ItemCommandEdit();
			request.setAttribute("btnEditText", "更新数据");
			request.setAttribute("btnEditCommandArgument", com.yun.common.Pager.getCurrentlyPage(request, "pagetype", "update"));
			af = (String.format("%sEdit", pageName));
		}
		else if (pagetype.equals("update"))// 更新数据库
		{
			request.setAttribute("btnEditText", "更新数据");
			update();
			ItemCommandEdit();
			ListShow();
			af = (String.format("%sEdit", pageName));
		}
		else if (pagetype.equals("delete"))// 删除数据库中的数据
		{
			delete();
			af = (String.format("%sEdit", pageName));
		}
		else if (pagetype.equals("details"))// 转到显示详细地址页面
		{
			ItemCommandDetails();
			af = (String.format("%sDetails", pageName));
		}
		else
		// 显示数据列表
		{
			DrpInit();
			ListShow();
			af = (String.format("%sList", pageName));
		}
		return af;
    }
	// [end]
    

	// [start] 下拉列表初始化
    protected void DrpInit()
    {

    }
	// [end]

	// [start] ListShow 显示数据列表
    protected void ListShow()
    {
		String pageListUrl = getpageListUrl();
    
        String OrderBy = "";//排序语句
        String pageListOrderByItem = com.colorwinglib.Requests.GetString(request, "OrderByItem", "TupiID");//排序排序的字段名
        String pageListOrderByItemDESC = com.colorwinglib.Requests.GetString(request, "OrderByItemDESC", "DESC");//排序排序的顺序 DESC ASC
        if (pageListOrderByItem.length() > 0)
        {
              OrderBy = String.format("%s %s", pageListOrderByItem, pageListOrderByItemDESC);//排序语句
        }

        int pageIndex = com.colorwinglib.Requests.GetInt(request, pageParameter, 1);//当前的页数
        int pageAll = 0;
        pageAll = com.yun.bll.culture.TupiProvider.GetListPagerBy();
        com.yun.entities.culture.collection.TupiInfoCollection TupiColl = com.yun.bll.culture.TupiProvider.GetListPagerBy(OrderBy,pageIndex, pageSize);
		request.setAttribute("TupiList", TupiColl);
        //for (com.yun.entities.culture.TupiInfo objTupiInfo : TupiColl)
        //{
        //}


		// 输出分页信息
		String pageDetails = "";
		if (pageAll > pageSize)
		{
			pageDetails = com.yun.common.Pager.LastNextPage(request, response, pageParameter, pageSize, pageAll);
			//pageDetails = com.yun.common.Pager.LastNextPageByAjax(request, response, pageParameter, pageSize, pageAll, "TupiAjaxPage");
		}

		request.setAttribute("pageDetails", pageDetails);
		//显示数据不存在的消息
		if (pageAll == 0)
		{
			request.setAttribute("tbListHid", "display: none");
			java.util.HashMap<String,Object> valueMap = new java.util.HashMap<String,Object>();
			valueMap.put("text", "");
			request.setAttribute("tbListHidShowMessage", com.yun.common.Message.GetMessage(com.yun.common.Message.I0000001, valueMap));
		}
    }
	// [end]
    

	// [start] ItemCommandEdit 转到编辑
    protected void ItemCommandEdit()
    {
    // 表主键字段
		int Tupidatabaseid =  com.colorwinglib.Requests.GetInt(request, "tupidatabaseid",0);//数据库ID  数据类型:int
    
		String pageListUrl = getpageListUrl();
    
		com.yun.entities.culture.TupiInfo objTupiInfo = com.yun.bll.culture.TupiProvider.GetTupiInfoByTupidatabaseid(Tupidatabaseid);//实体类
        if (objTupiInfo != null)
        {
			request.setAttribute("Tupidatabaseid", objTupiInfo.getTupidatabaseid());//数据库ID  数据类型:int
			request.setAttribute("Tupiid", objTupiInfo.getTupiid());//土地批准ID  数据类型:int
			request.setAttribute("Tupiname", com.colorwinglib.StringFormat.HtmlEncode(objTupiInfo.getTupiname()));//TupiName  数据类型:String

        }
        else
        {
			String js = com.colorwinglib.Javascript.AlertAndRedirect(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000005), "?" + pageListUrl);
			request.setAttribute("pageJavaScripStar", js);
        }
    }
	// [end]
    

	// [start] ItemCommandDetails 转到展示
    protected void ItemCommandDetails()
    {
    // 表主键字段
		int Tupidatabaseid =  com.colorwinglib.Requests.GetInt(request, "tupidatabaseid",0);//数据库ID  数据类型:int
    
		String pageListUrl = getpageListUrl();
    
		com.yun.entities.culture.TupiInfo objTupiInfo = com.yun.bll.culture.TupiProvider.GetTupiInfoByTupidatabaseid(Tupidatabaseid);//实体类
        if (objTupiInfo != null)
        {
			request.setAttribute("Tupidatabaseid", objTupiInfo.getTupidatabaseid());//数据库ID  数据类型:int
			request.setAttribute("Tupiid", objTupiInfo.getTupiid());//土地批准ID  数据类型:int
			request.setAttribute("Tupiname", objTupiInfo.getTupiname());//TupiName  数据类型:String



			//扩展属性
			//obj扩展属性
        }
        else
        {
			String js = com.colorwinglib.Javascript.AlertAndRedirect(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000005), "?" + pageListUrl);
			request.setAttribute("pageJavaScripStar", js);
        }
    }
	// [end]
    

	// [start] ServerValidate 服务器验证
    protected boolean ServerValidate()
    {
        java.util.HashMap<String,Object> valueMap = new java.util.HashMap<String,Object>();
        StringBuilder sbStr = new StringBuilder(1024);
        int i = 1;
     
        // [start] 土地批准ID
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "土地批准ID");
        if (com.colorwinglib.Requests.GetString(request, "tupiid").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "tupiid")))
        {
            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "tupiid")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
            i = i + 1;
        }
        TupiInfoCollection tc=TupiProvider.GetListByTupiid(Requests.GetInt(this.request, "tupiid"));
        if(tc.size()>0)
        {
        	TupiInfo tupi=tc.get(0);
        	if(tupi.getTupidatabaseid()!=Requests.GetInt(this.request, "tupidatabaseid"))
        	{	
        		valueMap.put("param1", Requests.GetInt(this.request, "tupiid"));
        		sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000015, valueMap)));
                i = i + 1;
        	}
        }
        // [end]
        // [start] TupiName
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "TupiName");
        if (com.colorwinglib.Requests.GetString(request, "tupiname").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }
        if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "tupiname")) > 50)
        {
            valueMap.put("N", 50);
            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
            i = i + 1;
        }
        // [end]

        if (i-1 > 0)
        {
			valueMap = new java.util.HashMap<String, Object>();
			valueMap.put("n", (i - 1));
            sbStr.append(com.yun.common.Message.GetMessage(com.yun.common.Message.I0000006, valueMap));
			String js = com.colorwinglib.Javascript.Alert(request, response, sbStr.toString());
			request.setAttribute("pageJavaScripEnd", js);
			if (com.colorwinglib.Requests.GetInt(request, "isSaveAndNew") == 1)
			{
				request.setAttribute("btnEditCommandArgument", com.yun.common.Pager.getCurrentlyPage(request, "pagetype", "insert"));
			}
            return false;
        }
        else
        {
            return true;
        }
    }
	// [end]
    

	// [start] insert 添加
    protected void insert()
    {
		String pageListUrl = getpageListUrl();
    
		int Tupidatabaseid =  com.colorwinglib.Requests.GetInt(request, "tupidatabaseid",0);//数据库ID  数据类型:int
		int Tupiid =  com.colorwinglib.Requests.GetInt(request, "tupiid",0);//土地批准ID  数据类型:int
		String Tupiname =  com.colorwinglib.Requests.GetString(request, "tupiname","");//TupiName  数据类型:String

        //服务器验证
		this.request.setAttribute("pagetype", "insert");
        if (!ServerValidate())
        {
			//进行赋值验证失败时用
			DrpInit();
			request.setAttribute("Tupidatabaseid", Tupidatabaseid);//数据库ID  数据类型:int
			request.setAttribute("Tupiid", Tupiid);//土地批准ID  数据类型:int
			request.setAttribute("Tupiname", com.colorwinglib.StringFormat.HtmlEncode(Tupiname));//TupiName  数据类型:String
            return;
        }

		com.yun.entities.culture.TupiInfo objTupiInfo = new com.yun.entities.culture.TupiInfo();//实体类
		objTupiInfo.setTupidatabaseid(Tupidatabaseid);//数据库ID  数据类型:int
		objTupiInfo.setTupiid(Tupiid);//土地批准ID  数据类型:int
		objTupiInfo.setTupiname(Tupiname);//TupiName  数据类型:String

        boolean isRun = com.yun.bll.culture.TupiProvider.Insert(objTupiInfo);

		if (isRun)
		{
			String js = com.colorwinglib.Javascript.Alert(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000002));
		if (com.colorwinglib.Requests.GetInt(request, "isSaveAndNew") == 1)
		{
			js = com.colorwinglib.Javascript.Alert(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000002));
		}
			request.setAttribute("pageJavaScripStar", js);
		}
		else
		{
			String js = com.colorwinglib.Javascript.Alert(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000009));
		if (com.colorwinglib.Requests.GetInt(request, "isSaveAndNew") == 1)
		{
			js = com.colorwinglib.Javascript.Alert(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000009));
		}
			request.setAttribute("pageJavaScripStar", js);
		}
        com.yun.bll.culture.TupiProvider.setTupiStatic(null);
    }
	// [end]
    

	// [start] update 更新
    protected void update()
    {
		String pageListUrl = getpageListUrl();
    
		int Tupidatabaseid = com.colorwinglib.Requests.GetInt(request, "tupidatabaseid",0);//数据库ID  数据类型:int
		int Tupiid = com.colorwinglib.Requests.GetInt(request, "tupiid",0);//土地批准ID  数据类型:int
		String Tupiname = com.colorwinglib.Requests.GetString(request, "tupiname","");//TupiName  数据类型:String

        //服务器验证
		this.request.setAttribute("pagetype", "update");
        if (!ServerValidate())
        {
			//进行赋值验证失败时用
			DrpInit();
			request.setAttribute("Tupidatabaseid", Tupidatabaseid);//数据库ID  数据类型:int
			request.setAttribute("Tupiid", Tupiid);//土地批准ID  数据类型:int
			request.setAttribute("Tupiname", com.colorwinglib.StringFormat.HtmlEncode(Tupiname));//TupiName  数据类型:String
            return;
        }


		com.yun.entities.culture.TupiInfo objTupiInfo = com.yun.bll.culture.TupiProvider.GetTupiInfoByTupidatabaseid(Tupidatabaseid);//实体类
		objTupiInfo.setTupidatabaseid(Tupidatabaseid);//数据库ID  数据类型:int
		objTupiInfo.setTupiid(Tupiid);//土地批准ID  数据类型:int
		objTupiInfo.setTupiname(Tupiname);//TupiName  数据类型:String

        boolean isRun = com.yun.bll.culture.TupiProvider.UpdateByTupidatabaseid(objTupiInfo);

		if (isRun)
		{
			String js = com.colorwinglib.Javascript.Alert(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000003));
		if (com.colorwinglib.Requests.GetInt(request, "isSaveAndNew") == 1)
		{
			js = com.colorwinglib.Javascript.Alert(request, response,com.yun.common.Message.GetMessage(com.yun.common.Message.I0000003));
		}
			request.setAttribute("pageJavaScripStar", js);
		}
		else
		{
			String js = com.colorwinglib.Javascript.Alert(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000011));
		if (com.colorwinglib.Requests.GetInt(request, "isSaveAndNew") == 1)
		{
			js = com.colorwinglib.Javascript.Alert(request, response,com.yun.common.Message.GetMessage(com.yun.common.Message.I0000011));
		}
			request.setAttribute("pageJavaScripStar", js);
		}
        com.yun.bll.culture.TupiProvider.setTupiStatic(null);
    }
	// [end]
    

	// [start] delete 删除
    protected void delete()
    {
    // 表主键字段
		int Tupidatabaseid =  com.colorwinglib.Requests.GetInt(request, "tupidatabaseid",0);//数据库ID  数据类型:int
    
		String pageListUrl = getpageListUrl();
    


		boolean isRun = com.yun.bll.culture.TupiProvider.DeleteByTupidatabaseid(Tupidatabaseid);//直接删除

        com.yun.bll.culture.TupiProvider.setTupiStatic(null);
		if (isRun)
		{
			String js = com.colorwinglib.Javascript.AlertAndRedirect(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000007), "?" + pageListUrl);
			request.setAttribute("pageJavaScripStar", js);
		}
		else
		{
			String js = com.colorwinglib.Javascript.AlertAndRedirect(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000008), "?" + pageListUrl);
			request.setAttribute("pageJavaScripStar", js);
		}
    }
	// [end]
    


}

