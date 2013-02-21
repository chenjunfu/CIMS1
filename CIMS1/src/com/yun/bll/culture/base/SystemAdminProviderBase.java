/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月13日 09:50:03
   功能说明: 表t_system_admin 系统人员表的业务类SystemAdminInfo的业务层基类
   表说明:系统人员表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表SystemAdmin 系统人员表 的实体SystemAdminInfo的数据操作类
 *
 */
public class SystemAdminProviderBase
{
	// [start] 设置和获取静态属性列表 SystemAdminStatic, 默认值:null
	// 设置和获取静态属性列表 SystemAdminStatic, 默认值:null 开始
	private static SystemAdminInfoCollection systemAdminStatic = null;
	/**
	* 获取 静态属性列表 SystemAdminStatic, 默认值:null
	 *
	 * @return 静态属性列表 SystemAdminStatic, 默认值:null
	 */
	public static SystemAdminInfoCollection getSystemAdminStatic()
	{
		if (systemAdminStatic == null)
		  systemAdminStatic = new SystemAdminDAL().GetListBy();
		return systemAdminStatic;
	}
	/**
	 * 设置 静态属性列表 SystemAdminStatic, 默认值:null
	 *
	 * @param sSystemAdminStatic
	 *            静态属性列表 SystemAdminStatic, 默认值:null
	 */
	public static void setSystemAdminStatic(SystemAdminInfoCollection sSystemAdminStatic)
	{
		systemAdminStatic = sSystemAdminStatic;
		setSystemAdminInfoStaticByDatabaseadminid (null);
	}
	// 设置和获取静态属性列表 SystemAdminStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.SystemAdminInfo objSystemAdminInfo : getSystemAdminStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objSystemAdminInfo.getDatabaseadminid(), objSystemAdminInfo.getTruename()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetSystemAdminInfoStaticByDatabaseadminid
	// [start] 设置和获取静态属性列表 SystemAdminInfoStaticByDatabaseadminid, 默认值:null
	// 设置和获取静态属性列表 SystemAdminInfoStaticByDatabaseadminid, 默认值:null 开始
	private static SystemAdminInfoCollection SystemAdminInfoStaticByDatabaseadminid = null;
	/**
	* 获取 静态属性列表 SystemAdminInfoStaticByDatabaseadminid, 默认值:null
	 *
	 * @return 静态属性列表 SystemAdminInfoStaticByDatabaseadminid, 默认值:null
	 */
	public static SystemAdminInfoCollection getSystemAdminInfoStaticByDatabaseadminid()
	{
		return SystemAdminInfoStaticByDatabaseadminid;
	}
	/**
	 * 设置 静态属性列表 SystemAdminInfoStaticByDatabaseadminid, 默认值:null
	 *
	 * @param sSystemAdminInfoStaticByDatabaseadminid
	 *            静态属性列表 SystemAdminInfoStaticByDatabaseadminid, 默认值:null
	 */
	public static void setSystemAdminInfoStaticByDatabaseadminid(SystemAdminInfoCollection sSystemAdminInfoStaticByDatabaseadminid)
	{
		SystemAdminInfoStaticByDatabaseadminid = sSystemAdminInfoStaticByDatabaseadminid;
	}
	// 设置和获取静态属性列表 SystemAdminInfoStaticByDatabaseadminid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 获取表t_system_admin 系统人员表的对象<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Databaseadminid 人员ID
        * @return SystemAdminInfo对象实体
        */
        public static SystemAdminInfo GetSystemAdminInfoStaticByDatabaseadminid(int Databaseadminid)
        {
            if (SystemAdminInfoStaticByDatabaseadminid == null)
                SystemAdminInfoStaticByDatabaseadminid = new SystemAdminInfoCollection();
            int allcount = SystemAdminInfoStaticByDatabaseadminid.size();
            SystemAdminInfo objSystemAdminInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (SystemAdminInfoStaticByDatabaseadminid == null)
                    break;
                    objSystemAdminInfo = SystemAdminInfoStaticByDatabaseadminid.get(i);
                if (objSystemAdminInfo == null)
                    break;
                if (objSystemAdminInfo.getDatabaseadminid() == Databaseadminid)
                {
                    return objSystemAdminInfo;
                }
            }
            SystemAdminInfo obj= new SystemAdminDAL().GetSystemAdminInfoByDatabaseadminid(Databaseadminid);

