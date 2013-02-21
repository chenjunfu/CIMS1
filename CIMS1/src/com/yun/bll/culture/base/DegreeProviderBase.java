/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:28:25
   功能说明: 表t_degree 的业务类DegreeInfo的业务层基类
   表说明:
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Degree  的实体DegreeInfo的数据操作类
 *
 */
public class DegreeProviderBase
{
	// [start] 设置和获取静态属性列表 DegreeStatic, 默认值:null
	// 设置和获取静态属性列表 DegreeStatic, 默认值:null 开始
	private static DegreeInfoCollection degreeStatic = null;
	/**
	* 获取 静态属性列表 DegreeStatic, 默认值:null
	 *
	 * @return 静态属性列表 DegreeStatic, 默认值:null
	 */
	public static DegreeInfoCollection getDegreeStatic()
	{
		if (degreeStatic == null)
		  degreeStatic = new DegreeDAL().GetListBy();
		return degreeStatic;
	}
	/**
	 * 设置 静态属性列表 DegreeStatic, 默认值:null
	 *
	 * @param sDegreeStatic
	 *            静态属性列表 DegreeStatic, 默认值:null
	 */
	public static void setDegreeStatic(DegreeInfoCollection sDegreeStatic)
	{
		degreeStatic = sDegreeStatic;
		setDegreeInfoStaticByDegreedatabaseid (null);
	}
	// 设置和获取静态属性列表 DegreeStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.DegreeInfo objDegreeInfo : getDegreeStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objDegreeInfo.getDegreedatabaseid(), objDegreeInfo.getDegreename()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetDegreeInfoStaticByDegreedatabaseid
	// [start] 设置和获取静态属性列表 DegreeInfoStaticByDegreedatabaseid, 默认值:null
	// 设置和获取静态属性列表 DegreeInfoStaticByDegreedatabaseid, 默认值:null 开始
	private static DegreeInfoCollection DegreeInfoStaticByDegreedatabaseid = null;
	/**
	* 获取 静态属性列表 DegreeInfoStaticByDegreedatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 DegreeInfoStaticByDegreedatabaseid, 默认值:null
	 */
	public static DegreeInfoCollection getDegreeInfoStaticByDegreedatabaseid()
	{
		return DegreeInfoStaticByDegreedatabaseid;
	}
	/**
	 * 设置 静态属性列表 DegreeInfoStaticByDegreedatabaseid, 默认值:null
	 *
	 * @param sDegreeInfoStaticByDegreedatabaseid
	 *            静态属性列表 DegreeInfoStaticByDegreedatabaseid, 默认值:null
	 */
	public static void setDegreeInfoStaticByDegreedatabaseid(DegreeInfoCollection sDegreeInfoStaticByDegreedatabaseid)
	{
		DegreeInfoStaticByDegreedatabaseid = sDegreeInfoStaticByDegreedatabaseid;
	}
	// 设置和获取静态属性列表 DegreeInfoStaticByDegreedatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 获取表t_degree 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreedatabaseid DegreedatabaseID
        * @return DegreeInfo对象实体
        */
        public static DegreeInfo GetDegreeInfoStaticByDegreedatabaseid(int Degreedatabaseid)
        {
            if (DegreeInfoStaticByDegreedatabaseid == null)
                DegreeInfoStaticByDegreedatabaseid = new DegreeInfoCollection();
            int allcount = DegreeInfoStaticByDegreedatabaseid.size();
            DegreeInfo objDegreeInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (DegreeInfoStaticByDegreedatabaseid == null)
                    break;
                    objDegreeInfo = DegreeInfoStaticByDegreedatabaseid.get(i);
                if (objDegreeInfo == null)
                    break;
                if (objDegreeInfo.getDegreedatabaseid() == Degreedatabaseid)
                {
                    return objDegreeInfo;
                }
            }
            DegreeInfo obj= new DegreeDAL().GetDegreeInfoByDegreedatabaseid(Degreedatabaseid);

