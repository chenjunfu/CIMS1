
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Enterprise 企业信息表的描述
 * 实体类基本类
 */
public class EnterpriseInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2013012213515756255L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public EnterpriseInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public EnterpriseInfoBase(int sDatabaseenterpriseid)
	{
		this.setDatabaseenterpriseid(sDatabaseenterpriseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public EnterpriseInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setDatabaseenterpriseid(rs.getInt("DatabaseEnterpriseID"));//企业ID
		setEnterpriseid(rs.getInt("EnterpriseID"));//企业编号
		setEnterprisename(rs.getString("EnterpriseName"));//企业名称
		setBusinesstypeid(rs.getInt("BusinessTypeID"));//行业类型
		setLegalperson(rs.getString("LegalPerson"));//法人
		setCreatetime(MyDate.setDate(rs.getTimestamp("CreateTime")));//创立时间
		setRegionid(rs.getInt("RegionID"));//所属区域
		setAddress(rs.getString("Address"));//企业地址
		setEnterprisecode(rs.getString("EnterpriseCode"));//工商登记号
		setPartentcode(rs.getString("PartentCode"));//产品专利号
		setScope(rs.getString("Scope"));//经营范围
		setRegistaddress(rs.getString("RegistAddress"));//企业注册地址
		setRegistfund(rs.getDouble("RegistFund"));//注册资金
		setArea(rs.getInt("Area"));//占地面积
		setToalinvest(rs.getDouble("ToalInvest"));//总投资
		setQualityid(rs.getInt("QualityID"));//企业性质
		setEmploynumber(rs.getInt("EmployNumber"));//就业人数
		setProducevalue(rs.getDouble("ProduceValue"));//年产值
		setProfit(rs.getDouble("Profit"));//利润
		setFeature(rs.getString("Feature"));//产品特色
		setObtainhonor(rs.getString("ObtainHonor"));//获得荣誉
		setSocialbenefit(rs.getString("SocialBenefit"));//社会效益
		setPeopleid1(rs.getInt("PeopleID1"));//统计人员
		setPeopleid2(rs.getInt("PeopleID2"));//填表人员
		setAdminid(rs.getInt("AdminID"));//登录人员
		setSectorid(rs.getInt("SectorID"));//部门编号
		setLogintime(MyDate.setDate(rs.getTimestamp("LoginTime")));//登录时间
		setLinkphone(rs.getString("LinkPhone"));//联系电话
		setContact(rs.getString("contact"));//联系人
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public EnterpriseInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//企业ID
			if (columnName.equals("DatabaseEnterpriseID"))
			{
				setDatabaseenterpriseid(rs.getInt("DatabaseEnterpriseID"));
				continue;
			}
			//企业编号
			if (columnName.equals("EnterpriseID"))
			{
				setEnterpriseid(rs.getInt("EnterpriseID"));
				continue;
			}
			//企业名称
			if (columnName.equals("EnterpriseName"))
			{
				setEnterprisename(rs.getString("EnterpriseName"));
				continue;
			}
			//行业类型
			if (columnName.equals("BusinessTypeID"))
			{
				setBusinesstypeid(rs.getInt("BusinessTypeID"));
				continue;
			}
			//法人
			if (columnName.equals("LegalPerson"))
			{
				setLegalperson(rs.getString("LegalPerson"));
				continue;
			}
			//创立时间
			if (columnName.equals("CreateTime"))
			{
				setCreatetime(MyDate.setDate(rs.getTimestamp("CreateTime")));
				continue;
			}
			//所属区域
			if (columnName.equals("RegionID"))
			{
				setRegionid(rs.getInt("RegionID"));
				continue;
			}
			//企业地址
			if (columnName.equals("Address"))
			{
				setAddress(rs.getString("Address"));
				continue;
			}
			//工商登记号
			if (columnName.equals("EnterpriseCode"))
			{
				setEnterprisecode(rs.getString("EnterpriseCode"));
				continue;
			}
			//产品专利号
			if (columnName.equals("PartentCode"))
			{
				setPartentcode(rs.getString("PartentCode"));
				continue;
			}
			//经营范围
			if (columnName.equals("Scope"))
			{
				setScope(rs.getString("Scope"));
				continue;
			}
			//企业注册地址
			if (columnName.equals("RegistAddress"))
			{
				setRegistaddress(rs.getString("RegistAddress"));
				continue;
			}
			//注册资金
			if (columnName.equals("RegistFund"))
			{
				setRegistfund(rs.getDouble("RegistFund"));
				continue;
			}
			//占地面积
			if (columnName.equals("Area"))
			{
				setArea(rs.getInt("Area"));
				continue;
			}
			//总投资
			if (columnName.equals("ToalInvest"))
			{
				setToalinvest(rs.getDouble("ToalInvest"));
				continue;
			}
			//企业性质
			if (columnName.equals("QualityID"))
			{
				setQualityid(rs.getInt("QualityID"));
				continue;
			}
			//就业人数
			if (columnName.equals("EmployNumber"))
			{
				setEmploynumber(rs.getInt("EmployNumber"));
				continue;
			}
			//年产值
			if (columnName.equals("ProduceValue"))
			{
				setProducevalue(rs.getDouble("ProduceValue"));
				continue;
			}
			//利润
			if (columnName.equals("Profit"))
			{
				setProfit(rs.getDouble("Profit"));
				continue;
			}
			//产品特色
			if (columnName.equals("Feature"))
			{
				setFeature(rs.getString("Feature"));
				continue;
			}
			//获得荣誉
			if (columnName.equals("ObtainHonor"))
			{
				setObtainhonor(rs.getString("ObtainHonor"));
				continue;
			}
			//社会效益
			if (columnName.equals("SocialBenefit"))
			{
				setSocialbenefit(rs.getString("SocialBenefit"));
				continue;
			}
			//统计人员
			if (columnName.equals("PeopleID1"))
			{
				setPeopleid1(rs.getInt("PeopleID1"));
				continue;
			}
			//填表人员
			if (columnName.equals("PeopleID2"))
			{
				setPeopleid2(rs.getInt("PeopleID2"));
				continue;
			}
			//登录人员
			if (columnName.equals("AdminID"))
			{
				setAdminid(rs.getInt("AdminID"));
				continue;
			}
			//部门编号
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
			//联系电话
			if (columnName.equals("LinkPhone"))
			{
				setLinkphone(rs.getString("LinkPhone"));
				continue;
			}
			//联系人
			if (columnName.equals("contact"))
			{
				setContact(rs.getString("contact"));
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
		if (!(rhs instanceof EnterpriseInfo))
			return false;
		EnterpriseInfo that = (EnterpriseInfo) rhs;

		return (this.getDatabaseenterpriseid() == (that.getDatabaseenterpriseid()));
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

			result = result * 37 + (this.getDatabaseenterpriseid() + "").hashCode();
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
	"DatabaseEnterpriseID", //企业ID
	"EnterpriseID", //企业编号
	"EnterpriseName", //企业名称
	"BusinessTypeID", //行业类型
	"LegalPerson", //法人
	"CreateTime", //创立时间
	"RegionID", //所属区域
	"Address", //企业地址
	"EnterpriseCode", //工商登记号
	"PartentCode", //产品专利号
	"Scope", //经营范围
	"RegistAddress", //企业注册地址
	"RegistFund", //注册资金
	"Area", //占地面积
	"ToalInvest", //总投资
	"QualityID", //企业性质
	"EmployNumber", //就业人数
	"ProduceValue", //年产值
	"Profit", //利润
	"Feature", //产品特色
	"ObtainHonor", //获得荣誉
	"SocialBenefit", //社会效益
	"PeopleID1", //统计人员
	"PeopleID2", //填表人员
	"AdminID", //登录人员
	"SectorID", //部门编号
	"LoginTime", //登录时间
	"LinkPhone", //联系电话
	"contact" //联系人
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum EnterpriseColumnNameEnum
{
		/**
		 * 企业ID
		 */
		Databaseenterpriseid,
		/**
		 * 企业编号
		 */
		Enterpriseid,
		/**
		 * 企业名称
		 */
		Enterprisename,
		/**
		 * 行业类型
		 */
		Businesstypeid,
		/**
		 * 法人
		 */
		Legalperson,
		/**
		 * 创立时间
		 */
		Createtime,
		/**
		 * 所属区域
		 */
		Regionid,
		/**
		 * 企业地址
		 */
		Address,
		/**
		 * 工商登记号
		 */
		Enterprisecode,
		/**
		 * 产品专利号
		 */
		Partentcode,
		/**
		 * 经营范围
		 */
		Scope,
		/**
		 * 企业注册地址
		 */
		Registaddress,
		/**
		 * 注册资金
		 */
		Registfund,
		/**
		 * 占地面积
		 */
		Area,
		/**
		 * 总投资
		 */
		Toalinvest,
		/**
		 * 企业性质
		 */
		Qualityid,
		/**
		 * 就业人数
		 */
		Employnumber,
		/**
		 * 年产值
		 */
		Producevalue,
		/**
		 * 利润
		 */
		Profit,
		/**
		 * 产品特色
		 */
		Feature,
		/**
		 * 获得荣誉
		 */
		Obtainhonor,
		/**
		 * 社会效益
		 */
		Socialbenefit,
		/**
		 * 统计人员
		 */
		Peopleid1,
		/**
		 * 填表人员
		 */
		Peopleid2,
		/**
		 * 登录人员
		 */
		Adminid,
		/**
		 * 部门编号
		 */
		Sectorid,
		/**
		 * 登录时间
		 */
		Logintime,
		/**
		 * 联系电话
		 */
		Linkphone,
		/**
		 * 联系人
		 */
		Contact
	};
	// [end]
        // [start] 设置和获取 企业ID, 默认值:0
	// 设置和获取 企业ID,类型int 默认值:0 开始
	private int databaseenterpriseid = 0;
	/**
	* 获取 企业ID, 类型int 默认值:0
	 *
	 * @return 企业ID, 类型int 默认值:0
	 */
	public int getDatabaseenterpriseid()
	{
		return this.databaseenterpriseid; 
	}
	/**
	 * 设置 企业ID, 类型int 默认值:0
	 *
	 * @param sDatabaseenterpriseid
	 *            企业ID, 类型int 默认值:0
	 */
	public void setDatabaseenterpriseid(int sDatabaseenterpriseid)
	{
		this.databaseenterpriseid = sDatabaseenterpriseid; 
	}
	// 设置和获取 企业ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 企业编号, 默认值:0
	// 设置和获取 企业编号,类型int 默认值:0 开始
	private int enterpriseid = 0;
	/**
	* 获取 企业编号, 类型int 默认值:0
	 *
	 * @return 企业编号, 类型int 默认值:0
	 */
	public int getEnterpriseid()
	{
		return this.enterpriseid; 
	}
	/**
	 * 设置 企业编号, 类型int 默认值:0
	 *
	 * @param sEnterpriseid
	 *            企业编号, 类型int 默认值:0
	 */
	public void setEnterpriseid(int sEnterpriseid)
	{
		this.enterpriseid = sEnterpriseid; 
	}
	// 设置和获取 企业编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 企业名称, 默认值:""
	// 设置和获取 企业名称,类型String 默认值:"" 开始
	private String enterprisename = "";
	/**
	* 获取 企业名称, 类型String 默认值:""
	 *
	 * @return 企业名称, 类型String 默认值:""
	 */
	public String getEnterprisename()
	{
		return this.enterprisename; 
	}
	/**
	 * 设置 企业名称, 类型String 默认值:""
	 *
	 * @param sEnterprisename
	 *            企业名称, 类型String 默认值:""
	 */
	public void setEnterprisename(String sEnterprisename)
	{
		this.enterprisename = sEnterprisename; 
	}
	// 设置和获取 企业名称, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 行业类型, 默认值:0
	// 设置和获取 行业类型,类型int 默认值:0 开始
	private int businesstypeid = 0;
	/**
	* 获取 行业类型, 类型int 默认值:0
	 *
	 * @return 行业类型, 类型int 默认值:0
	 */
	public int getBusinesstypeid()
	{
		return this.businesstypeid; 
	}
	/**
	 * 设置 行业类型, 类型int 默认值:0
	 *
	 * @param sBusinesstypeid
	 *            行业类型, 类型int 默认值:0
	 */
	public void setBusinesstypeid(int sBusinesstypeid)
	{
		this.businesstypeid = sBusinesstypeid; 
	}
	// 设置和获取 行业类型, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 法人, 默认值:""
	// 设置和获取 法人,类型String 默认值:"" 开始
	private String legalperson = "";
	/**
	* 获取 法人, 类型String 默认值:""
	 *
	 * @return 法人, 类型String 默认值:""
	 */
	public String getLegalperson()
	{
		return this.legalperson; 
	}
	/**
	 * 设置 法人, 类型String 默认值:""
	 *
	 * @param sLegalperson
	 *            法人, 类型String 默认值:""
	 */
	public void setLegalperson(String sLegalperson)
	{
		this.legalperson = sLegalperson; 
	}
	// 设置和获取 法人, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 创立时间, 默认值:new Date()
	// 设置和获取 创立时间,类型Date 默认值:new Date() 开始
	private Date createtime = new Date();
	/**
	* 获取 创立时间, 类型Date 默认值:new Date()
	 *
	 * @return 创立时间, 类型Date 默认值:new Date()
	 */
	public Date getCreatetime()
	{
		if (!(this.createtime instanceof MyDate))
			this.createtime = MyDate.setDate(this.createtime);
		return this.createtime; 
	}
	/**
	 * 设置 创立时间, 类型Date 默认值:new Date()
	 *
	 * @param sCreatetime
	 *            创立时间, 类型Date 默认值:new Date()
	 */
	public void setCreatetime(Date sCreatetime)
	{
		this.createtime = sCreatetime; 
	}
	// 设置和获取 创立时间, 类型Date 默认值:new Date() 结束
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


        // [start] 设置和获取 企业地址, 默认值:""
	// 设置和获取 企业地址,类型String 默认值:"" 开始
	private String address = "";
	/**
	* 获取 企业地址, 类型String 默认值:""
	 *
	 * @return 企业地址, 类型String 默认值:""
	 */
	public String getAddress()
	{
		return this.address; 
	}
	/**
	 * 设置 企业地址, 类型String 默认值:""
	 *
	 * @param sAddress
	 *            企业地址, 类型String 默认值:""
	 */
	public void setAddress(String sAddress)
	{
		this.address = sAddress; 
	}
	// 设置和获取 企业地址, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 工商登记号, 默认值:""
	// 设置和获取 工商登记号,类型String 默认值:"" 开始
	private String enterprisecode = "";
	/**
	* 获取 工商登记号, 类型String 默认值:""
	 *
	 * @return 工商登记号, 类型String 默认值:""
	 */
	public String getEnterprisecode()
	{
		return this.enterprisecode; 
	}
	/**
	 * 设置 工商登记号, 类型String 默认值:""
	 *
	 * @param sEnterprisecode
	 *            工商登记号, 类型String 默认值:""
	 */
	public void setEnterprisecode(String sEnterprisecode)
	{
		this.enterprisecode = sEnterprisecode; 
	}
	// 设置和获取 工商登记号, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 产品专利号, 默认值:""
	// 设置和获取 产品专利号,类型String 默认值:"" 开始
	private String partentcode = "";
	/**
	* 获取 产品专利号, 类型String 默认值:""
	 *
	 * @return 产品专利号, 类型String 默认值:""
	 */
	public String getPartentcode()
	{
		return this.partentcode; 
	}
	/**
	 * 设置 产品专利号, 类型String 默认值:""
	 *
	 * @param sPartentcode
	 *            产品专利号, 类型String 默认值:""
	 */
	public void setPartentcode(String sPartentcode)
	{
		this.partentcode = sPartentcode; 
	}
	// 设置和获取 产品专利号, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 经营范围, 默认值:""
	// 设置和获取 经营范围,类型String 默认值:"" 开始
	private String scope = "";
	/**
	* 获取 经营范围, 类型String 默认值:""
	 *
	 * @return 经营范围, 类型String 默认值:""
	 */
	public String getScope()
	{
		return this.scope; 
	}
	/**
	 * 设置 经营范围, 类型String 默认值:""
	 *
	 * @param sScope
	 *            经营范围, 类型String 默认值:""
	 */
	public void setScope(String sScope)
	{
		this.scope = sScope; 
	}
	// 设置和获取 经营范围, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 企业注册地址, 默认值:""
	// 设置和获取 企业注册地址,类型String 默认值:"" 开始
	private String registaddress = "";
	/**
	* 获取 企业注册地址, 类型String 默认值:""
	 *
	 * @return 企业注册地址, 类型String 默认值:""
	 */
	public String getRegistaddress()
	{
		return this.registaddress; 
	}
	/**
	 * 设置 企业注册地址, 类型String 默认值:""
	 *
	 * @param sRegistaddress
	 *            企业注册地址, 类型String 默认值:""
	 */
	public void setRegistaddress(String sRegistaddress)
	{
		this.registaddress = sRegistaddress; 
	}
	// 设置和获取 企业注册地址, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 注册资金, 默认值:0
	// 设置和获取 注册资金,类型double 默认值:0 开始
	private double registfund = 0;
	/**
	* 获取 注册资金, 类型double 默认值:0
	 *
	 * @return 注册资金, 类型double 默认值:0
	 */
	public double getRegistfund()
	{
		return this.registfund; 
	}
	/**
	 * 设置 注册资金, 类型double 默认值:0
	 *
	 * @param sRegistfund
	 *            注册资金, 类型double 默认值:0
	 */
	public void setRegistfund(double sRegistfund)
	{
		this.registfund = sRegistfund; 
	}
	// 设置和获取 注册资金, 类型double 默认值:0 结束
        // [end]


        // [start] 设置和获取 占地面积, 默认值:0
	// 设置和获取 占地面积,类型int 默认值:0 开始
	private int area = 0;
	/**
	* 获取 占地面积, 类型int 默认值:0
	 *
	 * @return 占地面积, 类型int 默认值:0
	 */
	public int getArea()
	{
		return this.area; 
	}
	/**
	 * 设置 占地面积, 类型int 默认值:0
	 *
	 * @param sArea
	 *            占地面积, 类型int 默认值:0
	 */
	public void setArea(int sArea)
	{
		this.area = sArea; 
	}
	// 设置和获取 占地面积, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 总投资, 默认值:0
	// 设置和获取 总投资,类型double 默认值:0 开始
	private double toalinvest = 0;
	/**
	* 获取 总投资, 类型double 默认值:0
	 *
	 * @return 总投资, 类型double 默认值:0
	 */
	public double getToalinvest()
	{
		return this.toalinvest; 
	}
	/**
	 * 设置 总投资, 类型double 默认值:0
	 *
	 * @param sToalinvest
	 *            总投资, 类型double 默认值:0
	 */
	public void setToalinvest(double sToalinvest)
	{
		this.toalinvest = sToalinvest; 
	}
	// 设置和获取 总投资, 类型double 默认值:0 结束
        // [end]


        // [start] 设置和获取 企业性质, 默认值:0
	// 设置和获取 企业性质,类型int 默认值:0 开始
	private int qualityid = 0;
	/**
	* 获取 企业性质, 类型int 默认值:0
	 *
	 * @return 企业性质, 类型int 默认值:0
	 */
	public int getQualityid()
	{
		return this.qualityid; 
	}
	/**
	 * 设置 企业性质, 类型int 默认值:0
	 *
	 * @param sQualityid
	 *            企业性质, 类型int 默认值:0
	 */
	public void setQualityid(int sQualityid)
	{
		this.qualityid = sQualityid; 
	}
	// 设置和获取 企业性质, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 就业人数, 默认值:0
	// 设置和获取 就业人数,类型int 默认值:0 开始
	private int employnumber = 0;
	/**
	* 获取 就业人数, 类型int 默认值:0
	 *
	 * @return 就业人数, 类型int 默认值:0
	 */
	public int getEmploynumber()
	{
		return this.employnumber; 
	}
	/**
	 * 设置 就业人数, 类型int 默认值:0
	 *
	 * @param sEmploynumber
	 *            就业人数, 类型int 默认值:0
	 */
	public void setEmploynumber(int sEmploynumber)
	{
		this.employnumber = sEmploynumber; 
	}
	// 设置和获取 就业人数, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 年产值, 默认值:0
	// 设置和获取 年产值,类型double 默认值:0 开始
	private double producevalue = 0;
	/**
	* 获取 年产值, 类型double 默认值:0
	 *
	 * @return 年产值, 类型double 默认值:0
	 */
	public double getProducevalue()
	{
		return this.producevalue; 
	}
	/**
	 * 设置 年产值, 类型double 默认值:0
	 *
	 * @param sProducevalue
	 *            年产值, 类型double 默认值:0
	 */
	public void setProducevalue(double sProducevalue)
	{
		this.producevalue = sProducevalue; 
	}
	// 设置和获取 年产值, 类型double 默认值:0 结束
        // [end]


        // [start] 设置和获取 利润, 默认值:0
	// 设置和获取 利润,类型double 默认值:0 开始
	private double profit = 0;
	/**
	* 获取 利润, 类型double 默认值:0
	 *
	 * @return 利润, 类型double 默认值:0
	 */
	public double getProfit()
	{
		return this.profit; 
	}
	/**
	 * 设置 利润, 类型double 默认值:0
	 *
	 * @param sProfit
	 *            利润, 类型double 默认值:0
	 */
	public void setProfit(double sProfit)
	{
		this.profit = sProfit; 
	}
	// 设置和获取 利润, 类型double 默认值:0 结束
        // [end]


        // [start] 设置和获取 产品特色, 默认值:""
	// 设置和获取 产品特色,类型String 默认值:"" 开始
	private String feature = "";
	/**
	* 获取 产品特色, 类型String 默认值:""
	 *
	 * @return 产品特色, 类型String 默认值:""
	 */
	public String getFeature()
	{
		return this.feature; 
	}
	/**
	 * 设置 产品特色, 类型String 默认值:""
	 *
	 * @param sFeature
	 *            产品特色, 类型String 默认值:""
	 */
	public void setFeature(String sFeature)
	{
		this.feature = sFeature; 
	}
	// 设置和获取 产品特色, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 获得荣誉, 默认值:""
	// 设置和获取 获得荣誉,类型String 默认值:"" 开始
	private String obtainhonor = "";
	/**
	* 获取 获得荣誉, 类型String 默认值:""
	 *
	 * @return 获得荣誉, 类型String 默认值:""
	 */
	public String getObtainhonor()
	{
		return this.obtainhonor; 
	}
	/**
	 * 设置 获得荣誉, 类型String 默认值:""
	 *
	 * @param sObtainhonor
	 *            获得荣誉, 类型String 默认值:""
	 */
	public void setObtainhonor(String sObtainhonor)
	{
		this.obtainhonor = sObtainhonor; 
	}
	// 设置和获取 获得荣誉, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 社会效益, 默认值:""
	// 设置和获取 社会效益,类型String 默认值:"" 开始
	private String socialbenefit = "";
	/**
	* 获取 社会效益, 类型String 默认值:""
	 *
	 * @return 社会效益, 类型String 默认值:""
	 */
	public String getSocialbenefit()
	{
		return this.socialbenefit; 
	}
	/**
	 * 设置 社会效益, 类型String 默认值:""
	 *
	 * @param sSocialbenefit
	 *            社会效益, 类型String 默认值:""
	 */
	public void setSocialbenefit(String sSocialbenefit)
	{
		this.socialbenefit = sSocialbenefit; 
	}
	// 设置和获取 社会效益, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 统计人员, 默认值:0
	// 设置和获取 统计人员,类型int 默认值:0 开始
	private int peopleid1 = 0;
	/**
	* 获取 统计人员, 类型int 默认值:0
	 *
	 * @return 统计人员, 类型int 默认值:0
	 */
	public int getPeopleid1()
	{
		return this.peopleid1; 
	}
	/**
	 * 设置 统计人员, 类型int 默认值:0
	 *
	 * @param sPeopleid1
	 *            统计人员, 类型int 默认值:0
	 */
	public void setPeopleid1(int sPeopleid1)
	{
		this.peopleid1 = sPeopleid1; 
	}
	// 设置和获取 统计人员, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 填表人员, 默认值:0
	// 设置和获取 填表人员,类型int 默认值:0 开始
	private int peopleid2 = 0;
	/**
	* 获取 填表人员, 类型int 默认值:0
	 *
	 * @return 填表人员, 类型int 默认值:0
	 */
	public int getPeopleid2()
	{
		return this.peopleid2; 
	}
	/**
	 * 设置 填表人员, 类型int 默认值:0
	 *
	 * @param sPeopleid2
	 *            填表人员, 类型int 默认值:0
	 */
	public void setPeopleid2(int sPeopleid2)
	{
		this.peopleid2 = sPeopleid2; 
	}
	// 设置和获取 填表人员, 类型int 默认值:0 结束
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


        // [start] 设置和获取 部门编号, 默认值:0
	// 设置和获取 部门编号,类型int 默认值:0 开始
	private int sectorid = 0;
	/**
	* 获取 部门编号, 类型int 默认值:0
	 *
	 * @return 部门编号, 类型int 默认值:0
	 */
	public int getSectorid()
	{
		return this.sectorid; 
	}
	/**
	 * 设置 部门编号, 类型int 默认值:0
	 *
	 * @param sSectorid
	 *            部门编号, 类型int 默认值:0
	 */
	public void setSectorid(int sSectorid)
	{
		this.sectorid = sSectorid; 
	}
	// 设置和获取 部门编号, 类型int 默认值:0 结束
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


        // [start] 设置和获取 联系电话, 默认值:""
	// 设置和获取 联系电话,类型String 默认值:"" 开始
	private String linkphone = "";
	/**
	* 获取 联系电话, 类型String 默认值:""
	 *
	 * @return 联系电话, 类型String 默认值:""
	 */
	public String getLinkphone()
	{
		return this.linkphone; 
	}
	/**
	 * 设置 联系电话, 类型String 默认值:""
	 *
	 * @param sLinkphone
	 *            联系电话, 类型String 默认值:""
	 */
	public void setLinkphone(String sLinkphone)
	{
		this.linkphone = sLinkphone; 
	}
	// 设置和获取 联系电话, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 联系人, 默认值:""
	// 设置和获取 联系人,类型String 默认值:"" 开始
	private String contact = "";
	/**
	* 获取 联系人, 类型String 默认值:""
	 *
	 * @return 联系人, 类型String 默认值:""
	 */
	public String getContact()
	{
		return this.contact; 
	}
	/**
	 * 设置 联系人, 类型String 默认值:""
	 *
	 * @param sContact
	 *            联系人, 类型String 默认值:""
	 */
	public void setContact(String sContact)
	{
		this.contact = sContact; 
	}
	// 设置和获取 联系人, 类型String 默认值:"" 结束
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
            sbStr.append(getDatabaseenterpriseid()).append(strSplit);
            sbStr.append(getEnterpriseid()).append(strSplit);
            sbStr.append(getEnterprisename()).append(strSplit);
            sbStr.append(getBusinesstypeid()).append(strSplit);
            sbStr.append(getLegalperson()).append(strSplit);
            sbStr.append(getCreatetime()).append(strSplit);
            sbStr.append(getRegionid()).append(strSplit);
            sbStr.append(getAddress()).append(strSplit);
            sbStr.append(getEnterprisecode()).append(strSplit);
            sbStr.append(getPartentcode()).append(strSplit);
            sbStr.append(getScope()).append(strSplit);
            sbStr.append(getRegistaddress()).append(strSplit);
            sbStr.append(getRegistfund()).append(strSplit);
            sbStr.append(getArea()).append(strSplit);
            sbStr.append(getToalinvest()).append(strSplit);
            sbStr.append(getQualityid()).append(strSplit);
            sbStr.append(getEmploynumber()).append(strSplit);
            sbStr.append(getProducevalue()).append(strSplit);
            sbStr.append(getProfit()).append(strSplit);
            sbStr.append(getFeature()).append(strSplit);
            sbStr.append(getObtainhonor()).append(strSplit);
            sbStr.append(getSocialbenefit()).append(strSplit);
            sbStr.append(getPeopleid1()).append(strSplit);
            sbStr.append(getPeopleid2()).append(strSplit);
            sbStr.append(getAdminid()).append(strSplit);
            sbStr.append(getSectorid()).append(strSplit);
            sbStr.append(getLogintime()).append(strSplit);
            sbStr.append(getLinkphone()).append(strSplit);
            sbStr.append(getContact()).append(strSplit);

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

            if (objs.length != 29)
            {
                return;
            }
            if (objs[0] != null || objs[0].length() >= 1)
            {
                setDatabaseenterpriseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setEnterpriseid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setEnterprisename(com.colorwinglib.Converts.objToStr(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setBusinesstypeid(com.colorwinglib.Converts.StrToInt(objs[3]));
            }
            if (objs[4] != null || objs[4].length() >= 1)
            {
                setLegalperson(com.colorwinglib.Converts.objToStr(objs[4]));
            }
            if (objs[5] != null || objs[5].length() >= 1)
            {
                setCreatetime(com.colorwinglib.Converts.StrToDate(objs[5]));
            }
            if (objs[6] != null || objs[6].length() >= 1)
            {
                setRegionid(com.colorwinglib.Converts.StrToInt(objs[6]));
            }
            if (objs[7] != null || objs[7].length() >= 1)
            {
                setAddress(com.colorwinglib.Converts.objToStr(objs[7]));
            }
            if (objs[8] != null || objs[8].length() >= 1)
            {
                setEnterprisecode(com.colorwinglib.Converts.objToStr(objs[8]));
            }
            if (objs[9] != null || objs[9].length() >= 1)
            {
                setPartentcode(com.colorwinglib.Converts.objToStr(objs[9]));
            }
            if (objs[10] != null || objs[10].length() >= 1)
            {
                setScope(com.colorwinglib.Converts.objToStr(objs[10]));
            }
            if (objs[11] != null || objs[11].length() >= 1)
            {
                setRegistaddress(com.colorwinglib.Converts.objToStr(objs[11]));
            }
            if (objs[12] != null || objs[12].length() >= 1)
            {
                setRegistfund(com.colorwinglib.Converts.StrToFloat(objs[12]));
            }
            if (objs[13] != null || objs[13].length() >= 1)
            {
                setArea(com.colorwinglib.Converts.StrToInt(objs[13]));
            }
            if (objs[14] != null || objs[14].length() >= 1)
            {
                setToalinvest(com.colorwinglib.Converts.StrToFloat(objs[14]));
            }
            if (objs[15] != null || objs[15].length() >= 1)
            {
                setQualityid(com.colorwinglib.Converts.StrToInt(objs[15]));
            }
            if (objs[16] != null || objs[16].length() >= 1)
            {
                setEmploynumber(com.colorwinglib.Converts.StrToInt(objs[16]));
            }
            if (objs[17] != null || objs[17].length() >= 1)
            {
                setProducevalue(com.colorwinglib.Converts.StrToFloat(objs[17]));
            }
            if (objs[18] != null || objs[18].length() >= 1)
            {
                setProfit(com.colorwinglib.Converts.StrToFloat(objs[18]));
            }
            if (objs[19] != null || objs[19].length() >= 1)
            {
                setFeature(com.colorwinglib.Converts.objToStr(objs[19]));
            }
            if (objs[20] != null || objs[20].length() >= 1)
            {
                setObtainhonor(com.colorwinglib.Converts.objToStr(objs[20]));
            }
            if (objs[21] != null || objs[21].length() >= 1)
            {
                setSocialbenefit(com.colorwinglib.Converts.objToStr(objs[21]));
            }
            if (objs[22] != null || objs[22].length() >= 1)
            {
                setPeopleid1(com.colorwinglib.Converts.StrToInt(objs[22]));
            }
            if (objs[23] != null || objs[23].length() >= 1)
            {
                setPeopleid2(com.colorwinglib.Converts.StrToInt(objs[23]));
            }
            if (objs[24] != null || objs[24].length() >= 1)
            {
                setAdminid(com.colorwinglib.Converts.StrToInt(objs[24]));
            }
            if (objs[25] != null || objs[25].length() >= 1)
            {
                setSectorid(com.colorwinglib.Converts.StrToInt(objs[25]));
            }
            if (objs[26] != null || objs[26].length() >= 1)
            {
                setLogintime(com.colorwinglib.Converts.StrToDate(objs[26]));
            }
            if (objs[27] != null || objs[27].length() >= 1)
            {
                setLinkphone(com.colorwinglib.Converts.objToStr(objs[27]));
            }
            if (objs[28] != null || objs[28].length() >= 1)
            {
                setContact(com.colorwinglib.Converts.objToStr(objs[28]));
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
            sbStr.append("&Databaseenterpriseid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseenterpriseid()));//企业ID
            sbStr.append("&Enterpriseid=").append(com.colorwinglib.StringFormat.UrlEncode(getEnterpriseid()));//企业编号
            sbStr.append("&Enterprisename=").append(com.colorwinglib.StringFormat.UrlEncode(getEnterprisename()));//企业名称
            sbStr.append("&Businesstypeid=").append(com.colorwinglib.StringFormat.UrlEncode(getBusinesstypeid()));//行业类型
            sbStr.append("&Legalperson=").append(com.colorwinglib.StringFormat.UrlEncode(getLegalperson()));//法人
            sbStr.append("&Createtime=").append(com.colorwinglib.StringFormat.UrlEncode(getCreatetime()));//创立时间
            sbStr.append("&Regionid=").append(com.colorwinglib.StringFormat.UrlEncode(getRegionid()));//所属区域
            sbStr.append("&Address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//企业地址
            sbStr.append("&Enterprisecode=").append(com.colorwinglib.StringFormat.UrlEncode(getEnterprisecode()));//工商登记号
            sbStr.append("&Partentcode=").append(com.colorwinglib.StringFormat.UrlEncode(getPartentcode()));//产品专利号
            sbStr.append("&Scope=").append(com.colorwinglib.StringFormat.UrlEncode(getScope()));//经营范围
            sbStr.append("&Registaddress=").append(com.colorwinglib.StringFormat.UrlEncode(getRegistaddress()));//企业注册地址
            sbStr.append("&Registfund=").append(com.colorwinglib.StringFormat.UrlEncode(getRegistfund()));//注册资金
            sbStr.append("&Area=").append(com.colorwinglib.StringFormat.UrlEncode(getArea()));//占地面积
            sbStr.append("&Toalinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getToalinvest()));//总投资
            sbStr.append("&Qualityid=").append(com.colorwinglib.StringFormat.UrlEncode(getQualityid()));//企业性质
            sbStr.append("&Employnumber=").append(com.colorwinglib.StringFormat.UrlEncode(getEmploynumber()));//就业人数
            sbStr.append("&Producevalue=").append(com.colorwinglib.StringFormat.UrlEncode(getProducevalue()));//年产值
            sbStr.append("&Profit=").append(com.colorwinglib.StringFormat.UrlEncode(getProfit()));//利润
            sbStr.append("&Feature=").append(com.colorwinglib.StringFormat.UrlEncode(getFeature()));//产品特色
            sbStr.append("&Obtainhonor=").append(com.colorwinglib.StringFormat.UrlEncode(getObtainhonor()));//获得荣誉
            sbStr.append("&Socialbenefit=").append(com.colorwinglib.StringFormat.UrlEncode(getSocialbenefit()));//社会效益
            sbStr.append("&Peopleid1=").append(com.colorwinglib.StringFormat.UrlEncode(getPeopleid1()));//统计人员
            sbStr.append("&Peopleid2=").append(com.colorwinglib.StringFormat.UrlEncode(getPeopleid2()));//填表人员
            sbStr.append("&Adminid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminid()));//登录人员
            sbStr.append("&Sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//部门编号
            sbStr.append("&Logintime=").append(com.colorwinglib.StringFormat.UrlEncode(getLogintime()));//登录时间
            sbStr.append("&Linkphone=").append(com.colorwinglib.StringFormat.UrlEncode(getLinkphone()));//联系电话
            sbStr.append("&Contact=").append(com.colorwinglib.StringFormat.UrlEncode(getContact()));//联系人

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
			if (columnName.equals("Databaseenterpriseid"))
				sbStr.append("&Databaseenterpriseid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseenterpriseid()));//企业ID
			if (columnName.equals("Enterpriseid"))
				sbStr.append("&Enterpriseid=").append(com.colorwinglib.StringFormat.UrlEncode(getEnterpriseid()));//企业编号
			if (columnName.equals("Enterprisename"))
				sbStr.append("&Enterprisename=").append(com.colorwinglib.StringFormat.UrlEncode(getEnterprisename()));//企业名称
			if (columnName.equals("Businesstypeid"))
				sbStr.append("&Businesstypeid=").append(com.colorwinglib.StringFormat.UrlEncode(getBusinesstypeid()));//行业类型
			if (columnName.equals("Legalperson"))
				sbStr.append("&Legalperson=").append(com.colorwinglib.StringFormat.UrlEncode(getLegalperson()));//法人
			if (columnName.equals("Createtime"))
				sbStr.append("&Createtime=").append(com.colorwinglib.StringFormat.UrlEncode(getCreatetime()));//创立时间
			if (columnName.equals("Regionid"))
				sbStr.append("&Regionid=").append(com.colorwinglib.StringFormat.UrlEncode(getRegionid()));//所属区域
			if (columnName.equals("Address"))
				sbStr.append("&Address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//企业地址
			if (columnName.equals("Enterprisecode"))
				sbStr.append("&Enterprisecode=").append(com.colorwinglib.StringFormat.UrlEncode(getEnterprisecode()));//工商登记号
			if (columnName.equals("Partentcode"))
				sbStr.append("&Partentcode=").append(com.colorwinglib.StringFormat.UrlEncode(getPartentcode()));//产品专利号
			if (columnName.equals("Scope"))
				sbStr.append("&Scope=").append(com.colorwinglib.StringFormat.UrlEncode(getScope()));//经营范围
			if (columnName.equals("Registaddress"))
				sbStr.append("&Registaddress=").append(com.colorwinglib.StringFormat.UrlEncode(getRegistaddress()));//企业注册地址
			if (columnName.equals("Registfund"))
				sbStr.append("&Registfund=").append(com.colorwinglib.StringFormat.UrlEncode(getRegistfund()));//注册资金
			if (columnName.equals("Area"))
				sbStr.append("&Area=").append(com.colorwinglib.StringFormat.UrlEncode(getArea()));//占地面积
			if (columnName.equals("Toalinvest"))
				sbStr.append("&Toalinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getToalinvest()));//总投资
			if (columnName.equals("Qualityid"))
				sbStr.append("&Qualityid=").append(com.colorwinglib.StringFormat.UrlEncode(getQualityid()));//企业性质
			if (columnName.equals("Employnumber"))
				sbStr.append("&Employnumber=").append(com.colorwinglib.StringFormat.UrlEncode(getEmploynumber()));//就业人数
			if (columnName.equals("Producevalue"))
				sbStr.append("&Producevalue=").append(com.colorwinglib.StringFormat.UrlEncode(getProducevalue()));//年产值
			if (columnName.equals("Profit"))
				sbStr.append("&Profit=").append(com.colorwinglib.StringFormat.UrlEncode(getProfit()));//利润
			if (columnName.equals("Feature"))
				sbStr.append("&Feature=").append(com.colorwinglib.StringFormat.UrlEncode(getFeature()));//产品特色
			if (columnName.equals("Obtainhonor"))
				sbStr.append("&Obtainhonor=").append(com.colorwinglib.StringFormat.UrlEncode(getObtainhonor()));//获得荣誉
			if (columnName.equals("Socialbenefit"))
				sbStr.append("&Socialbenefit=").append(com.colorwinglib.StringFormat.UrlEncode(getSocialbenefit()));//社会效益
			if (columnName.equals("Peopleid1"))
				sbStr.append("&Peopleid1=").append(com.colorwinglib.StringFormat.UrlEncode(getPeopleid1()));//统计人员
			if (columnName.equals("Peopleid2"))
				sbStr.append("&Peopleid2=").append(com.colorwinglib.StringFormat.UrlEncode(getPeopleid2()));//填表人员
			if (columnName.equals("Adminid"))
				sbStr.append("&Adminid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminid()));//登录人员
			if (columnName.equals("Sectorid"))
				sbStr.append("&Sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//部门编号
			if (columnName.equals("Logintime"))
				sbStr.append("&Logintime=").append(com.colorwinglib.StringFormat.UrlEncode(getLogintime()));//登录时间
			if (columnName.equals("Linkphone"))
				sbStr.append("&Linkphone=").append(com.colorwinglib.StringFormat.UrlEncode(getLinkphone()));//联系电话
			if (columnName.equals("Contact"))
				sbStr.append("&Contact=").append(com.colorwinglib.StringFormat.UrlEncode(getContact()));//联系人
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
            sbStr.append("&databaseenterpriseid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseenterpriseid()));//企业ID
            sbStr.append("&enterpriseid=").append(com.colorwinglib.StringFormat.UrlEncode(getEnterpriseid()));//企业编号
            sbStr.append("&enterprisename=").append(com.colorwinglib.StringFormat.UrlEncode(getEnterprisename()));//企业名称
            sbStr.append("&businesstypeid=").append(com.colorwinglib.StringFormat.UrlEncode(getBusinesstypeid()));//行业类型
            sbStr.append("&legalperson=").append(com.colorwinglib.StringFormat.UrlEncode(getLegalperson()));//法人
            sbStr.append("&createtime=").append(com.colorwinglib.StringFormat.UrlEncode(getCreatetime()));//创立时间
            sbStr.append("&regionid=").append(com.colorwinglib.StringFormat.UrlEncode(getRegionid()));//所属区域
            sbStr.append("&address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//企业地址
            sbStr.append("&enterprisecode=").append(com.colorwinglib.StringFormat.UrlEncode(getEnterprisecode()));//工商登记号
            sbStr.append("&partentcode=").append(com.colorwinglib.StringFormat.UrlEncode(getPartentcode()));//产品专利号
            sbStr.append("&scope=").append(com.colorwinglib.StringFormat.UrlEncode(getScope()));//经营范围
            sbStr.append("&registaddress=").append(com.colorwinglib.StringFormat.UrlEncode(getRegistaddress()));//企业注册地址
            sbStr.append("&registfund=").append(com.colorwinglib.StringFormat.UrlEncode(getRegistfund()));//注册资金
            sbStr.append("&area=").append(com.colorwinglib.StringFormat.UrlEncode(getArea()));//占地面积
            sbStr.append("&toalinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getToalinvest()));//总投资
            sbStr.append("&qualityid=").append(com.colorwinglib.StringFormat.UrlEncode(getQualityid()));//企业性质
            sbStr.append("&employnumber=").append(com.colorwinglib.StringFormat.UrlEncode(getEmploynumber()));//就业人数
            sbStr.append("&producevalue=").append(com.colorwinglib.StringFormat.UrlEncode(getProducevalue()));//年产值
            sbStr.append("&profit=").append(com.colorwinglib.StringFormat.UrlEncode(getProfit()));//利润
            sbStr.append("&feature=").append(com.colorwinglib.StringFormat.UrlEncode(getFeature()));//产品特色
            sbStr.append("&obtainhonor=").append(com.colorwinglib.StringFormat.UrlEncode(getObtainhonor()));//获得荣誉
            sbStr.append("&socialbenefit=").append(com.colorwinglib.StringFormat.UrlEncode(getSocialbenefit()));//社会效益
            sbStr.append("&peopleid1=").append(com.colorwinglib.StringFormat.UrlEncode(getPeopleid1()));//统计人员
            sbStr.append("&peopleid2=").append(com.colorwinglib.StringFormat.UrlEncode(getPeopleid2()));//填表人员
            sbStr.append("&adminid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminid()));//登录人员
            sbStr.append("&sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//部门编号
            sbStr.append("&logintime=").append(com.colorwinglib.StringFormat.UrlEncode(getLogintime()));//登录时间
            sbStr.append("&linkphone=").append(com.colorwinglib.StringFormat.UrlEncode(getLinkphone()));//联系电话
            sbStr.append("&contact=").append(com.colorwinglib.StringFormat.UrlEncode(getContact()));//联系人

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
			if (columnName.equals("Databaseenterpriseid"))
				sbStr.append("&databaseenterpriseid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseenterpriseid()));//企业ID
			if (columnName.equals("Enterpriseid"))
				sbStr.append("&enterpriseid=").append(com.colorwinglib.StringFormat.UrlEncode(getEnterpriseid()));//企业编号
			if (columnName.equals("Enterprisename"))
				sbStr.append("&enterprisename=").append(com.colorwinglib.StringFormat.UrlEncode(getEnterprisename()));//企业名称
			if (columnName.equals("Businesstypeid"))
				sbStr.append("&businesstypeid=").append(com.colorwinglib.StringFormat.UrlEncode(getBusinesstypeid()));//行业类型
			if (columnName.equals("Legalperson"))
				sbStr.append("&legalperson=").append(com.colorwinglib.StringFormat.UrlEncode(getLegalperson()));//法人
			if (columnName.equals("Createtime"))
				sbStr.append("&createtime=").append(com.colorwinglib.StringFormat.UrlEncode(getCreatetime()));//创立时间
			if (columnName.equals("Regionid"))
				sbStr.append("&regionid=").append(com.colorwinglib.StringFormat.UrlEncode(getRegionid()));//所属区域
			if (columnName.equals("Address"))
				sbStr.append("&address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//企业地址
			if (columnName.equals("Enterprisecode"))
				sbStr.append("&enterprisecode=").append(com.colorwinglib.StringFormat.UrlEncode(getEnterprisecode()));//工商登记号
			if (columnName.equals("Partentcode"))
				sbStr.append("&partentcode=").append(com.colorwinglib.StringFormat.UrlEncode(getPartentcode()));//产品专利号
			if (columnName.equals("Scope"))
				sbStr.append("&scope=").append(com.colorwinglib.StringFormat.UrlEncode(getScope()));//经营范围
			if (columnName.equals("Registaddress"))
				sbStr.append("&registaddress=").append(com.colorwinglib.StringFormat.UrlEncode(getRegistaddress()));//企业注册地址
			if (columnName.equals("Registfund"))
				sbStr.append("&registfund=").append(com.colorwinglib.StringFormat.UrlEncode(getRegistfund()));//注册资金
			if (columnName.equals("Area"))
				sbStr.append("&area=").append(com.colorwinglib.StringFormat.UrlEncode(getArea()));//占地面积
			if (columnName.equals("Toalinvest"))
				sbStr.append("&toalinvest=").append(com.colorwinglib.StringFormat.UrlEncode(getToalinvest()));//总投资
			if (columnName.equals("Qualityid"))
				sbStr.append("&qualityid=").append(com.colorwinglib.StringFormat.UrlEncode(getQualityid()));//企业性质
			if (columnName.equals("Employnumber"))
				sbStr.append("&employnumber=").append(com.colorwinglib.StringFormat.UrlEncode(getEmploynumber()));//就业人数
			if (columnName.equals("Producevalue"))
				sbStr.append("&producevalue=").append(com.colorwinglib.StringFormat.UrlEncode(getProducevalue()));//年产值
			if (columnName.equals("Profit"))
				sbStr.append("&profit=").append(com.colorwinglib.StringFormat.UrlEncode(getProfit()));//利润
			if (columnName.equals("Feature"))
				sbStr.append("&feature=").append(com.colorwinglib.StringFormat.UrlEncode(getFeature()));//产品特色
			if (columnName.equals("Obtainhonor"))
				sbStr.append("&obtainhonor=").append(com.colorwinglib.StringFormat.UrlEncode(getObtainhonor()));//获得荣誉
			if (columnName.equals("Socialbenefit"))
				sbStr.append("&socialbenefit=").append(com.colorwinglib.StringFormat.UrlEncode(getSocialbenefit()));//社会效益
			if (columnName.equals("Peopleid1"))
				sbStr.append("&peopleid1=").append(com.colorwinglib.StringFormat.UrlEncode(getPeopleid1()));//统计人员
			if (columnName.equals("Peopleid2"))
				sbStr.append("&peopleid2=").append(com.colorwinglib.StringFormat.UrlEncode(getPeopleid2()));//填表人员
			if (columnName.equals("Adminid"))
				sbStr.append("&adminid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminid()));//登录人员
			if (columnName.equals("Sectorid"))
				sbStr.append("&sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//部门编号
			if (columnName.equals("Logintime"))
				sbStr.append("&logintime=").append(com.colorwinglib.StringFormat.UrlEncode(getLogintime()));//登录时间
			if (columnName.equals("Linkphone"))
				sbStr.append("&linkphone=").append(com.colorwinglib.StringFormat.UrlEncode(getLinkphone()));//联系电话
			if (columnName.equals("Contact"))
				sbStr.append("&contact=").append(com.colorwinglib.StringFormat.UrlEncode(getContact()));//联系人
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
	public static EnterpriseInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			EnterpriseInfo obj = (EnterpriseInfo) in.readObject();
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
	public String ToModifyString(EnterpriseInfo objOld)
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
	public String ToModifyString(EnterpriseInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getDatabaseenterpriseid(), objOld.getDatabaseenterpriseid()))
			sbStr.append("Databaseenterpriseid 企业ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabaseenterpriseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabaseenterpriseid())).append("]").append(strSplit);// 企业ID
		if (com.colorwinglib.Validate.isEquals(getEnterpriseid(), objOld.getEnterpriseid()))
			sbStr.append("Enterpriseid 企业编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getEnterpriseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getEnterpriseid())).append("]").append(strSplit);// 企业编号
		if (com.colorwinglib.Validate.isEquals(getEnterprisename(), objOld.getEnterprisename()))
			sbStr.append("Enterprisename 企业名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getEnterprisename())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getEnterprisename())).append("]").append(strSplit);// 企业名称
		if (com.colorwinglib.Validate.isEquals(getBusinesstypeid(), objOld.getBusinesstypeid()))
			sbStr.append("Businesstypeid 行业类型:[").append(com.colorwinglib.Converts.objToStr(objOld.getBusinesstypeid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getBusinesstypeid())).append("]").append(strSplit);// 行业类型
		if (com.colorwinglib.Validate.isEquals(getLegalperson(), objOld.getLegalperson()))
			sbStr.append("Legalperson 法人:[").append(com.colorwinglib.Converts.objToStr(objOld.getLegalperson())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getLegalperson())).append("]").append(strSplit);// 法人
		if (com.colorwinglib.Validate.isEquals(getCreatetime(), objOld.getCreatetime()))
			sbStr.append("Createtime 创立时间:[").append(com.colorwinglib.Converts.objToStr(objOld.getCreatetime())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getCreatetime())).append("]").append(strSplit);// 创立时间
		if (com.colorwinglib.Validate.isEquals(getRegionid(), objOld.getRegionid()))
			sbStr.append("Regionid 所属区域:[").append(com.colorwinglib.Converts.objToStr(objOld.getRegionid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getRegionid())).append("]").append(strSplit);// 所属区域
		if (com.colorwinglib.Validate.isEquals(getAddress(), objOld.getAddress()))
			sbStr.append("Address 企业地址:[").append(com.colorwinglib.Converts.objToStr(objOld.getAddress())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAddress())).append("]").append(strSplit);// 企业地址
		if (com.colorwinglib.Validate.isEquals(getEnterprisecode(), objOld.getEnterprisecode()))
			sbStr.append("Enterprisecode 工商登记号:[").append(com.colorwinglib.Converts.objToStr(objOld.getEnterprisecode())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getEnterprisecode())).append("]").append(strSplit);// 工商登记号
		if (com.colorwinglib.Validate.isEquals(getPartentcode(), objOld.getPartentcode()))
			sbStr.append("Partentcode 产品专利号:[").append(com.colorwinglib.Converts.objToStr(objOld.getPartentcode())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPartentcode())).append("]").append(strSplit);// 产品专利号
		if (com.colorwinglib.Validate.isEquals(getScope(), objOld.getScope()))
			sbStr.append("Scope 经营范围:[").append(com.colorwinglib.Converts.objToStr(objOld.getScope())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getScope())).append("]").append(strSplit);// 经营范围
		if (com.colorwinglib.Validate.isEquals(getRegistaddress(), objOld.getRegistaddress()))
			sbStr.append("Registaddress 企业注册地址:[").append(com.colorwinglib.Converts.objToStr(objOld.getRegistaddress())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getRegistaddress())).append("]").append(strSplit);// 企业注册地址
		if (com.colorwinglib.Validate.isEquals(getRegistfund(), objOld.getRegistfund()))
			sbStr.append("Registfund 注册资金:[").append(com.colorwinglib.Converts.objToStr(objOld.getRegistfund())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getRegistfund())).append("]").append(strSplit);// 注册资金
		if (com.colorwinglib.Validate.isEquals(getArea(), objOld.getArea()))
			sbStr.append("Area 占地面积:[").append(com.colorwinglib.Converts.objToStr(objOld.getArea())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getArea())).append("]").append(strSplit);// 占地面积
		if (com.colorwinglib.Validate.isEquals(getToalinvest(), objOld.getToalinvest()))
			sbStr.append("Toalinvest 总投资:[").append(com.colorwinglib.Converts.objToStr(objOld.getToalinvest())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getToalinvest())).append("]").append(strSplit);// 总投资
		if (com.colorwinglib.Validate.isEquals(getQualityid(), objOld.getQualityid()))
			sbStr.append("Qualityid 企业性质:[").append(com.colorwinglib.Converts.objToStr(objOld.getQualityid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getQualityid())).append("]").append(strSplit);// 企业性质
		if (com.colorwinglib.Validate.isEquals(getEmploynumber(), objOld.getEmploynumber()))
			sbStr.append("Employnumber 就业人数:[").append(com.colorwinglib.Converts.objToStr(objOld.getEmploynumber())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getEmploynumber())).append("]").append(strSplit);// 就业人数
		if (com.colorwinglib.Validate.isEquals(getProducevalue(), objOld.getProducevalue()))
			sbStr.append("Producevalue 年产值:[").append(com.colorwinglib.Converts.objToStr(objOld.getProducevalue())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getProducevalue())).append("]").append(strSplit);// 年产值
		if (com.colorwinglib.Validate.isEquals(getProfit(), objOld.getProfit()))
			sbStr.append("Profit 利润:[").append(com.colorwinglib.Converts.objToStr(objOld.getProfit())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getProfit())).append("]").append(strSplit);// 利润
		if (com.colorwinglib.Validate.isEquals(getFeature(), objOld.getFeature()))
			sbStr.append("Feature 产品特色:[").append(com.colorwinglib.Converts.objToStr(objOld.getFeature())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getFeature())).append("]").append(strSplit);// 产品特色
		if (com.colorwinglib.Validate.isEquals(getObtainhonor(), objOld.getObtainhonor()))
			sbStr.append("Obtainhonor 获得荣誉:[").append(com.colorwinglib.Converts.objToStr(objOld.getObtainhonor())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getObtainhonor())).append("]").append(strSplit);// 获得荣誉
		if (com.colorwinglib.Validate.isEquals(getSocialbenefit(), objOld.getSocialbenefit()))
			sbStr.append("Socialbenefit 社会效益:[").append(com.colorwinglib.Converts.objToStr(objOld.getSocialbenefit())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getSocialbenefit())).append("]").append(strSplit);// 社会效益
		if (com.colorwinglib.Validate.isEquals(getPeopleid1(), objOld.getPeopleid1()))
			sbStr.append("Peopleid1 统计人员:[").append(com.colorwinglib.Converts.objToStr(objOld.getPeopleid1())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPeopleid1())).append("]").append(strSplit);// 统计人员
		if (com.colorwinglib.Validate.isEquals(getPeopleid2(), objOld.getPeopleid2()))
			sbStr.append("Peopleid2 填表人员:[").append(com.colorwinglib.Converts.objToStr(objOld.getPeopleid2())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPeopleid2())).append("]").append(strSplit);// 填表人员
		if (com.colorwinglib.Validate.isEquals(getAdminid(), objOld.getAdminid()))
			sbStr.append("Adminid 登录人员:[").append(com.colorwinglib.Converts.objToStr(objOld.getAdminid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAdminid())).append("]").append(strSplit);// 登录人员
		if (com.colorwinglib.Validate.isEquals(getSectorid(), objOld.getSectorid()))
			sbStr.append("Sectorid 部门编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getSectorid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getSectorid())).append("]").append(strSplit);// 部门编号
		if (com.colorwinglib.Validate.isEquals(getLogintime(), objOld.getLogintime()))
			sbStr.append("Logintime 登录时间:[").append(com.colorwinglib.Converts.objToStr(objOld.getLogintime())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getLogintime())).append("]").append(strSplit);// 登录时间
		if (com.colorwinglib.Validate.isEquals(getLinkphone(), objOld.getLinkphone()))
			sbStr.append("Linkphone 联系电话:[").append(com.colorwinglib.Converts.objToStr(objOld.getLinkphone())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getLinkphone())).append("]").append(strSplit);// 联系电话
		if (com.colorwinglib.Validate.isEquals(getContact(), objOld.getContact()))
			sbStr.append("Contact 联系人:[").append(com.colorwinglib.Converts.objToStr(objOld.getContact())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getContact())).append("]").append(strSplit);// 联系人
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
			json.put("Databaseenterpriseid", getDatabaseenterpriseid());// 企业ID
			json.put("Enterpriseid", getEnterpriseid());// 企业编号
			json.put("Enterprisename", getEnterprisename());// 企业名称
			json.put("Businesstypeid", getBusinesstypeid());// 行业类型
			json.put("Legalperson", getLegalperson());// 法人
			json.put("Createtime", getCreatetime());// 创立时间
			json.put("Regionid", getRegionid());// 所属区域
			json.put("Address", getAddress());// 企业地址
			json.put("Enterprisecode", getEnterprisecode());// 工商登记号
			json.put("Partentcode", getPartentcode());// 产品专利号
			json.put("Scope", getScope());// 经营范围
			json.put("Registaddress", getRegistaddress());// 企业注册地址
			json.put("Registfund", getRegistfund());// 注册资金
			json.put("Area", getArea());// 占地面积
			json.put("Toalinvest", getToalinvest());// 总投资
			json.put("Qualityid", getQualityid());// 企业性质
			json.put("Employnumber", getEmploynumber());// 就业人数
			json.put("Producevalue", getProducevalue());// 年产值
			json.put("Profit", getProfit());// 利润
			json.put("Feature", getFeature());// 产品特色
			json.put("Obtainhonor", getObtainhonor());// 获得荣誉
			json.put("Socialbenefit", getSocialbenefit());// 社会效益
			json.put("Peopleid1", getPeopleid1());// 统计人员
			json.put("Peopleid2", getPeopleid2());// 填表人员
			json.put("Adminid", getAdminid());// 登录人员
			json.put("Sectorid", getSectorid());// 部门编号
			json.put("Logintime", getLogintime());// 登录时间
			json.put("Linkphone", getLinkphone());// 联系电话
			json.put("Contact", getContact());// 联系人
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
			setDatabaseenterpriseid(json.getInt("Databaseenterpriseid"));// 企业ID
			setEnterpriseid(json.getInt("Enterpriseid"));// 企业编号
			setEnterprisename(json.getString("Enterprisename"));// 企业名称
			setBusinesstypeid(json.getInt("Businesstypeid"));// 行业类型
			setLegalperson(json.getString("Legalperson"));// 法人
			setCreatetime(com.colorwinglib.Converts.StrToDate(json.getString("Createtime")));// 创立时间
			setRegionid(json.getInt("Regionid"));// 所属区域
			setAddress(json.getString("Address"));// 企业地址
			setEnterprisecode(json.getString("Enterprisecode"));// 工商登记号
			setPartentcode(json.getString("Partentcode"));// 产品专利号
			setScope(json.getString("Scope"));// 经营范围
			setRegistaddress(json.getString("Registaddress"));// 企业注册地址
			setRegistfund(json.getDouble("Registfund"));// 注册资金
			setArea(json.getInt("Area"));// 占地面积
			setToalinvest(json.getDouble("Toalinvest"));// 总投资
			setQualityid(json.getInt("Qualityid"));// 企业性质
			setEmploynumber(json.getInt("Employnumber"));// 就业人数
			setProducevalue(json.getDouble("Producevalue"));// 年产值
			setProfit(json.getDouble("Profit"));// 利润
			setFeature(json.getString("Feature"));// 产品特色
			setObtainhonor(json.getString("Obtainhonor"));// 获得荣誉
			setSocialbenefit(json.getString("Socialbenefit"));// 社会效益
			setPeopleid1(json.getInt("Peopleid1"));// 统计人员
			setPeopleid2(json.getInt("Peopleid2"));// 填表人员
			setAdminid(json.getInt("Adminid"));// 登录人员
			setSectorid(json.getInt("Sectorid"));// 部门编号
			setLogintime(com.colorwinglib.Converts.StrToDate(json.getString("Logintime")));// 登录时间
			setLinkphone(json.getString("Linkphone"));// 联系电话
			setContact(json.getString("Contact"));// 联系人

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
		sbStr.append("<EnterpriseInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //企业ID
			sbStr.append("    <Databaseenterpriseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabaseenterpriseid()));
			sbStr.append("</Databaseenterpriseid>\n");
            //企业编号
			sbStr.append("    <Enterpriseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getEnterpriseid()));
			sbStr.append("</Enterpriseid>\n");
            //企业名称
			sbStr.append("    <Enterprisename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getEnterprisename()));
			sbStr.append("</Enterprisename>\n");
            //行业类型
			sbStr.append("    <Businesstypeid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getBusinesstypeid()));
			sbStr.append("</Businesstypeid>\n");
            //法人
			sbStr.append("    <Legalperson>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getLegalperson()));
			sbStr.append("</Legalperson>\n");
            //创立时间
			sbStr.append("    <Createtime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getCreatetime()));
			sbStr.append("</Createtime>\n");
            //所属区域
			sbStr.append("    <Regionid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getRegionid()));
			sbStr.append("</Regionid>\n");
            //企业地址
			sbStr.append("    <Address>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAddress()));
			sbStr.append("</Address>\n");
            //工商登记号
			sbStr.append("    <Enterprisecode>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getEnterprisecode()));
			sbStr.append("</Enterprisecode>\n");
            //产品专利号
			sbStr.append("    <Partentcode>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPartentcode()));
			sbStr.append("</Partentcode>\n");
            //经营范围
			sbStr.append("    <Scope>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getScope()));
			sbStr.append("</Scope>\n");
            //企业注册地址
			sbStr.append("    <Registaddress>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getRegistaddress()));
			sbStr.append("</Registaddress>\n");
            //注册资金
			sbStr.append("    <Registfund>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getRegistfund()));
			sbStr.append("</Registfund>\n");
            //占地面积
			sbStr.append("    <Area>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getArea()));
			sbStr.append("</Area>\n");
            //总投资
			sbStr.append("    <Toalinvest>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getToalinvest()));
			sbStr.append("</Toalinvest>\n");
            //企业性质
			sbStr.append("    <Qualityid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getQualityid()));
			sbStr.append("</Qualityid>\n");
            //就业人数
			sbStr.append("    <Employnumber>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getEmploynumber()));
			sbStr.append("</Employnumber>\n");
            //年产值
			sbStr.append("    <Producevalue>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getProducevalue()));
			sbStr.append("</Producevalue>\n");
            //利润
			sbStr.append("    <Profit>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getProfit()));
			sbStr.append("</Profit>\n");
            //产品特色
			sbStr.append("    <Feature>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getFeature()));
			sbStr.append("</Feature>\n");
            //获得荣誉
			sbStr.append("    <Obtainhonor>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getObtainhonor()));
			sbStr.append("</Obtainhonor>\n");
            //社会效益
			sbStr.append("    <Socialbenefit>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getSocialbenefit()));
			sbStr.append("</Socialbenefit>\n");
            //统计人员
			sbStr.append("    <Peopleid1>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPeopleid1()));
			sbStr.append("</Peopleid1>\n");
            //填表人员
			sbStr.append("    <Peopleid2>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPeopleid2()));
			sbStr.append("</Peopleid2>\n");
            //登录人员
			sbStr.append("    <Adminid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAdminid()));
			sbStr.append("</Adminid>\n");
            //部门编号
			sbStr.append("    <Sectorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getSectorid()));
			sbStr.append("</Sectorid>\n");
            //登录时间
			sbStr.append("    <Logintime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getLogintime()));
			sbStr.append("</Logintime>\n");
            //联系电话
			sbStr.append("    <Linkphone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getLinkphone()));
			sbStr.append("</Linkphone>\n");
            //联系人
			sbStr.append("    <Contact>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getContact()));
			sbStr.append("</Contact>\n");
		sbStr.append("</EnterpriseInfo>\n");
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
	// GetEnterpriseInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetEnterpriseInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static EnterpriseInfo GetEnterpriseInfoFormFileName(String filename)
	{
		return GetEnterpriseInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetEnterpriseInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EnterpriseInfo GetEnterpriseInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetEnterpriseInfoFormXml(xml, encoding);
	}

	// [end]

	// GetEnterpriseInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetEnterpriseInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EnterpriseInfo GetEnterpriseInfoFormXml(String xml)
	{
		return GetEnterpriseInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetEnterpriseInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EnterpriseInfo GetEnterpriseInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		EnterpriseInfo objEnterpriseInfo = new EnterpriseInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//企业ID
				if (foo.elementText("Databaseenterpriseid") != null)
					objEnterpriseInfo.setDatabaseenterpriseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseenterpriseid")));
				//企业编号
				if (foo.elementText("Enterpriseid") != null)
					objEnterpriseInfo.setEnterpriseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Enterpriseid")));
				//企业名称
				if (foo.elementText("Enterprisename") != null)
					objEnterpriseInfo.setEnterprisename(com.colorwinglib.Converts.objToStr(foo.elementText("Enterprisename")));
				//行业类型
				if (foo.elementText("Businesstypeid") != null)
					objEnterpriseInfo.setBusinesstypeid(com.colorwinglib.Converts.StrToInt(foo.elementText("Businesstypeid")));
				//法人
				if (foo.elementText("Legalperson") != null)
					objEnterpriseInfo.setLegalperson(com.colorwinglib.Converts.objToStr(foo.elementText("Legalperson")));
				//创立时间
				if (foo.elementText("Createtime") != null)
					objEnterpriseInfo.setCreatetime(com.colorwinglib.Converts.StrToDate(foo.elementText("Createtime")));
				//所属区域
				if (foo.elementText("Regionid") != null)
					objEnterpriseInfo.setRegionid(com.colorwinglib.Converts.StrToInt(foo.elementText("Regionid")));
				//企业地址
				if (foo.elementText("Address") != null)
					objEnterpriseInfo.setAddress(com.colorwinglib.Converts.objToStr(foo.elementText("Address")));
				//工商登记号
				if (foo.elementText("Enterprisecode") != null)
					objEnterpriseInfo.setEnterprisecode(com.colorwinglib.Converts.objToStr(foo.elementText("Enterprisecode")));
				//产品专利号
				if (foo.elementText("Partentcode") != null)
					objEnterpriseInfo.setPartentcode(com.colorwinglib.Converts.objToStr(foo.elementText("Partentcode")));
				//经营范围
				if (foo.elementText("Scope") != null)
					objEnterpriseInfo.setScope(com.colorwinglib.Converts.objToStr(foo.elementText("Scope")));
				//企业注册地址
				if (foo.elementText("Registaddress") != null)
					objEnterpriseInfo.setRegistaddress(com.colorwinglib.Converts.objToStr(foo.elementText("Registaddress")));
				//注册资金
				if (foo.elementText("Registfund") != null)
					objEnterpriseInfo.setRegistfund(com.colorwinglib.Converts.StrToFloat(foo.elementText("Registfund")));
				//占地面积
				if (foo.elementText("Area") != null)
					objEnterpriseInfo.setArea(com.colorwinglib.Converts.StrToInt(foo.elementText("Area")));
				//总投资
				if (foo.elementText("Toalinvest") != null)
					objEnterpriseInfo.setToalinvest(com.colorwinglib.Converts.StrToFloat(foo.elementText("Toalinvest")));
				//企业性质
				if (foo.elementText("Qualityid") != null)
					objEnterpriseInfo.setQualityid(com.colorwinglib.Converts.StrToInt(foo.elementText("Qualityid")));
				//就业人数
				if (foo.elementText("Employnumber") != null)
					objEnterpriseInfo.setEmploynumber(com.colorwinglib.Converts.StrToInt(foo.elementText("Employnumber")));
				//年产值
				if (foo.elementText("Producevalue") != null)
					objEnterpriseInfo.setProducevalue(com.colorwinglib.Converts.StrToFloat(foo.elementText("Producevalue")));
				//利润
				if (foo.elementText("Profit") != null)
					objEnterpriseInfo.setProfit(com.colorwinglib.Converts.StrToFloat(foo.elementText("Profit")));
				//产品特色
				if (foo.elementText("Feature") != null)
					objEnterpriseInfo.setFeature(com.colorwinglib.Converts.objToStr(foo.elementText("Feature")));
				//获得荣誉
				if (foo.elementText("Obtainhonor") != null)
					objEnterpriseInfo.setObtainhonor(com.colorwinglib.Converts.objToStr(foo.elementText("Obtainhonor")));
				//社会效益
				if (foo.elementText("Socialbenefit") != null)
					objEnterpriseInfo.setSocialbenefit(com.colorwinglib.Converts.objToStr(foo.elementText("Socialbenefit")));
				//统计人员
				if (foo.elementText("Peopleid1") != null)
					objEnterpriseInfo.setPeopleid1(com.colorwinglib.Converts.StrToInt(foo.elementText("Peopleid1")));
				//填表人员
				if (foo.elementText("Peopleid2") != null)
					objEnterpriseInfo.setPeopleid2(com.colorwinglib.Converts.StrToInt(foo.elementText("Peopleid2")));
				//登录人员
				if (foo.elementText("Adminid") != null)
					objEnterpriseInfo.setAdminid(com.colorwinglib.Converts.StrToInt(foo.elementText("Adminid")));
				//部门编号
				if (foo.elementText("Sectorid") != null)
					objEnterpriseInfo.setSectorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Sectorid")));
				//登录时间
				if (foo.elementText("Logintime") != null)
					objEnterpriseInfo.setLogintime(com.colorwinglib.Converts.StrToDate(foo.elementText("Logintime")));
				//联系电话
				if (foo.elementText("Linkphone") != null)
					objEnterpriseInfo.setLinkphone(com.colorwinglib.Converts.objToStr(foo.elementText("Linkphone")));
				//联系人
				if (foo.elementText("Contact") != null)
					objEnterpriseInfo.setContact(com.colorwinglib.Converts.objToStr(foo.elementText("Contact")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objEnterpriseInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public EnterpriseInfo Copy()
	{
		EnterpriseInfo objEnterpriseInfo = new EnterpriseInfo();
		objEnterpriseInfo.setDatabaseenterpriseid(this.getDatabaseenterpriseid());//企业ID
		objEnterpriseInfo.setEnterpriseid(this.getEnterpriseid());//企业编号
		objEnterpriseInfo.setEnterprisename(this.getEnterprisename());//企业名称
		objEnterpriseInfo.setBusinesstypeid(this.getBusinesstypeid());//行业类型
		objEnterpriseInfo.setLegalperson(this.getLegalperson());//法人
		objEnterpriseInfo.setCreatetime(this.getCreatetime());//创立时间
		objEnterpriseInfo.setRegionid(this.getRegionid());//所属区域
		objEnterpriseInfo.setAddress(this.getAddress());//企业地址
		objEnterpriseInfo.setEnterprisecode(this.getEnterprisecode());//工商登记号
		objEnterpriseInfo.setPartentcode(this.getPartentcode());//产品专利号
		objEnterpriseInfo.setScope(this.getScope());//经营范围
		objEnterpriseInfo.setRegistaddress(this.getRegistaddress());//企业注册地址
		objEnterpriseInfo.setRegistfund(this.getRegistfund());//注册资金
		objEnterpriseInfo.setArea(this.getArea());//占地面积
		objEnterpriseInfo.setToalinvest(this.getToalinvest());//总投资
		objEnterpriseInfo.setQualityid(this.getQualityid());//企业性质
		objEnterpriseInfo.setEmploynumber(this.getEmploynumber());//就业人数
		objEnterpriseInfo.setProducevalue(this.getProducevalue());//年产值
		objEnterpriseInfo.setProfit(this.getProfit());//利润
		objEnterpriseInfo.setFeature(this.getFeature());//产品特色
		objEnterpriseInfo.setObtainhonor(this.getObtainhonor());//获得荣誉
		objEnterpriseInfo.setSocialbenefit(this.getSocialbenefit());//社会效益
		objEnterpriseInfo.setPeopleid1(this.getPeopleid1());//统计人员
		objEnterpriseInfo.setPeopleid2(this.getPeopleid2());//填表人员
		objEnterpriseInfo.setAdminid(this.getAdminid());//登录人员
		objEnterpriseInfo.setSectorid(this.getSectorid());//部门编号
		objEnterpriseInfo.setLogintime(this.getLogintime());//登录时间
		objEnterpriseInfo.setLinkphone(this.getLinkphone());//联系电话
		objEnterpriseInfo.setContact(this.getContact());//联系人
		return objEnterpriseInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
