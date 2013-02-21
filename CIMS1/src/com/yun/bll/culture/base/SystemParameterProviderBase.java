/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:32:26
   功能说明: 表t_system_parameter 的业务类SystemParameterInfo的业务层基类
   表说明:
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表SystemParameter  的实体SystemParameterInfo的数据操作类
 *
 */
public class SystemParameterProviderBase
{
	// [start] 设置和获取静态属性列表 SystemParameterStatic, 默认值:null
	// 设置和获取静态属性列表 SystemParameterStatic, 默认值:null 开始
	private static SystemParameterInfoCollection systemParameterStatic = null;
	/**
	* 获取 静态属性列表 SystemParameterStatic, 默认值:null
	 *
	 * @return 静态属性列表 SystemParameterStatic, 默认值:null
	 */
	public static SystemParameterInfoCollection getSystemParameterStatic()
	{
		if (systemParameterStatic == null)
		  systemParameterStatic = new SystemParameterDAL().GetListBy();
		return systemParameterStatic;
	}
	/**
	 * 设置 静态属性列表 SystemParameterStatic, 默认值:null
	 *
	 * @param sSystemParameterStatic
	 *            静态属性列表 SystemParameterStatic, 默认值:null
	 */
	public static void setSystemParameterStatic(SystemParameterInfoCollection sSystemParameterStatic)
	{
		systemParameterStatic = sSystemParameterStatic;
		setSystemParameterInfoStaticByDatabaseid (null);
	}
	// 设置和获取静态属性列表 SystemParameterStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.SystemParameterInfo objSystemParameterInfo : getSystemParameterStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objSystemParameterInfo.getDatabaseid(), objSystemParameterInfo.getUnitname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetSystemParameterInfoStaticByDatabaseid
	// [start] 设置和获取静态属性列表 SystemParameterInfoStaticByDatabaseid, 默认值:null
	// 设置和获取静态属性列表 SystemParameterInfoStaticByDatabaseid, 默认值:null 开始
	private static SystemParameterInfoCollection SystemParameterInfoStaticByDatabaseid = null;
	/**
	* 获取 静态属性列表 SystemParameterInfoStaticByDatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 SystemParameterInfoStaticByDatabaseid, 默认值:null
	 */
	public static SystemParameterInfoCollection getSystemParameterInfoStaticByDatabaseid()
	{
		return SystemParameterInfoStaticByDatabaseid;
	}
	/**
	 * 设置 静态属性列表 SystemParameterInfoStaticByDatabaseid, 默认值:null
	 *
	 * @param sSystemParameterInfoStaticByDatabaseid
	 *            静态属性列表 SystemParameterInfoStaticByDatabaseid, 默认值:null
	 */
	public static void setSystemParameterInfoStaticByDatabaseid(SystemParameterInfoCollection sSystemParameterInfoStaticByDatabaseid)
	{
		SystemParameterInfoStaticByDatabaseid = sSystemParameterInfoStaticByDatabaseid;
	}
	// 设置和获取静态属性列表 SystemParameterInfoStaticByDatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 获取表t_system_parameter 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @param Databaseid DatabaseID
        * @return SystemParameterInfo对象实体
        */
        public static SystemParameterInfo GetSystemParameterInfoStaticByDatabaseid(int Databaseid)
        {
            if (SystemParameterInfoStaticByDatabaseid == null)
                SystemParameterInfoStaticByDatabaseid = new SystemParameterInfoCollection();
            int allcount = SystemParameterInfoStaticByDatabaseid.size();
            SystemParameterInfo objSystemParameterInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (SystemParameterInfoStaticByDatabaseid == null)
                    break;
                    objSystemParameterInfo = SystemParameterInfoStaticByDatabaseid.get(i);
                if (objSystemParameterInfo == null)
                    break;
                if (objSystemParameterInfo.getDatabaseid() == Databaseid)
                {
                    return objSystemParameterInfo;
                }
            }
            SystemParameterInfo obj= new SystemParameterDAL().GetSystemParameterInfoByDatabaseid(Databaseid);

