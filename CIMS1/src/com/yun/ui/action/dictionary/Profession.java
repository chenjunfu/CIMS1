/*     */ package com.yun.ui.action.dictionary;
/*     */ 
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.ProfessionProvider;
/*     */ import com.yun.common.Pager;
import com.yun.configuration.WebConfig;
/*     */ import com.yun.entities.culture.ProfessionInfo;
/*     */ import com.yun.entities.culture.collection.ProfessionInfoCollection;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class Profession
/*     */ {
/*     */   private static final long serialVersionUID = 2011112216315493716L;
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
/*  46 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "BusinessTypeID");
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
/*  78 */     int Businesstypeid = Requests.GetInt(this.request, "businesstypeid", 0);
/*     */ 
/*  83 */     String pageName = "Profession";
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
/* 148 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "BusinessTypeID");
/* 149 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 150 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 152 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/*     */ 
/* 155 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 156 */     int pageAll = 0;
/* 157 */     pageAll = ProfessionProvider.GetListPagerBy();
/* 158 */     ProfessionInfoCollection ProfessionColl = ProfessionProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 159 */     this.request.setAttribute("ProfessionList", ProfessionColl);
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
/* 179 */     int businessdatabaseid = Requests.GetInt(this.request, "businessdatabaseid", 0);
/*     */ 
/* 181 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 183 */     ProfessionInfo objProfessionInfo = ProfessionProvider.GetProfessionInfoByBusinessdatabaseid(businessdatabaseid);
/* 184 */     if (objProfessionInfo != null)
/*     */     {	
				this.request.setAttribute("businessdatabaseid", businessdatabaseid);
/* 186 */       this.request.setAttribute("Businesstypeid", objProfessionInfo.getBusinesstypeid());
/* 187 */       this.request.setAttribute("Businesstypename", StringFormat.HtmlEncode(objProfessionInfo.getBusinesstypename()));
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
/* 203 */     int businessdatabaseid = Requests.GetInt(this.request, "businessdatabaseid", 0);
/*     */ 
/* 205 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 207 */     ProfessionInfo objProfessionInfo = ProfessionProvider.GetProfessionInfoByBusinessdatabaseid(businessdatabaseid);
/* 208 */     if (objProfessionInfo != null)
/*     */     {	
				this.request.setAttribute("businessdatabaseid", businessdatabaseid);
/* 210 */       this.request.setAttribute("Businesstypeid", Integer.valueOf(objProfessionInfo.getBusinesstypeid()));
/* 211 */       this.request.setAttribute("Businesstypename", objProfessionInfo.getBusinesstypename());
/*     */     }
/*     */     else
/*     */     {
/* 220 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 221 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected boolean ServerValidate()
/*     */   {
/* 230 */     StringBuilder sbStr = new StringBuilder(1024);
/* 231 */     int i = 1;
/*     */ 
/* 233 */  		if (Requests.GetString(this.request, "businesstypeid").length() == 0)
/*     */     {
	/* 248 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "企业行业类型ID" }));
	/* 249 */       i++;
	/*     */     }
	/* 251 */     if (Validate.getLength(Requests.GetString(this.request, "businesstypeid")) > 50)
	/*     */     {
	/* 253 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "企业行业类型ID" }));
	/* 254 */       i++;
	/*     */     }
			  ProfessionInfoCollection pc=ProfessionProvider.GetListByBusinesstypeid(Requests.GetInt(this.request, "businesstypeid"));
			  if(pc.size()>0)
			  {
				  ProfessionInfo profession=pc.get(0);
				  if(profession.getBusinessdatabaseid()!=Requests.GetInt(this.request, "businessdatabaseid"))
				  {
					  sbStr.append(String.format("%1$s.%2$s：%3$s已存在,请更改\n", new Object[] { Integer.valueOf(i), "编号",Requests.GetInt(this.request, "businesstypeid") }));
					  i++;
				  }
			  }
/*     */ 
/* 246 */     if (Requests.GetString(this.request, "businesstypename").length() == 0)
/*     */     {
/* 248 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "企业行业类型名称" }));
/* 249 */       i++;
/*     */     }
/* 251 */     if (Validate.getLength(Requests.GetString(this.request, "businesstypename")) > 50)
/*     */     {
/* 253 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "企业行业类型名称" }));
/* 254 */       i++;
/*     */     }
/*     */ 	  
/* 258 */     if (i - 1 > 0)
/*     */     {
/* 260 */       sbStr.append("总共有" + (i - 1) + "个错误");
/* 261 */       String js = Javascript.Alert(this.request, this.response, sbStr.toString());
				
/* 262 */       this.request.setAttribute("pageJavaScripEnd", js);
/* 263 */       if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */       {
/* 265 */         this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "insert"));
/*     */       }
			   
/* 267 */       return false;
/*     */     }
/*     */ 
/* 271 */     return true;
/*     */   }
/*     */ 
/*     */   protected void insert()
/*     */   {
/* 280 */     String pageListUrl = getpageListUrl();
/*     */ 		
/* 282 */     int Businesstypeid = Requests.GetInt(this.request, "businesstypeid", 0);
/* 283 */     String Businesstypename = Requests.GetString(this.request, "businesstypename", "");
/*     */ 		this.request.setAttribute("pagetype", "insert");
/* 286 */     if (!ServerValidate())
/*     */     {
/* 289 */       DrpInit();
				
/* 290 */       this.request.setAttribute("Businesstypeid", Integer.valueOf(Businesstypeid));
/* 291 */       this.request.setAttribute("Businesstypename", StringFormat.HtmlEncode(Businesstypename));
/* 292 */       return;
/*     */     }
/*     */ 
/* 295 */     ProfessionInfo objProfessionInfo = new ProfessionInfo();
/* 296 */     objProfessionInfo.setBusinesstypeid(Businesstypeid);
/* 297 */     objProfessionInfo.setBusinesstypename(Businesstypename);
/*     */ 
/* 299 */     ProfessionProvider.Insert(objProfessionInfo);
/*     */ 
/* 301 */     String js = Javascript.Alert(this.request, this.response, "添加成功");
/* 302 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 304 */       js = Javascript.Alert(this.request, this.response, "添加成功");
/*     */     }
			  
/* 306 */     this.request.setAttribute("pageJavaScripStar", js);
/* 307 */     ProfessionProvider.setProfessionStatic(null);
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 315 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 317 */     int businessdatabaseid = Requests.GetInt(this.request, "businessdatabaseid", 0);
			  int Businesstypeid=Requests.GetInt(this.request, "businesstypeid",0);
/* 318 */     String Businesstypename = Requests.GetString(this.request, "businesstypename", "");
/*     */ 		this.request.setAttribute("pagetype", "update");
/* 321 */     if (!ServerValidate())
/*     */     {
/* 324 */       DrpInit();
				
				this.request.setAttribute("businessdatabaseid", businessdatabaseid);
/* 325 */       this.request.setAttribute("Businesstypeid", Integer.valueOf(Businesstypeid));
/* 326 */       this.request.setAttribute("Businesstypename", StringFormat.HtmlEncode(Businesstypename));
/* 327 */       return;
/*     */     }
/*     */ 
/* 331 */     ProfessionInfo objProfessionInfo = ProfessionProvider.GetProfessionInfoByBusinessdatabaseid(businessdatabaseid);
/* 332 */     objProfessionInfo.setBusinesstypeid(Businesstypeid);
/* 333 */     objProfessionInfo.setBusinesstypename(Businesstypename);
/*     */ 
/* 335 */     ProfessionProvider.UpdateByBusinessdatabaseid(objProfessionInfo);
/*     */ 
/* 337 */     String js = Javascript.Alert(this.request, this.response, "更新成功");
/* 338 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 340 */       js = Javascript.Alert(this.request, this.response, "更新成功");
/*     */     }
/* 342 */     this.request.setAttribute("pageJavaScripStar", js);
/* 343 */     ProfessionProvider.setProfessionStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 352 */     int businessdatabaseid = Requests.GetInt(this.request, "businessdatabaseid", 0);
/*     */ 
/* 354 */     String pageListUrl = getpageListUrl();

/* 358 */     ProfessionProvider.DeleteByBusinessdatabaseid(businessdatabaseid);
/*     */ 
/* 360 */     ProfessionProvider.setProfessionStatic(null);
/* 361 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "删除成功", "?" + pageListUrl);
/* 362 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.enterprise.Profession
 * JD-Core Version:    0.6.0
 */