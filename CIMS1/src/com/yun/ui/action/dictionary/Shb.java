package com.yun.ui.action.dictionary;

import java.util.Date;

import com.colorwinglib.Requests;
import com.yun.bll.culture.ShbProvider;
import com.yun.configuration.WebConfig;
import com.yun.entities.culture.ShbInfo;
import com.yun.entities.culture.collection.ShbInfoCollection;

public class Shb
{


	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。
	 * 在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，
	 * 如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120417074648481L;

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

	// [start] 实体类
	/**
	 * 实体类
	 */
	private com.yun.entities.culture.ShbInfo objShbInfo=new ShbInfo();

	public com.yun.entities.culture.ShbInfo getObjShbInfo()
	{
		return objShbInfo;
	}

	public void setObjAdminlogInfo(com.yun.entities.culture.ShbInfo objShbInfo)
	{
		this.objShbInfo = objShbInfo;
	}
	// [end]

	// [end]
	// [start] getpageListUrl
	private String getpageListUrl()
	{
        int pageIndex = com.colorwinglib.Requests.GetInt(request, pageParameter, 1);//当前的页数
        String pageListOrderByItem = com.colorwinglib.Requests.GetString(request, "OrderByItem", "shbdatabaseID");//排序排序的字段名
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
		int Shbdatabaseid =  com.colorwinglib.Requests.GetInt(request, "shbdatabaseid",0);//数据库ID  数据类型:int
    


		//页面的名字
		String pageName = "Shb";
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
			ListShow();
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
        String pageListOrderByItem = com.colorwinglib.Requests.GetString(request, "OrderByItem", "shbID");//排序排序的字段名
        String pageListOrderByItemDESC = com.colorwinglib.Requests.GetString(request, "OrderByItemDESC", "DESC");//排序排序的顺序 DESC ASC
        if (pageListOrderByItem.length() > 0)
        {
              OrderBy = String.format("%s %s", pageListOrderByItem, pageListOrderByItemDESC);//排序语句
        }

        int pageIndex = com.colorwinglib.Requests.GetInt(request, pageParameter, 1);//当前的页数
        int pageAll = 0;
        pageAll = com.yun.bll.culture.ShbProvider.GetListPagerBy();
        com.yun.entities.culture.collection.ShbInfoCollection ShbColl = com.yun.bll.culture.ShbProvider.GetListPagerBy(OrderBy,pageIndex, pageSize);
		request.setAttribute("ShbList", ShbColl);
        //for (com.yun.entities.culture.ShbInfo objShbInfo : ShbColl)
        //{
        //}


		// 输出分页信息
		String pageDetails = "";
		if (pageAll > pageSize)
			pageDetails = com.yun.common.Pager.LastNextPage(request, response, pageParameter, pageSize, pageAll);

		request.setAttribute("pageDetails", pageDetails);
    }
	// [end]
    

	// [start] ItemCommandEdit 转到编辑
    protected void ItemCommandEdit()
    {
    // 表主键字段
		int Shbdatabaseid =  objShbInfo.getShbdatabaseid();//数据库ID  数据类型:int
    
		String pageListUrl = getpageListUrl();
    
		objShbInfo = com.yun.bll.culture.ShbProvider.GetShbInfoByShbdatabaseid(Shbdatabaseid);//实体类
        if (objShbInfo != null)
        {
        }
        else
        {
			String js = com.colorwinglib.Javascript.AlertAndRedirect(request, response, "内容不存在", "?" + pageListUrl);
			request.setAttribute("pageJavaScripStar", js);
        }
    }
	// [end]
    

	// [start] ItemCommandDetails 转到展示
    protected void ItemCommandDetails()
    {
    // 表主键字段
		int Shbdatabaseid =  objShbInfo.getShbdatabaseid();//数据库ID  数据类型:int
    
		String pageListUrl = getpageListUrl();
    
		objShbInfo = com.yun.bll.culture.ShbProvider.GetShbInfoByShbdatabaseid(Shbdatabaseid);//实体类
        if (objShbInfo != null)
        {

			//扩展属性
			//obj扩展属性
        }
        else
        {
			String js = com.colorwinglib.Javascript.AlertAndRedirect(request, response, "内容不存在", "?" + pageListUrl);
			request.setAttribute("pageJavaScripStar", js);
        }
    }
	// [end]
    

