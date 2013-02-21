
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Major 专业表的描述
 * 实体类基本类
 */
public class MajorInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311502198428L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public MajorInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public MajorInfoBase(int sMajordatabaseid)
	{
		this.setMajordatabaseid(sMajordatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public MajorInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setMajordatabaseid(rs.getInt("MajordatabaseID"));//专业数据库编号
		setMajorid(rs.getInt("MajorID"));//专业编号
		setMajorname(rs.getString("MajorName"));//专业名称
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public MajorInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//专业数据库编号
			if (columnName.equals("MajordatabaseID"))
			{
				setMajordatabaseid(rs.getInt("MajordatabaseID"));
				continue;
			}
			//专业编号
			if (columnName.equals("MajorID"))
			{
				setMajorid(rs.getInt("MajorID"));
				continue;
			}
			//专业名称
			if (columnName.equals("MajorName"))
			{
				setMajorname(rs.getString("MajorName"));
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
		if (!(rhs instanceof MajorInfo))
			return false;
		MajorInfo that = (MajorInfo) rhs;

		return (this.getMajordatabaseid() == (that.getMajordatabaseid()));
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

			result = result * 37 + (this.getMajordatabaseid() + "").hashCode();
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
	"MajordatabaseID", //专业数据库编号
	"MajorID", //专业编号
	"MajorName" //专业名称
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum MajorColumnNameEnum
{
		/**
		 * 专业数据库编号
		 */
		Majordatabaseid,
		/**
		 * 专业编号
		 */
		Majorid,
		/**
		 * 专业名称
		 */
		Majorname
	};
	// [end]
        // [start] 设置和获取 专业数据库编号, 默认值:0
	// 设置和获取 专业数据库编号,类型int 默认值:0 开始
	private int majordatabaseid = 0;
	/**
	* 获取 专业数据库编号, 类型int 默认值:0
	 *
	 * @return 专业数据库编号, 类型int 默认值:0
	 */
	public int getMajordatabaseid()
	{
		return this.majordatabaseid; 
	}
	/**
	 * 设置 专业数据库编号, 类型int 默认值:0
	 *
	 * @param sMajordatabaseid
	 *            专业数据库编号, 类型int 默认值:0
	 */
	public void setMajordatabaseid(int sMajordatabaseid)
	{
		this.majordatabaseid = sMajordatabaseid; 
	}
	// 设置和获取 专业数据库编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 专业编号, 默认值:0
	// 设置和获取 专业编号,类型int 默认值:0 开始
	private int majorid = 0;
	/**
	* 获取 专业编号, 类型int 默认值:0
	 *
	 * @return 专业编号, 类型int 默认值:0
	 */
	public int getMajorid()
	{
		return this.majorid; 
	}
	/**
	 * 设置 专业编号, 类型int 默认值:0
	 *
	 * @param sMajorid
	 *            专业编号, 类型int 默认值:0
	 */
	public void setMajorid(int sMajorid)
	{
		this.majorid = sMajorid; 
	}
	// 设置和获取 专业编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 专业名称, 默认值:""
	// 设置和获取 专业名称,类型String 默认值:"" 开始
	private String majorname = "";
	/**
	* 获取 专业名称, 类型String 默认值:""
	 *
	 * @return 专业名称, 类型String 默认值:""
	 */
	public String getMajorname()
	{
		return this.majorname; 
	}
	/**
	 * 设置 专业名称, 类型String 默认值:""
	 *
	 * @param sMajorname
	 *            专业名称, 类型String 默认值:""
	 */
	public void setMajorname(String sMajorname)
	{
		this.majorname = sMajorname; 
	}
	// 设置和获取 专业名称, 类型String 默认值:"" 结束
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
            sbStr.append(getMajordatabaseid()).append(strSplit);
            sbStr.append(getMajorid()).append(strSplit);
            sbStr.append(getMajorname()).append(strSplit);

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
                setMajordatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setMajorid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setMajorname(com.colorwinglib.Converts.objToStr(objs[2]));
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
            sbStr.append("&Majordatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getMajordatabaseid()));//专业数据库编号
            sbStr.append("&Majorid=").append(com.colorwinglib.StringFormat.UrlEncode(getMajorid()));//专业编号
            sbStr.append("&Majorname=").append(com.colorwinglib.StringFormat.UrlEncode(getMajorname()));//专业名称

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
			if (columnName.equals("Majordatabaseid"))
				sbStr.append("&Majordatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getMajordatabaseid()));//专业数据库编号
			if (columnName.equals("Majorid"))
				sbStr.append("&Majorid=").append(com.colorwinglib.StringFormat.UrlEncode(getMajorid()));//专业编号
			if (columnName.equals("Majorname"))
				sbStr.append("&Majorname=").append(com.colorwinglib.StringFormat.UrlEncode(getMajorname()));//专业名称
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
            sbStr.append("&majordatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getMajordatabaseid()));//专业数据库编号
            sbStr.append("&majorid=").append(com.colorwinglib.StringFormat.UrlEncode(getMajorid()));//专业编号
            sbStr.append("&majorname=").append(com.colorwinglib.StringFormat.UrlEncode(getMajorname()));//专业名称

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
			if (columnName.equals("Majordatabaseid"))
				sbStr.append("&majordatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getMajordatabaseid()));//专业数据库编号
			if (columnName.equals("Majorid"))
				sbStr.append("&majorid=").append(com.colorwinglib.StringFormat.UrlEncode(getMajorid()));//专业编号
			if (columnName.equals("Majorname"))
				sbStr.append("&majorname=").append(com.colorwinglib.StringFormat.UrlEncode(getMajorname()));//专业名称
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
	public static MajorInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			MajorInfo obj = (MajorInfo) in.readObject();
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
	public String ToModifyString(MajorInfo objOld)
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
	public String ToModifyString(MajorInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getMajordatabaseid(), objOld.getMajordatabaseid()))
			sbStr.append("Majordatabaseid 专业数据库编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getMajordatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getMajordatabaseid())).append("]").append(strSplit);// 专业数据库编号
		if (com.colorwinglib.Validate.isEquals(getMajorid(), objOld.getMajorid()))
			sbStr.append("Majorid 专业编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getMajorid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getMajorid())).append("]").append(strSplit);// 专业编号
		if (com.colorwinglib.Validate.isEquals(getMajorname(), objOld.getMajorname()))
			sbStr.append("Majorname 专业名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getMajorname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getMajorname())).append("]").append(strSplit);// 专业名称
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
			json.put("Majordatabaseid", getMajordatabaseid());// 专业数据库编号
			json.put("Majorid", getMajorid());// 专业编号
			json.put("Majorname", getMajorname());// 专业名称
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
			setMajordatabaseid(json.getInt("Majordatabaseid"));// 专业数据库编号
			setMajorid(json.getInt("Majorid"));// 专业编号
			setMajorname(json.getString("Majorname"));// 专业名称

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
		sbStr.append("<MajorInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //专业数据库编号
			sbStr.append("    <Majordatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getMajordatabaseid()));
			sbStr.append("</Majordatabaseid>\n");
            //专业编号
			sbStr.append("    <Majorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getMajorid()));
			sbStr.append("</Majorid>\n");
            //专业名称
			sbStr.append("    <Majorname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getMajorname()));
			sbStr.append("</Majorname>\n");
		sbStr.append("</MajorInfo>\n");
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
	// GetMajorInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetMajorInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static MajorInfo GetMajorInfoFormFileName(String filename)
	{
		return GetMajorInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetMajorInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static MajorInfo GetMajorInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetMajorInfoFormXml(xml, encoding);
	}

	// [end]

	// GetMajorInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetMajorInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static MajorInfo GetMajorInfoFormXml(String xml)
	{
		return GetMajorInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetMajorInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static MajorInfo GetMajorInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		MajorInfo objMajorInfo = new MajorInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//专业数据库编号
				if (foo.elementText("Majordatabaseid") != null)
					objMajorInfo.setMajordatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Majordatabaseid")));
				//专业编号
				if (foo.elementText("Majorid") != null)
					objMajorInfo.setMajorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Majorid")));
				//专业名称
				if (foo.elementText("Majorname") != null)
					objMajorInfo.setMajorname(com.colorwinglib.Converts.objToStr(foo.elementText("Majorname")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objMajorInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public MajorInfo Copy()
	{
		MajorInfo objMajorInfo = new MajorInfo();
		objMajorInfo.setMajordatabaseid(this.getMajordatabaseid());//专业数据库编号
		objMajorInfo.setMajorid(this.getMajorid());//专业编号
		objMajorInfo.setMajorname(this.getMajorname());//专业名称
		return objMajorInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
