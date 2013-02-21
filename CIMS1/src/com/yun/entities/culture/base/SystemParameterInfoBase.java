
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * SystemParameter 的描述
 * 实体类基本类
 */
public class SystemParameterInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311561570395L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public SystemParameterInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public SystemParameterInfoBase(int sDatabaseid)
	{
		this.setDatabaseid(sDatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public SystemParameterInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setDatabaseid(rs.getInt("DatabaseID"));//DatabaseID
		setUnitname(rs.getString("UnitName"));//UnitName
		setDept(rs.getString("Dept"));//Dept
		setAddress(rs.getString("Address"));//Address
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public SystemParameterInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//DatabaseID
			if (columnName.equals("DatabaseID"))
			{
				setDatabaseid(rs.getInt("DatabaseID"));
				continue;
			}
			//UnitName
			if (columnName.equals("UnitName"))
			{
				setUnitname(rs.getString("UnitName"));
				continue;
			}
			//Dept
			if (columnName.equals("Dept"))
			{
				setDept(rs.getString("Dept"));
				continue;
			}
			//Address
			if (columnName.equals("Address"))
			{
				setAddress(rs.getString("Address"));
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
		if (!(rhs instanceof SystemParameterInfo))
			return false;
		SystemParameterInfo that = (SystemParameterInfo) rhs;

		return (this.getDatabaseid() == (that.getDatabaseid()));
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

			result = result * 37 + (this.getDatabaseid() + "").hashCode();
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
	"DatabaseID", //DatabaseID
	"UnitName", //UnitName
	"Dept", //Dept
	"Address" //Address
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum SystemParameterColumnNameEnum
{
		/**
		 * DatabaseID
		 */
		Databaseid,
		/**
		 * UnitName
		 */
		Unitname,
		/**
		 * Dept
		 */
		Dept,
		/**
		 * Address
		 */
		Address
	};
	// [end]
        // [start] 设置和获取 DatabaseID, 默认值:0
	// 设置和获取 DatabaseID,类型int 默认值:0 开始
	private int databaseid = 0;
	/**
	* 获取 DatabaseID, 类型int 默认值:0
	 *
	 * @return DatabaseID, 类型int 默认值:0
	 */
	public int getDatabaseid()
	{
		return this.databaseid; 
	}
	/**
	 * 设置 DatabaseID, 类型int 默认值:0
	 *
	 * @param sDatabaseid
	 *            DatabaseID, 类型int 默认值:0
	 */
	public void setDatabaseid(int sDatabaseid)
	{
		this.databaseid = sDatabaseid; 
	}
	// 设置和获取 DatabaseID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 UnitName, 默认值:""
	// 设置和获取 UnitName,类型String 默认值:"" 开始
	private String unitname = "";
	/**
	* 获取 UnitName, 类型String 默认值:""
	 *
	 * @return UnitName, 类型String 默认值:""
	 */
	public String getUnitname()
	{
		return this.unitname; 
	}
	/**
	 * 设置 UnitName, 类型String 默认值:""
	 *
	 * @param sUnitname
	 *            UnitName, 类型String 默认值:""
	 */
	public void setUnitname(String sUnitname)
	{
		this.unitname = sUnitname; 
	}
	// 设置和获取 UnitName, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 Dept, 默认值:""
	// 设置和获取 Dept,类型String 默认值:"" 开始
	private String dept = "";
	/**
	* 获取 Dept, 类型String 默认值:""
	 *
	 * @return Dept, 类型String 默认值:""
	 */
	public String getDept()
	{
		return this.dept; 
	}
	/**
	 * 设置 Dept, 类型String 默认值:""
	 *
	 * @param sDept
	 *            Dept, 类型String 默认值:""
	 */
	public void setDept(String sDept)
	{
		this.dept = sDept; 
	}
	// 设置和获取 Dept, 类型String 默认值:"" 结束
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
            sbStr.append(getDatabaseid()).append(strSplit);
            sbStr.append(getUnitname()).append(strSplit);
            sbStr.append(getDept()).append(strSplit);
            sbStr.append(getAddress()).append(strSplit);

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
                setDatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setUnitname(com.colorwinglib.Converts.objToStr(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setDept(com.colorwinglib.Converts.objToStr(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setAddress(com.colorwinglib.Converts.objToStr(objs[3]));
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
            sbStr.append("&Databaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseid()));//DatabaseID
            sbStr.append("&Unitname=").append(com.colorwinglib.StringFormat.UrlEncode(getUnitname()));//UnitName
            sbStr.append("&Dept=").append(com.colorwinglib.StringFormat.UrlEncode(getDept()));//Dept
            sbStr.append("&Address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//Address

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
			if (columnName.equals("Databaseid"))
				sbStr.append("&Databaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseid()));//DatabaseID
			if (columnName.equals("Unitname"))
				sbStr.append("&Unitname=").append(com.colorwinglib.StringFormat.UrlEncode(getUnitname()));//UnitName
			if (columnName.equals("Dept"))
				sbStr.append("&Dept=").append(com.colorwinglib.StringFormat.UrlEncode(getDept()));//Dept
			if (columnName.equals("Address"))
				sbStr.append("&Address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//Address
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
            sbStr.append("&databaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseid()));//DatabaseID
            sbStr.append("&unitname=").append(com.colorwinglib.StringFormat.UrlEncode(getUnitname()));//UnitName
            sbStr.append("&dept=").append(com.colorwinglib.StringFormat.UrlEncode(getDept()));//Dept
            sbStr.append("&address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//Address

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
			if (columnName.equals("Databaseid"))
				sbStr.append("&databaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseid()));//DatabaseID
			if (columnName.equals("Unitname"))
				sbStr.append("&unitname=").append(com.colorwinglib.StringFormat.UrlEncode(getUnitname()));//UnitName
			if (columnName.equals("Dept"))
				sbStr.append("&dept=").append(com.colorwinglib.StringFormat.UrlEncode(getDept()));//Dept
			if (columnName.equals("Address"))
				sbStr.append("&address=").append(com.colorwinglib.StringFormat.UrlEncode(getAddress()));//Address
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
	public static SystemParameterInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			SystemParameterInfo obj = (SystemParameterInfo) in.readObject();
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
	public String ToModifyString(SystemParameterInfo objOld)
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
	public String ToModifyString(SystemParameterInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getDatabaseid(), objOld.getDatabaseid()))
			sbStr.append("Databaseid DatabaseID:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabaseid())).append("]").append(strSplit);// DatabaseID
		if (com.colorwinglib.Validate.isEquals(getUnitname(), objOld.getUnitname()))
			sbStr.append("Unitname UnitName:[").append(com.colorwinglib.Converts.objToStr(objOld.getUnitname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getUnitname())).append("]").append(strSplit);// UnitName
		if (com.colorwinglib.Validate.isEquals(getDept(), objOld.getDept()))
			sbStr.append("Dept Dept:[").append(com.colorwinglib.Converts.objToStr(objOld.getDept())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDept())).append("]").append(strSplit);// Dept
		if (com.colorwinglib.Validate.isEquals(getAddress(), objOld.getAddress()))
			sbStr.append("Address Address:[").append(com.colorwinglib.Converts.objToStr(objOld.getAddress())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAddress())).append("]").append(strSplit);// Address
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
			json.put("Databaseid", getDatabaseid());// DatabaseID
			json.put("Unitname", getUnitname());// UnitName
			json.put("Dept", getDept());// Dept
			json.put("Address", getAddress());// Address
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
			setDatabaseid(json.getInt("Databaseid"));// DatabaseID
			setUnitname(json.getString("Unitname"));// UnitName
			setDept(json.getString("Dept"));// Dept
			setAddress(json.getString("Address"));// Address

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
		sbStr.append("<SystemParameterInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //DatabaseID
			sbStr.append("    <Databaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabaseid()));
			sbStr.append("</Databaseid>\n");
            //UnitName
			sbStr.append("    <Unitname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getUnitname()));
			sbStr.append("</Unitname>\n");
            //Dept
			sbStr.append("    <Dept>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDept()));
			sbStr.append("</Dept>\n");
            //Address
			sbStr.append("    <Address>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAddress()));
			sbStr.append("</Address>\n");
		sbStr.append("</SystemParameterInfo>\n");
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
	// GetSystemParameterInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetSystemParameterInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static SystemParameterInfo GetSystemParameterInfoFormFileName(String filename)
	{
		return GetSystemParameterInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemParameterInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemParameterInfo GetSystemParameterInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetSystemParameterInfoFormXml(xml, encoding);
	}

	// [end]

	// GetSystemParameterInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetSystemParameterInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemParameterInfo GetSystemParameterInfoFormXml(String xml)
	{
		return GetSystemParameterInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemParameterInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemParameterInfo GetSystemParameterInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		SystemParameterInfo objSystemParameterInfo = new SystemParameterInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//DatabaseID
				if (foo.elementText("Databaseid") != null)
					objSystemParameterInfo.setDatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseid")));
				//UnitName
				if (foo.elementText("Unitname") != null)
					objSystemParameterInfo.setUnitname(com.colorwinglib.Converts.objToStr(foo.elementText("Unitname")));
				//Dept
				if (foo.elementText("Dept") != null)
					objSystemParameterInfo.setDept(com.colorwinglib.Converts.objToStr(foo.elementText("Dept")));
				//Address
				if (foo.elementText("Address") != null)
					objSystemParameterInfo.setAddress(com.colorwinglib.Converts.objToStr(foo.elementText("Address")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objSystemParameterInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public SystemParameterInfo Copy()
	{
		SystemParameterInfo objSystemParameterInfo = new SystemParameterInfo();
		objSystemParameterInfo.setDatabaseid(this.getDatabaseid());//DatabaseID
		objSystemParameterInfo.setUnitname(this.getUnitname());//UnitName
		objSystemParameterInfo.setDept(this.getDept());//Dept
		objSystemParameterInfo.setAddress(this.getAddress());//Address
		return objSystemParameterInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
