
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * TalentProfession 人才所属行业的描述
 * 实体类基本类
 */
public class TalentProfessionInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311574806224L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public TalentProfessionInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public TalentProfessionInfoBase(int sTalentprofessiondatabaseid)
	{
		this.setTalentprofessiondatabaseid(sTalentprofessiondatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public TalentProfessionInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setTalentprofessiondatabaseid(rs.getInt("TalentProfessiondatabaseID"));//TalentProfessiondatabaseID
		setTalentprofessionid(rs.getInt("TalentProfessionID"));//人才所属行业
		setTalentprofessionname(rs.getString("TalentProfessionName"));//行业类型名称
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public TalentProfessionInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//TalentProfessiondatabaseID
			if (columnName.equals("TalentProfessiondatabaseID"))
			{
				setTalentprofessiondatabaseid(rs.getInt("TalentProfessiondatabaseID"));
				continue;
			}
			//人才所属行业
			if (columnName.equals("TalentProfessionID"))
			{
				setTalentprofessionid(rs.getInt("TalentProfessionID"));
				continue;
			}
			//行业类型名称
			if (columnName.equals("TalentProfessionName"))
			{
				setTalentprofessionname(rs.getString("TalentProfessionName"));
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
		if (!(rhs instanceof TalentProfessionInfo))
			return false;
		TalentProfessionInfo that = (TalentProfessionInfo) rhs;

		return (this.getTalentprofessiondatabaseid() == (that.getTalentprofessiondatabaseid()));
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

			result = result * 37 + (this.getTalentprofessiondatabaseid() + "").hashCode();
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
	"TalentProfessiondatabaseID", //TalentProfessiondatabaseID
	"TalentProfessionID", //人才所属行业
	"TalentProfessionName" //行业类型名称
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum TalentProfessionColumnNameEnum
{
		/**
		 * TalentProfessiondatabaseID
		 */
		Talentprofessiondatabaseid,
		/**
		 * 人才所属行业
		 */
		Talentprofessionid,
		/**
		 * 行业类型名称
		 */
		Talentprofessionname
	};
	// [end]
        // [start] 设置和获取 TalentProfessiondatabaseID, 默认值:0
	// 设置和获取 TalentProfessiondatabaseID,类型int 默认值:0 开始
	private int talentprofessiondatabaseid = 0;
	/**
	* 获取 TalentProfessiondatabaseID, 类型int 默认值:0
	 *
	 * @return TalentProfessiondatabaseID, 类型int 默认值:0
	 */
	public int getTalentprofessiondatabaseid()
	{
		return this.talentprofessiondatabaseid; 
	}
	/**
	 * 设置 TalentProfessiondatabaseID, 类型int 默认值:0
	 *
	 * @param sTalentprofessiondatabaseid
	 *            TalentProfessiondatabaseID, 类型int 默认值:0
	 */
	public void setTalentprofessiondatabaseid(int sTalentprofessiondatabaseid)
	{
		this.talentprofessiondatabaseid = sTalentprofessiondatabaseid; 
	}
	// 设置和获取 TalentProfessiondatabaseID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 人才所属行业, 默认值:0
	// 设置和获取 人才所属行业,类型int 默认值:0 开始
	private int talentprofessionid = 0;
	/**
	* 获取 人才所属行业, 类型int 默认值:0
	 *
	 * @return 人才所属行业, 类型int 默认值:0
	 */
	public int getTalentprofessionid()
	{
		return this.talentprofessionid; 
	}
	/**
	 * 设置 人才所属行业, 类型int 默认值:0
	 *
	 * @param sTalentprofessionid
	 *            人才所属行业, 类型int 默认值:0
	 */
	public void setTalentprofessionid(int sTalentprofessionid)
	{
		this.talentprofessionid = sTalentprofessionid; 
	}
	// 设置和获取 人才所属行业, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 行业类型名称, 默认值:""
	// 设置和获取 行业类型名称,类型String 默认值:"" 开始
	private String talentprofessionname = "";
	/**
	* 获取 行业类型名称, 类型String 默认值:""
	 *
	 * @return 行业类型名称, 类型String 默认值:""
	 */
	public String getTalentprofessionname()
	{
		return this.talentprofessionname; 
	}
	/**
	 * 设置 行业类型名称, 类型String 默认值:""
	 *
	 * @param sTalentprofessionname
	 *            行业类型名称, 类型String 默认值:""
	 */
	public void setTalentprofessionname(String sTalentprofessionname)
	{
		this.talentprofessionname = sTalentprofessionname; 
	}
	// 设置和获取 行业类型名称, 类型String 默认值:"" 结束
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
            sbStr.append(getTalentprofessiondatabaseid()).append(strSplit);
            sbStr.append(getTalentprofessionid()).append(strSplit);
            sbStr.append(getTalentprofessionname()).append(strSplit);

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
                setTalentprofessiondatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setTalentprofessionid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setTalentprofessionname(com.colorwinglib.Converts.objToStr(objs[2]));
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
            sbStr.append("&Talentprofessiondatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentprofessiondatabaseid()));//TalentProfessiondatabaseID
            sbStr.append("&Talentprofessionid=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentprofessionid()));//人才所属行业
            sbStr.append("&Talentprofessionname=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentprofessionname()));//行业类型名称

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
			if (columnName.equals("Talentprofessiondatabaseid"))
				sbStr.append("&Talentprofessiondatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentprofessiondatabaseid()));//TalentProfessiondatabaseID
			if (columnName.equals("Talentprofessionid"))
				sbStr.append("&Talentprofessionid=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentprofessionid()));//人才所属行业
			if (columnName.equals("Talentprofessionname"))
				sbStr.append("&Talentprofessionname=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentprofessionname()));//行业类型名称
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
            sbStr.append("&talentprofessiondatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentprofessiondatabaseid()));//TalentProfessiondatabaseID
            sbStr.append("&talentprofessionid=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentprofessionid()));//人才所属行业
            sbStr.append("&talentprofessionname=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentprofessionname()));//行业类型名称

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
			if (columnName.equals("Talentprofessiondatabaseid"))
				sbStr.append("&talentprofessiondatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentprofessiondatabaseid()));//TalentProfessiondatabaseID
			if (columnName.equals("Talentprofessionid"))
				sbStr.append("&talentprofessionid=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentprofessionid()));//人才所属行业
			if (columnName.equals("Talentprofessionname"))
				sbStr.append("&talentprofessionname=").append(com.colorwinglib.StringFormat.UrlEncode(getTalentprofessionname()));//行业类型名称
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
	public static TalentProfessionInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			TalentProfessionInfo obj = (TalentProfessionInfo) in.readObject();
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
	public String ToModifyString(TalentProfessionInfo objOld)
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
	public String ToModifyString(TalentProfessionInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getTalentprofessiondatabaseid(), objOld.getTalentprofessiondatabaseid()))
			sbStr.append("Talentprofessiondatabaseid TalentProfessiondatabaseID:[").append(com.colorwinglib.Converts.objToStr(objOld.getTalentprofessiondatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getTalentprofessiondatabaseid())).append("]").append(strSplit);// TalentProfessiondatabaseID
		if (com.colorwinglib.Validate.isEquals(getTalentprofessionid(), objOld.getTalentprofessionid()))
			sbStr.append("Talentprofessionid 人才所属行业:[").append(com.colorwinglib.Converts.objToStr(objOld.getTalentprofessionid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getTalentprofessionid())).append("]").append(strSplit);// 人才所属行业
		if (com.colorwinglib.Validate.isEquals(getTalentprofessionname(), objOld.getTalentprofessionname()))
			sbStr.append("Talentprofessionname 行业类型名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getTalentprofessionname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getTalentprofessionname())).append("]").append(strSplit);// 行业类型名称
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
			json.put("Talentprofessiondatabaseid", getTalentprofessiondatabaseid());// TalentProfessiondatabaseID
			json.put("Talentprofessionid", getTalentprofessionid());// 人才所属行业
			json.put("Talentprofessionname", getTalentprofessionname());// 行业类型名称
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
			setTalentprofessiondatabaseid(json.getInt("Talentprofessiondatabaseid"));// TalentProfessiondatabaseID
			setTalentprofessionid(json.getInt("Talentprofessionid"));// 人才所属行业
			setTalentprofessionname(json.getString("Talentprofessionname"));// 行业类型名称

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
		sbStr.append("<TalentProfessionInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //TalentProfessiondatabaseID
			sbStr.append("    <Talentprofessiondatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getTalentprofessiondatabaseid()));
			sbStr.append("</Talentprofessiondatabaseid>\n");
            //人才所属行业
			sbStr.append("    <Talentprofessionid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getTalentprofessionid()));
			sbStr.append("</Talentprofessionid>\n");
            //行业类型名称
			sbStr.append("    <Talentprofessionname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getTalentprofessionname()));
			sbStr.append("</Talentprofessionname>\n");
		sbStr.append("</TalentProfessionInfo>\n");
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
	// GetTalentProfessionInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetTalentProfessionInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static TalentProfessionInfo GetTalentProfessionInfoFormFileName(String filename)
	{
		return GetTalentProfessionInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetTalentProfessionInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static TalentProfessionInfo GetTalentProfessionInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetTalentProfessionInfoFormXml(xml, encoding);
	}

	// [end]

	// GetTalentProfessionInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetTalentProfessionInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static TalentProfessionInfo GetTalentProfessionInfoFormXml(String xml)
	{
		return GetTalentProfessionInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetTalentProfessionInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static TalentProfessionInfo GetTalentProfessionInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		TalentProfessionInfo objTalentProfessionInfo = new TalentProfessionInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//TalentProfessiondatabaseID
				if (foo.elementText("Talentprofessiondatabaseid") != null)
					objTalentProfessionInfo.setTalentprofessiondatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Talentprofessiondatabaseid")));
				//人才所属行业
				if (foo.elementText("Talentprofessionid") != null)
					objTalentProfessionInfo.setTalentprofessionid(com.colorwinglib.Converts.StrToInt(foo.elementText("Talentprofessionid")));
				//行业类型名称
				if (foo.elementText("Talentprofessionname") != null)
					objTalentProfessionInfo.setTalentprofessionname(com.colorwinglib.Converts.objToStr(foo.elementText("Talentprofessionname")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objTalentProfessionInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public TalentProfessionInfo Copy()
	{
		TalentProfessionInfo objTalentProfessionInfo = new TalentProfessionInfo();
		objTalentProfessionInfo.setTalentprofessiondatabaseid(this.getTalentprofessiondatabaseid());//TalentProfessiondatabaseID
		objTalentProfessionInfo.setTalentprofessionid(this.getTalentprofessionid());//人才所属行业
		objTalentProfessionInfo.setTalentprofessionname(this.getTalentprofessionname());//行业类型名称
		return objTalentProfessionInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
