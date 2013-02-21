/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:33:12
   功能说明: 表t_tupi 的业务类TupiInfo的业务层基类
   表说明:
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Tupi  的实体TupiInfo的数据操作类
 *
 */
public class TupiProviderBase
{
	// [start] 设置和获取静态属性列表 TupiStatic, 默认值:null
	// 设置和获取静态属性列表 TupiStatic, 默认值:null 开始
	private static TupiInfoCollection tupiStatic = null;
	/**
	* 获取 静态属性列表 TupiStatic, 默认值:null
	 *
	 * @return 静态属性列表 TupiStatic, 默认值:null
	 */
	public static TupiInfoCollection getTupiStatic()
	{
		if (tupiStatic == null)
		  tupiStatic = new TupiDAL().GetListBy();
		return tupiStatic;
	}
	/**
	 * 设置 静态属性列表 TupiStatic, 默认值:null
	 *
	 * @param sTupiStatic
	 *            静态属性列表 TupiStatic, 默认值:null
	 */
	public static void setTupiStatic(TupiInfoCollection sTupiStatic)
	{
		tupiStatic = sTupiStatic;
		setTupiInfoStaticByTupidatabaseid (null);
	}
	// 设置和获取静态属性列表 TupiStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.TupiInfo objTupiInfo : getTupiStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objTupiInfo.getTupidatabaseid(), objTupiInfo.getTupiname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetTupiInfoStaticByTupidatabaseid
	// [start] 设置和获取静态属性列表 TupiInfoStaticByTupidatabaseid, 默认值:null
	// 设置和获取静态属性列表 TupiInfoStaticByTupidatabaseid, 默认值:null 开始
	private static TupiInfoCollection TupiInfoStaticByTupidatabaseid = null;
	/**
	* 获取 静态属性列表 TupiInfoStaticByTupidatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 TupiInfoStaticByTupidatabaseid, 默认值:null
	 */
	public static TupiInfoCollection getTupiInfoStaticByTupidatabaseid()
	{
		return TupiInfoStaticByTupidatabaseid;
	}
	/**
	 * 设置 静态属性列表 TupiInfoStaticByTupidatabaseid, 默认值:null
	 *
	 * @param sTupiInfoStaticByTupidatabaseid
	 *            静态属性列表 TupiInfoStaticByTupidatabaseid, 默认值:null
	 */
	public static void setTupiInfoStaticByTupidatabaseid(TupiInfoCollection sTupiInfoStaticByTupidatabaseid)
	{
		TupiInfoStaticByTupidatabaseid = sTupiInfoStaticByTupidatabaseid;
	}
	// 设置和获取静态属性列表 TupiInfoStaticByTupidatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 获取表t_tupi 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupidatabaseid 数据库ID
        * @return TupiInfo对象实体
        */
        public static TupiInfo GetTupiInfoStaticByTupidatabaseid(int Tupidatabaseid)
        {
            if (TupiInfoStaticByTupidatabaseid == null)
                TupiInfoStaticByTupidatabaseid = new TupiInfoCollection();
            int allcount = TupiInfoStaticByTupidatabaseid.size();
            TupiInfo objTupiInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (TupiInfoStaticByTupidatabaseid == null)
                    break;
                    objTupiInfo = TupiInfoStaticByTupidatabaseid.get(i);
                if (objTupiInfo == null)
                    break;
                if (objTupiInfo.getTupidatabaseid() == Tupidatabaseid)
                {
                    return objTupiInfo;
                }
            }
            TupiInfo obj= new TupiDAL().GetTupiInfoByTupidatabaseid(Tupidatabaseid);

