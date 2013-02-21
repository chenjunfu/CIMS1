
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * SystemRoles 角色表的描述
 * 实体类基本类
 */
public class SystemRolesInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012121214182481287L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public SystemRolesInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public SystemRolesInfoBase(int sDatabaserolesid)
	{
		this.setDatabaserolesid(sDatabaserolesid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public SystemRolesInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setDatabaserolesid(rs.getInt("DatabaseRolesID"));//DatabaseRolesID
		setRolesid(rs.getInt("RolesID"));//角色编号
		setRolesname(rs.getString("RolesName"));//角色名称
		setDescription(rs.getString("Description"));//描述
		setIsUse(rs.getInt("Is_Use"));//启用标志：1-启用、2-未启用
		setCompetenceid(rs.getString("CompetenceID"));//权限编号
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public SystemRolesInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//DatabaseRolesID
			if (columnName.equals("DatabaseRolesID"))
			{
				setDatabaserolesid(rs.getInt("DatabaseRolesID"));
				continue;
			}
			//角色编号
			if (columnName.equals("RolesID"))
			{
				setRolesid(rs.getInt("RolesID"));
				continue;
			}
			//角色名称
			if (columnName.equals("RolesName"))
			{
				setRolesname(rs.getString("RolesName"));
				continue;
			}
			//描述
			if (columnName.equals("Description"))
			{
				setDescription(rs.getString("Description"));
				continue;
			}
			//启用标志：1-启用、2-未启用
			if (columnName.equals("Is_Use"))
			{
				setIsUse(rs.getInt("Is_Use"));
				continue;
			}
			//权限编号
			if (columnName.equals("CompetenceID"))
			{
				setCompetenceid(rs.getString("CompetenceID"));
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
		if (!(rhs instanceof SystemRolesInfo))
			return false;
		SystemRolesInfo that = (SystemRolesInfo) rhs;

		return (this.getDatabaserolesid() == (that.getDatabaserolesid()));
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

			result = result * 37 + (this.getDatabaserolesid() + "").hashCode();
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
	"DatabaseRolesID", //DatabaseRolesID
	"RolesID", //角色编号
	"RolesName", //角色名称
	"Description", //描述
	"Is_Use", //启用标志：1-启用、2-未启用
	"CompetenceID" //权限编号
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum SystemRolesColumnNameEnum
{
		/**
		 * DatabaseRolesID
		 */
		Databaserolesid,
		/**
		 * 角色编号
		 */
		Rolesid,
		/**
		 * 角色名称
		 */
		Rolesname,
		/**
		 * 描述
		 */
		Description,
		/**
		 * 启用标志：1-启用、2-未启用
		 */
		IsUse,
		/**
		 * 权限编号
		 */
		Competenceid
	};
	// [end]
        // [start] 设置和获取 DatabaseRolesID, 默认值:0
	// 设置和获取 DatabaseRolesID,类型int 默认值:0 开始
	private int databaserolesid = 0;
	/**
	* 获取 DatabaseRolesID, 类型int 默认值:0
	 *
	 * @return DatabaseRolesID, 类型int 默认值:0
	 */
	public int getDatabaserolesid()
	{
		return this.databaserolesid; 
	}
	/**
	 * 设置 DatabaseRolesID, 类型int 默认值:0
	 *
	 * @param sDatabaserolesid
	 *            DatabaseRolesID, 类型int 默认值:0
	 */
	public void setDatabaserolesid(int sDatabaserolesid)
	{
		this.databaserolesid = sDatabaserolesid; 
	}
	// 设置和获取 DatabaseRolesID, 类型int 默认值:0 结束
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


        // [start] 设置和获取 角色名称, 默认值:""
	// 设置和获取 角色名称,类型String 默认值:"" 开始
	private String rolesname = "";
	/**
	* 获取 角色名称, 类型String 默认值:""
	 *
	 * @return 角色名称, 类型String 默认值:""
	 */
	public String getRolesname()
	{
		return this.rolesname; 
	}
	/**
	 * 设置 角色名称, 类型String 默认值:""
	 *
	 * @param sRolesname
	 *            角色名称, 类型String 默认值:""
	 */
	public void setRolesname(String sRolesname)
	{
		this.rolesname = sRolesname; 
	}
	// 设置和获取 角色名称, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 描述, 默认值:""
	// 设置和获取 描述,类型String 默认值:"" 开始
	private String description = "";
	/**
	* 获取 描述, 类型String 默认值:""
	 *
	 * @return 描述, 类型String 默认值:""
	 */
	public String getDescription()
	{
		return this.description; 
	}
	/**
	 * 设置 描述, 类型String 默认值:""
	 *
	 * @param sDescription
	 *            描述, 类型String 默认值:""
	 */
	public void setDescription(String sDescription)
	{
		this.description = sDescription; 
	}
	// 设置和获取 描述, 类型String 默认值:"" 结束
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


        // [start] 设置和获取 权限编号, 默认值:""
	// 设置和获取 权限编号,类型String 默认值:"" 开始
	private String competenceid = "";
	/**
	* 获取 权限编号, 类型String 默认值:""
	 *
	 * @return 权限编号, 类型String 默认值:""
	 */
	public String getCompetenceid()
	{
		return this.competenceid; 
	}
	/**
	 * 设置 权限编号, 类型String 默认值:""
	 *
	 * @param sCompetenceid
	 *            权限编号, 类型String 默认值:""
	 */
	public void setCompetenceid(String sCompetenceid)
	{
		this.competenceid = sCompetenceid; 
	}
	// 设置和获取 权限编号, 类型String 默认值:"" 结束
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
            sbStr.append(getDatabaserolesid()).append(strSplit);
            sbStr.append(getRolesid()).append(strSplit);
            sbStr.append(getRolesname()).append(strSplit);
            sbStr.append(getDescription()).append(strSplit);
            sbStr.append(getIsUse()).append(strSplit);
            sbStr.append(getCompetenceid()).append(strSplit);

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

            if (objs.length != 6)
            {
                return;
            }
            if (objs[0] != null || objs[0].length() >= 1)
            {
                setDatabaserolesid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setRolesid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setRolesname(com.colorwinglib.Converts.objToStr(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setDescription(com.colorwinglib.Converts.objToStr(objs[3]));
            }
            if (objs[4] != null || objs[4].length() >= 1)
            {
                setIsUse(com.colorwinglib.Converts.StrToInt(objs[4]));
            }
            if (objs[5] != null || objs[5].length() >= 1)
            {
                setCompetenceid(com.colorwinglib.Converts.objToStr(objs[5]));
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
            sbStr.append("&Databaserolesid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaserolesid()));//DatabaseRolesID
            sbStr.append("&Rolesid=").append(com.colorwinglib.StringFormat.UrlEncode(getRolesid()));//角色编号
            sbStr.append("&Rolesname=").append(com.colorwinglib.StringFormat.UrlEncode(getRolesname()));//角色名称
            sbStr.append("&Description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//描述
            sbStr.append("&IsUse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsUse()));//启用标志：1-启用、2-未启用
            sbStr.append("&Competenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetenceid()));//权限编号

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
			if (columnName.equals("Databaserolesid"))
				sbStr.append("&Databaserolesid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaserolesid()));//DatabaseRolesID
			if (columnName.equals("Rolesid"))
				sbStr.append("&Rolesid=").append(com.colorwinglib.StringFormat.UrlEncode(getRolesid()));//角色编号
			if (columnName.equals("Rolesname"))
				sbStr.append("&Rolesname=").append(com.colorwinglib.StringFormat.UrlEncode(getRolesname()));//角色名称
			if (columnName.equals("Description"))
				sbStr.append("&Description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//描述
			if (columnName.equals("IsUse"))
				sbStr.append("&IsUse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsUse()));//启用标志：1-启用、2-未启用
			if (columnName.equals("Competenceid"))
				sbStr.append("&Competenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetenceid()));//权限编号
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
            sbStr.append("&databaserolesid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaserolesid()));//DatabaseRolesID
            sbStr.append("&rolesid=").append(com.colorwinglib.StringFormat.UrlEncode(getRolesid()));//角色编号
            sbStr.append("&rolesname=").append(com.colorwinglib.StringFormat.UrlEncode(getRolesname()));//角色名称
            sbStr.append("&description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//描述
            sbStr.append("&isUse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsUse()));//启用标志：1-启用、2-未启用
            sbStr.append("&competenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetenceid()));//权限编号

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
			if (columnName.equals("Databaserolesid"))
				sbStr.append("&databaserolesid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaserolesid()));//DatabaseRolesID
			if (columnName.equals("Rolesid"))
				sbStr.append("&rolesid=").append(com.colorwinglib.StringFormat.UrlEncode(getRolesid()));//角色编号
			if (columnName.equals("Rolesname"))
				sbStr.append("&rolesname=").append(com.colorwinglib.StringFormat.UrlEncode(getRolesname()));//角色名称
			if (columnName.equals("Description"))
				sbStr.append("&description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//描述
			if (columnName.equals("IsUse"))
				sbStr.append("&isUse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsUse()));//启用标志：1-启用、2-未启用
			if (columnName.equals("Competenceid"))
				sbStr.append("&competenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetenceid()));//权限编号
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
	public static SystemRolesInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			SystemRolesInfo obj = (SystemRolesInfo) in.readObject();
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
	public String ToModifyString(SystemRolesInfo objOld)
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
	public String ToModifyString(SystemRolesInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getDatabaserolesid(), objOld.getDatabaserolesid()))
			sbStr.append("Databaserolesid DatabaseRolesID:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabaserolesid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabaserolesid())).append("]").append(strSplit);// DatabaseRolesID
		if (com.colorwinglib.Validate.isEquals(getRolesid(), objOld.getRolesid()))
			sbStr.append("Rolesid 角色编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getRolesid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getRolesid())).append("]").append(strSplit);// 角色编号
		if (com.colorwinglib.Validate.isEquals(getRolesname(), objOld.getRolesname()))
			sbStr.append("Rolesname 角色名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getRolesname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getRolesname())).append("]").append(strSplit);// 角色名称
		if (com.colorwinglib.Validate.isEquals(getDescription(), objOld.getDescription()))
			sbStr.append("Description 描述:[").append(com.colorwinglib.Converts.objToStr(objOld.getDescription())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDescription())).append("]").append(strSplit);// 描述
		if (com.colorwinglib.Validate.isEquals(getIsUse(), objOld.getIsUse()))
			sbStr.append("IsUse 启用标志：1-启用、2-未启用:[").append(com.colorwinglib.Converts.objToStr(objOld.getIsUse())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getIsUse())).append("]").append(strSplit);// 启用标志：1-启用、2-未启用
		if (com.colorwinglib.Validate.isEquals(getCompetenceid(), objOld.getCompetenceid()))
			sbStr.append("Competenceid 权限编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getCompetenceid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getCompetenceid())).append("]").append(strSplit);// 权限编号
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
			json.put("Databaserolesid", getDatabaserolesid());// DatabaseRolesID
			json.put("Rolesid", getRolesid());// 角色编号
			json.put("Rolesname", getRolesname());// 角色名称
			json.put("Description", getDescription());// 描述
			json.put("IsUse", getIsUse());// 启用标志：1-启用、2-未启用
			json.put("Competenceid", getCompetenceid());// 权限编号
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
			setDatabaserolesid(json.getInt("Databaserolesid"));// DatabaseRolesID
			setRolesid(json.getInt("Rolesid"));// 角色编号
			setRolesname(json.getString("Rolesname"));// 角色名称
			setDescription(json.getString("Description"));// 描述
			setIsUse(json.getInt("IsUse"));// 启用标志：1-启用、2-未启用
			setCompetenceid(json.getString("Competenceid"));// 权限编号

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
		sbStr.append("<SystemRolesInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //DatabaseRolesID
			sbStr.append("    <Databaserolesid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabaserolesid()));
			sbStr.append("</Databaserolesid>\n");
            //角色编号
			sbStr.append("    <Rolesid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getRolesid()));
			sbStr.append("</Rolesid>\n");
            //角色名称
			sbStr.append("    <Rolesname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getRolesname()));
			sbStr.append("</Rolesname>\n");
            //描述
			sbStr.append("    <Description>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDescription()));
			sbStr.append("</Description>\n");
            //启用标志：1-启用、2-未启用
			sbStr.append("    <IsUse>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getIsUse()));
			sbStr.append("</IsUse>\n");
            //权限编号
			sbStr.append("    <Competenceid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getCompetenceid()));
			sbStr.append("</Competenceid>\n");
		sbStr.append("</SystemRolesInfo>\n");
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
	// GetSystemRolesInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetSystemRolesInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static SystemRolesInfo GetSystemRolesInfoFormFileName(String filename)
	{
		return GetSystemRolesInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemRolesInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemRolesInfo GetSystemRolesInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetSystemRolesInfoFormXml(xml, encoding);
	}

	// [end]

	// GetSystemRolesInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetSystemRolesInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemRolesInfo GetSystemRolesInfoFormXml(String xml)
	{
		return GetSystemRolesInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemRolesInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemRolesInfo GetSystemRolesInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		SystemRolesInfo objSystemRolesInfo = new SystemRolesInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//DatabaseRolesID
				if (foo.elementText("Databaserolesid") != null)
					objSystemRolesInfo.setDatabaserolesid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaserolesid")));
				//角色编号
				if (foo.elementText("Rolesid") != null)
					objSystemRolesInfo.setRolesid(com.colorwinglib.Converts.StrToInt(foo.elementText("Rolesid")));
				//角色名称
				if (foo.elementText("Rolesname") != null)
					objSystemRolesInfo.setRolesname(com.colorwinglib.Converts.objToStr(foo.elementText("Rolesname")));
				//描述
				if (foo.elementText("Description") != null)
					objSystemRolesInfo.setDescription(com.colorwinglib.Converts.objToStr(foo.elementText("Description")));
				//启用标志：1-启用、2-未启用
				if (foo.elementText("IsUse") != null)
					objSystemRolesInfo.setIsUse(com.colorwinglib.Converts.StrToInt(foo.elementText("IsUse")));
				//权限编号
				if (foo.elementText("Competenceid") != null)
					objSystemRolesInfo.setCompetenceid(com.colorwinglib.Converts.objToStr(foo.elementText("Competenceid")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objSystemRolesInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public SystemRolesInfo Copy()
	{
		SystemRolesInfo objSystemRolesInfo = new SystemRolesInfo();
		objSystemRolesInfo.setDatabaserolesid(this.getDatabaserolesid());//DatabaseRolesID
		objSystemRolesInfo.setRolesid(this.getRolesid());//角色编号
		objSystemRolesInfo.setRolesname(this.getRolesname());//角色名称
		objSystemRolesInfo.setDescription(this.getDescription());//描述
		objSystemRolesInfo.setIsUse(this.getIsUse());//启用标志：1-启用、2-未启用
		objSystemRolesInfo.setCompetenceid(this.getCompetenceid());//权限编号
		return objSystemRolesInfo;
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
			isUselabel = com.yun.bll.itemcollection.culture.SystemRolesItemCollection.IsUseText(String.valueOf(getIsUse()));
		return this.isUselabel; 
	}
        // [end]



	 //[end]
}
