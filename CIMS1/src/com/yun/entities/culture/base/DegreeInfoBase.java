
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Degree 的描述
 * 实体类基本类
 */
public class DegreeInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311461206222L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public DegreeInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public DegreeInfoBase(int sDegreedatabaseid)
	{
		this.setDegreedatabaseid(sDegreedatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public DegreeInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setDegreedatabaseid(rs.getInt("DegreedatabaseID"));//DegreedatabaseID
		setDegreeid(rs.getInt("DegreeID"));//DegreeID
		setDegreename(rs.getString("DegreeName"));//DegreeName
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public DegreeInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//DegreedatabaseID
			if (columnName.equals("DegreedatabaseID"))
			{
				setDegreedatabaseid(rs.getInt("DegreedatabaseID"));
				continue;
			}
			//DegreeID
			if (columnName.equals("DegreeID"))
			{
				setDegreeid(rs.getInt("DegreeID"));
				continue;
			}
			//DegreeName
			if (columnName.equals("DegreeName"))
			{
				setDegreename(rs.getString("DegreeName"));
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
		if (!(rhs instanceof DegreeInfo))
			return false;
		DegreeInfo that = (DegreeInfo) rhs;

		return (this.getDegreedatabaseid() == (that.getDegreedatabaseid()));
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

			result = result * 37 + (this.getDegreedatabaseid() + "").hashCode();
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
	"DegreedatabaseID", //DegreedatabaseID
	"DegreeID", //DegreeID
	"DegreeName" //DegreeName
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum DegreeColumnNameEnum
{
		/**
		 * DegreedatabaseID
		 */
		Degreedatabaseid,
		/**
		 * DegreeID
		 */
		Degreeid,
		/**
		 * DegreeName
		 */
		Degreename
	};
	// [end]
        // [start] 设置和获取 DegreedatabaseID, 默认值:0
	// 设置和获取 DegreedatabaseID,类型int 默认值:0 开始
	private int degreedatabaseid = 0;
	/**
	* 获取 DegreedatabaseID, 类型int 默认值:0
	 *
	 * @return DegreedatabaseID, 类型int 默认值:0
	 */
	public int getDegreedatabaseid()
	{
		return this.degreedatabaseid; 
	}
	/**
	 * 设置 DegreedatabaseID, 类型int 默认值:0
	 *
	 * @param sDegreedatabaseid
	 *            DegreedatabaseID, 类型int 默认值:0
	 */
	public void setDegreedatabaseid(int sDegreedatabaseid)
	{
		this.degreedatabaseid = sDegreedatabaseid; 
	}
	// 设置和获取 DegreedatabaseID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 DegreeID, 默认值:0
	// 设置和获取 DegreeID,类型int 默认值:0 开始
	private int degreeid = 0;
	/**
	* 获取 DegreeID, 类型int 默认值:0
	 *
	 * @return DegreeID, 类型int 默认值:0
	 */
	public int getDegreeid()
	{
		return this.degreeid; 
	}
	/**
	 * 设置 DegreeID, 类型int 默认值:0
	 *
	 * @param sDegreeid
	 *            DegreeID, 类型int 默认值:0
	 */
	public void setDegreeid(int sDegreeid)
	{
		this.degreeid = sDegreeid; 
	}
	// 设置和获取 DegreeID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 DegreeName, 默认值:""
	// 设置和获取 DegreeName,类型String 默认值:"" 开始
	private String degreename = "";
	/**
	* 获取 DegreeName, 类型String 默认值:""
	 *
	 * @return DegreeName, 类型String 默认值:""
	 */
	public String getDegreename()
	{
		return this.degreename; 
	}
	/**
	 * 设置 DegreeName, 类型String 默认值:""
	 *
	 * @param sDegreename
	 *            DegreeName, 类型String 默认值:""
	 */
	public void setDegreename(String sDegreename)
	{
		this.degreename = sDegreename; 
	}
	// 设置和获取 DegreeName, 类型String 默认值:"" 结束
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
            sbStr.append(getDegreedatabaseid()).append(strSplit);
            sbStr.append(getDegreeid()).append(strSplit);
            sbStr.append(getDegreename()).append(strSplit);

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
                setDegreedatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setDegreeid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setDegreename(com.colorwinglib.Converts.objToStr(objs[2]));
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
            sbStr.append("&Degreedatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getDegreedatabaseid()));//DegreedatabaseID
            sbStr.append("&Degreeid=").append(com.colorwinglib.StringFormat.UrlEncode(getDegreeid()));//DegreeID
            sbStr.append("&Degreename=").append(com.colorwinglib.StringFormat.UrlEncode(getDegreename()));//DegreeName

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
			if (columnName.equals("Degreedatabaseid"))
				sbStr.append("&Degreedatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getDegreedatabaseid()));//DegreedatabaseID
			if (columnName.equals("Degreeid"))
				sbStr.append("&Degreeid=").append(com.colorwinglib.StringFormat.UrlEncode(getDegreeid()));//DegreeID
			if (columnName.equals("Degreename"))
				sbStr.append("&Degreename=").append(com.colorwinglib.StringFormat.UrlEncode(getDegreename()));//DegreeName
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
            sbStr.append("&degreedatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getDegreedatabaseid()));//DegreedatabaseID
            sbStr.append("&degreeid=").append(com.colorwinglib.StringFormat.UrlEncode(getDegreeid()));//DegreeID
            sbStr.append("&degreename=").append(com.colorwinglib.StringFormat.UrlEncode(getDegreename()));//DegreeName

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
			if (columnName.equals("Degreedatabaseid"))
				sbStr.append("&degreedatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getDegreedatabaseid()));//DegreedatabaseID
			if (columnName.equals("Degreeid"))
				sbStr.append("&degreeid=").append(com.colorwinglib.StringFormat.UrlEncode(getDegreeid()));//DegreeID
			if (columnName.equals("Degreename"))
				sbStr.append("&degreename=").append(com.colorwinglib.StringFormat.UrlEncode(getDegreename()));//DegreeName
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
	public static DegreeInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			DegreeInfo obj = (DegreeInfo) in.readObject();
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
	public String ToModifyString(DegreeInfo objOld)
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
	public String ToModifyString(DegreeInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getDegreedatabaseid(), objOld.getDegreedatabaseid()))
			sbStr.append("Degreedatabaseid DegreedatabaseID:[").append(com.colorwinglib.Converts.objToStr(objOld.getDegreedatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDegreedatabaseid())).append("]").append(strSplit);// DegreedatabaseID
		if (com.colorwinglib.Validate.isEquals(getDegreeid(), objOld.getDegreeid()))
			sbStr.append("Degreeid DegreeID:[").append(com.colorwinglib.Converts.objToStr(objOld.getDegreeid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDegreeid())).append("]").append(strSplit);// DegreeID
		if (com.colorwinglib.Validate.isEquals(getDegreename(), objOld.getDegreename()))
			sbStr.append("Degreename DegreeName:[").append(com.colorwinglib.Converts.objToStr(objOld.getDegreename())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDegreename())).append("]").append(strSplit);// DegreeName
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
			json.put("Degreedatabaseid", getDegreedatabaseid());// DegreedatabaseID
			json.put("Degreeid", getDegreeid());// DegreeID
			json.put("Degreename", getDegreename());// DegreeName
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
			setDegreedatabaseid(json.getInt("Degreedatabaseid"));// DegreedatabaseID
			setDegreeid(json.getInt("Degreeid"));// DegreeID
			setDegreename(json.getString("Degreename"));// DegreeName

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
		sbStr.append("<DegreeInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //DegreedatabaseID
			sbStr.append("    <Degreedatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDegreedatabaseid()));
			sbStr.append("</Degreedatabaseid>\n");
            //DegreeID
			sbStr.append("    <Degreeid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDegreeid()));
			sbStr.append("</Degreeid>\n");
            //DegreeName
			sbStr.append("    <Degreename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDegreename()));
			sbStr.append("</Degreename>\n");
		sbStr.append("</DegreeInfo>\n");
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
	// GetDegreeInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetDegreeInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static DegreeInfo GetDegreeInfoFormFileName(String filename)
	{
		return GetDegreeInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetDegreeInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static DegreeInfo GetDegreeInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetDegreeInfoFormXml(xml, encoding);
	}

	// [end]

	// GetDegreeInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetDegreeInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static DegreeInfo GetDegreeInfoFormXml(String xml)
	{
		return GetDegreeInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetDegreeInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static DegreeInfo GetDegreeInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		DegreeInfo objDegreeInfo = new DegreeInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//DegreedatabaseID
				if (foo.elementText("Degreedatabaseid") != null)
					objDegreeInfo.setDegreedatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Degreedatabaseid")));
				//DegreeID
				if (foo.elementText("Degreeid") != null)
					objDegreeInfo.setDegreeid(com.colorwinglib.Converts.StrToInt(foo.elementText("Degreeid")));
				//DegreeName
				if (foo.elementText("Degreename") != null)
					objDegreeInfo.setDegreename(com.colorwinglib.Converts.objToStr(foo.elementText("Degreename")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objDegreeInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public DegreeInfo Copy()
	{
		DegreeInfo objDegreeInfo = new DegreeInfo();
		objDegreeInfo.setDegreedatabaseid(this.getDegreedatabaseid());//DegreedatabaseID
		objDegreeInfo.setDegreeid(this.getDegreeid());//DegreeID
		objDegreeInfo.setDegreename(this.getDegreename());//DegreeName
		return objDegreeInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明


	 //[end]
}
