
package com.yun.entities.culture.base;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.common.*;
import com.yun.entities.culture.*;

/**
 * People 人员表的描述
 * 实体类基本类
 */
public class PeopleInfoBase extends XmlSerializable implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311512606271L;

        // [start] 实体属性
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public PeopleInfoBase()
	{
	}
	// [end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public PeopleInfoBase(int sDatabasepeopleid)
	{
		this.setDatabasepeopleid(sDatabasepeopleid);
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs 数据库的一条值
	 * @throws SQLException
	 */
	public PeopleInfoBase(ResultSet rs) throws SQLException
	{

		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		setDatabasepeopleid(rs.getInt("DatabasePeopleID"));//人员ID
		setPeopleid(rs.getInt("PeopleID"));//人员编号
		setPeoplename(rs.getString("PeopleName"));//姓名
		setDatabasepeoplesectorid(rs.getInt("DatabasePeoplesectorID"));//所属部门
		setSex(rs.getInt("Sex"));//性别：1-男、2-女
		setAdress(rs.getString("Adress"));//办公地址
		setPhone(rs.getString("Phone"));//电话
		setCellphone(rs.getString("CellPhone"));//手机
	}
	// [end]

	// [start] 读取数据库填充数据
	/**
	 * 读取数据库填充数据
	 * @param rs
	 * @param columnNames
	 * @throws SQLException
	 */
	public PeopleInfoBase(ResultSet rs, String[] columnNames) throws SQLException
	{
		setRowNo(com.colorwinglib.Converts.StrToInt(rs.getObject(1)));// RowNo 数据类型int

		for (String columnName : columnNames)
		{
			//人员ID
			if (columnName.equals("DatabasePeopleID"))
			{
				setDatabasepeopleid(rs.getInt("DatabasePeopleID"));
				continue;
			}
			//人员编号
			if (columnName.equals("PeopleID"))
			{
				setPeopleid(rs.getInt("PeopleID"));
				continue;
			}
			//姓名
			if (columnName.equals("PeopleName"))
			{
				setPeoplename(rs.getString("PeopleName"));
				continue;
			}
			//所属部门
			if (columnName.equals("DatabasePeoplesectorID"))
			{
				setDatabasepeoplesectorid(rs.getInt("DatabasePeoplesectorID"));
				continue;
			}
			//性别：1-男、2-女
			if (columnName.equals("Sex"))
			{
				setSex(rs.getInt("Sex"));
				continue;
			}
			//办公地址
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
			//手机
			if (columnName.equals("CellPhone"))
			{
				setCellphone(rs.getString("CellPhone"));
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
		if (!(rhs instanceof PeopleInfo))
			return false;
		PeopleInfo that = (PeopleInfo) rhs;

		return (this.getDatabasepeopleid() == (that.getDatabasepeopleid()));
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

			result = result * 37 + (this.getDatabasepeopleid() + "").hashCode();
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
	"DatabasePeopleID", //人员ID
	"PeopleID", //人员编号
	"PeopleName", //姓名
	"DatabasePeoplesectorID", //所属部门
	"Sex", //性别：1-男、2-女
	"Adress", //办公地址
	"Phone", //电话
	"CellPhone" //手机
	};
	// [end]
	// [start] 数据库字段enum
	/**
	 * 数据库字段enum
	 */
	public enum PeopleColumnNameEnum
{
		/**
		 * 人员ID
		 */
		Databasepeopleid,
		/**
		 * 人员编号
		 */
		Peopleid,
		/**
		 * 姓名
		 */
		Peoplename,
		/**
		 * 所属部门
		 */
		Databasepeoplesectorid,
		/**
		 * 性别：1-男、2-女
		 */
		Sex,
		/**
		 * 办公地址
		 */
		Adress,
		/**
		 * 电话
		 */
		Phone,
		/**
		 * 手机
		 */
		Cellphone
	};
	// [end]
        // [start] 设置和获取 人员ID, 默认值:0
	// 设置和获取 人员ID,类型int 默认值:0 开始
	private int databasepeopleid = 0;
	/**
	* 获取 人员ID, 类型int 默认值:0
	 *
	 * @return 人员ID, 类型int 默认值:0
	 */
	public int getDatabasepeopleid()
	{
		return this.databasepeopleid; 
	}
	/**
	 * 设置 人员ID, 类型int 默认值:0
	 *
	 * @param sDatabasepeopleid
	 *            人员ID, 类型int 默认值:0
	 */
	public void setDatabasepeopleid(int sDatabasepeopleid)
	{
		this.databasepeopleid = sDatabasepeopleid; 
	}
	// 设置和获取 人员ID, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 人员编号, 默认值:0
	// 设置和获取 人员编号,类型int 默认值:0 开始
	private int peopleid = 0;
	/**
	* 获取 人员编号, 类型int 默认值:0
	 *
	 * @return 人员编号, 类型int 默认值:0
	 */
	public int getPeopleid()
	{
		return this.peopleid; 
	}
	/**
	 * 设置 人员编号, 类型int 默认值:0
	 *
	 * @param sPeopleid
	 *            人员编号, 类型int 默认值:0
	 */
	public void setPeopleid(int sPeopleid)
	{
		this.peopleid = sPeopleid; 
	}
	// 设置和获取 人员编号, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 姓名, 默认值:""
	// 设置和获取 姓名,类型String 默认值:"" 开始
	private String peoplename = "";
	/**
	* 获取 姓名, 类型String 默认值:""
	 *
	 * @return 姓名, 类型String 默认值:""
	 */
	public String getPeoplename()
	{
		return this.peoplename; 
	}
	/**
	 * 设置 姓名, 类型String 默认值:""
	 *
	 * @param sPeoplename
	 *            姓名, 类型String 默认值:""
	 */
	public void setPeoplename(String sPeoplename)
	{
		this.peoplename = sPeoplename; 
	}
	// 设置和获取 姓名, 类型String 默认值:"" 结束
        // [end]


        // [start] 设置和获取 所属部门, 默认值:0
	// 设置和获取 所属部门,类型int 默认值:0 开始
	private int databasepeoplesectorid = 0;
	/**
	* 获取 所属部门, 类型int 默认值:0
	 *
	 * @return 所属部门, 类型int 默认值:0
	 */
	public int getDatabasepeoplesectorid()
	{
		return this.databasepeoplesectorid; 
	}
	/**
	 * 设置 所属部门, 类型int 默认值:0
	 *
	 * @param sDatabasepeoplesectorid
	 *            所属部门, 类型int 默认值:0
	 */
	public void setDatabasepeoplesectorid(int sDatabasepeoplesectorid)
	{
		this.databasepeoplesectorid = sDatabasepeoplesectorid; 
	}
	// 设置和获取 所属部门, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 性别：1-男、2-女, 默认值:0
	// 设置和获取 性别：1-男、2-女,类型int 默认值:0 开始
	private int sex = 0;
	/**
	* 获取 性别：1-男、2-女, 类型int 默认值:0
	 *
	 * @return 性别：1-男、2-女, 类型int 默认值:0
	 */
	public int getSex()
	{
		return this.sex; 
	}
	/**
	 * 设置 性别：1-男、2-女, 类型int 默认值:0
	 *
	 * @param sSex
	 *            性别：1-男、2-女, 类型int 默认值:0
	 */
	public void setSex(int sSex)
	{
		this.sex = sSex; 
	}
	// 设置和获取 性别：1-男、2-女, 类型int 默认值:0 结束
        // [end]


        // [start] 设置和获取 办公地址, 默认值:""
	// 设置和获取 办公地址,类型String 默认值:"" 开始
	private String adress = "";
	/**
	* 获取 办公地址, 类型String 默认值:""
	 *
	 * @return 办公地址, 类型String 默认值:""
	 */
	public String getAdress()
	{
		return this.adress; 
	}
	/**
	 * 设置 办公地址, 类型String 默认值:""
	 *
	 * @param sAdress
	 *            办公地址, 类型String 默认值:""
	 */
	public void setAdress(String sAdress)
	{
		this.adress = sAdress; 
	}
	// 设置和获取 办公地址, 类型String 默认值:"" 结束
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


        // [start] 设置和获取 手机, 默认值:""
	// 设置和获取 手机,类型String 默认值:"" 开始
	private String cellphone = "";
	/**
	* 获取 手机, 类型String 默认值:""
	 *
	 * @return 手机, 类型String 默认值:""
	 */
	public String getCellphone()
	{
		return this.cellphone; 
	}
	/**
	 * 设置 手机, 类型String 默认值:""
	 *
	 * @param sCellphone
	 *            手机, 类型String 默认值:""
	 */
	public void setCellphone(String sCellphone)
	{
		this.cellphone = sCellphone; 
	}
	// 设置和获取 手机, 类型String 默认值:"" 结束
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
            sbStr.append(getDatabasepeopleid()).append(strSplit);
            sbStr.append(getPeopleid()).append(strSplit);
            sbStr.append(getPeoplename()).append(strSplit);
            sbStr.append(getDatabasepeoplesectorid()).append(strSplit);
            sbStr.append(getSex()).append(strSplit);
            sbStr.append(getAdress()).append(strSplit);
            sbStr.append(getPhone()).append(strSplit);
            sbStr.append(getCellphone()).append(strSplit);

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

            if (objs.length != 8)
            {
                return;
            }
            if (objs[0] != null || objs[0].length() >= 1)
            {
                setDatabasepeopleid(com.colorwinglib.Converts.StrToInt(objs[0]));
            }
            if (objs[1] != null || objs[1].length() >= 1)
            {
                setPeopleid(com.colorwinglib.Converts.StrToInt(objs[1]));
            }
            if (objs[2] != null || objs[2].length() >= 1)
            {
                setPeoplename(com.colorwinglib.Converts.objToStr(objs[2]));
            }
            if (objs[3] != null || objs[3].length() >= 1)
            {
                setDatabasepeoplesectorid(com.colorwinglib.Converts.StrToInt(objs[3]));
            }
            if (objs[4] != null || objs[4].length() >= 1)
            {
                setSex(com.colorwinglib.Converts.StrToInt(objs[4]));
            }
            if (objs[5] != null || objs[5].length() >= 1)
            {
                setAdress(com.colorwinglib.Converts.objToStr(objs[5]));
            }
            if (objs[6] != null || objs[6].length() >= 1)
            {
                setPhone(com.colorwinglib.Converts.objToStr(objs[6]));
            }
            if (objs[7] != null || objs[7].length() >= 1)
            {
                setCellphone(com.colorwinglib.Converts.objToStr(objs[7]));
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
            sbStr.append("&Databasepeopleid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid()));//人员ID
            sbStr.append("&Peopleid=").append(com.colorwinglib.StringFormat.UrlEncode(getPeopleid()));//人员编号
            sbStr.append("&Peoplename=").append(com.colorwinglib.StringFormat.UrlEncode(getPeoplename()));//姓名
            sbStr.append("&Databasepeoplesectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeoplesectorid()));//所属部门
            sbStr.append("&Sex=").append(com.colorwinglib.StringFormat.UrlEncode(getSex()));//性别：1-男、2-女
            sbStr.append("&Adress=").append(com.colorwinglib.StringFormat.UrlEncode(getAdress()));//办公地址
            sbStr.append("&Phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//电话
            sbStr.append("&Cellphone=").append(com.colorwinglib.StringFormat.UrlEncode(getCellphone()));//手机

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
			if (columnName.equals("Databasepeopleid"))
				sbStr.append("&Databasepeopleid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid()));//人员ID
			if (columnName.equals("Peopleid"))
				sbStr.append("&Peopleid=").append(com.colorwinglib.StringFormat.UrlEncode(getPeopleid()));//人员编号
			if (columnName.equals("Peoplename"))
				sbStr.append("&Peoplename=").append(com.colorwinglib.StringFormat.UrlEncode(getPeoplename()));//姓名
			if (columnName.equals("Databasepeoplesectorid"))
				sbStr.append("&Databasepeoplesectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeoplesectorid()));//所属部门
			if (columnName.equals("Sex"))
				sbStr.append("&Sex=").append(com.colorwinglib.StringFormat.UrlEncode(getSex()));//性别：1-男、2-女
			if (columnName.equals("Adress"))
				sbStr.append("&Adress=").append(com.colorwinglib.StringFormat.UrlEncode(getAdress()));//办公地址
			if (columnName.equals("Phone"))
				sbStr.append("&Phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//电话
			if (columnName.equals("Cellphone"))
				sbStr.append("&Cellphone=").append(com.colorwinglib.StringFormat.UrlEncode(getCellphone()));//手机
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
            sbStr.append("&databasepeopleid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid()));//人员ID
            sbStr.append("&peopleid=").append(com.colorwinglib.StringFormat.UrlEncode(getPeopleid()));//人员编号
            sbStr.append("&peoplename=").append(com.colorwinglib.StringFormat.UrlEncode(getPeoplename()));//姓名
            sbStr.append("&databasepeoplesectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeoplesectorid()));//所属部门
            sbStr.append("&sex=").append(com.colorwinglib.StringFormat.UrlEncode(getSex()));//性别：1-男、2-女
            sbStr.append("&adress=").append(com.colorwinglib.StringFormat.UrlEncode(getAdress()));//办公地址
            sbStr.append("&phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//电话
            sbStr.append("&cellphone=").append(com.colorwinglib.StringFormat.UrlEncode(getCellphone()));//手机

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
			if (columnName.equals("Databasepeopleid"))
				sbStr.append("&databasepeopleid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeopleid()));//人员ID
			if (columnName.equals("Peopleid"))
				sbStr.append("&peopleid=").append(com.colorwinglib.StringFormat.UrlEncode(getPeopleid()));//人员编号
			if (columnName.equals("Peoplename"))
				sbStr.append("&peoplename=").append(com.colorwinglib.StringFormat.UrlEncode(getPeoplename()));//姓名
			if (columnName.equals("Databasepeoplesectorid"))
				sbStr.append("&databasepeoplesectorid=").append(com.colorwinglib.StringFormat.UrlEncode(getDatabasepeoplesectorid()));//所属部门
			if (columnName.equals("Sex"))
				sbStr.append("&sex=").append(com.colorwinglib.StringFormat.UrlEncode(getSex()));//性别：1-男、2-女
			if (columnName.equals("Adress"))
				sbStr.append("&adress=").append(com.colorwinglib.StringFormat.UrlEncode(getAdress()));//办公地址
			if (columnName.equals("Phone"))
				sbStr.append("&phone=").append(com.colorwinglib.StringFormat.UrlEncode(getPhone()));//电话
			if (columnName.equals("Cellphone"))
				sbStr.append("&cellphone=").append(com.colorwinglib.StringFormat.UrlEncode(getCellphone()));//手机
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
	public static PeopleInfo readFormBinary(String filename)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			PeopleInfo obj = (PeopleInfo) in.readObject();
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
	public String ToModifyString(PeopleInfo objOld)
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
	public String ToModifyString(PeopleInfo objOld, String strSplit)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		if (com.colorwinglib.Validate.isEquals(getDatabasepeopleid(), objOld.getDatabasepeopleid()))
			sbStr.append("Databasepeopleid 人员ID:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabasepeopleid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabasepeopleid())).append("]").append(strSplit);// 人员ID
		if (com.colorwinglib.Validate.isEquals(getPeopleid(), objOld.getPeopleid()))
			sbStr.append("Peopleid 人员编号:[").append(com.colorwinglib.Converts.objToStr(objOld.getPeopleid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPeopleid())).append("]").append(strSplit);// 人员编号
		if (com.colorwinglib.Validate.isEquals(getPeoplename(), objOld.getPeoplename()))
			sbStr.append("Peoplename 姓名:[").append(com.colorwinglib.Converts.objToStr(objOld.getPeoplename())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPeoplename())).append("]").append(strSplit);// 姓名
		if (com.colorwinglib.Validate.isEquals(getDatabasepeoplesectorid(), objOld.getDatabasepeoplesectorid()))
			sbStr.append("Databasepeoplesectorid 所属部门:[").append(com.colorwinglib.Converts.objToStr(objOld.getDatabasepeoplesectorid())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getDatabasepeoplesectorid())).append("]").append(strSplit);// 所属部门
		if (com.colorwinglib.Validate.isEquals(getSex(), objOld.getSex()))
			sbStr.append("Sex 性别：1-男、2-女:[").append(com.colorwinglib.Converts.objToStr(objOld.getSex())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getSex())).append("]").append(strSplit);// 性别：1-男、2-女
		if (com.colorwinglib.Validate.isEquals(getAdress(), objOld.getAdress()))
			sbStr.append("Adress 办公地址:[").append(com.colorwinglib.Converts.objToStr(objOld.getAdress())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getAdress())).append("]").append(strSplit);// 办公地址
		if (com.colorwinglib.Validate.isEquals(getPhone(), objOld.getPhone()))
			sbStr.append("Phone 电话:[").append(com.colorwinglib.Converts.objToStr(objOld.getPhone())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getPhone())).append("]").append(strSplit);// 电话
		if (com.colorwinglib.Validate.isEquals(getCellphone(), objOld.getCellphone()))
			sbStr.append("Cellphone 手机:[").append(com.colorwinglib.Converts.objToStr(objOld.getCellphone())).append("]修改为[").append(com.colorwinglib.Converts.objToStr(getCellphone())).append("]").append(strSplit);// 手机
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
			json.put("Databasepeopleid", getDatabasepeopleid());// 人员ID
			json.put("Peopleid", getPeopleid());// 人员编号
			json.put("Peoplename", getPeoplename());// 姓名
			json.put("Databasepeoplesectorid", getDatabasepeoplesectorid());// 所属部门
			json.put("Sex", getSex());// 性别：1-男、2-女
			json.put("Adress", getAdress());// 办公地址
			json.put("Phone", getPhone());// 电话
			json.put("Cellphone", getCellphone());// 手机
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
			setDatabasepeopleid(json.getInt("Databasepeopleid"));// 人员ID
			setPeopleid(json.getInt("Peopleid"));// 人员编号
			setPeoplename(json.getString("Peoplename"));// 姓名
			setDatabasepeoplesectorid(json.getInt("Databasepeoplesectorid"));// 所属部门
			setSex(json.getInt("Sex"));// 性别：1-男、2-女
			setAdress(json.getString("Adress"));// 办公地址
			setPhone(json.getString("Phone"));// 电话
			setCellphone(json.getString("Cellphone"));// 手机

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
		sbStr.append("<PeopleInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
            //人员ID
			sbStr.append("    <Databasepeopleid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabasepeopleid()));
			sbStr.append("</Databasepeopleid>\n");
            //人员编号
			sbStr.append("    <Peopleid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPeopleid()));
			sbStr.append("</Peopleid>\n");
            //姓名
			sbStr.append("    <Peoplename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPeoplename()));
			sbStr.append("</Peoplename>\n");
            //所属部门
			sbStr.append("    <Databasepeoplesectorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getDatabasepeoplesectorid()));
			sbStr.append("</Databasepeoplesectorid>\n");
            //性别：1-男、2-女
			sbStr.append("    <Sex>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getSex()));
			sbStr.append("</Sex>\n");
            //办公地址
			sbStr.append("    <Adress>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getAdress()));
			sbStr.append("</Adress>\n");
            //电话
			sbStr.append("    <Phone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getPhone()));
			sbStr.append("</Phone>\n");
            //手机
			sbStr.append("    <Cellphone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(this.getCellphone()));
			sbStr.append("</Cellphone>\n");
		sbStr.append("</PeopleInfo>\n");
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
	// GetPeopleInfoFormFileName 从文件中反序列化获得实体类

	// [start] GetPeopleInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static PeopleInfo GetPeopleInfoFormFileName(String filename)
	{
		return GetPeopleInfoFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetPeopleInfoFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PeopleInfo GetPeopleInfoFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetPeopleInfoFormXml(xml, encoding);
	}

	// [end]

	// GetPeopleInfoFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetPeopleInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PeopleInfo GetPeopleInfoFormXml(String xml)
	{
		return GetPeopleInfoFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetPeopleInfoFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PeopleInfo GetPeopleInfoFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		PeopleInfo objPeopleInfo = new PeopleInfo();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element foo = doc.getRootElement();
				//人员ID
				if (foo.elementText("Databasepeopleid") != null)
					objPeopleInfo.setDatabasepeopleid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasepeopleid")));
				//人员编号
				if (foo.elementText("Peopleid") != null)
					objPeopleInfo.setPeopleid(com.colorwinglib.Converts.StrToInt(foo.elementText("Peopleid")));
				//姓名
				if (foo.elementText("Peoplename") != null)
					objPeopleInfo.setPeoplename(com.colorwinglib.Converts.objToStr(foo.elementText("Peoplename")));
				//所属部门
				if (foo.elementText("Databasepeoplesectorid") != null)
					objPeopleInfo.setDatabasepeoplesectorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasepeoplesectorid")));
				//性别：1-男、2-女
				if (foo.elementText("Sex") != null)
					objPeopleInfo.setSex(com.colorwinglib.Converts.StrToInt(foo.elementText("Sex")));
				//办公地址
				if (foo.elementText("Adress") != null)
					objPeopleInfo.setAdress(com.colorwinglib.Converts.objToStr(foo.elementText("Adress")));
				//电话
				if (foo.elementText("Phone") != null)
					objPeopleInfo.setPhone(com.colorwinglib.Converts.objToStr(foo.elementText("Phone")));
				//手机
				if (foo.elementText("Cellphone") != null)
					objPeopleInfo.setCellphone(com.colorwinglib.Converts.objToStr(foo.elementText("Cellphone")));

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objPeopleInfo;
	}

	// [end]

	// [start] copy 复制一个实体类
	/**
	 * 复制一个实体类
	 */
	public PeopleInfo Copy()
	{
		PeopleInfo objPeopleInfo = new PeopleInfo();
		objPeopleInfo.setDatabasepeopleid(this.getDatabasepeopleid());//人员ID
		objPeopleInfo.setPeopleid(this.getPeopleid());//人员编号
		objPeopleInfo.setPeoplename(this.getPeoplename());//姓名
		objPeopleInfo.setDatabasepeoplesectorid(this.getDatabasepeoplesectorid());//所属部门
		objPeopleInfo.setSex(this.getSex());//性别：1-男、2-女
		objPeopleInfo.setAdress(this.getAdress());//办公地址
		objPeopleInfo.setPhone(this.getPhone());//电话
		objPeopleInfo.setCellphone(this.getCellphone());//手机
		return objPeopleInfo;
	}

	// [end]


	// [start] 列表字段扩展的属性说明

        // [start] 设置和获取 性别：1-男、2-女, 默认值:0
	private String sexlabel = "";
	/**
	* 获取 性别：1-男、2-女, 类型String 默认值:""
	 *
	 * @return 性别：1-男、2-女, 类型String 默认值:""
	 */
	public String getSexlabel()
	{
		if (sexlabel.length() == 0)
			sexlabel = com.yun.bll.itemcollection.culture.PeopleItemCollection.SexText(String.valueOf(getSex()));
		return this.sexlabel; 
	}
        // [end]



	 //[end]
}
