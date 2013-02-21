
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * IndustryDutyunit 主管单位表的描述
 * 实体类基本类
 */
public class IndustryDutyunitInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311483120345L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public IndustryDutyunitInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public IndustryDutyunitInfoBase(int sDutyunitid)
	{
		this.setDutyunitid(sDutyunitid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public IndustryDutyunitInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setDutyunitid(rs.getInt("DutyUnitID"));//责主管位编号
		setDutyunitname(rs.getString("DutyUnitName"));//主管单位名
		setLinkman(rs.getString("Linkman"));//联系人
		setTelphone(rs.getString("Telphone"));//联系电话
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public IndustryDutyunitInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//责主管位编号
			if (columnName.equals("DutyUnitID"))
			{
				setDutyunitid(rs.getInt("DutyUnitID"));
				continue;
			}
			//主管单位名
			if (columnName.equals("DutyUnitName"))
			{
				setDutyunitname(rs.getString("DutyUnitName"));
				continue;
			}
			//联系人
			if (columnName.equals("Linkman"))
			{
				setLinkman(rs.getString("Linkman"));
				continue;
			}
			//联系电话
			if (columnName.equals("Telphone"))
			{
				setTelphone(rs.getString("Telphone"));
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
		if (!(rhs instanceof IndustryDutyunitInfo))
			return false;
		IndustryDutyunitInfo that = (IndustryDutyunitInfo) rhs;

		return (this.getDutyunitid() == (that.getDutyunitid()));
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

			result = result * 37 + (this.getDutyunitid() + "").hashCode();
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
	"DutyUnitID", //责主管位编号
	"DutyUnitName", //主管单位名
	"Linkman", //联系人
	"Telphone" //联系电话
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum IndustryDutyunitColumnNameEnum
{
		/**
		 * 责主管位编号
		 */
		Dutyunitid,
		/**
		 * 主管单位名
		 */
		Dutyunitname,
		/**
		 * 联系人
		 */
		Linkman,
		/**
		 * 联系电话
		 */
		Telphone
	};
	// [end]
        // [start] 设置和获取 责主管位编号, 默认值:0
	// 设置和获取 责主管位编号,类型int 默认值:0 开始
	private int dutyunitid = 0;
	/**
	* 获取 责主管位编号, 类型int 默认值:0
	 *
	 * @return 责主管位编号, 类型int 默认值:0
	 */
	public int getDutyunitid()
	{
		return this.dutyunitid; 
	}
	/**
	 * 设置 责主管位编号, 类型int 默认值:0
	 *
	 * @param sDutyunitid
	 *            责主管位编号, 类型int 默认值:0
	 */
	public void setDutyunitid(int sDutyunitid)
	{
		this.dutyunitid = sDutyunitid; 
	}
	// 设置和获取 责主管位编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 主管单位名, 默认值:""
	// 设置和获取 主管单位名,类型String 默认值:"" 开始
	private String dutyunitname = "";
	/**
	* 获取 主管单位名, 类型String 默认值:""
	 *
	 * @return 主管单位名, 类型String 默认值:""
	 */
	public String getDutyunitname()
	{
		return this.dutyunitname; 
	}
	/**
	 * 设置 主管单位名, 类型String 默认值:""
	 *
	 * @param sDutyunitname
	 *            主管单位名, 类型String 默认值:""
	 */
	public void setDutyunitname(String sDutyunitname)
	{
		this.dutyunitname = sDutyunitname; 
	}
	// 设置和获取 主管单位名, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 联系人, 默认值:""
	// 设置和获取 联系人,类型String 默认值:"" 开始
	private String linkman = "";
	/**
	* 获取 联系人, 类型String 默认值:""
	 *
	 * @return 联系人, 类型String 默认值:""
	 */
	public String getLinkman()
	{
		return this.linkman; 
	}
	/**
	 * 设置 联系人, 类型String 默认值:""
	 *
	 * @param sLinkman
	 *            联系人, 类型String 默认值:""
	 */
	public void setLinkman(String sLinkman)
	{
		this.linkman = sLinkman; 
	}
	// 设置和获取 联系人, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 联系电话, 默认值:""
	// 设置和获取 联系电话,类型String 默认值:"" 开始
	private String telphone = "";
	/**
	* 获取 联系电话, 类型String 默认值:""
	 *
	 * @return 联系电话, 类型String 默认值:""
	 */
	public String getTelphone()
	{
		return this.telphone; 
	}
	/**
	 * 设置 联系电话, 类型String 默认值:""
	 *
	 * @param sTelphone
	 *            联系电话, 类型String 默认值:""
	 */
	public void setTelphone(String sTelphone)
	{
		this.telphone = sTelphone; 
	}
	// 设置和获取 联系电话, 类型String 默认值:"" 结束
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
            sbStr.append(getDutyunitid()).append(strSplit);
            sbStr.append(getDutyunitname()).append(strSplit);
            sbStr.append(getLinkman()).append(strSplit);
            sbStr.append(getTelphone()).append(strSplit);

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

            if (objs.length != 4)
            {
                return;
            }
            if (objs[0] != null || objs[0].length() >= 1)
            {
                setDutyunitid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setDutyunitname(com.colorwinglib.Converts.objToStr(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setLinkman(com.colorwinglib.Converts.objToStr(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setTelphone(com.colorwinglib.Converts.objToStr(objs[3]));
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
            sbStr.append("&Dutyunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDutyunitid()));//责主管位编号
            sbStr.append("&Dutyunitname=").append(com.colorwinglib.StringFormat.UrlEncode(getDutyunitname()));//主管单位名
            sbStr.append("&Linkman=").append(com.colorwinglib.StringFormat.UrlEncode(getLinkman()));//联系人
            sbStr.append("&Telphone=").append(com.colorwinglib.StringFormat.UrlEncode(getTelphone()));//联系电话

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
			if (columnName.equals("Dutyunitid"))
				sbStr.append("&Dutyunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDutyunitid()));//责主管位编号
			if (columnName.equals("Dutyunitname"))
				sbStr.append("&Dutyunitname=").append(com.colorwinglib.StringFormat.UrlEncode(getDutyunitname()));//主管单位名
			if (columnName.equals("Linkman"))
				sbStr.append("&Linkman=").append(com.colorwinglib.StringFormat.UrlEncode(getLinkman()));//联系人
			if (columnName.equals("Telphone"))
				sbStr.append("&Telphone=").append(com.colorwinglib.StringFormat.UrlEncode(getTelphone()));//联系电话
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
            sbStr.append("&dutyunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDutyunitid()));//责主管位编号
            sbStr.append("&dutyunitname=").append(com.colorwinglib.StringFormat.UrlEncode(getDutyunitname()));//主管单位名
            sbStr.append("&linkman=").append(com.colorwinglib.StringFormat.UrlEncode(getLinkman()));//联系人
            sbStr.append("&telphone=").append(com.colorwinglib.StringFormat.UrlEncode(getTelphone()));//联系电话

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
			if (columnName.equals("Dutyunitid"))
				sbStr.append("&dutyunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDutyunitid()));//责主管位编号
			if (columnName.equals("Dutyunitname"))
				sbStr.append("&dutyunitname=").append(com.colorwinglib.StringFormat.UrlEncode(getDutyunitname()));//主管单位名
			if (columnName.equals("Linkman"))
				sbStr.append("&linkman=").append(com.colorwinglib.StringFormat.UrlEncode(getLinkman()));//联系人
			if (columnName.equals("Telphone"))
				sbStr.append("&telphone=").append(com.colorwinglib.StringFormat.UrlEncode(getTelphone()));//联系电话
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
	public static IndustryDutyunitInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			IndustryDutyunitInfo obj = (IndustryDutyunitInfo) in.readObject();
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
	public String ToModifyString(IndustryDutyunitInfo objOld)
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
	public String ToModifyString(IndustryDutyunitInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getDutyunitid(), objOld.getDutyunitid()))
			sbStr.append("Dutyunitid 责主管位编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getDutyunitid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDutyunitid())).append("]").append(strSplit);// 责主管位编号
		if (com.colorwinglib.Validate.isEquals(getDutyunitname(), objOld.getDutyunitname()))
			sbStr.append("Dutyunitname 主管单位名:[").append(com.colorwinglib.Converts.objToStr(objOld.getDutyunitname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDutyunitname())).append("]").append(strSplit);// 主管单位名
		if (com.colorwinglib.Validate.isEquals(getLinkman(), objOld.getLinkman()))
			sbStr.append("Linkman 联系人:[").append(com.colorwinglib.Converts.objToStr(objOld.getLinkman())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getLinkman())).append("]").append(strSplit);// 联系人
		if (com.colorwinglib.Validate.isEquals(getTelphone(), objOld.getTelphone()))
			sbStr.append("Telphone 联系电话:[").append(com.colorwinglib.Converts.objToStr(objOld.getTelphone())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getTelphone())).append("]").append(strSplit);// 联系电话
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
			json.put("Dutyunitid", getDutyunitid());// 责主管位编号
			json.put("Dutyunitname", getDutyunitname());// 主管单位名
			json.put("Linkman", getLinkman());// 联系人
			json.put("Telphone", getTelphone());// 联系电话
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
			setDutyunitid(json.getInt("Dutyunitid"));// 责主管位编号
			setDutyunitname(json.getString("Dutyunitname"));// 主管单位名
			setLinkman(json.getString("Linkman"));// 联系人
			setTelphone(json.getString("Telphone"));// 联系电话

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
		sbStr.append("<IndustryDutyunitInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //责主管位编号
			sbStr.append("    <Dutyunitid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDutyunitid()));
			sbStr.append("</Dutyunitid>\n");
            //主管单位名
			sbStr.append("    <Dutyunitname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDutyunitname()));
			sbStr.append("</Dutyunitname>\n");
            //联系人
			sbStr.append("    <Linkman>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getLinkman()));
			sbStr.append("</Linkman>\n");
            //联系电话
			sbStr.append("    <Telphone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getTelphone()));
			sbStr.append("</Telphone>\n");
		sbStr.append("</IndustryDutyunitInfo>\n");
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
	// GetIndustryDutyunitInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetIndustryDutyunitInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static IndustryDutyunitInfo GetIndustryDutyunitInfoFormFileName(String filename)
	{
		return GetIndustryDutyunitInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryDutyunitInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryDutyunitInfo GetIndustryDutyunitInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetIndustryDutyunitInfoFormXml(xml, encoding);
	}

	// [end]

	// GetIndustryDutyunitInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetIndustryDutyunitInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryDutyunitInfo GetIndustryDutyunitInfoFormXml(String xml)
	{
		return GetIndustryDutyunitInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryDutyunitInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryDutyunitInfo GetIndustryDutyunitInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		IndustryDutyunitInfo objIndustryDutyunitInfo = new IndustryDutyunitInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//责主管位编号
				if (foo.elementText("Dutyunitid") != null)
					objIndustryDutyunitInfo.setDutyunitid(com.colorwinglib.Converts.StrToInt(foo.elementText("Dutyunitid")));
				//主管单位名
				if (foo.elementText("Dutyunitname") != null)
					objIndustryDutyunitInfo.setDutyunitname(com.colorwinglib.Converts.objToStr(foo.elementText("Dutyunitname")));
				//联系人
				if (foo.elementText("Linkman") != null)
					objIndustryDutyunitInfo.setLinkman(com.colorwinglib.Converts.objToStr(foo.elementText("Linkman")));
				//联系电话
				if (foo.elementText("Telphone") != null)
					objIndustryDutyunitInfo.setTelphone(com.colorwinglib.Converts.objToStr(foo.elementText("Telphone")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objIndustryDutyunitInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public IndustryDutyunitInfo Copy()
	{
		IndustryDutyunitInfo objIndustryDutyunitInfo = new IndustryDutyunitInfo();
		objIndustryDutyunitInfo.setDutyunitid(this.getDutyunitid());//责主管位编号
		objIndustryDutyunitInfo.setDutyunitname(this.getDutyunitname());//主管单位名
		objIndustryDutyunitInfo.setLinkman(this.getLinkman());//联系人
		objIndustryDutyunitInfo.setTelphone(this.getTelphone());//联系电话
		return objIndustryDutyunitInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
