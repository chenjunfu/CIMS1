/*     */ package com.yun.ui.action.dictionary;
/*     */ 
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.EnterpristQualityProvider;
/*     */ import com.yun.common.Pager;
import com.yun.configuration.WebConfig;
/*     */ import com.yun.entities.culture.EnterpristQualityInfo;
/*     */ import com.yun.entities.culture.collection.EnterpristQualityInfoCollection;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class EnterpristQuality
/*     */ {
/*     */   private static final long serialVersionUID = 2011112214090253126L;
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
/*  46 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "QualityID");
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
/*  78 */     int Qualityid = Requests.GetInt(this.request, "qualityid", 0);
/*     */ 
/*  83 */     String pageName = "EnterpristQuality";
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
/* 148 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "QualityID");
/* 149 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 150 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 152 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/*     */ 
/* 155 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 156 */     int pageAll = 0;
/* 157 */     pageAll = EnterpristQualityProvider.GetListPagerBy();
/* 158 */     EnterpristQualityInfoCollection EnterpristQualityColl = EnterpristQualityProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 159 */     this.request.setAttribute("EnterpristQualityList", EnterpristQualityColl);
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
/* 179 */     int Qualityid = Requests.GetInt(this.request, "qualitydatabaseid", 0);
/*     */ 
/* 181 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 183 */     EnterpristQualityInfo objEnterpristQualityInfo = EnterpristQualityProvider.GetEnterpristQualityInfoByQualitydatabaseid(Qualityid);
/* 184 */     if (objEnterpristQualityInfo != null)
/*     */     {
				this.request.setAttribute("Qualitydatabaseid", Integer.valueOf(objEnterpristQualityInfo.getQualitydatabaseid()));
/* 186 */       this.request.setAttribute("Qualityid", StringFormat.HtmlEncode(objEnterpristQualityInfo.getQualityid()));
/* 187 */       this.request.setAttribute("Qualityname", StringFormat.HtmlEncode(objEnterpristQualityInfo.getQualityname()));
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
/* 203 */     int Qualityid = Requests.GetInt(this.request, "qualitydatabaseid", 0);
/*     */ 
/* 205 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 207 */     EnterpristQualityInfo objEnterpristQualityInfo = EnterpristQualityProvider.GetEnterpristQualityInfoByQualitydatabaseid(Qualityid);
/* 208 */     if (objEnterpristQualityInfo != null)
/*     */     {
				this.request.setAttribute("Qualitydatabaseid", Integer.valueOf(objEnterpristQualityInfo.getQualitydatabaseid()));
/* 210 */       this.request.setAttribute("Qualityid", objEnterpristQualityInfo.getQualitydatabaseid());
/* 211 */       this.request.setAttribute("Qualityname", objEnterpristQualityInfo.getQualityname());
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
/*     */ 	  String pageListUrl = getpageListUrl();
			  if (Requests.GetString(this.request, "qualityid").length() == 0)
/*     */     {
/* 248 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "企业性质编号 " }));
/* 249 */       i++;
/*     */     }
/* 251 */     if (Validate.getLength(Requests.GetString(this.request, "qualityid")) > 50)
/*     */     {
/* 253 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "企业性质编号 " }));
/* 254 */       i++;
/*     */     }
			  if (!Validate.IsNumber(Requests.GetString(this.request, "qualityid")))
/*     */     {	

/* 253 */       sbStr.append(String.format("%1$s.%2$s必须为数字\n", new Object[] { Integer.valueOf(i), "企业性质编号 " }));
/* 254 */       i++; 
/*     */     }
			  EnterpristQualityInfoCollection eqc=EnterpristQualityProvider.GetListByQualityid(Requests.GetString(this.request, "qualityid"));
			  if(eqc.size()>0)
			  {
				  EnterpristQualityInfo enterpristqualityinfo=eqc.get(0);
				  if(enterpristqualityinfo.getQualitydatabaseid()!=Requests.GetInt(this.request, "qualitydatabaseid"))
				  {
					  sbStr.append(String.format("%1$s.%2$s%3$s已存在,请更改\n", new Object[] { Integer.valueOf(i), "编号",Requests.GetInt(this.request, "qualityid") }));
					  i++;
				  }
			  }
/* 246 */     if (Requests.GetString(this.request, "qualityname").length() == 0)
/*     */     {
/* 248 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "企业性质名称" }));
/* 249 */       i++;
/*     */     }
/* 251 */     if (Validate.getLength(Requests.GetString(this.request, "qualityname")) > 50)
/*     */     {
/* 253 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "企业性质名称" }));
/* 254 */       i++;
/*     */     }
/*     */ 
/* 258 */     if (i - 1 > 0)
/*     */     {
/* 260 */       sbStr.append("总共有" + (i - 1) + "个错误");

/* 261 */       String js = Javascript.Alert(this.request, this.response, sbStr.toString());
				
/* 262 */       this.request.setAttribute("pageJavaScripEnd", js);
/* 263 */     
/* 267 */       return false;
/*     */     }
/*     */ 
/* 271 */     return true;
/*     */   }
/*     */ 
/*     */   protected void insert()
/*     */   {
/* 280 */     String pageListUrl = getpageListUrl();
/*     */ 	  int Qualitydatabaseid=Requests.GetInt(this.request, "qualitydatabaseid",0);
/* 282 */     String Qualityid = Requests.GetString(this.request, "qualityid", "");
/* 283 */     String Qualityname = Requests.GetString(this.request, "qualityname", "");
/*     */ this.request.setAttribute("pagetype", "insert");
/* 286 */     if (!ServerValidate())
/*     */     {
/* 289 */       DrpInit();
				
/* 290 */       this.request.setAttribute("Qualityid", StringFormat.HtmlEncode(Qualityid));
/* 291 */       this.request.setAttribute("Qualityname", StringFormat.HtmlEncode(Qualityname));
/* 292 */       return;
/*     */     }
/*     */ 
/* 295 */     EnterpristQualityInfo objEnterpristQualityInfo = new EnterpristQualityInfo();
			  objEnterpristQualityInfo.setQualitydatabaseid(Qualitydatabaseid);
/* 296 */     objEnterpristQualityInfo.setQualityid(Qualityid);
/* 297 */     objEnterpristQualityInfo.setQualityname(Qualityname);
/*     */ 
/* 299 */     EnterpristQualityProvider.Insert(objEnterpristQualityInfo);
/*     */ 
/* 301 */     String js = Javascript.Alert(this.request, this.response, "添加成功");
			 
/* 306 */     this.request.setAttribute("pageJavaScripStar", js);
/* 307 */     EnterpristQualityProvider.setEnterpristQualityStatic(null);
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 315 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 317 */     int Qualitydatabaseid = Requests.GetInt(this.request, "qualitydatabaseid", 0);
			  String Qualityid=Requests.GetString(this.request, "qualityid", "");
/* 318 */     String Qualityname = Requests.GetString(this.request, "qualityname", "");
/*     */ this.request.setAttribute("pagetype", "update");
/* 321 */     if (!ServerValidate())
/*     */     {
/* 324 */       DrpInit();
				
/* 325 */       this.request.setAttribute("Qualityid", String.valueOf(Qualityid));
/* 326 */       this.request.setAttribute("Qualityname", StringFormat.HtmlEncode(Qualityname));
				this.request.setAttribute("Qualitydatabaseid", Integer.valueOf(Qualitydatabaseid));
/* 327 */       return;
/*     */     }
/*     */ 
/* 331 */     EnterpristQualityInfo objEnterpristQualityInfo = EnterpristQualityProvider.GetEnterpristQualityInfoByQualitydatabaseid(Qualitydatabaseid);
			
/* 332 */     objEnterpristQualityInfo.setQualityid(Qualityid);
/* 333 */     objEnterpristQualityInfo.setQualityname(Qualityname);
/*     */ 	  
/* 335 */     EnterpristQualityProvider.UpdateByQualitydatabaseid(objEnterpristQualityInfo);
/*     */ 
/* 337 */     String js = Javascript.Alert(this.request, this.response, "更新成功");
/* 338 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 340 */       js = Javascript.Alert(this.request, this.response, "更新成功");
/*     */     }
/* 342 */     this.request.setAttribute("pageJavaScripStar", js);
/* 343 */     EnterpristQualityProvider.setEnterpristQualityStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 352 */     int Qualityid = Requests.GetInt(this.request, "qualitydatabaseid", 0);
/*     */ 
/* 354 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 358 */     EnterpristQualityProvider.DeleteByQualitydatabaseid(Qualityid);
/*     */ 
/* 360 */     EnterpristQualityProvider.setEnterpristQualityStatic(null);
/* 361 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "删除成功", "?" + pageListUrl);
/* 362 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.enterprise.EnterpristQuality
 * JD-Core Version:    0.6.0
 */