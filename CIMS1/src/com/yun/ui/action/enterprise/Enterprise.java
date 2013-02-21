/*      */ package com.yun.ui.action.enterprise;
/*      */ 
/*      */ import com.colorwinglib.Converts;
/*      */ import com.colorwinglib.Javascript;
/*      */ import com.colorwinglib.Requests;
/*      */ import com.colorwinglib.StringFormat;
/*      */ import com.colorwinglib.Validate;
/*      */ import com.yun.bll.culture.EnterpriseProvider;
/*      */ import com.yun.bll.culture.EnterpristQualityProvider;
import com.yun.bll.culture.IndustryProjectProvider;
/*      */ import com.yun.bll.culture.PeopleProvider;
/*      */ import com.yun.bll.culture.ProfessionProvider;
/*      */ import com.yun.bll.culture.RegionsProvider;
import com.yun.bll.culture.SystemAdminProvider;
/*      */ import com.yun.common.MyDate;
/*      */ import com.yun.common.Pager;
/*      */ import com.yun.entities.culture.EnterpriseInfo;
/*      */ import com.yun.entities.culture.EnterpristQualityInfo;
/*      */ import com.yun.entities.culture.IndustryProjectInfo;
/*      */ import com.yun.entities.culture.PeopleInfo;
/*      */ import com.yun.entities.culture.ProfessionInfo;
/*      */ import com.yun.entities.culture.RegionsInfo;
/*      */ import com.yun.entities.culture.SystemAdminInfo;
/*      */ import com.yun.entities.culture.SystemSectorInfo;
/*      */ import com.yun.entities.culture.collection.EnterpriseInfoCollection;
/*      */ import com.yun.entities.culture.collection.EnterpristQualityInfoCollection;
/*      */ import com.yun.entities.culture.collection.PeopleInfoCollection;
/*      */ import com.yun.entities.culture.collection.ProfessionInfoCollection;
/*      */ import com.yun.entities.culture.collection.RegionsInfoCollection;
import com.yun.entities.culture.collection.SystemAdminInfoCollection;
/*      */ import com.yun.ui.action.UserLook;
/*      */ import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Date;
/*      */ import javax.servlet.http.HttpServletRequest;
/*      */ import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
/*      */ 
/*      */ public class Enterprise
/*      */ {
/*      */   private static final long serialVersionUID = 2011112117311605411L;
/*   21 */   public int pageSize = com.yun.configuration.WebConfig.PAGE_SIZE;
/*      */ 
/*   26 */   public String pageParameter = "page";
/*      */ 
/*   31 */   HttpServletRequest request = null;
/*      */ 
/*   35 */   HttpServletResponse response = null;
/*      */ 
/*   39 */   PrintWriter out = null;
/*      */ 
/*      */   private String getpageListUrl()
/*      */   {
	
String params= com.yun.common.Pager.getCurrentlyParams(this.request);
int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);				
String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "DatabaseEnterpriseID");
String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
String pageListOrderByItemDESCNo = pageListOrderByItemDESC.toLowerCase().equals("desc") ? "asc" : "desc";
String pageListUrlOrderBy = String.format("%s%s=%s", new Object[] { params, this.pageParameter, Integer.valueOf(pageIndex) });
String pageListUrl = String.format("%s&OrderByItem=%s&OrderByItemDESC=%s", new Object[] { pageListUrlOrderBy, pageListOrderByItem, pageListOrderByItemDESC });
this.request.setAttribute("pageListOrderByItem", pageListOrderByItem);
this.request.setAttribute("pageListOrderByItemDESC", pageListOrderByItemDESC);
this.request.setAttribute("pageListOrderByItemDESCNo", pageListOrderByItemDESCNo);
this.request.setAttribute("pageListUrlOrderBy", pageListUrlOrderBy);
this.request.setAttribute("pageListUrl", pageListUrl);
return pageListUrl;
 }
