﻿
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Age 年龄段表的描述
 * 实体类基本类
 */
public class AgeInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311453293732L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public AgeInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public AgeInfoBase(int sAgedatabaseid)
	{
		this.setAgedatabaseid(sAgedatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public AgeInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setAgedatabaseid(rs.getInt("AgedatabaseID"));//AgedatabaseID
		setAgeid(rs.getInt("AgeID"));//年龄段编号
		setAgename(rs.getString("AgeName"));//年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public AgeInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//AgedatabaseID
			if (columnName.equals("AgedatabaseID"))
			{
				setAgedatabaseid(rs.getInt("AgedatabaseID"));
				continue;
			}
			//年龄段编号
			if (columnName.equals("AgeID"))
			{
				setAgeid(rs.getInt("AgeID"));
				continue;
			}
			//年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
			if (columnName.equals("AgeName"))
			{
				setAgename(rs.getString("AgeName"));
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
		if (!(rhs instanceof AgeInfo))
			return false;
		AgeInfo that = (AgeInfo) rhs;

		return (this.getAgedatabaseid() == (that.getAgedatabaseid()));
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

			result = result * 37 + (this.getAgedatabaseid() + "").hashCode();
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
	"AgedatabaseID", //AgedatabaseID
	"AgeID", //年龄段编号
	"AgeName" //年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum AgeColumnNameEnum
{
		/**
		 * AgedatabaseID
		 */
		Agedatabaseid,
		/**
		 * 年龄段编号
		 */
		Ageid,
		/**
		 * 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
		 */
		Agename
	};
	// [end]
        // [start] 设置和获取 AgedatabaseID, 默认值:0
	// 设置和获取 AgedatabaseID,类型int 默认值:0 开始
	private int agedatabaseid = 0;
	/**
	* 获取 AgedatabaseID, 类型int 默认值:0
	 *
	 * @return AgedatabaseID, 类型int 默认值:0
	 */
	public int getAgedatabaseid()
	{
		return this.agedatabaseid; 
	}
	/**
	 * 设置 AgedatabaseID, 类型int 默认值:0
	 *
	 * @param sAgedatabaseid
	 *            AgedatabaseID, 类型int 默认值:0
	 */
	public void setAgedatabaseid(int sAgedatabaseid)
	{
		this.agedatabaseid = sAgedatabaseid; 
	}
	// 设置和获取 AgedatabaseID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 年龄段编号, 默认值:0
	// 设置和获取 年龄段编号,类型int 默认值:0 开始
	private int ageid = 0;
	/**
	* 获取 年龄段编号, 类型int 默认值:0
	 *
	 * @return 年龄段编号, 类型int 默认值:0
	 */
	public int getAgeid()
	{
		return this.ageid; 
	}
	/**
	 * 设置 年龄段编号, 类型int 默认值:0
	 *
	 * @param sAgeid
	 *            年龄段编号, 类型int 默认值:0
	 */
	public void setAgeid(int sAgeid)
	{
		this.ageid = sAgeid; 
	}
	// 设置和获取 年龄段编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60, 默认值:""
	// 设置和获取 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60,类型String 默认值:"" 开始
	private String agename = "";
	/**
	* 获取 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60, 类型String 默认值:""
	 *
	 * @return 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60, 类型String 默认值:""
	 */
	public String getAgename()
	{
		return this.agename; 
	}
	/**
	 * 设置 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60, 类型String 默认值:""
	 *
	 * @param sAgename
	 *            年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60, 类型String 默认值:""
	 */
	public void setAgename(String sAgename)
	{
		this.agename = sAgename; 
	}
	// 设置和获取 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60, 类型String 默认值:"" 结束
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
            sbStr.append(getAgedatabaseid()).append(strSplit);
            sbStr.append(getAgeid()).append(strSplit);
            sbStr.append(getAgename()).append(strSplit);

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
                setAgedatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setAgeid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setAgename(com.colorwinglib.Converts.objToStr(objs[2]));
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
            sbStr.append("&Agedatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getAgedatabaseid()));//AgedatabaseID
            sbStr.append("&Ageid=").append(com.colorwinglib.StringFormat.UrlEncode(getAgeid()));//年龄段编号
            sbStr.append("&Agename=").append(com.colorwinglib.StringFormat.UrlEncode(getAgename()));//年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60

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
			if (columnName.equals("Agedatabaseid"))
				sbStr.append("&Agedatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getAgedatabaseid()));//AgedatabaseID
			if (columnName.equals("Ageid"))
				sbStr.append("&Ageid=").append(com.colorwinglib.StringFormat.UrlEncode(getAgeid()));//年龄段编号
			if (columnName.equals("Agename"))
				sbStr.append("&Agename=").append(com.colorwinglib.StringFormat.UrlEncode(getAgename()));//年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
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
            sbStr.append("&agedatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getAgedatabaseid()));//AgedatabaseID
            sbStr.append("&ageid=").append(com.colorwinglib.StringFormat.UrlEncode(getAgeid()));//年龄段编号
            sbStr.append("&agename=").append(com.colorwinglib.StringFormat.UrlEncode(getAgename()));//年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60

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
			if (columnName.equals("Agedatabaseid"))
				sbStr.append("&agedatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getAgedatabaseid()));//AgedatabaseID
			if (columnName.equals("Ageid"))
				sbStr.append("&ageid=").append(com.colorwinglib.StringFormat.UrlEncode(getAgeid()));//年龄段编号
			if (columnName.equals("Agename"))
				sbStr.append("&agename=").append(com.colorwinglib.StringFormat.UrlEncode(getAgename()));//年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
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
	public static AgeInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			AgeInfo obj = (AgeInfo) in.readObject();
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
	public String ToModifyString(AgeInfo objOld)
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
	public String ToModifyString(AgeInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getAgedatabaseid(), objOld.getAgedatabaseid()))
			sbStr.append("Agedatabaseid AgedatabaseID:[").append(com.colorwinglib.Converts.objToStr(objOld.getAgedatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAgedatabaseid())).append("]").append(strSplit);// AgedatabaseID
		if (com.colorwinglib.Validate.isEquals(getAgeid(), objOld.getAgeid()))
			sbStr.append("Ageid 年龄段编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getAgeid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAgeid())).append("]").append(strSplit);// 年龄段编号
		if (com.colorwinglib.Validate.isEquals(getAgename(), objOld.getAgename()))
			sbStr.append("Agename 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60:[").append(com.colorwinglib.Converts.objToStr(objOld.getAgename())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAgename())).append("]").append(strSplit);// 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
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
			json.put("Agedatabaseid", getAgedatabaseid());// AgedatabaseID
			json.put("Ageid", getAgeid());// 年龄段编号
			json.put("Agename", getAgename());// 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
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
			setAgedatabaseid(json.getInt("Agedatabaseid"));// AgedatabaseID
			setAgeid(json.getInt("Ageid"));// 年龄段编号
			setAgename(json.getString("Agename"));// 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60

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
		sbStr.append("<AgeInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //AgedatabaseID
			sbStr.append("    <Agedatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAgedatabaseid()));
			sbStr.append("</Agedatabaseid>\n");
            //年龄段编号
			sbStr.append("    <Ageid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAgeid()));
			sbStr.append("</Ageid>\n");
            //年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
			sbStr.append("    <Agename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAgename()));
			sbStr.append("</Agename>\n");
		sbStr.append("</AgeInfo>\n");
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
	// GetAgeInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetAgeInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static AgeInfo GetAgeInfoFormFileName(String filename)
	{
		return GetAgeInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetAgeInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static AgeInfo GetAgeInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetAgeInfoFormXml(xml, encoding);
	}

	// [end]

	// GetAgeInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetAgeInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static AgeInfo GetAgeInfoFormXml(String xml)
	{
		return GetAgeInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetAgeInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static AgeInfo GetAgeInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		AgeInfo objAgeInfo = new AgeInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//AgedatabaseID
				if (foo.elementText("Agedatabaseid") != null)
					objAgeInfo.setAgedatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Agedatabaseid")));
				//年龄段编号
				if (foo.elementText("Ageid") != null)
					objAgeInfo.setAgeid(com.colorwinglib.Converts.StrToInt(foo.elementText("Ageid")));
				//年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
				if (foo.elementText("Agename") != null)
					objAgeInfo.setAgename(com.colorwinglib.Converts.objToStr(foo.elementText("Agename")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objAgeInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public AgeInfo Copy()
	{
		AgeInfo objAgeInfo = new AgeInfo();
		objAgeInfo.setAgedatabaseid(this.getAgedatabaseid());//AgedatabaseID
		objAgeInfo.setAgeid(this.getAgeid());//年龄段编号
		objAgeInfo.setAgename(this.getAgename());//年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
		return objAgeInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明

        // [start] 设置和获取 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60, 默认值:""
	private String agenamelabel = "";
	/**
	* 获取 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60, 类型String 默认值:""
	 *
	 * @return 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60, 类型String 默认值:""
	 */
	public String getAgenamelabel()
	{
		if (agenamelabel.length() == 0)
			agenamelabel = com.yun.bll.itemcollection.culture.AgeItemCollection.AgenameText(String.valueOf(getAgename()));
		return this.agenamelabel; 
	}
        // [end]



	 //[end]
}
