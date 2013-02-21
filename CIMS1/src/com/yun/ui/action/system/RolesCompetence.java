/*     */ package com.yun.ui.action.system;
/*     */ 
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.RolesCompetenceProvider;
/*     */ import com.yun.common.Pager;
/*     */ import com.yun.entities.culture.RolesCompetenceInfo;
/*     */ import com.yun.entities.culture.collection.RolesCompetenceInfoCollection;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class RolesCompetence
/*     */ {
/*     */   private static final long serialVersionUID = 2011112516582742151L;
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
/*  46 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "DatabaseRoseCompetenceID");
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
/*  78 */     int Databaserosecompetenceid = Requests.GetInt(this.request, "databaserosecompetenceid", 0);
/*     */ 
/*  83 */     String pageName = "RolesCompetence";
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
/* 148 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "DatabaseRoseCompetenceID");
/* 149 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 150 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 152 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/*     */ 
/* 155 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 156 */     int pageAll = 0;
/* 157 */     pageAll = RolesCompetenceProvider.GetListPagerBy();
/* 158 */     RolesCompetenceInfoCollection RolesCompetenceColl = RolesCompetenceProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 159 */     this.request.setAttribute("RolesCompetenceList", RolesCompetenceColl);
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
/* 179 */     int Databaserosecompetenceid = Requests.GetInt(this.request, "databaserosecompetenceid", 0);
/*     */ 
/* 181 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 183 */     RolesCompetenceInfo objRolesCompetenceInfo = RolesCompetenceProvider.GetRolesCompetenceInfoByDatabaserosecompetenceid(Databaserosecompetenceid);
/* 184 */     if (objRolesCompetenceInfo != null)
/*     */     {
/* 186 */       this.request.setAttribute("Databaserosecompetenceid", Integer.valueOf(objRolesCompetenceInfo.getDatabaserosecompetenceid()));
/* 187 */       this.request.setAttribute("Rolesid", Integer.valueOf(objRolesCompetenceInfo.getRolesid()));
/* 188 */       this.request.setAttribute("Competenceid", Integer.valueOf(objRolesCompetenceInfo.getCompetenceid()));
/*     */     }
/*     */     else
/*     */     {
/* 193 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 194 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void ItemCommandDetails()
/*     */   {
/* 204 */     int Databaserosecompetenceid = Requests.GetInt(this.request, "databaserosecompetenceid", 0);
/*     */ 
/* 206 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 208 */     RolesCompetenceInfo objRolesCompetenceInfo = RolesCompetenceProvider.GetRolesCompetenceInfoByDatabaserosecompetenceid(Databaserosecompetenceid);
/* 209 */     if (objRolesCompetenceInfo != null)
/*     */     {
/* 211 */       this.request.setAttribute("Databaserosecompetenceid", Integer.valueOf(objRolesCompetenceInfo.getDatabaserosecompetenceid()));
/* 212 */       this.request.setAttribute("Rolesid", Integer.valueOf(objRolesCompetenceInfo.getRolesid()));
/* 213 */       this.request.setAttribute("Competenceid", Integer.valueOf(objRolesCompetenceInfo.getCompetenceid()));
/*     */     }
/*     */     else
/*     */     {
/* 222 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 223 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected boolean ServerValidate()
/*     */   {
/* 232 */     StringBuilder sbStr = new StringBuilder(1024);
/* 233 */     int i = 1;
/*     */ 
/* 235 */     if (Requests.GetString(this.request, "databaserosecompetenceid").length() == 0)
/*     */     {
/* 237 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "角色权限ID" }));
/* 238 */       i++;
/*     */     }
/*     */ 
/* 241 */     if (!Validate.IsNumber(Requests.GetString(this.request, "databaserosecompetenceid")))
/*     */     {
/* 243 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "角色权限ID" }));
/* 244 */       i++;
/*     */     }
/*     */ 
/* 248 */     if (Requests.GetString(this.request, "rolesid").length() == 0)
/*     */     {
/* 250 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "角色ID" }));
/* 251 */       i++;
/*     */     }
/*     */ 
/* 254 */     if (!Validate.IsNumber(Requests.GetString(this.request, "rolesid")))
/*     */     {
/* 256 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "角色ID" }));
/* 257 */       i++;
/*     */     }
/*     */ 
/* 261 */     if (Requests.GetString(this.request, "competenceid").length() == 0)
/*     */     {
/* 263 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "权限编号" }));
/* 264 */       i++;
/*     */     }
/*     */ 
/* 267 */     if (!Validate.IsNumber(Requests.GetString(this.request, "competenceid")))
/*     */     {
/* 269 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "权限编号" }));
/* 270 */       i++;
/*     */     }
/*     */ 
/* 274 */     if (i - 1 > 0)
/*     */     {
/* 276 */       sbStr.append("总共有" + (i - 1) + "个错误");
/* 277 */       String js = Javascript.Alert(this.request, this.response, sbStr.toString());
/* 278 */       this.request.setAttribute("pageJavaScripEnd", js);
/* 279 */       if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */       {
/* 281 */         this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "insert"));
/*     */       }
/* 283 */       return false;
/*     */     }
/*     */ 
/* 287 */     return true;
/*     */   }
/*     */ 
/*     */   protected void insert()
/*     */   {
/* 296 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 298 */     int Databaserosecompetenceid = Requests.GetInt(this.request, "databaserosecompetenceid", 0);
/* 299 */     int Rolesid = Requests.GetInt(this.request, "rolesid", 0);
/* 300 */     int Competenceid = Requests.GetInt(this.request, "competenceid", 0);
/*     */ 
/* 303 */     if (!ServerValidate())
/*     */     {
/* 306 */       DrpInit();
/* 307 */       this.request.setAttribute("Databaserosecompetenceid", Integer.valueOf(Databaserosecompetenceid));
/* 308 */       this.request.setAttribute("Rolesid", Integer.valueOf(Rolesid));
/* 309 */       this.request.setAttribute("Competenceid", Integer.valueOf(Competenceid));
/* 310 */       return;
/*     */     }
/*     */ 
/* 313 */     RolesCompetenceInfo objRolesCompetenceInfo = new RolesCompetenceInfo();
/* 314 */     objRolesCompetenceInfo.setDatabaserosecompetenceid(Databaserosecompetenceid);
/* 315 */     objRolesCompetenceInfo.setRolesid(Rolesid);
/* 316 */     objRolesCompetenceInfo.setCompetenceid(Competenceid);
/*     */ 
/* 318 */     RolesCompetenceProvider.Insert(objRolesCompetenceInfo);
/*     */ 
/* 320 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?" + pageListUrl);
/* 321 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 323 */       js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 325 */     this.request.setAttribute("pageJavaScripStar", js);
/* 326 */     RolesCompetenceProvider.setRolesCompetenceStatic(null);
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 334 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 336 */     int Databaserosecompetenceid = Requests.GetInt(this.request, "databaserosecompetenceid", 0);
/* 337 */     int Rolesid = Requests.GetInt(this.request, "rolesid", 0);
/* 338 */     int Competenceid = Requests.GetInt(this.request, "competenceid", 0);
/*     */ 
/* 341 */     if (!ServerValidate())
/*     */     {
/* 344 */       DrpInit();
/* 345 */       this.request.setAttribute("Databaserosecompetenceid", Integer.valueOf(Databaserosecompetenceid));
/* 346 */       this.request.setAttribute("Rolesid", Integer.valueOf(Rolesid));
/* 347 */       this.request.setAttribute("Competenceid", Integer.valueOf(Competenceid));
/* 348 */       return;
/*     */     }
/*     */ 
/* 352 */     RolesCompetenceInfo objRolesCompetenceInfo = RolesCompetenceProvider.GetRolesCompetenceInfoByDatabaserosecompetenceid(Databaserosecompetenceid);
/* 353 */     objRolesCompetenceInfo.setDatabaserosecompetenceid(Databaserosecompetenceid);
/* 354 */     objRolesCompetenceInfo.setRolesid(Rolesid);
/* 355 */     objRolesCompetenceInfo.setCompetenceid(Competenceid);
/*     */ 
/* 357 */     RolesCompetenceProvider.UpdateByDatabaserosecompetenceid(objRolesCompetenceInfo);
/*     */ 
/* 359 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?" + pageListUrl);
/* 360 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 362 */       js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 364 */     this.request.setAttribute("pageJavaScripStar", js);
/* 365 */     RolesCompetenceProvider.setRolesCompetenceStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 374 */     int Databaserosecompetenceid = Requests.GetInt(this.request, "databaserosecompetenceid", 0);
/*     */ 
/* 376 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 380 */     RolesCompetenceProvider.DeleteByDatabaserosecompetenceid(Databaserosecompetenceid);
/*     */ 
/* 382 */     RolesCompetenceProvider.setRolesCompetenceStatic(null);
/* 383 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "删除成功", "?" + pageListUrl);
/* 384 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.system.RolesCompetence
 * JD-Core Version:    0.6.0
 */