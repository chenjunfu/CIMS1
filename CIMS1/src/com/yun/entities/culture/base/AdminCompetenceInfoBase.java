
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * AdminCompetence 用户权限表的描述
 * 实体类基本类
 */
public class AdminCompetenceInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012121116145185979L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public AdminCompetenceInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public AdminCompetenceInfoBase(int sDatabaseadmincompetence)
	{
		this.setDatabaseadmincompetence(sDatabaseadmincompetence);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public AdminCompetenceInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setDatabaseadmincompetence(rs.getInt("DatabaseAdminCompetence"));//数据库ID
		setAdmincompetenceid(rs.getInt("AdminCompetenceID"));//用户权限编号
		setDatabaseadminid(rs.getInt("DatabaseAdminID"));//用户数据库ID
		setDatabasecompetenceid(rs.getInt("DatabaseCompetenceID"));//权限ID
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public AdminCompetenceInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//数据库ID
			if (columnName.equals("DatabaseAdminCompetence"))
			{
				setDatabaseadmincompetence(rs.getInt("DatabaseAdminCompetence"));
				continue;
			}
			//用户权限编号
			if (columnName.equals("AdminCompetenceID"))
			{
				setAdmincompetenceid(rs.getInt("AdminCompetenceID"));
				continue;
			}
			//用户数据库ID
			if (columnName.equals("DatabaseAdminID"))
			{
				setDatabaseadminid(rs.getInt("DatabaseAdminID"));
				continue;
			}
			//权限ID
			if (columnName.equals("DatabaseCompetenceID"))
			{
				setDatabasecompetenceid(rs.getInt("DatabaseCompetenceID"));
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
		if (!(rhs instanceof AdminCompetenceInfo))
			return false;
		AdminCompetenceInfo that = (AdminCompetenceInfo) rhs;

		return (this.getDatabaseadmincompetence() == (that.getDatabaseadmincompetence()));
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

			result = result * 37 + (this.getDatabaseadmincompetence() + "").hashCode();
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
	"DatabaseAdminCompetence", //数据库ID
	"AdminCompetenceID", //用户权限编号
	"DatabaseAdminID", //用户数据库ID
	"DatabaseCompetenceID" //权限ID
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum AdminCompetenceColumnNameEnum
{
		/**
		 * 数据库ID
		 */
		Databaseadmincompetence,
		/**
		 * 用户权限编号
		 */
		Admincompetenceid,
		/**
		 * 用户数据库ID
		 */
		Databaseadminid,
		/**
		 * 权限ID
		 */
		Databasecompetenceid
	};
	// [end]
        // [start] 设置和获取 数据库ID, 默认值:0
	// 设置和获取 数据库ID,类型int 默认值:0 开始
	private int databaseadmincompetence = 0;
	/**
	* 获取 数据库ID, 类型int 默认值:0
	 *
	 * @return 数据库ID, 类型int 默认值:0
	 */
	public int getDatabaseadmincompetence()
	{
		return this.databaseadmincompetence; 
	}
	/**
	 * 设置 数据库ID, 类型int 默认值:0
	 *
	 * @param sDatabaseadmincompetence
	 *            数据库ID, 类型int 默认值:0
	 */
	public void setDatabaseadmincompetence(int sDatabaseadmincompetence)
	{
		this.databaseadmincompetence = sDatabaseadmincompetence; 
	}
	// 设置和获取 数据库ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 用户权限编号, 默认值:0
	// 设置和获取 用户权限编号,类型int 默认值:0 开始
	private int admincompetenceid = 0;
	/**
	* 获取 用户权限编号, 类型int 默认值:0
	 *
	 * @return 用户权限编号, 类型int 默认值:0
	 */
	public int getAdmincompetenceid()
	{
		return this.admincompetenceid; 
	}
	/**
	 * 设置 用户权限编号, 类型int 默认值:0
	 *
	 * @param sAdmincompetenceid
	 *            用户权限编号, 类型int 默认值:0
	 */
	public void setAdmincompetenceid(int sAdmincompetenceid)
	{
		this.admincompetenceid = sAdmincompetenceid; 
	}
	// 设置和获取 用户权限编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 用户数据库ID, 默认值:0
	// 设置和获取 用户数据库ID,类型int 默认值:0 开始
	private int databaseadminid = 0;
	/**
	* 获取 用户数据库ID, 类型int 默认值:0
	 *
	 * @return 用户数据库ID, 类型int 默认值:0
	 */
	public int getDatabaseadminid()
	{
		return this.databaseadminid; 
	}
	/**
	 * 设置 用户数据库ID, 类型int 默认值:0
	 *
	 * @param sDatabaseadminid
	 *            用户数据库ID, 类型int 默认值:0
	 */
	public void setDatabaseadminid(int sDatabaseadminid)
	{
		this.databaseadminid = sDatabaseadminid; 
	}
	// 设置和获取 用户数据库ID, 类型int 默认值:0 结束
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
            sbStr.append(getDatabaseadmincompetence()).append(strSplit);
            sbStr.append(getAdmincompetenceid()).append(strSplit);
            sbStr.append(getDatabaseadminid()).append(strSplit);
            sbStr.append(getDatabasecompetenceid()).append(strSplit);

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

            if (objs.length != 4)
            {
                return;
            }
            if (objs[0] != null || objs[0].length() >= 1)
            {
                setDatabaseadmincompetence(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setAdmincompetenceid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setDatabaseadminid(com.colorwinglib.Converts.StrToInt(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setDatabasecompetenceid(com.colorwinglib.Converts.StrToInt(objs[3]));
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
            sbStr.append("&Databaseadmincompetence=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseadmincompetence()));//数据库ID
            sbStr.append("&Admincompetenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdmincompetenceid()));//用户权限编号
            sbStr.append("&Databaseadminid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseadminid()));//用户数据库ID
            sbStr.append("&Databasecompetenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasecompetenceid()));//权限ID

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
			if (columnName.equals("Databaseadmincompetence"))
				sbStr.append("&Databaseadmincompetence=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseadmincompetence()));//数据库ID
			if (columnName.equals("Admincompetenceid"))
				sbStr.append("&Admincompetenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdmincompetenceid()));//用户权限编号
			if (columnName.equals("Databaseadminid"))
				sbStr.append("&Databaseadminid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseadminid()));//用户数据库ID
			if (columnName.equals("Databasecompetenceid"))
				sbStr.append("&Databasecompetenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasecompetenceid()));//权限ID
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
            sbStr.append("&databaseadmincompetence=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseadmincompetence()));//数据库ID
            sbStr.append("&admincompetenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdmincompetenceid()));//用户权限编号
            sbStr.append("&databaseadminid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseadminid()));//用户数据库ID
            sbStr.append("&databasecompetenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasecompetenceid()));//权限ID

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
			if (columnName.equals("Databaseadmincompetence"))
				sbStr.append("&databaseadmincompetence=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseadmincompetence()));//数据库ID
			if (columnName.equals("Admincompetenceid"))
				sbStr.append("&admincompetenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getAdmincompetenceid()));//用户权限编号
			if (columnName.equals("Databaseadminid"))
				sbStr.append("&databaseadminid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseadminid()));//用户数据库ID
			if (columnName.equals("Databasecompetenceid"))
				sbStr.append("&databasecompetenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasecompetenceid()));//权限ID
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
	public static AdminCompetenceInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			AdminCompetenceInfo obj = (AdminCompetenceInfo) in.readObject();
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
	public String ToModifyString(AdminCompetenceInfo objOld)
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
	public String ToModifyString(AdminCompetenceInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getDatabaseadmincompetence(), objOld.getDatabaseadmincompetence()))
			sbStr.append("Databaseadmincompetence 数据库ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabaseadmincompetence())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabaseadmincompetence())).append("]").append(strSplit);// 数据库ID
		if (com.colorwinglib.Validate.isEquals(getAdmincompetenceid(), objOld.getAdmincompetenceid()))
			sbStr.append("Admincompetenceid 用户权限编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getAdmincompetenceid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAdmincompetenceid())).append("]").append(strSplit);// 用户权限编号
		if (com.colorwinglib.Validate.isEquals(getDatabaseadminid(), objOld.getDatabaseadminid()))
			sbStr.append("Databaseadminid 用户数据库ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabaseadminid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabaseadminid())).append("]").append(strSplit);// 用户数据库ID
		if (com.colorwinglib.Validate.isEquals(getDatabasecompetenceid(), objOld.getDatabasecompetenceid()))
			sbStr.append("Databasecompetenceid 权限ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabasecompetenceid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabasecompetenceid())).append("]").append(strSplit);// 权限ID
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
			json.put("Databaseadmincompetence", getDatabaseadmincompetence());// 数据库ID
			json.put("Admincompetenceid", getAdmincompetenceid());// 用户权限编号
			json.put("Databaseadminid", getDatabaseadminid());// 用户数据库ID
			json.put("Databasecompetenceid", getDatabasecompetenceid());// 权限ID
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
			setDatabaseadmincompetence(json.getInt("Databaseadmincompetence"));// 数据库ID
			setAdmincompetenceid(json.getInt("Admincompetenceid"));// 用户权限编号
			setDatabaseadminid(json.getInt("Databaseadminid"));// 用户数据库ID
			setDatabasecompetenceid(json.getInt("Databasecompetenceid"));// 权限ID

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
		sbStr.append("<AdminCompetenceInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //数据库ID
			sbStr.append("    <Databaseadmincompetence>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabaseadmincompetence()));
			sbStr.append("</Databaseadmincompetence>\n");
            //用户权限编号
			sbStr.append("    <Admincompetenceid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAdmincompetenceid()));
			sbStr.append("</Admincompetenceid>\n");
            //用户数据库ID
			sbStr.append("    <Databaseadminid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabaseadminid()));
			sbStr.append("</Databaseadminid>\n");
            //权限ID
			sbStr.append("    <Databasecompetenceid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabasecompetenceid()));
			sbStr.append("</Databasecompetenceid>\n");
		sbStr.append("</AdminCompetenceInfo>\n");
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
	// GetAdminCompetenceInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetAdminCompetenceInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static AdminCompetenceInfo GetAdminCompetenceInfoFormFileName(String filename)
	{
		return GetAdminCompetenceInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetAdminCompetenceInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static AdminCompetenceInfo GetAdminCompetenceInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetAdminCompetenceInfoFormXml(xml, encoding);
	}

	// [end]

	// GetAdminCompetenceInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetAdminCompetenceInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static AdminCompetenceInfo GetAdminCompetenceInfoFormXml(String xml)
	{
		return GetAdminCompetenceInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetAdminCompetenceInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static AdminCompetenceInfo GetAdminCompetenceInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		AdminCompetenceInfo objAdminCompetenceInfo = new AdminCompetenceInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//数据库ID
				if (foo.elementText("Databaseadmincompetence") != null)
					objAdminCompetenceInfo.setDatabaseadmincompetence(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseadmincompetence")));
				//用户权限编号
				if (foo.elementText("Admincompetenceid") != null)
					objAdminCompetenceInfo.setAdmincompetenceid(com.colorwinglib.Converts.StrToInt(foo.elementText("Admincompetenceid")));
				//用户数据库ID
				if (foo.elementText("Databaseadminid") != null)
					objAdminCompetenceInfo.setDatabaseadminid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseadminid")));
				//权限ID
				if (foo.elementText("Databasecompetenceid") != null)
					objAdminCompetenceInfo.setDatabasecompetenceid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasecompetenceid")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objAdminCompetenceInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public AdminCompetenceInfo Copy()
	{
		AdminCompetenceInfo objAdminCompetenceInfo = new AdminCompetenceInfo();
		objAdminCompetenceInfo.setDatabaseadmincompetence(this.getDatabaseadmincompetence());//数据库ID
		objAdminCompetenceInfo.setAdmincompetenceid(this.getAdmincompetenceid());//用户权限编号
		objAdminCompetenceInfo.setDatabaseadminid(this.getDatabaseadminid());//用户数据库ID
		objAdminCompetenceInfo.setDatabasecompetenceid(this.getDatabasecompetenceid());//权限ID
		return objAdminCompetenceInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
