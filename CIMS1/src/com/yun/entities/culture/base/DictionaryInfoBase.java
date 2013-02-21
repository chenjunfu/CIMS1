
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Dictionary 的描述
 * 实体类基本类
 */
public class DictionaryInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311463215631L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public DictionaryInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public DictionaryInfoBase(int sDictionaryid)
	{
		this.setDictionaryid(sDictionaryid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public DictionaryInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setDictionaryid(rs.getInt("DictionaryId"));//DictionaryId
		setName(rs.getString("Name"));//显示名称
		setTablename(rs.getString("TableName"));//对应表名
		setIsuse(rs.getInt("IsUse"));//是否启用
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public DictionaryInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//DictionaryId
			if (columnName.equals("DictionaryId"))
			{
				setDictionaryid(rs.getInt("DictionaryId"));
				continue;
			}
			//显示名称
			if (columnName.equals("Name"))
			{
				setName(rs.getString("Name"));
				continue;
			}
			//对应表名
			if (columnName.equals("TableName"))
			{
				setTablename(rs.getString("TableName"));
				continue;
			}
			//是否启用
			if (columnName.equals("IsUse"))
			{
				setIsuse(rs.getInt("IsUse"));
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
		if (!(rhs instanceof DictionaryInfo))
			return false;
		DictionaryInfo that = (DictionaryInfo) rhs;

		return (this.getDictionaryid() == (that.getDictionaryid()));
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

			result = result * 37 + (this.getDictionaryid() + "").hashCode();
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
	"DictionaryId", //DictionaryId
	"Name", //显示名称
	"TableName", //对应表名
	"IsUse" //是否启用
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum DictionaryColumnNameEnum
{
		/**
		 * DictionaryId
		 */
		Dictionaryid,
		/**
		 * 显示名称
		 */
		Name,
		/**
		 * 对应表名
		 */
		Tablename,
		/**
		 * 是否启用
		 */
		Isuse
	};
	// [end]
        // [start] 设置和获取 DictionaryId, 默认值:0
	// 设置和获取 DictionaryId,类型int 默认值:0 开始
	private int dictionaryid = 0;
	/**
	* 获取 DictionaryId, 类型int 默认值:0
	 *
	 * @return DictionaryId, 类型int 默认值:0
	 */
	public int getDictionaryid()
	{
		return this.dictionaryid; 
	}
	/**
	 * 设置 DictionaryId, 类型int 默认值:0
	 *
	 * @param sDictionaryid
	 *            DictionaryId, 类型int 默认值:0
	 */
	public void setDictionaryid(int sDictionaryid)
	{
		this.dictionaryid = sDictionaryid; 
	}
	// 设置和获取 DictionaryId, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 显示名称, 默认值:""
	// 设置和获取 显示名称,类型String 默认值:"" 开始
	private String name = "";
	/**
	* 获取 显示名称, 类型String 默认值:""
	 *
	 * @return 显示名称, 类型String 默认值:""
	 */
	public String getName()
	{
		return this.name; 
	}
	/**
	 * 设置 显示名称, 类型String 默认值:""
	 *
	 * @param sName
	 *            显示名称, 类型String 默认值:""
	 */
	public void setName(String sName)
	{
		this.name = sName; 
	}
	// 设置和获取 显示名称, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 对应表名, 默认值:""
	// 设置和获取 对应表名,类型String 默认值:"" 开始
	private String tablename = "";
	/**
	* 获取 对应表名, 类型String 默认值:""
	 *
	 * @return 对应表名, 类型String 默认值:""
	 */
	public String getTablename()
	{
		return this.tablename; 
	}
	/**
	 * 设置 对应表名, 类型String 默认值:""
	 *
	 * @param sTablename
	 *            对应表名, 类型String 默认值:""
	 */
	public void setTablename(String sTablename)
	{
		this.tablename = sTablename; 
	}
	// 设置和获取 对应表名, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 是否启用, 默认值:0
	// 设置和获取 是否启用,类型int 默认值:0 开始
	private int isuse = 0;
	/**
	* 获取 是否启用, 类型int 默认值:0
	 *
	 * @return 是否启用, 类型int 默认值:0
	 */
	public int getIsuse()
	{
		return this.isuse; 
	}
	/**
	 * 设置 是否启用, 类型int 默认值:0
	 *
	 * @param sIsuse
	 *            是否启用, 类型int 默认值:0
	 */
	public void setIsuse(int sIsuse)
	{
		this.isuse = sIsuse; 
	}
	// 设置和获取 是否启用, 类型int 默认值:0 结束
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
            sbStr.append(getDictionaryid()).append(strSplit);
            sbStr.append(getName()).append(strSplit);
            sbStr.append(getTablename()).append(strSplit);
            sbStr.append(getIsuse()).append(strSplit);

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
                setDictionaryid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setName(com.colorwinglib.Converts.objToStr(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setTablename(com.colorwinglib.Converts.objToStr(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setIsuse(com.colorwinglib.Converts.StrToInt(objs[3]));
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
            sbStr.append("&Dictionaryid=").append(com.colorwinglib.StringFormat.UrlEncode(getDictionaryid()));//DictionaryId
            sbStr.append("&Name=").append(com.colorwinglib.StringFormat.UrlEncode(getName()));//显示名称
            sbStr.append("&Tablename=").append(com.colorwinglib.StringFormat.UrlEncode(getTablename()));//对应表名
            sbStr.append("&Isuse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsuse()));//是否启用

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
			if (columnName.equals("Dictionaryid"))
				sbStr.append("&Dictionaryid=").append(com.colorwinglib.StringFormat.UrlEncode(getDictionaryid()));//DictionaryId
			if (columnName.equals("Name"))
				sbStr.append("&Name=").append(com.colorwinglib.StringFormat.UrlEncode(getName()));//显示名称
			if (columnName.equals("Tablename"))
				sbStr.append("&Tablename=").append(com.colorwinglib.StringFormat.UrlEncode(getTablename()));//对应表名
			if (columnName.equals("Isuse"))
				sbStr.append("&Isuse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsuse()));//是否启用
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
            sbStr.append("&dictionaryid=").append(com.colorwinglib.StringFormat.UrlEncode(getDictionaryid()));//DictionaryId
            sbStr.append("&name=").append(com.colorwinglib.StringFormat.UrlEncode(getName()));//显示名称
            sbStr.append("&tablename=").append(com.colorwinglib.StringFormat.UrlEncode(getTablename()));//对应表名
            sbStr.append("&isuse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsuse()));//是否启用

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
			if (columnName.equals("Dictionaryid"))
				sbStr.append("&dictionaryid=").append(com.colorwinglib.StringFormat.UrlEncode(getDictionaryid()));//DictionaryId
			if (columnName.equals("Name"))
				sbStr.append("&name=").append(com.colorwinglib.StringFormat.UrlEncode(getName()));//显示名称
			if (columnName.equals("Tablename"))
				sbStr.append("&tablename=").append(com.colorwinglib.StringFormat.UrlEncode(getTablename()));//对应表名
			if (columnName.equals("Isuse"))
				sbStr.append("&isuse=").append(com.colorwinglib.StringFormat.UrlEncode(getIsuse()));//是否启用
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
	public static DictionaryInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			DictionaryInfo obj = (DictionaryInfo) in.readObject();
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
	public String ToModifyString(DictionaryInfo objOld)
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
	public String ToModifyString(DictionaryInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getDictionaryid(), objOld.getDictionaryid()))
			sbStr.append("Dictionaryid DictionaryId:[").append(com.colorwinglib.Converts.objToStr(objOld.getDictionaryid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDictionaryid())).append("]").append(strSplit);// DictionaryId
		if (com.colorwinglib.Validate.isEquals(getName(), objOld.getName()))
			sbStr.append("Name 显示名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getName())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getName())).append("]").append(strSplit);// 显示名称
		if (com.colorwinglib.Validate.isEquals(getTablename(), objOld.getTablename()))
			sbStr.append("Tablename 对应表名:[").append(com.colorwinglib.Converts.objToStr(objOld.getTablename())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getTablename())).append("]").append(strSplit);// 对应表名
		if (com.colorwinglib.Validate.isEquals(getIsuse(), objOld.getIsuse()))
			sbStr.append("Isuse 是否启用:[").append(com.colorwinglib.Converts.objToStr(objOld.getIsuse())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getIsuse())).append("]").append(strSplit);// 是否启用
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
			json.put("Dictionaryid", getDictionaryid());// DictionaryId
			json.put("Name", getName());// 显示名称
			json.put("Tablename", getTablename());// 对应表名
			json.put("Isuse", getIsuse());// 是否启用
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
			setDictionaryid(json.getInt("Dictionaryid"));// DictionaryId
			setName(json.getString("Name"));// 显示名称
			setTablename(json.getString("Tablename"));// 对应表名
			setIsuse(json.getInt("Isuse"));// 是否启用

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
		sbStr.append("<DictionaryInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //DictionaryId
			sbStr.append("    <Dictionaryid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDictionaryid()));
			sbStr.append("</Dictionaryid>\n");
            //显示名称
			sbStr.append("    <Name>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getName()));
			sbStr.append("</Name>\n");
            //对应表名
			sbStr.append("    <Tablename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getTablename()));
			sbStr.append("</Tablename>\n");
            //是否启用
			sbStr.append("    <Isuse>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getIsuse()));
			sbStr.append("</Isuse>\n");
		sbStr.append("</DictionaryInfo>\n");
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
	// GetDictionaryInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetDictionaryInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static DictionaryInfo GetDictionaryInfoFormFileName(String filename)
	{
		return GetDictionaryInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetDictionaryInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static DictionaryInfo GetDictionaryInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetDictionaryInfoFormXml(xml, encoding);
	}

	// [end]

	// GetDictionaryInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetDictionaryInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static DictionaryInfo GetDictionaryInfoFormXml(String xml)
	{
		return GetDictionaryInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetDictionaryInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static DictionaryInfo GetDictionaryInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		DictionaryInfo objDictionaryInfo = new DictionaryInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//DictionaryId
				if (foo.elementText("Dictionaryid") != null)
					objDictionaryInfo.setDictionaryid(com.colorwinglib.Converts.StrToInt(foo.elementText("Dictionaryid")));
				//显示名称
				if (foo.elementText("Name") != null)
					objDictionaryInfo.setName(com.colorwinglib.Converts.objToStr(foo.elementText("Name")));
				//对应表名
				if (foo.elementText("Tablename") != null)
					objDictionaryInfo.setTablename(com.colorwinglib.Converts.objToStr(foo.elementText("Tablename")));
				//是否启用
				if (foo.elementText("Isuse") != null)
					objDictionaryInfo.setIsuse(com.colorwinglib.Converts.StrToInt(foo.elementText("Isuse")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objDictionaryInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public DictionaryInfo Copy()
	{
		DictionaryInfo objDictionaryInfo = new DictionaryInfo();
		objDictionaryInfo.setDictionaryid(this.getDictionaryid());//DictionaryId
		objDictionaryInfo.setName(this.getName());//显示名称
		objDictionaryInfo.setTablename(this.getTablename());//对应表名
		objDictionaryInfo.setIsuse(this.getIsuse());//是否启用
		return objDictionaryInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
