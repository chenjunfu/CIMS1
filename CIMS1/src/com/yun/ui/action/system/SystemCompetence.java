/*     */ package com.yun.ui.action.system;
/*     */ 
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.RolesCompetenceProvider;
/*     */ import com.yun.bll.culture.SystemCompetenceProvider;
/*     */ import com.yun.bll.itemcollection.ItemInfo;
/*     */ import com.yun.bll.itemcollection.culture.SystemCompetenceItemCollection;
/*     */ import com.yun.common.Pager;
/*     */ import com.yun.entities.culture.SystemCompetenceInfo;
/*     */ import com.yun.entities.culture.collection.SystemCompetenceInfoCollection;
/*     */ import com.yun.ui.action.UserLook;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class SystemCompetence
/*     */ {
/*     */   private static final long serialVersionUID = 2011112516054918717L;
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
/*  49 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "DatabaseCompetenceID");
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
/*  81 */     int Databasecompetenceid = Requests.GetInt(this.request, "databasecompetenceid", 0);
/*     */ 
/*  84 */     UserLook userLook = new UserLook(this.request, this.response);
/*  85 */     int Rolesid = userLook.getRolesid();
/*  86 */   
/*     */ 
/*  92 */     String pageName = "SystemCompetence";
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
/* 148 */     StringBuilder sbIsUse = new StringBuilder(100);
/* 149 */     for (ItemInfo itemInfo : SystemCompetenceItemCollection.IsUseCollection())
/*     */     {
/* 151 */       sbIsUse.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { itemInfo.getValue(), itemInfo.getText() }));
/*     */     }
/* 153 */     this.request.setAttribute("IsUse", Integer.valueOf(0));
/* 154 */     this.request.setAttribute("IsUseEdit", sbIsUse.toString());
/* 155 */     this.request.setAttribute("IsUseList", sbIsUse.toString());
/*     */   }
/*     */ 
/*     */   protected void ListShow()
/*     */   {
/* 164 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 166 */     String OrderBy = "";
/* 167 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "DatabaseCompetenceID");
/* 168 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 169 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 171 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/*     */ 
/* 174 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 175 */     int pageAll = 0;
/* 176 */     pageAll = SystemCompetenceProvider.GetListPagerBy();
/* 177 */     SystemCompetenceInfoCollection SystemCompetenceColl = SystemCompetenceProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 178 */     this.request.setAttribute("SystemCompetenceList", SystemCompetenceColl);
/*     */ 
/* 185 */     String pageDetails = "";
/* 186 */     if (pageAll > this.pageSize) {
/* 187 */       pageDetails = Pager.LastNextPage(this.request, this.response, this.pageParameter, this.pageSize, pageAll);
/*     */     }
/* 189 */     this.request.setAttribute("pageDetails", pageDetails);
/*     */   }
/*     */ 
/*     */   protected void ItemCommandEdit()
/*     */   {
/* 198 */     int Databasecompetenceid = Requests.GetInt(this.request, "databasecompetenceid", 0);
/*     */ 
/* 200 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 202 */     SystemCompetenceInfo objSystemCompetenceInfo = SystemCompetenceProvider.GetSystemCompetenceInfoByDatabasecompetenceid(Databasecompetenceid);
/* 203 */     if (objSystemCompetenceInfo != null)
/*     */     {
/* 205 */       this.request.setAttribute("Databasecompetenceid", Integer.valueOf(objSystemCompetenceInfo.getDatabasecompetenceid()));
/* 206 */       this.request.setAttribute("Competenceid", Integer.valueOf(objSystemCompetenceInfo.getCompetenceid()));
/* 207 */       this.request.setAttribute("Competencename", StringFormat.HtmlEncode(objSystemCompetenceInfo.getCompetencename()));
/* 208 */       this.request.setAttribute("Description", StringFormat.HtmlEncode(objSystemCompetenceInfo.getDescription()));
/* 209 */       this.request.setAttribute("IsUse", Integer.valueOf(objSystemCompetenceInfo.getIsUse()));
/*     */     }
/*     */     else
/*     */     {
/* 214 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 215 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void ItemCommandDetails()
/*     */   {
/* 225 */     int Databasecompetenceid = Requests.GetInt(this.request, "databasecompetenceid", 0);
/*     */ 
/* 227 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 229 */     SystemCompetenceInfo objSystemCompetenceInfo = SystemCompetenceProvider.GetSystemCompetenceInfoByDatabasecompetenceid(Databasecompetenceid);
/* 230 */     if (objSystemCompetenceInfo != null)
/*     */     {
/* 232 */       this.request.setAttribute("Databasecompetenceid", Integer.valueOf(objSystemCompetenceInfo.getDatabasecompetenceid()));
/* 233 */       this.request.setAttribute("Competenceid", Integer.valueOf(objSystemCompetenceInfo.getCompetenceid()));
/* 234 */       this.request.setAttribute("Competencename", objSystemCompetenceInfo.getCompetencename());
/* 235 */       this.request.setAttribute("Description", objSystemCompetenceInfo.getDescription());
/* 236 */       this.request.setAttribute("IsUse", Integer.valueOf(objSystemCompetenceInfo.getIsUse()));
/*     */ 
/* 241 */       this.request.setAttribute("IsUselabel", objSystemCompetenceInfo.getIsUselabel());
/*     */     }
/*     */     else
/*     */     {
/* 246 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 247 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected boolean ServerValidate()
/*     */   {
/* 256 */     StringBuilder sbStr = new StringBuilder(1024);
/* 257 */     int i = 1;
/*     */ 
/* 260 */     if (Requests.GetString(this.request, "competenceid").length() == 0)
/*     */     {
/* 262 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "权限编号" }));
/* 263 */       i++;
/*     */     }
/*     */ 
/* 266 */     if (!Validate.IsNumber(Requests.GetString(this.request, "competenceid")))
/*     */     {
/* 268 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "权限编号" }));
/* 269 */       i++;
/*     */     }
/*     */ 
/* 273 */     if (Requests.GetString(this.request, "competencename").length() == 0)
/*     */     {
/* 275 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "权限名称" }));
/* 276 */       i++;
/*     */     }
/* 278 */     if (Validate.getLength(Requests.GetString(this.request, "competencename")) > 50)
/*     */     {
/* 280 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "权限名称" }));
/* 281 */       i++;
/*     */     }
/*     */ 
/* 286 */     if (Requests.GetString(this.request, "isUse").length() == 0)
/*     */     {
/* 288 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "启用标志" }));
/* 289 */       i++;
/*     */     }
/*     */ 
/* 292 */     if (!Validate.IsNumber(Requests.GetString(this.request, "isUse")))
/*     */     {
/* 294 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "启用标志" }));
/* 295 */       i++;
/*     */     }
/*     */ 
/* 299 */     if (i - 1 > 0)
/*     */     {
/* 301 */       sbStr.append("总共有" + (i - 1) + "个错误");
/* 302 */       String js = Javascript.Alert(this.request, this.response, sbStr.toString());
/* 303 */       this.request.setAttribute("pageJavaScripEnd", js);
/* 304 */       if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */       {
/* 306 */         this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "insert"));
/*     */       }
/* 308 */       return false;
/*     */     }
/*     */ 
/* 312 */     return true;
/*     */   }
/*     */ 
/*     */   protected void insert()
/*     */   {
/* 321 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 323 */     int Databasecompetenceid = Requests.GetInt(this.request, "databasecompetenceid", 0);
/* 324 */     int Competenceid = Requests.GetInt(this.request, "competenceid", 0);
/* 325 */     String Competencename = Requests.GetString(this.request, "competencename", "");
/* 326 */     String Description = Requests.GetString(this.request, "description", "");
/* 327 */     int IsUse = Requests.GetInt(this.request, "isUse", 0);
/*     */ 
/* 330 */     if (!ServerValidate())
/*     */     {
/* 333 */       DrpInit();
/* 334 */       this.request.setAttribute("Databasecompetenceid", Integer.valueOf(Databasecompetenceid));
/* 335 */       this.request.setAttribute("Competenceid", Integer.valueOf(Competenceid));
/* 336 */       this.request.setAttribute("Competencename", StringFormat.HtmlEncode(Competencename));
/* 337 */       this.request.setAttribute("Description", StringFormat.HtmlEncode(Description));
/* 338 */       this.request.setAttribute("IsUse", Integer.valueOf(IsUse));
/* 339 */       return;
/*     */     }
/*     */ 
/* 342 */     SystemCompetenceInfo objSystemCompetenceInfo = new SystemCompetenceInfo();
/* 343 */     objSystemCompetenceInfo.setDatabasecompetenceid(Databasecompetenceid);
/* 344 */     objSystemCompetenceInfo.setCompetenceid(Competenceid);
/* 345 */     objSystemCompetenceInfo.setCompetencename(Competencename);
/* 346 */     objSystemCompetenceInfo.setDescription(Description);
/* 347 */     objSystemCompetenceInfo.setIsUse(IsUse);
/*     */ 
/* 349 */     SystemCompetenceProvider.Insert(objSystemCompetenceInfo);
/*     */ 
/* 351 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?" + pageListUrl);
/* 352 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 354 */       js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 356 */     this.request.setAttribute("pageJavaScripStar", js);
/* 357 */     SystemCompetenceProvider.setSystemCompetenceStatic(null);
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 365 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 367 */     int Databasecompetenceid = Requests.GetInt(this.request, "databasecompetenceid", 0);
/* 368 */     int Competenceid = Requests.GetInt(this.request, "competenceid", 0);
/* 369 */     String Competencename = Requests.GetString(this.request, "competencename", "");
/* 370 */     String Description = Requests.GetString(this.request, "description", "");
/* 371 */     int IsUse = Requests.GetInt(this.request, "isUse", 0);
/*     */ 
/* 374 */     if (!ServerValidate())
/*     */     {
/* 377 */       DrpInit();
/* 378 */       this.request.setAttribute("Databasecompetenceid", Integer.valueOf(Databasecompetenceid));
/* 379 */       this.request.setAttribute("Competenceid", Integer.valueOf(Competenceid));
/* 380 */       this.request.setAttribute("Competencename", StringFormat.HtmlEncode(Competencename));
/* 381 */       this.request.setAttribute("Description", StringFormat.HtmlEncode(Description));
/* 382 */       this.request.setAttribute("IsUse", Integer.valueOf(IsUse));
/* 383 */       return;
/*     */     }
/*     */ 
/* 387 */     SystemCompetenceInfo objSystemCompetenceInfo = SystemCompetenceProvider.GetSystemCompetenceInfoByDatabasecompetenceid(Databasecompetenceid);
/* 388 */     objSystemCompetenceInfo.setDatabasecompetenceid(Databasecompetenceid);
/* 389 */     objSystemCompetenceInfo.setCompetenceid(Competenceid);
/* 390 */     objSystemCompetenceInfo.setCompetencename(Competencename);
/* 391 */     objSystemCompetenceInfo.setDescription(Description);
/* 392 */     objSystemCompetenceInfo.setIsUse(IsUse);
/*     */ 
/* 394 */     SystemCompetenceProvider.UpdateByDatabasecompetenceid(objSystemCompetenceInfo);
/*     */ 
/* 396 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?" + pageListUrl);
/* 397 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 399 */       js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 401 */     this.request.setAttribute("pageJavaScripStar", js);
/* 402 */     SystemCompetenceProvider.setSystemCompetenceStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 411 */     int Databasecompetenceid = Requests.GetInt(this.request, "databasecompetenceid", 0);
/*     */ 
/* 413 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 417 */     SystemCompetenceProvider.DeleteByDatabasecompetenceid(Databasecompetenceid);
/*     */ 
/* 419 */     SystemCompetenceProvider.setSystemCompetenceStatic(null);
/* 420 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "删除成功", "?" + pageListUrl);
/* 421 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.system.SystemCompetence
 * JD-Core Version:    0.6.0
 */