            if (obj != null)
            {
                if (SystemAdminInfoStaticByDatabaseadminid != null)
                    SystemAdminInfoStaticByDatabaseadminid.add(obj);
                return obj;
            }
            else
            {
                return new SystemAdminInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByDatabaseadminid
        // [start] CountByDatabaseadminid
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Databaseadminid 人员ID
        * @return 数据量
        */
        public static int CountByDatabaseadminid(int Databaseadminid)
        {
            return new SystemAdminDAL().CountByDatabaseadminid(Databaseadminid);
        }
        // [end]
        // [start] CountByDatabaseadminid
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Databaseadminid 人员ID
        * @return 数据量
        */
        public static int CountByDatabaseadminid(DataProvider dp, int Databaseadminid)
        {
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByDatabaseadminid(Databaseadminid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new SystemAdminDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]
        // [start] CountByAdminid
        // [start] CountByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Adminid 人员编号
        * @return 数据量
        */
        public static int CountByAdminid(int Adminid)
        {
            return new SystemAdminDAL().CountByAdminid(Adminid);
        }
        // [end]
        // [start] CountByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Adminid 人员编号
        * @return 数据量
        */
        public static int CountByAdminid(DataProvider dp, int Adminid)
        {
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByAdminid(Adminid);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminInfoCollection GetListBy()
        {
            return new SystemAdminDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminInfoCollection GetListBy(DataProvider dp )
        {
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminInfoCollection GetListBy(String OrderBy)
        {
            return new SystemAdminDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListByAdminid
        // [start] GetListByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Adminid 人员编号
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminInfoCollection GetListByAdminid(int Adminid)
        {
            return new SystemAdminDAL().GetListByAdminid(Adminid);
        }
        // [end]
        // [start] GetListByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Adminid 人员编号
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminInfoCollection GetListByAdminid(DataProvider dp, int Adminid)
        {
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByAdminid(Adminid);
        }
        // [end]
        // [start] GetListByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Adminid 人员编号
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminInfoCollection GetListByAdminid(int Adminid, String OrderBy)
        {
            return new SystemAdminDAL().GetListByAdminid(Adminid, OrderBy);
        }
        // [end]
        // [start] GetListByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Adminid 人员编号
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminInfoCollection GetListByAdminid(DataProvider dp, int Adminid, String OrderBy)
        {
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByAdminid(Adminid, OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new SystemAdminDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new SystemAdminDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new SystemAdminDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new SystemAdminDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListPagerByAdminid
        // [start] GetListPagerByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Adminid 人员编号
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminInfoCollection GetListPagerByAdminid(int Adminid, int pageIndex, int pageSize)
        {
            return new SystemAdminDAL().GetListPagerByAdminid(Adminid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Adminid 人员编号
        * @return 数据总量
        */
        public static int GetListPagerByAdminid(int Adminid)
        {
            return new SystemAdminDAL().GetListPagerByAdminid(Adminid);
        }
        // [end]
        // [start] GetListPagerByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Adminid 人员编号
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminInfoCollection GetListPagerByAdminid(int Adminid,  String OrderBy, int pageIndex, int pageSize)
        {
            return new SystemAdminDAL().GetListPagerByAdminid(Adminid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Adminid 人员编号
        * @return 数据总量
        */
        public static int GetListPagerByAdminid(int Adminid, String OrderBy)
        {
            return new SystemAdminDAL().GetListPagerByAdminid(Adminid,  OrderBy);
        }
        // [end]
        // [start] GetListPagerByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Adminid 人员编号
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminInfoCollection GetListPagerByAdminid(DataProvider dp,int Adminid, int pageIndex, int pageSize)
        {
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByAdminid(Adminid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Adminid 人员编号
        * @return 数据总量
        */
        public static int GetListPagerByAdminid(DataProvider dp, int Adminid)
        {
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByAdminid(Adminid);
        }
        // [end]
        // [start] GetListPagerByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Adminid 人员编号
        * @return 数据列表的强类型实体类
        */
        public static SystemAdminInfoCollection GetListPagerByAdminid(DataProvider dp, int Adminid,  String OrderBy, int pageIndex, int pageSize)
        {
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByAdminid(Adminid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Adminid 人员编号
        * @return 数据总量
        */
        public static int GetListPagerByAdminid(DataProvider dp, int Adminid, String OrderBy)
        {
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByAdminid(Adminid,  OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetSystemAdminInfoByDatabaseadminid
        // [start] GetSystemAdminInfoByDatabaseadminid
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 获取表t_system_admin 系统人员表的对象<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Databaseadminid 人员ID
        * @return SystemAdminInfo对象实体
        */
        public static SystemAdminInfo GetSystemAdminInfoByDatabaseadminid(int Databaseadminid)
        {
            return new SystemAdminDAL().GetSystemAdminInfoByDatabaseadminid(Databaseadminid);
        }
        // [end]
        // [start] GetSystemAdminInfoByDatabaseadminid
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 获取表t_system_admin 系统人员表的对象<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Databaseadminid 人员ID
        * @return SystemAdminInfo对象实体
        */
        public static SystemAdminInfo GetSystemAdminInfoByDatabaseadminid(DataProvider dp, int Databaseadminid)
        {
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetSystemAdminInfoByDatabaseadminid(Databaseadminid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_system_admin 系统人员表中插入数据<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param objSystemAdminInfo SystemAdminInfo对象 系统人员表
        */
  public static boolean Insert(SystemAdminInfo objSystemAdminInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objSystemAdminInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_system_admin 系统人员表中插入数据<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param objSystemAdminInfo SystemAdminInfo对象 系统人员表
        */
  public static boolean Insert(DataProvider dp, SystemAdminInfo objSystemAdminInfo)
	{
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objSystemAdminInfo);
		setSystemAdminStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_system_admin", "添加", objSystemAdminInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByDatabaseadminid
        // [start] UpdateByDatabaseadminid
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 更新表t_system_admin 系统人员表中的内容<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param objSystemAdminInfo SystemAdminInfo对象 系统人员表
        */
  public static boolean UpdateByDatabaseadminid(SystemAdminInfo objSystemAdminInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByDatabaseadminid(dp, objSystemAdminInfo);
	}

	// [end]
        // [start] UpdateByDatabaseadminid
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 更新表t_system_admin 系统人员表中的内容<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param objSystemAdminInfo SystemAdminInfo对象 系统人员表
        */
  public static boolean UpdateByDatabaseadminid(DataProvider dp, SystemAdminInfo objSystemAdminInfo)
	{
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Databaseadminid =  objSystemAdminInfo.getDatabaseadminid();//人员ID  数据类型:int
      SystemAdminInfo objOld =  dal.GetSystemAdminInfoByDatabaseadminid(Databaseadminid);// 读取实体信息
		dal.UpdateByDatabaseadminid(objSystemAdminInfo);
		setSystemAdminStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objSystemAdminInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objSystemAdminInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_system_admin", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByDatabaseadminid
        // [start] DeleteByDatabaseadminid
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 删除数据表t_system_admin 系统人员表中的内容<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Databaseadminid 人员ID
        */
	public static boolean DeleteByDatabaseadminid(int Databaseadminid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByDatabaseadminid(dp, Databaseadminid);
	}

	// [end]
        // [start] DeleteByDatabaseadminid
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 删除数据表t_system_admin 系统人员表中的内容<br />
        * 开发者 贾军磊 2012年12月13日 09:50:03
        *
        * @param Databaseadminid 人员ID
        */
	public static boolean DeleteByDatabaseadminid(DataProvider dp, int Databaseadminid)
	{
		SystemAdminDAL dal = new SystemAdminDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      SystemAdminInfo objOld =  dal.GetSystemAdminInfoByDatabaseadminid(Databaseadminid);// 读取实体信息
		dal.DeleteByDatabaseadminid(Databaseadminid);
		setSystemAdminStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_system_admin", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}