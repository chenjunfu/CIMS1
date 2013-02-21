/*======================================================================
   开发者:贾军磊
   创建日期:2013年01月22日 13:52:53
   功能说明: 表t_enterprise 企业信息表的业务类EnterpriseInfo的业务层基类
   表说明:企业信息表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Enterprise 企业信息表 的实体EnterpriseInfo的数据操作类
 *
 */
public class EnterpriseProviderBase
{
	// [start] 设置和获取静态属性列表 EnterpriseStatic, 默认值:null
	// 设置和获取静态属性列表 EnterpriseStatic, 默认值:null 开始
	private static EnterpriseInfoCollection enterpriseStatic = null;
	/**
	* 获取 静态属性列表 EnterpriseStatic, 默认值:null
	 *
	 * @return 静态属性列表 EnterpriseStatic, 默认值:null
	 */
	public static EnterpriseInfoCollection getEnterpriseStatic()
	{
		if (enterpriseStatic == null)
		  enterpriseStatic = new EnterpriseDAL().GetListBy();
		return enterpriseStatic;
	}
	/**
	 * 设置 静态属性列表 EnterpriseStatic, 默认值:null
	 *
	 * @param sEnterpriseStatic
	 *            静态属性列表 EnterpriseStatic, 默认值:null
	 */
	public static void setEnterpriseStatic(EnterpriseInfoCollection sEnterpriseStatic)
	{
		enterpriseStatic = sEnterpriseStatic;
		setEnterpriseInfoStaticByDatabaseenterpriseid (null);
	}
	// 设置和获取静态属性列表 EnterpriseStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.EnterpriseInfo objEnterpriseInfo : getEnterpriseStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objEnterpriseInfo.getDatabaseenterpriseid(), objEnterpriseInfo.getEnterprisename()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetEnterpriseInfoStaticByDatabaseenterpriseid
	// [start] 设置和获取静态属性列表 EnterpriseInfoStaticByDatabaseenterpriseid, 默认值:null
	// 设置和获取静态属性列表 EnterpriseInfoStaticByDatabaseenterpriseid, 默认值:null 开始
	private static EnterpriseInfoCollection EnterpriseInfoStaticByDatabaseenterpriseid = null;
	/**
	* 获取 静态属性列表 EnterpriseInfoStaticByDatabaseenterpriseid, 默认值:null
	 *
	 * @return 静态属性列表 EnterpriseInfoStaticByDatabaseenterpriseid, 默认值:null
	 */
	public static EnterpriseInfoCollection getEnterpriseInfoStaticByDatabaseenterpriseid()
	{
		return EnterpriseInfoStaticByDatabaseenterpriseid;
	}
	/**
	 * 设置 静态属性列表 EnterpriseInfoStaticByDatabaseenterpriseid, 默认值:null
	 *
	 * @param sEnterpriseInfoStaticByDatabaseenterpriseid
	 *            静态属性列表 EnterpriseInfoStaticByDatabaseenterpriseid, 默认值:null
	 */
	public static void setEnterpriseInfoStaticByDatabaseenterpriseid(EnterpriseInfoCollection sEnterpriseInfoStaticByDatabaseenterpriseid)
	{
		EnterpriseInfoStaticByDatabaseenterpriseid = sEnterpriseInfoStaticByDatabaseenterpriseid;
	}
	// 设置和获取静态属性列表 EnterpriseInfoStaticByDatabaseenterpriseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 获取表t_enterprise 企业信息表的对象<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Databaseenterpriseid 企业ID
        * @return EnterpriseInfo对象实体
        */
        public static EnterpriseInfo GetEnterpriseInfoStaticByDatabaseenterpriseid(int Databaseenterpriseid)
        {
            if (EnterpriseInfoStaticByDatabaseenterpriseid == null)
                EnterpriseInfoStaticByDatabaseenterpriseid = new EnterpriseInfoCollection();
            int allcount = EnterpriseInfoStaticByDatabaseenterpriseid.size();
            EnterpriseInfo objEnterpriseInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (EnterpriseInfoStaticByDatabaseenterpriseid == null)
                    break;
                    objEnterpriseInfo = EnterpriseInfoStaticByDatabaseenterpriseid.get(i);
                if (objEnterpriseInfo == null)
                    break;
                if (objEnterpriseInfo.getDatabaseenterpriseid() == Databaseenterpriseid)
                {
                    return objEnterpriseInfo;
                }
            }
            EnterpriseInfo obj= new EnterpriseDAL().GetEnterpriseInfoByDatabaseenterpriseid(Databaseenterpriseid);

