/*     */ package com.yun.ui.action.ajax;
/*     */ 
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.ProjectpicProvider;
/*     */ import com.yun.common.Pager;
/*     */ import com.yun.entities.culture.ProjectpicInfo;
import com.yun.entities.culture.base.ProjectpicInfoBase;
/*     */ import com.yun.entities.culture.collection.ProjectpicInfoCollection;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class Projectpic
/*     */ {
/*     */   private static final long serialVersionUID = 2011112118303187586L;
/*  20 */   public int pageSize = 6;
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
/*  46 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "ProjectPicID");
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
/*  78 */     int Projectpicid = Requests.GetInt(this.request, "projectpicid", 0);
/*     */ 
/*  83 */     String pageName = "Projectpic";
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
/* 148 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "ProjectPicID");
/* 149 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 150 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 152 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/*     */ 
/* 155 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 156 */     int pageAll = 0;
int databaseprojectid=Requests.GetInt(this.request, "databaseprojectid");
pageAll=ProjectpicProvider.GetListPagerByDatabaseprojectid(databaseprojectid);

/* 158 */     ProjectpicInfoCollection ProjectpicColl = ProjectpicProvider.GetListPagerByDatabaseprojectid(databaseprojectid,"ProjectPicID", pageIndex, this.pageSize);
/* 159 */     this.request.setAttribute("ProjectpicList", ProjectpicColl);
/*     */ 
/* 166 */     String pageDetails = "";
/* 167 */     if (pageAll > this.pageSize)
/*     */     {
/* 169 */       pageDetails = Pager.LastNextPageByAjax(this.request, this.response, this.pageParameter, this.pageSize, pageAll);
/*     */     }
/* 171 */     this.request.setAttribute("pageDetails", pageDetails);
/*     */   }
/*     */ 
/*     */   protected void ItemCommandEdit()
/*     */   {
/* 180 */     int Projectpicid = Requests.GetInt(this.request, "projectpicid", 0);
/*     */ 
/* 182 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 184 */     ProjectpicInfo objProjectpicInfo = ProjectpicProvider.GetProjectpicInfoByProjectpicid(Projectpicid);
/* 185 */     if (objProjectpicInfo != null)
/*     */     {
/* 187 */       this.request.setAttribute("Projectpicid", Integer.valueOf(objProjectpicInfo.getProjectpicid()));
/* 188 */       this.request.setAttribute("Databaseprojectid", Integer.valueOf(objProjectpicInfo.getDatabaseprojectid()));
/* 189 */       this.request.setAttribute("Pic", StringFormat.HtmlEncode(objProjectpicInfo.getPic()));
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
/* 205 */     int Projectpicid = Requests.GetInt(this.request, "projectpicid", 0);
/*     */ 
/* 207 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 209 */     ProjectpicInfo objProjectpicInfo = ProjectpicProvider.GetProjectpicInfoByProjectpicid(Projectpicid);
/* 210 */     if (objProjectpicInfo != null)
/*     */     {
/* 212 */       this.request.setAttribute("Projectpicid", Integer.valueOf(objProjectpicInfo.getProjectpicid()));
/* 213 */       this.request.setAttribute("Databaseprojectid", Integer.valueOf(objProjectpicInfo.getDatabaseprojectid()));
/* 214 */       this.request.setAttribute("Pic", objProjectpicInfo.getPic());
/*     */     }
/*     */     else
/*     */     {
/* 223 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 224 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected boolean ServerValidate()
/*     */   {
/* 233 */     StringBuilder sbStr = new StringBuilder(1024);
/* 234 */     int i = 1;
/*     */ 
/* 236 */     if (Requests.GetString(this.request, "projectpicid").length() == 0)
/*     */     {
/* 238 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "项目图片编号" }));
/* 239 */       i++;
/*     */     }
/*     */ 
/* 242 */     if (!Validate.IsNumber(Requests.GetString(this.request, "projectpicid")))
/*     */     {
/* 244 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "项目图片编号" }));
/* 245 */       i++;
/*     */     }
/*     */ 
/* 249 */     if (Requests.GetString(this.request, "databaseprojectid").length() == 0)
/*     */     {
/* 251 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "项目编号" }));
/* 252 */       i++;
/*     */     }
/*     */ 
/* 255 */     if (!Validate.IsNumber(Requests.GetString(this.request, "databaseprojectid")))
/*     */     {
/* 257 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "项目编号" }));
/* 258 */       i++;
/*     */     }
/*     */ 
/* 262 */     if (Requests.GetString(this.request, "pic").length() == 0)
/*     */     {
/* 264 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "项目图片" }));
/* 265 */       i++;
/*     */     }
/* 267 */     if (Validate.getLength(Requests.GetString(this.request, "pic")) > 100)
/*     */     {
/* 269 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于100\n", new Object[] { Integer.valueOf(i), "项目图片" }));
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
/* 298 */     int Projectpicid = Requests.GetInt(this.request, "projectpicid", 0);
/* 299 */     int Databaseprojectid = Requests.GetInt(this.request, "databaseprojectid", 0);
/* 300 */     String Pic = Requests.GetString(this.request, "pic", "");
/*     */ 
/* 303 */     if (!ServerValidate())
/*     */     {
/* 306 */       DrpInit();
/* 307 */       this.request.setAttribute("Projectpicid", Integer.valueOf(Projectpicid));
/* 308 */       this.request.setAttribute("Databaseprojectid", Integer.valueOf(Databaseprojectid));
/* 309 */       this.request.setAttribute("Pic", StringFormat.HtmlEncode(Pic));
/* 310 */       return;
/*     */     }
/*     */ 
/* 313 */     ProjectpicInfo objProjectpicInfo = new ProjectpicInfo();
/* 314 */     objProjectpicInfo.setProjectpicid(Projectpicid);
/* 315 */     objProjectpicInfo.setDatabaseprojectid(Databaseprojectid);
/* 316 */     objProjectpicInfo.setPic(Pic);
/*     */ 
/* 318 */     ProjectpicProvider.Insert(objProjectpicInfo);
/*     */ 
/* 320 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?" + pageListUrl);
/* 321 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 323 */       js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 325 */     this.request.setAttribute("pageJavaScripStar", js);
/* 326 */     ProjectpicProvider.setProjectpicStatic(null);
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 334 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 336 */     int Projectpicid = Requests.GetInt(this.request, "projectpicid", 0);
/* 337 */     int Databaseprojectid = Requests.GetInt(this.request, "databaseprojectid", 0);
/* 338 */     String Pic = Requests.GetString(this.request, "pic", "");
/*     */ 
/* 341 */     if (!ServerValidate())
/*     */     {
/* 344 */       DrpInit();
/* 345 */       this.request.setAttribute("Projectpicid", Integer.valueOf(Projectpicid));
/* 346 */       this.request.setAttribute("Databaseprojectid", Integer.valueOf(Databaseprojectid));
/* 347 */       this.request.setAttribute("Pic", StringFormat.HtmlEncode(Pic));
/* 348 */       return;
/*     */     }
/*     */ 
/* 352 */     ProjectpicInfo objProjectpicInfo = ProjectpicProvider.GetProjectpicInfoByProjectpicid(Projectpicid);
/* 353 */     objProjectpicInfo.setProjectpicid(Projectpicid);
/* 354 */     objProjectpicInfo.setDatabaseprojectid(Databaseprojectid);
/* 355 */     objProjectpicInfo.setPic(Pic);
/*     */ 
/* 357 */     ProjectpicProvider.UpdateByProjectpicid(objProjectpicInfo);
/*     */ 
/* 359 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?" + pageListUrl);
/* 360 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 362 */       js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 364 */     this.request.setAttribute("pageJavaScripStar", js);
/* 365 */     ProjectpicProvider.setProjectpicStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 374 */     int Projectpicid = Requests.GetInt(this.request, "projectpicid", 0);
/*     */     
/* 376 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 380 */     ProjectpicProvider.DeleteByProjectpicid(Projectpicid);
/*     */ 
/* 382 */     ProjectpicProvider.setProjectpicStatic(null);
/* 383 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "删除成功", "?" + pageListUrl);
/* 384 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.ajax.Projectpic
 * JD-Core Version:    0.6.0
 */