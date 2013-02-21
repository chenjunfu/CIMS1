/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:31:25
   功能说明: 表t_regions 郑州市地区表的业务类RegionsInfo的业务层基类
   表说明:郑州市地区表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Regions 郑州市地区表 的实体RegionsInfo的数据操作类
 *
 */
public class RegionsProviderBase
{
	// [start] 设置和获取静态属性列表 RegionsStatic, 默认值:null
	// 设置和获取静态属性列表 RegionsStatic, 默认值:null 开始
	private static RegionsInfoCollection regionsStatic = null;
	/**
	* 获取 静态属性列表 RegionsStatic, 默认值:null
	 *
	 * @return 静态属性列表 RegionsStatic, 默认值:null
	 */
	public static RegionsInfoCollection getRegionsStatic()
	{
		if (regionsStatic == null)
		  regionsStatic = new RegionsDAL().GetListBy();
		return regionsStatic;
	}
	/**
	 * 设置 静态属性列表 RegionsStatic, 默认值:null
	 *
	 * @param sRegionsStatic
	 *            静态属性列表 RegionsStatic, 默认值:null
	 */
	public static void setRegionsStatic(RegionsInfoCollection sRegionsStatic)
	{
		regionsStatic = sRegionsStatic;
		setRegionsInfoStaticByRegiondatabaseid (null);
	}
	// 设置和获取静态属性列表 RegionsStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.RegionsInfo objRegionsInfo : getRegionsStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objRegionsInfo.getRegiondatabaseid(), objRegionsInfo.getRegionname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetRegionsInfoStaticByRegiondatabaseid
	// [start] 设置和获取静态属性列表 RegionsInfoStaticByRegiondatabaseid, 默认值:null
	// 设置和获取静态属性列表 RegionsInfoStaticByRegiondatabaseid, 默认值:null 开始
	private static RegionsInfoCollection RegionsInfoStaticByRegiondatabaseid = null;
	/**
	* 获取 静态属性列表 RegionsInfoStaticByRegiondatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 RegionsInfoStaticByRegiondatabaseid, 默认值:null
	 */
	public static RegionsInfoCollection getRegionsInfoStaticByRegiondatabaseid()
	{
		return RegionsInfoStaticByRegiondatabaseid;
	}
	/**
	 * 设置 静态属性列表 RegionsInfoStaticByRegiondatabaseid, 默认值:null
	 *
	 * @param sRegionsInfoStaticByRegiondatabaseid
	 *            静态属性列表 RegionsInfoStaticByRegiondatabaseid, 默认值:null
	 */
	public static void setRegionsInfoStaticByRegiondatabaseid(RegionsInfoCollection sRegionsInfoStaticByRegiondatabaseid)
	{
		RegionsInfoStaticByRegiondatabaseid = sRegionsInfoStaticByRegiondatabaseid;
	}
	// 设置和获取静态属性列表 RegionsInfoStaticByRegiondatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 获取表t_regions 郑州市地区表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regiondatabaseid RegiondatabaseID
        * @return RegionsInfo对象实体
        */
        public static RegionsInfo GetRegionsInfoStaticByRegiondatabaseid(int Regiondatabaseid)
        {
            if (RegionsInfoStaticByRegiondatabaseid == null)
                RegionsInfoStaticByRegiondatabaseid = new RegionsInfoCollection();
            int allcount = RegionsInfoStaticByRegiondatabaseid.size();
            RegionsInfo objRegionsInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (RegionsInfoStaticByRegiondatabaseid == null)
                    break;
                    objRegionsInfo = RegionsInfoStaticByRegiondatabaseid.get(i);
                if (objRegionsInfo == null)
                    break;
                if (objRegionsInfo.getRegiondatabaseid() == Regiondatabaseid)
                {
                    return objRegionsInfo;
                }
            }
            RegionsInfo obj= new RegionsDAL().GetRegionsInfoByRegiondatabaseid(Regiondatabaseid);

