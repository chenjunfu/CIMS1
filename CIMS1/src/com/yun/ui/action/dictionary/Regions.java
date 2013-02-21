/*     */ package com.yun.ui.action.dictionary;
/*     */ 
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.RegionsProvider;
/*     */ import com.yun.common.Pager;
import com.yun.configuration.WebConfig;
/*     */ import com.yun.entities.culture.RegionsInfo;
/*     */ import com.yun.entities.culture.collection.RegionsInfoCollection;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class Regions
/*     */ {
/*     */   private static final long serialVersionUID = 2011112210125032886L;
/*  21 */   public int pageSize = WebConfig.PAGE_SIZE;
/*     */ 
/*  26 */   public String pageParameter = "page";
/*     */ 
/*  32 */   HttpServletRequest request = null;
/*     */ 
/*  36 */   HttpServletResponse response = null;
/*     */ 
/*  40 */   PrintWriter out = null;
/*     */ 
/*     */   private String getpageListUrl()
/*     */   {
/*  46 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/*  47 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "RegionID");
/*  48 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/*  49 */     String pageListOrderByItemDESCNo = pageListOrderByItemDESC.toLowerCase().equals("desc") ? "asc" : "desc";
/*  50 */     String pageListUrlOrderBy = String.format("%s=%s", new Object[] { this.pageParameter, Integer.valueOf(pageIndex) });
/*  51 */     String pageListUrl = String.format("%s&OrderByItem=%s&OrderByItemDESC=%s", new Object[] { pageListUrlOrderBy, pageListOrderByItem, pageListOrderByItemDESC });
/*     */ 
/*  54 */     this.request.setAttribute("pageListOrderByItem", pageListOrderByItem);
/*  55 */     this.request.setAttribute("pageListOrderByItemDESC", pageListOrderByItemDESC);
/*  56 */     this.request.setAttribute("pageListOrderByItemDESCNo", pageListOrderByItemDESCNo);
/*  57 */     this.request.setAttribute("pageListUrlOrderBy", pageListUrlOrderBy);
/*  58 */     this.request.setAttribute("pageListUrl", pageListUrl);
/*     */ 
/*  60 */     return pageListUrl;
/*     */   }
/*     */ 
/*     */   public String execute()
/*     */     throws Exception
/*     */   {
/*  70 */     this.request = ServletActionContext.getRequest();
/*  71 */     this.response = ServletActionContext.getResponse();
/*     */ 
/*  73 */     String af = null;
/*  74 */     this.response.setCharacterEncoding("utf-8");
this.request.setCharacterEncoding("utf-8");
/*  75 */     this.out = this.response.getWriter();
/*  76 */     String pageListUrl = getpageListUrl();
/*     */ 
/*  79 */     int Regionid = Requests.GetInt(this.request, "regionid", 0);
/*     */ 
/*  84 */     String pageName = "Regions";
/*  85 */     String pagetype = Requests.GetString(this.request, "pagetype").toLowerCase();
/*  86 */     if (pagetype.equals("gotoinsert"))
/*     */     {
/*  88 */       this.request.setAttribute("btnEditText", "添加数据");
/*  89 */       this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "insert"));
/*  90 */       DrpInit();
/*  91 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/*  93 */     else if (pagetype.equals("insert"))
/*     */     {
/*  95 */       this.request.setAttribute("btnEditText", "添加数据");
/*  96 */       insert();
ListShow();
/*  97 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/*  99 */     else if (pagetype.equals("gotoupdate"))
/*     */     {
/* 101 */       DrpInit();
/* 102 */       ItemCommandEdit();
/* 103 */       this.request.setAttribute("btnEditText", "更新数据");
/* 104 */       this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "update"));
/* 105 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 107 */     else if (pagetype.equals("update"))
/*     */     {
/* 109 */       this.request.setAttribute("btnEditText", "更新数据");
/* 110 */       update();
ItemCommandEdit();
ListShow();
/* 111 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 113 */     else if (pagetype.equals("delete"))
/*     */     {
/* 115 */       delete();
/* 116 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 118 */     else if (pagetype.equals("details"))
/*     */     {
/* 120 */       ItemCommandDetails();
/* 121 */       af = String.format("%sDetails", new Object[] { pageName });
/*     */     }
/*     */     else
/*     */     {
/* 126 */       DrpInit();
/* 127 */       ListShow();
/* 128 */       af = String.format("%sList", new Object[] { pageName });
/*     */     }
/* 130 */     return af;
/*     */   }
/*     */ 
/*     */   protected void DrpInit()
/*     */   {
//				RegionsInfoCollection regionsinfocollection=RegionsProvider.getRegionsStatic();
//				StringBuffer sbregionsid=new StringBuffer();
//				for(RegionsInfo regionsinfo :regionsinfocollection)
//				{
//					 sbregionsid.append(String.format(
//							 /*  174 */         "<option value=\"%1$s\">%2$s</option>\n", new Object[] { 
//							 /*  175 */         Integer.valueOf(regionsinfo.getRegionid())
//							 /*  175 */         , regionsinfo
//							 /*  176 */         .getRegionname()} ));
//				}
	
/*     */   }
/*     */ 
/*     */   protected void ListShow()
/*     */   {
/* 146 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 148 */     String OrderBy = "";
/* 149 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "RegionID");
/* 150 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 151 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 153 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/*     */ 
/* 156 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 157 */     int pageAll = 0;
/* 158 */     pageAll = RegionsProvider.GetListPagerBy();
/* 159 */     RegionsInfoCollection RegionsColl = RegionsProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 160 */     this.request.setAttribute("RegionsList", RegionsColl);
/*     */ 
/* 167 */     String pageDetails = "";
/* 168 */     if (pageAll > this.pageSize) {
/* 169 */       pageDetails = Pager.LastNextPage(this.request, this.response, this.pageParameter, this.pageSize, pageAll);
/*     */     }
/* 171 */     this.request.setAttribute("pageDetails", pageDetails);
/*     */   }
/*     */ 
/*     */   protected void ItemCommandEdit()
/*     */   {
/* 180 */     int Regiondatabaseid = Requests.GetInt(this.request, "regiondatabaseid", 0);
/*     */ 
/* 182 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 184 */     RegionsInfo objRegionsInfo = RegionsProvider.GetRegionsInfoByRegiondatabaseid(Regiondatabaseid);
/* 185 */     if (objRegionsInfo != null)
/*     */     {	
				this.request.setAttribute("Regiondatabaseid", Regiondatabaseid);
/* 187 */       this.request.setAttribute("Regionid", Integer.valueOf(objRegionsInfo.getRegionid()));
/* 188 */       this.request.setAttribute("Regionname", StringFormat.HtmlEncode(objRegionsInfo.getRegionname()));
/* 189 */       this.request.setAttribute("Partherregionsid", Integer.valueOf(objRegionsInfo.getPartherregionsid()));
/* 190 */       this.request.setAttribute("Depth", Integer.valueOf(objRegionsInfo.getDepth()));
/*     */     }
/*     */     else
/*     */     {
/* 195 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 196 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void ItemCommandDetails()
/*     */   {
/* 206 */     int Regiondatabaseid = Requests.GetInt(this.request, "regiondatabaseid", 0);
/*     */ 
/* 208 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 210 */     RegionsInfo objRegionsInfo = RegionsProvider.GetRegionsInfoByRegiondatabaseid(Regiondatabaseid);
/* 211 */     if (objRegionsInfo != null)
/*     */     {	
				this.request.setAttribute("Regiondatabaseid", Regiondatabaseid);
				
/* 213 */       this.request.setAttribute("Regionid", Integer.valueOf(objRegionsInfo.getRegionid()));
/* 214 */       this.request.setAttribute("Regionname", objRegionsInfo.getRegionname());
/* 215 */       this.request.setAttribute("Partherregionsid", Integer.valueOf(objRegionsInfo.getPartherregionsid()));
/* 216 */       this.request.setAttribute("Depth", Integer.valueOf(objRegionsInfo.getDepth()));
/*     */     }
/*     */     else
/*     */     {
/* 225 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 226 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected boolean ServerValidate()
/*     */   {
/* 235 */     StringBuilder sbStr = new StringBuilder(1024);
/* 236 */     int i = 1;
/*     */ 		if (Requests.GetString(this.request, "regionid").length() == 0)
/*     */     {
	/* 253 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "城市ID" }));
	/* 254 */       i++;
	/*     */     }
	/* 256 */     if (Validate.getLength(Requests.GetString(this.request, "regionid")) > 50)
	/*     */     {
	/* 258 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "城市ID" }));
	/* 259 */       i++;
	/*     */     }
	 RegionsInfoCollection rc=RegionsProvider.GetListByRegionid(Requests.GetInt(this.request, "regionid"));
	 if(rc.size()>0)
	 {
		 RegionsInfo region=rc.get(0);
		 if(region.getRegiondatabaseid()!=Requests.GetInt(this.request, "regiondatabaseid"))
		 {
			 sbStr.append(String.format("%1$s.%2$s%3$s已存在，请更改\n",i , "编号",Requests.GetInt(this.request, "regionid")));
             i = i + 1;
		 }
	 }
/* 238 *
/* 251 */     if (Requests.GetString(this.request, "regionname").length() == 0)
/*     */     {
/* 253 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "城市名称" }));
/* 254 */       i++;
/*     */     }
/* 256 */     if (Validate.getLength(Requests.GetString(this.request, "regionname")) > 50)
/*     */     {
/* 258 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "城市名称" }));
/* 259 */       i++;
/*     */     }
			 
/*     */ 

/*     */ 
/* 276 */     if (Requests.GetString(this.request, "depth").length() == 0)
/*     */     {
/* 278 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "深度" }));
/* 279 */       i++;
/*     */     }
/*     */ 
/* 282 */     if (!Validate.IsNumber(Requests.GetString(this.request, "depth")))
/*     */     {
/* 284 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "深度" }));
/* 285 */       i++;
/*     */     }
/*     */ 
/* 289 */     if (i - 1 > 0)
/*     */     {	
				String pagelisturl=getpageListUrl();
/* 291 */       sbStr.append("总共有" + (i - 1) + "个错误");
/* 292 */       String js = Javascript.Alert(this.request, this.response, sbStr.toString());
/* 293 */       
				this.request.setAttribute("pageJavaScripEnd", js);
/* 294 */       
/* 298 */       return false;
/*     */     }
/*     */ 
/* 302 */     return true;
/*     */   }
/*     */ 
/*     */   protected void insert()
/*     */   {
/* 311 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 313 */     int Regionid = Requests.GetInt(this.request, "regionid", 0);
/* 314 */     String Regionname = Requests.GetString(this.request, "regionname", "");
/* 315 */     int Partherregionsid = Requests.GetInt(this.request, "partherregionsid", 0);
/* 316 */     int Depth = Requests.GetInt(this.request, "depth", 0);
/*     */ 		 this.request.setAttribute("pagetype", "insert");
/* 319 */     if (!ServerValidate())
/*     */     {
/* 322 */       DrpInit();
				
/* 323 */       this.request.setAttribute("Regionid", Integer.valueOf(Regionid));
/* 324 */       this.request.setAttribute("Regionname", StringFormat.HtmlEncode(Regionname));
/* 325 */       this.request.setAttribute("Partherregionsid", Integer.valueOf(Partherregionsid));
/* 326 */       this.request.setAttribute("Depth", Integer.valueOf(Depth));
/* 327 */       return;
/*     */     }
/*     */ 
/* 330 */     RegionsInfo objRegionsInfo = new RegionsInfo();
/* 331 */     objRegionsInfo.setRegionid(Regionid);
/* 332 */     objRegionsInfo.setRegionname(Regionname);
/* 333 */     objRegionsInfo.setPartherregionsid(Partherregionsid);
/* 334 */     objRegionsInfo.setDepth(Depth);
/*     */ 
/* 336 */     RegionsProvider.Insert(objRegionsInfo);
/*     */ 
/* 338 */     String js = Javascript.Alert(this.request, this.response, "添加成功");
/* 339 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 341 */       js = Javascript.Alert(this.request, this.response, "添加成功");
/*     */     }
/* 343 */     this.request.setAttribute("pageJavaScripStar", js);
/* 344 */     RegionsProvider.setRegionsStatic(null);
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 352 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 354 */     int Regiondatabaseid = Requests.GetInt(this.request, "regiondatabaseid", 0);
			  int Regionid=Requests.GetInt(this.request, "regionid");
/* 355 */     String Regionname = Requests.GetString(this.request, "regionname", "");
/* 356 */     int Partherregionsid = Requests.GetInt(this.request, "partherregionsid", 0);
/* 357 */     int Depth = Requests.GetInt(this.request, "depth", 0);
/*     */     this.request.setAttribute("pagetype", "update");
/* 360 */     if (!ServerValidate())
/*     */     {
/* 363 */       DrpInit();
				
				this.request.setAttribute("Regiondatabaseid", Regiondatabaseid);
/* 364 */       this.request.setAttribute("Regionid", Integer.valueOf(Regionid));
/* 365 */       this.request.setAttribute("Regionname", StringFormat.HtmlEncode(Regionname));
/* 366 */       this.request.setAttribute("Partherregionsid", Integer.valueOf(Partherregionsid));
/* 367 */       this.request.setAttribute("Depth", Integer.valueOf(Depth));
/* 368 */       return;
/*     */     }
/*     */ 
/* 372 */     RegionsInfo objRegionsInfo = RegionsProvider.GetRegionsInfoByRegiondatabaseid(Regiondatabaseid);
/* 373 */     objRegionsInfo.setRegionid(Regionid);
/* 374 */     objRegionsInfo.setRegionname(Regionname);
/* 375 */     objRegionsInfo.setPartherregionsid(Partherregionsid);
/* 376 */     objRegionsInfo.setDepth(Depth);
/*     */ 
/* 378 */     RegionsProvider.UpdateByRegiondatabaseid(objRegionsInfo);
/*     */ 
/* 380 */     String js = Javascript.Alert(this.request, this.response, "更新成功");
/* 381 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 383 */       js = Javascript.Alert(this.request, this.response, "更新成功");
/*     */     }
/* 385 */     this.request.setAttribute("pageJavaScripStar", js);
/* 386 */     RegionsProvider.setRegionsStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 395 */     int Regiondatabaseid = Requests.GetInt(this.request, "regiondatabaseid", 0);
/*     */ 
/* 397 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 401 */     RegionsProvider.DeleteByRegiondatabaseid(Regiondatabaseid);
/*     */ 
/* 403 */     RegionsProvider.setRegionsStatic(null);
/* 404 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "删除成功", "?" + pageListUrl);
/* 405 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.dictionary.Regions
 * JD-Core Version:    0.6.0
 */