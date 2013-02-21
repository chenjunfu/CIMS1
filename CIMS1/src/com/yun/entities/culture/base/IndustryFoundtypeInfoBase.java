
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * IndustryFoundtype 资金类别表的描述
 * 实体类基本类
 */
public class IndustryFoundtypeInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311485092119L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public IndustryFoundtypeInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public IndustryFoundtypeInfoBase(int sFundtypeid)
	{
		this.setFundtypeid(sFundtypeid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public IndustryFoundtypeInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setFundtypeid(rs.getInt("FundTypeID"));//资金类别编号
		setFundtypename(rs.getString("FundTypeName"));//资金类别名
		setDescription(rs.getString("Description"));//描述
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public IndustryFoundtypeInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//资金类别编号
			if (columnName.equals("FundTypeID"))
			{
				setFundtypeid(rs.getInt("FundTypeID"));
				continue;
			}
			//资金类别名
			if (columnName.equals("FundTypeName"))
			{
				setFundtypename(rs.getString("FundTypeName"));
				continue;
			}
			//描述
			if (columnName.equals("Description"))
			{
				setDescription(rs.getString("Description"));
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
		if (!(rhs instanceof IndustryFoundtypeInfo))
			return false;
		IndustryFoundtypeInfo that = (IndustryFoundtypeInfo) rhs;

		return (this.getFundtypeid() == (that.getFundtypeid()));
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

			result = result * 37 + (this.getFundtypeid() + "").hashCode();
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
	"FundTypeID", //资金类别编号
	"FundTypeName", //资金类别名
	"Description" //描述
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum IndustryFoundtypeColumnNameEnum
{
		/**
		 * 资金类别编号
		 */
		Fundtypeid,
		/**
		 * 资金类别名
		 */
		Fundtypename,
		/**
		 * 描述
		 */
		Description
	};
	// [end]
        // [start] 设置和获取 资金类别编号, 默认值:0
	// 设置和获取 资金类别编号,类型int 默认值:0 开始
	private int fundtypeid = 0;
	/**
	* 获取 资金类别编号, 类型int 默认值:0
	 *
	 * @return 资金类别编号, 类型int 默认值:0
	 */
	public int getFundtypeid()
	{
		return this.fundtypeid; 
	}
	/**
	 * 设置 资金类别编号, 类型int 默认值:0
	 *
	 * @param sFundtypeid
	 *            资金类别编号, 类型int 默认值:0
	 */
	public void setFundtypeid(int sFundtypeid)
	{
		this.fundtypeid = sFundtypeid; 
	}
	// 设置和获取 资金类别编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 资金类别名, 默认值:""
	// 设置和获取 资金类别名,类型String 默认值:"" 开始
	private String fundtypename = "";
	/**
	* 获取 资金类别名, 类型String 默认值:""
	 *
	 * @return 资金类别名, 类型String 默认值:""
	 */
	public String getFundtypename()
	{
		return this.fundtypename; 
	}
	/**
	 * 设置 资金类别名, 类型String 默认值:""
	 *
	 * @param sFundtypename
	 *            资金类别名, 类型String 默认值:""
	 */
	public void setFundtypename(String sFundtypename)
	{
		this.fundtypename = sFundtypename; 
	}
	// 设置和获取 资金类别名, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 描述, 默认值:""
	// 设置和获取 描述,类型String 默认值:"" 开始
	private String description = "";
	/**
	* 获取 描述, 类型String 默认值:""
	 *
	 * @return 描述, 类型String 默认值:""
	 */
	public String getDescription()
	{
		return this.description; 
	}
	/**
	 * 设置 描述, 类型String 默认值:""
	 *
	 * @param sDescription
	 *            描述, 类型String 默认值:""
	 */
	public void setDescription(String sDescription)
	{
		this.description = sDescription; 
	}
	// 设置和获取 描述, 类型String 默认值:"" 结束
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
            sbStr.append(getFundtypeid()).append(strSplit);
            sbStr.append(getFundtypename()).append(strSplit);
            sbStr.append(getDescription()).append(strSplit);

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
                setFundtypeid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setFundtypename(com.colorwinglib.Converts.objToStr(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setDescription(com.colorwinglib.Converts.objToStr(objs[2]));
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
            sbStr.append("&Fundtypeid=").append(com.colorwinglib.StringFormat.UrlEncode(getFundtypeid()));//资金类别编号
            sbStr.append("&Fundtypename=").append(com.colorwinglib.StringFormat.UrlEncode(getFundtypename()));//资金类别名
            sbStr.append("&Description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//描述

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
			if (columnName.equals("Fundtypeid"))
				sbStr.append("&Fundtypeid=").append(com.colorwinglib.StringFormat.UrlEncode(getFundtypeid()));//资金类别编号
			if (columnName.equals("Fundtypename"))
				sbStr.append("&Fundtypename=").append(com.colorwinglib.StringFormat.UrlEncode(getFundtypename()));//资金类别名
			if (columnName.equals("Description"))
				sbStr.append("&Description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//描述
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
            sbStr.append("&fundtypeid=").append(com.colorwinglib.StringFormat.UrlEncode(getFundtypeid()));//资金类别编号
            sbStr.append("&fundtypename=").append(com.colorwinglib.StringFormat.UrlEncode(getFundtypename()));//资金类别名
            sbStr.append("&description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//描述

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
			if (columnName.equals("Fundtypeid"))
				sbStr.append("&fundtypeid=").append(com.colorwinglib.StringFormat.UrlEncode(getFundtypeid()));//资金类别编号
			if (columnName.equals("Fundtypename"))
				sbStr.append("&fundtypename=").append(com.colorwinglib.StringFormat.UrlEncode(getFundtypename()));//资金类别名
			if (columnName.equals("Description"))
				sbStr.append("&description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//描述
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
	public static IndustryFoundtypeInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			IndustryFoundtypeInfo obj = (IndustryFoundtypeInfo) in.readObject();
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
	public String ToModifyString(IndustryFoundtypeInfo objOld)
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
	public String ToModifyString(IndustryFoundtypeInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getFundtypeid(), objOld.getFundtypeid()))
			sbStr.append("Fundtypeid 资金类别编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getFundtypeid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getFundtypeid())).append("]").append(strSplit);// 资金类别编号
		if (com.colorwinglib.Validate.isEquals(getFundtypename(), objOld.getFundtypename()))
			sbStr.append("Fundtypename 资金类别名:[").append(com.colorwinglib.Converts.objToStr(objOld.getFundtypename())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getFundtypename())).append("]").append(strSplit);// 资金类别名
		if (com.colorwinglib.Validate.isEquals(getDescription(), objOld.getDescription()))
			sbStr.append("Description 描述:[").append(com.colorwinglib.Converts.objToStr(objOld.getDescription())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDescription())).append("]").append(strSplit);// 描述
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
			json.put("Fundtypeid", getFundtypeid());// 资金类别编号
			json.put("Fundtypename", getFundtypename());// 资金类别名
			json.put("Description", getDescription());// 描述
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
			setFundtypeid(json.getInt("Fundtypeid"));// 资金类别编号
			setFundtypename(json.getString("Fundtypename"));// 资金类别名
			setDescription(json.getString("Description"));// 描述

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
		sbStr.append("<IndustryFoundtypeInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //资金类别编号
			sbStr.append("    <Fundtypeid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getFundtypeid()));
			sbStr.append("</Fundtypeid>\n");
            //资金类别名
			sbStr.append("    <Fundtypename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getFundtypename()));
			sbStr.append("</Fundtypename>\n");
            //描述
			sbStr.append("    <Description>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDescription()));
			sbStr.append("</Description>\n");
		sbStr.append("</IndustryFoundtypeInfo>\n");
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
	// GetIndustryFoundtypeInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetIndustryFoundtypeInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static IndustryFoundtypeInfo GetIndustryFoundtypeInfoFormFileName(String filename)
	{
		return GetIndustryFoundtypeInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryFoundtypeInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryFoundtypeInfo GetIndustryFoundtypeInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetIndustryFoundtypeInfoFormXml(xml, encoding);
	}

	// [end]

	// GetIndustryFoundtypeInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetIndustryFoundtypeInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryFoundtypeInfo GetIndustryFoundtypeInfoFormXml(String xml)
	{
		return GetIndustryFoundtypeInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryFoundtypeInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryFoundtypeInfo GetIndustryFoundtypeInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		IndustryFoundtypeInfo objIndustryFoundtypeInfo = new IndustryFoundtypeInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//资金类别编号
				if (foo.elementText("Fundtypeid") != null)
					objIndustryFoundtypeInfo.setFundtypeid(com.colorwinglib.Converts.StrToInt(foo.elementText("Fundtypeid")));
				//资金类别名
				if (foo.elementText("Fundtypename") != null)
					objIndustryFoundtypeInfo.setFundtypename(com.colorwinglib.Converts.objToStr(foo.elementText("Fundtypename")));
				//描述
				if (foo.elementText("Description") != null)
					objIndustryFoundtypeInfo.setDescription(com.colorwinglib.Converts.objToStr(foo.elementText("Description")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objIndustryFoundtypeInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public IndustryFoundtypeInfo Copy()
	{
		IndustryFoundtypeInfo objIndustryFoundtypeInfo = new IndustryFoundtypeInfo();
		objIndustryFoundtypeInfo.setFundtypeid(this.getFundtypeid());//资金类别编号
		objIndustryFoundtypeInfo.setFundtypename(this.getFundtypename());//资金类别名
		objIndustryFoundtypeInfo.setDescription(this.getDescription());//描述
		return objIndustryFoundtypeInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
