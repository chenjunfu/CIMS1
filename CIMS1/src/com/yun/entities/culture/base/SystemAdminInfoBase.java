
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * SystemAdmin 系统人员表的描述
 * 实体类基本类
 */
public class SystemAdminInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012121309490440664L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public SystemAdminInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public SystemAdminInfoBase(int sDatabaseadminid)
	{
		this.setDatabaseadminid(sDatabaseadminid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public SystemAdminInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setDatabaseadminid(rs.getInt("DatabaseAdminID"));//人员ID
		setAdminid(rs.getInt("AdminID"));//人员编号
		setAdminname(rs.getString("AdminName"));//帐号
		setAdminpassword(rs.getString("AdminPassWord"));//密码
		setSex(rs.getInt("Sex"));//性别：1-男、2-女
		setTruename(rs.getString("TrueName"));//姓名
		setWorkno(rs.getString("WorkNO"));//工号
		setEmail(rs.getString("Email"));//联系EMAIL
		setMovephone(rs.getString("MovePhone"));//移动电话
		setPhone(rs.getString("Phone"));//电话
		setMsn(rs.getString("MSN"));//MSN
		setRolesid(rs.getInt("RolesID"));//角色编号
		setSectorid(rs.getInt("SectorID"));//部门编号
		setDescription(rs.getString("Description"));//人员描述
		setAddress(rs.getString("Address"));//通讯地址
		setLimitIp(rs.getString("Limit_Ip"));//限定IP
		setLastLogintime(MyDate.setDate(rs.getTimestamp("Last_LoginTime")));//最后登录时间
		setLastLoginip(rs.getString("Last_LoginIp"));//最后登录IP
		setCreateTime(MyDate.setDate(rs.getTimestamp("Create_Time")));//创建时间
		setLastModifytime(MyDate.setDate(rs.getTimestamp("Last_ModifyTime")));//最后修改时间
		setIsUse(rs.getInt("Is_Use"));//启用标志：1-启用、2-未启用
		setIsDel(rs.getInt("Is_Del"));//是否删除：1-未删除、2-已删除
		setCompetence(rs.getString("Competence"));//拥有权限
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public SystemAdminInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//人员ID
			if (columnName.equals("DatabaseAdminID"))
			{
				setDatabaseadminid(rs.getInt("DatabaseAdminID"));
				continue;
			}
			//人员编号
			if (columnName.equals("AdminID"))
			{
				setAdminid(rs.getInt("AdminID"));
				continue;
			}
			//帐号
			if (columnName.equals("AdminName"))
			{
				setAdminname(rs.getString("AdminName"));
				continue;
			}
			//密码
			if (columnName.equals("AdminPassWord"))
			{
				setAdminpassword(rs.getString("AdminPassWord"));
				continue;
			}
			//性别：1-男、2-女
			if (columnName.equals("Sex"))
			{
				setSex(rs.getInt("Sex"));
				continue;
			}
			//姓名
			if (columnName.equals("TrueName"))
			{
				setTruename(rs.getString("TrueName"));
				continue;
			}
			//工号
			if (columnName.equals("WorkNO"))
			{
				setWorkno(rs.getString("WorkNO"));
				continue;
			}
			//联系EMAIL
			if (columnName.equals("Email"))
			{
				setEmail(rs.getString("Email"));
				continue;
			}
			//移动电话
			if (columnName.equals("MovePhone"))
			{
				setMovephone(rs.getString("MovePhone"));
				continue;
			}
			//电话
			if (columnName.equals("Phone"))
			{
				setPhone(rs.getString("Phone"));
				continue;
			}
			//MSN
			if (columnName.equals("MSN"))
			{
				setMsn(rs.getString("MSN"));
				continue;
			}
			//角色编号
			if (columnName.equals("RolesID"))
			{
				setRolesid(rs.getInt("RolesID"));
				continue;
			}
			//部门编号
			if (columnName.equals("SectorID"))
			{
				setSectorid(rs.getInt("SectorID"));
				continue;
			}
			//人员描述
			if (columnName.equals("Description"))
			{
				setDescription(rs.getString("Description"));
				continue;
			}
			//通讯地址
			if (columnName.equals("Address"))
			{
				setAddress(rs.getString("Address"));
				continue;
			}
			//限定IP
			if (columnName.equals("Limit_Ip"))
			{
				setLimitIp(rs.getString("Limit_Ip"));
				continue;
			}
			//最后登录时间
			if (columnName.equals("Last_LoginTime"))
			{
				setLastLogintime(MyDate.setDate(rs.getTimestamp("Last_LoginTime")));
				continue;
			}
			//最后登录IP
			if (columnName.equals("Last_LoginIp"))
			{
				setLastLoginip(rs.getString("Last_LoginIp"));
				continue;
			}
			//创建时间
			if (columnName.equals("Create_Time"))
			{
				setCreateTime(MyDate.setDate(rs.getTimestamp("Create_Time")));
				continue;
			}
			//最后修改时间
			if (columnName.equals("Last_ModifyTime"))
			{
				setLastModifytime(MyDate.setDate(rs.getTimestamp("Last_ModifyTime")));
				continue;
			}
			//启用标志：1-启用、2-未启用
			if (columnName.equals("Is_Use"))
			{
				setIsUse(rs.getInt("Is_Use"));
				continue;
			}
			//是否删除：1-未删除、2-已删除
			if (columnName.equals("Is_Del"))
			{
				setIsDel(rs.getInt("Is_Del"));
				continue;
			}
			//拥有权限
			if (columnName.equals("Competence"))
			{
				setCompetence(rs.getString("Competence"));
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
		if (!(rhs instanceof SystemAdminInfo))
			return false;
		SystemAdminInfo that = (SystemAdminInfo) rhs;

		return (this.getDatabaseadminid() == (that.getDatabaseadminid()));
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

			result = result * 37 + (this.getDatabaseadminid() + "").hashCode();
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
	"DatabaseAdminID", //人员ID
	"AdminID", //人员编号
	"AdminName", //帐号
	"AdminPassWord", //密码
	"Sex", //性别：1-男、2-女
	"TrueName", //姓名
	"WorkNO", //工号
	"Email", //联系EMAIL
	"MovePhone", //移动电话
	"Phone", //电话
	"MSN", //MSN
	"RolesID", //角色编号
	"SectorID", //部门编号
	"Description", //人员描述
	"Address", //通讯地址
	"Limit_Ip", //限定IP
	"Last_LoginTime", //最后登录时间
	"Last_LoginIp", //最后登录IP
	"Create_Time", //创建时间
	"Last_ModifyTime", //最后修改时间
	"Is_Use", //启用标志：1-启用、2-未启用
	"Is_Del", //是否删除：1-未删除、2-已删除
	"Competence" //拥有权限
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum SystemAdminColumnNameEnum
{
		/**
		 * 人员ID
		 */
		Databaseadminid,
		/**
		 * 人员编号
		 */
		Adminid,
		/**
		 * 帐号
		 */
		Adminname,
		/**
		 * 密码
		 */
		Adminpassword,
		/**
		 * 性别：1-男、2-女
		 */
		Sex,
		/**
		 * 姓名
		 */
		Truename,
		/**
		 * 工号
		 */
		Workno,
		/**
		 * 联系EMAIL
		 */
		Email,
		/**
		 * 移动电话
		 */
		Movephone,
		/**
		 * 电话
		 */
		Phone,
		/**
		 * MSN
		 */
		Msn,
		/**
		 * 角色编号
		 */
		Rolesid,
		/**
		 * 部门编号
		 */
		Sectorid,
		/**
		 * 人员描述
		 */
		Description,
		/**
		 * 通讯地址
		 */
		Address,
		/**
		 * 限定IP
		 */
		LimitIp,
		/**
		 * 最后登录时间
		 */
		LastLogintime,
		/**
		 * 最后登录IP
		 */
		LastLoginip,
		/**
		 * 创建时间
		 */
		CreateTime,
		/**
		 * 最后修改时间
		 */
		LastModifytime,
		/**
		 * 启用标志：1-启用、2-未启用
		 */
		IsUse,
		/**
		 * 是否删除：1-未删除、2-已删除
		 */
		IsDel,
		/**
		 * 拥有权限
		 */
		Competence
	};
	// [end]
        // [start] 设置和获取 人员ID, 默认值:0
	// 设置和获取 人员ID,类型int 默认值:0 开始
	private int databaseadminid = 0;
	/**
	* 获取 人员ID, 类型int 默认值:0
	 *
	 * @return 人员ID, 类型int 默认值:0
	 */
	public int getDatabaseadminid()
	{
		return this.databaseadminid; 
	}
	/**
	 * 设置 人员ID, 类型int 默认值:0
	 *
	 * @param sDatabaseadminid
	 *            人员ID, 类型int 默认值:0
	 */
	public void setDatabaseadminid(int sDatabaseadminid)
	{
		this.databaseadminid = sDatabaseadminid; 
	}
	// 设置和获取 人员ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 人员编号, 默认值:0
	// 设置和获取 人员编号,类型int 默认值:0 开始
	private int adminid = 0;
	/**
	* 获取 人员编号, 类型int 默认值:0
	 *
	 * @return 人员编号, 类型int 默认值:0
	 */
	public int getAdminid()
	{
		return this.adminid; 
	}
	/**
	 * 设置 人员编号, 类型int 默认值:0
	 *
	 * @param sAdminid
	 *            人员编号, 类型int 默认值:0
	 */
	public void setAdminid(int sAdminid)
	{
		this.adminid = sAdminid; 
	}
	// 设置和获取 人员编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 帐号, 默认值:""
	// 设置和获取 帐号,类型String 默认值:"" 开始
	private String adminname = "";
	/**
	* 获取 帐号, 类型String 默认值:""
	 *
	 * @return 帐号, 类型String 默认值:""
	 */
	public String getAdminname()
	{
		return this.adminname; 
	}
	/**
	 * 设置 帐号, 类型String 默认值:""
	 *
	 * @param sAdminname
	 *            帐号, 类型String 默认值:""
	 */
	public void setAdminname(String sAdminname)
	{
		this.adminname = sAdminname; 
	}
	// 设置和获取 帐号, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 密码, 默认值:""
	// 设置和获取 密码,类型String 默认值:"" 开始
	private String adminpassword = "";
	/**
	* 获取 密码, 类型String 默认值:""
	 *
	 * @return 密码, 类型String 默认值:""
	 */
	public String getAdminpassword()
	{
		return this.adminpassword; 
	}
	/**
	 * 设置 密码, 类型String 默认值:""
	 *
	 * @param sAdminpassword
	 *            密码, 类型String 默认值:""
	 */
	public void setAdminpassword(String sAdminpassword)
	{
		this.adminpassword = sAdminpassword; 
	}
	// 设置和获取 密码, 类型String 默认值:"" 结束
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


        // [start] 设置和获取 姓名, 默认值:""
	// 设置和获取 姓名,类型String 默认值:"" 开始
	private String truename = "";
	/**
	* 获取 姓名, 类型String 默认值:""
	 *
	 * @return 姓名, 类型String 默认值:""
	 */
	public String getTruename()
	{
		return this.truename; 
	}
	/**
	 * 设置 姓名, 类型String 默认值:""
	 *
	 * @param sTruename
	 *            姓名, 类型String 默认值:""
	 */
	public void setTruename(String sTruename)
	{
		this.truename = sTruename; 
	}
	// 设置和获取 姓名, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 工号, 默认值:""
	// 设置和获取 工号,类型String 默认值:"" 开始
	private String workno = "";
	/**
	* 获取 工号, 类型String 默认值:""
	 *
	 * @return 工号, 类型String 默认值:""
	 */
	public String getWorkno()
	{
		return this.workno; 
	}
	/**
	 * 设置 工号, 类型String 默认值:""
	 *
	 * @param sWorkno
	 *            工号, 类型String 默认值:""
	 */
	public void setWorkno(String sWorkno)
	{
		this.workno = sWorkno; 
	}
	// 设置和获取 工号, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 联系EMAIL, 默认值:""
	// 设置和获取 联系EMAIL,类型String 默认值:"" 开始
	private String email = "";
	/**
	* 获取 联系EMAIL, 类型String 默认值:""
	 *
	 * @return 联系EMAIL, 类型String 默认值:""
	 */
	public String getEmail()
	{
		return this.email; 
	}
	/**
	 * 设置 联系EMAIL, 类型String 默认值:""
	 *
	 * @param sEmail
	 *            联系EMAIL, 类型String 默认值:""
	 */
	public void setEmail(String sEmail)
	{
		this.email = sEmail; 
	}
	// 设置和获取 联系EMAIL, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 移动电话, 默认值:""
	// 设置和获取 移动电话,类型String 默认值:"" 开始
	private String movephone = "";
	/**
	* 获取 移动电话, 类型String 默认值:""
	 *
	 * @return 移动电话, 类型String 默认值:""
	 */
	public String getMovephone()
	{
		return this.movephone; 
	}
	/**
	 * 设置 移动电话, 类型String 默认值:""
	 *
	 * @param sMovephone
	 *            移动电话, 类型String 默认值:""
	 */
	public void setMovephone(String sMovephone)
	{
		this.movephone = sMovephone; 
	}
	// 设置和获取 移动电话, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 电话, 默认值:""
	// 设置和获取 电话,类型String 默认值:"" 开始
	private String phone = "";
	/**
	* 获取 电话, 类型String 默认值:""
	 *
	 * @return 电话, 类型String 默认值:""
	 */
	public String getPhone()
	{
		return this.phone; 
	}
	/**
	 * 设置 电话, 类型String 默认值:""
	 *
	 * @param sPhone
	 *            电话, 类型String 默认值:""
	 */
	public void setPhone(String sPhone)
	{
		this.phone = sPhone; 
	}
	// 设置和获取 电话, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 MSN, 默认值:""
	// 设置和获取 MSN,类型String 默认值:"" 开始
	private String msn = "";
	/**
	* 获取 MSN, 类型String 默认值:""
	 *
	 * @return MSN, 类型String 默认值:""
	 */
	public String getMsn()
	{
		return this.msn; 
	}
	/**
	 * 设置 MSN, 类型String 默认值:""
	 *
	 * @param sMsn
	 *            MSN, 类型String 默认值:""
	 */
	public void setMsn(String sMsn)
	{
		this.msn = sMsn; 
	}
	// 设置和获取 MSN, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 角色编号, 默认值:0
	// 设置和获取 角色编号,类型int 默认值:0 开始
	private int rolesid = 0;
	/**
	* 获取 角色编号, 类型int 默认值:0
	 *
	 * @return 角色编号, 类型int 默认值:0
	 */
	public int getRolesid()
	{
		return this.rolesid; 
	}
	/**
	 * 设置 角色编号, 类型int 默认值:0
	 *
	 * @param sRolesid
	 *            角色编号, 类型int 默认值:0
	 */
	public void setRolesid(int sRolesid)
	{
		this.rolesid = sRolesid; 
	}
	// 设置和获取 角色编号, 类型int 默认值:0 结束
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


        // [start] 设置和获取 人员描述, 默认值:""
	// 设置和获取 人员描述,类型String 默认值:"" 开始
	private String description = "";
	/**
	* 获取 人员描述, 类型String 默认值:""
	 *
	 * @return 人员描述, 类型String 默认值:""
	 */
	public String getDescription()
	{
		return this.description; 
	}
	/**
	 * 设置 人员描述, 类型String 默认值:""
	 *
	 * @param sDescription
	 *            人员描述, 类型String 默认值:""
	 */
	public void setDescription(String sDescription)
	{
		this.description = sDescription; 
	}
	// 设置和获取 人员描述, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 通讯地址, 默认值:""
	// 设置和获取 通讯地址,类型String 默认值:"" 开始
	private String address = "";
	/**
	* 获取 通讯地址, 类型String 默认值:""
	 *
	 * @return 通讯地址, 类型String 默认值:""
	 */
	public String getAddress()
	{
		return this.address; 
	}
	/**
	 * 设置 通讯地址, 类型String 默认值:""
	 *
	 * @param sAddress
	 *            通讯地址, 类型String 默认值:""
	 */
	public void setAddress(String sAddress)
	{
		this.address = sAddress; 
	}
	// 设置和获取 通讯地址, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 限定IP, 默认值:""
	// 设置和获取 限定IP,类型String 默认值:"" 开始
	private String limitIp = "";
	/**
	* 获取 限定IP, 类型String 默认值:""
	 *
	 * @return 限定IP, 类型String 默认值:""
	 */
	public String getLimitIp()
	{
		return this.limitIp; 
	}
	/**
	 * 设置 限定IP, 类型String 默认值:""
	 *
	 * @param sLimitIp
	 *            限定IP, 类型String 默认值:""
	 */
	public void setLimitIp(String sLimitIp)
	{
		this.limitIp = sLimitIp; 
	}
	// 设置和获取 限定IP, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 最后登录时间, 默认值:new Date()
	// 设置和获取 最后登录时间,类型Date 默认值:new Date() 开始
	private Date lastLogintime = new Date();
	/**
	* 获取 最后登录时间, 类型Date 默认值:new Date()
	 *
	 * @return 最后登录时间, 类型Date 默认值:new Date()
	 */
	public Date getLastLogintime()
	{
		if (!(this.lastLogintime instanceof MyDate))
			this.lastLogintime = MyDate.setDate(this.lastLogintime);
		return this.lastLogintime; 
	}
	/**
	 * 设置 最后登录时间, 类型Date 默认值:new Date()
	 *
	 * @param sLastLogintime
	 *            最后登录时间, 类型Date 默认值:new Date()
	 */
	public void setLastLogintime(Date sLastLogintime)
	{
		this.lastLogintime = sLastLogintime; 
	}
	// 设置和获取 最后登录时间, 类型Date 默认值:new Date() 结束
        // [end]


        // [start] 设置和获取 最后登录IP, 默认值:""
	// 设置和获取 最后登录IP,类型String 默认值:"" 开始
	private String lastLoginip = "";
	/**
	* 获取 最后登录IP, 类型String 默认值:""
	 *
	 * @return 最后登录IP, 类型String 默认值:""
	 */
	public String getLastLoginip()
	{
		return this.lastLoginip; 
	}
	/**
	 * 设置 最后登录IP, 类型String 默认值:""
	 *
	 * @param sLastLoginip
	 *            最后登录IP, 类型String 默认值:""
	 */
	public void setLastLoginip(String sLastLoginip)
	{
		this.lastLoginip = sLastLoginip; 
	}
	// 设置和获取 最后登录IP, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 创建时间, 默认值:new Date()
	// 设置和获取 创建时间,类型Date 默认值:new Date() 开始
	private Date createTime = new Date();
	/**
	* 获取 创建时间, 类型Date 默认值:new Date()
	 *
	 * @return 创建时间, 类型Date 默认值:new Date()
	 */
	public Date getCreateTime()
	{
		if (!(this.createTime instanceof MyDate))
			this.createTime = MyDate.setDate(this.createTime);
		return this.createTime; 
	}
	/**
	 * 设置 创建时间, 类型Date 默认值:new Date()
	 *
	 * @param sCreateTime
	 *            创建时间, 类型Date 默认值:new Date()
	 */
	public void setCreateTime(Date sCreateTime)
	{
		this.createTime = sCreateTime; 
	}
	// 设置和获取 创建时间, 类型Date 默认值:new Date() 结束
        // [end]


        // [start] 设置和获取 最后修改时间, 默认值:new Date()
	// 设置和获取 最后修改时间,类型Date 默认值:new Date() 开始
	private Date lastModifytime = new Date();
	/**
	* 获取 最后修改时间, 类型Date 默认值:new Date()
	 *
	 * @return 最后修改时间, 类型Date 默认值:new Date()
	 */
	public Date getLastModifytime()
	{
		if (!(this.lastModifytime instanceof MyDate))
			this.lastModifytime = MyDate.setDate(this.lastModifytime);
		return this.lastModifytime; 
	}
	/**
	 * 设置 最后修改时间, 类型Date 默认值:new Date()
	 *
	 * @param sLastModifytime
	 *            最后修改时间, 类型Date 默认值:new Date()
	 */
	public void setLastModifytime(Date sLastModifytime)
	{
		this.lastModifytime = sLastModifytime; 
	}
	// 设置和获取 最后修改时间, 类型Date 默认值:new Date() 结束
        // [end]


        // [start] 设置和获取 启用标志：1-启用、2-未启用, 默认值:0
	// 设置和获取 启用标志：1-启用、2-未启用,类型int 默认值:0 开始
	private int isUse = 0;
	/**
	* 获取 启用标志：1-启用、2-未启用, 类型int 默认值:0
	 *
	 * @return 启用标志：1-启用、2-未启用, 类型int 默认值:0
	 */
	public int getIsUse()
	{
		return this.isUse; 
	}
	/**
	 * 设置 启用标志：1-启用、2-未启用, 类型int 默认值:0
	 *
	 * @param sIsUse
	 *            启用标志：1-启用、2-未启用, 类型int 默认值:0
	 */
	public void setIsUse(int sIsUse)
	{
		this.isUse = sIsUse; 
	}
	// 设置和获取 启用标志：1-启用、2-未启用, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 是否删除：1-未删除、2-已删除, 默认值:0
	// 设置和获取 是否删除：1-未删除、2-已删除,类型int 默认值:0 开始
	private int isDel = 0;
	/**
	* 获取 是否删除：1-未删除、2-已删除, 类型int 默认值:0
	 *
	 * @return 是否删除：1-未删除、2-已删除, 类型int 默认值:0
	 */
	public int getIsDel()
	{
		return this.isDel; 
	}
	/**
	 * 设置 是否删除：1-未删除、2-已删除, 类型int 默认值:0
	 *
	 * @param sIsDel
	 *            是否删除：1-未删除、2-已删除, 类型int 默认值:0
	 */
	public void setIsDel(int sIsDel)
	{
		this.isDel = sIsDel; 
	}
	// 设置和获取 是否删除：1-未删除、2-已删除, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 拥有权限, 默认值:""
	// 设置和获取 拥有权限,类型String 默认值:"" 开始
	private String competence = "";
	/**
	* 获取 拥有权限, 类型String 默认值:""
	 *
	 * @return 拥有权限, 类型String 默认值:""
	 */
	public String getCompetence()
	{
		return this.competence; 
	}
	/**
	 * 设置 拥有权限, 类型String 默认值:""
	 *
	 * @param sCompetence
	 *            拥有权限, 类型String 默认值:""
	 */
	public void setCompetence(String sCompetence)
	{
		this.competence = sCompetence; 
	}
	// 设置和获取 拥有权限, 类型String 默认值:"" 结束
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
            sbStr.append(getDatabaseadminid()).append(strSplit);
            sbStr.append(getAdminid()).append(strSplit);
            sbStr.append(getAdminname()).append(strSplit);
            sbStr.append(getAdminpassword()).append(strSplit);
            sbStr.append(getSex()).append(strSplit);
            sbStr.append(getTruename()).append(strSplit);
            sbStr.append(getWorkno()).append(strSplit);
            sbStr.append(getEmail()).append(strSplit);
            sbStr.append(getMovephone()).append(strSplit);
            sbStr.append(getPhone()).append(strSplit);
            sbStr.append(getMsn()).append(strSplit);
            sbStr.append(getRolesid()).append(strSplit);
            sbStr.append(getSectorid()).append(strSplit);
            sbStr.append(getDescription()).append(strSplit);
            sbStr.append(getAddress()).append(strSplit);
            sbStr.append(getLimitIp()).append(strSplit);
            sbStr.append(getLastLogintime()).append(strSplit);
            sbStr.append(getLastLoginip()).append(strSplit);
            sbStr.append(getCreateTime()).append(strSplit);
            sbStr.append(getLastModifytime()).append(strSplit);
            sbStr.append(getIsUse()).append(strSplit);
            sbStr.append(getIsDel()).append(strSplit);
            sbStr.append(getCompetence()).append(strSplit);

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

            if (objs.length != 23)
            {
                return;
            }
            if (objs[0] != null || objs[0].length() >= 1)
            {
                setDatabaseadminid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setAdminid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setAdminname(com.colorwinglib.Converts.objToStr(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setAdminpassword(com.colorwinglib.Converts.objToStr(objs[3]));
            }
            if (objs[4] != null || objs[4].length() >= 1)
            {
                setSex(com.colorwinglib.Converts.StrToInt(objs[4]));
            }
            if (objs[5] != null || objs[5].length() >= 1)
            {
                setTruename(com.colorwinglib.Converts.objToStr(objs[5]));
            }
            if (objs[6] != null || objs[6].length() >= 1)
            {
                setWorkno(com.colorwinglib.Converts.objToStr(objs[6]));
            }
            if (objs[7] != null || objs[7].length() >= 1)
            {
                setEmail(com.colorwinglib.Converts.objToStr(objs[7]));
            }
            if (objs[8] != null || objs[8].length() >= 1)
            {
                setMovephone(com.colorwinglib.Converts.objToStr(objs[8]));
            }
            if (objs[9] != null || objs[9].length() >= 1)
            {
                setPhone(com.colorwinglib.Converts.objToStr(objs[9]));
            }
            if (objs[10] != null || objs[10].length() >= 1)
            {
                setMsn(com.colorwinglib.Converts.objToStr(objs[10]));
            }
            if (objs[11] != null || objs[11].length() >= 1)
            {
                setRolesid(com.colorwinglib.Converts.StrToInt(objs[11]));
            }
            if (objs[12] != null || objs[12].length() >= 1)
            {
                setSectorid(com.colorwinglib.Converts.StrToInt(objs[12]));
            }
            if (objs[13] != null || objs[13].length() >= 1)
            {
                setDescription(com.colorwinglib.Converts.objToStr(objs[13]));
            }
            if (objs[14] != null || objs[14].length() >= 1)
            {
                setAddress(com.colorwinglib.Converts.objToStr(objs[14]));
            }
            if (objs[15] != null || objs[15].length() >= 1)
            {
                setLimitIp(com.colorwinglib.Converts.objToStr(objs[15]));
            }
            if (objs[16] != null || objs[16].length() >= 1)
            {
                setLastLogintime(com.colorwinglib.Converts.StrToDate(objs[16]));
            }
            if (objs[17] != null || objs[17].length() >= 1)
            {
                setLastLoginip(com.colorwinglib.Converts.objToStr(objs[17]));
            }
            if (objs[18] != null || objs[18].length() >= 1)
            {
                setCreateTime(com.colorwinglib.Converts.StrToDate(objs[18]));
            }
            if (objs[19] != null || objs[19].length() >= 1)
            {
                setLastModifytime(com.colorwinglib.Converts.StrToDate(objs[19]));
            }
            if (objs[20] != null || objs[20].length() >= 1)
            {
                setIsUse(com.colorwinglib.Converts.StrToInt(objs[20]));
            }
            if (objs[21] != null || objs[21].length() >= 1)
            {
                setIsDel(com.colorwinglib.Converts.StrToInt(objs[21]));
            }
            if (objs[22] != null || objs[22].length() >= 1)
            {
                setCompetence(com.colorwinglib.Converts.objToStr(objs[22]));
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
            sbStr.append("&Databaseadminid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseadminid()));//人员ID
            sbStr.append("&Adminid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminid()));//人员编号
            sbStr.append("&Adminname=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminname()));//帐号
            sbStr.append("&Adminpassword=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminpassword()));//密码
            sbStr.append("&Sex=").append(com.colorwinglib.StringFormat.UrlEncode(getSex()));//性别：1-男、2-女
            sbStr.append("&Truename=").append(com.colorwinglib.StringFormat.UrlEncode(getTruename()));//姓名
            sbStr.append("&Workno=").append(com.colorwinglib.StringFormat.UrlEncode(getWorkno()));//工号
            sbStr.append("&Email=").append(com.colorwinglib.StringFormat.UrlEncode(getEmail()));//联系EMAIL
            sbStr.append("&Movephone=").append(com.colorwinglib.StringFormat.UrlEncode(getMovephone()));//移动电话
            sbStr.append("&Phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//电话
            sbStr.append("&Msn=").append(com.colorwinglib.StringFormat.UrlEncode(getMsn()));//MSN
            sbStr.append("&Rolesid=").append(com.colorwinglib.StringFormat.UrlEncode(getRolesid()));//角色编号
            sbStr.append("&Sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//部门编号
            sbStr.append("&Description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//人员描述
            sbStr.append("&Address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//通讯地址
            sbStr.append("&LimitIp=").append(com.colorwinglib.StringFormat.UrlEncode(getLimitIp()));//限定IP
            sbStr.append("&LastLogintime=").append(com.colorwinglib.StringFormat.UrlEncode(getLastLogintime()));//最后登录时间
            sbStr.append("&LastLoginip=").append(com.colorwinglib.StringFormat.UrlEncode(getLastLoginip()));//最后登录IP
            sbStr.append("&CreateTime=").append(com.colorwinglib.StringFormat.UrlEncode(getCreateTime()));//创建时间
            sbStr.append("&LastModifytime=").append(com.colorwinglib.StringFormat.UrlEncode(getLastModifytime()));//最后修改时间
            sbStr.append("&IsUse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsUse()));//启用标志：1-启用、2-未启用
            sbStr.append("&IsDel=").append(com.colorwinglib.StringFormat.UrlEncode(getIsDel()));//是否删除：1-未删除、2-已删除
            sbStr.append("&Competence=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetence()));//拥有权限

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
			if (columnName.equals("Databaseadminid"))
				sbStr.append("&Databaseadminid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseadminid()));//人员ID
			if (columnName.equals("Adminid"))
				sbStr.append("&Adminid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminid()));//人员编号
			if (columnName.equals("Adminname"))
				sbStr.append("&Adminname=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminname()));//帐号
			if (columnName.equals("Adminpassword"))
				sbStr.append("&Adminpassword=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminpassword()));//密码
			if (columnName.equals("Sex"))
				sbStr.append("&Sex=").append(com.colorwinglib.StringFormat.UrlEncode(getSex()));//性别：1-男、2-女
			if (columnName.equals("Truename"))
				sbStr.append("&Truename=").append(com.colorwinglib.StringFormat.UrlEncode(getTruename()));//姓名
			if (columnName.equals("Workno"))
				sbStr.append("&Workno=").append(com.colorwinglib.StringFormat.UrlEncode(getWorkno()));//工号
			if (columnName.equals("Email"))
				sbStr.append("&Email=").append(com.colorwinglib.StringFormat.UrlEncode(getEmail()));//联系EMAIL
			if (columnName.equals("Movephone"))
				sbStr.append("&Movephone=").append(com.colorwinglib.StringFormat.UrlEncode(getMovephone()));//移动电话
			if (columnName.equals("Phone"))
				sbStr.append("&Phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//电话
			if (columnName.equals("Msn"))
				sbStr.append("&Msn=").append(com.colorwinglib.StringFormat.UrlEncode(getMsn()));//MSN
			if (columnName.equals("Rolesid"))
				sbStr.append("&Rolesid=").append(com.colorwinglib.StringFormat.UrlEncode(getRolesid()));//角色编号
			if (columnName.equals("Sectorid"))
				sbStr.append("&Sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//部门编号
			if (columnName.equals("Description"))
				sbStr.append("&Description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//人员描述
			if (columnName.equals("Address"))
				sbStr.append("&Address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//通讯地址
			if (columnName.equals("LimitIp"))
				sbStr.append("&LimitIp=").append(com.colorwinglib.StringFormat.UrlEncode(getLimitIp()));//限定IP
			if (columnName.equals("LastLogintime"))
				sbStr.append("&LastLogintime=").append(com.colorwinglib.StringFormat.UrlEncode(getLastLogintime()));//最后登录时间
			if (columnName.equals("LastLoginip"))
				sbStr.append("&LastLoginip=").append(com.colorwinglib.StringFormat.UrlEncode(getLastLoginip()));//最后登录IP
			if (columnName.equals("CreateTime"))
				sbStr.append("&CreateTime=").append(com.colorwinglib.StringFormat.UrlEncode(getCreateTime()));//创建时间
			if (columnName.equals("LastModifytime"))
				sbStr.append("&LastModifytime=").append(com.colorwinglib.StringFormat.UrlEncode(getLastModifytime()));//最后修改时间
			if (columnName.equals("IsUse"))
				sbStr.append("&IsUse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsUse()));//启用标志：1-启用、2-未启用
			if (columnName.equals("IsDel"))
				sbStr.append("&IsDel=").append(com.colorwinglib.StringFormat.UrlEncode(getIsDel()));//是否删除：1-未删除、2-已删除
			if (columnName.equals("Competence"))
				sbStr.append("&Competence=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetence()));//拥有权限
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
            sbStr.append("&databaseadminid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseadminid()));//人员ID
            sbStr.append("&adminid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminid()));//人员编号
            sbStr.append("&adminname=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminname()));//帐号
            sbStr.append("&adminpassword=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminpassword()));//密码
            sbStr.append("&sex=").append(com.colorwinglib.StringFormat.UrlEncode(getSex()));//性别：1-男、2-女
            sbStr.append("&truename=").append(com.colorwinglib.StringFormat.UrlEncode(getTruename()));//姓名
            sbStr.append("&workno=").append(com.colorwinglib.StringFormat.UrlEncode(getWorkno()));//工号
            sbStr.append("&email=").append(com.colorwinglib.StringFormat.UrlEncode(getEmail()));//联系EMAIL
            sbStr.append("&movephone=").append(com.colorwinglib.StringFormat.UrlEncode(getMovephone()));//移动电话
            sbStr.append("&phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//电话
            sbStr.append("&msn=").append(com.colorwinglib.StringFormat.UrlEncode(getMsn()));//MSN
            sbStr.append("&rolesid=").append(com.colorwinglib.StringFormat.UrlEncode(getRolesid()));//角色编号
            sbStr.append("&sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//部门编号
            sbStr.append("&description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//人员描述
            sbStr.append("&address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//通讯地址
            sbStr.append("&limitIp=").append(com.colorwinglib.StringFormat.UrlEncode(getLimitIp()));//限定IP
            sbStr.append("&lastLogintime=").append(com.colorwinglib.StringFormat.UrlEncode(getLastLogintime()));//最后登录时间
            sbStr.append("&lastLoginip=").append(com.colorwinglib.StringFormat.UrlEncode(getLastLoginip()));//最后登录IP
            sbStr.append("&createTime=").append(com.colorwinglib.StringFormat.UrlEncode(getCreateTime()));//创建时间
            sbStr.append("&lastModifytime=").append(com.colorwinglib.StringFormat.UrlEncode(getLastModifytime()));//最后修改时间
            sbStr.append("&isUse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsUse()));//启用标志：1-启用、2-未启用
            sbStr.append("&isDel=").append(com.colorwinglib.StringFormat.UrlEncode(getIsDel()));//是否删除：1-未删除、2-已删除
            sbStr.append("&competence=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetence()));//拥有权限

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
			if (columnName.equals("Databaseadminid"))
				sbStr.append("&databaseadminid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseadminid()));//人员ID
			if (columnName.equals("Adminid"))
				sbStr.append("&adminid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminid()));//人员编号
			if (columnName.equals("Adminname"))
				sbStr.append("&adminname=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminname()));//帐号
			if (columnName.equals("Adminpassword"))
				sbStr.append("&adminpassword=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminpassword()));//密码
			if (columnName.equals("Sex"))
				sbStr.append("&sex=").append(com.colorwinglib.StringFormat.UrlEncode(getSex()));//性别：1-男、2-女
			if (columnName.equals("Truename"))
				sbStr.append("&truename=").append(com.colorwinglib.StringFormat.UrlEncode(getTruename()));//姓名
			if (columnName.equals("Workno"))
				sbStr.append("&workno=").append(com.colorwinglib.StringFormat.UrlEncode(getWorkno()));//工号
			if (columnName.equals("Email"))
				sbStr.append("&email=").append(com.colorwinglib.StringFormat.UrlEncode(getEmail()));//联系EMAIL
			if (columnName.equals("Movephone"))
				sbStr.append("&movephone=").append(com.colorwinglib.StringFormat.UrlEncode(getMovephone()));//移动电话
			if (columnName.equals("Phone"))
				sbStr.append("&phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//电话
			if (columnName.equals("Msn"))
				sbStr.append("&msn=").append(com.colorwinglib.StringFormat.UrlEncode(getMsn()));//MSN
			if (columnName.equals("Rolesid"))
				sbStr.append("&rolesid=").append(com.colorwinglib.StringFormat.UrlEncode(getRolesid()));//角色编号
			if (columnName.equals("Sectorid"))
				sbStr.append("&sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//部门编号
			if (columnName.equals("Description"))
				sbStr.append("&description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//人员描述
			if (columnName.equals("Address"))
				sbStr.append("&address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//通讯地址
			if (columnName.equals("LimitIp"))
				sbStr.append("&limitIp=").append(com.colorwinglib.StringFormat.UrlEncode(getLimitIp()));//限定IP
			if (columnName.equals("LastLogintime"))
				sbStr.append("&lastLogintime=").append(com.colorwinglib.StringFormat.UrlEncode(getLastLogintime()));//最后登录时间
			if (columnName.equals("LastLoginip"))
				sbStr.append("&lastLoginip=").append(com.colorwinglib.StringFormat.UrlEncode(getLastLoginip()));//最后登录IP
			if (columnName.equals("CreateTime"))
				sbStr.append("&createTime=").append(com.colorwinglib.StringFormat.UrlEncode(getCreateTime()));//创建时间
			if (columnName.equals("LastModifytime"))
				sbStr.append("&lastModifytime=").append(com.colorwinglib.StringFormat.UrlEncode(getLastModifytime()));//最后修改时间
			if (columnName.equals("IsUse"))
				sbStr.append("&isUse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsUse()));//启用标志：1-启用、2-未启用
			if (columnName.equals("IsDel"))
				sbStr.append("&isDel=").append(com.colorwinglib.StringFormat.UrlEncode(getIsDel()));//是否删除：1-未删除、2-已删除
			if (columnName.equals("Competence"))
				sbStr.append("&competence=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetence()));//拥有权限
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
	public static SystemAdminInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			SystemAdminInfo obj = (SystemAdminInfo) in.readObject();
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
	public String ToModifyString(SystemAdminInfo objOld)
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
	public String ToModifyString(SystemAdminInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getDatabaseadminid(), objOld.getDatabaseadminid()))
			sbStr.append("Databaseadminid 人员ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabaseadminid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabaseadminid())).append("]").append(strSplit);// 人员ID
		if (com.colorwinglib.Validate.isEquals(getAdminid(), objOld.getAdminid()))
			sbStr.append("Adminid 人员编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getAdminid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAdminid())).append("]").append(strSplit);// 人员编号
		if (com.colorwinglib.Validate.isEquals(getAdminname(), objOld.getAdminname()))
			sbStr.append("Adminname 帐号:[").append(com.colorwinglib.Converts.objToStr(objOld.getAdminname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAdminname())).append("]").append(strSplit);// 帐号
		if (com.colorwinglib.Validate.isEquals(getAdminpassword(), objOld.getAdminpassword()))
			sbStr.append("Adminpassword 密码:[").append(com.colorwinglib.Converts.objToStr(objOld.getAdminpassword())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAdminpassword())).append("]").append(strSplit);// 密码
		if (com.colorwinglib.Validate.isEquals(getSex(), objOld.getSex()))
			sbStr.append("Sex 性别：1-男、2-女:[").append(com.colorwinglib.Converts.objToStr(objOld.getSex())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getSex())).append("]").append(strSplit);// 性别：1-男、2-女
		if (com.colorwinglib.Validate.isEquals(getTruename(), objOld.getTruename()))
			sbStr.append("Truename 姓名:[").append(com.colorwinglib.Converts.objToStr(objOld.getTruename())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getTruename())).append("]").append(strSplit);// 姓名
		if (com.colorwinglib.Validate.isEquals(getWorkno(), objOld.getWorkno()))
			sbStr.append("Workno 工号:[").append(com.colorwinglib.Converts.objToStr(objOld.getWorkno())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getWorkno())).append("]").append(strSplit);// 工号
		if (com.colorwinglib.Validate.isEquals(getEmail(), objOld.getEmail()))
			sbStr.append("Email 联系EMAIL:[").append(com.colorwinglib.Converts.objToStr(objOld.getEmail())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getEmail())).append("]").append(strSplit);// 联系EMAIL
		if (com.colorwinglib.Validate.isEquals(getMovephone(), objOld.getMovephone()))
			sbStr.append("Movephone 移动电话:[").append(com.colorwinglib.Converts.objToStr(objOld.getMovephone())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getMovephone())).append("]").append(strSplit);// 移动电话
		if (com.colorwinglib.Validate.isEquals(getPhone(), objOld.getPhone()))
			sbStr.append("Phone 电话:[").append(com.colorwinglib.Converts.objToStr(objOld.getPhone())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPhone())).append("]").append(strSplit);// 电话
		if (com.colorwinglib.Validate.isEquals(getMsn(), objOld.getMsn()))
			sbStr.append("Msn MSN:[").append(com.colorwinglib.Converts.objToStr(objOld.getMsn())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getMsn())).append("]").append(strSplit);// MSN
		if (com.colorwinglib.Validate.isEquals(getRolesid(), objOld.getRolesid()))
			sbStr.append("Rolesid 角色编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getRolesid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getRolesid())).append("]").append(strSplit);// 角色编号
		if (com.colorwinglib.Validate.isEquals(getSectorid(), objOld.getSectorid()))
			sbStr.append("Sectorid 部门编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getSectorid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getSectorid())).append("]").append(strSplit);// 部门编号
		if (com.colorwinglib.Validate.isEquals(getDescription(), objOld.getDescription()))
			sbStr.append("Description 人员描述:[").append(com.colorwinglib.Converts.objToStr(objOld.getDescription())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDescription())).append("]").append(strSplit);// 人员描述
		if (com.colorwinglib.Validate.isEquals(getAddress(), objOld.getAddress()))
			sbStr.append("Address 通讯地址:[").append(com.colorwinglib.Converts.objToStr(objOld.getAddress())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAddress())).append("]").append(strSplit);// 通讯地址
		if (com.colorwinglib.Validate.isEquals(getLimitIp(), objOld.getLimitIp()))
			sbStr.append("LimitIp 限定IP:[").append(com.colorwinglib.Converts.objToStr(objOld.getLimitIp())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getLimitIp())).append("]").append(strSplit);// 限定IP
		if (com.colorwinglib.Validate.isEquals(getLastLogintime(), objOld.getLastLogintime()))
			sbStr.append("LastLogintime 最后登录时间:[").append(com.colorwinglib.Converts.objToStr(objOld.getLastLogintime())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getLastLogintime())).append("]").append(strSplit);// 最后登录时间
		if (com.colorwinglib.Validate.isEquals(getLastLoginip(), objOld.getLastLoginip()))
			sbStr.append("LastLoginip 最后登录IP:[").append(com.colorwinglib.Converts.objToStr(objOld.getLastLoginip())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getLastLoginip())).append("]").append(strSplit);// 最后登录IP
		if (com.colorwinglib.Validate.isEquals(getCreateTime(), objOld.getCreateTime()))
			sbStr.append("CreateTime 创建时间:[").append(com.colorwinglib.Converts.objToStr(objOld.getCreateTime())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getCreateTime())).append("]").append(strSplit);// 创建时间
		if (com.colorwinglib.Validate.isEquals(getLastModifytime(), objOld.getLastModifytime()))
			sbStr.append("LastModifytime 最后修改时间:[").append(com.colorwinglib.Converts.objToStr(objOld.getLastModifytime())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getLastModifytime())).append("]").append(strSplit);// 最后修改时间
		if (com.colorwinglib.Validate.isEquals(getIsUse(), objOld.getIsUse()))
			sbStr.append("IsUse 启用标志：1-启用、2-未启用:[").append(com.colorwinglib.Converts.objToStr(objOld.getIsUse())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getIsUse())).append("]").append(strSplit);// 启用标志：1-启用、2-未启用
		if (com.colorwinglib.Validate.isEquals(getIsDel(), objOld.getIsDel()))
			sbStr.append("IsDel 是否删除：1-未删除、2-已删除:[").append(com.colorwinglib.Converts.objToStr(objOld.getIsDel())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getIsDel())).append("]").append(strSplit);// 是否删除：1-未删除、2-已删除
		if (com.colorwinglib.Validate.isEquals(getCompetence(), objOld.getCompetence()))
			sbStr.append("Competence 拥有权限:[").append(com.colorwinglib.Converts.objToStr(objOld.getCompetence())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getCompetence())).append("]").append(strSplit);// 拥有权限
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
			json.put("Databaseadminid", getDatabaseadminid());// 人员ID
			json.put("Adminid", getAdminid());// 人员编号
			json.put("Adminname", getAdminname());// 帐号
			json.put("Adminpassword", getAdminpassword());// 密码
			json.put("Sex", getSex());// 性别：1-男、2-女
			json.put("Truename", getTruename());// 姓名
			json.put("Workno", getWorkno());// 工号
			json.put("Email", getEmail());// 联系EMAIL
			json.put("Movephone", getMovephone());// 移动电话
			json.put("Phone", getPhone());// 电话
			json.put("Msn", getMsn());// MSN
			json.put("Rolesid", getRolesid());// 角色编号
			json.put("Sectorid", getSectorid());// 部门编号
			json.put("Description", getDescription());// 人员描述
			json.put("Address", getAddress());// 通讯地址
			json.put("LimitIp", getLimitIp());// 限定IP
			json.put("LastLogintime", getLastLogintime());// 最后登录时间
			json.put("LastLoginip", getLastLoginip());// 最后登录IP
			json.put("CreateTime", getCreateTime());// 创建时间
			json.put("LastModifytime", getLastModifytime());// 最后修改时间
			json.put("IsUse", getIsUse());// 启用标志：1-启用、2-未启用
			json.put("IsDel", getIsDel());// 是否删除：1-未删除、2-已删除
			json.put("Competence", getCompetence());// 拥有权限
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
			setDatabaseadminid(json.getInt("Databaseadminid"));// 人员ID
			setAdminid(json.getInt("Adminid"));// 人员编号
			setAdminname(json.getString("Adminname"));// 帐号
			setAdminpassword(json.getString("Adminpassword"));// 密码
			setSex(json.getInt("Sex"));// 性别：1-男、2-女
			setTruename(json.getString("Truename"));// 姓名
			setWorkno(json.getString("Workno"));// 工号
			setEmail(json.getString("Email"));// 联系EMAIL
			setMovephone(json.getString("Movephone"));// 移动电话
			setPhone(json.getString("Phone"));// 电话
			setMsn(json.getString("Msn"));// MSN
			setRolesid(json.getInt("Rolesid"));// 角色编号
			setSectorid(json.getInt("Sectorid"));// 部门编号
			setDescription(json.getString("Description"));// 人员描述
			setAddress(json.getString("Address"));// 通讯地址
			setLimitIp(json.getString("LimitIp"));// 限定IP
			setLastLogintime(com.colorwinglib.Converts.StrToDate(json.getString("LastLogintime")));// 最后登录时间
			setLastLoginip(json.getString("LastLoginip"));// 最后登录IP
			setCreateTime(com.colorwinglib.Converts.StrToDate(json.getString("CreateTime")));// 创建时间
			setLastModifytime(com.colorwinglib.Converts.StrToDate(json.getString("LastModifytime")));// 最后修改时间
			setIsUse(json.getInt("IsUse"));// 启用标志：1-启用、2-未启用
			setIsDel(json.getInt("IsDel"));// 是否删除：1-未删除、2-已删除
			setCompetence(json.getString("Competence"));// 拥有权限

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
		sbStr.append("<SystemAdminInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //人员ID
			sbStr.append("    <Databaseadminid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabaseadminid()));
			sbStr.append("</Databaseadminid>\n");
            //人员编号
			sbStr.append("    <Adminid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAdminid()));
			sbStr.append("</Adminid>\n");
            //帐号
			sbStr.append("    <Adminname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAdminname()));
			sbStr.append("</Adminname>\n");
            //密码
			sbStr.append("    <Adminpassword>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAdminpassword()));
			sbStr.append("</Adminpassword>\n");
            //性别：1-男、2-女
			sbStr.append("    <Sex>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getSex()));
			sbStr.append("</Sex>\n");
            //姓名
			sbStr.append("    <Truename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getTruename()));
			sbStr.append("</Truename>\n");
            //工号
			sbStr.append("    <Workno>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getWorkno()));
			sbStr.append("</Workno>\n");
            //联系EMAIL
			sbStr.append("    <Email>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getEmail()));
			sbStr.append("</Email>\n");
            //移动电话
			sbStr.append("    <Movephone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getMovephone()));
			sbStr.append("</Movephone>\n");
            //电话
			sbStr.append("    <Phone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPhone()));
			sbStr.append("</Phone>\n");
            //MSN
			sbStr.append("    <Msn>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getMsn()));
			sbStr.append("</Msn>\n");
            //角色编号
			sbStr.append("    <Rolesid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getRolesid()));
			sbStr.append("</Rolesid>\n");
            //部门编号
			sbStr.append("    <Sectorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getSectorid()));
			sbStr.append("</Sectorid>\n");
            //人员描述
			sbStr.append("    <Description>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDescription()));
			sbStr.append("</Description>\n");
            //通讯地址
			sbStr.append("    <Address>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAddress()));
			sbStr.append("</Address>\n");
            //限定IP
			sbStr.append("    <LimitIp>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getLimitIp()));
			sbStr.append("</LimitIp>\n");
            //最后登录时间
			sbStr.append("    <LastLogintime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getLastLogintime()));
			sbStr.append("</LastLogintime>\n");
            //最后登录IP
			sbStr.append("    <LastLoginip>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getLastLoginip()));
			sbStr.append("</LastLoginip>\n");
            //创建时间
			sbStr.append("    <CreateTime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getCreateTime()));
			sbStr.append("</CreateTime>\n");
            //最后修改时间
			sbStr.append("    <LastModifytime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getLastModifytime()));
			sbStr.append("</LastModifytime>\n");
            //启用标志：1-启用、2-未启用
			sbStr.append("    <IsUse>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getIsUse()));
			sbStr.append("</IsUse>\n");
            //是否删除：1-未删除、2-已删除
			sbStr.append("    <IsDel>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getIsDel()));
			sbStr.append("</IsDel>\n");
            //拥有权限
			sbStr.append("    <Competence>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getCompetence()));
			sbStr.append("</Competence>\n");
		sbStr.append("</SystemAdminInfo>\n");
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
	// GetSystemAdminInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetSystemAdminInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static SystemAdminInfo GetSystemAdminInfoFormFileName(String filename)
	{
		return GetSystemAdminInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemAdminInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemAdminInfo GetSystemAdminInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetSystemAdminInfoFormXml(xml, encoding);
	}

	// [end]

	// GetSystemAdminInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetSystemAdminInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemAdminInfo GetSystemAdminInfoFormXml(String xml)
	{
		return GetSystemAdminInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemAdminInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemAdminInfo GetSystemAdminInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		SystemAdminInfo objSystemAdminInfo = new SystemAdminInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//人员ID
				if (foo.elementText("Databaseadminid") != null)
					objSystemAdminInfo.setDatabaseadminid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseadminid")));
				//人员编号
				if (foo.elementText("Adminid") != null)
					objSystemAdminInfo.setAdminid(com.colorwinglib.Converts.StrToInt(foo.elementText("Adminid")));
				//帐号
				if (foo.elementText("Adminname") != null)
					objSystemAdminInfo.setAdminname(com.colorwinglib.Converts.objToStr(foo.elementText("Adminname")));
				//密码
				if (foo.elementText("Adminpassword") != null)
					objSystemAdminInfo.setAdminpassword(com.colorwinglib.Converts.objToStr(foo.elementText("Adminpassword")));
				//性别：1-男、2-女
				if (foo.elementText("Sex") != null)
					objSystemAdminInfo.setSex(com.colorwinglib.Converts.StrToInt(foo.elementText("Sex")));
				//姓名
				if (foo.elementText("Truename") != null)
					objSystemAdminInfo.setTruename(com.colorwinglib.Converts.objToStr(foo.elementText("Truename")));
				//工号
				if (foo.elementText("Workno") != null)
					objSystemAdminInfo.setWorkno(com.colorwinglib.Converts.objToStr(foo.elementText("Workno")));
				//联系EMAIL
				if (foo.elementText("Email") != null)
					objSystemAdminInfo.setEmail(com.colorwinglib.Converts.objToStr(foo.elementText("Email")));
				//移动电话
				if (foo.elementText("Movephone") != null)
					objSystemAdminInfo.setMovephone(com.colorwinglib.Converts.objToStr(foo.elementText("Movephone")));
				//电话
				if (foo.elementText("Phone") != null)
					objSystemAdminInfo.setPhone(com.colorwinglib.Converts.objToStr(foo.elementText("Phone")));
				//MSN
				if (foo.elementText("Msn") != null)
					objSystemAdminInfo.setMsn(com.colorwinglib.Converts.objToStr(foo.elementText("Msn")));
				//角色编号
				if (foo.elementText("Rolesid") != null)
					objSystemAdminInfo.setRolesid(com.colorwinglib.Converts.StrToInt(foo.elementText("Rolesid")));
				//部门编号
				if (foo.elementText("Sectorid") != null)
					objSystemAdminInfo.setSectorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Sectorid")));
				//人员描述
				if (foo.elementText("Description") != null)
					objSystemAdminInfo.setDescription(com.colorwinglib.Converts.objToStr(foo.elementText("Description")));
				//通讯地址
				if (foo.elementText("Address") != null)
					objSystemAdminInfo.setAddress(com.colorwinglib.Converts.objToStr(foo.elementText("Address")));
				//限定IP
				if (foo.elementText("LimitIp") != null)
					objSystemAdminInfo.setLimitIp(com.colorwinglib.Converts.objToStr(foo.elementText("LimitIp")));
				//最后登录时间
				if (foo.elementText("LastLogintime") != null)
					objSystemAdminInfo.setLastLogintime(com.colorwinglib.Converts.StrToDate(foo.elementText("LastLogintime")));
				//最后登录IP
				if (foo.elementText("LastLoginip") != null)
					objSystemAdminInfo.setLastLoginip(com.colorwinglib.Converts.objToStr(foo.elementText("LastLoginip")));
				//创建时间
				if (foo.elementText("CreateTime") != null)
					objSystemAdminInfo.setCreateTime(com.colorwinglib.Converts.StrToDate(foo.elementText("CreateTime")));
				//最后修改时间
				if (foo.elementText("LastModifytime") != null)
					objSystemAdminInfo.setLastModifytime(com.colorwinglib.Converts.StrToDate(foo.elementText("LastModifytime")));
				//启用标志：1-启用、2-未启用
				if (foo.elementText("IsUse") != null)
					objSystemAdminInfo.setIsUse(com.colorwinglib.Converts.StrToInt(foo.elementText("IsUse")));
				//是否删除：1-未删除、2-已删除
				if (foo.elementText("IsDel") != null)
					objSystemAdminInfo.setIsDel(com.colorwinglib.Converts.StrToInt(foo.elementText("IsDel")));
				//拥有权限
				if (foo.elementText("Competence") != null)
					objSystemAdminInfo.setCompetence(com.colorwinglib.Converts.objToStr(foo.elementText("Competence")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objSystemAdminInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public SystemAdminInfo Copy()
	{
		SystemAdminInfo objSystemAdminInfo = new SystemAdminInfo();
		objSystemAdminInfo.setDatabaseadminid(this.getDatabaseadminid());//人员ID
		objSystemAdminInfo.setAdminid(this.getAdminid());//人员编号
		objSystemAdminInfo.setAdminname(this.getAdminname());//帐号
		objSystemAdminInfo.setAdminpassword(this.getAdminpassword());//密码
		objSystemAdminInfo.setSex(this.getSex());//性别：1-男、2-女
		objSystemAdminInfo.setTruename(this.getTruename());//姓名
		objSystemAdminInfo.setWorkno(this.getWorkno());//工号
		objSystemAdminInfo.setEmail(this.getEmail());//联系EMAIL
		objSystemAdminInfo.setMovephone(this.getMovephone());//移动电话
		objSystemAdminInfo.setPhone(this.getPhone());//电话
		objSystemAdminInfo.setMsn(this.getMsn());//MSN
		objSystemAdminInfo.setRolesid(this.getRolesid());//角色编号
		objSystemAdminInfo.setSectorid(this.getSectorid());//部门编号
		objSystemAdminInfo.setDescription(this.getDescription());//人员描述
		objSystemAdminInfo.setAddress(this.getAddress());//通讯地址
		objSystemAdminInfo.setLimitIp(this.getLimitIp());//限定IP
		objSystemAdminInfo.setLastLogintime(this.getLastLogintime());//最后登录时间
		objSystemAdminInfo.setLastLoginip(this.getLastLoginip());//最后登录IP
		objSystemAdminInfo.setCreateTime(this.getCreateTime());//创建时间
		objSystemAdminInfo.setLastModifytime(this.getLastModifytime());//最后修改时间
		objSystemAdminInfo.setIsUse(this.getIsUse());//启用标志：1-启用、2-未启用
		objSystemAdminInfo.setIsDel(this.getIsDel());//是否删除：1-未删除、2-已删除
		objSystemAdminInfo.setCompetence(this.getCompetence());//拥有权限
		return objSystemAdminInfo;
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
			sexlabel = com.yun.bll.itemcollection.culture.SystemAdminItemCollection.SexText(String.valueOf(getSex()));
		return this.sexlabel; 
	}
        // [end]


        // [start] 设置和获取 启用标志：1-启用、2-未启用, 默认值:0
	private String isUselabel = "";
	/**
	* 获取 启用标志：1-启用、2-未启用, 类型String 默认值:""
	 *
	 * @return 启用标志：1-启用、2-未启用, 类型String 默认值:""
	 */
	public String getIsUselabel()
	{
		if (isUselabel.length() == 0)
			isUselabel = com.yun.bll.itemcollection.culture.SystemAdminItemCollection.IsUseText(String.valueOf(getIsUse()));
		return this.isUselabel; 
	}
        // [end]


        // [start] 设置和获取 是否删除：1-未删除、2-已删除, 默认值:0
	private String isDellabel = "";
	/**
	* 获取 是否删除：1-未删除、2-已删除, 类型String 默认值:""
	 *
	 * @return 是否删除：1-未删除、2-已删除, 类型String 默认值:""
	 */
	public String getIsDellabel()
	{
		if (isDellabel.length() == 0)
			isDellabel = com.yun.bll.itemcollection.culture.SystemAdminItemCollection.IsDelText(String.valueOf(getIsDel()));
		return this.isDellabel; 
	}
        // [end]



	 //[end]
}
