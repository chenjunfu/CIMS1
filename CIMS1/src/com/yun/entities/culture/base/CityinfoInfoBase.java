
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Cityinfo 城市的描述
 * 实体类基本类
 */
public class CityinfoInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311455564088L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public CityinfoInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public CityinfoInfoBase(int sCityid)
	{
		this.setCityid(sCityid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public CityinfoInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setCityid(rs.getInt("N_CityID"));//城市id
		setParentid(rs.getInt("N_ParentID"));//父id
		setCityname(rs.getString("C_CityName"));//城市名称
		setOrderid(rs.getInt("N_OrderID"));//排序id
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public CityinfoInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//城市id
			if (columnName.equals("N_CityID"))
			{
				setCityid(rs.getInt("N_CityID"));
				continue;
			}
			//父id
			if (columnName.equals("N_ParentID"))
			{
				setParentid(rs.getInt("N_ParentID"));
				continue;
			}
			//城市名称
			if (columnName.equals("C_CityName"))
			{
				setCityname(rs.getString("C_CityName"));
				continue;
			}
			//排序id
			if (columnName.equals("N_OrderID"))
			{
				setOrderid(rs.getInt("N_OrderID"));
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
		if (!(rhs instanceof CityinfoInfo))
			return false;
		CityinfoInfo that = (CityinfoInfo) rhs;

		return (this.getCityid() == (that.getCityid()));
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

			result = result * 37 + (this.getCityid() + "").hashCode();
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
	"N_CityID", //城市id
	"N_ParentID", //父id
	"C_CityName", //城市名称
	"N_OrderID" //排序id
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum CityinfoColumnNameEnum
{
		/**
		 * 城市id
		 */
		Cityid,
		/**
		 * 父id
		 */
		Parentid,
		/**
		 * 城市名称
		 */
		Cityname,
		/**
		 * 排序id
		 */
		Orderid
	};
	// [end]
        // [start] 设置和获取 城市id, 默认值:0
	// 设置和获取 城市id,类型int 默认值:0 开始
	private int cityid = 0;
	/**
	* 获取 城市id, 类型int 默认值:0
	 *
	 * @return 城市id, 类型int 默认值:0
	 */
	public int getCityid()
	{
		return this.cityid; 
	}
	/**
	 * 设置 城市id, 类型int 默认值:0
	 *
	 * @param sCityid
	 *            城市id, 类型int 默认值:0
	 */
	public void setCityid(int sCityid)
	{
		this.cityid = sCityid; 
	}
	// 设置和获取 城市id, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 父id, 默认值:(int)((0))
	// 设置和获取 父id,类型int 默认值:(int)((0)) 开始
	private int parentid = (int)((0));
	/**
	* 获取 父id, 类型int 默认值:(int)((0))
	 *
	 * @return 父id, 类型int 默认值:(int)((0))
	 */
	public int getParentid()
	{
		return this.parentid; 
	}
	/**
	 * 设置 父id, 类型int 默认值:(int)((0))
	 *
	 * @param sParentid
	 *            父id, 类型int 默认值:(int)((0))
	 */
	public void setParentid(int sParentid)
	{
		this.parentid = sParentid; 
	}
	// 设置和获取 父id, 类型int 默认值:(int)((0)) 结束
        // [end]


        // [start] 设置和获取 城市名称, 默认值:""
	// 设置和获取 城市名称,类型String 默认值:"" 开始
	private String cityname = "";
	/**
	* 获取 城市名称, 类型String 默认值:""
	 *
	 * @return 城市名称, 类型String 默认值:""
	 */
	public String getCityname()
	{
		return this.cityname; 
	}
	/**
	 * 设置 城市名称, 类型String 默认值:""
	 *
	 * @param sCityname
	 *            城市名称, 类型String 默认值:""
	 */
	public void setCityname(String sCityname)
	{
		this.cityname = sCityname; 
	}
	// 设置和获取 城市名称, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 排序id, 默认值:(int)((0))
	// 设置和获取 排序id,类型int 默认值:(int)((0)) 开始
	private int orderid = (int)((0));
	/**
	* 获取 排序id, 类型int 默认值:(int)((0))
	 *
	 * @return 排序id, 类型int 默认值:(int)((0))
	 */
	public int getOrderid()
	{
		return this.orderid; 
	}
	/**
	 * 设置 排序id, 类型int 默认值:(int)((0))
	 *
	 * @param sOrderid
	 *            排序id, 类型int 默认值:(int)((0))
	 */
	public void setOrderid(int sOrderid)
	{
		this.orderid = sOrderid; 
	}
	// 设置和获取 排序id, 类型int 默认值:(int)((0)) 结束
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
            sbStr.append(getCityid()).append(strSplit);
            sbStr.append(getParentid()).append(strSplit);
            sbStr.append(getCityname()).append(strSplit);
            sbStr.append(getOrderid()).append(strSplit);

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
                setCityid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setParentid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setCityname(com.colorwinglib.Converts.objToStr(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setOrderid(com.colorwinglib.Converts.StrToInt(objs[3]));
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
            sbStr.append("&Cityid=").append(com.colorwinglib.StringFormat.UrlEncode(getCityid()));//城市id
            sbStr.append("&Parentid=").append(com.colorwinglib.StringFormat.UrlEncode(getParentid()));//父id
            sbStr.append("&Cityname=").append(com.colorwinglib.StringFormat.UrlEncode(getCityname()));//城市名称
            sbStr.append("&Orderid=").append(com.colorwinglib.StringFormat.UrlEncode(getOrderid()));//排序id

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
			if (columnName.equals("Cityid"))
				sbStr.append("&Cityid=").append(com.colorwinglib.StringFormat.UrlEncode(getCityid()));//城市id
			if (columnName.equals("Parentid"))
				sbStr.append("&Parentid=").append(com.colorwinglib.StringFormat.UrlEncode(getParentid()));//父id
			if (columnName.equals("Cityname"))
				sbStr.append("&Cityname=").append(com.colorwinglib.StringFormat.UrlEncode(getCityname()));//城市名称
			if (columnName.equals("Orderid"))
				sbStr.append("&Orderid=").append(com.colorwinglib.StringFormat.UrlEncode(getOrderid()));//排序id
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
            sbStr.append("&cityid=").append(com.colorwinglib.StringFormat.UrlEncode(getCityid()));//城市id
            sbStr.append("&parentid=").append(com.colorwinglib.StringFormat.UrlEncode(getParentid()));//父id
            sbStr.append("&cityname=").append(com.colorwinglib.StringFormat.UrlEncode(getCityname()));//城市名称
            sbStr.append("&orderid=").append(com.colorwinglib.StringFormat.UrlEncode(getOrderid()));//排序id

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
			if (columnName.equals("Cityid"))
				sbStr.append("&cityid=").append(com.colorwinglib.StringFormat.UrlEncode(getCityid()));//城市id
			if (columnName.equals("Parentid"))
				sbStr.append("&parentid=").append(com.colorwinglib.StringFormat.UrlEncode(getParentid()));//父id
			if (columnName.equals("Cityname"))
				sbStr.append("&cityname=").append(com.colorwinglib.StringFormat.UrlEncode(getCityname()));//城市名称
			if (columnName.equals("Orderid"))
				sbStr.append("&orderid=").append(com.colorwinglib.StringFormat.UrlEncode(getOrderid()));//排序id
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
	public static CityinfoInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			CityinfoInfo obj = (CityinfoInfo) in.readObject();
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
	public String ToModifyString(CityinfoInfo objOld)
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
	public String ToModifyString(CityinfoInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getCityid(), objOld.getCityid()))
			sbStr.append("Cityid 城市id:[").append(com.colorwinglib.Converts.objToStr(objOld.getCityid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getCityid())).append("]").append(strSplit);// 城市id
		if (com.colorwinglib.Validate.isEquals(getParentid(), objOld.getParentid()))
			sbStr.append("Parentid 父id:[").append(com.colorwinglib.Converts.objToStr(objOld.getParentid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getParentid())).append("]").append(strSplit);// 父id
		if (com.colorwinglib.Validate.isEquals(getCityname(), objOld.getCityname()))
			sbStr.append("Cityname 城市名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getCityname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getCityname())).append("]").append(strSplit);// 城市名称
		if (com.colorwinglib.Validate.isEquals(getOrderid(), objOld.getOrderid()))
			sbStr.append("Orderid 排序id:[").append(com.colorwinglib.Converts.objToStr(objOld.getOrderid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getOrderid())).append("]").append(strSplit);// 排序id
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
			json.put("Cityid", getCityid());// 城市id
			json.put("Parentid", getParentid());// 父id
			json.put("Cityname", getCityname());// 城市名称
			json.put("Orderid", getOrderid());// 排序id
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
			setCityid(json.getInt("Cityid"));// 城市id
			setParentid(json.getInt("Parentid"));// 父id
			setCityname(json.getString("Cityname"));// 城市名称
			setOrderid(json.getInt("Orderid"));// 排序id

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
		sbStr.append("<CityinfoInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //城市id
			sbStr.append("    <Cityid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getCityid()));
			sbStr.append("</Cityid>\n");
            //父id
			sbStr.append("    <Parentid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getParentid()));
			sbStr.append("</Parentid>\n");
            //城市名称
			sbStr.append("    <Cityname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getCityname()));
			sbStr.append("</Cityname>\n");
            //排序id
			sbStr.append("    <Orderid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getOrderid()));
			sbStr.append("</Orderid>\n");
		sbStr.append("</CityinfoInfo>\n");
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
	// GetCityinfoInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetCityinfoInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static CityinfoInfo GetCityinfoInfoFormFileName(String filename)
	{
		return GetCityinfoInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetCityinfoInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static CityinfoInfo GetCityinfoInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetCityinfoInfoFormXml(xml, encoding);
	}

	// [end]

	// GetCityinfoInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetCityinfoInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static CityinfoInfo GetCityinfoInfoFormXml(String xml)
	{
		return GetCityinfoInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetCityinfoInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static CityinfoInfo GetCityinfoInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		CityinfoInfo objCityinfoInfo = new CityinfoInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//城市id
				if (foo.elementText("Cityid") != null)
					objCityinfoInfo.setCityid(com.colorwinglib.Converts.StrToInt(foo.elementText("Cityid")));
				//父id
				if (foo.elementText("Parentid") != null)
					objCityinfoInfo.setParentid(com.colorwinglib.Converts.StrToInt(foo.elementText("Parentid")));
				//城市名称
				if (foo.elementText("Cityname") != null)
					objCityinfoInfo.setCityname(com.colorwinglib.Converts.objToStr(foo.elementText("Cityname")));
				//排序id
				if (foo.elementText("Orderid") != null)
					objCityinfoInfo.setOrderid(com.colorwinglib.Converts.StrToInt(foo.elementText("Orderid")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objCityinfoInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public CityinfoInfo Copy()
	{
		CityinfoInfo objCityinfoInfo = new CityinfoInfo();
		objCityinfoInfo.setCityid(this.getCityid());//城市id
		objCityinfoInfo.setParentid(this.getParentid());//父id
		objCityinfoInfo.setCityname(this.getCityname());//城市名称
		objCityinfoInfo.setOrderid(this.getOrderid());//排序id
		return objCityinfoInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
