
package com.yun.entities.culture;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.yun.bll.itemcollection.culture.TalentItemCollection;
import com.yun.entities.culture.base.*;

/**
 * Talent 文化人才表的摘要说明
 */
public class TalentInfo extends TalentInfoBase implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120317482709358L;

	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public TalentInfo()
	{
		super();
	}
	 //[end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public TalentInfo(int sTalentid)
	{
		super(sTalentid);
	}
	 //[end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 * @throws SQLException
	 */
	public TalentInfo(ResultSet rs) throws SQLException
	{
		super(rs);
	}
	 //[end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 * @throws SQLException
	 */
	public TalentInfo(ResultSet rs, String[] columnNames) throws SQLException
	{
		super(rs, columnNames);
	}
	 //[end]
	
	// [start] 获取 民族表 字段：NationID Nationid 民族
	private NationInfo objNationInfoByNationid = null;

	/**
	 * 获取 民族表
	 * @return
	 */
	public NationInfo getObjNationInfoByNationid()
	{
		//民族表
		//if (objNationInfoByNationid == null)
		//	objNationInfoByNationid = com.yun.bll.culture.NationProvider.GetNationInfoStaticByNationdatabaseid(getNationid());

		if (objNationInfoByNationid == null)
			objNationInfoByNationid = com.yun.bll.culture.NationProvider.getNationStatic().GetNationInfoByNationdatabaseid(getNationid());

		if (objNationInfoByNationid == null)
			return new NationInfo();
		else
			return this.objNationInfoByNationid;

	}
	// [end]
	
	//[start]
	private CityinfoInfo objProvinceInfoByProvinceid=null;
	/**
	 * 
	 * 获得 省市 
	 */
	public CityinfoInfo getObjProvinceInfoByProvinceid() {
		//城市
		//if (objCityinfoInfoByCityid == null)
		//	objCityinfoInfoByCityid = com.yun.bll.culture.CityinfoProvider.GetCityinfoInfoStaticByCityid(getCityid());

		if (objProvinceInfoByProvinceid == null)
			objProvinceInfoByProvinceid = com.yun.bll.culture.CityinfoProvider.getCityinfoStatic().GetCityinfoInfoByCityid(getProvince());

		if (objProvinceInfoByProvinceid == null)
			return new CityinfoInfo();
		else
			return this.objProvinceInfoByProvinceid;
	}
	//[end]
	
	
	// [start] 获取 城市 字段：CityID Cityid 城市
	private CityinfoInfo objCityinfoInfoByCityid = null;


	/**
	 * 获取 城市
	 * @return
	 */
	public CityinfoInfo getObjCityinfoInfoByCityid()
	{
		//城市
		//if (objCityinfoInfoByCityid == null)
		//	objCityinfoInfoByCityid = com.yun.bll.culture.CityinfoProvider.GetCityinfoInfoStaticByCityid(getCityid());

		if (objCityinfoInfoByCityid == null)
			objCityinfoInfoByCityid = com.yun.bll.culture.CityinfoProvider.getCityinfoStatic().GetCityinfoInfoByCityid(getCityid());

		if (objCityinfoInfoByCityid == null)
			return new CityinfoInfo();
		else
			return this.objCityinfoInfoByCityid;

	}
	// [end]
	// [start] 获取 学历表 字段：EducationID Educationid 学历
	private EducationInfo objEducationInfoByEducationid = null;

	/**
	 * 获取 学历表
	 * @return
	 */
	public EducationInfo getObjEducationInfoByEducationid()
	{
		//学历表
		//if (objEducationInfoByEducationid == null)
		//	objEducationInfoByEducationid = com.yun.bll.culture.EducationProvider.GetEducationInfoStaticByEducationdatabaseid(getEducationid());

		if (objEducationInfoByEducationid == null)
			objEducationInfoByEducationid = com.yun.bll.culture.EducationProvider.getEducationStatic().GetEducationInfoByEducationdatabaseid(getEducationid());

		if (objEducationInfoByEducationid == null)
			return new EducationInfo();
		else
			return this.objEducationInfoByEducationid;

	}
	// [end]
	// [start] 获取 t_degree 字段：DegreeID Degreeid 学位
	private DegreeInfo objDegreeInfoByDegreeid = null;

	/**
	 * 获取 t_degree
	 * @return
	 */
	public DegreeInfo getObjDegreeInfoByDegreeid()
	{
		//t_degree
		//if (objDegreeInfoByDegreeid == null)
		//	objDegreeInfoByDegreeid = com.yun.bll.culture.DegreeProvider.GetDegreeInfoStaticByDegreedatabaseid(getDegreeid());

		if (objDegreeInfoByDegreeid == null)
			objDegreeInfoByDegreeid = com.yun.bll.culture.DegreeProvider.getDegreeStatic().GetDegreeInfoByDegreedatabaseid(getDegreeid());

		if (objDegreeInfoByDegreeid == null)
			return new DegreeInfo();
		else
			return this.objDegreeInfoByDegreeid;

	}
	// [end]
	// [start] 获取 专业表 字段：MajorID Majorid 专业
	private MajorInfo objMajorInfoByMajorid = null;

	/**
	 * 获取 专业表
	 * @return
	 */
	public MajorInfo getObjMajorInfoByMajorid()
	{
		//专业表
		//if (objMajorInfoByMajorid == null)
		//	objMajorInfoByMajorid = com.yun.bll.culture.MajorProvider.GetMajorInfoStaticByMajordatabaseid(getMajorid());

		if (objMajorInfoByMajorid == null)
			objMajorInfoByMajorid = com.yun.bll.culture.MajorProvider.getMajorStatic().GetMajorInfoByMajordatabaseid(getMajorid());

		if (objMajorInfoByMajorid == null)
			return new MajorInfo();
		else
			return this.objMajorInfoByMajorid;

	}
	// [end]
	// [start] 获取 行业类别表 字段：TalentProfessionID Talentprofessionid 人才所属行业
	private ProfessionInfo objProfessionInfoByTalentprofessionid = null;

	/**
	 * 获取 行业类别表
	 * @return
	 */
	public ProfessionInfo getObjProfessionInfoByTalentprofessionid()
	{
		//行业类别表
		//if (objProfessionInfoByTalentprofessionid == null)
		//	objProfessionInfoByTalentprofessionid = com.yun.bll.culture.ProfessionProvider.GetProfessionInfoStaticByBusinessdatabaseid(getTalentprofessionid());

		if (objProfessionInfoByTalentprofessionid == null)
			objProfessionInfoByTalentprofessionid = com.yun.bll.culture.ProfessionProvider.getProfessionStatic().GetProfessionInfoByBusinessdatabaseid(getTalentprofessionid());

		if (objProfessionInfoByTalentprofessionid == null)
			return new ProfessionInfo();
		else
			return this.objProfessionInfoByTalentprofessionid;

	}
	// [end]
	// [start] 获取 系统人员表 字段：DatabasePeopleID1 Databasepeopleid1 统计人员
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
	// [start] 获取 系统人员表 字段：DatabasePeopleID2 Databasepeopleid2 填表人员
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
	// [start] 获取 部门表 字段：SectorID Sectorid SectorID
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
		// 民族
		objNationInfoByNationid = null;
		// 城市
		objCityinfoInfoByCityid = null;
		// 学历
		objEducationInfoByEducationid = null;
		// 学位
		objDegreeInfoByDegreeid = null;
		// 专业
		objMajorInfoByMajorid = null;
		// 人才所属行业
		objProfessionInfoByTalentprofessionid = null;
		// 统计人员
		objSystemAdminInfoByDatabasepeopleid1 = null;
		// 填表人员
		objSystemAdminInfoByDatabasepeopleid2 = null;
		// 登录人员
		objSystemAdminInfoByAdminid = null;
		// SectorID
		objSystemSectorInfoBySectorid = null;
		objPostInfoByPosttitleid = null;
	}

	// [end]
	// [start] 获取 职称表 字段：PostTitleID Posttitleid 职称
	private PostInfo objPostInfoByPosttitleid = null;

	/**
	 * 获取 职称表
	 * @return
	 */
	public PostInfo getObjPostInfoByPosttitleid()
	{
		//职称表
		//if (objPostInfoByPosttitleid == null)
		//	objPostInfoByPosttitleid = com.yun.bll.culture.PostProvider.GetPostInfoStaticByTitledatabaseid(getPosttitleid());

		if (objPostInfoByPosttitleid == null)
			objPostInfoByPosttitleid = com.yun.bll.culture.PostProvider.getPostStatic().GetPostInfoByTitledatabaseid(getPosttitleid());

		if (objPostInfoByPosttitleid == null)
			return new PostInfo();
		else
			return this.objPostInfoByPosttitleid;

	}
	// [end]

	// [start]清空缓存数据

	/**
	 * 清空缓存数据
	 *
	 * @return
	 */
   
	
	// [end]

	 //[end]


}
