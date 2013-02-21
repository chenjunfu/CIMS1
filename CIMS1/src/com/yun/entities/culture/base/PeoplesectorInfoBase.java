
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Peoplesector 部门信息表的描述
 * 实体类基本类
 */
public class PeoplesectorInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311514723495L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public PeoplesectorInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public PeoplesectorInfoBase(int sDatabasepeoplesectorid)
	{
		this.setDatabasepeoplesectorid(sDatabasepeoplesectorid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public PeoplesectorInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setDatabasepeoplesectorid(rs.getInt("DatabasePeoplesectorID"));//部门ID
		setPeoplesectorid(rs.getInt("PeopleSectorID"));//部门编号
		setPeoplesectorname(rs.getString("PeopleSectorName"));//部门名称
		setAdress(rs.getString("Adress"));//办公住址
		setPhone(rs.getString("Phone"));//电话
		setDatabaseunitid(rs.getInt("DatabaseUnitID"));//单位编号
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public PeoplesectorInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//部门ID
			if (columnName.equals("DatabasePeoplesectorID"))
			{
				setDatabasepeoplesectorid(rs.getInt("DatabasePeoplesectorID"));
				continue;
			}
			//部门编号
			if (columnName.equals("PeopleSectorID"))
			{
				setPeoplesectorid(rs.getInt("PeopleSectorID"));
				continue;
			}
			//部门名称
			if (columnName.equals("PeopleSectorName"))
			{
				setPeoplesectorname(rs.getString("PeopleSectorName"));
				continue;
			}
			//办公住址
			if (columnName.equals("Adress"))
			{
				setAdress(rs.getString("Adress"));
				continue;
			}
			//电话
			if (columnName.equals("Phone"))
			{
				setPhone(rs.getString("Phone"));
				continue;
			}
			//单位编号
			if (columnName.equals("DatabaseUnitID"))
			{
				setDatabaseunitid(rs.getInt("DatabaseUnitID"));
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
		if (!(rhs instanceof PeoplesectorInfo))
			return false;
		PeoplesectorInfo that = (PeoplesectorInfo) rhs;

		return (this.getDatabasepeoplesectorid() == (that.getDatabasepeoplesectorid()));
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

			result = result * 37 + (this.getDatabasepeoplesectorid() + "").hashCode();
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
	"DatabasePeoplesectorID", //部门ID
	"PeopleSectorID", //部门编号
	"PeopleSectorName", //部门名称
	"Adress", //办公住址
	"Phone", //电话
	"DatabaseUnitID" //单位编号
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum PeoplesectorColumnNameEnum
{
		/**
		 * 部门ID
		 */
		Databasepeoplesectorid,
		/**
		 * 部门编号
		 */
		Peoplesectorid,
		/**
		 * 部门名称
		 */
		Peoplesectorname,
		/**
		 * 办公住址
		 */
		Adress,
		/**
		 * 电话
		 */
		Phone,
		/**
		 * 单位编号
		 */
		Databaseunitid
	};
	// [end]
        // [start] 设置和获取 部门ID, 默认值:0
	// 设置和获取 部门ID,类型int 默认值:0 开始
	private int databasepeoplesectorid = 0;
	/**
	* 获取 部门ID, 类型int 默认值:0
	 *
	 * @return 部门ID, 类型int 默认值:0
	 */
	public int getDatabasepeoplesectorid()
	{
		return this.databasepeoplesectorid; 
	}
	/**
	 * 设置 部门ID, 类型int 默认值:0
	 *
	 * @param sDatabasepeoplesectorid
	 *            部门ID, 类型int 默认值:0
	 */
	public void setDatabasepeoplesectorid(int sDatabasepeoplesectorid)
	{
		this.databasepeoplesectorid = sDatabasepeoplesectorid; 
	}
	// 设置和获取 部门ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 部门编号, 默认值:0
	// 设置和获取 部门编号,类型int 默认值:0 开始
	private int peoplesectorid = 0;
	/**
	* 获取 部门编号, 类型int 默认值:0
	 *
	 * @return 部门编号, 类型int 默认值:0
	 */
	public int getPeoplesectorid()
	{
		return this.peoplesectorid; 
	}
	/**
	 * 设置 部门编号, 类型int 默认值:0
	 *
	 * @param sPeoplesectorid
	 *            部门编号, 类型int 默认值:0
	 */
	public void setPeoplesectorid(int sPeoplesectorid)
	{
		this.peoplesectorid = sPeoplesectorid; 
	}
	// 设置和获取 部门编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 部门名称, 默认值:""
	// 设置和获取 部门名称,类型String 默认值:"" 开始
	private String peoplesectorname = "";
	/**
	* 获取 部门名称, 类型String 默认值:""
	 *
	 * @return 部门名称, 类型String 默认值:""
	 */
	public String getPeoplesectorname()
	{
		return this.peoplesectorname; 
	}
	/**
	 * 设置 部门名称, 类型String 默认值:""
	 *
	 * @param sPeoplesectorname
	 *            部门名称, 类型String 默认值:""
	 */
	public void setPeoplesectorname(String sPeoplesectorname)
	{
		this.peoplesectorname = sPeoplesectorname; 
	}
	// 设置和获取 部门名称, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 办公住址, 默认值:""
	// 设置和获取 办公住址,类型String 默认值:"" 开始
	private String adress = "";
	/**
	* 获取 办公住址, 类型String 默认值:""
	 *
	 * @return 办公住址, 类型String 默认值:""
	 */
	public String getAdress()
	{
		return this.adress; 
	}
	/**
	 * 设置 办公住址, 类型String 默认值:""
	 *
	 * @param sAdress
	 *            办公住址, 类型String 默认值:""
	 */
	public void setAdress(String sAdress)
	{
		this.adress = sAdress; 
	}
	// 设置和获取 办公住址, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 电话, 默认值:""
	// 设置和获取 电话,类型String 默认值:"" 开始
	private String phone = "";
	/**
	* 获取 电话, 类型String 默认值:""
	 *
	 * @return 电话, 类型String 默认值:""
	 */
	public String getPhone()
	{
		return this.phone; 
	}
	/**
	 * 设置 电话, 类型String 默认值:""
	 *
	 * @param sPhone
	 *            电话, 类型String 默认值:""
	 */
	public void setPhone(String sPhone)
	{
		this.phone = sPhone; 
	}
	// 设置和获取 电话, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 单位编号, 默认值:0
	// 设置和获取 单位编号,类型int 默认值:0 开始
	private int databaseunitid = 0;
	/**
	* 获取 单位编号, 类型int 默认值:0
	 *
	 * @return 单位编号, 类型int 默认值:0
	 */
	public int getDatabaseunitid()
	{
		return this.databaseunitid; 
	}
	/**
	 * 设置 单位编号, 类型int 默认值:0
	 *
	 * @param sDatabaseunitid
	 *            单位编号, 类型int 默认值:0
	 */
	public void setDatabaseunitid(int sDatabaseunitid)
	{
		this.databaseunitid = sDatabaseunitid; 
	}
	// 设置和获取 单位编号, 类型int 默认值:0 结束
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
            sbStr.append(getDatabasepeoplesectorid()).append(strSplit);
            sbStr.append(getPeoplesectorid()).append(strSplit);
            sbStr.append(getPeoplesectorname()).append(strSplit);
            sbStr.append(getAdress()).append(strSplit);
            sbStr.append(getPhone()).append(strSplit);
            sbStr.append(getDatabaseunitid()).append(strSplit);

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

            if (objs.length != 6)
            {
                return;
            }
            if (objs[0] != null || objs[0].length() >= 1)
            {
                setDatabasepeoplesectorid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setPeoplesectorid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setPeoplesectorname(com.colorwinglib.Converts.objToStr(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setAdress(com.colorwinglib.Converts.objToStr(objs[3]));
            }
            if (objs[4] != null || objs[4].length() >= 1)
            {
                setPhone(com.colorwinglib.Converts.objToStr(objs[4]));
            }
            if (objs[5] != null || objs[5].length() >= 1)
            {
                setDatabaseunitid(com.colorwinglib.Converts.StrToInt(objs[5]));
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
            sbStr.append("&Databasepeoplesectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeoplesectorid()));//部门ID
            sbStr.append("&Peoplesectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getPeoplesectorid()));//部门编号
            sbStr.append("&Peoplesectorname=").append(com.colorwinglib.StringFormat.UrlEncode(getPeoplesectorname()));//部门名称
            sbStr.append("&Adress=").append(com.colorwinglib.StringFormat.UrlEncode(getAdress()));//办公住址
            sbStr.append("&Phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//电话
            sbStr.append("&Databaseunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseunitid()));//单位编号

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
			if (columnName.equals("Databasepeoplesectorid"))
				sbStr.append("&Databasepeoplesectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeoplesectorid()));//部门ID
			if (columnName.equals("Peoplesectorid"))
				sbStr.append("&Peoplesectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getPeoplesectorid()));//部门编号
			if (columnName.equals("Peoplesectorname"))
				sbStr.append("&Peoplesectorname=").append(com.colorwinglib.StringFormat.UrlEncode(getPeoplesectorname()));//部门名称
			if (columnName.equals("Adress"))
				sbStr.append("&Adress=").append(com.colorwinglib.StringFormat.UrlEncode(getAdress()));//办公住址
			if (columnName.equals("Phone"))
				sbStr.append("&Phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//电话
			if (columnName.equals("Databaseunitid"))
				sbStr.append("&Databaseunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseunitid()));//单位编号
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
            sbStr.append("&databasepeoplesectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeoplesectorid()));//部门ID
            sbStr.append("&peoplesectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getPeoplesectorid()));//部门编号
            sbStr.append("&peoplesectorname=").append(com.colorwinglib.StringFormat.UrlEncode(getPeoplesectorname()));//部门名称
            sbStr.append("&adress=").append(com.colorwinglib.StringFormat.UrlEncode(getAdress()));//办公住址
            sbStr.append("&phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//电话
            sbStr.append("&databaseunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseunitid()));//单位编号

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
			if (columnName.equals("Databasepeoplesectorid"))
				sbStr.append("&databasepeoplesectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeoplesectorid()));//部门ID
			if (columnName.equals("Peoplesectorid"))
				sbStr.append("&peoplesectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getPeoplesectorid()));//部门编号
			if (columnName.equals("Peoplesectorname"))
				sbStr.append("&peoplesectorname=").append(com.colorwinglib.StringFormat.UrlEncode(getPeoplesectorname()));//部门名称
			if (columnName.equals("Adress"))
				sbStr.append("&adress=").append(com.colorwinglib.StringFormat.UrlEncode(getAdress()));//办公住址
			if (columnName.equals("Phone"))
				sbStr.append("&phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//电话
			if (columnName.equals("Databaseunitid"))
				sbStr.append("&databaseunitid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseunitid()));//单位编号
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
	public static PeoplesectorInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			PeoplesectorInfo obj = (PeoplesectorInfo) in.readObject();
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
	public String ToModifyString(PeoplesectorInfo objOld)
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
	public String ToModifyString(PeoplesectorInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getDatabasepeoplesectorid(), objOld.getDatabasepeoplesectorid()))
			sbStr.append("Databasepeoplesectorid 部门ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabasepeoplesectorid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabasepeoplesectorid())).append("]").append(strSplit);// 部门ID
		if (com.colorwinglib.Validate.isEquals(getPeoplesectorid(), objOld.getPeoplesectorid()))
			sbStr.append("Peoplesectorid 部门编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getPeoplesectorid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPeoplesectorid())).append("]").append(strSplit);// 部门编号
		if (com.colorwinglib.Validate.isEquals(getPeoplesectorname(), objOld.getPeoplesectorname()))
			sbStr.append("Peoplesectorname 部门名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getPeoplesectorname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPeoplesectorname())).append("]").append(strSplit);// 部门名称
		if (com.colorwinglib.Validate.isEquals(getAdress(), objOld.getAdress()))
			sbStr.append("Adress 办公住址:[").append(com.colorwinglib.Converts.objToStr(objOld.getAdress())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAdress())).append("]").append(strSplit);// 办公住址
		if (com.colorwinglib.Validate.isEquals(getPhone(), objOld.getPhone()))
			sbStr.append("Phone 电话:[").append(com.colorwinglib.Converts.objToStr(objOld.getPhone())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPhone())).append("]").append(strSplit);// 电话
		if (com.colorwinglib.Validate.isEquals(getDatabaseunitid(), objOld.getDatabaseunitid()))
			sbStr.append("Databaseunitid 单位编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabaseunitid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabaseunitid())).append("]").append(strSplit);// 单位编号
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
			json.put("Databasepeoplesectorid", getDatabasepeoplesectorid());// 部门ID
			json.put("Peoplesectorid", getPeoplesectorid());// 部门编号
			json.put("Peoplesectorname", getPeoplesectorname());// 部门名称
			json.put("Adress", getAdress());// 办公住址
			json.put("Phone", getPhone());// 电话
			json.put("Databaseunitid", getDatabaseunitid());// 单位编号
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
			setDatabasepeoplesectorid(json.getInt("Databasepeoplesectorid"));// 部门ID
			setPeoplesectorid(json.getInt("Peoplesectorid"));// 部门编号
			setPeoplesectorname(json.getString("Peoplesectorname"));// 部门名称
			setAdress(json.getString("Adress"));// 办公住址
			setPhone(json.getString("Phone"));// 电话
			setDatabaseunitid(json.getInt("Databaseunitid"));// 单位编号

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
		sbStr.append("<PeoplesectorInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //部门ID
			sbStr.append("    <Databasepeoplesectorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabasepeoplesectorid()));
			sbStr.append("</Databasepeoplesectorid>\n");
            //部门编号
			sbStr.append("    <Peoplesectorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPeoplesectorid()));
			sbStr.append("</Peoplesectorid>\n");
            //部门名称
			sbStr.append("    <Peoplesectorname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPeoplesectorname()));
			sbStr.append("</Peoplesectorname>\n");
            //办公住址
			sbStr.append("    <Adress>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAdress()));
			sbStr.append("</Adress>\n");
            //电话
			sbStr.append("    <Phone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPhone()));
			sbStr.append("</Phone>\n");
            //单位编号
			sbStr.append("    <Databaseunitid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabaseunitid()));
			sbStr.append("</Databaseunitid>\n");
		sbStr.append("</PeoplesectorInfo>\n");
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
	// GetPeoplesectorInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetPeoplesectorInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static PeoplesectorInfo GetPeoplesectorInfoFormFileName(String filename)
	{
		return GetPeoplesectorInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetPeoplesectorInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PeoplesectorInfo GetPeoplesectorInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetPeoplesectorInfoFormXml(xml, encoding);
	}

	// [end]

	// GetPeoplesectorInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetPeoplesectorInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PeoplesectorInfo GetPeoplesectorInfoFormXml(String xml)
	{
		return GetPeoplesectorInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetPeoplesectorInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PeoplesectorInfo GetPeoplesectorInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		PeoplesectorInfo objPeoplesectorInfo = new PeoplesectorInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//部门ID
				if (foo.elementText("Databasepeoplesectorid") != null)
					objPeoplesectorInfo.setDatabasepeoplesectorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasepeoplesectorid")));
				//部门编号
				if (foo.elementText("Peoplesectorid") != null)
					objPeoplesectorInfo.setPeoplesectorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Peoplesectorid")));
				//部门名称
				if (foo.elementText("Peoplesectorname") != null)
					objPeoplesectorInfo.setPeoplesectorname(com.colorwinglib.Converts.objToStr(foo.elementText("Peoplesectorname")));
				//办公住址
				if (foo.elementText("Adress") != null)
					objPeoplesectorInfo.setAdress(com.colorwinglib.Converts.objToStr(foo.elementText("Adress")));
				//电话
				if (foo.elementText("Phone") != null)
					objPeoplesectorInfo.setPhone(com.colorwinglib.Converts.objToStr(foo.elementText("Phone")));
				//单位编号
				if (foo.elementText("Databaseunitid") != null)
					objPeoplesectorInfo.setDatabaseunitid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseunitid")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objPeoplesectorInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public PeoplesectorInfo Copy()
	{
		PeoplesectorInfo objPeoplesectorInfo = new PeoplesectorInfo();
		objPeoplesectorInfo.setDatabasepeoplesectorid(this.getDatabasepeoplesectorid());//部门ID
		objPeoplesectorInfo.setPeoplesectorid(this.getPeoplesectorid());//部门编号
		objPeoplesectorInfo.setPeoplesectorname(this.getPeoplesectorname());//部门名称
		objPeoplesectorInfo.setAdress(this.getAdress());//办公住址
		objPeoplesectorInfo.setPhone(this.getPhone());//电话
		objPeoplesectorInfo.setDatabaseunitid(this.getDatabaseunitid());//单位编号
		return objPeoplesectorInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
