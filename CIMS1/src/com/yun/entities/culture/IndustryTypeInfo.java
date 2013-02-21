﻿
package com.yun.entities.culture;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.entities.culture.base.*;

/**
 * IndustryType 产业项目类别类别表的摘要说明
 */
public class IndustryTypeInfo extends IndustryTypeInfoBase implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311500537531L;

	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public IndustryTypeInfo()
	{
		super();
	}
	 //[end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public IndustryTypeInfo(int sIndustrydatabaseid)
	{
		super(sIndustrydatabaseid);
	}
	 //[end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 * @throws SQLException
	 */
	public IndustryTypeInfo(ResultSet rs) throws SQLException
	{
		super(rs);
	}
	 //[end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 * @throws SQLException
	 */
	public IndustryTypeInfo(ResultSet rs, String[] columnNames) throws SQLException
	{
		super(rs, columnNames);
	}
	 //[end]
	 //[end]


}
