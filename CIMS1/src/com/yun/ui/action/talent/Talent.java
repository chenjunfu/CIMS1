/*     */ package com.yun.ui.action.talent;
/*     */ 
/*     */ import com.colorwinglib.Converts;
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.colorwinglib.Validate;
/*     */ import com.yun.bll.culture.CityinfoProvider;
/*     */ import com.yun.bll.culture.DegreeProvider;
/*     */ import com.yun.bll.culture.EducationProvider;
/*     */ import com.yun.bll.culture.MajorProvider;
/*     */ import com.yun.bll.culture.NationProvider;
/*     */ import com.yun.bll.culture.PeopleProvider;
/*     */ import com.yun.bll.culture.PostProvider;
import com.yun.bll.culture.ProfessionProvider;
/*     */ import com.yun.bll.culture.RolesCompetenceProvider;
/*     */ import com.yun.bll.culture.SystemAdminProvider;
/*     */ import com.yun.bll.culture.SystemSectorProvider;
/*     */ import com.yun.bll.culture.TalentProfessionProvider;
/*     */ import com.yun.bll.culture.TalentProvider;
/*     */ import com.yun.common.Pager;
/*     */ import com.yun.entities.culture.CityinfoInfo;
/*     */ import com.yun.entities.culture.DegreeInfo;
/*     */ import com.yun.entities.culture.EducationInfo;
/*     */ import com.yun.entities.culture.MajorInfo;
/*     */ import com.yun.entities.culture.NationInfo;
/*     */ import com.yun.entities.culture.PeopleInfo;
/*     */ import com.yun.entities.culture.PostInfo;
import com.yun.entities.culture.ProfessionInfo;
/*     */ import com.yun.entities.culture.SystemAdminInfo;
/*     */ import com.yun.entities.culture.SystemSectorInfo;
/*     */ import com.yun.entities.culture.TalentInfo;
/*     */ import com.yun.entities.culture.TalentProfessionInfo;
import com.yun.entities.culture.base.NationInfoBase;
/*     */ import com.yun.entities.culture.collection.CityinfoInfoCollection;
/*     */ import com.yun.entities.culture.collection.DegreeInfoCollection;
/*     */ import com.yun.entities.culture.collection.EducationInfoCollection;
/*     */ import com.yun.entities.culture.collection.MajorInfoCollection;
/*     */ import com.yun.entities.culture.collection.NationInfoCollection;
/*     */ import com.yun.entities.culture.collection.PeopleInfoCollection;
/*     */ import com.yun.entities.culture.collection.PostInfoCollection;
import com.yun.entities.culture.collection.ProfessionInfoCollection;
import com.yun.entities.culture.collection.SystemAdminInfoCollection;
/*     */ import com.yun.entities.culture.collection.TalentInfoCollection;
/*     */ import com.yun.entities.culture.collection.TalentProfessionInfoCollection;
/*     */ import com.yun.ui.action.UserLook;
/*     */ import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class Talent
/*     */ {
/*     */   private static final long serialVersionUID = 2011112123190253120L;
/*  22 */   public int pageSize = com.yun.configuration.WebConfig.PAGE_SIZE;
/*     */ 
/*  27 */   public String pageParameter = "page";
/*     */ 
/*  32 */   HttpServletRequest request = null;
/*     */ 
/*  36 */   HttpServletResponse response = null;
/*     */ 
/*  40 */   PrintWriter out = null;
/*     */ 
/*  42 */   private static boolean flag = false;
/*     */ 
/*  44 */   private static boolean flag2 = false;
/*     */   private static int rolesid;
/*     */ 	
/*     */   private String getpageListUrl()
/*     */   {
			  String params= com.yun.common.Pager.getCurrentlyParams(this.request);
/*  52 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/*  53 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "TalentID");
/*  54 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/*  55 */     String pageListOrderByItemDESCNo = pageListOrderByItemDESC.toLowerCase().equals("desc") ? "asc" : "desc";
/*  56 */     String pageListUrlOrderBy = String.format("%s%s=%s", new Object[] {params ,this.pageParameter, Integer.valueOf(pageIndex) });
/*  57 */     String pageListUrl = String.format("%s&OrderByItem=%s&OrderByItemDESC=%s", new Object[] { pageListUrlOrderBy, pageListOrderByItem, pageListOrderByItemDESC });
/*     */ 

/*     */ 
/*  65 */     this.request.setAttribute("pageListOrderByItem", pageListOrderByItem);
/*  66 */     this.request.setAttribute("pageListOrderByItemDESC", pageListOrderByItemDESC);
/*  67 */     this.request.setAttribute("pageListOrderByItemDESCNo", pageListOrderByItemDESCNo);
/*  68 */     this.request.setAttribute("pageListUrlOrderBy", pageListUrlOrderBy);
/*  69 */     this.request.setAttribute("pageListUrl", pageListUrl);
/*     */ 
/*  71 */     return pageListUrl;
/*     */   }
/*     */ 
String pageListUrl="";
/*     */   public String execute()
/*     */     throws Exception
/*     */   {
/*  82 */     this.request = ServletActionContext.getRequest();
/*  83 */     this.response = ServletActionContext.getResponse();
/*     */     UserLook userlook=new UserLook(this.request,this.response);
/*  85 */     String af = null;
/*  86 */     this.response.setCharacterEncoding("utf-8");
/*  87 */     this.out = this.response.getWriter();
/*  88 */     pageListUrl = getpageListUrl();
/*     */ 	 
/*  91 */    
/*     */ 
/*  93 */    
/*  94 */     
/*     */ 
/*  96 */     
/*     */ 
/*  99 */     String pageName = "Talent";
/* 100 */     String pagetype = Requests.GetString(this.request, "pagetype").toLowerCase();
/* 101 */     String select = Requests.GetString(this.request, "select").toLowerCase();
/*     */ 
/* 104 */     if (pagetype.equals("gotoinsert"))
/*     */     {
				
				
/* 106 */       
				userlook.seePageY("11");
/*     */ 		this.request.setAttribute("pageListUrl", "pagetype=select&state=1");
				this.request.setAttribute("title", "录入");
/* 111 */       this.request.setAttribute("btnEditText", "btnLog");
/* 112 */       this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "insert"));
/* 113 */       DrpInit();
/*     */ 
/* 115 */       
/*     */ 
/* 121 */       Date Logintime =  new Date();
/* 122 */       this.request.setAttribute("Logintime", new SimpleDateFormat("yyyy-MM-dd").format(Logintime));
/*     */ 
/* 124 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 126 */     else if (pagetype.equals("insert"))
/*     */     {	
				this.request.setAttribute("title", "录入");
/* 128 */       this.request.setAttribute("btnEditText", "btnLog");
/* 129 */       insert();
/* 130 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 132 */     else if (pagetype.equals("gotoupdate"))
/*     */     {
				userlook.seePageY("12");
/* 134 */       DrpInit();
/* 135 */       ItemCommandEdit();
this.request.setAttribute("title", "更新");
/* 136 */       this.request.setAttribute("btnEditText", "btnModify");
/* 137 */       this.request.setAttribute("btnEditCommandArgument", pageListUrl+"&pagetype=update");
				
/* 138 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 140 */     else if (pagetype.equals("update"))
/*     */     {
	this.request.setAttribute("title", "更新");
/* 142 */      
/* 143 */       update();
				DrpInit();
/* 135 */       ItemCommandEdit();
				this.request.setAttribute("title", "更新");
/* 136 */       this.request.setAttribute("btnEditText", "btnModify");
/* 137 */       this.request.setAttribute("btnEditCommandArgument", pageListUrl+"&pagetype=update");
/* 144 */       af = String.format("%sEdit", new Object[] { pageName });
/*     */     }
/* 146 */     else if (pagetype.equals("delete"))
/*     */     {	
				userlook.seePageY("15");
/* 148 */       delete();
				DrpInit();
				ListShow();
/* 149 */       af = String.format("%sModify", new Object[] { pageName });
/*     */     }
/* 151 */     else if (pagetype.equals("details"))
/*     */     {
/* 153 */       ItemCommandDetails();
/* 154 */       af = String.format("%sDetails", new Object[] { pageName });
/*     */     }
/* 156 */     else if (pagetype.equals("select"))
/*     */     {
/* 159 */       userlook.seePageY("13");
/*     */       
/* 164 */       DrpInit();
			
	 
		ListShow();

/* 166 */       af = "TalentList";
/*     */     }
/*     */   else
/*     */    {
/* 170 */       userlook.seePageY("13");
/* 175 */       DrpInit();

			if (Requests.GetString(this.request, "state").equals("1"))
			{		
					
					ListShow();
			}
			af = "TalentModify";
}			

/* 179 */     return af;
/*     */   }
/*     */ 
/*     */   protected void DrpInit()
/*     */   {
/* 190 */     NationInfoCollection NationColl = NationProvider.getNationStatic();
/* 191 */     NationColl.sort(NationInfoBase.NationColumnNameEnum.Nationid, true);
			  StringBuilder sbNationid = new StringBuilder(100);
/* 192 */     for (NationInfo objNationInfo : NationColl)
/*     */     {
/* 194 */       sbNationid.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { Integer.valueOf(objNationInfo.getNationdatabaseid()), objNationInfo.getNationname() }));
/*     */     }
/* 196 */     
/* 197 */     this.request.setAttribute("NationidEdit", sbNationid.toString());
/* 198 */     this.request.setAttribute("NationidList", sbNationid.toString());
/*     */ 
/* 202 */     CityinfoInfoCollection CityinfoColl = CityinfoProvider.getCityinfoStatic();
/* 203 */     StringBuilder sbProvinceid = new StringBuilder(100);
/* 204 */     for (CityinfoInfo objCityinfoInfo : CityinfoColl)
/*     */     {
/* 206 */       sbProvinceid.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { Integer.valueOf(objCityinfoInfo.getParentid()), Integer.valueOf(objCityinfoInfo.getParentid()) }));
/*     */     }
/* 208 */     
/* 209 */     this.request.setAttribute("ProvinceidEdit", sbProvinceid.toString());
/* 210 */     this.request.setAttribute("ProvinceidList", sbProvinceid.toString());
/*     */ 
/* 214 */     CityinfoInfoCollection CityinfoColl2 = CityinfoProvider.getCityinfoStatic();
/* 215 */     StringBuilder sbCityid = new StringBuilder(100);
/* 216 */     for (CityinfoInfo objCityinfoInfo : CityinfoColl2)
/*     */     {
/* 218 */       sbCityid.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { objCityinfoInfo.getCityname(), objCityinfoInfo.getCityname() }));
/*     */     }
/* 220 */    
/* 221 */     this.request.setAttribute("CityidEdit", sbCityid.toString());
/* 222 */     this.request.setAttribute("CityidList", sbCityid.toString());
/*     */ 
/* 226 */     EducationInfoCollection EducationColl = EducationProvider.getEducationStatic();
/* 227 */     StringBuilder sbEducationid = new StringBuilder(100);
/* 228 */     for (EducationInfo objEducationInfo : EducationColl)
/*     */     {
/* 230 */       sbEducationid.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { Integer.valueOf(objEducationInfo.getEducationdatabaseid()), objEducationInfo.getEducationname() }));
/*     */     }
/* 232 */    
/* 233 */     this.request.setAttribute("EducationidEdit", sbEducationid.toString());
/* 234 */     this.request.setAttribute("EducationidList", sbEducationid.toString());
/*     */ 
/* 238 */     DegreeInfoCollection DegreeColl = DegreeProvider.getDegreeStatic();
/* 239 */     StringBuilder sbDegreeid = new StringBuilder(100);
/* 240 */     for (DegreeInfo objDegreeInfo : DegreeColl)
/*     */     {
/* 242 */       sbDegreeid.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { Integer.valueOf(objDegreeInfo.getDegreedatabaseid()), objDegreeInfo.getDegreename() }));
/*     */     }
/* 244 */    
/* 245 */     this.request.setAttribute("DegreeidEdit", sbDegreeid.toString());
/* 246 */     this.request.setAttribute("DegreeidList", sbDegreeid.toString());
/*     */ 
/* 250 */     MajorInfoCollection MajorColl = MajorProvider.getMajorStatic();
/* 251 */     StringBuilder sbMajorid = new StringBuilder(100);
/* 252 */     for (MajorInfo objMajorInfo : MajorColl)
/*     */     {
/* 254 */       sbMajorid.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { Integer.valueOf(objMajorInfo.getMajordatabaseid()), objMajorInfo.getMajorname() }));
/*     */     }
/* 256 */     
/* 257 */     this.request.setAttribute("MajoridEdit", sbMajorid.toString());
/* 258 */     this.request.setAttribute("MajoridList", sbMajorid.toString());
/*     */ 

