
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * SystemAdminLog 管理人员日志表的描述
 * 实体类基本类
 */
public class SystemAdminLogInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311554842170L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public SystemAdminLogInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public SystemAdminLogInfoBase(int sLogid)
	{
		this.setLogid(sLogid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public SystemAdminLogInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setLogid(rs.getInt("LogID"));//人员日志编号
		setAdminname(rs.getString("AdminName"));//帐号
		setType(rs.getInt("Type"));//日志类型：1-操作日志、2-登录日志
		setContent(rs.getString("Content"));//日志内容
		setAddtime(MyDate.setDate(rs.getTimestamp("AddTime")));//日志时间
		setIp(rs.getString("IP"));//日志IP
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public SystemAdminLogInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//人员日志编号
			if (columnName.equals("LogID"))
			{
				setLogid(rs.getInt("LogID"));
				continue;
			}
			//帐号
			if (columnName.equals("AdminName"))
			{
				setAdminname(rs.getString("AdminName"));
				continue;
			}
			//日志类型：1-操作日志、2-登录日志
			if (columnName.equals("Type"))
			{
				setType(rs.getInt("Type"));
				continue;
			}
			//日志内容
			if (columnName.equals("Content"))
			{
				setContent(rs.getString("Content"));
				continue;
			}
			//日志时间
			if (columnName.equals("AddTime"))
			{
				setAddtime(MyDate.setDate(rs.getTimestamp("AddTime")));
				continue;
			}
			//日志IP
			if (columnName.equals("IP"))
			{
				setIp(rs.getString("IP"));
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
		if (!(rhs instanceof SystemAdminLogInfo))
			return false;
		SystemAdminLogInfo that = (SystemAdminLogInfo) rhs;

		return (this.getLogid() == (that.getLogid()));
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

			result = result * 37 + (this.getLogid() + "").hashCode();
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
	"LogID", //人员日志编号
	"AdminName", //帐号
	"Type", //日志类型：1-操作日志、2-登录日志
	"Content", //日志内容
	"AddTime", //日志时间
	"IP" //日志IP
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum SystemAdminLogColumnNameEnum
{
		/**
		 * 人员日志编号
		 */
		Logid,
		/**
		 * 帐号
		 */
		Adminname,
		/**
		 * 日志类型：1-操作日志、2-登录日志
		 */
		Type,
		/**
		 * 日志内容
		 */
		Content,
		/**
		 * 日志时间
		 */
		Addtime,
		/**
		 * 日志IP
		 */
		Ip
	};
	// [end]
        // [start] 设置和获取 人员日志编号, 默认值:0
	// 设置和获取 人员日志编号,类型int 默认值:0 开始
	private int logid = 0;
	/**
	* 获取 人员日志编号, 类型int 默认值:0
	 *
	 * @return 人员日志编号, 类型int 默认值:0
	 */
	public int getLogid()
	{
		return this.logid; 
	}
	/**
	 * 设置 人员日志编号, 类型int 默认值:0
	 *
	 * @param sLogid
	 *            人员日志编号, 类型int 默认值:0
	 */
	public void setLogid(int sLogid)
	{
		this.logid = sLogid; 
	}
	// 设置和获取 人员日志编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 帐号, 默认值:""
	// 设置和获取 帐号,类型String 默认值:"" 开始
	private String adminname = "";
	/**
	* 获取 帐号, 类型String 默认值:""
	 *
	 * @return 帐号, 类型String 默认值:""
	 */
	public String getAdminname()
	{
		return this.adminname; 
	}
	/**
	 * 设置 帐号, 类型String 默认值:""
	 *
	 * @param sAdminname
	 *            帐号, 类型String 默认值:""
	 */
	public void setAdminname(String sAdminname)
	{
		this.adminname = sAdminname; 
	}
	// 设置和获取 帐号, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 日志类型：1-操作日志、2-登录日志, 默认值:0
	// 设置和获取 日志类型：1-操作日志、2-登录日志,类型int 默认值:0 开始
	private int type = 0;
	/**
	* 获取 日志类型：1-操作日志、2-登录日志, 类型int 默认值:0
	 *
	 * @return 日志类型：1-操作日志、2-登录日志, 类型int 默认值:0
	 */
	public int getType()
	{
		return this.type; 
	}
	/**
	 * 设置 日志类型：1-操作日志、2-登录日志, 类型int 默认值:0
	 *
	 * @param sType
	 *            日志类型：1-操作日志、2-登录日志, 类型int 默认值:0
	 */
	public void setType(int sType)
	{
		this.type = sType; 
	}
	// 设置和获取 日志类型：1-操作日志、2-登录日志, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 日志内容, 默认值:""
	// 设置和获取 日志内容,类型String 默认值:"" 开始
	private String content = "";
	/**
	* 获取 日志内容, 类型String 默认值:""
	 *
	 * @return 日志内容, 类型String 默认值:""
	 */
	public String getContent()
	{
		return this.content; 
	}
	/**
	 * 设置 日志内容, 类型String 默认值:""
	 *
	 * @param sContent
	 *            日志内容, 类型String 默认值:""
	 */
	public void setContent(String sContent)
	{
		this.content = sContent; 
	}
	// 设置和获取 日志内容, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 日志时间, 默认值:new Date()
	// 设置和获取 日志时间,类型Date 默认值:new Date() 开始
	private Date addtime = new Date();
	/**
	* 获取 日志时间, 类型Date 默认值:new Date()
	 *
	 * @return 日志时间, 类型Date 默认值:new Date()
	 */
	public Date getAddtime()
	{
		if (!(this.addtime instanceof MyDate))
			this.addtime = MyDate.setDate(this.addtime);
		return this.addtime; 
	}
	/**
	 * 设置 日志时间, 类型Date 默认值:new Date()
	 *
	 * @param sAddtime
	 *            日志时间, 类型Date 默认值:new Date()
	 */
	public void setAddtime(Date sAddtime)
	{
		this.addtime = sAddtime; 
	}
	// 设置和获取 日志时间, 类型Date 默认值:new Date() 结束
        // [end]


        // [start] 设置和获取 日志IP, 默认值:""
	// 设置和获取 日志IP,类型String 默认值:"" 开始
	private String ip = "";
	/**
	* 获取 日志IP, 类型String 默认值:""
	 *
	 * @return 日志IP, 类型String 默认值:""
	 */
	public String getIp()
	{
		return this.ip; 
	}
	/**
	 * 设置 日志IP, 类型String 默认值:""
	 *
	 * @param sIp
	 *            日志IP, 类型String 默认值:""
	 */
	public void setIp(String sIp)
	{
		this.ip = sIp; 
	}
	// 设置和获取 日志IP, 类型String 默认值:"" 结束
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
            sbStr.append(getLogid()).append(strSplit);
            sbStr.append(getAdminname()).append(strSplit);
            sbStr.append(getType()).append(strSplit);
            sbStr.append(getContent()).append(strSplit);
            sbStr.append(getAddtime()).append(strSplit);
            sbStr.append(getIp()).append(strSplit);

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
                setLogid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setAdminname(com.colorwinglib.Converts.objToStr(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setType(com.colorwinglib.Converts.StrToInt(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setContent(com.colorwinglib.Converts.objToStr(objs[3]));
            }
            if (objs[4] != null || objs[4].length() >= 1)
            {
                setAddtime(com.colorwinglib.Converts.StrToDate(objs[4]));
            }
            if (objs[5] != null || objs[5].length() >= 1)
            {
                setIp(com.colorwinglib.Converts.objToStr(objs[5]));
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
            sbStr.append("&Logid=").append(com.colorwinglib.StringFormat.UrlEncode(getLogid()));//人员日志编号
            sbStr.append("&Adminname=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminname()));//帐号
            sbStr.append("&Type=").append(com.colorwinglib.StringFormat.UrlEncode(getType()));//日志类型：1-操作日志、2-登录日志
            sbStr.append("&Content=").append(com.colorwinglib.StringFormat.UrlEncode(getContent()));//日志内容
            sbStr.append("&Addtime=").append(com.colorwinglib.StringFormat.UrlEncode(getAddtime()));//日志时间
            sbStr.append("&Ip=").append(com.colorwinglib.StringFormat.UrlEncode(getIp()));//日志IP

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
			if (columnName.equals("Logid"))
				sbStr.append("&Logid=").append(com.colorwinglib.StringFormat.UrlEncode(getLogid()));//人员日志编号
			if (columnName.equals("Adminname"))
				sbStr.append("&Adminname=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminname()));//帐号
			if (columnName.equals("Type"))
				sbStr.append("&Type=").append(com.colorwinglib.StringFormat.UrlEncode(getType()));//日志类型：1-操作日志、2-登录日志
			if (columnName.equals("Content"))
				sbStr.append("&Content=").append(com.colorwinglib.StringFormat.UrlEncode(getContent()));//日志内容
			if (columnName.equals("Addtime"))
				sbStr.append("&Addtime=").append(com.colorwinglib.StringFormat.UrlEncode(getAddtime()));//日志时间
			if (columnName.equals("Ip"))
				sbStr.append("&Ip=").append(com.colorwinglib.StringFormat.UrlEncode(getIp()));//日志IP
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
            sbStr.append("&logid=").append(com.colorwinglib.StringFormat.UrlEncode(getLogid()));//人员日志编号
            sbStr.append("&adminname=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminname()));//帐号
            sbStr.append("&type=").append(com.colorwinglib.StringFormat.UrlEncode(getType()));//日志类型：1-操作日志、2-登录日志
            sbStr.append("&content=").append(com.colorwinglib.StringFormat.UrlEncode(getContent()));//日志内容
            sbStr.append("&addtime=").append(com.colorwinglib.StringFormat.UrlEncode(getAddtime()));//日志时间
            sbStr.append("&ip=").append(com.colorwinglib.StringFormat.UrlEncode(getIp()));//日志IP

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
			if (columnName.equals("Logid"))
				sbStr.append("&logid=").append(com.colorwinglib.StringFormat.UrlEncode(getLogid()));//人员日志编号
			if (columnName.equals("Adminname"))
				sbStr.append("&adminname=").append(com.colorwinglib.StringFormat.UrlEncode(getAdminname()));//帐号
			if (columnName.equals("Type"))
				sbStr.append("&type=").append(com.colorwinglib.StringFormat.UrlEncode(getType()));//日志类型：1-操作日志、2-登录日志
			if (columnName.equals("Content"))
				sbStr.append("&content=").append(com.colorwinglib.StringFormat.UrlEncode(getContent()));//日志内容
			if (columnName.equals("Addtime"))
				sbStr.append("&addtime=").append(com.colorwinglib.StringFormat.UrlEncode(getAddtime()));//日志时间
			if (columnName.equals("Ip"))
				sbStr.append("&ip=").append(com.colorwinglib.StringFormat.UrlEncode(getIp()));//日志IP
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
	public static SystemAdminLogInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			SystemAdminLogInfo obj = (SystemAdminLogInfo) in.readObject();
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
	public String ToModifyString(SystemAdminLogInfo objOld)
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
	public String ToModifyString(SystemAdminLogInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getLogid(), objOld.getLogid()))
			sbStr.append("Logid 人员日志编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getLogid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getLogid())).append("]").append(strSplit);// 人员日志编号
		if (com.colorwinglib.Validate.isEquals(getAdminname(), objOld.getAdminname()))
			sbStr.append("Adminname 帐号:[").append(com.colorwinglib.Converts.objToStr(objOld.getAdminname())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAdminname())).append("]").append(strSplit);// 帐号
		if (com.colorwinglib.Validate.isEquals(getType(), objOld.getType()))
			sbStr.append("Type 日志类型：1-操作日志、2-登录日志:[").append(com.colorwinglib.Converts.objToStr(objOld.getType())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getType())).append("]").append(strSplit);// 日志类型：1-操作日志、2-登录日志
		if (com.colorwinglib.Validate.isEquals(getContent(), objOld.getContent()))
			sbStr.append("Content 日志内容:[").append(com.colorwinglib.Converts.objToStr(objOld.getContent())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getContent())).append("]").append(strSplit);// 日志内容
		if (com.colorwinglib.Validate.isEquals(getAddtime(), objOld.getAddtime()))
			sbStr.append("Addtime 日志时间:[").append(com.colorwinglib.Converts.objToStr(objOld.getAddtime())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAddtime())).append("]").append(strSplit);// 日志时间
		if (com.colorwinglib.Validate.isEquals(getIp(), objOld.getIp()))
			sbStr.append("Ip 日志IP:[").append(com.colorwinglib.Converts.objToStr(objOld.getIp())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getIp())).append("]").append(strSplit);// 日志IP
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
			json.put("Logid", getLogid());// 人员日志编号
			json.put("Adminname", getAdminname());// 帐号
			json.put("Type", getType());// 日志类型：1-操作日志、2-登录日志
			json.put("Content", getContent());// 日志内容
			json.put("Addtime", getAddtime());// 日志时间
			json.put("Ip", getIp());// 日志IP
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
			setLogid(json.getInt("Logid"));// 人员日志编号
			setAdminname(json.getString("Adminname"));// 帐号
			setType(json.getInt("Type"));// 日志类型：1-操作日志、2-登录日志
			setContent(json.getString("Content"));// 日志内容
			setAddtime(com.colorwinglib.Converts.StrToDate(json.getString("Addtime")));// 日志时间
			setIp(json.getString("Ip"));// 日志IP

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
		sbStr.append("<SystemAdminLogInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //人员日志编号
			sbStr.append("    <Logid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getLogid()));
			sbStr.append("</Logid>\n");
            //帐号
			sbStr.append("    <Adminname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAdminname()));
			sbStr.append("</Adminname>\n");
            //日志类型：1-操作日志、2-登录日志
			sbStr.append("    <Type>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getType()));
			sbStr.append("</Type>\n");
            //日志内容
			sbStr.append("    <Content>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getContent()));
			sbStr.append("</Content>\n");
            //日志时间
			sbStr.append("    <Addtime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAddtime()));
			sbStr.append("</Addtime>\n");
            //日志IP
			sbStr.append("    <Ip>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getIp()));
			sbStr.append("</Ip>\n");
		sbStr.append("</SystemAdminLogInfo>\n");
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
	// GetSystemAdminLogInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetSystemAdminLogInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static SystemAdminLogInfo GetSystemAdminLogInfoFormFileName(String filename)
	{
		return GetSystemAdminLogInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemAdminLogInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemAdminLogInfo GetSystemAdminLogInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetSystemAdminLogInfoFormXml(xml, encoding);
	}

	// [end]

	// GetSystemAdminLogInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetSystemAdminLogInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemAdminLogInfo GetSystemAdminLogInfoFormXml(String xml)
	{
		return GetSystemAdminLogInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemAdminLogInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemAdminLogInfo GetSystemAdminLogInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		SystemAdminLogInfo objSystemAdminLogInfo = new SystemAdminLogInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//人员日志编号
				if (foo.elementText("Logid") != null)
					objSystemAdminLogInfo.setLogid(com.colorwinglib.Converts.StrToInt(foo.elementText("Logid")));
				//帐号
				if (foo.elementText("Adminname") != null)
					objSystemAdminLogInfo.setAdminname(com.colorwinglib.Converts.objToStr(foo.elementText("Adminname")));
				//日志类型：1-操作日志、2-登录日志
				if (foo.elementText("Type") != null)
					objSystemAdminLogInfo.setType(com.colorwinglib.Converts.StrToInt(foo.elementText("Type")));
				//日志内容
				if (foo.elementText("Content") != null)
					objSystemAdminLogInfo.setContent(com.colorwinglib.Converts.objToStr(foo.elementText("Content")));
				//日志时间
				if (foo.elementText("Addtime") != null)
					objSystemAdminLogInfo.setAddtime(com.colorwinglib.Converts.StrToDate(foo.elementText("Addtime")));
				//日志IP
				if (foo.elementText("Ip") != null)
					objSystemAdminLogInfo.setIp(com.colorwinglib.Converts.objToStr(foo.elementText("Ip")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objSystemAdminLogInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public SystemAdminLogInfo Copy()
	{
		SystemAdminLogInfo objSystemAdminLogInfo = new SystemAdminLogInfo();
		objSystemAdminLogInfo.setLogid(this.getLogid());//人员日志编号
		objSystemAdminLogInfo.setAdminname(this.getAdminname());//帐号
		objSystemAdminLogInfo.setType(this.getType());//日志类型：1-操作日志、2-登录日志
		objSystemAdminLogInfo.setContent(this.getContent());//日志内容
		objSystemAdminLogInfo.setAddtime(this.getAddtime());//日志时间
		objSystemAdminLogInfo.setIp(this.getIp());//日志IP
		return objSystemAdminLogInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明

        // [start] 设置和获取 日志类型：1-操作日志、2-登录日志, 默认值:0
	private String typelabel = "";
	/**
	* 获取 日志类型：1-操作日志、2-登录日志, 类型String 默认值:""
	 *
	 * @return 日志类型：1-操作日志、2-登录日志, 类型String 默认值:""
	 */
	public String getTypelabel()
	{
		if (typelabel.length() == 0)
			typelabel = com.yun.bll.itemcollection.culture.SystemAdminLogItemCollection.TypeText(String.valueOf(getType()));
		return this.typelabel; 
	}
        // [end]



	 //[end]
}
