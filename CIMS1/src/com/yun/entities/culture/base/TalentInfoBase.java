
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Talent 文化人才表的描述
 * 实体类基本类
 */
public class TalentInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012122617583806268L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public TalentInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public TalentInfoBase(int sDatabasetalentid)
	{
		this.setDatabasetalentid(sDatabasetalentid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public TalentInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setDatabasetalentid(rs.getInt("databasetalentid"));//databasetalentid
		setTalentid(rs.getInt("TalentID"));//人才编号
		setTalentname(rs.getString("TalentName"));//姓名
		setSex(rs.getInt("Sex"));//性别：1-男、2-女
		setBirthday(MyDate.setDate(rs.getTimestamp("Birthday")));//出生日期
		setNationid(rs.getInt("NationID"));//民族
		setNativeplace(rs.getString("NativePlace"));//籍贯
		setPoliticsstatus(rs.getString("PoliticsStatus"));//政治面貌
		setProvince(rs.getInt("Province"));//省份
		setCityid(rs.getInt("CityID"));//城市
		setEducationid(rs.getInt("EducationID"));//学历
		setDegreeid(rs.getInt("DegreeID"));//学位
		setMajorid(rs.getInt("MajorID"));//专业
		setLearnexperience(rs.getString("LearnExperience"));//个人学习经历
		setWorkexperience(rs.getString("WorkExperience"));//工作经历
		setTalentprofessionid(rs.getInt("TalentProfessionID"));//人才所属行业
		setAcheivement(rs.getString("Acheivement"));//业绩
		setHonor(rs.getString("Honor"));//荣誉
		setSkills(rs.getString("Skills"));//专长
		setPosttitleid(rs.getInt("PostTitleID"));//职称
		setWorkunit(rs.getString("WorkUnit"));//工作单位
		setAdress(rs.getString("Adress"));//现在住址
		setMovephone(rs.getString("MovePhone"));//手机
		setEmail(rs.getString("Email"));//邮箱
		setDatabasepeopleid1(rs.getInt("DatabasePeopleID1"));//统计人员
		setDatabasepeopleid2(rs.getInt("DatabasePeopleID2"));//填表人员
		setAdminid(rs.getInt("AdminID"));//登录人员
		setSectorid(rs.getInt("SectorID"));//SectorID
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
	public TalentInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//databasetalentid
			if (columnName.equals("databasetalentid"))
			{
				setDatabasetalentid(rs.getInt("databasetalentid"));
				continue;
			}
			//人才编号
			if (columnName.equals("TalentID"))
			{
				setTalentid(rs.getInt("TalentID"));
				continue;
			}
			//姓名
			if (columnName.equals("TalentName"))
			{
				setTalentname(rs.getString("TalentName"));
				continue;
			}
			//性别：1-男、2-女
			if (columnName.equals("Sex"))
			{
				setSex(rs.getInt("Sex"));
				continue;
			}
			//出生日期
			if (columnName.equals("Birthday"))
			{
				setBirthday(MyDate.setDate(rs.getTimestamp("Birthday")));
				continue;
			}
			//民族
			if (columnName.equals("NationID"))
			{
				setNationid(rs.getInt("NationID"));
				continue;
			}
			//籍贯
			if (columnName.equals("NativePlace"))
			{
				setNativeplace(rs.getString("NativePlace"));
				continue;
			}
			//政治面貌
			if (columnName.equals("PoliticsStatus"))
			{
				setPoliticsstatus(rs.getString("PoliticsStatus"));
				continue;
			}
			//省份
			if (columnName.equals("Province"))
			{
				setProvince(rs.getInt("Province"));
				continue;
			}
			//城市
			if (columnName.equals("CityID"))
			{
				setCityid(rs.getInt("CityID"));
				continue;
			}
			//学历
			if (columnName.equals("EducationID"))
			{
				setEducationid(rs.getInt("EducationID"));
				continue;
			}
			//学位
			if (columnName.equals("DegreeID"))
			{
				setDegreeid(rs.getInt("DegreeID"));
				continue;
			}
			//专业
			if (columnName.equals("MajorID"))
			{
				setMajorid(rs.getInt("MajorID"));
				continue;
			}
			//个人学习经历
			if (columnName.equals("LearnExperience"))
			{
				setLearnexperience(rs.getString("LearnExperience"));
				continue;
			}
			//工作经历
			if (columnName.equals("WorkExperience"))
			{
				setWorkexperience(rs.getString("WorkExperience"));
				continue;
			}
			//人才所属行业
			if (columnName.equals("TalentProfessionID"))
			{
				setTalentprofessionid(rs.getInt("TalentProfessionID"));
				continue;
			}
			//业绩
			if (columnName.equals("Acheivement"))
			{
				setAcheivement(rs.getString("Acheivement"));
				continue;
			}
			//荣誉
			if (columnName.equals("Honor"))
			{
				setHonor(rs.getString("Honor"));
				continue;
			}
			//专长
			if (columnName.equals("Skills"))
			{
				setSkills(rs.getString("Skills"));
				continue;
			}
			//职称
			if (columnName.equals("PostTitleID"))
			{
				setPosttitleid(rs.getInt("PostTitleID"));
				continue;
			}
			//工作单位
			if (columnName.equals("WorkUnit"))
			{
				setWorkunit(rs.getString("WorkUnit"));
				continue;
			}
			//现在住址
			if (columnName.equals("Adress"))
			{
				setAdress(rs.getString("Adress"));
				continue;
			}
			//手机
			if (columnName.equals("MovePhone"))
			{
				setMovephone(rs.getString("MovePhone"));
				continue;
			}
			//邮箱
			if (columnName.equals("Email"))
			{
				setEmail(rs.getString("Email"));
				continue;
			}
			//统计人员
			if (columnName.equals("DatabasePeopleID1"))
			{
				setDatabasepeopleid1(rs.getInt("DatabasePeopleID1"));
				continue;
			}
			//填表人员
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
			//SectorID
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
		if (!(rhs instanceof TalentInfo))
			return false;
		TalentInfo that = (TalentInfo) rhs;

		return (this.getDatabasetalentid() == (that.getDatabasetalentid()));
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

			result = result * 37 + (this.getDatabasetalentid() + "").hashCode();
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
	"databasetalentid", //databasetalentid
	"TalentID", //人才编号
	"TalentName", //姓名
	"Sex", //性别：1-男、2-女
	"Birthday", //出生日期
	"NationID", //民族
	"NativePlace", //籍贯
	"PoliticsStatus", //政治面貌
	"Province", //省份
	"CityID", //城市
	"EducationID", //学历
	"DegreeID", //学位
	"MajorID", //专业
	"LearnExperience", //个人学习经历
	"WorkExperience", //工作经历
	"TalentProfessionID", //人才所属行业
	"Acheivement", //业绩
	"Honor", //荣誉
	"Skills", //专长
	"PostTitleID", //职称
	"WorkUnit", //工作单位
	"Adress", //现在住址
	"MovePhone", //手机
	"Email", //邮箱
	"DatabasePeopleID1", //统计人员
	"DatabasePeopleID2", //填表人员
	"AdminID", //登录人员
	"SectorID", //SectorID
	"LoginTime" //登录时间
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum TalentColumnNameEnum
{
		/**
		 * databasetalentid
		 */
		Databasetalentid,
		/**
		 * 人才编号
		 */
		Talentid,
		/**
		 * 姓名
		 */
		Talentname,
		/**
		 * 性别：1-男、2-女
		 */
		Sex,
		/**
		 * 出生日期
		 */
		Birthday,
		/**
		 * 民族
		 */
		Nationid,
		/**
		 * 籍贯
		 */
		Nativeplace,
		/**
		 * 政治面貌
		 */
		Politicsstatus,
		/**
		 * 省份
		 */
		Province,
		/**
		 * 城市
		 */
		Cityid,
		/**
		 * 学历
		 */
		Educationid,
		/**
		 * 学位
		 */
		Degreeid,
		/**
		 * 专业
		 */
		Majorid,
		/**
		 * 个人学习经历
		 */
		Learnexperience,
		/**
		 * 工作经历
		 */
		Workexperience,
		/**
		 * 人才所属行业
		 */
		Talentprofessionid,
		/**
		 * 业绩
		 */
		Acheivement,
		/**
		 * 荣誉
		 */
		Honor,
		/**
		 * 专长
		 */
		Skills,
		/**
		 * 职称
		 */
		Posttitleid,
		/**
		 * 工作单位
		 */
		Workunit,
		/**
		 * 现在住址
		 */
		Adress,
		/**
		 * 手机
		 */
		Movephone,
		/**
		 * 邮箱
		 */
		Email,
		/**
		 * 统计人员
		 */
		Databasepeopleid1,
		/**
		 * 填表人员
		 */
		Databasepeopleid2,
		/**
		 * 登录人员
		 */
		Adminid,
		/**
		 * SectorID
		 */
		Sectorid,
		/**
		 * 登录时间
		 */
		Logintime
	};
	// [end]
        // [start] 设置和获取 databasetalentid, 默认值:0
	// 设置和获取 databasetalentid,类型int 默认值:0 开始
	private int databasetalentid = 0;
	/**
	* 获取 databasetalentid, 类型int 默认值:0
	 *
	 * @return databasetalentid, 类型int 默认值:0
	 */
	public int getDatabasetalentid()
	{
		return this.databasetalentid; 
	}
	/**
	 * 设置 databasetalentid, 类型int 默认值:0
	 *
	 * @param sDatabasetalentid
	 *            databasetalentid, 类型int 默认值:0
	 */
	public void setDatabasetalentid(int sDatabasetalentid)
	{
		this.databasetalentid = sDatabasetalentid; 
	}
	// 设置和获取 databasetalentid, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 人才编号, 默认值:0
	// 设置和获取 人才编号,类型int 默认值:0 开始
	private int talentid = 0;
	/**
	* 获取 人才编号, 类型int 默认值:0
	 *
	 * @return 人才编号, 类型int 默认值:0
	 */
	public int getTalentid()
	{
		return this.talentid; 
	}
	/**
	 * 设置 人才编号, 类型int 默认值:0
	 *
	 * @param sTalentid
	 *            人才编号, 类型int 默认值:0
	 */
	public void setTalentid(int sTalentid)
	{
		this.talentid = sTalentid; 
	}
	// 设置和获取 人才编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 姓名, 默认值:""
	// 设置和获取 姓名,类型String 默认值:"" 开始
	private String talentname = "";
	/**
	* 获取 姓名, 类型String 默认值:""
	 *
	 * @return 姓名, 类型String 默认值:""
	 */
	public String getTalentname()
	{
		return this.talentname; 
	}
	/**
	 * 设置 姓名, 类型String 默认值:""
	 *
	 * @param sTalentname
	 *            姓名, 类型String 默认值:""
	 */
	public void setTalentname(String sTalentname)
	{
		this.talentname = sTalentname; 
	}
	// 设置和获取 姓名, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 性别：1-男、2-女, 默认值:0
	// 设置和获取 性别：1-男、2-女,类型int 默认值:0 开始
	private int sex = 0;
	/**
	* 获取 性别：1-男、2-女, 类型int 默认值:0
	 *
	 * @return 性别：1-男、2-女, 类型int 默认值:0
	 */
	public int getSex()
	{
		return this.sex; 
	}
	/**
	 * 设置 性别：1-男、2-女, 类型int 默认值:0
	 *
	 * @param sSex
	 *            性别：1-男、2-女, 类型int 默认值:0
	 */
	public void setSex(int sSex)
	{
		this.sex = sSex; 
	}
	// 设置和获取 性别：1-男、2-女, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 出生日期, 默认值:new Date()
	// 设置和获取 出生日期,类型Date 默认值:new Date() 开始
	private Date birthday = new Date();
	/**
	* 获取 出生日期, 类型Date 默认值:new Date()
	 *
	 * @return 出生日期, 类型Date 默认值:new Date()
	 */
	public Date getBirthday()
	{
		if (!(this.birthday instanceof MyDate))
			this.birthday = MyDate.setDate(this.birthday);
		return this.birthday; 
	}
	/**
	 * 设置 出生日期, 类型Date 默认值:new Date()
	 *
	 * @param sBirthday
	 *            出生日期, 类型Date 默认值:new Date()
	 */
	public void setBirthday(Date sBirthday)
	{
		this.birthday = sBirthday; 
	}
	// 设置和获取 出生日期, 类型Date 默认值:new Date() 结束
        // [end]


        // [start] 设置和获取 民族, 默认值:0
	// 设置和获取 民族,类型int 默认值:0 开始
	private int nationid = 0;
	/**
	* 获取 民族, 类型int 默认值:0
	 *
	 * @return 民族, 类型int 默认值:0
	 */
	public int getNationid()
	{
		return this.nationid; 
	}
	/**
	 * 设置 民族, 类型int 默认值:0
	 *
	 * @param sNationid
	 *            民族, 类型int 默认值:0
	 */
	public void setNationid(int sNationid)
	{
		this.nationid = sNationid; 
	}
	// 设置和获取 民族, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 籍贯, 默认值:""
	// 设置和获取 籍贯,类型String 默认值:"" 开始
	private String nativeplace = "";
	/**
	* 获取 籍贯, 类型String 默认值:""
	 *
	 * @return 籍贯, 类型String 默认值:""
	 */
	public String getNativeplace()
	{
		return this.nativeplace; 
	}
	/**
	 * 设置 籍贯, 类型String 默认值:""
	 *
	 * @param sNativeplace
	 *            籍贯, 类型String 默认值:""
	 */
	public void setNativeplace(String sNativeplace)
	{
		this.nativeplace = sNativeplace; 
	}
	// 设置和获取 籍贯, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 政治面貌, 默认值:""
	// 设置和获取 政治面貌,类型String 默认值:"" 开始
	private String politicsstatus = "";
	/**
	* 获取 政治面貌, 类型String 默认值:""
	 *
	 * @return 政治面貌, 类型String 默认值:""
	 */
	public String getPoliticsstatus()
	{
		return this.politicsstatus; 
	}
	/**
	 * 设置 政治面貌, 类型String 默认值:""
	 *
	 * @param sPoliticsstatus
	 *            政治面貌, 类型String 默认值:""
	 */
	public void setPoliticsstatus(String sPoliticsstatus)
	{
		this.politicsstatus = sPoliticsstatus; 
	}
	// 设置和获取 政治面貌, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 省份, 默认值:0
	// 设置和获取 省份,类型int 默认值:0 开始
	private int province = 0;
	/**
	* 获取 省份, 类型int 默认值:0
	 *
	 * @return 省份, 类型int 默认值:0
	 */
	public int getProvince()
	{
		return this.province; 
	}
	/**
	 * 设置 省份, 类型int 默认值:0
	 *
	 * @param sProvince
	 *            省份, 类型int 默认值:0
	 */
	public void setProvince(int sProvince)
	{
		this.province = sProvince; 
	}
	// 设置和获取 省份, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 城市, 默认值:0
	// 设置和获取 城市,类型int 默认值:0 开始
	private int cityid = 0;
	/**
	* 获取 城市, 类型int 默认值:0
	 *
	 * @return 城市, 类型int 默认值:0
	 */
	public int getCityid()
	{
		return this.cityid; 
	}
	/**
	 * 设置 城市, 类型int 默认值:0
	 *
	 * @param sCityid
	 *            城市, 类型int 默认值:0
	 */
	public void setCityid(int sCityid)
	{
		this.cityid = sCityid; 
	}
	// 设置和获取 城市, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 学历, 默认值:0
	// 设置和获取 学历,类型int 默认值:0 开始
	private int educationid = 0;
	/**
	* 获取 学历, 类型int 默认值:0
	 *
	 * @return 学历, 类型int 默认值:0
	 */
	public int getEducationid()
	{
		return this.educationid; 
	}
	/**
	 * 设置 学历, 类型int 默认值:0
	 *
	 * @param sEducationid
	 *            学历, 类型int 默认值:0
	 */
	public void setEducationid(int sEducationid)
	{
		this.educationid = sEducationid; 
	}
	// 设置和获取 学历, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 学位, 默认值:0
	// 设置和获取 学位,类型int 默认值:0 开始
	private int degreeid = 0;
	/**
	* 获取 学位, 类型int 默认值:0
	 *
	 * @return 学位, 类型int 默认值:0
	 */
	public int getDegreeid()
	{
		return this.degreeid; 
	}
	/**
	 * 设置 学位, 类型int 默认值:0
	 *
	 * @param sDegreeid
	 *            学位, 类型int 默认值:0
	 */
	public void setDegreeid(int sDegreeid)
	{
		this.degreeid = sDegreeid; 
	}
	// 设置和获取 学位, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 专业, 默认值:0
	// 设置和获取 专业,类型int 默认值:0 开始
	private int majorid = 0;
	/**
	* 获取 专业, 类型int 默认值:0
	 *
	 * @return 专业, 类型int 默认值:0
	 */
	public int getMajorid()
	{
		return this.majorid; 
	}
	/**
	 * 设置 专业, 类型int 默认值:0
	 *
	 * @param sMajorid
	 *            专业, 类型int 默认值:0
	 */
	public void setMajorid(int sMajorid)
	{
		this.majorid = sMajorid; 
	}
	// 设置和获取 专业, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 个人学习经历, 默认值:""
	// 设置和获取 个人学习经历,类型String 默认值:"" 开始
	private String learnexperience = "";
	/**
	* 获取 个人学习经历, 类型String 默认值:""
	 *
	 * @return 个人学习经历, 类型String 默认值:""
	 */
	public String getLearnexperience()
	{
		return this.learnexperience; 
	}
	/**
	 * 设置 个人学习经历, 类型String 默认值:""
	 *
	 * @param sLearnexperience
	 *            个人学习经历, 类型String 默认值:""
	 */
	public void setLearnexperience(String sLearnexperience)
	{
		this.learnexperience = sLearnexperience; 
	}
	// 设置和获取 个人学习经历, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 工作经历, 默认值:""
	// 设置和获取 工作经历,类型String 默认值:"" 开始
	private String workexperience = "";
	/**
	* 获取 工作经历, 类型String 默认值:""
	 *
	 * @return 工作经历, 类型String 默认值:""
	 */
	public String getWorkexperience()
	{
		return this.workexperience; 
	}
	/**
	 * 设置 工作经历, 类型String 默认值:""
	 *
	 * @param sWorkexperience
	 *            工作经历, 类型String 默认值:""
	 */
	public void setWorkexperience(String sWorkexperience)
	{
		this.workexperience = sWorkexperience; 
	}
	// 设置和获取 工作经历, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 人才所属行业, 默认值:0
	// 设置和获取 人才所属行业,类型int 默认值:0 开始
	private int talentprofessionid = 0;
	/**
	* 获取 人才所属行业, 类型int 默认值:0
	 *
	 * @return 人才所属行业, 类型int 默认值:0
	 */
	public int getTalentprofessionid()
	{
		return this.talentprofessionid; 
	}
	/**
	 * 设置 人才所属行业, 类型int 默认值:0
	 *
	 * @param sTalentprofessionid
	 *            人才所属行业, 类型int 默认值:0
	 */
	public void setTalentprofessionid(int sTalentprofessionid)
	{
		this.talentprofessionid = sTalentprofessionid; 
	}
	// 设置和获取 人才所属行业, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 业绩, 默认值:""
	// 设置和获取 业绩,类型String 默认值:"" 开始
	private String acheivement = "";
	/**
	* 获取 业绩, 类型String 默认值:""
	 *
	 * @return 业绩, 类型String 默认值:""
	 */
	public String getAcheivement()
	{
		return this.acheivement; 
	}
	/**
	 * 设置 业绩, 类型String 默认值:""
	 *
	 * @param sAcheivement
	 *            业绩, 类型String 默认值:""
	 */
	public void setAcheivement(String sAcheivement)
	{
		this.acheivement = sAcheivement; 
	}
	// 设置和获取 业绩, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 荣誉, 默认值:""
	// 设置和获取 荣誉,类型String 默认值:"" 开始
	private String honor = "";
	/**
	* 获取 荣誉, 类型String 默认值:""
	 *
	 * @return 荣誉, 类型String 默认值:""
	 */
	public String getHonor()
	{
		return this.honor; 
	}
	/**
	 * 设置 荣誉, 类型String 默认值:""
	 *
	 * @param sHonor
	 *            荣誉, 类型String 默认值:""
	 */
	public void setHonor(String sHonor)
	{
		this.honor = sHonor; 
	}
	// 设置和获取 荣誉, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 专长, 默认值:""
	// 设置和获取 专长,类型String 默认值:"" 开始
	private String skills = "";
	/**
	* 获取 专长, 类型String 默认值:""
	 *
	 * @return 专长, 类型String 默认值:""
	 */
	public String getSkills()
	{
		return this.skills; 
	}
	/**
	 * 设置 专长, 类型String 默认值:""
	 *
	 * @param sSkills
	 *            专长, 类型String 默认值:""
	 */
	public void setSkills(String sSkills)
	{
		this.skills = sSkills; 
	}
	// 设置和获取 专长, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 职称, 默认值:0
	// 设置和获取 职称,类型int 默认值:0 开始
	private int posttitleid = 0;
	/**
	* 获取 职称, 类型int 默认值:0
	 *
	 * @return 职称, 类型int 默认值:0
	 */
	public int getPosttitleid()
	{
		return this.posttitleid; 
	}
	/**
	 * 设置 职称, 类型int 默认值:0
	 *
	 * @param sPosttitleid
	 *            职称, 类型int 默认值:0
	 */
	public void setPosttitleid(int sPosttitleid)
	{
		this.posttitleid = sPosttitleid; 
	}
	// 设置和获取 职称, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 工作单位, 默认值:""
	// 设置和获取 工作单位,类型String 默认值:"" 开始
	private String workunit = "";
	/**
	* 获取 工作单位, 类型String 默认值:""
	 *
	 * @return 工作单位, 类型String 默认值:""
	 */
	public String getWorkunit()
	{
		return this.workunit; 
	}
	/**
	 * 设置 工作单位, 类型String 默认值:""
	 *
	 * @param sWorkunit
	 *            工作单位, 类型String 默认值:""
	 */
	public void setWorkunit(String sWorkunit)
	{
		this.workunit = sWorkunit; 
	}
	// 设置和获取 工作单位, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 现在住址, 默认值:""
	// 设置和获取 现在住址,类型String 默认值:"" 开始
	private String adress = "";
	/**
	* 获取 现在住址, 类型String 默认值:""
	 *
	 * @return 现在住址, 类型String 默认值:""
	 */
	public String getAdress()
	{
		return this.adress; 
	}
	/**
	 * 设置 现在住址, 类型String 默认值:""
	 *
	 * @param sAdress
	 *            现在住址, 类型String 默认值:""
	 */
	public void setAdress(String sAdress)
	{
		this.adress = sAdress; 
	}
	// 设置和获取 现在住址, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 手机, 默认值:""
	// 设置和获取 手机,类型String 默认值:"" 开始
	private String movephone = "";
	/**
	* 获取 手机, 类型String 默认值:""
	 *
	 * @return 手机, 类型String 默认值:""
	 */
	public String getMovephone()
	{
		return this.movephone; 
	}
	/**
	 * 设置 手机, 类型String 默认值:""
	 *
	 * @param sMovephone
	 *            手机, 类型String 默认值:""
	 */
	public void setMovephone(String sMovephone)
	{
		this.movephone = sMovephone; 
	}
	// 设置和获取 手机, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 邮箱, 默认值:""
	// 设置和获取 邮箱,类型String 默认值:"" 开始
	private String email = "";
	/**
	* 获取 邮箱, 类型String 默认值:""
	 *
	 * @return 邮箱, 类型String 默认值:""
	 */
	public String getEmail()
	{
		return this.email; 
	}
	/**
	 * 设置 邮箱, 类型String 默认值:""
	 *
	 * @param sEmail
	 *            邮箱, 类型String 默认值:""
	 */
	public void setEmail(String sEmail)
	{
		this.email = sEmail; 
	}
	// 设置和获取 邮箱, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 统计人员, 默认值:0
	// 设置和获取 统计人员,类型int 默认值:0 开始
	private int databasepeopleid1 = 0;
	/**
	* 获取 统计人员, 类型int 默认值:0
	 *
	 * @return 统计人员, 类型int 默认值:0
	 */
	public int getDatabasepeopleid1()
	{
		return this.databasepeopleid1; 
	}
	/**
	 * 设置 统计人员, 类型int 默认值:0
	 *
	 * @param sDatabasepeopleid1
	 *            统计人员, 类型int 默认值:0
	 */
	public void setDatabasepeopleid1(int sDatabasepeopleid1)
	{
		this.databasepeopleid1 = sDatabasepeopleid1; 
	}
	// 设置和获取 统计人员, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 填表人员, 默认值:0
	// 设置和获取 填表人员,类型int 默认值:0 开始
	private int databasepeopleid2 = 0;
	/**
	* 获取 填表人员, 类型int 默认值:0
	 *
	 * @return 填表人员, 类型int 默认值:0
	 */
	public int getDatabasepeopleid2()
	{
		return this.databasepeopleid2; 
	}
	/**
	 * 设置 填表人员, 类型int 默认值:0
	 *
	 * @param sDatabasepeopleid2
	 *            填表人员, 类型int 默认值:0
	 */
	public void setDatabasepeopleid2(int sDatabasepeopleid2)
	{
		this.databasepeopleid2 = sDatabasepeopleid2; 
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


        // [start] 设置和获取 SectorID, 默认值:0
	// 设置和获取 SectorID,类型int 默认值:0 开始
	private int sectorid = 0;
	/**
	* 获取 SectorID, 类型int 默认值:0
	 *
	 * @return SectorID, 类型int 默认值:0
	 */
	public int getSectorid()
	{
		return this.sectorid; 
	}
	/**
	 * 设置 SectorID, 类型int 默认值:0
	 *
	 * @param sSectorid
	 *            SectorID, 类型int 默认值:0
	 */
	public void setSectorid(int sSectorid)
	{
		this.sectorid = sSectorid; 
	}
	// 设置和获取 SectorID, 类型int 默认值:0 结束
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
            sbStr.append(getDatabasetalentid()).append(strSplit);
            sbStr.append(getTalentid()).append(strSplit);
            sbStr.append(getTalentname()).append(strSplit);
            sbStr.append(getSex()).append(strSplit);
            sbStr.append(getBirthday()).append(strSplit);
            sbStr.append(getNationid()).append(strSplit);
            sbStr.append(getNativeplace()).append(strSplit);
            sbStr.append(getPoliticsstatus()).append(strSplit);
            sbStr.append(getProvince()).append(strSplit);
            sbStr.append(getCityid()).append(strSplit);
            sbStr.append(getEducationid()).append(strSplit);
            sbStr.append(getDegreeid()).append(strSplit);
            sbStr.append(getMajorid()).append(strSplit);
            sbStr.append(getLearnexperience()).append(strSplit);
            sbStr.append(getWorkexperience()).append(strSplit);
            sbStr.append(getTalentprofessionid()).append(strSplit);
            sbStr.append(getAcheivement()).append(strSplit);
            sbStr.append(getHonor()).append(strSplit);
            sbStr.append(getSkills()).append(strSplit);
            sbStr.append(getPosttitleid()).append(strSplit);
            sbStr.append(getWorkunit()).append(strSplit);
            sbStr.append(getAdress()).append(strSplit);
            sbStr.append(getMovephone()).append(strSplit);
            sbStr.append(getEmail()).append(strSplit);
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

            if (objs.length != 29)
            {
                return;
            }
            if (objs[0] != null || objs[0].length() >= 1)
            {
                setDatabasetalentid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setTalentid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setTalentname(com.colorwinglib.Converts.objToStr(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setSex(com.colorwinglib.Converts.StrToInt(objs[3]));
            }
            if (objs[4] != null || objs[4].length() >= 1)
            {
                setBirthday(com.colorwinglib.Converts.StrToDate(objs[4]));
            }
            if (objs[5] != null || objs[5].length() >= 1)
            {
                setNationid(com.colorwinglib.Converts.StrToInt(objs[5]));
            }
            if (objs[6] != null || objs[6].length() >= 1)
            {
                setNativeplace(com.colorwinglib.Converts.objToStr(objs[6]));
            }
            if (objs[7] != null || objs[7].length() >= 1)
            {
                setPoliticsstatus(com.colorwinglib.Converts.objToStr(objs[7]));
            }
            if (objs[8] != null || objs[8].length() >= 1)
            {
                setProvince(com.colorwinglib.Converts.StrToInt(objs[8]));
            }
            if (objs[9] != null || objs[9].length() >= 1)
            {
                setCityid(com.colorwinglib.Converts.StrToInt(objs[9]));
            }
            if (objs[10] != null || objs[10].length() >= 1)
            {
                setEducationid(com.colorwinglib.Converts.StrToInt(objs[10]));
            }
            if (objs[11] != null || objs[11].length() >= 1)
            {
                setDegreeid(com.colorwinglib.Converts.StrToInt(objs[11]));
            }
            if (objs[12] != null || objs[12].length() >= 1)
            {
                setMajorid(com.colorwinglib.Converts.StrToInt(objs[12]));
            }
            if (objs[13] != null || objs[13].length() >= 1)
            {
                setLearnexperience(com.colorwinglib.Converts.objToStr(objs[13]));
            }
            if (objs[14] != null || objs[14].length() >= 1)
            {
                setWorkexperience(com.colorwinglib.Converts.objToStr(objs[14]));
            }
            if (objs[15] != null || objs[15].length() >= 1)
            {
                setTalentprofessionid(com.colorwinglib.Converts.StrToInt(objs[15]));
            }
            if (objs[16] != null || objs[16].length() >= 1)
            {
                setAcheivement(com.colorwinglib.Converts.objToStr(objs[16]));
            }
            if (objs[17] != null || objs[17].length() >= 1)
            {
                setHonor(com.colorwinglib.Converts.objToStr(objs[17]));
            }
            if (objs[18] != null || objs[18].length() >= 1)
            {
                setSkills(com.colorwinglib.Converts.objToStr(objs[18]));
            }
            if (objs[19] != null || objs[19].length() >= 1)
            {
                setPosttitleid(com.colorwinglib.Converts.StrToInt(objs[19]));
            }
            if (objs[20] != null || objs[20].length() >= 1)
            {
                setWorkunit(com.colorwinglib.Converts.objToStr(objs[20]));
            }
            if (objs[21] != null || objs[21].length() >= 1)
            {
                setAdress(com.colorwinglib.Converts.objToStr(objs[21]));
            }
            if (objs[22] != null || objs[22].length() >= 1)
            {
                setMovephone(com.colorwinglib.Converts.objToStr(objs[22]));
            }
            if (objs[23] != null || objs[23].length() >= 1)
            {
                setEmail(com.colorwinglib.Converts.objToStr(objs[23]));
            }
            if (objs[24] != null || objs[24].length() >= 1)
            {
                setDatabasepeopleid1(com.colorwinglib.Converts.StrToInt(objs[24]));
            }
            if (objs[25] != null || objs[25].length() >= 1)
            {
                setDatabasepeopleid2(com.colorwinglib.Converts.StrToInt(objs[25]));
            }
            if (objs[26] != null || objs[26].length() >= 1)
            {
                setAdminid(com.colorwinglib.Converts.StrToInt(objs[26]));
            }
            if (objs[27] != null || objs[27].length() >= 1)
            {
                setSectorid(com.colorwinglib.Converts.StrToInt(objs[27]));
            }
            if (objs[28] != null || objs[28].length() >= 1)
            {
                setLogintime(com.colorwinglib.Converts.StrToDate(objs[28]));
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
            sbStr.append("&Databasetalentid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasetalentid()));//databasetalentid
            sbStr.append("&Talentid=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentid()));//人才编号
            sbStr.append("&Talentname=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentname()));//姓名
            sbStr.append("&Sex=").append(com.colorwinglib.StringFormat.UrlEncode(getSex()));//性别：1-男、2-女
            sbStr.append("&Birthday=").append(com.colorwinglib.StringFormat.UrlEncode(getBirthday()));//出生日期
            sbStr.append("&Nationid=").append(com.colorwinglib.StringFormat.UrlEncode(getNationid()));//民族
            sbStr.append("&Nativeplace=").append(com.colorwinglib.StringFormat.UrlEncode(getNativeplace()));//籍贯
            sbStr.append("&Politicsstatus=").append(com.colorwinglib.StringFormat.UrlEncode(getPoliticsstatus()));//政治面貌
            sbStr.append("&Province=").append(com.colorwinglib.StringFormat.UrlEncode(getProvince()));//省份
            sbStr.append("&Cityid=").append(com.colorwinglib.StringFormat.UrlEncode(getCityid()));//城市
            sbStr.append("&Educationid=").append(com.colorwinglib.StringFormat.UrlEncode(getEducationid()));//学历
            sbStr.append("&Degreeid=").append(com.colorwinglib.StringFormat.UrlEncode(getDegreeid()));//学位
            sbStr.append("&Majorid=").append(com.colorwinglib.StringFormat.UrlEncode(getMajorid()));//专业
            sbStr.append("&Learnexperience=").append(com.colorwinglib.StringFormat.UrlEncode(getLearnexperience()));//个人学习经历
            sbStr.append("&Workexperience=").append(com.colorwinglib.StringFormat.UrlEncode(getWorkexperience()));//工作经历
            sbStr.append("&Talentprofessionid=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentprofessionid()));//人才所属行业
            sbStr.append("&Acheivement=").append(com.colorwinglib.StringFormat.UrlEncode(getAcheivement()));//业绩
            sbStr.append("&Honor=").append(com.colorwinglib.StringFormat.UrlEncode(getHonor()));//荣誉
            sbStr.append("&Skills=").append(com.colorwinglib.StringFormat.UrlEncode(getSkills()));//专长
            sbStr.append("&Posttitleid=").append(com.colorwinglib.StringFormat.UrlEncode(getPosttitleid()));//职称
            sbStr.append("&Workunit=").append(com.colorwinglib.StringFormat.UrlEncode(getWorkunit()));//工作单位
            sbStr.append("&Adress=").append(com.colorwinglib.StringFormat.UrlEncode(getAdress()));//现在住址
            sbStr.append("&Movephone=").append(com.colorwinglib.StringFormat.UrlEncode(getMovephone()));//手机
            sbStr.append("&Email=").append(com.colorwinglib.StringFormat.UrlEncode(getEmail()));//邮箱
            sbStr.append("&Databasepeopleid1=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid1()));//统计人员
            sbStr.append("&Databasepeopleid2=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid2()));//填表人员
            sbStr.append("&Adminid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminid()));//登录人员
            sbStr.append("&Sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//SectorID
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
			if (columnName.equals("Databasetalentid"))
				sbStr.append("&Databasetalentid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasetalentid()));//databasetalentid
			if (columnName.equals("Talentid"))
				sbStr.append("&Talentid=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentid()));//人才编号
			if (columnName.equals("Talentname"))
				sbStr.append("&Talentname=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentname()));//姓名
			if (columnName.equals("Sex"))
				sbStr.append("&Sex=").append(com.colorwinglib.StringFormat.UrlEncode(getSex()));//性别：1-男、2-女
			if (columnName.equals("Birthday"))
				sbStr.append("&Birthday=").append(com.colorwinglib.StringFormat.UrlEncode(getBirthday()));//出生日期
			if (columnName.equals("Nationid"))
				sbStr.append("&Nationid=").append(com.colorwinglib.StringFormat.UrlEncode(getNationid()));//民族
			if (columnName.equals("Nativeplace"))
				sbStr.append("&Nativeplace=").append(com.colorwinglib.StringFormat.UrlEncode(getNativeplace()));//籍贯
			if (columnName.equals("Politicsstatus"))
				sbStr.append("&Politicsstatus=").append(com.colorwinglib.StringFormat.UrlEncode(getPoliticsstatus()));//政治面貌
			if (columnName.equals("Province"))
				sbStr.append("&Province=").append(com.colorwinglib.StringFormat.UrlEncode(getProvince()));//省份
			if (columnName.equals("Cityid"))
				sbStr.append("&Cityid=").append(com.colorwinglib.StringFormat.UrlEncode(getCityid()));//城市
			if (columnName.equals("Educationid"))
				sbStr.append("&Educationid=").append(com.colorwinglib.StringFormat.UrlEncode(getEducationid()));//学历
			if (columnName.equals("Degreeid"))
				sbStr.append("&Degreeid=").append(com.colorwinglib.StringFormat.UrlEncode(getDegreeid()));//学位
			if (columnName.equals("Majorid"))
				sbStr.append("&Majorid=").append(com.colorwinglib.StringFormat.UrlEncode(getMajorid()));//专业
			if (columnName.equals("Learnexperience"))
				sbStr.append("&Learnexperience=").append(com.colorwinglib.StringFormat.UrlEncode(getLearnexperience()));//个人学习经历
			if (columnName.equals("Workexperience"))
				sbStr.append("&Workexperience=").append(com.colorwinglib.StringFormat.UrlEncode(getWorkexperience()));//工作经历
			if (columnName.equals("Talentprofessionid"))
				sbStr.append("&Talentprofessionid=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentprofessionid()));//人才所属行业
			if (columnName.equals("Acheivement"))
				sbStr.append("&Acheivement=").append(com.colorwinglib.StringFormat.UrlEncode(getAcheivement()));//业绩
			if (columnName.equals("Honor"))
				sbStr.append("&Honor=").append(com.colorwinglib.StringFormat.UrlEncode(getHonor()));//荣誉
			if (columnName.equals("Skills"))
				sbStr.append("&Skills=").append(com.colorwinglib.StringFormat.UrlEncode(getSkills()));//专长
			if (columnName.equals("Posttitleid"))
				sbStr.append("&Posttitleid=").append(com.colorwinglib.StringFormat.UrlEncode(getPosttitleid()));//职称
			if (columnName.equals("Workunit"))
				sbStr.append("&Workunit=").append(com.colorwinglib.StringFormat.UrlEncode(getWorkunit()));//工作单位
			if (columnName.equals("Adress"))
				sbStr.append("&Adress=").append(com.colorwinglib.StringFormat.UrlEncode(getAdress()));//现在住址
			if (columnName.equals("Movephone"))
				sbStr.append("&Movephone=").append(com.colorwinglib.StringFormat.UrlEncode(getMovephone()));//手机
			if (columnName.equals("Email"))
				sbStr.append("&Email=").append(com.colorwinglib.StringFormat.UrlEncode(getEmail()));//邮箱
			if (columnName.equals("Databasepeopleid1"))
				sbStr.append("&Databasepeopleid1=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid1()));//统计人员
			if (columnName.equals("Databasepeopleid2"))
				sbStr.append("&Databasepeopleid2=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid2()));//填表人员
			if (columnName.equals("Adminid"))
				sbStr.append("&Adminid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminid()));//登录人员
			if (columnName.equals("Sectorid"))
				sbStr.append("&Sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//SectorID
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
            sbStr.append("&databasetalentid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasetalentid()));//databasetalentid
            sbStr.append("&talentid=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentid()));//人才编号
            sbStr.append("&talentname=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentname()));//姓名
            sbStr.append("&sex=").append(com.colorwinglib.StringFormat.UrlEncode(getSex()));//性别：1-男、2-女
            sbStr.append("&birthday=").append(com.colorwinglib.StringFormat.UrlEncode(getBirthday()));//出生日期
            sbStr.append("&nationid=").append(com.colorwinglib.StringFormat.UrlEncode(getNationid()));//民族
            sbStr.append("&nativeplace=").append(com.colorwinglib.StringFormat.UrlEncode(getNativeplace()));//籍贯
            sbStr.append("&politicsstatus=").append(com.colorwinglib.StringFormat.UrlEncode(getPoliticsstatus()));//政治面貌
            sbStr.append("&province=").append(com.colorwinglib.StringFormat.UrlEncode(getProvince()));//省份
            sbStr.append("&cityid=").append(com.colorwinglib.StringFormat.UrlEncode(getCityid()));//城市
            sbStr.append("&educationid=").append(com.colorwinglib.StringFormat.UrlEncode(getEducationid()));//学历
            sbStr.append("&degreeid=").append(com.colorwinglib.StringFormat.UrlEncode(getDegreeid()));//学位
            sbStr.append("&majorid=").append(com.colorwinglib.StringFormat.UrlEncode(getMajorid()));//专业
            sbStr.append("&learnexperience=").append(com.colorwinglib.StringFormat.UrlEncode(getLearnexperience()));//个人学习经历
            sbStr.append("&workexperience=").append(com.colorwinglib.StringFormat.UrlEncode(getWorkexperience()));//工作经历
            sbStr.append("&talentprofessionid=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentprofessionid()));//人才所属行业
            sbStr.append("&acheivement=").append(com.colorwinglib.StringFormat.UrlEncode(getAcheivement()));//业绩
            sbStr.append("&honor=").append(com.colorwinglib.StringFormat.UrlEncode(getHonor()));//荣誉
            sbStr.append("&skills=").append(com.colorwinglib.StringFormat.UrlEncode(getSkills()));//专长
            sbStr.append("&posttitleid=").append(com.colorwinglib.StringFormat.UrlEncode(getPosttitleid()));//职称
            sbStr.append("&workunit=").append(com.colorwinglib.StringFormat.UrlEncode(getWorkunit()));//工作单位
            sbStr.append("&adress=").append(com.colorwinglib.StringFormat.UrlEncode(getAdress()));//现在住址
            sbStr.append("&movephone=").append(com.colorwinglib.StringFormat.UrlEncode(getMovephone()));//手机
            sbStr.append("&email=").append(com.colorwinglib.StringFormat.UrlEncode(getEmail()));//邮箱
            sbStr.append("&databasepeopleid1=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid1()));//统计人员
            sbStr.append("&databasepeopleid2=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid2()));//填表人员
            sbStr.append("&adminid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminid()));//登录人员
            sbStr.append("&sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//SectorID
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
			if (columnName.equals("Databasetalentid"))
				sbStr.append("&databasetalentid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasetalentid()));//databasetalentid
			if (columnName.equals("Talentid"))
				sbStr.append("&talentid=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentid()));//人才编号
			if (columnName.equals("Talentname"))
				sbStr.append("&talentname=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentname()));//姓名
			if (columnName.equals("Sex"))
				sbStr.append("&sex=").append(com.colorwinglib.StringFormat.UrlEncode(getSex()));//性别：1-男、2-女
			if (columnName.equals("Birthday"))
				sbStr.append("&birthday=").append(com.colorwinglib.StringFormat.UrlEncode(getBirthday()));//出生日期
			if (columnName.equals("Nationid"))
				sbStr.append("&nationid=").append(com.colorwinglib.StringFormat.UrlEncode(getNationid()));//民族
			if (columnName.equals("Nativeplace"))
				sbStr.append("&nativeplace=").append(com.colorwinglib.StringFormat.UrlEncode(getNativeplace()));//籍贯
			if (columnName.equals("Politicsstatus"))
				sbStr.append("&politicsstatus=").append(com.colorwinglib.StringFormat.UrlEncode(getPoliticsstatus()));//政治面貌
			if (columnName.equals("Province"))
				sbStr.append("&province=").append(com.colorwinglib.StringFormat.UrlEncode(getProvince()));//省份
			if (columnName.equals("Cityid"))
				sbStr.append("&cityid=").append(com.colorwinglib.StringFormat.UrlEncode(getCityid()));//城市
			if (columnName.equals("Educationid"))
				sbStr.append("&educationid=").append(com.colorwinglib.StringFormat.UrlEncode(getEducationid()));//学历
			if (columnName.equals("Degreeid"))
				sbStr.append("&degreeid=").append(com.colorwinglib.StringFormat.UrlEncode(getDegreeid()));//学位
			if (columnName.equals("Majorid"))
				sbStr.append("&majorid=").append(com.colorwinglib.StringFormat.UrlEncode(getMajorid()));//专业
			if (columnName.equals("Learnexperience"))
				sbStr.append("&learnexperience=").append(com.colorwinglib.StringFormat.UrlEncode(getLearnexperience()));//个人学习经历
			if (columnName.equals("Workexperience"))
				sbStr.append("&workexperience=").append(com.colorwinglib.StringFormat.UrlEncode(getWorkexperience()));//工作经历
			if (columnName.equals("Talentprofessionid"))
				sbStr.append("&talentprofessionid=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentprofessionid()));//人才所属行业
			if (columnName.equals("Acheivement"))
				sbStr.append("&acheivement=").append(com.colorwinglib.StringFormat.UrlEncode(getAcheivement()));//业绩
			if (columnName.equals("Honor"))
				sbStr.append("&honor=").append(com.colorwinglib.StringFormat.UrlEncode(getHonor()));//荣誉
			if (columnName.equals("Skills"))
				sbStr.append("&skills=").append(com.colorwinglib.StringFormat.UrlEncode(getSkills()));//专长
			if (columnName.equals("Posttitleid"))
				sbStr.append("&posttitleid=").append(com.colorwinglib.StringFormat.UrlEncode(getPosttitleid()));//职称
			if (columnName.equals("Workunit"))
				sbStr.append("&workunit=").append(com.colorwinglib.StringFormat.UrlEncode(getWorkunit()));//工作单位
			if (columnName.equals("Adress"))
				sbStr.append("&adress=").append(com.colorwinglib.StringFormat.UrlEncode(getAdress()));//现在住址
			if (columnName.equals("Movephone"))
				sbStr.append("&movephone=").append(com.colorwinglib.StringFormat.UrlEncode(getMovephone()));//手机
			if (columnName.equals("Email"))
				sbStr.append("&email=").append(com.colorwinglib.StringFormat.UrlEncode(getEmail()));//邮箱
			if (columnName.equals("Databasepeopleid1"))
				sbStr.append("&databasepeopleid1=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid1()));//统计人员
			if (columnName.equals("Databasepeopleid2"))
				sbStr.append("&databasepeopleid2=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid2()));//填表人员
			if (columnName.equals("Adminid"))
				sbStr.append("&adminid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminid()));//登录人员
			if (columnName.equals("Sectorid"))
				sbStr.append("&sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//SectorID
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
	public static TalentInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			TalentInfo obj = (TalentInfo) in.readObject();
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
	public String ToModifyString(TalentInfo objOld)
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
	public String ToModifyString(TalentInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getDatabasetalentid(), objOld.getDatabasetalentid()))
			sbStr.append("Databasetalentid databasetalentid:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabasetalentid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabasetalentid())).append("]").append(strSplit);// databasetalentid
		if (com.colorwinglib.Validate.isEquals(getTalentid(), objOld.getTalentid()))
			sbStr.append("Talentid 人才编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getTalentid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getTalentid())).append("]").append(strSplit);// 人才编号
		if (com.colorwinglib.Validate.isEquals(getTalentname(), objOld.getTalentname()))
			sbStr.append("Talentname 姓名:[").append(com.colorwinglib.Converts.objToStr(objOld.getTalentname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getTalentname())).append("]").append(strSplit);// 姓名
		if (com.colorwinglib.Validate.isEquals(getSex(), objOld.getSex()))
			sbStr.append("Sex 性别：1-男、2-女:[").append(com.colorwinglib.Converts.objToStr(objOld.getSex())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getSex())).append("]").append(strSplit);// 性别：1-男、2-女
		if (com.colorwinglib.Validate.isEquals(getBirthday(), objOld.getBirthday()))
			sbStr.append("Birthday 出生日期:[").append(com.colorwinglib.Converts.objToStr(objOld.getBirthday())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getBirthday())).append("]").append(strSplit);// 出生日期
		if (com.colorwinglib.Validate.isEquals(getNationid(), objOld.getNationid()))
			sbStr.append("Nationid 民族:[").append(com.colorwinglib.Converts.objToStr(objOld.getNationid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getNationid())).append("]").append(strSplit);// 民族
		if (com.colorwinglib.Validate.isEquals(getNativeplace(), objOld.getNativeplace()))
			sbStr.append("Nativeplace 籍贯:[").append(com.colorwinglib.Converts.objToStr(objOld.getNativeplace())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getNativeplace())).append("]").append(strSplit);// 籍贯
		if (com.colorwinglib.Validate.isEquals(getPoliticsstatus(), objOld.getPoliticsstatus()))
			sbStr.append("Politicsstatus 政治面貌:[").append(com.colorwinglib.Converts.objToStr(objOld.getPoliticsstatus())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPoliticsstatus())).append("]").append(strSplit);// 政治面貌
		if (com.colorwinglib.Validate.isEquals(getProvince(), objOld.getProvince()))
			sbStr.append("Province 省份:[").append(com.colorwinglib.Converts.objToStr(objOld.getProvince())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getProvince())).append("]").append(strSplit);// 省份
		if (com.colorwinglib.Validate.isEquals(getCityid(), objOld.getCityid()))
			sbStr.append("Cityid 城市:[").append(com.colorwinglib.Converts.objToStr(objOld.getCityid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getCityid())).append("]").append(strSplit);// 城市
		if (com.colorwinglib.Validate.isEquals(getEducationid(), objOld.getEducationid()))
			sbStr.append("Educationid 学历:[").append(com.colorwinglib.Converts.objToStr(objOld.getEducationid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getEducationid())).append("]").append(strSplit);// 学历
		if (com.colorwinglib.Validate.isEquals(getDegreeid(), objOld.getDegreeid()))
			sbStr.append("Degreeid 学位:[").append(com.colorwinglib.Converts.objToStr(objOld.getDegreeid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDegreeid())).append("]").append(strSplit);// 学位
		if (com.colorwinglib.Validate.isEquals(getMajorid(), objOld.getMajorid()))
			sbStr.append("Majorid 专业:[").append(com.colorwinglib.Converts.objToStr(objOld.getMajorid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getMajorid())).append("]").append(strSplit);// 专业
		if (com.colorwinglib.Validate.isEquals(getLearnexperience(), objOld.getLearnexperience()))
			sbStr.append("Learnexperience 个人学习经历:[").append(com.colorwinglib.Converts.objToStr(objOld.getLearnexperience())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getLearnexperience())).append("]").append(strSplit);// 个人学习经历
		if (com.colorwinglib.Validate.isEquals(getWorkexperience(), objOld.getWorkexperience()))
			sbStr.append("Workexperience 工作经历:[").append(com.colorwinglib.Converts.objToStr(objOld.getWorkexperience())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getWorkexperience())).append("]").append(strSplit);// 工作经历
		if (com.colorwinglib.Validate.isEquals(getTalentprofessionid(), objOld.getTalentprofessionid()))
			sbStr.append("Talentprofessionid 人才所属行业:[").append(com.colorwinglib.Converts.objToStr(objOld.getTalentprofessionid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getTalentprofessionid())).append("]").append(strSplit);// 人才所属行业
		if (com.colorwinglib.Validate.isEquals(getAcheivement(), objOld.getAcheivement()))
			sbStr.append("Acheivement 业绩:[").append(com.colorwinglib.Converts.objToStr(objOld.getAcheivement())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAcheivement())).append("]").append(strSplit);// 业绩
		if (com.colorwinglib.Validate.isEquals(getHonor(), objOld.getHonor()))
			sbStr.append("Honor 荣誉:[").append(com.colorwinglib.Converts.objToStr(objOld.getHonor())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getHonor())).append("]").append(strSplit);// 荣誉
		if (com.colorwinglib.Validate.isEquals(getSkills(), objOld.getSkills()))
			sbStr.append("Skills 专长:[").append(com.colorwinglib.Converts.objToStr(objOld.getSkills())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getSkills())).append("]").append(strSplit);// 专长
		if (com.colorwinglib.Validate.isEquals(getPosttitleid(), objOld.getPosttitleid()))
			sbStr.append("Posttitleid 职称:[").append(com.colorwinglib.Converts.objToStr(objOld.getPosttitleid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPosttitleid())).append("]").append(strSplit);// 职称
		if (com.colorwinglib.Validate.isEquals(getWorkunit(), objOld.getWorkunit()))
			sbStr.append("Workunit 工作单位:[").append(com.colorwinglib.Converts.objToStr(objOld.getWorkunit())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getWorkunit())).append("]").append(strSplit);// 工作单位
		if (com.colorwinglib.Validate.isEquals(getAdress(), objOld.getAdress()))
			sbStr.append("Adress 现在住址:[").append(com.colorwinglib.Converts.objToStr(objOld.getAdress())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAdress())).append("]").append(strSplit);// 现在住址
		if (com.colorwinglib.Validate.isEquals(getMovephone(), objOld.getMovephone()))
			sbStr.append("Movephone 手机:[").append(com.colorwinglib.Converts.objToStr(objOld.getMovephone())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getMovephone())).append("]").append(strSplit);// 手机
		if (com.colorwinglib.Validate.isEquals(getEmail(), objOld.getEmail()))
			sbStr.append("Email 邮箱:[").append(com.colorwinglib.Converts.objToStr(objOld.getEmail())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getEmail())).append("]").append(strSplit);// 邮箱
		if (com.colorwinglib.Validate.isEquals(getDatabasepeopleid1(), objOld.getDatabasepeopleid1()))
			sbStr.append("Databasepeopleid1 统计人员:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabasepeopleid1())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabasepeopleid1())).append("]").append(strSplit);// 统计人员
		if (com.colorwinglib.Validate.isEquals(getDatabasepeopleid2(), objOld.getDatabasepeopleid2()))
			sbStr.append("Databasepeopleid2 填表人员:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabasepeopleid2())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabasepeopleid2())).append("]").append(strSplit);// 填表人员
		if (com.colorwinglib.Validate.isEquals(getAdminid(), objOld.getAdminid()))
			sbStr.append("Adminid 登录人员:[").append(com.colorwinglib.Converts.objToStr(objOld.getAdminid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAdminid())).append("]").append(strSplit);// 登录人员
		if (com.colorwinglib.Validate.isEquals(getSectorid(), objOld.getSectorid()))
			sbStr.append("Sectorid SectorID:[").append(com.colorwinglib.Converts.objToStr(objOld.getSectorid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getSectorid())).append("]").append(strSplit);// SectorID
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
			json.put("Databasetalentid", getDatabasetalentid());// databasetalentid
			json.put("Talentid", getTalentid());// 人才编号
			json.put("Talentname", getTalentname());// 姓名
			json.put("Sex", getSex());// 性别：1-男、2-女
			json.put("Birthday", getBirthday());// 出生日期
			json.put("Nationid", getNationid());// 民族
			json.put("Nativeplace", getNativeplace());// 籍贯
			json.put("Politicsstatus", getPoliticsstatus());// 政治面貌
			json.put("Province", getProvince());// 省份
			json.put("Cityid", getCityid());// 城市
			json.put("Educationid", getEducationid());// 学历
			json.put("Degreeid", getDegreeid());// 学位
			json.put("Majorid", getMajorid());// 专业
			json.put("Learnexperience", getLearnexperience());// 个人学习经历
			json.put("Workexperience", getWorkexperience());// 工作经历
			json.put("Talentprofessionid", getTalentprofessionid());// 人才所属行业
			json.put("Acheivement", getAcheivement());// 业绩
			json.put("Honor", getHonor());// 荣誉
			json.put("Skills", getSkills());// 专长
			json.put("Posttitleid", getPosttitleid());// 职称
			json.put("Workunit", getWorkunit());// 工作单位
			json.put("Adress", getAdress());// 现在住址
			json.put("Movephone", getMovephone());// 手机
			json.put("Email", getEmail());// 邮箱
			json.put("Databasepeopleid1", getDatabasepeopleid1());// 统计人员
			json.put("Databasepeopleid2", getDatabasepeopleid2());// 填表人员
			json.put("Adminid", getAdminid());// 登录人员
			json.put("Sectorid", getSectorid());// SectorID
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
			setDatabasetalentid(json.getInt("Databasetalentid"));// databasetalentid
			setTalentid(json.getInt("Talentid"));// 人才编号
			setTalentname(json.getString("Talentname"));// 姓名
			setSex(json.getInt("Sex"));// 性别：1-男、2-女
			setBirthday(com.colorwinglib.Converts.StrToDate(json.getString("Birthday")));// 出生日期
			setNationid(json.getInt("Nationid"));// 民族
			setNativeplace(json.getString("Nativeplace"));// 籍贯
			setPoliticsstatus(json.getString("Politicsstatus"));// 政治面貌
			setProvince(json.getInt("Province"));// 省份
			setCityid(json.getInt("Cityid"));// 城市
			setEducationid(json.getInt("Educationid"));// 学历
			setDegreeid(json.getInt("Degreeid"));// 学位
			setMajorid(json.getInt("Majorid"));// 专业
			setLearnexperience(json.getString("Learnexperience"));// 个人学习经历
			setWorkexperience(json.getString("Workexperience"));// 工作经历
			setTalentprofessionid(json.getInt("Talentprofessionid"));// 人才所属行业
			setAcheivement(json.getString("Acheivement"));// 业绩
			setHonor(json.getString("Honor"));// 荣誉
			setSkills(json.getString("Skills"));// 专长
			setPosttitleid(json.getInt("Posttitleid"));// 职称
			setWorkunit(json.getString("Workunit"));// 工作单位
			setAdress(json.getString("Adress"));// 现在住址
			setMovephone(json.getString("Movephone"));// 手机
			setEmail(json.getString("Email"));// 邮箱
			setDatabasepeopleid1(json.getInt("Databasepeopleid1"));// 统计人员
			setDatabasepeopleid2(json.getInt("Databasepeopleid2"));// 填表人员
			setAdminid(json.getInt("Adminid"));// 登录人员
			setSectorid(json.getInt("Sectorid"));// SectorID
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
		sbStr.append("<TalentInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //databasetalentid
			sbStr.append("    <Databasetalentid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabasetalentid()));
			sbStr.append("</Databasetalentid>\n");
            //人才编号
			sbStr.append("    <Talentid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getTalentid()));
			sbStr.append("</Talentid>\n");
            //姓名
			sbStr.append("    <Talentname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getTalentname()));
			sbStr.append("</Talentname>\n");
            //性别：1-男、2-女
			sbStr.append("    <Sex>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getSex()));
			sbStr.append("</Sex>\n");
            //出生日期
			sbStr.append("    <Birthday>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getBirthday()));
			sbStr.append("</Birthday>\n");
            //民族
			sbStr.append("    <Nationid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getNationid()));
			sbStr.append("</Nationid>\n");
            //籍贯
			sbStr.append("    <Nativeplace>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getNativeplace()));
			sbStr.append("</Nativeplace>\n");
            //政治面貌
			sbStr.append("    <Politicsstatus>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPoliticsstatus()));
			sbStr.append("</Politicsstatus>\n");
            //省份
			sbStr.append("    <Province>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getProvince()));
			sbStr.append("</Province>\n");
            //城市
			sbStr.append("    <Cityid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getCityid()));
			sbStr.append("</Cityid>\n");
            //学历
			sbStr.append("    <Educationid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getEducationid()));
			sbStr.append("</Educationid>\n");
            //学位
			sbStr.append("    <Degreeid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDegreeid()));
			sbStr.append("</Degreeid>\n");
            //专业
			sbStr.append("    <Majorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getMajorid()));
			sbStr.append("</Majorid>\n");
            //个人学习经历
			sbStr.append("    <Learnexperience>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getLearnexperience()));
			sbStr.append("</Learnexperience>\n");
            //工作经历
			sbStr.append("    <Workexperience>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getWorkexperience()));
			sbStr.append("</Workexperience>\n");
            //人才所属行业
			sbStr.append("    <Talentprofessionid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getTalentprofessionid()));
			sbStr.append("</Talentprofessionid>\n");
            //业绩
			sbStr.append("    <Acheivement>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAcheivement()));
			sbStr.append("</Acheivement>\n");
            //荣誉
			sbStr.append("    <Honor>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getHonor()));
			sbStr.append("</Honor>\n");
            //专长
			sbStr.append("    <Skills>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getSkills()));
			sbStr.append("</Skills>\n");
            //职称
			sbStr.append("    <Posttitleid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPosttitleid()));
			sbStr.append("</Posttitleid>\n");
            //工作单位
			sbStr.append("    <Workunit>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getWorkunit()));
			sbStr.append("</Workunit>\n");
            //现在住址
			sbStr.append("    <Adress>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAdress()));
			sbStr.append("</Adress>\n");
            //手机
			sbStr.append("    <Movephone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getMovephone()));
			sbStr.append("</Movephone>\n");
            //邮箱
			sbStr.append("    <Email>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getEmail()));
			sbStr.append("</Email>\n");
            //统计人员
			sbStr.append("    <Databasepeopleid1>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabasepeopleid1()));
			sbStr.append("</Databasepeopleid1>\n");
            //填表人员
			sbStr.append("    <Databasepeopleid2>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabasepeopleid2()));
			sbStr.append("</Databasepeopleid2>\n");
            //登录人员
			sbStr.append("    <Adminid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAdminid()));
			sbStr.append("</Adminid>\n");
            //SectorID
			sbStr.append("    <Sectorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getSectorid()));
			sbStr.append("</Sectorid>\n");
            //登录时间
			sbStr.append("    <Logintime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getLogintime()));
			sbStr.append("</Logintime>\n");
		sbStr.append("</TalentInfo>\n");
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
	// GetTalentInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetTalentInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static TalentInfo GetTalentInfoFormFileName(String filename)
	{
		return GetTalentInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetTalentInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static TalentInfo GetTalentInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetTalentInfoFormXml(xml, encoding);
	}

	// [end]

	// GetTalentInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetTalentInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static TalentInfo GetTalentInfoFormXml(String xml)
	{
		return GetTalentInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetTalentInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static TalentInfo GetTalentInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		TalentInfo objTalentInfo = new TalentInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//databasetalentid
				if (foo.elementText("Databasetalentid") != null)
					objTalentInfo.setDatabasetalentid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasetalentid")));
				//人才编号
				if (foo.elementText("Talentid") != null)
					objTalentInfo.setTalentid(com.colorwinglib.Converts.StrToInt(foo.elementText("Talentid")));
				//姓名
				if (foo.elementText("Talentname") != null)
					objTalentInfo.setTalentname(com.colorwinglib.Converts.objToStr(foo.elementText("Talentname")));
				//性别：1-男、2-女
				if (foo.elementText("Sex") != null)
					objTalentInfo.setSex(com.colorwinglib.Converts.StrToInt(foo.elementText("Sex")));
				//出生日期
				if (foo.elementText("Birthday") != null)
					objTalentInfo.setBirthday(com.colorwinglib.Converts.StrToDate(foo.elementText("Birthday")));
				//民族
				if (foo.elementText("Nationid") != null)
					objTalentInfo.setNationid(com.colorwinglib.Converts.StrToInt(foo.elementText("Nationid")));
				//籍贯
				if (foo.elementText("Nativeplace") != null)
					objTalentInfo.setNativeplace(com.colorwinglib.Converts.objToStr(foo.elementText("Nativeplace")));
				//政治面貌
				if (foo.elementText("Politicsstatus") != null)
					objTalentInfo.setPoliticsstatus(com.colorwinglib.Converts.objToStr(foo.elementText("Politicsstatus")));
				//省份
				if (foo.elementText("Province") != null)
					objTalentInfo.setProvince(com.colorwinglib.Converts.StrToInt(foo.elementText("Province")));
				//城市
				if (foo.elementText("Cityid") != null)
					objTalentInfo.setCityid(com.colorwinglib.Converts.StrToInt(foo.elementText("Cityid")));
				//学历
				if (foo.elementText("Educationid") != null)
					objTalentInfo.setEducationid(com.colorwinglib.Converts.StrToInt(foo.elementText("Educationid")));
				//学位
				if (foo.elementText("Degreeid") != null)
					objTalentInfo.setDegreeid(com.colorwinglib.Converts.StrToInt(foo.elementText("Degreeid")));
				//专业
				if (foo.elementText("Majorid") != null)
					objTalentInfo.setMajorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Majorid")));
				//个人学习经历
				if (foo.elementText("Learnexperience") != null)
					objTalentInfo.setLearnexperience(com.colorwinglib.Converts.objToStr(foo.elementText("Learnexperience")));
				//工作经历
				if (foo.elementText("Workexperience") != null)
					objTalentInfo.setWorkexperience(com.colorwinglib.Converts.objToStr(foo.elementText("Workexperience")));
				//人才所属行业
				if (foo.elementText("Talentprofessionid") != null)
					objTalentInfo.setTalentprofessionid(com.colorwinglib.Converts.StrToInt(foo.elementText("Talentprofessionid")));
				//业绩
				if (foo.elementText("Acheivement") != null)
					objTalentInfo.setAcheivement(com.colorwinglib.Converts.objToStr(foo.elementText("Acheivement")));
				//荣誉
				if (foo.elementText("Honor") != null)
					objTalentInfo.setHonor(com.colorwinglib.Converts.objToStr(foo.elementText("Honor")));
				//专长
				if (foo.elementText("Skills") != null)
					objTalentInfo.setSkills(com.colorwinglib.Converts.objToStr(foo.elementText("Skills")));
				//职称
				if (foo.elementText("Posttitleid") != null)
					objTalentInfo.setPosttitleid(com.colorwinglib.Converts.StrToInt(foo.elementText("Posttitleid")));
				//工作单位
				if (foo.elementText("Workunit") != null)
					objTalentInfo.setWorkunit(com.colorwinglib.Converts.objToStr(foo.elementText("Workunit")));
				//现在住址
				if (foo.elementText("Adress") != null)
					objTalentInfo.setAdress(com.colorwinglib.Converts.objToStr(foo.elementText("Adress")));
				//手机
				if (foo.elementText("Movephone") != null)
					objTalentInfo.setMovephone(com.colorwinglib.Converts.objToStr(foo.elementText("Movephone")));
				//邮箱
				if (foo.elementText("Email") != null)
					objTalentInfo.setEmail(com.colorwinglib.Converts.objToStr(foo.elementText("Email")));
				//统计人员
				if (foo.elementText("Databasepeopleid1") != null)
					objTalentInfo.setDatabasepeopleid1(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasepeopleid1")));
				//填表人员
				if (foo.elementText("Databasepeopleid2") != null)
					objTalentInfo.setDatabasepeopleid2(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasepeopleid2")));
				//登录人员
				if (foo.elementText("Adminid") != null)
					objTalentInfo.setAdminid(com.colorwinglib.Converts.StrToInt(foo.elementText("Adminid")));
				//SectorID
				if (foo.elementText("Sectorid") != null)
					objTalentInfo.setSectorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Sectorid")));
				//登录时间
				if (foo.elementText("Logintime") != null)
					objTalentInfo.setLogintime(com.colorwinglib.Converts.StrToDate(foo.elementText("Logintime")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objTalentInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public TalentInfo Copy()
	{
		TalentInfo objTalentInfo = new TalentInfo();
		objTalentInfo.setDatabasetalentid(this.getDatabasetalentid());//databasetalentid
		objTalentInfo.setTalentid(this.getTalentid());//人才编号
		objTalentInfo.setTalentname(this.getTalentname());//姓名
		objTalentInfo.setSex(this.getSex());//性别：1-男、2-女
		objTalentInfo.setBirthday(this.getBirthday());//出生日期
		objTalentInfo.setNationid(this.getNationid());//民族
		objTalentInfo.setNativeplace(this.getNativeplace());//籍贯
		objTalentInfo.setPoliticsstatus(this.getPoliticsstatus());//政治面貌
		objTalentInfo.setProvince(this.getProvince());//省份
		objTalentInfo.setCityid(this.getCityid());//城市
		objTalentInfo.setEducationid(this.getEducationid());//学历
		objTalentInfo.setDegreeid(this.getDegreeid());//学位
		objTalentInfo.setMajorid(this.getMajorid());//专业
		objTalentInfo.setLearnexperience(this.getLearnexperience());//个人学习经历
		objTalentInfo.setWorkexperience(this.getWorkexperience());//工作经历
		objTalentInfo.setTalentprofessionid(this.getTalentprofessionid());//人才所属行业
		objTalentInfo.setAcheivement(this.getAcheivement());//业绩
		objTalentInfo.setHonor(this.getHonor());//荣誉
		objTalentInfo.setSkills(this.getSkills());//专长
		objTalentInfo.setPosttitleid(this.getPosttitleid());//职称
		objTalentInfo.setWorkunit(this.getWorkunit());//工作单位
		objTalentInfo.setAdress(this.getAdress());//现在住址
		objTalentInfo.setMovephone(this.getMovephone());//手机
		objTalentInfo.setEmail(this.getEmail());//邮箱
		objTalentInfo.setDatabasepeopleid1(this.getDatabasepeopleid1());//统计人员
		objTalentInfo.setDatabasepeopleid2(this.getDatabasepeopleid2());//填表人员
		objTalentInfo.setAdminid(this.getAdminid());//登录人员
		objTalentInfo.setSectorid(this.getSectorid());//SectorID
		objTalentInfo.setLogintime(this.getLogintime());//登录时间
		return objTalentInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明

        // [start] 设置和获取 性别：1-男、2-女, 默认值:0
	private String sexlabel = "";
	/**
	* 获取 性别：1-男、2-女, 类型String 默认值:""
	 *
	 * @return 性别：1-男、2-女, 类型String 默认值:""
	 */
	public String getSexlabel()
	{
		if (sexlabel.length() == 0)
			sexlabel = com.yun.bll.itemcollection.culture.TalentItemCollection.SexText(String.valueOf(getSex()));
		return this.sexlabel; 
	}
        // [end]



	 //[end]
}
