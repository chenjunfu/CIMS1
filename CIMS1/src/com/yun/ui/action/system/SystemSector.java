/*     */ package com.yun.ui.action.system;
/*     */ 
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.RolesCompetenceProvider;
/*     */ import com.yun.bll.culture.SystemSectorProvider;
/*     */ import com.yun.bll.itemcollection.ItemInfo;
/*     */ import com.yun.bll.itemcollection.culture.SystemSectorItemCollection;
/*     */ import com.yun.common.Pager;
/*     */ import com.yun.entities.culture.SystemSectorInfo;
/*     */ import com.yun.entities.culture.collection.SystemSectorInfoCollection;
/*     */ import com.yun.ui.action.UserLook;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class SystemSector
/*     */ {
/*     */   private static final long serialVersionUID = 2011112116081393176L;
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
/*  49 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "SectorID");
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
/*  81 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
/*     */ 
/*  83 */     UserLook userlook = new UserLook(this.request, this.response);
/*  84 */     userlook.seePageY("21");
/*  85 */    
/*     */    
/*  92 */     String pageName = "SystemSector";
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
/*     */     else if(pagetype.equals("tree"))
				{
						String treeString=com.yun.bll.culture.SystemSectorProvider.getSystemTree();
						 int defaultItem=SystemSectorProvider.getSystemSectorStatic().get(0).getSectordatabaseid();
						 defaultItem=Requests.GetInt(this.request, "default",defaultItem);
						request.setAttribute("defaultItem", "<script>ItemCommandEditSector("+defaultItem+")</script>");
						request.setAttribute("SystemConfigTree", treeString);
						af="SystemSector";
				}
				else
/*     */     {
/* 135 */       DrpInit();
/* 136 */       ListShow();
/* 137 */       af = String.format("%sList", new Object[] { pageName });
/*     */     }
/* 139 */     return af;
/*     */   }
/*     */ 
/*     */   protected void DrpInit()
/*     */   {
/* 149 */     StringBuilder sbIsUse = new StringBuilder(100);
/* 150 */     for (ItemInfo itemInfo : SystemSectorItemCollection.IsUseCollection())
/*     */     {
/* 152 */       sbIsUse.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { itemInfo.getValue(), itemInfo.getText() }));
/*     */     }
/* 154 */     this.request.setAttribute("IsUse", Integer.valueOf(1));
/* 155 */     this.request.setAttribute("IsUseEdit", sbIsUse.toString());
/* 156 */     this.request.setAttribute("IsUseList", sbIsUse.toString());
/*     */ 
/* 159 */     StringBuilder sbIsDel = new StringBuilder(100);
/* 160 */     for (ItemInfo itemInfo : SystemSectorItemCollection.IsDelCollection())
/*     */     {
/* 162 */       sbIsDel.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { itemInfo.getValue(), itemInfo.getText() }));
/*     */     }
/* 164 */     this.request.setAttribute("IsDel", Integer.valueOf(1));
/* 165 */     this.request.setAttribute("IsDelEdit", sbIsDel.toString());
/* 166 */     this.request.setAttribute("IsDelList", sbIsDel.toString());
/*     */   }
/*     */ 
/*     */   protected void ListShow()
/*     */   {
/* 175 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 177 */     String OrderBy = "";
/* 178 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "SectorID");
/* 179 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 180 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 182 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/*     */ 
/* 185 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 186 */     int pageAll = 0;
/* 187 */     pageAll = SystemSectorProvider.GetListPagerBy();
/* 188 */     SystemSectorInfoCollection SystemSectorColl = SystemSectorProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 189 */     this.request.setAttribute("SystemSectorList", SystemSectorColl);
/*     */ 
/* 196 */     String pageDetails = "";
/* 197 */     if (pageAll > this.pageSize) {
/* 198 */       pageDetails = Pager.LastNextPage(this.request, this.response, this.pageParameter, this.pageSize, pageAll);
/*     */     }
/* 200 */     this.request.setAttribute("pageDetails", pageDetails);
/*     */   }
/*     */ 
/*     */   protected void ItemCommandEdit()
/*     */   {
/* 209 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
/*     */ 
/* 211 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 213 */     SystemSectorInfo objSystemSectorInfo = SystemSectorProvider.GetSystemSectorInfoBySectordatabaseid(Sectorid);
/* 214 */     if (objSystemSectorInfo != null)
/*     */     {
/* 216 */       this.request.setAttribute("Sectorid", Integer.valueOf(objSystemSectorInfo.getSectorid()));
/* 216 */       this.request.setAttribute("Sectordatabaseid", Integer.valueOf(objSystemSectorInfo.getSectordatabaseid()));
/* 217 */       this.request.setAttribute("Sectorname", StringFormat.HtmlEncode(objSystemSectorInfo.getSectorname()));
/* 218 */       this.request.setAttribute("Description", StringFormat.HtmlEncode(objSystemSectorInfo.getDescription()));
/* 216 */       this.request.setAttribute("Address", Integer.valueOf(objSystemSectorInfo.getAddress()));
/* 216 */       this.request.setAttribute("Phone", Integer.valueOf(objSystemSectorInfo.getPhone()));
/* 219 */       this.request.setAttribute("IsUse", Integer.valueOf(objSystemSectorInfo.getIsUse()));
/* 220 */       this.request.setAttribute("IsDel", Integer.valueOf(objSystemSectorInfo.getIsDel()));
/* 216 */       this.request.setAttribute("DatabaseUnitID", Integer.valueOf(objSystemSectorInfo.getDatabaseunitid()));
/* 221 */       this.request.setAttribute("Sorts", Double.valueOf(objSystemSectorInfo.getSorts()));
/*     */     }
/*     */     else
/*     */     {
/* 226 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 227 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void ItemCommandDetails()
/*     */   {
/* 237 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
/*     */ 
/* 239 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 241 */     SystemSectorInfo objSystemSectorInfo = SystemSectorProvider.GetSystemSectorInfoBySectordatabaseid(Sectorid);
/* 242 */     if (objSystemSectorInfo != null)
/*     */     {
	/* 244 */       this.request.setAttribute("Sectordatabaseid", Integer.valueOf(objSystemSectorInfo.getSectordatabaseid()));
/* 244 */       this.request.setAttribute("Sectorid", Integer.valueOf(objSystemSectorInfo.getSectorid()));
/* 245 */       this.request.setAttribute("Sectorname", objSystemSectorInfo.getSectorname());
/* 246 */       this.request.setAttribute("Description", objSystemSectorInfo.getDescription());
/* 244 */       this.request.setAttribute("Address", Integer.valueOf(objSystemSectorInfo.getAddress()));
/* 244 */       this.request.setAttribute("Phone", Integer.valueOf(objSystemSectorInfo.getPhone()));
/* 247 */       this.request.setAttribute("IsUse", Integer.valueOf(objSystemSectorInfo.getIsUse()));
/* 248 */       this.request.setAttribute("IsDel", Integer.valueOf(objSystemSectorInfo.getIsDel()));
/* 248 */       this.request.setAttribute("DatabaseUnitID", Integer.valueOf(objSystemSectorInfo.getDatabaseunitid()));

/* 249 */       this.request.setAttribute("Sorts", Double.valueOf(objSystemSectorInfo.getSorts()));
/*     */ 
/* 254 */       this.request.setAttribute("IsUselabel", objSystemSectorInfo.getIsUselabel());
/* 255 */       this.request.setAttribute("IsDellabel", objSystemSectorInfo.getIsDellabel());
/*     */     }
/*     */     else
/*     */     {
/* 260 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 261 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected boolean ServerValidate()
/*     */   {
/* 270 */     StringBuilder sbStr = new StringBuilder(1024);
/* 271 */     int i = 1;
/*     */ 
/* 274 */     if (Requests.GetString(this.request, "sectorname").length() == 0)
/*     */     {
/* 276 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "部门名称" }));
/* 277 */       i++;
/*     */     }
/* 279 */     if (Validate.getLength(Requests.GetString(this.request, "sectorname")) > 50)
/*     */     {
/* 281 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "部门名称" }));
/* 282 */       i++;
/*     */     }
/*     */ 
/* 287 */     if (Requests.GetString(this.request, "isUse").length() == 0)
/*     */     {
/* 289 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "启用标志" }));
/* 290 */       i++;
/*     */     }
/*     */ 
/* 293 */     if (!Validate.IsNumber(Requests.GetString(this.request, "isUse")))
/*     */     {
/* 295 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "启用标志" }));
/* 296 */       i++;
/*     */     }
/*     */ 
/* 300 */     if (Requests.GetString(this.request, "isDel").length() == 0)
/*     */     {
/* 302 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "是否删除" }));
/* 303 */       i++;
/*     */     }
/*     */ 
/* 306 */     if (!Validate.IsNumber(Requests.GetString(this.request, "isDel")))
/*     */     {
/* 308 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "是否删除" }));
/* 309 */       i++;
/*     */     }
/*     */ 
/* 313 */     if (Requests.GetString(this.request, "sorts").length() == 0)
/*     */     {
/* 315 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "排序" }));
/* 316 */       i++;
/*     */     }
/*     */ 
/* 319 */     if (!Validate.IsNumber(Requests.GetString(this.request, "sorts")))
/*     */     {
/* 321 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "排序" }));
/* 322 */       i++;
/*     */     }
/*     */ 
/* 326 */     if (i - 1 > 0)
/*     */     {
/* 328 */       sbStr.append("总共有" + (i - 1) + "个错误");
/* 329 */       String js = Javascript.Alert(this.request, this.response, sbStr.toString());
/* 330 */       this.request.setAttribute("pageJavaScripEnd", js);
/* 331 */       if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */       {
/* 333 */         this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "insert"));
/*     */       }
/* 335 */       return false;
/*     */     }
/*     */ 
/* 339 */     return true;
/*     */   }
/*     */ 
/*     */   protected void insert()
/*     */   {
/* 348 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 350 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
/* 351 */     String Sectorname = Requests.GetString(this.request, "sectorname", "");
/* 352 */     String Description = Requests.GetString(this.request, "description", "");
String Address=Requests.GetString(this.request, "address","");
String Phone=Requests.GetString(this.request, "phone","");
/* 353 */     int IsUse = Requests.GetInt(this.request, "isUse", 0);
/* 354 */     int IsDel = Requests.GetInt(this.request, "isDel", 0);
String  DatabaseUnitID =Requests.GetString(this.request, "databaseunitid","0");
/* 355 */     double Sorts = Requests.GetDouble(this.request, "sorts", 0.0D);
/*     */ 
/* 358 */     if (!ServerValidate())
/*     */     {
/* 361 */       DrpInit();
/* 362 */       this.request.setAttribute("Sectorid", Integer.valueOf(Sectorid));
/* 363 */       this.request.setAttribute("Sectorname", StringFormat.HtmlEncode(Sectorname));
/* 364 */       this.request.setAttribute("Description", StringFormat.HtmlEncode(Description));
/* 365 */       this.request.setAttribute("IsUse", Integer.valueOf(IsUse));
/* 366 */       this.request.setAttribute("IsDel", Integer.valueOf(IsDel));
/* 367 */       this.request.setAttribute("Sorts", Double.valueOf(Sorts));
this.request.setAttribute("Address", Address);
this.request.setAttribute("Phone", Phone);
this.request.setAttribute("DatabaseUnitID", DatabaseUnitID);
/* 368 */       return;
/*     */     }
/*     */ 
/* 371 */     SystemSectorInfo objSystemSectorInfo = new SystemSectorInfo();
/* 372 */     objSystemSectorInfo.setSectorid(Sectorid);
/* 373 */     objSystemSectorInfo.setSectorname(Sectorname);
/* 374 */     objSystemSectorInfo.setDescription(Description);
objSystemSectorInfo.setAddress(Address);
objSystemSectorInfo.setPhone(Phone);
objSystemSectorInfo.setDatabaseunitid(DatabaseUnitID);

/* 375 */     objSystemSectorInfo.setIsUse(IsUse);
/* 376 */     objSystemSectorInfo.setIsDel(IsDel);
/* 377 */     objSystemSectorInfo.setSorts(Sorts);
/*     */ 
/* 379 */     SystemSectorProvider.Insert(objSystemSectorInfo);
/*     */ 
/* 381 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?" + pageListUrl);
/* 382 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 384 */       js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 386 */     this.request.setAttribute("pageJavaScripStar", js);
/* 387 */     SystemSectorProvider.setSystemSectorStatic(null);
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 395 */     String pageListUrl = getpageListUrl();
/*     */    int SectordatabaseID=Requests.GetInt(this.request, "sectordatabaseid",0);
/* 397 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
/* 398 */     String Sectorname = Requests.GetString(this.request, "sectorname", "");
/* 399 */     String Description = Requests.GetString(this.request, "description", "");
String Address=Requests.GetString(this.request, "address","");
String Phone =Requests.GetString(this.request, "phone");
/* 400 */     int IsUse = Requests.GetInt(this.request, "isUse", 0);
/* 401 */     int IsDel = Requests.GetInt(this.request, "isDel", 0);
String DatabaseUnitID=Requests.GetString(this.request, "databaseunitid","0");
/* 402 */     double Sorts = Requests.GetDouble(this.request, "sorts", 0.0D);
/*     */ 
/* 405 */     if (!ServerValidate())
/*     */     {
/* 408 */       DrpInit();
/* 409 */       this.request.setAttribute("Sectorid", Integer.valueOf(Sectorid));
/* 410 */       this.request.setAttribute("Sectorname", StringFormat.HtmlEncode(Sectorname));
/* 411 */       this.request.setAttribute("Description", StringFormat.HtmlEncode(Description));
/* 412 */       this.request.setAttribute("IsUse", Integer.valueOf(IsUse));
/* 413 */       this.request.setAttribute("IsDel", Integer.valueOf(IsDel));
/* 414 */       this.request.setAttribute("Sorts", Double.valueOf(Sorts));
this.request.setAttribute("Sectordatabaseid", SectordatabaseID);
this.request.setAttribute("Address", Address);
this.request.setAttribute("Phone", Phone);
/* 415 */       return;
/*     */     }
/*     */ 
/* 419 */     SystemSectorInfo objSystemSectorInfo = SystemSectorProvider.GetSystemSectorInfoBySectordatabaseid(SectordatabaseID);
/* 420 */     objSystemSectorInfo.setSectorid(Sectorid);
/* 421 */     objSystemSectorInfo.setSectorname(Sectorname);
/* 422 */     objSystemSectorInfo.setDescription(Description);
objSystemSectorInfo.setAddress(Address);
objSystemSectorInfo.setPhone(Phone);
/* 423 */     objSystemSectorInfo.setIsUse(IsUse);
/* 424 */     objSystemSectorInfo.setIsDel(IsDel);
objSystemSectorInfo.setDatabaseunitid(DatabaseUnitID);
/* 425 */     objSystemSectorInfo.setSorts(Sorts);
/*     */ 
/* 427 */     SystemSectorProvider.UpdateBySectordatabaseid(objSystemSectorInfo);
/*     */ 
/* 429 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?" + pageListUrl);
/* 430 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 432 */       js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 434 */     this.request.setAttribute("pageJavaScripStar", js);
/* 435 */     SystemSectorProvider.setSystemSectorStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 444 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
/*     */ 
/* 446 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 450 */     SystemSectorProvider.DeleteBySectordatabaseid(Sectorid);
/*     */ 
/* 452 */     SystemSectorProvider.setSystemSectorStatic(null);
/* 453 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "删除成功", "?" + pageListUrl);
/* 454 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.system.SystemSector
 * JD-Core Version:    0.6.0
 */