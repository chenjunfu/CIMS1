/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:31:49
   功能说明: 表t_shb 的业务类ShbInfo的业务层基类
   表说明:
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Shb  的实体ShbInfo的数据操作类
 *
 */
public class ShbProviderBase
{
	// [start] 设置和获取静态属性列表 ShbStatic, 默认值:null
	// 设置和获取静态属性列表 ShbStatic, 默认值:null 开始
	private static ShbInfoCollection shbStatic = null;
	/**
	* 获取 静态属性列表 ShbStatic, 默认值:null
	 *
	 * @return 静态属性列表 ShbStatic, 默认值:null
	 */
	public static ShbInfoCollection getShbStatic()
	{
		if (shbStatic == null)
		  shbStatic = new ShbDAL().GetListBy();
		return shbStatic;
	}
	/**
	 * 设置 静态属性列表 ShbStatic, 默认值:null
	 *
	 * @param sShbStatic
	 *            静态属性列表 ShbStatic, 默认值:null
	 */
	public static void setShbStatic(ShbInfoCollection sShbStatic)
	{
		shbStatic = sShbStatic;
		setShbInfoStaticByShbdatabaseid (null);
	}
	// 设置和获取静态属性列表 ShbStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.ShbInfo objShbInfo : getShbStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objShbInfo.getShbdatabaseid(), objShbInfo.getShbname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetShbInfoStaticByShbdatabaseid
	// [start] 设置和获取静态属性列表 ShbInfoStaticByShbdatabaseid, 默认值:null
	// 设置和获取静态属性列表 ShbInfoStaticByShbdatabaseid, 默认值:null 开始
	private static ShbInfoCollection ShbInfoStaticByShbdatabaseid = null;
	/**
	* 获取 静态属性列表 ShbInfoStaticByShbdatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 ShbInfoStaticByShbdatabaseid, 默认值:null
	 */
	public static ShbInfoCollection getShbInfoStaticByShbdatabaseid()
	{
		return ShbInfoStaticByShbdatabaseid;
	}
	/**
	 * 设置 静态属性列表 ShbInfoStaticByShbdatabaseid, 默认值:null
	 *
	 * @param sShbInfoStaticByShbdatabaseid
	 *            静态属性列表 ShbInfoStaticByShbdatabaseid, 默认值:null
	 */
	public static void setShbInfoStaticByShbdatabaseid(ShbInfoCollection sShbInfoStaticByShbdatabaseid)
	{
		ShbInfoStaticByShbdatabaseid = sShbInfoStaticByShbdatabaseid;
	}
	// 设置和获取静态属性列表 ShbInfoStaticByShbdatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 获取表t_shb 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbdatabaseid 数据库ID
        * @return ShbInfo对象实体
        */
        public static ShbInfo GetShbInfoStaticByShbdatabaseid(int Shbdatabaseid)
        {
            if (ShbInfoStaticByShbdatabaseid == null)
                ShbInfoStaticByShbdatabaseid = new ShbInfoCollection();
            int allcount = ShbInfoStaticByShbdatabaseid.size();
            ShbInfo objShbInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (ShbInfoStaticByShbdatabaseid == null)
                    break;
                    objShbInfo = ShbInfoStaticByShbdatabaseid.get(i);
                if (objShbInfo == null)
                    break;
                if (objShbInfo.getShbdatabaseid() == Shbdatabaseid)
                {
                    return objShbInfo;
                }
            }
            ShbInfo obj= new ShbDAL().GetShbInfoByShbdatabaseid(Shbdatabaseid);

