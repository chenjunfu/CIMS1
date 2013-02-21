/*     */ package com.yun.ui.action.cultureproduce;
/*     */ 
/*     */ import com.colorwinglib.FileFormat;
/*     */ import com.colorwinglib.ImageFormat;
/*     */ import com.colorwinglib.Javascript;
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.yun.bll.culture.ProjectpicProvider;
/*     */ import com.yun.common.Pager;
/*     */ import com.yun.configuration.WebConfig;
/*     */ import com.yun.entities.culture.ProjectpicInfo;
/*     */ import com.yun.entities.culture.collection.ProjectpicInfoCollection;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class Projectpic
/*     */ {
/*     */   private static final long serialVersionUID = 2011120109092170361L;
/*  20 */   public int pageSize = 10;
/*     */ 
/*  25 */   public String pageParameter = "page";
/*     */ 
/*  31 */   HttpServletRequest request = null;
/*     */ 
/*  35 */   HttpServletResponse response = null;
/*     */ 
/*  39 */   PrintWriter out = null;
/*     */   private String filepicFileName;
/* 437 */   private String filepic1FileName = "";
/*     */ 
/* 451 */   private String filepic2FileName = "";
/*     */ 
/* 462 */   private String filepic3FileName = "";
/*     */ 
/* 474 */   private String filepic4FileName = "";
/*     */   private File filepic;
/*     */   private File filepic1;
/*     */   private File filepic2;
/*     */   private File filepic3;
/*     */   private File filepic4;
/*     */   private String filepicContentType;
/*     */   private String filepic1ContentType;
/*     */   private String filepic2ContentType;
/*     */   private String filepic3ContentType;
/*     */   private String filepic4ContentType;
/*     */ 
/*     */   private String getpageListUrl()
/*     */   {
/*  45 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/*  46 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "ProjectPicID");
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
/*  78 */     int Projectpicid = Requests.GetInt(this.request, "projectpicid", 0);
/*     */ 
/*  83 */     String pageName = "Projectpic";
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
/* 148 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "ProjectPicID");
/* 149 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 150 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 152 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/*     */ 
/* 155 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 156 */     int pageAll = 0;
/* 157 */     pageAll = ProjectpicProvider.GetListPagerBy();
/* 158 */     ProjectpicInfoCollection ProjectpicColl = ProjectpicProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 159 */     this.request.setAttribute("ProjectpicList", ProjectpicColl);
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
/* 190 */     throw new Error("无法解析的编译问题：\n\t没有为类型 ProjectpicInfo 定义方法 getPicMin（）\n\t没有为类型 ProjectpicInfo 定义方法 getPicMax（）\n\t没有为类型 ProjectpicInfo 定义方法 getPicMax（）\n");
/*     */   }
/*     */ 
/*     */   protected void ItemCommandDetails()
/*     */   {
/* 219 */     throw new Error("无法解析的编译问题：\n\t没有为类型 ProjectpicInfo 定义方法 getPicMin（）\n\t没有为类型 ProjectpicInfo 定义方法 getPicMax（）\n");
/*     */   }
/*     */ 
/*     */   protected boolean ServerValidate()
/*     */   {
/* 237 */     StringBuilder sbStr = new StringBuilder(1024);
/* 238 */     int i = 1;
/*     */ 
/* 242 */     if ((Requests.GetString(this.request, "pagetype").toLowerCase().equals("insert")) && (this.filepic == null))
/*     */     {
/* 244 */       sbStr.append(String.format("%1$s.%2$s不能为空\n", new Object[] { Integer.valueOf(i), "项目图片" }));
/* 245 */       i++;
/*     */     }
/*     */ 
/* 249 */     if (i - 1 > 0)
/*     */     {
/* 251 */       sbStr.append("总共有" + (i - 1) + "个错误");
/* 252 */       String js = Javascript.Alert(this.request, this.response, sbStr.toString());
/* 253 */       this.request.setAttribute("pageJavaScripEnd", js);
/* 254 */       if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */       {
/* 256 */         this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "insert"));
/*     */       }
/* 258 */       return false;
/*     */     }
/*     */ 
/* 262 */     return true; } 
			public int databaseprojectid=0;
			
