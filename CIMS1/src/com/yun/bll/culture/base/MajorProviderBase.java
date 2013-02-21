/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:30:13
   功能说明: 表t_major 专业表的业务类MajorInfo的业务层基类
   表说明:专业表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Major 专业表 的实体MajorInfo的数据操作类
 *
 */
public class MajorProviderBase
{
	// [start] 设置和获取静态属性列表 MajorStatic, 默认值:null
	// 设置和获取静态属性列表 MajorStatic, 默认值:null 开始
	private static MajorInfoCollection majorStatic = null;
	/**
	* 获取 静态属性列表 MajorStatic, 默认值:null
	 *
	 * @return 静态属性列表 MajorStatic, 默认值:null
	 */
	public static MajorInfoCollection getMajorStatic()
	{
		if (majorStatic == null)
		  majorStatic = new MajorDAL().GetListBy();
		return majorStatic;
	}
	/**
	 * 设置 静态属性列表 MajorStatic, 默认值:null
	 *
	 * @param sMajorStatic
	 *            静态属性列表 MajorStatic, 默认值:null
	 */
	public static void setMajorStatic(MajorInfoCollection sMajorStatic)
	{
		majorStatic = sMajorStatic;
		setMajorInfoStaticByMajordatabaseid (null);
	}
	// 设置和获取静态属性列表 MajorStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.MajorInfo objMajorInfo : getMajorStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objMajorInfo.getMajordatabaseid(), objMajorInfo.getMajorname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetMajorInfoStaticByMajordatabaseid
	// [start] 设置和获取静态属性列表 MajorInfoStaticByMajordatabaseid, 默认值:null
	// 设置和获取静态属性列表 MajorInfoStaticByMajordatabaseid, 默认值:null 开始
	private static MajorInfoCollection MajorInfoStaticByMajordatabaseid = null;
	/**
	* 获取 静态属性列表 MajorInfoStaticByMajordatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 MajorInfoStaticByMajordatabaseid, 默认值:null
	 */
	public static MajorInfoCollection getMajorInfoStaticByMajordatabaseid()
	{
		return MajorInfoStaticByMajordatabaseid;
	}
	/**
	 * 设置 静态属性列表 MajorInfoStaticByMajordatabaseid, 默认值:null
	 *
	 * @param sMajorInfoStaticByMajordatabaseid
	 *            静态属性列表 MajorInfoStaticByMajordatabaseid, 默认值:null
	 */
	public static void setMajorInfoStaticByMajordatabaseid(MajorInfoCollection sMajorInfoStaticByMajordatabaseid)
	{
		MajorInfoStaticByMajordatabaseid = sMajorInfoStaticByMajordatabaseid;
	}
	// 设置和获取静态属性列表 MajorInfoStaticByMajordatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 获取表t_major 专业表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majordatabaseid 专业数据库编号
        * @return MajorInfo对象实体
        */
        public static MajorInfo GetMajorInfoStaticByMajordatabaseid(int Majordatabaseid)
        {
            if (MajorInfoStaticByMajordatabaseid == null)
                MajorInfoStaticByMajordatabaseid = new MajorInfoCollection();
            int allcount = MajorInfoStaticByMajordatabaseid.size();
            MajorInfo objMajorInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (MajorInfoStaticByMajordatabaseid == null)
                    break;
                    objMajorInfo = MajorInfoStaticByMajordatabaseid.get(i);
                if (objMajorInfo == null)
                    break;
                if (objMajorInfo.getMajordatabaseid() == Majordatabaseid)
                {
                    return objMajorInfo;
                }
            }
            MajorInfo obj= new MajorDAL().GetMajorInfoByMajordatabaseid(Majordatabaseid);

