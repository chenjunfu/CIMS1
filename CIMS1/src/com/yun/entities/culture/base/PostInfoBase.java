
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * Post 职称表的描述
 * 实体类基本类
 */
public class PostInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311521620318L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public PostInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public PostInfoBase(int sTitledatabaseid)
	{
		this.setTitledatabaseid(sTitledatabaseid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public PostInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setTitledatabaseid(rs.getInt("TitledatabaseID"));//TitledatabaseID
		setTitleid(rs.getInt("TitleID"));//职称编号
		setTitlename(rs.getString("TitleName"));//职称名称
		setDescription(rs.getString("Description"));//职称描述
		setFarthertitleid(rs.getInt("FartherTitleID"));//上级职称编号
		setDepth(rs.getInt("Depth"));//深度
		setIsDel(rs.getInt("Is_Del"));//是否删除：1-未删除、2-已删除
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public PostInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//TitledatabaseID
			if (columnName.equals("TitledatabaseID"))
			{
				setTitledatabaseid(rs.getInt("TitledatabaseID"));
				continue;
			}
			//职称编号
			if (columnName.equals("TitleID"))
			{
				setTitleid(rs.getInt("TitleID"));
				continue;
			}
			//职称名称
			if (columnName.equals("TitleName"))
			{
				setTitlename(rs.getString("TitleName"));
				continue;
			}
			//职称描述
			if (columnName.equals("Description"))
			{
				setDescription(rs.getString("Description"));
				continue;
			}
			//上级职称编号
			if (columnName.equals("FartherTitleID"))
			{
				setFarthertitleid(rs.getInt("FartherTitleID"));
				continue;
			}
			//深度
			if (columnName.equals("Depth"))
			{
				setDepth(rs.getInt("Depth"));
				continue;
			}
			//是否删除：1-未删除、2-已删除
			if (columnName.equals("Is_Del"))
			{
				setIsDel(rs.getInt("Is_Del"));
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
		if (!(rhs instanceof PostInfo))
			return false;
		PostInfo that = (PostInfo) rhs;

		return (this.getTitledatabaseid() == (that.getTitledatabaseid()));
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

			result = result * 37 + (this.getTitledatabaseid() + "").hashCode();
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
	"TitledatabaseID", //TitledatabaseID
	"TitleID", //职称编号
	"TitleName", //职称名称
	"Description", //职称描述
	"FartherTitleID", //上级职称编号
	"Depth", //深度
	"Is_Del" //是否删除：1-未删除、2-已删除
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum PostColumnNameEnum
{
		/**
		 * TitledatabaseID
		 */
		Titledatabaseid,
		/**
		 * 职称编号
		 */
		Titleid,
		/**
		 * 职称名称
		 */
		Titlename,
		/**
		 * 职称描述
		 */
		Description,
		/**
		 * 上级职称编号
		 */
		Farthertitleid,
		/**
		 * 深度
		 */
		Depth,
		/**
		 * 是否删除：1-未删除、2-已删除
		 */
		IsDel
	};
	// [end]
        // [start] 设置和获取 TitledatabaseID, 默认值:0
	// 设置和获取 TitledatabaseID,类型int 默认值:0 开始
	private int titledatabaseid = 0;
	/**
	* 获取 TitledatabaseID, 类型int 默认值:0
	 *
	 * @return TitledatabaseID, 类型int 默认值:0
	 */
	public int getTitledatabaseid()
	{
		return this.titledatabaseid; 
	}
	/**
	 * 设置 TitledatabaseID, 类型int 默认值:0
	 *
	 * @param sTitledatabaseid
	 *            TitledatabaseID, 类型int 默认值:0
	 */
	public void setTitledatabaseid(int sTitledatabaseid)
	{
		this.titledatabaseid = sTitledatabaseid; 
	}
	// 设置和获取 TitledatabaseID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 职称编号, 默认值:0
	// 设置和获取 职称编号,类型int 默认值:0 开始
	private int titleid = 0;
	/**
	* 获取 职称编号, 类型int 默认值:0
	 *
	 * @return 职称编号, 类型int 默认值:0
	 */
	public int getTitleid()
	{
		return this.titleid; 
	}
	/**
	 * 设置 职称编号, 类型int 默认值:0
	 *
	 * @param sTitleid
	 *            职称编号, 类型int 默认值:0
	 */
	public void setTitleid(int sTitleid)
	{
		this.titleid = sTitleid; 
	}
	// 设置和获取 职称编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 职称名称, 默认值:""
	// 设置和获取 职称名称,类型String 默认值:"" 开始
	private String titlename = "";
	/**
	* 获取 职称名称, 类型String 默认值:""
	 *
	 * @return 职称名称, 类型String 默认值:""
	 */
	public String getTitlename()
	{
		return this.titlename; 
	}
	/**
	 * 设置 职称名称, 类型String 默认值:""
	 *
	 * @param sTitlename
	 *            职称名称, 类型String 默认值:""
	 */
	public void setTitlename(String sTitlename)
	{
		this.titlename = sTitlename; 
	}
	// 设置和获取 职称名称, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 职称描述, 默认值:""
	// 设置和获取 职称描述,类型String 默认值:"" 开始
	private String description = "";
	/**
	* 获取 职称描述, 类型String 默认值:""
	 *
	 * @return 职称描述, 类型String 默认值:""
	 */
	public String getDescription()
	{
		return this.description; 
	}
	/**
	 * 设置 职称描述, 类型String 默认值:""
	 *
	 * @param sDescription
	 *            职称描述, 类型String 默认值:""
	 */
	public void setDescription(String sDescription)
	{
		this.description = sDescription; 
	}
	// 设置和获取 职称描述, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 上级职称编号, 默认值:0
	// 设置和获取 上级职称编号,类型int 默认值:0 开始
	private int farthertitleid = 0;
	/**
	* 获取 上级职称编号, 类型int 默认值:0
	 *
	 * @return 上级职称编号, 类型int 默认值:0
	 */
	public int getFarthertitleid()
	{
		return this.farthertitleid; 
	}
	/**
	 * 设置 上级职称编号, 类型int 默认值:0
	 *
	 * @param sFarthertitleid
	 *            上级职称编号, 类型int 默认值:0
	 */
	public void setFarthertitleid(int sFarthertitleid)
	{
		this.farthertitleid = sFarthertitleid; 
	}
	// 设置和获取 上级职称编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 深度, 默认值:0
	// 设置和获取 深度,类型int 默认值:0 开始
	private int depth = 0;
	/**
	* 获取 深度, 类型int 默认值:0
	 *
	 * @return 深度, 类型int 默认值:0
	 */
	public int getDepth()
	{
		return this.depth; 
	}
	/**
	 * 设置 深度, 类型int 默认值:0
	 *
	 * @param sDepth
	 *            深度, 类型int 默认值:0
	 */
	public void setDepth(int sDepth)
	{
		this.depth = sDepth; 
	}
	// 设置和获取 深度, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 是否删除：1-未删除、2-已删除, 默认值:0
	// 设置和获取 是否删除：1-未删除、2-已删除,类型int 默认值:0 开始
	private int isDel = 0;
	/**
	* 获取 是否删除：1-未删除、2-已删除, 类型int 默认值:0
	 *
	 * @return 是否删除：1-未删除、2-已删除, 类型int 默认值:0
	 */
	public int getIsDel()
	{
		return this.isDel; 
	}
	/**
	 * 设置 是否删除：1-未删除、2-已删除, 类型int 默认值:0
	 *
	 * @param sIsDel
	 *            是否删除：1-未删除、2-已删除, 类型int 默认值:0
	 */
	public void setIsDel(int sIsDel)
	{
		this.isDel = sIsDel; 
	}
	// 设置和获取 是否删除：1-未删除、2-已删除, 类型int 默认值:0 结束
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
            sbStr.append(getTitledatabaseid()).append(strSplit);
            sbStr.append(getTitleid()).append(strSplit);
            sbStr.append(getTitlename()).append(strSplit);
            sbStr.append(getDescription()).append(strSplit);
            sbStr.append(getFarthertitleid()).append(strSplit);
            sbStr.append(getDepth()).append(strSplit);
            sbStr.append(getIsDel()).append(strSplit);

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

            if (objs.length != 7)
            {
                return;
            }
            if (objs[0] != null || objs[0].length() >= 1)
            {
                setTitledatabaseid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setTitleid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setTitlename(com.colorwinglib.Converts.objToStr(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setDescription(com.colorwinglib.Converts.objToStr(objs[3]));
            }
            if (objs[4] != null || objs[4].length() >= 1)
            {
                setFarthertitleid(com.colorwinglib.Converts.StrToInt(objs[4]));
            }
            if (objs[5] != null || objs[5].length() >= 1)
            {
                setDepth(com.colorwinglib.Converts.StrToInt(objs[5]));
            }
            if (objs[6] != null || objs[6].length() >= 1)
            {
                setIsDel(com.colorwinglib.Converts.StrToInt(objs[6]));
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
            sbStr.append("&Titledatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getTitledatabaseid()));//TitledatabaseID
            sbStr.append("&Titleid=").append(com.colorwinglib.StringFormat.UrlEncode(getTitleid()));//职称编号
            sbStr.append("&Titlename=").append(com.colorwinglib.StringFormat.UrlEncode(getTitlename()));//职称名称
            sbStr.append("&Description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//职称描述
            sbStr.append("&Farthertitleid=").append(com.colorwinglib.StringFormat.UrlEncode(getFarthertitleid()));//上级职称编号
            sbStr.append("&Depth=").append(com.colorwinglib.StringFormat.UrlEncode(getDepth()));//深度
            sbStr.append("&IsDel=").append(com.colorwinglib.StringFormat.UrlEncode(getIsDel()));//是否删除：1-未删除、2-已删除

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
			if (columnName.equals("Titledatabaseid"))
				sbStr.append("&Titledatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getTitledatabaseid()));//TitledatabaseID
			if (columnName.equals("Titleid"))
				sbStr.append("&Titleid=").append(com.colorwinglib.StringFormat.UrlEncode(getTitleid()));//职称编号
			if (columnName.equals("Titlename"))
				sbStr.append("&Titlename=").append(com.colorwinglib.StringFormat.UrlEncode(getTitlename()));//职称名称
			if (columnName.equals("Description"))
				sbStr.append("&Description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//职称描述
			if (columnName.equals("Farthertitleid"))
				sbStr.append("&Farthertitleid=").append(com.colorwinglib.StringFormat.UrlEncode(getFarthertitleid()));//上级职称编号
			if (columnName.equals("Depth"))
				sbStr.append("&Depth=").append(com.colorwinglib.StringFormat.UrlEncode(getDepth()));//深度
			if (columnName.equals("IsDel"))
				sbStr.append("&IsDel=").append(com.colorwinglib.StringFormat.UrlEncode(getIsDel()));//是否删除：1-未删除、2-已删除
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
            sbStr.append("&titledatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getTitledatabaseid()));//TitledatabaseID
            sbStr.append("&titleid=").append(com.colorwinglib.StringFormat.UrlEncode(getTitleid()));//职称编号
            sbStr.append("&titlename=").append(com.colorwinglib.StringFormat.UrlEncode(getTitlename()));//职称名称
            sbStr.append("&description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//职称描述
            sbStr.append("&farthertitleid=").append(com.colorwinglib.StringFormat.UrlEncode(getFarthertitleid()));//上级职称编号
            sbStr.append("&depth=").append(com.colorwinglib.StringFormat.UrlEncode(getDepth()));//深度
            sbStr.append("&isDel=").append(com.colorwinglib.StringFormat.UrlEncode(getIsDel()));//是否删除：1-未删除、2-已删除

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
			if (columnName.equals("Titledatabaseid"))
				sbStr.append("&titledatabaseid=").append(com.colorwinglib.StringFormat.UrlEncode(getTitledatabaseid()));//TitledatabaseID
			if (columnName.equals("Titleid"))
				sbStr.append("&titleid=").append(com.colorwinglib.StringFormat.UrlEncode(getTitleid()));//职称编号
			if (columnName.equals("Titlename"))
				sbStr.append("&titlename=").append(com.colorwinglib.StringFormat.UrlEncode(getTitlename()));//职称名称
			if (columnName.equals("Description"))
				sbStr.append("&description=").append(com.colorwinglib.StringFormat.UrlEncode(getDescription()));//职称描述
			if (columnName.equals("Farthertitleid"))
				sbStr.append("&farthertitleid=").append(com.colorwinglib.StringFormat.UrlEncode(getFarthertitleid()));//上级职称编号
			if (columnName.equals("Depth"))
				sbStr.append("&depth=").append(com.colorwinglib.StringFormat.UrlEncode(getDepth()));//深度
			if (columnName.equals("IsDel"))
				sbStr.append("&isDel=").append(com.colorwinglib.StringFormat.UrlEncode(getIsDel()));//是否删除：1-未删除、2-已删除
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
	public static PostInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			PostInfo obj = (PostInfo) in.readObject();
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
	public String ToModifyString(PostInfo objOld)
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
	public String ToModifyString(PostInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getTitledatabaseid(), objOld.getTitledatabaseid()))
			sbStr.append("Titledatabaseid TitledatabaseID:[").append(com.colorwinglib.Converts.objToStr(objOld.getTitledatabaseid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getTitledatabaseid())).append("]").append(strSplit);// TitledatabaseID
		if (com.colorwinglib.Validate.isEquals(getTitleid(), objOld.getTitleid()))
			sbStr.append("Titleid 职称编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getTitleid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getTitleid())).append("]").append(strSplit);// 职称编号
		if (com.colorwinglib.Validate.isEquals(getTitlename(), objOld.getTitlename()))
			sbStr.append("Titlename 职称名称:[").append(com.colorwinglib.Converts.objToStr(objOld.getTitlename())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getTitlename())).append("]").append(strSplit);// 职称名称
		if (com.colorwinglib.Validate.isEquals(getDescription(), objOld.getDescription()))
			sbStr.append("Description 职称描述:[").append(com.colorwinglib.Converts.objToStr(objOld.getDescription())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDescription())).append("]").append(strSplit);// 职称描述
		if (com.colorwinglib.Validate.isEquals(getFarthertitleid(), objOld.getFarthertitleid()))
			sbStr.append("Farthertitleid 上级职称编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getFarthertitleid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getFarthertitleid())).append("]").append(strSplit);// 上级职称编号
		if (com.colorwinglib.Validate.isEquals(getDepth(), objOld.getDepth()))
			sbStr.append("Depth 深度:[").append(com.colorwinglib.Converts.objToStr(objOld.getDepth())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDepth())).append("]").append(strSplit);// 深度
		if (com.colorwinglib.Validate.isEquals(getIsDel(), objOld.getIsDel()))
			sbStr.append("IsDel 是否删除：1-未删除、2-已删除:[").append(com.colorwinglib.Converts.objToStr(objOld.getIsDel())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getIsDel())).append("]").append(strSplit);// 是否删除：1-未删除、2-已删除
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
			json.put("Titledatabaseid", getTitledatabaseid());// TitledatabaseID
			json.put("Titleid", getTitleid());// 职称编号
			json.put("Titlename", getTitlename());// 职称名称
			json.put("Description", getDescription());// 职称描述
			json.put("Farthertitleid", getFarthertitleid());// 上级职称编号
			json.put("Depth", getDepth());// 深度
			json.put("IsDel", getIsDel());// 是否删除：1-未删除、2-已删除
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
			setTitledatabaseid(json.getInt("Titledatabaseid"));// TitledatabaseID
			setTitleid(json.getInt("Titleid"));// 职称编号
			setTitlename(json.getString("Titlename"));// 职称名称
			setDescription(json.getString("Description"));// 职称描述
			setFarthertitleid(json.getInt("Farthertitleid"));// 上级职称编号
			setDepth(json.getInt("Depth"));// 深度
			setIsDel(json.getInt("IsDel"));// 是否删除：1-未删除、2-已删除

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
		sbStr.append("<PostInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //TitledatabaseID
			sbStr.append("    <Titledatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getTitledatabaseid()));
			sbStr.append("</Titledatabaseid>\n");
            //职称编号
			sbStr.append("    <Titleid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getTitleid()));
			sbStr.append("</Titleid>\n");
            //职称名称
			sbStr.append("    <Titlename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getTitlename()));
			sbStr.append("</Titlename>\n");
            //职称描述
			sbStr.append("    <Description>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDescription()));
			sbStr.append("</Description>\n");
            //上级职称编号
			sbStr.append("    <Farthertitleid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getFarthertitleid()));
			sbStr.append("</Farthertitleid>\n");
            //深度
			sbStr.append("    <Depth>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDepth()));
			sbStr.append("</Depth>\n");
            //是否删除：1-未删除、2-已删除
			sbStr.append("    <IsDel>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getIsDel()));
			sbStr.append("</IsDel>\n");
		sbStr.append("</PostInfo>\n");
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
	// GetPostInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetPostInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static PostInfo GetPostInfoFormFileName(String filename)
	{
		return GetPostInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetPostInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PostInfo GetPostInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetPostInfoFormXml(xml, encoding);
	}

	// [end]

	// GetPostInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetPostInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PostInfo GetPostInfoFormXml(String xml)
	{
		return GetPostInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetPostInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PostInfo GetPostInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		PostInfo objPostInfo = new PostInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//TitledatabaseID
				if (foo.elementText("Titledatabaseid") != null)
					objPostInfo.setTitledatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Titledatabaseid")));
				//职称编号
				if (foo.elementText("Titleid") != null)
					objPostInfo.setTitleid(com.colorwinglib.Converts.StrToInt(foo.elementText("Titleid")));
				//职称名称
				if (foo.elementText("Titlename") != null)
					objPostInfo.setTitlename(com.colorwinglib.Converts.objToStr(foo.elementText("Titlename")));
				//职称描述
				if (foo.elementText("Description") != null)
					objPostInfo.setDescription(com.colorwinglib.Converts.objToStr(foo.elementText("Description")));
				//上级职称编号
				if (foo.elementText("Farthertitleid") != null)
					objPostInfo.setFarthertitleid(com.colorwinglib.Converts.StrToInt(foo.elementText("Farthertitleid")));
				//深度
				if (foo.elementText("Depth") != null)
					objPostInfo.setDepth(com.colorwinglib.Converts.StrToInt(foo.elementText("Depth")));
				//是否删除：1-未删除、2-已删除
				if (foo.elementText("IsDel") != null)
					objPostInfo.setIsDel(com.colorwinglib.Converts.StrToInt(foo.elementText("IsDel")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objPostInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public PostInfo Copy()
	{
		PostInfo objPostInfo = new PostInfo();
		objPostInfo.setTitledatabaseid(this.getTitledatabaseid());//TitledatabaseID
		objPostInfo.setTitleid(this.getTitleid());//职称编号
		objPostInfo.setTitlename(this.getTitlename());//职称名称
		objPostInfo.setDescription(this.getDescription());//职称描述
		objPostInfo.setFarthertitleid(this.getFarthertitleid());//上级职称编号
		objPostInfo.setDepth(this.getDepth());//深度
		objPostInfo.setIsDel(this.getIsDel());//是否删除：1-未删除、2-已删除
		return objPostInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明

        // [start] 设置和获取 是否删除：1-未删除、2-已删除, 默认值:0
	private String isDellabel = "";
	/**
	* 获取 是否删除：1-未删除、2-已删除, 类型String 默认值:""
	 *
	 * @return 是否删除：1-未删除、2-已删除, 类型String 默认值:""
	 */
	public String getIsDellabel()
	{
		if (isDellabel.length() == 0)
			isDellabel = com.yun.bll.itemcollection.culture.PostItemCollection.IsDelText(String.valueOf(getIsDel()));
		return this.isDellabel; 
	}
        // [end]



	 //[end]
}
