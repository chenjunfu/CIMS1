
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Huanpi 的描述
 * 实体类基本类
 */
public class HuanpiInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311475892198L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public HuanpiInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public HuanpiInfoBase(int sHuanpidatabaseid)
	{
		this.setHuanpidatabaseid(sHuanpidatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public HuanpiInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setHuanpidatabaseid(rs.getInt("HuanpidatabaseID"));//数据库ID
		setHuanpiid(rs.getInt("HuanpiID"));//环境批复ID
		setHuanpiname(rs.getString("HuanpiName"));//HuanpiName
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public HuanpiInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//数据库ID
			if (columnName.equals("HuanpidatabaseID"))
			{
				setHuanpidatabaseid(rs.getInt("HuanpidatabaseID"));
				continue;
			}
			//环境批复ID
			if (columnName.equals("HuanpiID"))
			{
				setHuanpiid(rs.getInt("HuanpiID"));
				continue;
			}
			//HuanpiName
			if (columnName.equals("HuanpiName"))
			{
				setHuanpiname(rs.getString("HuanpiName"));
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
		if (!(rhs instanceof HuanpiInfo))
			return false;
		HuanpiInfo that = (HuanpiInfo) rhs;

		return (this.getHuanpidatabaseid() == (that.getHuanpidatabaseid()));
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

			result = result * 37 + (this.getHuanpidatabaseid() + "").hashCode();
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
	"HuanpidatabaseID", //数据库ID
	"HuanpiID", //环境批复ID
	"HuanpiName" //HuanpiName
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum HuanpiColumnNameEnum
{
		/**
		 * 数据库ID
		 */
		Huanpidatabaseid,
		/**
		 * 环境批复ID
		 */
		Huanpiid,
		/**
		 * HuanpiName
		 */
		Huanpiname
	};
	// [end]
        // [start] 设置和获取 数据库ID, 默认值:0
	// 设置和获取 数据库ID,类型int 默认值:0 开始
	private int huanpidatabaseid = 0;
	/**
	* 获取 数据库ID, 类型int 默认值:0
	 *
	 * @return 数据库ID, 类型int 默认值:0
	 */
	public int getHuanpidatabaseid()
	{
		return this.huanpidatabaseid; 
	}
	/**
	 * 设置 数据库ID, 类型int 默认值:0
	 *
	 * @param sHuanpidatabaseid
	 *            数据库ID, 类型int 默认值:0
	 */
	public void setHuanpidatabaseid(int sHuanpidatabaseid)
	{
		this.huanpidatabaseid = sHuanpidatabaseid; 
	}
	// 设置和获取 数据库ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 环境批复ID, 默认值:0
	// 设置和获取 环境批复ID,类型int 默认值:0 开始
	private int huanpiid = 0;
	/**
	* 获取 环境批复ID, 类型int 默认值:0
	 *
	 * @return 环境批复ID, 类型int 默认值:0
	 */
	public int getHuanpiid()
	{
		return this.huanpiid; 
	}
	/**
	 * 设置 环境批复ID, 类型int 默认值:0
	 *
	 * @param sHuanpiid
	 *            环境批复ID, 类型int 默认值:0
	 */
	public void setHuanpiid(int sHuanpiid)
	{
		this.huanpiid = sHuanpiid; 
	}
	// 设置和获取 环境批复ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 HuanpiName, 默认值:""
	// 设置和获取 HuanpiName,类型String 默认值:"" 开始
	private String huanpiname = "";
	/**
	* 获取 HuanpiName, 类型String 默认值:""
	 *
	 * @return HuanpiName, 类型String 默认值:""
	 */
	public String getHuanpiname()
	{
		return this.huanpiname; 
	}
	/**
	 * 设置 HuanpiName, 类型String 默认值:""
	 *
	 * @param sHuanpiname
	 *            HuanpiName, 类型String 默认值:""
	 */
	public void setHuanpiname(String sHuanpiname)
	{
		this.huanpiname = sHuanpiname; 
	}
	// 设置和获取 HuanpiName, 类型String 默认值:"" 结束
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
            sbStr.append(getHuanpidatabaseid()).append(strSplit);
            sbStr.append(getHuanpiid()).append(strSplit);
            sbStr.append(getHuanpiname()).append(strSplit);

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
                setHuanpidatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setHuanpiid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setHuanpiname(com.colorwinglib.Converts.objToStr(objs[2]));
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
            sbStr.append("&Huanpidatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getHuanpidatabaseid()));//数据库ID
            sbStr.append("&Huanpiid=").append(com.colorwinglib.StringFormat.UrlEncode(getHuanpiid()));//环境批复ID
            sbStr.append("&Huanpiname=").append(com.colorwinglib.StringFormat.UrlEncode(getHuanpiname()));//HuanpiName

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
			if (columnName.equals("Huanpidatabaseid"))
				sbStr.append("&Huanpidatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getHuanpidatabaseid()));//数据库ID
			if (columnName.equals("Huanpiid"))
				sbStr.append("&Huanpiid=").append(com.colorwinglib.StringFormat.UrlEncode(getHuanpiid()));//环境批复ID
			if (columnName.equals("Huanpiname"))
				sbStr.append("&Huanpiname=").append(com.colorwinglib.StringFormat.UrlEncode(getHuanpiname()));//HuanpiName
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
            sbStr.append("&huanpidatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getHuanpidatabaseid()));//数据库ID
            sbStr.append("&huanpiid=").append(com.colorwinglib.StringFormat.UrlEncode(getHuanpiid()));//环境批复ID
            sbStr.append("&huanpiname=").append(com.colorwinglib.StringFormat.UrlEncode(getHuanpiname()));//HuanpiName

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
			if (columnName.equals("Huanpidatabaseid"))
				sbStr.append("&huanpidatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getHuanpidatabaseid()));//数据库ID
			if (columnName.equals("Huanpiid"))
				sbStr.append("&huanpiid=").append(com.colorwinglib.StringFormat.UrlEncode(getHuanpiid()));//环境批复ID
			if (columnName.equals("Huanpiname"))
				sbStr.append("&huanpiname=").append(com.colorwinglib.StringFormat.UrlEncode(getHuanpiname()));//HuanpiName
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
	public static HuanpiInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			HuanpiInfo obj = (HuanpiInfo) in.readObject();
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
	public String ToModifyString(HuanpiInfo objOld)
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
	public String ToModifyString(HuanpiInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getHuanpidatabaseid(), objOld.getHuanpidatabaseid()))
			sbStr.append("Huanpidatabaseid 数据库ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getHuanpidatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getHuanpidatabaseid())).append("]").append(strSplit);// 数据库ID
		if (com.colorwinglib.Validate.isEquals(getHuanpiid(), objOld.getHuanpiid()))
			sbStr.append("Huanpiid 环境批复ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getHuanpiid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getHuanpiid())).append("]").append(strSplit);// 环境批复ID
		if (com.colorwinglib.Validate.isEquals(getHuanpiname(), objOld.getHuanpiname()))
			sbStr.append("Huanpiname HuanpiName:[").append(com.colorwinglib.Converts.objToStr(objOld.getHuanpiname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getHuanpiname())).append("]").append(strSplit);// HuanpiName
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
			json.put("Huanpidatabaseid", getHuanpidatabaseid());// 数据库ID
			json.put("Huanpiid", getHuanpiid());// 环境批复ID
			json.put("Huanpiname", getHuanpiname());// HuanpiName
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
			setHuanpidatabaseid(json.getInt("Huanpidatabaseid"));// 数据库ID
			setHuanpiid(json.getInt("Huanpiid"));// 环境批复ID
			setHuanpiname(json.getString("Huanpiname"));// HuanpiName

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
		sbStr.append("<HuanpiInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //数据库ID
			sbStr.append("    <Huanpidatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getHuanpidatabaseid()));
			sbStr.append("</Huanpidatabaseid>\n");
            //环境批复ID
			sbStr.append("    <Huanpiid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getHuanpiid()));
			sbStr.append("</Huanpiid>\n");
            //HuanpiName
			sbStr.append("    <Huanpiname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getHuanpiname()));
			sbStr.append("</Huanpiname>\n");
		sbStr.append("</HuanpiInfo>\n");
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
	// GetHuanpiInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetHuanpiInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static HuanpiInfo GetHuanpiInfoFormFileName(String filename)
	{
		return GetHuanpiInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetHuanpiInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static HuanpiInfo GetHuanpiInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetHuanpiInfoFormXml(xml, encoding);
	}

	// [end]

	// GetHuanpiInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetHuanpiInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static HuanpiInfo GetHuanpiInfoFormXml(String xml)
	{
		return GetHuanpiInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetHuanpiInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static HuanpiInfo GetHuanpiInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		HuanpiInfo objHuanpiInfo = new HuanpiInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//数据库ID
				if (foo.elementText("Huanpidatabaseid") != null)
					objHuanpiInfo.setHuanpidatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Huanpidatabaseid")));
				//环境批复ID
				if (foo.elementText("Huanpiid") != null)
					objHuanpiInfo.setHuanpiid(com.colorwinglib.Converts.StrToInt(foo.elementText("Huanpiid")));
				//HuanpiName
				if (foo.elementText("Huanpiname") != null)
					objHuanpiInfo.setHuanpiname(com.colorwinglib.Converts.objToStr(foo.elementText("Huanpiname")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objHuanpiInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public HuanpiInfo Copy()
	{
		HuanpiInfo objHuanpiInfo = new HuanpiInfo();
		objHuanpiInfo.setHuanpidatabaseid(this.getHuanpidatabaseid());//数据库ID
		objHuanpiInfo.setHuanpiid(this.getHuanpiid());//环境批复ID
		objHuanpiInfo.setHuanpiname(this.getHuanpiname());//HuanpiName
		return objHuanpiInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
