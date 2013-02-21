/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:32:44
   功能说明: 表t_system_sector 部门表的业务类SystemSectorInfo的业务层基类
   表说明:部门表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表SystemSector 部门表 的实体SystemSectorInfo的数据操作类
 *
 */
public class SystemSectorProviderBase
{
	// [start] 设置和获取静态属性列表 SystemSectorStatic, 默认值:null
	// 设置和获取静态属性列表 SystemSectorStatic, 默认值:null 开始
	private static SystemSectorInfoCollection systemSectorStatic = null;
	/**
	* 获取 静态属性列表 SystemSectorStatic, 默认值:null
	 *
	 * @return 静态属性列表 SystemSectorStatic, 默认值:null
	 */
	public static SystemSectorInfoCollection getSystemSectorStatic()
	{
		if (systemSectorStatic == null)
		  systemSectorStatic = new SystemSectorDAL().GetListBy();
		return systemSectorStatic;
	}
	/**
	 * 设置 静态属性列表 SystemSectorStatic, 默认值:null
	 *
	 * @param sSystemSectorStatic
	 *            静态属性列表 SystemSectorStatic, 默认值:null
	 */
	public static void setSystemSectorStatic(SystemSectorInfoCollection sSystemSectorStatic)
	{
		systemSectorStatic = sSystemSectorStatic;
		setSystemSectorInfoStaticBySectordatabaseid (null);
	}
	// 设置和获取静态属性列表 SystemSectorStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.SystemSectorInfo objSystemSectorInfo : getSystemSectorStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objSystemSectorInfo.getSectordatabaseid(), objSystemSectorInfo.getSectorname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetSystemSectorInfoStaticBySectordatabaseid
	// [start] 设置和获取静态属性列表 SystemSectorInfoStaticBySectordatabaseid, 默认值:null
	// 设置和获取静态属性列表 SystemSectorInfoStaticBySectordatabaseid, 默认值:null 开始
	private static SystemSectorInfoCollection SystemSectorInfoStaticBySectordatabaseid = null;
	/**
	* 获取 静态属性列表 SystemSectorInfoStaticBySectordatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 SystemSectorInfoStaticBySectordatabaseid, 默认值:null
	 */
	public static SystemSectorInfoCollection getSystemSectorInfoStaticBySectordatabaseid()
	{
		return SystemSectorInfoStaticBySectordatabaseid;
	}
	/**
	 * 设置 静态属性列表 SystemSectorInfoStaticBySectordatabaseid, 默认值:null
	 *
	 * @param sSystemSectorInfoStaticBySectordatabaseid
	 *            静态属性列表 SystemSectorInfoStaticBySectordatabaseid, 默认值:null
	 */
	public static void setSystemSectorInfoStaticBySectordatabaseid(SystemSectorInfoCollection sSystemSectorInfoStaticBySectordatabaseid)
	{
		SystemSectorInfoStaticBySectordatabaseid = sSystemSectorInfoStaticBySectordatabaseid;
	}
	// 设置和获取静态属性列表 SystemSectorInfoStaticBySectordatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 获取表t_system_sector 部门表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectordatabaseid 部门编号
        * @return SystemSectorInfo对象实体
        */
        public static SystemSectorInfo GetSystemSectorInfoStaticBySectordatabaseid(int Sectordatabaseid)
        {
            if (SystemSectorInfoStaticBySectordatabaseid == null)
                SystemSectorInfoStaticBySectordatabaseid = new SystemSectorInfoCollection();
            int allcount = SystemSectorInfoStaticBySectordatabaseid.size();
            SystemSectorInfo objSystemSectorInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (SystemSectorInfoStaticBySectordatabaseid == null)
                    break;
                    objSystemSectorInfo = SystemSectorInfoStaticBySectordatabaseid.get(i);
                if (objSystemSectorInfo == null)
                    break;
                if (objSystemSectorInfo.getSectordatabaseid() == Sectordatabaseid)
                {
                    return objSystemSectorInfo;
                }
            }
            SystemSectorInfo obj= new SystemSectorDAL().GetSystemSectorInfoBySectordatabaseid(Sectordatabaseid);