            if (obj != null)
            {
                if (SystemParameterInfoStaticByDatabaseid != null)
                    SystemParameterInfoStaticByDatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new SystemParameterInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByDatabaseid
        // [start] CountByDatabaseid
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 统计表t_system_parameter 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @param Databaseid DatabaseID
        * @return 数据量
        */
        public static int CountByDatabaseid(int Databaseid)
        {
            return new SystemParameterDAL().CountByDatabaseid(Databaseid);
        }
        // [end]
        // [start] CountByDatabaseid
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 统计表t_system_parameter 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @param Databaseid DatabaseID
        * @return 数据量
        */
        public static int CountByDatabaseid(DataProvider dp, int Databaseid)
        {
		SystemParameterDAL dal = new SystemParameterDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByDatabaseid(Databaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_parameter 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new SystemParameterDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_parameter 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		SystemParameterDAL dal = new SystemParameterDAL();
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
 返回表t_system_parameter 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemParameterInfoCollection GetListBy()
        {
            return new SystemParameterDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_parameter 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemParameterInfoCollection GetListBy(DataProvider dp )
        {
		SystemParameterDAL dal = new SystemParameterDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_parameter 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemParameterInfoCollection GetListBy(String OrderBy)
        {
            return new SystemParameterDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_parameter 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemParameterInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		SystemParameterDAL dal = new SystemParameterDAL();
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
 返回表t_system_parameter 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemParameterInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new SystemParameterDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_parameter 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new SystemParameterDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_parameter 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemParameterInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new SystemParameterDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_parameter 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new SystemParameterDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_parameter 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemParameterInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		SystemParameterDAL dal = new SystemParameterDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_parameter 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		SystemParameterDAL dal = new SystemParameterDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_parameter 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemParameterInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		SystemParameterDAL dal = new SystemParameterDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_parameter 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		SystemParameterDAL dal = new SystemParameterDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetSystemParameterInfoByDatabaseid
        // [start] GetSystemParameterInfoByDatabaseid
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 获取表t_system_parameter 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @param Databaseid DatabaseID
        * @return SystemParameterInfo对象实体
        */
        public static SystemParameterInfo GetSystemParameterInfoByDatabaseid(int Databaseid)
        {
            return new SystemParameterDAL().GetSystemParameterInfoByDatabaseid(Databaseid);
        }
        // [end]
        // [start] GetSystemParameterInfoByDatabaseid
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 获取表t_system_parameter 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @param Databaseid DatabaseID
        * @return SystemParameterInfo对象实体
        */
        public static SystemParameterInfo GetSystemParameterInfoByDatabaseid(DataProvider dp, int Databaseid)
        {
		SystemParameterDAL dal = new SystemParameterDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetSystemParameterInfoByDatabaseid(Databaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_system_parameter 中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @param objSystemParameterInfo SystemParameterInfo对象 
        */
  public static boolean Insert(SystemParameterInfo objSystemParameterInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objSystemParameterInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_system_parameter 中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @param objSystemParameterInfo SystemParameterInfo对象 
        */
  public static boolean Insert(DataProvider dp, SystemParameterInfo objSystemParameterInfo)
	{
		SystemParameterDAL dal = new SystemParameterDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objSystemParameterInfo);
      setSystemParameterStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_system_parameter", "添加", objSystemParameterInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByDatabaseid
        // [start] UpdateByDatabaseid
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 更新表t_system_parameter 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @param objSystemParameterInfo SystemParameterInfo对象 
        */
  public static boolean UpdateByDatabaseid(SystemParameterInfo objSystemParameterInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByDatabaseid(dp, objSystemParameterInfo);
	}

	// [end]
        // [start] UpdateByDatabaseid
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 更新表t_system_parameter 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @param objSystemParameterInfo SystemParameterInfo对象 
        */
  public static boolean UpdateByDatabaseid(DataProvider dp, SystemParameterInfo objSystemParameterInfo)
	{
		SystemParameterDAL dal = new SystemParameterDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Databaseid =  objSystemParameterInfo.getDatabaseid();//DatabaseID  数据类型:int
      SystemParameterInfo objOld =  dal.GetSystemParameterInfoByDatabaseid(Databaseid);// 读取实体信息
		dal.UpdateByDatabaseid(objSystemParameterInfo);
		setSystemParameterStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objSystemParameterInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objSystemParameterInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_system_parameter", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByDatabaseid
        // [start] DeleteByDatabaseid
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 删除数据表t_system_parameter 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @param Databaseid DatabaseID
        */
	public static boolean DeleteByDatabaseid(int Databaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByDatabaseid(dp, Databaseid);
	}

	// [end]
        // [start] DeleteByDatabaseid
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 删除数据表t_system_parameter 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:32:26
        *
        * @param Databaseid DatabaseID
        */
	public static boolean DeleteByDatabaseid(DataProvider dp, int Databaseid)
	{
		SystemParameterDAL dal = new SystemParameterDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      SystemParameterInfo objOld =  dal.GetSystemParameterInfoByDatabaseid(Databaseid);// 读取实体信息
		dal.DeleteByDatabaseid(Databaseid);
		setSystemParameterStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_system_parameter", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}