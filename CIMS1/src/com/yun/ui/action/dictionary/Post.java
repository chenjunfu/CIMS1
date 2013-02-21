/*     */ package com.yun.ui.action.dictionary;
/*     */ 
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.PostProvider;
/*     */ import com.yun.bll.itemcollection.ItemInfo;
/*     */ import com.yun.bll.itemcollection.culture.PostItemCollection;
/*     */ import com.yun.common.Pager;
import com.yun.configuration.WebConfig;
/*     */ import com.yun.entities.culture.PostInfo;
/*     */ import com.yun.entities.culture.collection.PostInfoCollection;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class Post
/*     */ {
/*     */   private static final long serialVersionUID = 2011112118472194752L;
/*  20 */   public int pageSize = WebConfig.PAGE_SIZE;
/*     */ 
/*  25 */   public String pageParameter = "page";
/*     */ 
/*  31 */   HttpServletRequest request = null;
/*     */ 
/*  35 */   HttpServletResponse response = null;
/*     */ 
/*  39 */   PrintWriter out = null;
/*     */ 
/*     */   private String getpageListUrl()
/*     */   {
/*  45 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/*  46 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "TitleID");
/*  47 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/*  48 */     String pageListOrderByItemDESCNo = pageListOrderByItemDESC.toLowerCase().equals("desc") ? "asc" : "desc";
/*  49 */     String pageListUrlOrderBy = String.format("%s=%s", new Object[] { this.pageParameter, Integer.valueOf(pageIndex) });
/*  50 */     String pageListUrl = String.format("%s&OrderByItem=%s&OrderByItemDESC=%s", new Object[] { pageListUrlOrderBy, pageListOrderByItem, pageListOrderByItemDESC });
/*     */ 
/*  53 */     this.request.setAttribute("pageListOrderByItem", pageListOrderByItem);
/*  54 */     this.request.setAttribute("pageListOrderByItemDESC", pageListOrderByItemDESC);
/*  55 */     this.request.setAttribute("pageListOrderByItemDESCNo", pageListOrderByItemDESCNo);
/*  56 */     this.request.setAttribute("pageListUrlOrderBy", pageListUrlOrderBy);
/*  57 */     this.request.setAttribute("pageListUrl", pageListUrl);
/*     */ 
/*  59 */     return pageListUrl;
/*     */   }
/*     */ 
/*     */   public String execute()
/*     */     throws Exception
/*     */   {
/*  69 */     this.request = ServletActionContext.getRequest();
/*  70 */     this.response = ServletActionContext.getResponse();
/*     */ 
/*  72 */     String af = null;
			  this.request.setCharacterEncoding("utf-8");
/*  73 */     this.response.setCharacterEncoding("utf-8");
/*  74 */     this.out = this.response.getWriter();
/*  75 */     String pageListUrl = getpageListUrl();
/*     */ 
/*  78 */     int Titleid = Requests.GetInt(this.request, "titleid", 0);
/*     */ 
/*  83 */     String pageName = "Post";
/*  84 */     String pagetype = Requests.GetString(this.request, "pagetype").toLowerCase();
/*  85 */     if (pagetype.equals("gotoinsert"))
/*     */     {
/*  87 */       this.request.setAttribute("btnEditText", "添加数据");
/*  88 */       this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "insert"));
/*  89 */       DrpInit();
/*  90 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/*  92 */     else if (pagetype.equals("insert"))
/*     */     {
/*  94 */       this.request.setAttribute("btnEditText", "添加数据");
/*  95 */       insert();
				ListShow();
/*  96 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/*  98 */     else if (pagetype.equals("gotoupdate"))
/*     */     {
/* 100 */       DrpInit();
/* 101 */       ItemCommandEdit();
/* 102 */       this.request.setAttribute("btnEditText", "更新数据");
/* 103 */       this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "update"));
/* 104 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 106 */     else if (pagetype.equals("update"))
/*     */     {
/* 108 */       this.request.setAttribute("btnEditText", "更新数据");
/* 109 */       update();
ItemCommandEdit();
ListShow();
/* 110 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 112 */     else if (pagetype.equals("delete"))
/*     */     {
/* 114 */       delete();
/* 115 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 117 */     else if (pagetype.equals("details"))
/*     */     {
/* 119 */       ItemCommandDetails();
/* 120 */       af = String.format("%sDetails", new Object[] { pageName });
/*     */     }
/*     */     else
/*     */     {
/* 125 */       DrpInit();
/* 126 */       ListShow();
/* 127 */       af = String.format("%sList", new Object[] { pageName });
/*     */     }
				
/* 129 */     return af;
/*     */   }
/*     */ 
/*     */   protected void DrpInit()
/*     */   {
/* 139 */     StringBuilder sbIsDel = new StringBuilder(100);
/* 140 */     for (ItemInfo itemInfo : PostItemCollection.IsDelCollection())
/*     */     {
/* 142 */       sbIsDel.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { itemInfo.getValue(), itemInfo.getText() }));
/*     */     }
/* 144 */     this.request.setAttribute("IsDel", Integer.valueOf(0));
/* 145 */     this.request.setAttribute("IsDelEdit", sbIsDel.toString());
/* 146 */     this.request.setAttribute("IsDelList", sbIsDel.toString());
/*     */   }
/*     */ 
/*     */   protected void ListShow()
/*     */   {
/* 155 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 157 */     String OrderBy = "";
/* 158 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "TitleID");
/* 159 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 160 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 162 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/*     */ 
/* 165 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 166 */     int pageAll = 0;
/* 167 */     pageAll = PostProvider.GetListPagerBy();
/* 168 */     PostInfoCollection PostColl = PostProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 169 */     this.request.setAttribute("PostList", PostColl);
/*     */ 	 
/* 176 */     String pageDetails = "";
/* 177 */     if (pageAll > this.pageSize) {
/* 178 */       pageDetails = Pager.LastNextPage(this.request, this.response, this.pageParameter, this.pageSize, pageAll);
/*     */     }
/* 180 */     this.request.setAttribute("pageDetails", pageDetails);
/*     */   }
/*     */ 
/*     */   protected void ItemCommandEdit()
/*     */   {
/* 189 */     int Titledatabaseid = Requests.GetInt(this.request, "titledatabaseid", 0);
/*     */ 
/* 191 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 193 */     PostInfo objPostInfo = PostProvider.GetPostInfoByTitledatabaseid(Titledatabaseid);
/* 194 */     if (objPostInfo != null)
/*     */     {	
				this.request.setAttribute("Titledatabaseid", Titledatabaseid);
/* 196 */       this.request.setAttribute("Titleid", Integer.valueOf(objPostInfo.getTitleid()));
/* 197 */       this.request.setAttribute("Titlename", StringFormat.HtmlEncode(objPostInfo.getTitlename()));
/* 198 */       this.request.setAttribute("Description", StringFormat.HtmlEncode(objPostInfo.getDescription()));
/* 199 */       this.request.setAttribute("Farthertitleid", Integer.valueOf(objPostInfo.getFarthertitleid()));
/* 200 */       this.request.setAttribute("Depth", Integer.valueOf(objPostInfo.getDepth()));
/* 201 */       this.request.setAttribute("IsDel", Integer.valueOf(objPostInfo.getIsDel()));
/*     */     }
/*     */     else
/*     */     {
/* 206 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 207 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void ItemCommandDetails()
/*     */   {
/* 217 */     int Titledatabaseid = Requests.GetInt(this.request, "titledatabaseid", 0);
/*     */ 
/* 219 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 221 */     PostInfo objPostInfo = PostProvider.GetPostInfoByTitledatabaseid(Titledatabaseid);
/* 222 */     if (objPostInfo != null)
/*     */     {
				this.request.setAttribute("Titledatabaseid",Titledatabaseid );
/* 224 */       this.request.setAttribute("Titleid", Integer.valueOf(objPostInfo.getTitleid()));
/* 225 */       this.request.setAttribute("Titlename", objPostInfo.getTitlename());
/* 226 */       this.request.setAttribute("Description", objPostInfo.getDescription());
/* 227 */       this.request.setAttribute("Farthertitleid", Integer.valueOf(objPostInfo.getFarthertitleid()));
/* 228 */       this.request.setAttribute("Depth", Integer.valueOf(objPostInfo.getDepth()));
/* 229 */       this.request.setAttribute("IsDel", Integer.valueOf(objPostInfo.getIsDel()));
/*     */ 
/* 234 */       this.request.setAttribute("IsDellabel", objPostInfo.getIsDellabel());
/*     */     }
/*     */     else
/*     */     {
/* 239 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 240 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
// [start] ServerValidate 服务器验证
protected boolean ServerValidate()
{
    java.util.HashMap<String,Object> valueMap = new java.util.HashMap<String,Object>();
    StringBuilder sbStr = new StringBuilder(1024);
    int i = 1;
   
    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "titledatabaseid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 职称编号
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "职称编号");
    if (com.colorwinglib.Requests.GetString(request, "titleid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "titleid")))
    {
        sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "titleid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    PostInfoCollection pc=PostProvider.GetListByTitleid(Requests.GetInt(this.request, "titleid"));
    if(pc.size()>0)
    {
    	PostInfo post=pc.get(0);
    	if(post.getTitledatabaseid()!=Requests.GetInt(this.request, "titledatabaseid"))
    	{
    		 valueMap.put("param1", Requests.GetInt(this.request, "titleid"));
    	     sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000015, valueMap)));
    	     i = i + 1;
    	}
    }
    // [end]
    // [start] 职称名称
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "职称名称");
    if (com.colorwinglib.Requests.GetString(request, "titlename").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "titlename")) > 50)
    {
        valueMap.put("N", 50);
        sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 职称描述
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "职称描述");
    if (com.colorwinglib.Requests.GetString(request, "description").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "description")) > 500)
    {
        valueMap.put("N", 500);
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



/*     */ 
/*     */   protected void insert()
/*     */   {
/* 350 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 352 */     int Titleid = Requests.GetInt(this.request, "titleid", 0);
/* 353 */     String Titlename = Requests.GetString(this.request, "titlename", "");
/* 354 */     String Description = Requests.GetString(this.request, "description", "");
/* 355 */     int Farthertitleid = Requests.GetInt(this.request, "farthertitleid", 0);
/* 356 */     int Depth = Requests.GetInt(this.request, "depth", 0);
/* 357 */     int IsDel = Requests.GetInt(this.request, "isDel", 0);
/*     */ 		 this.request.setAttribute("pagetype", "insert");
/* 360 */     if (!ServerValidate())
/*     */     {
/* 363 */       DrpInit();
				
/* 364 */       this.request.setAttribute("Titleid", Integer.valueOf(Titleid));
/* 365 */       this.request.setAttribute("Titlename", StringFormat.HtmlEncode(Titlename));
/* 366 */       this.request.setAttribute("Description", StringFormat.HtmlEncode(Description));
/* 367 */       this.request.setAttribute("Farthertitleid", Integer.valueOf(Farthertitleid));
/* 368 */       this.request.setAttribute("Depth", Integer.valueOf(Depth));
/* 369 */       this.request.setAttribute("IsDel", Integer.valueOf(IsDel));
/* 370 */       return;
/*     */     }
/*     */ 
/* 373 */     PostInfo objPostInfo = new PostInfo();
/* 374 */     objPostInfo.setTitleid(Titleid);
/* 375 */     objPostInfo.setTitlename(Titlename);
/* 376 */     objPostInfo.setDescription(Description);
/* 377 */     objPostInfo.setFarthertitleid(Farthertitleid);
/* 378 */     objPostInfo.setDepth(Depth);
/* 379 */     objPostInfo.setIsDel(IsDel);
/*     */ 
/* 381 */     PostProvider.Insert(objPostInfo);
/*     */ 
/* 383 */     String js = Javascript.Alert(this.request, this.response, "添加成功");
/* 384 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 386 */       js = Javascript.Alert(this.request, this.response, "添加成功");
/*     */     }
/* 388 */     this.request.setAttribute("pageJavaScripStar", js);
/* 389 */     PostProvider.setPostStatic(null);
				
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 397 */     String pageListUrl = getpageListUrl();
/*     */ 	  int Titledatabaseid=Requests.GetInt(this.request, "titledatabaseid",0);
/* 399 */     int Titleid = Requests.GetInt(this.request, "titleid", 0);
/* 400 */     String Titlename = Requests.GetString(this.request, "titlename", "");
/* 401 */     String Description = Requests.GetString(this.request, "description", "");
/* 402 */     int Farthertitleid = Requests.GetInt(this.request, "farthertitleid", 0);
/* 403 */     int Depth = Requests.GetInt(this.request, "depth", 0);
/* 404 */     int IsDel = Requests.GetInt(this.request, "isDel", 0);
/*     */     this.request.setAttribute("pagetype", "update");
/* 407 */     if (!ServerValidate())
/*     */     {
/* 410 */       DrpInit();
				
				this.request.setAttribute("Titledatabaseid", Titledatabaseid);
/* 411 */       this.request.setAttribute("Titleid", Integer.valueOf(Titleid));
/* 412 */       this.request.setAttribute("Titlename", StringFormat.HtmlEncode(Titlename));
/* 413 */       this.request.setAttribute("Description", StringFormat.HtmlEncode(Description));
/* 414 */       this.request.setAttribute("Farthertitleid", Integer.valueOf(Farthertitleid));
/* 415 */       this.request.setAttribute("Depth", Integer.valueOf(Depth));
/* 416 */       this.request.setAttribute("IsDel", Integer.valueOf(IsDel));
/* 417 */       return;
/*     */     }
/*     */ 
/* 421 */     PostInfo objPostInfo = PostProvider.GetPostInfoByTitledatabaseid(Titledatabaseid);
/* 422 */     objPostInfo.setTitleid(Titleid);
/* 423 */     objPostInfo.setTitlename(Titlename);
/* 424 */     objPostInfo.setDescription(Description);
/* 425 */     objPostInfo.setFarthertitleid(Farthertitleid);
/* 426 */     objPostInfo.setDepth(Depth);
/* 427 */     objPostInfo.setIsDel(IsDel);
/*     */ 
/* 429 */     PostProvider.UpdateByTitledatabaseid(objPostInfo);
/*     */ 
/* 431 */     String js = Javascript.Alert(this.request, this.response, "更新成功");
/* 432 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 434 */       js = Javascript.Alert(this.request, this.response, "更新成功");
/*     */     }
/* 436 */     this.request.setAttribute("pageJavaScripStar", js);
/* 437 */     PostProvider.setPostStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 446 */     int Titledatabaseid = Requests.GetInt(this.request, "titledatabaseid", 0);
/*     */ 
/* 448 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 452 */     PostProvider.DeleteByTitledatabaseid(Titledatabaseid);
/*     */ 
/* 454 */     PostProvider.setPostStatic(null);
/* 455 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "删除成功", "?" + pageListUrl);
/* 456 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.dictionary.Post
 * JD-Core Version:    0.6.0
 */