            if (obj != null)
            {
                if (SystemSectorInfoStaticBySectordatabaseid != null)
                    SystemSectorInfoStaticBySectordatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new SystemSectorInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountBySectordatabaseid
        // [start] CountBySectordatabaseid
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectordatabaseid 部门编号
        * @return 数据量
        */
        public static int CountBySectordatabaseid(int Sectordatabaseid)
        {
            return new SystemSectorDAL().CountBySectordatabaseid(Sectordatabaseid);
        }
        // [end]
        // [start] CountBySectordatabaseid
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectordatabaseid 部门编号
        * @return 数据量
        */
        public static int CountBySectordatabaseid(DataProvider dp, int Sectordatabaseid)
        {
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBySectordatabaseid(Sectordatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new SystemSectorDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]
        // [start] CountBySectorid
        // [start] CountBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectorid 部门编号
        * @return 数据量
        */
        public static int CountBySectorid(int Sectorid)
        {
            return new SystemSectorDAL().CountBySectorid(Sectorid);
        }
        // [end]
        // [start] CountBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectorid 部门编号
        * @return 数据量
        */
        public static int CountBySectorid(DataProvider dp, int Sectorid)
        {
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBySectorid(Sectorid);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemSectorInfoCollection GetListBy()
        {
            return new SystemSectorDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemSectorInfoCollection GetListBy(DataProvider dp )
        {
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemSectorInfoCollection GetListBy(String OrderBy)
        {
            return new SystemSectorDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemSectorInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListBySectorid
        // [start] GetListBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectorid 部门编号
        * @return 数据列表的强类型实体类
        */
        public static SystemSectorInfoCollection GetListBySectorid(int Sectorid)
        {
            return new SystemSectorDAL().GetListBySectorid(Sectorid);
        }
        // [end]
        // [start] GetListBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectorid 部门编号
        * @return 数据列表的强类型实体类
        */
        public static SystemSectorInfoCollection GetListBySectorid(DataProvider dp, int Sectorid)
        {
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBySectorid(Sectorid);
        }
        // [end]
        // [start] GetListBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectorid 部门编号
        * @return 数据列表的强类型实体类
        */
        public static SystemSectorInfoCollection GetListBySectorid(int Sectorid, String OrderBy)
        {
            return new SystemSectorDAL().GetListBySectorid(Sectorid, OrderBy);
        }
        // [end]
        // [start] GetListBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectorid 部门编号
        * @return 数据列表的强类型实体类
        */
        public static SystemSectorInfoCollection GetListBySectorid(DataProvider dp, int Sectorid, String OrderBy)
        {
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBySectorid(Sectorid, OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemSectorInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new SystemSectorDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new SystemSectorDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemSectorInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new SystemSectorDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new SystemSectorDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemSectorInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemSectorInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListPagerBySectorid
        // [start] GetListPagerBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectorid 部门编号
        * @return 数据列表的强类型实体类
        */
        public static SystemSectorInfoCollection GetListPagerBySectorid(int Sectorid, int pageIndex, int pageSize)
        {
            return new SystemSectorDAL().GetListPagerBySectorid(Sectorid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectorid 部门编号
        * @return 数据总量
        */
        public static int GetListPagerBySectorid(int Sectorid)
        {
            return new SystemSectorDAL().GetListPagerBySectorid(Sectorid);
        }
        // [end]
        // [start] GetListPagerBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectorid 部门编号
        * @return 数据列表的强类型实体类
        */
        public static SystemSectorInfoCollection GetListPagerBySectorid(int Sectorid,  String OrderBy, int pageIndex, int pageSize)
        {
            return new SystemSectorDAL().GetListPagerBySectorid(Sectorid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectorid 部门编号
        * @return 数据总量
        */
        public static int GetListPagerBySectorid(int Sectorid, String OrderBy)
        {
            return new SystemSectorDAL().GetListPagerBySectorid(Sectorid,  OrderBy);
        }
        // [end]
        // [start] GetListPagerBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectorid 部门编号
        * @return 数据列表的强类型实体类
        */
        public static SystemSectorInfoCollection GetListPagerBySectorid(DataProvider dp,int Sectorid, int pageIndex, int pageSize)
        {
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBySectorid(Sectorid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectorid 部门编号
        * @return 数据总量
        */
        public static int GetListPagerBySectorid(DataProvider dp, int Sectorid)
        {
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBySectorid(Sectorid);
        }
        // [end]
        // [start] GetListPagerBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectorid 部门编号
        * @return 数据列表的强类型实体类
        */
        public static SystemSectorInfoCollection GetListPagerBySectorid(DataProvider dp, int Sectorid,  String OrderBy, int pageIndex, int pageSize)
        {
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBySectorid(Sectorid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectorid 部门编号
        * @return 数据总量
        */
        public static int GetListPagerBySectorid(DataProvider dp, int Sectorid, String OrderBy)
        {
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBySectorid(Sectorid,  OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetSystemSectorInfoBySectordatabaseid
        // [start] GetSystemSectorInfoBySectordatabaseid
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 获取表t_system_sector 部门表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectordatabaseid 部门编号
        * @return SystemSectorInfo对象实体
        */
        public static SystemSectorInfo GetSystemSectorInfoBySectordatabaseid(int Sectordatabaseid)
        {
            return new SystemSectorDAL().GetSystemSectorInfoBySectordatabaseid(Sectordatabaseid);
        }
        // [end]
        // [start] GetSystemSectorInfoBySectordatabaseid
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 获取表t_system_sector 部门表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectordatabaseid 部门编号
        * @return SystemSectorInfo对象实体
        */
        public static SystemSectorInfo GetSystemSectorInfoBySectordatabaseid(DataProvider dp, int Sectordatabaseid)
        {
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetSystemSectorInfoBySectordatabaseid(Sectordatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_system_sector 部门表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param objSystemSectorInfo SystemSectorInfo对象 部门表
        */
  public static boolean Insert(SystemSectorInfo objSystemSectorInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objSystemSectorInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_system_sector 部门表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param objSystemSectorInfo SystemSectorInfo对象 部门表
        */
  public static boolean Insert(DataProvider dp, SystemSectorInfo objSystemSectorInfo)
	{
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objSystemSectorInfo);
      setSystemSectorStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_system_sector", "添加", objSystemSectorInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateBySectordatabaseid
        // [start] UpdateBySectordatabaseid
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 更新表t_system_sector 部门表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param objSystemSectorInfo SystemSectorInfo对象 部门表
        */
  public static boolean UpdateBySectordatabaseid(SystemSectorInfo objSystemSectorInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateBySectordatabaseid(dp, objSystemSectorInfo);
	}

	// [end]
        // [start] UpdateBySectordatabaseid
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 更新表t_system_sector 部门表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param objSystemSectorInfo SystemSectorInfo对象 部门表
        */
  public static boolean UpdateBySectordatabaseid(DataProvider dp, SystemSectorInfo objSystemSectorInfo)
	{
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Sectordatabaseid =  objSystemSectorInfo.getSectordatabaseid();//部门编号  数据类型:int
      SystemSectorInfo objOld =  dal.GetSystemSectorInfoBySectordatabaseid(Sectordatabaseid);// 读取实体信息
		dal.UpdateBySectordatabaseid(objSystemSectorInfo);
		setSystemSectorStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objSystemSectorInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objSystemSectorInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_system_sector", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteBySectordatabaseid
        // [start] DeleteBySectordatabaseid
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 删除数据表t_system_sector 部门表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectordatabaseid 部门编号
        */
	public static boolean DeleteBySectordatabaseid(int Sectordatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteBySectordatabaseid(dp, Sectordatabaseid);
	}

	// [end]
        // [start] DeleteBySectordatabaseid
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 删除数据表t_system_sector 部门表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:32:44
        *
        * @param Sectordatabaseid 部门编号
        */
	public static boolean DeleteBySectordatabaseid(DataProvider dp, int Sectordatabaseid)
	{
		SystemSectorDAL dal = new SystemSectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      SystemSectorInfo objOld =  dal.GetSystemSectorInfoBySectordatabaseid(Sectordatabaseid);// 读取实体信息
		dal.DeleteBySectordatabaseid(Sectordatabaseid);
		setSystemSectorStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_system_sector", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}