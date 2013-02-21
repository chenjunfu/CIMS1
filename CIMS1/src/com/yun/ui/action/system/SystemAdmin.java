/*     */ package com.yun.ui.action.system;
/*     */ 
/*     */ import com.colorwinglib.Converts;
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.RolesCompetenceProvider;
/*     */ import com.yun.bll.culture.SystemAdminProvider;
import com.yun.bll.culture.SystemCompetenceProvider;
/*     */ import com.yun.bll.culture.SystemRolesProvider;
/*     */ import com.yun.bll.culture.SystemSectorProvider;
/*     */ import com.yun.bll.itemcollection.ItemInfo;
/*     */ import com.yun.bll.itemcollection.culture.SystemAdminItemCollection;
/*     */ import com.yun.common.Pager;
/*     */ import com.yun.entities.culture.SystemAdminInfo;
/*     */ import com.yun.entities.culture.SystemRolesInfo;
/*     */ import com.yun.entities.culture.SystemSectorInfo;
/*     */ import com.yun.entities.culture.collection.SystemAdminInfoCollection;
import com.yun.entities.culture.collection.SystemCompetenceInfoCollection;
/*     */ import com.yun.entities.culture.collection.SystemRolesInfoCollection;
/*     */ import com.yun.entities.culture.collection.SystemSectorInfoCollection;
/*     */ import com.yun.ui.action.UserLook;
/*     */ import java.io.PrintWriter;
/*     */ import java.text.SimpleDateFormat;
import java.util.ArrayList;
/*     */ import java.util.Date;
import java.util.List;

/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class SystemAdmin
/*     */ {
/*     */   private static final long serialVersionUID = 2011112111281127544L;
/*  20 */   public int pageSize = 10;
/*     */ 
/*  25 */   public String pageParameter = "page";
/*     */ 
/*  30 */   HttpServletRequest request = null;
/*     */ 
/*  34 */   HttpServletResponse response = null;
/*     */ 
/*  38 */   PrintWriter out = null;
/*     */ 
/*     */   private String getpageListUrl()
/*     */   {
/*  44 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/*  45 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "DatabaseAdminID");
/*  46 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/*  47 */     String pageListOrderByItemDESCNo = pageListOrderByItemDESC.toLowerCase().equals("desc") ? "asc" : "desc";
/*  48 */     String pageListUrlOrderBy = String.format("%s=%s", new Object[] { this.pageParameter, Integer.valueOf(pageIndex) });
/*  49 */     String pageListUrl = String.format("%s&OrderByItem=%s&OrderByItemDESC=%s", new Object[] { pageListUrlOrderBy, pageListOrderByItem, pageListOrderByItemDESC });

/*     */ 
/*  51 */     this.request.setAttribute("pageListOrderByItem", pageListOrderByItem);
/*  52 */     this.request.setAttribute("pageListOrderByItemDESC", pageListOrderByItemDESC);
/*  53 */     this.request.setAttribute("pageListOrderByItemDESCNo", pageListOrderByItemDESCNo);
/*  54 */     this.request.setAttribute("pageListUrlOrderBy", pageListUrlOrderBy);
/*  55 */     this.request.setAttribute("pageListUrl", pageListUrl);
			
			
/*     */ 
/*  57 */     return pageListUrl;
/*     */   }
/*     */ 
/*     */   public String execute()
/*     */     throws Exception
/*     */   {
/*  68 */     this.request = ServletActionContext.getRequest();
/*  69 */     this.response = ServletActionContext.getResponse();
/*     */ 	  UserLook userlook=new UserLook(request, response);
/*  71 */     String af = null;
/*  72 */     this.response.setCharacterEncoding("utf-8");
/*  73 */     this.out = this.response.getWriter();
/*  74 */     String pageListUrl = getpageListUrl();
/*     */ 
/*  77 */     int Databaseadminid = Requests.GetInt(this.request, "databaseadminid", 0);
/*  87 */     String pageName = "SystemAdmin";
/*  88 */     String pagetype = Requests.GetString(this.request, "pagetype").toLowerCase();
/*  89 */     if (pagetype.equals("gotoinsert"))
/*     */     {
/*  91 */       this.request.setAttribute("btnEditText", "添加数据");
/*  92 */       this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "insert"));
/*  93 */       DrpInit();
/*  94 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/*  96 */     else if (pagetype.equals("insert"))
/*     */     {
/*  98 */       this.request.setAttribute("btnEditText", "添加数据");
/*  99 */       insert();
/* 100 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 102 */     else if (pagetype.equals("gotoupdate"))
/*     */     {
	
/* 104 */       DrpInit();
/* 105 */       ItemCommandEdit();
/* 106 */       this.request.setAttribute("btnEditText", "更新数据");
/* 107 */       this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "update"));
/* 108 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 110 */     else if (pagetype.equals("update"))
/*     */     { 
				
/* 112 */       this.request.setAttribute("btnEditText", "更新数据");
/* 113 */       update();
/* 114 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
else if(pagetype.equals("updataforself"))
{
	  this.request.setAttribute("btnEditText", "更新数据");
      updateforself();
      af = String.format("%sDetails", new Object[] { pageName });

}
/* 116 */     else if (pagetype.equals("delete"))
/*     */     {
/* 118 */       delete();
/* 119 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 121 */     else if (pagetype.equals("details"))
/*     */     {	
				userlook.seePageY("18");
/* 123 */       ItemCommandDetails();
/* 124 */       af = String.format("%sDetails", new Object[] { pageName });
/*     */     }
/* 126 */     else if (pagetype.equals("modifypw"))
/*     */     {
/* 128 */       modifyPW();
/* 129 */       af = "modifypw";
/*     */     }
else if(pagetype.equals("setcompetence"))
{
	ItemCommandEdit();
	this.request.setAttribute("btnEditText", "更新数据");
	this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "updatecompetence"));
	af = String.format("%ssetcompetence", new Object[] { pageName });
}
else if(pagetype.equals("updatecompetence"))
{	
	
	updateCompetence();	
	ItemCommandEdit();
	this.request.setAttribute("btnEditText", "更新数据");
	this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "updatecompetence"));
	af = String.format("%ssetcompetence", new Object[] { pageName });
}
else if(pagetype.equals("tree"))
{			
					  userlook.seePageY("20");
					  String target=Requests.GetString(request, "target","");
					  DrpInit();
					  int defaultItem=SystemAdminProvider.getSystemAdminStatic().get(0).getDatabaseadminid();
					  
					  defaultItem=Requests.GetInt(this.request, "default",defaultItem);
					  request.setAttribute("defaultItem", "<script>ItemCommandEditAdmin("+defaultItem+")</script>");
					  String SystemConfigTree = SystemAdminProvider.getSystemTree(target);
					  SystemAdminInfo defaultAdmin= SystemAdminProvider.GetSystemAdminInfoByDatabaseadminid(defaultItem);
					  if(defaultAdmin!=null)
					  {
						  defaultItem=defaultAdmin.getSectorid();
					  }		  
					  this.request.setAttribute("SystemConfigTree", SystemConfigTree+";createTree(Tree,null,"+defaultItem+");");
					  if(target.equals("personnel"))
					  af = "SystemPersonnel";
					  else
					  af="SystemAdminTree";
			  }

			else
