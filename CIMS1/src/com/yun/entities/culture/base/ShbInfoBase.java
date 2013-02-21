
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Shb 的描述
 * 实体类基本类
 */
public class ShbInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311550621877L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public ShbInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public ShbInfoBase(int sShbdatabaseid)
	{
		this.setShbdatabaseid(sShbdatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public ShbInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setShbdatabaseid(rs.getInt("shbdatabaseID"));//数据库ID
		setShbid(rs.getInt("shbID"));//审核备ID
		setShbname(rs.getString("shbName"));//shbName
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public ShbInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//数据库ID
			if (columnName.equals("shbdatabaseID"))
			{
				setShbdatabaseid(rs.getInt("shbdatabaseID"));
				continue;
			}
			//审核备ID
			if (columnName.equals("shbID"))
			{
				setShbid(rs.getInt("shbID"));
				continue;
			}
			//shbName
			if (columnName.equals("shbName"))
			{
				setShbname(rs.getString("shbName"));
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
		if (!(rhs instanceof ShbInfo))
			return false;
		ShbInfo that = (ShbInfo) rhs;

		return (this.getShbdatabaseid() == (that.getShbdatabaseid()));
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

			result = result * 37 + (this.getShbdatabaseid() + "").hashCode();
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
	"shbdatabaseID", //数据库ID
	"shbID", //审核备ID
	"shbName" //shbName
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum ShbColumnNameEnum
{
		/**
		 * 数据库ID
		 */
		Shbdatabaseid,
		/**
		 * 审核备ID
		 */
		Shbid,
		/**
		 * shbName
		 */
		Shbname
	};
	// [end]
        // [start] 设置和获取 数据库ID, 默认值:0
	// 设置和获取 数据库ID,类型int 默认值:0 开始
	private int shbdatabaseid = 0;
	/**
	* 获取 数据库ID, 类型int 默认值:0
	 *
	 * @return 数据库ID, 类型int 默认值:0
	 */
	public int getShbdatabaseid()
	{
		return this.shbdatabaseid; 
	}
	/**
	 * 设置 数据库ID, 类型int 默认值:0
	 *
	 * @param sShbdatabaseid
	 *            数据库ID, 类型int 默认值:0
	 */
	public void setShbdatabaseid(int sShbdatabaseid)
	{
		this.shbdatabaseid = sShbdatabaseid; 
	}
	// 设置和获取 数据库ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 审核备ID, 默认值:0
	// 设置和获取 审核备ID,类型int 默认值:0 开始
	private int shbid = 0;
	/**
	* 获取 审核备ID, 类型int 默认值:0
	 *
	 * @return 审核备ID, 类型int 默认值:0
	 */
	public int getShbid()
	{
		return this.shbid; 
	}
	/**
	 * 设置 审核备ID, 类型int 默认值:0
	 *
	 * @param sShbid
	 *            审核备ID, 类型int 默认值:0
	 */
	public void setShbid(int sShbid)
	{
		this.shbid = sShbid; 
	}
	// 设置和获取 审核备ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 shbName, 默认值:""
	// 设置和获取 shbName,类型String 默认值:"" 开始
	private String shbname = "";
	/**
	* 获取 shbName, 类型String 默认值:""
	 *
	 * @return shbName, 类型String 默认值:""
	 */
	public String getShbname()
	{
		return this.shbname; 
	}
	/**
	 * 设置 shbName, 类型String 默认值:""
	 *
	 * @param sShbname
	 *            shbName, 类型String 默认值:""
	 */
	public void setShbname(String sShbname)
	{
		this.shbname = sShbname; 
	}
	// 设置和获取 shbName, 类型String 默认值:"" 结束
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
            sbStr.append(getShbdatabaseid()).append(strSplit);
            sbStr.append(getShbid()).append(strSplit);
            sbStr.append(getShbname()).append(strSplit);

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
                setShbdatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setShbid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setShbname(com.colorwinglib.Converts.objToStr(objs[2]));
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
            sbStr.append("&Shbdatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getShbdatabaseid()));//数据库ID
            sbStr.append("&Shbid=").append(com.colorwinglib.StringFormat.UrlEncode(getShbid()));//审核备ID
            sbStr.append("&Shbname=").append(com.colorwinglib.StringFormat.UrlEncode(getShbname()));//shbName

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
			if (columnName.equals("Shbdatabaseid"))
				sbStr.append("&Shbdatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getShbdatabaseid()));//数据库ID
			if (columnName.equals("Shbid"))
				sbStr.append("&Shbid=").append(com.colorwinglib.StringFormat.UrlEncode(getShbid()));//审核备ID
			if (columnName.equals("Shbname"))
				sbStr.append("&Shbname=").append(com.colorwinglib.StringFormat.UrlEncode(getShbname()));//shbName
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
            sbStr.append("&shbdatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getShbdatabaseid()));//数据库ID
            sbStr.append("&shbid=").append(com.colorwinglib.StringFormat.UrlEncode(getShbid()));//审核备ID
            sbStr.append("&shbname=").append(com.colorwinglib.StringFormat.UrlEncode(getShbname()));//shbName

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
			if (columnName.equals("Shbdatabaseid"))
				sbStr.append("&shbdatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getShbdatabaseid()));//数据库ID
			if (columnName.equals("Shbid"))
				sbStr.append("&shbid=").append(com.colorwinglib.StringFormat.UrlEncode(getShbid()));//审核备ID
			if (columnName.equals("Shbname"))
				sbStr.append("&shbname=").append(com.colorwinglib.StringFormat.UrlEncode(getShbname()));//shbName
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
	public static ShbInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			ShbInfo obj = (ShbInfo) in.readObject();
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
	public String ToModifyString(ShbInfo objOld)
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
	public String ToModifyString(ShbInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getShbdatabaseid(), objOld.getShbdatabaseid()))
			sbStr.append("Shbdatabaseid 数据库ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getShbdatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getShbdatabaseid())).append("]").append(strSplit);// 数据库ID
		if (com.colorwinglib.Validate.isEquals(getShbid(), objOld.getShbid()))
			sbStr.append("Shbid 审核备ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getShbid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getShbid())).append("]").append(strSplit);// 审核备ID
		if (com.colorwinglib.Validate.isEquals(getShbname(), objOld.getShbname()))
			sbStr.append("Shbname shbName:[").append(com.colorwinglib.Converts.objToStr(objOld.getShbname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getShbname())).append("]").append(strSplit);// shbName
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
			json.put("Shbdatabaseid", getShbdatabaseid());// 数据库ID
			json.put("Shbid", getShbid());// 审核备ID
			json.put("Shbname", getShbname());// shbName
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
			setShbdatabaseid(json.getInt("Shbdatabaseid"));// 数据库ID
			setShbid(json.getInt("Shbid"));// 审核备ID
			setShbname(json.getString("Shbname"));// shbName

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
		sbStr.append("<ShbInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //数据库ID
			sbStr.append("    <Shbdatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getShbdatabaseid()));
			sbStr.append("</Shbdatabaseid>\n");
            //审核备ID
			sbStr.append("    <Shbid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getShbid()));
			sbStr.append("</Shbid>\n");
            //shbName
			sbStr.append("    <Shbname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getShbname()));
			sbStr.append("</Shbname>\n");
		sbStr.append("</ShbInfo>\n");
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
	// GetShbInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetShbInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static ShbInfo GetShbInfoFormFileName(String filename)
	{
		return GetShbInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetShbInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ShbInfo GetShbInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetShbInfoFormXml(xml, encoding);
	}

	// [end]

	// GetShbInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetShbInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ShbInfo GetShbInfoFormXml(String xml)
	{
		return GetShbInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetShbInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ShbInfo GetShbInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		ShbInfo objShbInfo = new ShbInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//数据库ID
				if (foo.elementText("Shbdatabaseid") != null)
					objShbInfo.setShbdatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Shbdatabaseid")));
				//审核备ID
				if (foo.elementText("Shbid") != null)
					objShbInfo.setShbid(com.colorwinglib.Converts.StrToInt(foo.elementText("Shbid")));
				//shbName
				if (foo.elementText("Shbname") != null)
					objShbInfo.setShbname(com.colorwinglib.Converts.objToStr(foo.elementText("Shbname")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objShbInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public ShbInfo Copy()
	{
		ShbInfo objShbInfo = new ShbInfo();
		objShbInfo.setShbdatabaseid(this.getShbdatabaseid());//数据库ID
		objShbInfo.setShbid(this.getShbid());//审核备ID
		objShbInfo.setShbname(this.getShbname());//shbName
		return objShbInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
