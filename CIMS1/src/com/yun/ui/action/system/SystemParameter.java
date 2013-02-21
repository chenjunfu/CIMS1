/*     */ package com.yun.ui.action.system;
/*     */ 
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.RolesCompetenceProvider;
/*     */ import com.yun.bll.culture.SystemCompetenceProvider;
import com.yun.bll.culture.SystemParameterProvider;
/*     */ import com.yun.bll.itemcollection.ItemInfo;
/*     */ import com.yun.bll.itemcollection.culture.SystemCompetenceItemCollection;
/*     */ import com.yun.common.Pager;
/*     */ import com.yun.entities.culture.SystemParameterInfo;
/*     */ import com.yun.entities.culture.collection.SystemParameterInfoCollection;
/*     */ import com.yun.ui.action.UserLook;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class SystemParameter
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
/*     */ 	  UserLook userlook=new UserLook(this.request,this.response);
/*  75 */     String af = null;
/*  76 */     this.response.setCharacterEncoding("utf-8");
/*  77 */     this.out = this.response.getWriter();
/*  78 */     String pageListUrl = getpageListUrl();
/*     */ 
/*  81 */     int DatabaseID = Requests.GetInt(this.request, "databaseid", 0);

/*  92 */     String pageName = "SystemParameter";
/*  93 */     String pagetype = Requests.GetString(this.request, "pagetype").toLowerCase();
			 
/*  94 */    
/* 107 */      if (pagetype.equals("gotoupdate"))
/*     */     {
/* 109 */     
/* 110 */       ItemCommandDetails();
/* 111 */       this.request.setAttribute("btnEditText", "更新数据");
/* 112 */       this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "update"));
/* 113 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 115 */     else if (pagetype.equals("update"))
/*     */     {
	
				int count=SystemParameterProvider.CountBy();
				if(count==0)
				{
					insert();
				}
				else
				{
					 update();

				}
/* 117 */       this.request.setAttribute("btnEditText", "更新数据");
/* 118 */      
/* 119 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }

/* 126 */     else if (pagetype.equals("details"))
/*     */     {
				userlook.seePageY("22");
/* 128 */       ItemCommandDetails();
/* 129 */       af = String.format("%sDetails", new Object[] { pageName });
/*     */     }
/* 138 */     return af;
/*     */   }
/*     */ 
/*     */   
/*     */ 
/*     */  
/*     */ 

