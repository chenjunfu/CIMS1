
package com.yun.entities.culture;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.entities.culture.base.*;

/**
 * Enterprise 企业信息表的摘要说明
 */
public class EnterpriseInfo extends EnterpriseInfoBase implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311472565698L;

	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public EnterpriseInfo()
	{
		super();
	}
	 //[end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public EnterpriseInfo(int sDatabaseenterpriseid)
	{
		super(sDatabaseenterpriseid);
	}
	 //[end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 * @throws SQLException
	 */
	public EnterpriseInfo(ResultSet rs) throws SQLException
	{
		super(rs);
	}
	 //[end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 * @throws SQLException
	 */
	public EnterpriseInfo(ResultSet rs, String[] columnNames) throws SQLException
	{
		super(rs, columnNames);
	}
	 //[end]
	// [start] 获取 行业类别表 字段：BusinessTypeID Businesstypeid 行业类型
	private ProfessionInfo objProfessionInfoByBusinesstypeid = null;

	/**
	 * 获取 行业类别表
	 * @return
	 */
	public ProfessionInfo getObjProfessionInfoByBusinesstypeid()
	{
		//行业类别表
		//if (objProfessionInfoByBusinesstypeid == null)
		//	objProfessionInfoByBusinesstypeid = com.yun.bll.culture.ProfessionProvider.GetProfessionInfoStaticByBusinessdatabaseid(getBusinesstypeid());

		if (objProfessionInfoByBusinesstypeid == null)
			objProfessionInfoByBusinesstypeid = com.yun.bll.culture.ProfessionProvider.getProfessionStatic().GetProfessionInfoByBusinessdatabaseid(getBusinesstypeid());

		if (objProfessionInfoByBusinesstypeid == null)
			return new ProfessionInfo();
		else
			return this.objProfessionInfoByBusinesstypeid;

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
	// [start] 获取 企业性质表 字段：QualityID Qualityid 企业性质
	private EnterpristQualityInfo objEnterpristQualityInfoByQualityid = null;

	/**
	 * 获取 企业性质表
	 * @return
	 */
	public EnterpristQualityInfo getObjEnterpristQualityInfoByQualityid()
	{
		//企业性质表
		//if (objEnterpristQualityInfoByQualityid == null)
		//	objEnterpristQualityInfoByQualityid = com.yun.bll.culture.EnterpristQualityProvider.GetEnterpristQualityInfoStaticByQualitydatabaseid(getQualityid());

		if (objEnterpristQualityInfoByQualityid == null)
			objEnterpristQualityInfoByQualityid = com.yun.bll.culture.EnterpristQualityProvider.getEnterpristQualityStatic().GetEnterpristQualityInfoByQualitydatabaseid(getQualityid());

		if (objEnterpristQualityInfoByQualityid == null)
			return new EnterpristQualityInfo();
		else
			return this.objEnterpristQualityInfoByQualityid;

	}
	// [end]
	// [start] 获取 系统人员表 字段：PeopleID1 Peopleid1 统计人员
	private SystemAdminInfo objSystemAdminInfoByPeopleid1 = null;

	/**
	 * 获取 系统人员表
	 * @return
	 */
	public SystemAdminInfo getObjSystemAdminInfoByPeopleid1()
	{
		//系统人员表
		//if (objSystemAdminInfoByPeopleid1 == null)
		//	objSystemAdminInfoByPeopleid1 = com.yun.bll.culture.SystemAdminProvider.GetSystemAdminInfoStaticByDatabaseadminid(getPeopleid1());

		if (objSystemAdminInfoByPeopleid1 == null)
			objSystemAdminInfoByPeopleid1 = com.yun.bll.culture.SystemAdminProvider.getSystemAdminStatic().GetSystemAdminInfoByDatabaseadminid(getPeopleid1());

		if (objSystemAdminInfoByPeopleid1 == null)
			return new SystemAdminInfo();
		else
			return this.objSystemAdminInfoByPeopleid1;

	}
	// [end]
	// [start] 获取 系统人员表 字段：PeopleID2 Peopleid2 填表人员
	private SystemAdminInfo objSystemAdminInfoByPeopleid2 = null;

	/**
	 * 获取 系统人员表
	 * @return
	 */
	public SystemAdminInfo getObjSystemAdminInfoByPeopleid2()
	{
		//系统人员表
		//if (objSystemAdminInfoByPeopleid2 == null)
		//	objSystemAdminInfoByPeopleid2 = com.yun.bll.culture.SystemAdminProvider.GetSystemAdminInfoStaticByDatabaseadminid(getPeopleid2());

		if (objSystemAdminInfoByPeopleid2 == null)
			objSystemAdminInfoByPeopleid2 = com.yun.bll.culture.SystemAdminProvider.getSystemAdminStatic().GetSystemAdminInfoByDatabaseadminid(getPeopleid2());

		if (objSystemAdminInfoByPeopleid2 == null)
			return new SystemAdminInfo();
		else
			return this.objSystemAdminInfoByPeopleid2;

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
	// [start] 获取 部门表 字段：SectorID Sectorid 部门编号
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
	// [end]

	// [start]清空缓存数据

	/**
	 * 清空缓存数据
	 *
	 * @return
	 */
	public void setNull()
	{
		// 行业类型
		objProfessionInfoByBusinesstypeid = null;
		// 所属区域
		objRegionsInfoByRegionid = null;
		// 企业性质
		objEnterpristQualityInfoByQualityid = null;
		// 统计人员
		objSystemAdminInfoByPeopleid1 = null;
		// 填表人员
		objSystemAdminInfoByPeopleid2 = null;
		// 登录人员
		objSystemAdminInfoByAdminid = null;
		// 部门编号
		objSystemSectorInfoBySectorid = null;
	}

	// [end]

	
	 //[end]


}