/*     */     { 
				userlook.seePageY("23");
/* 134 */       DrpInit();
/* 135 */       ListShow();
/* 136 */       af = String.format("%sList", new Object[] { pageName });
/*     */     }

/* 138 */     return af;
		
/*     */   }
/*     */ 
/*     */   protected void DrpInit()
/*     */   {
/* 148 */     StringBuilder sbSex = new StringBuilder(100);
/* 149 */     for (ItemInfo itemInfo : SystemAdminItemCollection.SexCollection())
/*     */     {
/* 151 */       sbSex.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { itemInfo.getValue(), itemInfo.getText() }));
/*     */     }
/* 153 */     this.request.setAttribute("Sex", Integer.valueOf(1));
/* 154 */     this.request.setAttribute("SexEdit", sbSex.toString());
/* 155 */     this.request.setAttribute("SexList", sbSex.toString());
/*     */ 
/* 160 */     SystemRolesInfoCollection SystemRolesColl = SystemRolesProvider.getSystemRolesStatic();
/* 161 */     StringBuilder sbRolesid = new StringBuilder(100);
/* 162 */     for (SystemRolesInfo objSystemRolesInfo : SystemRolesColl)
/*     */     {
/* 164 */       sbRolesid.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { Integer.valueOf(objSystemRolesInfo.getRolesid()), objSystemRolesInfo.getRolesname() }));
/*     */     }
/* 166 */     this.request.setAttribute("Rolesid", Integer.valueOf(1));
/* 167 */     this.request.setAttribute("RolesidEdit", sbRolesid.toString());
/* 168 */     this.request.setAttribute("RolesidList", sbRolesid.toString());
/*     */ 
/* 172 */     SystemSectorInfoCollection SystemSectorColl = SystemSectorProvider.getSystemSectorStatic();
/* 173 */     StringBuilder sbSectorid = new StringBuilder(100);
/* 174 */     for (SystemSectorInfo objSystemSectorInfo : SystemSectorColl)
/*     */     {
/* 176 */       sbSectorid.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { Integer.valueOf(objSystemSectorInfo.getSectordatabaseid()), objSystemSectorInfo.getSectorname() }));
/*     */     }
/* 178 */     this.request.setAttribute("Sectorid", Integer.valueOf(2));
/* 179 */     this.request.setAttribute("SectoridEdit", sbSectorid.toString());
/* 180 */     this.request.setAttribute("SectoridList", sbSectorid.toString());
/*     */ 
/* 184 */     StringBuilder sbIsUse = new StringBuilder(100);
/* 185 */     for (ItemInfo itemInfo : SystemAdminItemCollection.IsUseCollection())
/*     */     {
/* 187 */       sbIsUse.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { itemInfo.getValue(), itemInfo.getText() }));
/*     */     }
/* 189 */     this.request.setAttribute("IsUse", Integer.valueOf(1));
/* 190 */     this.request.setAttribute("IsUseEdit", sbIsUse.toString());
/* 191 */     this.request.setAttribute("IsUseList", sbIsUse.toString());
/*     */ 
/* 194 */     StringBuilder sbIsDel = new StringBuilder(100);
/* 195 */     for (ItemInfo itemInfo : SystemAdminItemCollection.IsDelCollection())
/*     */     {
/* 197 */       sbIsDel.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { itemInfo.getValue(), itemInfo.getText() }));
/*     */     }
/* 199 */     this.request.setAttribute("IsDel", Integer.valueOf(1));
/* 200 */     this.request.setAttribute("IsDelEdit", sbIsDel.toString());
/* 201 */     this.request.setAttribute("IsDelList", sbIsDel.toString());
/*     */   }
/*     */ 
/*     */   protected void ListShow()
/*     */   {
/* 209 */     String pageListUrl = getpageListUrl();
/*     */ 	  DrpInit();
			  
/* 211 */     String OrderBy = "";
/* 212 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "DatabaseAdminID");
/* 213 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
			  String target=Requests.GetString(this.request, "target","");
			  boolean isadmin=false;
			  if(target.equals("admin"))
			  {
				  isadmin=true;
			  }
/* 214 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 216 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/*     */ 
/* 219 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 220 */     int pageAll = 0;
/* 221 */     pageAll = SystemAdminProvider.GetListPagerBy();
			  SystemAdminProvider.setSystemAdminStatic(null);
/* 222 */     SystemAdminInfoCollection temp = SystemAdminProvider.getSystemAdminStatic();
			  SystemAdminInfoCollection SystemAdminColl=new SystemAdminInfoCollection();
			  SystemAdminInfoCollection SystemAdminNoUse=new SystemAdminInfoCollection();
			  for(SystemAdminInfo admin: temp)
			   {
				   if(admin.getIsDel()==1)
				   {
					   SystemAdminColl.add(admin);
				   }
			   }
			  for(SystemAdminInfo admin: temp)
			  {
				  
				  if(admin.getIsDel()!=1)
				  {
					  SystemAdminNoUse.add(admin);
					
				  }
			  }
			  StringBuffer sbStrNoUseID=new StringBuffer();
			  StringBuffer sbStrNoUseName=new StringBuffer();
			  StringBuffer sbStrNoUseSex=new StringBuffer();
			  StringBuffer sbStrNoUseSector=new StringBuffer();
			  StringBuffer sbStrNoUseDatabaseID=new StringBuffer();
			  for (SystemAdminInfo objSystemAdminInfo : SystemAdminNoUse)
			  {
				  sbStrNoUseID.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { Integer.valueOf(objSystemAdminInfo.getAdminid()),Integer.valueOf(objSystemAdminInfo.getAdminid())  }));
				  sbStrNoUseName.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { Integer.valueOf(objSystemAdminInfo.getAdminid()),objSystemAdminInfo.getTruename() }));
				  sbStrNoUseSex.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { Integer.valueOf(objSystemAdminInfo.getAdminid()),objSystemAdminInfo.getSex() }));
				  sbStrNoUseSector.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { Integer.valueOf(objSystemAdminInfo.getAdminid()),objSystemAdminInfo.getSectorid() }));
				  sbStrNoUseDatabaseID.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { Integer.valueOf(objSystemAdminInfo.getAdminid()),objSystemAdminInfo.getDatabaseadminid() }));
			  }
			  this.request.setAttribute("NoUseDatabaseID", sbStrNoUseDatabaseID);
			  this.request.setAttribute("NoUseSex", sbStrNoUseSex.toString());
			  this.request.setAttribute("NoUseSector", sbStrNoUseSector.toString());
			  this.request.setAttribute("NoUseName",sbStrNoUseName.toString());
			  this.request.setAttribute("NoUseID",sbStrNoUseID.toString());
