/*     */ package com.yun.ui.action.system;
/*     */ 
/*     */ import com.colorwinglib.Converts;
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.SystemAdminLogProvider;
/*     */ import com.yun.bll.itemcollection.ItemInfo;
/*     */ import com.yun.bll.itemcollection.culture.SystemAdminLogItemCollection;
/*     */ import com.yun.common.Pager;
/*     */ import com.yun.entities.culture.SystemAdminLogInfo;
/*     */ import com.yun.entities.culture.collection.SystemAdminLogInfoCollection;
/*     */ import java.io.PrintWriter;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class SystemAdminLog
/*     */ {
/*     */   private static final long serialVersionUID = 2011112213015606279L;
/*  20 */   public int pageSize = 10;
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
/*  46 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "LogID");
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
/*  74 */     this.out = this.response.getWriter();
/*  75 */     String pageListUrl = getpageListUrl();
/*     */ 
/*  78 */     int Logid = Requests.GetInt(this.request, "logid", 0);
/*     */ 
/*  83 */     String pageName = "SystemAdminLog";
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
/* 139 */     StringBuilder sbType = new StringBuilder(100);
/* 140 */     for (ItemInfo itemInfo : SystemAdminLogItemCollection.TypeCollection())
/*     */     {
/* 142 */       sbType.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { itemInfo.getValue(), itemInfo.getText() }));
/*     */     }
/* 144 */     this.request.setAttribute("Type", Integer.valueOf(0));
/* 145 */     this.request.setAttribute("TypeEdit", sbType.toString());
/* 146 */     this.request.setAttribute("TypeList", sbType.toString());
/*     */   }
/*     */ 
/*     */   protected void ListShow()
/*     */   {
/* 155 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 157 */     String OrderBy = "";
/* 158 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "LogID");
/* 159 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 160 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 162 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/*     */ 
/* 165 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 166 */     int pageAll = 0;
/* 167 */     pageAll = SystemAdminLogProvider.GetListPagerBy();
/* 168 */     SystemAdminLogInfoCollection SystemAdminLogColl = SystemAdminLogProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 169 */     this.request.setAttribute("SystemAdminLogList", SystemAdminLogColl);
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
/* 189 */     int Logid = Requests.GetInt(this.request, "logid", 0);
/*     */ 
/* 191 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 193 */     SystemAdminLogInfo objSystemAdminLogInfo = SystemAdminLogProvider.GetSystemAdminLogInfoByLogid(Logid);
/* 194 */     if (objSystemAdminLogInfo != null)
/*     */     {
/* 196 */       this.request.setAttribute("Logid", Integer.valueOf(objSystemAdminLogInfo.getLogid()));
/* 197 */       this.request.setAttribute("Adminname", StringFormat.HtmlEncode(objSystemAdminLogInfo.getAdminname()));
/* 198 */       this.request.setAttribute("Type", Integer.valueOf(objSystemAdminLogInfo.getType()));
/* 199 */       this.request.setAttribute("Content", StringFormat.HtmlEncode(objSystemAdminLogInfo.getContent()));
/* 200 */       this.request.setAttribute("Addtime", Converts.DateToString(objSystemAdminLogInfo.getAddtime(), "yyyy-MM-dd"));
/* 201 */       this.request.setAttribute("Ip", StringFormat.HtmlEncode(objSystemAdminLogInfo.getIp()));
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
/* 217 */     int Logid = Requests.GetInt(this.request, "logid", 0);
/*     */ 
/* 219 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 221 */     SystemAdminLogInfo objSystemAdminLogInfo = SystemAdminLogProvider.GetSystemAdminLogInfoByLogid(Logid);
/* 222 */     if (objSystemAdminLogInfo != null)
/*     */     {
/* 224 */       this.request.setAttribute("Logid", Integer.valueOf(objSystemAdminLogInfo.getLogid()));
/* 225 */       this.request.setAttribute("Adminname", objSystemAdminLogInfo.getAdminname());
/* 226 */       this.request.setAttribute("Type", Integer.valueOf(objSystemAdminLogInfo.getType()));
/* 227 */       this.request.setAttribute("Content", objSystemAdminLogInfo.getContent());
/* 228 */       this.request.setAttribute("Addtime", Converts.DateToString(objSystemAdminLogInfo.getAddtime(), "yyyy-MM-dd"));
/* 229 */       this.request.setAttribute("Ip", objSystemAdminLogInfo.getIp());
/*     */ 
/* 234 */       this.request.setAttribute("Typelabel", objSystemAdminLogInfo.getTypelabel());
/*     */     }
/*     */     else
/*     */     {
/* 239 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 240 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected boolean ServerValidate()
/*     */   {
/* 249 */     StringBuilder sbStr = new StringBuilder(1024);
/* 250 */     int i = 1;
/*     */ 
/* 252 */     if (Requests.GetString(this.request, "logid").length() == 0)
/*     */     {
/* 254 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "人员日志编号" }));
/* 255 */       i++;
/*     */     }
/*     */ 
/* 258 */     if (!Validate.IsNumber(Requests.GetString(this.request, "logid")))
/*     */     {
/* 260 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "人员日志编号" }));
/* 261 */       i++;
/*     */     }
/*     */ 
/* 265 */     if (Requests.GetString(this.request, "adminname").length() == 0)
/*     */     {
/* 267 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "帐号" }));
/* 268 */       i++;
/*     */     }
/* 270 */     if (Validate.getLength(Requests.GetString(this.request, "adminname")) > 50)
/*     */     {
/* 272 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "帐号" }));
/* 273 */       i++;
/*     */     }
/*     */ 
/* 277 */     if (Requests.GetString(this.request, "type").length() == 0)
/*     */     {
/* 279 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "日志类型" }));
/* 280 */       i++;
/*     */     }
/*     */ 
/* 283 */     if (!Validate.IsNumber(Requests.GetString(this.request, "type")))
/*     */     {
/* 285 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "日志类型" }));
/* 286 */       i++;
/*     */     }
/*     */ 
/* 290 */     if (Requests.GetString(this.request, "content").length() == 0)
/*     */     {
/* 292 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "日志内容" }));
/* 293 */       i++;
/*     */     }
/* 295 */     if (Validate.getLength(Requests.GetString(this.request, "content")) > 2000)
/*     */     {
/* 297 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于2000\n", new Object[] { Integer.valueOf(i), "日志内容" }));
/* 298 */       i++;
/*     */     }
/*     */ 
/* 302 */     if (Requests.GetString(this.request, "addtime").length() == 0)
/*     */     {
/* 304 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "日志时间" }));
/* 305 */       i++;
/*     */     }
/*     */ 
/* 308 */     if (!Validate.IsDateString(Requests.GetString(this.request, "addtime")))
/*     */     {
/* 310 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "日志时间" }));
/* 311 */       i++;
/*     */     }
/*     */ 
/* 315 */     if (Requests.GetString(this.request, "ip").length() == 0)
/*     */     {
/* 317 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "日志IP" }));
/* 318 */       i++;
/*     */     }
/* 320 */     if (Validate.getLength(Requests.GetString(this.request, "ip")) > 50)
/*     */     {
/* 322 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "日志IP" }));
/* 323 */       i++;
/*     */     }
/*     */ 
/* 327 */     if (i - 1 > 0)
/*     */     {
/* 329 */       sbStr.append("总共有" + (i - 1) + "个错误");
/* 330 */       String js = Javascript.Alert(this.request, this.response, sbStr.toString());
/* 331 */       this.request.setAttribute("pageJavaScripEnd", js);
/* 332 */       if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */       {
/* 334 */         this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "insert"));
/*     */       }
/* 336 */       return false;
/*     */     }
/*     */ 
/* 340 */     return true;
/*     */   }
/*     */ 
/*     */   protected void insert()
/*     */   {
/* 349 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 351 */     int Logid = Requests.GetInt(this.request, "logid", 0);
/* 352 */     String Adminname = Requests.GetString(this.request, "adminname", "");
/* 353 */     int Type = Requests.GetInt(this.request, "type", 0);
/* 354 */     String Content = Requests.GetString(this.request, "content", "");
/* 355 */     Date Addtime = Requests.GetDate(this.request, "addtime", new Date());
/* 356 */     String Ip = Requests.GetString(this.request, "ip", "");
/*     */ 
/* 359 */     if (!ServerValidate())
/*     */     {
/* 362 */       DrpInit();
/* 363 */       this.request.setAttribute("Logid", Integer.valueOf(Logid));
/* 364 */       this.request.setAttribute("Adminname", StringFormat.HtmlEncode(Adminname));
/* 365 */       this.request.setAttribute("Type", Integer.valueOf(Type));
/* 366 */       this.request.setAttribute("Content", StringFormat.HtmlEncode(Content));
/* 367 */       this.request.setAttribute("Addtime", new SimpleDateFormat("yyyy-MM-dd").format(Addtime));
/* 368 */       this.request.setAttribute("Ip", StringFormat.HtmlEncode(Ip));
/* 369 */       return;
/*     */     }
/*     */ 
/* 372 */     SystemAdminLogInfo objSystemAdminLogInfo = new SystemAdminLogInfo();
/* 373 */     objSystemAdminLogInfo.setLogid(Logid);
/* 374 */     objSystemAdminLogInfo.setAdminname(Adminname);
/* 375 */     objSystemAdminLogInfo.setType(Type);
/* 376 */     objSystemAdminLogInfo.setContent(Content);
/* 377 */     objSystemAdminLogInfo.setAddtime(Addtime);
/* 378 */     objSystemAdminLogInfo.setIp(Ip);
/*     */ 
/* 380 */     SystemAdminLogProvider.Insert(objSystemAdminLogInfo);
/*     */ 
/* 382 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?" + pageListUrl);
/* 383 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 385 */       js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 387 */     this.request.setAttribute("pageJavaScripStar", js);
/* 388 */     SystemAdminLogProvider.setSystemAdminLogStatic(null);
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 396 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 398 */     int Logid = Requests.GetInt(this.request, "logid", 0);
/* 399 */     String Adminname = Requests.GetString(this.request, "adminname", "");
/* 400 */     int Type = Requests.GetInt(this.request, "type", 0);
/* 401 */     String Content = Requests.GetString(this.request, "content", "");
/* 402 */     Date Addtime = Requests.GetDate(this.request, "addtime", new Date());
/* 403 */     String Ip = Requests.GetString(this.request, "ip", "");
/*     */ 
/* 406 */     if (!ServerValidate())
/*     */     {
/* 409 */       DrpInit();
/* 410 */       this.request.setAttribute("Logid", Integer.valueOf(Logid));
/* 411 */       this.request.setAttribute("Adminname", StringFormat.HtmlEncode(Adminname));
/* 412 */       this.request.setAttribute("Type", Integer.valueOf(Type));
/* 413 */       this.request.setAttribute("Content", StringFormat.HtmlEncode(Content));
/* 414 */       this.request.setAttribute("Addtime", new SimpleDateFormat("yyyy-MM-dd").format(Addtime));
/* 415 */       this.request.setAttribute("Ip", StringFormat.HtmlEncode(Ip));
/* 416 */       return;
/*     */     }
/*     */ 
/* 420 */     SystemAdminLogInfo objSystemAdminLogInfo = SystemAdminLogProvider.GetSystemAdminLogInfoByLogid(Logid);
/* 421 */     objSystemAdminLogInfo.setLogid(Logid);
/* 422 */     objSystemAdminLogInfo.setAdminname(Adminname);
/* 423 */     objSystemAdminLogInfo.setType(Type);
/* 424 */     objSystemAdminLogInfo.setContent(Content);
/* 425 */     objSystemAdminLogInfo.setAddtime(Addtime);
/* 426 */     objSystemAdminLogInfo.setIp(Ip);
/*     */ 
/* 428 */     SystemAdminLogProvider.UpdateByLogid(objSystemAdminLogInfo);
/*     */ 
/* 430 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?" + pageListUrl);
/* 431 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 433 */       js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 435 */     this.request.setAttribute("pageJavaScripStar", js);
/* 436 */     SystemAdminLogProvider.setSystemAdminLogStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 445 */     int Logid = Requests.GetInt(this.request, "logid", 0);
/*     */ 
/* 447 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 451 */     SystemAdminLogProvider.DeleteByLogid(Logid);
/*     */ 
/* 453 */     SystemAdminLogProvider.setSystemAdminLogStatic(null);
/* 454 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "删除成功", "?" + pageListUrl);
/* 455 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.system.SystemAdminLog
 * JD-Core Version:    0.6.0
 */