
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * RolesCompetence 角色权限表的描述
 * 实体类基本类
 */
public class RolesCompetenceInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311545659347L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public RolesCompetenceInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public RolesCompetenceInfoBase(int sDatabaserosecompetenceid)
	{
		this.setDatabaserosecompetenceid(sDatabaserosecompetenceid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public RolesCompetenceInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setDatabaserosecompetenceid(rs.getInt("DatabaseRoseCompetenceID"));//角色权限ID
		setRolesid(rs.getInt("RolesID"));//角色ID
		setCompetenceid(rs.getInt("CompetenceID"));//权限编号
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public RolesCompetenceInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//角色权限ID
			if (columnName.equals("DatabaseRoseCompetenceID"))
			{
				setDatabaserosecompetenceid(rs.getInt("DatabaseRoseCompetenceID"));
				continue;
			}
			//角色ID
			if (columnName.equals("RolesID"))
			{
				setRolesid(rs.getInt("RolesID"));
				continue;
			}
			//权限编号
			if (columnName.equals("CompetenceID"))
			{
				setCompetenceid(rs.getInt("CompetenceID"));
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
		if (!(rhs instanceof RolesCompetenceInfo))
			return false;
		RolesCompetenceInfo that = (RolesCompetenceInfo) rhs;

		return (this.getDatabaserosecompetenceid() == (that.getDatabaserosecompetenceid()));
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

			result = result * 37 + (this.getDatabaserosecompetenceid() + "").hashCode();
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
	"DatabaseRoseCompetenceID", //角色权限ID
	"RolesID", //角色ID
	"CompetenceID" //权限编号
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum RolesCompetenceColumnNameEnum
{
		/**
		 * 角色权限ID
		 */
		Databaserosecompetenceid,
		/**
		 * 角色ID
		 */
		Rolesid,
		/**
		 * 权限编号
		 */
		Competenceid
	};
	// [end]
        // [start] 设置和获取 角色权限ID, 默认值:0
	// 设置和获取 角色权限ID,类型int 默认值:0 开始
	private int databaserosecompetenceid = 0;
	/**
	* 获取 角色权限ID, 类型int 默认值:0
	 *
	 * @return 角色权限ID, 类型int 默认值:0
	 */
	public int getDatabaserosecompetenceid()
	{
		return this.databaserosecompetenceid; 
	}
	/**
	 * 设置 角色权限ID, 类型int 默认值:0
	 *
	 * @param sDatabaserosecompetenceid
	 *            角色权限ID, 类型int 默认值:0
	 */
	public void setDatabaserosecompetenceid(int sDatabaserosecompetenceid)
	{
		this.databaserosecompetenceid = sDatabaserosecompetenceid; 
	}
	// 设置和获取 角色权限ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 角色ID, 默认值:0
	// 设置和获取 角色ID,类型int 默认值:0 开始
	private int rolesid = 0;
	/**
	* 获取 角色ID, 类型int 默认值:0
	 *
	 * @return 角色ID, 类型int 默认值:0
	 */
	public int getRolesid()
	{
		return this.rolesid; 
	}
	/**
	 * 设置 角色ID, 类型int 默认值:0
	 *
	 * @param sRolesid
	 *            角色ID, 类型int 默认值:0
	 */
	public void setRolesid(int sRolesid)
	{
		this.rolesid = sRolesid; 
	}
	// 设置和获取 角色ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 权限编号, 默认值:0
	// 设置和获取 权限编号,类型int 默认值:0 开始
	private int competenceid = 0;
	/**
	* 获取 权限编号, 类型int 默认值:0
	 *
	 * @return 权限编号, 类型int 默认值:0
	 */
	public int getCompetenceid()
	{
		return this.competenceid; 
	}
	/**
	 * 设置 权限编号, 类型int 默认值:0
	 *
	 * @param sCompetenceid
	 *            权限编号, 类型int 默认值:0
	 */
	public void setCompetenceid(int sCompetenceid)
	{
		this.competenceid = sCompetenceid; 
	}
	// 设置和获取 权限编号, 类型int 默认值:0 结束
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
            sbStr.append(getDatabaserosecompetenceid()).append(strSplit);
            sbStr.append(getRolesid()).append(strSplit);
            sbStr.append(getCompetenceid()).append(strSplit);

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
                setDatabaserosecompetenceid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setRolesid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setCompetenceid(com.colorwinglib.Converts.StrToInt(objs[2]));
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
            sbStr.append("&Databaserosecompetenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaserosecompetenceid()));//角色权限ID
            sbStr.append("&Rolesid=").append(com.colorwinglib.StringFormat.UrlEncode(getRolesid()));//角色ID
            sbStr.append("&Competenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetenceid()));//权限编号

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
			if (columnName.equals("Databaserosecompetenceid"))
				sbStr.append("&Databaserosecompetenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaserosecompetenceid()));//角色权限ID
			if (columnName.equals("Rolesid"))
				sbStr.append("&Rolesid=").append(com.colorwinglib.StringFormat.UrlEncode(getRolesid()));//角色ID
			if (columnName.equals("Competenceid"))
				sbStr.append("&Competenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetenceid()));//权限编号
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
            sbStr.append("&databaserosecompetenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaserosecompetenceid()));//角色权限ID
            sbStr.append("&rolesid=").append(com.colorwinglib.StringFormat.UrlEncode(getRolesid()));//角色ID
            sbStr.append("&competenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetenceid()));//权限编号

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
			if (columnName.equals("Databaserosecompetenceid"))
				sbStr.append("&databaserosecompetenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabaserosecompetenceid()));//角色权限ID
			if (columnName.equals("Rolesid"))
				sbStr.append("&rolesid=").append(com.colorwinglib.StringFormat.UrlEncode(getRolesid()));//角色ID
			if (columnName.equals("Competenceid"))
				sbStr.append("&competenceid=").append(com.colorwinglib.StringFormat.UrlEncode(getCompetenceid()));//权限编号
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
	public static RolesCompetenceInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			RolesCompetenceInfo obj = (RolesCompetenceInfo) in.readObject();
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
	public String ToModifyString(RolesCompetenceInfo objOld)
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
	public String ToModifyString(RolesCompetenceInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getDatabaserosecompetenceid(), objOld.getDatabaserosecompetenceid()))
			sbStr.append("Databaserosecompetenceid 角色权限ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabaserosecompetenceid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabaserosecompetenceid())).append("]").append(strSplit);// 角色权限ID
		if (com.colorwinglib.Validate.isEquals(getRolesid(), objOld.getRolesid()))
			sbStr.append("Rolesid 角色ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getRolesid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getRolesid())).append("]").append(strSplit);// 角色ID
		if (com.colorwinglib.Validate.isEquals(getCompetenceid(), objOld.getCompetenceid()))
			sbStr.append("Competenceid 权限编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getCompetenceid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getCompetenceid())).append("]").append(strSplit);// 权限编号
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
			json.put("Databaserosecompetenceid", getDatabaserosecompetenceid());// 角色权限ID
			json.put("Rolesid", getRolesid());// 角色ID
			json.put("Competenceid", getCompetenceid());// 权限编号
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
			setDatabaserosecompetenceid(json.getInt("Databaserosecompetenceid"));// 角色权限ID
			setRolesid(json.getInt("Rolesid"));// 角色ID
			setCompetenceid(json.getInt("Competenceid"));// 权限编号

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
		sbStr.append("<RolesCompetenceInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //角色权限ID
			sbStr.append("    <Databaserosecompetenceid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabaserosecompetenceid()));
			sbStr.append("</Databaserosecompetenceid>\n");
            //角色ID
			sbStr.append("    <Rolesid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getRolesid()));
			sbStr.append("</Rolesid>\n");
            //权限编号
			sbStr.append("    <Competenceid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getCompetenceid()));
			sbStr.append("</Competenceid>\n");
		sbStr.append("</RolesCompetenceInfo>\n");
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
	// GetRolesCompetenceInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetRolesCompetenceInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static RolesCompetenceInfo GetRolesCompetenceInfoFormFileName(String filename)
	{
		return GetRolesCompetenceInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetRolesCompetenceInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static RolesCompetenceInfo GetRolesCompetenceInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetRolesCompetenceInfoFormXml(xml, encoding);
	}

	// [end]

	// GetRolesCompetenceInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetRolesCompetenceInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static RolesCompetenceInfo GetRolesCompetenceInfoFormXml(String xml)
	{
		return GetRolesCompetenceInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetRolesCompetenceInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static RolesCompetenceInfo GetRolesCompetenceInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		RolesCompetenceInfo objRolesCompetenceInfo = new RolesCompetenceInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//角色权限ID
				if (foo.elementText("Databaserosecompetenceid") != null)
					objRolesCompetenceInfo.setDatabaserosecompetenceid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaserosecompetenceid")));
				//角色ID
				if (foo.elementText("Rolesid") != null)
					objRolesCompetenceInfo.setRolesid(com.colorwinglib.Converts.StrToInt(foo.elementText("Rolesid")));
				//权限编号
				if (foo.elementText("Competenceid") != null)
					objRolesCompetenceInfo.setCompetenceid(com.colorwinglib.Converts.StrToInt(foo.elementText("Competenceid")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objRolesCompetenceInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public RolesCompetenceInfo Copy()
	{
		RolesCompetenceInfo objRolesCompetenceInfo = new RolesCompetenceInfo();
		objRolesCompetenceInfo.setDatabaserosecompetenceid(this.getDatabaserosecompetenceid());//角色权限ID
		objRolesCompetenceInfo.setRolesid(this.getRolesid());//角色ID
		objRolesCompetenceInfo.setCompetenceid(this.getCompetenceid());//权限编号
		return objRolesCompetenceInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
