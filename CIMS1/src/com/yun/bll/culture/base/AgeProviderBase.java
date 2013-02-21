/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:28:04
   功能说明: 表t_age 年龄段表的业务类AgeInfo的业务层基类
   表说明:年龄段表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Age 年龄段表 的实体AgeInfo的数据操作类
 *
 */
public class AgeProviderBase
{
	// [start] 设置和获取静态属性列表 AgeStatic, 默认值:null
	// 设置和获取静态属性列表 AgeStatic, 默认值:null 开始
	private static AgeInfoCollection ageStatic = null;
	/**
	* 获取 静态属性列表 AgeStatic, 默认值:null
	 *
	 * @return 静态属性列表 AgeStatic, 默认值:null
	 */
	public static AgeInfoCollection getAgeStatic()
	{
		if (ageStatic == null)
		  ageStatic = new AgeDAL().GetListBy();
		return ageStatic;
	}
	/**
	 * 设置 静态属性列表 AgeStatic, 默认值:null
	 *
	 * @param sAgeStatic
	 *            静态属性列表 AgeStatic, 默认值:null
	 */
	public static void setAgeStatic(AgeInfoCollection sAgeStatic)
	{
		ageStatic = sAgeStatic;
		setAgeInfoStaticByAgedatabaseid (null);
	}
	// 设置和获取静态属性列表 AgeStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.AgeInfo objAgeInfo : getAgeStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objAgeInfo.getAgedatabaseid(), objAgeInfo.getAgename()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetAgeInfoStaticByAgedatabaseid
	// [start] 设置和获取静态属性列表 AgeInfoStaticByAgedatabaseid, 默认值:null
	// 设置和获取静态属性列表 AgeInfoStaticByAgedatabaseid, 默认值:null 开始
	private static AgeInfoCollection AgeInfoStaticByAgedatabaseid = null;
	/**
	* 获取 静态属性列表 AgeInfoStaticByAgedatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 AgeInfoStaticByAgedatabaseid, 默认值:null
	 */
	public static AgeInfoCollection getAgeInfoStaticByAgedatabaseid()
	{
		return AgeInfoStaticByAgedatabaseid;
	}
	/**
	 * 设置 静态属性列表 AgeInfoStaticByAgedatabaseid, 默认值:null
	 *
	 * @param sAgeInfoStaticByAgedatabaseid
	 *            静态属性列表 AgeInfoStaticByAgedatabaseid, 默认值:null
	 */
	public static void setAgeInfoStaticByAgedatabaseid(AgeInfoCollection sAgeInfoStaticByAgedatabaseid)
	{
		AgeInfoStaticByAgedatabaseid = sAgeInfoStaticByAgedatabaseid;
	}
	// 设置和获取静态属性列表 AgeInfoStaticByAgedatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 获取表t_age 年龄段表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Agedatabaseid AgedatabaseID
        * @return AgeInfo对象实体
        */
        public static AgeInfo GetAgeInfoStaticByAgedatabaseid(int Agedatabaseid)
        {
            if (AgeInfoStaticByAgedatabaseid == null)
                AgeInfoStaticByAgedatabaseid = new AgeInfoCollection();
            int allcount = AgeInfoStaticByAgedatabaseid.size();
            AgeInfo objAgeInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (AgeInfoStaticByAgedatabaseid == null)
                    break;
                    objAgeInfo = AgeInfoStaticByAgedatabaseid.get(i);
                if (objAgeInfo == null)
                    break;
                if (objAgeInfo.getAgedatabaseid() == Agedatabaseid)
                {
                    return objAgeInfo;
                }
            }
            AgeInfo obj= new AgeDAL().GetAgeInfoByAgedatabaseid(Agedatabaseid);

