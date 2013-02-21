/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:29:04
   功能说明: 表t_huanpi 的业务类HuanpiInfo的业务层基类
   表说明:
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Huanpi  的实体HuanpiInfo的数据操作类
 *
 */
public class HuanpiProviderBase
{
	// [start] 设置和获取静态属性列表 HuanpiStatic, 默认值:null
	// 设置和获取静态属性列表 HuanpiStatic, 默认值:null 开始
	private static HuanpiInfoCollection huanpiStatic = null;
	/**
	* 获取 静态属性列表 HuanpiStatic, 默认值:null
	 *
	 * @return 静态属性列表 HuanpiStatic, 默认值:null
	 */
	public static HuanpiInfoCollection getHuanpiStatic()
	{
		if (huanpiStatic == null)
		  huanpiStatic = new HuanpiDAL().GetListBy();
		return huanpiStatic;
	}
	/**
	 * 设置 静态属性列表 HuanpiStatic, 默认值:null
	 *
	 * @param sHuanpiStatic
	 *            静态属性列表 HuanpiStatic, 默认值:null
	 */
	public static void setHuanpiStatic(HuanpiInfoCollection sHuanpiStatic)
	{
		huanpiStatic = sHuanpiStatic;
		setHuanpiInfoStaticByHuanpidatabaseid (null);
	}
	// 设置和获取静态属性列表 HuanpiStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.HuanpiInfo objHuanpiInfo : getHuanpiStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objHuanpiInfo.getHuanpidatabaseid(), objHuanpiInfo.getHuanpiname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetHuanpiInfoStaticByHuanpidatabaseid
	// [start] 设置和获取静态属性列表 HuanpiInfoStaticByHuanpidatabaseid, 默认值:null
	// 设置和获取静态属性列表 HuanpiInfoStaticByHuanpidatabaseid, 默认值:null 开始
	private static HuanpiInfoCollection HuanpiInfoStaticByHuanpidatabaseid = null;
	/**
	* 获取 静态属性列表 HuanpiInfoStaticByHuanpidatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 HuanpiInfoStaticByHuanpidatabaseid, 默认值:null
	 */
	public static HuanpiInfoCollection getHuanpiInfoStaticByHuanpidatabaseid()
	{
		return HuanpiInfoStaticByHuanpidatabaseid;
	}
	/**
	 * 设置 静态属性列表 HuanpiInfoStaticByHuanpidatabaseid, 默认值:null
	 *
	 * @param sHuanpiInfoStaticByHuanpidatabaseid
	 *            静态属性列表 HuanpiInfoStaticByHuanpidatabaseid, 默认值:null
	 */
	public static void setHuanpiInfoStaticByHuanpidatabaseid(HuanpiInfoCollection sHuanpiInfoStaticByHuanpidatabaseid)
	{
		HuanpiInfoStaticByHuanpidatabaseid = sHuanpiInfoStaticByHuanpidatabaseid;
	}
	// 设置和获取静态属性列表 HuanpiInfoStaticByHuanpidatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 获取表t_huanpi 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpidatabaseid 数据库ID
        * @return HuanpiInfo对象实体
        */
        public static HuanpiInfo GetHuanpiInfoStaticByHuanpidatabaseid(int Huanpidatabaseid)
        {
            if (HuanpiInfoStaticByHuanpidatabaseid == null)
                HuanpiInfoStaticByHuanpidatabaseid = new HuanpiInfoCollection();
            int allcount = HuanpiInfoStaticByHuanpidatabaseid.size();
            HuanpiInfo objHuanpiInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (HuanpiInfoStaticByHuanpidatabaseid == null)
                    break;
                    objHuanpiInfo = HuanpiInfoStaticByHuanpidatabaseid.get(i);
                if (objHuanpiInfo == null)
                    break;
                if (objHuanpiInfo.getHuanpidatabaseid() == Huanpidatabaseid)
                {
                    return objHuanpiInfo;
                }
            }
            HuanpiInfo obj= new HuanpiDAL().GetHuanpiInfoByHuanpidatabaseid(Huanpidatabaseid);

