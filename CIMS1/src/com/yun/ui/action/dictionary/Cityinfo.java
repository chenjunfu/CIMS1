/*     */ package com.yun.ui.action.dictionary;
/*     */ 
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.CityinfoProvider;
/*     */ import com.yun.common.Pager;
import com.yun.configuration.WebConfig;
/*     */ import com.yun.entities.culture.CityinfoInfo;
/*     */ import com.yun.entities.culture.collection.CityinfoInfoCollection;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class Cityinfo
/*     */ {
/*     */   private static final long serialVersionUID = 2011112221303390630L;
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
/*  46 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "N_CityID");
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
/*  78 */     int Cityid = Requests.GetInt(this.request, "cityid", 0);
/*     */ 
/*  83 */     String pageName = "Cityinfo";
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
/* 148 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "N_CityID");
/* 149 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 150 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 152 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/*     */ 
/* 155 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 156 */     int pageAll = 0;
/* 157 */     pageAll = CityinfoProvider.GetListPagerBy();
/* 158 */     CityinfoInfoCollection CityinfoColl = CityinfoProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 159 */     this.request.setAttribute("CityinfoList", CityinfoColl);
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
/* 179 */     int Cityid = Requests.GetInt(this.request, "cityid", 0);
/*     */ 
/* 181 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 183 */     CityinfoInfo objCityinfoInfo = CityinfoProvider.GetCityinfoInfoByCityid(Cityid);
/* 184 */     if (objCityinfoInfo != null)
/*     */     {
/* 186 */       this.request.setAttribute("Cityid", Integer.valueOf(objCityinfoInfo.getCityid()));
/* 187 */       this.request.setAttribute("Parentid", Integer.valueOf(objCityinfoInfo.getParentid()));
/* 188 */       this.request.setAttribute("Cityname", StringFormat.HtmlEncode(objCityinfoInfo.getCityname()));
/* 189 */       this.request.setAttribute("Orderid", Integer.valueOf(objCityinfoInfo.getOrderid()));
/*     */     }
/*     */     else
/*     */     {
/* 194 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 195 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void ItemCommandDetails()
/*     */   {
/* 205 */     int Cityid = Requests.GetInt(this.request, "cityid", 0);
/*     */ 
/* 207 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 209 */     CityinfoInfo objCityinfoInfo = CityinfoProvider.GetCityinfoInfoByCityid(Cityid);
/* 210 */     if (objCityinfoInfo != null)
/*     */     {
/* 212 */       this.request.setAttribute("Cityid", Integer.valueOf(objCityinfoInfo.getCityid()));
/* 213 */       this.request.setAttribute("Parentid", Integer.valueOf(objCityinfoInfo.getParentid()));
/* 214 */       this.request.setAttribute("Cityname", objCityinfoInfo.getCityname());
/* 215 */       this.request.setAttribute("Orderid", Integer.valueOf(objCityinfoInfo.getOrderid()));
/*     */     }
/*     */     else
/*     */     {
/* 224 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 225 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected boolean ServerValidate()
/*     */   {
/* 234 */     StringBuilder sbStr = new StringBuilder(1024);
/* 235 */     int i = 1;
/*     */ 
/* 237 */     if (Requests.GetString(this.request, "cityid").length() == 0)
/*     */     {
/* 239 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "城市id" }));
/* 240 */       i++;
/*     */     }
/*     */ 
/* 243 */     if (!Validate.IsNumber(Requests.GetString(this.request, "cityid")))
/*     */     {
/* 245 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "城市id" }));
/* 246 */       i++;
/*     */     }
/*     */ 
/* 250 */     if (Requests.GetString(this.request, "parentid").length() == 0)
/*     */     {
/* 252 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "父id" }));
/* 253 */       i++;
/*     */     }
/*     */ 
/* 256 */     if (!Validate.IsNumber(Requests.GetString(this.request, "parentid")))
/*     */     {
/* 258 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "父id" }));
/* 259 */       i++;
/*     */     }
/*     */ 
/* 263 */     if (Requests.GetString(this.request, "cityname").length() == 0)
/*     */     {
/* 265 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "城市名称" }));
/* 266 */       i++;
/*     */     }
/* 268 */     if (Validate.getLength(Requests.GetString(this.request, "cityname")) > 50)
/*     */     {
/* 270 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "城市名称" }));
/* 271 */       i++;
/*     */     }
/*     */ 
/* 275 */     if (Requests.GetString(this.request, "orderid").length() == 0)
/*     */     {
/* 277 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "排序id" }));
/* 278 */       i++;
/*     */     }
/*     */ 
/* 281 */     if (!Validate.IsNumber(Requests.GetString(this.request, "orderid")))
/*     */     {
/* 283 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "排序id" }));
/* 284 */       i++;
/*     */     }
/*     */ 
/* 288 */     if (i - 1 > 0)
/*     */     {
/* 290 */       sbStr.append("总共有" + (i - 1) + "个错误");
/* 291 */       String js = Javascript.Alert(this.request, this.response, sbStr.toString());
/* 292 */       this.request.setAttribute("pageJavaScripEnd", js);
/* 293 */       if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */       {
/* 295 */         this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "insert"));
/*     */       }
/* 297 */       return false;
/*     */     }
/*     */ 
/* 301 */     return true;
/*     */   }
/*     */ 
/*     */   protected void insert()
/*     */   {
/* 310 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 312 */     int Cityid = Requests.GetInt(this.request, "cityid", 0);
/* 313 */     int Parentid = Requests.GetInt(this.request, "parentid", 0);
/* 314 */     String Cityname = Requests.GetString(this.request, "cityname", "");
/* 315 */     int Orderid = Requests.GetInt(this.request, "orderid", 0);
/*     */ 
/* 318 */     if (!ServerValidate())
/*     */     {
/* 321 */       DrpInit();
/* 322 */       this.request.setAttribute("Cityid", Integer.valueOf(Cityid));
/* 323 */       this.request.setAttribute("Parentid", Integer.valueOf(Parentid));
/* 324 */       this.request.setAttribute("Cityname", StringFormat.HtmlEncode(Cityname));
/* 325 */       this.request.setAttribute("Orderid", Integer.valueOf(Orderid));
/* 326 */       return;
/*     */     }
/*     */ 
/* 329 */     CityinfoInfo objCityinfoInfo = new CityinfoInfo();
/* 330 */     objCityinfoInfo.setCityid(Cityid);
/* 331 */     objCityinfoInfo.setParentid(Parentid);
/* 332 */     objCityinfoInfo.setCityname(Cityname);
/* 333 */     objCityinfoInfo.setOrderid(Orderid);
/*     */ 
/* 335 */     CityinfoProvider.Insert(objCityinfoInfo);
/*     */ 
/* 337 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?" + pageListUrl);
/* 338 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 340 */       js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 342 */     this.request.setAttribute("pageJavaScripStar", js);
/* 343 */     CityinfoProvider.setCityinfoStatic(null);
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 351 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 353 */     int Cityid = Requests.GetInt(this.request, "cityid", 0);
/* 354 */     int Parentid = Requests.GetInt(this.request, "parentid", 0);
/* 355 */     String Cityname = Requests.GetString(this.request, "cityname", "");
/* 356 */     int Orderid = Requests.GetInt(this.request, "orderid", 0);
/*     */ 
/* 359 */     if (!ServerValidate())
/*     */     {
/* 362 */       DrpInit();
/* 363 */       this.request.setAttribute("Cityid", Integer.valueOf(Cityid));
/* 364 */       this.request.setAttribute("Parentid", Integer.valueOf(Parentid));
/* 365 */       this.request.setAttribute("Cityname", StringFormat.HtmlEncode(Cityname));
/* 366 */       this.request.setAttribute("Orderid", Integer.valueOf(Orderid));
/* 367 */       return;
/*     */     }
/*     */ 
/* 371 */     CityinfoInfo objCityinfoInfo = CityinfoProvider.GetCityinfoInfoByCityid(Cityid);
/* 372 */     objCityinfoInfo.setCityid(Cityid);
/* 373 */     objCityinfoInfo.setParentid(Parentid);
/* 374 */     objCityinfoInfo.setCityname(Cityname);
/* 375 */     objCityinfoInfo.setOrderid(Orderid);
/*     */ 
/* 377 */     CityinfoProvider.UpdateByCityid(objCityinfoInfo);
/*     */ 
/* 379 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?" + pageListUrl);
/* 380 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 382 */       js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 384 */     this.request.setAttribute("pageJavaScripStar", js);
/* 385 */     CityinfoProvider.setCityinfoStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 394 */     int Cityid = Requests.GetInt(this.request, "cityid", 0);
/*     */ 
/* 396 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 400 */     CityinfoProvider.DeleteByCityid(Cityid);
/*     */ 
/* 402 */     CityinfoProvider.setCityinfoStatic(null);
/* 403 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "删除成功", "?" + pageListUrl);
/* 404 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.dictionary.Cityinfo
 * JD-Core Version:    0.6.0
 */