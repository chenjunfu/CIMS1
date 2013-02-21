
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Regions 郑州市地区表的描述
 * 实体类基本类
 */
public class RegionsInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311541728137L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public RegionsInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public RegionsInfoBase(int sRegiondatabaseid)
	{
		this.setRegiondatabaseid(sRegiondatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public RegionsInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setRegiondatabaseid(rs.getInt("RegiondatabaseID"));//RegiondatabaseID
		setRegionid(rs.getInt("RegionID"));//城市编号
		setRegionname(rs.getString("RegionName"));//城市名称
		setPartherregionsid(rs.getInt("PartherRegionsID"));//上级城市编号
		setDepth(rs.getInt("Depth"));//深度
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public RegionsInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//RegiondatabaseID
			if (columnName.equals("RegiondatabaseID"))
			{
				setRegiondatabaseid(rs.getInt("RegiondatabaseID"));
				continue;
			}
			//城市编号
			if (columnName.equals("RegionID"))
			{
				setRegionid(rs.getInt("RegionID"));
				continue;
			}
			//城市名称
			if (columnName.equals("RegionName"))
			{
				setRegionname(rs.getString("RegionName"));
				continue;
			}
			//上级城市编号
			if (columnName.equals("PartherRegionsID"))
			{
				setPartherregionsid(rs.getInt("PartherRegionsID"));
				continue;
			}
			//深度
			if (columnName.equals("Depth"))
			{
				setDepth(rs.getInt("Depth"));
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
		if (!(rhs instanceof RegionsInfo))
			return false;
		RegionsInfo that = (RegionsInfo) rhs;

		return (this.getRegiondatabaseid() == (that.getRegiondatabaseid()));
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

			result = result * 37 + (this.getRegiondatabaseid() + "").hashCode();
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
	"RegiondatabaseID", //RegiondatabaseID
	"RegionID", //城市编号
	"RegionName", //城市名称
	"PartherRegionsID", //上级城市编号
	"Depth" //深度
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum RegionsColumnNameEnum
{
		/**
		 * RegiondatabaseID
		 */
		Regiondatabaseid,
		/**
		 * 城市编号
		 */
		Regionid,
		/**
		 * 城市名称
		 */
		Regionname,
		/**
		 * 上级城市编号
		 */
		Partherregionsid,
		/**
		 * 深度
		 */
		Depth
	};
	// [end]
        // [start] 设置和获取 RegiondatabaseID, 默认值:0
	// 设置和获取 RegiondatabaseID,类型int 默认值:0 开始
	private int regiondatabaseid = 0;
	/**
	* 获取 RegiondatabaseID, 类型int 默认值:0
	 *
	 * @return RegiondatabaseID, 类型int 默认值:0
	 */
	public int getRegiondatabaseid()
	{
		return this.regiondatabaseid; 
	}
	/**
	 * 设置 RegiondatabaseID, 类型int 默认值:0
	 *
	 * @param sRegiondatabaseid
	 *            RegiondatabaseID, 类型int 默认值:0
	 */
	public void setRegiondatabaseid(int sRegiondatabaseid)
	{
		this.regiondatabaseid = sRegiondatabaseid; 
	}
	// 设置和获取 RegiondatabaseID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 城市编号, 默认值:0
	// 设置和获取 城市编号,类型int 默认值:0 开始
	private int regionid = 0;
	/**
	* 获取 城市编号, 类型int 默认值:0
	 *
	 * @return 城市编号, 类型int 默认值:0
	 */
	public int getRegionid()
	{
		return this.regionid; 
	}
	/**
	 * 设置 城市编号, 类型int 默认值:0
	 *
	 * @param sRegionid
	 *            城市编号, 类型int 默认值:0
	 */
	public void setRegionid(int sRegionid)
	{
		this.regionid = sRegionid; 
	}
	// 设置和获取 城市编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 城市名称, 默认值:""
	// 设置和获取 城市名称,类型String 默认值:"" 开始
	private String regionname = "";
	/**
	* 获取 城市名称, 类型String 默认值:""
	 *
	 * @return 城市名称, 类型String 默认值:""
	 */
	public String getRegionname()
	{
		return this.regionname; 
	}
	/**
	 * 设置 城市名称, 类型String 默认值:""
	 *
	 * @param sRegionname
	 *            城市名称, 类型String 默认值:""
	 */
	public void setRegionname(String sRegionname)
	{
		this.regionname = sRegionname; 
	}
	// 设置和获取 城市名称, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 上级城市编号, 默认值:0
	// 设置和获取 上级城市编号,类型int 默认值:0 开始
	private int partherregionsid = 0;
	/**
	* 获取 上级城市编号, 类型int 默认值:0
	 *
	 * @return 上级城市编号, 类型int 默认值:0
	 */
	public int getPartherregionsid()
	{
		return this.partherregionsid; 
	}
	/**
	 * 设置 上级城市编号, 类型int 默认值:0
	 *
	 * @param sPartherregionsid
	 *            上级城市编号, 类型int 默认值:0
	 */
	public void setPartherregionsid(int sPartherregionsid)
	{
		this.partherregionsid = sPartherregionsid; 
	}
	// 设置和获取 上级城市编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 深度, 默认值:0
	// 设置和获取 深度,类型int 默认值:0 开始
	private int depth = 0;
	/**
	* 获取 深度, 类型int 默认值:0
	 *
	 * @return 深度, 类型int 默认值:0
	 */
	public int getDepth()
	{
		return this.depth; 
	}
	/**
	 * 设置 深度, 类型int 默认值:0
	 *
	 * @param sDepth
	 *            深度, 类型int 默认值:0
	 */
	public void setDepth(int sDepth)
	{
		this.depth = sDepth; 
	}
	// 设置和获取 深度, 类型int 默认值:0 结束
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
            sbStr.append(getRegiondatabaseid()).append(strSplit);
            sbStr.append(getRegionid()).append(strSplit);
            sbStr.append(getRegionname()).append(strSplit);
            sbStr.append(getPartherregionsid()).append(strSplit);
            sbStr.append(getDepth()).append(strSplit);

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
                setRegiondatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setRegionid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setRegionname(com.colorwinglib.Converts.objToStr(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setPartherregionsid(com.colorwinglib.Converts.StrToInt(objs[3]));
            }
            if (objs[4] != null || objs[4].length() >= 1)
            {
                setDepth(com.colorwinglib.Converts.StrToInt(objs[4]));
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
            sbStr.append("&Regiondatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getRegiondatabaseid()));//RegiondatabaseID
            sbStr.append("&Regionid=").append(com.colorwinglib.StringFormat.UrlEncode(getRegionid()));//城市编号
            sbStr.append("&Regionname=").append(com.colorwinglib.StringFormat.UrlEncode(getRegionname()));//城市名称
            sbStr.append("&Partherregionsid=").append(com.colorwinglib.StringFormat.UrlEncode(getPartherregionsid()));//上级城市编号
            sbStr.append("&Depth=").append(com.colorwinglib.StringFormat.UrlEncode(getDepth()));//深度

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
			if (columnName.equals("Regiondatabaseid"))
				sbStr.append("&Regiondatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getRegiondatabaseid()));//RegiondatabaseID
			if (columnName.equals("Regionid"))
				sbStr.append("&Regionid=").append(com.colorwinglib.StringFormat.UrlEncode(getRegionid()));//城市编号
			if (columnName.equals("Regionname"))
				sbStr.append("&Regionname=").append(com.colorwinglib.StringFormat.UrlEncode(getRegionname()));//城市名称
			if (columnName.equals("Partherregionsid"))
				sbStr.append("&Partherregionsid=").append(com.colorwinglib.StringFormat.UrlEncode(getPartherregionsid()));//上级城市编号
			if (columnName.equals("Depth"))
				sbStr.append("&Depth=").append(com.colorwinglib.StringFormat.UrlEncode(getDepth()));//深度
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
            sbStr.append("&regiondatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getRegiondatabaseid()));//RegiondatabaseID
            sbStr.append("&regionid=").append(com.colorwinglib.StringFormat.UrlEncode(getRegionid()));//城市编号
            sbStr.append("&regionname=").append(com.colorwinglib.StringFormat.UrlEncode(getRegionname()));//城市名称
            sbStr.append("&partherregionsid=").append(com.colorwinglib.StringFormat.UrlEncode(getPartherregionsid()));//上级城市编号
            sbStr.append("&depth=").append(com.colorwinglib.StringFormat.UrlEncode(getDepth()));//深度

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
			if (columnName.equals("Regiondatabaseid"))
				sbStr.append("&regiondatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getRegiondatabaseid()));//RegiondatabaseID
			if (columnName.equals("Regionid"))
				sbStr.append("&regionid=").append(com.colorwinglib.StringFormat.UrlEncode(getRegionid()));//城市编号
			if (columnName.equals("Regionname"))
				sbStr.append("&regionname=").append(com.colorwinglib.StringFormat.UrlEncode(getRegionname()));//城市名称
			if (columnName.equals("Partherregionsid"))
				sbStr.append("&partherregionsid=").append(com.colorwinglib.StringFormat.UrlEncode(getPartherregionsid()));//上级城市编号
			if (columnName.equals("Depth"))
				sbStr.append("&depth=").append(com.colorwinglib.StringFormat.UrlEncode(getDepth()));//深度
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
	public static RegionsInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			RegionsInfo obj = (RegionsInfo) in.readObject();
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
	public String ToModifyString(RegionsInfo objOld)
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
	public String ToModifyString(RegionsInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getRegiondatabaseid(), objOld.getRegiondatabaseid()))
			sbStr.append("Regiondatabaseid RegiondatabaseID:[").append(com.colorwinglib.Converts.objToStr(objOld.getRegiondatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getRegiondatabaseid())).append("]").append(strSplit);// RegiondatabaseID
		if (com.colorwinglib.Validate.isEquals(getRegionid(), objOld.getRegionid()))
			sbStr.append("Regionid 城市编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getRegionid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getRegionid())).append("]").append(strSplit);// 城市编号
		if (com.colorwinglib.Validate.isEquals(getRegionname(), objOld.getRegionname()))
			sbStr.append("Regionname 城市名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getRegionname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getRegionname())).append("]").append(strSplit);// 城市名称
		if (com.colorwinglib.Validate.isEquals(getPartherregionsid(), objOld.getPartherregionsid()))
			sbStr.append("Partherregionsid 上级城市编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getPartherregionsid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPartherregionsid())).append("]").append(strSplit);// 上级城市编号
		if (com.colorwinglib.Validate.isEquals(getDepth(), objOld.getDepth()))
			sbStr.append("Depth 深度:[").append(com.colorwinglib.Converts.objToStr(objOld.getDepth())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDepth())).append("]").append(strSplit);// 深度
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
			json.put("Regiondatabaseid", getRegiondatabaseid());// RegiondatabaseID
			json.put("Regionid", getRegionid());// 城市编号
			json.put("Regionname", getRegionname());// 城市名称
			json.put("Partherregionsid", getPartherregionsid());// 上级城市编号
			json.put("Depth", getDepth());// 深度
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
			setRegiondatabaseid(json.getInt("Regiondatabaseid"));// RegiondatabaseID
			setRegionid(json.getInt("Regionid"));// 城市编号
			setRegionname(json.getString("Regionname"));// 城市名称
			setPartherregionsid(json.getInt("Partherregionsid"));// 上级城市编号
			setDepth(json.getInt("Depth"));// 深度

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
		sbStr.append("<RegionsInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //RegiondatabaseID
			sbStr.append("    <Regiondatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getRegiondatabaseid()));
			sbStr.append("</Regiondatabaseid>\n");
            //城市编号
			sbStr.append("    <Regionid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getRegionid()));
			sbStr.append("</Regionid>\n");
            //城市名称
			sbStr.append("    <Regionname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getRegionname()));
			sbStr.append("</Regionname>\n");
            //上级城市编号
			sbStr.append("    <Partherregionsid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPartherregionsid()));
			sbStr.append("</Partherregionsid>\n");
            //深度
			sbStr.append("    <Depth>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDepth()));
			sbStr.append("</Depth>\n");
		sbStr.append("</RegionsInfo>\n");
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
	// GetRegionsInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetRegionsInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static RegionsInfo GetRegionsInfoFormFileName(String filename)
	{
		return GetRegionsInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetRegionsInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static RegionsInfo GetRegionsInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetRegionsInfoFormXml(xml, encoding);
	}

	// [end]

	// GetRegionsInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetRegionsInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static RegionsInfo GetRegionsInfoFormXml(String xml)
	{
		return GetRegionsInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetRegionsInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static RegionsInfo GetRegionsInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		RegionsInfo objRegionsInfo = new RegionsInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//RegiondatabaseID
				if (foo.elementText("Regiondatabaseid") != null)
					objRegionsInfo.setRegiondatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Regiondatabaseid")));
				//城市编号
				if (foo.elementText("Regionid") != null)
					objRegionsInfo.setRegionid(com.colorwinglib.Converts.StrToInt(foo.elementText("Regionid")));
				//城市名称
				if (foo.elementText("Regionname") != null)
					objRegionsInfo.setRegionname(com.colorwinglib.Converts.objToStr(foo.elementText("Regionname")));
				//上级城市编号
				if (foo.elementText("Partherregionsid") != null)
					objRegionsInfo.setPartherregionsid(com.colorwinglib.Converts.StrToInt(foo.elementText("Partherregionsid")));
				//深度
				if (foo.elementText("Depth") != null)
					objRegionsInfo.setDepth(com.colorwinglib.Converts.StrToInt(foo.elementText("Depth")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objRegionsInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public RegionsInfo Copy()
	{
		RegionsInfo objRegionsInfo = new RegionsInfo();
		objRegionsInfo.setRegiondatabaseid(this.getRegiondatabaseid());//RegiondatabaseID
		objRegionsInfo.setRegionid(this.getRegionid());//城市编号
		objRegionsInfo.setRegionname(this.getRegionname());//城市名称
		objRegionsInfo.setPartherregionsid(this.getPartherregionsid());//上级城市编号
		objRegionsInfo.setDepth(this.getDepth());//深度
		return objRegionsInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
