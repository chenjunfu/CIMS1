
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Education 学历表的描述
 * 实体类基本类
 */
public class EducationInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311465634368L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public EducationInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public EducationInfoBase(int sEducationdatabaseid)
	{
		this.setEducationdatabaseid(sEducationdatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public EducationInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setEducationdatabaseid(rs.getInt("EducationdatabaseID"));//EducationdatabaseID
		setEducationid(rs.getInt("EducationID"));//学历编号
		setEducationname(rs.getString("EducationName"));//学历名称
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public EducationInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//EducationdatabaseID
			if (columnName.equals("EducationdatabaseID"))
			{
				setEducationdatabaseid(rs.getInt("EducationdatabaseID"));
				continue;
			}
			//学历编号
			if (columnName.equals("EducationID"))
			{
				setEducationid(rs.getInt("EducationID"));
				continue;
			}
			//学历名称
			if (columnName.equals("EducationName"))
			{
				setEducationname(rs.getString("EducationName"));
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
		if (!(rhs instanceof EducationInfo))
			return false;
		EducationInfo that = (EducationInfo) rhs;

		return (this.getEducationdatabaseid() == (that.getEducationdatabaseid()));
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

			result = result * 37 + (this.getEducationdatabaseid() + "").hashCode();
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
	"EducationdatabaseID", //EducationdatabaseID
	"EducationID", //学历编号
	"EducationName" //学历名称
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum EducationColumnNameEnum
{
		/**
		 * EducationdatabaseID
		 */
		Educationdatabaseid,
		/**
		 * 学历编号
		 */
		Educationid,
		/**
		 * 学历名称
		 */
		Educationname
	};
	// [end]
        // [start] 设置和获取 EducationdatabaseID, 默认值:0
	// 设置和获取 EducationdatabaseID,类型int 默认值:0 开始
	private int educationdatabaseid = 0;
	/**
	* 获取 EducationdatabaseID, 类型int 默认值:0
	 *
	 * @return EducationdatabaseID, 类型int 默认值:0
	 */
	public int getEducationdatabaseid()
	{
		return this.educationdatabaseid; 
	}
	/**
	 * 设置 EducationdatabaseID, 类型int 默认值:0
	 *
	 * @param sEducationdatabaseid
	 *            EducationdatabaseID, 类型int 默认值:0
	 */
	public void setEducationdatabaseid(int sEducationdatabaseid)
	{
		this.educationdatabaseid = sEducationdatabaseid; 
	}
	// 设置和获取 EducationdatabaseID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 学历编号, 默认值:0
	// 设置和获取 学历编号,类型int 默认值:0 开始
	private int educationid = 0;
	/**
	* 获取 学历编号, 类型int 默认值:0
	 *
	 * @return 学历编号, 类型int 默认值:0
	 */
	public int getEducationid()
	{
		return this.educationid; 
	}
	/**
	 * 设置 学历编号, 类型int 默认值:0
	 *
	 * @param sEducationid
	 *            学历编号, 类型int 默认值:0
	 */
	public void setEducationid(int sEducationid)
	{
		this.educationid = sEducationid; 
	}
	// 设置和获取 学历编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 学历名称, 默认值:""
	// 设置和获取 学历名称,类型String 默认值:"" 开始
	private String educationname = "";
	/**
	* 获取 学历名称, 类型String 默认值:""
	 *
	 * @return 学历名称, 类型String 默认值:""
	 */
	public String getEducationname()
	{
		return this.educationname; 
	}
	/**
	 * 设置 学历名称, 类型String 默认值:""
	 *
	 * @param sEducationname
	 *            学历名称, 类型String 默认值:""
	 */
	public void setEducationname(String sEducationname)
	{
		this.educationname = sEducationname; 
	}
	// 设置和获取 学历名称, 类型String 默认值:"" 结束
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
            sbStr.append(getEducationdatabaseid()).append(strSplit);
            sbStr.append(getEducationid()).append(strSplit);
            sbStr.append(getEducationname()).append(strSplit);

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
                setEducationdatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setEducationid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setEducationname(com.colorwinglib.Converts.objToStr(objs[2]));
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
            sbStr.append("&Educationdatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getEducationdatabaseid()));//EducationdatabaseID
            sbStr.append("&Educationid=").append(com.colorwinglib.StringFormat.UrlEncode(getEducationid()));//学历编号
            sbStr.append("&Educationname=").append(com.colorwinglib.StringFormat.UrlEncode(getEducationname()));//学历名称

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
			if (columnName.equals("Educationdatabaseid"))
				sbStr.append("&Educationdatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getEducationdatabaseid()));//EducationdatabaseID
			if (columnName.equals("Educationid"))
				sbStr.append("&Educationid=").append(com.colorwinglib.StringFormat.UrlEncode(getEducationid()));//学历编号
			if (columnName.equals("Educationname"))
				sbStr.append("&Educationname=").append(com.colorwinglib.StringFormat.UrlEncode(getEducationname()));//学历名称
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
            sbStr.append("&educationdatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getEducationdatabaseid()));//EducationdatabaseID
            sbStr.append("&educationid=").append(com.colorwinglib.StringFormat.UrlEncode(getEducationid()));//学历编号
            sbStr.append("&educationname=").append(com.colorwinglib.StringFormat.UrlEncode(getEducationname()));//学历名称

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
			if (columnName.equals("Educationdatabaseid"))
				sbStr.append("&educationdatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getEducationdatabaseid()));//EducationdatabaseID
			if (columnName.equals("Educationid"))
				sbStr.append("&educationid=").append(com.colorwinglib.StringFormat.UrlEncode(getEducationid()));//学历编号
			if (columnName.equals("Educationname"))
				sbStr.append("&educationname=").append(com.colorwinglib.StringFormat.UrlEncode(getEducationname()));//学历名称
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
	public static EducationInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			EducationInfo obj = (EducationInfo) in.readObject();
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
	public String ToModifyString(EducationInfo objOld)
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
	public String ToModifyString(EducationInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getEducationdatabaseid(), objOld.getEducationdatabaseid()))
			sbStr.append("Educationdatabaseid EducationdatabaseID:[").append(com.colorwinglib.Converts.objToStr(objOld.getEducationdatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getEducationdatabaseid())).append("]").append(strSplit);// EducationdatabaseID
		if (com.colorwinglib.Validate.isEquals(getEducationid(), objOld.getEducationid()))
			sbStr.append("Educationid 学历编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getEducationid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getEducationid())).append("]").append(strSplit);// 学历编号
		if (com.colorwinglib.Validate.isEquals(getEducationname(), objOld.getEducationname()))
			sbStr.append("Educationname 学历名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getEducationname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getEducationname())).append("]").append(strSplit);// 学历名称
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
			json.put("Educationdatabaseid", getEducationdatabaseid());// EducationdatabaseID
			json.put("Educationid", getEducationid());// 学历编号
			json.put("Educationname", getEducationname());// 学历名称
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
			setEducationdatabaseid(json.getInt("Educationdatabaseid"));// EducationdatabaseID
			setEducationid(json.getInt("Educationid"));// 学历编号
			setEducationname(json.getString("Educationname"));// 学历名称

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
		sbStr.append("<EducationInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //EducationdatabaseID
			sbStr.append("    <Educationdatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getEducationdatabaseid()));
			sbStr.append("</Educationdatabaseid>\n");
            //学历编号
			sbStr.append("    <Educationid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getEducationid()));
			sbStr.append("</Educationid>\n");
            //学历名称
			sbStr.append("    <Educationname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getEducationname()));
			sbStr.append("</Educationname>\n");
		sbStr.append("</EducationInfo>\n");
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
	// GetEducationInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetEducationInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static EducationInfo GetEducationInfoFormFileName(String filename)
	{
		return GetEducationInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetEducationInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EducationInfo GetEducationInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetEducationInfoFormXml(xml, encoding);
	}

	// [end]

	// GetEducationInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetEducationInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EducationInfo GetEducationInfoFormXml(String xml)
	{
		return GetEducationInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetEducationInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EducationInfo GetEducationInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		EducationInfo objEducationInfo = new EducationInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//EducationdatabaseID
				if (foo.elementText("Educationdatabaseid") != null)
					objEducationInfo.setEducationdatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Educationdatabaseid")));
				//学历编号
				if (foo.elementText("Educationid") != null)
					objEducationInfo.setEducationid(com.colorwinglib.Converts.StrToInt(foo.elementText("Educationid")));
				//学历名称
				if (foo.elementText("Educationname") != null)
					objEducationInfo.setEducationname(com.colorwinglib.Converts.objToStr(foo.elementText("Educationname")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objEducationInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public EducationInfo Copy()
	{
		EducationInfo objEducationInfo = new EducationInfo();
		objEducationInfo.setEducationdatabaseid(this.getEducationdatabaseid());//EducationdatabaseID
		objEducationInfo.setEducationid(this.getEducationid());//学历编号
		objEducationInfo.setEducationname(this.getEducationname());//学历名称
		return objEducationInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
