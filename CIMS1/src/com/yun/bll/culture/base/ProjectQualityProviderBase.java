/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:31:15
   功能说明: 表t_project_quality 项目性质的业务类ProjectQualityInfo的业务层基类
   表说明:项目性质
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表ProjectQuality 项目性质 的实体ProjectQualityInfo的数据操作类
 *
 */
public class ProjectQualityProviderBase
{
	// [start] 设置和获取静态属性列表 ProjectQualityStatic, 默认值:null
	// 设置和获取静态属性列表 ProjectQualityStatic, 默认值:null 开始
	private static ProjectQualityInfoCollection projectQualityStatic = null;
	/**
	* 获取 静态属性列表 ProjectQualityStatic, 默认值:null
	 *
	 * @return 静态属性列表 ProjectQualityStatic, 默认值:null
	 */
	public static ProjectQualityInfoCollection getProjectQualityStatic()
	{
		if (projectQualityStatic == null)
		  projectQualityStatic = new ProjectQualityDAL().GetListBy();
		return projectQualityStatic;
	}
	/**
	 * 设置 静态属性列表 ProjectQualityStatic, 默认值:null
	 *
	 * @param sProjectQualityStatic
	 *            静态属性列表 ProjectQualityStatic, 默认值:null
	 */
	public static void setProjectQualityStatic(ProjectQualityInfoCollection sProjectQualityStatic)
	{
		projectQualityStatic = sProjectQualityStatic;
		setProjectQualityInfoStaticByProqulidatabaseid (null);
	}
	// 设置和获取静态属性列表 ProjectQualityStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.ProjectQualityInfo objProjectQualityInfo : getProjectQualityStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objProjectQualityInfo.getProqulidatabaseid(), objProjectQualityInfo.getProquliname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetProjectQualityInfoStaticByProqulidatabaseid
	// [start] 设置和获取静态属性列表 ProjectQualityInfoStaticByProqulidatabaseid, 默认值:null
	// 设置和获取静态属性列表 ProjectQualityInfoStaticByProqulidatabaseid, 默认值:null 开始
	private static ProjectQualityInfoCollection ProjectQualityInfoStaticByProqulidatabaseid = null;
	/**
	* 获取 静态属性列表 ProjectQualityInfoStaticByProqulidatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 ProjectQualityInfoStaticByProqulidatabaseid, 默认值:null
	 */
	public static ProjectQualityInfoCollection getProjectQualityInfoStaticByProqulidatabaseid()
	{
		return ProjectQualityInfoStaticByProqulidatabaseid;
	}
	/**
	 * 设置 静态属性列表 ProjectQualityInfoStaticByProqulidatabaseid, 默认值:null
	 *
	 * @param sProjectQualityInfoStaticByProqulidatabaseid
	 *            静态属性列表 ProjectQualityInfoStaticByProqulidatabaseid, 默认值:null
	 */
	public static void setProjectQualityInfoStaticByProqulidatabaseid(ProjectQualityInfoCollection sProjectQualityInfoStaticByProqulidatabaseid)
	{
		ProjectQualityInfoStaticByProqulidatabaseid = sProjectQualityInfoStaticByProqulidatabaseid;
	}
	// 设置和获取静态属性列表 ProjectQualityInfoStaticByProqulidatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 获取表t_project_quality 项目性质的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proqulidatabaseid 数据库ID
        * @return ProjectQualityInfo对象实体
        */
        public static ProjectQualityInfo GetProjectQualityInfoStaticByProqulidatabaseid(int Proqulidatabaseid)
        {
            if (ProjectQualityInfoStaticByProqulidatabaseid == null)
                ProjectQualityInfoStaticByProqulidatabaseid = new ProjectQualityInfoCollection();
            int allcount = ProjectQualityInfoStaticByProqulidatabaseid.size();
            ProjectQualityInfo objProjectQualityInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (ProjectQualityInfoStaticByProqulidatabaseid == null)
                    break;
                    objProjectQualityInfo = ProjectQualityInfoStaticByProqulidatabaseid.get(i);
                if (objProjectQualityInfo == null)
                    break;
                if (objProjectQualityInfo.getProqulidatabaseid() == Proqulidatabaseid)
                {
                    return objProjectQualityInfo;
                }
            }
            ProjectQualityInfo obj= new ProjectQualityDAL().GetProjectQualityInfoByProqulidatabaseid(Proqulidatabaseid);

