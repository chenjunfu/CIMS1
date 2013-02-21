/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:28:55
   功能说明: 表t_enterprist_quality 企业性质表的业务类EnterpristQualityInfo的业务层基类
   表说明:企业性质表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表EnterpristQuality 企业性质表 的实体EnterpristQualityInfo的数据操作类
 *
 */
public class EnterpristQualityProviderBase
{
	// [start] 设置和获取静态属性列表 EnterpristQualityStatic, 默认值:null
	// 设置和获取静态属性列表 EnterpristQualityStatic, 默认值:null 开始
	private static EnterpristQualityInfoCollection enterpristQualityStatic = null;
	/**
	* 获取 静态属性列表 EnterpristQualityStatic, 默认值:null
	 *
	 * @return 静态属性列表 EnterpristQualityStatic, 默认值:null
	 */
	public static EnterpristQualityInfoCollection getEnterpristQualityStatic()
	{
		if (enterpristQualityStatic == null)
		  enterpristQualityStatic = new EnterpristQualityDAL().GetListBy();
		return enterpristQualityStatic;
	}
	/**
	 * 设置 静态属性列表 EnterpristQualityStatic, 默认值:null
	 *
	 * @param sEnterpristQualityStatic
	 *            静态属性列表 EnterpristQualityStatic, 默认值:null
	 */
	public static void setEnterpristQualityStatic(EnterpristQualityInfoCollection sEnterpristQualityStatic)
	{
		enterpristQualityStatic = sEnterpristQualityStatic;
		setEnterpristQualityInfoStaticByQualitydatabaseid (null);
	}
	// 设置和获取静态属性列表 EnterpristQualityStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.EnterpristQualityInfo objEnterpristQualityInfo : getEnterpristQualityStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objEnterpristQualityInfo.getQualitydatabaseid(), objEnterpristQualityInfo.getQualityname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetEnterpristQualityInfoStaticByQualitydatabaseid
	// [start] 设置和获取静态属性列表 EnterpristQualityInfoStaticByQualitydatabaseid, 默认值:null
	// 设置和获取静态属性列表 EnterpristQualityInfoStaticByQualitydatabaseid, 默认值:null 开始
	private static EnterpristQualityInfoCollection EnterpristQualityInfoStaticByQualitydatabaseid = null;
	/**
	* 获取 静态属性列表 EnterpristQualityInfoStaticByQualitydatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 EnterpristQualityInfoStaticByQualitydatabaseid, 默认值:null
	 */
	public static EnterpristQualityInfoCollection getEnterpristQualityInfoStaticByQualitydatabaseid()
	{
		return EnterpristQualityInfoStaticByQualitydatabaseid;
	}
	/**
	 * 设置 静态属性列表 EnterpristQualityInfoStaticByQualitydatabaseid, 默认值:null
	 *
	 * @param sEnterpristQualityInfoStaticByQualitydatabaseid
	 *            静态属性列表 EnterpristQualityInfoStaticByQualitydatabaseid, 默认值:null
	 */
	public static void setEnterpristQualityInfoStaticByQualitydatabaseid(EnterpristQualityInfoCollection sEnterpristQualityInfoStaticByQualitydatabaseid)
	{
		EnterpristQualityInfoStaticByQualitydatabaseid = sEnterpristQualityInfoStaticByQualitydatabaseid;
	}
	// 设置和获取静态属性列表 EnterpristQualityInfoStaticByQualitydatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 获取表t_enterprist_quality 企业性质表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualitydatabaseid 企业性质编号
        * @return EnterpristQualityInfo对象实体
        */
        public static EnterpristQualityInfo GetEnterpristQualityInfoStaticByQualitydatabaseid(int Qualitydatabaseid)
        {
            if (EnterpristQualityInfoStaticByQualitydatabaseid == null)
                EnterpristQualityInfoStaticByQualitydatabaseid = new EnterpristQualityInfoCollection();
            int allcount = EnterpristQualityInfoStaticByQualitydatabaseid.size();
            EnterpristQualityInfo objEnterpristQualityInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (EnterpristQualityInfoStaticByQualitydatabaseid == null)
                    break;
                    objEnterpristQualityInfo = EnterpristQualityInfoStaticByQualitydatabaseid.get(i);
                if (objEnterpristQualityInfo == null)
                    break;
                if (objEnterpristQualityInfo.getQualitydatabaseid() == Qualitydatabaseid)
                {
                    return objEnterpristQualityInfo;
                }
            }
            EnterpristQualityInfo obj= new EnterpristQualityDAL().GetEnterpristQualityInfoByQualitydatabaseid(Qualitydatabaseid);