/*     */ 
/* 274 */     PostInfoCollection PostColl = PostProvider.getPostStatic();
/* 275 */     StringBuilder sbPosttitleid = new StringBuilder(100);
/* 276 */     for (PostInfo objPostInfo : PostColl)
/*     */     {
/* 278 */       sbPosttitleid.append(String.format("<option value=\"%1$s\">%2$s</option>\n", new Object[] { Integer.valueOf(objPostInfo.getTitledatabaseid()), objPostInfo.getTitlename() }));
/*     */     }
/* 280 */     
/* 281 */     this.request.setAttribute("PosttitleidEdit", sbPosttitleid.toString());
/* 282 */     this.request.setAttribute("PosttitleidList", sbPosttitleid.toString());
/*     */ 


SystemAdminInfoCollection AdminColl= SystemAdminProvider.getSystemAdminStatic();
StringBuilder sbAdmin=new StringBuilder();

for(SystemAdminInfo admin:AdminColl)
{
	sbAdmin.append(String.format(
		"<option value=\"%1$s\">%2$s</option>\n", new Object[] { 
		Integer.valueOf(admin
		.getAdminid()), admin
		.getTruename() }));
}
this.request.setAttribute("AdminIDEdit", sbAdmin.toString());

ProfessionInfoCollection ProfessionColl = 
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