            if (obj != null)
            {
                if (ProjectQualityInfoStaticByProqulidatabaseid != null)
                    ProjectQualityInfoStaticByProqulidatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new ProjectQualityInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByProqulidatabaseid
        // [start] CountByProqulidatabaseid
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proqulidatabaseid 数据库ID
        * @return 数据量
        */
        public static int CountByProqulidatabaseid(int Proqulidatabaseid)
        {
            return new ProjectQualityDAL().CountByProqulidatabaseid(Proqulidatabaseid);
        }
        // [end]
        // [start] CountByProqulidatabaseid
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proqulidatabaseid 数据库ID
        * @return 数据量
        */
        public static int CountByProqulidatabaseid(DataProvider dp, int Proqulidatabaseid)
        {
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByProqulidatabaseid(Proqulidatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new ProjectQualityDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]
        // [start] CountByProquliid
        // [start] CountByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proquliid 项目性质ID
        * @return 数据量
        */
        public static int CountByProquliid(int Proquliid)
        {
            return new ProjectQualityDAL().CountByProquliid(Proquliid);
        }
        // [end]
        // [start] CountByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proquliid 项目性质ID
        * @return 数据量
        */
        public static int CountByProquliid(DataProvider dp, int Proquliid)
        {
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByProquliid(Proquliid);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @return 数据列表的强类型实体类
        */
        public static ProjectQualityInfoCollection GetListBy()
        {
            return new ProjectQualityDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @return 数据列表的强类型实体类
        */
        public static ProjectQualityInfoCollection GetListBy(DataProvider dp )
        {
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @return 数据列表的强类型实体类
        */
        public static ProjectQualityInfoCollection GetListBy(String OrderBy)
        {
            return new ProjectQualityDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @return 数据列表的强类型实体类
        */
        public static ProjectQualityInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListByProquliid
        // [start] GetListByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proquliid 项目性质ID
        * @return 数据列表的强类型实体类
        */
        public static ProjectQualityInfoCollection GetListByProquliid(int Proquliid)
        {
            return new ProjectQualityDAL().GetListByProquliid(Proquliid);
        }
        // [end]
        // [start] GetListByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proquliid 项目性质ID
        * @return 数据列表的强类型实体类
        */
        public static ProjectQualityInfoCollection GetListByProquliid(DataProvider dp, int Proquliid)
        {
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByProquliid(Proquliid);
        }
        // [end]
        // [start] GetListByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proquliid 项目性质ID
        * @return 数据列表的强类型实体类
        */
        public static ProjectQualityInfoCollection GetListByProquliid(int Proquliid, String OrderBy)
        {
            return new ProjectQualityDAL().GetListByProquliid(Proquliid, OrderBy);
        }
        // [end]
        // [start] GetListByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proquliid 项目性质ID
        * @return 数据列表的强类型实体类
        */
        public static ProjectQualityInfoCollection GetListByProquliid(DataProvider dp, int Proquliid, String OrderBy)
        {
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByProquliid(Proquliid, OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @return 数据列表的强类型实体类
        */
        public static ProjectQualityInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new ProjectQualityDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new ProjectQualityDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @return 数据列表的强类型实体类
        */
        public static ProjectQualityInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new ProjectQualityDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new ProjectQualityDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @return 数据列表的强类型实体类
        */
        public static ProjectQualityInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @return 数据列表的强类型实体类
        */
        public static ProjectQualityInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListPagerByProquliid
        // [start] GetListPagerByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proquliid 项目性质ID
        * @return 数据列表的强类型实体类
        */
        public static ProjectQualityInfoCollection GetListPagerByProquliid(int Proquliid, int pageIndex, int pageSize)
        {
            return new ProjectQualityDAL().GetListPagerByProquliid(Proquliid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proquliid 项目性质ID
        * @return 数据总量
        */
        public static int GetListPagerByProquliid(int Proquliid)
        {
            return new ProjectQualityDAL().GetListPagerByProquliid(Proquliid);
        }
        // [end]
        // [start] GetListPagerByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proquliid 项目性质ID
        * @return 数据列表的强类型实体类
        */
        public static ProjectQualityInfoCollection GetListPagerByProquliid(int Proquliid,  String OrderBy, int pageIndex, int pageSize)
        {
            return new ProjectQualityDAL().GetListPagerByProquliid(Proquliid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proquliid 项目性质ID
        * @return 数据总量
        */
        public static int GetListPagerByProquliid(int Proquliid, String OrderBy)
        {
            return new ProjectQualityDAL().GetListPagerByProquliid(Proquliid,  OrderBy);
        }
        // [end]
        // [start] GetListPagerByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proquliid 项目性质ID
        * @return 数据列表的强类型实体类
        */
        public static ProjectQualityInfoCollection GetListPagerByProquliid(DataProvider dp,int Proquliid, int pageIndex, int pageSize)
        {
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByProquliid(Proquliid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proquliid 项目性质ID
        * @return 数据总量
        */
        public static int GetListPagerByProquliid(DataProvider dp, int Proquliid)
        {
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByProquliid(Proquliid);
        }
        // [end]
        // [start] GetListPagerByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proquliid 项目性质ID
        * @return 数据列表的强类型实体类
        */
        public static ProjectQualityInfoCollection GetListPagerByProquliid(DataProvider dp, int Proquliid,  String OrderBy, int pageIndex, int pageSize)
        {
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByProquliid(Proquliid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proquliid 项目性质ID
        * @return 数据总量
        */
        public static int GetListPagerByProquliid(DataProvider dp, int Proquliid, String OrderBy)
        {
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByProquliid(Proquliid,  OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetProjectQualityInfoByProqulidatabaseid
        // [start] GetProjectQualityInfoByProqulidatabaseid
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 获取表t_project_quality 项目性质的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proqulidatabaseid 数据库ID
        * @return ProjectQualityInfo对象实体
        */
        public static ProjectQualityInfo GetProjectQualityInfoByProqulidatabaseid(int Proqulidatabaseid)
        {
            return new ProjectQualityDAL().GetProjectQualityInfoByProqulidatabaseid(Proqulidatabaseid);
        }
        // [end]
        // [start] GetProjectQualityInfoByProqulidatabaseid
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 获取表t_project_quality 项目性质的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proqulidatabaseid 数据库ID
        * @return ProjectQualityInfo对象实体
        */
        public static ProjectQualityInfo GetProjectQualityInfoByProqulidatabaseid(DataProvider dp, int Proqulidatabaseid)
        {
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetProjectQualityInfoByProqulidatabaseid(Proqulidatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_project_quality 项目性质中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param objProjectQualityInfo ProjectQualityInfo对象 项目性质
        */
  public static boolean Insert(ProjectQualityInfo objProjectQualityInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objProjectQualityInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_project_quality 项目性质中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param objProjectQualityInfo ProjectQualityInfo对象 项目性质
        */
  public static boolean Insert(DataProvider dp, ProjectQualityInfo objProjectQualityInfo)
	{
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objProjectQualityInfo);
      setProjectQualityStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_project_quality", "添加", objProjectQualityInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByProqulidatabaseid
        // [start] UpdateByProqulidatabaseid
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 更新表t_project_quality 项目性质中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param objProjectQualityInfo ProjectQualityInfo对象 项目性质
        */
  public static boolean UpdateByProqulidatabaseid(ProjectQualityInfo objProjectQualityInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByProqulidatabaseid(dp, objProjectQualityInfo);
	}

	// [end]
        // [start] UpdateByProqulidatabaseid
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 更新表t_project_quality 项目性质中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param objProjectQualityInfo ProjectQualityInfo对象 项目性质
        */
  public static boolean UpdateByProqulidatabaseid(DataProvider dp, ProjectQualityInfo objProjectQualityInfo)
	{
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Proqulidatabaseid =  objProjectQualityInfo.getProqulidatabaseid();//数据库ID  数据类型:int
      ProjectQualityInfo objOld =  dal.GetProjectQualityInfoByProqulidatabaseid(Proqulidatabaseid);// 读取实体信息
		dal.UpdateByProqulidatabaseid(objProjectQualityInfo);
		setProjectQualityStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objProjectQualityInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objProjectQualityInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_project_quality", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByProqulidatabaseid
        // [start] DeleteByProqulidatabaseid
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 删除数据表t_project_quality 项目性质中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proqulidatabaseid 数据库ID
        */
	public static boolean DeleteByProqulidatabaseid(int Proqulidatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByProqulidatabaseid(dp, Proqulidatabaseid);
	}

	// [end]
        // [start] DeleteByProqulidatabaseid
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 删除数据表t_project_quality 项目性质中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:15
        *
        * @param Proqulidatabaseid 数据库ID
        */
	public static boolean DeleteByProqulidatabaseid(DataProvider dp, int Proqulidatabaseid)
	{
		ProjectQualityDAL dal = new ProjectQualityDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      ProjectQualityInfo objOld =  dal.GetProjectQualityInfoByProqulidatabaseid(Proqulidatabaseid);// 读取实体信息
		dal.DeleteByProqulidatabaseid(Proqulidatabaseid);
		setProjectQualityStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_project_quality", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}