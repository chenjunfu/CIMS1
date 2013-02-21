
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Proadd 的描述
 * 实体类基本类
 */
public class ProaddInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311524629696L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public ProaddInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public ProaddInfoBase(int sProadddatabaseid)
	{
		this.setProadddatabaseid(sProadddatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public ProaddInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setProadddatabaseid(rs.getInt("ProadddatabaseID"));//数据库ID
		setProaddid(rs.getInt("ProaddID"));//地址ID
		setProaddname(rs.getString("ProaddName"));//地址名称
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public ProaddInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//数据库ID
			if (columnName.equals("ProadddatabaseID"))
			{
				setProadddatabaseid(rs.getInt("ProadddatabaseID"));
				continue;
			}
			//地址ID
			if (columnName.equals("ProaddID"))
			{
				setProaddid(rs.getInt("ProaddID"));
				continue;
			}
			//地址名称
			if (columnName.equals("ProaddName"))
			{
				setProaddname(rs.getString("ProaddName"));
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
		if (!(rhs instanceof ProaddInfo))
			return false;
		ProaddInfo that = (ProaddInfo) rhs;

		return (this.getProadddatabaseid() == (that.getProadddatabaseid()));
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

			result = result * 37 + (this.getProadddatabaseid() + "").hashCode();
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
	"ProadddatabaseID", //数据库ID
	"ProaddID", //地址ID
	"ProaddName" //地址名称
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum ProaddColumnNameEnum
{
		/**
		 * 数据库ID
		 */
		Proadddatabaseid,
		/**
		 * 地址ID
		 */
		Proaddid,
		/**
		 * 地址名称
		 */
		Proaddname
	};
	// [end]
        // [start] 设置和获取 数据库ID, 默认值:0
	// 设置和获取 数据库ID,类型int 默认值:0 开始
	private int proadddatabaseid = 0;
	/**
	* 获取 数据库ID, 类型int 默认值:0
	 *
	 * @return 数据库ID, 类型int 默认值:0
	 */
	public int getProadddatabaseid()
	{
		return this.proadddatabaseid; 
	}
	/**
	 * 设置 数据库ID, 类型int 默认值:0
	 *
	 * @param sProadddatabaseid
	 *            数据库ID, 类型int 默认值:0
	 */
	public void setProadddatabaseid(int sProadddatabaseid)
	{
		this.proadddatabaseid = sProadddatabaseid; 
	}
	// 设置和获取 数据库ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 地址ID, 默认值:0
	// 设置和获取 地址ID,类型int 默认值:0 开始
	private int proaddid = 0;
	/**
	* 获取 地址ID, 类型int 默认值:0
	 *
	 * @return 地址ID, 类型int 默认值:0
	 */
	public int getProaddid()
	{
		return this.proaddid; 
	}
	/**
	 * 设置 地址ID, 类型int 默认值:0
	 *
	 * @param sProaddid
	 *            地址ID, 类型int 默认值:0
	 */
	public void setProaddid(int sProaddid)
	{
		this.proaddid = sProaddid; 
	}
	// 设置和获取 地址ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 地址名称, 默认值:""
	// 设置和获取 地址名称,类型String 默认值:"" 开始
	private String proaddname = "";
	/**
	* 获取 地址名称, 类型String 默认值:""
	 *
	 * @return 地址名称, 类型String 默认值:""
	 */
	public String getProaddname()
	{
		return this.proaddname; 
	}
	/**
	 * 设置 地址名称, 类型String 默认值:""
	 *
	 * @param sProaddname
	 *            地址名称, 类型String 默认值:""
	 */
	public void setProaddname(String sProaddname)
	{
		this.proaddname = sProaddname; 
	}
	// 设置和获取 地址名称, 类型String 默认值:"" 结束
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
            sbStr.append(getProadddatabaseid()).append(strSplit);
            sbStr.append(getProaddid()).append(strSplit);
            sbStr.append(getProaddname()).append(strSplit);

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
                setProadddatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setProaddid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setProaddname(com.colorwinglib.Converts.objToStr(objs[2]));
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
            sbStr.append("&Proadddatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getProadddatabaseid()));//数据库ID
            sbStr.append("&Proaddid=").append(com.colorwinglib.StringFormat.UrlEncode(getProaddid()));//地址ID
            sbStr.append("&Proaddname=").append(com.colorwinglib.StringFormat.UrlEncode(getProaddname()));//地址名称

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
			if (columnName.equals("Proadddatabaseid"))
				sbStr.append("&Proadddatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getProadddatabaseid()));//数据库ID
			if (columnName.equals("Proaddid"))
				sbStr.append("&Proaddid=").append(com.colorwinglib.StringFormat.UrlEncode(getProaddid()));//地址ID
			if (columnName.equals("Proaddname"))
				sbStr.append("&Proaddname=").append(com.colorwinglib.StringFormat.UrlEncode(getProaddname()));//地址名称
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
            sbStr.append("&proadddatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getProadddatabaseid()));//数据库ID
            sbStr.append("&proaddid=").append(com.colorwinglib.StringFormat.UrlEncode(getProaddid()));//地址ID
            sbStr.append("&proaddname=").append(com.colorwinglib.StringFormat.UrlEncode(getProaddname()));//地址名称

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
			if (columnName.equals("Proadddatabaseid"))
				sbStr.append("&proadddatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getProadddatabaseid()));//数据库ID
			if (columnName.equals("Proaddid"))
				sbStr.append("&proaddid=").append(com.colorwinglib.StringFormat.UrlEncode(getProaddid()));//地址ID
			if (columnName.equals("Proaddname"))
				sbStr.append("&proaddname=").append(com.colorwinglib.StringFormat.UrlEncode(getProaddname()));//地址名称
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
	public static ProaddInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			ProaddInfo obj = (ProaddInfo) in.readObject();
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
	public String ToModifyString(ProaddInfo objOld)
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
	public String ToModifyString(ProaddInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getProadddatabaseid(), objOld.getProadddatabaseid()))
			sbStr.append("Proadddatabaseid 数据库ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getProadddatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getProadddatabaseid())).append("]").append(strSplit);// 数据库ID
		if (com.colorwinglib.Validate.isEquals(getProaddid(), objOld.getProaddid()))
			sbStr.append("Proaddid 地址ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getProaddid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getProaddid())).append("]").append(strSplit);// 地址ID
		if (com.colorwinglib.Validate.isEquals(getProaddname(), objOld.getProaddname()))
			sbStr.append("Proaddname 地址名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getProaddname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getProaddname())).append("]").append(strSplit);// 地址名称
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
			json.put("Proadddatabaseid", getProadddatabaseid());// 数据库ID
			json.put("Proaddid", getProaddid());// 地址ID
			json.put("Proaddname", getProaddname());// 地址名称
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
			setProadddatabaseid(json.getInt("Proadddatabaseid"));// 数据库ID
			setProaddid(json.getInt("Proaddid"));// 地址ID
			setProaddname(json.getString("Proaddname"));// 地址名称

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
		sbStr.append("<ProaddInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //数据库ID
			sbStr.append("    <Proadddatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getProadddatabaseid()));
			sbStr.append("</Proadddatabaseid>\n");
            //地址ID
			sbStr.append("    <Proaddid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getProaddid()));
			sbStr.append("</Proaddid>\n");
            //地址名称
			sbStr.append("    <Proaddname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getProaddname()));
			sbStr.append("</Proaddname>\n");
		sbStr.append("</ProaddInfo>\n");
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
	// GetProaddInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetProaddInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static ProaddInfo GetProaddInfoFormFileName(String filename)
	{
		return GetProaddInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetProaddInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProaddInfo GetProaddInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetProaddInfoFormXml(xml, encoding);
	}

	// [end]

	// GetProaddInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetProaddInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProaddInfo GetProaddInfoFormXml(String xml)
	{
		return GetProaddInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetProaddInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProaddInfo GetProaddInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		ProaddInfo objProaddInfo = new ProaddInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//数据库ID
				if (foo.elementText("Proadddatabaseid") != null)
					objProaddInfo.setProadddatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Proadddatabaseid")));
				//地址ID
				if (foo.elementText("Proaddid") != null)
					objProaddInfo.setProaddid(com.colorwinglib.Converts.StrToInt(foo.elementText("Proaddid")));
				//地址名称
				if (foo.elementText("Proaddname") != null)
					objProaddInfo.setProaddname(com.colorwinglib.Converts.objToStr(foo.elementText("Proaddname")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objProaddInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public ProaddInfo Copy()
	{
		ProaddInfo objProaddInfo = new ProaddInfo();
		objProaddInfo.setProadddatabaseid(this.getProadddatabaseid());//数据库ID
		objProaddInfo.setProaddid(this.getProaddid());//地址ID
		objProaddInfo.setProaddname(this.getProaddname());//地址名称
		return objProaddInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
