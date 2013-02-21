/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月12日 14:19:34
   功能说明: 表t_system_roles 角色表的业务类SystemRolesInfo的业务层基类
   表说明:角色表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表SystemRoles 角色表 的实体SystemRolesInfo的数据操作类
 *
 */
public class SystemRolesProviderBase
{
	// [start] 设置和获取静态属性列表 SystemRolesStatic, 默认值:null
	// 设置和获取静态属性列表 SystemRolesStatic, 默认值:null 开始
	private static SystemRolesInfoCollection systemRolesStatic = null;
	/**
	* 获取 静态属性列表 SystemRolesStatic, 默认值:null
	 *
	 * @return 静态属性列表 SystemRolesStatic, 默认值:null
	 */
	public static SystemRolesInfoCollection getSystemRolesStatic()
	{
		if (systemRolesStatic == null)
		  systemRolesStatic = new SystemRolesDAL().GetListBy();
		return systemRolesStatic;
	}
	/**
	 * 设置 静态属性列表 SystemRolesStatic, 默认值:null
	 *
	 * @param sSystemRolesStatic
	 *            静态属性列表 SystemRolesStatic, 默认值:null
	 */
	public static void setSystemRolesStatic(SystemRolesInfoCollection sSystemRolesStatic)
	{
		systemRolesStatic = sSystemRolesStatic;
		setSystemRolesInfoStaticByDatabaserolesid (null);
	}
	// 设置和获取静态属性列表 SystemRolesStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.SystemRolesInfo objSystemRolesInfo : getSystemRolesStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objSystemRolesInfo.getDatabaserolesid(), objSystemRolesInfo.getRolesname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetSystemRolesInfoStaticByDatabaserolesid
	// [start] 设置和获取静态属性列表 SystemRolesInfoStaticByDatabaserolesid, 默认值:null
	// 设置和获取静态属性列表 SystemRolesInfoStaticByDatabaserolesid, 默认值:null 开始
	private static SystemRolesInfoCollection SystemRolesInfoStaticByDatabaserolesid = null;
	/**
	* 获取 静态属性列表 SystemRolesInfoStaticByDatabaserolesid, 默认值:null
	 *
	 * @return 静态属性列表 SystemRolesInfoStaticByDatabaserolesid, 默认值:null
	 */
	public static SystemRolesInfoCollection getSystemRolesInfoStaticByDatabaserolesid()
	{
		return SystemRolesInfoStaticByDatabaserolesid;
	}
	/**
	 * 设置 静态属性列表 SystemRolesInfoStaticByDatabaserolesid, 默认值:null
	 *
	 * @param sSystemRolesInfoStaticByDatabaserolesid
	 *            静态属性列表 SystemRolesInfoStaticByDatabaserolesid, 默认值:null
	 */
	public static void setSystemRolesInfoStaticByDatabaserolesid(SystemRolesInfoCollection sSystemRolesInfoStaticByDatabaserolesid)
	{
		SystemRolesInfoStaticByDatabaserolesid = sSystemRolesInfoStaticByDatabaserolesid;
	}
	// 设置和获取静态属性列表 SystemRolesInfoStaticByDatabaserolesid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 获取表t_system_roles 角色表的对象<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @param Databaserolesid DatabaseRolesID
        * @return SystemRolesInfo对象实体
        */
        public static SystemRolesInfo GetSystemRolesInfoStaticByDatabaserolesid(int Databaserolesid)
        {
            if (SystemRolesInfoStaticByDatabaserolesid == null)
                SystemRolesInfoStaticByDatabaserolesid = new SystemRolesInfoCollection();
            int allcount = SystemRolesInfoStaticByDatabaserolesid.size();
            SystemRolesInfo objSystemRolesInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (SystemRolesInfoStaticByDatabaserolesid == null)
                    break;
                    objSystemRolesInfo = SystemRolesInfoStaticByDatabaserolesid.get(i);
                if (objSystemRolesInfo == null)
                    break;
                if (objSystemRolesInfo.getDatabaserolesid() == Databaserolesid)
                {
                    return objSystemRolesInfo;
                }
            }
            SystemRolesInfo obj= new SystemRolesDAL().GetSystemRolesInfoByDatabaserolesid(Databaserolesid);

