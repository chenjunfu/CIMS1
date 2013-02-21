
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * IndustryProject 文化项目表的描述
 * 实体类基本类
 */
public class IndustryProjectInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012122610574417141L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public IndustryProjectInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public IndustryProjectInfoBase(int sDatabaseprojectid)
	{
		this.setDatabaseprojectid(sDatabaseprojectid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public IndustryProjectInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setDatabaseprojectid(rs.getInt("DatabaseProjectID"));//项目ID
		setProjectid(rs.getInt("ProjectID"));//项目编号
		setProjectname(rs.getString("ProjectName"));//项目名称
		setDatabaseenterpriseid(rs.getInt("DatabaseEnterpriseID"));//经营单位
		setProquality(rs.getInt("ProQuality"));//建设性质
		setAddress(rs.getString("Address"));//所在地址
		setCreatetime(MyDate.setDate(rs.getTimestamp("CreateTime")));//创建时间
		setPlantime(MyDate.setDate(rs.getTimestamp("plantime")));//计划时间
		setCompletetime(rs.getTimestamp("CompleteTime"));//完成时间
		setProcontent(rs.getString("ProContent"));//项目内容
		setPlaninvest(rs.getDouble("planInvest"));//计划投入资金
		setTotalinvest(rs.getDouble("TotalInvest"));//实际投入资金
		setRealinvest(rs.getDouble("RealInvest"));//RealInvest
		setYearinvest(rs.getDouble("yearinvest"));//本年投入资金
		setPublicinvest(rs.getDouble("publicinvest"));//政府投资
		setSelfinvest(rs.getDouble("selfinvest"));//自筹
		setBankloan(rs.getDouble("bankloan"));//银行
		setShb(rs.getInt("shb"));//审批,核准,备案
		setHppf(rs.getInt("hppf"));//环评批复
		setTdpz(rs.getInt("tdpz"));//土地批准
		setGhxz(rs.getInt("ghxz"));//规划选址
		setShbno(rs.getString("shbno"));//shbno
		setHppfno(rs.getString("hppfno"));//hppfno
		setTdpzno(rs.getString("tdpzno"));//tdpzno
		setGhxzno(rs.getString("ghxzno"));//ghxzno
		setRegionid(rs.getInt("RegionID"));//所属区域
		setDutyunitid(rs.getInt("DutyUnitID"));//主管单位
		setIndustryid(rs.getInt("IndustryID"));//产业类别
		setPlanprogress(rs.getString("PlanProgress"));//计划进度
		setRealprogress(rs.getString("RealProgress"));//实际进度
		setFeature(rs.getString("Feature"));//项目特色
		setState(rs.getString("State"));//经营状况
		setLinkman(rs.getString("linkman"));//linkman
		setPhone(rs.getString("phone"));//phone
		setComment(rs.getString("comment"));//comment
		setPic(rs.getString("Pic"));//项目图片
		setDatabasepeopleid1(rs.getInt("DatabasePeopleID1"));//填表人员
		setDatabasepeopleid2(rs.getInt("DatabasePeopleID2"));//统计人员
		setAdminid(rs.getInt("AdminID"));//登录人员
		setSectorid(rs.getInt("SectorID"));//部门
		setLogintime(MyDate.setDate(rs.getTimestamp("LoginTime")));//登录时间
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public IndustryProjectInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//项目ID
			if (columnName.equals("DatabaseProjectID"))
			{
				setDatabaseprojectid(rs.getInt("DatabaseProjectID"));
				continue;
			}
			//项目编号
			if (columnName.equals("ProjectID"))
			{
				setProjectid(rs.getInt("ProjectID"));
				continue;
			}
			//项目名称
			if (columnName.equals("ProjectName"))
			{
				setProjectname(rs.getString("ProjectName"));
				continue;
			}
			//经营单位
			if (columnName.equals("DatabaseEnterpriseID"))
			{
				setDatabaseenterpriseid(rs.getInt("DatabaseEnterpriseID"));
				continue;
			}
			//建设性质
			if (columnName.equals("ProQuality"))
			{
				setProquality(rs.getInt("ProQuality"));
				continue;
			}
			//所在地址
			if (columnName.equals("Address"))
			{
				setAddress(rs.getString("Address"));
				continue;
			}
			//创建时间
			if (columnName.equals("CreateTime"))
			{
				setCreatetime(MyDate.setDate(rs.getTimestamp("CreateTime")));
				continue;
			}
			//计划时间
			if (columnName.equals("plantime"))
			{
				setPlantime(MyDate.setDate(rs.getTimestamp("plantime")));
				continue;
			}
			//完成时间
			if (columnName.equals("CompleteTime"))
			{
				setCompletetime(MyDate.setDate(rs.getTimestamp("CompleteTime")));
				continue;
			}
			//项目内容
			if (columnName.equals("ProContent"))
			{
				setProcontent(rs.getString("ProContent"));
				continue;
			}
			//计划投入资金
			if (columnName.equals("planInvest"))
			{
				setPlaninvest(rs.getDouble("planInvest"));
				continue;
			}
			//实际投入资金
			if (columnName.equals("TotalInvest"))
			{
				setTotalinvest(rs.getDouble("TotalInvest"));
				continue;
			}
			//RealInvest
			if (columnName.equals("RealInvest"))
			{
				setRealinvest(rs.getDouble("RealInvest"));
				continue;
			}
			//本年投入资金
			if (columnName.equals("yearinvest"))
			{
				setYearinvest(rs.getDouble("yearinvest"));
				continue;
			}
			//政府投资
			if (columnName.equals("publicinvest"))
			{
				setPublicinvest(rs.getDouble("publicinvest"));
				continue;
			}
			//自筹
			if (columnName.equals("selfinvest"))
			{
				setSelfinvest(rs.getDouble("selfinvest"));
				continue;
			}
			//银行
			if (columnName.equals("bankloan"))
			{
				setBankloan(rs.getDouble("bankloan"));
				continue;
			}
			//审批,核准,备案
			if (columnName.equals("shb"))
			{
				setShb(rs.getInt("shb"));
				continue;
			}
			//环评批复
			if (columnName.equals("hppf"))
			{
				setHppf(rs.getInt("hppf"));
				continue;
			}
			//土地批准
			if (columnName.equals("tdpz"))
			{
				setTdpz(rs.getInt("tdpz"));
				continue;
			}
			//规划选址
			if (columnName.equals("ghxz"))
			{
				setGhxz(rs.getInt("ghxz"));
				continue;
			}
			//shbno
			if (columnName.equals("shbno"))
			{
				setShbno(rs.getString("shbno"));
				continue;
			}
			//hppfno
			if (columnName.equals("hppfno"))
			{
				setHppfno(rs.getString("hppfno"));
				continue;
			}
			//tdpzno
			if (columnName.equals("tdpzno"))
			{
				setTdpzno(rs.getString("tdpzno"));
				continue;
			}
			//ghxzno
			if (columnName.equals("ghxzno"))
			{
				setGhxzno(rs.getString("ghxzno"));
				continue;
			}
			//所属区域
			if (columnName.equals("RegionID"))
			{
				setRegionid(rs.getInt("RegionID"));
				continue;
			}
			//主管单位
			if (columnName.equals("DutyUnitID"))
			{
				setDutyunitid(rs.getInt("DutyUnitID"));
				continue;
			}
			//产业类别
			if (columnName.equals("IndustryID"))
			{
				setIndustryid(rs.getInt("IndustryID"));
				continue;
			}
			//计划进度
			if (columnName.equals("PlanProgress"))
			{
				setPlanprogress(rs.getString("PlanProgress"));
				continue;
			}
			//实际进度
			if (columnName.equals("RealProgress"))
			{
				setRealprogress(rs.getString("RealProgress"));
				continue;
			}
			//项目特色
			if (columnName.equals("Feature"))
			{
				setFeature(rs.getString("Feature"));
				continue;
			}
			//经营状况
			if (columnName.equals("State"))
			{
				setState(rs.getString("State"));
				continue;
			}
			//linkman
			if (columnName.equals("linkman"))
			{
				setLinkman(rs.getString("linkman"));
				continue;
			}
			//phone
			if (columnName.equals("phone"))
			{
				setPhone(rs.getString("phone"));
				continue;
			}
			//comment
			if (columnName.equals("comment"))
			{
				setComment(rs.getString("comment"));
				continue;
			}
			//项目图片
			if (columnName.equals("Pic"))
			{
				setPic(rs.getString("Pic"));
				continue;
			}
			//填表人员
			if (columnName.equals("DatabasePeopleID1"))
			{
				setDatabasepeopleid1(rs.getInt("DatabasePeopleID1"));
				continue;
			}
			//统计人员
			if (columnName.equals("DatabasePeopleID2"))
			{
				setDatabasepeopleid2(rs.getInt("DatabasePeopleID2"));
				continue;
			}
			//登录人员
			if (columnName.equals("AdminID"))
			{
				setAdminid(rs.getInt("AdminID"));
				continue;
			}
			//部门
			if (columnName.equals("SectorID"))
			{
				setSectorid(rs.getInt("SectorID"));
				continue;
			}
			//登录时间
			if (columnName.equals("LoginTime"))
			{
				setLogintime(MyDate.setDate(rs.getTimestamp("LoginTime")));
				continue;
			}
		}
	}
	// [end]
	// [end]

	// [start] 通过主键的值比较两个实例是否相等
	/**
	 * 通过主键的值比较两个实例是否相等
	 *
	 * @param obj
	 * @return boolean
	 */
	public boolean equals(Object rhs)
	{
		if (rhs == null)
			return false;
		if (!(rhs instanceof IndustryProjectInfo))
			return false;
		IndustryProjectInfo that = (IndustryProjectInfo) rhs;

		return (this.getDatabaseprojectid() == (that.getDatabaseprojectid()));
	}
	// [end]

	// [start] 生成新的哈希码
	/** 用来存储实例的哈希码，设为0时可以让程序重新计算。 */
	private int hashValue = 0;
	/**
	 * 生成新的哈希码
	 *
	 * @return int
	 */
	public int hashCode()
	{
		if (this.hashValue == 0)
		{
			int result = 17;

			result = result * 37 + (this.getDatabaseprojectid() + "").hashCode();
			this.hashValue = result;
		}
		return this.hashValue;
	}
	// [end]
	// [start] 数据库字段列表
	/**
	 * 数据库字段列表
	 */
	public static String[] ColumnNames = new String[] {
	"DatabaseProjectID", //项目ID
	"ProjectID", //项目编号
	"ProjectName", //项目名称
	"DatabaseEnterpriseID", //经营单位
	"ProQuality", //建设性质
	"Address", //所在地址
	"CreateTime", //创建时间
	"plantime", //计划时间
	"CompleteTime", //完成时间
	"ProContent", //项目内容
	"planInvest", //计划投入资金
	"TotalInvest", //实际投入资金
	"RealInvest", //RealInvest
	"yearinvest", //本年投入资金
	"publicinvest", //政府投资
	"selfinvest", //自筹
	"bankloan", //银行
	"shb", //审批,核准,备案
	"hppf", //环评批复
	"tdpz", //土地批准
	"ghxz", //规划选址
	"shbno", //shbno
	"hppfno", //hppfno
	"tdpzno", //tdpzno
	"ghxzno", //ghxzno
	"RegionID", //所属区域
	"DutyUnitID", //主管单位
	"IndustryID", //产业类别
	"PlanProgress", //计划进度
	"RealProgress", //实际进度
	"Feature", //项目特色
	"State", //经营状况
	"linkman", //linkman
	"phone", //phone
	"comment", //comment
	"Pic", //项目图片
	"DatabasePeopleID1", //填表人员
	"DatabasePeopleID2", //统计人员
	"AdminID", //登录人员
	"SectorID", //部门
	"LoginTime" //登录时间
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum IndustryProjectColumnNameEnum
{
		/**
		 * 项目ID
		 */
		Databaseprojectid,
		/**
		 * 项目编号
		 */
		Projectid,
		/**
		 * 项目名称
		 */
		Projectname,
		/**
		 * 经营单位
		 */
		Databaseenterpriseid,
		/**
		 * 建设性质
		 */
		Proquality,
		/**
		 * 所在地址
		 */
		Address,
		/**
		 * 创建时间
		 */
		Createtime,
		/**
		 * 计划时间
		 */
		Plantime,
		/**
		 * 完成时间
		 */
		Completetime,
		/**
		 * 项目内容
		 */
		Procontent,
		/**
		 * 计划投入资金
		 */
		Planinvest,
		/**
		 * 实际投入资金
		 */
		Totalinvest,
		/**
		 * RealInvest
		 */
		Realinvest,
		/**
		 * 本年投入资金
		 */
		Yearinvest,
		/**
		 * 政府投资
		 */
		Publicinvest,
		/**
		 * 自筹
		 */
		Selfinvest,
		/**
		 * 银行
		 */
		Bankloan,
		/**
		 * 审批,核准,备案
		 */
		Shb,
		/**
		 * 环评批复
		 */
		Hppf,
		/**
		 * 土地批准
		 */
		Tdpz,
		/**
		 * 规划选址
		 */
		Ghxz,
		/**
		 * shbno
		 */
		Shbno,
		/**
		 * hppfno
		 */
		Hppfno,
		/**
		 * tdpzno
		 */
		Tdpzno,
		/**
		 * ghxzno
		 */
		Ghxzno,
		/**
		 * 所属区域
		 */
		Regionid,
		/**
		 * 主管单位
		 */
		Dutyunitid,
		/**
		 * 产业类别
		 */
		Industryid,
		/**
		 * 计划进度
		 */
		Planprogress,
		/**
		 * 实际进度
		 */
		Realprogress,
		/**
		 * 项目特色
		 */
		Feature,
		/**
		 * 经营状况
		 */
		State,
		/**
		 * linkman
		 */
		Linkman,
		/**
		 * phone
		 */
		Phone,
		/**
		 * comment
		 */
		Comment,
		/**
		 * 项目图片
		 */
		Pic,
		/**
		 * 填表人员
		 */
		Databasepeopleid1,
		/**
		 * 统计人员
		 */
		Databasepeopleid2,
		/**
		 * 登录人员
		 */
		Adminid,
		/**
		 * 部门
		 */
		Sectorid,
		/**
		 * 登录时间
		 */
		Logintime
	};
	// [end]
        // [start] 设置和获取 项目ID, 默认值:0
	// 设置和获取 项目ID,类型int 默认值:0 开始
	private int databaseprojectid = 0;
	/**
	* 获取 项目ID, 类型int 默认值:0
	 *
	 * @return 项目ID, 类型int 默认值:0
	 */
	public int getDatabaseprojectid()
	{
		return this.databaseprojectid; 
	}
	/**
	 * 设置 项目ID, 类型int 默认值:0
	 *
	 * @param sDatabaseprojectid
	 *            项目ID, 类型int 默认值:0
	 */
	public void setDatabaseprojectid(int sDatabaseprojectid)
	{
		this.databaseprojectid = sDatabaseprojectid; 
	}
	// 设置和获取 项目ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 项目编号, 默认值:0
	// 设置和获取 项目编号,类型int 默认值:0 开始
	private int projectid = 0;
	/**
	* 获取 项目编号, 类型int 默认值:0
	 *
	 * @return 项目编号, 类型int 默认值:0
	 */
	public int getProjectid()
	{
		return this.projectid; 
	}
	/**
	 * 设置 项目编号, 类型int 默认值:0
	 *
	 * @param sProjectid
	 *            项目编号, 类型int 默认值:0
	 */
	public void setProjectid(int sProjectid)
	{
		this.projectid = sProjectid; 
	}
	// 设置和获取 项目编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 项目名称, 默认值:""
	// 设置和获取 项目名称,类型String 默认值:"" 开始
	private String projectname = "";
	/**
	* 获取 项目名称, 类型String 默认值:""
	 *
	 * @return 项目名称, 类型String 默认值:""
	 */
	public String getProjectname()
	{
		return this.projectname; 
	}
	/**
	 * 设置 项目名称, 类型String 默认值:""
	 *
	 * @param sProjectname
	 *            项目名称, 类型String 默认值:""
	 */
	public void setProjectname(String sProjectname)
	{
		this.projectname = sProjectname; 
	}
	// 设置和获取 项目名称, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 经营单位, 默认值:0
	// 设置和获取 经营单位,类型int 默认值:0 开始
	private int databaseenterpriseid = 0;
	/**
	* 获取 经营单位, 类型int 默认值:0
	 *
	 * @return 经营单位, 类型int 默认值:0
	 */
	public int getDatabaseenterpriseid()
	{
		return this.databaseenterpriseid; 
	}
	/**
	 * 设置 经营单位, 类型int 默认值:0
	 *
	 * @param sDatabaseenterpriseid
	 *            经营单位, 类型int 默认值:0
	 */
	public void setDatabaseenterpriseid(int sDatabaseenterpriseid)
	{
		this.databaseenterpriseid = sDatabaseenterpriseid; 
	}
	// 设置和获取 经营单位, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 建设性质, 默认值:0
	// 设置和获取 建设性质,类型int 默认值:0 开始
	private int proquality = 0;
	/**
	* 获取 建设性质, 类型int 默认值:0
	 *
	 * @return 建设性质, 类型int 默认值:0
	 */
	public int getProquality()
	{
		return this.proquality; 
	}
	/**
	 * 设置 建设性质, 类型int 默认值:0
	 *
	 * @param sProquality
	 *            建设性质, 类型int 默认值:0
	 */
	public void setProquality(int sProquality)
	{
		this.proquality = sProquality; 
	}
	// 设置和获取 建设性质, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 所在地址, 默认值:""
	// 设置和获取 所在地址,类型String 默认值:"" 开始
	private String address = "";
	/**
	* 获取 所在地址, 类型String 默认值:""
	 *
	 * @return 所在地址, 类型String 默认值:""
	 */
	public String getAddress()
	{
		return this.address; 
	}
	/**
	 * 设置 所在地址, 类型String 默认值:""
	 *
	 * @param sAddress
	 *            所在地址, 类型String 默认值:""
	 */
	public void setAddress(String sAddress)
	{
		this.address = sAddress; 
	}
	// 设置和获取 所在地址, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 创建时间, 默认值:new Date()
	// 设置和获取 创建时间,类型Date 默认值:new Date() 开始
	private Date createtime = new Date();
	/**
	* 获取 创建时间, 类型Date 默认值:new Date()
	 *
	 * @return 创建时间, 类型Date 默认值:new Date()
	 */
	public Date getCreatetime()
	{
		if (!(this.createtime instanceof MyDate))
			this.createtime = MyDate.setDate(this.createtime);
		return this.createtime; 
	}
	/**
	 * 设置 创建时间, 类型Date 默认值:new Date()
	 *
	 * @param sCreatetime
	 *            创建时间, 类型Date 默认值:new Date()
	 */
	public void setCreatetime(Date sCreatetime)
	{
		this.createtime = sCreatetime; 
	}
	// 设置和获取 创建时间, 类型Date 默认值:new Date() 结束
        // [end]


        // [start] 设置和获取 计划时间, 默认值:new Date()
	// 设置和获取 计划时间,类型Date 默认值:new Date() 开始
	private Date plantime = new Date();
	/**
	* 获取 计划时间, 类型Date 默认值:new Date()
	 *
	 * @return 计划时间, 类型Date 默认值:new Date()
	 */
	public Date getPlantime()
	{
		if (!(this.plantime instanceof MyDate))
			this.plantime = MyDate.setDate(this.plantime);
		return this.plantime; 
	}
	/**
	 * 设置 计划时间, 类型Date 默认值:new Date()
	 *
	 * @param sPlantime
	 *            计划时间, 类型Date 默认值:new Date()
	 */
	public void setPlantime(Date sPlantime)
	{
		this.plantime = sPlantime; 
	}
	// 设置和获取 计划时间, 类型Date 默认值:new Date() 结束
        // [end]


        // [start] 设置和获取 完成时间, 默认值:new Date()
	// 设置和获取 完成时间,类型Date 默认值:new Date() 开始
	private Date completetime = null;
	/**
	* 获取 完成时间, 类型Date 默认值:new Date()
	 *
	 * @return 完成时间, 类型Date 默认值:new Date()
	 */
	public Date getCompletetime()
	{	
		if (this.completetime!=null&&!(this.completetime instanceof MyDate))
			this.completetime = MyDate.setDate(this.completetime);
		return this.completetime; 
	}
	/**
	 * 设置 完成时间, 类型Date 默认值:new Date()
	 *
	 * @param sCompletetime
	 *            完成时间, 类型Date 默认值:new Date()
	 */
	public void setCompletetime(Date sCompletetime)
	{
		this.completetime = sCompletetime; 
	}
	// 设置和获取 完成时间, 类型Date 默认值:new Date() 结束
        // [end]


        // [start] 设置和获取 项目内容, 默认值:""
	// 设置和获取 项目内容,类型String 默认值:"" 开始
	private String procontent = "";
	/**
	* 获取 项目内容, 类型String 默认值:""
	 *
	 * @return 项目内容, 类型String 默认值:""
	 */
	public String getProcontent()
	{
		return this.procontent; 
	}
	/**
	 * 设置 项目内容, 类型String 默认值:""
	 *
	 * @param sProcontent
	 *            项目内容, 类型String 默认值:""
	 */
	public void setProcontent(String sProcontent)
	{
		this.procontent = sProcontent; 
	}
	// 设置和获取 项目内容, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 计划投入资金, 默认值:0
	// 设置和获取 计划投入资金,类型double 默认值:0 开始
	private double planinvest = 0;
	/**
	* 获取 计划投入资金, 类型double 默认值:0
	 *
	 * @return 计划投入资金, 类型double 默认值:0
	 */
	public double getPlaninvest()
	{
		return this.planinvest; 
	}
	/**
	 * 设置 计划投入资金, 类型double 默认值:0
	 *
	 * @param sPlaninvest
	 *            计划投入资金, 类型double 默认值:0
	 */
	public void setPlaninvest(double sPlaninvest)
	{
		this.planinvest = sPlaninvest; 
	}
	// 设置和获取 计划投入资金, 类型double 默认值:0 结束
        // [end]


        // [start] 设置和获取 实际投入资金, 默认值:0
	// 设置和获取 实际投入资金,类型double 默认值:0 开始
	private double totalinvest = 0;
	/**
	* 获取 实际投入资金, 类型double 默认值:0
	 *
	 * @return 实际投入资金, 类型double 默认值:0
	 */
	public double getTotalinvest()
	{
		return this.totalinvest; 
	}
	/**
	 * 设置 实际投入资金, 类型double 默认值:0
	 *
	 * @param sTotalinvest
	 *            实际投入资金, 类型double 默认值:0
	 */
	public void setTotalinvest(double sTotalinvest)
	{
		this.totalinvest = sTotalinvest; 
	}
	// 设置和获取 实际投入资金, 类型double 默认值:0 结束
        // [end]


        // [start] 设置和获取 RealInvest, 默认值:0
	// 设置和获取 RealInvest,类型double 默认值:0 开始
	private double realinvest = 0;
	/**
	* 获取 RealInvest, 类型double 默认值:0
	 *
	 * @return RealInvest, 类型double 默认值:0
	 */
	public double getRealinvest()
	{
		return this.realinvest; 
	}
	/**
	 * 设置 RealInvest, 类型double 默认值:0
	 *
	 * @param sRealinvest
	 *            RealInvest, 类型double 默认值:0
	 */
	public void setRealinvest(double sRealinvest)
	{
		this.realinvest = sRealinvest; 
	}
	// 设置和获取 RealInvest, 类型double 默认值:0 结束
        // [end]


        // [start] 设置和获取 本年投入资金, 默认值:0
	// 设置和获取 本年投入资金,类型double 默认值:0 开始
	private double yearinvest = 0;
	/**
	* 获取 本年投入资金, 类型double 默认值:0
	 *
	 * @return 本年投入资金, 类型double 默认值:0
	 */
	public double getYearinvest()
	{
		return this.yearinvest; 
	}
	/**
	 * 设置 本年投入资金, 类型double 默认值:0
	 *
	 * @param sYearinvest
	 *            本年投入资金, 类型double 默认值:0
	 */
	public void setYearinvest(double sYearinvest)
	{
		this.yearinvest = sYearinvest; 
	}
	// 设置和获取 本年投入资金, 类型double 默认值:0 结束
        // [end]


        // [start] 设置和获取 政府投资, 默认值:0
	// 设置和获取 政府投资,类型double 默认值:0 开始
	private double publicinvest = 0;
	/**
	* 获取 政府投资, 类型double 默认值:0
	 *
	 * @return 政府投资, 类型double 默认值:0
	 */
	public double getPublicinvest()
	{
		return this.publicinvest; 
	}
	/**
	 * 设置 政府投资, 类型double 默认值:0
	 *
	 * @param sPublicinvest
	 *            政府投资, 类型double 默认值:0
	 */
	public void setPublicinvest(double sPublicinvest)
	{
		this.publicinvest = sPublicinvest; 
	}
	// 设置和获取 政府投资, 类型double 默认值:0 结束
        // [end]


        // [start] 设置和获取 自筹, 默认值:0
	// 设置和获取 自筹,类型double 默认值:0 开始
	private double selfinvest = 0;
	/**
	* 获取 自筹, 类型double 默认值:0
	 *
	 * @return 自筹, 类型double 默认值:0
	 */
	public double getSelfinvest()
	{
		return this.selfinvest; 
	}
	/**
	 * 设置 自筹, 类型double 默认值:0
	 *
	 * @param sSelfinvest
	 *            自筹, 类型double 默认值:0
	 */
	public void setSelfinvest(double sSelfinvest)
	{
		this.selfinvest = sSelfinvest; 
	}
	// 设置和获取 自筹, 类型double 默认值:0 结束
        // [end]


        // [start] 设置和获取 银行, 默认值:0
	// 设置和获取 银行,类型double 默认值:0 开始
	private double bankloan = 0;
	/**
	* 获取 银行, 类型double 默认值:0
	 *
	 * @return 银行, 类型double 默认值:0
	 */
	public double getBankloan()
	{
		return this.bankloan; 
	}
	/**
	 * 设置 银行, 类型double 默认值:0
	 *
	 * @param sBankloan
	 *            银行, 类型double 默认值:0
	 */
	public void setBankloan(double sBankloan)
	{
		this.bankloan = sBankloan; 
	}
	// 设置和获取 银行, 类型double 默认值:0 结束
        // [end]


        // [start] 设置和获取 审批,核准,备案, 默认值:0
	// 设置和获取 审批,核准,备案,类型int 默认值:0 开始
	private int shb = 0;
	/**
	* 获取 审批,核准,备案, 类型int 默认值:0
	 *
	 * @return 审批,核准,备案, 类型int 默认值:0
	 */
	public int getShb()
	{
		return this.shb; 
	}
	/**
	 * 设置 审批,核准,备案, 类型int 默认值:0
	 *
	 * @param sShb
	 *            审批,核准,备案, 类型int 默认值:0
	 */
	public void setShb(int sShb)
	{
		this.shb = sShb; 
	}
	// 设置和获取 审批,核准,备案, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 环评批复, 默认值:0
	// 设置和获取 环评批复,类型int 默认值:0 开始
	private int hppf = 0;
	/**
	* 获取 环评批复, 类型int 默认值:0
	 *
	 * @return 环评批复, 类型int 默认值:0
	 */
	public int getHppf()
	{
		return this.hppf; 
	}
	/**
	 * 设置 环评批复, 类型int 默认值:0
	 *
	 * @param sHppf
	 *            环评批复, 类型int 默认值:0
	 */
	public void setHppf(int sHppf)
	{
		this.hppf = sHppf; 
	}
	// 设置和获取 环评批复, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 土地批准, 默认值:0
	// 设置和获取 土地批准,类型int 默认值:0 开始
	private int tdpz = 0;
	/**
	* 获取 土地批准, 类型int 默认值:0
	 *
	 * @return 土地批准, 类型int 默认值:0
	 */
	public int getTdpz()
	{
		return this.tdpz; 
	}
	/**
	 * 设置 土地批准, 类型int 默认值:0
	 *
	 * @param sTdpz
	 *            土地批准, 类型int 默认值:0
	 */
	public void setTdpz(int sTdpz)
	{
		this.tdpz = sTdpz; 
	}
	// 设置和获取 土地批准, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 规划选址, 默认值:0
	// 设置和获取 规划选址,类型int 默认值:0 开始
	private int ghxz = 0;
	/**
	* 获取 规划选址, 类型int 默认值:0
	 *
	 * @return 规划选址, 类型int 默认值:0
	 */
	public int getGhxz()
	{
		return this.ghxz; 
	}
	/**
	 * 设置 规划选址, 类型int 默认值:0
	 *
	 * @param sGhxz
	 *            规划选址, 类型int 默认值:0
	 */
	public void setGhxz(int sGhxz)
	{
		this.ghxz = sGhxz; 
	}
	// 设置和获取 规划选址, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 shbno, 默认值:""
	// 设置和获取 shbno,类型String 默认值:"" 开始
	private String shbno = "";
	/**
	* 获取 shbno, 类型String 默认值:""
	 *
	 * @return shbno, 类型String 默认值:""
	 */
	public String getShbno()
	{
		return this.shbno; 
	}
	/**
	 * 设置 shbno, 类型String 默认值:""
	 *
	 * @param sShbno
	 *            shbno, 类型String 默认值:""
	 */
	public void setShbno(String sShbno)
	{
		this.shbno = sShbno; 
	}
	// 设置和获取 shbno, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 hppfno, 默认值:""
	// 设置和获取 hppfno,类型String 默认值:"" 开始
	private String hppfno = "";
	/**
	* 获取 hppfno, 类型String 默认值:""
	 *
	 * @return hppfno, 类型String 默认值:""
	 */
	public String getHppfno()
	{
		return this.hppfno; 
	}
	/**
	 * 设置 hppfno, 类型String 默认值:""
	 *
	 * @param sHppfno
	 *            hppfno, 类型String 默认值:""
	 */
	public void setHppfno(String sHppfno)
	{
		this.hppfno = sHppfno; 
	}
	// 设置和获取 hppfno, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 tdpzno, 默认值:""
	// 设置和获取 tdpzno,类型String 默认值:"" 开始
	private String tdpzno = "";
	/**
	* 获取 tdpzno, 类型String 默认值:""
	 *
	 * @return tdpzno, 类型String 默认值:""
	 */
	public String getTdpzno()
	{
		return this.tdpzno; 
	}
	/**
	 * 设置 tdpzno, 类型String 默认值:""
	 *
	 * @param sTdpzno
	 *            tdpzno, 类型String 默认值:""
	 */
	public void setTdpzno(String sTdpzno)
	{
		this.tdpzno = sTdpzno; 
	}
	// 设置和获取 tdpzno, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 ghxzno, 默认值:""
	// 设置和获取 ghxzno,类型String 默认值:"" 开始
	private String ghxzno = "";
	/**
	* 获取 ghxzno, 类型String 默认值:""
	 *
	 * @return ghxzno, 类型String 默认值:""
	 */
	public String getGhxzno()
	{
		return this.ghxzno; 
	}
	/**
	 * 设置 ghxzno, 类型String 默认值:""
	 *
	 * @param sGhxzno
	 *            ghxzno, 类型String 默认值:""
	 */
	public void setGhxzno(String sGhxzno)
	{
		this.ghxzno = sGhxzno; 
	}
	// 设置和获取 ghxzno, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 所属区域, 默认值:0
	// 设置和获取 所属区域,类型int 默认值:0 开始
	private int regionid = 0;
	/**
	* 获取 所属区域, 类型int 默认值:0
	 *
	 * @return 所属区域, 类型int 默认值:0
	 */
	public int getRegionid()
	{
		return this.regionid; 
	}
	/**
	 * 设置 所属区域, 类型int 默认值:0
	 *
	 * @param sRegionid
	 *            所属区域, 类型int 默认值:0
	 */
	public void setRegionid(int sRegionid)
	{
		this.regionid = sRegionid; 
	}
	// 设置和获取 所属区域, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 主管单位, 默认值:0
	// 设置和获取 主管单位,类型int 默认值:0 开始
	private int dutyunitid = 0;
	/**
	* 获取 主管单位, 类型int 默认值:0
	 *
	 * @return 主管单位, 类型int 默认值:0
	 */
	public int getDutyunitid()
	{
		return this.dutyunitid; 
	}
	/**
	 * 设置 主管单位, 类型int 默认值:0
	 *
	 * @param sDutyunitid
	 *            主管单位, 类型int 默认值:0
	 */
	public void setDutyunitid(int sDutyunitid)
	{
		this.dutyunitid = sDutyunitid; 
	}
	// 设置和获取 主管单位, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 产业类别, 默认值:0
	// 设置和获取 产业类别,类型int 默认值:0 开始
	private int industryid = 0;
	/**
	* 获取 产业类别, 类型int 默认值:0
	 *
	 * @return 产业类别, 类型int 默认值:0
	 */
	public int getIndustryid()
	{
		return this.industryid; 
	}
	/**
	 * 设置 产业类别, 类型int 默认值:0
	 *
	 * @param sIndustryid
	 *            产业类别, 类型int 默认值:0
	 */
	public void setIndustryid(int sIndustryid)
	{
		this.industryid = sIndustryid; 
	}
	// 设置和获取 产业类别, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 计划进度, 默认值:""
	// 设置和获取 计划进度,类型String 默认值:"" 开始
	private String planprogress = "";
	/**
	* 获取 计划进度, 类型String 默认值:""
	 *
	 * @return 计划进度, 类型String 默认值:""
	 */
	public String getPlanprogress()
	{
		return this.planprogress; 
	}
	/**
	 * 设置 计划进度, 类型String 默认值:""
	 *
	 * @param sPlanprogress
	 *            计划进度, 类型String 默认值:""
	 */
	public void setPlanprogress(String sPlanprogress)
	{
		this.planprogress = sPlanprogress; 
	}
	// 设置和获取 计划进度, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 实际进度, 默认值:""
	// 设置和获取 实际进度,类型String 默认值:"" 开始
	private String realprogress = "";
	/**
	* 获取 实际进度, 类型String 默认值:""
	 *
	 * @return 实际进度, 类型String 默认值:""
	 */
	public String getRealprogress()
	{
		return this.realprogress; 
	}
	/**
	 * 设置 实际进度, 类型String 默认值:""
	 *
	 * @param sRealprogress
	 *            实际进度, 类型String 默认值:""
	 */
	public void setRealprogress(String sRealprogress)
	{
		this.realprogress = sRealprogress; 
	}
	// 设置和获取 实际进度, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 项目特色, 默认值:""
	// 设置和获取 项目特色,类型String 默认值:"" 开始
	private String feature = "";
	/**
	* 获取 项目特色, 类型String 默认值:""
	 *
	 * @return 项目特色, 类型String 默认值:""
	 */
	public String getFeature()
	{
		return this.feature; 
	}
	/**
	 * 设置 项目特色, 类型String 默认值:""
	 *
	 * @param sFeature
	 *            项目特色, 类型String 默认值:""
	 */
	public void setFeature(String sFeature)
	{
		this.feature = sFeature; 
	}
	// 设置和获取 项目特色, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 经营状况, 默认值:""
	// 设置和获取 经营状况,类型String 默认值:"" 开始
	private String state = "";
	/**
	* 获取 经营状况, 类型String 默认值:""
	 *
	 * @return 经营状况, 类型String 默认值:""
	 */
	public String getState()
	{
		return this.state; 
	}
	/**
	 * 设置 经营状况, 类型String 默认值:""
	 *
	 * @param sState
	 *            经营状况, 类型String 默认值:""
	 */
	public void setState(String sState)
	{
		this.state = sState; 
	}
	// 设置和获取 经营状况, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 linkman, 默认值:""
	// 设置和获取 linkman,类型String 默认值:"" 开始
	private String linkman = "";
	/**
	* 获取 linkman, 类型String 默认值:""
	 *
	 * @return linkman, 类型String 默认值:""
	 */
	public String getLinkman()
	{
		return this.linkman; 
	}
	/**
	 * 设置 linkman, 类型String 默认值:""
	 *
	 * @param sLinkman
	 *            linkman, 类型String 默认值:""
	 */
	public void setLinkman(String sLinkman)
	{
		this.linkman = sLinkman; 
	}
	// 设置和获取 linkman, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 phone, 默认值:""
	// 设置和获取 phone,类型String 默认值:"" 开始
	private String phone = "";
	/**
	* 获取 phone, 类型String 默认值:""
	 *
	 * @return phone, 类型String 默认值:""
	 */
	public String getPhone()
	{
		return this.phone; 
	}
	/**
	 * 设置 phone, 类型String 默认值:""
	 *
	 * @param sPhone
	 *            phone, 类型String 默认值:""
	 */
	public void setPhone(String sPhone)
	{
		this.phone = sPhone; 
	}
	// 设置和获取 phone, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 comment, 默认值:""
	// 设置和获取 comment,类型String 默认值:"" 开始
	private String comment = "";
	/**
	* 获取 comment, 类型String 默认值:""
	 *
	 * @return comment, 类型String 默认值:""
	 */
	public String getComment()
	{
		return this.comment; 
	}
	/**
	 * 设置 comment, 类型String 默认值:""
	 *
	 * @param sComment
	 *            comment, 类型String 默认值:""
	 */
	public void setComment(String sComment)
	{
		this.comment = sComment; 
	}
	// 设置和获取 comment, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 项目图片, 默认值:""
	// 设置和获取 项目图片,类型String 默认值:"" 开始
	private String pic = "";
	/**
	* 获取 项目图片, 类型String 默认值:""
	 *
	 * @return 项目图片, 类型String 默认值:""
	 */
	public String getPic()
	{
		return this.pic; 
	}
	/**
	 * 设置 项目图片, 类型String 默认值:""
	 *
	 * @param sPic
	 *            项目图片, 类型String 默认值:""
	 */
	public void setPic(String sPic)
	{
		this.pic = sPic; 
	}
	// 设置和获取 项目图片, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 填表人员, 默认值:0
	// 设置和获取 填表人员,类型int 默认值:0 开始
	private int databasepeopleid1 = 0;
	/**
	* 获取 填表人员, 类型int 默认值:0
	 *
	 * @return 填表人员, 类型int 默认值:0
	 */
	public int getDatabasepeopleid1()
	{
		return this.databasepeopleid1; 
	}
	/**
	 * 设置 填表人员, 类型int 默认值:0
	 *
	 * @param sDatabasepeopleid1
	 *            填表人员, 类型int 默认值:0
	 */
	public void setDatabasepeopleid1(int sDatabasepeopleid1)
	{
		this.databasepeopleid1 = sDatabasepeopleid1; 
	}
	// 设置和获取 填表人员, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 统计人员, 默认值:0
	// 设置和获取 统计人员,类型int 默认值:0 开始
	private int databasepeopleid2 = 0;
	/**
	* 获取 统计人员, 类型int 默认值:0
	 *
	 * @return 统计人员, 类型int 默认值:0
	 */
	public int getDatabasepeopleid2()
	{
		return this.databasepeopleid2; 
	}
	/**
	 * 设置 统计人员, 类型int 默认值:0
	 *
	 * @param sDatabasepeopleid2
	 *            统计人员, 类型int 默认值:0
	 */
	public void setDatabasepeopleid2(int sDatabasepeopleid2)
	{
		this.databasepeopleid2 = sDatabasepeopleid2; 
	}
	// 设置和获取 统计人员, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 登录人员, 默认值:0
	// 设置和获取 登录人员,类型int 默认值:0 开始
	private int adminid = 0;
	/**
	* 获取 登录人员, 类型int 默认值:0
	 *
	 * @return 登录人员, 类型int 默认值:0
	 */
	public int getAdminid()
	{
		return this.adminid; 
	}
	/**
	 * 设置 登录人员, 类型int 默认值:0
	 *
	 * @param sAdminid
	 *            登录人员, 类型int 默认值:0
	 */
	public void setAdminid(int sAdminid)
	{
		this.adminid = sAdminid; 
	}
	// 设置和获取 登录人员, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 部门, 默认值:0
	// 设置和获取 部门,类型int 默认值:0 开始
	private int sectorid = 0;
	/**
	* 获取 部门, 类型int 默认值:0
	 *
	 * @return 部门, 类型int 默认值:0
	 */
	public int getSectorid()
	{
		return this.sectorid; 
	}
	/**
	 * 设置 部门, 类型int 默认值:0
	 *
	 * @param sSectorid
	 *            部门, 类型int 默认值:0
	 */
	public void setSectorid(int sSectorid)
	{
		this.sectorid = sSectorid; 
	}
	// 设置和获取 部门, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 登录时间, 默认值:new Date()
	// 设置和获取 登录时间,类型Date 默认值:new Date() 开始
	private Date logintime = new Date();
	/**
	* 获取 登录时间, 类型Date 默认值:new Date()
	 *
	 * @return 登录时间, 类型Date 默认值:new Date()
	 */
	public Date getLogintime()
	{
		if (!(this.logintime instanceof MyDate))
			this.logintime = MyDate.setDate(this.logintime);
		return this.logintime; 
	}
	/**
	 * 设置 登录时间, 类型Date 默认值:new Date()
	 *
	 * @param sLogintime
	 *            登录时间, 类型Date 默认值:new Date()
	 */
	public void setLogintime(Date sLogintime)
	{
		this.logintime = sLogintime; 
	}
	// 设置和获取 登录时间, 类型Date 默认值:new Date() 结束
        // [end]



        //[end]

    // [start] toStringEmpty 返回空字符
    /**
    * 返回空字符串
    */
    public String toStringEmpty()
    {
        return "";
    }
	 //[end]

	// [start] ToSplitString 将对象转化为分割的字符串列表，类似序列化，默认用,号分割
	/**
	 * 将对象转化为分割的字符串列表，类似序列化，默认用,号分割
	 */
	public String ToSplitString()
	{
		return ToSplitString(",");
	}

	/**
	 * 将对象转化为分割的字符串列表，类似序列化，默认用,号分割
	 *
	 * 字符串
	 */
	public String ToSplitString(String strSplit)
	{
		StringBuffer sbStr = new StringBuffer(1024);
            sbStr.append(getDatabaseprojectid()).append(strSplit);
            sbStr.append(getProjectid()).append(strSplit);
            sbStr.append(getProjectname()).append(strSplit);
            sbStr.append(getDatabaseenterpriseid()).append(strSplit);
            sbStr.append(getProquality()).append(strSplit);
            sbStr.append(getAddress()).append(strSplit);
            sbStr.append(getCreatetime()).append(strSplit);
            sbStr.append(getPlantime()).append(strSplit);
            sbStr.append(getCompletetime()).append(strSplit);
            sbStr.append(getProcontent()).append(strSplit);
            sbStr.append(getPlaninvest()).append(strSplit);
            sbStr.append(getTotalinvest()).append(strSplit);
            sbStr.append(getRealinvest()).append(strSplit);
            sbStr.append(getYearinvest()).append(strSplit);
            sbStr.append(getPublicinvest()).append(strSplit);
            sbStr.append(getSelfinvest()).append(strSplit);
            sbStr.append(getBankloan()).append(strSplit);
            sbStr.append(getShb()).append(strSplit);
            sbStr.append(getHppf()).append(strSplit);
            sbStr.append(getTdpz()).append(strSplit);
            sbStr.append(getGhxz()).append(strSplit);
            sbStr.append(getShbno()).append(strSplit);
            sbStr.append(getHppfno()).append(strSplit);
            sbStr.append(getTdpzno()).append(strSplit);
            sbStr.append(getGhxzno()).append(strSplit);
            sbStr.append(getRegionid()).append(strSplit);
            sbStr.append(getDutyunitid()).append(strSplit);
            sbStr.append(getIndustryid()).append(strSplit);
            sbStr.append(getPlanprogress()).append(strSplit);
            sbStr.append(getRealprogress()).append(strSplit);
            sbStr.append(getFeature()).append(strSplit);
            sbStr.append(getState()).append(strSplit);
            sbStr.append(getLinkman()).append(strSplit);
            sbStr.append(getPhone()).append(strSplit);
            sbStr.append(getComment()).append(strSplit);
            sbStr.append(getPic()).append(strSplit);
            sbStr.append(getDatabasepeopleid1()).append(strSplit);
            sbStr.append(getDatabasepeopleid2()).append(strSplit);
            sbStr.append(getAdminid()).append(strSplit);
            sbStr.append(getSectorid()).append(strSplit);
            sbStr.append(getLogintime()).append(strSplit);

		return sbStr.toString();
	}
	 //[end]

	// [start] FormSplitString 从字符串中初始化对象，类似反序列化
	/**
	 * 从字符串中初始化对象，类似反序列化
	 *
	 * @param objString 对象字符串
	 */
	public void FormSplitString(String objString)
	{
		FormSplitString(objString, ",");
	}

	// FormSplitString 从字符串中初始化对象，类似反序列化
	/**
	 * 从字符串中初始化对象，类似反序列化
	 *
	 * @param objString对象字符串
	 */
	public void FormSplitString(String objString, String strSplit)
	{
		if (objString == null)
		{
			return;
		}
		String[] objs = objString.split(strSplit);

            if (objs.length != 41)
            {
                return;
            }
            if (objs[0] != null || objs[0].length() >= 1)
            {
                setDatabaseprojectid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setProjectid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setProjectname(com.colorwinglib.Converts.objToStr(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setDatabaseenterpriseid(com.colorwinglib.Converts.StrToInt(objs[3]));
            }
            if (objs[4] != null || objs[4].length() >= 1)
            {
                setProquality(com.colorwinglib.Converts.StrToInt(objs[4]));
            }
            if (objs[5] != null || objs[5].length() >= 1)
            {
                setAddress(com.colorwinglib.Converts.objToStr(objs[5]));
            }
            if (objs[6] != null || objs[6].length() >= 1)
            {
                setCreatetime(com.colorwinglib.Converts.StrToDate(objs[6]));
            }
            if (objs[7] != null || objs[7].length() >= 1)
            {
                setPlantime(com.colorwinglib.Converts.StrToDate(objs[7]));
            }
            if (objs[8] != null || objs[8].length() >= 1)
            {
                setCompletetime(com.colorwinglib.Converts.StrToDate(objs[8]));
            }
            if (objs[9] != null || objs[9].length() >= 1)
            {
                setProcontent(com.colorwinglib.Converts.objToStr(objs[9]));
            }
            if (objs[10] != null || objs[10].length() >= 1)
            {
                setPlaninvest(com.colorwinglib.Converts.StrToFloat(objs[10]));
            }
            if (objs[11] != null || objs[11].length() >= 1)
            {
                setTotalinvest(com.colorwinglib.Converts.StrToFloat(objs[11]));
            }
            if (objs[12] != null || objs[12].length() >= 1)
            {
                setRealinvest(com.colorwinglib.Converts.StrToFloat(objs[12]));
            }
            if (objs[13] != null || objs[13].length() >= 1)
            {
                setYearinvest(com.colorwinglib.Converts.StrToFloat(objs[13]));
            }
            if (objs[14] != null || objs[14].length() >= 1)
            {
                setPublicinvest(com.colorwinglib.Converts.StrToFloat(objs[14]));
            }
            if (objs[15] != null || objs[15].length() >= 1)
            {
                setSelfinvest(com.colorwinglib.Converts.StrToFloat(objs[15]));
            }
            if (objs[16] != null || objs[16].length() >= 1)
            {
                setBankloan(com.colorwinglib.Converts.StrToFloat(objs[16]));
            }
            if (objs[17] != null || objs[17].length() >= 1)
            {
                setShb(com.colorwinglib.Converts.StrToInt(objs[17]));
            }
            if (objs[18] != null || objs[18].length() >= 1)
            {
                setHppf(com.colorwinglib.Converts.StrToInt(objs[18]));
            }
            if (objs[19] != null || objs[19].length() >= 1)
            {
                setTdpz(com.colorwinglib.Converts.StrToInt(objs[19]));
            }
            if (objs[20] != null || objs[20].length() >= 1)
            {
                setGhxz(com.colorwinglib.Converts.StrToInt(objs[20]));
            }
            if (objs[21] != null || objs[21].length() >= 1)
            {
                setShbno(com.colorwinglib.Converts.objToStr(objs[21]));
            }
            if (objs[22] != null || objs[22].length() >= 1)
            {
                setHppfno(com.colorwinglib.Converts.objToStr(objs[22]));
            }
            if (objs[23] != null || objs[23].length() >= 1)
            {
                setTdpzno(com.colorwinglib.Converts.objToStr(objs[23]));
            }
            if (objs[24] != null || objs[24].length() >= 1)
            {
                setGhxzno(com.colorwinglib.Converts.objToStr(objs[24]));
            }
            if (objs[25] != null || objs[25].length() >= 1)
            {
                setRegionid(com.colorwinglib.Converts.StrToInt(objs[25]));
            }
            if (objs[26] != null || objs[26].length() >= 1)
            {
                setDutyunitid(com.colorwinglib.Converts.StrToInt(objs[26]));
            }
            if (objs[27] != null || objs[27].length() >= 1)
            {
                setIndustryid(com.colorwinglib.Converts.StrToInt(objs[27]));
            }
            if (objs[28] != null || objs[28].length() >= 1)
            {
                setPlanprogress(com.colorwinglib.Converts.objToStr(objs[28]));
            }
            if (objs[29] != null || objs[29].length() >= 1)
            {
                setRealprogress(com.colorwinglib.Converts.objToStr(objs[29]));
            }
            if (objs[30] != null || objs[30].length() >= 1)
            {
                setFeature(com.colorwinglib.Converts.objToStr(objs[30]));
            }
            if (objs[31] != null || objs[31].length() >= 1)
            {
                setState(com.colorwinglib.Converts.objToStr(objs[31]));
            }
            if (objs[32] != null || objs[32].length() >= 1)
            {
                setLinkman(com.colorwinglib.Converts.objToStr(objs[32]));
            }
            if (objs[33] != null || objs[33].length() >= 1)
            {
                setPhone(com.colorwinglib.Converts.objToStr(objs[33]));
            }
            if (objs[34] != null || objs[34].length() >= 1)
            {
                setComment(com.colorwinglib.Converts.objToStr(objs[34]));
            }
            if (objs[35] != null || objs[35].length() >= 1)
            {
                setPic(com.colorwinglib.Converts.objToStr(objs[35]));
            }
            if (objs[36] != null || objs[36].length() >= 1)
            {
                setDatabasepeopleid1(com.colorwinglib.Converts.StrToInt(objs[36]));
            }
            if (objs[37] != null || objs[37].length() >= 1)
            {
                setDatabasepeopleid2(com.colorwinglib.Converts.StrToInt(objs[37]));
            }
            if (objs[38] != null || objs[38].length() >= 1)
            {
                setAdminid(com.colorwinglib.Converts.StrToInt(objs[38]));
            }
            if (objs[39] != null || objs[39].length() >= 1)
            {
                setSectorid(com.colorwinglib.Converts.StrToInt(objs[39]));
            }
            if (objs[40] != null || objs[40].length() >= 1)
            {
                setLogintime(com.colorwinglib.Converts.StrToDate(objs[40]));
            }

	}
	 //[end]


	// [start] 获取 Url
	/**
	 * 获取 Url
	 */
	public String getUrl()
	{
		return this.ToUrlEncodeLinkStringByFirstToLower();
	}
	// [end]

	// [start] 将对象转化为Url连接字符串
	/**
	 * 将对象转化为Url连接字符串
	 */
	public String ToUrlEncodeLinkString()
	{

		StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("&Databaseprojectid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseprojectid()));//项目ID
            sbStr.append("&Projectid=").append(com.colorwinglib.StringFormat.UrlEncode(getProjectid()));//项目编号
            sbStr.append("&Projectname=").append(com.colorwinglib.StringFormat.UrlEncode(getProjectname()));//项目名称
            sbStr.append("&Databaseenterpriseid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseenterpriseid()));//经营单位
            sbStr.append("&Proquality=").append(com.colorwinglib.StringFormat.UrlEncode(getProquality()));//建设性质
            sbStr.append("&Address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//所在地址
            sbStr.append("&Createtime=").append(com.colorwinglib.StringFormat.UrlEncode(getCreatetime()));//创建时间
            sbStr.append("&Plantime=").append(com.colorwinglib.StringFormat.UrlEncode(getPlantime()));//计划时间
            sbStr.append("&Completetime=").append(com.colorwinglib.StringFormat.UrlEncode(getCompletetime()));//完成时间
            sbStr.append("&Procontent=").append(com.colorwinglib.StringFormat.UrlEncode(getProcontent()));//项目内容
            sbStr.append("&Planinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getPlaninvest()));//计划投入资金
            sbStr.append("&Totalinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getTotalinvest()));//实际投入资金
            sbStr.append("&Realinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getRealinvest()));//RealInvest
            sbStr.append("&Yearinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getYearinvest()));//本年投入资金
            sbStr.append("&Publicinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getPublicinvest()));//政府投资
            sbStr.append("&Selfinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getSelfinvest()));//自筹
            sbStr.append("&Bankloan=").append(com.colorwinglib.StringFormat.UrlEncode(getBankloan()));//银行
            sbStr.append("&Shb=").append(com.colorwinglib.StringFormat.UrlEncode(getShb()));//审批,核准,备案
            sbStr.append("&Hppf=").append(com.colorwinglib.StringFormat.UrlEncode(getHppf()));//环评批复
            sbStr.append("&Tdpz=").append(com.colorwinglib.StringFormat.UrlEncode(getTdpz()));//土地批准
            sbStr.append("&Ghxz=").append(com.colorwinglib.StringFormat.UrlEncode(getGhxz()));//规划选址
            sbStr.append("&Shbno=").append(com.colorwinglib.StringFormat.UrlEncode(getShbno()));//shbno
            sbStr.append("&Hppfno=").append(com.colorwinglib.StringFormat.UrlEncode(getHppfno()));//hppfno
            sbStr.append("&Tdpzno=").append(com.colorwinglib.StringFormat.UrlEncode(getTdpzno()));//tdpzno
            sbStr.append("&Ghxzno=").append(com.colorwinglib.StringFormat.UrlEncode(getGhxzno()));//ghxzno
            sbStr.append("&Regionid=").append(com.colorwinglib.StringFormat.UrlEncode(getRegionid()));//所属区域
            sbStr.append("&Dutyunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDutyunitid()));//主管单位
            sbStr.append("&Industryid=").append(com.colorwinglib.StringFormat.UrlEncode(getIndustryid()));//产业类别
            sbStr.append("&Planprogress=").append(com.colorwinglib.StringFormat.UrlEncode(getPlanprogress()));//计划进度
            sbStr.append("&Realprogress=").append(com.colorwinglib.StringFormat.UrlEncode(getRealprogress()));//实际进度
            sbStr.append("&Feature=").append(com.colorwinglib.StringFormat.UrlEncode(getFeature()));//项目特色
            sbStr.append("&State=").append(com.colorwinglib.StringFormat.UrlEncode(getState()));//经营状况
            sbStr.append("&Linkman=").append(com.colorwinglib.StringFormat.UrlEncode(getLinkman()));//linkman
            sbStr.append("&Phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//phone
            sbStr.append("&Comment=").append(com.colorwinglib.StringFormat.UrlEncode(getComment()));//comment
            sbStr.append("&Pic=").append(com.colorwinglib.StringFormat.UrlEncode(getPic()));//项目图片
            sbStr.append("&Databasepeopleid1=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid1()));//填表人员
            sbStr.append("&Databasepeopleid2=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid2()));//统计人员
            sbStr.append("&Adminid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminid()));//登录人员
            sbStr.append("&Sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//部门
            sbStr.append("&Logintime=").append(com.colorwinglib.StringFormat.UrlEncode(getLogintime()));//登录时间

		return sbStr.toString();
	}
	// [end]

	// [start] 将对象转化为Url连接字符串
	/**
	 * 将对象转化为Url连接字符串
	 *
	 * @param columnNames
	 *            需要实例化的字段列表
	 */
	public String ToUrlEncodeLinkString(String[] columnNames)
	{

		StringBuilder sbStr = new StringBuilder(1024);
		for (String columnName : columnNames)
		{
			if (columnName.equals("Databaseprojectid"))
				sbStr.append("&Databaseprojectid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseprojectid()));//项目ID
			if (columnName.equals("Projectid"))
				sbStr.append("&Projectid=").append(com.colorwinglib.StringFormat.UrlEncode(getProjectid()));//项目编号
			if (columnName.equals("Projectname"))
				sbStr.append("&Projectname=").append(com.colorwinglib.StringFormat.UrlEncode(getProjectname()));//项目名称
			if (columnName.equals("Databaseenterpriseid"))
				sbStr.append("&Databaseenterpriseid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseenterpriseid()));//经营单位
			if (columnName.equals("Proquality"))
				sbStr.append("&Proquality=").append(com.colorwinglib.StringFormat.UrlEncode(getProquality()));//建设性质
			if (columnName.equals("Address"))
				sbStr.append("&Address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//所在地址
			if (columnName.equals("Createtime"))
				sbStr.append("&Createtime=").append(com.colorwinglib.StringFormat.UrlEncode(getCreatetime()));//创建时间
			if (columnName.equals("Plantime"))
				sbStr.append("&Plantime=").append(com.colorwinglib.StringFormat.UrlEncode(getPlantime()));//计划时间
			if (columnName.equals("Completetime"))
				sbStr.append("&Completetime=").append(com.colorwinglib.StringFormat.UrlEncode(getCompletetime()));//完成时间
			if (columnName.equals("Procontent"))
				sbStr.append("&Procontent=").append(com.colorwinglib.StringFormat.UrlEncode(getProcontent()));//项目内容
			if (columnName.equals("Planinvest"))
				sbStr.append("&Planinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getPlaninvest()));//计划投入资金
			if (columnName.equals("Totalinvest"))
				sbStr.append("&Totalinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getTotalinvest()));//实际投入资金
			if (columnName.equals("Realinvest"))
				sbStr.append("&Realinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getRealinvest()));//RealInvest
			if (columnName.equals("Yearinvest"))
				sbStr.append("&Yearinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getYearinvest()));//本年投入资金
			if (columnName.equals("Publicinvest"))
				sbStr.append("&Publicinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getPublicinvest()));//政府投资
			if (columnName.equals("Selfinvest"))
				sbStr.append("&Selfinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getSelfinvest()));//自筹
			if (columnName.equals("Bankloan"))
				sbStr.append("&Bankloan=").append(com.colorwinglib.StringFormat.UrlEncode(getBankloan()));//银行
			if (columnName.equals("Shb"))
				sbStr.append("&Shb=").append(com.colorwinglib.StringFormat.UrlEncode(getShb()));//审批,核准,备案
			if (columnName.equals("Hppf"))
				sbStr.append("&Hppf=").append(com.colorwinglib.StringFormat.UrlEncode(getHppf()));//环评批复
			if (columnName.equals("Tdpz"))
				sbStr.append("&Tdpz=").append(com.colorwinglib.StringFormat.UrlEncode(getTdpz()));//土地批准
			if (columnName.equals("Ghxz"))
				sbStr.append("&Ghxz=").append(com.colorwinglib.StringFormat.UrlEncode(getGhxz()));//规划选址
			if (columnName.equals("Shbno"))
				sbStr.append("&Shbno=").append(com.colorwinglib.StringFormat.UrlEncode(getShbno()));//shbno
			if (columnName.equals("Hppfno"))
				sbStr.append("&Hppfno=").append(com.colorwinglib.StringFormat.UrlEncode(getHppfno()));//hppfno
			if (columnName.equals("Tdpzno"))
				sbStr.append("&Tdpzno=").append(com.colorwinglib.StringFormat.UrlEncode(getTdpzno()));//tdpzno
			if (columnName.equals("Ghxzno"))
				sbStr.append("&Ghxzno=").append(com.colorwinglib.StringFormat.UrlEncode(getGhxzno()));//ghxzno
			if (columnName.equals("Regionid"))
				sbStr.append("&Regionid=").append(com.colorwinglib.StringFormat.UrlEncode(getRegionid()));//所属区域
			if (columnName.equals("Dutyunitid"))
				sbStr.append("&Dutyunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDutyunitid()));//主管单位
			if (columnName.equals("Industryid"))
				sbStr.append("&Industryid=").append(com.colorwinglib.StringFormat.UrlEncode(getIndustryid()));//产业类别
			if (columnName.equals("Planprogress"))
				sbStr.append("&Planprogress=").append(com.colorwinglib.StringFormat.UrlEncode(getPlanprogress()));//计划进度
			if (columnName.equals("Realprogress"))
				sbStr.append("&Realprogress=").append(com.colorwinglib.StringFormat.UrlEncode(getRealprogress()));//实际进度
			if (columnName.equals("Feature"))
				sbStr.append("&Feature=").append(com.colorwinglib.StringFormat.UrlEncode(getFeature()));//项目特色
			if (columnName.equals("State"))
				sbStr.append("&State=").append(com.colorwinglib.StringFormat.UrlEncode(getState()));//经营状况
			if (columnName.equals("Linkman"))
				sbStr.append("&Linkman=").append(com.colorwinglib.StringFormat.UrlEncode(getLinkman()));//linkman
			if (columnName.equals("Phone"))
				sbStr.append("&Phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//phone
			if (columnName.equals("Comment"))
				sbStr.append("&Comment=").append(com.colorwinglib.StringFormat.UrlEncode(getComment()));//comment
			if (columnName.equals("Pic"))
				sbStr.append("&Pic=").append(com.colorwinglib.StringFormat.UrlEncode(getPic()));//项目图片
			if (columnName.equals("Databasepeopleid1"))
				sbStr.append("&Databasepeopleid1=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid1()));//填表人员
			if (columnName.equals("Databasepeopleid2"))
				sbStr.append("&Databasepeopleid2=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid2()));//统计人员
			if (columnName.equals("Adminid"))
				sbStr.append("&Adminid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminid()));//登录人员
			if (columnName.equals("Sectorid"))
				sbStr.append("&Sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//部门
			if (columnName.equals("Logintime"))
				sbStr.append("&Logintime=").append(com.colorwinglib.StringFormat.UrlEncode(getLogintime()));//登录时间
		}
		return sbStr.toString();
	}
	// [end]

	// [start] 将对象转化为Url连接字符串
	/**
	 * 将对象转化为Url连接字符串
	 */
	public String ToUrlEncodeLinkStringByFirstToLower()
	{

		StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("&databaseprojectid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseprojectid()));//项目ID
            sbStr.append("&projectid=").append(com.colorwinglib.StringFormat.UrlEncode(getProjectid()));//项目编号
            sbStr.append("&projectname=").append(com.colorwinglib.StringFormat.UrlEncode(getProjectname()));//项目名称
            sbStr.append("&databaseenterpriseid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseenterpriseid()));//经营单位
            sbStr.append("&proquality=").append(com.colorwinglib.StringFormat.UrlEncode(getProquality()));//建设性质
            sbStr.append("&address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//所在地址
            sbStr.append("&createtime=").append(com.colorwinglib.StringFormat.UrlEncode(getCreatetime()));//创建时间
            sbStr.append("&plantime=").append(com.colorwinglib.StringFormat.UrlEncode(getPlantime()));//计划时间
            sbStr.append("&completetime=").append(com.colorwinglib.StringFormat.UrlEncode(getCompletetime()));//完成时间
            sbStr.append("&procontent=").append(com.colorwinglib.StringFormat.UrlEncode(getProcontent()));//项目内容
            sbStr.append("&planinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getPlaninvest()));//计划投入资金
            sbStr.append("&totalinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getTotalinvest()));//实际投入资金
            sbStr.append("&realinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getRealinvest()));//RealInvest
            sbStr.append("&yearinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getYearinvest()));//本年投入资金
            sbStr.append("&publicinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getPublicinvest()));//政府投资
            sbStr.append("&selfinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getSelfinvest()));//自筹
            sbStr.append("&bankloan=").append(com.colorwinglib.StringFormat.UrlEncode(getBankloan()));//银行
            sbStr.append("&shb=").append(com.colorwinglib.StringFormat.UrlEncode(getShb()));//审批,核准,备案
            sbStr.append("&hppf=").append(com.colorwinglib.StringFormat.UrlEncode(getHppf()));//环评批复
            sbStr.append("&tdpz=").append(com.colorwinglib.StringFormat.UrlEncode(getTdpz()));//土地批准
            sbStr.append("&ghxz=").append(com.colorwinglib.StringFormat.UrlEncode(getGhxz()));//规划选址
            sbStr.append("&shbno=").append(com.colorwinglib.StringFormat.UrlEncode(getShbno()));//shbno
            sbStr.append("&hppfno=").append(com.colorwinglib.StringFormat.UrlEncode(getHppfno()));//hppfno
            sbStr.append("&tdpzno=").append(com.colorwinglib.StringFormat.UrlEncode(getTdpzno()));//tdpzno
            sbStr.append("&ghxzno=").append(com.colorwinglib.StringFormat.UrlEncode(getGhxzno()));//ghxzno
            sbStr.append("&regionid=").append(com.colorwinglib.StringFormat.UrlEncode(getRegionid()));//所属区域
            sbStr.append("&dutyunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDutyunitid()));//主管单位
            sbStr.append("&industryid=").append(com.colorwinglib.StringFormat.UrlEncode(getIndustryid()));//产业类别
            sbStr.append("&planprogress=").append(com.colorwinglib.StringFormat.UrlEncode(getPlanprogress()));//计划进度
            sbStr.append("&realprogress=").append(com.colorwinglib.StringFormat.UrlEncode(getRealprogress()));//实际进度
            sbStr.append("&feature=").append(com.colorwinglib.StringFormat.UrlEncode(getFeature()));//项目特色
            sbStr.append("&state=").append(com.colorwinglib.StringFormat.UrlEncode(getState()));//经营状况
            sbStr.append("&linkman=").append(com.colorwinglib.StringFormat.UrlEncode(getLinkman()));//linkman
            sbStr.append("&phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//phone
            sbStr.append("&comment=").append(com.colorwinglib.StringFormat.UrlEncode(getComment()));//comment
            sbStr.append("&pic=").append(com.colorwinglib.StringFormat.UrlEncode(getPic()));//项目图片
            sbStr.append("&databasepeopleid1=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid1()));//填表人员
            sbStr.append("&databasepeopleid2=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid2()));//统计人员
            sbStr.append("&adminid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminid()));//登录人员
            sbStr.append("&sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//部门
            sbStr.append("&logintime=").append(com.colorwinglib.StringFormat.UrlEncode(getLogintime()));//登录时间

		return sbStr.toString();
	}
	// [end]

	// [start] 将对象转化为Url连接字符串
	/**
	 * 将对象转化为Url连接字符串
	 *
	 * @param columnNames
	 *            需要实例化的字段列表
	 */
	public String ToUrlEncodeLinkStringByFirstToLower(String[] columnNames)
	{

		StringBuilder sbStr = new StringBuilder(1024);
		for (String columnName : columnNames)
		{
			if (columnName.equals("Databaseprojectid"))
				sbStr.append("&databaseprojectid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseprojectid()));//项目ID
			if (columnName.equals("Projectid"))
				sbStr.append("&projectid=").append(com.colorwinglib.StringFormat.UrlEncode(getProjectid()));//项目编号
			if (columnName.equals("Projectname"))
				sbStr.append("&projectname=").append(com.colorwinglib.StringFormat.UrlEncode(getProjectname()));//项目名称
			if (columnName.equals("Databaseenterpriseid"))
				sbStr.append("&databaseenterpriseid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseenterpriseid()));//经营单位
			if (columnName.equals("Proquality"))
				sbStr.append("&proquality=").append(com.colorwinglib.StringFormat.UrlEncode(getProquality()));//建设性质
			if (columnName.equals("Address"))
				sbStr.append("&address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//所在地址
			if (columnName.equals("Createtime"))
				sbStr.append("&createtime=").append(com.colorwinglib.StringFormat.UrlEncode(getCreatetime()));//创建时间
			if (columnName.equals("Plantime"))
				sbStr.append("&plantime=").append(com.colorwinglib.StringFormat.UrlEncode(getPlantime()));//计划时间
			if (columnName.equals("Completetime"))
				sbStr.append("&completetime=").append(com.colorwinglib.StringFormat.UrlEncode(getCompletetime()));//完成时间
			if (columnName.equals("Procontent"))
				sbStr.append("&procontent=").append(com.colorwinglib.StringFormat.UrlEncode(getProcontent()));//项目内容
			if (columnName.equals("Planinvest"))
				sbStr.append("&planinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getPlaninvest()));//计划投入资金
			if (columnName.equals("Totalinvest"))
				sbStr.append("&totalinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getTotalinvest()));//实际投入资金
			if (columnName.equals("Realinvest"))
				sbStr.append("&realinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getRealinvest()));//RealInvest
			if (columnName.equals("Yearinvest"))
				sbStr.append("&yearinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getYearinvest()));//本年投入资金
			if (columnName.equals("Publicinvest"))
				sbStr.append("&publicinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getPublicinvest()));//政府投资
			if (columnName.equals("Selfinvest"))
				sbStr.append("&selfinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getSelfinvest()));//自筹
			if (columnName.equals("Bankloan"))
				sbStr.append("&bankloan=").append(com.colorwinglib.StringFormat.UrlEncode(getBankloan()));//银行
			if (columnName.equals("Shb"))
				sbStr.append("&shb=").append(com.colorwinglib.StringFormat.UrlEncode(getShb()));//审批,核准,备案
			if (columnName.equals("Hppf"))
				sbStr.append("&hppf=").append(com.colorwinglib.StringFormat.UrlEncode(getHppf()));//环评批复
			if (columnName.equals("Tdpz"))
				sbStr.append("&tdpz=").append(com.colorwinglib.StringFormat.UrlEncode(getTdpz()));//土地批准
			if (columnName.equals("Ghxz"))
				sbStr.append("&ghxz=").append(com.colorwinglib.StringFormat.UrlEncode(getGhxz()));//规划选址
			if (columnName.equals("Shbno"))
				sbStr.append("&shbno=").append(com.colorwinglib.StringFormat.UrlEncode(getShbno()));//shbno
			if (columnName.equals("Hppfno"))
				sbStr.append("&hppfno=").append(com.colorwinglib.StringFormat.UrlEncode(getHppfno()));//hppfno
			if (columnName.equals("Tdpzno"))
				sbStr.append("&tdpzno=").append(com.colorwinglib.StringFormat.UrlEncode(getTdpzno()));//tdpzno
			if (columnName.equals("Ghxzno"))
				sbStr.append("&ghxzno=").append(com.colorwinglib.StringFormat.UrlEncode(getGhxzno()));//ghxzno
			if (columnName.equals("Regionid"))
				sbStr.append("&regionid=").append(com.colorwinglib.StringFormat.UrlEncode(getRegionid()));//所属区域
			if (columnName.equals("Dutyunitid"))
				sbStr.append("&dutyunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDutyunitid()));//主管单位
			if (columnName.equals("Industryid"))
				sbStr.append("&industryid=").append(com.colorwinglib.StringFormat.UrlEncode(getIndustryid()));//产业类别
			if (columnName.equals("Planprogress"))
				sbStr.append("&planprogress=").append(com.colorwinglib.StringFormat.UrlEncode(getPlanprogress()));//计划进度
			if (columnName.equals("Realprogress"))
				sbStr.append("&realprogress=").append(com.colorwinglib.StringFormat.UrlEncode(getRealprogress()));//实际进度
			if (columnName.equals("Feature"))
				sbStr.append("&feature=").append(com.colorwinglib.StringFormat.UrlEncode(getFeature()));//项目特色
			if (columnName.equals("State"))
				sbStr.append("&state=").append(com.colorwinglib.StringFormat.UrlEncode(getState()));//经营状况
			if (columnName.equals("Linkman"))
				sbStr.append("&linkman=").append(com.colorwinglib.StringFormat.UrlEncode(getLinkman()));//linkman
			if (columnName.equals("Phone"))
				sbStr.append("&phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//phone
			if (columnName.equals("Comment"))
				sbStr.append("&comment=").append(com.colorwinglib.StringFormat.UrlEncode(getComment()));//comment
			if (columnName.equals("Pic"))
				sbStr.append("&pic=").append(com.colorwinglib.StringFormat.UrlEncode(getPic()));//项目图片
			if (columnName.equals("Databasepeopleid1"))
				sbStr.append("&databasepeopleid1=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid1()));//填表人员
			if (columnName.equals("Databasepeopleid2"))
				sbStr.append("&databasepeopleid2=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid2()));//统计人员
			if (columnName.equals("Adminid"))
				sbStr.append("&adminid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminid()));//登录人员
			if (columnName.equals("Sectorid"))
				sbStr.append("&sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//部门
			if (columnName.equals("Logintime"))
				sbStr.append("&logintime=").append(com.colorwinglib.StringFormat.UrlEncode(getLogintime()));//登录时间
		}
		return sbStr.toString();
	}
	// [end]



	// [start] 返回实体类到二进制文件
	/**
	 * 返回实体类到二进制文件
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryProjectInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			IndustryProjectInfo obj = (IndustryProjectInfo) in.readObject();
			//System.out.println(object);
			in.close();
			return obj;
		}
		catch (ClassNotFoundException e)
		{
		}
		catch (IOException e)
		{
		}
		return null;
	}
	// [end]

	// [start] ToModifyString
	/**
	 * 返回修改的字段的内容
	 *
	 * @param objOld
	 *            需要对比的原始的对象数据
	 * @param strSplit
	 *            分割字符串，默认用“\n”号
	 * @return 对比修改的结果
	 */
	public String ToModifyString(IndustryProjectInfo objOld)
	{
		return ToModifyString(objOld, "\n");
	}

	// [end]
	// [start] ToModifyString
	/**
	 * 返回修改的字段的内容
	 *
	 * @param objOld
	 *            需要对比的原始的对象数据
	 * @param strSplit
	 *            分割字符串，默认用“\n”号
	 * @return 对比修改的结果
	 */
	public String ToModifyString(IndustryProjectInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getDatabaseprojectid(), objOld.getDatabaseprojectid()))
			sbStr.append("Databaseprojectid 项目ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabaseprojectid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabaseprojectid())).append("]").append(strSplit);// 项目ID
		if (com.colorwinglib.Validate.isEquals(getProjectid(), objOld.getProjectid()))
			sbStr.append("Projectid 项目编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getProjectid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getProjectid())).append("]").append(strSplit);// 项目编号
		if (com.colorwinglib.Validate.isEquals(getProjectname(), objOld.getProjectname()))
			sbStr.append("Projectname 项目名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getProjectname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getProjectname())).append("]").append(strSplit);// 项目名称
		if (com.colorwinglib.Validate.isEquals(getDatabaseenterpriseid(), objOld.getDatabaseenterpriseid()))
			sbStr.append("Databaseenterpriseid 经营单位:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabaseenterpriseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabaseenterpriseid())).append("]").append(strSplit);// 经营单位
		if (com.colorwinglib.Validate.isEquals(getProquality(), objOld.getProquality()))
			sbStr.append("Proquality 建设性质:[").append(com.colorwinglib.Converts.objToStr(objOld.getProquality())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getProquality())).append("]").append(strSplit);// 建设性质
		if (com.colorwinglib.Validate.isEquals(getAddress(), objOld.getAddress()))
			sbStr.append("Address 所在地址:[").append(com.colorwinglib.Converts.objToStr(objOld.getAddress())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAddress())).append("]").append(strSplit);// 所在地址
		if (com.colorwinglib.Validate.isEquals(getCreatetime(), objOld.getCreatetime()))
			sbStr.append("Createtime 创建时间:[").append(com.colorwinglib.Converts.objToStr(objOld.getCreatetime())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getCreatetime())).append("]").append(strSplit);// 创建时间
		if (com.colorwinglib.Validate.isEquals(getPlantime(), objOld.getPlantime()))
			sbStr.append("Plantime 计划时间:[").append(com.colorwinglib.Converts.objToStr(objOld.getPlantime())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPlantime())).append("]").append(strSplit);// 计划时间
		if (com.colorwinglib.Validate.isEquals(getCompletetime(), objOld.getCompletetime()))
			sbStr.append("Completetime 完成时间:[").append(com.colorwinglib.Converts.objToStr(objOld.getCompletetime())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getCompletetime())).append("]").append(strSplit);// 完成时间
		if (com.colorwinglib.Validate.isEquals(getProcontent(), objOld.getProcontent()))
			sbStr.append("Procontent 项目内容:[").append(com.colorwinglib.Converts.objToStr(objOld.getProcontent())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getProcontent())).append("]").append(strSplit);// 项目内容
		if (com.colorwinglib.Validate.isEquals(getPlaninvest(), objOld.getPlaninvest()))
			sbStr.append("Planinvest 计划投入资金:[").append(com.colorwinglib.Converts.objToStr(objOld.getPlaninvest())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPlaninvest())).append("]").append(strSplit);// 计划投入资金
		if (com.colorwinglib.Validate.isEquals(getTotalinvest(), objOld.getTotalinvest()))
			sbStr.append("Totalinvest 实际投入资金:[").append(com.colorwinglib.Converts.objToStr(objOld.getTotalinvest())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getTotalinvest())).append("]").append(strSplit);// 实际投入资金
		if (com.colorwinglib.Validate.isEquals(getRealinvest(), objOld.getRealinvest()))
			sbStr.append("Realinvest RealInvest:[").append(com.colorwinglib.Converts.objToStr(objOld.getRealinvest())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getRealinvest())).append("]").append(strSplit);// RealInvest
		if (com.colorwinglib.Validate.isEquals(getYearinvest(), objOld.getYearinvest()))
			sbStr.append("Yearinvest 本年投入资金:[").append(com.colorwinglib.Converts.objToStr(objOld.getYearinvest())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getYearinvest())).append("]").append(strSplit);// 本年投入资金
		if (com.colorwinglib.Validate.isEquals(getPublicinvest(), objOld.getPublicinvest()))
			sbStr.append("Publicinvest 政府投资:[").append(com.colorwinglib.Converts.objToStr(objOld.getPublicinvest())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPublicinvest())).append("]").append(strSplit);// 政府投资
		if (com.colorwinglib.Validate.isEquals(getSelfinvest(), objOld.getSelfinvest()))
			sbStr.append("Selfinvest 自筹:[").append(com.colorwinglib.Converts.objToStr(objOld.getSelfinvest())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getSelfinvest())).append("]").append(strSplit);// 自筹
		if (com.colorwinglib.Validate.isEquals(getBankloan(), objOld.getBankloan()))
			sbStr.append("Bankloan 银行:[").append(com.colorwinglib.Converts.objToStr(objOld.getBankloan())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getBankloan())).append("]").append(strSplit);// 银行
		if (com.colorwinglib.Validate.isEquals(getShb(), objOld.getShb()))
			sbStr.append("Shb 审批,核准,备案:[").append(com.colorwinglib.Converts.objToStr(objOld.getShb())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getShb())).append("]").append(strSplit);// 审批,核准,备案
		if (com.colorwinglib.Validate.isEquals(getHppf(), objOld.getHppf()))
			sbStr.append("Hppf 环评批复:[").append(com.colorwinglib.Converts.objToStr(objOld.getHppf())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getHppf())).append("]").append(strSplit);// 环评批复
		if (com.colorwinglib.Validate.isEquals(getTdpz(), objOld.getTdpz()))
			sbStr.append("Tdpz 土地批准:[").append(com.colorwinglib.Converts.objToStr(objOld.getTdpz())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getTdpz())).append("]").append(strSplit);// 土地批准
		if (com.colorwinglib.Validate.isEquals(getGhxz(), objOld.getGhxz()))
			sbStr.append("Ghxz 规划选址:[").append(com.colorwinglib.Converts.objToStr(objOld.getGhxz())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getGhxz())).append("]").append(strSplit);// 规划选址
		if (com.colorwinglib.Validate.isEquals(getShbno(), objOld.getShbno()))
			sbStr.append("Shbno shbno:[").append(com.colorwinglib.Converts.objToStr(objOld.getShbno())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getShbno())).append("]").append(strSplit);// shbno
		if (com.colorwinglib.Validate.isEquals(getHppfno(), objOld.getHppfno()))
			sbStr.append("Hppfno hppfno:[").append(com.colorwinglib.Converts.objToStr(objOld.getHppfno())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getHppfno())).append("]").append(strSplit);// hppfno
		if (com.colorwinglib.Validate.isEquals(getTdpzno(), objOld.getTdpzno()))
			sbStr.append("Tdpzno tdpzno:[").append(com.colorwinglib.Converts.objToStr(objOld.getTdpzno())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getTdpzno())).append("]").append(strSplit);// tdpzno
		if (com.colorwinglib.Validate.isEquals(getGhxzno(), objOld.getGhxzno()))
			sbStr.append("Ghxzno ghxzno:[").append(com.colorwinglib.Converts.objToStr(objOld.getGhxzno())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getGhxzno())).append("]").append(strSplit);// ghxzno
		if (com.colorwinglib.Validate.isEquals(getRegionid(), objOld.getRegionid()))
			sbStr.append("Regionid 所属区域:[").append(com.colorwinglib.Converts.objToStr(objOld.getRegionid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getRegionid())).append("]").append(strSplit);// 所属区域
		if (com.colorwinglib.Validate.isEquals(getDutyunitid(), objOld.getDutyunitid()))
			sbStr.append("Dutyunitid 主管单位:[").append(com.colorwinglib.Converts.objToStr(objOld.getDutyunitid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDutyunitid())).append("]").append(strSplit);// 主管单位
		if (com.colorwinglib.Validate.isEquals(getIndustryid(), objOld.getIndustryid()))
			sbStr.append("Industryid 产业类别:[").append(com.colorwinglib.Converts.objToStr(objOld.getIndustryid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getIndustryid())).append("]").append(strSplit);// 产业类别
		if (com.colorwinglib.Validate.isEquals(getPlanprogress(), objOld.getPlanprogress()))
			sbStr.append("Planprogress 计划进度:[").append(com.colorwinglib.Converts.objToStr(objOld.getPlanprogress())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPlanprogress())).append("]").append(strSplit);// 计划进度
		if (com.colorwinglib.Validate.isEquals(getRealprogress(), objOld.getRealprogress()))
			sbStr.append("Realprogress 实际进度:[").append(com.colorwinglib.Converts.objToStr(objOld.getRealprogress())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getRealprogress())).append("]").append(strSplit);// 实际进度
		if (com.colorwinglib.Validate.isEquals(getFeature(), objOld.getFeature()))
			sbStr.append("Feature 项目特色:[").append(com.colorwinglib.Converts.objToStr(objOld.getFeature())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getFeature())).append("]").append(strSplit);// 项目特色
		if (com.colorwinglib.Validate.isEquals(getState(), objOld.getState()))
			sbStr.append("State 经营状况:[").append(com.colorwinglib.Converts.objToStr(objOld.getState())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getState())).append("]").append(strSplit);// 经营状况
		if (com.colorwinglib.Validate.isEquals(getLinkman(), objOld.getLinkman()))
			sbStr.append("Linkman linkman:[").append(com.colorwinglib.Converts.objToStr(objOld.getLinkman())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getLinkman())).append("]").append(strSplit);// linkman
		if (com.colorwinglib.Validate.isEquals(getPhone(), objOld.getPhone()))
			sbStr.append("Phone phone:[").append(com.colorwinglib.Converts.objToStr(objOld.getPhone())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPhone())).append("]").append(strSplit);// phone
		if (com.colorwinglib.Validate.isEquals(getComment(), objOld.getComment()))
			sbStr.append("Comment comment:[").append(com.colorwinglib.Converts.objToStr(objOld.getComment())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getComment())).append("]").append(strSplit);// comment
		if (com.colorwinglib.Validate.isEquals(getPic(), objOld.getPic()))
			sbStr.append("Pic 项目图片:[").append(com.colorwinglib.Converts.objToStr(objOld.getPic())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPic())).append("]").append(strSplit);// 项目图片
		if (com.colorwinglib.Validate.isEquals(getDatabasepeopleid1(), objOld.getDatabasepeopleid1()))
			sbStr.append("Databasepeopleid1 填表人员:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabasepeopleid1())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabasepeopleid1())).append("]").append(strSplit);// 填表人员
		if (com.colorwinglib.Validate.isEquals(getDatabasepeopleid2(), objOld.getDatabasepeopleid2()))
			sbStr.append("Databasepeopleid2 统计人员:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabasepeopleid2())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabasepeopleid2())).append("]").append(strSplit);// 统计人员
		if (com.colorwinglib.Validate.isEquals(getAdminid(), objOld.getAdminid()))
			sbStr.append("Adminid 登录人员:[").append(com.colorwinglib.Converts.objToStr(objOld.getAdminid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAdminid())).append("]").append(strSplit);// 登录人员
		if (com.colorwinglib.Validate.isEquals(getSectorid(), objOld.getSectorid()))
			sbStr.append("Sectorid 部门:[").append(com.colorwinglib.Converts.objToStr(objOld.getSectorid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getSectorid())).append("]").append(strSplit);// 部门
		if (com.colorwinglib.Validate.isEquals(getLogintime(), objOld.getLogintime()))
			sbStr.append("Logintime 登录时间:[").append(com.colorwinglib.Converts.objToStr(objOld.getLogintime())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getLogintime())).append("]").append(strSplit);// 登录时间
		return sbStr.toString();
	}
	// [end]

	// [start] toJson 返回Json
	/**
	 * 返回Json
	 */
	public org.json.JSONObject toJson()
	{
		org.json.JSONObject json = new org.json.JSONObject();
		try
		{
			json.put("Databaseprojectid", getDatabaseprojectid());// 项目ID
			json.put("Projectid", getProjectid());// 项目编号
			json.put("Projectname", getProjectname());// 项目名称
			json.put("Databaseenterpriseid", getDatabaseenterpriseid());// 经营单位
			json.put("Proquality", getProquality());// 建设性质
			json.put("Address", getAddress());// 所在地址
			json.put("Createtime", getCreatetime());// 创建时间
			json.put("Plantime", getPlantime());// 计划时间
			json.put("Completetime", getCompletetime());// 完成时间
			json.put("Procontent", getProcontent());// 项目内容
			json.put("Planinvest", getPlaninvest());// 计划投入资金
			json.put("Totalinvest", getTotalinvest());// 实际投入资金
			json.put("Realinvest", getRealinvest());// RealInvest
			json.put("Yearinvest", getYearinvest());// 本年投入资金
			json.put("Publicinvest", getPublicinvest());// 政府投资
			json.put("Selfinvest", getSelfinvest());// 自筹
			json.put("Bankloan", getBankloan());// 银行
			json.put("Shb", getShb());// 审批,核准,备案
			json.put("Hppf", getHppf());// 环评批复
			json.put("Tdpz", getTdpz());// 土地批准
			json.put("Ghxz", getGhxz());// 规划选址
			json.put("Shbno", getShbno());// shbno
			json.put("Hppfno", getHppfno());// hppfno
			json.put("Tdpzno", getTdpzno());// tdpzno
			json.put("Ghxzno", getGhxzno());// ghxzno
			json.put("Regionid", getRegionid());// 所属区域
			json.put("Dutyunitid", getDutyunitid());// 主管单位
			json.put("Industryid", getIndustryid());// 产业类别
			json.put("Planprogress", getPlanprogress());// 计划进度
			json.put("Realprogress", getRealprogress());// 实际进度
			json.put("Feature", getFeature());// 项目特色
			json.put("State", getState());// 经营状况
			json.put("Linkman", getLinkman());// linkman
			json.put("Phone", getPhone());// phone
			json.put("Comment", getComment());// comment
			json.put("Pic", getPic());// 项目图片
			json.put("Databasepeopleid1", getDatabasepeopleid1());// 填表人员
			json.put("Databasepeopleid2", getDatabasepeopleid2());// 统计人员
			json.put("Adminid", getAdminid());// 登录人员
			json.put("Sectorid", getSectorid());// 部门
			json.put("Logintime", getLogintime());// 登录时间
		}
		catch (org.json.JSONException e)
		{
			e.printStackTrace();
		}
		return json;
	}

	// [end]

	// [start] FromJson 通过Json填充数据
	/**
	 * 通过Json填充数据
	 */
	public void FromJson(String strJson)
	{
		try
		{
			org.json.JSONObject json = new org.json.JSONObject(strJson);
			FromJson(json);
		}
		catch (org.json.JSONException e)
		{
			e.printStackTrace();
		}
	}

	// [end]
	// [start] FromJson 通过Json填充数据
	/**
	 * 通过Json填充数据
	 */
	public void FromJson(org.json.JSONObject json)
	{
		try
		{
			setDatabaseprojectid(json.getInt("Databaseprojectid"));// 项目ID
			setProjectid(json.getInt("Projectid"));// 项目编号
			setProjectname(json.getString("Projectname"));// 项目名称
			setDatabaseenterpriseid(json.getInt("Databaseenterpriseid"));// 经营单位
			setProquality(json.getInt("Proquality"));// 建设性质
			setAddress(json.getString("Address"));// 所在地址
			setCreatetime(com.colorwinglib.Converts.StrToDate(json.getString("Createtime")));// 创建时间
			setPlantime(com.colorwinglib.Converts.StrToDate(json.getString("Plantime")));// 计划时间
			setCompletetime(com.colorwinglib.Converts.StrToDate(json.getString("Completetime")));// 完成时间
			setProcontent(json.getString("Procontent"));// 项目内容
			setPlaninvest(json.getDouble("Planinvest"));// 计划投入资金
			setTotalinvest(json.getDouble("Totalinvest"));// 实际投入资金
			setRealinvest(json.getDouble("Realinvest"));// RealInvest
			setYearinvest(json.getDouble("Yearinvest"));// 本年投入资金
			setPublicinvest(json.getDouble("Publicinvest"));// 政府投资
			setSelfinvest(json.getDouble("Selfinvest"));// 自筹
			setBankloan(json.getDouble("Bankloan"));// 银行
			setShb(json.getInt("Shb"));// 审批,核准,备案
			setHppf(json.getInt("Hppf"));// 环评批复
			setTdpz(json.getInt("Tdpz"));// 土地批准
			setGhxz(json.getInt("Ghxz"));// 规划选址
			setShbno(json.getString("Shbno"));// shbno
			setHppfno(json.getString("Hppfno"));// hppfno
			setTdpzno(json.getString("Tdpzno"));// tdpzno
			setGhxzno(json.getString("Ghxzno"));// ghxzno
			setRegionid(json.getInt("Regionid"));// 所属区域
			setDutyunitid(json.getInt("Dutyunitid"));// 主管单位
			setIndustryid(json.getInt("Industryid"));// 产业类别
			setPlanprogress(json.getString("Planprogress"));// 计划进度
			setRealprogress(json.getString("Realprogress"));// 实际进度
			setFeature(json.getString("Feature"));// 项目特色
			setState(json.getString("State"));// 经营状况
			setLinkman(json.getString("Linkman"));// linkman
			setPhone(json.getString("Phone"));// phone
			setComment(json.getString("Comment"));// comment
			setPic(json.getString("Pic"));// 项目图片
			setDatabasepeopleid1(json.getInt("Databasepeopleid1"));// 填表人员
			setDatabasepeopleid2(json.getInt("Databasepeopleid2"));// 统计人员
			setAdminid(json.getInt("Adminid"));// 登录人员
			setSectorid(json.getInt("Sectorid"));// 部门
			setLogintime(com.colorwinglib.Converts.StrToDate(json.getString("Logintime")));// 登录时间

		}
		catch (org.json.JSONException e)
		{
			e.printStackTrace();
		}
	}

	// [end]



	// [start] GetXml 返回存储在实体类中的Xml表现形式
	/**
	 * GetXml 返回存储在实体类中的Xml表现形式
	 */
	public String GetXml()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		sbStr.append("<IndustryProjectInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //项目ID
			sbStr.append("    <Databaseprojectid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabaseprojectid()));
			sbStr.append("</Databaseprojectid>\n");
            //项目编号
			sbStr.append("    <Projectid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getProjectid()));
			sbStr.append("</Projectid>\n");
            //项目名称
			sbStr.append("    <Projectname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getProjectname()));
			sbStr.append("</Projectname>\n");
            //经营单位
			sbStr.append("    <Databaseenterpriseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabaseenterpriseid()));
			sbStr.append("</Databaseenterpriseid>\n");
            //建设性质
			sbStr.append("    <Proquality>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getProquality()));
			sbStr.append("</Proquality>\n");
            //所在地址
			sbStr.append("    <Address>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAddress()));
			sbStr.append("</Address>\n");
            //创建时间
			sbStr.append("    <Createtime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getCreatetime()));
			sbStr.append("</Createtime>\n");
            //计划时间
			sbStr.append("    <Plantime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPlantime()));
			sbStr.append("</Plantime>\n");
            //完成时间
			sbStr.append("    <Completetime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getCompletetime()));
			sbStr.append("</Completetime>\n");
            //项目内容
			sbStr.append("    <Procontent>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getProcontent()));
			sbStr.append("</Procontent>\n");
            //计划投入资金
			sbStr.append("    <Planinvest>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPlaninvest()));
			sbStr.append("</Planinvest>\n");
            //实际投入资金
			sbStr.append("    <Totalinvest>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getTotalinvest()));
			sbStr.append("</Totalinvest>\n");
            //RealInvest
			sbStr.append("    <Realinvest>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getRealinvest()));
			sbStr.append("</Realinvest>\n");
            //本年投入资金
			sbStr.append("    <Yearinvest>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getYearinvest()));
			sbStr.append("</Yearinvest>\n");
            //政府投资
			sbStr.append("    <Publicinvest>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPublicinvest()));
			sbStr.append("</Publicinvest>\n");
            //自筹
			sbStr.append("    <Selfinvest>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getSelfinvest()));
			sbStr.append("</Selfinvest>\n");
            //银行
			sbStr.append("    <Bankloan>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getBankloan()));
			sbStr.append("</Bankloan>\n");
            //审批,核准,备案
			sbStr.append("    <Shb>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getShb()));
			sbStr.append("</Shb>\n");
            //环评批复
			sbStr.append("    <Hppf>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getHppf()));
			sbStr.append("</Hppf>\n");
            //土地批准
			sbStr.append("    <Tdpz>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getTdpz()));
			sbStr.append("</Tdpz>\n");
            //规划选址
			sbStr.append("    <Ghxz>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getGhxz()));
			sbStr.append("</Ghxz>\n");
            //shbno
			sbStr.append("    <Shbno>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getShbno()));
			sbStr.append("</Shbno>\n");
            //hppfno
			sbStr.append("    <Hppfno>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getHppfno()));
			sbStr.append("</Hppfno>\n");
            //tdpzno
			sbStr.append("    <Tdpzno>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getTdpzno()));
			sbStr.append("</Tdpzno>\n");
            //ghxzno
			sbStr.append("    <Ghxzno>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getGhxzno()));
			sbStr.append("</Ghxzno>\n");
            //所属区域
			sbStr.append("    <Regionid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getRegionid()));
			sbStr.append("</Regionid>\n");
            //主管单位
			sbStr.append("    <Dutyunitid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDutyunitid()));
			sbStr.append("</Dutyunitid>\n");
            //产业类别
			sbStr.append("    <Industryid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getIndustryid()));
			sbStr.append("</Industryid>\n");
            //计划进度
			sbStr.append("    <Planprogress>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPlanprogress()));
			sbStr.append("</Planprogress>\n");
            //实际进度
			sbStr.append("    <Realprogress>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getRealprogress()));
			sbStr.append("</Realprogress>\n");
            //项目特色
			sbStr.append("    <Feature>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getFeature()));
			sbStr.append("</Feature>\n");
            //经营状况
			sbStr.append("    <State>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getState()));
			sbStr.append("</State>\n");
            //linkman
			sbStr.append("    <Linkman>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getLinkman()));
			sbStr.append("</Linkman>\n");
            //phone
			sbStr.append("    <Phone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPhone()));
			sbStr.append("</Phone>\n");
            //comment
			sbStr.append("    <Comment>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getComment()));
			sbStr.append("</Comment>\n");
            //项目图片
			sbStr.append("    <Pic>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPic()));
			sbStr.append("</Pic>\n");
            //填表人员
			sbStr.append("    <Databasepeopleid1>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabasepeopleid1()));
			sbStr.append("</Databasepeopleid1>\n");
            //统计人员
			sbStr.append("    <Databasepeopleid2>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabasepeopleid2()));
			sbStr.append("</Databasepeopleid2>\n");
            //登录人员
			sbStr.append("    <Adminid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAdminid()));
			sbStr.append("</Adminid>\n");
            //部门
			sbStr.append("    <Sectorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getSectorid()));
			sbStr.append("</Sectorid>\n");
            //登录时间
			sbStr.append("    <Logintime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getLogintime()));
			sbStr.append("</Logintime>\n");
		sbStr.append("</IndustryProjectInfo>\n");
		return sbStr.toString();
	}

	// [end]

	// [start] Save 保存实体类到文件
	/**
	 * 保存实体类到文件
	 */
	public void save(String filename)
	{
		com.colorwinglib.FileFormat.CreateFiles(filename, GetXml(), com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// 反序列化类
	// GetIndustryProjectInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetIndustryProjectInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static IndustryProjectInfo GetIndustryProjectInfoFormFileName(String filename)
	{
		return GetIndustryProjectInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryProjectInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryProjectInfo GetIndustryProjectInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetIndustryProjectInfoFormXml(xml, encoding);
	}

	// [end]

	// GetIndustryProjectInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetIndustryProjectInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryProjectInfo GetIndustryProjectInfoFormXml(String xml)
	{
		return GetIndustryProjectInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryProjectInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryProjectInfo GetIndustryProjectInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		IndustryProjectInfo objIndustryProjectInfo = new IndustryProjectInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//项目ID
				if (foo.elementText("Databaseprojectid") != null)
					objIndustryProjectInfo.setDatabaseprojectid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseprojectid")));
				//项目编号
				if (foo.elementText("Projectid") != null)
					objIndustryProjectInfo.setProjectid(com.colorwinglib.Converts.StrToInt(foo.elementText("Projectid")));
				//项目名称
				if (foo.elementText("Projectname") != null)
					objIndustryProjectInfo.setProjectname(com.colorwinglib.Converts.objToStr(foo.elementText("Projectname")));
				//经营单位
				if (foo.elementText("Databaseenterpriseid") != null)
					objIndustryProjectInfo.setDatabaseenterpriseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseenterpriseid")));
				//建设性质
				if (foo.elementText("Proquality") != null)
					objIndustryProjectInfo.setProquality(com.colorwinglib.Converts.StrToInt(foo.elementText("Proquality")));
				//所在地址
				if (foo.elementText("Address") != null)
					objIndustryProjectInfo.setAddress(com.colorwinglib.Converts.objToStr(foo.elementText("Address")));
				//创建时间
				if (foo.elementText("Createtime") != null)
					objIndustryProjectInfo.setCreatetime(com.colorwinglib.Converts.StrToDate(foo.elementText("Createtime")));
				//计划时间
				if (foo.elementText("Plantime") != null)
					objIndustryProjectInfo.setPlantime(com.colorwinglib.Converts.StrToDate(foo.elementText("Plantime")));
				//完成时间
				if (foo.elementText("Completetime") != null)
					objIndustryProjectInfo.setCompletetime(com.colorwinglib.Converts.StrToDate(foo.elementText("Completetime")));
				//项目内容
				if (foo.elementText("Procontent") != null)
					objIndustryProjectInfo.setProcontent(com.colorwinglib.Converts.objToStr(foo.elementText("Procontent")));
				//计划投入资金
				if (foo.elementText("Planinvest") != null)
					objIndustryProjectInfo.setPlaninvest(com.colorwinglib.Converts.StrToFloat(foo.elementText("Planinvest")));
				//实际投入资金
				if (foo.elementText("Totalinvest") != null)
					objIndustryProjectInfo.setTotalinvest(com.colorwinglib.Converts.StrToFloat(foo.elementText("Totalinvest")));
				//RealInvest
				if (foo.elementText("Realinvest") != null)
					objIndustryProjectInfo.setRealinvest(com.colorwinglib.Converts.StrToFloat(foo.elementText("Realinvest")));
				//本年投入资金
				if (foo.elementText("Yearinvest") != null)
					objIndustryProjectInfo.setYearinvest(com.colorwinglib.Converts.StrToFloat(foo.elementText("Yearinvest")));
				//政府投资
				if (foo.elementText("Publicinvest") != null)
					objIndustryProjectInfo.setPublicinvest(com.colorwinglib.Converts.StrToFloat(foo.elementText("Publicinvest")));
				//自筹
				if (foo.elementText("Selfinvest") != null)
					objIndustryProjectInfo.setSelfinvest(com.colorwinglib.Converts.StrToFloat(foo.elementText("Selfinvest")));
				//银行
				if (foo.elementText("Bankloan") != null)
					objIndustryProjectInfo.setBankloan(com.colorwinglib.Converts.StrToFloat(foo.elementText("Bankloan")));
				//审批,核准,备案
				if (foo.elementText("Shb") != null)
					objIndustryProjectInfo.setShb(com.colorwinglib.Converts.StrToInt(foo.elementText("Shb")));
				//环评批复
				if (foo.elementText("Hppf") != null)
					objIndustryProjectInfo.setHppf(com.colorwinglib.Converts.StrToInt(foo.elementText("Hppf")));
				//土地批准
				if (foo.elementText("Tdpz") != null)
					objIndustryProjectInfo.setTdpz(com.colorwinglib.Converts.StrToInt(foo.elementText("Tdpz")));
				//规划选址
				if (foo.elementText("Ghxz") != null)
					objIndustryProjectInfo.setGhxz(com.colorwinglib.Converts.StrToInt(foo.elementText("Ghxz")));
				//shbno
				if (foo.elementText("Shbno") != null)
					objIndustryProjectInfo.setShbno(com.colorwinglib.Converts.objToStr(foo.elementText("Shbno")));
				//hppfno
				if (foo.elementText("Hppfno") != null)
					objIndustryProjectInfo.setHppfno(com.colorwinglib.Converts.objToStr(foo.elementText("Hppfno")));
				//tdpzno
				if (foo.elementText("Tdpzno") != null)
					objIndustryProjectInfo.setTdpzno(com.colorwinglib.Converts.objToStr(foo.elementText("Tdpzno")));
				//ghxzno
				if (foo.elementText("Ghxzno") != null)
					objIndustryProjectInfo.setGhxzno(com.colorwinglib.Converts.objToStr(foo.elementText("Ghxzno")));
				//所属区域
				if (foo.elementText("Regionid") != null)
					objIndustryProjectInfo.setRegionid(com.colorwinglib.Converts.StrToInt(foo.elementText("Regionid")));
				//主管单位
				if (foo.elementText("Dutyunitid") != null)
					objIndustryProjectInfo.setDutyunitid(com.colorwinglib.Converts.StrToInt(foo.elementText("Dutyunitid")));
				//产业类别
				if (foo.elementText("Industryid") != null)
					objIndustryProjectInfo.setIndustryid(com.colorwinglib.Converts.StrToInt(foo.elementText("Industryid")));
				//计划进度
				if (foo.elementText("Planprogress") != null)
					objIndustryProjectInfo.setPlanprogress(com.colorwinglib.Converts.objToStr(foo.elementText("Planprogress")));
				//实际进度
				if (foo.elementText("Realprogress") != null)
					objIndustryProjectInfo.setRealprogress(com.colorwinglib.Converts.objToStr(foo.elementText("Realprogress")));
				//项目特色
				if (foo.elementText("Feature") != null)
					objIndustryProjectInfo.setFeature(com.colorwinglib.Converts.objToStr(foo.elementText("Feature")));
				//经营状况
				if (foo.elementText("State") != null)
					objIndustryProjectInfo.setState(com.colorwinglib.Converts.objToStr(foo.elementText("State")));
				//linkman
				if (foo.elementText("Linkman") != null)
					objIndustryProjectInfo.setLinkman(com.colorwinglib.Converts.objToStr(foo.elementText("Linkman")));
				//phone
				if (foo.elementText("Phone") != null)
					objIndustryProjectInfo.setPhone(com.colorwinglib.Converts.objToStr(foo.elementText("Phone")));
				//comment
				if (foo.elementText("Comment") != null)
					objIndustryProjectInfo.setComment(com.colorwinglib.Converts.objToStr(foo.elementText("Comment")));
				//项目图片
				if (foo.elementText("Pic") != null)
					objIndustryProjectInfo.setPic(com.colorwinglib.Converts.objToStr(foo.elementText("Pic")));
				//填表人员
				if (foo.elementText("Databasepeopleid1") != null)
					objIndustryProjectInfo.setDatabasepeopleid1(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasepeopleid1")));
				//统计人员
				if (foo.elementText("Databasepeopleid2") != null)
					objIndustryProjectInfo.setDatabasepeopleid2(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasepeopleid2")));
				//登录人员
				if (foo.elementText("Adminid") != null)
					objIndustryProjectInfo.setAdminid(com.colorwinglib.Converts.StrToInt(foo.elementText("Adminid")));
				//部门
				if (foo.elementText("Sectorid") != null)
					objIndustryProjectInfo.setSectorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Sectorid")));
				//登录时间
				if (foo.elementText("Logintime") != null)
					objIndustryProjectInfo.setLogintime(com.colorwinglib.Converts.StrToDate(foo.elementText("Logintime")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objIndustryProjectInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public IndustryProjectInfo Copy()
	{
		IndustryProjectInfo objIndustryProjectInfo = new IndustryProjectInfo();
		objIndustryProjectInfo.setDatabaseprojectid(this.getDatabaseprojectid());//项目ID
		objIndustryProjectInfo.setProjectid(this.getProjectid());//项目编号
		objIndustryProjectInfo.setProjectname(this.getProjectname());//项目名称
		objIndustryProjectInfo.setDatabaseenterpriseid(this.getDatabaseenterpriseid());//经营单位
		objIndustryProjectInfo.setProquality(this.getProquality());//建设性质
		objIndustryProjectInfo.setAddress(this.getAddress());//所在地址
		objIndustryProjectInfo.setCreatetime(this.getCreatetime());//创建时间
		objIndustryProjectInfo.setPlantime(this.getPlantime());//计划时间
		objIndustryProjectInfo.setCompletetime(this.getCompletetime());//完成时间
		objIndustryProjectInfo.setProcontent(this.getProcontent());//项目内容
		objIndustryProjectInfo.setPlaninvest(this.getPlaninvest());//计划投入资金
		objIndustryProjectInfo.setTotalinvest(this.getTotalinvest());//实际投入资金
		objIndustryProjectInfo.setRealinvest(this.getRealinvest());//RealInvest
		objIndustryProjectInfo.setYearinvest(this.getYearinvest());//本年投入资金
		objIndustryProjectInfo.setPublicinvest(this.getPublicinvest());//政府投资
		objIndustryProjectInfo.setSelfinvest(this.getSelfinvest());//自筹
		objIndustryProjectInfo.setBankloan(this.getBankloan());//银行
		objIndustryProjectInfo.setShb(this.getShb());//审批,核准,备案
		objIndustryProjectInfo.setHppf(this.getHppf());//环评批复
		objIndustryProjectInfo.setTdpz(this.getTdpz());//土地批准
		objIndustryProjectInfo.setGhxz(this.getGhxz());//规划选址
		objIndustryProjectInfo.setShbno(this.getShbno());//shbno
		objIndustryProjectInfo.setHppfno(this.getHppfno());//hppfno
		objIndustryProjectInfo.setTdpzno(this.getTdpzno());//tdpzno
		objIndustryProjectInfo.setGhxzno(this.getGhxzno());//ghxzno
		objIndustryProjectInfo.setRegionid(this.getRegionid());//所属区域
		objIndustryProjectInfo.setDutyunitid(this.getDutyunitid());//主管单位
		objIndustryProjectInfo.setIndustryid(this.getIndustryid());//产业类别
		objIndustryProjectInfo.setPlanprogress(this.getPlanprogress());//计划进度
		objIndustryProjectInfo.setRealprogress(this.getRealprogress());//实际进度
		objIndustryProjectInfo.setFeature(this.getFeature());//项目特色
		objIndustryProjectInfo.setState(this.getState());//经营状况
		objIndustryProjectInfo.setLinkman(this.getLinkman());//linkman
		objIndustryProjectInfo.setPhone(this.getPhone());//phone
		objIndustryProjectInfo.setComment(this.getComment());//comment
		objIndustryProjectInfo.setPic(this.getPic());//项目图片
		objIndustryProjectInfo.setDatabasepeopleid1(this.getDatabasepeopleid1());//填表人员
		objIndustryProjectInfo.setDatabasepeopleid2(this.getDatabasepeopleid2());//统计人员
		objIndustryProjectInfo.setAdminid(this.getAdminid());//登录人员
		objIndustryProjectInfo.setSectorid(this.getSectorid());//部门
		objIndustryProjectInfo.setLogintime(this.getLogintime());//登录时间
		return objIndustryProjectInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