            if (obj != null)
            {
                if (EnterpristQualityInfoStaticByQualitydatabaseid != null)
                    EnterpristQualityInfoStaticByQualitydatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new EnterpristQualityInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByQualitydatabaseid
        // [start] CountByQualitydatabaseid
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualitydatabaseid 企业性质编号
        * @return 数据量
        */
        public static int CountByQualitydatabaseid(int Qualitydatabaseid)
        {
            return new EnterpristQualityDAL().CountByQualitydatabaseid(Qualitydatabaseid);
        }
        // [end]
        // [start] CountByQualitydatabaseid
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualitydatabaseid 企业性质编号
        * @return 数据量
        */
        public static int CountByQualitydatabaseid(DataProvider dp, int Qualitydatabaseid)
        {
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByQualitydatabaseid(Qualitydatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new EnterpristQualityDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]
        // [start] CountByQualityid
        // [start] CountByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualityid QualityID
        * @return 数据量
        */
        public static int CountByQualityid(String Qualityid)
        {
            return new EnterpristQualityDAL().CountByQualityid(Qualityid);
        }
        // [end]
        // [start] CountByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualityid QualityID
        * @return 数据量
        */
        public static int CountByQualityid(DataProvider dp, String Qualityid)
        {
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByQualityid(Qualityid);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @return 数据列表的强类型实体类
        */
        public static EnterpristQualityInfoCollection GetListBy()
        {
            return new EnterpristQualityDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @return 数据列表的强类型实体类
        */
        public static EnterpristQualityInfoCollection GetListBy(DataProvider dp )
        {
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @return 数据列表的强类型实体类
        */
        public static EnterpristQualityInfoCollection GetListBy(String OrderBy)
        {
            return new EnterpristQualityDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @return 数据列表的强类型实体类
        */
        public static EnterpristQualityInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListByQualityid
        // [start] GetListByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualityid QualityID
        * @return 数据列表的强类型实体类
        */
        public static EnterpristQualityInfoCollection GetListByQualityid(String Qualityid)
        {
            return new EnterpristQualityDAL().GetListByQualityid(Qualityid);
        }
        // [end]
        // [start] GetListByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualityid QualityID
        * @return 数据列表的强类型实体类
        */
        public static EnterpristQualityInfoCollection GetListByQualityid(DataProvider dp, String Qualityid)
        {
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByQualityid(Qualityid);
        }
        // [end]
        // [start] GetListByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualityid QualityID
        * @return 数据列表的强类型实体类
        */
        public static EnterpristQualityInfoCollection GetListByQualityid(String Qualityid, String OrderBy)
        {
            return new EnterpristQualityDAL().GetListByQualityid(Qualityid, OrderBy);
        }
        // [end]
        // [start] GetListByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualityid QualityID
        * @return 数据列表的强类型实体类
        */
        public static EnterpristQualityInfoCollection GetListByQualityid(DataProvider dp, String Qualityid, String OrderBy)
        {
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByQualityid(Qualityid, OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @return 数据列表的强类型实体类
        */
        public static EnterpristQualityInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new EnterpristQualityDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new EnterpristQualityDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @return 数据列表的强类型实体类
        */
        public static EnterpristQualityInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new EnterpristQualityDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new EnterpristQualityDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @return 数据列表的强类型实体类
        */
        public static EnterpristQualityInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @return 数据列表的强类型实体类
        */
        public static EnterpristQualityInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListPagerByQualityid
        // [start] GetListPagerByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualityid QualityID
        * @return 数据列表的强类型实体类
        */
        public static EnterpristQualityInfoCollection GetListPagerByQualityid(String Qualityid, int pageIndex, int pageSize)
        {
            return new EnterpristQualityDAL().GetListPagerByQualityid(Qualityid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualityid QualityID
        * @return 数据总量
        */
        public static int GetListPagerByQualityid(String Qualityid)
        {
            return new EnterpristQualityDAL().GetListPagerByQualityid(Qualityid);
        }
        // [end]
        // [start] GetListPagerByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualityid QualityID
        * @return 数据列表的强类型实体类
        */
        public static EnterpristQualityInfoCollection GetListPagerByQualityid(String Qualityid,  String OrderBy, int pageIndex, int pageSize)
        {
            return new EnterpristQualityDAL().GetListPagerByQualityid(Qualityid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualityid QualityID
        * @return 数据总量
        */
        public static int GetListPagerByQualityid(String Qualityid, String OrderBy)
        {
            return new EnterpristQualityDAL().GetListPagerByQualityid(Qualityid,  OrderBy);
        }
        // [end]
        // [start] GetListPagerByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualityid QualityID
        * @return 数据列表的强类型实体类
        */
        public static EnterpristQualityInfoCollection GetListPagerByQualityid(DataProvider dp,String Qualityid, int pageIndex, int pageSize)
        {
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByQualityid(Qualityid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualityid QualityID
        * @return 数据总量
        */
        public static int GetListPagerByQualityid(DataProvider dp, String Qualityid)
        {
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByQualityid(Qualityid);
        }
        // [end]
        // [start] GetListPagerByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualityid QualityID
        * @return 数据列表的强类型实体类
        */
        public static EnterpristQualityInfoCollection GetListPagerByQualityid(DataProvider dp, String Qualityid,  String OrderBy, int pageIndex, int pageSize)
        {
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByQualityid(Qualityid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualityid QualityID
        * @return 数据总量
        */
        public static int GetListPagerByQualityid(DataProvider dp, String Qualityid, String OrderBy)
        {
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByQualityid(Qualityid,  OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetEnterpristQualityInfoByQualitydatabaseid
        // [start] GetEnterpristQualityInfoByQualitydatabaseid
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 获取表t_enterprist_quality 企业性质表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualitydatabaseid 企业性质编号
        * @return EnterpristQualityInfo对象实体
        */
        public static EnterpristQualityInfo GetEnterpristQualityInfoByQualitydatabaseid(int Qualitydatabaseid)
        {
            return new EnterpristQualityDAL().GetEnterpristQualityInfoByQualitydatabaseid(Qualitydatabaseid);
        }
        // [end]
        // [start] GetEnterpristQualityInfoByQualitydatabaseid
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 获取表t_enterprist_quality 企业性质表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualitydatabaseid 企业性质编号
        * @return EnterpristQualityInfo对象实体
        */
        public static EnterpristQualityInfo GetEnterpristQualityInfoByQualitydatabaseid(DataProvider dp, int Qualitydatabaseid)
        {
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetEnterpristQualityInfoByQualitydatabaseid(Qualitydatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_enterprist_quality 企业性质表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param objEnterpristQualityInfo EnterpristQualityInfo对象 企业性质表
        */
  public static boolean Insert(EnterpristQualityInfo objEnterpristQualityInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objEnterpristQualityInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_enterprist_quality 企业性质表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param objEnterpristQualityInfo EnterpristQualityInfo对象 企业性质表
        */
  public static boolean Insert(DataProvider dp, EnterpristQualityInfo objEnterpristQualityInfo)
	{
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objEnterpristQualityInfo);
      setEnterpristQualityStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_enterprist_quality", "添加", objEnterpristQualityInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByQualitydatabaseid
        // [start] UpdateByQualitydatabaseid
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 更新表t_enterprist_quality 企业性质表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param objEnterpristQualityInfo EnterpristQualityInfo对象 企业性质表
        */
  public static boolean UpdateByQualitydatabaseid(EnterpristQualityInfo objEnterpristQualityInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByQualitydatabaseid(dp, objEnterpristQualityInfo);
	}

	// [end]
        // [start] UpdateByQualitydatabaseid
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 更新表t_enterprist_quality 企业性质表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param objEnterpristQualityInfo EnterpristQualityInfo对象 企业性质表
        */
  public static boolean UpdateByQualitydatabaseid(DataProvider dp, EnterpristQualityInfo objEnterpristQualityInfo)
	{
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Qualitydatabaseid =  objEnterpristQualityInfo.getQualitydatabaseid();//企业性质编号  数据类型:int
      EnterpristQualityInfo objOld =  dal.GetEnterpristQualityInfoByQualitydatabaseid(Qualitydatabaseid);// 读取实体信息
		dal.UpdateByQualitydatabaseid(objEnterpristQualityInfo);
		setEnterpristQualityStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objEnterpristQualityInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objEnterpristQualityInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_enterprist_quality", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByQualitydatabaseid
        // [start] DeleteByQualitydatabaseid
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 删除数据表t_enterprist_quality 企业性质表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualitydatabaseid 企业性质编号
        */
	public static boolean DeleteByQualitydatabaseid(int Qualitydatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByQualitydatabaseid(dp, Qualitydatabaseid);
	}

	// [end]
        // [start] DeleteByQualitydatabaseid
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 删除数据表t_enterprist_quality 企业性质表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:55
        *
        * @param Qualitydatabaseid 企业性质编号
        */
	public static boolean DeleteByQualitydatabaseid(DataProvider dp, int Qualitydatabaseid)
	{
		EnterpristQualityDAL dal = new EnterpristQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      EnterpristQualityInfo objOld =  dal.GetEnterpristQualityInfoByQualitydatabaseid(Qualitydatabaseid);// 读取实体信息
		dal.DeleteByQualitydatabaseid(Qualitydatabaseid);
		setEnterpristQualityStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_enterprist_quality", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}