            if (obj != null)
            {
                if (DegreeInfoStaticByDegreedatabaseid != null)
                    DegreeInfoStaticByDegreedatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new DegreeInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByDegreedatabaseid
        // [start] CountByDegreedatabaseid
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreedatabaseid DegreedatabaseID
        * @return 数据量
        */
        public static int CountByDegreedatabaseid(int Degreedatabaseid)
        {
            return new DegreeDAL().CountByDegreedatabaseid(Degreedatabaseid);
        }
        // [end]
        // [start] CountByDegreedatabaseid
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreedatabaseid DegreedatabaseID
        * @return 数据量
        */
        public static int CountByDegreedatabaseid(DataProvider dp, int Degreedatabaseid)
        {
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByDegreedatabaseid(Degreedatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new DegreeDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]
        // [start] CountByDegreeid
        // [start] CountByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreeid DegreeID
        * @return 数据量
        */
        public static int CountByDegreeid(int Degreeid)
        {
            return new DegreeDAL().CountByDegreeid(Degreeid);
        }
        // [end]
        // [start] CountByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreeid DegreeID
        * @return 数据量
        */
        public static int CountByDegreeid(DataProvider dp, int Degreeid)
        {
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByDegreeid(Degreeid);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @return 数据列表的强类型实体类
        */
        public static DegreeInfoCollection GetListBy()
        {
            return new DegreeDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @return 数据列表的强类型实体类
        */
        public static DegreeInfoCollection GetListBy(DataProvider dp )
        {
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @return 数据列表的强类型实体类
        */
        public static DegreeInfoCollection GetListBy(String OrderBy)
        {
            return new DegreeDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @return 数据列表的强类型实体类
        */
        public static DegreeInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListByDegreeid
        // [start] GetListByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreeid DegreeID
        * @return 数据列表的强类型实体类
        */
        public static DegreeInfoCollection GetListByDegreeid(int Degreeid)
        {
            return new DegreeDAL().GetListByDegreeid(Degreeid);
        }
        // [end]
        // [start] GetListByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreeid DegreeID
        * @return 数据列表的强类型实体类
        */
        public static DegreeInfoCollection GetListByDegreeid(DataProvider dp, int Degreeid)
        {
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByDegreeid(Degreeid);
        }
        // [end]
        // [start] GetListByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreeid DegreeID
        * @return 数据列表的强类型实体类
        */
        public static DegreeInfoCollection GetListByDegreeid(int Degreeid, String OrderBy)
        {
            return new DegreeDAL().GetListByDegreeid(Degreeid, OrderBy);
        }
        // [end]
        // [start] GetListByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreeid DegreeID
        * @return 数据列表的强类型实体类
        */
        public static DegreeInfoCollection GetListByDegreeid(DataProvider dp, int Degreeid, String OrderBy)
        {
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByDegreeid(Degreeid, OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @return 数据列表的强类型实体类
        */
        public static DegreeInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new DegreeDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new DegreeDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @return 数据列表的强类型实体类
        */
        public static DegreeInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new DegreeDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new DegreeDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @return 数据列表的强类型实体类
        */
        public static DegreeInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @return 数据列表的强类型实体类
        */
        public static DegreeInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListPagerByDegreeid
        // [start] GetListPagerByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreeid DegreeID
        * @return 数据列表的强类型实体类
        */
        public static DegreeInfoCollection GetListPagerByDegreeid(int Degreeid, int pageIndex, int pageSize)
        {
            return new DegreeDAL().GetListPagerByDegreeid(Degreeid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreeid DegreeID
        * @return 数据总量
        */
        public static int GetListPagerByDegreeid(int Degreeid)
        {
            return new DegreeDAL().GetListPagerByDegreeid(Degreeid);
        }
        // [end]
        // [start] GetListPagerByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreeid DegreeID
        * @return 数据列表的强类型实体类
        */
        public static DegreeInfoCollection GetListPagerByDegreeid(int Degreeid,  String OrderBy, int pageIndex, int pageSize)
        {
            return new DegreeDAL().GetListPagerByDegreeid(Degreeid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreeid DegreeID
        * @return 数据总量
        */
        public static int GetListPagerByDegreeid(int Degreeid, String OrderBy)
        {
            return new DegreeDAL().GetListPagerByDegreeid(Degreeid,  OrderBy);
        }
        // [end]
        // [start] GetListPagerByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreeid DegreeID
        * @return 数据列表的强类型实体类
        */
        public static DegreeInfoCollection GetListPagerByDegreeid(DataProvider dp,int Degreeid, int pageIndex, int pageSize)
        {
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByDegreeid(Degreeid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreeid DegreeID
        * @return 数据总量
        */
        public static int GetListPagerByDegreeid(DataProvider dp, int Degreeid)
        {
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByDegreeid(Degreeid);
        }
        // [end]
        // [start] GetListPagerByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreeid DegreeID
        * @return 数据列表的强类型实体类
        */
        public static DegreeInfoCollection GetListPagerByDegreeid(DataProvider dp, int Degreeid,  String OrderBy, int pageIndex, int pageSize)
        {
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByDegreeid(Degreeid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreeid DegreeID
        * @return 数据总量
        */
        public static int GetListPagerByDegreeid(DataProvider dp, int Degreeid, String OrderBy)
        {
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByDegreeid(Degreeid,  OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetDegreeInfoByDegreedatabaseid
        // [start] GetDegreeInfoByDegreedatabaseid
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 获取表t_degree 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreedatabaseid DegreedatabaseID
        * @return DegreeInfo对象实体
        */
        public static DegreeInfo GetDegreeInfoByDegreedatabaseid(int Degreedatabaseid)
        {
            return new DegreeDAL().GetDegreeInfoByDegreedatabaseid(Degreedatabaseid);
        }
        // [end]
        // [start] GetDegreeInfoByDegreedatabaseid
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 获取表t_degree 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreedatabaseid DegreedatabaseID
        * @return DegreeInfo对象实体
        */
        public static DegreeInfo GetDegreeInfoByDegreedatabaseid(DataProvider dp, int Degreedatabaseid)
        {
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetDegreeInfoByDegreedatabaseid(Degreedatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_degree 中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param objDegreeInfo DegreeInfo对象 
        */
  public static boolean Insert(DegreeInfo objDegreeInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objDegreeInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_degree 中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param objDegreeInfo DegreeInfo对象 
        */
  public static boolean Insert(DataProvider dp, DegreeInfo objDegreeInfo)
	{
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objDegreeInfo);
      setDegreeStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_degree", "添加", objDegreeInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByDegreedatabaseid
        // [start] UpdateByDegreedatabaseid
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 更新表t_degree 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param objDegreeInfo DegreeInfo对象 
        */
  public static boolean UpdateByDegreedatabaseid(DegreeInfo objDegreeInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByDegreedatabaseid(dp, objDegreeInfo);
	}

	// [end]
        // [start] UpdateByDegreedatabaseid
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 更新表t_degree 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param objDegreeInfo DegreeInfo对象 
        */
  public static boolean UpdateByDegreedatabaseid(DataProvider dp, DegreeInfo objDegreeInfo)
	{
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Degreedatabaseid =  objDegreeInfo.getDegreedatabaseid();//DegreedatabaseID  数据类型:int
      DegreeInfo objOld =  dal.GetDegreeInfoByDegreedatabaseid(Degreedatabaseid);// 读取实体信息
		dal.UpdateByDegreedatabaseid(objDegreeInfo);
		setDegreeStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objDegreeInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objDegreeInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_degree", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByDegreedatabaseid
        // [start] DeleteByDegreedatabaseid
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 删除数据表t_degree 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreedatabaseid DegreedatabaseID
        */
	public static boolean DeleteByDegreedatabaseid(int Degreedatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByDegreedatabaseid(dp, Degreedatabaseid);
	}

	// [end]
        // [start] DeleteByDegreedatabaseid
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 删除数据表t_degree 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:25
        *
        * @param Degreedatabaseid DegreedatabaseID
        */
	public static boolean DeleteByDegreedatabaseid(DataProvider dp, int Degreedatabaseid)
	{
		DegreeDAL dal = new DegreeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      DegreeInfo objOld =  dal.GetDegreeInfoByDegreedatabaseid(Degreedatabaseid);// 读取实体信息
		dal.DeleteByDegreedatabaseid(Degreedatabaseid);
		setDegreeStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_degree", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}