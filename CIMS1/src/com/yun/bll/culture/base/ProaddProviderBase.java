/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:31:00
   功能说明: 表t_proadd 的业务类ProaddInfo的业务层基类
   表说明:
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Proadd  的实体ProaddInfo的数据操作类
 *
 */
public class ProaddProviderBase
{
	// [start] 设置和获取静态属性列表 ProaddStatic, 默认值:null
	// 设置和获取静态属性列表 ProaddStatic, 默认值:null 开始
	private static ProaddInfoCollection proaddStatic = null;
	/**
	* 获取 静态属性列表 ProaddStatic, 默认值:null
	 *
	 * @return 静态属性列表 ProaddStatic, 默认值:null
	 */
	public static ProaddInfoCollection getProaddStatic()
	{
		if (proaddStatic == null)
		  proaddStatic = new ProaddDAL().GetListBy();
		return proaddStatic;
	}
	/**
	 * 设置 静态属性列表 ProaddStatic, 默认值:null
	 *
	 * @param sProaddStatic
	 *            静态属性列表 ProaddStatic, 默认值:null
	 */
	public static void setProaddStatic(ProaddInfoCollection sProaddStatic)
	{
		proaddStatic = sProaddStatic;
		setProaddInfoStaticByProadddatabaseid (null);
	}
	// 设置和获取静态属性列表 ProaddStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.ProaddInfo objProaddInfo : getProaddStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objProaddInfo.getProadddatabaseid(), objProaddInfo.getProaddname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetProaddInfoStaticByProadddatabaseid
	// [start] 设置和获取静态属性列表 ProaddInfoStaticByProadddatabaseid, 默认值:null
	// 设置和获取静态属性列表 ProaddInfoStaticByProadddatabaseid, 默认值:null 开始
	private static ProaddInfoCollection ProaddInfoStaticByProadddatabaseid = null;
	/**
	* 获取 静态属性列表 ProaddInfoStaticByProadddatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 ProaddInfoStaticByProadddatabaseid, 默认值:null
	 */
	public static ProaddInfoCollection getProaddInfoStaticByProadddatabaseid()
	{
		return ProaddInfoStaticByProadddatabaseid;
	}
	/**
	 * 设置 静态属性列表 ProaddInfoStaticByProadddatabaseid, 默认值:null
	 *
	 * @param sProaddInfoStaticByProadddatabaseid
	 *            静态属性列表 ProaddInfoStaticByProadddatabaseid, 默认值:null
	 */
	public static void setProaddInfoStaticByProadddatabaseid(ProaddInfoCollection sProaddInfoStaticByProadddatabaseid)
	{
		ProaddInfoStaticByProadddatabaseid = sProaddInfoStaticByProadddatabaseid;
	}
	// 设置和获取静态属性列表 ProaddInfoStaticByProadddatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 获取表t_proadd 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proadddatabaseid 数据库ID
        * @return ProaddInfo对象实体
        */
        public static ProaddInfo GetProaddInfoStaticByProadddatabaseid(int Proadddatabaseid)
        {
            if (ProaddInfoStaticByProadddatabaseid == null)
                ProaddInfoStaticByProadddatabaseid = new ProaddInfoCollection();
            int allcount = ProaddInfoStaticByProadddatabaseid.size();
            ProaddInfo objProaddInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (ProaddInfoStaticByProadddatabaseid == null)
                    break;
                    objProaddInfo = ProaddInfoStaticByProadddatabaseid.get(i);
                if (objProaddInfo == null)
                    break;
                if (objProaddInfo.getProadddatabaseid() == Proadddatabaseid)
                {
                    return objProaddInfo;
                }
            }
            ProaddInfo obj= new ProaddDAL().GetProaddInfoByProadddatabaseid(Proadddatabaseid);

