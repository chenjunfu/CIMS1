/*     */ package com.yun.ui.action.dictionary;
/*     */ 
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.EducationProvider;
/*     */ import com.yun.common.Pager;
import com.yun.configuration.WebConfig;
/*     */ import com.yun.entities.culture.EducationInfo;
/*     */ import com.yun.entities.culture.collection.EducationInfoCollection;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class Education
/*     */ {
/*     */   private static final long serialVersionUID = 2011112115594877593L;
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
/*  46 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "EducationID");
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
/*  78 */     int Educationid = Requests.GetInt(this.request, "educationid", 0);
/*     */ 
/*  83 */     String pageName = "Education";
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
/* 148 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "EducationID");
/* 149 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 150 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 152 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/*     */ 
/* 155 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 156 */     int pageAll = 0;
/* 157 */     pageAll = EducationProvider.GetListPagerBy();
/* 158 */     EducationInfoCollection EducationColl = EducationProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 159 */     this.request.setAttribute("EducationList", EducationColl);
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
/* 179 */     int Educationdatabaseid = Requests.GetInt(this.request, "educationdatabaseid", 0);
/*     */ 
/* 181 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 183 */     EducationInfo objEducationInfo = EducationProvider.GetEducationInfoByEducationdatabaseid(Educationdatabaseid);
/* 184 */     if (objEducationInfo != null)
/*     */     {	
				this.request.setAttribute("Educationdatabaseid", Educationdatabaseid);
/* 186 */       this.request.setAttribute("Educationid", Integer.valueOf(objEducationInfo.getEducationid()));
/* 187 */       this.request.setAttribute("Educationname", StringFormat.HtmlEncode(objEducationInfo.getEducationname()));
/*     */     }
/*     */    
/*     */   }
/*     */ 
/*     */   protected void ItemCommandDetails()
/*     */   {
/* 203 */     int Educationdatabaseid = Requests.GetInt(this.request, "educationdatabaseid", 0);
/*     */ 
/* 205 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 207 */     EducationInfo objEducationInfo = EducationProvider.GetEducationInfoByEducationdatabaseid(Educationdatabaseid);
/* 208 */     if (objEducationInfo != null)
/*     */     {
				this.request.setAttribute("Educationdatabaseid", Educationdatabaseid);
				
/* 210 */       this.request.setAttribute("Educationid", Integer.valueOf(objEducationInfo.getEducationid()));
/* 211 */       this.request.setAttribute("Educationname", objEducationInfo.getEducationname());
/*     */     }
/*     */    
/*     */   }
/*     */ 
/*     */   protected boolean ServerValidate()
/*     */   {
/* 230 */     StringBuilder sbStr = new StringBuilder(1024);
/* 231 */     int i = 1;

/* 233 */   if (Requests.GetString(this.request, "educationid").length() == 0)
/*     */     {
	/* 248 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "编号" }));
	/* 249 */       i++;
	/*     */     }
	/* 251 */     if (Validate.getLength(Requests.GetString(this.request, "educationid")) > 50)
	/*     */     {
	/* 253 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "编号" }));
	/* 254 */       i++;
	/*     */     }
				EducationInfoCollection ec=EducationProvider.GetListByEducationid(Requests.GetInt(this.request, "educationid"));
				if(ec.size()>0)
				{
					EducationInfo e=ec.get(0);
					if(e.getEducationdatabaseid()!=Requests.GetInt(this.request, "educationdatabaseid"))
					{
						sbStr.append(String.format("%1$s.%2$s%3$s已经存在,请更换\n", new Object[] { Integer.valueOf(i), "编号",Requests.GetInt(this.request, "educationid") }));
			            i = i + 1;
					}
				}
/*     */ 
/* 246 */     if (Requests.GetString(this.request, "educationname").length() == 0)
/*     */     {
/* 248 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "学历名称" }));
/* 249 */       i++;
/*     */     }
/* 251 */     if (Validate.getLength(Requests.GetString(this.request, "educationname")) > 50)
/*     */     {
/* 253 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "学历名称" }));
/* 254 */       i++;
/*     */     }
/*     */ 
/* 258 */     if (i - 1 > 0)
/*     */     {	
				String pagelisturl=getpageListUrl();
/* 260 */       sbStr.append("总共有" + (i - 1) + "个错误");
/* 261 */       String js = Javascript.Alert(this.request, this.response, sbStr.toString());
/* 262 */     
				this.request.setAttribute("pageJavaScripEnd", js);

///* 263 */   
			   
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
/* 282 */     int Educationid = Requests.GetInt(this.request, "educationid", 0);
/* 283 */     String Educationname = Requests.GetString(this.request, "educationname", "");
/*     */     this.request.setAttribute("pagetype", "update");
/* 286 */     if (!ServerValidate())
/*     */     {
/* 289 */       DrpInit();
				this.request.setAttribute("pagetype", "insert");
/* 290 */       this.request.setAttribute("Educationid", Integer.valueOf(Educationid));
/* 291 */       this.request.setAttribute("Educationname", StringFormat.HtmlEncode(Educationname));
/* 292 */       return;
/*     */     }
/*     */ 
/* 295 */     EducationInfo objEducationInfo = new EducationInfo();
/* 296 */     objEducationInfo.setEducationid(Educationid);
/* 297 */     objEducationInfo.setEducationname(Educationname);
/*     */ 
/* 299 */     EducationProvider.Insert(objEducationInfo);
/*     */ 
/* 301 */     String js = Javascript.Alert(this.request, this.response, "添加成功");
/* 302 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 304 */       js = Javascript.Alert(this.request, this.response, "添加成功");
/*     */     }
/* 306 */     this.request.setAttribute("pageJavaScripStar", js);
/* 307 */     EducationProvider.setEducationStatic(null);
			
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 315 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 317 */     int Educationid = Requests.GetInt(this.request, "educationid", 0);
/* 317 */     int Educationdatabaseid = Requests.GetInt(this.request, "educationdatabaseid", 0);
/* 318 */     String Educationname = Requests.GetString(this.request, "educationname", "");
/*     */ 		this.request.setAttribute("pagetype", "update");
/* 321 */     if (!ServerValidate())
/*     */     {
/* 324 */       DrpInit();
				
				this.request.setAttribute("Educationdatabaseid", Educationdatabaseid);
/* 325 */       this.request.setAttribute("Educationid", Integer.valueOf(Educationid));
/* 326 */       this.request.setAttribute("Educationname", StringFormat.HtmlEncode(Educationname));
/* 327 */       return;
/*     */     }
/*     */ 
/* 331 */     EducationInfo objEducationInfo = EducationProvider.GetEducationInfoByEducationdatabaseid(Educationid);
/* 332 */     objEducationInfo.setEducationid(Educationid);
/* 333 */     objEducationInfo.setEducationname(Educationname);
/*     */ 
/* 335 */     EducationProvider.UpdateByEducationdatabaseid(objEducationInfo);
/*     */ 
/* 337 */     String js = Javascript.Alert(this.request, this.response, "更新成功");
/* 338 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 340 */       js = Javascript.Alert(this.request, this.response, "更新成功");
/*     */     }
/* 342 */     this.request.setAttribute("pageJavaScripStar", js);
/* 343 */     EducationProvider.setEducationStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 352 */     int Educationdatabaseid = Requests.GetInt(this.request, "educationdatabaseid", 0);
/*     */ 
/* 354 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 358 */     EducationProvider.DeleteByEducationdatabaseid(Educationdatabaseid);
/*     */ 
/* 360 */     EducationProvider.setEducationStatic(null);
/* 361 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "删除成功", "?" + pageListUrl);
/* 362 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.dictionary.Education
 * JD-Core Version:    0.6.0
 */