	//[start] ServerValidate 服务器验证
    protected boolean ServerValidate()
    {
        StringBuilder sbStr = new StringBuilder(1024);
        int i = 1;
      
        // [start] 审核备ID
        if (com.colorwinglib.Requests.GetString(request, "objShbInfo.shbid").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s不能为空\n",i , "审核备ID"));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "objShbInfo.shbid")))
        {
            sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n",i , "审核备ID"));
            i = i + 1;
        }
        ShbInfoCollection sc=ShbProvider.GetListByShbid(Requests.GetInt(request, "objShbInfo.shbid"));
        if(sc.size()>0)
        {
        	ShbInfo shb=sc.get(0);
        	if(shb.getShbdatabaseid()!=Requests.GetInt(request, "objShbInfo.shbdatabaseid"))
        	{
        		 sbStr.append(String.format("%1$s.%2$s:%3$s已存在，请更改\n",i , "编号",Requests.GetInt(request, "objShbInfo.shbid")));
                 i = i + 1;
        	}
        }
        // [end]
        // [start] shbName
        if (com.colorwinglib.Requests.GetString(request, "objShbInfo.shbname").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s不能为空\n",i , "shbName"));
            i = i + 1;
        }
        if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "objShbInfo.shbname")) > 50)
        {
            sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n",i , "shbName"));
            i = i + 1;
        }
        // [end]

        if (i-1 > 0)
        {
            sbStr.append("总共有" + (i-1) + "个错误");
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
    


    


	// [end]
    

	// [start] insert 添加
    protected void insert()
    {
		String pageListUrl = getpageListUrl();
    

		this.request.setAttribute("pagetype", "insert");
        //服务器验证
        if (!ServerValidate())
        {
			//进行赋值验证失败时用
			DrpInit();
            return;
        }

        com.yun.bll.culture.ShbProvider.Insert(objShbInfo);

			String js = com.colorwinglib.Javascript.Alert(request, response, "添加成功");
		if (com.colorwinglib.Requests.GetInt(request, "isSaveAndNew") == 1)
		{
			js = com.colorwinglib.Javascript.Alert(request, response, "添加成功");
		}
			request.setAttribute("pageJavaScripStar", js);
        com.yun.bll.culture.ShbProvider.setShbStatic(null);
    }
	// [end]
    

	// [start] update 更新
    protected void update()
    {
		String pageListUrl = getpageListUrl();

        //服务器验证
		this.request.setAttribute("pagetype", "update");
        if (!ServerValidate())
        {
			//进行赋值验证失败时用
			DrpInit();
            return;
        }


    // 表主键字段
		int Shbdatabaseid = objShbInfo.getShbdatabaseid();//数据库ID  数据类型:int

		com.yun.entities.culture.ShbInfo objShbInfo = com.yun.bll.culture.ShbProvider.GetShbInfoByShbdatabaseid(Shbdatabaseid);//实体类
		objShbInfo.setShbdatabaseid(this.objShbInfo.getShbdatabaseid());//数据库ID  数据类型:int
		objShbInfo.setShbid(this.objShbInfo.getShbid());//审核备ID  数据类型:int
		objShbInfo.setShbname(this.objShbInfo.getShbname());//shbName  数据类型:String
        com.yun.bll.culture.ShbProvider.UpdateByShbdatabaseid(objShbInfo);

		String js = com.colorwinglib.Javascript.Alert(request, response, "更新成功");
		if (com.colorwinglib.Requests.GetInt(request, "isSaveAndNew") == 1)
		{
			js = com.colorwinglib.Javascript.Alert(request, response, "更新成功");
		}
			request.setAttribute("pageJavaScripStar", js);
        com.yun.bll.culture.ShbProvider.setShbStatic(null);
    }
	// [end]
    

	// [start] delete 删除
    protected void delete()
    {
    // 表主键字段
		int Shbdatabaseid =  objShbInfo.getShbdatabaseid();//数据库ID  数据类型:int
    
		String pageListUrl = getpageListUrl();
    
		

		com.yun.bll.culture.ShbProvider.DeleteByShbdatabaseid(Shbdatabaseid);//直接删除

        com.yun.bll.culture.ShbProvider.setShbStatic(null);
			String js = com.colorwinglib.Javascript.Alert(request, response, "删除成功");
			request.setAttribute("pageJavaScripStar", js);
    }
	// [end]
    


}