/*     */ 
/*     */   protected void ItemCommandDetails()
/*     */   {
/* 225 */     //int DatabaseID = Requests.GetInt(this.request, "databaseid", 1);
/*     */ 
/* 227 */     String pageListUrl = getpageListUrl();
/*     */     int DatabaseID=SystemParameterProvider.GetMaxDatabaseID();
/* 229 */     SystemParameterInfo objSystemParameterInfo = SystemParameterProvider.GetSystemParameterInfoByDatabaseid(DatabaseID);
/* 230 */     if (objSystemParameterInfo != null)
/*     */     {
/* 232 */       this.request.setAttribute("databaseid", Integer.valueOf(objSystemParameterInfo.getDatabaseid()));
/* 233 */       this.request.setAttribute("unitname", objSystemParameterInfo.getUnitname());
/* 234 */       this.request.setAttribute("dept", objSystemParameterInfo.getDept());
/* 235 */       this.request.setAttribute("address", objSystemParameterInfo.getAddress());
/*     */     }
/*     */     else
/*     */     {
///* 246 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
///* 247 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected boolean ServerValidate()
/*     */   {
/* 256 */     StringBuilder sbStr = new StringBuilder(1024);
/* 257 */     int i = 1;
/*     */ 
/* 260 */
/*     */ 
/* 266 */    
/*     */ 
/* 273 */     if (Requests.GetString(this.request, "unitname").length() == 0)
/*     */     {
/* 275 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "单位名字" }));
/* 276 */       i++;
/*     */     }
/*
/*     */ 
/* 286 */     if (Requests.GetString(this.request, "dept").length() == 0)
/*     */     {
/* 288 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "部门名称" }));
/* 289 */       i++;
/*     */     }
/*     */ 


			  if (Requests.GetString(this.request, "address").length() == 0)
/*     */     {
/* 288 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "地址" }));
/* 289 */       i++;
/*     */     }
/*     */ 

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
/*     */     int DatabaseID=SystemParameterProvider.GetMaxDatabaseID();
/* 324 */     String UnitName = Requests.GetString(this.request, "unitname", "");
/* 325 */     String Dept = Requests.GetString(this.request, "dept", "");
/* 326 */     String Address = Requests.GetString(this.request, "address", "");

/*     */ 
/* 330 */     if (!ServerValidate())
/*     */     {
/* 333 */     
/* 334 */       this.request.setAttribute("databaseid", Integer.valueOf(DatabaseID));
/* 336 */       this.request.setAttribute("unitname", StringFormat.HtmlEncode(UnitName));
/* 337 */       this.request.setAttribute("dept", StringFormat.HtmlEncode(Dept));
/* 338 */       this.request.setAttribute("address", StringFormat.HTMLDecode(Address));
/* 339 */       return;
/*     */     }
/*     */ 
/* 342 */     SystemParameterInfo objSystemParameterInfo = new SystemParameterInfo();
/* 343 */     objSystemParameterInfo.setDatabaseid(DatabaseID);
/* 344 */     objSystemParameterInfo.setUnitname(UnitName);
/* 345 */     objSystemParameterInfo.setDept(Dept);
/* 346 */     objSystemParameterInfo.setAddress(Address);
/* 347 */    
/*     */ 
/* 349 */     SystemParameterProvider.Insert(objSystemParameterInfo);
/*     */ 
/* 351 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "SystemParameter.do?pagetype=Details");
/* 352 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 354 */       js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 356 */     this.request.setAttribute("pageJavaScripStar", js);
/* 357 */     SystemParameterProvider.setSystemParameterStatic(null);
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 365 */     String pageListUrl = getpageListUrl();
/*     */    
/*     */     int DatabaseID=SystemParameterProvider.GetMaxDatabaseID();
/* 368 */     String UnitName = Requests.GetString(this.request, "unitname", "");
/* 369 */     String Dept = Requests.GetString(this.request, "dept", "");
/* 370 */     String Address = Requests.GetString(this.request, "address", "");

/*     */ 
/* 374 */     if (!ServerValidate())
/*     */     {
/* 377 */      
/* 378 */       this.request.setAttribute("databaseid", Integer.valueOf(DatabaseID));
/* 380 */       this.request.setAttribute("unitname", StringFormat.HtmlEncode(UnitName));
/* 381 */       this.request.setAttribute("dept", StringFormat.HtmlEncode(Dept));
/* 382 */       this.request.setAttribute("address", StringFormat.HtmlEncode(Address));
/* 383 */       return;
/*     */     }
/*     */ 
/* 387 */     SystemParameterInfo objSystemParameterInfo = SystemParameterProvider.GetSystemParameterInfoByDatabaseid(DatabaseID);
/* 388 */    
/* 389 */     
/* 390 */     objSystemParameterInfo.setUnitname(UnitName);
/* 391 */     objSystemParameterInfo.setDept(Dept);
/* 392 */     objSystemParameterInfo.setAddress(Address);
/*     */ 
/* 394 */     SystemParameterProvider.UpdateByDatabaseid(objSystemParameterInfo);
/*     */ 
/* 396 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "SystemParameter.do?pagetype=Details");
/* 401 */     this.request.setAttribute("pageJavaScripStar", js);
/* 402 */     SystemParameterProvider.setSystemParameterStatic(null);
/*     */   }
/*     */ 
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.system.SystemCompetence
 * JD-Core Version:    0.6.0
 */