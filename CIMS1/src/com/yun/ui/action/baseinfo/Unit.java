/*     */ package com.yun.ui.action.baseinfo;
/*     */ 
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.RolesCompetenceProvider;
/*     */ import com.yun.bll.culture.UnitProvider;
/*     */ import com.yun.common.Pager;
/*     */ import com.yun.entities.culture.UnitInfo;
/*     */ import com.yun.entities.culture.collection.UnitInfoCollection;
/*     */ import com.yun.ui.action.UserLook;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class Unit
/*     */ {
/*     */   private static final long serialVersionUID = 2011112215313407817L;
/*  23 */   public int pageSize = 10;
/*     */ 
/*  28 */   public String pageParameter = "page";
/*     */ 
/*  34 */   HttpServletRequest request = null;
/*     */ 
/*  38 */   HttpServletResponse response = null;
/*     */ 
/*  42 */   PrintWriter out = null;
/*     */ 
/*     */   private String getpageListUrl()
/*     */   {
/*  48 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/*  49 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "DatabaseUnitID");
/*  50 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/*  51 */     String pageListOrderByItemDESCNo = pageListOrderByItemDESC.toLowerCase().equals("desc") ? "asc" : "desc";
/*  52 */     String pageListUrlOrderBy = String.format("%s=%s", new Object[] { this.pageParameter, Integer.valueOf(pageIndex) });
/*  53 */     String pageListUrl = String.format("%s&OrderByItem=%s&OrderByItemDESC=%s", new Object[] { pageListUrlOrderBy, pageListOrderByItem, pageListOrderByItemDESC });
/*     */ 
/*  56 */     this.request.setAttribute("pageListOrderByItem", pageListOrderByItem);
/*  57 */     this.request.setAttribute("pageListOrderByItemDESC", pageListOrderByItemDESC);
/*  58 */     this.request.setAttribute("pageListOrderByItemDESCNo", pageListOrderByItemDESCNo);
/*  59 */     this.request.setAttribute("pageListUrlOrderBy", pageListUrlOrderBy);
/*  60 */     this.request.setAttribute("pageListUrl", pageListUrl);
/*     */ 
/*  62 */     return pageListUrl;
/*     */   }
/*     */ 
/*     */   public String execute()
/*     */     throws Exception
/*     */   {
/*  72 */     this.request = ServletActionContext.getRequest();
/*  73 */     this.response = ServletActionContext.getResponse();
/*     */ 
/*  75 */     String af = null;
/*  76 */     this.response.setCharacterEncoding("utf-8");
/*  77 */     this.out = this.response.getWriter();
/*  78 */     String pageListUrl = getpageListUrl();
/*     */ 
/*  81 */     int Databaseunitid = Requests.GetInt(this.request, "databaseunitid", 0);
/*     */ 
/*  84 */     UserLook userlook = new UserLook(this.request, this.response);
/*  85 */     int Rolesid = userlook.getRolesid();
/*  86 */     userlook.seePageY("17");
/*     */ 
/*  92 */     String pageName = "Unit";
/*  93 */     String pagetype = Requests.GetString(this.request, "pagetype").toLowerCase();
/*  94 */     if (pagetype.equals("gotoinsert"))
/*     */     {
/*  96 */       this.request.setAttribute("btnEditText", "添加数据");
/*  97 */       this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "insert"));
/*  98 */       DrpInit();
/*  99 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 101 */     else if (pagetype.equals("insert"))
/*     */     {
/* 103 */       this.request.setAttribute("btnEditText", "添加数据");
/* 104 */       insert();
/* 105 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 107 */     else if (pagetype.equals("gotoupdate"))
/*     */     {
/* 109 */       DrpInit();
/* 110 */       ItemCommandEdit();
/* 111 */       this.request.setAttribute("btnEditText", "更新数据");
/* 112 */       this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "update"));
/* 113 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 115 */     else if (pagetype.equals("update"))
/*     */     {
/* 117 */       this.request.setAttribute("btnEditText", "更新数据");
/* 118 */       update();
/* 119 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 121 */     else if (pagetype.equals("delete"))
/*     */     {
/* 123 */       delete();
/* 124 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 126 */     else if (pagetype.equals("details"))
/*     */     {
/* 128 */       ItemCommandDetails();
/* 129 */       af = String.format("%sDetails", new Object[] { pageName });
/*     */     }
/*     */     else
/*     */     {
/* 134 */       DrpInit();
/* 135 */       ListShow();
/* 136 */       af = String.format("%sList", new Object[] { pageName });
/*     */     }
/* 138 */     return af;
/*     */   }
/*     */ 
/*     */   protected void DrpInit()
/*     */   {
/*     */   }
/*     */ 
/*     */   protected void ListShow()
/*     */   {
/* 154 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 156 */     String OrderBy = "";
/* 157 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "DatabaseUnitID");
/* 158 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 159 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 161 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/*     */ 
/* 164 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 165 */     int pageAll = 0;
/* 166 */     pageAll = UnitProvider.GetListPagerBy();
/* 167 */     UnitInfoCollection UnitColl = UnitProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 168 */     this.request.setAttribute("UnitList", UnitColl);
/*     */ 
/* 175 */     String pageDetails = "";
/* 176 */     if (pageAll > this.pageSize) {
/* 177 */       pageDetails = Pager.LastNextPage(this.request, this.response, this.pageParameter, this.pageSize, pageAll);
/*     */     }
/* 179 */     this.request.setAttribute("pageDetails", pageDetails);
/*     */   }
/*     */ 
/*     */   protected void ItemCommandEdit()
/*     */   {
/* 188 */     int Databaseunitid = Requests.GetInt(this.request, "databaseunitid", 0);
/*     */ 
/* 190 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 192 */     UnitInfo objUnitInfo = UnitProvider.GetUnitInfoByDatabaseunitid(Databaseunitid);
/* 193 */     if (objUnitInfo != null)
/*     */     {
/* 195 */       this.request.setAttribute("Databaseunitid", Integer.valueOf(objUnitInfo.getDatabaseunitid()));
/* 196 */       this.request.setAttribute("Unitid", Integer.valueOf(objUnitInfo.getUnitid()));
/* 197 */       this.request.setAttribute("Unitname", StringFormat.HtmlEncode(objUnitInfo.getUnitname()));
/* 198 */       this.request.setAttribute("Adress", StringFormat.HtmlEncode(objUnitInfo.getAdress()));
/* 199 */       this.request.setAttribute("Phone", StringFormat.HtmlEncode(objUnitInfo.getPhone()));
/*     */     }
/*     */     else
/*     */     {
/* 204 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 205 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void ItemCommandDetails()
/*     */   {
/* 215 */     int Databaseunitid = Requests.GetInt(this.request, "databaseunitid", 0);
/*     */ 
/* 217 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 219 */     UnitInfo objUnitInfo = UnitProvider.GetUnitInfoByDatabaseunitid(Databaseunitid);
/* 220 */     if (objUnitInfo != null)
/*     */     {
/* 222 */       this.request.setAttribute("Databaseunitid", Integer.valueOf(objUnitInfo.getDatabaseunitid()));
/* 223 */       this.request.setAttribute("Unitid", Integer.valueOf(objUnitInfo.getUnitid()));
/* 224 */       this.request.setAttribute("Unitname", objUnitInfo.getUnitname());
/* 225 */       this.request.setAttribute("Adress", objUnitInfo.getAdress());
/* 226 */       this.request.setAttribute("Phone", objUnitInfo.getPhone());
/*     */     }
/*     */     else
/*     */     {
/* 235 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 236 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected boolean ServerValidate()
/*     */   {
/* 245 */     StringBuilder sbStr = new StringBuilder(1024);
/* 246 */     int i = 1;
/*     */ 
/* 249 */     if (Requests.GetString(this.request, "unitid").length() == 0)
/*     */     {
/* 251 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "单位编号" }));
/* 252 */       i++;
/*     */     }
/*     */ 
/* 255 */     if (!Validate.IsNumber(Requests.GetString(this.request, "unitid")))
/*     */     {
/* 257 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "单位编号" }));
/* 258 */       i++;
/*     */     }
/*     */ 
/* 262 */     if (Requests.GetString(this.request, "unitname").length() == 0)
/*     */     {
/* 264 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "单位名称" }));
/* 265 */       i++;
/*     */     }
/* 267 */     if (Validate.getLength(Requests.GetString(this.request, "unitname")) > 50)
/*     */     {
/* 269 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "单位名称" }));
/* 270 */       i++;
/*     */     }
/*     */ 
/* 274 */     if (Requests.GetString(this.request, "adress").length() == 0)
/*     */     {
/* 276 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "单位地址" }));
/* 277 */       i++;
/*     */     }
/* 279 */     if (Validate.getLength(Requests.GetString(this.request, "adress")) > 50)
/*     */     {
/* 281 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "单位地址" }));
/* 282 */       i++;
/*     */     }
/*     */ 
/* 286 */     if (Requests.GetString(this.request, "phone").length() == 0)
/*     */     {
/* 288 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "联系电话" }));
/* 289 */       i++;
/*     */     }
/* 291 */     if (Validate.getLength(Requests.GetString(this.request, "phone")) > 20)
/*     */     {
/* 293 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于20\n", new Object[] { Integer.valueOf(i), "联系电话" }));
/* 294 */       i++;
/*     */     }
/*     */ 
/* 298 */     if (i - 1 > 0)
/*     */     {
/* 300 */       sbStr.append("总共有" + (i - 1) + "个错误");
/* 301 */       String js = Javascript.Alert(this.request, this.response, sbStr.toString());
/* 302 */       this.request.setAttribute("pageJavaScripEnd", js);
/* 303 */       if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */       {
/* 305 */         this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "insert"));
/*     */       }
/* 307 */       return false;
/*     */     }
/*     */ 
/* 311 */     return true;
/*     */   }
/*     */ 
/*     */   protected void insert()
/*     */   {
/* 320 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 322 */     int Databaseunitid = Requests.GetInt(this.request, "databaseunitid", 0);
/* 323 */     int Unitid = Requests.GetInt(this.request, "unitid", 0);
/* 324 */     String Unitname = Requests.GetString(this.request, "unitname", "");
/* 325 */     String Adress = Requests.GetString(this.request, "adress", "");
/* 326 */     String Phone = Requests.GetString(this.request, "phone", "");
/*     */ 
/* 329 */     if (!ServerValidate())
/*     */     {
/* 332 */       DrpInit();
/* 333 */       this.request.setAttribute("Databaseunitid", Integer.valueOf(Databaseunitid));
/* 334 */       this.request.setAttribute("Unitid", Integer.valueOf(Unitid));
/* 335 */       this.request.setAttribute("Unitname", StringFormat.HtmlEncode(Unitname));
/* 336 */       this.request.setAttribute("Adress", StringFormat.HtmlEncode(Adress));
/* 337 */       this.request.setAttribute("Phone", StringFormat.HtmlEncode(Phone));
/* 338 */       return;
/*     */     }
/*     */ 
/* 341 */     UnitInfo objUnitInfo = new UnitInfo();
/* 342 */     objUnitInfo.setDatabaseunitid(Databaseunitid);
/* 343 */     objUnitInfo.setUnitid(Unitid);
/* 344 */     objUnitInfo.setUnitname(Unitname);
/* 345 */     objUnitInfo.setAdress(Adress);
/* 346 */     objUnitInfo.setPhone(Phone);
/*     */ 
/* 348 */     UnitProvider.Insert(objUnitInfo);
/*     */ 
/* 350 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?" + pageListUrl);
/* 351 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 353 */       js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 355 */     this.request.setAttribute("pageJavaScripStar", js);
/* 356 */     UnitProvider.setUnitStatic(null);
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 364 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 366 */     int Databaseunitid = Requests.GetInt(this.request, "databaseunitid", 0);
/* 367 */     int Unitid = Requests.GetInt(this.request, "unitid", 0);
/* 368 */     String Unitname = Requests.GetString(this.request, "unitname", "");
/* 369 */     String Adress = Requests.GetString(this.request, "adress", "");
/* 370 */     String Phone = Requests.GetString(this.request, "phone", "");
/*     */ 
/* 373 */     if (!ServerValidate())
/*     */     {
/* 376 */       DrpInit();
/* 377 */       this.request.setAttribute("Databaseunitid", Integer.valueOf(Databaseunitid));
/* 378 */       this.request.setAttribute("Unitid", Integer.valueOf(Unitid));
/* 379 */       this.request.setAttribute("Unitname", StringFormat.HtmlEncode(Unitname));
/* 380 */       this.request.setAttribute("Adress", StringFormat.HtmlEncode(Adress));
/* 381 */       this.request.setAttribute("Phone", StringFormat.HtmlEncode(Phone));
/* 382 */       return;
/*     */     }
/*     */ 
/* 386 */     UnitInfo objUnitInfo = UnitProvider.GetUnitInfoByDatabaseunitid(Databaseunitid);
/* 387 */     objUnitInfo.setDatabaseunitid(Databaseunitid);
/* 388 */     objUnitInfo.setUnitid(Unitid);
/* 389 */     objUnitInfo.setUnitname(Unitname);
/* 390 */     objUnitInfo.setAdress(Adress);
/* 391 */     objUnitInfo.setPhone(Phone);
/*     */ 
/* 393 */     UnitProvider.UpdateByDatabaseunitid(objUnitInfo);
/*     */ 
/* 395 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?" + pageListUrl);
/* 396 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 398 */       js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 400 */     this.request.setAttribute("pageJavaScripStar", js);
/* 401 */     UnitProvider.setUnitStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 410 */     int Databaseunitid = Requests.GetInt(this.request, "databaseunitid", 0);
/*     */ 
/* 412 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 416 */     UnitProvider.DeleteByDatabaseunitid(Databaseunitid);
/*     */ 
/* 418 */     UnitProvider.setUnitStatic(null);
/* 419 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "删除成功", "?" + pageListUrl);
/* 420 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.baseinfo.Unit
 * JD-Core Version:    0.6.0
 */