            if (obj != null)
            {
                if (EnterpriseInfoStaticByDatabaseenterpriseid != null)
                    EnterpriseInfoStaticByDatabaseenterpriseid.add(obj);
                return obj;
            }
            else
            {
                return new EnterpriseInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByDatabaseenterpriseid
        // [start] CountByDatabaseenterpriseid
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Databaseenterpriseid 企业ID
        * @return 数据量
        */
        public static int CountByDatabaseenterpriseid(int Databaseenterpriseid)
        {
            return new EnterpriseDAL().CountByDatabaseenterpriseid(Databaseenterpriseid);
        }
        // [end]
        // [start] CountByDatabaseenterpriseid
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Databaseenterpriseid 企业ID
        * @return 数据量
        */
        public static int CountByDatabaseenterpriseid(DataProvider dp, int Databaseenterpriseid)
        {
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByDatabaseenterpriseid(Databaseenterpriseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new EnterpriseDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]
        // [start] CountByEnterpriseid
        // [start] CountByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Enterpriseid 企业编号
        * @return 数据量
        */
        public static int CountByEnterpriseid(int Enterpriseid)
        {
            return new EnterpriseDAL().CountByEnterpriseid(Enterpriseid);
        }
        // [end]
        // [start] CountByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Enterpriseid 企业编号
        * @return 数据量
        */
        public static int CountByEnterpriseid(DataProvider dp, int Enterpriseid)
        {
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByEnterpriseid(Enterpriseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @return 数据列表的强类型实体类
        */
        public static EnterpriseInfoCollection GetListBy()
        {
            return new EnterpriseDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @return 数据列表的强类型实体类
        */
        public static EnterpriseInfoCollection GetListBy(DataProvider dp )
        {
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @return 数据列表的强类型实体类
        */
        public static EnterpriseInfoCollection GetListBy(String OrderBy)
        {
            return new EnterpriseDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @return 数据列表的强类型实体类
        */
        public static EnterpriseInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListByEnterpriseid
        // [start] GetListByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Enterpriseid 企业编号
        * @return 数据列表的强类型实体类
        */
        public static EnterpriseInfoCollection GetListByEnterpriseid(int Enterpriseid)
        {
            return new EnterpriseDAL().GetListByEnterpriseid(Enterpriseid);
        }
        // [end]
        // [start] GetListByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Enterpriseid 企业编号
        * @return 数据列表的强类型实体类
        */
        public static EnterpriseInfoCollection GetListByEnterpriseid(DataProvider dp, int Enterpriseid)
        {
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByEnterpriseid(Enterpriseid);
        }
        // [end]
        // [start] GetListByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Enterpriseid 企业编号
        * @return 数据列表的强类型实体类
        */
        public static EnterpriseInfoCollection GetListByEnterpriseid(int Enterpriseid, String OrderBy)
        {
            return new EnterpriseDAL().GetListByEnterpriseid(Enterpriseid, OrderBy);
        }
        // [end]
        // [start] GetListByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Enterpriseid 企业编号
        * @return 数据列表的强类型实体类
        */
        public static EnterpriseInfoCollection GetListByEnterpriseid(DataProvider dp, int Enterpriseid, String OrderBy)
        {
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByEnterpriseid(Enterpriseid, OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @return 数据列表的强类型实体类
        */
        public static EnterpriseInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new EnterpriseDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new EnterpriseDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @return 数据列表的强类型实体类
        */
        public static EnterpriseInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new EnterpriseDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new EnterpriseDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @return 数据列表的强类型实体类
        */
        public static EnterpriseInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @return 数据列表的强类型实体类
        */
        public static EnterpriseInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListPagerByEnterpriseid
        // [start] GetListPagerByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Enterpriseid 企业编号
        * @return 数据列表的强类型实体类
        */
        public static EnterpriseInfoCollection GetListPagerByEnterpriseid(int Enterpriseid, int pageIndex, int pageSize)
        {
            return new EnterpriseDAL().GetListPagerByEnterpriseid(Enterpriseid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Enterpriseid 企业编号
        * @return 数据总量
        */
        public static int GetListPagerByEnterpriseid(int Enterpriseid)
        {
            return new EnterpriseDAL().GetListPagerByEnterpriseid(Enterpriseid);
        }
        // [end]
        // [start] GetListPagerByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Enterpriseid 企业编号
        * @return 数据列表的强类型实体类
        */
        public static EnterpriseInfoCollection GetListPagerByEnterpriseid(int Enterpriseid,  String OrderBy, int pageIndex, int pageSize)
        {
            return new EnterpriseDAL().GetListPagerByEnterpriseid(Enterpriseid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Enterpriseid 企业编号
        * @return 数据总量
        */
        public static int GetListPagerByEnterpriseid(int Enterpriseid, String OrderBy)
        {
            return new EnterpriseDAL().GetListPagerByEnterpriseid(Enterpriseid,  OrderBy);
        }
        // [end]
        // [start] GetListPagerByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Enterpriseid 企业编号
        * @return 数据列表的强类型实体类
        */
        public static EnterpriseInfoCollection GetListPagerByEnterpriseid(DataProvider dp,int Enterpriseid, int pageIndex, int pageSize)
        {
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByEnterpriseid(Enterpriseid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Enterpriseid 企业编号
        * @return 数据总量
        */
        public static int GetListPagerByEnterpriseid(DataProvider dp, int Enterpriseid)
        {
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByEnterpriseid(Enterpriseid);
        }
        // [end]
        // [start] GetListPagerByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Enterpriseid 企业编号
        * @return 数据列表的强类型实体类
        */
        public static EnterpriseInfoCollection GetListPagerByEnterpriseid(DataProvider dp, int Enterpriseid,  String OrderBy, int pageIndex, int pageSize)
        {
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByEnterpriseid(Enterpriseid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Enterpriseid 企业编号
        * @return 数据总量
        */
        public static int GetListPagerByEnterpriseid(DataProvider dp, int Enterpriseid, String OrderBy)
        {
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByEnterpriseid(Enterpriseid,  OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetEnterpriseInfoByDatabaseenterpriseid
        // [start] GetEnterpriseInfoByDatabaseenterpriseid
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 获取表t_enterprise 企业信息表的对象<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Databaseenterpriseid 企业ID
        * @return EnterpriseInfo对象实体
        */
        public static EnterpriseInfo GetEnterpriseInfoByDatabaseenterpriseid(int Databaseenterpriseid)
        {
            return new EnterpriseDAL().GetEnterpriseInfoByDatabaseenterpriseid(Databaseenterpriseid);
        }
        // [end]
        // [start] GetEnterpriseInfoByDatabaseenterpriseid
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 获取表t_enterprise 企业信息表的对象<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Databaseenterpriseid 企业ID
        * @return EnterpriseInfo对象实体
        */
        public static EnterpriseInfo GetEnterpriseInfoByDatabaseenterpriseid(DataProvider dp, int Databaseenterpriseid)
        {
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetEnterpriseInfoByDatabaseenterpriseid(Databaseenterpriseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_enterprise 企业信息表中插入数据<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param objEnterpriseInfo EnterpriseInfo对象 企业信息表
        */
  public static boolean Insert(EnterpriseInfo objEnterpriseInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objEnterpriseInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_enterprise 企业信息表中插入数据<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param objEnterpriseInfo EnterpriseInfo对象 企业信息表
        */
  public static boolean Insert(DataProvider dp, EnterpriseInfo objEnterpriseInfo)
	{
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objEnterpriseInfo);
      setEnterpriseStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_enterprise", "添加", objEnterpriseInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByDatabaseenterpriseid
        // [start] UpdateByDatabaseenterpriseid
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 更新表t_enterprise 企业信息表中的内容<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param objEnterpriseInfo EnterpriseInfo对象 企业信息表
        */
  public static boolean UpdateByDatabaseenterpriseid(EnterpriseInfo objEnterpriseInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByDatabaseenterpriseid(dp, objEnterpriseInfo);
	}

	// [end]
        // [start] UpdateByDatabaseenterpriseid
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 更新表t_enterprise 企业信息表中的内容<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param objEnterpriseInfo EnterpriseInfo对象 企业信息表
        */
  public static boolean UpdateByDatabaseenterpriseid(DataProvider dp, EnterpriseInfo objEnterpriseInfo)
	{
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Databaseenterpriseid =  objEnterpriseInfo.getDatabaseenterpriseid();//企业ID  数据类型:int
      EnterpriseInfo objOld =  dal.GetEnterpriseInfoByDatabaseenterpriseid(Databaseenterpriseid);// 读取实体信息
		dal.UpdateByDatabaseenterpriseid(objEnterpriseInfo);
		setEnterpriseStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objEnterpriseInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objEnterpriseInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_enterprise", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByDatabaseenterpriseid
        // [start] DeleteByDatabaseenterpriseid
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 删除数据表t_enterprise 企业信息表中的内容<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Databaseenterpriseid 企业ID
        */
	public static boolean DeleteByDatabaseenterpriseid(int Databaseenterpriseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByDatabaseenterpriseid(dp, Databaseenterpriseid);
	}

	// [end]
        // [start] DeleteByDatabaseenterpriseid
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 删除数据表t_enterprise 企业信息表中的内容<br />
        * 开发者 贾军磊 2013年01月22日 13:52:53
        *
        * @param Databaseenterpriseid 企业ID
        */
	public static boolean DeleteByDatabaseenterpriseid(DataProvider dp, int Databaseenterpriseid)
	{
		EnterpriseDAL dal = new EnterpriseDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      EnterpriseInfo objOld =  dal.GetEnterpriseInfoByDatabaseenterpriseid(Databaseenterpriseid);// 读取实体信息
		dal.DeleteByDatabaseenterpriseid(Databaseenterpriseid);
		setEnterpriseStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_enterprise", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}