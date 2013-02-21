package com.yun.ui.action.cultureproduce;

import java.io.UnsupportedEncodingException;
import java.rmi.server.ObjID;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.colorwinglib.Converts;
import com.colorwinglib.Requests;
import com.yun.bll.culture.IndustryProjectProvider;
import com.yun.common.MyDate;
import com.yun.common.Pager;
import com.yun.entities.culture.IndustryProjectInfo;
import com.yun.entities.culture.collection.IndustryProjectInfoCollection;
import com.yun.ui.action.UserLook;

public class IndustryProject
{


	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。
	 * 在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，
	 * 如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120518303835974L;

	// [start] Methods 全局变量
    /**
	 * 当前的页面列表数量
    */
	public int pageSize = com.yun.configuration.WebConfig.PAGE_SIZE;//当前的页面列表数量

    /**
	 * 页面分割的参数
    */
	public String pageParameter = "page";//页面分割的参数


	/**
	 * request请求对象
	 */
	javax.servlet.http.HttpServletRequest request = null;
	/**
	 * response响应对象
	 */
	javax.servlet.http.HttpServletResponse response = null;
	/**
	 * 向文本输出流打印对象的格式化表示形式。
	 */
	java.io.PrintWriter out = null;

	// [end]
	// [start] getpageListUrl
	private String getpageListUrl()
	{
		String params= com.yun.common.Pager.getCurrentlyParams(this.request);
        int pageIndex = com.colorwinglib.Requests.GetInt(request, pageParameter, 1);//当前的页数
        String pageListOrderByItem = com.colorwinglib.Requests.GetString(request, "OrderByItem", "DatabaseProjectID");//排序排序的字段名
        String pageListOrderByItemDESC = com.colorwinglib.Requests.GetString(request, "OrderByItemDESC", "DESC");//排序排序的顺序 DESC ASC
        String pageListOrderByItemDESCNo = pageListOrderByItemDESC.toLowerCase().equals("desc") ? "asc" : "desc";//排序排序的顺序 DESC ASC 的反顺序
        String pageListUrlOrderBy = String.format("%s%s=%s",params , pageParameter, pageIndex);//排序的?后的地址 (注意，这里一般要根据实际情况修改)
        String pageListUrl = String.format("%s&OrderByItem=%s&OrderByItemDESC=%s", pageListUrlOrderBy, pageListOrderByItem, pageListOrderByItemDESC);//显示列表的?后的地址 (注意，这里一般要根据实际情况修改)

		request.setAttribute("pageListOrderByItem", pageListOrderByItem);
		request.setAttribute("pageListOrderByItemDESC", pageListOrderByItemDESC);
		request.setAttribute("pageListOrderByItemDESCNo", pageListOrderByItemDESCNo);
		request.setAttribute("pageListUrlOrderBy", pageListUrlOrderBy);
		request.setAttribute("pageListUrl", pageListUrl);

		return pageListUrl;
	}
	// [end]

	// [start] execute
	  String pageListUrl="";
	/*     */   public String execute()
	/*     */     throws Exception
	/*     */   {
	/*  78 */     this.request = ServletActionContext.getRequest();
	/*  79 */     this.response = ServletActionContext.getResponse();
	/*     */ 	  
	/*  81 */     String af = null;
	/*  82 */     this.response.setCharacterEncoding("utf-8");
	/*  83 */     this.out = this.response.getWriter();
	/*  84 */      pageListUrl = getpageListUrl();
	/*     */ 
	/*  87 */     int Databaseprojectid = Requests.GetInt(this.request, "databaseprojectid", 0);
	/*     */ 
	/*  89 */     UserLook userlook = new UserLook(this.request, this.response);
	/*     */ 
	/*  93 */     String pageName = "IndustryProject";
	/*  94 */     String pagetype = Requests.GetString(this.request, "pagetype").toLowerCase();
	/*  95 */     IndustryProjectInfo industyrpro = new IndustryProjectInfo();
	/*  96 */     if (pagetype.equals("gotoinsert"))
	/*     */     {	
					userlook.seePageY("6");
	/*  98 */       this.request.setAttribute("btnEditText", "btnLog");
	/*  99 */       this.request.setAttribute("btnEditCommandArgument", Pager.getCurrentlyPage(this.request, "pagetype", "insert"));
	/*     */ 		this.request.setAttribute("title", "录入");
	/* 101 */       this.request.setAttribute("Logintime", Converts.DateToString(new Date(), "yyyy-MM-dd"));
	/*     */ 
	/* 103 */       this.request.setAttribute("sectorname", industyrpro.getObjSystemSectorInfoBySectorid(userlook.getSectorid()).getSectorname());
	/* 104 */       DrpInit();
	/*     */ 
	/* 106 */       af = String.format("%sInsert", new Object[] { pageName });
	/*     */     }
	/* 108 */     else if (pagetype.equals("insert"))
	/*     */     {	
					this.request.setAttribute("title", "录入");
	/* 110 */       this.request.setAttribute("btnEditText", "btnLog");
	/* 111 */       if(insert())
					{
		
					af = String.format("%sChainToPic", new Object[] { pageName });
					}
					else
					{
					af = String.format("%sInsert", new Object[] { pageName });
					}
	/* 112 */      	
	/*     */     }
	/* 114 */     else if (pagetype.equals("gotoupdate"))
	/*     */     {	
					userlook.seePageY("7");
	/* 116 */       DrpInit();
	/* 117 */       ItemCommandEdit();
	/* 118 */       this.request.setAttribute("btnEditText", "btnModify");
					this.request.setAttribute("title", "更新");
	/* 119 */       this.request.setAttribute("btnEditCommandArgument", pageListUrl+"&pagetype=update");
	/* 120 */       af = String.format("%sEdit", new Object[] { pageName });
	/*     */     }
	/* 122 */     else if (pagetype.equals("update"))
	/*     */     {
	/* 124 */       this.request.setAttribute("btnEditText", "btnModify");
					this.request.setAttribute("title", "更新");
					
	/* 125 */       update();
					DrpInit();
					ItemCommandEdit();
	/* 126 */       af = String.format("%sEdit", new Object[] { pageName });
	/*     */     }
	/* 128 */     else if (pagetype.equals("delete"))
	/*     */     {	
			
					userlook.seePageY("10");
	/* 130 */       delete();
					DrpInit();
					ListShow();
	/* 131 */       af = String.format("%sdata", new Object[] { pageName });
	/*     */     }
	/* 133 */     else if (pagetype.equals("details"))
	/*     */     {
	/* 135 */       ItemCommandDetails();
	/* 136 */       af = String.format("%sDetails", new Object[] { pageName });
	/* 137 */     } 
				  else if (pagetype.equals("updata")) {
					  
					  userlook.seePageY("8");
				       DrpInit();
				        if (Requests.GetString(this.request, "getdata").equals(
				         "1")) {
				        
				         ListShow();
				        	}
	        		af = String.format("%sdata", new Object[] { pageName });
				  	}
				  else if(pagetype.equals("select"))
				  {		
					  userlook.seePageY("8");
					
					  DrpInit();
					  ListShow();
					  af = String.format("%sList", new Object[] { pageName });
				  }
	/*     */     else
	/*     */     {
					userlook.seePageY("8");
					 
	/* 145 */       DrpInit();
	/* 146 */       ListShow();
	/* 147 */       af = String.format("%sList", new Object[] { pageName });
	/*     */     }
				
	/* 149 */     return af;
	/*     */   }
	// [end]
    

