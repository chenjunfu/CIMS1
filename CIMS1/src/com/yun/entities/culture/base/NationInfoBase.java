
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Nation 民族表的描述
 * 实体类基本类
 */
public class NationInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311505782811L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public NationInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public NationInfoBase(int sNationdatabaseid)
	{
		this.setNationdatabaseid(sNationdatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public NationInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setNationdatabaseid(rs.getInt("NationdatabaseID"));//NationdatabaseID
		setNationid(rs.getInt("NationID"));//民族编号
		setNationname(rs.getString("NationName"));//民族名称
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public NationInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//NationdatabaseID
			if (columnName.equals("NationdatabaseID"))
			{
				setNationdatabaseid(rs.getInt("NationdatabaseID"));
				continue;
			}
			//民族编号
			if (columnName.equals("NationID"))
			{
				setNationid(rs.getInt("NationID"));
				continue;
			}
			//民族名称
			if (columnName.equals("NationName"))
			{
				setNationname(rs.getString("NationName"));
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
		if (!(rhs instanceof NationInfo))
			return false;
		NationInfo that = (NationInfo) rhs;

		return (this.getNationdatabaseid() == (that.getNationdatabaseid()));
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

			result = result * 37 + (this.getNationdatabaseid() + "").hashCode();
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
	"NationdatabaseID", //NationdatabaseID
	"NationID", //民族编号
	"NationName" //民族名称
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum NationColumnNameEnum
{
		/**
		 * NationdatabaseID
		 */
		Nationdatabaseid,
		/**
		 * 民族编号
		 */
		Nationid,
		/**
		 * 民族名称
		 */
		Nationname
	};
	// [end]
        // [start] 设置和获取 NationdatabaseID, 默认值:0
	// 设置和获取 NationdatabaseID,类型int 默认值:0 开始
	private int nationdatabaseid = 0;
	/**
	* 获取 NationdatabaseID, 类型int 默认值:0
	 *
	 * @return NationdatabaseID, 类型int 默认值:0
	 */
	public int getNationdatabaseid()
	{
		return this.nationdatabaseid; 
	}
	/**
	 * 设置 NationdatabaseID, 类型int 默认值:0
	 *
	 * @param sNationdatabaseid
	 *            NationdatabaseID, 类型int 默认值:0
	 */
	public void setNationdatabaseid(int sNationdatabaseid)
	{
		this.nationdatabaseid = sNationdatabaseid; 
	}
	// 设置和获取 NationdatabaseID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 民族编号, 默认值:0
	// 设置和获取 民族编号,类型int 默认值:0 开始
	private int nationid = 0;
	/**
	* 获取 民族编号, 类型int 默认值:0
	 *
	 * @return 民族编号, 类型int 默认值:0
	 */
	public int getNationid()
	{
		return this.nationid; 
	}
	/**
	 * 设置 民族编号, 类型int 默认值:0
	 *
	 * @param sNationid
	 *            民族编号, 类型int 默认值:0
	 */
	public void setNationid(int sNationid)
	{
		this.nationid = sNationid; 
	}
	// 设置和获取 民族编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 民族名称, 默认值:""
	// 设置和获取 民族名称,类型String 默认值:"" 开始
	private String nationname = "";
	/**
	* 获取 民族名称, 类型String 默认值:""
	 *
	 * @return 民族名称, 类型String 默认值:""
	 */
	public String getNationname()
	{
		return this.nationname; 
	}
	/**
	 * 设置 民族名称, 类型String 默认值:""
	 *
	 * @param sNationname
	 *            民族名称, 类型String 默认值:""
	 */
	public void setNationname(String sNationname)
	{
		this.nationname = sNationname; 
	}
	// 设置和获取 民族名称, 类型String 默认值:"" 结束
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
            sbStr.append(getNationdatabaseid()).append(strSplit);
            sbStr.append(getNationid()).append(strSplit);
            sbStr.append(getNationname()).append(strSplit);

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
                setNationdatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setNationid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setNationname(com.colorwinglib.Converts.objToStr(objs[2]));
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
            sbStr.append("&Nationdatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getNationdatabaseid()));//NationdatabaseID
            sbStr.append("&Nationid=").append(com.colorwinglib.StringFormat.UrlEncode(getNationid()));//民族编号
            sbStr.append("&Nationname=").append(com.colorwinglib.StringFormat.UrlEncode(getNationname()));//民族名称

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
			if (columnName.equals("Nationdatabaseid"))
				sbStr.append("&Nationdatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getNationdatabaseid()));//NationdatabaseID
			if (columnName.equals("Nationid"))
				sbStr.append("&Nationid=").append(com.colorwinglib.StringFormat.UrlEncode(getNationid()));//民族编号
			if (columnName.equals("Nationname"))
				sbStr.append("&Nationname=").append(com.colorwinglib.StringFormat.UrlEncode(getNationname()));//民族名称
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
            sbStr.append("&nationdatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getNationdatabaseid()));//NationdatabaseID
            sbStr.append("&nationid=").append(com.colorwinglib.StringFormat.UrlEncode(getNationid()));//民族编号
            sbStr.append("&nationname=").append(com.colorwinglib.StringFormat.UrlEncode(getNationname()));//民族名称

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
			if (columnName.equals("Nationdatabaseid"))
				sbStr.append("&nationdatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getNationdatabaseid()));//NationdatabaseID
			if (columnName.equals("Nationid"))
				sbStr.append("&nationid=").append(com.colorwinglib.StringFormat.UrlEncode(getNationid()));//民族编号
			if (columnName.equals("Nationname"))
				sbStr.append("&nationname=").append(com.colorwinglib.StringFormat.UrlEncode(getNationname()));//民族名称
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
	public static NationInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			NationInfo obj = (NationInfo) in.readObject();
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
	public String ToModifyString(NationInfo objOld)
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
	public String ToModifyString(NationInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getNationdatabaseid(), objOld.getNationdatabaseid()))
			sbStr.append("Nationdatabaseid NationdatabaseID:[").append(com.colorwinglib.Converts.objToStr(objOld.getNationdatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getNationdatabaseid())).append("]").append(strSplit);// NationdatabaseID
		if (com.colorwinglib.Validate.isEquals(getNationid(), objOld.getNationid()))
			sbStr.append("Nationid 民族编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getNationid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getNationid())).append("]").append(strSplit);// 民族编号
		if (com.colorwinglib.Validate.isEquals(getNationname(), objOld.getNationname()))
			sbStr.append("Nationname 民族名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getNationname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getNationname())).append("]").append(strSplit);// 民族名称
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
			json.put("Nationdatabaseid", getNationdatabaseid());// NationdatabaseID
			json.put("Nationid", getNationid());// 民族编号
			json.put("Nationname", getNationname());// 民族名称
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
			setNationdatabaseid(json.getInt("Nationdatabaseid"));// NationdatabaseID
			setNationid(json.getInt("Nationid"));// 民族编号
			setNationname(json.getString("Nationname"));// 民族名称

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
		sbStr.append("<NationInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //NationdatabaseID
			sbStr.append("    <Nationdatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getNationdatabaseid()));
			sbStr.append("</Nationdatabaseid>\n");
            //民族编号
			sbStr.append("    <Nationid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getNationid()));
			sbStr.append("</Nationid>\n");
            //民族名称
			sbStr.append("    <Nationname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getNationname()));
			sbStr.append("</Nationname>\n");
		sbStr.append("</NationInfo>\n");
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
	// GetNationInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetNationInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static NationInfo GetNationInfoFormFileName(String filename)
	{
		return GetNationInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetNationInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static NationInfo GetNationInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetNationInfoFormXml(xml, encoding);
	}

	// [end]

	// GetNationInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetNationInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static NationInfo GetNationInfoFormXml(String xml)
	{
		return GetNationInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetNationInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static NationInfo GetNationInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		NationInfo objNationInfo = new NationInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//NationdatabaseID
				if (foo.elementText("Nationdatabaseid") != null)
					objNationInfo.setNationdatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Nationdatabaseid")));
				//民族编号
				if (foo.elementText("Nationid") != null)
					objNationInfo.setNationid(com.colorwinglib.Converts.StrToInt(foo.elementText("Nationid")));
				//民族名称
				if (foo.elementText("Nationname") != null)
					objNationInfo.setNationname(com.colorwinglib.Converts.objToStr(foo.elementText("Nationname")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objNationInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public NationInfo Copy()
	{
		NationInfo objNationInfo = new NationInfo();
		objNationInfo.setNationdatabaseid(this.getNationdatabaseid());//NationdatabaseID
		objNationInfo.setNationid(this.getNationid());//民族编号
		objNationInfo.setNationname(this.getNationname());//民族名称
		return objNationInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