            if (obj != null)
            {
                if (ProaddInfoStaticByProadddatabaseid != null)
                    ProaddInfoStaticByProadddatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new ProaddInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByProadddatabaseid
        // [start] CountByProadddatabaseid
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proadddatabaseid 数据库ID
        * @return 数据量
        */
        public static int CountByProadddatabaseid(int Proadddatabaseid)
        {
            return new ProaddDAL().CountByProadddatabaseid(Proadddatabaseid);
        }
        // [end]
        // [start] CountByProadddatabaseid
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proadddatabaseid 数据库ID
        * @return 数据量
        */
        public static int CountByProadddatabaseid(DataProvider dp, int Proadddatabaseid)
        {
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByProadddatabaseid(Proadddatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new ProaddDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]
        // [start] CountByProaddid
        // [start] CountByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proaddid 地址ID
        * @return 数据量
        */
        public static int CountByProaddid(int Proaddid)
        {
            return new ProaddDAL().CountByProaddid(Proaddid);
        }
        // [end]
        // [start] CountByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proaddid 地址ID
        * @return 数据量
        */
        public static int CountByProaddid(DataProvider dp, int Proaddid)
        {
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByProaddid(Proaddid);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @return 数据列表的强类型实体类
        */
        public static ProaddInfoCollection GetListBy()
        {
            return new ProaddDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @return 数据列表的强类型实体类
        */
        public static ProaddInfoCollection GetListBy(DataProvider dp )
        {
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @return 数据列表的强类型实体类
        */
        public static ProaddInfoCollection GetListBy(String OrderBy)
        {
            return new ProaddDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @return 数据列表的强类型实体类
        */
        public static ProaddInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListByProaddid
        // [start] GetListByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proaddid 地址ID
        * @return 数据列表的强类型实体类
        */
        public static ProaddInfoCollection GetListByProaddid(int Proaddid)
        {
            return new ProaddDAL().GetListByProaddid(Proaddid);
        }
        // [end]
        // [start] GetListByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proaddid 地址ID
        * @return 数据列表的强类型实体类
        */
        public static ProaddInfoCollection GetListByProaddid(DataProvider dp, int Proaddid)
        {
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByProaddid(Proaddid);
        }
        // [end]
        // [start] GetListByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proaddid 地址ID
        * @return 数据列表的强类型实体类
        */
        public static ProaddInfoCollection GetListByProaddid(int Proaddid, String OrderBy)
        {
            return new ProaddDAL().GetListByProaddid(Proaddid, OrderBy);
        }
        // [end]
        // [start] GetListByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proaddid 地址ID
        * @return 数据列表的强类型实体类
        */
        public static ProaddInfoCollection GetListByProaddid(DataProvider dp, int Proaddid, String OrderBy)
        {
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByProaddid(Proaddid, OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @return 数据列表的强类型实体类
        */
        public static ProaddInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new ProaddDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new ProaddDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @return 数据列表的强类型实体类
        */
        public static ProaddInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new ProaddDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new ProaddDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @return 数据列表的强类型实体类
        */
        public static ProaddInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @return 数据列表的强类型实体类
        */
        public static ProaddInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListPagerByProaddid
        // [start] GetListPagerByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proaddid 地址ID
        * @return 数据列表的强类型实体类
        */
        public static ProaddInfoCollection GetListPagerByProaddid(int Proaddid, int pageIndex, int pageSize)
        {
            return new ProaddDAL().GetListPagerByProaddid(Proaddid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proaddid 地址ID
        * @return 数据总量
        */
        public static int GetListPagerByProaddid(int Proaddid)
        {
            return new ProaddDAL().GetListPagerByProaddid(Proaddid);
        }
        // [end]
        // [start] GetListPagerByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proaddid 地址ID
        * @return 数据列表的强类型实体类
        */
        public static ProaddInfoCollection GetListPagerByProaddid(int Proaddid,  String OrderBy, int pageIndex, int pageSize)
        {
            return new ProaddDAL().GetListPagerByProaddid(Proaddid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proaddid 地址ID
        * @return 数据总量
        */
        public static int GetListPagerByProaddid(int Proaddid, String OrderBy)
        {
            return new ProaddDAL().GetListPagerByProaddid(Proaddid,  OrderBy);
        }
        // [end]
        // [start] GetListPagerByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proaddid 地址ID
        * @return 数据列表的强类型实体类
        */
        public static ProaddInfoCollection GetListPagerByProaddid(DataProvider dp,int Proaddid, int pageIndex, int pageSize)
        {
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByProaddid(Proaddid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proaddid 地址ID
        * @return 数据总量
        */
        public static int GetListPagerByProaddid(DataProvider dp, int Proaddid)
        {
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByProaddid(Proaddid);
        }
        // [end]
        // [start] GetListPagerByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proaddid 地址ID
        * @return 数据列表的强类型实体类
        */
        public static ProaddInfoCollection GetListPagerByProaddid(DataProvider dp, int Proaddid,  String OrderBy, int pageIndex, int pageSize)
        {
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByProaddid(Proaddid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proaddid 地址ID
        * @return 数据总量
        */
        public static int GetListPagerByProaddid(DataProvider dp, int Proaddid, String OrderBy)
        {
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByProaddid(Proaddid,  OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetProaddInfoByProadddatabaseid
        // [start] GetProaddInfoByProadddatabaseid
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 获取表t_proadd 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proadddatabaseid 数据库ID
        * @return ProaddInfo对象实体
        */
        public static ProaddInfo GetProaddInfoByProadddatabaseid(int Proadddatabaseid)
        {
            return new ProaddDAL().GetProaddInfoByProadddatabaseid(Proadddatabaseid);
        }
        // [end]
        // [start] GetProaddInfoByProadddatabaseid
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 获取表t_proadd 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proadddatabaseid 数据库ID
        * @return ProaddInfo对象实体
        */
        public static ProaddInfo GetProaddInfoByProadddatabaseid(DataProvider dp, int Proadddatabaseid)
        {
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetProaddInfoByProadddatabaseid(Proadddatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_proadd 中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param objProaddInfo ProaddInfo对象 
        */
  public static boolean Insert(ProaddInfo objProaddInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objProaddInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_proadd 中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param objProaddInfo ProaddInfo对象 
        */
  public static boolean Insert(DataProvider dp, ProaddInfo objProaddInfo)
	{
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objProaddInfo);
      setProaddStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_proadd", "添加", objProaddInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByProadddatabaseid
        // [start] UpdateByProadddatabaseid
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 更新表t_proadd 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param objProaddInfo ProaddInfo对象 
        */
  public static boolean UpdateByProadddatabaseid(ProaddInfo objProaddInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByProadddatabaseid(dp, objProaddInfo);
	}

	// [end]
        // [start] UpdateByProadddatabaseid
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 更新表t_proadd 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param objProaddInfo ProaddInfo对象 
        */
  public static boolean UpdateByProadddatabaseid(DataProvider dp, ProaddInfo objProaddInfo)
	{
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Proadddatabaseid =  objProaddInfo.getProadddatabaseid();//数据库ID  数据类型:int
      ProaddInfo objOld =  dal.GetProaddInfoByProadddatabaseid(Proadddatabaseid);// 读取实体信息
		dal.UpdateByProadddatabaseid(objProaddInfo);
		setProaddStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objProaddInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objProaddInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_proadd", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByProadddatabaseid
        // [start] DeleteByProadddatabaseid
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 删除数据表t_proadd 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proadddatabaseid 数据库ID
        */
	public static boolean DeleteByProadddatabaseid(int Proadddatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByProadddatabaseid(dp, Proadddatabaseid);
	}

	// [end]
        // [start] DeleteByProadddatabaseid
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 删除数据表t_proadd 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:00
        *
        * @param Proadddatabaseid 数据库ID
        */
	public static boolean DeleteByProadddatabaseid(DataProvider dp, int Proadddatabaseid)
	{
		ProaddDAL dal = new ProaddDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      ProaddInfo objOld =  dal.GetProaddInfoByProadddatabaseid(Proadddatabaseid);// 读取实体信息
		dal.DeleteByProadddatabaseid(Proadddatabaseid);
		setProaddStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_proadd", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}