/*      */ 
String pageListUrl="";
/*      */   public String execute()
/*      */     throws Exception
/*      */   {
				
				
				
/*   80 */     this.request = ServletActionContext.getRequest();
/*   81 */     this.response = ServletActionContext.getResponse();
/*      */     UserLook userlook=new UserLook(this.request,this.response);
/*   83 */     String af = null;
/*   84 */     this.response.setCharacterEncoding("utf-8");
			  
			   
/*   85 */     this.out = this.response.getWriter();
/*   86 */    
/*      */ 
/*   89 */     int Databaseenterpriseid = Requests.GetInt(this.request, 
/*   90 */       "databaseenterpriseid", 0);
/*      */ 
/*   93 */     String pageName = "Enterprise";
/*   94 */     String pagetype = Requests.GetString(this.request, 
/*   95 */       "pagetype").toLowerCase();
pageListUrl= getpageListUrl();
/*   96 */     if (pagetype.equals("gotoinsert"))
/*      */     {	
				 userlook.seePageY("1");
				 this.request.setAttribute("title", "录入");
/*   98 */       this.request.setAttribute("btnEditText", "btnLog");
/*   99 */       this.request.setAttribute("btnReturn", "window.location.href=window.location.pathname + '?${pageListUrl}'");
/*  100 */       this.request.setAttribute("btnEditCommandArgument", 
/*  101 */       Pager.getCurrentlyPage(this.request, "pagetype", "insert"));
/*  102 */       DrpInit();
/*  103 */       af = String.format("%sEdit", new Object[] { pageName });
/*  104 */     } else if (pagetype.equals("insert"))
/*      */     {
				 this.request.setAttribute("title", "录入");
/*  106 */       this.request.setAttribute("btnEditText", "btnLog");
/*  107 */       this.request.setAttribute("btnReturn", "window.location.href=window.location.pathname + '?${pageListUrl}'");
/*  108 */       insert();
/*  109 */       af = String.format("%sEdit", new Object[] { pageName });
/*  110 */     } else if (pagetype.equals("gotoupdate"))
/*      */     {
				 userlook.seePageY("2");
/*  112 */       DrpInit();
/*  113 */       ItemCommandEdit();
this.request.setAttribute("title", "更新");
/*  114 */       this.request.setAttribute("btnEditText", "btnModify");
/*  115 */       this.request.setAttribute("btnReturn", "window.location.href=window.location.pathname + '?pagetype=updata&state=1'");
/*  116 */       this.request.setAttribute("btnEditCommandArgument", pageListUrl+"&pagetype=update");
/*  118 */       af = String.format("%sEdit", new Object[] { pageName });
/*  119 */     } else if (pagetype.equals("update"))
/*      */     {
				 this.request.setAttribute("title", "更新");
/*  121 */       this.request.setAttribute("btnEditText", "btnModify");
/*  122 */       this.request.setAttribute("btnReturn", "");
/*  123 */       update();
				  DrpInit();
/*  113 */       ItemCommandEdit();
/*  124 */       af = String.format("%sEdit", new Object[] { pageName });
/*  125 */     } else if (pagetype.equals("delete"))
/*      */     {	
	 			 userlook.seePageY("5");
/*  127 */       delete();
				 DrpInit();
				 ListShow();
/*  128 */       af = String.format("%sUpdata", new Object[] { pageName });
/*  129 */     } else if (pagetype.equals("details"))
/*      */     {	
				 
/*  131 */       ItemCommandDetails();
/*  132 */       af = String.format("%sDetails", new Object[] { pageName });
/*  133 */     } else if (pagetype.equals("updata"))
/*      */     {	
				 userlook.seePageY("3");
/*  136 */       DrpInit();

/*  137 */       if (Requests.GetString(this.request, "state").equals(
/*  138 */         "1")) {
	 

/*  139 */         ListShow();
/*      */       }
/*  141 */       af = String.format("%sUpdata", new Object[] { pageName });
/*      */     }
///*  143 */     else if (pagetype.equals("select"))
///*      */     {	
//				  userlook.seePageY("3");
///*  145 */       DrpInit();
///*      */ 		 ListShow();
///*  150 */       af = String.format("%sList", new Object[] { pageName });
///*      */     }
//				else if(pagetype.equals("report"))
//				{
//				
//				DrpInit();
//				ListShow();
//				af=String.format("%sReport", new Object[] { pageName });;
//				}
/*      */     else
/*      */     {
				  userlook.seePageY("3");
/*  155 */        DrpInit();
/*  156 */        ListShow();
/*  157 */        af = String.format("%sList", new Object[] { pageName });
/*      */     }
			
/*  159 */     return af;
/*      */   }
/*      */ 
/*      */   protected void DrpInit()
/*      */   {
/*  169 */     ProfessionInfoCollection ProfessionColl = 
/*  170 */       ProfessionProvider.getProfessionStatic();
/*  171 */     StringBuilder sbBusinesstypeid = new StringBuilder(100);
/*  172 */     for (ProfessionInfo objProfessionInfo : ProfessionColl) {
/*  173 */       sbBusinesstypeid.append(String.format(
/*  174 */         "<option value=\"%1$s\">%2$s</option>\n", new Object[] { 
/*  175 */         Integer.valueOf(objProfessionInfo
/*  175 */         .getBusinessdatabaseid()), objProfessionInfo
/*  176 */         .getBusinesstypename() }));
/*      */     }
/*      */ 
/*  179 */     this.request.setAttribute("BusinesstypeidEdit", sbBusinesstypeid.toString());
/*  180 */     this.request.setAttribute("BusinesstypeidList", sbBusinesstypeid.toString());
/*      */ 
/*  184 */     RegionsInfoCollection RegionsColl = 
/*  185 */       RegionsProvider.getRegionsStatic();
/*  186 */     StringBuilder sbRegionid = new StringBuilder(100);
/*  187 */     for (RegionsInfo objRegionsInfo : RegionsColl) {
/*  188 */       sbRegionid.append(String.format(
/*  189 */         "<option value=\"%1$s\">%2$s</option>\n", new Object[] { 
/*  190 */         Integer.valueOf(objRegionsInfo
/*  190 */         .getRegiondatabaseid()), objRegionsInfo.getRegionname() }));
/*      */     }
/*      */ 
/*  193 */     this.request.setAttribute("RegionidEdit", sbRegionid.toString());
/*  194 */     this.request.setAttribute("RegionidList", sbRegionid.toString());
/*      */ 
/*  198 */     EnterpristQualityInfoCollection EnterpristQualityColl = 
/*  199 */       EnterpristQualityProvider.getEnterpristQualityStatic();
/*  200 */     StringBuilder sbQualityid = new StringBuilder(100);
/*  201 */     for (EnterpristQualityInfo objEnterpristQualityInfo : EnterpristQualityColl) {
/*  202 */       sbQualityid.append(String.format(
/*  203 */         "<option value=\"%1$s\">%2$s</option>\n", new Object[] { 
/*  204 */         Integer.valueOf(objEnterpristQualityInfo.getQualitydatabaseid()), 
/*  205 */         objEnterpristQualityInfo.getQualityname() }));
/*      */     }
/*      */ 
/*  208 */     this.request.setAttribute("QualityidEdit", sbQualityid.toString());
/*  209 */     this.request.setAttribute("QualityidList", sbQualityid.toString());
/*      */ 
///*  213 */     PeopleInfoCollection PeopleColl = 
///*  214 */       PeopleProvider.getPeopleStatic();
///*  215 */     StringBuilder sbPeopleid1 = new StringBuilder(100);
///*  216 */     StringBuilder sbPeopleid2 = new StringBuilder(100);
///*  217 */     for (PeopleInfo objPeopleInfo : PeopleColl) {
///*  218 */       sbPeopleid1.append(String.format(
///*  219 */         "<option value=\"%1$s\">%2$s</option>\n", new Object[] { 
///*  220 */         Integer.valueOf(objPeopleInfo
///*  220 */         .getDatabasepeopleid()), objPeopleInfo
///*  221 */         .getPeoplename() }));
///*      */     }
/*      */ 
///*  224 */     sbPeopleid2 = sbPeopleid1;
///*      */ 
///*  226 */     this.request.setAttribute("Peopleid1Edit", sbPeopleid1.toString());
///*  227 */     this.request.setAttribute("Peopleid1List", sbPeopleid1.toString());
///*      */ 
///*  240 */     this.request.setAttribute("Peopleid2Edit", sbPeopleid2.toString());
///*  241 */     this.request.setAttribute("Peopleid2List", sbPeopleid2.toString());
/*      */ 
/*  273 */     //UserLook user = new UserLook(this.request, this.response);
/*  274 */     //IndustryProjectInfo industyrpro = new IndustryProjectInfo();
/*  275 */     //this.request.setAttribute("sectorname", industyrpro.getObjSystemSectorInfoBySectorid(user.getSectorid()).getSectorname());
/*  276 */     this.request.setAttribute("Logintime", new MyDate().getShortDate());
			   
			    SystemAdminInfoCollection AdminColl= SystemAdminProvider.getSystemAdminStatic();
			    StringBuilder sbAdmin=new StringBuilder();
			    
			    for(SystemAdminInfo admin:AdminColl)
			    {
			    	sbAdmin.append(String.format(
			    		"<option value=\"%1$s\">%2$s</option>\n", new Object[] { 
			    		Integer.valueOf(admin
			    		.getDatabaseadminid()), admin
			    		.getTruename() }));
			    }
				this.request.setAttribute("AdminIDEdit", sbAdmin.toString());
/*      */   }
/*      */ 
/*      */   protected void ListShow()
/*      */   {


/*  286 */     String OrderBy = "";
/*  287 */     String pageListOrderByItem = Requests.GetString(
/*  288 */       this.request, "OrderByItem", "EnterpriseID");
/*  289 */     String pageListOrderByItemDESC = Requests.GetString(
/*  290 */       this.request, "OrderByItemDESC", "DESC");
/*  291 */     if (pageListOrderByItem.length() > 0) {
/*  292 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, 
/*  293 */         pageListOrderByItemDESC });
/*      */     }
/*  295 */     String Enterprisename = Requests.GetString(this.request, 
/*  296 */       "enterprisenames", "");

