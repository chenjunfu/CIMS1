/*     */ package com.yun.ui.action;
/*     */ 
/*     */ import com.colorwinglib.Requests;
/*     */ import com.colorwinglib.StringFormat;
/*     */ import com.yun.bll.culture.IndustryProjectProvider;
/*     */ import com.yun.entities.culture.IndustryProjectInfo;
/*     */ import com.yun.entities.culture.collection.IndustryProjectInfoCollection;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.struts2.ServletActionContext;
/*     */ 
/*     */ public class procExcel
/*     */ {
/*     */   private static final long serialVersionUID = 2011112513152100033L;
/*  14 */   public int pageSize = 10;
/*     */ 
/*  19 */   public String pageParameter = "page";
/*     */ 
/*  24 */   HttpServletRequest request = null;
/*     */ 
/*  28 */   HttpServletResponse response = null;
/*     */ 
/*  32 */   PrintWriter out = null;
/*     */ 
/*     */   private String getpageListUrl()
/*     */   {
/*  38 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/*  39 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "DatabaseEnterpriseID");
/*  40 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/*  41 */     String pageListOrderByItemDESCNo = pageListOrderByItemDESC.toLowerCase().equals("desc") ? "asc" : "desc";
/*  42 */     String Createtime1s = Requests.GetString(this.request, "createtime1s", "");
/*  43 */     String Createtime2s = Requests.GetString(this.request, "createtime2s", "");
/*  44 */     String Regionids = Requests.GetString(this.request, "regionids", "");
/*  45 */     String pageListUrlOrderBy = String.format("%s=%s&createtime1s=%s&createtime2s=%s&regionids=%s", new Object[] { this.pageParameter, Integer.valueOf(pageIndex), StringFormat.UrlEncode(Createtime1s), StringFormat.UrlEncode(Createtime2s), StringFormat.UrlEncode(Regionids) });
/*  46 */     String pageListUrl = String.format("%s&OrderByItem=%s&OrderByItemDESC=%s", new Object[] { pageListUrlOrderBy, pageListOrderByItem, pageListOrderByItemDESC });
/*     */ 
/*  48 */     this.request.setAttribute("pageListOrderByItem", pageListOrderByItem);
/*  49 */     this.request.setAttribute("pageListOrderByItemDESC", pageListOrderByItemDESC);
/*  50 */     this.request.setAttribute("pageListOrderByItemDESCNo", pageListOrderByItemDESCNo);
/*  51 */     this.request.setAttribute("pageListUrlOrderBy", pageListUrlOrderBy);
/*  52 */     this.request.setAttribute("pageListUrl", pageListUrl);
/*     */ 
/*  54 */     return pageListUrl;
/*     */   }
/*     */ 
/*     */   public String execute()
/*     */     throws Exception
/*     */   {
/*  65 */     this.request = ServletActionContext.getRequest();
/*  66 */     this.response = ServletActionContext.getResponse();
/*     */ 
/*  68 */     String af = null;
/*  69 */     this.response.setCharacterEncoding("utf-8");
/*  70 */     this.out = this.response.getWriter();
/*  71 */     String pageListUrl = getpageListUrl();
/*     */ 
/*  74 */     int Databaseenterpriseid = Requests.GetInt(this.request, "databaseenterpriseid", 0);
/*     */ 
/*  77 */     String pageName = "Enterprise";
/*  78 */     String pagetype = Requests.GetString(this.request, "pagetype").toLowerCase();
/*  79 */     if (pagetype.equals("excel"))
/*     */     {
/*  81 */       Excel();
/*     */ 
/*  84 */       af = null;
/*     */     }
/*  86 */     return af;
/*     */   }
/*     */ 
/*     */   protected void Excel()
/*     */   {
/*  94 */     ExportExcelXml();
/*     */   }
/*     */ 
/*     */   protected void ExportExcelXml()
/*     */   {
/*  99 */     StringBuilder sbStr = new StringBuilder(1024);
/*     */ 
/* 101 */     sbStr.append("<?xml version=\"1.0\" ?>");
/* 102 */     sbStr.append("<?mso-application progid=\"Excel.Sheet\"?>");
/* 103 */     sbStr.append("<Workbook xmlns=\"urn:schemas-microsoft-com:office:spreadsheet\" xmlns:o=\"urn:schemas-microsoft-com:office:office\"");
/* 104 */     sbStr.append("    xmlns:x=\"urn:schemas-microsoft-com:office:excel\" xmlns:ss=\"urn:schemas-microsoft-com:office:spreadsheet\"");
/* 105 */     sbStr.append("    xmlns:html=\"http://www.w3.org/TR/REC-html40\">");
/* 106 */     sbStr.append("    <DocumentProperties xmlns=\"urn:schemas-microsoft-com:office:office\">");
/* 107 */     sbStr.append("        <Author>���Ƿ�</Author>");
/* 108 */     sbStr.append("        <LastAuthor>���Ƿ�</LastAuthor>");
/* 109 */     sbStr.append("        <Created>2011-12-3 17:11:11</Created>");
/* 110 */     sbStr.append("        <Company>hg</Company>");
/* 111 */     sbStr.append("        <Version>11.5606</Version>");
/* 112 */     sbStr.append("    </DocumentProperties>");
/* 113 */     sbStr.append("    <ExcelWorkbook xmlns=\"urn:schemas-microsoft-com:office:excel\">");
/* 114 */     sbStr.append("        <WindowHeight>9090</WindowHeight>");
/* 115 */     sbStr.append("        <WindowWidth>10380</WindowWidth>");
/* 116 */     sbStr.append("        <WindowTopX>360</WindowTopX>");
/* 117 */     sbStr.append("        <WindowTopY>45</WindowTopY>");
/* 118 */     sbStr.append("        <ProtectStructure>False</ProtectStructure>");
/* 119 */     sbStr.append("        <ProtectWindows>False</ProtectWindows>");
/* 120 */     sbStr.append("    </ExcelWorkbook>");
/* 121 */     sbStr.append(" <Styles>\n");
/* 122 */     sbStr.append("  <Style ss:ID=\"Default\" ss:Name=\"Normal\">\n");
/* 123 */     sbStr.append("   <Alignment ss:Vertical=\"Center\"/>\n");
/* 124 */     sbStr.append("   <Borders/>\n");
/* 125 */     sbStr.append("   <Font ss:FontName=\"����\" x:CharSet=\"134\" ss:Size=\"12\"/>\n");
/* 126 */     sbStr.append("   <Interior/>\n");
/* 127 */     sbStr.append("   <NumberFormat/>\n");
/* 128 */     sbStr.append("   <Protection/>\n");
/* 129 */     sbStr.append("  </Style>\n");
/* 130 */     sbStr.append("  <Style ss:ID=\"s22\">\n");
/* 131 */     sbStr.append("   <Alignment ss:Horizontal=\"Center\" ss:Vertical=\"Center\"/>\n");
/* 132 */     sbStr.append("  </Style>\n");
/* 133 */     sbStr.append(" </Styles>\n");
/*     */ 
/* 135 */     sbStr.append("    <Worksheet ss:Name=\"Sheet1\">");
/* 136 */     sbStr.append("        <Table>");
/* 137 */     sbStr.append("  <Row>\n");
/* 138 */     sbStr.append("        <Cell ss:MergeAcross=\"24\" ss:StyleID=\"s22\"><Data ss:Type=\"String\">��������Ļ���Ŀͳ��</Data></Cell>\n");
/* 139 */     sbStr.append("       </Row>\n");
/*     */ 
/* 141 */     sbStr.append("<Row>");
/*     */ 
/* 144 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 145 */     sbStr.append("��ĿID");
/* 146 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 148 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 149 */     sbStr.append("��Ŀ���");
/* 150 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 152 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 153 */     sbStr.append("��Ŀ���");
/* 154 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 156 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 157 */     sbStr.append("��������");
/* 158 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 160 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 161 */     sbStr.append("���ڵ�ַ");
/* 162 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 164 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 165 */     sbStr.append("���ܵ�λ");
/* 166 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 168 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 169 */     sbStr.append("��Ӫ��λ");
/* 170 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 172 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 173 */     sbStr.append("��Ŀ����");
/* 174 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 176 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 177 */     sbStr.append("��ҵ���");
/* 178 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 180 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 181 */     sbStr.append("��Ŀ��ɫ");
/* 182 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 184 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 185 */     sbStr.append("Ͷ���ʽ�");
/* 186 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 188 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 189 */     sbStr.append("�ʽ���Դ");
/* 190 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 192 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 193 */     sbStr.append("�ʽ����");
/* 194 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 196 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 197 */     sbStr.append("�ƻ����");
/* 198 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 200 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 201 */     sbStr.append("����ʱ��");
/* 202 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 204 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 205 */     sbStr.append("���ʱ��");
/* 206 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 208 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 209 */     sbStr.append("��Ӫ״��");
/* 210 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 212 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 213 */     sbStr.append("��ĿͼƬ");
/* 214 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 216 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 217 */     sbStr.append("�����Ա");
/* 218 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 220 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 221 */     sbStr.append("ͳ����Ա");
/* 222 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 224 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 225 */     sbStr.append("��¼��Ա");
/* 226 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 228 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 229 */     sbStr.append("SectorID");
/* 230 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 232 */     sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 233 */     sbStr.append("��¼ʱ��");
/* 234 */     sbStr.append("</Data></Cell>");
/*     */ 
/* 236 */     sbStr.append("</Row>");
/* 237 */     String OrderBy = "";
/* 238 */     String pageListOrderByItem = Requests.GetString(this.request, "OrderByItem", "DatabaseProjectID");
/* 239 */     String pageListOrderByItemDESC = Requests.GetString(this.request, "OrderByItemDESC", "DESC");
/* 240 */     if (pageListOrderByItem.length() > 0)
/*     */     {
/* 242 */       OrderBy = String.format("%s %s", new Object[] { pageListOrderByItem, pageListOrderByItemDESC });
/*     */     }
/* 244 */     int pageIndex = Requests.GetInt(this.request, this.pageParameter, 1);
/* 245 */     int pageAll = IndustryProjectProvider.GetListPagerBy();
/* 246 */     IndustryProjectInfoCollection IndustryProjectColl = IndustryProjectProvider.GetListPagerBy(OrderBy, pageIndex, this.pageSize);
/* 247 */     for (IndustryProjectInfo objIndustryProjectInfo : IndustryProjectColl)
/*     */     {
/* 249 */       sbStr.append("<Row>");
/*     */ 
/* 252 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 253 */       sbStr.append(objIndustryProjectInfo.getDatabaseprojectid());
/* 254 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 256 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 257 */       sbStr.append(objIndustryProjectInfo.getProjectid());
/* 258 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 260 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 261 */       sbStr.append(objIndustryProjectInfo.getProjectname());
/* 262 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 264 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 265 */       sbStr.append(objIndustryProjectInfo.getRegionid());
/* 266 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 268 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 269 */       sbStr.append(objIndustryProjectInfo.getAddress());
/* 270 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 272 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 273 */       sbStr.append(objIndustryProjectInfo.getDutyunitid());
/* 274 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 276 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 277 */       sbStr.append(objIndustryProjectInfo.getDatabaseenterpriseid());
/* 278 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 280 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 281 */       sbStr.append(objIndustryProjectInfo.getProcontent());
/* 282 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 284 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 285 */       sbStr.append(objIndustryProjectInfo.getIndustryid());
/* 286 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 288 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 289 */       sbStr.append(objIndustryProjectInfo.getFeature());
/* 290 */       sbStr.append("</Data></Cell>");
/*     */ 
/*     */ 
/* 304 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 305 */       sbStr.append(objIndustryProjectInfo.getPlanprogress());
/* 306 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 308 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 309 */       sbStr.append(objIndustryProjectInfo.getCreatetime());
/* 310 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 312 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 313 */       sbStr.append(objIndustryProjectInfo.getCompletetime());
/* 314 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 316 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 317 */       sbStr.append(objIndustryProjectInfo.getState());
/* 318 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 320 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 321 */       sbStr.append(objIndustryProjectInfo.getPic());
/* 322 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 324 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 325 */       sbStr.append(objIndustryProjectInfo.getDatabasepeopleid1());
/* 326 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 328 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 329 */       sbStr.append(objIndustryProjectInfo.getDatabasepeopleid2());
/* 330 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 332 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 333 */       sbStr.append(objIndustryProjectInfo.getAdminid());
/* 334 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 336 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 337 */       sbStr.append(objIndustryProjectInfo.getSectorid());
/* 338 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 340 */       sbStr.append("<Cell><Data ss:Type=\"String\">");
/* 341 */       sbStr.append(objIndustryProjectInfo.getLogintime());
/* 342 */       sbStr.append("</Data></Cell>");
/*     */ 
/* 344 */       sbStr.append("</Row>");
/*     */     }
/*     */ 
/* 347 */     sbStr.append("        </Table>");
/* 348 */     sbStr.append("        <WorksheetOptions xmlns=\"urn:schemas-microsoft-com:office:excel\">");
/* 349 */     sbStr.append("            <Selected />");
/* 350 */     sbStr.append("            <ProtectObjects>False</ProtectObjects>");
/* 351 */     sbStr.append("            <ProtectScenarios>False</ProtectScenarios>");
/* 352 */     sbStr.append("        </WorksheetOptions>");
/* 353 */     sbStr.append("    </Worksheet>");
/* 354 */     sbStr.append("</Workbook>");
/*     */ 
/* 356 */     String temp = String.format("attachment;filename=%1$s", new Object[] { "ExportData.xls" });
/* 357 */     this.response.addHeader("Content-disposition", temp);
/* 358 */     this.out.write(sbStr.toString());
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator.J-2813E3D2AB6F4\桌面\WebRoot\WEB-INF\classes\
 * Qualified Name:     com.yun.ui.action.procExcel
 * JD-Core Version:    0.6.0
 */