            if (obj != null)
            {
                if (MajorInfoStaticByMajordatabaseid != null)
                    MajorInfoStaticByMajordatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new MajorInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByMajordatabaseid
        // [start] CountByMajordatabaseid
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majordatabaseid 专业数据库编号
        * @return 数据量
        */
        public static int CountByMajordatabaseid(int Majordatabaseid)
        {
            return new MajorDAL().CountByMajordatabaseid(Majordatabaseid);
        }
        // [end]
        // [start] CountByMajordatabaseid
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majordatabaseid 专业数据库编号
        * @return 数据量
        */
        public static int CountByMajordatabaseid(DataProvider dp, int Majordatabaseid)
        {
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByMajordatabaseid(Majordatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new MajorDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]
        // [start] CountByMajorid
        // [start] CountByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majorid 专业编号
        * @return 数据量
        */
        public static int CountByMajorid(int Majorid)
        {
            return new MajorDAL().CountByMajorid(Majorid);
        }
        // [end]
        // [start] CountByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majorid 专业编号
        * @return 数据量
        */
        public static int CountByMajorid(DataProvider dp, int Majorid)
        {
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByMajorid(Majorid);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @return 数据列表的强类型实体类
        */
        public static MajorInfoCollection GetListBy()
        {
            return new MajorDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @return 数据列表的强类型实体类
        */
        public static MajorInfoCollection GetListBy(DataProvider dp )
        {
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @return 数据列表的强类型实体类
        */
        public static MajorInfoCollection GetListBy(String OrderBy)
        {
            return new MajorDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @return 数据列表的强类型实体类
        */
        public static MajorInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListByMajorid
        // [start] GetListByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majorid 专业编号
        * @return 数据列表的强类型实体类
        */
        public static MajorInfoCollection GetListByMajorid(int Majorid)
        {
            return new MajorDAL().GetListByMajorid(Majorid);
        }
        // [end]
        // [start] GetListByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majorid 专业编号
        * @return 数据列表的强类型实体类
        */
        public static MajorInfoCollection GetListByMajorid(DataProvider dp, int Majorid)
        {
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByMajorid(Majorid);
        }
        // [end]
        // [start] GetListByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majorid 专业编号
        * @return 数据列表的强类型实体类
        */
        public static MajorInfoCollection GetListByMajorid(int Majorid, String OrderBy)
        {
            return new MajorDAL().GetListByMajorid(Majorid, OrderBy);
        }
        // [end]
        // [start] GetListByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majorid 专业编号
        * @return 数据列表的强类型实体类
        */
        public static MajorInfoCollection GetListByMajorid(DataProvider dp, int Majorid, String OrderBy)
        {
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByMajorid(Majorid, OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @return 数据列表的强类型实体类
        */
        public static MajorInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new MajorDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new MajorDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @return 数据列表的强类型实体类
        */
        public static MajorInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new MajorDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new MajorDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @return 数据列表的强类型实体类
        */
        public static MajorInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @return 数据列表的强类型实体类
        */
        public static MajorInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListPagerByMajorid
        // [start] GetListPagerByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majorid 专业编号
        * @return 数据列表的强类型实体类
        */
        public static MajorInfoCollection GetListPagerByMajorid(int Majorid, int pageIndex, int pageSize)
        {
            return new MajorDAL().GetListPagerByMajorid(Majorid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majorid 专业编号
        * @return 数据总量
        */
        public static int GetListPagerByMajorid(int Majorid)
        {
            return new MajorDAL().GetListPagerByMajorid(Majorid);
        }
        // [end]
        // [start] GetListPagerByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majorid 专业编号
        * @return 数据列表的强类型实体类
        */
        public static MajorInfoCollection GetListPagerByMajorid(int Majorid,  String OrderBy, int pageIndex, int pageSize)
        {
            return new MajorDAL().GetListPagerByMajorid(Majorid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majorid 专业编号
        * @return 数据总量
        */
        public static int GetListPagerByMajorid(int Majorid, String OrderBy)
        {
            return new MajorDAL().GetListPagerByMajorid(Majorid,  OrderBy);
        }
        // [end]
        // [start] GetListPagerByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majorid 专业编号
        * @return 数据列表的强类型实体类
        */
        public static MajorInfoCollection GetListPagerByMajorid(DataProvider dp,int Majorid, int pageIndex, int pageSize)
        {
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByMajorid(Majorid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majorid 专业编号
        * @return 数据总量
        */
        public static int GetListPagerByMajorid(DataProvider dp, int Majorid)
        {
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByMajorid(Majorid);
        }
        // [end]
        // [start] GetListPagerByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majorid 专业编号
        * @return 数据列表的强类型实体类
        */
        public static MajorInfoCollection GetListPagerByMajorid(DataProvider dp, int Majorid,  String OrderBy, int pageIndex, int pageSize)
        {
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByMajorid(Majorid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majorid 专业编号
        * @return 数据总量
        */
        public static int GetListPagerByMajorid(DataProvider dp, int Majorid, String OrderBy)
        {
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByMajorid(Majorid,  OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetMajorInfoByMajordatabaseid
        // [start] GetMajorInfoByMajordatabaseid
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 获取表t_major 专业表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majordatabaseid 专业数据库编号
        * @return MajorInfo对象实体
        */
        public static MajorInfo GetMajorInfoByMajordatabaseid(int Majordatabaseid)
        {
            return new MajorDAL().GetMajorInfoByMajordatabaseid(Majordatabaseid);
        }
        // [end]
        // [start] GetMajorInfoByMajordatabaseid
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 获取表t_major 专业表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majordatabaseid 专业数据库编号
        * @return MajorInfo对象实体
        */
        public static MajorInfo GetMajorInfoByMajordatabaseid(DataProvider dp, int Majordatabaseid)
        {
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetMajorInfoByMajordatabaseid(Majordatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_major 专业表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param objMajorInfo MajorInfo对象 专业表
        */
  public static boolean Insert(MajorInfo objMajorInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objMajorInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_major 专业表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param objMajorInfo MajorInfo对象 专业表
        */
  public static boolean Insert(DataProvider dp, MajorInfo objMajorInfo)
	{
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objMajorInfo);
      setMajorStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_major", "添加", objMajorInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByMajordatabaseid
        // [start] UpdateByMajordatabaseid
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 更新表t_major 专业表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param objMajorInfo MajorInfo对象 专业表
        */
  public static boolean UpdateByMajordatabaseid(MajorInfo objMajorInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByMajordatabaseid(dp, objMajorInfo);
	}

	// [end]
        // [start] UpdateByMajordatabaseid
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 更新表t_major 专业表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param objMajorInfo MajorInfo对象 专业表
        */
  public static boolean UpdateByMajordatabaseid(DataProvider dp, MajorInfo objMajorInfo)
	{
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Majordatabaseid =  objMajorInfo.getMajordatabaseid();//专业数据库编号  数据类型:int
      MajorInfo objOld =  dal.GetMajorInfoByMajordatabaseid(Majordatabaseid);// 读取实体信息
		dal.UpdateByMajordatabaseid(objMajorInfo);
		setMajorStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objMajorInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objMajorInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_major", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByMajordatabaseid
        // [start] DeleteByMajordatabaseid
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 删除数据表t_major 专业表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majordatabaseid 专业数据库编号
        */
	public static boolean DeleteByMajordatabaseid(int Majordatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByMajordatabaseid(dp, Majordatabaseid);
	}

	// [end]
        // [start] DeleteByMajordatabaseid
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 删除数据表t_major 专业表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:13
        *
        * @param Majordatabaseid 专业数据库编号
        */
	public static boolean DeleteByMajordatabaseid(DataProvider dp, int Majordatabaseid)
	{
		MajorDAL dal = new MajorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      MajorInfo objOld =  dal.GetMajorInfoByMajordatabaseid(Majordatabaseid);// 读取实体信息
		dal.DeleteByMajordatabaseid(Majordatabaseid);
		setMajorStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_major", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}