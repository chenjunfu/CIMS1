
package com.yun.entities.culture;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.yun.entities.culture.base.*;

/**
 * SystemAdmin 系统人员表的摘要说明
 */
public class SystemAdminInfo extends SystemAdminInfoBase implements Serializable
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120313425073413L;
	// [start] 构造函数
	// [start] 无参数构造函数
	/**
	 * 无参数构造函数
	 */
	public SystemAdminInfo()
	{
		super();
	}
	 //[end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 */
	public SystemAdminInfo(int sDatabaseadminid)
	{
		super(sDatabaseadminid);
	}
	 //[end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 * @throws SQLException
	 */
	public SystemAdminInfo(ResultSet rs) throws SQLException
	{
		super(rs);
	}
	 //[end]

	// [start] 通过给定的主键生成实例
	/**
	 * 通过给定的主键生成实例
	 * @throws SQLException
	 */
	public SystemAdminInfo(ResultSet rs, String[] columnNames) throws SQLException
	{
		super(rs, columnNames);
	}
	 //[end]
	
	// [start] 获取 角色表 字段：RolesID Rolesid 角色编号
	private SystemRolesInfo objSystemRolesInfoByRolesid = null;

	/**
	 * 获取 角色表
	 * @return
	 */
	public SystemRolesInfo getObjSystemRolesInfoByRolesid()
	{
		//角色表
		//if (objSystemRolesInfoByRolesid == null)
		//	objSystemRolesInfoByRolesid = com.yun.bll.culture.SystemRolesProvider.GetSystemRolesInfoStaticByRolesid(getRolesid());

		if (objSystemRolesInfoByRolesid == null)
			objSystemRolesInfoByRolesid = com.yun.bll.culture.SystemRolesProvider.getSystemRolesStatic().GetSystemRolesInfoByRolesid(getRolesid());

		if (objSystemRolesInfoByRolesid == null)
			return new SystemRolesInfo();
		else
			return this.objSystemRolesInfoByRolesid;

	}
	// [end]
	// [start] 获取 部门表 字段：SectorID Sectorid 部门编号
	private SystemSectorInfo objSystemSectorInfoBySectorid = null;

	/**
	 * 获取 部门表
	 * @return
	 */
	public SystemSectorInfo getObjSystemSectorInfoBySectorid()
	{
		//部门表
		//if (objSystemSectorInfoBySectorid == null)
		//	objSystemSectorInfoBySectorid = com.yun.bll.culture.SystemSectorProvider.GetSystemSectorInfoStaticBySectordatabaseid(getSectorid());

		if (objSystemSectorInfoBySectorid == null)
			objSystemSectorInfoBySectorid = com.yun.bll.culture.SystemSectorProvider.getSystemSectorStatic().GetSystemSectorInfoBySectordatabaseid(getSectorid());

		if (objSystemSectorInfoBySectorid == null)
			return new SystemSectorInfo();
		else
			return this.objSystemSectorInfoBySectorid;

	}
	// [end]

	// [start]清空缓存数据

	/**
	 * 清空缓存数据
	 *
	 * @return
	 */
	public void setNull()
	{
		// 角色编号
		objSystemRolesInfoByRolesid = null;
		// 部门编号
		objSystemSectorInfoBySectorid = null;
	}

	// [end]

	 //[end]


}