try {
	Enterprisename=new String(Enterprisename.getBytes("ISO-8859-1"),"utf-8");
} catch (UnsupportedEncodingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
/*  297 */     int Businesstypeid = Requests.GetInt(this.request, 
/*  298 */       "businesstypeids", 0);
/*  299 */     String Legalperson = Requests.GetString(this.request, 
/*  300 */       "legalpersons", "");
try {
	Legalperson=new String(Legalperson.getBytes("ISO-8859-1"),"utf-8");
} catch (UnsupportedEncodingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
/*  301 */     int Regionid = 
/*  302 */       Requests.GetInt(this.request, "regionids", 0);
/*      */ 
/*  304 */     int pageIndex = Requests.GetInt(this.request, 
/*  305 */       this.pageParameter, 1);
/*  306 */     int pageAll = 0;
/*  307 */     pageAll = 
/*  308 */       EnterpriseProvider.GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(
/*  309 */       Enterprisename, Businesstypeid, Legalperson, Regionid);
			
/*  310 */     EnterpriseInfoCollection EnterpriseColl = 
/*  311 */       EnterpriseProvider.GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(
/*  312 */       Enterprisename, Businesstypeid, Legalperson, Regionid, 
/*  313 */       OrderBy, pageIndex, this.pageSize);
/*  314 */     this.request.setAttribute("EnterpriseList", EnterpriseColl);
/*      */ 
/*  321 */     String pageDetails = "";
/*  322 */     if (pageAll > this.pageSize) {
/*  323 */       pageDetails = Pager.LastNextPage(this.request, this.response, 
/*  324 */         this.pageParameter, this.pageSize, pageAll);
/*      */     }
/*  326 */     this.request.setAttribute("pageDetails", pageDetails);
/*      */   }
/*      */ 
/*      */   protected void ItemCommandEdit()
/*      */   {
/*  334 */     int Databaseenterpriseid = Requests.GetInt(this.request, 
/*  335 */       "databaseenterpriseid", 0);
/*      */ 
/*
/*      */ 
/*  339 */     EnterpriseInfo objEnterpriseInfo = 
/*  340 */       EnterpriseProvider.GetEnterpriseInfoByDatabaseenterpriseid(Databaseenterpriseid);
/*  341 */     if (objEnterpriseInfo != null) {
/*  342 */       this.request.setAttribute("Databaseenterpriseid", 
/*  343 */         Integer.valueOf(objEnterpriseInfo
/*  343 */         .getDatabaseenterpriseid()));
/*  344 */       this.request.setAttribute("Enterpriseid", 
/*  345 */         Integer.valueOf(objEnterpriseInfo
/*  345 */         .getEnterpriseid()));
/*  346 */       this.request.setAttribute("Enterprisename", 
/*  347 */         StringFormat.HtmlEncode(objEnterpriseInfo
/*  348 */         .getEnterprisename()));
/*  349 */       this.request.setAttribute("Businesstypeid", 
/*  350 */         Integer.valueOf(objEnterpriseInfo
/*  350 */         .getBusinesstypeid()));
/*  351 */       this.request.setAttribute("Legalperson", 
/*  352 */         StringFormat.HtmlEncode(objEnterpriseInfo.getLegalperson()));
/*      */ 
/*  354 */       this.request.setAttribute("Createtime", 
/*  355 */         Converts.DateToString(objEnterpriseInfo.getCreatetime(), 
/*  356 */         "yyyy-MM-dd"));
/*  357 */       this.request.setAttribute("Regionid", Integer.valueOf(objEnterpriseInfo.getRegionid()));
/*      */ 
/*  359 */       this.request.setAttribute("Address", 
/*  360 */         StringFormat.HtmlEncode(objEnterpriseInfo.getAddress()));
/*      */ 
/*  362 */       this.request.setAttribute("Enterprisecode", 
/*  363 */         StringFormat.HtmlEncode(objEnterpriseInfo
/*  364 */         .getEnterprisecode()));
/*  365 */       this.request.setAttribute("Partentcode", 
/*  366 */         StringFormat.HtmlEncode(objEnterpriseInfo.getPartentcode()));
/*      */ 
/*  368 */       this.request.setAttribute("Scope", 
/*  369 */         StringFormat.HtmlEncode(objEnterpriseInfo.getScope()));
/*      */ 
/*  371 */       this.request.setAttribute("Registaddress", 
/*  372 */         StringFormat.HtmlEncode(objEnterpriseInfo.getRegistaddress()));
/*      */ 
/*  374 */       this.request.setAttribute("Registfund", 
/*  375 */         StringFormat.HtmlEncode(objEnterpriseInfo.getRegistfund()));
/*      */ 
/*  377 */       this.request.setAttribute("Area", 
/*  378 */         StringFormat.HtmlEncode(objEnterpriseInfo.getArea()));
/*      */ 
/*  380 */       this.request.setAttribute("Toalinvest", 
/*  381 */         StringFormat.HtmlEncode(objEnterpriseInfo.getToalinvest()));
/*      */ 
/*  383 */       this.request.setAttribute("Qualityid", Integer.valueOf(objEnterpriseInfo.getQualityid()));
/*      */ 
/*  385 */       this.request.setAttribute("Employnumber", 
/*  386 */         Integer.valueOf(objEnterpriseInfo
/*  386 */         .getEmploynumber()));
/*  387 */       this.request.setAttribute("Producevalue", 
/*  388 */        objEnterpriseInfo
/*  388 */         .getProducevalue());
/*  389 */       this.request.setAttribute("Profit", objEnterpriseInfo.getProfit());
/*      */ 
/*  391 */       this.request.setAttribute("Feature", 
/*  392 */         StringFormat.HtmlEncode(objEnterpriseInfo.getFeature()));
/*      */ 
/*  394 */       this.request.setAttribute("Obtainhonor", 
/*  395 */         StringFormat.HtmlEncode(objEnterpriseInfo.getObtainhonor()));
/*      */ 
/*  397 */       this.request.setAttribute("Socialbenefit", 
/*  398 */         StringFormat.HtmlEncode(objEnterpriseInfo.getSocialbenefit()));
/*      */ 
/*  400 */       this.request.setAttribute("Peopleid1", Integer.valueOf(objEnterpriseInfo.getPeopleid1()));
				
/*      */ 
/*  402 */       this.request.setAttribute("Peopleid2", Integer.valueOf(objEnterpriseInfo.getPeopleid2()));
/*      */ 
/*  404 */       this.request.setAttribute("Adminid", Integer.valueOf(objEnterpriseInfo.getAdminid()));
/*      */ 
/*  406 */       this.request.setAttribute("Sectorid", Integer.valueOf(objEnterpriseInfo.getSectorid()));
/*      */ 
/*  408 */       this.request.setAttribute("Logintime", 
/*  409 */         Converts.DateToString(objEnterpriseInfo.getLogintime(), 
/*  410 */         "yyyy-MM-dd"));
				 this.request.setAttribute("objSystemAdminInfoByPeopleid1.truename", objEnterpriseInfo.getObjSystemAdminInfoByPeopleid1().getTruename());
				 this.request.setAttribute("objSystemAdminInfoByPeopleid2.truename", objEnterpriseInfo.getObjSystemAdminInfoByPeopleid2().getTruename());
				 this.request.setAttribute("Linkphone",objEnterpriseInfo.getLinkphone());
				 this.request.setAttribute("Contact",objEnterpriseInfo.getContact());
/*      */     }
/*      */     else {
/*  413 */       String js = Javascript.AlertAndRedirect(this.request, 
/*  414 */         this.response, "内容不存在", "?" + pageListUrl);
/*  415 */       this.request.setAttribute("pageJavaScripStar", js);
/*      */     }
/*      */   }
/*      */ 
/*      */   protected void ItemCommandDetails()
/*      */   {
/*  424 */     int Databaseenterpriseid = Requests.GetInt(this.request, 
/*  425 */       "databaseenterpriseid", 0);
/*      */ 

/*      */ 
/*  429 */     EnterpriseInfo objEnterpriseInfo = 
/*  430 */       EnterpriseProvider.GetEnterpriseInfoByDatabaseenterpriseid(Databaseenterpriseid);
/*  431 */     if (objEnterpriseInfo != null) {
/*  432 */       this.request.setAttribute("Databaseenterpriseid", 
/*  433 */         Integer.valueOf(objEnterpriseInfo
/*  433 */         .getDatabaseenterpriseid()));
/*  434 */       this.request.setAttribute("Enterpriseid", 
/*  435 */         Integer.valueOf(objEnterpriseInfo
/*  435 */         .getEnterpriseid()));
/*  436 */       this.request.setAttribute("Enterprisename", objEnterpriseInfo
/*  437 */         .getEnterprisename());
/*  438 */       this.request.setAttribute("Businesstypeid", 
/*  439 */         Integer.valueOf(objEnterpriseInfo
/*  439 */         .getBusinesstypeid()));
/*  440 */       this.request.setAttribute("Legalperson", objEnterpriseInfo
/*  441 */         .getLegalperson());
/*  442 */       this.request.setAttribute("Createtime", 
/*  443 */         Converts.DateToString(objEnterpriseInfo.getCreatetime(), 
/*  444 */         "yyyy-MM-dd"));
/*  445 */       this.request.setAttribute("Regionid", objEnterpriseInfo.getObjRegionsInfoByRegionid().getRegionname());
/*      */ 		 
/*  447 */       this.request.setAttribute("Address", objEnterpriseInfo.getAddress());
/*      */ 
/*  449 */       this.request.setAttribute("Enterprisecode", objEnterpriseInfo
/*  450 */         .getEnterprisecode());
/*  451 */       this.request.setAttribute("Partentcode", objEnterpriseInfo
/*  452 */         .getPartentcode());
/*  453 */       this.request.setAttribute("Scope", objEnterpriseInfo.getScope());
/*      */ 
/*  455 */       this.request.setAttribute("Registaddress", objEnterpriseInfo
/*  456 */         .getRegistaddress());
/*  457 */       this.request.setAttribute("Registfund", objEnterpriseInfo
/*  458 */         .getRegistfund());
/*  459 */       this.request.setAttribute("Area", objEnterpriseInfo.getArea());
/*      */ 
/*  461 */       this.request.setAttribute("Toalinvest", objEnterpriseInfo
/*  462 */         .getToalinvest());
/*  463 */       this.request.setAttribute("Qualityid", Integer.valueOf(objEnterpriseInfo.getQualityid()));
/*      */ 		  this.request.setAttribute("Qualityname",objEnterpriseInfo.getObjEnterpristQualityInfoByQualityid().getQualityname());
/*  465 */       this.request.setAttribute("Employnumber", 
/*  466 */         Integer.valueOf(objEnterpriseInfo
/*  466 */         .getEmploynumber()));
/*  467 */       this.request.setAttribute("Producevalue", 
/*  468 */         objEnterpriseInfo
/*  468 */         .getProducevalue());
/*  469 */       this.request.setAttribute("Profit", objEnterpriseInfo.getProfit());
/*      */ 
/*  471 */       this.request.setAttribute("Feature", objEnterpriseInfo.getFeature());
/*      */ 
/*  473 */       this.request.setAttribute("Obtainhonor", objEnterpriseInfo
/*  474 */         .getObtainhonor());
/*  475 */       this.request.setAttribute("Socialbenefit", objEnterpriseInfo
/*  476 */         .getSocialbenefit());
/*  477 */       this.request.setAttribute("Peopleid1", Integer.valueOf(objEnterpriseInfo.getPeopleid1()));
/*      */ 
/*  479 */       this.request.setAttribute("Peopleid2", Integer.valueOf(objEnterpriseInfo.getPeopleid2()));
/*      */ 
/*  481 */       this.request.setAttribute("Adminid", Integer.valueOf(objEnterpriseInfo.getAdminid()));
/*      */ 
/*  483 */       this.request.setAttribute("Sectorid", Integer.valueOf(objEnterpriseInfo.getSectorid()));
/*      */ 
/*  485 */       this.request.setAttribute("Logintime", 
/*  486 */         Converts.DateToString(objEnterpriseInfo.getLogintime(), 
/*  487 */         "yyyy-MM-dd"));
/*      */ 
/*  491 */       this.request.setAttribute("PeoplenameByPeopleid1", objEnterpriseInfo
/*  492 */         .getObjSystemAdminInfoByPeopleid1().getTruename());
/*      */ 
/*  494 */       this.request.setAttribute("PeoplenameByPeopleid2", objEnterpriseInfo
/*  495 */         .getObjSystemAdminInfoByPeopleid2().getTruename());
/*      */ 
/*  497 */       this.request.setAttribute("TruenameByAdminid", objEnterpriseInfo
/*  498 */         .getObjSystemAdminInfoByAdminid().getTruename());
/*      */ 
/*  500 */       this.request.setAttribute("SectornameBySectorid", objEnterpriseInfo
/*  501 */         .getObjSystemSectorInfoBySectorid().getSectorname());

				this.request.setAttribute("Linkphone",objEnterpriseInfo.getLinkphone());
				this.request.setAttribute("Contact",objEnterpriseInfo.getContact());
				this.request.setAttribute("ProfessionByBusinessTypeId", objEnterpriseInfo.getObjProfessionInfoByBusinesstypeid().getBusinesstypename());
/*      */      
				}
/*      */     else {
/*  504 */       String js = Javascript.AlertAndRedirect(this.request, 
/*  505 */         this.response, "内容不存在", "?" + pageListUrl);
/*  506 */       this.request.setAttribute("pageJavaScripStar", js);
/*      */     }
/*      */   }
/*      */ 
///*      */   protected boolean ServerValidate()
///*      */   {
///*  514 */     StringBuilder sbStr = new StringBuilder(1024);
///*  515 */     int i = 1;
///*      */ 
///*  534 */     if (Requests.GetString(this.request, "peopleid1").length() == 0) {
///*  535 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "统计人员" }));
///*  536 */       i++;
///*      */     }
///*      */ 
///*  539 */     if (!Validate.IsNumber(
///*  540 */       Requests.GetString(this.request, "peopleid1"))) {
///*  541 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "统计人员" }));
///*  542 */       i++;
///*      */     }
///*      */ 
///*  546 */     if (Requests.GetString(this.request, "peopleid2").length() == 0) {
///*  547 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "填表人员" }));
///*  548 */       i++;
///*      */     }
///*      */ 
///*  551 */     if (!Validate.IsNumber(
///*  552 */       Requests.GetString(this.request, "peopleid2"))) {
///*  553 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "填表人员" }));
///*  554 */       i++;
///*      */     }
///*      */ 
///*  558 */     if (Requests.GetString(this.request, "adminid").length() == 0) {
///*  559 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "登录人员" }));
///*  560 */       i++;
///*      */     }
///*      */ 
///*  563 */     if (!Validate.IsNumber(
///*  564 */       Requests.GetString(this.request, "adminid"))) {
///*  565 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "登录人员" }));
///*  566 */       i++;
///*      */     }
///*      */ 
///*  570 */     if (Requests.GetString(this.request, "sectorid").length() == 0) {
///*  571 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "部门" }));
///*  572 */       i++;
///*      */     }
///*  574 */     if (!Validate.IsNumber(
///*  575 */       Requests.GetString(this.request, "sectorid"))) {
///*  576 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "部门" }));
///*  577 */       i++;
///*      */     }
///*      */ 
///*  581 */   
///*      */ 
///*  594 */     if (Requests.GetString(this.request, "enterpriseid")
///*  595 */       .length() == 0) {
///*  596 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "企业编号" }));
///*  597 */       i++;
///*      */     }
///*      */ 
///*  600 */     if (!Validate.IsNumber(
///*  601 */       Requests.GetString(this.request, "enterpriseid"))) {
///*  602 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "企业编号" }));
///*  603 */       i++;
///*      */     }
///*      */ 
///*  607 */     if (Requests.GetString(this.request, "enterprisename")
///*  608 */       .length() == 0) {
///*  609 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "企业名称" }));
///*  610 */       i++;
///*      */     }
///*      */ 
///*  613 */     if (Validate.getLength(
///*  613 */       Requests.GetString(this.request, "enterprisename")) > 50) {
///*  614 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "企业名称" }));
///*  615 */       i++;
///*      */     }
///*      */ 
///*  619 */     if (Requests.GetString(this.request, "businesstypeid")
///*  620 */       .length() == 0) {
///*  621 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "行业类型" }));
///*  622 */       i++;
///*      */     }
///*      */ 
///*  625 */     if (!Validate.IsNumber(
///*  626 */       Requests.GetString(this.request, "businesstypeid"))) {
///*  627 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "行业类型" }));
///*  628 */       i++;
///*      */     }
///*      */ 
///*  632 */     if (Requests.GetString(this.request, "legalperson")
///*  633 */       .length() == 0) {
///*  634 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "法人" }));
///*  635 */       i++;
///*      */     }
///*      */ 
///*  638 */     if (Validate.getLength(
///*  638 */       Requests.GetString(this.request, "legalperson")) > 50) {
///*  639 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "法人" }));
///*  640 */       i++;
///*      */     }
///*      */ 
///*  657 */     if (Requests.GetString(this.request, "regionid").length() == 0) {
///*  658 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "所属区域" }));
///*  659 */       i++;
///*      */     }
///*      */ 
///*  662 */     if (!Validate.IsNumber(
///*  663 */       Requests.GetString(this.request, "regionid"))) {
///*  664 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "所属区域" }));
///*  665 */       i++;
///*      */     }
///*      */ 
///*  669 */     if (Requests.GetString(this.request, "address").length() == 0) {
///*  670 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "企业地址" }));
///*  671 */       i++;
///*      */     }
///*      */ 
///*  674 */     if (Validate.getLength(
///*  674 */       Requests.GetString(this.request, "address")) > 50) {
///*  675 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "企业地址" }));
///*  676 */       i++;
///*      */     }
///*      */ 
///*  680 */     if (Requests.GetString(this.request, "enterprisecode")
///*  681 */       .length() == 0) {
///*  682 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "工商登记号" }));
///*  683 */       i++;
///*      */     }
///*      */ 
///*  686 */     if (Validate.getLength(
///*  686 */       Requests.GetString(this.request, "enterprisecode")) > 50) {
///*  687 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "工商登记号" }));
///*  688 */       i++;
///*      */     }
///*  690 */     if (!Validate.IsNumber(
///*  691 */       Requests.GetString(this.request, "enterprisecode"))) {
///*  692 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "工商登记号" }));
///*  693 */       i++;
///*      */     }
///*      */ 
///*  697 */     if (Requests.GetString(this.request, "partentcode")
///*  698 */       .length() != 0)
///*      */     {
///*  703 */       if (Validate.getLength(
///*  703 */         Requests.GetString(this.request, "partentcode")) > 50) {
///*  704 */         sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "产品专利号" }));
///*  705 */         i++;
///*      */       }
///*      */ 
///*      */     }
///*      */ 
///*  710 */     if (Requests.GetString(this.request, "scope").length() == 0) {
///*  711 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "经营范围" }));
///*  712 */       i++;
///*      */     }
///*      */ 
///*  715 */     if (Validate.getLength(
///*  715 */       Requests.GetString(this.request, "scope")) > 50) {
///*  716 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), "经营范围" }));
///*  717 */       i++;
///*      */     }
///*      */ 
///*  721 */     if (Requests.GetString(this.request, "registaddress")
///*  722 */       .length() != 0)
///*      */     {
///*  725 */       if (Validate.getLength(
///*  725 */         Requests.GetString(this.request, "registaddress")) > 50) {
///*  726 */         sbStr
///*  727 */           .append(String.format("%1$s.%2$s的长度不能大于50\n", new Object[] { Integer.valueOf(i), 
///*  728 */           "企业注册地址" }));
///*  729 */         i++;
///*      */       }
///*      */ 
///*      */     }
///*      */ 
///*  734 */     if (Requests.GetString(this.request, "registfund").length() == 0) {
///*  735 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "注册资金" }));
///*  736 */       i++;
///*      */     }
///*      */ 
///*  739 */     if (Validate.getLength(
///*  739 */       Requests.GetString(this.request, "registfund")) > 20) {
///*  740 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于20\n", new Object[] { Integer.valueOf(i), "注册资金" }));
///*  741 */       i++;
///*      */     }
///*  743 */     if (!Validate.IsNumber(
///*  744 */       Requests.GetString(this.request, "registfund"))) {
///*  745 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "注册资金" }));
///*  746 */       i++;
///*      */     }
///*      */ 
///*  750 */     if (Requests.GetString(this.request, "area").length() == 0) {
///*  751 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "占地面积" }));
///*  752 */       i++;
///*      */     }
///*      */ 
///*  755 */     if (Validate.getLength(
///*  755 */       Requests.GetString(this.request, "area")) > 20) {
///*  756 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于20\n", new Object[] { Integer.valueOf(i), "占地面积" }));
///*  757 */       i++;
///*      */     }
///*  759 */     if (!Validate.IsNumber(
///*  760 */       Requests.GetString(this.request, "area"))) {
///*  761 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "占地面积" }));
///*  762 */       i++;
///*      */     }
///*      */ 
///*  766 */     if (Requests.GetString(this.request, "toalinvest").length() == 0) {
///*  767 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "总投资" }));
///*  768 */       i++;
///*      */     }
///*      */ 
///*  771 */     if (Validate.getLength(
///*  771 */       Requests.GetString(this.request, "toalinvest")) > 20) {
///*  772 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于20\n", new Object[] { Integer.valueOf(i), "总投资" }));
///*  773 */       i++;
///*      */     }
///*  775 */     if (!Validate.IsNumber(
///*  776 */       Requests.GetString(this.request, "toalinvest"))) {
///*  777 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "总投资" }));
///*  778 */       i++;
///*      */     }
///*      */ 
///*  782 */     if (Requests.GetString(this.request, "qualityid").length() == 0) {
///*  783 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "企业性质" }));
///*  784 */       i++;
///*      */     }
///*      */ 
///*  787 */     if (!Validate.IsNumber(
///*  788 */       Requests.GetString(this.request, "qualityid"))) {
///*  789 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "企业性质" }));
///*  790 */       i++;
///*      */     }
///*      */ 
///*  794 */     if (Requests.GetString(this.request, "employnumber")
///*  795 */       .length() == 0) {
///*  796 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "就业人数" }));
///*  797 */       i++;
///*      */     }
///*      */ 
///*  800 */     if (!Validate.IsNumber(
///*  801 */       Requests.GetString(this.request, "employnumber"))) {
///*  802 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "就业人数" }));
///*  803 */       i++;
///*      */     }
///*      */ 
///*  807 */     if (Requests.GetString(this.request, "producevalue")
///*  808 */       .length() == 0) {
///*  809 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "年产值" }));
///*  810 */       i++;
///*      */     }
///*      */ 
///*  813 */     if (!Validate.IsNumber(
///*  814 */       Requests.GetString(this.request, "producevalue"))) {
///*  815 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "年产值" }));
///*  816 */       i++;
///*      */     }
///*  818 */     if (!Validate.IsNumber(
///*  819 */       Requests.GetString(this.request, "producevalue"))) {
///*  820 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "年产值" }));
///*  821 */       i++;
///*      */     }
///*      */ 
///*  825 */     if (Requests.GetString(this.request, "profit").length() == 0) {
///*  826 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "利润" }));
///*  827 */       i++;
///*      */     }
///*      */ 
///*  830 */     if (!Validate.IsNumber(
///*  831 */       Requests.GetString(this.request, "profit"))) {
///*  832 */       sbStr.append(String.format("%1$s.您的%2$s写错了，请修改\n", new Object[] { Integer.valueOf(i), "利润" }));
///*  833 */       i++;
///*      */     }
///*      */ 
///*  837 */     if (Requests.GetString(this.request, "feature").length() == 0) {
///*  838 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "产品特色" }));
///*  839 */       i++;
///*      */     }
///*      */ 
///*  842 */     if (Validate.getLength(
///*  842 */       Requests.GetString(this.request, "feature")) > 500) {
///*  843 */       sbStr.append(String.format("%1$s.%2$s的长度不能大于500\n", new Object[] { Integer.valueOf(i), "产品特色" }));
///*  844 */       i++;
///*      */     }
///*      */ 
///*  848 */     if (Requests.GetString(this.request, "obtainhonor")
///*  849 */       .length() != 0)
///*      */     {
///*  852 */       if (Validate.getLength(
///*  852 */         Requests.GetString(this.request, "obtainhonor")) > 500) {
///*  853 */         sbStr.append(String.format("%1$s.%2$s的长度不能大于500\n", new Object[] { Integer.valueOf(i), "获得荣誉" }));
///*  854 */         i++;
///*      */       }
///*      */ 
///*      */     }
///*      */ 
///*  859 */     if (Requests.GetString(this.request, "socialbenefit")
///*  860 */       .length() != 0)
///*      */     {
///*  863 */       if (Validate.getLength(
///*  863 */         Requests.GetString(this.request, "socialbenefit")) > 500) {
///*  864 */         sbStr.append(String.format("%1$s.%2$s的长度不能大于500\n", new Object[] { Integer.valueOf(i), "社会效益" }));
///*  865 */         i++;
///*      */       }
///*      */ 
///*      */     }
//
////联系电话验证
//
//if (Requests.GetString(this.request, "linkphone").length() == 0) {
//	/*  826 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "联系电话" }));
//	/*  827 */       i++;
//	/*      */     }
//					  if (Requests.GetString(this.request, "linkphone")
//		/*  849 */       .length() != 0)
//		/*      */     {
//		/*  852 */       if (Validate.getLength(
//		/*  852 */         Requests.GetString(this.request, "linkphone")) > 500) {
//		/*  853 */         sbStr.append(String.format("%1$s.%2$s的长度不能大于500\n", new Object[] { Integer.valueOf(i), "联系电话" }));
//		/*  854 */         i++;
//		/*      */       }
//		/*      */ 
//		/*      */     }
//
//		
//		
//		
///*      */ 
///*  871 */     if (i - 1 > 0) {
///*  872 */       sbStr.append("总共有" + (i - 1) + "个错误");
///*  873 */       String js = Javascript.Alert(this.request, this.response, 
///*  874 */         sbStr.toString());
///*  875 */       this.request.setAttribute("pageJavaScripEnd", js);
///*  876 */       if (Requests.GetInt(this.request, "isSaveAndNew") == 1) {
///*  877 */         this.request.setAttribute("btnEditCommandArgument", 
///*  878 */           Pager.getCurrentlyPage(this.request, 
///*  879 */           "pagetype", "insert"));
///*      */       }
///*  881 */       return false;
///*      */     }
///*  883 */     return true;
///*      */   }
/*      */ 
// [start] ServerValidate 服务器验证
protected boolean ServerValidate()
{
    java.util.HashMap<String,Object> valueMap = new java.util.HashMap<String,Object>();
    StringBuilder sbStr = new StringBuilder(1024);
    int i = 1;
   
    // [start] 企业编号
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "企业编号");
    if (com.colorwinglib.Requests.GetString(request, "enterpriseid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "enterpriseid")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "enterpriseid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    EnterpriseInfoCollection ec=EnterpriseProvider.GetListByEnterpriseid(Requests.GetInt(this.request, "enterpriseid"));
    if(ec.size()>0)
    {
    	EnterpriseInfo enterprise=ec.get(0);
    	if(enterprise.getDatabaseenterpriseid()!=Requests.GetInt(this.request, "databaseenterpriseid"))
    	{
    		 valueMap.put("param1", Requests.GetInt(request, "enterpriseid"));
	         sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000015, valueMap)));
	         i = i + 1;
    	}
    }

  
    // [end]
    // [start] 企业名称
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "企业名称");
    if (com.colorwinglib.Requests.GetString(request, "enterprisename").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "enterprisename")) > 50)
    {
        valueMap.put("N", 50);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 行业类型
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "行业类型");
    if (com.colorwinglib.Requests.GetString(request, "businesstypeid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "businesstypeid")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "businesstypeid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 法人
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "法人");
    if (com.colorwinglib.Requests.GetString(request, "legalperson").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "legalperson")) > 50)
    {
        valueMap.put("N", 50);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 创立时间
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "创立时间");
    if (com.colorwinglib.Requests.GetString(request, "createtime").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsDateString(com.colorwinglib.Requests.GetString(request, "createtime")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 所属区域
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "所属区域");
    if (com.colorwinglib.Requests.GetString(request, "regionid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "regionid")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "regionid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 企业地址
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "企业地址");
    if (com.colorwinglib.Requests.GetString(request, "address").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "address")) > 50)
    {
        valueMap.put("N", 50);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 工商登记号
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "工商登记号");
    if (com.colorwinglib.Requests.GetString(request, "enterprisecode").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "enterprisecode")) > 50)
    {
        valueMap.put("N", 50);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 产品专利号
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "产品专利号");
    if (com.colorwinglib.Requests.GetString(request, "partentcode").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "partentcode")) > 50)
    {
        valueMap.put("N", 50);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 经营范围
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "经营范围");
    if (com.colorwinglib.Requests.GetString(request, "scope").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "scope")) > 50)
    {
        valueMap.put("N", 50);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 企业注册地址
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "企业注册地址");
    if (com.colorwinglib.Requests.GetString(request, "registaddress").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "registaddress")) > 50)
    {
        valueMap.put("N", 50);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 注册资金
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "注册资金");
    if (com.colorwinglib.Requests.GetString(request, "registfund").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "registfund")) > 20)
    {
        valueMap.put("N", 20);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 占地面积
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "占地面积");
    if (com.colorwinglib.Requests.GetString(request, "area").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "area")) > 20)
    {
        valueMap.put("N", 20);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 总投资
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "总投资");
    if (com.colorwinglib.Requests.GetString(request, "toalinvest").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "toalinvest")) > 20)
    {
        valueMap.put("N", 20);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    } 
    // [end]
    // [start] 企业性质
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "企业性质");
    if (com.colorwinglib.Requests.GetString(request, "qualityid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "qualityid")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "qualityid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 就业人数
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "就业人数");
    if (com.colorwinglib.Requests.GetString(request, "employnumber").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "employnumber")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "employnumber")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 年产值
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "年产值");
    if (com.colorwinglib.Requests.GetString(request, "producevalue").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "producevalue")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "producevalue")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 利润
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "利润");
    if (com.colorwinglib.Requests.GetString(request, "profit").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "profit")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "profit")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 产品特色
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "产品特色");
    if (com.colorwinglib.Requests.GetString(request, "feature").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "feature")) > 500)
    {
        valueMap.put("N", 500);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 获得荣誉
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "获得荣誉");
    if (com.colorwinglib.Requests.GetString(request, "obtainhonor").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "obtainhonor")) > 500)
    {
        valueMap.put("N", 500);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 社会效益
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "社会效益");
    if (com.colorwinglib.Requests.GetString(request, "socialbenefit").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "socialbenefit")) > 500)
    {
        valueMap.put("N", 500);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 统计人员
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "统计人员");
    if (com.colorwinglib.Requests.GetString(request, "peopleid1").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "peopleid1")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "peopleid1")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 填表人员
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "填表人员");
    if (com.colorwinglib.Requests.GetString(request, "peopleid2").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "peopleid2")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "peopleid2")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 登录人员
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "登录人员");
    if (com.colorwinglib.Requests.GetString(request, "adminid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "adminid")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "adminid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 部门编号
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "部门编号");
    if (com.colorwinglib.Requests.GetString(request, "sectorid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "sectorid")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "sectorid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    
    // [start] 联系电话
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "联系电话");
    if (com.colorwinglib.Requests.GetString(request, "linkphone").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "linkphone")) > 50)
    {
        valueMap.put("N", 50);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 联系人
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "联系人");
    if (com.colorwinglib.Requests.GetString(request, "contact").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "contact")) > 50)
    {
        valueMap.put("N", 50);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    if (i-1 > 0)
    {
		valueMap = new java.util.HashMap<String, Object>();
		valueMap.put("n", (i - 1));
        sbStr.append(com.yun.common.Message.GetMessage(com.yun.common.Message.I0000006, valueMap));
        String js=" $('#error').html('<p>"+sbStr.toString()+"</p>');  \n  $('#error').dialog('open')";
		//String js = com.colorwinglib.Javascript.Alert(request, response, sbStr.toString());
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



/*      */   protected void insert()
/*      */   {

/*      */ 
/*  893 */    
/*  895 */     int Enterpriseid = Requests.GetInt(this.request, 
/*  896 */       "enterpriseid", 0);
/*  897 */     String Enterprisename = Requests.GetString(this.request, 
/*  898 */       "enterprisename", "");
/*  899 */     int Businesstypeid = Requests.GetInt(this.request, 
/*  900 */       "businesstypeid", 0);
/*  901 */     String Legalperson = Requests.GetString(this.request, 
/*  902 */       "legalperson", "");
/*  903 */     Date Createtime = Requests.GetDate(this.request, 
/*  904 */       "createtime", new Date());
/*  905 */     int Regionid = Requests.GetInt(this.request, "regionid", 0);
/*      */ 
/*  907 */     String Address = Requests.GetString(this.request, 
/*  908 */       "address", "");
/*  909 */     String Enterprisecode = Requests.GetString(this.request, 
/*  910 */       "enterprisecode", "");
/*  911 */     String Partentcode = Requests.GetString(this.request, 
/*  912 */       "partentcode", "");
/*  913 */     String Scope = 
/*  914 */       Requests.GetString(this.request, "scope", "");
/*  915 */     String Registaddress = Requests.GetString(this.request, 
/*  916 */       "registaddress", "");
/*  917 */     double Registfund = Requests.GetDouble(this.request, 
/*  918 */       "registfund",0d);
/*  919 */     int Area = Requests.GetInt(this.request, "area");
/*      */ 
/*  921 */     double Toalinvest = Requests.GetDouble(this.request, 
/*  922 */       "toalinvest");
/*  923 */     int Qualityid = Requests.GetInt(this.request, "qualityid", 
/*  924 */       0);
/*  925 */     int Employnumber = Requests.GetInt(this.request, 
/*  926 */       "employnumber", 0);
/*  927 */     double Producevalue = Requests.GetDouble(this.request, 
/*  928 */       "producevalue", 0d);
/*  929 */     double Profit = Requests.GetDouble(this.request, "profit", 0d);
/*      */ 
/*  931 */     String Feature = Requests.GetString(this.request, 
/*  932 */       "feature", "");
/*  933 */     String Obtainhonor = Requests.GetString(this.request, 
/*  934 */       "obtainhonor", "");
/*  935 */     String Socialbenefit = Requests.GetString(this.request, 
/*  936 */       "socialbenefit", "");
/*  937 */     int Peopleid1 = Requests.GetInt(this.request, "peopleid1", 
/*  938 */       0);
/*  939 */     int Peopleid2 = Requests.GetInt(this.request, "peopleid2", 
/*  940 */       0);
/*  941 */     int Adminid = Requests.GetInt(this.request, "adminid", 0);
/*      */ 
/*  943 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
/*      */ 		
/*  945 */     Date Logintime = Requests.GetDate(this.request, 
/*  946 */       "txtLogintimeEdit", new Date());
/*      */ 		String Linkphone=Requests.GetString(this.request, "linkphone","");
				String contact=Requests.GetString(this.request, "contact","");
/*  949 */     if (!ServerValidate())
/*      */     {
/*  951 */       DrpInit();
/*  952 */       
/*      */ 
/*  954 */       this.request.setAttribute("Enterpriseid", Integer.valueOf(Enterpriseid));
/*  955 */       this.request.setAttribute("Enterprisename", 
/*  956 */         StringFormat.HtmlEncode(Enterprisename));
/*      */ 
/*  958 */       this.request.setAttribute("Businesstypeid", Integer.valueOf(Businesstypeid));
/*      */ 
/*  960 */       this.request.setAttribute("Legalperson", 
/*  961 */         StringFormat.HtmlEncode(Legalperson));
				this.request.setAttribute("Createtime", this.request.getParameter("createtime"));
/*  964 */       this.request.setAttribute("Regionid", Integer.valueOf(Regionid));
/*  965 */       this.request.setAttribute("Address", 
/*  966 */         StringFormat.HtmlEncode(Address));
/*  967 */       this.request.setAttribute("Enterprisecode", 
/*  968 */         StringFormat.HtmlEncode(Enterprisecode));
/*      */ 
/*  970 */       this.request.setAttribute("Partentcode", 
/*  971 */         StringFormat.HtmlEncode(Partentcode));
/*  972 */       this.request.setAttribute("Scope", 
/*  973 */         StringFormat.HtmlEncode(Scope));
/*  974 */       this.request.setAttribute("Registaddress", 
/*  975 */         StringFormat.HtmlEncode(Registaddress));
/*  976 */       this.request.setAttribute("Registfund", 
/*  977 */         StringFormat.HtmlEncode(Registfund));
/*  978 */       this.request.setAttribute("Area", 
/*  979 */         StringFormat.HtmlEncode(Area));
/*  980 */       this.request.setAttribute("Toalinvest", 
/*  981 */         StringFormat.HtmlEncode(Toalinvest));
/*  982 */       this.request.setAttribute("Qualityid", Qualityid);
/*  983 */       this.request.setAttribute("Employnumber", Employnumber);
/*  984 */       this.request.setAttribute("Producevalue", Producevalue);
/*  985 */       this.request.setAttribute("Profit", Profit);
/*  986 */       this.request.setAttribute("Feature", 
/*  987 */         StringFormat.HtmlEncode(Feature));
/*  988 */       this.request.setAttribute("Obtainhonor", 
/*  989 */         StringFormat.HtmlEncode(Obtainhonor));
/*  990 */       this.request.setAttribute("Socialbenefit", 
/*  991 */         StringFormat.HtmlEncode(Socialbenefit));
/*  992 */       this.request.setAttribute("Peopleid1", Integer.valueOf(Peopleid1));
/*  993 */       this.request.setAttribute("Peopleid2", Integer.valueOf(Peopleid2));
/*  994 */       this.request.setAttribute("Adminid", Integer.valueOf(Adminid));
/*  995 */       this.request.setAttribute("Sectorid", Integer.valueOf(Sectorid));
/*  996 */       this.request.setAttribute("Logintime", 
/*  997 */         new SimpleDateFormat("yyyy-MM-dd").format(Logintime));
				 this.request.setAttribute("Linkphone", Linkphone);
				 this.request.setAttribute("contact", contact);
/*  998 */       return;
/*      */     }
/*      */ 
/* 1001 */     EnterpriseInfo objEnterpriseInfo = new EnterpriseInfo();
/* 1002 */     
/*      */ 
/* 1004 */     objEnterpriseInfo.setEnterpriseid(Enterpriseid);
/* 1005 */     objEnterpriseInfo.setEnterprisename(Enterprisename);
/* 1006 */     objEnterpriseInfo.setBusinesstypeid(Businesstypeid);
/* 1007 */     objEnterpriseInfo.setLegalperson(Legalperson);
/* 1008 */     objEnterpriseInfo.setCreatetime(Createtime);
/* 1009 */     objEnterpriseInfo.setRegionid(Regionid);
/* 1010 */     objEnterpriseInfo.setAddress(Address);
/* 1011 */     objEnterpriseInfo.setEnterprisecode(Enterprisecode);
/* 1012 */     objEnterpriseInfo.setPartentcode(Partentcode);
/* 1013 */     objEnterpriseInfo.setScope(Scope);
/* 1014 */     objEnterpriseInfo.setRegistaddress(Registaddress);
/* 1015 */     objEnterpriseInfo.setRegistfund(Registfund);
/* 1016 */     objEnterpriseInfo.setArea(Area);
/* 1017 */     objEnterpriseInfo.setToalinvest(Toalinvest);
/* 1018 */     objEnterpriseInfo.setQualityid(Qualityid);
/* 1019 */     objEnterpriseInfo.setEmploynumber(Employnumber);
/* 1020 */     objEnterpriseInfo.setProducevalue(Producevalue);
/* 1021 */     objEnterpriseInfo.setProfit(Profit);
/* 1022 */     objEnterpriseInfo.setFeature(Feature);
/* 1023 */     objEnterpriseInfo.setObtainhonor(Obtainhonor);
/* 1024 */     objEnterpriseInfo.setSocialbenefit(Socialbenefit);
/* 1025 */     objEnterpriseInfo.setPeopleid1(Peopleid1);
/* 1026 */     objEnterpriseInfo.setPeopleid2(Peopleid2);
/* 1027 */     objEnterpriseInfo.setAdminid(Adminid);
/* 1028 */     objEnterpriseInfo.setSectorid(Sectorid);
/* 1029 */     objEnterpriseInfo.setLogintime(Logintime);
			   objEnterpriseInfo.setLinkphone(Linkphone);
/*      */ 	   objEnterpriseInfo.setContact(contact);
/* 1031 */     EnterpriseProvider.Insert(objEnterpriseInfo);
/*      */ 	   
/* 1033 */     String js = Javascript.AlertAndRedirect(this.request, 
/* 1034 */       this.response, "添加成功", "?pagetype=gotoinsert&" + pageListUrl);
/* 1035 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1) {
/* 1036 */       js = Javascript.AlertAndRedirect(this.request, 
/* 1037 */         this.response, "添加成功", "?pagetype=gotoinsert&" + pageListUrl);
/*      */     }
/* 1039 */     this.request.setAttribute("pageJavaScripStar", js);
/* 1040 */     EnterpriseProvider.setEnterpriseStatic(null);
/*      */   }
/*      */ 
/*      */   protected void update()
/*      */   {

/*      */ 
/* 1049 */     int Databaseenterpriseid = Requests.GetInt(this.request, 
/* 1050 */       "databaseenterpriseid", 0);
/* 1051 */     int Enterpriseid = Requests.GetInt(this.request, 
/* 1052 */       "enterpriseid", 0);
/* 1053 */     String Enterprisename = Requests.GetString(this.request, 
/* 1054 */       "enterprisename", "");
/* 1055 */     int Businesstypeid = Requests.GetInt(this.request, 
/* 1056 */       "businesstypeid", 0);
/* 1057 */     String Legalperson = Requests.GetString(this.request, 
/* 1058 */       "legalperson", "");
/* 1059 */     Date Createtime = Requests.GetDate(this.request, 
/* 1060 */       "createtime", new Date());
/* 1061 */     int Regionid = Requests.GetInt(this.request, "regionid", 0);
/*      */ 
/* 1063 */     String Address = Requests.GetString(this.request, 
/* 1064 */       "address", "");
/* 1065 */     String Enterprisecode = Requests.GetString(this.request, 
/* 1066 */       "enterprisecode", "");
/* 1067 */     String Partentcode = Requests.GetString(this.request, 
/* 1068 */       "partentcode", "");
/* 1069 */     String Scope = 
/* 1070 */       Requests.GetString(this.request, "scope", "");
/* 1071 */     String Registaddress = Requests.GetString(this.request, 
/* 1072 */       "registaddress", "");
/* 1073 */     double Registfund = Requests.GetDouble(this.request, 
/* 1074 */       "registfund", 0d);
/* 1075 */     int Area = Requests.GetInt(this.request, "area", 0);
/*      */ 
/* 1077 */     double Toalinvest = Requests.GetDouble(this.request, 
/* 1078 */       "toalinvest");
/* 1079 */     int Qualityid = Requests.GetInt(this.request, "qualityid", 
/* 1080 */       0);
/* 1081 */     int Employnumber = Requests.GetInt(this.request, 
/* 1082 */       "employnumber", 0);
/* 1083 */     double Producevalue = Requests.GetDouble(this.request, 
/* 1084 */       "producevalue", 0d);
/* 1085 */     double Profit = Requests.GetDouble(this.request, "profit", 0d);
/*      */ 
/* 1087 */     String Feature = Requests.GetString(this.request, 
/* 1088 */       "feature", "");
/* 1089 */     String Obtainhonor = Requests.GetString(this.request, 
/* 1090 */       "obtainhonor", "");
/* 1091 */     String Socialbenefit = Requests.GetString(this.request, 
/* 1092 */       "socialbenefit", "");
/* 1093 */     int Peopleid1 = Requests.GetInt(this.request, "peopleid1", 
/* 1094 */       0);
/* 1095 */     int Peopleid2 = Requests.GetInt(this.request, "peopleid2", 
/* 1096 */       0);
/* 1097 */     int Adminid = Requests.GetInt(this.request, "adminid", 0);
/*      */ 
/* 1099 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
/*      */ 
/* 1101 */     Date Logintime = Requests.GetDate(this.request, 
/* 1102 */       "logintime", new Date());
/*      */ 		String Linkphone=Requests.GetString(this.request, "linkphone","");
/*      */ 		String contact=Requests.GetString(this.request, "contact","");
/* 1105 */     if (!ServerValidate())
/*      */     {
/* 1107 */       DrpInit();
/* 1108 */       this.request.setAttribute("Databaseenterpriseid", Integer.valueOf(Databaseenterpriseid));
/*      */ 
/* 1110 */       this.request.setAttribute("Enterpriseid", Integer.valueOf(Enterpriseid));
/* 1111 */       this.request.setAttribute("Enterprisename", 
/* 1112 */         StringFormat.HtmlEncode(Enterprisename));
/*      */ 
/* 1114 */       this.request.setAttribute("Businesstypeid", Businesstypeid);
/*      */ 
/* 1116 */       this.request.setAttribute("Legalperson", 
/* 1117 */         StringFormat.HtmlEncode(Legalperson));
/* 1118 */       this.request.setAttribute("Createtime", 
/* 1119 */         new SimpleDateFormat("yyyy-MM-dd").format(Createtime));
/* 1120 */       this.request.setAttribute("Regionid", Regionid);
/* 1121 */       this.request.setAttribute("Address", 
/* 1122 */         StringFormat.HtmlEncode(Address));
/* 1123 */       this.request.setAttribute("Enterprisecode", 
/* 1124 */         StringFormat.HtmlEncode(Enterprisecode));
/*      */ 
/* 1126 */       this.request.setAttribute("Partentcode", 
/* 1127 */         StringFormat.HtmlEncode(Partentcode));
/* 1128 */       this.request.setAttribute("Scope", 
/* 1129 */         StringFormat.HtmlEncode(Scope));
/* 1130 */       this.request.setAttribute("Registaddress", 
/* 1131 */         StringFormat.HtmlEncode(Registaddress));
/* 1132 */       this.request.setAttribute("Registfund", 
/* 1133 */         StringFormat.HtmlEncode(Registfund));
/* 1134 */       this.request.setAttribute("Area", 
/* 1135 */         StringFormat.HtmlEncode(Area));
/* 1136 */       this.request.setAttribute("Toalinvest", 
/* 1137 */         StringFormat.HtmlEncode(Toalinvest));
/* 1138 */       this.request.setAttribute("Qualityid", Qualityid);
/* 1139 */       this.request.setAttribute("Employnumber", Employnumber);
/* 1140 */       this.request.setAttribute("Producevalue", Producevalue);
/* 1141 */       this.request.setAttribute("Profit", Profit);
/* 1142 */       this.request.setAttribute("Feature", 
/* 1143 */         StringFormat.HtmlEncode(Feature));
/* 1144 */       this.request.setAttribute("Obtainhonor", 
/* 1145 */         StringFormat.HtmlEncode(Obtainhonor));
/* 1146 */       this.request.setAttribute("Socialbenefit", 
/* 1147 */         StringFormat.HtmlEncode(Socialbenefit));
/* 1148 */       this.request.setAttribute("Peopleid1", Peopleid1);
/* 1149 */       this.request.setAttribute("Peopleid2", Peopleid2);
/* 1150 */       this.request.setAttribute("Adminid", Adminid);
/* 1151 */       this.request.setAttribute("Sectorid", Sectorid);
/* 1152 */       this.request.setAttribute("Logintime", 
/* 1153 */         new SimpleDateFormat("yyyy-MM-dd").format(Logintime));
				 this.request.setAttribute("Linkphone", Linkphone);
				 this.request.setAttribute("contact", contact);
/* 1154 */       return;
/*      */     }
/*      */ 
/* 1157 */     EnterpriseInfo objEnterpriseInfo = 
/* 1158 */       EnterpriseProvider.GetEnterpriseInfoByDatabaseenterpriseid(Databaseenterpriseid);
/* 1159 */     objEnterpriseInfo.setDatabaseenterpriseid(Databaseenterpriseid);
/*      */ 
/* 1161 */     objEnterpriseInfo.setEnterpriseid(Enterpriseid);
/* 1162 */     objEnterpriseInfo.setEnterprisename(Enterprisename);
/* 1163 */     objEnterpriseInfo.setBusinesstypeid(Businesstypeid);
/* 1164 */     objEnterpriseInfo.setLegalperson(Legalperson);
/* 1165 */     objEnterpriseInfo.setCreatetime(Createtime);
/* 1166 */     objEnterpriseInfo.setRegionid(Regionid);
/* 1167 */     objEnterpriseInfo.setAddress(Address);
/* 1168 */     objEnterpriseInfo.setEnterprisecode(Enterprisecode);
/* 1169 */     objEnterpriseInfo.setPartentcode(Partentcode);
/* 1170 */     objEnterpriseInfo.setScope(Scope);
/* 1171 */     objEnterpriseInfo.setRegistaddress(Registaddress);
/* 1172 */     objEnterpriseInfo.setRegistfund(Registfund);
/* 1173 */     objEnterpriseInfo.setArea(Area);
/* 1174 */     objEnterpriseInfo.setToalinvest(Toalinvest);
/* 1175 */     objEnterpriseInfo.setQualityid(Qualityid);
/* 1176 */     objEnterpriseInfo.setEmploynumber(Employnumber);
/* 1177 */     objEnterpriseInfo.setProducevalue(Producevalue);
/* 1178 */     objEnterpriseInfo.setProfit(Profit);
/* 1179 */     objEnterpriseInfo.setFeature(Feature);
/* 1180 */     objEnterpriseInfo.setObtainhonor(Obtainhonor);
/* 1181 */     objEnterpriseInfo.setSocialbenefit(Socialbenefit);
/* 1182 */     objEnterpriseInfo.setPeopleid1(Peopleid1);
/* 1183 */     objEnterpriseInfo.setPeopleid2(Peopleid2);
/* 1184 */     objEnterpriseInfo.setAdminid(Adminid);
/* 1185 */     objEnterpriseInfo.setSectorid(Sectorid);
/* 1186 */     objEnterpriseInfo.setLogintime(Logintime);
			   objEnterpriseInfo.setLinkphone(Linkphone);
/*      */ 		objEnterpriseInfo.setContact(contact);
/* 1189 */     EnterpriseProvider.UpdateByDatabaseenterpriseid(objEnterpriseInfo);
/*      */ 	 
/* 1191 */     String js = Javascript.Alert(this.request, this.response, "更新成功");

/* 1192 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1) {
/* 1193 */       js = Javascript.Alert(this.request, this.response, "更新成功");
/*      */     }
			 
/* 1196 */     this.request.setAttribute("pageJavaScripStar", js);
/* 1197 */     EnterpriseProvider.setEnterpriseStatic(null);
/*      */   }
/*      */ 
/*      */   protected void delete()
/*      */   {
/* 1205 */     int Databaseenterpriseid = Requests.GetInt(this.request, 
/* 1206 */       "databaseenterpriseid", 0);
/*      */ 
				
				if(IndustryProjectProvider.CountByDatabaseenterpriseid(Databaseenterpriseid)>0)
				{
					String js = Javascript.Alert(this.request, 
							this.response, "该企业下还有项目，不能删除");
							this.request.setAttribute("pageJavaScripStar", js);
				}
				else
				{
					EnterpriseProvider.DeleteByDatabaseenterpriseid(Databaseenterpriseid);
					EnterpriseProvider.setEnterpriseStatic(null);
					String js = Javascript.Alert(this.request, 
					this.response, "删除成功");
					this.request.setAttribute("pageJavaScripStar", js);
				}
/* 1211 */     
/*      */   }
/*      */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.enterprise.Enterprise
 * JD-Core Version:    0.6.0
 */