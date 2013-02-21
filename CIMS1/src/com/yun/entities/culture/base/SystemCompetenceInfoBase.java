
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * SystemCompetence 权限表的描述
 * 实体类基本类
 */
public class SystemCompetenceInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311560792196L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public SystemCompetenceInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public SystemCompetenceInfoBase(int sDatabasecompetenceid)
	{
		this.setDatabasecompetenceid(sDatabasecompetenceid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public SystemCompetenceInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setDatabasecompetenceid(rs.getInt("DatabaseCompetenceID"));//权限ID
		setCompetenceid(rs.getInt("CompetenceID"));//权限编号
		setCompetencename(rs.getString("CompetenceName"));//权限名称
		setDescription(rs.getString("Description"));//权限描述
		setIsUse(rs.getInt("Is_Use"));//启用标志：1-启用、2-未启用
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public SystemCompetenceInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//权限ID
			if (columnName.equals("DatabaseCompetenceID"))
			{
				setDatabasecompetenceid(rs.getInt("DatabaseCompetenceID"));
				continue;
			}
			//权限编号
			if (columnName.equals("CompetenceID"))
			{
				setCompetenceid(rs.getInt("CompetenceID"));
				continue;
			}
			//权限名称
			if (columnName.equals("CompetenceName"))
			{
				setCompetencename(rs.getString("CompetenceName"));
				continue;
			}
			//权限描述
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
		if (!(rhs instanceof SystemCompetenceInfo))
			return false;
		SystemCompetenceInfo that = (SystemCompetenceInfo) rhs;

		return (this.getDatabasecompetenceid() == (that.getDatabasecompetenceid()));
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

			result = result * 37 + (this.getDatabasecompetenceid() + "").hashCode();
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
	"DatabaseCompetenceID", //权限ID
	"CompetenceID", //权限编号
	"CompetenceName", //权限名称
	"Description", //权限描述
	"Is_Use" //启用标志：1-启用、2-未启用
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum SystemCompetenceColumnNameEnum
{
		/**
		 * 权限ID
		 */
		Databasecompetenceid,
		/**
		 * 权限编号
		 */
		Competenceid,
		/**
		 * 权限名称
		 */
		Competencename,
		/**
		 * 权限描述
		 */
		Description,
		/**
		 * 启用标志：1-启用、2-未启用
		 */
		IsUse
	};
	// [end]
        // [start] 设置和获取 权限ID, 默认值:0
	// 设置和获取 权限ID,类型int 默认值:0 开始
	private int databasecompetenceid = 0;
	/**
	* 获取 权限ID, 类型int 默认值:0
	 *
	 * @return 权限ID, 类型int 默认值:0
	 */
	public int getDatabasecompetenceid()
	{
		return this.databasecompetenceid; 
	}
	/**
	 * 设置 权限ID, 类型int 默认值:0
	 *
	 * @param sDatabasecompetenceid
	 *            权限ID, 类型int 默认值:0
	 */
	public void setDatabasecompetenceid(int sDatabasecompetenceid)
	{
		this.databasecompetenceid = sDatabasecompetenceid; 
	}
	// 设置和获取 权限ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 权限编号, 默认值:0
	// 设置和获取 权限编号,类型int 默认值:0 开始
	private int competenceid = 0;
	/**
	* 获取 权限编号, 类型int 默认值:0
	 *
	 * @return 权限编号, 类型int 默认值:0
	 */
	public int getCompetenceid()
	{
		return this.competenceid; 
	}
	/**
	 * 设置 权限编号, 类型int 默认值:0
	 *
	 * @param sCompetenceid
	 *            权限编号, 类型int 默认值:0
	 */
	public void setCompetenceid(int sCompetenceid)
	{
		this.competenceid = sCompetenceid; 
	}
	// 设置和获取 权限编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 权限名称, 默认值:""
	// 设置和获取 权限名称,类型String 默认值:"" 开始
	private String competencename = "";
	/**
	* 获取 权限名称, 类型String 默认值:""
	 *
	 * @return 权限名称, 类型String 默认值:""
	 */
	public String getCompetencename()
	{
		return this.competencename; 
	}
	/**
	 * 设置 权限名称, 类型String 默认值:""
	 *
	 * @param sCompetencename
	 *            权限名称, 类型String 默认值:""
	 */
	public void setCompetencename(String sCompetencename)
	{
		this.competencename = sCompetencename; 
	}
	// 设置和获取 权限名称, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 权限描述, 默认值:""
	// 设置和获取 权限描述,类型String 默认值:"" 开始
	private String description = "";
	/**
	* 获取 权限描述, 类型String 默认值:""
	 *
	 * @return 权限描述, 类型String 默认值:""
	 */
	public String getDescription()
	{
		return this.description; 
	}
	/**
	 * 设置 权限描述, 类型String 默认值:""
	 *
	 * @param sDescription
	 *            权限描述, 类型String 默认值:""
	 */
	public void setDescription(String sDescription)
	{
		this.description = sDescription; 
	}
	// 设置和获取 权限描述, 类型String 默认值:"" 结束
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
            sbStr.append(getDatabasecompetenceid()).append(strSplit);
            sbStr.append(getCompetenceid()).append(strSplit);
            sbStr.append(getCompetencename()).append(strSplit);
            sbStr.append(getDescription()).append(strSplit);
            sbStr.append(getIsUse()).append(strSplit);

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

            if (objs.length != 5)
            {
                return;
            }
            if (objs[0] != null || objs[0].length() >= 1)
            {
                setDatabasecompetenceid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setCompetenceid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setCompetencename(com.colorwinglib.Converts.objToStr(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setDescription(com.colorwinglib.Converts.objToStr(objs[3]));
            }
            if (objs[4] != null || objs[4].length() >= 1)
            {
                setIsUse(com.colorwinglib.Converts.StrToInt(objs[4]));
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
            sbStr.append("&Databasecompetenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasecompetenceid()));//权限ID
            sbStr.append("&Competenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetenceid()));//权限编号
            sbStr.append("&Competencename=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetencename()));//权限名称
            sbStr.append("&Description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//权限描述
            sbStr.append("&IsUse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsUse()));//启用标志：1-启用、2-未启用

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
			if (columnName.equals("Databasecompetenceid"))
				sbStr.append("&Databasecompetenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasecompetenceid()));//权限ID
			if (columnName.equals("Competenceid"))
				sbStr.append("&Competenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetenceid()));//权限编号
			if (columnName.equals("Competencename"))
				sbStr.append("&Competencename=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetencename()));//权限名称
			if (columnName.equals("Description"))
				sbStr.append("&Description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//权限描述
			if (columnName.equals("IsUse"))
				sbStr.append("&IsUse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsUse()));//启用标志：1-启用、2-未启用
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
            sbStr.append("&databasecompetenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasecompetenceid()));//权限ID
            sbStr.append("&competenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetenceid()));//权限编号
            sbStr.append("&competencename=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetencename()));//权限名称
            sbStr.append("&description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//权限描述
            sbStr.append("&isUse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsUse()));//启用标志：1-启用、2-未启用

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
			if (columnName.equals("Databasecompetenceid"))
				sbStr.append("&databasecompetenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasecompetenceid()));//权限ID
			if (columnName.equals("Competenceid"))
				sbStr.append("&competenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetenceid()));//权限编号
			if (columnName.equals("Competencename"))
				sbStr.append("&competencename=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetencename()));//权限名称
			if (columnName.equals("Description"))
				sbStr.append("&description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//权限描述
			if (columnName.equals("IsUse"))
				sbStr.append("&isUse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsUse()));//启用标志：1-启用、2-未启用
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
	public static SystemCompetenceInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			SystemCompetenceInfo obj = (SystemCompetenceInfo) in.readObject();
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
	public String ToModifyString(SystemCompetenceInfo objOld)
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
	public String ToModifyString(SystemCompetenceInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getDatabasecompetenceid(), objOld.getDatabasecompetenceid()))
			sbStr.append("Databasecompetenceid 权限ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabasecompetenceid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabasecompetenceid())).append("]").append(strSplit);// 权限ID
		if (com.colorwinglib.Validate.isEquals(getCompetenceid(), objOld.getCompetenceid()))
			sbStr.append("Competenceid 权限编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getCompetenceid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getCompetenceid())).append("]").append(strSplit);// 权限编号
		if (com.colorwinglib.Validate.isEquals(getCompetencename(), objOld.getCompetencename()))
			sbStr.append("Competencename 权限名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getCompetencename())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getCompetencename())).append("]").append(strSplit);// 权限名称
		if (com.colorwinglib.Validate.isEquals(getDescription(), objOld.getDescription()))
			sbStr.append("Description 权限描述:[").append(com.colorwinglib.Converts.objToStr(objOld.getDescription())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDescription())).append("]").append(strSplit);// 权限描述
		if (com.colorwinglib.Validate.isEquals(getIsUse(), objOld.getIsUse()))
			sbStr.append("IsUse 启用标志：1-启用、2-未启用:[").append(com.colorwinglib.Converts.objToStr(objOld.getIsUse())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getIsUse())).append("]").append(strSplit);// 启用标志：1-启用、2-未启用
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
			json.put("Databasecompetenceid", getDatabasecompetenceid());// 权限ID
			json.put("Competenceid", getCompetenceid());// 权限编号
			json.put("Competencename", getCompetencename());// 权限名称
			json.put("Description", getDescription());// 权限描述
			json.put("IsUse", getIsUse());// 启用标志：1-启用、2-未启用
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
			setDatabasecompetenceid(json.getInt("Databasecompetenceid"));// 权限ID
			setCompetenceid(json.getInt("Competenceid"));// 权限编号
			setCompetencename(json.getString("Competencename"));// 权限名称
			setDescription(json.getString("Description"));// 权限描述
			setIsUse(json.getInt("IsUse"));// 启用标志：1-启用、2-未启用

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
		sbStr.append("<SystemCompetenceInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //权限ID
			sbStr.append("    <Databasecompetenceid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabasecompetenceid()));
			sbStr.append("</Databasecompetenceid>\n");
            //权限编号
			sbStr.append("    <Competenceid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getCompetenceid()));
			sbStr.append("</Competenceid>\n");
            //权限名称
			sbStr.append("    <Competencename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getCompetencename()));
			sbStr.append("</Competencename>\n");
            //权限描述
			sbStr.append("    <Description>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDescription()));
			sbStr.append("</Description>\n");
            //启用标志：1-启用、2-未启用
			sbStr.append("    <IsUse>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getIsUse()));
			sbStr.append("</IsUse>\n");
		sbStr.append("</SystemCompetenceInfo>\n");
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
	// GetSystemCompetenceInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetSystemCompetenceInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static SystemCompetenceInfo GetSystemCompetenceInfoFormFileName(String filename)
	{
		return GetSystemCompetenceInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemCompetenceInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemCompetenceInfo GetSystemCompetenceInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetSystemCompetenceInfoFormXml(xml, encoding);
	}

	// [end]

	// GetSystemCompetenceInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetSystemCompetenceInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemCompetenceInfo GetSystemCompetenceInfoFormXml(String xml)
	{
		return GetSystemCompetenceInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemCompetenceInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemCompetenceInfo GetSystemCompetenceInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		SystemCompetenceInfo objSystemCompetenceInfo = new SystemCompetenceInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//权限ID
				if (foo.elementText("Databasecompetenceid") != null)
					objSystemCompetenceInfo.setDatabasecompetenceid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasecompetenceid")));
				//权限编号
				if (foo.elementText("Competenceid") != null)
					objSystemCompetenceInfo.setCompetenceid(com.colorwinglib.Converts.StrToInt(foo.elementText("Competenceid")));
				//权限名称
				if (foo.elementText("Competencename") != null)
					objSystemCompetenceInfo.setCompetencename(com.colorwinglib.Converts.objToStr(foo.elementText("Competencename")));
				//权限描述
				if (foo.elementText("Description") != null)
					objSystemCompetenceInfo.setDescription(com.colorwinglib.Converts.objToStr(foo.elementText("Description")));
				//启用标志：1-启用、2-未启用
				if (foo.elementText("IsUse") != null)
					objSystemCompetenceInfo.setIsUse(com.colorwinglib.Converts.StrToInt(foo.elementText("IsUse")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objSystemCompetenceInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public SystemCompetenceInfo Copy()
	{
		SystemCompetenceInfo objSystemCompetenceInfo = new SystemCompetenceInfo();
		objSystemCompetenceInfo.setDatabasecompetenceid(this.getDatabasecompetenceid());//权限ID
		objSystemCompetenceInfo.setCompetenceid(this.getCompetenceid());//权限编号
		objSystemCompetenceInfo.setCompetencename(this.getCompetencename());//权限名称
		objSystemCompetenceInfo.setDescription(this.getDescription());//权限描述
		objSystemCompetenceInfo.setIsUse(this.getIsUse());//启用标志：1-启用、2-未启用
		return objSystemCompetenceInfo;
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
			isUselabel = com.yun.bll.itemcollection.culture.SystemCompetenceItemCollection.IsUseText(String.valueOf(getIsUse()));
		return this.isUselabel; 
	}
        // [end]



	 //[end]
}
