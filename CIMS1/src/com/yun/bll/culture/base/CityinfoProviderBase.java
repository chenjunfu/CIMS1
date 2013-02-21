/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:28:16
   功能说明: 表t_cityinfo 城市的业务类CityinfoInfo的业务层基类
   表说明:城市
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Cityinfo 城市 的实体CityinfoInfo的数据操作类
 *
 */
public class CityinfoProviderBase
{
	// [start] 设置和获取静态属性列表 CityinfoStatic, 默认值:null
	// 设置和获取静态属性列表 CityinfoStatic, 默认值:null 开始
	private static CityinfoInfoCollection cityinfoStatic = null;
	/**
	* 获取 静态属性列表 CityinfoStatic, 默认值:null
	 *
	 * @return 静态属性列表 CityinfoStatic, 默认值:null
	 */
	public static CityinfoInfoCollection getCityinfoStatic()
	{
		if (cityinfoStatic == null)
		  cityinfoStatic = new CityinfoDAL().GetListBy();
		return cityinfoStatic;
	}
	/**
	 * 设置 静态属性列表 CityinfoStatic, 默认值:null
	 *
	 * @param sCityinfoStatic
	 *            静态属性列表 CityinfoStatic, 默认值:null
	 */
	public static void setCityinfoStatic(CityinfoInfoCollection sCityinfoStatic)
	{
		cityinfoStatic = sCityinfoStatic;
		setCityinfoInfoStaticByCityid (null);
	}
	// 设置和获取静态属性列表 CityinfoStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.CityinfoInfo objCityinfoInfo : getCityinfoStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objCityinfoInfo.getCityid(), objCityinfoInfo.getCityname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetCityinfoInfoStaticByCityid
	// [start] 设置和获取静态属性列表 CityinfoInfoStaticByCityid, 默认值:null
	// 设置和获取静态属性列表 CityinfoInfoStaticByCityid, 默认值:null 开始
	private static CityinfoInfoCollection CityinfoInfoStaticByCityid = null;
	/**
	* 获取 静态属性列表 CityinfoInfoStaticByCityid, 默认值:null
	 *
	 * @return 静态属性列表 CityinfoInfoStaticByCityid, 默认值:null
	 */
	public static CityinfoInfoCollection getCityinfoInfoStaticByCityid()
	{
		return CityinfoInfoStaticByCityid;
	}
	/**
	 * 设置 静态属性列表 CityinfoInfoStaticByCityid, 默认值:null
	 *
	 * @param sCityinfoInfoStaticByCityid
	 *            静态属性列表 CityinfoInfoStaticByCityid, 默认值:null
	 */
	public static void setCityinfoInfoStaticByCityid(CityinfoInfoCollection sCityinfoInfoStaticByCityid)
	{
		CityinfoInfoStaticByCityid = sCityinfoInfoStaticByCityid;
	}
	// 设置和获取静态属性列表 CityinfoInfoStaticByCityid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 获取表t_cityinfo 城市的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @param Cityid 城市id
        * @return CityinfoInfo对象实体
        */
        public static CityinfoInfo GetCityinfoInfoStaticByCityid(int Cityid)
        {
            if (CityinfoInfoStaticByCityid == null)
                CityinfoInfoStaticByCityid = new CityinfoInfoCollection();
            int allcount = CityinfoInfoStaticByCityid.size();
            CityinfoInfo objCityinfoInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (CityinfoInfoStaticByCityid == null)
                    break;
                    objCityinfoInfo = CityinfoInfoStaticByCityid.get(i);
                if (objCityinfoInfo == null)
                    break;
                if (objCityinfoInfo.getCityid() == Cityid)
                {
                    return objCityinfoInfo;
                }
            }
            CityinfoInfo obj= new CityinfoDAL().GetCityinfoInfoByCityid(Cityid);

