
package com.yun.entities.culture;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.entities.culture.base.*;

/**
 * IndustryProject 文化项目表的摘要说明
 */
public class IndustryProjectInfo extends IndustryProjectInfoBase implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120315202451593L;

	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public IndustryProjectInfo()
	{
		super();
	}
	 //[end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public IndustryProjectInfo(int sDatabaseprojectid)
	{
		super(sDatabaseprojectid);
	}
	 //[end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 * @throws SQLException
	 */
	public IndustryProjectInfo(ResultSet rs) throws SQLException
	{
		super(rs);
	}
	 //[end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 * @throws SQLException
	 */
	public IndustryProjectInfo(ResultSet rs, String[] columnNames) throws SQLException
	{
		super(rs, columnNames);
	}
	 //[end]
	
	// [start] 获取 企业信息表 字段：DatabaseEnterpriseID Databaseenterpriseid 经营单位
	private EnterpriseInfo objEnterpriseInfoByDatabaseenterpriseid = null;

	/**
	 * 获取 企业信息表
	 * @return
	 */
	public EnterpriseInfo getObjEnterpriseInfoByDatabaseenterpriseid()
	{
		//企业信息表
		//if (objEnterpriseInfoByDatabaseenterpriseid == null)
		//	objEnterpriseInfoByDatabaseenterpriseid = com.yun.bll.culture.EnterpriseProvider.GetEnterpriseInfoStaticByDatabaseenterpriseid(getDatabaseenterpriseid());

		if (objEnterpriseInfoByDatabaseenterpriseid == null)
			objEnterpriseInfoByDatabaseenterpriseid = com.yun.bll.culture.EnterpriseProvider.GetEnterpriseInfoByDatabaseenterpriseid(getDatabaseenterpriseid());

		if (objEnterpriseInfoByDatabaseenterpriseid == null)
			return new EnterpriseInfo();
		else
			return this.objEnterpriseInfoByDatabaseenterpriseid;

	}
	// [end]
	// [start] 获取 项目性质 字段：ProQuality Proquality 建设性质
	private ProjectQualityInfo objProjectQualityInfoByProquality = null;

	/**
	 * 获取 项目性质
	 * @return
	 */
	public ProjectQualityInfo getObjProjectQualityInfoByProquality()
	{
		//项目性质
		//if (objProjectQualityInfoByProquality == null)
		//	objProjectQualityInfoByProquality = com.yun.bll.culture.ProjectQualityProvider.GetProjectQualityInfoStaticByProqulidatabaseid(getProquality());

		if (objProjectQualityInfoByProquality == null)
			objProjectQualityInfoByProquality = com.yun.bll.culture.ProjectQualityProvider.getProjectQualityStatic().GetProjectQualityInfoByProqulidatabaseid(getProquality());

		if (objProjectQualityInfoByProquality == null)
			return new ProjectQualityInfo();
		else
			return this.objProjectQualityInfoByProquality;

	}
	// [end]
	// [start] 获取 数据库ID 字段：shb Shb 审批,核准,备案
	private ShbInfo objShbInfoByShb = null;

	/**
	 * 获取 数据库ID
	 * @return
	 */
	public ShbInfo getObjShbInfoByShb()
	{
		//数据库ID
		//if (objShbInfoByShb == null)
		//	objShbInfoByShb = com.yun.bll.culture.ShbProvider.GetShbInfoStaticByShbdatabaseid(getShb());

		if (objShbInfoByShb == null)
			objShbInfoByShb = com.yun.bll.culture.ShbProvider.getShbStatic().GetShbInfoByShbdatabaseid(getShb());

		if (objShbInfoByShb == null)
			return new ShbInfo();
		else
			return this.objShbInfoByShb;

	}
	// [end]
	// [start] 获取 数据库ID 字段：hppf Hppf 环评批复
	private HuanpiInfo objHuanpiInfoByHppf = null;

	/**
	 * 获取 数据库ID
	 * @return
	 */
	public HuanpiInfo getObjHuanpiInfoByHppf()
	{
		//数据库ID
		//if (objHuanpiInfoByHppf == null)
		//	objHuanpiInfoByHppf = com.yun.bll.culture.HuanpiProvider.GetHuanpiInfoStaticByHuanpidatabaseid(getHppf());

		if (objHuanpiInfoByHppf == null)
			objHuanpiInfoByHppf = com.yun.bll.culture.HuanpiProvider.getHuanpiStatic().GetHuanpiInfoByHuanpidatabaseid(getHppf());

		if (objHuanpiInfoByHppf == null)
			return new HuanpiInfo();
		else
			return this.objHuanpiInfoByHppf;

	}
	// [end]
	// [start] 获取 数据库ID 字段：tdpz Tdpz 土地批准
	private TupiInfo objTupiInfoByTdpz = null;

	/**
	 * 获取 数据库ID
	 * @return
	 */
	public TupiInfo getObjTupiInfoByTdpz()
	{
		//数据库ID
		//if (objTupiInfoByTdpz == null)
		//	objTupiInfoByTdpz = com.yun.bll.culture.TupiProvider.GetTupiInfoStaticByTupidatabaseid(getTdpz());

		if (objTupiInfoByTdpz == null)
			objTupiInfoByTdpz = com.yun.bll.culture.TupiProvider.getTupiStatic().GetTupiInfoByTupidatabaseid(getTdpz());

		if (objTupiInfoByTdpz == null)
			return new TupiInfo();
		else
			return this.objTupiInfoByTdpz;

	}
	// [end]
	// [start] 获取 数据库ID 字段：ghxz Ghxz 规划选址
	private ProaddInfo objProaddInfoByGhxz = null;

	/**
	 * 获取 数据库ID
	 * @return
	 */
	public ProaddInfo getObjProaddInfoByGhxz()
	{
		//数据库ID
		//if (objProaddInfoByGhxz == null)
		//	objProaddInfoByGhxz = com.yun.bll.culture.ProaddProvider.GetProaddInfoStaticByProadddatabaseid(getGhxz());

		if (objProaddInfoByGhxz == null)
			objProaddInfoByGhxz = com.yun.bll.culture.ProaddProvider.getProaddStatic().GetProaddInfoByProadddatabaseid(getGhxz());

		if (objProaddInfoByGhxz == null)
			return new ProaddInfo();
		else
			return this.objProaddInfoByGhxz;

	}
	// [end]
	// [start] 获取 郑州市地区表 字段：RegionID Regionid 所属区域
	private RegionsInfo objRegionsInfoByRegionid = null;

	/**
	 * 获取 郑州市地区表
	 * @return
	 */
	public RegionsInfo getObjRegionsInfoByRegionid()
	{
		//郑州市地区表
		//if (objRegionsInfoByRegionid == null)
		//	objRegionsInfoByRegionid = com.yun.bll.culture.RegionsProvider.GetRegionsInfoStaticByRegiondatabaseid(getRegionid());

		if (objRegionsInfoByRegionid == null)
			objRegionsInfoByRegionid = com.yun.bll.culture.RegionsProvider.getRegionsStatic().GetRegionsInfoByRegiondatabaseid(getRegionid());

		if (objRegionsInfoByRegionid == null)
			return new RegionsInfo();
		else
			return this.objRegionsInfoByRegionid;

	}
	// [end]
	// [start] 获取 单位信息 字段：DutyUnitID Dutyunitid 主管单位
	private UnitInfo objUnitInfoByDutyunitid = null;

	/**
	 * 获取 单位信息
	 * @return
	 */
	public UnitInfo getObjUnitInfoByDutyunitid()
	{
		//单位信息
		//if (objUnitInfoByDutyunitid == null)
		//	objUnitInfoByDutyunitid = com.yun.bll.culture.UnitProvider.GetUnitInfoStaticByDatabaseunitid(getDutyunitid());

		if (objUnitInfoByDutyunitid == null)
			objUnitInfoByDutyunitid = com.yun.bll.culture.UnitProvider.getUnitStatic().GetUnitInfoByDatabaseunitid(getDutyunitid());

		if (objUnitInfoByDutyunitid == null)
			return new UnitInfo();
		else
			return this.objUnitInfoByDutyunitid;

	}
	// [end]
	// [start] 获取 行业类别表 字段：IndustryID Industryid 产业类别
	private ProfessionInfo objProfessionInfoByIndustryid = null;

	/**
	 * 获取 行业类别表
	 * @return
	 */
	public ProfessionInfo getObjProfessionInfoByIndustryid()
	{
		//行业类别表
		//if (objProfessionInfoByIndustryid == null)
		//	objProfessionInfoByIndustryid = com.yun.bll.culture.ProfessionProvider.GetProfessionInfoStaticByBusinessdatabaseid(getIndustryid());

		if (objProfessionInfoByIndustryid == null)
			objProfessionInfoByIndustryid = com.yun.bll.culture.ProfessionProvider.getProfessionStatic().GetProfessionInfoByBusinessdatabaseid(getIndustryid());

		if (objProfessionInfoByIndustryid == null)
			return new ProfessionInfo();
		else
			return this.objProfessionInfoByIndustryid;

	}
	// [end]
	// [start] 获取 系统人员表 字段：DatabasePeopleID1 Databasepeopleid1 填表人员
	private SystemAdminInfo objSystemAdminInfoByDatabasepeopleid1 = null;

	/**
	 * 获取 系统人员表
	 * @return
	 */
	public SystemAdminInfo getObjSystemAdminInfoByDatabasepeopleid1()
	{
		//系统人员表
		//if (objSystemAdminInfoByDatabasepeopleid1 == null)
		//	objSystemAdminInfoByDatabasepeopleid1 = com.yun.bll.culture.SystemAdminProvider.GetSystemAdminInfoStaticByDatabaseadminid(getDatabasepeopleid1());

		if (objSystemAdminInfoByDatabasepeopleid1 == null)
			objSystemAdminInfoByDatabasepeopleid1 = com.yun.bll.culture.SystemAdminProvider.getSystemAdminStatic().GetSystemAdminInfoByDatabaseadminid(getDatabasepeopleid1());

		if (objSystemAdminInfoByDatabasepeopleid1 == null)
			return new SystemAdminInfo();
		else
			return this.objSystemAdminInfoByDatabasepeopleid1;

	}
	// [end]
	// [start] 获取 系统人员表 字段：DatabasePeopleID2 Databasepeopleid2 统计人员
	private SystemAdminInfo objSystemAdminInfoByDatabasepeopleid2 = null;

	/**
	 * 获取 系统人员表
	 * @return
	 */
	public SystemAdminInfo getObjSystemAdminInfoByDatabasepeopleid2()
	{
		//系统人员表
		//if (objSystemAdminInfoByDatabasepeopleid2 == null)
		//	objSystemAdminInfoByDatabasepeopleid2 = com.yun.bll.culture.SystemAdminProvider.GetSystemAdminInfoStaticByDatabaseadminid(getDatabasepeopleid2());

		if (objSystemAdminInfoByDatabasepeopleid2 == null)
			objSystemAdminInfoByDatabasepeopleid2 = com.yun.bll.culture.SystemAdminProvider.getSystemAdminStatic().GetSystemAdminInfoByDatabaseadminid(getDatabasepeopleid2());

		if (objSystemAdminInfoByDatabasepeopleid2 == null)
			return new SystemAdminInfo();
		else
			return this.objSystemAdminInfoByDatabasepeopleid2;

	}
	// [end]
	// [start] 获取 系统人员表 字段：AdminID Adminid 登录人员
	private SystemAdminInfo objSystemAdminInfoByAdminid = null;

	/**
	 * 获取 系统人员表
	 * @return
	 */
	public SystemAdminInfo getObjSystemAdminInfoByAdminid()
	{
		//系统人员表
		//if (objSystemAdminInfoByAdminid == null)
		//	objSystemAdminInfoByAdminid = com.yun.bll.culture.SystemAdminProvider.GetSystemAdminInfoStaticByDatabaseadminid(getAdminid());

		if (objSystemAdminInfoByAdminid == null)
			objSystemAdminInfoByAdminid = com.yun.bll.culture.SystemAdminProvider.getSystemAdminStatic().GetSystemAdminInfoByDatabaseadminid(getAdminid());

		if (objSystemAdminInfoByAdminid == null)
			return new SystemAdminInfo();
		else
			return this.objSystemAdminInfoByAdminid;

	}
	// [end]
	// [start] 获取 部门表 字段：SectorID Sectorid 部门
	private SystemSectorInfo objSystemSectorInfoBySectorid = null;

	/**
	 * 获取 部门表
	 * @return
	 */
	public SystemSectorInfo getObjSystemSectorInfoBySectorid()
	{
		//部门表
		//if (objSystemSectorInfoBySectorid == null)
		//	objSystemSectorInfoBySectorid = com.yun.bll.culture.SystemSectorProvider.GetSystemSectorInfoStaticBySectordatabaseid(getSectorid());

		if (objSystemSectorInfoBySectorid == null)
			objSystemSectorInfoBySectorid = com.yun.bll.culture.SystemSectorProvider.getSystemSectorStatic().GetSystemSectorInfoBySectordatabaseid(getSectorid());

		if (objSystemSectorInfoBySectorid == null)
			return new SystemSectorInfo();
		else
			return this.objSystemSectorInfoBySectorid;

	}
	public SystemSectorInfo getObjSystemSectorInfoBySectorid(int id)
	{
		//部门表
		//if (objSystemSectorInfoBySectorid == null)
		//	objSystemSectorInfoBySectorid = com.yun.bll.culture.SystemSectorProvider.GetSystemSectorInfoStaticBySectordatabaseid(getSectorid());
		setSectorid(id);
		if (objSystemSectorInfoBySectorid == null)
			objSystemSectorInfoBySectorid = com.yun.bll.culture.SystemSectorProvider.getSystemSectorStatic().GetSystemSectorInfoBySectordatabaseid(getSectorid());

		if (objSystemSectorInfoBySectorid == null)
			return new SystemSectorInfo();
		else
			return this.objSystemSectorInfoBySectorid;

	}
	// [end]
	

	// [start]清空缓存数据

	/**
	 * 清空缓存数据
	 *
	 * @return
	 */
	public void setNull()
	{
		// 经营单位
		objEnterpriseInfoByDatabaseenterpriseid = null;
		// 建设性质
		objProjectQualityInfoByProquality = null;
		// 审批,核准,备案
		objShbInfoByShb = null;
		// 环评批复
		objHuanpiInfoByHppf = null;
		// 土地批准
		objTupiInfoByTdpz = null;
		// 规划选址
		objProaddInfoByGhxz = null;
		// 所属区域
		objRegionsInfoByRegionid = null;
		// 主管单位
		objUnitInfoByDutyunitid = null;
		// 产业类别
		objProfessionInfoByIndustryid = null;
		// 填表人员
		objSystemAdminInfoByDatabasepeopleid1 = null;
		// 统计人员
		objSystemAdminInfoByDatabasepeopleid2 = null;
		// 登录人员
		objSystemAdminInfoByAdminid = null;
		// 部门
		objSystemSectorInfoBySectorid = null;
	}

	// [end]

	 //[end]
	


}