            if (obj != null)
            {
                if (RegionsInfoStaticByRegiondatabaseid != null)
                    RegionsInfoStaticByRegiondatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new RegionsInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByRegiondatabaseid
        // [start] CountByRegiondatabaseid
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regiondatabaseid RegiondatabaseID
        * @return 数据量
        */
        public static int CountByRegiondatabaseid(int Regiondatabaseid)
        {
            return new RegionsDAL().CountByRegiondatabaseid(Regiondatabaseid);
        }
        // [end]
        // [start] CountByRegiondatabaseid
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regiondatabaseid RegiondatabaseID
        * @return 数据量
        */
        public static int CountByRegiondatabaseid(DataProvider dp, int Regiondatabaseid)
        {
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByRegiondatabaseid(Regiondatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new RegionsDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]
        // [start] CountByRegionid
        // [start] CountByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regionid 城市编号
        * @return 数据量
        */
        public static int CountByRegionid(int Regionid)
        {
            return new RegionsDAL().CountByRegionid(Regionid);
        }
        // [end]
        // [start] CountByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regionid 城市编号
        * @return 数据量
        */
        public static int CountByRegionid(DataProvider dp, int Regionid)
        {
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByRegionid(Regionid);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @return 数据列表的强类型实体类
        */
        public static RegionsInfoCollection GetListBy()
        {
            return new RegionsDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @return 数据列表的强类型实体类
        */
        public static RegionsInfoCollection GetListBy(DataProvider dp )
        {
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @return 数据列表的强类型实体类
        */
        public static RegionsInfoCollection GetListBy(String OrderBy)
        {
            return new RegionsDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @return 数据列表的强类型实体类
        */
        public static RegionsInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListByRegionid
        // [start] GetListByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regionid 城市编号
        * @return 数据列表的强类型实体类
        */
        public static RegionsInfoCollection GetListByRegionid(int Regionid)
        {
            return new RegionsDAL().GetListByRegionid(Regionid);
        }
        // [end]
        // [start] GetListByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regionid 城市编号
        * @return 数据列表的强类型实体类
        */
        public static RegionsInfoCollection GetListByRegionid(DataProvider dp, int Regionid)
        {
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByRegionid(Regionid);
        }
        // [end]
        // [start] GetListByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regionid 城市编号
        * @return 数据列表的强类型实体类
        */
        public static RegionsInfoCollection GetListByRegionid(int Regionid, String OrderBy)
        {
            return new RegionsDAL().GetListByRegionid(Regionid, OrderBy);
        }
        // [end]
        // [start] GetListByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regionid 城市编号
        * @return 数据列表的强类型实体类
        */
        public static RegionsInfoCollection GetListByRegionid(DataProvider dp, int Regionid, String OrderBy)
        {
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByRegionid(Regionid, OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @return 数据列表的强类型实体类
        */
        public static RegionsInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new RegionsDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new RegionsDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @return 数据列表的强类型实体类
        */
        public static RegionsInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new RegionsDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new RegionsDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @return 数据列表的强类型实体类
        */
        public static RegionsInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @return 数据列表的强类型实体类
        */
        public static RegionsInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListPagerByRegionid
        // [start] GetListPagerByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regionid 城市编号
        * @return 数据列表的强类型实体类
        */
        public static RegionsInfoCollection GetListPagerByRegionid(int Regionid, int pageIndex, int pageSize)
        {
            return new RegionsDAL().GetListPagerByRegionid(Regionid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regionid 城市编号
        * @return 数据总量
        */
        public static int GetListPagerByRegionid(int Regionid)
        {
            return new RegionsDAL().GetListPagerByRegionid(Regionid);
        }
        // [end]
        // [start] GetListPagerByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regionid 城市编号
        * @return 数据列表的强类型实体类
        */
        public static RegionsInfoCollection GetListPagerByRegionid(int Regionid,  String OrderBy, int pageIndex, int pageSize)
        {
            return new RegionsDAL().GetListPagerByRegionid(Regionid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regionid 城市编号
        * @return 数据总量
        */
        public static int GetListPagerByRegionid(int Regionid, String OrderBy)
        {
            return new RegionsDAL().GetListPagerByRegionid(Regionid,  OrderBy);
        }
        // [end]
        // [start] GetListPagerByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regionid 城市编号
        * @return 数据列表的强类型实体类
        */
        public static RegionsInfoCollection GetListPagerByRegionid(DataProvider dp,int Regionid, int pageIndex, int pageSize)
        {
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByRegionid(Regionid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regionid 城市编号
        * @return 数据总量
        */
        public static int GetListPagerByRegionid(DataProvider dp, int Regionid)
        {
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByRegionid(Regionid);
        }
        // [end]
        // [start] GetListPagerByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regionid 城市编号
        * @return 数据列表的强类型实体类
        */
        public static RegionsInfoCollection GetListPagerByRegionid(DataProvider dp, int Regionid,  String OrderBy, int pageIndex, int pageSize)
        {
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByRegionid(Regionid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regionid 城市编号
        * @return 数据总量
        */
        public static int GetListPagerByRegionid(DataProvider dp, int Regionid, String OrderBy)
        {
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByRegionid(Regionid,  OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetRegionsInfoByRegiondatabaseid
        // [start] GetRegionsInfoByRegiondatabaseid
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 获取表t_regions 郑州市地区表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regiondatabaseid RegiondatabaseID
        * @return RegionsInfo对象实体
        */
        public static RegionsInfo GetRegionsInfoByRegiondatabaseid(int Regiondatabaseid)
        {
            return new RegionsDAL().GetRegionsInfoByRegiondatabaseid(Regiondatabaseid);
        }
        // [end]
        // [start] GetRegionsInfoByRegiondatabaseid
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 获取表t_regions 郑州市地区表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regiondatabaseid RegiondatabaseID
        * @return RegionsInfo对象实体
        */
        public static RegionsInfo GetRegionsInfoByRegiondatabaseid(DataProvider dp, int Regiondatabaseid)
        {
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetRegionsInfoByRegiondatabaseid(Regiondatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_regions 郑州市地区表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param objRegionsInfo RegionsInfo对象 郑州市地区表
        */
  public static boolean Insert(RegionsInfo objRegionsInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objRegionsInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_regions 郑州市地区表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param objRegionsInfo RegionsInfo对象 郑州市地区表
        */
  public static boolean Insert(DataProvider dp, RegionsInfo objRegionsInfo)
	{
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objRegionsInfo);
      setRegionsStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_regions", "添加", objRegionsInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByRegiondatabaseid
        // [start] UpdateByRegiondatabaseid
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 更新表t_regions 郑州市地区表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param objRegionsInfo RegionsInfo对象 郑州市地区表
        */
  public static boolean UpdateByRegiondatabaseid(RegionsInfo objRegionsInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByRegiondatabaseid(dp, objRegionsInfo);
	}

	// [end]
        // [start] UpdateByRegiondatabaseid
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 更新表t_regions 郑州市地区表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param objRegionsInfo RegionsInfo对象 郑州市地区表
        */
  public static boolean UpdateByRegiondatabaseid(DataProvider dp, RegionsInfo objRegionsInfo)
	{
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Regiondatabaseid =  objRegionsInfo.getRegiondatabaseid();//RegiondatabaseID  数据类型:int
      RegionsInfo objOld =  dal.GetRegionsInfoByRegiondatabaseid(Regiondatabaseid);// 读取实体信息
		dal.UpdateByRegiondatabaseid(objRegionsInfo);
		setRegionsStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objRegionsInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objRegionsInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_regions", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByRegiondatabaseid
        // [start] DeleteByRegiondatabaseid
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 删除数据表t_regions 郑州市地区表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regiondatabaseid RegiondatabaseID
        */
	public static boolean DeleteByRegiondatabaseid(int Regiondatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByRegiondatabaseid(dp, Regiondatabaseid);
	}

	// [end]
        // [start] DeleteByRegiondatabaseid
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 删除数据表t_regions 郑州市地区表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:25
        *
        * @param Regiondatabaseid RegiondatabaseID
        */
	public static boolean DeleteByRegiondatabaseid(DataProvider dp, int Regiondatabaseid)
	{
		RegionsDAL dal = new RegionsDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      RegionsInfo objOld =  dal.GetRegionsInfoByRegiondatabaseid(Regiondatabaseid);// 读取实体信息
		dal.DeleteByRegiondatabaseid(Regiondatabaseid);
		setRegionsStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_regions", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}