public int getDatabaseprojectid() {
				return databaseprojectid;
			}
			public void setDatabaseprojectid(int databaseprojectid) {
				this.databaseprojectid = databaseprojectid;
			}
/* 271 */   protected void insert() {
			String pageListUrl = getpageListUrl();
/*     */ 	  	
/* 273 */     
/* 274 */     int Databaseprojectid = Requests.GetInt(this.request, "databaseprojectid", 0);
/* 275 */     String Pic = Requests.GetString(this.request, "pic", "");
/*     */     String Pic1;
/*     */     String Pic2;
/*     */     String Pic3;
/*     */     String Pic4;
/*     */     try {
				 Pic1 = Requests.GetString(this.request, "pic1", "");
/* 279 */        Pic2 = Requests.GetString(this.request, "pic2", "");
/* 280 */        Pic3 = Requests.GetString(this.request, "pic3", "");
/* 281 */        Pic4 = Requests.GetString(this.request, "pic4", "");
	
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       Pic4 = "";
/* 284 */       Pic1 = "";
/* 285 */       Pic2 = ""; 
/* 286 */       Pic3 = "";
/* 287 */       Pic4 = "";
/*     */     }

/*     */ 	 
/* 290 */     if (!ServerValidate())
/*     */     {
/* 293 */       DrpInit();
/* 294 */     
/* 295 */       this.request.setAttribute("Databaseprojectid", Integer.valueOf(Databaseprojectid));
/* 296 */       this.request.setAttribute("Pic", StringFormat.HtmlEncode(Pic));
/* 297 */       return;
/*     */     }
/*     */ 
/* 300 */     ProjectpicInfo objProjectpicInfo = new ProjectpicInfo();
/*     */ 
/* 302 */     
/* 303 */     objProjectpicInfo.setDatabaseprojectid(Databaseprojectid);
/*     */ 
/* 305 */     if (!this.filepicFileName.equals("")) {
/* 306 */       objProjectpicInfo.setPic(Pic);
/* 307 */       Pic = UpFile("filepic", Pic);
/* 308 */       objProjectpicInfo.setPic(Pic);
/*     */ 
/* 310 */       ProjectpicProvider.Insert(objProjectpicInfo);
/*     */     }
/* 312 */     if (!this.filepic1FileName.equals("")) {
/* 313 */       objProjectpicInfo.setPic(Pic);
/* 314 */       Pic = UpFile("filepic1", Pic1);
/* 315 */       objProjectpicInfo.setPic(Pic);
/*     */ 
/* 317 */       ProjectpicProvider.Insert(objProjectpicInfo);
/*     */     }
/* 319 */     if (!"".equals(this.filepic2FileName)) {
/* 320 */       objProjectpicInfo.setPic(Pic);
/* 321 */       Pic = UpFile("filepic2", Pic2);
/* 322 */       objProjectpicInfo.setPic(Pic);
/*     */ 
/* 324 */       ProjectpicProvider.Insert(objProjectpicInfo);
/*     */     }
/* 326 */     if (!"".equals(this.filepic3FileName)) {
/* 327 */       objProjectpicInfo.setPic(Pic);
/* 328 */       Pic = UpFile("filepic3", Pic3);
/* 329 */       objProjectpicInfo.setPic(Pic);
/*     */ 
/* 331 */       ProjectpicProvider.Insert(objProjectpicInfo);
/*     */     }
/* 333 */     if (!"".equals(this.filepic4FileName)) {
/* 334 */       objProjectpicInfo.setPic(Pic);
/* 335 */       Pic = UpFile("filepic4", Pic4);
/* 336 */       objProjectpicInfo.setPic(Pic);
/*     */ 
/* 338 */       ProjectpicProvider.Insert(objProjectpicInfo);
/*     */     }
/* 340 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?pagetype=gotoinsert&" + pageListUrl);
/* 341 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 343 */       js = Javascript.AlertAndRedirect(this.request, this.response, "添加成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 345 */     this.request.setAttribute("pageJavaScripStar", js);
/* 346 */     ProjectpicProvider.setProjectpicStatic(null);
/*     */   }
/*     */ 
/*     */   protected void update()
/*     */   {
/* 354 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 356 */     int Projectpicid = Requests.GetInt(this.request, "projectpicid", 0);
/* 357 */     int Databaseprojectid = Requests.GetInt(this.request, "databaseprojectid", 0);
/* 358 */     String Pic = Requests.GetString(this.request, "pic", "");
/*     */ 
/* 361 */     if (!ServerValidate())
/*     */     {
/* 364 */       DrpInit();
/* 365 */       this.request.setAttribute("Projectpicid", Integer.valueOf(Projectpicid));
/* 366 */       this.request.setAttribute("Databaseprojectid", Integer.valueOf(Databaseprojectid));
/* 367 */       this.request.setAttribute("Pic", StringFormat.HtmlEncode(Pic));
/* 368 */       return;
/*     */     }
/*     */ 
/* 371 */     Pic = UpFile("filepic", Pic);
/*     */ 
/* 373 */     ProjectpicInfo objProjectpicInfo = ProjectpicProvider.GetProjectpicInfoByProjectpicid(Projectpicid);
/* 374 */     objProjectpicInfo.setProjectpicid(Projectpicid);
/* 375 */     objProjectpicInfo.setDatabaseprojectid(Databaseprojectid);
/* 376 */     objProjectpicInfo.setPic(Pic);
/*     */ 
/* 378 */     ProjectpicProvider.UpdateByProjectpicid(objProjectpicInfo);
/*     */ 
/* 380 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?" + pageListUrl);
/* 381 */     if (Requests.GetInt(this.request, "isSaveAndNew") == 1)
/*     */     {
/* 383 */       js = Javascript.AlertAndRedirect(this.request, this.response, "更新成功", "?pagetype=gotoinsert&" + pageListUrl);
/*     */     }
/* 385 */     this.request.setAttribute("pageJavaScripStar", js);
/* 386 */     ProjectpicProvider.setProjectpicStatic(null);
/*     */   }
/*     */ 
/*     */   protected void delete()
/*     */   {
/* 395 */     int Projectpicid = Requests.GetInt(this.request, "projectpicid", 0);
/*     */ 
/* 397 */     String pageListUrl = getpageListUrl();
/*     */ 
/* 400 */     ProjectpicInfo objProjectpicInfo = ProjectpicProvider.GetProjectpicInfoByProjectpicid(Projectpicid);
/* 401 */     String filePath = "";
/*     */ 
/* 403 */     filePath = this.request.getSession().getServletContext().getRealPath(String.format("%s", new Object[] { objProjectpicInfo.getPic() }));
/* 404 */     FileFormat.DeleteFiles(filePath);
System.out.println(filePath);
/* 405 */     filePath = this.request.getSession().getServletContext().getRealPath(String.format("%s", new Object[] { objProjectpicInfo.getPicmin() }));
/* 406 */     FileFormat.DeleteFiles(filePath);
System.out.println(filePath);
/*     */ 	  
/* 409 */     ProjectpicProvider.DeleteByProjectpicid(Projectpicid);
/*     */ 
/* 411 */     ProjectpicProvider.setProjectpicStatic(null);
/* 412 */     String js = Javascript.AlertAndRedirect(this.request, this.response, "删除成功", "?" + pageListUrl);
/* 413 */     this.request.setAttribute("pageJavaScripStar", js);
/*     */   }
/*     */ 
/*     */   public String getFilepicFileName()
/*     */   {
/* 430 */     return this.filepicFileName;
/*     */   }
/*     */ 
/*     */   public void setFilepicFileName(String filepicFileName)
/*     */   {
/* 435 */     this.filepicFileName = filepicFileName;
/*     */   }
/*     */ 
/*     */   public String getFilepic1FileName()
/*     */   {
/* 443 */     return this.filepic1FileName;
/*     */   }
/*     */ 
/*     */   public void setFilepic1FileName(String filepic1FileName)
/*     */   {
/* 448 */     this.filepic1FileName = filepic1FileName;
/*     */   }
/*     */ 
/*     */   public String getFilepic2FileName()
/*     */   {
/* 455 */     return this.filepic2FileName;
/*     */   }
/*     */ 
/*     */   public void setFilepic2FileName(String filepic2FileName)
/*     */   {
/* 460 */     this.filepic2FileName = filepic2FileName;
/*     */   }
/*     */ 
/*     */   public String getFilepic3FileName()
/*     */   {
/* 467 */     return this.filepic3FileName;
/*     */   }
/*     */ 
/*     */   public void setFilepic3FileName(String filepic3FileName)
/*     */   {
/* 472 */     this.filepic3FileName = filepic3FileName;
/*     */   }
/*     */ 
/*     */   public String getFilepic4FileName()
/*     */   {
/* 479 */     return this.filepic4FileName;
/*     */   }
/*     */ 
/*     */   public void setFilepic4FileName(String filepic4FileName)
/*     */   {
/* 484 */     this.filepic4FileName = filepic4FileName;
/*     */   }
/*     */ 
/*     */   public File getFilepic()
/*     */   {
/* 497 */     return this.filepic;
/*     */   }
/*     */ 
/*     */   public void setFilepic(File filepic)
/*     */   {
/* 502 */     this.filepic = filepic;
/*     */   }
/*     */ 
/*     */   public File getFilepic1()
/*     */   {
/* 511 */     return this.filepic1;
/*     */   }
/*     */ 
/*     */   public void setFilepic1(File filepic1)
/*     */   {
/* 516 */     this.filepic1 = filepic1;
/*     */   }
/*     */ 
/*     */   public File getFilepic2()
/*     */   {
/* 523 */     return this.filepic2;
/*     */   }
/*     */ 
/*     */   public void setFilepic2(File filepic2)
/*     */   {
/* 528 */     this.filepic2 = filepic2;
/*     */   }
/*     */ 
/*     */   public File getFilepic3()
/*     */   {
/* 535 */     return this.filepic3;
/*     */   }
/*     */ 
/*     */   public void setFilepic3(File filepic3)
/*     */   {
/* 540 */     this.filepic3 = filepic3;
/*     */   }
/*     */ 
/*     */   public File getFilepic4()
/*     */   {
/* 547 */     return this.filepic4;
/*     */   }
/*     */ 
/*     */   public void setFilepic4(File filepic4)
/*     */   {
/* 552 */     this.filepic4 = filepic4;
/*     */   }
/*     */ 
/*     */   public void setFilepicContentType(String contentType)
/*     */   {
/* 565 */     this.filepicContentType = contentType;
/*     */   }
/*     */ 
/*     */   public String getFilepicContentType()
/*     */   {
/* 570 */     return this.filepicContentType;
/*     */   }
/*     */ 
/*     */   public String getFilepic1ContentType()
/*     */   {
/* 578 */     return this.filepic1ContentType;
/*     */   }
/*     */ 
/*     */   public void setFilepic1ContentType(String filepic1ContentType)
/*     */   {
/* 583 */     this.filepic1ContentType = filepic1ContentType;
/*     */   }
/*     */ 
/*     */   public String getFilepic2ContentType()
/*     */   {
/* 588 */     return this.filepic2ContentType;
/*     */   }
/*     */ 
/*     */   public void setFilepic2ContentType(String filepic2ContentType)
/*     */   {
/* 593 */     this.filepic2ContentType = filepic2ContentType;
/*     */   }
/*     */ 
/*     */   public String getFilepic3ContentType()
/*     */   {
/* 598 */     return this.filepic3ContentType;
/*     */   }
/*     */ 
/*     */   public void setFilepic3ContentType(String filepic3ContentType)
/*     */   {
/* 603 */     this.filepic3ContentType = filepic3ContentType;
/*     */   }
/*     */ 
/*     */   public String getFilepic4ContentType()
/*     */   {
/* 608 */     return this.filepic4ContentType;
/*     */   }
/*     */ 
/*     */   public void setFilepic4ContentType(String filepic4ContentType)
/*     */   {
/* 613 */     this.filepic4ContentType = filepic4ContentType;
/*     */   }
/*     */ 
/*     */   protected String UpFile(String fipName, String oldItemValue)
/*     */   {
/* 628 */     if (fipName.equals("filepic"))
/*     */     {
/* 630 */       return UpFile(this.filepic, this.filepicContentType, this.filepicFileName, oldItemValue);
/* 631 */     }
			  if (fipName.equals("filepic1"))
/* 632 */       return UpFile(this.filepic1, this.filepic1ContentType, this.filepic1FileName, oldItemValue);
/* 633 */     if (fipName.equals("filepic2"))
/* 634 */       return UpFile(this.filepic2, this.filepic2ContentType, this.filepic2FileName, oldItemValue);
/* 635 */     if (fipName.equals("filepic3"))
/* 636 */       return UpFile(this.filepic3, this.filepic3ContentType, this.filepic3FileName, oldItemValue);
/* 637 */     if (fipName.equals("filepic4")) {
/* 638 */       return UpFile(this.filepic4, this.filepic4ContentType, this.filepic4FileName, oldItemValue);
/*     */     }
/* 640 */     return "";
/*     */   }
/*     */ 
/*     */   protected String UpImg(File fFile, String fileContentType, String fileName, String oldItemValue)
/*     */   {
/* 658 */     if (fFile != null)
/*     */     {
/* 661 */       SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd/");
/* 662 */       String urlPath = "upfile/images/" + formatter.format(new Date());
/* 663 */       String filePath = this.request.getSession().getServletContext().getRealPath("/" + urlPath);
/*     */ 
/* 665 */       String fileExtension = ".jpg";
/*     */ 
/* 667 */       fileName = "";
/*     */       try
/*     */       {
/* 671 */         fileName = String.format("%1$s%2$s", new Object[] { urlPath, oldItemValue });
/*     */ 
/* 673 */         if (fileContentType.indexOf("image") < 0)
/*     */         {
/* 676 */           String js = Javascript.Alert(this.request, this.response, "无效的图形格式");
/* 677 */           this.request.setAttribute("pageJavaScripStar", js);
/* 678 */           return oldItemValue;
/*     */         }
/*     */ 
/* 682 */         long fSize = fFile.length();
/* 683 */         int maxFSize = 2048;
/* 684 */         if (fSize > maxFSize * 1024)
/*     */         {
/* 686 */           String js = Javascript.Alert(this.request, this.response, "文件太大，请选择小于" + maxFSize + "K的文件");
/* 687 */           this.request.setAttribute("pageJavaScripStar", js);
/* 688 */           return oldItemValue;
/*     */         }
/*     */ 
/* 692 */         fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + (int)(Math.random() * 100000.0D);
/*     */ 
/* 695 */         FileFormat.CreateDirectory(filePath);
/*     */ 
/* 697 */         String oldfilePath = "";
/* 698 */         oldfilePath = this.request.getSession().getServletContext().getRealPath(String.format("/%1$s%2$s", new Object[] { oldItemValue, fileExtension }));
/* 699 */         FileFormat.DeleteFiles(oldfilePath);
/* 700 */         oldfilePath = this.request.getSession().getServletContext().getRealPath(String.format("/%1$ss%2$s", new Object[] { oldItemValue, fileExtension }));
/* 701 */         FileFormat.DeleteFiles(oldfilePath);
/*     */ 
/* 704 */         String source = String.format("%1$s%4$s%2$s%3$s", new Object[] { filePath, fileName, fileExtension, WebConfig.getFileSeparator() });
/* 705 */         ImageMaxSave(fFile, source);
/*     */ 
/* 707 */         ImageMinSave(source, String.format("%1$s%4$s%2$ss%3$s", new Object[] { filePath, fileName, fileExtension, WebConfig.getFileSeparator() }));
/*     */ 
/* 709 */         fileName = String.format("%1$s%2$s", new Object[] { urlPath, fileName });
/*     */ 
/* 711 */         return fileName;
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/* 715 */         ex.printStackTrace();
/*     */       }
/*     */     }
/* 718 */     return oldItemValue;
/*     */   }
/*     */ 
/*     */   protected String UpFile(File fFile, String fileContentType, String fileName, String oldItemValue)
/*     */   {
/* 736 */     if (fFile != null)
/*     */     {
/* 739 */       SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd/");
/* 740 */       String urlPath = "images/upfile/images/" + formatter.format(new Date());
/* 741 */       String filePath = this.request.getSession().getServletContext().getRealPath("/" + urlPath);
/*     */ 		
/* 743 */       String fileExtension = fileName.substring(fileName.indexOf("."));

/* 744 */       fileName = "";
/*     */       try
/*     */       {
/* 748 */         fileName = String.format("%1$s%2$s", new Object[] { urlPath, oldItemValue });
/*     */ 			
/* 751 */         long fSize = fFile.length();
/* 752 */         int maxFSize = 2048;
/* 753 */         if (fSize > maxFSize * 1024)
/*     */         {
/* 755 */           String js = Javascript.Alert(this.request, this.response, "文件太大，请选择小于" + maxFSize + "K的文件");
/* 756 */           this.request.setAttribute("pageJavaScripStar", js);
/* 757 */           return oldItemValue;
/*     */         }
/*     */ 
/* 761 */         fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + (int)(Math.random() * 100000.0D);
/*     */ 
/* 764 */         FileFormat.CreateDirectory(filePath);
/*     */ 
/* 766 */         String oldfilePath = "";
/* 767 */         oldfilePath = this.request.getSession().getServletContext().getRealPath(String.format("/%1$s", new Object[] { oldItemValue }));
/* 768 */         FileFormat.DeleteFiles(oldfilePath);
/*     */ 
/* 771 */         String source = String.format("%1$s%4$s%2$s%3$s", new Object[] { filePath, fileName, fileExtension, WebConfig.getFileSeparator() });
/* 772 */         String minsorce=String.format("%1$s%4$s%2$smin%3$s", new Object[] { filePath, fileName, fileExtension, WebConfig.getFileSeparator() });
				  ImageMaxSave(fFile, source);
/*     */         ImageMinSave(source,minsorce);
/* 774 */         fileName = String.format("%1$s%2$s%3$s", new Object[] { urlPath, fileName, fileExtension });
				
/* 775 */         return fileName;
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/* 779 */         ex.printStackTrace();
/*     */       }
/*     */     }
/* 782 */     return oldItemValue;
/*     */   }
/*     */ 
/*     */   private boolean ImageMaxSave(File fFile, String FilePath)
/*     */   {
/*     */     try
/*     */     {
/* 800 */       InputStream is = new FileInputStream(fFile);
/* 801 */       OutputStream os = new FileOutputStream(FilePath);
				
/* 802 */       byte[] buffer = new byte[8192];
/* 803 */       int count = 0;
/* 804 */       while ((count = is.read(buffer)) > 0)
/*     */       {
/* 806 */         os.write(buffer, 0, count);
/*     */       }
/* 808 */       os.close();
/* 809 */       is.close();
/* 810 */       return true;
/*     */     }
/*     */     catch (FileNotFoundException e)
/*     */     {
/* 814 */       e.printStackTrace();
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 818 */       e.printStackTrace();
/*     */     }
/* 820 */     return false;
/*     */   }
/*     */ 
/*     */   protected boolean ImageMinSave(String source, String FilePath)
/*     */   {
/* 836 */     int NewWidth = 200;
/* 837 */     int NewHeight = 200;
/*     */ 		
/* 840 */     return ImageFormat.GenerateThumbnail(source, NewWidth, NewHeight, FilePath);
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.cultureproduce.Projectpic
 * JD-Core Version:    0.6.0
 */