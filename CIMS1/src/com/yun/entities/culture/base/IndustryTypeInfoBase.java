
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * IndustryType 产业项目类别类别表的描述
 * 实体类基本类
 */
public class IndustryTypeInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311495640664L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public IndustryTypeInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public IndustryTypeInfoBase(int sIndustrydatabaseid)
	{
		this.setIndustrydatabaseid(sIndustrydatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public IndustryTypeInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setIndustrydatabaseid(rs.getInt("IndustrydatabaseID"));//IndustrydatabaseID
		setIndustryid(rs.getInt("IndustryID"));//产业项目类别编号
		setIndustryname(rs.getString("IndustryName"));//产业项目类别名称
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public IndustryTypeInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//IndustrydatabaseID
			if (columnName.equals("IndustrydatabaseID"))
			{
				setIndustrydatabaseid(rs.getInt("IndustrydatabaseID"));
				continue;
			}
			//产业项目类别编号
			if (columnName.equals("IndustryID"))
			{
				setIndustryid(rs.getInt("IndustryID"));
				continue;
			}
			//产业项目类别名称
			if (columnName.equals("IndustryName"))
			{
				setIndustryname(rs.getString("IndustryName"));
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
		if (!(rhs instanceof IndustryTypeInfo))
			return false;
		IndustryTypeInfo that = (IndustryTypeInfo) rhs;

		return (this.getIndustrydatabaseid() == (that.getIndustrydatabaseid()));
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

			result = result * 37 + (this.getIndustrydatabaseid() + "").hashCode();
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
	"IndustrydatabaseID", //IndustrydatabaseID
	"IndustryID", //产业项目类别编号
	"IndustryName" //产业项目类别名称
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum IndustryTypeColumnNameEnum
{
		/**
		 * IndustrydatabaseID
		 */
		Industrydatabaseid,
		/**
		 * 产业项目类别编号
		 */
		Industryid,
		/**
		 * 产业项目类别名称
		 */
		Industryname
	};
	// [end]
        // [start] 设置和获取 IndustrydatabaseID, 默认值:0
	// 设置和获取 IndustrydatabaseID,类型int 默认值:0 开始
	private int industrydatabaseid = 0;
	/**
	* 获取 IndustrydatabaseID, 类型int 默认值:0
	 *
	 * @return IndustrydatabaseID, 类型int 默认值:0
	 */
	public int getIndustrydatabaseid()
	{
		return this.industrydatabaseid; 
	}
	/**
	 * 设置 IndustrydatabaseID, 类型int 默认值:0
	 *
	 * @param sIndustrydatabaseid
	 *            IndustrydatabaseID, 类型int 默认值:0
	 */
	public void setIndustrydatabaseid(int sIndustrydatabaseid)
	{
		this.industrydatabaseid = sIndustrydatabaseid; 
	}
	// 设置和获取 IndustrydatabaseID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 产业项目类别编号, 默认值:0
	// 设置和获取 产业项目类别编号,类型int 默认值:0 开始
	private int industryid = 0;
	/**
	* 获取 产业项目类别编号, 类型int 默认值:0
	 *
	 * @return 产业项目类别编号, 类型int 默认值:0
	 */
	public int getIndustryid()
	{
		return this.industryid; 
	}
	/**
	 * 设置 产业项目类别编号, 类型int 默认值:0
	 *
	 * @param sIndustryid
	 *            产业项目类别编号, 类型int 默认值:0
	 */
	public void setIndustryid(int sIndustryid)
	{
		this.industryid = sIndustryid; 
	}
	// 设置和获取 产业项目类别编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 产业项目类别名称, 默认值:""
	// 设置和获取 产业项目类别名称,类型String 默认值:"" 开始
	private String industryname = "";
	/**
	* 获取 产业项目类别名称, 类型String 默认值:""
	 *
	 * @return 产业项目类别名称, 类型String 默认值:""
	 */
	public String getIndustryname()
	{
		return this.industryname; 
	}
	/**
	 * 设置 产业项目类别名称, 类型String 默认值:""
	 *
	 * @param sIndustryname
	 *            产业项目类别名称, 类型String 默认值:""
	 */
	public void setIndustryname(String sIndustryname)
	{
		this.industryname = sIndustryname; 
	}
	// 设置和获取 产业项目类别名称, 类型String 默认值:"" 结束
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
            sbStr.append(getIndustrydatabaseid()).append(strSplit);
            sbStr.append(getIndustryid()).append(strSplit);
            sbStr.append(getIndustryname()).append(strSplit);

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

            if (objs.length != 3)
            {
                return;
            }
            if (objs[0] != null || objs[0].length() >= 1)
            {
                setIndustrydatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setIndustryid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setIndustryname(com.colorwinglib.Converts.objToStr(objs[2]));
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
            sbStr.append("&Industrydatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getIndustrydatabaseid()));//IndustrydatabaseID
            sbStr.append("&Industryid=").append(com.colorwinglib.StringFormat.UrlEncode(getIndustryid()));//产业项目类别编号
            sbStr.append("&Industryname=").append(com.colorwinglib.StringFormat.UrlEncode(getIndustryname()));//产业项目类别名称

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
			if (columnName.equals("Industrydatabaseid"))
				sbStr.append("&Industrydatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getIndustrydatabaseid()));//IndustrydatabaseID
			if (columnName.equals("Industryid"))
				sbStr.append("&Industryid=").append(com.colorwinglib.StringFormat.UrlEncode(getIndustryid()));//产业项目类别编号
			if (columnName.equals("Industryname"))
				sbStr.append("&Industryname=").append(com.colorwinglib.StringFormat.UrlEncode(getIndustryname()));//产业项目类别名称
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
            sbStr.append("&industrydatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getIndustrydatabaseid()));//IndustrydatabaseID
            sbStr.append("&industryid=").append(com.colorwinglib.StringFormat.UrlEncode(getIndustryid()));//产业项目类别编号
            sbStr.append("&industryname=").append(com.colorwinglib.StringFormat.UrlEncode(getIndustryname()));//产业项目类别名称

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
			if (columnName.equals("Industrydatabaseid"))
				sbStr.append("&industrydatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getIndustrydatabaseid()));//IndustrydatabaseID
			if (columnName.equals("Industryid"))
				sbStr.append("&industryid=").append(com.colorwinglib.StringFormat.UrlEncode(getIndustryid()));//产业项目类别编号
			if (columnName.equals("Industryname"))
				sbStr.append("&industryname=").append(com.colorwinglib.StringFormat.UrlEncode(getIndustryname()));//产业项目类别名称
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
	public static IndustryTypeInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			IndustryTypeInfo obj = (IndustryTypeInfo) in.readObject();
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
	public String ToModifyString(IndustryTypeInfo objOld)
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
	public String ToModifyString(IndustryTypeInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getIndustrydatabaseid(), objOld.getIndustrydatabaseid()))
			sbStr.append("Industrydatabaseid IndustrydatabaseID:[").append(com.colorwinglib.Converts.objToStr(objOld.getIndustrydatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getIndustrydatabaseid())).append("]").append(strSplit);// IndustrydatabaseID
		if (com.colorwinglib.Validate.isEquals(getIndustryid(), objOld.getIndustryid()))
			sbStr.append("Industryid 产业项目类别编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getIndustryid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getIndustryid())).append("]").append(strSplit);// 产业项目类别编号
		if (com.colorwinglib.Validate.isEquals(getIndustryname(), objOld.getIndustryname()))
			sbStr.append("Industryname 产业项目类别名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getIndustryname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getIndustryname())).append("]").append(strSplit);// 产业项目类别名称
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
			json.put("Industrydatabaseid", getIndustrydatabaseid());// IndustrydatabaseID
			json.put("Industryid", getIndustryid());// 产业项目类别编号
			json.put("Industryname", getIndustryname());// 产业项目类别名称
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
			setIndustrydatabaseid(json.getInt("Industrydatabaseid"));// IndustrydatabaseID
			setIndustryid(json.getInt("Industryid"));// 产业项目类别编号
			setIndustryname(json.getString("Industryname"));// 产业项目类别名称

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
		sbStr.append("<IndustryTypeInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //IndustrydatabaseID
			sbStr.append("    <Industrydatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getIndustrydatabaseid()));
			sbStr.append("</Industrydatabaseid>\n");
            //产业项目类别编号
			sbStr.append("    <Industryid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getIndustryid()));
			sbStr.append("</Industryid>\n");
            //产业项目类别名称
			sbStr.append("    <Industryname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getIndustryname()));
			sbStr.append("</Industryname>\n");
		sbStr.append("</IndustryTypeInfo>\n");
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
	// GetIndustryTypeInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetIndustryTypeInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static IndustryTypeInfo GetIndustryTypeInfoFormFileName(String filename)
	{
		return GetIndustryTypeInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryTypeInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryTypeInfo GetIndustryTypeInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetIndustryTypeInfoFormXml(xml, encoding);
	}

	// [end]

	// GetIndustryTypeInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetIndustryTypeInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryTypeInfo GetIndustryTypeInfoFormXml(String xml)
	{
		return GetIndustryTypeInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryTypeInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryTypeInfo GetIndustryTypeInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		IndustryTypeInfo objIndustryTypeInfo = new IndustryTypeInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//IndustrydatabaseID
				if (foo.elementText("Industrydatabaseid") != null)
					objIndustryTypeInfo.setIndustrydatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Industrydatabaseid")));
				//产业项目类别编号
				if (foo.elementText("Industryid") != null)
					objIndustryTypeInfo.setIndustryid(com.colorwinglib.Converts.StrToInt(foo.elementText("Industryid")));
				//产业项目类别名称
				if (foo.elementText("Industryname") != null)
					objIndustryTypeInfo.setIndustryname(com.colorwinglib.Converts.objToStr(foo.elementText("Industryname")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objIndustryTypeInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public IndustryTypeInfo Copy()
	{
		IndustryTypeInfo objIndustryTypeInfo = new IndustryTypeInfo();
		objIndustryTypeInfo.setIndustrydatabaseid(this.getIndustrydatabaseid());//IndustrydatabaseID
		objIndustryTypeInfo.setIndustryid(this.getIndustryid());//产业项目类别编号
		objIndustryTypeInfo.setIndustryname(this.getIndustryname());//产业项目类别名称
		return objIndustryTypeInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