/* 223 */     this.request.setAttribute("SystemAdminList", SystemAdminColl);
/*     */ 
/* 229 */     //String pageDetails = "";
/* 230 */     //if (pageAll > this.pageSize) pageDetails = Pager.LastNextPage(this.request, this.response, this.pageParameter, this.pageSize, pageAll);
/*     */ 
/* 232 */     //this.request.setAttribute("pageDetails", pageDetails);
/*     */   }
/*     */ 
/*     */   protected void ItemCommandEdit()
/*     */   {
/* 241 */     int Databaseadminid = Requests.GetInt(this.request, "databaseadminid", 0);
/*     */ 
/* 243 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 245 */     SystemAdminInfo objSystemAdminInfo = SystemAdminProvider.GetSystemAdminInfoByDatabaseadminid(Databaseadminid);
/* 246 */     if (objSystemAdminInfo != null)
/*     */     {	
				this.request.setAttribute("rolecompetence",objSystemAdminInfo.getObjSystemRolesInfoByRolesid().getCompetenceid());
				this.request.setAttribute("sectorname", objSystemAdminInfo.getObjSystemSectorInfoBySectorid().getSectorname());
				this.request.setAttribute("rolesname", objSystemAdminInfo.getObjSystemRolesInfoByRolesid().getRolesname());
				this.request.setAttribute("isUselabel", objSystemAdminInfo.getIsUselabel());
				this.request.setAttribute("isDellabel", objSystemAdminInfo.getIsDellabel());
				this.request.setAttribute("competenceid", objSystemAdminInfo.getCompetence());
/* 248 */       this.request.setAttribute("Databaseadminid", Integer.valueOf(objSystemAdminInfo.getDatabaseadminid()));
/* 249 */       this.request.setAttribute("Adminid", Integer.valueOf(objSystemAdminInfo.getAdminid()));
/* 250 */       this.request.setAttribute("Adminname", StringFormat.HtmlEncode(objSystemAdminInfo.getAdminname()));
/* 251 */       this.request.setAttribute("Adminpassword", StringFormat.HtmlEncode(objSystemAdminInfo.getAdminpassword()));
/* 252 */       this.request.setAttribute("Sex", Integer.valueOf(objSystemAdminInfo.getSex()));
/* 253 */       this.request.setAttribute("Truename", StringFormat.HtmlEncode(objSystemAdminInfo.getTruename()));
/* 254 */       this.request.setAttribute("Workno", StringFormat.HtmlEncode(objSystemAdminInfo.getWorkno()));
/* 255 */       this.request.setAttribute("Email", StringFormat.HtmlEncode(objSystemAdminInfo.getEmail()));
/* 256 */       this.request.setAttribute("Movephone", StringFormat.HtmlEncode(objSystemAdminInfo.getMovephone()));
/* 257 */       this.request.setAttribute("Phone", StringFormat.HtmlEncode(objSystemAdminInfo.getPhone()));
/* 258 */       this.request.setAttribute("Msn", StringFormat.HtmlEncode(objSystemAdminInfo.getMsn()));
/* 259 */       this.request.setAttribute("Rolesid", Integer.valueOf(objSystemAdminInfo.getRolesid()));
/* 260 */       this.request.setAttribute("Sectorid", Integer.valueOf(objSystemAdminInfo.getSectorid()));
/* 261 */       this.request.setAttribute("Description", StringFormat.HtmlEncode(objSystemAdminInfo.getDescription()));
/* 262 */       this.request.setAttribute("Address", StringFormat.HtmlEncode(objSystemAdminInfo.getAddress()));
/* 263 */       this.request.setAttribute("LimitIp", StringFormat.HtmlEncode(objSystemAdminInfo.getLimitIp()));
/* 264 */       this.request.setAttribute("LastLogintime", Converts.DateToString(objSystemAdminInfo.getLastLogintime(), "yyyy-MM-dd"));
/* 265 */       this.request.setAttribute("LastLoginip", StringFormat.HtmlEncode(objSystemAdminInfo.getLastLoginip()));
/* 266 */       this.request.setAttribute("CreateTime", Converts.DateToString(objSystemAdminInfo.getCreateTime(), "yyyy-MM-dd"));
/* 267 */       this.request.setAttribute("LastModifytime", Converts.DateToString(objSystemAdminInfo.getLastModifytime(), "yyyy-MM-dd"));
/* 268 */       this.request.setAttribute("IsUse", Integer.valueOf(objSystemAdminInfo.getIsUse()));
/* 269 */       this.request.setAttribute("IsDel", Integer.valueOf(objSystemAdminInfo.getIsDel()));
/*     */    
				this.request.setAttribute("Sexlabel", objSystemAdminInfo.getSexlabel());
/* 317 */       this.request.setAttribute("IsUselabel", objSystemAdminInfo.getIsUselabel());
/* 318 */       this.request.setAttribute("IsDellabel", objSystemAdminInfo.getIsDellabel());
/*     */ 
/* 321 */       this.request.setAttribute("RolesnameByRolesid", objSystemAdminInfo.getObjSystemRolesInfoByRolesid().getRolesname());
/* 322 */       this.request.setAttribute("SectornameBySectorid", objSystemAdminInfo.getObjSystemSectorInfoBySectorid().getSectorname());
			   }
/*     */     else
/*     */     {
/* 274 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 275 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void ItemCommandDetails()
/*     */   {
/* 285 */     int Databaseadminid = Requests.GetInt(this.request, "databaseadminid", 0);
/*     */ 
/* 287 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 289 */     SystemAdminInfo objSystemAdminInfo = SystemAdminProvider.GetSystemAdminInfoByDatabaseadminid(Databaseadminid);
/* 290 */     if (objSystemAdminInfo != null)
/*     */     {
/* 292 */       this.request.setAttribute("Databaseadminid", Integer.valueOf(objSystemAdminInfo.getDatabaseadminid()));
/* 293 */       this.request.setAttribute("Adminid", Integer.valueOf(objSystemAdminInfo.getAdminid()));
/* 294 */       this.request.setAttribute("Adminname", objSystemAdminInfo.getAdminname());
/* 295 */       this.request.setAttribute("Adminpassword", objSystemAdminInfo.getAdminpassword());
/* 296 */       this.request.setAttribute("Sex", Integer.valueOf(objSystemAdminInfo.getSex()));
/* 297 */       this.request.setAttribute("Truename", objSystemAdminInfo.getTruename());
/* 298 */       this.request.setAttribute("Workno", objSystemAdminInfo.getWorkno());
/* 299 */       this.request.setAttribute("Email", objSystemAdminInfo.getEmail());
/* 300 */       this.request.setAttribute("Movephone", objSystemAdminInfo.getMovephone());
/* 301 */       this.request.setAttribute("Phone", objSystemAdminInfo.getPhone());
/* 302 */       this.request.setAttribute("Msn", objSystemAdminInfo.getMsn());
/* 303 */       this.request.setAttribute("Rolesid", Integer.valueOf(objSystemAdminInfo.getRolesid()));
/* 304 */       this.request.setAttribute("Sectorid", Integer.valueOf(objSystemAdminInfo.getSectorid()));
/* 305 */       this.request.setAttribute("Description", objSystemAdminInfo.getDescription());
/* 306 */       this.request.setAttribute("Address", objSystemAdminInfo.getAddress());
/* 307 */       this.request.setAttribute("LimitIp", objSystemAdminInfo.getLimitIp());
/* 308 */       this.request.setAttribute("LastLogintime", Converts.DateToString(objSystemAdminInfo.getLastLogintime(), "yyyy-MM-dd"));
/* 309 */       this.request.setAttribute("LastLoginip", objSystemAdminInfo.getLastLoginip());
/* 310 */       this.request.setAttribute("CreateTime", Converts.DateToString(objSystemAdminInfo.getCreateTime(), "yyyy-MM-dd"));
/* 311 */       this.request.setAttribute("LastModifytime", Converts.DateToString(objSystemAdminInfo.getLastModifytime(), "yyyy-MM-dd"));
/* 312 */       this.request.setAttribute("IsUse", Integer.valueOf(objSystemAdminInfo.getIsUse()));
/* 313 */       this.request.setAttribute("IsDel", Integer.valueOf(objSystemAdminInfo.getIsDel()));
/*     */ 
/* 316 */       this.request.setAttribute("Sexlabel", objSystemAdminInfo.getSexlabel());
/* 317 */       this.request.setAttribute("IsUselabel", objSystemAdminInfo.getIsUselabel());
/* 318 */       this.request.setAttribute("IsDellabel", objSystemAdminInfo.getIsDellabel());
/*     */ 
/* 321 */       this.request.setAttribute("RolesnameByRolesid", objSystemAdminInfo.getObjSystemRolesInfoByRolesid().getRolesname());
/* 322 */       this.request.setAttribute("SectornameBySectorid", objSystemAdminInfo.getObjSystemSectorInfoBySectorid().getSectorname());
/*     */     }
/*     */     else
/*     */     {
/* 327 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 328 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected boolean ServerValidate()
/*     */   {
/* 337 */     StringBuilder sbStr = new StringBuilder(1024);
/* 338 */     int i = 1;
/*     */ 
/* 341 */     if (Requests.GetString(this.request, "adminid").length() == 0)
/*     */     {
/* 343 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "人员编号" }));
/* 344 */       i++;
/*     */     }
/*     */ 
/* 347 */     if (!Validate.IsNumber(Requests.GetString(this.request, "adminid")))
/*     */     {
/* 349 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "人员编号" }));
/* 350 */       i++;
/*     */     }
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
///* 386 */     if (Requests.GetString(this.request, "sex").length() == 0)
///*     */     {
///* 388 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "性别" }));
///* 389 */       i++;
///*     */     }
///*     */ 
///* 392 */     if (!Validate.IsNumber(Requests.GetString(this.request, "sex")))
///*     */     {
///* 394 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "性别" }));
///* 395 */       i++;
///*     */     }
/*     */ 
///* 399 */     if (Requests.GetString(this.request, "truename").length() == 0)
///*     */     {
///* 401 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "姓名" }));
///* 402 */       i++;
///*     */     }
///* 404 */     if (Validate.getLength(Requests.GetString(this.request, "truename")) > 50)
///*     */     {
///* 406 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "姓名" }));
///* 407 */       i++;
///*     */     }
/*     */ 
///* 411 */     if (Requests.GetString(this.request, "workno").length() == 0)
///*     */     {
///* 413 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "工号" }));
///* 414 */       i++;
///*     */     }
///* 416 */     if (Validate.getLength(Requests.GetString(this.request, "workno")) > 50)
///*     */     {
///* 418 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "工号" }));
///* 419 */       i++;
///*     */     }
///*     */ 
///* 424 */     if (Requests.GetString(this.request, "rolesid").length() == 0)
///*     */     {
///* 426 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "角色编号" }));
///* 427 */       i++;
///*     */     }
///*     */ 
///* 430 */     if (!Validate.IsNumber(Requests.GetString(this.request, "rolesid")))
///*     */     {
///* 432 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "角色编号" }));
///* 433 */       i++;
///*     */     }
///*     */ 
///* 437 */     if (Requests.GetString(this.request, "sectorid").length() == 0)
///*     */     {
///* 439 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "部门编号" }));
///* 440 */       i++;
///*     */     }
///*     */ 
///* 443 */     if (!Validate.IsNumber(Requests.GetString(this.request, "sectorid")))
///*     */     {
///* 445 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "部门编号" }));
///* 446 */       i++;
///*     */     }
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
/*     */ 
/*     */   protected void insert()
/*     */   {
/* 472 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 474 */     int Databaseadminid = Requests.GetInt(this.request, "databaseadminid", 0);
/* 475 */     int Adminid = Requests.GetInt(this.request, "adminid", 0);
/* 476 */     String Adminname = Requests.GetString(this.request, "adminname", "");
/* 477 */     String Adminpassword = Requests.GetString(this.request, "adminpassword", "");
/* 478 */     int Sex = Requests.GetInt(this.request, "sex", 0);
/* 479 */     String Truename = Requests.GetString(this.request, "truename", "");
/* 480 */     String Workno = Requests.GetString(this.request, "workno", "");
/* 481 */     String Email = Requests.GetString(this.request, "email", "");
			
/* 482 */     String Movephone = Requests.GetString(this.request, "movephone", "");
/* 483 */     String Phone = Requests.GetString(this.request, "phone", "");
/* 484 */     String Msn = Requests.GetString(this.request, "msn", "");
/* 485 */     int Rolesid = Requests.GetInt(this.request, "rolesid", 0);
/* 486 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
/* 487 */     String Description = Requests.GetString(this.request, "description", "");
/* 488 */     String Address = Requests.GetString(this.request, "address", "");
/* 489 */     String LimitIp = Requests.GetString(this.request, "limitIp", "");
/* 490 */     Date LastLogintime = Requests.GetDate(this.request, "lastLogintime", new Date());
/* 491 */     String LastLoginip = Requests.GetString(this.request, "lastLoginip", "");
/* 492 */     Date CreateTime = Requests.GetDate(this.request, "createTime", new Date());
/* 493 */     Date LastModifytime = Requests.GetDate(this.request, "lastModifytime", new Date());


/* 494 */     int IsUse = Requests.GetInt(this.request, "isUse", 2);
/* 495 */     int IsDel = Requests.GetInt(this.request, "isDel", 1);
/*     */ 
/* 498 */     if (!ServerValidate())
/*     */     {
/* 501 */       DrpInit();
/* 502 */       this.request.setAttribute("Databaseadminid", Integer.valueOf(Databaseadminid));
/* 503 */       this.request.setAttribute("Adminid", Integer.valueOf(Adminid));
/* 504 */       this.request.setAttribute("Adminname", StringFormat.HtmlEncode(Adminname));
/* 505 */       this.request.setAttribute("Adminpassword", StringFormat.HtmlEncode(Adminpassword));
/* 506 */       this.request.setAttribute("Sex", Integer.valueOf(Sex));
/* 507 */       this.request.setAttribute("Truename", StringFormat.HtmlEncode(Truename));
/* 508 */       this.request.setAttribute("Workno", StringFormat.HtmlEncode(Workno));
/* 509 */       this.request.setAttribute("Email", StringFormat.HtmlEncode(Email));
/* 510 */       this.request.setAttribute("Movephone", StringFormat.HtmlEncode(Movephone));
/* 511 */       this.request.setAttribute("Phone", StringFormat.HtmlEncode(Phone));
/* 512 */       this.request.setAttribute("Msn", StringFormat.HtmlEncode(Msn));
/* 513 */       this.request.setAttribute("Rolesid", Integer.valueOf(Rolesid));
/* 514 */       this.request.setAttribute("Sectorid", Integer.valueOf(Sectorid));
/* 515 */       this.request.setAttribute("Description", StringFormat.HtmlEncode(Description));
/* 516 */       this.request.setAttribute("Address", StringFormat.HtmlEncode(Address));
/* 517 */       this.request.setAttribute("LimitIp", StringFormat.HtmlEncode(LimitIp));
/* 518 */       this.request.setAttribute("LastLogintime", new SimpleDateFormat("yyyy-MM-dd").format(LastLogintime));
/* 519 */       this.request.setAttribute("LastLoginip", StringFormat.HtmlEncode(LastLoginip));
/* 520 */       this.request.setAttribute("CreateTime", new SimpleDateFormat("yyyy-MM-dd").format(CreateTime));
/* 521 */       this.request.setAttribute("LastModifytime", new SimpleDateFormat("yyyy-MM-dd").format(LastModifytime));
/* 522 */       this.request.setAttribute("IsUse", Integer.valueOf(IsUse));
/* 523 */       this.request.setAttribute("IsDel", Integer.valueOf(IsDel));
/* 524 */       return;
/*     */     }
/*     */ 
/* 527 */     SystemAdminInfo objSystemAdminInfo = new SystemAdminInfo();
/* 528 */     objSystemAdminInfo.setDatabaseadminid(Databaseadminid);
/* 529 */     objSystemAdminInfo.setAdminid(Adminid);
/* 530 */     objSystemAdminInfo.setAdminname(Adminname);
/* 531 */     objSystemAdminInfo.setAdminpassword(Adminpassword);
/* 532 */     objSystemAdminInfo.setSex(Sex);
/* 533 */     objSystemAdminInfo.setTruename(Truename);
/* 534 */     objSystemAdminInfo.setWorkno(Workno);
/* 535 */     objSystemAdminInfo.setEmail(Email);
/* 536 */     objSystemAdminInfo.setMovephone(Movephone);
/* 537 */     objSystemAdminInfo.setPhone(Phone);
/* 538 */     objSystemAdminInfo.setMsn(Msn);
/* 539 */     objSystemAdminInfo.setRolesid(Rolesid);
/* 540 */     objSystemAdminInfo.setSectorid(Sectorid);
/* 541 */     objSystemAdminInfo.setDescription(Description);
/* 542 */     objSystemAdminInfo.setAddress(Address);
/* 543 */     objSystemAdminInfo.setLimitIp(LimitIp);
/* 544 */     objSystemAdminInfo.setLastLogintime(LastLogintime);
/* 545 */     objSystemAdminInfo.setLastLoginip(LastLoginip);
/* 546 */     objSystemAdminInfo.setCreateTime(CreateTime);
/* 547 */     objSystemAdminInfo.setLastModifytime(LastModifytime);
/* 548 */     objSystemAdminInfo.setIsUse(IsUse);
/* 549 */     objSystemAdminInfo.setIsDel(IsDel);
/*     */ 
/* 551 */     SystemAdminProvider.Insert(objSystemAdminInfo);
/*     */ 
/* 553 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?" + pageListUrl);
/* 554 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 556 */       js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 558 */     this.request.setAttribute("pageJavaScripStar", js);
/* 559 */     SystemAdminProvider.setSystemAdminStatic(null);
/*     */   }
			protected void updateCompetence()
			{
				 String pageListUrl = getpageListUrl();
				 int Databaseadminid = Requests.GetInt(this.request, "databaseadminid", 0);
				 String newcompetence=Requests.GetString(this.request, "competenceid",0);
				 SystemAdminInfo objSystemAdminInfo = SystemAdminProvider.GetSystemAdminInfoByDatabaseadminid(Databaseadminid); 
				 objSystemAdminInfo.setCompetence(newcompetence);
				 SystemAdminProvider.UpdateByDatabaseadminid(objSystemAdminInfo);
				 String js = Javascript.Alert(this.request, this.response, "更新成功");
				 this.request.setAttribute("pageJavaScripStar", js);
				 SystemAdminProvider.setSystemAdminStatic(null);
			}
/*     */ 
/*     */   protected void update()
/*     */   {
			  
/* 567 */     String pageListUrl = getpageListUrl();
/* 569 */     
			  int Databaseadminid = Requests.GetInt(this.request, "databaseadminid", 0);
/* 570 */     int Adminid = Requests.GetInt(this.request, "adminid", 0);
/* 571 */     String Adminname = Requests.GetString(this.request, "adminname", "");
/* 572 */     String Adminpassword = Requests.GetString(this.request, "adminpassword", "");

			   int Rolesid = Requests.GetInt(this.request, "rolesid", 0);
			   	
/* 589 */      int IsUse = Requests.GetInt(this.request, "isUse", 1);
/* 590 */      int IsDel = Requests.GetInt(this.request, "isDel", 1);
/*     */ 	   String address=Requests.GetString(this.request, "address");

/* 593 */     if (!ServerValidate())
/*     */     {
/* 596 */       DrpInit();

/* 597 */       this.request.setAttribute("Databaseadminid", Integer.valueOf(Databaseadminid));
/* 598 */       this.request.setAttribute("Adminid", Integer.valueOf(Adminid));
/* 599 */       this.request.setAttribute("Adminname", StringFormat.HtmlEncode(Adminname));
/* 600 */       this.request.setAttribute("Adminpassword", StringFormat.HtmlEncode(Adminpassword));

/* 617 */       this.request.setAttribute("IsDel", Integer.valueOf(IsDel));
/* 618 */       this.request.setAttribute("IsUse", Integer.valueOf(IsUse));
/* 619 */       return;
/*     */     }
/*     */ 
/* 622 */     SystemAdminInfo objSystemAdminInfo = SystemAdminProvider.GetSystemAdminInfoByDatabaseadminid(Databaseadminid);

/* 624 */     objSystemAdminInfo.setAdminid(Adminid);
/* 625 */     objSystemAdminInfo.setAdminname(Adminname);
/* 626 */     objSystemAdminInfo.setAdminpassword(Adminpassword);

			  if(Rolesid!=objSystemAdminInfo.getRolesid())
			  {
				  objSystemAdminInfo.setCompetence(SystemRolesProvider.GetSystemRolesInfoByDatabaserolesid(Rolesid).getCompetenceid());
				  objSystemAdminInfo.setRolesid(Rolesid);
			  }
			  

/* 643 */     objSystemAdminInfo.setIsUse(IsUse);
/* 644 */     objSystemAdminInfo.setIsDel(IsDel);
/*     */ 
/* 646 */     SystemAdminProvider.UpdateByDatabaseadminid(objSystemAdminInfo);
/*     */ 
/* 648 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?" + pageListUrl);
/* 649 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 651 */       js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 653 */     this.request.setAttribute("pageJavaScripStar", js);
/* 654 */     SystemAdminProvider.setSystemAdminStatic(null);

/*     */   }
/*     */   

/*     */   protected void delete()
/*     */   {
/* 663 */     int Databaseadminid = Requests.GetInt(this.request, "databaseadminid", 0);
/*     */ 
/* 665 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 667 */     SystemAdminProvider.DeleteByDatabaseadminid(Databaseadminid);
/*     */ 
/* 669 */     SystemAdminProvider.setSystemAdminStatic(null);
/* 670 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "删除成功", "?" + pageListUrl);
/* 671 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ 
/*     */   public void modifyPW()
/*     */   {
/* 678 */     int Databaseadminid = Requests.GetInt(this.request, "databaseadminid", 0);
/*     */ 
/* 680 */     String Password = Requests.GetString(this.request, "password", "");
/* 681 */     String Oldpassword = Requests.GetString(this.request, "oldpassword", "");
/*     */ 
/* 683 */     SystemAdminInfo objSystemAdminInfo = SystemAdminProvider.GetSystemAdminInfoByDatabaseadminid(Databaseadminid);
/* 684 */     if (objSystemAdminInfo.getAdminpassword().equals(Oldpassword))
/*     */     {
/* 686 */       objSystemAdminInfo.setDatabaseadminid(Databaseadminid);
/* 687 */       objSystemAdminInfo.setAdminpassword(Password);
/* 688 */       SystemAdminProvider.UpdateByDatabaseadminid(objSystemAdminInfo);
/*     */ 
/* 690 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "修改成功", "#");
/* 691 */       if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */       {
/* 693 */         js = Javascript.AlertAndRedirect(this.request, this.response, "修改成功", "#");
/*     */       }
/* 695 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */     else
/*     */     {
/* 700 */       String sbStr = "旧密码错误";
/* 701 */       String js = Javascript.Alert(this.request, this.response, sbStr.toString());
/* 702 */       this.request.setAttribute("pageJavaScripEnd", js);
/* 703 */       return;
/*     */     }
/*     */   }
public boolean comparaToStr(String str1,String str2)
{		
	String[] temp=str1.split(",");
	for(int i=0;i<temp.length;i++)
	{	

		if(temp[i].equals(str2))
			return true;
	}
	return false;
}

private	SystemCompetenceInfoCollection systemcompetenceforenterprise=SystemCompetenceProvider.getSystemcompetenceforenterprise();
private	SystemCompetenceInfoCollection systemcompetenceforproject=SystemCompetenceProvider.getSystemcompetenceforproject();
private	SystemCompetenceInfoCollection systemcompetencefortalent=SystemCompetenceProvider.getSystemcompetencefortalent();
private	SystemCompetenceInfoCollection systemcompetenceforbaseinfo=SystemCompetenceProvider.getSystemcompetenceforbaseinfo();
private	SystemCompetenceInfoCollection systemcompetenceforsystem=SystemCompetenceProvider.getSystemcompetenceforsystem();
public SystemCompetenceInfoCollection getSystemcompetenceforenterprise() {
			return systemcompetenceforenterprise;
		}
		public void setSystemcompetenceforenterprise(
				SystemCompetenceInfoCollection systemcompetenceforenterprise) {
			this.systemcompetenceforenterprise = systemcompetenceforenterprise;
		}
		public SystemCompetenceInfoCollection getSystemcompetenceforproject() {
			return systemcompetenceforproject;
		}
		public void setSystemcompetenceforproject(
				SystemCompetenceInfoCollection systemcompetenceforproject) {
			this.systemcompetenceforproject = systemcompetenceforproject;
		}
		public SystemCompetenceInfoCollection getSystemcompetencefortalent() {
			return systemcompetencefortalent;
		}
		public void setSystemcompetencefortalent(
				SystemCompetenceInfoCollection systemcompetencefortalent) {
			this.systemcompetencefortalent = systemcompetencefortalent;
		}
		public SystemCompetenceInfoCollection getSystemcompetenceforbaseinfo() {
			return systemcompetenceforbaseinfo; 
		}
		public void setSystemcompetenceforbaseinfo(
				SystemCompetenceInfoCollection systemcompetenceforbaseInfo) {
			this.systemcompetenceforbaseinfo = systemcompetenceforbaseInfo;
		}
		public SystemCompetenceInfoCollection getSystemcompetenceforsystem() {
			return systemcompetenceforsystem;
		}
		public void setSystemcompetenceforsystem(
				SystemCompetenceInfoCollection systemcompetenceforsystem) {
			this.systemcompetenceforsystem = systemcompetenceforsystem;
		}
		
		// [start] ServerValidate 服务器验证
	    protected boolean ServerValidateforSelf()
	    {
	        java.util.HashMap<String,Object> valueMap = new java.util.HashMap<String,Object>();
	        StringBuilder sbStr = new StringBuilder(1024);
	        int i = 1;

	        
	        // [start] 联系EMAIL
	        valueMap = new java.util.HashMap<String,Object>();
	        valueMap.put("label_name", "联系EMAIL");
	        if (com.colorwinglib.Requests.GetString(request, "email").length() == 0)
	        {
	            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
	            i = i + 1;
	        }
	        if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "email")) > 50)
	        {
	            valueMap.put("N", 50);
	            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
	            i = i + 1;
	        }

	        if (!com.colorwinglib.Validate.IsEmail(com.colorwinglib.Requests.GetString(request, "email")))
	        {
	            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
	            i = i + 1;
	        }
	        // [end]
	        // [start] 移动电话
	        valueMap = new java.util.HashMap<String,Object>();
	        valueMap.put("label_name", "移动电话");
	        if (com.colorwinglib.Requests.GetString(request, "movephone").length() == 0)
	        {
	            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
	            i = i + 1;
	        }
	        if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "movephone")) > 50)
	        {
	            valueMap.put("N", 50);
	            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
	            i = i + 1;
	        }
	        // [end]
	        // [start] 电话
	        valueMap = new java.util.HashMap<String,Object>();
	        valueMap.put("label_name", "电话");
	        if (com.colorwinglib.Requests.GetString(request, "phone").length() == 0)
	        {
	            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
	            i = i + 1;
	        }
	        if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "phone")) > 50)
	        {
	            valueMap.put("N", 50);
	            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
	            i = i + 1;
	        }
	        // [end]
	      
	        // [start] 通讯地址
	        valueMap = new java.util.HashMap<String,Object>();
	        valueMap.put("label_name", "通讯地址");
	        if (com.colorwinglib.Requests.GetString(request, "address").length() == 0)
	        {
	            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
	            i = i + 1;
	        }
	        if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "address")) > 50)
	        {
	            valueMap.put("N", 50);
	            sbStr.append(String.format("%1$s.%2$s\n",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
	            i = i + 1;
	        }
	        // [end]
	        
	     
	    
	     

	        if (i-1 > 0)
	        {
				valueMap = new java.util.HashMap<String, Object>();
				valueMap.put("n", (i - 1));
	            sbStr.append(com.yun.common.Message.GetMessage(com.yun.common.Message.I0000006, valueMap));
				String js = com.colorwinglib.Javascript.Alert(request, response, sbStr.toString());
				request.setAttribute("pageJavaScripEnd", js);
				if (com.colorwinglib.Requests.GetInt(request, "isSaveAndNew") == 1)
				{
					request.setAttribute("btnEditCommandArgument", com.yun.common.Pager.getCurrentlyPage(request, "pagetype", "insert"));
				}
	            return false;
	        }
	        else
	        {
	            return true;
	        }
	    }
		// [end]
		// [start] update 更新
	    protected void updateforself ()
	    {
			String pageListUrl = getpageListUrl();
			int Databaseadminid = com.colorwinglib.Requests.GetInt(request, "databaseadminid",0);//人员ID  数据类型:int
			String Email = com.colorwinglib.Requests.GetString(request, "email","");//联系EMAIL  数据类型:String
			String Movephone = com.colorwinglib.Requests.GetString(request, "movephone","");//移动电话  数据类型:String
			String Phone = com.colorwinglib.Requests.GetString(request, "phone","");//电话  数据类型:String
			String Address = com.colorwinglib.Requests.GetString(request, "address","");//通讯地址  数据类型:String
			Date LastModifytime = com.colorwinglib.Requests.GetDate(request, "lastModifytime",new Date());//最后修改时间  数据类型:Date


	        //服务器验证
	        if (!ServerValidateforSelf())
	        {
				//进行赋值验证失败时用
				DrpInit();
				ItemCommandEdit();
				request.setAttribute("Databaseadminid", Databaseadminid);//人员ID  数据类型:int


				request.setAttribute("Email", com.colorwinglib.StringFormat.HtmlEncode(Email));//联系EMAIL  数据类型:String
				request.setAttribute("Movephone", com.colorwinglib.StringFormat.HtmlEncode(Movephone));//移动电话  数据类型:String
				request.setAttribute("Phone", com.colorwinglib.StringFormat.HtmlEncode(Phone));//电话  数据类型:String
				request.setAttribute("Address", com.colorwinglib.StringFormat.HtmlEncode(Address));//通讯地址  数据类型:String

				request.setAttribute("LastModifytime", new java.text.SimpleDateFormat("yyyy-MM-dd").format(LastModifytime));//最后修改时间  数据类型:Date
	            return;
	        }

	        
			com.yun.entities.culture.SystemAdminInfo objSystemAdminInfo = com.yun.bll.culture.SystemAdminProvider.GetSystemAdminInfoByDatabaseadminid(Databaseadminid);//实体类
			objSystemAdminInfo.setDatabaseadminid(Databaseadminid);//人员ID  数据类型:int
			objSystemAdminInfo.setEmail(Email);//联系EMAIL  数据类型:String
			objSystemAdminInfo.setMovephone(Movephone);//移动电话  数据类型:String
			objSystemAdminInfo.setPhone(Phone);//电话  数据类型:String
			objSystemAdminInfo.setAddress(Address);//通讯地址  数据类型:String

			objSystemAdminInfo.setLastModifytime(LastModifytime);//最后修改时间  数据类型:Date

	        boolean isRun = com.yun.bll.culture.SystemAdminProvider.UpdateByDatabaseadminid(objSystemAdminInfo);

			if (isRun)
			{
				String js = com.colorwinglib.Javascript.Alert(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000003));
			if (com.colorwinglib.Requests.GetInt(request, "isSaveAndNew") == 1)
			{
				js = com.colorwinglib.Javascript.Alert(request, response,com.yun.common.Message.GetMessage(com.yun.common.Message.I0000003));
			}
				request.setAttribute("pageJavaScripStar", js);
			}
			else
			{
				String js = com.colorwinglib.Javascript.Alert(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000011));
			if (com.colorwinglib.Requests.GetInt(request, "isSaveAndNew") == 1)
			{
				js = com.colorwinglib.Javascript.Alert(request, response,com.yun.common.Message.GetMessage(com.yun.common.Message.I0000011));
			}
				request.setAttribute("pageJavaScripStar", js);
			}
	        com.yun.bll.culture.SystemAdminProvider.setSystemAdminStatic(null);
	        ItemCommandEdit();
	    }
		// [end]
	    




	    


		
 }


/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.system.SystemAdmin
 * JD-Core Version:    0.6.0
 */