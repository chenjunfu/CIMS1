/*     */ package com.yun.ui.action.ajax;
/*     */ 
/*     */ import com.colorwinglib.Converts;
import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.SystemAdminProvider;
/*     */ import com.yun.bll.itemcollection.ItemInfo;
/*     */ import com.yun.bll.itemcollection.culture.SystemAdminItemCollection;
/*     */ import com.yun.common.Pager;
/*     */ import com.yun.entities.culture.SystemAdminInfo;
/*     */ import com.yun.entities.culture.collection.SystemAdminInfoCollection;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.Date;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class SystemAdmin
/*     */ {
/*     */   private static final long serialVersionUID = 2011112409042810927L;
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
/*  46 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "DatabaseAdminID");
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
/*  78 */     int Databaseadminid = Requests.GetInt(this.request, "databaseadminid", 0);
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
				else if(pagetype.equals("updateforadmin"))
				{
					updateforAdmin();
				}
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
/* 118 */     StringBuilder sbSex = new StringBuilder(100);
/* 119 */     for (ItemInfo itemInfo : SystemAdminItemCollection.SexCollection())
/*     */     {
/* 121 */       sbSex.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { itemInfo.getValue(), itemInfo.getText() }));
/*     */     }
/* 123 */     this.request.setAttribute("Sex", Integer.valueOf(0));
/* 124 */     this.request.setAttribute("SexEdit", sbSex.toString());
/* 125 */     this.request.setAttribute("SexList", sbSex.toString());
/*     */ 
/* 128 */     StringBuilder sbIsUse = new StringBuilder(100);
/* 129 */     for (ItemInfo itemInfo : SystemAdminItemCollection.IsUseCollection())
/*     */     {
/* 131 */       sbIsUse.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { itemInfo.getValue(), itemInfo.getText() }));
/*     */     }
/* 133 */     this.request.setAttribute("IsUse", Integer.valueOf(0));
/* 134 */     this.request.setAttribute("IsUseEdit", sbIsUse.toString());
/* 135 */     this.request.setAttribute("IsUseList", sbIsUse.toString());
/*     */ 
/* 138 */     StringBuilder sbIsDel = new StringBuilder(100);
/* 139 */     for (ItemInfo itemInfo : SystemAdminItemCollection.IsDelCollection())
/*     */     {
/* 141 */       sbIsDel.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { itemInfo.getValue(), itemInfo.getText() }));
/*     */     }
/* 143 */     this.request.setAttribute("IsDel", Integer.valueOf(0));
/* 144 */     this.request.setAttribute("IsDelEdit", sbIsDel.toString());
/* 145 */     this.request.setAttribute("IsDelList", sbIsDel.toString());
/*     */   }
/*     */ 
/*     */   protected void ListShow()
/*     */   {
/* 154 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 156 */     String OrderBy = "";
/* 157 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "DatabaseAdminID");
/* 158 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 159 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 161 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/* 163 */     this.out.write("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"tbList\">\n");
/* 164 */     this.out.write("<tr>\n");
/* 165 */     this.out.write("    <td>\n");
/* 166 */     this.out.write("    人员ID\n");
/* 167 */     this.out.write("    </td>\n");
/* 168 */     this.out.write("    <td>\n");
/* 169 */     this.out.write("    人员编号\n");
/* 170 */     this.out.write("    </td>\n");
/* 171 */     this.out.write("    <td>\n");
/* 172 */     this.out.write("    帐号\n");
/* 173 */     this.out.write("    </td>\n");
/* 174 */     this.out.write("    <td>\n");
/* 175 */     this.out.write("    密码\n");
/* 176 */     this.out.write("    </td>\n");
/* 177 */     this.out.write("    <td>\n");
/* 178 */     this.out.write("    性别\n");
/* 179 */     this.out.write("    </td>\n");
/* 180 */     this.out.write("    <td>\n");
/* 181 */     this.out.write("    姓名\n");
/* 182 */     this.out.write("    </td>\n");
/* 183 */     this.out.write("    <td>\n");
/* 184 */     this.out.write("    工号\n");
/* 185 */     this.out.write("    </td>\n");
/* 186 */     this.out.write("    <td>\n");
/* 187 */     this.out.write("    联系EMAIL\n");
/* 188 */     this.out.write("    </td>\n");
/* 189 */     this.out.write("    <td>\n");
/* 190 */     this.out.write("    移动电话\n");
/* 191 */     this.out.write("    </td>\n");
/* 192 */     this.out.write("    <td>\n");
/* 193 */     this.out.write("    电话\n");
/* 194 */     this.out.write("    </td>\n");
/* 195 */     this.out.write("    <td>\n");
/* 196 */     this.out.write("    MSN\n");
/* 197 */     this.out.write("    </td>\n");
/* 198 */     this.out.write("    <td>\n");
/* 199 */     this.out.write("    角色编号\n");
/* 200 */     this.out.write("    </td>\n");
/* 201 */     this.out.write("    <td>\n");
/* 202 */     this.out.write("    部门编号\n");
/* 203 */     this.out.write("    </td>\n");
/* 204 */     this.out.write("    <td>\n");
/* 205 */     this.out.write("    人员描述\n");
/* 206 */     this.out.write("    </td>\n");
/* 207 */     this.out.write("    <td>\n");
/* 208 */     this.out.write("    通讯地址\n");
/* 209 */     this.out.write("    </td>\n");
/* 210 */     this.out.write("    <td>\n");
/* 211 */     this.out.write("    限定IP\n");
/* 212 */     this.out.write("    </td>\n");
/* 213 */     this.out.write("    <td>\n");
/* 214 */     this.out.write("    最后登录时间\n");
/* 215 */     this.out.write("    </td>\n");
/* 216 */     this.out.write("    <td>\n");
/* 217 */     this.out.write("    最后登录IP\n");
/* 218 */     this.out.write("    </td>\n");
/* 219 */     this.out.write("    <td>\n");
/* 220 */     this.out.write("    创建时间\n");
/* 221 */     this.out.write("    </td>\n");
/* 222 */     this.out.write("    <td>\n");
/* 223 */     this.out.write("    最后修改时间\n");
/* 224 */     this.out.write("    </td>\n");
/* 225 */     this.out.write("    <td>\n");
/* 226 */     this.out.write("    启用标志\n");
/* 227 */     this.out.write("    </td>\n");
/* 228 */     this.out.write("    <td>\n");
/* 229 */     this.out.write("    是否删除\n");
/* 230 */     this.out.write("    </td>\n");
/* 231 */     this.out.write("    <td>\n");
/* 232 */     this.out.write("    操作\n");
/* 233 */     this.out.write("    </td>\n");
/* 234 */     this.out.write("</tr>\n");
/*     */ 
/* 236 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 237 */     int pageAll = 0;
/* 238 */     pageAll = SystemAdminProvider.GetListPagerBy();
/* 239 */     SystemAdminInfoCollection SystemAdminColl = SystemAdminProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 240 */     for (SystemAdminInfo objSystemAdminInfo : SystemAdminColl)
/*     */     {
/* 242 */       this.out.write("<tr>\n");
/*     */ 
/* 244 */       this.out.write("    <td>\n");
/* 245 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getDatabaseadminid()));
/* 246 */       this.out.write("    </td>\n");
/*     */ 
/* 249 */       this.out.write("    <td>\n");
/* 250 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getAdminid()));
/* 251 */       this.out.write("    </td>\n");
/*     */ 
/* 254 */       this.out.write("    <td>\n");
/* 255 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getAdminname()));
/* 256 */       this.out.write("    </td>\n");
/*     */ 
/* 259 */       this.out.write("    <td>\n");
/* 260 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getAdminpassword()));
/* 261 */       this.out.write("    </td>\n");
/*     */ 
/* 264 */       this.out.write("    <td>\n");
/* 265 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getSexlabel()));
/* 266 */       this.out.write("    </td>\n");
/*     */ 
/* 269 */       this.out.write("    <td>\n");
/* 270 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getTruename()));
/* 271 */       this.out.write("    </td>\n");
/*     */ 
/* 274 */       this.out.write("    <td>\n");
/* 275 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getWorkno()));
/* 276 */       this.out.write("    </td>\n");
/*     */ 
/* 279 */       this.out.write("    <td>\n");
/* 280 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getEmail()));
/* 281 */       this.out.write("    </td>\n");
/*     */ 
/* 284 */       this.out.write("    <td>\n");
/* 285 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getMovephone()));
/* 286 */       this.out.write("    </td>\n");
/*     */ 
/* 289 */       this.out.write("    <td>\n");
/* 290 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getPhone()));
/* 291 */       this.out.write("    </td>\n");
/*     */ 
/* 294 */       this.out.write("    <td>\n");
/* 295 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getMsn()));
/* 296 */       this.out.write("    </td>\n");
/*     */ 
/* 299 */       this.out.write("    <td>\n");
/* 300 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getRolesid()));
/* 301 */       this.out.write("    </td>\n");
/*     */ 
/* 304 */       this.out.write("    <td>\n");
/* 305 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getSectorid()));
/* 306 */       this.out.write("    </td>\n");
/*     */ 
/* 309 */       this.out.write("    <td>\n");
/* 310 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getDescription()));
/* 311 */       this.out.write("    </td>\n");
/*     */ 
/* 314 */       this.out.write("    <td>\n");
/* 315 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getAddress()));
/* 316 */       this.out.write("    </td>\n");
/*     */ 
/* 319 */       this.out.write("    <td>\n");
/* 320 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getLimitIp()));
/* 321 */       this.out.write("    </td>\n");
/*     */ 
/* 324 */       this.out.write("    <td>\n");
/* 325 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getLastLogintime()));
/* 326 */       this.out.write("    </td>\n");
/*     */ 
/* 329 */       this.out.write("    <td>\n");
/* 330 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getLastLoginip()));
/* 331 */       this.out.write("    </td>\n");
/*     */ 
/* 334 */       this.out.write("    <td>\n");
/* 335 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getCreateTime()));
/* 336 */       this.out.write("    </td>\n");
/*     */ 
/* 339 */       this.out.write("    <td>\n");
/* 340 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getLastModifytime()));
/* 341 */       this.out.write("    </td>\n");
/*     */ 
/* 344 */       this.out.write("    <td>\n");
/* 345 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getIsUselabel()));
/* 346 */       this.out.write("    </td>\n");
/*     */ 
/* 349 */       this.out.write("    <td>\n");
/* 350 */       this.out.write(Converts.objToStr(objSystemAdminInfo.getIsDellabel()));
/* 351 */       this.out.write("    </td>\n");
/*     */ 
/* 353 */       this.out.write("    <td>\n");
/* 354 */       this.out.write("            <a href=\"SystemAdminDetails.jsp?pagetype=Details&" + pageListUrl + "&databaseadminid=" + StringFormat.UrlEncode(Converts.objToStr(objSystemAdminInfo.getDatabaseadminid())) + "\">显示详细</a>\n");
/* 355 */       this.out.write("            <a href=\"SystemAdminEdit.jsp?pagetype=gotoupdate&" + pageListUrl + "&databaseadminid=" + StringFormat.UrlEncode(Converts.objToStr(objSystemAdminInfo.getDatabaseadminid())) + "\">编辑</a>\n");
/* 356 */       this.out.write("            <a href=\"SystemAdminList.jsp?pagetype=delete&" + pageListUrl + "&databaseadminid=" + StringFormat.UrlEncode(Converts.objToStr(objSystemAdminInfo.getDatabaseadminid())) + "\">删除</a>\n");
/* 357 */       this.out.write("    </td>\n");
/* 358 */       this.out.write("</tr>\n");
/*     */     }
/* 360 */     this.out.write("</table>\n");
/*     */ 
/* 362 */     String pageDetails = "";
/* 363 */     if (pageAll > this.pageSize)
/*     */     {
/* 365 */       this.out.write(Pager.LastNextPageByAjax(this.request, this.response, this.pageParameter, this.pageSize, pageAll));
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void ItemCommandEdit()
/*     */   {
/* 374 */     int Databaseadminid = Requests.GetInt(this.request, "databaseadminid", 0);
/*     */ 
/* 376 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 378 */     SystemAdminInfo objSystemAdminInfo = SystemAdminProvider.GetSystemAdminInfoByDatabaseadminid(Databaseadminid);
/* 379 */     if (objSystemAdminInfo != null)
/*     */     {
/* 381 */       this.out.write("strUrl=\"" + StringFormat.JsEncode(objSystemAdminInfo.ToUrlEncodeLinkString()) + "\";");
/*     */     }
/* 407 */     else if (Requests.GetInt(this.request, "isFlash") == 1)
/*     */     {
/* 409 */       this.out.write("messageID=1&message=%e5%86%85%e5%ae%b9%e4%b8%8d%e5%ad%98%e5%9c%a8");
/*     */     }
/*     */     else
/*     */     {
/* 413 */       this.out.write("messageID = 1;message ='内容不存在';");
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void ItemCommandDetails()
/*     */   {
/* 424 */     int Databaseadminid = Requests.GetInt(this.request, "databaseadminid", 0);
/*     */ 
/* 426 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 428 */     SystemAdminInfo objSystemAdminInfo = SystemAdminProvider.GetSystemAdminInfoByDatabaseadminid(Databaseadminid);
/* 429 */     if (objSystemAdminInfo != null)
/*     */     {
/* 431 */       this.out.write("strUrl=\"" + StringFormat.UrlDecode(objSystemAdminInfo.ToUrlEncodeLinkString()) + "\";");
/*     */     }
/* 457 */     else if (Requests.GetInt(this.request, "isFlash") == 1)
/*     */     {
/* 459 */       this.out.write("messageID=1&message=%e5%86%85%e5%ae%b9%e4%b8%8d%e5%ad%98%e5%9c%a8");
/*     */     }
/*     */     else
/*     */     {
/* 463 */       this.out.write("messageID = 1;message ='内容不存在';");
/*     */     }
/*     */   }
			
protected boolean ServerValidate2()
/*     */   {
/* 337 */     StringBuilder sbStr = new StringBuilder(1024);
/* 338 */     int i = 1;
/*     */ 
/* 341 
/*     */ 
/* 347 */    
/*     */ 
/* 354 */     if (Requests.GetString(this.request, "adminname").length() == 0)
/*     */     {
/* 356 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "帐号" }));
/* 357 */       i++;
/*     */     }
/* 359 */     if (Validate.getLength(Requests.GetString(this.request, "adminname")) > 50)
/*     */     {
/* 361 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "帐号" }));
/* 362 */       i++;
/*     */     }
/*     */ 
/* 366 */     if (Requests.GetString(this.request, "adminpassword").length() == 0)
/*     */     {
/* 368 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "密码" }));
/* 369 */       i++;
/*     */     }
/*     */ 
/* 373 */     if (Requests.GetString(this.request, "adminpassword").length() < 6)
/*     */     {
/* 375 */       sbStr.append(String.format("%1$s.%2$s不能少于6位!\n", new Object[] { Integer.valueOf(i), "密码" }));
/* 376 */       i++;
/*     */     }
/*     */ 
/* 379 */     if (Validate.getLength(Requests.GetString(this.request, "adminpassword")) > 50)
/*     */     {
/* 381 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "密码" }));
/* 382 */       i++;
/*     */     }
/*     */ 
/* 386 */     
/* 399 */     if (Requests.GetString(this.request, "truename").length() == 0)
/*     */     {
/* 401 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "姓名" }));
/* 402 */       i++;
/*     */     }
/* 404 */     if (Validate.getLength(Requests.GetString(this.request, "truename")) > 50)
/*     */     {
/* 406 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "姓名" }));
/* 407 */       i++;
/*     */     }
/*     */ 
/* 411 */     
/* 430 */    
/*     */ 
/* 450 */     if (i - 1 > 0)
/*     */     {
/* 452 */       sbStr.append("总共有" + (i - 1) + "个错误");
/* 453 */       String js = Javascript.Alert(this.request, this.response, sbStr.toString());
/* 454 */       this.request.setAttribute("pageJavaScripEnd", js);
/* 455 */       if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */       {
/* 457 */         this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "insert"));
/*     */       }
/* 459 */       return false;
/*     */     }
/*     */ 
/* 463 */     return true;
/*     */   }
/*     */   protected boolean ServerValidate()
/*     */   {
/* 473 */     StringBuilder sbStr = new StringBuilder(1024);
/* 474 */     int i = 1;
/*     */ 
/* 477 */     
/*     */ 
/* 483 */    
/* 490 */     
/* 495 */     if (Requests.GetString(this.request, "adminid").length() == 0)
/*     */     {
	/* 537 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "编号" }));
	/* 538 */       i++;
	/*     */     }
	/* 540 */     if (Validate.getLength(Requests.GetString(this.request, "adminid")) > 50)
	/*     */     {
	/* 542 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "编号" }));
	/* 543 */       i++;
	/*     */     }
/* 502 */     
/*     */ 
/* 509 */    
/*     */ 
/* 515 */    
/*     */ 
/* 523 */     if (Requests.GetString(this.request, "truename").length() == 0)
/*     */     {
/* 525 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "姓名" }));
/* 526 */       i++;
/*     */     }
/* 528 */     if (Validate.getLength(Requests.GetString(this.request, "truename")) > 50)
/*     */     {
/* 530 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "姓名" }));
/* 531 */       i++;
/*     */     }
/*     */ 
/* 535 */     if (Requests.GetString(this.request, "workno").length() == 0)
/*     */     {
/* 537 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "工号" }));
/* 538 */       i++;
/*     */     }
/* 540 */     if (Validate.getLength(Requests.GetString(this.request, "workno")) > 50)
/*     */     {
/* 542 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "工号" }));
/* 543 */       i++;
/*     */     }
/*     */ 
/* 548 */     
/*     */ 
/* 554 */    
/* 601 */     if (i - 1 > 0)
/*     */     {
/* 603 */       sbStr.append("总共有" + (i - 1) + "个错误");
/* 604 */       this.out.write(String.format("messageID = 2;message ='%1$s';", new Object[] { StringFormat.JsEncode(sbStr.toString()) }));
/* 605 */       return false;
/*     */     }
/*     */ 
/* 609 */     return true;
/*     */   }
/*     */ 
/*     */   protected void insert()
/*     */   {
/* 618 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 620 */     int Databaseadminid = Requests.GetInt(this.request, "databaseadminid", 0);
/* 621 */     int Adminid = Requests.GetInt(this.request, "adminid", 0);
/* 622 */     String Adminname = Requests.GetString(this.request, "adminname", "");
/* 623 */     String Adminpassword = Requests.GetString(this.request, "adminpassword", "");
/* 624 */     int Sex = Requests.GetInt(this.request, "sex", 0);
/* 625 */     String Truename = Requests.GetString(this.request, "truename", "");
/* 626 */     String Workno = Requests.GetString(this.request, "workno", "");
/* 627 */     String Email = Requests.GetString(this.request, "email", "");
/* 628 */     String Movephone = Requests.GetString(this.request, "movephone", "");
/* 629 */     String Phone = Requests.GetString(this.request, "phone", "");
/* 630 */     String Msn = Requests.GetString(this.request, "msn", "");
/* 631 */     int Rolesid = Requests.GetInt(this.request, "rolesid", 0);
/* 632 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
/* 633 */     String Description = Requests.GetString(this.request, "description", "");
/* 634 */     String Address = Requests.GetString(this.request, "address", "");
/* 635 */     String LimitIp = Requests.GetString(this.request, "limitIp", "");
/* 636 */     Date LastLogintime = Requests.GetDate(this.request, "lastLogintime", new Date());
/* 637 */     String LastLoginip = Requests.GetString(this.request, "lastLoginip", "");
/* 638 */     Date CreateTime = Requests.GetDate(this.request, "createTime", new Date());
/* 639 */     Date LastModifytime = Requests.GetDate(this.request, "lastModifytime", new Date());
/* 640 */     int IsUse = Requests.GetInt(this.request, "isUse2", 2);
/* 641 */     int IsDel = Requests.GetInt(this.request, "isDel2",2);
/* 644 */     if (!ServerValidate())
/*     */     {
/* 647 */       DrpInit();
/* 648 */       return;
/*     */     }
/*     */ 
/* 651 */     SystemAdminInfo objSystemAdminInfo = new SystemAdminInfo();
/* 652 */     objSystemAdminInfo.setDatabaseadminid(Databaseadminid);
/* 653 */     objSystemAdminInfo.setAdminid(Adminid);
/* 654 */     objSystemAdminInfo.setAdminname(Adminname);
/* 655 */     objSystemAdminInfo.setAdminpassword(Adminpassword);
/* 656 */     objSystemAdminInfo.setSex(Sex);
/* 657 */     objSystemAdminInfo.setTruename(Truename);
/* 658 */     objSystemAdminInfo.setWorkno(Workno);
/* 659 */     objSystemAdminInfo.setEmail(Email);
/* 660 */     objSystemAdminInfo.setMovephone(Movephone);
/* 661 */     objSystemAdminInfo.setPhone(Phone);
/* 662 */     objSystemAdminInfo.setMsn(Msn);
/* 663 */     objSystemAdminInfo.setRolesid(Rolesid);
/* 664 */     objSystemAdminInfo.setSectorid(Sectorid);
/* 665 */     objSystemAdminInfo.setDescription(Description);
/* 666 */     objSystemAdminInfo.setAddress(Address);
/* 667 */     objSystemAdminInfo.setLimitIp(LimitIp);
/* 668 */     objSystemAdminInfo.setLastLogintime(LastLogintime);
/* 669 */     objSystemAdminInfo.setLastLoginip(LastLoginip);
/* 670 */     objSystemAdminInfo.setCreateTime(CreateTime);
/* 671 */     objSystemAdminInfo.setLastModifytime(LastModifytime);
/* 672 */     objSystemAdminInfo.setIsUse(IsUse);
/* 673 */     objSystemAdminInfo.setIsDel(IsDel);
/*     */ 
/* 675 */     SystemAdminProvider.Insert(objSystemAdminInfo);
/*     */ 
/* 677 */     if (Requests.GetInt(this.request, "isFlash") == 1)
/*     */     {
/* 679 */       this.out.write("messageID=1&message=%e6%b7%bb%e5%8a%a0%e6%88%90%e5%8a%9f");
/*     */     }
/*     */     else
/*     */     {
/* 684 */       this.out.write("messageID = 1;message ='添加成功';");
/*     */     }
/*     */ 
/* 687 */     SystemAdminProvider.setSystemAdminStatic(null);
/*     */   }
/*     */ 	
protected void updateforAdmin()
{
		String pageListUrl = getpageListUrl();
	     int Databaseadminid = Requests.GetInt(this.request, "databaseadminid", 0);
	     String adminnames=Requests.GetString(this.request, "adminname","");
	     String adminpasswords=Requests.GetString(this.request, "adminpassword","");
	     String truenames=Requests.GetString(this.request, "truename","");
	     String limitIps=Requests.GetString(this.request, "limitIp");

	     int isuse=Requests.GetInt(this.request, "isUse2");
	     if (!ServerValidate2())
	          {	
	     				
	            DrpInit();
	           return;
	         }
	     SystemAdminInfo objSystemAdminInfo = SystemAdminProvider.GetSystemAdminInfoByDatabaseadminid(Databaseadminid);
	     objSystemAdminInfo.setAdminname(adminnames);
	     objSystemAdminInfo.setAdminpassword(adminpasswords);
	     objSystemAdminInfo.setTruename(truenames);
	     objSystemAdminInfo.setLimitIp(limitIps);


	     objSystemAdminInfo.setIsDel(isuse);
	     SystemAdminProvider.UpdateByDatabaseadminid(objSystemAdminInfo);
	     /*     */ 
	     /* 757 */     if (Requests.GetInt(this.request, "isFlash") == 1)
	     /*     */     {
	     /* 759 */       this.out.write("messageID=1&message=%e6%9b%b4%e6%96%b0%e6%88%90%e5%8a%9f");
	     /*     */     }
	     /*     */     else
	     /*     */     {
	     /* 764 */       this.out.write("messageID = 1;message ='更新成功';");
	     /*     */     }
	     /*     */ 
	     /* 767 */     SystemAdminProvider.setSystemAdminStatic(null);
	     
	     
}
/*     */   protected void update()
/*     */   {
/* 695 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 697 */     int Databaseadminid = Requests.GetInt(this.request, "databaseadminid", 0);
/* 701 */     int Sex = Requests.GetInt(this.request, "sex", 0);
/* 702 */     String Truename = Requests.GetString(this.request, "truename", "");
/* 703 */     String Workno = Requests.GetString(this.request, "workno", "");
/* 704 */     String Email = Requests.GetString(this.request, "email", "");
/* 705 */     String Movephone = Requests.GetString(this.request, "movephone", "");
/* 706 */     String Phone = Requests.GetString(this.request, "phone", "");
/* 707 */     int adminid=Requests.GetInt(this.request, "adminid",0);
/* 708 */     String address=Requests.GetString(this.request, "address","");
/* 709 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
			  
/* 710 */     
/* 711 */     
/* 712 */    
/*     */ 
/* 720 */    
/*     */ 
/* 723 */     if (!ServerValidate())
/*     */     {	
				
/* 726 */       DrpInit();
/* 727 */       return;
/*     */     }
/*     */ 		
/* 731 */     SystemAdminInfo objSystemAdminInfo = SystemAdminProvider.GetSystemAdminInfoByDatabaseadminid(Databaseadminid);
/* 732 */     objSystemAdminInfo.setDatabaseadminid(Databaseadminid);
/* 733 */     objSystemAdminInfo.setAdminid(adminid);
/* 736 */     objSystemAdminInfo.setSex(Sex);
/* 737 */     objSystemAdminInfo.setTruename(Truename);
/* 738 */     objSystemAdminInfo.setWorkno(Workno);
/* 739 */     objSystemAdminInfo.setEmail(Email);
/* 740 */     objSystemAdminInfo.setMovephone(Movephone);
/* 741 */     objSystemAdminInfo.setPhone(Phone);
/* 743 */     objSystemAdminInfo.setAddress(address);
/* 744 */     objSystemAdminInfo.setSectorid(Sectorid);
/* 745 */     
/* 746 */     
/* 747 */     
/* 748 */     
/* 749 */    
/* 750 */    
/* 751 */     
/* 752 */    
/* 753 */     
/*     */ 
/* 755 */     SystemAdminProvider.UpdateByDatabaseadminid(objSystemAdminInfo);
/*     */ 
/* 757 */     if (Requests.GetInt(this.request, "isFlash") == 1)
/*     */     {
/* 759 */       this.out.write("messageID=1&message=%e6%9b%b4%e6%96%b0%e6%88%90%e5%8a%9f");
/*     */     }
/*     */     else
/*     */     {
/* 764 */       this.out.write("messageID = 1;message ='更新成功';");
/*     */     }
/*     */ 
/* 767 */     SystemAdminProvider.setSystemAdminStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 776 */     int Databaseadminid = Requests.GetInt(this.request, "databaseadminid", 0);
/*     */ 
/* 778 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 782 */     SystemAdminProvider.DeleteByDatabaseadminid(Databaseadminid);
/*     */ 
/* 784 */     SystemAdminProvider.setSystemAdminStatic(null);
/* 785 */     if (Requests.GetInt(this.request, "isFlash") == 1)
/*     */     {
/* 787 */       this.out.write("messageID=1&message=%e5%88%a0%e9%99%a4%e6%88%90%e5%8a%9f");
/*     */     }
/*     */     else
/*     */     {
/* 792 */       this.out.write("messageID = 1;message ='删除成功';");
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.ajax.SystemAdmin
 * JD-Core Version:    0.6.0
 */