            if (obj != null)
            {
                if (SystemRolesInfoStaticByDatabaserolesid != null)
                    SystemRolesInfoStaticByDatabaserolesid.add(obj);
                return obj;
            }
            else
            {
                return new SystemRolesInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByDatabaserolesid
        // [start] CountByDatabaserolesid
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 统计表t_system_roles 角色表的数据量<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @param Databaserolesid DatabaseRolesID
        * @return 数据量
        */
        public static int CountByDatabaserolesid(int Databaserolesid)
        {
            return new SystemRolesDAL().CountByDatabaserolesid(Databaserolesid);
        }
        // [end]
        // [start] CountByDatabaserolesid
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 统计表t_system_roles 角色表的数据量<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @param Databaserolesid DatabaseRolesID
        * @return 数据量
        */
        public static int CountByDatabaserolesid(DataProvider dp, int Databaserolesid)
        {
		SystemRolesDAL dal = new SystemRolesDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByDatabaserolesid(Databaserolesid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_roles 角色表的数据量<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new SystemRolesDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_roles 角色表的数据量<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		SystemRolesDAL dal = new SystemRolesDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_roles 角色表的数据列表<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemRolesInfoCollection GetListBy()
        {
            return new SystemRolesDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_roles 角色表的数据列表<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemRolesInfoCollection GetListBy(DataProvider dp )
        {
		SystemRolesDAL dal = new SystemRolesDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_roles 角色表的数据列表<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemRolesInfoCollection GetListBy(String OrderBy)
        {
            return new SystemRolesDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_roles 角色表的数据列表<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemRolesInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		SystemRolesDAL dal = new SystemRolesDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_roles 角色表的数据列表<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemRolesInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new SystemRolesDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_roles 角色表的数据量<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new SystemRolesDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_roles 角色表的数据列表<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemRolesInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new SystemRolesDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_roles 角色表的数据量<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new SystemRolesDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_roles 角色表的数据列表<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemRolesInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		SystemRolesDAL dal = new SystemRolesDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_roles 角色表的数据量<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		SystemRolesDAL dal = new SystemRolesDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_roles 角色表的数据列表<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemRolesInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		SystemRolesDAL dal = new SystemRolesDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_roles 角色表的数据量<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		SystemRolesDAL dal = new SystemRolesDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetSystemRolesInfoByDatabaserolesid
        // [start] GetSystemRolesInfoByDatabaserolesid
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 获取表t_system_roles 角色表的对象<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @param Databaserolesid DatabaseRolesID
        * @return SystemRolesInfo对象实体
        */
        public static SystemRolesInfo GetSystemRolesInfoByDatabaserolesid(int Databaserolesid)
        {
            return new SystemRolesDAL().GetSystemRolesInfoByDatabaserolesid(Databaserolesid);
        }
        // [end]
        // [start] GetSystemRolesInfoByDatabaserolesid
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 获取表t_system_roles 角色表的对象<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @param Databaserolesid DatabaseRolesID
        * @return SystemRolesInfo对象实体
        */
        public static SystemRolesInfo GetSystemRolesInfoByDatabaserolesid(DataProvider dp, int Databaserolesid)
        {
		SystemRolesDAL dal = new SystemRolesDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetSystemRolesInfoByDatabaserolesid(Databaserolesid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_system_roles 角色表中插入数据<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @param objSystemRolesInfo SystemRolesInfo对象 角色表
        */
  public static boolean Insert(SystemRolesInfo objSystemRolesInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objSystemRolesInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_system_roles 角色表中插入数据<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @param objSystemRolesInfo SystemRolesInfo对象 角色表
        */
  public static boolean Insert(DataProvider dp, SystemRolesInfo objSystemRolesInfo)
	{
		SystemRolesDAL dal = new SystemRolesDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objSystemRolesInfo);
      setSystemRolesStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_system_roles", "添加", objSystemRolesInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByDatabaserolesid
        // [start] UpdateByDatabaserolesid
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 更新表t_system_roles 角色表中的内容<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @param objSystemRolesInfo SystemRolesInfo对象 角色表
        */
  public static boolean UpdateByDatabaserolesid(SystemRolesInfo objSystemRolesInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByDatabaserolesid(dp, objSystemRolesInfo);
	}

	// [end]
        // [start] UpdateByDatabaserolesid
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 更新表t_system_roles 角色表中的内容<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @param objSystemRolesInfo SystemRolesInfo对象 角色表
        */
  public static boolean UpdateByDatabaserolesid(DataProvider dp, SystemRolesInfo objSystemRolesInfo)
	{
		SystemRolesDAL dal = new SystemRolesDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Databaserolesid =  objSystemRolesInfo.getDatabaserolesid();//DatabaseRolesID  数据类型:int
      SystemRolesInfo objOld =  dal.GetSystemRolesInfoByDatabaserolesid(Databaserolesid);// 读取实体信息
		dal.UpdateByDatabaserolesid(objSystemRolesInfo);
		setSystemRolesStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objSystemRolesInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objSystemRolesInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_system_roles", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByDatabaserolesid
        // [start] DeleteByDatabaserolesid
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 删除数据表t_system_roles 角色表中的内容<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @param Databaserolesid DatabaseRolesID
        */
	public static boolean DeleteByDatabaserolesid(int Databaserolesid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByDatabaserolesid(dp, Databaserolesid);
	}

	// [end]
        // [start] DeleteByDatabaserolesid
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 删除数据表t_system_roles 角色表中的内容<br />
        * 开发者 贾军磊 2012年12月12日 14:19:34
        *
        * @param Databaserolesid DatabaseRolesID
        */
	public static boolean DeleteByDatabaserolesid(DataProvider dp, int Databaserolesid)
	{
		SystemRolesDAL dal = new SystemRolesDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      SystemRolesInfo objOld =  dal.GetSystemRolesInfoByDatabaserolesid(Databaserolesid);// 读取实体信息
		dal.DeleteByDatabaserolesid(Databaserolesid);
		setSystemRolesStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_system_roles", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}