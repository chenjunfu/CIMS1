/*     */ package com.yun.ui.action.dictionary;
/*     */ 
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.DegreeProvider;
/*     */ import com.yun.common.Pager;
import com.yun.configuration.WebConfig;
/*     */ import com.yun.entities.culture.DegreeInfo;
/*     */ import com.yun.entities.culture.collection.DegreeInfoCollection;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class Degree
/*     */ {
/*     */   private static final long serialVersionUID = 2011112115580493174L;
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
/*  46 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "DegreeID");
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
/*  73 */     this.response.setCharacterEncoding("utf-8");
			  this.request.setCharacterEncoding("UTF-8");
/*  74 */     this.out = this.response.getWriter();
/*  75 */     String pageListUrl = getpageListUrl();
/*     */ 
/*  78 */     int Degreeid = Requests.GetInt(this.request, "degreeid",0);
/*     */  
/*  83 */     String pageName = "Degree";
/*  84 */     String pagetype = Requests.GetString(this.request, "pagetype").toLowerCase();
/*  85 */     
				if (pagetype.equals("gotoinsert"))
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
				ListShow();
				ItemCommandEdit();
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
/*     */   }
/*     */ 
/*     */   protected void ListShow()
/*     */   {	
	
/* 145 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 147 */     String OrderBy = "";
/* 148 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "DegreeID");
/* 149 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 150 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 152 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/*     */ 
/* 155 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 156 */     int pageAll = 0;
/* 157 */     pageAll = DegreeProvider.GetListPagerBy();
/* 158 */     DegreeInfoCollection DegreeColl = DegreeProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 159 */     this.request.setAttribute("DegreeList", DegreeColl);
/*     */ 
/* 166 */     String pageDetails = "";
/* 167 */     if (pageAll > this.pageSize) {
/* 168 */       pageDetails = Pager.LastNextPage(this.request, this.response, this.pageParameter, this.pageSize, pageAll);
/*     */     }
/* 170 */     this.request.setAttribute("pageDetails", pageDetails);
/*     */   }
/*     */ 
/*     */   protected void ItemCommandEdit()
/*     */   {
/* 179 */     int Degreedatabaseid = Requests.GetInt(this.request, "degreedatabaseid", 0);
/*     */ 
/* 181 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 183 */     DegreeInfo objDegreeInfo = DegreeProvider.GetDegreeInfoByDegreedatabaseid(Degreedatabaseid);
/* 184 */     if (objDegreeInfo != null)
/*     */     {	
				this.request.setAttribute("Degreedatabaseid", Degreedatabaseid);
/* 186 */       this.request.setAttribute("Degreeid", Integer.valueOf(objDegreeInfo.getDegreeid()));
/* 187 */       this.request.setAttribute("Degreename", StringFormat.HtmlEncode(objDegreeInfo.getDegreename()));
/*     */     }
/*     */     else
/*     */     {
/* 192 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 193 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void ItemCommandDetails()
/*     */   {
/* 203 */     int Degreedatabaseid = Requests.GetInt(this.request, "degreedatabaseid", 0);
/*     */ 
/* 205 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 207 */     DegreeInfo objDegreeInfo = DegreeProvider.GetDegreeInfoByDegreedatabaseid(Degreedatabaseid);
/* 208 */     if (objDegreeInfo != null)
/*     */     {	
				this.request.setAttribute("Degreedatabaseid", Degreedatabaseid);
/* 210 */       this.request.setAttribute("Degreeid", Integer.valueOf(objDegreeInfo.getDegreeid()));
/* 211 */       this.request.setAttribute("Degreename", objDegreeInfo.getDegreename());
/*     */     }
/*     */     else
/*     */     {
/* 220 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 221 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   	// [start] ServerValidate 服务器验证
protected boolean ServerValidate()
{
    java.util.HashMap<String,Object> valueMap = new java.util.HashMap<String,Object>();
    StringBuilder sbStr = new StringBuilder(1024);
    int i = 1;
    
    // [start] DegreeID
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "DegreeID");
    if (com.colorwinglib.Requests.GetString(request, "degreeid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "degreeid")))
    {
        sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "degreeid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    DegreeInfoCollection dc=DegreeProvider.GetListByDegreeid(Requests.GetInt(this.request, "degreeid"));
    if(dc.size()>0)
    {
    	DegreeInfo degree=dc.get(0);
    	if(degree.getDegreedatabaseid()!=Requests.GetInt(this.request, "degreedatabaseid"))
    	{	
    		valueMap.put("param1", Requests.GetInt(this.request, "degreeid"));
    		sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000015, valueMap)));
            i = i + 1;
    	}
    }
    
 
    // [end]
    // [start] DegreeName
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "DegreeName");
    if (com.colorwinglib.Requests.GetString(request, "degreename").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "degreename")) > 50)
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



/*     */ 
/*     */   protected void insert()
/*     */   {
/* 280 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 282 */     int Degreeid = Requests.GetInt(this.request, "degreeid", 0);
/* 283 */     String Degreename = Requests.GetString(this.request, "degreename", "");
/*     */ 	  this.request.setAttribute("pagetype", "insert");
/* 286 */     if (!ServerValidate())
/*     */     {
/* 289 */       DrpInit();
				
/* 290 */       this.request.setAttribute("Degreeid", Integer.valueOf(Degreeid));
/* 291 */       this.request.setAttribute("Degreename", StringFormat.HtmlEncode(Degreename));
/* 292 */       return;
/*     */     }
/*     */ 	  
/* 295 */     DegreeInfo objDegreeInfo = new DegreeInfo();
/* 296 */     objDegreeInfo.setDegreeid(Degreeid);
/* 297 */     objDegreeInfo.setDegreename(Degreename);
/*     */ 
/* 299 */     DegreeProvider.Insert(objDegreeInfo);
/*     */ 
/* 301 */     String js = Javascript.Alert(this.request, this.response, "添加成功");
/* 302 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 304 */       js = Javascript.Alert(this.request, this.response, "添加成功");
/*     */     }
/* 306 */     this.request.setAttribute("pageJavaScripStar", js);
/* 307 */     DegreeProvider.setDegreeStatic(null);
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 315 */     String pageListUrl = getpageListUrl();
/*     */ 	  int Degreeid=Requests.GetInt(this.request, "degreeid",0);
/* 317 */     int Degreedatabaseid = Requests.GetInt(this.request, "degreedatabaseid", 0);
/* 318 */     String Degreename = Requests.GetString(this.request, "degreename", "");
/*     */     this.request.setAttribute("pagetype", "update");
/* 321 */     if (!ServerValidate())
/*     */     {
/* 324 */       DrpInit();
				
				this.request.setAttribute("Degreedatabaseid", Degreedatabaseid);
/* 325 */       this.request.setAttribute("Degreeid", Integer.valueOf(Degreeid));
/* 326 */       this.request.setAttribute("Degreename", StringFormat.HtmlEncode(Degreename));
/* 327 */       return;
/*     */     }
/*     */ 
/* 331 */     DegreeInfo objDegreeInfo = DegreeProvider.GetDegreeInfoByDegreedatabaseid(Degreedatabaseid);
/* 332 */     objDegreeInfo.setDegreeid(Degreeid);
/* 333 */     objDegreeInfo.setDegreename(Degreename);
/*     */ 
/* 335 */     DegreeProvider.UpdateByDegreedatabaseid(objDegreeInfo);
/*     */ 
/* 337 */     String js = Javascript.Alert(this.request, this.response, "更新成功");
/* 338 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 340 */       js = Javascript.Alert(this.request, this.response, "更新成功");
/*     */     }
/* 342 */     this.request.setAttribute("pageJavaScripStar", js);
/* 343 */     DegreeProvider.setDegreeStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 352 */     int Degreedatabaseid = Requests.GetInt(this.request, "degreedatabaseid", 0);
/*     */ 
/* 354 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 358 */     DegreeProvider.DeleteByDegreedatabaseid(Degreedatabaseid);
/*     */ 
/* 360 */     DegreeProvider.setDegreeStatic(null);
/* 361 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "删除成功", "?" + pageListUrl);
/* 362 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.dictionary.Degree
 * JD-Core Version:    0.6.0
 */