            if (obj != null)
            {
                if (CityinfoInfoStaticByCityid != null)
                    CityinfoInfoStaticByCityid.add(obj);
                return obj;
            }
            else
            {
                return new CityinfoInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByCityid
        // [start] CountByCityid
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 统计表t_cityinfo 城市的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @param Cityid 城市id
        * @return 数据量
        */
        public static int CountByCityid(int Cityid)
        {
            return new CityinfoDAL().CountByCityid(Cityid);
        }
        // [end]
        // [start] CountByCityid
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 统计表t_cityinfo 城市的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @param Cityid 城市id
        * @return 数据量
        */
        public static int CountByCityid(DataProvider dp, int Cityid)
        {
		CityinfoDAL dal = new CityinfoDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByCityid(Cityid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_cityinfo 城市的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new CityinfoDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_cityinfo 城市的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		CityinfoDAL dal = new CityinfoDAL();
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
 返回表t_cityinfo 城市的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @return 数据列表的强类型实体类
        */
        public static CityinfoInfoCollection GetListBy()
        {
            return new CityinfoDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_cityinfo 城市的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @return 数据列表的强类型实体类
        */
        public static CityinfoInfoCollection GetListBy(DataProvider dp )
        {
		CityinfoDAL dal = new CityinfoDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_cityinfo 城市的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @return 数据列表的强类型实体类
        */
        public static CityinfoInfoCollection GetListBy(String OrderBy)
        {
            return new CityinfoDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_cityinfo 城市的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @return 数据列表的强类型实体类
        */
        public static CityinfoInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		CityinfoDAL dal = new CityinfoDAL();
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
 返回表t_cityinfo 城市的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @return 数据列表的强类型实体类
        */
        public static CityinfoInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new CityinfoDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_cityinfo 城市的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new CityinfoDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_cityinfo 城市的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @return 数据列表的强类型实体类
        */
        public static CityinfoInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new CityinfoDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_cityinfo 城市的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new CityinfoDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_cityinfo 城市的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @return 数据列表的强类型实体类
        */
        public static CityinfoInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		CityinfoDAL dal = new CityinfoDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_cityinfo 城市的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		CityinfoDAL dal = new CityinfoDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_cityinfo 城市的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @return 数据列表的强类型实体类
        */
        public static CityinfoInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		CityinfoDAL dal = new CityinfoDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_cityinfo 城市的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		CityinfoDAL dal = new CityinfoDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetCityinfoInfoByCityid
        // [start] GetCityinfoInfoByCityid
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 获取表t_cityinfo 城市的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @param Cityid 城市id
        * @return CityinfoInfo对象实体
        */
        public static CityinfoInfo GetCityinfoInfoByCityid(int Cityid)
        {
            return new CityinfoDAL().GetCityinfoInfoByCityid(Cityid);
        }
        // [end]
        // [start] GetCityinfoInfoByCityid
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 获取表t_cityinfo 城市的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @param Cityid 城市id
        * @return CityinfoInfo对象实体
        */
        public static CityinfoInfo GetCityinfoInfoByCityid(DataProvider dp, int Cityid)
        {
		CityinfoDAL dal = new CityinfoDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetCityinfoInfoByCityid(Cityid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_cityinfo 城市中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @param objCityinfoInfo CityinfoInfo对象 城市
        */
  public static boolean Insert(CityinfoInfo objCityinfoInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objCityinfoInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_cityinfo 城市中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @param objCityinfoInfo CityinfoInfo对象 城市
        */
  public static boolean Insert(DataProvider dp, CityinfoInfo objCityinfoInfo)
	{
		CityinfoDAL dal = new CityinfoDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objCityinfoInfo);
      setCityinfoStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_cityinfo", "添加", objCityinfoInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByCityid
        // [start] UpdateByCityid
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 更新表t_cityinfo 城市中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @param objCityinfoInfo CityinfoInfo对象 城市
        */
  public static boolean UpdateByCityid(CityinfoInfo objCityinfoInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByCityid(dp, objCityinfoInfo);
	}

	// [end]
        // [start] UpdateByCityid
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 更新表t_cityinfo 城市中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @param objCityinfoInfo CityinfoInfo对象 城市
        */
  public static boolean UpdateByCityid(DataProvider dp, CityinfoInfo objCityinfoInfo)
	{
		CityinfoDAL dal = new CityinfoDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Cityid =  objCityinfoInfo.getCityid();//城市id  数据类型:int
      CityinfoInfo objOld =  dal.GetCityinfoInfoByCityid(Cityid);// 读取实体信息
		dal.UpdateByCityid(objCityinfoInfo);
		setCityinfoStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objCityinfoInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objCityinfoInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_cityinfo", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByCityid
        // [start] DeleteByCityid
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 删除数据表t_cityinfo 城市中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @param Cityid 城市id
        */
	public static boolean DeleteByCityid(int Cityid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByCityid(dp, Cityid);
	}

	// [end]
        // [start] DeleteByCityid
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 删除数据表t_cityinfo 城市中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:16
        *
        * @param Cityid 城市id
        */
	public static boolean DeleteByCityid(DataProvider dp, int Cityid)
	{
		CityinfoDAL dal = new CityinfoDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      CityinfoInfo objOld =  dal.GetCityinfoInfoByCityid(Cityid);// 读取实体信息
		dal.DeleteByCityid(Cityid);
		setCityinfoStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_cityinfo", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}