/*     */ package com.yun.ui.action.dictionary;
/*     */ 
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.NationProvider;
/*     */ import com.yun.common.Pager;
import com.yun.configuration.WebConfig;
/*     */ import com.yun.entities.culture.NationInfo;
/*     */ import com.yun.entities.culture.collection.NationInfoCollection;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class Nation
/*     */ {
/*     */   private static final long serialVersionUID = 2011112115514790069L;
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
/*  46 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "NationID");
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
this.request.setCharacterEncoding("utf-8");
/*  74 */     this.out = this.response.getWriter();
/*  75 */     String pageListUrl = getpageListUrl();
/*     */ 
/*  78 */     int Nationid = Requests.GetInt(this.request, "nationid", 0);
/*     */ 
/*  83 */     String pageName = "Nation";
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
/*     */   }
/*     */ 
/*     */   protected void ListShow()
/*     */   {
/* 145 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 147 */     String OrderBy = "";
/* 148 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "NationID");
/* 149 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 150 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 152 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/*     */ 
/* 155 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 156 */     int pageAll = 0;
/* 157 */     pageAll = NationProvider.GetListPagerBy();
/* 158 */     NationInfoCollection NationColl = NationProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 159 */     this.request.setAttribute("NationList", NationColl);
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
/* 179 */     int Nationdatabaseid = Requests.GetInt(this.request, "nationdatabaseid", 0);
/*     */ 
/* 181 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 183 */     NationInfo objNationInfo = NationProvider.GetNationInfoByNationdatabaseid(Nationdatabaseid);
/* 184 */     if (objNationInfo != null)
/*     */     {	
				this.request.setAttribute("Nationdatabaseid", Nationdatabaseid);
/* 186 */       this.request.setAttribute("Nationid", Integer.valueOf(objNationInfo.getNationid()));
/* 187 */       this.request.setAttribute("Nationname", StringFormat.HtmlEncode(objNationInfo.getNationname()));
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
/* 203 */     int Nationdatabaseid = Requests.GetInt(this.request, "nationdatabaseid", 0);
/*     */ 
/* 205 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 207 */     NationInfo objNationInfo = NationProvider.GetNationInfoByNationdatabaseid(Nationdatabaseid);
/* 208 */     if (objNationInfo != null)
/*     */     {
				this.request.setAttribute("Nationdatabaseid", Nationdatabaseid);
/* 210 */       this.request.setAttribute("Nationid", Integer.valueOf(objNationInfo.getNationid()));
/* 211 */       this.request.setAttribute("Nationname", objNationInfo.getNationname());
/*     */     }
/*     */     else
/*     */     {
/* 220 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 221 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */  	// [start] ServerValidate 服务器验证
protected boolean ServerValidate()
{
    java.util.HashMap<String,Object> valueMap = new java.util.HashMap<String,Object>();
    StringBuilder sbStr = new StringBuilder(1024);
    int i = 1;
   
    // [start] 民族编号
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "民族编号");
    if (com.colorwinglib.Requests.GetString(request, "nationid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "nationid")))
    {
        sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "nationid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    NationInfoCollection nc=NationProvider.GetListByNationid(Requests.GetInt(this.request, "nationid"));
    if(nc.size()>0)
    {
    	NationInfo nation=nc.get(0);
    	if(nation.getNationdatabaseid()!=Requests.GetInt(this.request, "nationdatabaseid"))
    	{ 	
    		valueMap.put("param1", Requests.GetInt(this.request, "nationid"));
    		sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000015, valueMap)));
            i = i + 1;
    	}
    }
    // [end]
    // [start] 民族名称
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "民族名称");
    if (com.colorwinglib.Requests.GetString(request, "nationname").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "nationname")) > 50)
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
/* 280 */     
/*     */ 
/* 282 */     int Nationid = Requests.GetInt(this.request, "nationid", 0);
/* 283 */     String Nationname = Requests.GetString(this.request, "nationname", "");
/*     */ this.request.setAttribute("pagetype", "insert");
/* 286 */     if (!ServerValidate())
/*     */     {
/* 289 */       DrpInit();
				
/* 290 */       this.request.setAttribute("Nationid", Integer.valueOf(Nationid));
/* 291 */       this.request.setAttribute("Nationname", StringFormat.HtmlEncode(Nationname));
/* 292 */       return;
/*     */     }
/*     */ 
/* 295 */     NationInfo objNationInfo = new NationInfo();
/* 296 */     objNationInfo.setNationid(Nationid);
/* 297 */     objNationInfo.setNationname(Nationname);
/*     */ 
/* 299 */     NationProvider.Insert(objNationInfo);
/*     */ 
/* 301 */     String js = Javascript.Alert(this.request, this.response, "添加成功");
/* 302 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 304 */       js = Javascript.Alert(this.request, this.response, "添加成功");
/*     */     }
/* 306 */     this.request.setAttribute("pageJavaScripStar", js);
/* 307 */     NationProvider.setNationStatic(null);
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 315 */     String pageListUrl = getpageListUrl();
/*     */     int Nationdatabaseid=Requests.GetInt(this.request, "nationdatabaseid");
/* 317 */     int Nationid = Requests.GetInt(this.request, "nationid", 0);
/* 318 */     String Nationname = Requests.GetString(this.request, "nationname", "");
/*     */     this.request.setAttribute("pagetype", "update");
/* 321 */     if (!ServerValidate())
/*     */     {
/* 324 */       DrpInit();
				
				this.request.setAttribute("Nationdatabaseid", Nationdatabaseid);
/* 325 */       this.request.setAttribute("Nationid", Integer.valueOf(Nationid));
/* 326 */       this.request.setAttribute("Nationname", StringFormat.HtmlEncode(Nationname));
/* 327 */       return;
/*     */     }
/*     */ 		
/* 331 */     NationInfo objNationInfo = NationProvider.GetNationInfoByNationdatabaseid(Nationdatabaseid);
/* 332 */     objNationInfo.setNationid(Nationid);
/* 333 */     objNationInfo.setNationname(Nationname);
/*     */ 
/* 335 */     NationProvider.UpdateByNationdatabaseid(objNationInfo);
/*     */ 
/* 337 */     String js = Javascript.Alert(this.request, this.response, "更新成功");
/* 338 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 340 */       js = Javascript.Alert(this.request, this.response, "更新成功");
/*     */     }
/* 342 */     this.request.setAttribute("pageJavaScripStar", js);
/* 343 */     NationProvider.setNationStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 352 */     int Nationdatabaseid = Requests.GetInt(this.request, "nationdatabaseid", 0);
/*     */ 
/* 354 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 358 */     NationProvider.DeleteByNationdatabaseid(Nationdatabaseid);
/*     */ 
/* 360 */     NationProvider.setNationStatic(null);
/* 361 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "删除成功", "?" + pageListUrl);
/* 362 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.dictionary.Nation
 * JD-Core Version:    0.6.0
 */