	// [start] 下拉列表初始化
    protected void DrpInit()
    {

        // [start] 经营单位
    //经营单位
    	/*  276 */     this.request.setAttribute("Logintime", new MyDate().getShortDate());
        com.yun.entities.culture.collection.EnterpriseInfoCollection EnterpriseColl = com.yun.bll.culture.EnterpriseProvider.getEnterpriseStatic();
        StringBuilder sbDatabaseenterpriseid = new StringBuilder(100);
        for (com.yun.entities.culture.EnterpriseInfo objEnterpriseInfo : EnterpriseColl)
        {
            sbDatabaseenterpriseid.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objEnterpriseInfo.getDatabaseenterpriseid(), objEnterpriseInfo.getEnterprisename()));
        }
        
		request.setAttribute("DatabaseenterpriseidEdit", sbDatabaseenterpriseid.toString());
		request.setAttribute("DatabaseenterpriseidList", sbDatabaseenterpriseid.toString());
        // [end]
        // [start] 建设性质
    //建设性质
        com.yun.entities.culture.collection.ProjectQualityInfoCollection ProjectQualityColl = com.yun.bll.culture.ProjectQualityProvider.getProjectQualityStatic();
        StringBuilder sbProquality = new StringBuilder(100);
        for (com.yun.entities.culture.ProjectQualityInfo objProjectQualityInfo : ProjectQualityColl)
        {
            sbProquality.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objProjectQualityInfo.getProqulidatabaseid(), objProjectQualityInfo.getProquliname()));
        }

		request.setAttribute("ProqualityEdit", sbProquality.toString());
		request.setAttribute("ProqualityList", sbProquality.toString());
        // [end]
        // [start] 审批,核准,备案
    //审批,核准,备案
        com.yun.entities.culture.collection.ShbInfoCollection ShbColl = com.yun.bll.culture.ShbProvider.getShbStatic();
        StringBuilder sbShb = new StringBuilder(100);
        for (com.yun.entities.culture.ShbInfo objShbInfo : ShbColl)
        {
            sbShb.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objShbInfo.getShbdatabaseid(), objShbInfo.getShbname()));
        }

		request.setAttribute("ShbEdit", sbShb.toString());
		request.setAttribute("ShbList", sbShb.toString());
        // [end]
        // [start] 环评批复
    //环评批复
        com.yun.entities.culture.collection.HuanpiInfoCollection HuanpiColl = com.yun.bll.culture.HuanpiProvider.getHuanpiStatic();
        StringBuilder sbHppf = new StringBuilder(100);
        for (com.yun.entities.culture.HuanpiInfo objHuanpiInfo : HuanpiColl)
        {
            sbHppf.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objHuanpiInfo.getHuanpidatabaseid(), objHuanpiInfo.getHuanpiname()));
        }

		request.setAttribute("HppfEdit", sbHppf.toString());
		request.setAttribute("HppfList", sbHppf.toString());
        // [end]
        // [start] 土地批准
    //土地批准
        com.yun.entities.culture.collection.TupiInfoCollection TupiColl = com.yun.bll.culture.TupiProvider.getTupiStatic();
        StringBuilder sbTdpz = new StringBuilder(100);
        for (com.yun.entities.culture.TupiInfo objTupiInfo : TupiColl)
        {
            sbTdpz.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objTupiInfo.getTupidatabaseid(), objTupiInfo.getTupiname()));
          
        }
		request.setAttribute("Tdpz", 2);// 土地批准 数据类型:int
		request.setAttribute("TdpzEdit", sbTdpz.toString());
		request.setAttribute("TdpzList", sbTdpz.toString());
        // [end]
        // [start] 规划选址
    //规划选址
        com.yun.entities.culture.collection.ProaddInfoCollection ProaddColl = com.yun.bll.culture.ProaddProvider.getProaddStatic();
        StringBuilder sbGhxz = new StringBuilder(100);
        for (com.yun.entities.culture.ProaddInfo objProaddInfo : ProaddColl)
        {
            sbGhxz.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objProaddInfo.getProadddatabaseid(), objProaddInfo.getProaddname()));
        }

		request.setAttribute("GhxzEdit", sbGhxz.toString());
		request.setAttribute("GhxzList", sbGhxz.toString());
        // [end]
        // [start] 所属区域
    //所属区域
        com.yun.entities.culture.collection.RegionsInfoCollection RegionsColl = com.yun.bll.culture.RegionsProvider.getRegionsStatic();
        StringBuilder sbRegionid = new StringBuilder(100);
        for (com.yun.entities.culture.RegionsInfo objRegionsInfo : RegionsColl)
        {
            sbRegionid.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objRegionsInfo.getRegiondatabaseid(), objRegionsInfo.getRegionname()));
        }

		request.setAttribute("RegionidEdit", sbRegionid.toString());
		request.setAttribute("RegionidList", sbRegionid.toString());
        // [end]
        // [start] 主管单位
    //主管单位
        com.yun.entities.culture.collection.UnitInfoCollection UnitColl = com.yun.bll.culture.UnitProvider.getUnitStatic();
        StringBuilder sbDutyunitid = new StringBuilder(100);
        for (com.yun.entities.culture.UnitInfo objUnitInfo : UnitColl)
        {
            sbDutyunitid.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objUnitInfo.getDatabaseunitid(), objUnitInfo.getUnitname()));
        }

		request.setAttribute("DutyunitidEdit", sbDutyunitid.toString());
		request.setAttribute("DutyunitidList", sbDutyunitid.toString());
        // [end]
        // [start] 产业类别
    //产业类别
        com.yun.entities.culture.collection.ProfessionInfoCollection ProfessionColl = com.yun.bll.culture.ProfessionProvider.getProfessionStatic();
        StringBuilder sbIndustryid = new StringBuilder(100);
        for (com.yun.entities.culture.ProfessionInfo objProfessionInfo : ProfessionColl)
        {
            sbIndustryid.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objProfessionInfo.getBusinessdatabaseid(), objProfessionInfo.getBusinesstypename()));
        }

		request.setAttribute("IndustryidEdit", sbIndustryid.toString());
		request.setAttribute("IndustryidList", sbIndustryid.toString());
        // [end]
        // [start] 填表人员
    //填表人员
        com.yun.entities.culture.collection.SystemAdminInfoCollection SystemAdminColl = com.yun.bll.culture.SystemAdminProvider.getSystemAdminStatic();
        StringBuilder sbDatabasepeopleid1 = new StringBuilder(100);
        for (com.yun.entities.culture.SystemAdminInfo objSystemAdminInfo : SystemAdminColl)
        {
            sbDatabasepeopleid1.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objSystemAdminInfo.getDatabaseadminid(), objSystemAdminInfo.getTruename()));
        }

		request.setAttribute("Databasepeopleid1Edit", sbDatabasepeopleid1.toString());
		request.setAttribute("Databasepeopleid1List", sbDatabasepeopleid1.toString());
        // [end]
        // [start] 统计人员
    //统计人员
        com.yun.entities.culture.collection.SystemAdminInfoCollection SystemAdminColl1 = com.yun.bll.culture.SystemAdminProvider.getSystemAdminStatic();
        StringBuilder sbDatabasepeopleid2 = new StringBuilder(100);
        for (com.yun.entities.culture.SystemAdminInfo objSystemAdminInfo : SystemAdminColl1)
        {
            sbDatabasepeopleid2.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objSystemAdminInfo.getDatabaseadminid(), objSystemAdminInfo.getTruename()));
        }
		request.setAttribute("Databasepeopleid2Edit", sbDatabasepeopleid2.toString());
		request.setAttribute("Databasepeopleid2List", sbDatabasepeopleid2.toString());
        // [end]
        // [start] 登录人员
    //登录人员
        com.yun.entities.culture.collection.SystemAdminInfoCollection SystemAdminColl2 = com.yun.bll.culture.SystemAdminProvider.getSystemAdminStatic();
        StringBuilder sbAdminid = new StringBuilder(100);
        for (com.yun.entities.culture.SystemAdminInfo objSystemAdminInfo : SystemAdminColl2)
        {
            sbAdminid.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objSystemAdminInfo.getDatabaseadminid(), objSystemAdminInfo.getTruename()));
        }

		request.setAttribute("AdminidEdit", sbAdminid.toString());
		request.setAttribute("AdminidList", sbAdminid.toString());
        // [end]
        // [start] 部门
    //部门
        com.yun.entities.culture.collection.SystemSectorInfoCollection SystemSectorColl = com.yun.bll.culture.SystemSectorProvider.getSystemSectorStatic();
        StringBuilder sbSectorid = new StringBuilder(100);
        for (com.yun.entities.culture.SystemSectorInfo objSystemSectorInfo : SystemSectorColl)
        {
            sbSectorid.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objSystemSectorInfo.getSectordatabaseid(), objSystemSectorInfo.getSectorname()));
        }
	
		request.setAttribute("SectoridEdit", sbSectorid.toString());
		request.setAttribute("SectoridList", sbSectorid.toString());
        // [end]
    }
	// [end]

	// [start] ListShow 显示数据列表
    protected void ListShow()
    {
		String pageListUrl = getpageListUrl();
		

        String OrderBy = "";//排序语句
        String pageListOrderByItem = com.colorwinglib.Requests.GetString(request, "OrderByItem", "DatabaseProjectID");//排序排序的字段名
        String pageListOrderByItemDESC = com.colorwinglib.Requests.GetString(request, "OrderByItemDESC", "DESC");//排序排序的顺序 DESC ASC
        if (pageListOrderByItem.length() > 0)
        {
              OrderBy = String.format("%s %s", pageListOrderByItem, pageListOrderByItemDESC);//排序语句
        }
        String projectnames=Requests.GetString(this.request, "projectnames","");
        try {
			projectnames= new   String(projectnames.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int regionids=Requests.GetInt(this.request, "regionids",0);
        int dutyunitids=Requests.GetInt(this.request, "dutyunitids",0);
        int industryids=Requests.GetInt(this.request, "industryids",0);
        Date createtimes=Requests.GetDate(this.request, "createtimes");
        Date s=Requests.GetDate(this.request, "s",new Date());
        int pageIndex = com.colorwinglib.Requests.GetInt(request, pageParameter, 1);//当前的页数
        int pageAll = 0;
        if(createtimes.equals(s))
        {
        	createtimes=null;
        	s=null;
        }
        pageAll = com.yun.bll.culture.IndustryProjectProvider.GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(projectnames, createtimes, s, regionids, dutyunitids, industryids, OrderBy);
        com.yun.entities.culture.collection.IndustryProjectInfoCollection IndustryProjectColl = com.yun.bll.culture.IndustryProjectProvider.GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(projectnames, createtimes, s, regionids, dutyunitids, industryids, OrderBy,pageIndex, pageSize);
		request.setAttribute("IndustryProjectList", IndustryProjectColl);
        //for (com.yun.entities.culture.IndustryProjectInfo objIndustryProjectInfo : IndustryProjectColl)
        //{
        //}


		// 输出分页信息
		String pageDetails = "";
		if (pageAll > pageSize)
			pageDetails = com.yun.common.Pager.LastNextPage(request, response, pageParameter, pageSize, pageAll);
			//pageDetails = com.yun.common.Pager.LastNextPageByAjax(request, response, pageParameter, pageSize, pageAll, "IndustryProjectAjaxPage");

		request.setAttribute("pageDetails", pageDetails);
		//显示数据不存在的消息
		if (pageAll == 0)
		{
			request.setAttribute("tbListHid", "display: none");
			java.util.HashMap<String,Object> valueMap = new java.util.HashMap<String,Object>();
			valueMap.put("text", "文化项目表");
			request.setAttribute("tbListHidShowMessage", com.yun.common.Message.GetMessage(com.yun.common.Message.I0000001, valueMap));
		}
    }
	// [end]
    

	// [start] ItemCommandEdit 转到编辑
    protected void ItemCommandEdit()
    {
    // 表主键字段
		int Databaseprojectid =  com.colorwinglib.Requests.GetInt(request, "databaseprojectid",0);//项目ID  数据类型:int
    
		String pageListUrl = getpageListUrl();
    
		com.yun.entities.culture.IndustryProjectInfo objIndustryProjectInfo = com.yun.bll.culture.IndustryProjectProvider.GetIndustryProjectInfoByDatabaseprojectid(Databaseprojectid);//实体类
        if (objIndustryProjectInfo != null)
        {
			request.setAttribute("Databaseprojectid", objIndustryProjectInfo.getDatabaseprojectid());//项目ID  数据类型:int
			request.setAttribute("Projectid", objIndustryProjectInfo.getProjectid());//项目编号  数据类型:int
			request.setAttribute("Projectname", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getProjectname()));//项目名称  数据类型:String
			request.setAttribute("Databaseenterpriseid", objIndustryProjectInfo.getDatabaseenterpriseid());//经营单位  数据类型:int
			request.setAttribute("DatabaseenterpriseidEnterprisename", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getObjEnterpriseInfoByDatabaseenterpriseid().getEnterprisename()));//经营单位  数据类型:int
			request.setAttribute("Proquality", objIndustryProjectInfo.getProquality());//建设性质  数据类型:int
			request.setAttribute("ProqualityProquliname", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getObjProjectQualityInfoByProquality().getProquliname()));//建设性质  数据类型:int
			request.setAttribute("Address", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getAddress()));//所在地址  数据类型:String
			request.setAttribute("Createtime", com.colorwinglib.Converts.DateToString(objIndustryProjectInfo.getCreatetime(),"yyyy-MM-dd"));//创建时间  数据类型:Date
			request.setAttribute("Plantime", com.colorwinglib.Converts.DateToString(objIndustryProjectInfo.getPlantime(),"yyyy-MM-dd"));//计划时间  数据类型:Date
			request.setAttribute("Completetime", com.colorwinglib.Converts.DateToString(objIndustryProjectInfo.getCompletetime(),"yyyy-MM-dd"));//完成时间  数据类型:Date
			request.setAttribute("Procontent", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getProcontent()));//项目内容  数据类型:String
			request.setAttribute("Planinvest", objIndustryProjectInfo.getPlaninvest());//计划投入资金  数据类型:double
			request.setAttribute("Totalinvest", objIndustryProjectInfo.getTotalinvest());//实际投入资金  数据类型:double
			request.setAttribute("Realinvest", objIndustryProjectInfo.getRealinvest());//RealInvest  数据类型:double
			request.setAttribute("Yearinvest", objIndustryProjectInfo.getYearinvest());//本年投入资金  数据类型:double
			request.setAttribute("Publicinvest", objIndustryProjectInfo.getPublicinvest());//政府投资  数据类型:double
			request.setAttribute("Selfinvest", objIndustryProjectInfo.getSelfinvest());//自筹  数据类型:double
			request.setAttribute("Bankloan", objIndustryProjectInfo.getBankloan());//银行  数据类型:double
			request.setAttribute("Shb", objIndustryProjectInfo.getShb());//审批,核准,备案  数据类型:int
			request.setAttribute("ShbShbname", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getObjShbInfoByShb().getShbname()));//审批,核准,备案  数据类型:int
			request.setAttribute("Hppf", objIndustryProjectInfo.getHppf());//环评批复  数据类型:int
			request.setAttribute("HppfHuanpiname", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getObjHuanpiInfoByHppf().getHuanpiname()));//环评批复  数据类型:int
			request.setAttribute("Tdpz", objIndustryProjectInfo.getTdpz());//土地批准  数据类型:int
			request.setAttribute("TdpzTupiname", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getObjTupiInfoByTdpz().getTupiname()));//土地批准  数据类型:int
			request.setAttribute("Ghxz", objIndustryProjectInfo.getGhxz());//规划选址  数据类型:int
			request.setAttribute("GhxzProaddname", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getObjProaddInfoByGhxz().getProaddname()));//规划选址  数据类型:int
			request.setAttribute("Regionid", objIndustryProjectInfo.getRegionid());//所属区域  数据类型:int
			request.setAttribute("RegionidRegionname", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getObjRegionsInfoByRegionid().getRegionname()));//所属区域  数据类型:int
			request.setAttribute("Dutyunitid", objIndustryProjectInfo.getDutyunitid());//主管单位  数据类型:int
			request.setAttribute("DutyunitidUnitname", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getObjUnitInfoByDutyunitid().getUnitname()));//主管单位  数据类型:int
			request.setAttribute("Industryid", objIndustryProjectInfo.getIndustryid());//产业类别  数据类型:int
			request.setAttribute("IndustryidBusinesstypename", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getObjProfessionInfoByIndustryid().getBusinesstypename()));//产业类别  数据类型:int
			request.setAttribute("Planprogress", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getPlanprogress()));//计划进度  数据类型:String
			request.setAttribute("Realprogress", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getRealprogress()));//实际进度  数据类型:String
			request.setAttribute("Feature", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getFeature()));//项目特色  数据类型:String
			request.setAttribute("State", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getState()));//经营状况  数据类型:String
			request.setAttribute("Linkman", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getLinkman()));//linkman  数据类型:String
			request.setAttribute("Phone", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getPhone()));//phone  数据类型:String
			request.setAttribute("Comment", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getComment()));//comment  数据类型:String
			request.setAttribute("Pic", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getPic()));//项目图片  数据类型:String
			request.setAttribute("Databasepeopleid1", objIndustryProjectInfo.getDatabasepeopleid1());//填表人员  数据类型:int
			request.setAttribute("Databasepeopleid1Truename", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getObjSystemAdminInfoByDatabasepeopleid1().getTruename()));//填表人员  数据类型:int
			request.setAttribute("Databasepeopleid2", objIndustryProjectInfo.getDatabasepeopleid2());//统计人员  数据类型:int
			request.setAttribute("Databasepeopleid2Truename", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getObjSystemAdminInfoByDatabasepeopleid2().getTruename()));//统计人员  数据类型:int
			request.setAttribute("Adminid", objIndustryProjectInfo.getAdminid());//登录人员  数据类型:int
			request.setAttribute("AdminidTruename", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getObjSystemAdminInfoByAdminid().getTruename()));//登录人员  数据类型:int
			request.setAttribute("Sectorid", objIndustryProjectInfo.getSectorid());//部门  数据类型:int
			request.setAttribute("SectoridSectorname", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getObjSystemSectorInfoBySectorid().getSectorname()));//部门  数据类型:int
			request.setAttribute("Logintime", com.colorwinglib.Converts.DateToString(objIndustryProjectInfo.getLogintime(),"yyyy-MM-dd"));//登录时间  数据类型:Date
			this.request.setAttribute("Shbno", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getShbno()));
			this.request.setAttribute("Hppfno",com.colorwinglib.StringFormat.HtmlEncode( objIndustryProjectInfo.getHppfno()));
			this.request.setAttribute("Tdpzno", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getTdpzno()));
			this.request.setAttribute("Ghxzno",com.colorwinglib.StringFormat.HtmlEncode( objIndustryProjectInfo.getGhxzno()));
        }
        else
        {
			String js = com.colorwinglib.Javascript.AlertAndRedirect(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000005), "?" + pageListUrl);
			request.setAttribute("pageJavaScripStar", js);
        }
    }
	// [end]
    

	// [start] ItemCommandDetails 转到展示
    protected void ItemCommandDetails()
    {
    // 表主键字段
		int Databaseprojectid =  com.colorwinglib.Requests.GetInt(request, "databaseprojectid",0);//项目ID  数据类型:int
    
		String pageListUrl = getpageListUrl();
    
		com.yun.entities.culture.IndustryProjectInfo objIndustryProjectInfo = com.yun.bll.culture.IndustryProjectProvider.GetIndustryProjectInfoByDatabaseprojectid(Databaseprojectid);//实体类
        if (objIndustryProjectInfo != null)
        {
			request.setAttribute("Databaseprojectid", objIndustryProjectInfo.getDatabaseprojectid());//项目ID  数据类型:int
			request.setAttribute("Projectid", objIndustryProjectInfo.getProjectid());//项目编号  数据类型:int
			request.setAttribute("Projectname", objIndustryProjectInfo.getProjectname());//项目名称  数据类型:String
			request.setAttribute("Databaseenterpriseid", objIndustryProjectInfo.getObjEnterpriseInfoByDatabaseenterpriseid().getEnterprisename());//经营单位  数据类型:int
			request.setAttribute("Proquality", objIndustryProjectInfo.getObjProjectQualityInfoByProquality().getProquliname());//建设性质  数据类型:int
			request.setAttribute("Address", objIndustryProjectInfo.getAddress());//所在地址  数据类型:String
			request.setAttribute("Createtime", com.colorwinglib.Converts.DateToString(objIndustryProjectInfo.getCreatetime(),"yyyy-MM-dd"));//创建时间  数据类型:Date
			request.setAttribute("Plantime", com.colorwinglib.Converts.DateToString(objIndustryProjectInfo.getPlantime(),"yyyy-MM-dd"));//计划时间  数据类型:Date
			request.setAttribute("Completetime", com.colorwinglib.Converts.DateToString(objIndustryProjectInfo.getCompletetime(),"yyyy-MM-dd"));//完成时间  数据类型:Date
			request.setAttribute("Procontent", objIndustryProjectInfo.getProcontent());//项目内容  数据类型:String
			request.setAttribute("Planinvest", objIndustryProjectInfo.getPlaninvest());//计划投入资金  数据类型:double
			request.setAttribute("Totalinvest", objIndustryProjectInfo.getTotalinvest());//实际投入资金  数据类型:double
			request.setAttribute("Realinvest", objIndustryProjectInfo.getRealinvest());//RealInvest  数据类型:double
			request.setAttribute("Yearinvest", objIndustryProjectInfo.getYearinvest());//本年投入资金  数据类型:double
			request.setAttribute("Publicinvest", objIndustryProjectInfo.getPublicinvest());//政府投资  数据类型:double
			request.setAttribute("Selfinvest", objIndustryProjectInfo.getSelfinvest());//自筹  数据类型:double
			request.setAttribute("Bankloan", objIndustryProjectInfo.getBankloan());//银行  数据类型:double
			request.setAttribute("Shb", objIndustryProjectInfo.getObjShbInfoByShb().getShbname());//审批,核准,备案  数据类型:int
			request.setAttribute("Hppf", objIndustryProjectInfo.getObjHuanpiInfoByHppf().getHuanpiname());//环评批复  数据类型:int
			request.setAttribute("Tdpz", objIndustryProjectInfo.getObjTupiInfoByTdpz().getTupiname());//土地批准  数据类型:int
			request.setAttribute("Ghxz", objIndustryProjectInfo.getObjProaddInfoByGhxz().getProaddname());//规划选址  数据类型:int
			request.setAttribute("Regionid", objIndustryProjectInfo.getObjRegionsInfoByRegionid().getRegionname());//所属区域  数据类型:int
			request.setAttribute("Dutyunitid", objIndustryProjectInfo.getObjUnitInfoByDutyunitid().getUnitname());//主管单位  数据类型:int
			request.setAttribute("Industryid", objIndustryProjectInfo.getObjProfessionInfoByIndustryid().getBusinesstypename());//产业类别  数据类型:int
			request.setAttribute("Planprogress", objIndustryProjectInfo.getPlanprogress());//计划进度  数据类型:String
			request.setAttribute("Realprogress", objIndustryProjectInfo.getRealprogress());//实际进度  数据类型:String
			request.setAttribute("Feature", objIndustryProjectInfo.getFeature());//项目特色  数据类型:String
			request.setAttribute("State", objIndustryProjectInfo.getState());//经营状况  数据类型:String
			request.setAttribute("Linkman", objIndustryProjectInfo.getLinkman());//linkman  数据类型:String
			request.setAttribute("Phone", objIndustryProjectInfo.getPhone());//phone  数据类型:String
			request.setAttribute("Comment", objIndustryProjectInfo.getComment());//comment  数据类型:String
			request.setAttribute("Pic", objIndustryProjectInfo.getPic());//项目图片  数据类型:String
			request.setAttribute("Databasepeopleid1", objIndustryProjectInfo.getObjSystemAdminInfoByDatabasepeopleid1().getTruename());//填表人员  数据类型:int
			request.setAttribute("Databasepeopleid2", objIndustryProjectInfo.getObjSystemAdminInfoByDatabasepeopleid2().getTruename());//统计人员  数据类型:int
			request.setAttribute("Adminid", objIndustryProjectInfo.getObjSystemAdminInfoByAdminid().getTruename());//登录人员  数据类型:int
			request.setAttribute("Sectorid", objIndustryProjectInfo.getObjSystemSectorInfoBySectorid().getSectorname());//部门  数据类型:int
			request.setAttribute("Logintime", com.colorwinglib.Converts.DateToString(objIndustryProjectInfo.getLogintime(),"yyyy-MM-dd"));//登录时间  数据类型:Date
			this.request.setAttribute("Shbno", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getShbno()));
			this.request.setAttribute("Hppfno",com.colorwinglib.StringFormat.HtmlEncode( objIndustryProjectInfo.getHppfno()));
			this.request.setAttribute("Tdpzno", com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getTdpzno()));
			this.request.setAttribute("Ghxzno",com.colorwinglib.StringFormat.HtmlEncode( objIndustryProjectInfo.getGhxzno()));


			//扩展属性
			//obj扩展属性
			request.setAttribute("EnterprisenameByDatabaseenterpriseid", objIndustryProjectInfo.getObjEnterpriseInfoByDatabaseenterpriseid().getEnterprisename());//经营单位  数据类型:int
			request.setAttribute("ProqulinameByProquality", objIndustryProjectInfo.getObjProjectQualityInfoByProquality().getProquliname());//建设性质  数据类型:int
			request.setAttribute("ShbnameByShb", objIndustryProjectInfo.getObjShbInfoByShb().getShbname());//审批,核准,备案  数据类型:int
			request.setAttribute("HuanpinameByHppf", objIndustryProjectInfo.getObjHuanpiInfoByHppf().getHuanpiname());//环评批复  数据类型:int
			request.setAttribute("TupinameByTdpz", objIndustryProjectInfo.getObjTupiInfoByTdpz().getTupiname());//土地批准  数据类型:int
			request.setAttribute("ProaddnameByGhxz", objIndustryProjectInfo.getObjProaddInfoByGhxz().getProaddname());//规划选址  数据类型:int
			request.setAttribute("RegionnameByRegionid", objIndustryProjectInfo.getObjRegionsInfoByRegionid().getRegionname());//所属区域  数据类型:int
			request.setAttribute("UnitnameByDutyunitid", objIndustryProjectInfo.getObjUnitInfoByDutyunitid().getUnitname());//主管单位  数据类型:int
			request.setAttribute("BusinesstypenameByIndustryid", objIndustryProjectInfo.getObjProfessionInfoByIndustryid().getBusinesstypename());//产业类别  数据类型:int
			request.setAttribute("TruenameByDatabasepeopleid1", objIndustryProjectInfo.getObjSystemAdminInfoByDatabasepeopleid1().getTruename());//填表人员  数据类型:int
			request.setAttribute("TruenameByDatabasepeopleid2", objIndustryProjectInfo.getObjSystemAdminInfoByDatabasepeopleid2().getTruename());//统计人员  数据类型:int
			request.setAttribute("TruenameByAdminid", objIndustryProjectInfo.getObjSystemAdminInfoByAdminid().getTruename());//登录人员  数据类型:int
			request.setAttribute("SectornameBySectorid", objIndustryProjectInfo.getObjSystemSectorInfoBySectorid().getSectorname());//部门  数据类型:int
        }
        else
        {
			String js = com.colorwinglib.Javascript.AlertAndRedirect(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000005), "?" + pageListUrl);
			request.setAttribute("pageJavaScripStar", js);
        }
    }
	// [end]
    

	// [start] ServerValidate 服务器验证
    protected boolean ServerValidate()
    {
        java.util.HashMap<String,Object> valueMap = new java.util.HashMap<String,Object>();
        StringBuilder sbStr = new StringBuilder(1024);
        int i = 1;
      
        // [start] 项目编号
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "项目编号");
        if (com.colorwinglib.Requests.GetString(request, "projectid").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "projectid")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "projectid")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
            i = i + 1;
        }
        IndustryProjectInfoCollection ipc=IndustryProjectProvider.GetListByProjectid(Requests.GetInt(this.request, "projectid"));
        if(ipc.size()>0)
        {
        	IndustryProjectInfo industryProject=ipc.get(0);
        	if(industryProject.getDatabaseprojectid()!=Requests.GetInt(this.request, "databaseprojectid"))
        	{
        		valueMap.put("param1",Requests.GetInt(request, "projectid"));
	        	sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000015, valueMap)));
	            i = i + 1;
        	}
        }
        
       
        // [end]
        // [start] 项目名称
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "项目名称");
        if (com.colorwinglib.Requests.GetString(request, "projectname").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }
        if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "projectname")) > 50)
        {
            valueMap.put("N", 50);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 经营单位
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "经营单位");
        if (com.colorwinglib.Requests.GetString(request, "databaseenterpriseid").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "databaseenterpriseid")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "databaseenterpriseid")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 建设性质
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "建设性质");
        if (com.colorwinglib.Requests.GetString(request, "proquality").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "proquality")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "proquality")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 所在地址
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "所在地址");
        if (com.colorwinglib.Requests.GetString(request, "address").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }
        if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "address")) > 100)
        {
            valueMap.put("N", 100);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 创建时间
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "创建时间");
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
        // [start] 计划时间
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "计划时间");
        if (com.colorwinglib.Requests.GetString(request, "plantime").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsDateString(com.colorwinglib.Requests.GetString(request, "plantime")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 完成时间
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "完成时间");
      
        if (!com.colorwinglib.Validate.IsDateString(com.colorwinglib.Requests.GetString(request, "completetime"))&&com.colorwinglib.Requests.GetString(request, "completetime").length() != 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 项目内容
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "项目内容");
        if (com.colorwinglib.Requests.GetString(request, "procontent").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }
        if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "procontent")) > 500)
        {
            valueMap.put("N", 500);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 计划投入资金
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "计划投入资金");
        if (com.colorwinglib.Requests.GetString(request, "planinvest").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "planinvest")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToDouble(com.colorwinglib.Requests.GetString(request, "planinvest")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 实际投入资金
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "总投入资金");
        if (com.colorwinglib.Requests.GetString(request, "totalinvest").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "totalinvest")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToDouble(com.colorwinglib.Requests.GetString(request, "totalinvest")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] RealInvest
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "实际投入资金");
        if (com.colorwinglib.Requests.GetString(request, "realinvest").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "realinvest")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToDouble(com.colorwinglib.Requests.GetString(request, "realinvest")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 本年投入资金
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "截止去年年底投入资金");
        if (com.colorwinglib.Requests.GetString(request, "yearinvest").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "yearinvest")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToDouble(com.colorwinglib.Requests.GetString(request, "yearinvest")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 政府投资
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "政府投资");
        if (com.colorwinglib.Requests.GetString(request, "publicinvest").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "publicinvest")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToDouble(com.colorwinglib.Requests.GetString(request, "publicinvest")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 自筹
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "自筹");
        if (com.colorwinglib.Requests.GetString(request, "selfinvest").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "selfinvest")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToDouble(com.colorwinglib.Requests.GetString(request, "selfinvest")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 银行
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "银行");
        if (com.colorwinglib.Requests.GetString(request, "bankloan").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "bankloan")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToDouble(com.colorwinglib.Requests.GetString(request, "bankloan")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 审批,核准,备案
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "审批,核准,备案");
        if (com.colorwinglib.Requests.GetString(request, "shb").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "shb")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "shb")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 环评批复
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "环评批复");
        if (com.colorwinglib.Requests.GetString(request, "hppf").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "hppf")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "hppf")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 土地批准
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "土地批准");
        if (com.colorwinglib.Requests.GetString(request, "tdpz").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "tdpz")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "tdpz")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 规划选址
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "规划选址");
        if (com.colorwinglib.Requests.GetString(request, "ghxz").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "ghxz")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "ghxz")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
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
        // [start] 主管单位
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "主管单位");
        if (com.colorwinglib.Requests.GetString(request, "dutyunitid").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "dutyunitid")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "dutyunitid")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 产业类别
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "产业类别");
        if (com.colorwinglib.Requests.GetString(request, "industryid").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumber(com.colorwinglib.Requests.GetString(request, "industryid")))
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000014, valueMap)));
            i = i + 1;
        }

        if (!com.colorwinglib.Validate.IsNumberRange(com.colorwinglib.Converts.StrToInt(com.colorwinglib.Requests.GetString(request, "industryid")),0,9999999))
        {
            valueMap.put("param1", 0);
            valueMap.put("param2", 9999999);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000005, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 计划进度
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "计划进度");
        if (com.colorwinglib.Requests.GetString(request, "planprogress").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }
        if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "planprogress")) > 100)
        {
            valueMap.put("N", 100);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 实际进度
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "实际进度");
        if (com.colorwinglib.Requests.GetString(request, "realprogress").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }
        if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "realprogress")) > 50)
        {
            valueMap.put("N", 50);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] 项目特色
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "项目特色");
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
        // [start] 经营状况
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "经营状况");
        if (com.colorwinglib.Requests.GetString(request, "state").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }
        if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "state")) > 50)
        {
            valueMap.put("N", 50);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] linkman
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "联系人");
        if (com.colorwinglib.Requests.GetString(request, "linkman").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }
        if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "linkman")) > 50)
        {
            valueMap.put("N", 50);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] phone
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "手机");
        if (com.colorwinglib.Requests.GetString(request, "phone").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }
        if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "phone")) > 20)
        {
            valueMap.put("N", 20);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
            i = i + 1;
        }
        // [end]
        // [start] comment
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "备注");
        if (com.colorwinglib.Requests.GetString(request, "comment").length() == 0)
        {
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000001, valueMap)));
            i = i + 1;
        }
        if (com.colorwinglib.Validate.getLength(com.colorwinglib.Requests.GetString(request, "comment")) > 200)
        {
            valueMap.put("N", 200);
            sbStr.append(String.format("%1$s.%2$s<br>",i , com.yun.common.Message.GetMessage(com.yun.common.Message.E0000003, valueMap)));
            i = i + 1;
        }
        // [end]
        
        // [start] 填表人员
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "填表人员");
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
        // [start] 统计人员
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "统计人员");
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
        // [start] 部门
        valueMap = new java.util.HashMap<String,Object>();
        valueMap.put("label_name", "部门");
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
    

	// [start] insert 添加
    protected boolean insert()
    {
    	
    	
		String pageListUrl = getpageListUrl();
    
		int Databaseprojectid =  com.colorwinglib.Requests.GetInt(request, "databaseprojectid",0);//项目ID  数据类型:int
		int Projectid =  com.colorwinglib.Requests.GetInt(request, "projectid",0);//项目编号  数据类型:int
		String Projectname =  com.colorwinglib.Requests.GetString(request, "projectname","");//项目名称  数据类型:String
		int Databaseenterpriseid =  com.colorwinglib.Requests.GetInt(request, "databaseenterpriseid",0);//经营单位  数据类型:int
		int Proquality =  com.colorwinglib.Requests.GetInt(request, "proquality",0);//建设性质  数据类型:int
		String Address =  com.colorwinglib.Requests.GetString(request, "address","");//所在地址  数据类型:String
		Date Createtime = com.colorwinglib.Requests.GetDate(request, "createtime",new Date());//创建时间  数据类型:Date
		Date Plantime =  com.colorwinglib.Requests.GetDate(request, "plantime",new Date());//计划时间  数据类型:Date
		Date Completetime =  null;
		if(request.getParameter("completetime")!=null&&!request.getParameter("completetime").equals(""))
		{
			Completetime=com.colorwinglib.Requests.GetDate(request, "completetime",new Date());//完成时间  数据类型:Date
		}
		String Procontent =  com.colorwinglib.Requests.GetString(request, "procontent","");//项目内容  数据类型:String
		double Planinvest =  com.colorwinglib.Requests.GetDouble(request, "planinvest",0);//计划投入资金  数据类型:double
		double Totalinvest =  com.colorwinglib.Requests.GetDouble(request, "totalinvest",0);//实际投入资金  数据类型:double
		double Realinvest =  com.colorwinglib.Requests.GetDouble(request, "realinvest",0);//RealInvest  数据类型:double
		double Yearinvest =  com.colorwinglib.Requests.GetDouble(request, "yearinvest",0);//本年投入资金  数据类型:double
		double Publicinvest =  com.colorwinglib.Requests.GetDouble(request, "publicinvest",0);//政府投资  数据类型:double
		double Selfinvest =  com.colorwinglib.Requests.GetDouble(request, "selfinvest",0);//自筹  数据类型:double
		double Bankloan =  com.colorwinglib.Requests.GetDouble(request, "bankloan",0);//银行  数据类型:double
		int Shb =  com.colorwinglib.Requests.GetInt(request, "shb",0);//审批,核准,备案  数据类型:int
		int Hppf =  com.colorwinglib.Requests.GetInt(request, "hppf",0);//环评批复  数据类型:int
		int Tdpz =  com.colorwinglib.Requests.GetInt(request, "tdpz",0);//土地批准  数据类型:int
		int Ghxz =  com.colorwinglib.Requests.GetInt(request, "ghxz",0);//规划选址  数据类型:int
		int Regionid =  com.colorwinglib.Requests.GetInt(request, "regionid",0);//所属区域  数据类型:int
		int Dutyunitid =  com.colorwinglib.Requests.GetInt(request, "dutyunitid",0);//主管单位  数据类型:int
		int Industryid =  com.colorwinglib.Requests.GetInt(request, "industryid",0);//产业类别  数据类型:int
		String Planprogress =  com.colorwinglib.Requests.GetString(request, "planprogress","");//计划进度  数据类型:String
		String Realprogress =  com.colorwinglib.Requests.GetString(request, "realprogress","");//实际进度  数据类型:String
		String Feature =  com.colorwinglib.Requests.GetString(request, "feature","");//项目特色  数据类型:String
		String State =  com.colorwinglib.Requests.GetString(request, "state","");//经营状况  数据类型:String
		String Linkman =  com.colorwinglib.Requests.GetString(request, "linkman","");//linkman  数据类型:String
		String Phone =  com.colorwinglib.Requests.GetString(request, "phone","");//phone  数据类型:String
		String Comment =  com.colorwinglib.Requests.GetString(request, "comment","");//comment  数据类型:String
		String Pic =  com.colorwinglib.Requests.GetString(request, "pic","");//项目图片  数据类型:String
		int Databasepeopleid1 =  com.colorwinglib.Requests.GetInt(request, "databasepeopleid1",0);//填表人员  数据类型:int
		int Databasepeopleid2 =  com.colorwinglib.Requests.GetInt(request, "databasepeopleid2",0);//统计人员  数据类型:int
		int Adminid =  com.colorwinglib.Requests.GetInt(request, "adminid",0);//登录人员  数据类型:int
		int Sectorid =  com.colorwinglib.Requests.GetInt(request, "sectorid",0);//部门  数据类型:int
		Date Logintime =  com.colorwinglib.Requests.GetDate(request, "logintime",new Date());//登录时间  数据类型:Date
		String Shbno=com.colorwinglib.Requests.GetString(request, "shbno","");
		String Hppfno=com.colorwinglib.Requests.GetString(request, "hppfno","");
		String Tdpzno=com.colorwinglib.Requests.GetString(request, "tdpzno","");
		String Ghxzno=com.colorwinglib.Requests.GetString(request, "ghxzno","");
        //服务器验证
        if (!ServerValidate())
        {
			//进行赋值验证失败时用
			DrpInit();
			request.setAttribute("Projectid", this.request.getParameter("projectid"));//项目编号  数据类型:int
			request.setAttribute("Projectname", com.colorwinglib.StringFormat.HtmlEncode(Projectname));//项目名称  数据类型:String
			request.setAttribute("Databaseenterpriseid", Databaseenterpriseid);//经营单位  数据类型:int
			request.setAttribute("DatabaseenterpriseidEnterprisename", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "databaseenterpriseidEnterprisename")));//经营单位  数据类型:int
			request.setAttribute("Proquality", Proquality);//建设性质  数据类型:int
			request.setAttribute("ProqualityProquliname", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "proqualityProquliname")));//建设性质  数据类型:int
			request.setAttribute("Address", com.colorwinglib.StringFormat.HtmlEncode(Address));//所在地址  数据类型:String
			request.setAttribute("Createtime", this.request.getParameter("createtime"));//创建时间  数据类型:Date
			request.setAttribute("Plantime",this.request.getParameter("plantime"));//计划时间  数据类型:Date
	
			request.setAttribute("Completetime", this.request.getParameter("completetime"));//完成时间  数据类型:Date
			request.setAttribute("Procontent", com.colorwinglib.StringFormat.HtmlEncode(Procontent));//项目内容  数据类型:String
			request.setAttribute("Planinvest", this.request.getParameter("planinvest"));//计划投入资金  数据类型:double
			request.setAttribute("Totalinvest", this.request.getParameter("totalinvest"));//实际投入资金  数据类型:double
			request.setAttribute("Realinvest", this.request.getParameter("realinvest"));//RealInvest  数据类型:double
			request.setAttribute("Yearinvest", this.request.getParameter("yearinvest"));//本年投入资金  数据类型:double
			request.setAttribute("Publicinvest", this.request.getParameter("publicinvest"));//政府投资  数据类型:double
			request.setAttribute("Selfinvest", this.request.getParameter("selfinvest"));//自筹  数据类型:double
			request.setAttribute("Bankloan", this.request.getParameter("bankloan"));//银行  数据类型:double
			request.setAttribute("Shb", this.request.getParameter("shb"));//审批,核准,备案  数据类型:int
			request.setAttribute("ShbShbname", com.colorwinglib.StringFormat.HtmlEncode(this.request.getParameter("shbShbname")));//审批,核准,备案  数据类型:int
			request.setAttribute("Hppf", Hppf);//环评批复  数据类型:int
			request.setAttribute("HppfHuanpiname", com.colorwinglib.StringFormat.HtmlEncode(this.request.getParameter("hppfHuanpiname")));//环评批复  数据类型:int
			request.setAttribute("Tdpz", Tdpz);//土地批准  数据类型:int
			request.setAttribute("TdpzTupiname", com.colorwinglib.StringFormat.HtmlEncode(this.request.getParameter("tdpzTupiname")));//土地批准  数据类型:int
			request.setAttribute("Ghxz", Ghxz);//规划选址  数据类型:int
			request.setAttribute("GhxzProaddname", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "ghxzProaddname")));//规划选址  数据类型:int
			request.setAttribute("Regionid", Regionid);//所属区域  数据类型:int
			request.setAttribute("RegionidRegionname", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "regionidRegionname")));//所属区域  数据类型:int
			request.setAttribute("Dutyunitid", Dutyunitid);//主管单位  数据类型:int
			request.setAttribute("DutyunitidUnitname", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "dutyunitidUnitname")));//主管单位  数据类型:int
			request.setAttribute("Industryid", Industryid);//产业类别  数据类型:int
			request.setAttribute("IndustryidBusinesstypename", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "industryidBusinesstypename")));//产业类别  数据类型:int
			request.setAttribute("Planprogress", com.colorwinglib.StringFormat.HtmlEncode(Planprogress));//计划进度  数据类型:String
			request.setAttribute("Realprogress", com.colorwinglib.StringFormat.HtmlEncode(Realprogress));//实际进度  数据类型:String
			request.setAttribute("Feature", com.colorwinglib.StringFormat.HtmlEncode(Feature));//项目特色  数据类型:String
			request.setAttribute("State", com.colorwinglib.StringFormat.HtmlEncode(State));//经营状况  数据类型:String
			request.setAttribute("Linkman", com.colorwinglib.StringFormat.HtmlEncode(Linkman));//linkman  数据类型:String
			request.setAttribute("Phone", com.colorwinglib.StringFormat.HtmlEncode(Phone));//phone  数据类型:String
			request.setAttribute("Comment", com.colorwinglib.StringFormat.HtmlEncode(Comment));//comment  数据类型:String
			request.setAttribute("Pic", com.colorwinglib.StringFormat.HtmlEncode(Pic));//项目图片  数据类型:String
			request.setAttribute("Databasepeopleid1", Databasepeopleid1);//填表人员  数据类型:int
			request.setAttribute("Databasepeopleid1Truename", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "databasepeopleid1Truename")));//填表人员  数据类型:int
			request.setAttribute("Databasepeopleid2", Databasepeopleid2);//统计人员  数据类型:int
			request.setAttribute("Databasepeopleid2Truename", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "databasepeopleid2Truename")));//统计人员  数据类型:int
			request.setAttribute("Adminid", Adminid);//登录人员  数据类型:int
			request.setAttribute("AdminidTruename", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "adminidTruename")));//登录人员  数据类型:int
			request.setAttribute("Sectorid", Sectorid);//部门  数据类型:int
			request.setAttribute("SectoridSectorname", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "sectoridSectorname")));//部门  数据类型:int
			request.setAttribute("Logintime", new java.text.SimpleDateFormat("yyyy-MM-dd").format(Logintime));//登录时间  数据类型:Date
			this.request.setAttribute("Shbno", Shbno);
			this.request.setAttribute("Hppfno", Hppfno);
			this.request.setAttribute("Tdpzno", Tdpzno);
			this.request.setAttribute("Ghxzno", Ghxzno);
			return false;
        }

		com.yun.entities.culture.IndustryProjectInfo objIndustryProjectInfo = new com.yun.entities.culture.IndustryProjectInfo();//实体类
		objIndustryProjectInfo.setDatabaseprojectid(Databaseprojectid);//项目ID  数据类型:int
		objIndustryProjectInfo.setProjectid(Projectid);//项目编号  数据类型:int
		objIndustryProjectInfo.setProjectname(Projectname);//项目名称  数据类型:String
		objIndustryProjectInfo.setDatabaseenterpriseid(Databaseenterpriseid);//经营单位  数据类型:int
		objIndustryProjectInfo.setProquality(Proquality);//建设性质  数据类型:int
		objIndustryProjectInfo.setAddress(Address);//所在地址  数据类型:String
		objIndustryProjectInfo.setCreatetime(Createtime);//创建时间  数据类型:Date
		objIndustryProjectInfo.setPlantime(Plantime);//计划时间  数据类型:Date
		objIndustryProjectInfo.setCompletetime(Completetime);//完成时间  数据类型:Date
		objIndustryProjectInfo.setProcontent(Procontent);//项目内容  数据类型:String
		objIndustryProjectInfo.setPlaninvest(Planinvest);//计划投入资金  数据类型:double
		objIndustryProjectInfo.setTotalinvest(Totalinvest);//实际投入资金  数据类型:double
		objIndustryProjectInfo.setRealinvest(Realinvest);//RealInvest  数据类型:double
		objIndustryProjectInfo.setYearinvest(Yearinvest);//本年投入资金  数据类型:double
		objIndustryProjectInfo.setPublicinvest(Publicinvest);//政府投资  数据类型:double
		objIndustryProjectInfo.setSelfinvest(Selfinvest);//自筹  数据类型:double
		objIndustryProjectInfo.setBankloan(Bankloan);//银行  数据类型:double
		objIndustryProjectInfo.setShb(Shb);//审批,核准,备案  数据类型:int
		objIndustryProjectInfo.setHppf(Hppf);//环评批复  数据类型:int
		objIndustryProjectInfo.setTdpz(Tdpz);//土地批准  数据类型:int
		objIndustryProjectInfo.setGhxz(Ghxz);//规划选址  数据类型:int
		objIndustryProjectInfo.setRegionid(Regionid);//所属区域  数据类型:int
		objIndustryProjectInfo.setDutyunitid(Dutyunitid);//主管单位  数据类型:int
		objIndustryProjectInfo.setIndustryid(Industryid);//产业类别  数据类型:int
		objIndustryProjectInfo.setPlanprogress(Planprogress);//计划进度  数据类型:String
		objIndustryProjectInfo.setRealprogress(Realprogress);//实际进度  数据类型:String
		objIndustryProjectInfo.setFeature(Feature);//项目特色  数据类型:String
		objIndustryProjectInfo.setState(State);//经营状况  数据类型:String
		objIndustryProjectInfo.setLinkman(Linkman);//linkman  数据类型:String
		objIndustryProjectInfo.setPhone(Phone);//phone  数据类型:String
		objIndustryProjectInfo.setComment(Comment);//comment  数据类型:String
		objIndustryProjectInfo.setPic(Pic);//项目图片  数据类型:String
		objIndustryProjectInfo.setDatabasepeopleid1(Databasepeopleid1);//填表人员  数据类型:int
		objIndustryProjectInfo.setDatabasepeopleid2(Databasepeopleid2);//统计人员  数据类型:int
		objIndustryProjectInfo.setAdminid(Adminid);//登录人员  数据类型:int
		objIndustryProjectInfo.setSectorid(Sectorid);//部门  数据类型:int
		objIndustryProjectInfo.setLogintime(Logintime);//登录时间  数据类型:Date
		objIndustryProjectInfo.setShbno(Shbno);
		objIndustryProjectInfo.setHppfno(Hppfno);
		objIndustryProjectInfo.setTdpzno(Tdpzno);
		objIndustryProjectInfo.setGhxzno(Ghxzno);
        boolean isRun = com.yun.bll.culture.IndustryProjectProvider.Insert(objIndustryProjectInfo);

		if (isRun)
		{
			String js = com.colorwinglib.Javascript.AlertAndRedirect(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000002), "?pagetype=gotoinsert&" + pageListUrl);
		if (com.colorwinglib.Requests.GetInt(request, "isSaveAndNew") == 1)
		{
			js = com.colorwinglib.Javascript.AlertAndRedirect(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000002), "?pagetype=gotoinsert&" + pageListUrl);
		}
			request.setAttribute("IndustryProjectDatabaseID", objIndustryProjectInfo.getDatabaseenterpriseid());
			request.setAttribute("pageJavaScripStar", js);
			return true;
		}
		else
		{
			String js = com.colorwinglib.Javascript.AlertAndRedirect(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000009), "?pagetype=gotoinsert&" + pageListUrl);
		if (com.colorwinglib.Requests.GetInt(request, "isSaveAndNew") == 1)
		{
			js = com.colorwinglib.Javascript.AlertAndRedirect(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000009), "?pagetype=gotoinsert&" + pageListUrl);
		}
			request.setAttribute("pageJavaScripStar", js);
			
		}
        com.yun.bll.culture.IndustryProjectProvider.setIndustryProjectStatic(null);
        return false;
    }
	// [end]
    

	// [start] update 更新
    protected void update()
    {
		String pageListUrl = getpageListUrl();
    
		int Databaseprojectid = com.colorwinglib.Requests.GetInt(request, "databaseprojectid",0);//项目ID  数据类型:int
		int Projectid = com.colorwinglib.Requests.GetInt(request, "projectid",0);//项目编号  数据类型:int
		String Projectname = com.colorwinglib.Requests.GetString(request, "projectname","");//项目名称  数据类型:String
		int Databaseenterpriseid = com.colorwinglib.Requests.GetInt(request, "databaseenterpriseid",0);//经营单位  数据类型:int
		int Proquality = com.colorwinglib.Requests.GetInt(request, "proquality",0);//建设性质  数据类型:int
		String Address = com.colorwinglib.Requests.GetString(request, "address","");//所在地址  数据类型:String
		Date Createtime = com.colorwinglib.Requests.GetDate(request, "createtime",new Date());//创建时间  数据类型:Date
		Date Plantime = com.colorwinglib.Requests.GetDate(request, "plantime",new Date());//计划时间  数据类型:Date
		Date Completetime=null ;
		if(request.getParameter("completetime")!=null&&!request.getParameter("completetime").equals(""))
		{
			Completetime= com.colorwinglib.Requests.GetDate(request, "completetime",new Date());//完成时间  数据类型:Date
		}
		String Procontent = com.colorwinglib.Requests.GetString(request, "procontent","");//项目内容  数据类型:String
		double Planinvest = com.colorwinglib.Requests.GetDouble(request, "planinvest",0);//计划投入资金  数据类型:double
		double Totalinvest = com.colorwinglib.Requests.GetDouble(request, "totalinvest",0);//实际投入资金  数据类型:double
		double Realinvest = com.colorwinglib.Requests.GetDouble(request, "realinvest",0);//RealInvest  数据类型:double
		double Yearinvest = com.colorwinglib.Requests.GetDouble(request, "yearinvest",0);//本年投入资金  数据类型:double
		double Publicinvest = com.colorwinglib.Requests.GetDouble(request, "publicinvest",0);//政府投资  数据类型:double
		double Selfinvest = com.colorwinglib.Requests.GetDouble(request, "selfinvest",0);//自筹  数据类型:double
		double Bankloan = com.colorwinglib.Requests.GetDouble(request, "bankloan",0);//银行  数据类型:double
		int Shb = com.colorwinglib.Requests.GetInt(request, "shb",0);//审批,核准,备案  数据类型:int
		int Hppf = com.colorwinglib.Requests.GetInt(request, "hppf",0);//环评批复  数据类型:int
		int Tdpz = com.colorwinglib.Requests.GetInt(request, "tdpz",0);//土地批准  数据类型:int
		int Ghxz = com.colorwinglib.Requests.GetInt(request, "ghxz",0);//规划选址  数据类型:int
		String Shbno=com.colorwinglib.Requests.GetString(request, "shbno","");
		String Hppfno=com.colorwinglib.Requests.GetString(request, "hppfno","");
		String Tdpzno=com.colorwinglib.Requests.GetString(request, "tdpzno","");
		String Ghxzno=com.colorwinglib.Requests.GetString(request, "ghxzno","");
		int Regionid = com.colorwinglib.Requests.GetInt(request, "regionid",0);//所属区域  数据类型:int
		int Dutyunitid = com.colorwinglib.Requests.GetInt(request, "dutyunitid",0);//主管单位  数据类型:int
		int Industryid = com.colorwinglib.Requests.GetInt(request, "industryid",0);//产业类别  数据类型:int
		String Planprogress = com.colorwinglib.Requests.GetString(request, "planprogress","");//计划进度  数据类型:String
		String Realprogress = com.colorwinglib.Requests.GetString(request, "realprogress","");//实际进度  数据类型:String
		String Feature = com.colorwinglib.Requests.GetString(request, "feature","");//项目特色  数据类型:String
		String State = com.colorwinglib.Requests.GetString(request, "state","");//经营状况  数据类型:String
		String Linkman = com.colorwinglib.Requests.GetString(request, "linkman","");//linkman  数据类型:String
		String Phone = com.colorwinglib.Requests.GetString(request, "phone","");//phone  数据类型:String
		String Comment = com.colorwinglib.Requests.GetString(request, "comment","");//comment  数据类型:String
		String Pic = com.colorwinglib.Requests.GetString(request, "pic","");//项目图片  数据类型:String
		int Databasepeopleid1 = com.colorwinglib.Requests.GetInt(request, "databasepeopleid1",0);//填表人员  数据类型:int
		int Databasepeopleid2 = com.colorwinglib.Requests.GetInt(request, "databasepeopleid2",0);//统计人员  数据类型:int
		int Adminid = com.colorwinglib.Requests.GetInt(request, "adminid",0);//登录人员  数据类型:int
		int Sectorid = com.colorwinglib.Requests.GetInt(request, "sectorid",0);//部门  数据类型:int
		Date Logintime = com.colorwinglib.Requests.GetDate(request, "logintime",new Date());//登录时间  数据类型:Date

        //服务器验证
        if (!ServerValidate())
        {
			//进行赋值验证失败时用
			DrpInit();
		
			request.setAttribute("Databaseprojectid", Databaseprojectid);//项目ID  数据类型:int
			request.setAttribute("Projectid", Projectid);//项目编号  数据类型:int
			request.setAttribute("Projectname", com.colorwinglib.StringFormat.HtmlEncode(Projectname));//项目名称  数据类型:String
			request.setAttribute("Databaseenterpriseid", Databaseenterpriseid);//经营单位  数据类型:int
			request.setAttribute("DatabaseenterpriseidEnterprisename", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "databaseenterpriseidEnterprisename")));//经营单位  数据类型:int
			request.setAttribute("Proquality", Proquality);//建设性质  数据类型:int
			request.setAttribute("ProqualityProquliname", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "proqualityProquliname")));//建设性质  数据类型:int
			request.setAttribute("Address", com.colorwinglib.StringFormat.HtmlEncode(Address));//所在地址  数据类型:String
			request.setAttribute("Createtime", new java.text.SimpleDateFormat("yyyy-MM-dd").format(Createtime));//创建时间  数据类型:Date
			request.setAttribute("Plantime", new java.text.SimpleDateFormat("yyyy-MM-dd").format(Plantime));//计划时间  数据类型:Date
			
			if(Completetime!=null)
			{	
				request.setAttribute("Completetime", new java.text.SimpleDateFormat("yyyy-MM-dd").format(Completetime));//完成时间  数据类型:Date
			}
			
			request.setAttribute("Procontent", com.colorwinglib.StringFormat.HtmlEncode(Procontent));//项目内容  数据类型:String
			request.setAttribute("Planinvest", Planinvest);//计划投入资金  数据类型:double
			request.setAttribute("Totalinvest", Totalinvest);//实际投入资金  数据类型:double
			request.setAttribute("Realinvest", Realinvest);//RealInvest  数据类型:double
			request.setAttribute("Yearinvest", Yearinvest);//本年投入资金  数据类型:double
			request.setAttribute("Publicinvest", Publicinvest);//政府投资  数据类型:double
			request.setAttribute("Selfinvest", Selfinvest);//自筹  数据类型:double
			request.setAttribute("Bankloan", Bankloan);//银行  数据类型:double
			request.setAttribute("Shb", Shb);//审批,核准,备案  数据类型:int
			request.setAttribute("ShbShbname", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "shbShbname")));//审批,核准,备案  数据类型:int
			request.setAttribute("Hppf", Hppf);//环评批复  数据类型:int
			request.setAttribute("HppfHuanpiname", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "hppfHuanpiname")));//环评批复  数据类型:int
			request.setAttribute("Tdpz", Tdpz);//土地批准  数据类型:int
			request.setAttribute("TdpzTupiname", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "tdpzTupiname")));//土地批准  数据类型:int
			request.setAttribute("Ghxz", Ghxz);//规划选址  数据类型:int
			request.setAttribute("GhxzProaddname", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "ghxzProaddname")));//规划选址  数据类型:int
			this.request.setAttribute("Shbno", Shbno);
			this.request.setAttribute("Hppfno", Hppfno);
			this.request.setAttribute("Tdpzno", Tdpzno);
			this.request.setAttribute("Ghxzno", Ghxzno);
			request.setAttribute("Regionid", Regionid);//所属区域  数据类型:int
			request.setAttribute("RegionidRegionname", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "regionidRegionname")));//所属区域  数据类型:int
			request.setAttribute("Dutyunitid", Dutyunitid);//主管单位  数据类型:int
			request.setAttribute("DutyunitidUnitname", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "dutyunitidUnitname")));//主管单位  数据类型:int
			request.setAttribute("Industryid", Industryid);//产业类别  数据类型:int
			request.setAttribute("IndustryidBusinesstypename", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "industryidBusinesstypename")));//产业类别  数据类型:int
			request.setAttribute("Planprogress", com.colorwinglib.StringFormat.HtmlEncode(Planprogress));//计划进度  数据类型:String
			request.setAttribute("Realprogress", com.colorwinglib.StringFormat.HtmlEncode(Realprogress));//实际进度  数据类型:String
			request.setAttribute("Feature", com.colorwinglib.StringFormat.HtmlEncode(Feature));//项目特色  数据类型:String
			request.setAttribute("State", com.colorwinglib.StringFormat.HtmlEncode(State));//经营状况  数据类型:String
			request.setAttribute("Linkman", com.colorwinglib.StringFormat.HtmlEncode(Linkman));//linkman  数据类型:String
			request.setAttribute("Phone", com.colorwinglib.StringFormat.HtmlEncode(Phone));//phone  数据类型:String
			request.setAttribute("Comment", com.colorwinglib.StringFormat.HtmlEncode(Comment));//comment  数据类型:String
			request.setAttribute("Pic", com.colorwinglib.StringFormat.HtmlEncode(Pic));//项目图片  数据类型:String
			request.setAttribute("Databasepeopleid1", Databasepeopleid1);//填表人员  数据类型:int
			request.setAttribute("Databasepeopleid1Truename", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "databasepeopleid1Truename")));//填表人员  数据类型:int
			request.setAttribute("Databasepeopleid2", Databasepeopleid2);//统计人员  数据类型:int
			request.setAttribute("Databasepeopleid2Truename", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "databasepeopleid2Truename")));//统计人员  数据类型:int
			request.setAttribute("Adminid", Adminid);//登录人员  数据类型:int
			request.setAttribute("AdminidTruename", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "adminidTruename")));//登录人员  数据类型:int
			request.setAttribute("Sectorid", Sectorid);//部门  数据类型:int
			request.setAttribute("SectoridSectorname", com.colorwinglib.StringFormat.HtmlEncode(com.colorwinglib.Requests.GetString(request, "sectoridSectorname")));//部门  数据类型:int
			request.setAttribute("Logintime", new java.text.SimpleDateFormat("yyyy-MM-dd").format(Logintime));//登录时间  数据类型:Date
            return;
        }


		com.yun.entities.culture.IndustryProjectInfo objIndustryProjectInfo = com.yun.bll.culture.IndustryProjectProvider.GetIndustryProjectInfoByDatabaseprojectid(Databaseprojectid);//实体类
		objIndustryProjectInfo.setDatabaseprojectid(Databaseprojectid);//项目ID  数据类型:int
		objIndustryProjectInfo.setProjectid(Projectid);//项目编号  数据类型:int
		objIndustryProjectInfo.setProjectname(Projectname);//项目名称  数据类型:String
		objIndustryProjectInfo.setDatabaseenterpriseid(Databaseenterpriseid);//经营单位  数据类型:int
		objIndustryProjectInfo.setProquality(Proquality);//建设性质  数据类型:int
		objIndustryProjectInfo.setAddress(Address);//所在地址  数据类型:String
		objIndustryProjectInfo.setCreatetime(Createtime);//创建时间  数据类型:Date
		objIndustryProjectInfo.setPlantime(Plantime);//计划时间  数据类型:Date
		objIndustryProjectInfo.setCompletetime(Completetime);//完成时间  数据类型:Date
		objIndustryProjectInfo.setProcontent(Procontent);//项目内容  数据类型:String
		objIndustryProjectInfo.setPlaninvest(Planinvest);//计划投入资金  数据类型:double
		objIndustryProjectInfo.setTotalinvest(Totalinvest);//实际投入资金  数据类型:double
		objIndustryProjectInfo.setRealinvest(Realinvest);//RealInvest  数据类型:double
		objIndustryProjectInfo.setYearinvest(Yearinvest);//本年投入资金  数据类型:double
		objIndustryProjectInfo.setPublicinvest(Publicinvest);//政府投资  数据类型:double
		objIndustryProjectInfo.setSelfinvest(Selfinvest);//自筹  数据类型:double
		objIndustryProjectInfo.setBankloan(Bankloan);//银行  数据类型:double
		objIndustryProjectInfo.setShb(Shb);//审批,核准,备案  数据类型:int
		objIndustryProjectInfo.setHppf(Hppf);//环评批复  数据类型:int
		objIndustryProjectInfo.setTdpz(Tdpz);//土地批准  数据类型:int
		objIndustryProjectInfo.setGhxz(Ghxz);//规划选址  数据类型:int
		objIndustryProjectInfo.setRegionid(Regionid);//所属区域  数据类型:int
		objIndustryProjectInfo.setDutyunitid(Dutyunitid);//主管单位  数据类型:int
		objIndustryProjectInfo.setIndustryid(Industryid);//产业类别  数据类型:int
		objIndustryProjectInfo.setPlanprogress(Planprogress);//计划进度  数据类型:String
		objIndustryProjectInfo.setRealprogress(Realprogress);//实际进度  数据类型:String
		objIndustryProjectInfo.setFeature(Feature);//项目特色  数据类型:String
		objIndustryProjectInfo.setState(State);//经营状况  数据类型:String
		objIndustryProjectInfo.setLinkman(Linkman);//linkman  数据类型:String
		objIndustryProjectInfo.setPhone(Phone);//phone  数据类型:String
		objIndustryProjectInfo.setComment(Comment);//comment  数据类型:String
		objIndustryProjectInfo.setPic(Pic);//项目图片  数据类型:String
		objIndustryProjectInfo.setDatabasepeopleid1(Databasepeopleid1);//填表人员  数据类型:int
		objIndustryProjectInfo.setDatabasepeopleid2(Databasepeopleid2);//统计人员  数据类型:int
		objIndustryProjectInfo.setAdminid(Adminid);//登录人员  数据类型:int
		objIndustryProjectInfo.setSectorid(Sectorid);//部门  数据类型:int
		objIndustryProjectInfo.setLogintime(Logintime);//登录时间  数据类型:Date
		objIndustryProjectInfo.setShbno(Shbno);
		objIndustryProjectInfo.setHppfno(Hppfno);
		objIndustryProjectInfo.setTdpzno(Tdpzno);
		objIndustryProjectInfo.setGhxzno(Ghxzno);
        boolean isRun = com.yun.bll.culture.IndustryProjectProvider.UpdateByDatabaseprojectid(objIndustryProjectInfo);
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
	
        com.yun.bll.culture.IndustryProjectProvider.setIndustryProjectStatic(null);
    }
	// [end]
    

	// [start] delete 删除
    protected void delete()
    {
    // 表主键字段
		int Databaseprojectid =  com.colorwinglib.Requests.GetInt(request, "databaseprojectid",0);//项目ID  数据类型:int
    
		String pageListUrl = getpageListUrl();
    


		boolean isRun = com.yun.bll.culture.IndustryProjectProvider.DeleteByDatabaseprojectid(Databaseprojectid);//直接删除

        com.yun.bll.culture.IndustryProjectProvider.setIndustryProjectStatic(null);
		if (isRun)
		{
			String js = com.colorwinglib.Javascript.Alert(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000007));
			request.setAttribute("pageJavaScripStar", js);
		}
		else
		{
			String js = com.colorwinglib.Javascript.Alert(request, response, com.yun.common.Message.GetMessage(com.yun.common.Message.I0000008));
			request.setAttribute("pageJavaScripStar", js);
		}
    }
	// [end]
    


}

