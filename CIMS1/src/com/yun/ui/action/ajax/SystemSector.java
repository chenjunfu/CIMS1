/*     */ package com.yun.ui.action.ajax;
/*     */ 
/*     */ import com.colorwinglib.Converts;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.SystemAdminProvider;
/*     */ import com.yun.bll.culture.SystemSectorProvider;
/*     */ import com.yun.bll.itemcollection.ItemInfo;
/*     */ import com.yun.bll.itemcollection.culture.SystemSectorItemCollection;
/*     */ import com.yun.common.Pager;
/*     */ import com.yun.entities.culture.SystemSectorInfo;
/*     */ import com.yun.entities.culture.collection.SystemAdminInfoCollection;
/*     */ import com.yun.entities.culture.collection.SystemSectorInfoCollection;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class SystemSector
/*     */ {
/*     */   private static final long serialVersionUID = 2011112318344598463L;
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
/*  46 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "SectorID");
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
/*  78 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
/*     */ 
/*  82 */     String pagetype = Requests.GetString(this.request, "pagetype").toLowerCase();
/*  83 */     if (pagetype.equals("insert"))
/*     */     {
/*  85 */       insert();
/*     */     }
/*  87 */     else if (pagetype.equals("gotoupdate"))
/*     */     {
/*  89 */       ItemCommandEdit();
/*     */     }
/*  91 */     else if (pagetype.equals("update"))
/*     */     {
/*  93 */       update();
/*     */     }
/*  95 */     else if (pagetype.equals("delete"))
/*     */     {
/*  97 */       delete();
/*     */     }
/*  99 */     else if (pagetype.equals("details"))
/*     */     {
/* 101 */       ItemCommandDetails();
/*     */     }
/*     */     else
/*     */     {
/* 106 */       ListShow();
/*     */     }
/* 108 */     return null;
/*     */   }
/*     */ 
/*     */   protected void DrpInit()
/*     */   {
/* 118 */     StringBuilder sbIsUse = new StringBuilder(100);
/* 119 */     for (ItemInfo itemInfo : SystemSectorItemCollection.IsUseCollection())
/*     */     {
/* 121 */       sbIsUse.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { itemInfo.getValue(), itemInfo.getText() }));
/*     */     }
/* 123 */     this.request.setAttribute("IsUse", Integer.valueOf(0));
/* 124 */     this.request.setAttribute("IsUseEdit", sbIsUse.toString());
/* 125 */     this.request.setAttribute("IsUseList", sbIsUse.toString());
/*     */ 
/* 128 */     StringBuilder sbIsDel = new StringBuilder(100);
/* 129 */     for (ItemInfo itemInfo : SystemSectorItemCollection.IsDelCollection())
/*     */     {
/* 131 */       sbIsDel.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { itemInfo.getValue(), itemInfo.getText() }));
/*     */     }
/* 133 */     this.request.setAttribute("IsDel", Integer.valueOf(0));
/* 134 */     this.request.setAttribute("IsDelEdit", sbIsDel.toString());
/* 135 */     this.request.setAttribute("IsDelList", sbIsDel.toString());
/*     */   }
/*     */ 
/*     */   protected void ListShow()
/*     */   {
/* 144 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 146 */     String OrderBy = "";
/* 147 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "SectorID");
/* 148 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 149 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 151 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/* 153 */     this.out.write("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"tbList\">\n");
/* 154 */     this.out.write("<tr>\n");
/* 155 */     this.out.write("    <td>\n");
/* 156 */     this.out.write("    部门编号\n");
/* 157 */     this.out.write("    </td>\n");
/* 158 */     this.out.write("    <td>\n");
/* 159 */     this.out.write("    部门名称\n");
/* 160 */     this.out.write("    </td>\n");
/* 161 */     this.out.write("    <td>\n");
/* 162 */     this.out.write("    部门描述\n");
/* 163 */     this.out.write("    </td>\n");
/* 161 */     this.out.write("    <td>\n");
/* 162 */     this.out.write("    部门地址\n");
/* 163 */     this.out.write("    </td>\n");
/* 161 */     this.out.write("    <td>\n");
/* 162 */     this.out.write("    部门电话\n");
/* 163 */     this.out.write("    </td>\n");
/* 164 */     this.out.write("    <td>\n");
/* 165 */     this.out.write("    启用标志\n");
/* 166 */     this.out.write("    </td>\n");
/* 167 */     this.out.write("    <td>\n");
/* 168 */     this.out.write("    是否删除\n");
/* 169 */     this.out.write("    </td>\n");
/* 170 */     this.out.write("    <td>\n");
/* 171 */     this.out.write("    排序\n");
/* 172 */     this.out.write("    </td>\n");
/* 173 */     this.out.write("    <td>\n");
/* 174 */     this.out.write("    操作\n");
/* 175 */     this.out.write("    </td>\n");
/* 176 */     this.out.write("</tr>\n");
/*     */ 
/* 178 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 179 */     int pageAll = 0;
/* 180 */     pageAll = SystemSectorProvider.GetListPagerBy();
/* 181 */     SystemSectorInfoCollection SystemSectorColl = SystemSectorProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 182 */     for (SystemSectorInfo objSystemSectorInfo : SystemSectorColl)
/*     */     {
/* 184 */       this.out.write("<tr>\n");
/*     */ 
/* 186 */       this.out.write("    <td>\n");
/* 187 */       this.out.write(Converts.objToStr(objSystemSectorInfo.getSectorid()));
/* 188 */       this.out.write("    </td>\n");
/*     */ 
/* 191 */       this.out.write("    <td>\n");
/* 192 */       this.out.write(Converts.objToStr(objSystemSectorInfo.getSectorname()));
/* 193 */       this.out.write("    </td>\n");
/*     */ 
/* 196 */       this.out.write("    <td>\n");
/* 197 */       this.out.write(Converts.objToStr(objSystemSectorInfo.getDescription()));
/* 198 */       this.out.write("    </td>\n");
/*     */ 
/* 201 */       this.out.write("    <td>\n");
/* 202 */       this.out.write(Converts.objToStr(objSystemSectorInfo.getIsUselabel()));
/* 203 */       this.out.write("    </td>\n");
/* 201 */       this.out.write("    <td>\n");
/* 202 */       this.out.write(Converts.objToStr(objSystemSectorInfo.getIsUselabel()));
/* 203 */       this.out.write("    </td>\n");
/* 201 */       this.out.write("    <td>\n");
/* 202 */       this.out.write(Converts.objToStr(objSystemSectorInfo.getIsUselabel()));
/* 203 */       this.out.write("    </td>\n");
/*     */ 
/* 206 */       this.out.write("    <td>\n");
/* 207 */       this.out.write(Converts.objToStr(objSystemSectorInfo.getIsDellabel()));
/* 208 */       this.out.write("    </td>\n");
/*     */ 
/* 211 */       this.out.write("    <td>\n");
/* 212 */       this.out.write(Converts.objToStr(objSystemSectorInfo.getSorts()));
/* 213 */       this.out.write("    </td>\n");
/*     */ 
/* 215 */       this.out.write("    <td>\n");
/* 216 */       this.out.write("            <a href=\"SystemSectorDetails.jsp?pagetype=Details&" + pageListUrl + "&sectorid=" + StringFormat.UrlEncode(Converts.objToStr(objSystemSectorInfo.getSectorid())) + "\">显示详细</a>\n");
/* 217 */       this.out.write("            <a href=\"SystemSectorEdit.jsp?pagetype=gotoupdate&" + pageListUrl + "&sectorid=" + StringFormat.UrlEncode(Converts.objToStr(objSystemSectorInfo.getSectorid())) + "\">编辑</a>\n");
/* 218 */       this.out.write("            <a href=\"SystemSectorList.jsp?pagetype=delete&" + pageListUrl + "&sectorid=" + StringFormat.UrlEncode(Converts.objToStr(objSystemSectorInfo.getSectorid())) + "\">删除</a>\n");
/* 219 */       this.out.write("    </td>\n");
/* 220 */       this.out.write("</tr>\n");
/*     */     }
/* 222 */     this.out.write("</table>\n");
/*     */ 
/* 224 */     String pageDetails = "";
/* 225 */     if (pageAll > this.pageSize)
/*     */     {
/* 227 */       this.out.write(Pager.LastNextPageByAjax(this.request, this.response, this.pageParameter, this.pageSize, pageAll));
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void ItemCommandEdit()
/*     */   {
/* 236 */     int Sectordatabaseid = Requests.GetInt(this.request, "sectordatabaseid", 0);
/*     */ 
/* 238 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 240 */     SystemSectorInfo objSystemSectorInfo = SystemSectorProvider.GetSystemSectorInfoBySectordatabaseid(Sectordatabaseid);
/* 241 */     if (objSystemSectorInfo != null)
/*     */     {
/* 243 */       this.out.write("strUrl=\"" + StringFormat.JsEncode(objSystemSectorInfo.ToUrlEncodeLinkString()) + "\";");
/*     */     }
/* 253 */     else if (Requests.GetInt(this.request, "isFlash") == 1)
/*     */     {
/* 255 */       this.out.write("messageID=1&message=%e5%86%85%e5%ae%b9%e4%b8%8d%e5%ad%98%e5%9c%a8");
/*     */     }
/*     */     else
/*     */     {
/* 259 */       this.out.write("messageID = 1;message ='内容不存在';");
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void ItemCommandDetails()
/*     */   {
/* 269 */     DrpInit();
/*     */ 		
/* 272 */     int Sectordatabaseid = Requests.GetInt(this.request, "sectordatabaseid", 0);
/*     */    
/* 274 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 276 */     SystemSectorInfo objSystemSectorInfo = SystemSectorProvider.GetSystemSectorInfoBySectordatabaseid(Sectordatabaseid);
			
/* 277 */     if (objSystemSectorInfo != null)
/*     */     {
				
/* 279 */       this.out.write("strUrl=\"" + StringFormat.UrlDecode(objSystemSectorInfo.ToUrlEncodeLinkString()) + "\";");
			
				
/*     */     }
/* 289 */     else if (Requests.GetInt(this.request, "isFlash") == 1)
/*     */     {
/* 291 */       this.out.write("messageID=1&message=%e5%86%85%e5%ae%b9%e4%b8%8d%e5%ad%98%e5%9c%a8");
/*     */     }
/*     */     else
/*     */     {
/* 295 */       this.out.write("messageID = 1;message ='内容不存在';");
/*     */     }
			
/*     */   }
/*     */ 
/*     */   protected boolean ServerValidate()
/*     */   {
/* 305 */     StringBuilder sbStr = new StringBuilder(1024);
/* 306 */     int i = 1;

/*     */     if (!Validate.IsNumber(Requests.GetString(this.request, "sectorid")))
/*     */     {
	/* 311 */       sbStr.append(String.format("%1$s.%2$s只能为数字\n", new Object[] { Integer.valueOf(i), "部门编号" }));
	/* 312 */       i++;
	/*     */     }
	/* 314 */     if (Validate.getLength(Requests.GetString(this.request, "sectorid")) > 50)
	/*     */     {
	/* 316 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "部门编号" }));
	/* 317 */       i++;
	/*     */     }
/* 309 */     if (Requests.GetString(this.request, "sectorname").length() == 0)
/*     */     {
/* 311 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "部门名称" }));
/* 312 */       i++;
/*     */     }
/* 314 */     if (Validate.getLength(Requests.GetString(this.request, "sectorname")) > 50)
/*     */     {
/* 316 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "部门名称" }));
/* 317 */       i++;
/*     */     }
/*     */ 
/* 323 */     if (i - 1 > 0)
/*     */     {
/* 325 */       sbStr.append("总共有" + (i - 1) + "个错误");
/* 326 */       this.out.write(String.format("messageID = 2;message ='%1$s';", new Object[] { StringFormat.JsEncode(sbStr.toString()) }));
/* 327 */       return false;
/*     */     }
/*     */ 
/* 331 */     return true;
/*     */   }
/*     */ 
/*     */   protected void insert()
/*     */   {
	
				
/* 340 */     String pageListUrl = getpageListUrl();
/*     */     int Sectordatabaseid=Requests.GetInt(this.request, "sectordatabaseid");
/* 342 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
/* 343 */     String Sectorname = Requests.GetString(this.request, "sectorname", "");
/* 344 */     String Description = Requests.GetString(this.request, "description", "");
			  String Address=Requests.GetString(this.request, "address");
			  String Phone=Requests.GetString(this.request, "phone");
/* 345 */     int IsUse = Requests.GetInt(this.request, "isUse", 0);
/* 346 */     int IsDel = Requests.GetInt(this.request, "isDel", 0);
/* 347 */     double Sorts = Requests.GetDouble(this.request, "sorts", 0.0D);
/*     */ 
/* 350 */     if (!ServerValidate())
/*     */     {
/* 353 */       DrpInit();
/* 354 */       return;
/*     */     }
/*     */ 
/* 357 */     SystemSectorInfo objSystemSectorInfo = new SystemSectorInfo();
/* 358 */     objSystemSectorInfo.setSectorid(Sectorid);
/* 359 */     objSystemSectorInfo.setSectorname(Sectorname);
/* 360 */     objSystemSectorInfo.setDescription(Description);
			  objSystemSectorInfo.setAddress(Address);
			  objSystemSectorInfo.setPhone(Phone);
/* 361 */     objSystemSectorInfo.setIsUse(IsUse);
/* 362 */     objSystemSectorInfo.setIsDel(IsDel);
/* 363 */     objSystemSectorInfo.setSorts(Sorts);
/*     */    
/* 365 */     SystemSectorProvider.Insert(objSystemSectorInfo);
/*     */     
/* 367 */     if (Requests.GetInt(this.request, "isFlash") == 1)
/*     */     {
/* 369 */       this.out.write("messageID=1&message=%e6%b7%bb%e5%8a%a0%e6%88%90%e5%8a%9f");
/*     */     }
/*     */     else
/*     */     {
/* 374 */       this.out.write("messageID = 1;message ='添加成功';");
/*     */     }
/*     */ 
/* 377 */     SystemSectorProvider.setSystemSectorStatic(null);
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 385 */     String pageListUrl = getpageListUrl();
/*     */ 	  int Sectordatabaseid=Requests.GetInt(this.request, "sectordatabaseid");
/* 387 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
/* 388 */     String Sectorname = Requests.GetString(this.request, "sectorname", "");
/* 389 */     String Description = Requests.GetString(this.request, "description", "");
			  String Address=Requests.GetString(this.request, "address");
			  String Phone=Requests.GetString(this.request, "phone");
/* 390 */     int IsUse = Requests.GetInt(this.request, "isUse", 0);
/* 391 */     int IsDel = Requests.GetInt(this.request, "isDel", 0);
/*     */ 
/* 395 */     if (!ServerValidate())
/*     */     {	
				
/* 398 */       DrpInit();
/* 399 */       return;
/*     */     }
/*     */ 		 
/* 403 */     SystemSectorInfo objSystemSectorInfo = SystemSectorProvider.GetSystemSectorInfoBySectordatabaseid(Sectordatabaseid);
			
/* 404 */     objSystemSectorInfo.setSectorid(Sectorid);
/* 405 */     objSystemSectorInfo.setSectorname(Sectorname);
/* 406 */     objSystemSectorInfo.setDescription(Description);
			  objSystemSectorInfo.setAddress(Address);
			  objSystemSectorInfo.setPhone(Phone);
/* 407 */     objSystemSectorInfo.setIsUse(IsUse);
/* 408 */     objSystemSectorInfo.setIsDel(IsDel);
/*     */ 
/* 411 */     SystemSectorProvider.UpdateBySectordatabaseid(objSystemSectorInfo);

/* 413 */     if (Requests.GetInt(this.request, "isFlash") == 1)
/*     */     {
/* 415 */       this.out.write("messageID=1&message=%e6%9b%b4%e6%96%b0%e6%88%90%e5%8a%9f");
/*     */     }
/*     */     else
/*     */     {
/* 420 */       this.out.write("messageID = 1;message ='更新成功';");
/*     */     }
/*     */ 
/* 423 */     SystemSectorProvider.setSystemSectorStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 432 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
/*     */     
/* 434 */     String pageListUrl = getpageListUrl();
/*     */ 		
/* 436 */     SystemAdminInfoCollection SystemAdminInfoCollection = SystemAdminProvider.GetListPagerBySectorid(Sectorid, 1, 100);

/* 438 */     if (SystemAdminInfoCollection.size() == 0) {
/* 439 */       SystemSectorProvider.DeleteBySectordatabaseid(Sectorid);
/*     */ 
/* 441 */       SystemSectorProvider.setSystemSectorStatic(null);
/* 442 */       if (Requests.GetInt(this.request, "isFlash") == 1)
/*     */       {
/* 444 */         this.out.write("messageID=1&message=%e5%88%a0%e9%99%a4%e6%88%90%e5%8a%9f");
/*     */       }
/*     */       else
/*     */       {
/* 449 */         this.out.write("messageID = 1;message ='删除成功';");
/*     */       }
/*     */ 
/* 453 */       
				
/*     */     } else {
/* 455 */       this.out.write("messageID = 2;message ='部门下还有人员，删除失败';");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.ajax.SystemSector
 * JD-Core Version:    0.6.0
 */