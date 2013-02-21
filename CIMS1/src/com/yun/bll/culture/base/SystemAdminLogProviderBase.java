/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:32:04
   功能说明: 表t_system_admin_log 管理人员日志表的业务类SystemAdminLogInfo的业务层基类
   表说明:管理人员日志表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表SystemAdminLog 管理人员日志表 的实体SystemAdminLogInfo的数据操作类
 *
 */
public class SystemAdminLogProviderBase
{
	// [start] 设置和获取静态属性列表 SystemAdminLogStatic, 默认值:null
	// 设置和获取静态属性列表 SystemAdminLogStatic, 默认值:null 开始
	private static SystemAdminLogInfoCollection systemAdminLogStatic = null;
	/**
	* 获取 静态属性列表 SystemAdminLogStatic, 默认值:null
	 *
	 * @return 静态属性列表 SystemAdminLogStatic, 默认值:null
	 */
	public static SystemAdminLogInfoCollection getSystemAdminLogStatic()
	{
		if (systemAdminLogStatic == null)
		  systemAdminLogStatic = new SystemAdminLogDAL().GetListBy();
		return systemAdminLogStatic;
	}
	/**
	 * 设置 静态属性列表 SystemAdminLogStatic, 默认值:null
	 *
	 * @param sSystemAdminLogStatic
	 *            静态属性列表 SystemAdminLogStatic, 默认值:null
	 */
	public static void setSystemAdminLogStatic(SystemAdminLogInfoCollection sSystemAdminLogStatic)
	{
		systemAdminLogStatic = sSystemAdminLogStatic;
		setSystemAdminLogInfoStaticByLogid (null);
	}
	// 设置和获取静态属性列表 SystemAdminLogStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.SystemAdminLogInfo objSystemAdminLogInfo : getSystemAdminLogStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objSystemAdminLogInfo.getLogid(), objSystemAdminLogInfo.getAdminname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetSystemAdminLogInfoStaticByLogid
	// [start] 设置和获取静态属性列表 SystemAdminLogInfoStaticByLogid, 默认值:null
	// 设置和获取静态属性列表 SystemAdminLogInfoStaticByLogid, 默认值:null 开始
	private static SystemAdminLogInfoCollection SystemAdminLogInfoStaticByLogid = null;
	/**
	* 获取 静态属性列表 SystemAdminLogInfoStaticByLogid, 默认值:null
	 *
	 * @return 静态属性列表 SystemAdminLogInfoStaticByLogid, 默认值:null
	 */
	public static SystemAdminLogInfoCollection getSystemAdminLogInfoStaticByLogid()
	{
		return SystemAdminLogInfoStaticByLogid;
	}
	/**
	 * 设置 静态属性列表 SystemAdminLogInfoStaticByLogid, 默认值:null
	 *
	 * @param sSystemAdminLogInfoStaticByLogid
	 *            静态属性列表 SystemAdminLogInfoStaticByLogid, 默认值:null
	 */
	public static void setSystemAdminLogInfoStaticByLogid(SystemAdminLogInfoCollection sSystemAdminLogInfoStaticByLogid)
	{
		SystemAdminLogInfoStaticByLogid = sSystemAdminLogInfoStaticByLogid;
	}
	// 设置和获取静态属性列表 SystemAdminLogInfoStaticByLogid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 获取表t_system_admin_log 管理人员日志表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @param Logid 人员日志编号
        * @return SystemAdminLogInfo对象实体
        */
        public static SystemAdminLogInfo GetSystemAdminLogInfoStaticByLogid(int Logid)
        {
            if (SystemAdminLogInfoStaticByLogid == null)
                SystemAdminLogInfoStaticByLogid = new SystemAdminLogInfoCollection();
            int allcount = SystemAdminLogInfoStaticByLogid.size();
            SystemAdminLogInfo objSystemAdminLogInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (SystemAdminLogInfoStaticByLogid == null)
                    break;
                    objSystemAdminLogInfo = SystemAdminLogInfoStaticByLogid.get(i);
                if (objSystemAdminLogInfo == null)
                    break;
                if (objSystemAdminLogInfo.getLogid() == Logid)
                {
                    return objSystemAdminLogInfo;
                }
            }
            SystemAdminLogInfo obj= new SystemAdminLogDAL().GetSystemAdminLogInfoByLogid(Logid);

