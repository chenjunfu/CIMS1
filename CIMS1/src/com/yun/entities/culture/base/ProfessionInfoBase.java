
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Profession 行业类别表的描述
 * 实体类基本类
 */
public class ProfessionInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311530718794L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public ProfessionInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public ProfessionInfoBase(int sBusinessdatabaseid)
	{
		this.setBusinessdatabaseid(sBusinessdatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public ProfessionInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setBusinessdatabaseid(rs.getInt("BusinessdatabaseID"));//数据库ID
		setBusinesstypeid(rs.getInt("BusinessTypeID"));//企业所属行业ID
		setBusinesstypename(rs.getString("BusinessTypeName"));//企业行业类型名称
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public ProfessionInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//数据库ID
			if (columnName.equals("BusinessdatabaseID"))
			{
				setBusinessdatabaseid(rs.getInt("BusinessdatabaseID"));
				continue;
			}
			//企业所属行业ID
			if (columnName.equals("BusinessTypeID"))
			{
				setBusinesstypeid(rs.getInt("BusinessTypeID"));
				continue;
			}
			//企业行业类型名称
			if (columnName.equals("BusinessTypeName"))
			{
				setBusinesstypename(rs.getString("BusinessTypeName"));
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
		if (!(rhs instanceof ProfessionInfo))
			return false;
		ProfessionInfo that = (ProfessionInfo) rhs;

		return (this.getBusinessdatabaseid() == (that.getBusinessdatabaseid()));
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

			result = result * 37 + (this.getBusinessdatabaseid() + "").hashCode();
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
	"BusinessdatabaseID", //数据库ID
	"BusinessTypeID", //企业所属行业ID
	"BusinessTypeName" //企业行业类型名称
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum ProfessionColumnNameEnum
{
		/**
		 * 数据库ID
		 */
		Businessdatabaseid,
		/**
		 * 企业所属行业ID
		 */
		Businesstypeid,
		/**
		 * 企业行业类型名称
		 */
		Businesstypename
	};
	// [end]
        // [start] 设置和获取 数据库ID, 默认值:0
	// 设置和获取 数据库ID,类型int 默认值:0 开始
	private int businessdatabaseid = 0;
	/**
	* 获取 数据库ID, 类型int 默认值:0
	 *
	 * @return 数据库ID, 类型int 默认值:0
	 */
	public int getBusinessdatabaseid()
	{
		return this.businessdatabaseid; 
	}
	/**
	 * 设置 数据库ID, 类型int 默认值:0
	 *
	 * @param sBusinessdatabaseid
	 *            数据库ID, 类型int 默认值:0
	 */
	public void setBusinessdatabaseid(int sBusinessdatabaseid)
	{
		this.businessdatabaseid = sBusinessdatabaseid; 
	}
	// 设置和获取 数据库ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 企业所属行业ID, 默认值:0
	// 设置和获取 企业所属行业ID,类型int 默认值:0 开始
	private int businesstypeid = 0;
	/**
	* 获取 企业所属行业ID, 类型int 默认值:0
	 *
	 * @return 企业所属行业ID, 类型int 默认值:0
	 */
	public int getBusinesstypeid()
	{
		return this.businesstypeid; 
	}
	/**
	 * 设置 企业所属行业ID, 类型int 默认值:0
	 *
	 * @param sBusinesstypeid
	 *            企业所属行业ID, 类型int 默认值:0
	 */
	public void setBusinesstypeid(int sBusinesstypeid)
	{
		this.businesstypeid = sBusinesstypeid; 
	}
	// 设置和获取 企业所属行业ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 企业行业类型名称, 默认值:""
	// 设置和获取 企业行业类型名称,类型String 默认值:"" 开始
	private String businesstypename = "";
	/**
	* 获取 企业行业类型名称, 类型String 默认值:""
	 *
	 * @return 企业行业类型名称, 类型String 默认值:""
	 */
	public String getBusinesstypename()
	{
		return this.businesstypename; 
	}
	/**
	 * 设置 企业行业类型名称, 类型String 默认值:""
	 *
	 * @param sBusinesstypename
	 *            企业行业类型名称, 类型String 默认值:""
	 */
	public void setBusinesstypename(String sBusinesstypename)
	{
		this.businesstypename = sBusinesstypename; 
	}
	// 设置和获取 企业行业类型名称, 类型String 默认值:"" 结束
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
            sbStr.append(getBusinessdatabaseid()).append(strSplit);
            sbStr.append(getBusinesstypeid()).append(strSplit);
            sbStr.append(getBusinesstypename()).append(strSplit);

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
                setBusinessdatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setBusinesstypeid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setBusinesstypename(com.colorwinglib.Converts.objToStr(objs[2]));
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
            sbStr.append("&Businessdatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getBusinessdatabaseid()));//数据库ID
            sbStr.append("&Businesstypeid=").append(com.colorwinglib.StringFormat.UrlEncode(getBusinesstypeid()));//企业所属行业ID
            sbStr.append("&Businesstypename=").append(com.colorwinglib.StringFormat.UrlEncode(getBusinesstypename()));//企业行业类型名称

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
			if (columnName.equals("Businessdatabaseid"))
				sbStr.append("&Businessdatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getBusinessdatabaseid()));//数据库ID
			if (columnName.equals("Businesstypeid"))
				sbStr.append("&Businesstypeid=").append(com.colorwinglib.StringFormat.UrlEncode(getBusinesstypeid()));//企业所属行业ID
			if (columnName.equals("Businesstypename"))
				sbStr.append("&Businesstypename=").append(com.colorwinglib.StringFormat.UrlEncode(getBusinesstypename()));//企业行业类型名称
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
            sbStr.append("&businessdatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getBusinessdatabaseid()));//数据库ID
            sbStr.append("&businesstypeid=").append(com.colorwinglib.StringFormat.UrlEncode(getBusinesstypeid()));//企业所属行业ID
            sbStr.append("&businesstypename=").append(com.colorwinglib.StringFormat.UrlEncode(getBusinesstypename()));//企业行业类型名称

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
			if (columnName.equals("Businessdatabaseid"))
				sbStr.append("&businessdatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getBusinessdatabaseid()));//数据库ID
			if (columnName.equals("Businesstypeid"))
				sbStr.append("&businesstypeid=").append(com.colorwinglib.StringFormat.UrlEncode(getBusinesstypeid()));//企业所属行业ID
			if (columnName.equals("Businesstypename"))
				sbStr.append("&businesstypename=").append(com.colorwinglib.StringFormat.UrlEncode(getBusinesstypename()));//企业行业类型名称
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
	public static ProfessionInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			ProfessionInfo obj = (ProfessionInfo) in.readObject();
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
	public String ToModifyString(ProfessionInfo objOld)
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
	public String ToModifyString(ProfessionInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getBusinessdatabaseid(), objOld.getBusinessdatabaseid()))
			sbStr.append("Businessdatabaseid 数据库ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getBusinessdatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getBusinessdatabaseid())).append("]").append(strSplit);// 数据库ID
		if (com.colorwinglib.Validate.isEquals(getBusinesstypeid(), objOld.getBusinesstypeid()))
			sbStr.append("Businesstypeid 企业所属行业ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getBusinesstypeid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getBusinesstypeid())).append("]").append(strSplit);// 企业所属行业ID
		if (com.colorwinglib.Validate.isEquals(getBusinesstypename(), objOld.getBusinesstypename()))
			sbStr.append("Businesstypename 企业行业类型名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getBusinesstypename())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getBusinesstypename())).append("]").append(strSplit);// 企业行业类型名称
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
			json.put("Businessdatabaseid", getBusinessdatabaseid());// 数据库ID
			json.put("Businesstypeid", getBusinesstypeid());// 企业所属行业ID
			json.put("Businesstypename", getBusinesstypename());// 企业行业类型名称
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
			setBusinessdatabaseid(json.getInt("Businessdatabaseid"));// 数据库ID
			setBusinesstypeid(json.getInt("Businesstypeid"));// 企业所属行业ID
			setBusinesstypename(json.getString("Businesstypename"));// 企业行业类型名称

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
		sbStr.append("<ProfessionInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //数据库ID
			sbStr.append("    <Businessdatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getBusinessdatabaseid()));
			sbStr.append("</Businessdatabaseid>\n");
            //企业所属行业ID
			sbStr.append("    <Businesstypeid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getBusinesstypeid()));
			sbStr.append("</Businesstypeid>\n");
            //企业行业类型名称
			sbStr.append("    <Businesstypename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getBusinesstypename()));
			sbStr.append("</Businesstypename>\n");
		sbStr.append("</ProfessionInfo>\n");
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
	// GetProfessionInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetProfessionInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static ProfessionInfo GetProfessionInfoFormFileName(String filename)
	{
		return GetProfessionInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetProfessionInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProfessionInfo GetProfessionInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetProfessionInfoFormXml(xml, encoding);
	}

	// [end]

	// GetProfessionInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetProfessionInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProfessionInfo GetProfessionInfoFormXml(String xml)
	{
		return GetProfessionInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetProfessionInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProfessionInfo GetProfessionInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		ProfessionInfo objProfessionInfo = new ProfessionInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//数据库ID
				if (foo.elementText("Businessdatabaseid") != null)
					objProfessionInfo.setBusinessdatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Businessdatabaseid")));
				//企业所属行业ID
				if (foo.elementText("Businesstypeid") != null)
					objProfessionInfo.setBusinesstypeid(com.colorwinglib.Converts.StrToInt(foo.elementText("Businesstypeid")));
				//企业行业类型名称
				if (foo.elementText("Businesstypename") != null)
					objProfessionInfo.setBusinesstypename(com.colorwinglib.Converts.objToStr(foo.elementText("Businesstypename")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objProfessionInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public ProfessionInfo Copy()
	{
		ProfessionInfo objProfessionInfo = new ProfessionInfo();
		objProfessionInfo.setBusinessdatabaseid(this.getBusinessdatabaseid());//数据库ID
		objProfessionInfo.setBusinesstypeid(this.getBusinesstypeid());//企业所属行业ID
		objProfessionInfo.setBusinesstypename(this.getBusinesstypename());//企业行业类型名称
		return objProfessionInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