/*     */   }
/*     */ 
/*     */   protected void ListShow()
/*     */   {
/* 314 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 316 */     String OrderBy = "";
/* 317 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "TalentID");
/* 318 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 319 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 321 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/* 323 */     String Talentname = Requests.GetString(this.request, "talentnames", "");
try {
	Talentname=new String(Talentname.getBytes("ISO-8859-1"),"utf-8");
} catch (UnsupportedEncodingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
/* 324 */     int Nationid = Requests.GetInt(this.request, "nationids", 0);
/* 325 */     int Educationid = Requests.GetInt(this.request, "educationids", 0);
/* 326 */     int Majorid = Requests.GetInt(this.request, "majorids", 0);
/* 327 */     int Posttitleid = Requests.GetInt(this.request, "posttitleids", 0);
/*     */ 
/* 329 */     String Whole = Requests.GetString(this.request, "whole", "");
/*     */ 
/* 332 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 333 */     int pageAll = 0;
/*     */ 
/* 335 */     if ((Talentname == "") && (Nationid == 0) && (Educationid == 0) && (Majorid == 0) && (Posttitleid == 0)) {
/* 336 */       flag2 = true;
/*     */     }
			  pageAll=TalentProvider.GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(Talentname, Nationid, Educationid, Majorid, Posttitleid);
/* 338 */     TalentInfoCollection TalentColl = TalentProvider.GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(Talentname, Nationid, Educationid, Majorid, Posttitleid, OrderBy, pageIndex, this.pageSize);
/* 339 */     
			  if ((!flag2) || (Whole.equals("yes"))) {
/* 340 */       this.request.setAttribute("TalentList", TalentColl);
/*     */     }
/*     */ 
/* 346 */     String pageDetails = "";

/* 347 */     if (pageAll > this.pageSize)
{	pageDetails = Pager.LastNextPage(this.request, this.response, this.pageParameter, this.pageSize, pageAll);
/*     */ 	
/* 349 */     this.request.setAttribute("pageDetails", pageDetails);
/* 350 */     flag2 = false;
}
/*     */   }
/*     */ 
/*     */   protected void ItemCommandEdit()
/*     */   {
/* 359 */     int Databasetalentid = Requests.GetInt(this.request, "databasetalentid", 0);
/*     */ 	 	
/* 361 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 363 */     TalentInfo objTalentInfo = TalentProvider.GetTalentInfoByDatabasetalentid(Databasetalentid);
/* 364 */     if (objTalentInfo != null)
/*     */     {
				this.request.setAttribute("Databasetalentid", objTalentInfo.getDatabasetalentid());
/* 366 */       this.request.setAttribute("Talentid", Integer.valueOf(objTalentInfo.getTalentid()));
/* 367 */       this.request.setAttribute("Talentname", StringFormat.HtmlEncode(objTalentInfo.getTalentname()));
/* 368 */       this.request.setAttribute("Sex", Integer.valueOf(objTalentInfo.getSex()));
/* 369 */       this.request.setAttribute("Birthday", Converts.DateToString(objTalentInfo.getBirthday(), "yyyy-MM-dd"));
/* 370 */       this.request.setAttribute("Nationid", Integer.valueOf(objTalentInfo.getNationid()));
/* 371 */       this.request.setAttribute("Nativeplace", StringFormat.HtmlEncode(objTalentInfo.getNativeplace()));
/* 372 */       this.request.setAttribute("Politicsstatus", StringFormat.HtmlEncode(objTalentInfo.getPoliticsstatus()));
/* 373 */       this.request.setAttribute("Provinceid", Integer.valueOf(objTalentInfo.getProvince()));
/* 374 */       this.request.setAttribute("Cityid", Integer.valueOf(objTalentInfo.getCityid()));
/* 375 */       this.request.setAttribute("Educationid", Integer.valueOf(objTalentInfo.getEducationid()));
/* 376 */       this.request.setAttribute("Degreeid", Integer.valueOf(objTalentInfo.getDegreeid()));
/* 377 */       this.request.setAttribute("Majorid", Integer.valueOf(objTalentInfo.getMajorid()));
/* 378 */       this.request.setAttribute("Learnexperience", StringFormat.HtmlEncode(objTalentInfo.getLearnexperience()));
/* 379 */       this.request.setAttribute("Workexperience", StringFormat.HtmlEncode(objTalentInfo.getWorkexperience()));
/* 380 */       this.request.setAttribute("Talentprofessionid", Integer.valueOf(objTalentInfo.getTalentprofessionid()));
/* 381 */       this.request.setAttribute("Acheivement", StringFormat.HtmlEncode(objTalentInfo.getAcheivement()));
/* 382 */       this.request.setAttribute("Honor", StringFormat.HtmlEncode(objTalentInfo.getHonor()));
/* 383 */       this.request.setAttribute("Skills", StringFormat.HtmlEncode(objTalentInfo.getSkills()));
/* 384 */       this.request.setAttribute("Posttitleid", Integer.valueOf(objTalentInfo.getPosttitleid()));
/* 385 */       this.request.setAttribute("Workunit", StringFormat.HtmlEncode(objTalentInfo.getWorkunit()));
/* 386 */       this.request.setAttribute("Adress", StringFormat.HtmlEncode(objTalentInfo.getAdress()));
/* 387 */       this.request.setAttribute("Movephone", StringFormat.HtmlEncode(objTalentInfo.getMovephone()));
/* 388 */       this.request.setAttribute("Email", StringFormat.HtmlEncode(objTalentInfo.getEmail()));
/* 389 */       this.request.setAttribute("Databasepeopleid1", Integer.valueOf(objTalentInfo.getDatabasepeopleid1()));
/* 390 */       this.request.setAttribute("Databasepeopleid2", Integer.valueOf(objTalentInfo.getDatabasepeopleid2()));
/* 391 */       this.request.setAttribute("Adminid", Integer.valueOf(objTalentInfo.getAdminid()));
/* 392 */       this.request.setAttribute("Sectorid", Integer.valueOf(objTalentInfo.getSectorid()));
/* 393 */       this.request.setAttribute("Logintime", Converts.DateToString(objTalentInfo.getLogintime(), "yyyy-MM-dd"));
/*     */     }
/*     */     else
/*     */     {
/* 398 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 399 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected void ItemCommandDetails()
/*     */   {
/* 409 */     int Databasetalentid = Requests.GetInt(this.request, "databasetalentid", 0);
/*     */ 	
/* 411 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 413 */     TalentInfo objTalentInfo = TalentProvider.GetTalentInfoByDatabasetalentid(Databasetalentid);
/* 414 */     if (objTalentInfo != null)
/*     */     {	
				this.request.setAttribute("Databasetalentid", objTalentInfo.getDatabasetalentid());
/* 416 */       this.request.setAttribute("Talentid", Integer.valueOf(objTalentInfo.getTalentid()));
/* 417 */       this.request.setAttribute("Talentname", objTalentInfo.getTalentname());
/* 418 */       this.request.setAttribute("Sex", Integer.valueOf(objTalentInfo.getSex()));
				this.request.setAttribute("Sexlabel", objTalentInfo.getSexlabel());
/* 419 */       this.request.setAttribute("Birthday", Converts.DateToString(objTalentInfo.getBirthday(), "yyyy-MM-dd"));
/* 420 */       this.request.setAttribute("Nationid", Integer.valueOf(objTalentInfo.getNationid()));
/* 421 */       this.request.setAttribute("Nativeplace", objTalentInfo.getNativeplace());
/* 422 */       this.request.setAttribute("Politicsstatus", objTalentInfo.getPoliticsstatus());
/* 423 */       this.request.setAttribute("Province", Integer.valueOf(objTalentInfo.getProvince()));
/* 424 */       this.request.setAttribute("Cityid", Integer.valueOf(objTalentInfo.getCityid()));
/* 425 */       this.request.setAttribute("Educationid", Integer.valueOf(objTalentInfo.getEducationid()));
/* 426 */       this.request.setAttribute("Degreeid", Integer.valueOf(objTalentInfo.getDegreeid()));
/* 427 */       this.request.setAttribute("Majorid", Integer.valueOf(objTalentInfo.getMajorid()));
/* 428 */       this.request.setAttribute("Learnexperience", objTalentInfo.getLearnexperience());
/* 429 */       this.request.setAttribute("Workexperience", objTalentInfo.getWorkexperience());
/* 430 */       this.request.setAttribute("Talentprofessionid", Integer.valueOf(objTalentInfo.getTalentprofessionid()));
/* 431 */       this.request.setAttribute("Acheivement", objTalentInfo.getAcheivement());
/* 432 */       this.request.setAttribute("Honor", objTalentInfo.getHonor());
/* 433 */       this.request.setAttribute("Skills", objTalentInfo.getSkills());
/* 434 */       this.request.setAttribute("Posttitleid", Integer.valueOf(objTalentInfo.getPosttitleid()));
/* 435 */       this.request.setAttribute("Workunit", objTalentInfo.getWorkunit());
/* 436 */       this.request.setAttribute("Adress", objTalentInfo.getAdress());
/* 437 */       this.request.setAttribute("Movephone", objTalentInfo.getMovephone());
/* 438 */       this.request.setAttribute("Email", objTalentInfo.getEmail());
/* 439 */       this.request.setAttribute("Databasepeopleid1", Integer.valueOf(objTalentInfo.getDatabasepeopleid1()));
/* 440 */       this.request.setAttribute("Databasepeopleid2", Integer.valueOf(objTalentInfo.getDatabasepeopleid2()));
/*     */ 
/* 443 */       SystemAdminInfo objSystemAdminInfo = SystemAdminProvider.GetSystemAdminInfoByDatabaseadminid(objTalentInfo.getAdminid());
/* 444 */       this.request.setAttribute("AdminName", objSystemAdminInfo.getAdminname());
/*     */ 
/* 446 */       this.request.setAttribute("Sectorid", Integer.valueOf(objTalentInfo.getSectorid()));
/* 447 */       this.request.setAttribute("Logintime", Converts.DateToString(objTalentInfo.getLogintime(), "yyyy-MM-dd"));
/*     */ 
/* 451 */       this.request.setAttribute("NationnameByNationid", objTalentInfo.getObjNationInfoByNationid().getNationname());
/* 452 */       this.request.setAttribute("CitynameByProvince", objTalentInfo.getObjProvinceInfoByProvinceid().getCityname());
/* 453 */       this.request.setAttribute("CitynameByCityid", objTalentInfo.getObjCityinfoInfoByCityid().getCityname());
/* 454 */       this.request.setAttribute("EducationnameByEducationid", objTalentInfo.getObjEducationInfoByEducationid().getEducationname());
/* 455 */       this.request.setAttribute("DegreenameByDegreeid", objTalentInfo.getObjDegreeInfoByDegreeid().getDegreename());
/* 456 */       this.request.setAttribute("MajornameByMajorid", objTalentInfo.getObjMajorInfoByMajorid().getMajorname());
/* 457 */       this.request.setAttribute("TitlenameByPosttitleid", objTalentInfo.getObjPostInfoByPosttitleid().getTitlename());
/*     */ 
/* 459 */       this.request.setAttribute("TalentprofessionnameByTalentprofessionid", objTalentInfo.getObjProfessionInfoByTalentprofessionid().getBusinesstypename());
/* 461 */       this.request.setAttribute("PeoplenameByDatabasepeopleid1", objTalentInfo.getObjSystemAdminInfoByDatabasepeopleid1().getTruename());
/* 462 */       this.request.setAttribute("PeoplenameByDatabasepeopleid2", objTalentInfo.getObjSystemAdminInfoByDatabasepeopleid2().getTruename());
/* 463 */       this.request.setAttribute("SectornameBySectorid", objTalentInfo.getObjSystemSectorInfoBySectorid().getSectorname());
/*     */     }
/*     */     else
/*     */     {
/* 468 */       String js = Javascript.AlertAndRedirect(this.request, this.response, "内容不存在", "?" + pageListUrl);
/* 469 */       this.request.setAttribute("pageJavaScripStar", js);
/*     */     }
/*     */   }
/*     */ 
// [start] ServerValidate 服务器验证
protected boolean ServerValidate()
{
    java.util.HashMap<String,Object> valueMap = new java.util.HashMap<String,Object>();
    StringBuilder sbStr = new StringBuilder(1024);
    int i = 1;
  
    // [start] 人才编号
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "人才编号");
    if (com.colorwinglib.Requests.GetString(request, "talentid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "talentid")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "talentid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    TalentInfoCollection talentc =TalentProvider.GetListByTalentid(Requests.GetInt(this.request, "talentid"));
    if(talentc.size()!=0)
    {
    	if(talentc.get(0).getDatabasetalentid()!=Requests.GetInt(this.request, "databasetalentid"))
    	{
    		valueMap.put("param1", com.colorwinglib.Requests.GetInt(request, "talentid"));
	    	sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000015, valueMap)));
	        i = i + 1;
    	}
    }		
    // [end]
    // [start] 姓名
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "姓名");
    if (com.colorwinglib.Requests.GetString(request, "talentname").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "talentname")) > 50)
    {
        valueMap.put("N", 50);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 性别：1-男、2-女
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "性别");
    if (com.colorwinglib.Requests.GetString(request, "sex").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "sex")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "sex")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 出生日期
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "出生日期");
    if (com.colorwinglib.Requests.GetString(request, "birthday").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsDateString(com.colorwinglib.Requests.GetString(request, "birthday")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 民族
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "民族");
    if (com.colorwinglib.Requests.GetString(request, "nationid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "nationid")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "nationid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 籍贯
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "籍贯");
    if (com.colorwinglib.Requests.GetString(request, "nativeplace").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "nativeplace")) > 50)
    {
        valueMap.put("N", 50);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 政治面貌
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "政治面貌");
    if (com.colorwinglib.Requests.GetString(request, "politicsstatus").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "politicsstatus")) > 50)
    {
        valueMap.put("N", 50);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 省份
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "省份");
    if (com.colorwinglib.Requests.GetString(request, "provinceid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "provinceid")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "provinceid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 城市
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "城市");
    if (com.colorwinglib.Requests.GetString(request, "cityid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "cityid")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "cityid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 学历
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "学历");
    if (com.colorwinglib.Requests.GetString(request, "educationid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "educationid")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "educationid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 学位
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "学位");
    if (com.colorwinglib.Requests.GetString(request, "degreeid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "degreeid")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "degreeid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 专业
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "专业");
    if (com.colorwinglib.Requests.GetString(request, "majorid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "majorid")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "majorid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 个人学习经历
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "个人学习经历");
    if (com.colorwinglib.Requests.GetString(request, "learnexperience").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "learnexperience")) > 200)
    {
        valueMap.put("N", 200);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 工作经历
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "工作经历");
    if (com.colorwinglib.Requests.GetString(request, "workexperience").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "workexperience")) > 200)
    {
        valueMap.put("N", 200);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 人才所属行业
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "人才所属行业");
    if (com.colorwinglib.Requests.GetString(request, "talentprofessionid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "talentprofessionid")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "talentprofessionid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 业绩
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "业绩");
    if (com.colorwinglib.Requests.GetString(request, "acheivement").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "acheivement")) > 200)
    {
        valueMap.put("N", 200);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 荣誉
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "荣誉");
    if (com.colorwinglib.Requests.GetString(request, "honor").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "honor")) > 200)
    {
        valueMap.put("N", 200);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 专长
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "专长");
    if (com.colorwinglib.Requests.GetString(request, "skills").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "skills")) > 200)
    {
        valueMap.put("N", 200);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 职称
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "职称");
    if (com.colorwinglib.Requests.GetString(request, "posttitleid").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "posttitleid")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "posttitleid")),0,9999999))
    {
        valueMap.put("param1", 0);
        valueMap.put("param2", 9999999);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 工作单位
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "工作单位");
    if (com.colorwinglib.Requests.GetString(request, "workunit").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "workunit")) > 50)
    {
        valueMap.put("N", 50);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 现在住址
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "现在住址");
    if (com.colorwinglib.Requests.GetString(request, "adress").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "adress")) > 50)
    {
        valueMap.put("N", 50);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 手机
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "手机");
    if (com.colorwinglib.Requests.GetString(request, "movephone").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "movephone")) > 20)
    {
        valueMap.put("N", 20);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 邮箱
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "邮箱");
    if (com.colorwinglib.Requests.GetString(request, "email").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }
    if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "email")) > 50)
    {
        valueMap.put("N", 50);
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsEmail(com.colorwinglib.Requests.GetString(request, "email")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }
    // [end]
    // [start] 统计人员
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "统计人员");
    if (com.colorwinglib.Requests.GetString(request, "databasepeopleid1").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "databasepeopleid1")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "databasepeopleid1")),0,9999999))
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
    if (com.colorwinglib.Requests.GetString(request, "databasepeopleid2").length() == 0)
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "databasepeopleid2")))
    {
        sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
        i = i + 1;
    }

    if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "databasepeopleid2")),0,9999999))
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
    // [start] SectorID
    valueMap = new java.util.HashMap<String,Object>();
    valueMap.put("label_name", "SectorID");
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



