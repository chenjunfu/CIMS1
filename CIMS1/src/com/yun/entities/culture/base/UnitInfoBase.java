
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Unit 单位信息的描述
 * 实体类基本类
 */
public class UnitInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311582553145L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public UnitInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public UnitInfoBase(int sDatabaseunitid)
	{
		this.setDatabaseunitid(sDatabaseunitid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public UnitInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setDatabaseunitid(rs.getInt("DatabaseUnitID"));//单位ID
		setUnitid(rs.getInt("UnitID"));//单位编号
		setUnitname(rs.getString("UnitName"));//单位名称
		setAdress(rs.getString("Adress"));//单位地址
		setPhone(rs.getString("Phone"));//联系电话
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public UnitInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//单位ID
			if (columnName.equals("DatabaseUnitID"))
			{
				setDatabaseunitid(rs.getInt("DatabaseUnitID"));
				continue;
			}
			//单位编号
			if (columnName.equals("UnitID"))
			{
				setUnitid(rs.getInt("UnitID"));
				continue;
			}
			//单位名称
			if (columnName.equals("UnitName"))
			{
				setUnitname(rs.getString("UnitName"));
				continue;
			}
			//单位地址
			if (columnName.equals("Adress"))
			{
				setAdress(rs.getString("Adress"));
				continue;
			}
			//联系电话
			if (columnName.equals("Phone"))
			{
				setPhone(rs.getString("Phone"));
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
		if (!(rhs instanceof UnitInfo))
			return false;
		UnitInfo that = (UnitInfo) rhs;

		return (this.getDatabaseunitid() == (that.getDatabaseunitid()));
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

			result = result * 37 + (this.getDatabaseunitid() + "").hashCode();
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
	"DatabaseUnitID", //单位ID
	"UnitID", //单位编号
	"UnitName", //单位名称
	"Adress", //单位地址
	"Phone" //联系电话
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum UnitColumnNameEnum
{
		/**
		 * 单位ID
		 */
		Databaseunitid,
		/**
		 * 单位编号
		 */
		Unitid,
		/**
		 * 单位名称
		 */
		Unitname,
		/**
		 * 单位地址
		 */
		Adress,
		/**
		 * 联系电话
		 */
		Phone
	};
	// [end]
        // [start] 设置和获取 单位ID, 默认值:0
	// 设置和获取 单位ID,类型int 默认值:0 开始
	private int databaseunitid = 0;
	/**
	* 获取 单位ID, 类型int 默认值:0
	 *
	 * @return 单位ID, 类型int 默认值:0
	 */
	public int getDatabaseunitid()
	{
		return this.databaseunitid; 
	}
	/**
	 * 设置 单位ID, 类型int 默认值:0
	 *
	 * @param sDatabaseunitid
	 *            单位ID, 类型int 默认值:0
	 */
	public void setDatabaseunitid(int sDatabaseunitid)
	{
		this.databaseunitid = sDatabaseunitid; 
	}
	// 设置和获取 单位ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 单位编号, 默认值:0
	// 设置和获取 单位编号,类型int 默认值:0 开始
	private int unitid = 0;
	/**
	* 获取 单位编号, 类型int 默认值:0
	 *
	 * @return 单位编号, 类型int 默认值:0
	 */
	public int getUnitid()
	{
		return this.unitid; 
	}
	/**
	 * 设置 单位编号, 类型int 默认值:0
	 *
	 * @param sUnitid
	 *            单位编号, 类型int 默认值:0
	 */
	public void setUnitid(int sUnitid)
	{
		this.unitid = sUnitid; 
	}
	// 设置和获取 单位编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 单位名称, 默认值:""
	// 设置和获取 单位名称,类型String 默认值:"" 开始
	private String unitname = "";
	/**
	* 获取 单位名称, 类型String 默认值:""
	 *
	 * @return 单位名称, 类型String 默认值:""
	 */
	public String getUnitname()
	{
		return this.unitname; 
	}
	/**
	 * 设置 单位名称, 类型String 默认值:""
	 *
	 * @param sUnitname
	 *            单位名称, 类型String 默认值:""
	 */
	public void setUnitname(String sUnitname)
	{
		this.unitname = sUnitname; 
	}
	// 设置和获取 单位名称, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 单位地址, 默认值:""
	// 设置和获取 单位地址,类型String 默认值:"" 开始
	private String adress = "";
	/**
	* 获取 单位地址, 类型String 默认值:""
	 *
	 * @return 单位地址, 类型String 默认值:""
	 */
	public String getAdress()
	{
		return this.adress; 
	}
	/**
	 * 设置 单位地址, 类型String 默认值:""
	 *
	 * @param sAdress
	 *            单位地址, 类型String 默认值:""
	 */
	public void setAdress(String sAdress)
	{
		this.adress = sAdress; 
	}
	// 设置和获取 单位地址, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 联系电话, 默认值:""
	// 设置和获取 联系电话,类型String 默认值:"" 开始
	private String phone = "";
	/**
	* 获取 联系电话, 类型String 默认值:""
	 *
	 * @return 联系电话, 类型String 默认值:""
	 */
	public String getPhone()
	{
		return this.phone; 
	}
	/**
	 * 设置 联系电话, 类型String 默认值:""
	 *
	 * @param sPhone
	 *            联系电话, 类型String 默认值:""
	 */
	public void setPhone(String sPhone)
	{
		this.phone = sPhone; 
	}
	// 设置和获取 联系电话, 类型String 默认值:"" 结束
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
            sbStr.append(getDatabaseunitid()).append(strSplit);
            sbStr.append(getUnitid()).append(strSplit);
            sbStr.append(getUnitname()).append(strSplit);
            sbStr.append(getAdress()).append(strSplit);
            sbStr.append(getPhone()).append(strSplit);

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
                setDatabaseunitid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setUnitid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setUnitname(com.colorwinglib.Converts.objToStr(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setAdress(com.colorwinglib.Converts.objToStr(objs[3]));
            }
            if (objs[4] != null || objs[4].length() >= 1)
            {
                setPhone(com.colorwinglib.Converts.objToStr(objs[4]));
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
            sbStr.append("&Databaseunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseunitid()));//单位ID
            sbStr.append("&Unitid=").append(com.colorwinglib.StringFormat.UrlEncode(getUnitid()));//单位编号
            sbStr.append("&Unitname=").append(com.colorwinglib.StringFormat.UrlEncode(getUnitname()));//单位名称
            sbStr.append("&Adress=").append(com.colorwinglib.StringFormat.UrlEncode(getAdress()));//单位地址
            sbStr.append("&Phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//联系电话

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
			if (columnName.equals("Databaseunitid"))
				sbStr.append("&Databaseunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseunitid()));//单位ID
			if (columnName.equals("Unitid"))
				sbStr.append("&Unitid=").append(com.colorwinglib.StringFormat.UrlEncode(getUnitid()));//单位编号
			if (columnName.equals("Unitname"))
				sbStr.append("&Unitname=").append(com.colorwinglib.StringFormat.UrlEncode(getUnitname()));//单位名称
			if (columnName.equals("Adress"))
				sbStr.append("&Adress=").append(com.colorwinglib.StringFormat.UrlEncode(getAdress()));//单位地址
			if (columnName.equals("Phone"))
				sbStr.append("&Phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//联系电话
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
            sbStr.append("&databaseunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseunitid()));//单位ID
            sbStr.append("&unitid=").append(com.colorwinglib.StringFormat.UrlEncode(getUnitid()));//单位编号
            sbStr.append("&unitname=").append(com.colorwinglib.StringFormat.UrlEncode(getUnitname()));//单位名称
            sbStr.append("&adress=").append(com.colorwinglib.StringFormat.UrlEncode(getAdress()));//单位地址
            sbStr.append("&phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//联系电话

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
			if (columnName.equals("Databaseunitid"))
				sbStr.append("&databaseunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseunitid()));//单位ID
			if (columnName.equals("Unitid"))
				sbStr.append("&unitid=").append(com.colorwinglib.StringFormat.UrlEncode(getUnitid()));//单位编号
			if (columnName.equals("Unitname"))
				sbStr.append("&unitname=").append(com.colorwinglib.StringFormat.UrlEncode(getUnitname()));//单位名称
			if (columnName.equals("Adress"))
				sbStr.append("&adress=").append(com.colorwinglib.StringFormat.UrlEncode(getAdress()));//单位地址
			if (columnName.equals("Phone"))
				sbStr.append("&phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//联系电话
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
	public static UnitInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			UnitInfo obj = (UnitInfo) in.readObject();
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
	public String ToModifyString(UnitInfo objOld)
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
	public String ToModifyString(UnitInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getDatabaseunitid(), objOld.getDatabaseunitid()))
			sbStr.append("Databaseunitid 单位ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabaseunitid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabaseunitid())).append("]").append(strSplit);// 单位ID
		if (com.colorwinglib.Validate.isEquals(getUnitid(), objOld.getUnitid()))
			sbStr.append("Unitid 单位编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getUnitid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getUnitid())).append("]").append(strSplit);// 单位编号
		if (com.colorwinglib.Validate.isEquals(getUnitname(), objOld.getUnitname()))
			sbStr.append("Unitname 单位名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getUnitname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getUnitname())).append("]").append(strSplit);// 单位名称
		if (com.colorwinglib.Validate.isEquals(getAdress(), objOld.getAdress()))
			sbStr.append("Adress 单位地址:[").append(com.colorwinglib.Converts.objToStr(objOld.getAdress())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAdress())).append("]").append(strSplit);// 单位地址
		if (com.colorwinglib.Validate.isEquals(getPhone(), objOld.getPhone()))
			sbStr.append("Phone 联系电话:[").append(com.colorwinglib.Converts.objToStr(objOld.getPhone())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPhone())).append("]").append(strSplit);// 联系电话
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
			json.put("Databaseunitid", getDatabaseunitid());// 单位ID
			json.put("Unitid", getUnitid());// 单位编号
			json.put("Unitname", getUnitname());// 单位名称
			json.put("Adress", getAdress());// 单位地址
			json.put("Phone", getPhone());// 联系电话
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
			setDatabaseunitid(json.getInt("Databaseunitid"));// 单位ID
			setUnitid(json.getInt("Unitid"));// 单位编号
			setUnitname(json.getString("Unitname"));// 单位名称
			setAdress(json.getString("Adress"));// 单位地址
			setPhone(json.getString("Phone"));// 联系电话

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
		sbStr.append("<UnitInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //单位ID
			sbStr.append("    <Databaseunitid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabaseunitid()));
			sbStr.append("</Databaseunitid>\n");
            //单位编号
			sbStr.append("    <Unitid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getUnitid()));
			sbStr.append("</Unitid>\n");
            //单位名称
			sbStr.append("    <Unitname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getUnitname()));
			sbStr.append("</Unitname>\n");
            //单位地址
			sbStr.append("    <Adress>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAdress()));
			sbStr.append("</Adress>\n");
            //联系电话
			sbStr.append("    <Phone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPhone()));
			sbStr.append("</Phone>\n");
		sbStr.append("</UnitInfo>\n");
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
	// GetUnitInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetUnitInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static UnitInfo GetUnitInfoFormFileName(String filename)
	{
		return GetUnitInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetUnitInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static UnitInfo GetUnitInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetUnitInfoFormXml(xml, encoding);
	}

	// [end]

	// GetUnitInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetUnitInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static UnitInfo GetUnitInfoFormXml(String xml)
	{
		return GetUnitInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetUnitInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static UnitInfo GetUnitInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		UnitInfo objUnitInfo = new UnitInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//单位ID
				if (foo.elementText("Databaseunitid") != null)
					objUnitInfo.setDatabaseunitid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseunitid")));
				//单位编号
				if (foo.elementText("Unitid") != null)
					objUnitInfo.setUnitid(com.colorwinglib.Converts.StrToInt(foo.elementText("Unitid")));
				//单位名称
				if (foo.elementText("Unitname") != null)
					objUnitInfo.setUnitname(com.colorwinglib.Converts.objToStr(foo.elementText("Unitname")));
				//单位地址
				if (foo.elementText("Adress") != null)
					objUnitInfo.setAdress(com.colorwinglib.Converts.objToStr(foo.elementText("Adress")));
				//联系电话
				if (foo.elementText("Phone") != null)
					objUnitInfo.setPhone(com.colorwinglib.Converts.objToStr(foo.elementText("Phone")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objUnitInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public UnitInfo Copy()
	{
		UnitInfo objUnitInfo = new UnitInfo();
		objUnitInfo.setDatabaseunitid(this.getDatabaseunitid());//单位ID
		objUnitInfo.setUnitid(this.getUnitid());//单位编号
		objUnitInfo.setUnitname(this.getUnitname());//单位名称
		objUnitInfo.setAdress(this.getAdress());//单位地址
		objUnitInfo.setPhone(this.getPhone());//联系电话
		return objUnitInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