            if (obj != null)
            {
                if (AgeInfoStaticByAgedatabaseid != null)
                    AgeInfoStaticByAgedatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new AgeInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByAgedatabaseid
        // [start] CountByAgedatabaseid
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Agedatabaseid AgedatabaseID
        * @return 数据量
        */
        public static int CountByAgedatabaseid(int Agedatabaseid)
        {
            return new AgeDAL().CountByAgedatabaseid(Agedatabaseid);
        }
        // [end]
        // [start] CountByAgedatabaseid
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Agedatabaseid AgedatabaseID
        * @return 数据量
        */
        public static int CountByAgedatabaseid(DataProvider dp, int Agedatabaseid)
        {
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByAgedatabaseid(Agedatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new AgeDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]
        // [start] CountByAgeid
        // [start] CountByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Ageid 年龄段编号
        * @return 数据量
        */
        public static int CountByAgeid(int Ageid)
        {
            return new AgeDAL().CountByAgeid(Ageid);
        }
        // [end]
        // [start] CountByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Ageid 年龄段编号
        * @return 数据量
        */
        public static int CountByAgeid(DataProvider dp, int Ageid)
        {
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByAgeid(Ageid);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @return 数据列表的强类型实体类
        */
        public static AgeInfoCollection GetListBy()
        {
            return new AgeDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @return 数据列表的强类型实体类
        */
        public static AgeInfoCollection GetListBy(DataProvider dp )
        {
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @return 数据列表的强类型实体类
        */
        public static AgeInfoCollection GetListBy(String OrderBy)
        {
            return new AgeDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @return 数据列表的强类型实体类
        */
        public static AgeInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListByAgeid
        // [start] GetListByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Ageid 年龄段编号
        * @return 数据列表的强类型实体类
        */
        public static AgeInfoCollection GetListByAgeid(int Ageid)
        {
            return new AgeDAL().GetListByAgeid(Ageid);
        }
        // [end]
        // [start] GetListByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Ageid 年龄段编号
        * @return 数据列表的强类型实体类
        */
        public static AgeInfoCollection GetListByAgeid(DataProvider dp, int Ageid)
        {
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByAgeid(Ageid);
        }
        // [end]
        // [start] GetListByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Ageid 年龄段编号
        * @return 数据列表的强类型实体类
        */
        public static AgeInfoCollection GetListByAgeid(int Ageid, String OrderBy)
        {
            return new AgeDAL().GetListByAgeid(Ageid, OrderBy);
        }
        // [end]
        // [start] GetListByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Ageid 年龄段编号
        * @return 数据列表的强类型实体类
        */
        public static AgeInfoCollection GetListByAgeid(DataProvider dp, int Ageid, String OrderBy)
        {
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByAgeid(Ageid, OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @return 数据列表的强类型实体类
        */
        public static AgeInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new AgeDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new AgeDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @return 数据列表的强类型实体类
        */
        public static AgeInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new AgeDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new AgeDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @return 数据列表的强类型实体类
        */
        public static AgeInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @return 数据列表的强类型实体类
        */
        public static AgeInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListPagerByAgeid
        // [start] GetListPagerByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Ageid 年龄段编号
        * @return 数据列表的强类型实体类
        */
        public static AgeInfoCollection GetListPagerByAgeid(int Ageid, int pageIndex, int pageSize)
        {
            return new AgeDAL().GetListPagerByAgeid(Ageid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Ageid 年龄段编号
        * @return 数据总量
        */
        public static int GetListPagerByAgeid(int Ageid)
        {
            return new AgeDAL().GetListPagerByAgeid(Ageid);
        }
        // [end]
        // [start] GetListPagerByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Ageid 年龄段编号
        * @return 数据列表的强类型实体类
        */
        public static AgeInfoCollection GetListPagerByAgeid(int Ageid,  String OrderBy, int pageIndex, int pageSize)
        {
            return new AgeDAL().GetListPagerByAgeid(Ageid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Ageid 年龄段编号
        * @return 数据总量
        */
        public static int GetListPagerByAgeid(int Ageid, String OrderBy)
        {
            return new AgeDAL().GetListPagerByAgeid(Ageid,  OrderBy);
        }
        // [end]
        // [start] GetListPagerByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Ageid 年龄段编号
        * @return 数据列表的强类型实体类
        */
        public static AgeInfoCollection GetListPagerByAgeid(DataProvider dp,int Ageid, int pageIndex, int pageSize)
        {
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByAgeid(Ageid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Ageid 年龄段编号
        * @return 数据总量
        */
        public static int GetListPagerByAgeid(DataProvider dp, int Ageid)
        {
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByAgeid(Ageid);
        }
        // [end]
        // [start] GetListPagerByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Ageid 年龄段编号
        * @return 数据列表的强类型实体类
        */
        public static AgeInfoCollection GetListPagerByAgeid(DataProvider dp, int Ageid,  String OrderBy, int pageIndex, int pageSize)
        {
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByAgeid(Ageid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Ageid 年龄段编号
        * @return 数据总量
        */
        public static int GetListPagerByAgeid(DataProvider dp, int Ageid, String OrderBy)
        {
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByAgeid(Ageid,  OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetAgeInfoByAgedatabaseid
        // [start] GetAgeInfoByAgedatabaseid
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 获取表t_age 年龄段表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Agedatabaseid AgedatabaseID
        * @return AgeInfo对象实体
        */
        public static AgeInfo GetAgeInfoByAgedatabaseid(int Agedatabaseid)
        {
            return new AgeDAL().GetAgeInfoByAgedatabaseid(Agedatabaseid);
        }
        // [end]
        // [start] GetAgeInfoByAgedatabaseid
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 获取表t_age 年龄段表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Agedatabaseid AgedatabaseID
        * @return AgeInfo对象实体
        */
        public static AgeInfo GetAgeInfoByAgedatabaseid(DataProvider dp, int Agedatabaseid)
        {
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetAgeInfoByAgedatabaseid(Agedatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_age 年龄段表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param objAgeInfo AgeInfo对象 年龄段表
        */
  public static boolean Insert(AgeInfo objAgeInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objAgeInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_age 年龄段表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param objAgeInfo AgeInfo对象 年龄段表
        */
  public static boolean Insert(DataProvider dp, AgeInfo objAgeInfo)
	{
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objAgeInfo);
      setAgeStatic(null);
		
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByAgedatabaseid
        // [start] UpdateByAgedatabaseid
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 更新表t_age 年龄段表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param objAgeInfo AgeInfo对象 年龄段表
        */
  public static boolean UpdateByAgedatabaseid(AgeInfo objAgeInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByAgedatabaseid(dp, objAgeInfo);
	}

	// [end]
        // [start] UpdateByAgedatabaseid
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 更新表t_age 年龄段表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param objAgeInfo AgeInfo对象 年龄段表
        */
  public static boolean UpdateByAgedatabaseid(DataProvider dp, AgeInfo objAgeInfo)
	{
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Agedatabaseid =  objAgeInfo.getAgedatabaseid();//AgedatabaseID  数据类型:int
      AgeInfo objOld =  dal.GetAgeInfoByAgedatabaseid(Agedatabaseid);// 读取实体信息
		dal.UpdateByAgedatabaseid(objAgeInfo);
		setAgeStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objAgeInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objAgeInfo.ToModifyString(objOld));
	
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByAgedatabaseid
        // [start] DeleteByAgedatabaseid
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 删除数据表t_age 年龄段表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Agedatabaseid AgedatabaseID
        */
	public static boolean DeleteByAgedatabaseid(int Agedatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByAgedatabaseid(dp, Agedatabaseid);
	}

	// [end]
        // [start] DeleteByAgedatabaseid
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 删除数据表t_age 年龄段表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:04
        *
        * @param Agedatabaseid AgedatabaseID
        */
	public static boolean DeleteByAgedatabaseid(DataProvider dp, int Agedatabaseid)
	{
		AgeDAL dal = new AgeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      AgeInfo objOld =  dal.GetAgeInfoByAgedatabaseid(Agedatabaseid);// 读取实体信息
		dal.DeleteByAgedatabaseid(Agedatabaseid);
		setAgeStatic(null);
		
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}