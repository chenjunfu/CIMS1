
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Projectpic 项目图片表的描述
 * 实体类基本类
 */
public class ProjectpicInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311540287532L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public ProjectpicInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public ProjectpicInfoBase(int sProjectpicid)
	{
		this.setProjectpicid(sProjectpicid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public ProjectpicInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setProjectpicid(rs.getInt("ProjectPicID"));//项目图片编号
		setDatabaseprojectid(rs.getInt("DatabaseProjectID"));//项目编号
		setPic(rs.getString("Pic"));//项目图片
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public ProjectpicInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//项目图片编号
			if (columnName.equals("ProjectPicID"))
			{
				setProjectpicid(rs.getInt("ProjectPicID"));
				continue;
			}
			//项目编号
			if (columnName.equals("DatabaseProjectID"))
			{
				setDatabaseprojectid(rs.getInt("DatabaseProjectID"));
				continue;
			}
			//项目图片
			if (columnName.equals("Pic"))
			{
				setPic(rs.getString("Pic"));
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
		if (!(rhs instanceof ProjectpicInfo))
			return false;
		ProjectpicInfo that = (ProjectpicInfo) rhs;

		return (this.getProjectpicid() == (that.getProjectpicid()));
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

			result = result * 37 + (this.getProjectpicid() + "").hashCode();
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
	"ProjectPicID", //项目图片编号
	"DatabaseProjectID", //项目编号
	"Pic" //项目图片
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum ProjectpicColumnNameEnum
{
		/**
		 * 项目图片编号
		 */
		Projectpicid,
		/**
		 * 项目编号
		 */
		Databaseprojectid,
		/**
		 * 项目图片
		 */
		Pic
	};
	// [end]
        // [start] 设置和获取 项目图片编号, 默认值:0
	// 设置和获取 项目图片编号,类型int 默认值:0 开始
	private int projectpicid = 0;
	/**
	* 获取 项目图片编号, 类型int 默认值:0
	 *
	 * @return 项目图片编号, 类型int 默认值:0
	 */
	public int getProjectpicid()
	{
		return this.projectpicid; 
	}
	/**
	 * 设置 项目图片编号, 类型int 默认值:0
	 *
	 * @param sProjectpicid
	 *            项目图片编号, 类型int 默认值:0
	 */
	public void setProjectpicid(int sProjectpicid)
	{
		this.projectpicid = sProjectpicid; 
	}
	// 设置和获取 项目图片编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 项目编号, 默认值:0
	// 设置和获取 项目编号,类型int 默认值:0 开始
	private int databaseprojectid = 0;
	/**
	* 获取 项目编号, 类型int 默认值:0
	 *
	 * @return 项目编号, 类型int 默认值:0
	 */
	public int getDatabaseprojectid()
	{
		return this.databaseprojectid; 
	}
	/**
	 * 设置 项目编号, 类型int 默认值:0
	 *
	 * @param sDatabaseprojectid
	 *            项目编号, 类型int 默认值:0
	 */
	public void setDatabaseprojectid(int sDatabaseprojectid)
	{
		this.databaseprojectid = sDatabaseprojectid; 
	}
	// 设置和获取 项目编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 项目图片, 默认值:""
	// 设置和获取 项目图片,类型String 默认值:"" 开始
	private String pic = "";
	/**
	* 获取 项目图片, 类型String 默认值:""
	 *
	 * @return 项目图片, 类型String 默认值:""
	 */
	public String getPic()
	{
		return this.pic; 
	}
	/**
	 * 设置 项目图片, 类型String 默认值:""
	 *
	 * @param sPic
	 *            项目图片, 类型String 默认值:""
	 */
	public void setPic(String sPic)
	{
		this.pic = sPic; 
	}
	// 设置和获取 项目图片, 类型String 默认值:"" 结束
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
            sbStr.append(getProjectpicid()).append(strSplit);
            sbStr.append(getDatabaseprojectid()).append(strSplit);
            sbStr.append(getPic()).append(strSplit);

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
                setProjectpicid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setDatabaseprojectid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setPic(com.colorwinglib.Converts.objToStr(objs[2]));
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
            sbStr.append("&Projectpicid=").append(com.colorwinglib.StringFormat.UrlEncode(getProjectpicid()));//项目图片编号
            sbStr.append("&Databaseprojectid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseprojectid()));//项目编号
            sbStr.append("&Pic=").append(com.colorwinglib.StringFormat.UrlEncode(getPic()));//项目图片

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
			if (columnName.equals("Projectpicid"))
				sbStr.append("&Projectpicid=").append(com.colorwinglib.StringFormat.UrlEncode(getProjectpicid()));//项目图片编号
			if (columnName.equals("Databaseprojectid"))
				sbStr.append("&Databaseprojectid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseprojectid()));//项目编号
			if (columnName.equals("Pic"))
				sbStr.append("&Pic=").append(com.colorwinglib.StringFormat.UrlEncode(getPic()));//项目图片
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
            sbStr.append("&projectpicid=").append(com.colorwinglib.StringFormat.UrlEncode(getProjectpicid()));//项目图片编号
            sbStr.append("&databaseprojectid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseprojectid()));//项目编号
            sbStr.append("&pic=").append(com.colorwinglib.StringFormat.UrlEncode(getPic()));//项目图片

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
			if (columnName.equals("Projectpicid"))
				sbStr.append("&projectpicid=").append(com.colorwinglib.StringFormat.UrlEncode(getProjectpicid()));//项目图片编号
			if (columnName.equals("Databaseprojectid"))
				sbStr.append("&databaseprojectid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaseprojectid()));//项目编号
			if (columnName.equals("Pic"))
				sbStr.append("&pic=").append(com.colorwinglib.StringFormat.UrlEncode(getPic()));//项目图片
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
	public static ProjectpicInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			ProjectpicInfo obj = (ProjectpicInfo) in.readObject();
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
	public String ToModifyString(ProjectpicInfo objOld)
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
	public String ToModifyString(ProjectpicInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getProjectpicid(), objOld.getProjectpicid()))
			sbStr.append("Projectpicid 项目图片编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getProjectpicid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getProjectpicid())).append("]").append(strSplit);// 项目图片编号
		if (com.colorwinglib.Validate.isEquals(getDatabaseprojectid(), objOld.getDatabaseprojectid()))
			sbStr.append("Databaseprojectid 项目编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabaseprojectid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabaseprojectid())).append("]").append(strSplit);// 项目编号
		if (com.colorwinglib.Validate.isEquals(getPic(), objOld.getPic()))
			sbStr.append("Pic 项目图片:[").append(com.colorwinglib.Converts.objToStr(objOld.getPic())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPic())).append("]").append(strSplit);// 项目图片
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
			json.put("Projectpicid", getProjectpicid());// 项目图片编号
			json.put("Databaseprojectid", getDatabaseprojectid());// 项目编号
			json.put("Pic", getPic());// 项目图片
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
			setProjectpicid(json.getInt("Projectpicid"));// 项目图片编号
			setDatabaseprojectid(json.getInt("Databaseprojectid"));// 项目编号
			setPic(json.getString("Pic"));// 项目图片

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
		sbStr.append("<ProjectpicInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //项目图片编号
			sbStr.append("    <Projectpicid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getProjectpicid()));
			sbStr.append("</Projectpicid>\n");
            //项目编号
			sbStr.append("    <Databaseprojectid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabaseprojectid()));
			sbStr.append("</Databaseprojectid>\n");
            //项目图片
			sbStr.append("    <Pic>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPic()));
			sbStr.append("</Pic>\n");
		sbStr.append("</ProjectpicInfo>\n");
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
	// GetProjectpicInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetProjectpicInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static ProjectpicInfo GetProjectpicInfoFormFileName(String filename)
	{
		return GetProjectpicInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetProjectpicInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProjectpicInfo GetProjectpicInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetProjectpicInfoFormXml(xml, encoding);
	}

	// [end]

	// GetProjectpicInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetProjectpicInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProjectpicInfo GetProjectpicInfoFormXml(String xml)
	{
		return GetProjectpicInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetProjectpicInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProjectpicInfo GetProjectpicInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		ProjectpicInfo objProjectpicInfo = new ProjectpicInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//项目图片编号
				if (foo.elementText("Projectpicid") != null)
					objProjectpicInfo.setProjectpicid(com.colorwinglib.Converts.StrToInt(foo.elementText("Projectpicid")));
				//项目编号
				if (foo.elementText("Databaseprojectid") != null)
					objProjectpicInfo.setDatabaseprojectid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseprojectid")));
				//项目图片
				if (foo.elementText("Pic") != null)
					objProjectpicInfo.setPic(com.colorwinglib.Converts.objToStr(foo.elementText("Pic")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objProjectpicInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public ProjectpicInfo Copy()
	{
		ProjectpicInfo objProjectpicInfo = new ProjectpicInfo();
		objProjectpicInfo.setProjectpicid(this.getProjectpicid());//项目图片编号
		objProjectpicInfo.setDatabaseprojectid(this.getDatabaseprojectid());//项目编号
		objProjectpicInfo.setPic(this.getPic());//项目图片
		return objProjectpicInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