/*     */ 
/*     */   protected void insert()
/*     */   {
/* 690 */     String pageListUrl = getpageListUrl();
			  
/*     */     int Databasetalentid=Requests.GetInt(this.request, "databasetalentid");
/* 692 */     int Talentid = Requests.GetInt(this.request, "talentid", 0);
/* 693 */     String Talentname = Requests.GetString(this.request, "talentname", "");
/* 694 */     int Sex = Requests.GetInt(this.request, "sex", 0);
/* 695 */     Date Birthday = Requests.GetDate(this.request, "birthday", new Date());
/* 696 */     int Nationid = Requests.GetInt(this.request, "nationid", 0);
/* 697 */     String Nativeplace = Requests.GetString(this.request, "nativeplace", "");
/* 698 */     String Politicsstatus = Requests.GetString(this.request, "politicsstatus", "");
/* 699 */     int Province = Requests.GetInt(this.request, "provinceid", 0);
/* 700 */     int Cityid = Requests.GetInt(this.request, "cityid", 0);
/* 701 */     int Educationid = Requests.GetInt(this.request, "educationid", 0);
/* 702 */     int Degreeid = Requests.GetInt(this.request, "degreeid", 0);
/* 703 */     int Majorid = Requests.GetInt(this.request, "majorid", 0);
/* 704 */     String Learnexperience = Requests.GetString(this.request, "learnexperience", "");
/* 705 */     String Workexperience = Requests.GetString(this.request, "workexperience", "");
/* 706 */     int Talentprofessionid = Requests.GetInt(this.request, "talentprofessionid", 0);
/* 707 */     String Acheivement = Requests.GetString(this.request, "acheivement", "");

/* 708 */     String Honor = Requests.GetString(this.request, "honor", "");
/* 709 */     String Skills = Requests.GetString(this.request, "skills", "");
/* 710 */     int Posttitleid = Requests.GetInt(this.request, "posttitleid", 0);
/* 711 */     String Workunit = Requests.GetString(this.request, "workunit", "");
/* 712 */     String Adress = Requests.GetString(this.request, "adress", "");
/* 713 */     String Movephone = Requests.GetString(this.request, "movephone", "");
/* 714 */     String Email = Requests.GetString(this.request, "email", "");
/* 715 */     int Databasepeopleid1 = Requests.GetInt(this.request, "databasepeopleid1", 0);
/* 716 */     int Databasepeopleid2 = Requests.GetInt(this.request, "databasepeopleid2", 0);
/* 717 */     int Adminid = Requests.GetInt(this.request, "adminid", 0);
/* 718 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
/* 719 */     Date Logintime = Requests.GetDate(this.request, "logintime", new Date());
/*     */ 	
/* 722 */     if (!ServerValidate())
/*     */     {
/* 725 */       DrpInit();
				this.request.setAttribute("Databasetalentid", Databasetalentid);
/* 726 */       this.request.setAttribute("Talentid", Integer.valueOf(Talentid));
/* 727 */       this.request.setAttribute("Talentname", StringFormat.HtmlEncode(Talentname));
/* 728 */       this.request.setAttribute("Sex", Integer.valueOf(Sex));
/* 729 */       this.request.setAttribute("Birthday", new SimpleDateFormat("yyyy-MM-dd").format(Birthday));
/* 730 */       this.request.setAttribute("Nationid", Integer.valueOf(Nationid));
/* 731 */       this.request.setAttribute("Nativeplace", StringFormat.HtmlEncode(Nativeplace));
/* 732 */       this.request.setAttribute("Politicsstatus", StringFormat.HtmlEncode(Politicsstatus));
/* 733 */       this.request.setAttribute("Province", Integer.valueOf(Province));
/* 734 */       this.request.setAttribute("Cityid", Integer.valueOf(Cityid));
/* 735 */       this.request.setAttribute("Educationid", Integer.valueOf(Educationid));
/* 736 */       this.request.setAttribute("Degreeid", Integer.valueOf(Degreeid));
/* 737 */       this.request.setAttribute("Majorid", Integer.valueOf(Majorid));
/* 738 */       this.request.setAttribute("Learnexperience", StringFormat.HtmlEncode(Learnexperience));
/* 739 */       this.request.setAttribute("Workexperience", StringFormat.HtmlEncode(Workexperience));
/* 740 */       this.request.setAttribute("Talentprofessionid", Integer.valueOf(Talentprofessionid));
/* 741 */       this.request.setAttribute("Acheivement", StringFormat.HtmlEncode(Acheivement));
/* 742 */       this.request.setAttribute("Honor", StringFormat.HtmlEncode(Honor));
/* 743 */       this.request.setAttribute("Skills", StringFormat.HtmlEncode(Skills));
/* 744 */       this.request.setAttribute("Posttitleid", Integer.valueOf(Posttitleid));
/* 745 */       this.request.setAttribute("Workunit", StringFormat.HtmlEncode(Workunit));
/* 746 */       this.request.setAttribute("Adress", StringFormat.HtmlEncode(Adress));
/* 747 */       this.request.setAttribute("Movephone", StringFormat.HtmlEncode(Movephone));
/* 748 */       this.request.setAttribute("Email", StringFormat.HtmlEncode(Email));
/* 749 */       this.request.setAttribute("Databasepeopleid1", Integer.valueOf(Databasepeopleid1));
/* 750 */       this.request.setAttribute("Databasepeopleid2", Integer.valueOf(Databasepeopleid2));
/*     */ 
/* 755 */       
/* 756 */       
/* 757 */      
/*     */ 
/* 761 */       return;
/*     */     }
/*     */ 
/* 764 */     TalentInfo objTalentInfo = new TalentInfo();
/* 765 */     objTalentInfo.setTalentid(Talentid);
/* 766 */     objTalentInfo.setTalentname(Talentname);
/* 767 */     objTalentInfo.setSex(Sex);
/* 768 */     objTalentInfo.setBirthday(Birthday);
/* 769 */     objTalentInfo.setNationid(Nationid);
/* 770 */     objTalentInfo.setNativeplace(Nativeplace);
/* 771 */     objTalentInfo.setPoliticsstatus(Politicsstatus);
/* 772 */     objTalentInfo.setProvince(Province);
/* 773 */     objTalentInfo.setCityid(Cityid);
/* 774 */     objTalentInfo.setEducationid(Educationid);
/* 775 */     objTalentInfo.setDegreeid(Degreeid);
/* 776 */     objTalentInfo.setMajorid(Majorid);
/* 777 */     objTalentInfo.setLearnexperience(Learnexperience);
/* 778 */     objTalentInfo.setWorkexperience(Workexperience);
/* 779 */     objTalentInfo.setTalentprofessionid(Talentprofessionid);
/* 780 */     objTalentInfo.setAcheivement(Acheivement);
/* 781 */     objTalentInfo.setHonor(Honor);
/* 782 */     objTalentInfo.setSkills(Skills);
/* 783 */     objTalentInfo.setPosttitleid(Posttitleid);
/* 784 */     objTalentInfo.setWorkunit(Workunit);
/* 785 */     objTalentInfo.setAdress(Adress);
/* 786 */     objTalentInfo.setMovephone(Movephone);
/* 787 */     objTalentInfo.setEmail(Email);
/* 788 */     objTalentInfo.setDatabasepeopleid1(Databasepeopleid1);
/* 789 */     objTalentInfo.setDatabasepeopleid2(Databasepeopleid2);
/* 790 */     objTalentInfo.setAdminid(Adminid);
/* 791 */     objTalentInfo.setSectorid(Sectorid);
/* 792 */     objTalentInfo.setLogintime(Logintime);
/*     */ 
/* 794 */     TalentProvider.Insert(objTalentInfo);
/*     */ 
/* 796 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?pagetype=gotoinsert&" + pageListUrl);
/* 797 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 799 */       js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 801 */     this.request.setAttribute("pageJavaScripStar", js);
/* 802 */     TalentProvider.setTalentStatic(null);
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 810 */     flag = true;
/*     */ 
/* 812 */     String pageListUrl = getpageListUrl();
/*     */     int Databasetalentid=Requests.GetInt(this.request, "databasetalentid");
/* 814 */     int Talentid = Requests.GetInt(this.request, "talentid", 0);
/* 815 */     String Talentname = Requests.GetString(this.request, "talentname", "");
/* 816 */     int Sex = Requests.GetInt(this.request, "sex", 0);
/* 817 */     Date Birthday = Requests.GetDate(this.request, "birthday", new Date());
/* 818 */     int Nationid = Requests.GetInt(this.request, "nationid", 0);
/* 819 */     String Nativeplace = Requests.GetString(this.request, "nativeplace", "");
/* 820 */     String Politicsstatus = Requests.GetString(this.request, "politicsstatus", "");
/* 821 */     int Province = Requests.GetInt(this.request, "provinceid", 0);
/* 822 */     int Cityid = Requests.GetInt(this.request, "cityid", 0);
/* 823 */     int Educationid = Requests.GetInt(this.request, "educationid", 0);
/* 824 */     int Degreeid = Requests.GetInt(this.request, "degreeid", 0);
/* 825 */     int Majorid = Requests.GetInt(this.request, "majorid", 0);
/* 826 */     String Learnexperience = Requests.GetString(this.request, "learnexperience", "");
/* 827 */     String Workexperience = Requests.GetString(this.request, "workexperience", "");
/* 828 */     int Talentprofessionid = Requests.GetInt(this.request, "talentprofessionid", 0);
/* 829 */     String Acheivement = Requests.GetString(this.request, "acheivement", "");
/* 830 */     String Honor = Requests.GetString(this.request, "honor", "");
/* 831 */     String Skills = Requests.GetString(this.request, "skills", "");
/* 832 */     int Posttitleid = Requests.GetInt(this.request, "posttitleid", 0);
/* 833 */     String Workunit = Requests.GetString(this.request, "workunit", "");
/* 834 */     String Adress = Requests.GetString(this.request, "adress", "");
/* 835 */     String Movephone = Requests.GetString(this.request, "movephone", "");
/* 836 */     String Email = Requests.GetString(this.request, "email", "");
/*     */ 	  int Databasepeopleid1 = Requests.GetInt(this.request, "databasepeopleid1", 0);
/* 716 */     int Databasepeopleid2 = Requests.GetInt(this.request, "databasepeopleid2", 0);
/* 717 */     int Adminid = Requests.GetInt(this.request, "adminid", 0);
/* 718 */     int Sectorid = Requests.GetInt(this.request, "sectorid", 0);
/* 719 */     Date Logintime = Requests.GetDate(this.request, "logintime", new Date());
/* 844 */     if (!ServerValidate())
/*     */     {
/* 847 */       DrpInit();
				this.request.setAttribute("Databasetalentid", Databasetalentid);
/* 848 */       this.request.setAttribute("Talentid", Integer.valueOf(Talentid));
/* 849 */       this.request.setAttribute("Talentname", StringFormat.HtmlEncode(Talentname));
/* 850 */       this.request.setAttribute("Sex", Integer.valueOf(Sex));
/* 851 */       this.request.setAttribute("Birthday", new SimpleDateFormat("yyyy-MM-dd").format(Birthday));
/* 852 */       this.request.setAttribute("Nationid", Integer.valueOf(Nationid));
/* 853 */       this.request.setAttribute("Nativeplace", StringFormat.HtmlEncode(Nativeplace));
/* 854 */       this.request.setAttribute("Politicsstatus", StringFormat.HtmlEncode(Politicsstatus));
/* 855 */       this.request.setAttribute("Province", Integer.valueOf(Province));
/* 856 */       this.request.setAttribute("Cityid", Integer.valueOf(Cityid));
/* 857 */       this.request.setAttribute("Educationid", Integer.valueOf(Educationid));
/* 858 */       this.request.setAttribute("Degreeid", Integer.valueOf(Degreeid));
/* 859 */       this.request.setAttribute("Majorid", Integer.valueOf(Majorid));
/* 860 */       this.request.setAttribute("Learnexperience", StringFormat.HtmlEncode(Learnexperience));
/* 861 */       this.request.setAttribute("Workexperience", StringFormat.HtmlEncode(Workexperience));
/* 862 */       this.request.setAttribute("Talentprofessionid", Integer.valueOf(Talentprofessionid));
/* 863 */       this.request.setAttribute("Acheivement", StringFormat.HtmlEncode(Acheivement));
/* 864 */       this.request.setAttribute("Honor", StringFormat.HtmlEncode(Honor));
/* 865 */       this.request.setAttribute("Skills", StringFormat.HtmlEncode(Skills));
/* 866 */       this.request.setAttribute("Posttitleid", Integer.valueOf(Posttitleid));
/* 867 */       this.request.setAttribute("Workunit", StringFormat.HtmlEncode(Workunit));
/* 868 */       this.request.setAttribute("Adress", StringFormat.HtmlEncode(Adress));
/* 869 */       this.request.setAttribute("Movephone", StringFormat.HtmlEncode(Movephone));
/* 870 */       this.request.setAttribute("Email", StringFormat.HtmlEncode(Email));
/*     */       this.request.setAttribute("Databasepeopleid1", Integer.valueOf(Databasepeopleid1));
/* 750 */       this.request.setAttribute("Databasepeopleid2", Integer.valueOf(Databasepeopleid2));
/* 876 */       return;
/*     */     }
/*     */ 
/* 879 */     flag = false;
/*     */     
/* 881 */     TalentInfo objTalentInfo = TalentProvider.GetTalentInfoByDatabasetalentid(Databasetalentid);
/* 882 */     objTalentInfo.setTalentid(Talentid);
/* 883 */     objTalentInfo.setTalentname(Talentname);
/* 884 */     objTalentInfo.setSex(Sex);
/* 885 */     objTalentInfo.setBirthday(Birthday);
/* 886 */     objTalentInfo.setNationid(Nationid);
/* 887 */     objTalentInfo.setNativeplace(Nativeplace);
/* 888 */     objTalentInfo.setPoliticsstatus(Politicsstatus);
/* 889 */     objTalentInfo.setProvince(Province);
/* 890 */     objTalentInfo.setCityid(Cityid);
/* 891 */     objTalentInfo.setEducationid(Educationid);
/* 892 */     objTalentInfo.setDegreeid(Degreeid);
/* 893 */     objTalentInfo.setMajorid(Majorid);
/* 894 */     objTalentInfo.setLearnexperience(Learnexperience);
/* 895 */     objTalentInfo.setWorkexperience(Workexperience);
/* 896 */     objTalentInfo.setTalentprofessionid(Talentprofessionid);
/* 897 */     objTalentInfo.setAcheivement(Acheivement);
/* 898 */     objTalentInfo.setHonor(Honor);
/* 899 */     objTalentInfo.setSkills(Skills);
/* 900 */     objTalentInfo.setPosttitleid(Posttitleid);
/* 901 */     objTalentInfo.setWorkunit(Workunit);
/* 902 */     objTalentInfo.setAdress(Adress);
/* 903 */     objTalentInfo.setMovephone(Movephone);
/* 904 */     objTalentInfo.setEmail(Email);
/*     */     objTalentInfo.setDatabasepeopleid1(Databasepeopleid1);
/* 789 */     objTalentInfo.setDatabasepeopleid2(Databasepeopleid2);
/* 790 */     objTalentInfo.setAdminid(Adminid);
/* 791 */     objTalentInfo.setSectorid(Sectorid);
/* 792 */     objTalentInfo.setLogintime(Logintime);
/* 911 */     TalentProvider.UpdateByDatabasetalentid(objTalentInfo);
/*     */ 
/* 913 */     String js = Javascript.Alert(this.request, this.response, "更新成功" );
/* 914 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 916 */       js = Javascript.Alert(this.request, this.response, "更新成功");
/*     */     }
/* 918 */     this.request.setAttribute("pageJavaScripStar", js);
/* 919 */     TalentProvider.setTalentStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 928 */     int Talentid = Requests.GetInt(this.request, "databasetalentid", 0);
/*     */ 
/* 930 */	  
/*     */ 
/* 932 */     TalentProvider.DeleteByDatabasetalentid(Talentid);
/*     */ 
/* 934 */     TalentProvider.setTalentStatic(null);
				
/* 935 */     String js = Javascript.Alert(this.request, this.response, "删除成功");

/* 936 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ 
/*     */ 
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.talent.Talent
 * JD-Core Version:    0.6.0
 */