            if (obj != null)
            {
                if (HuanpiInfoStaticByHuanpidatabaseid != null)
                    HuanpiInfoStaticByHuanpidatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new HuanpiInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByHuanpidatabaseid
        // [start] CountByHuanpidatabaseid
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpidatabaseid 数据库ID
        * @return 数据量
        */
        public static int CountByHuanpidatabaseid(int Huanpidatabaseid)
        {
            return new HuanpiDAL().CountByHuanpidatabaseid(Huanpidatabaseid);
        }
        // [end]
        // [start] CountByHuanpidatabaseid
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpidatabaseid 数据库ID
        * @return 数据量
        */
        public static int CountByHuanpidatabaseid(DataProvider dp, int Huanpidatabaseid)
        {
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByHuanpidatabaseid(Huanpidatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new HuanpiDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]
        // [start] CountByHuanpiid
        // [start] CountByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpiid 环境批复ID
        * @return 数据量
        */
        public static int CountByHuanpiid(int Huanpiid)
        {
            return new HuanpiDAL().CountByHuanpiid(Huanpiid);
        }
        // [end]
        // [start] CountByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpiid 环境批复ID
        * @return 数据量
        */
        public static int CountByHuanpiid(DataProvider dp, int Huanpiid)
        {
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByHuanpiid(Huanpiid);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @return 数据列表的强类型实体类
        */
        public static HuanpiInfoCollection GetListBy()
        {
            return new HuanpiDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @return 数据列表的强类型实体类
        */
        public static HuanpiInfoCollection GetListBy(DataProvider dp )
        {
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @return 数据列表的强类型实体类
        */
        public static HuanpiInfoCollection GetListBy(String OrderBy)
        {
            return new HuanpiDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @return 数据列表的强类型实体类
        */
        public static HuanpiInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListByHuanpiid
        // [start] GetListByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpiid 环境批复ID
        * @return 数据列表的强类型实体类
        */
        public static HuanpiInfoCollection GetListByHuanpiid(int Huanpiid)
        {
            return new HuanpiDAL().GetListByHuanpiid(Huanpiid);
        }
        // [end]
        // [start] GetListByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpiid 环境批复ID
        * @return 数据列表的强类型实体类
        */
        public static HuanpiInfoCollection GetListByHuanpiid(DataProvider dp, int Huanpiid)
        {
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByHuanpiid(Huanpiid);
        }
        // [end]
        // [start] GetListByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpiid 环境批复ID
        * @return 数据列表的强类型实体类
        */
        public static HuanpiInfoCollection GetListByHuanpiid(int Huanpiid, String OrderBy)
        {
            return new HuanpiDAL().GetListByHuanpiid(Huanpiid, OrderBy);
        }
        // [end]
        // [start] GetListByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpiid 环境批复ID
        * @return 数据列表的强类型实体类
        */
        public static HuanpiInfoCollection GetListByHuanpiid(DataProvider dp, int Huanpiid, String OrderBy)
        {
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByHuanpiid(Huanpiid, OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @return 数据列表的强类型实体类
        */
        public static HuanpiInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new HuanpiDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new HuanpiDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @return 数据列表的强类型实体类
        */
        public static HuanpiInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new HuanpiDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new HuanpiDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @return 数据列表的强类型实体类
        */
        public static HuanpiInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @return 数据列表的强类型实体类
        */
        public static HuanpiInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListPagerByHuanpiid
        // [start] GetListPagerByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpiid 环境批复ID
        * @return 数据列表的强类型实体类
        */
        public static HuanpiInfoCollection GetListPagerByHuanpiid(int Huanpiid, int pageIndex, int pageSize)
        {
            return new HuanpiDAL().GetListPagerByHuanpiid(Huanpiid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpiid 环境批复ID
        * @return 数据总量
        */
        public static int GetListPagerByHuanpiid(int Huanpiid)
        {
            return new HuanpiDAL().GetListPagerByHuanpiid(Huanpiid);
        }
        // [end]
        // [start] GetListPagerByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpiid 环境批复ID
        * @return 数据列表的强类型实体类
        */
        public static HuanpiInfoCollection GetListPagerByHuanpiid(int Huanpiid,  String OrderBy, int pageIndex, int pageSize)
        {
            return new HuanpiDAL().GetListPagerByHuanpiid(Huanpiid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpiid 环境批复ID
        * @return 数据总量
        */
        public static int GetListPagerByHuanpiid(int Huanpiid, String OrderBy)
        {
            return new HuanpiDAL().GetListPagerByHuanpiid(Huanpiid,  OrderBy);
        }
        // [end]
        // [start] GetListPagerByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpiid 环境批复ID
        * @return 数据列表的强类型实体类
        */
        public static HuanpiInfoCollection GetListPagerByHuanpiid(DataProvider dp,int Huanpiid, int pageIndex, int pageSize)
        {
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByHuanpiid(Huanpiid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpiid 环境批复ID
        * @return 数据总量
        */
        public static int GetListPagerByHuanpiid(DataProvider dp, int Huanpiid)
        {
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByHuanpiid(Huanpiid);
        }
        // [end]
        // [start] GetListPagerByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpiid 环境批复ID
        * @return 数据列表的强类型实体类
        */
        public static HuanpiInfoCollection GetListPagerByHuanpiid(DataProvider dp, int Huanpiid,  String OrderBy, int pageIndex, int pageSize)
        {
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByHuanpiid(Huanpiid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpiid 环境批复ID
        * @return 数据总量
        */
        public static int GetListPagerByHuanpiid(DataProvider dp, int Huanpiid, String OrderBy)
        {
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByHuanpiid(Huanpiid,  OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetHuanpiInfoByHuanpidatabaseid
        // [start] GetHuanpiInfoByHuanpidatabaseid
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 获取表t_huanpi 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpidatabaseid 数据库ID
        * @return HuanpiInfo对象实体
        */
        public static HuanpiInfo GetHuanpiInfoByHuanpidatabaseid(int Huanpidatabaseid)
        {
            return new HuanpiDAL().GetHuanpiInfoByHuanpidatabaseid(Huanpidatabaseid);
        }
        // [end]
        // [start] GetHuanpiInfoByHuanpidatabaseid
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 获取表t_huanpi 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpidatabaseid 数据库ID
        * @return HuanpiInfo对象实体
        */
        public static HuanpiInfo GetHuanpiInfoByHuanpidatabaseid(DataProvider dp, int Huanpidatabaseid)
        {
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetHuanpiInfoByHuanpidatabaseid(Huanpidatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_huanpi 中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param objHuanpiInfo HuanpiInfo对象 
        */
  public static boolean Insert(HuanpiInfo objHuanpiInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objHuanpiInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_huanpi 中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param objHuanpiInfo HuanpiInfo对象 
        */
  public static boolean Insert(DataProvider dp, HuanpiInfo objHuanpiInfo)
	{
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objHuanpiInfo);
      setHuanpiStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_huanpi", "添加", objHuanpiInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByHuanpidatabaseid
        // [start] UpdateByHuanpidatabaseid
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 更新表t_huanpi 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param objHuanpiInfo HuanpiInfo对象 
        */
  public static boolean UpdateByHuanpidatabaseid(HuanpiInfo objHuanpiInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByHuanpidatabaseid(dp, objHuanpiInfo);
	}

	// [end]
        // [start] UpdateByHuanpidatabaseid
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 更新表t_huanpi 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param objHuanpiInfo HuanpiInfo对象 
        */
  public static boolean UpdateByHuanpidatabaseid(DataProvider dp, HuanpiInfo objHuanpiInfo)
	{
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Huanpidatabaseid =  objHuanpiInfo.getHuanpidatabaseid();//数据库ID  数据类型:int
      HuanpiInfo objOld =  dal.GetHuanpiInfoByHuanpidatabaseid(Huanpidatabaseid);// 读取实体信息
		dal.UpdateByHuanpidatabaseid(objHuanpiInfo);
		setHuanpiStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objHuanpiInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objHuanpiInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_huanpi", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByHuanpidatabaseid
        // [start] DeleteByHuanpidatabaseid
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 删除数据表t_huanpi 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpidatabaseid 数据库ID
        */
	public static boolean DeleteByHuanpidatabaseid(int Huanpidatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByHuanpidatabaseid(dp, Huanpidatabaseid);
	}

	// [end]
        // [start] DeleteByHuanpidatabaseid
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 删除数据表t_huanpi 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:04
        *
        * @param Huanpidatabaseid 数据库ID
        */
	public static boolean DeleteByHuanpidatabaseid(DataProvider dp, int Huanpidatabaseid)
	{
		HuanpiDAL dal = new HuanpiDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      HuanpiInfo objOld =  dal.GetHuanpiInfoByHuanpidatabaseid(Huanpidatabaseid);// 读取实体信息
		dal.DeleteByHuanpidatabaseid(Huanpidatabaseid);
		setHuanpiStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_huanpi", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}