            if (obj != null)
            {
                if (SystemAdminLogInfoStaticByLogid != null)
                    SystemAdminLogInfoStaticByLogid.add(obj);
                return obj;
            }
            else
            {
                return new SystemAdminLogInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByLogid
        // [start] CountByLogid
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 统计表t_system_admin_log 管理人员日志表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @param Logid 人员日志编号
        * @return 数据量
        */
        public static int CountByLogid(int Logid)
        {
            return new SystemAdminLogDAL().CountByLogid(Logid);
        }
        // [end]
        // [start] CountByLogid
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 统计表t_system_admin_log 管理人员日志表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @param Logid 人员日志编号
        * @return 数据量
        */
        public static int CountByLogid(DataProvider dp, int Logid)
        {
		SystemAdminLogDAL dal = new SystemAdminLogDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByLogid(Logid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_admin_log 管理人员日志表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new SystemAdminLogDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_admin_log 管理人员日志表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		SystemAdminLogDAL dal = new SystemAdminLogDAL();
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
 返回表t_system_admin_log 管理人员日志表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminLogInfoCollection GetListBy()
        {
            return new SystemAdminLogDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_admin_log 管理人员日志表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminLogInfoCollection GetListBy(DataProvider dp )
        {
		SystemAdminLogDAL dal = new SystemAdminLogDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_admin_log 管理人员日志表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminLogInfoCollection GetListBy(String OrderBy)
        {
            return new SystemAdminLogDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_admin_log 管理人员日志表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminLogInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		SystemAdminLogDAL dal = new SystemAdminLogDAL();
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
 返回表t_system_admin_log 管理人员日志表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminLogInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new SystemAdminLogDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_admin_log 管理人员日志表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new SystemAdminLogDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_admin_log 管理人员日志表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminLogInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new SystemAdminLogDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_admin_log 管理人员日志表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new SystemAdminLogDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_admin_log 管理人员日志表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminLogInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		SystemAdminLogDAL dal = new SystemAdminLogDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_admin_log 管理人员日志表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		SystemAdminLogDAL dal = new SystemAdminLogDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_admin_log 管理人员日志表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminLogInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		SystemAdminLogDAL dal = new SystemAdminLogDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_admin_log 管理人员日志表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		SystemAdminLogDAL dal = new SystemAdminLogDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetSystemAdminLogInfoByLogid
        // [start] GetSystemAdminLogInfoByLogid
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 获取表t_system_admin_log 管理人员日志表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @param Logid 人员日志编号
        * @return SystemAdminLogInfo对象实体
        */
        public static SystemAdminLogInfo GetSystemAdminLogInfoByLogid(int Logid)
        {
            return new SystemAdminLogDAL().GetSystemAdminLogInfoByLogid(Logid);
        }
        // [end]
        // [start] GetSystemAdminLogInfoByLogid
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 获取表t_system_admin_log 管理人员日志表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @param Logid 人员日志编号
        * @return SystemAdminLogInfo对象实体
        */
        public static SystemAdminLogInfo GetSystemAdminLogInfoByLogid(DataProvider dp, int Logid)
        {
		SystemAdminLogDAL dal = new SystemAdminLogDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetSystemAdminLogInfoByLogid(Logid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_system_admin_log 管理人员日志表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @param objSystemAdminLogInfo SystemAdminLogInfo对象 管理人员日志表
        */
  public static boolean Insert(SystemAdminLogInfo objSystemAdminLogInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objSystemAdminLogInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_system_admin_log 管理人员日志表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @param objSystemAdminLogInfo SystemAdminLogInfo对象 管理人员日志表
        */
  public static boolean Insert(DataProvider dp, SystemAdminLogInfo objSystemAdminLogInfo)
	{
		SystemAdminLogDAL dal = new SystemAdminLogDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objSystemAdminLogInfo);
		setSystemAdminLogStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_system_admin_log", "添加", objSystemAdminLogInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByLogid
        // [start] UpdateByLogid
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 更新表t_system_admin_log 管理人员日志表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @param objSystemAdminLogInfo SystemAdminLogInfo对象 管理人员日志表
        */
  public static boolean UpdateByLogid(SystemAdminLogInfo objSystemAdminLogInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByLogid(dp, objSystemAdminLogInfo);
	}

	// [end]
        // [start] UpdateByLogid
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 更新表t_system_admin_log 管理人员日志表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @param objSystemAdminLogInfo SystemAdminLogInfo对象 管理人员日志表
        */
  public static boolean UpdateByLogid(DataProvider dp, SystemAdminLogInfo objSystemAdminLogInfo)
	{
		SystemAdminLogDAL dal = new SystemAdminLogDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Logid =  objSystemAdminLogInfo.getLogid();//人员日志编号  数据类型:int
      SystemAdminLogInfo objOld =  dal.GetSystemAdminLogInfoByLogid(Logid);// 读取实体信息
		dal.UpdateByLogid(objSystemAdminLogInfo);
		setSystemAdminLogStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objSystemAdminLogInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objSystemAdminLogInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_system_admin_log", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByLogid
        // [start] DeleteByLogid
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 删除数据表t_system_admin_log 管理人员日志表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @param Logid 人员日志编号
        */
	public static boolean DeleteByLogid(int Logid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByLogid(dp, Logid);
	}

	// [end]
        // [start] DeleteByLogid
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 删除数据表t_system_admin_log 管理人员日志表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:32:04
        *
        * @param Logid 人员日志编号
        */
	public static boolean DeleteByLogid(DataProvider dp, int Logid)
	{
		SystemAdminLogDAL dal = new SystemAdminLogDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      SystemAdminLogInfo objOld =  dal.GetSystemAdminLogInfoByLogid(Logid);// 读取实体信息
		dal.DeleteByLogid(Logid);
		setSystemAdminLogStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_system_admin_log", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}