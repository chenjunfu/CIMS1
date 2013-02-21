
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * ProjectQuality 项目性质的描述
 * 实体类基本类
 */
public class ProjectQualityInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311532917194L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public ProjectQualityInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public ProjectQualityInfoBase(int sProqulidatabaseid)
	{
		this.setProqulidatabaseid(sProqulidatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public ProjectQualityInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setProqulidatabaseid(rs.getInt("proqulidatabaseID"));//数据库ID
		setProquliid(rs.getInt("proquliID"));//项目性质ID
		setProquliname(rs.getString("proquliName"));//项目性质Name
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public ProjectQualityInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//数据库ID
			if (columnName.equals("proqulidatabaseID"))
			{
				setProqulidatabaseid(rs.getInt("proqulidatabaseID"));
				continue;
			}
			//项目性质ID
			if (columnName.equals("proquliID"))
			{
				setProquliid(rs.getInt("proquliID"));
				continue;
			}
			//项目性质Name
			if (columnName.equals("proquliName"))
			{
				setProquliname(rs.getString("proquliName"));
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
		if (!(rhs instanceof ProjectQualityInfo))
			return false;
		ProjectQualityInfo that = (ProjectQualityInfo) rhs;

		return (this.getProqulidatabaseid() == (that.getProqulidatabaseid()));
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

			result = result * 37 + (this.getProqulidatabaseid() + "").hashCode();
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
	"proqulidatabaseID", //数据库ID
	"proquliID", //项目性质ID
	"proquliName" //项目性质Name
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum ProjectQualityColumnNameEnum
{
		/**
		 * 数据库ID
		 */
		Proqulidatabaseid,
		/**
		 * 项目性质ID
		 */
		Proquliid,
		/**
		 * 项目性质Name
		 */
		Proquliname
	};
	// [end]
        // [start] 设置和获取 数据库ID, 默认值:0
	// 设置和获取 数据库ID,类型int 默认值:0 开始
	private int proqulidatabaseid = 0;
	/**
	* 获取 数据库ID, 类型int 默认值:0
	 *
	 * @return 数据库ID, 类型int 默认值:0
	 */
	public int getProqulidatabaseid()
	{
		return this.proqulidatabaseid; 
	}
	/**
	 * 设置 数据库ID, 类型int 默认值:0
	 *
	 * @param sProqulidatabaseid
	 *            数据库ID, 类型int 默认值:0
	 */
	public void setProqulidatabaseid(int sProqulidatabaseid)
	{
		this.proqulidatabaseid = sProqulidatabaseid; 
	}
	// 设置和获取 数据库ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 项目性质ID, 默认值:0
	// 设置和获取 项目性质ID,类型int 默认值:0 开始
	private int proquliid = 0;
	/**
	* 获取 项目性质ID, 类型int 默认值:0
	 *
	 * @return 项目性质ID, 类型int 默认值:0
	 */
	public int getProquliid()
	{
		return this.proquliid; 
	}
	/**
	 * 设置 项目性质ID, 类型int 默认值:0
	 *
	 * @param sProquliid
	 *            项目性质ID, 类型int 默认值:0
	 */
	public void setProquliid(int sProquliid)
	{
		this.proquliid = sProquliid; 
	}
	// 设置和获取 项目性质ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 项目性质Name, 默认值:""
	// 设置和获取 项目性质Name,类型String 默认值:"" 开始
	private String proquliname = "";
	/**
	* 获取 项目性质Name, 类型String 默认值:""
	 *
	 * @return 项目性质Name, 类型String 默认值:""
	 */
	public String getProquliname()
	{
		return this.proquliname; 
	}
	/**
	 * 设置 项目性质Name, 类型String 默认值:""
	 *
	 * @param sProquliname
	 *            项目性质Name, 类型String 默认值:""
	 */
	public void setProquliname(String sProquliname)
	{
		this.proquliname = sProquliname; 
	}
	// 设置和获取 项目性质Name, 类型String 默认值:"" 结束
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
            sbStr.append(getProqulidatabaseid()).append(strSplit);
            sbStr.append(getProquliid()).append(strSplit);
            sbStr.append(getProquliname()).append(strSplit);

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
                setProqulidatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setProquliid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setProquliname(com.colorwinglib.Converts.objToStr(objs[2]));
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
            sbStr.append("&Proqulidatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getProqulidatabaseid()));//数据库ID
            sbStr.append("&Proquliid=").append(com.colorwinglib.StringFormat.UrlEncode(getProquliid()));//项目性质ID
            sbStr.append("&Proquliname=").append(com.colorwinglib.StringFormat.UrlEncode(getProquliname()));//项目性质Name

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
			if (columnName.equals("Proqulidatabaseid"))
				sbStr.append("&Proqulidatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getProqulidatabaseid()));//数据库ID
			if (columnName.equals("Proquliid"))
				sbStr.append("&Proquliid=").append(com.colorwinglib.StringFormat.UrlEncode(getProquliid()));//项目性质ID
			if (columnName.equals("Proquliname"))
				sbStr.append("&Proquliname=").append(com.colorwinglib.StringFormat.UrlEncode(getProquliname()));//项目性质Name
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
            sbStr.append("&proqulidatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getProqulidatabaseid()));//数据库ID
            sbStr.append("&proquliid=").append(com.colorwinglib.StringFormat.UrlEncode(getProquliid()));//项目性质ID
            sbStr.append("&proquliname=").append(com.colorwinglib.StringFormat.UrlEncode(getProquliname()));//项目性质Name

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
			if (columnName.equals("Proqulidatabaseid"))
				sbStr.append("&proqulidatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getProqulidatabaseid()));//数据库ID
			if (columnName.equals("Proquliid"))
				sbStr.append("&proquliid=").append(com.colorwinglib.StringFormat.UrlEncode(getProquliid()));//项目性质ID
			if (columnName.equals("Proquliname"))
				sbStr.append("&proquliname=").append(com.colorwinglib.StringFormat.UrlEncode(getProquliname()));//项目性质Name
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
	public static ProjectQualityInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			ProjectQualityInfo obj = (ProjectQualityInfo) in.readObject();
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
	public String ToModifyString(ProjectQualityInfo objOld)
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
	public String ToModifyString(ProjectQualityInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getProqulidatabaseid(), objOld.getProqulidatabaseid()))
			sbStr.append("Proqulidatabaseid 数据库ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getProqulidatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getProqulidatabaseid())).append("]").append(strSplit);// 数据库ID
		if (com.colorwinglib.Validate.isEquals(getProquliid(), objOld.getProquliid()))
			sbStr.append("Proquliid 项目性质ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getProquliid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getProquliid())).append("]").append(strSplit);// 项目性质ID
		if (com.colorwinglib.Validate.isEquals(getProquliname(), objOld.getProquliname()))
			sbStr.append("Proquliname 项目性质Name:[").append(com.colorwinglib.Converts.objToStr(objOld.getProquliname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getProquliname())).append("]").append(strSplit);// 项目性质Name
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
			json.put("Proqulidatabaseid", getProqulidatabaseid());// 数据库ID
			json.put("Proquliid", getProquliid());// 项目性质ID
			json.put("Proquliname", getProquliname());// 项目性质Name
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
			setProqulidatabaseid(json.getInt("Proqulidatabaseid"));// 数据库ID
			setProquliid(json.getInt("Proquliid"));// 项目性质ID
			setProquliname(json.getString("Proquliname"));// 项目性质Name

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
		sbStr.append("<ProjectQualityInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //数据库ID
			sbStr.append("    <Proqulidatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getProqulidatabaseid()));
			sbStr.append("</Proqulidatabaseid>\n");
            //项目性质ID
			sbStr.append("    <Proquliid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getProquliid()));
			sbStr.append("</Proquliid>\n");
            //项目性质Name
			sbStr.append("    <Proquliname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getProquliname()));
			sbStr.append("</Proquliname>\n");
		sbStr.append("</ProjectQualityInfo>\n");
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
	// GetProjectQualityInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetProjectQualityInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static ProjectQualityInfo GetProjectQualityInfoFormFileName(String filename)
	{
		return GetProjectQualityInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetProjectQualityInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProjectQualityInfo GetProjectQualityInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetProjectQualityInfoFormXml(xml, encoding);
	}

	// [end]

	// GetProjectQualityInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetProjectQualityInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProjectQualityInfo GetProjectQualityInfoFormXml(String xml)
	{
		return GetProjectQualityInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetProjectQualityInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProjectQualityInfo GetProjectQualityInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		ProjectQualityInfo objProjectQualityInfo = new ProjectQualityInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//数据库ID
				if (foo.elementText("Proqulidatabaseid") != null)
					objProjectQualityInfo.setProqulidatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Proqulidatabaseid")));
				//项目性质ID
				if (foo.elementText("Proquliid") != null)
					objProjectQualityInfo.setProquliid(com.colorwinglib.Converts.StrToInt(foo.elementText("Proquliid")));
				//项目性质Name
				if (foo.elementText("Proquliname") != null)
					objProjectQualityInfo.setProquliname(com.colorwinglib.Converts.objToStr(foo.elementText("Proquliname")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objProjectQualityInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public ProjectQualityInfo Copy()
	{
		ProjectQualityInfo objProjectQualityInfo = new ProjectQualityInfo();
		objProjectQualityInfo.setProqulidatabaseid(this.getProqulidatabaseid());//数据库ID
		objProjectQualityInfo.setProquliid(this.getProquliid());//项目性质ID
		objProjectQualityInfo.setProquliname(this.getProquliname());//项目性质Name
		return objProjectQualityInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
