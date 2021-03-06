﻿
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * EnterpristQuality 企业性质表的描述
 * 实体类基本类
 */
public class EnterpristQualityInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311473843766L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public EnterpristQualityInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public EnterpristQualityInfoBase(int sQualitydatabaseid)
	{
		this.setQualitydatabaseid(sQualitydatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public EnterpristQualityInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setQualitydatabaseid(rs.getInt("QualitydatabaseID"));//企业性质编号
		setQualityid(rs.getString("QualityID"));//QualityID
		setQualityname(rs.getString("QualityName"));//企业性质名称
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public EnterpristQualityInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//企业性质编号
			if (columnName.equals("QualitydatabaseID"))
			{
				setQualitydatabaseid(rs.getInt("QualitydatabaseID"));
				continue;
			}
			//QualityID
			if (columnName.equals("QualityID"))
			{
				setQualityid(rs.getString("QualityID"));
				continue;
			}
			//企业性质名称
			if (columnName.equals("QualityName"))
			{
				setQualityname(rs.getString("QualityName"));
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
		if (!(rhs instanceof EnterpristQualityInfo))
			return false;
		EnterpristQualityInfo that = (EnterpristQualityInfo) rhs;

		return (this.getQualitydatabaseid() == (that.getQualitydatabaseid()));
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

			result = result * 37 + (this.getQualitydatabaseid() + "").hashCode();
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
	"QualitydatabaseID", //企业性质编号
	"QualityID", //QualityID
	"QualityName" //企业性质名称
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum EnterpristQualityColumnNameEnum
{
		/**
		 * 企业性质编号
		 */
		Qualitydatabaseid,
		/**
		 * QualityID
		 */
		Qualityid,
		/**
		 * 企业性质名称
		 */
		Qualityname
	};
	// [end]
        // [start] 设置和获取 企业性质编号, 默认值:0
	// 设置和获取 企业性质编号,类型int 默认值:0 开始
	private int qualitydatabaseid = 0;
	/**
	* 获取 企业性质编号, 类型int 默认值:0
	 *
	 * @return 企业性质编号, 类型int 默认值:0
	 */
	public int getQualitydatabaseid()
	{
		return this.qualitydatabaseid; 
	}
	/**
	 * 设置 企业性质编号, 类型int 默认值:0
	 *
	 * @param sQualitydatabaseid
	 *            企业性质编号, 类型int 默认值:0
	 */
	public void setQualitydatabaseid(int sQualitydatabaseid)
	{
		this.qualitydatabaseid = sQualitydatabaseid; 
	}
	// 设置和获取 企业性质编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 QualityID, 默认值:""
	// 设置和获取 QualityID,类型String 默认值:"" 开始
	private String qualityid = "";
	/**
	* 获取 QualityID, 类型String 默认值:""
	 *
	 * @return QualityID, 类型String 默认值:""
	 */
	public String getQualityid()
	{
		return this.qualityid; 
	}
	/**
	 * 设置 QualityID, 类型String 默认值:""
	 *
	 * @param sQualityid
	 *            QualityID, 类型String 默认值:""
	 */
	public void setQualityid(String sQualityid)
	{
		this.qualityid = sQualityid; 
	}
	// 设置和获取 QualityID, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 企业性质名称, 默认值:""
	// 设置和获取 企业性质名称,类型String 默认值:"" 开始
	private String qualityname = "";
	/**
	* 获取 企业性质名称, 类型String 默认值:""
	 *
	 * @return 企业性质名称, 类型String 默认值:""
	 */
	public String getQualityname()
	{
		return this.qualityname; 
	}
	/**
	 * 设置 企业性质名称, 类型String 默认值:""
	 *
	 * @param sQualityname
	 *            企业性质名称, 类型String 默认值:""
	 */
	public void setQualityname(String sQualityname)
	{
		this.qualityname = sQualityname; 
	}
	// 设置和获取 企业性质名称, 类型String 默认值:"" 结束
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
            sbStr.append(getQualitydatabaseid()).append(strSplit);
            sbStr.append(getQualityid()).append(strSplit);
            sbStr.append(getQualityname()).append(strSplit);

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
                setQualitydatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setQualityid(com.colorwinglib.Converts.objToStr(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setQualityname(com.colorwinglib.Converts.objToStr(objs[2]));
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
            sbStr.append("&Qualitydatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getQualitydatabaseid()));//企业性质编号
            sbStr.append("&Qualityid=").append(com.colorwinglib.StringFormat.UrlEncode(getQualityid()));//QualityID
            sbStr.append("&Qualityname=").append(com.colorwinglib.StringFormat.UrlEncode(getQualityname()));//企业性质名称

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
			if (columnName.equals("Qualitydatabaseid"))
				sbStr.append("&Qualitydatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getQualitydatabaseid()));//企业性质编号
			if (columnName.equals("Qualityid"))
				sbStr.append("&Qualityid=").append(com.colorwinglib.StringFormat.UrlEncode(getQualityid()));//QualityID
			if (columnName.equals("Qualityname"))
				sbStr.append("&Qualityname=").append(com.colorwinglib.StringFormat.UrlEncode(getQualityname()));//企业性质名称
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
            sbStr.append("&qualitydatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getQualitydatabaseid()));//企业性质编号
            sbStr.append("&qualityid=").append(com.colorwinglib.StringFormat.UrlEncode(getQualityid()));//QualityID
            sbStr.append("&qualityname=").append(com.colorwinglib.StringFormat.UrlEncode(getQualityname()));//企业性质名称

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
			if (columnName.equals("Qualitydatabaseid"))
				sbStr.append("&qualitydatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getQualitydatabaseid()));//企业性质编号
			if (columnName.equals("Qualityid"))
				sbStr.append("&qualityid=").append(com.colorwinglib.StringFormat.UrlEncode(getQualityid()));//QualityID
			if (columnName.equals("Qualityname"))
				sbStr.append("&qualityname=").append(com.colorwinglib.StringFormat.UrlEncode(getQualityname()));//企业性质名称
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
	public static EnterpristQualityInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			EnterpristQualityInfo obj = (EnterpristQualityInfo) in.readObject();
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
	public String ToModifyString(EnterpristQualityInfo objOld)
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
	public String ToModifyString(EnterpristQualityInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getQualitydatabaseid(), objOld.getQualitydatabaseid()))
			sbStr.append("Qualitydatabaseid 企业性质编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getQualitydatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getQualitydatabaseid())).append("]").append(strSplit);// 企业性质编号
		if (com.colorwinglib.Validate.isEquals(getQualityid(), objOld.getQualityid()))
			sbStr.append("Qualityid QualityID:[").append(com.colorwinglib.Converts.objToStr(objOld.getQualityid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getQualityid())).append("]").append(strSplit);// QualityID
		if (com.colorwinglib.Validate.isEquals(getQualityname(), objOld.getQualityname()))
			sbStr.append("Qualityname 企业性质名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getQualityname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getQualityname())).append("]").append(strSplit);// 企业性质名称
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
			json.put("Qualitydatabaseid", getQualitydatabaseid());// 企业性质编号
			json.put("Qualityid", getQualityid());// QualityID
			json.put("Qualityname", getQualityname());// 企业性质名称
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
			setQualitydatabaseid(json.getInt("Qualitydatabaseid"));// 企业性质编号
			setQualityid(json.getString("Qualityid"));// QualityID
			setQualityname(json.getString("Qualityname"));// 企业性质名称

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
		sbStr.append("<EnterpristQualityInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //企业性质编号
			sbStr.append("    <Qualitydatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getQualitydatabaseid()));
			sbStr.append("</Qualitydatabaseid>\n");
            //QualityID
			sbStr.append("    <Qualityid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getQualityid()));
			sbStr.append("</Qualityid>\n");
            //企业性质名称
			sbStr.append("    <Qualityname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getQualityname()));
			sbStr.append("</Qualityname>\n");
		sbStr.append("</EnterpristQualityInfo>\n");
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
	// GetEnterpristQualityInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetEnterpristQualityInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static EnterpristQualityInfo GetEnterpristQualityInfoFormFileName(String filename)
	{
		return GetEnterpristQualityInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetEnterpristQualityInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EnterpristQualityInfo GetEnterpristQualityInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetEnterpristQualityInfoFormXml(xml, encoding);
	}

	// [end]

	// GetEnterpristQualityInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetEnterpristQualityInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EnterpristQualityInfo GetEnterpristQualityInfoFormXml(String xml)
	{
		return GetEnterpristQualityInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetEnterpristQualityInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EnterpristQualityInfo GetEnterpristQualityInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		EnterpristQualityInfo objEnterpristQualityInfo = new EnterpristQualityInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//企业性质编号
				if (foo.elementText("Qualitydatabaseid") != null)
					objEnterpristQualityInfo.setQualitydatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Qualitydatabaseid")));
				//QualityID
				if (foo.elementText("Qualityid") != null)
					objEnterpristQualityInfo.setQualityid(com.colorwinglib.Converts.objToStr(foo.elementText("Qualityid")));
				//企业性质名称
				if (foo.elementText("Qualityname") != null)
					objEnterpristQualityInfo.setQualityname(com.colorwinglib.Converts.objToStr(foo.elementText("Qualityname")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objEnterpristQualityInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public EnterpristQualityInfo Copy()
	{
		EnterpristQualityInfo objEnterpristQualityInfo = new EnterpristQualityInfo();
		objEnterpristQualityInfo.setQualitydatabaseid(this.getQualitydatabaseid());//企业性质编号
		objEnterpristQualityInfo.setQualityid(this.getQualityid());//QualityID
		objEnterpristQualityInfo.setQualityname(this.getQualityname());//企业性质名称
		return objEnterpristQualityInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