            if (obj != null)
            {
                if (ShbInfoStaticByShbdatabaseid != null)
                    ShbInfoStaticByShbdatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new ShbInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByShbdatabaseid
        // [start] CountByShbdatabaseid
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbdatabaseid 数据库ID
        * @return 数据量
        */
        public static int CountByShbdatabaseid(int Shbdatabaseid)
        {
            return new ShbDAL().CountByShbdatabaseid(Shbdatabaseid);
        }
        // [end]
        // [start] CountByShbdatabaseid
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbdatabaseid 数据库ID
        * @return 数据量
        */
        public static int CountByShbdatabaseid(DataProvider dp, int Shbdatabaseid)
        {
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByShbdatabaseid(Shbdatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new ShbDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]
        // [start] CountByShbid
        // [start] CountByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbid 审核备ID
        * @return 数据量
        */
        public static int CountByShbid(int Shbid)
        {
            return new ShbDAL().CountByShbid(Shbid);
        }
        // [end]
        // [start] CountByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbid 审核备ID
        * @return 数据量
        */
        public static int CountByShbid(DataProvider dp, int Shbid)
        {
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByShbid(Shbid);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @return 数据列表的强类型实体类
        */
        public static ShbInfoCollection GetListBy()
        {
            return new ShbDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @return 数据列表的强类型实体类
        */
        public static ShbInfoCollection GetListBy(DataProvider dp )
        {
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @return 数据列表的强类型实体类
        */
        public static ShbInfoCollection GetListBy(String OrderBy)
        {
            return new ShbDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @return 数据列表的强类型实体类
        */
        public static ShbInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListByShbid
        // [start] GetListByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbid 审核备ID
        * @return 数据列表的强类型实体类
        */
        public static ShbInfoCollection GetListByShbid(int Shbid)
        {
            return new ShbDAL().GetListByShbid(Shbid);
        }
        // [end]
        // [start] GetListByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbid 审核备ID
        * @return 数据列表的强类型实体类
        */
        public static ShbInfoCollection GetListByShbid(DataProvider dp, int Shbid)
        {
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByShbid(Shbid);
        }
        // [end]
        // [start] GetListByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbid 审核备ID
        * @return 数据列表的强类型实体类
        */
        public static ShbInfoCollection GetListByShbid(int Shbid, String OrderBy)
        {
            return new ShbDAL().GetListByShbid(Shbid, OrderBy);
        }
        // [end]
        // [start] GetListByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbid 审核备ID
        * @return 数据列表的强类型实体类
        */
        public static ShbInfoCollection GetListByShbid(DataProvider dp, int Shbid, String OrderBy)
        {
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByShbid(Shbid, OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @return 数据列表的强类型实体类
        */
        public static ShbInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new ShbDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new ShbDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @return 数据列表的强类型实体类
        */
        public static ShbInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new ShbDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new ShbDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @return 数据列表的强类型实体类
        */
        public static ShbInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @return 数据列表的强类型实体类
        */
        public static ShbInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListPagerByShbid
        // [start] GetListPagerByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbid 审核备ID
        * @return 数据列表的强类型实体类
        */
        public static ShbInfoCollection GetListPagerByShbid(int Shbid, int pageIndex, int pageSize)
        {
            return new ShbDAL().GetListPagerByShbid(Shbid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbid 审核备ID
        * @return 数据总量
        */
        public static int GetListPagerByShbid(int Shbid)
        {
            return new ShbDAL().GetListPagerByShbid(Shbid);
        }
        // [end]
        // [start] GetListPagerByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbid 审核备ID
        * @return 数据列表的强类型实体类
        */
        public static ShbInfoCollection GetListPagerByShbid(int Shbid,  String OrderBy, int pageIndex, int pageSize)
        {
            return new ShbDAL().GetListPagerByShbid(Shbid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbid 审核备ID
        * @return 数据总量
        */
        public static int GetListPagerByShbid(int Shbid, String OrderBy)
        {
            return new ShbDAL().GetListPagerByShbid(Shbid,  OrderBy);
        }
        // [end]
        // [start] GetListPagerByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbid 审核备ID
        * @return 数据列表的强类型实体类
        */
        public static ShbInfoCollection GetListPagerByShbid(DataProvider dp,int Shbid, int pageIndex, int pageSize)
        {
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByShbid(Shbid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbid 审核备ID
        * @return 数据总量
        */
        public static int GetListPagerByShbid(DataProvider dp, int Shbid)
        {
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByShbid(Shbid);
        }
        // [end]
        // [start] GetListPagerByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbid 审核备ID
        * @return 数据列表的强类型实体类
        */
        public static ShbInfoCollection GetListPagerByShbid(DataProvider dp, int Shbid,  String OrderBy, int pageIndex, int pageSize)
        {
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByShbid(Shbid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbid 审核备ID
        * @return 数据总量
        */
        public static int GetListPagerByShbid(DataProvider dp, int Shbid, String OrderBy)
        {
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByShbid(Shbid,  OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetShbInfoByShbdatabaseid
        // [start] GetShbInfoByShbdatabaseid
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 获取表t_shb 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbdatabaseid 数据库ID
        * @return ShbInfo对象实体
        */
        public static ShbInfo GetShbInfoByShbdatabaseid(int Shbdatabaseid)
        {
            return new ShbDAL().GetShbInfoByShbdatabaseid(Shbdatabaseid);
        }
        // [end]
        // [start] GetShbInfoByShbdatabaseid
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 获取表t_shb 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbdatabaseid 数据库ID
        * @return ShbInfo对象实体
        */
        public static ShbInfo GetShbInfoByShbdatabaseid(DataProvider dp, int Shbdatabaseid)
        {
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetShbInfoByShbdatabaseid(Shbdatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_shb 中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param objShbInfo ShbInfo对象 
        */
  public static boolean Insert(ShbInfo objShbInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objShbInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_shb 中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param objShbInfo ShbInfo对象 
        */
  public static boolean Insert(DataProvider dp, ShbInfo objShbInfo)
	{
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objShbInfo);
      setShbStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_shb", "添加", objShbInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByShbdatabaseid
        // [start] UpdateByShbdatabaseid
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 更新表t_shb 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param objShbInfo ShbInfo对象 
        */
  public static boolean UpdateByShbdatabaseid(ShbInfo objShbInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByShbdatabaseid(dp, objShbInfo);
	}

	// [end]
        // [start] UpdateByShbdatabaseid
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 更新表t_shb 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param objShbInfo ShbInfo对象 
        */
  public static boolean UpdateByShbdatabaseid(DataProvider dp, ShbInfo objShbInfo)
	{
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Shbdatabaseid =  objShbInfo.getShbdatabaseid();//数据库ID  数据类型:int
      ShbInfo objOld =  dal.GetShbInfoByShbdatabaseid(Shbdatabaseid);// 读取实体信息
		dal.UpdateByShbdatabaseid(objShbInfo);
		setShbStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objShbInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objShbInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_shb", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByShbdatabaseid
        // [start] DeleteByShbdatabaseid
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 删除数据表t_shb 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbdatabaseid 数据库ID
        */
	public static boolean DeleteByShbdatabaseid(int Shbdatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByShbdatabaseid(dp, Shbdatabaseid);
	}

	// [end]
        // [start] DeleteByShbdatabaseid
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 删除数据表t_shb 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:49
        *
        * @param Shbdatabaseid 数据库ID
        */
	public static boolean DeleteByShbdatabaseid(DataProvider dp, int Shbdatabaseid)
	{
		ShbDAL dal = new ShbDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      ShbInfo objOld =  dal.GetShbInfoByShbdatabaseid(Shbdatabaseid);// 读取实体信息
		dal.DeleteByShbdatabaseid(Shbdatabaseid);
		setShbStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_shb", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}