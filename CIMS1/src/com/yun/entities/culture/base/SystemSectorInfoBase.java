
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * SystemSector 部门表的描述
 * 实体类基本类
 */
public class SystemSectorInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311571415635L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public SystemSectorInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public SystemSectorInfoBase(int sSectordatabaseid)
	{
		this.setSectordatabaseid(sSectordatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public SystemSectorInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setSectordatabaseid(rs.getInt("SectordatabaseID"));//部门编号
		setSectorid(rs.getInt("SectorID"));//部门编号
		setSectorname(rs.getString("SectorName"));//部门名称
		setDescription(rs.getString("Description"));//部门描述
		setAddress(rs.getString("Address"));//Address
		setPhone(rs.getString("Phone"));//Phone
		setIsUse(rs.getInt("Is_Use"));//启用标志：1-启用、2-未启用
		setIsDel(rs.getInt("Is_Del"));//是否删除：1-未删除、2-已删除
		setDatabaseunitid(rs.getString("DatabaseUnitID"));//DatabaseUnitID
		setSorts(rs.getDouble("sorts"));//排序
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public SystemSectorInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//部门编号
			if (columnName.equals("SectordatabaseID"))
			{
				setSectordatabaseid(rs.getInt("SectordatabaseID"));
				continue;
			}
			//部门编号
			if (columnName.equals("SectorID"))
			{
				setSectorid(rs.getInt("SectorID"));
				continue;
			}
			//部门名称
			if (columnName.equals("SectorName"))
			{
				setSectorname(rs.getString("SectorName"));
				continue;
			}
			//部门描述
			if (columnName.equals("Description"))
			{
				setDescription(rs.getString("Description"));
				continue;
			}
			//Address
			if (columnName.equals("Address"))
			{
				setAddress(rs.getString("Address"));
				continue;
			}
			//Phone
			if (columnName.equals("Phone"))
			{
				setPhone(rs.getString("Phone"));
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
			//DatabaseUnitID
			if (columnName.equals("DatabaseUnitID"))
			{
				setDatabaseunitid(rs.getString("DatabaseUnitID"));
				continue;
			}
			//排序
			if (columnName.equals("sorts"))
			{
				setSorts(rs.getDouble("sorts"));
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
		if (!(rhs instanceof SystemSectorInfo))
			return false;
		SystemSectorInfo that = (SystemSectorInfo) rhs;

		return (this.getSectordatabaseid() == (that.getSectordatabaseid()));
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

			result = result * 37 + (this.getSectordatabaseid() + "").hashCode();
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
	"SectordatabaseID", //部门编号
	"SectorID", //部门编号
	"SectorName", //部门名称
	"Description", //部门描述
	"Address", //Address
	"Phone", //Phone
	"Is_Use", //启用标志：1-启用、2-未启用
	"Is_Del", //是否删除：1-未删除、2-已删除
	"DatabaseUnitID", //DatabaseUnitID
	"sorts" //排序
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum SystemSectorColumnNameEnum
{
		/**
		 * 部门编号
		 */
		Sectordatabaseid,
		/**
		 * 部门编号
		 */
		Sectorid,
		/**
		 * 部门名称
		 */
		Sectorname,
		/**
		 * 部门描述
		 */
		Description,
		/**
		 * Address
		 */
		Address,
		/**
		 * Phone
		 */
		Phone,
		/**
		 * 启用标志：1-启用、2-未启用
		 */
		IsUse,
		/**
		 * 是否删除：1-未删除、2-已删除
		 */
		IsDel,
		/**
		 * DatabaseUnitID
		 */
		Databaseunitid,
		/**
		 * 排序
		 */
		Sorts
	};
	// [end]
        // [start] 设置和获取 部门编号, 默认值:0
	// 设置和获取 部门编号,类型int 默认值:0 开始
	private int sectordatabaseid = 0;
	/**
	* 获取 部门编号, 类型int 默认值:0
	 *
	 * @return 部门编号, 类型int 默认值:0
	 */
	public int getSectordatabaseid()
	{
		return this.sectordatabaseid; 
	}
	/**
	 * 设置 部门编号, 类型int 默认值:0
	 *
	 * @param sSectordatabaseid
	 *            部门编号, 类型int 默认值:0
	 */
	public void setSectordatabaseid(int sSectordatabaseid)
	{
		this.sectordatabaseid = sSectordatabaseid; 
	}
	// 设置和获取 部门编号, 类型int 默认值:0 结束
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


        // [start] 设置和获取 部门名称, 默认值:""
	// 设置和获取 部门名称,类型String 默认值:"" 开始
	private String sectorname = "";
	/**
	* 获取 部门名称, 类型String 默认值:""
	 *
	 * @return 部门名称, 类型String 默认值:""
	 */
	public String getSectorname()
	{
		return this.sectorname; 
	}
	/**
	 * 设置 部门名称, 类型String 默认值:""
	 *
	 * @param sSectorname
	 *            部门名称, 类型String 默认值:""
	 */
	public void setSectorname(String sSectorname)
	{
		this.sectorname = sSectorname; 
	}
	// 设置和获取 部门名称, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 部门描述, 默认值:""
	// 设置和获取 部门描述,类型String 默认值:"" 开始
	private String description = "";
	/**
	* 获取 部门描述, 类型String 默认值:""
	 *
	 * @return 部门描述, 类型String 默认值:""
	 */
	public String getDescription()
	{
		return this.description; 
	}
	/**
	 * 设置 部门描述, 类型String 默认值:""
	 *
	 * @param sDescription
	 *            部门描述, 类型String 默认值:""
	 */
	public void setDescription(String sDescription)
	{
		this.description = sDescription; 
	}
	// 设置和获取 部门描述, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 Address, 默认值:""
	// 设置和获取 Address,类型String 默认值:"" 开始
	private String address = "";
	/**
	* 获取 Address, 类型String 默认值:""
	 *
	 * @return Address, 类型String 默认值:""
	 */
	public String getAddress()
	{
		return this.address; 
	}
	/**
	 * 设置 Address, 类型String 默认值:""
	 *
	 * @param sAddress
	 *            Address, 类型String 默认值:""
	 */
	public void setAddress(String sAddress)
	{
		this.address = sAddress; 
	}
	// 设置和获取 Address, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 Phone, 默认值:""
	// 设置和获取 Phone,类型String 默认值:"" 开始
	private String phone = "";
	/**
	* 获取 Phone, 类型String 默认值:""
	 *
	 * @return Phone, 类型String 默认值:""
	 */
	public String getPhone()
	{
		return this.phone; 
	}
	/**
	 * 设置 Phone, 类型String 默认值:""
	 *
	 * @param sPhone
	 *            Phone, 类型String 默认值:""
	 */
	public void setPhone(String sPhone)
	{
		this.phone = sPhone; 
	}
	// 设置和获取 Phone, 类型String 默认值:"" 结束
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


        // [start] 设置和获取 DatabaseUnitID, 默认值:""
	// 设置和获取 DatabaseUnitID,类型String 默认值:"" 开始
	private String databaseunitid = "";
	/**
	* 获取 DatabaseUnitID, 类型String 默认值:""
	 *
	 * @return DatabaseUnitID, 类型String 默认值:""
	 */
	public String getDatabaseunitid()
	{
		return this.databaseunitid; 
	}
	/**
	 * 设置 DatabaseUnitID, 类型String 默认值:""
	 *
	 * @param sDatabaseunitid
	 *            DatabaseUnitID, 类型String 默认值:""
	 */
	public void setDatabaseunitid(String sDatabaseunitid)
	{
		this.databaseunitid = sDatabaseunitid; 
	}
	// 设置和获取 DatabaseUnitID, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 排序, 默认值:0
	// 设置和获取 排序,类型double 默认值:0 开始
	private double sorts = 0;
	/**
	* 获取 排序, 类型double 默认值:0
	 *
	 * @return 排序, 类型double 默认值:0
	 */
	public double getSorts()
	{
		return this.sorts; 
	}
	/**
	 * 设置 排序, 类型double 默认值:0
	 *
	 * @param sSorts
	 *            排序, 类型double 默认值:0
	 */
	public void setSorts(double sSorts)
	{
		this.sorts = sSorts; 
	}
	// 设置和获取 排序, 类型double 默认值:0 结束
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
            sbStr.append(getSectordatabaseid()).append(strSplit);
            sbStr.append(getSectorid()).append(strSplit);
            sbStr.append(getSectorname()).append(strSplit);
            sbStr.append(getDescription()).append(strSplit);
            sbStr.append(getAddress()).append(strSplit);
            sbStr.append(getPhone()).append(strSplit);
            sbStr.append(getIsUse()).append(strSplit);
            sbStr.append(getIsDel()).append(strSplit);
            sbStr.append(getDatabaseunitid()).append(strSplit);
            sbStr.append(getSorts()).append(strSplit);

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

            if (objs.length != 10)
            {
                return;
            }
            if (objs[0] != null || objs[0].length() >= 1)
            {
                setSectordatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setSectorid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setSectorname(com.colorwinglib.Converts.objToStr(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setDescription(com.colorwinglib.Converts.objToStr(objs[3]));
            }
            if (objs[4] != null || objs[4].length() >= 1)
            {
                setAddress(com.colorwinglib.Converts.objToStr(objs[4]));
            }
            if (objs[5] != null || objs[5].length() >= 1)
            {
                setPhone(com.colorwinglib.Converts.objToStr(objs[5]));
            }
            if (objs[6] != null || objs[6].length() >= 1)
            {
                setIsUse(com.colorwinglib.Converts.StrToInt(objs[6]));
            }
            if (objs[7] != null || objs[7].length() >= 1)
            {
                setIsDel(com.colorwinglib.Converts.StrToInt(objs[7]));
            }
            if (objs[8] != null || objs[8].length() >= 1)
            {
                setDatabaseunitid(com.colorwinglib.Converts.objToStr(objs[8]));
            }
            if (objs[9] != null || objs[9].length() >= 1)
            {
                setSorts(com.colorwinglib.Converts.StrToFloat(objs[9]));
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
            sbStr.append("&Sectordatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectordatabaseid()));//部门编号
            sbStr.append("&Sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//部门编号
            sbStr.append("&Sectorname=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorname()));//部门名称
            sbStr.append("&Description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//部门描述
            sbStr.append("&Address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//Address
            sbStr.append("&Phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//Phone
            sbStr.append("&IsUse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsUse()));//启用标志：1-启用、2-未启用
            sbStr.append("&IsDel=").append(com.colorwinglib.StringFormat.UrlEncode(getIsDel()));//是否删除：1-未删除、2-已删除
            sbStr.append("&Databaseunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseunitid()));//DatabaseUnitID
            sbStr.append("&Sorts=").append(com.colorwinglib.StringFormat.UrlEncode(getSorts()));//排序

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
			if (columnName.equals("Sectordatabaseid"))
				sbStr.append("&Sectordatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectordatabaseid()));//部门编号
			if (columnName.equals("Sectorid"))
				sbStr.append("&Sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//部门编号
			if (columnName.equals("Sectorname"))
				sbStr.append("&Sectorname=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorname()));//部门名称
			if (columnName.equals("Description"))
				sbStr.append("&Description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//部门描述
			if (columnName.equals("Address"))
				sbStr.append("&Address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//Address
			if (columnName.equals("Phone"))
				sbStr.append("&Phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//Phone
			if (columnName.equals("IsUse"))
				sbStr.append("&IsUse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsUse()));//启用标志：1-启用、2-未启用
			if (columnName.equals("IsDel"))
				sbStr.append("&IsDel=").append(com.colorwinglib.StringFormat.UrlEncode(getIsDel()));//是否删除：1-未删除、2-已删除
			if (columnName.equals("Databaseunitid"))
				sbStr.append("&Databaseunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseunitid()));//DatabaseUnitID
			if (columnName.equals("Sorts"))
				sbStr.append("&Sorts=").append(com.colorwinglib.StringFormat.UrlEncode(getSorts()));//排序
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
            sbStr.append("&sectordatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectordatabaseid()));//部门编号
            sbStr.append("&sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//部门编号
            sbStr.append("&sectorname=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorname()));//部门名称
            sbStr.append("&description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//部门描述
            sbStr.append("&address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//Address
            sbStr.append("&phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//Phone
            sbStr.append("&isUse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsUse()));//启用标志：1-启用、2-未启用
            sbStr.append("&isDel=").append(com.colorwinglib.StringFormat.UrlEncode(getIsDel()));//是否删除：1-未删除、2-已删除
            sbStr.append("&databaseunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseunitid()));//DatabaseUnitID
            sbStr.append("&sorts=").append(com.colorwinglib.StringFormat.UrlEncode(getSorts()));//排序

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
			if (columnName.equals("Sectordatabaseid"))
				sbStr.append("&sectordatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectordatabaseid()));//部门编号
			if (columnName.equals("Sectorid"))
				sbStr.append("&sectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorid()));//部门编号
			if (columnName.equals("Sectorname"))
				sbStr.append("&sectorname=").append(com.colorwinglib.StringFormat.UrlEncode(getSectorname()));//部门名称
			if (columnName.equals("Description"))
				sbStr.append("&description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//部门描述
			if (columnName.equals("Address"))
				sbStr.append("&address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//Address
			if (columnName.equals("Phone"))
				sbStr.append("&phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//Phone
			if (columnName.equals("IsUse"))
				sbStr.append("&isUse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsUse()));//启用标志：1-启用、2-未启用
			if (columnName.equals("IsDel"))
				sbStr.append("&isDel=").append(com.colorwinglib.StringFormat.UrlEncode(getIsDel()));//是否删除：1-未删除、2-已删除
			if (columnName.equals("Databaseunitid"))
				sbStr.append("&databaseunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseunitid()));//DatabaseUnitID
			if (columnName.equals("Sorts"))
				sbStr.append("&sorts=").append(com.colorwinglib.StringFormat.UrlEncode(getSorts()));//排序
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
	public static SystemSectorInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			SystemSectorInfo obj = (SystemSectorInfo) in.readObject();
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
	public String ToModifyString(SystemSectorInfo objOld)
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
	public String ToModifyString(SystemSectorInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getSectordatabaseid(), objOld.getSectordatabaseid()))
			sbStr.append("Sectordatabaseid 部门编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getSectordatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getSectordatabaseid())).append("]").append(strSplit);// 部门编号
		if (com.colorwinglib.Validate.isEquals(getSectorid(), objOld.getSectorid()))
			sbStr.append("Sectorid 部门编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getSectorid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getSectorid())).append("]").append(strSplit);// 部门编号
		if (com.colorwinglib.Validate.isEquals(getSectorname(), objOld.getSectorname()))
			sbStr.append("Sectorname 部门名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getSectorname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getSectorname())).append("]").append(strSplit);// 部门名称
		if (com.colorwinglib.Validate.isEquals(getDescription(), objOld.getDescription()))
			sbStr.append("Description 部门描述:[").append(com.colorwinglib.Converts.objToStr(objOld.getDescription())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDescription())).append("]").append(strSplit);// 部门描述
		if (com.colorwinglib.Validate.isEquals(getAddress(), objOld.getAddress()))
			sbStr.append("Address Address:[").append(com.colorwinglib.Converts.objToStr(objOld.getAddress())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAddress())).append("]").append(strSplit);// Address
		if (com.colorwinglib.Validate.isEquals(getPhone(), objOld.getPhone()))
			sbStr.append("Phone Phone:[").append(com.colorwinglib.Converts.objToStr(objOld.getPhone())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPhone())).append("]").append(strSplit);// Phone
		if (com.colorwinglib.Validate.isEquals(getIsUse(), objOld.getIsUse()))
			sbStr.append("IsUse 启用标志：1-启用、2-未启用:[").append(com.colorwinglib.Converts.objToStr(objOld.getIsUse())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getIsUse())).append("]").append(strSplit);// 启用标志：1-启用、2-未启用
		if (com.colorwinglib.Validate.isEquals(getIsDel(), objOld.getIsDel()))
			sbStr.append("IsDel 是否删除：1-未删除、2-已删除:[").append(com.colorwinglib.Converts.objToStr(objOld.getIsDel())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getIsDel())).append("]").append(strSplit);// 是否删除：1-未删除、2-已删除
		if (com.colorwinglib.Validate.isEquals(getDatabaseunitid(), objOld.getDatabaseunitid()))
			sbStr.append("Databaseunitid DatabaseUnitID:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabaseunitid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabaseunitid())).append("]").append(strSplit);// DatabaseUnitID
		if (com.colorwinglib.Validate.isEquals(getSorts(), objOld.getSorts()))
			sbStr.append("Sorts 排序:[").append(com.colorwinglib.Converts.objToStr(objOld.getSorts())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getSorts())).append("]").append(strSplit);// 排序
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
			json.put("Sectordatabaseid", getSectordatabaseid());// 部门编号
			json.put("Sectorid", getSectorid());// 部门编号
			json.put("Sectorname", getSectorname());// 部门名称
			json.put("Description", getDescription());// 部门描述
			json.put("Address", getAddress());// Address
			json.put("Phone", getPhone());// Phone
			json.put("IsUse", getIsUse());// 启用标志：1-启用、2-未启用
			json.put("IsDel", getIsDel());// 是否删除：1-未删除、2-已删除
			json.put("Databaseunitid", getDatabaseunitid());// DatabaseUnitID
			json.put("Sorts", getSorts());// 排序
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
			setSectordatabaseid(json.getInt("Sectordatabaseid"));// 部门编号
			setSectorid(json.getInt("Sectorid"));// 部门编号
			setSectorname(json.getString("Sectorname"));// 部门名称
			setDescription(json.getString("Description"));// 部门描述
			setAddress(json.getString("Address"));// Address
			setPhone(json.getString("Phone"));// Phone
			setIsUse(json.getInt("IsUse"));// 启用标志：1-启用、2-未启用
			setIsDel(json.getInt("IsDel"));// 是否删除：1-未删除、2-已删除
			setDatabaseunitid(json.getString("Databaseunitid"));// DatabaseUnitID
			setSorts(json.getDouble("Sorts"));// 排序

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
		sbStr.append("<SystemSectorInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //部门编号
			sbStr.append("    <Sectordatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getSectordatabaseid()));
			sbStr.append("</Sectordatabaseid>\n");
            //部门编号
			sbStr.append("    <Sectorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getSectorid()));
			sbStr.append("</Sectorid>\n");
            //部门名称
			sbStr.append("    <Sectorname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getSectorname()));
			sbStr.append("</Sectorname>\n");
            //部门描述
			sbStr.append("    <Description>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDescription()));
			sbStr.append("</Description>\n");
            //Address
			sbStr.append("    <Address>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAddress()));
			sbStr.append("</Address>\n");
            //Phone
			sbStr.append("    <Phone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPhone()));
			sbStr.append("</Phone>\n");
            //启用标志：1-启用、2-未启用
			sbStr.append("    <IsUse>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getIsUse()));
			sbStr.append("</IsUse>\n");
            //是否删除：1-未删除、2-已删除
			sbStr.append("    <IsDel>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getIsDel()));
			sbStr.append("</IsDel>\n");
            //DatabaseUnitID
			sbStr.append("    <Databaseunitid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabaseunitid()));
			sbStr.append("</Databaseunitid>\n");
            //排序
			sbStr.append("    <Sorts>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getSorts()));
			sbStr.append("</Sorts>\n");
		sbStr.append("</SystemSectorInfo>\n");
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
	// GetSystemSectorInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetSystemSectorInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static SystemSectorInfo GetSystemSectorInfoFormFileName(String filename)
	{
		return GetSystemSectorInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemSectorInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemSectorInfo GetSystemSectorInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetSystemSectorInfoFormXml(xml, encoding);
	}

	// [end]

	// GetSystemSectorInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetSystemSectorInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemSectorInfo GetSystemSectorInfoFormXml(String xml)
	{
		return GetSystemSectorInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemSectorInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemSectorInfo GetSystemSectorInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		SystemSectorInfo objSystemSectorInfo = new SystemSectorInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//部门编号
				if (foo.elementText("Sectordatabaseid") != null)
					objSystemSectorInfo.setSectordatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Sectordatabaseid")));
				//部门编号
				if (foo.elementText("Sectorid") != null)
					objSystemSectorInfo.setSectorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Sectorid")));
				//部门名称
				if (foo.elementText("Sectorname") != null)
					objSystemSectorInfo.setSectorname(com.colorwinglib.Converts.objToStr(foo.elementText("Sectorname")));
				//部门描述
				if (foo.elementText("Description") != null)
					objSystemSectorInfo.setDescription(com.colorwinglib.Converts.objToStr(foo.elementText("Description")));
				//Address
				if (foo.elementText("Address") != null)
					objSystemSectorInfo.setAddress(com.colorwinglib.Converts.objToStr(foo.elementText("Address")));
				//Phone
				if (foo.elementText("Phone") != null)
					objSystemSectorInfo.setPhone(com.colorwinglib.Converts.objToStr(foo.elementText("Phone")));
				//启用标志：1-启用、2-未启用
				if (foo.elementText("IsUse") != null)
					objSystemSectorInfo.setIsUse(com.colorwinglib.Converts.StrToInt(foo.elementText("IsUse")));
				//是否删除：1-未删除、2-已删除
				if (foo.elementText("IsDel") != null)
					objSystemSectorInfo.setIsDel(com.colorwinglib.Converts.StrToInt(foo.elementText("IsDel")));
				//DatabaseUnitID
				if (foo.elementText("Databaseunitid") != null)
					objSystemSectorInfo.setDatabaseunitid(com.colorwinglib.Converts.objToStr(foo.elementText("Databaseunitid")));
				//排序
				if (foo.elementText("Sorts") != null)
					objSystemSectorInfo.setSorts(com.colorwinglib.Converts.StrToFloat(foo.elementText("Sorts")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objSystemSectorInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public SystemSectorInfo Copy()
	{
		SystemSectorInfo objSystemSectorInfo = new SystemSectorInfo();
		objSystemSectorInfo.setSectordatabaseid(this.getSectordatabaseid());//部门编号
		objSystemSectorInfo.setSectorid(this.getSectorid());//部门编号
		objSystemSectorInfo.setSectorname(this.getSectorname());//部门名称
		objSystemSectorInfo.setDescription(this.getDescription());//部门描述
		objSystemSectorInfo.setAddress(this.getAddress());//Address
		objSystemSectorInfo.setPhone(this.getPhone());//Phone
		objSystemSectorInfo.setIsUse(this.getIsUse());//启用标志：1-启用、2-未启用
		objSystemSectorInfo.setIsDel(this.getIsDel());//是否删除：1-未删除、2-已删除
		objSystemSectorInfo.setDatabaseunitid(this.getDatabaseunitid());//DatabaseUnitID
		objSystemSectorInfo.setSorts(this.getSorts());//排序
		return objSystemSectorInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明

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
			isUselabel = com.yun.bll.itemcollection.culture.SystemSectorItemCollection.IsUseText(String.valueOf(getIsUse()));
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
			isDellabel = com.yun.bll.itemcollection.culture.SystemSectorItemCollection.IsDelText(String.valueOf(getIsDel()));
		return this.isDellabel; 
	}
        // [end]



	 //[end]
}