            if (obj != null)
            {
                if (TupiInfoStaticByTupidatabaseid != null)
                    TupiInfoStaticByTupidatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new TupiInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByTupidatabaseid
        // [start] CountByTupidatabaseid
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupidatabaseid 数据库ID
        * @return 数据量
        */
        public static int CountByTupidatabaseid(int Tupidatabaseid)
        {
            return new TupiDAL().CountByTupidatabaseid(Tupidatabaseid);
        }
        // [end]
        // [start] CountByTupidatabaseid
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupidatabaseid 数据库ID
        * @return 数据量
        */
        public static int CountByTupidatabaseid(DataProvider dp, int Tupidatabaseid)
        {
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByTupidatabaseid(Tupidatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new TupiDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]
        // [start] CountByTupiid
        // [start] CountByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupiid 土地批准ID
        * @return 数据量
        */
        public static int CountByTupiid(int Tupiid)
        {
            return new TupiDAL().CountByTupiid(Tupiid);
        }
        // [end]
        // [start] CountByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupiid 土地批准ID
        * @return 数据量
        */
        public static int CountByTupiid(DataProvider dp, int Tupiid)
        {
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByTupiid(Tupiid);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @return 数据列表的强类型实体类
        */
        public static TupiInfoCollection GetListBy()
        {
            return new TupiDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @return 数据列表的强类型实体类
        */
        public static TupiInfoCollection GetListBy(DataProvider dp )
        {
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @return 数据列表的强类型实体类
        */
        public static TupiInfoCollection GetListBy(String OrderBy)
        {
            return new TupiDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @return 数据列表的强类型实体类
        */
        public static TupiInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListByTupiid
        // [start] GetListByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupiid 土地批准ID
        * @return 数据列表的强类型实体类
        */
        public static TupiInfoCollection GetListByTupiid(int Tupiid)
        {
            return new TupiDAL().GetListByTupiid(Tupiid);
        }
        // [end]
        // [start] GetListByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupiid 土地批准ID
        * @return 数据列表的强类型实体类
        */
        public static TupiInfoCollection GetListByTupiid(DataProvider dp, int Tupiid)
        {
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByTupiid(Tupiid);
        }
        // [end]
        // [start] GetListByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupiid 土地批准ID
        * @return 数据列表的强类型实体类
        */
        public static TupiInfoCollection GetListByTupiid(int Tupiid, String OrderBy)
        {
            return new TupiDAL().GetListByTupiid(Tupiid, OrderBy);
        }
        // [end]
        // [start] GetListByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupiid 土地批准ID
        * @return 数据列表的强类型实体类
        */
        public static TupiInfoCollection GetListByTupiid(DataProvider dp, int Tupiid, String OrderBy)
        {
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByTupiid(Tupiid, OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @return 数据列表的强类型实体类
        */
        public static TupiInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new TupiDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new TupiDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @return 数据列表的强类型实体类
        */
        public static TupiInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new TupiDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new TupiDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @return 数据列表的强类型实体类
        */
        public static TupiInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @return 数据列表的强类型实体类
        */
        public static TupiInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListPagerByTupiid
        // [start] GetListPagerByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupiid 土地批准ID
        * @return 数据列表的强类型实体类
        */
        public static TupiInfoCollection GetListPagerByTupiid(int Tupiid, int pageIndex, int pageSize)
        {
            return new TupiDAL().GetListPagerByTupiid(Tupiid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupiid 土地批准ID
        * @return 数据总量
        */
        public static int GetListPagerByTupiid(int Tupiid)
        {
            return new TupiDAL().GetListPagerByTupiid(Tupiid);
        }
        // [end]
        // [start] GetListPagerByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupiid 土地批准ID
        * @return 数据列表的强类型实体类
        */
        public static TupiInfoCollection GetListPagerByTupiid(int Tupiid,  String OrderBy, int pageIndex, int pageSize)
        {
            return new TupiDAL().GetListPagerByTupiid(Tupiid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupiid 土地批准ID
        * @return 数据总量
        */
        public static int GetListPagerByTupiid(int Tupiid, String OrderBy)
        {
            return new TupiDAL().GetListPagerByTupiid(Tupiid,  OrderBy);
        }
        // [end]
        // [start] GetListPagerByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupiid 土地批准ID
        * @return 数据列表的强类型实体类
        */
        public static TupiInfoCollection GetListPagerByTupiid(DataProvider dp,int Tupiid, int pageIndex, int pageSize)
        {
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByTupiid(Tupiid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupiid 土地批准ID
        * @return 数据总量
        */
        public static int GetListPagerByTupiid(DataProvider dp, int Tupiid)
        {
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByTupiid(Tupiid);
        }
        // [end]
        // [start] GetListPagerByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupiid 土地批准ID
        * @return 数据列表的强类型实体类
        */
        public static TupiInfoCollection GetListPagerByTupiid(DataProvider dp, int Tupiid,  String OrderBy, int pageIndex, int pageSize)
        {
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByTupiid(Tupiid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupiid 土地批准ID
        * @return 数据总量
        */
        public static int GetListPagerByTupiid(DataProvider dp, int Tupiid, String OrderBy)
        {
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByTupiid(Tupiid,  OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetTupiInfoByTupidatabaseid
        // [start] GetTupiInfoByTupidatabaseid
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 获取表t_tupi 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupidatabaseid 数据库ID
        * @return TupiInfo对象实体
        */
        public static TupiInfo GetTupiInfoByTupidatabaseid(int Tupidatabaseid)
        {
            return new TupiDAL().GetTupiInfoByTupidatabaseid(Tupidatabaseid);
        }
        // [end]
        // [start] GetTupiInfoByTupidatabaseid
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 获取表t_tupi 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupidatabaseid 数据库ID
        * @return TupiInfo对象实体
        */
        public static TupiInfo GetTupiInfoByTupidatabaseid(DataProvider dp, int Tupidatabaseid)
        {
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetTupiInfoByTupidatabaseid(Tupidatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_tupi 中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param objTupiInfo TupiInfo对象 
        */
  public static boolean Insert(TupiInfo objTupiInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objTupiInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_tupi 中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param objTupiInfo TupiInfo对象 
        */
  public static boolean Insert(DataProvider dp, TupiInfo objTupiInfo)
	{
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objTupiInfo);
      setTupiStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_tupi", "添加", objTupiInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByTupidatabaseid
        // [start] UpdateByTupidatabaseid
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 更新表t_tupi 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param objTupiInfo TupiInfo对象 
        */
  public static boolean UpdateByTupidatabaseid(TupiInfo objTupiInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByTupidatabaseid(dp, objTupiInfo);
	}

	// [end]
        // [start] UpdateByTupidatabaseid
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 更新表t_tupi 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param objTupiInfo TupiInfo对象 
        */
  public static boolean UpdateByTupidatabaseid(DataProvider dp, TupiInfo objTupiInfo)
	{
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Tupidatabaseid =  objTupiInfo.getTupidatabaseid();//数据库ID  数据类型:int
      TupiInfo objOld =  dal.GetTupiInfoByTupidatabaseid(Tupidatabaseid);// 读取实体信息
		dal.UpdateByTupidatabaseid(objTupiInfo);
		setTupiStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objTupiInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objTupiInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_tupi", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByTupidatabaseid
        // [start] DeleteByTupidatabaseid
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 删除数据表t_tupi 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupidatabaseid 数据库ID
        */
	public static boolean DeleteByTupidatabaseid(int Tupidatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByTupidatabaseid(dp, Tupidatabaseid);
	}

	// [end]
        // [start] DeleteByTupidatabaseid
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 删除数据表t_tupi 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:33:12
        *
        * @param Tupidatabaseid 数据库ID
        */
	public static boolean DeleteByTupidatabaseid(DataProvider dp, int Tupidatabaseid)
	{
		TupiDAL dal = new TupiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      TupiInfo objOld =  dal.GetTupiInfoByTupidatabaseid(Tupidatabaseid);// 读取实体信息
		dal.DeleteByTupidatabaseid(Tupidatabaseid);
		setTupiStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_tupi", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}