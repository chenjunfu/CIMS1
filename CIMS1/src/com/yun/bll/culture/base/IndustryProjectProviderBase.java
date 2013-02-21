/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月26日 10:59:01
   功能说明: 表t_industry_project 文化项目表的业务类IndustryProjectInfo的业务层基类
   表说明:文化项目表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表IndustryProject 文化项目表 的实体IndustryProjectInfo的数据操作类
 *
 */
public class IndustryProjectProviderBase
{
	// [start] 设置和获取静态属性列表 IndustryProjectStatic, 默认值:null
	// 设置和获取静态属性列表 IndustryProjectStatic, 默认值:null 开始
	private static IndustryProjectInfoCollection industryProjectStatic = null;
	/**
	* 获取 静态属性列表 IndustryProjectStatic, 默认值:null
	 *
	 * @return 静态属性列表 IndustryProjectStatic, 默认值:null
	 */
	public static IndustryProjectInfoCollection getIndustryProjectStatic()
	{
		if (industryProjectStatic == null)
		  industryProjectStatic = new IndustryProjectDAL().GetListBy();
		return industryProjectStatic;
	}
	/**
	 * 设置 静态属性列表 IndustryProjectStatic, 默认值:null
	 *
	 * @param sIndustryProjectStatic
	 *            静态属性列表 IndustryProjectStatic, 默认值:null
	 */
	public static void setIndustryProjectStatic(IndustryProjectInfoCollection sIndustryProjectStatic)
	{
		industryProjectStatic = sIndustryProjectStatic;
		setIndustryProjectInfoStaticByDatabaseprojectid (null);
	}
	// 设置和获取静态属性列表 IndustryProjectStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.IndustryProjectInfo objIndustryProjectInfo : getIndustryProjectStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objIndustryProjectInfo.getDatabaseprojectid(), objIndustryProjectInfo.getProjectname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetIndustryProjectInfoStaticByDatabaseprojectid
	// [start] 设置和获取静态属性列表 IndustryProjectInfoStaticByDatabaseprojectid, 默认值:null
	// 设置和获取静态属性列表 IndustryProjectInfoStaticByDatabaseprojectid, 默认值:null 开始
	private static IndustryProjectInfoCollection IndustryProjectInfoStaticByDatabaseprojectid = null;
	/**
	* 获取 静态属性列表 IndustryProjectInfoStaticByDatabaseprojectid, 默认值:null
	 *
	 * @return 静态属性列表 IndustryProjectInfoStaticByDatabaseprojectid, 默认值:null
	 */
	public static IndustryProjectInfoCollection getIndustryProjectInfoStaticByDatabaseprojectid()
	{
		return IndustryProjectInfoStaticByDatabaseprojectid;
	}
	/**
	 * 设置 静态属性列表 IndustryProjectInfoStaticByDatabaseprojectid, 默认值:null
	 *
	 * @param sIndustryProjectInfoStaticByDatabaseprojectid
	 *            静态属性列表 IndustryProjectInfoStaticByDatabaseprojectid, 默认值:null
	 */
	public static void setIndustryProjectInfoStaticByDatabaseprojectid(IndustryProjectInfoCollection sIndustryProjectInfoStaticByDatabaseprojectid)
	{
		IndustryProjectInfoStaticByDatabaseprojectid = sIndustryProjectInfoStaticByDatabaseprojectid;
	}
	// 设置和获取静态属性列表 IndustryProjectInfoStaticByDatabaseprojectid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 获取表t_industry_project 文化项目表的对象<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @param Databaseprojectid 项目ID
        * @return IndustryProjectInfo对象实体
        */
        public static IndustryProjectInfo GetIndustryProjectInfoStaticByDatabaseprojectid(int Databaseprojectid)
        {
            if (IndustryProjectInfoStaticByDatabaseprojectid == null)
                IndustryProjectInfoStaticByDatabaseprojectid = new IndustryProjectInfoCollection();
            int allcount = IndustryProjectInfoStaticByDatabaseprojectid.size();
            IndustryProjectInfo objIndustryProjectInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (IndustryProjectInfoStaticByDatabaseprojectid == null)
                    break;
                    objIndustryProjectInfo = IndustryProjectInfoStaticByDatabaseprojectid.get(i);
                if (objIndustryProjectInfo == null)
                    break;
                if (objIndustryProjectInfo.getDatabaseprojectid() == Databaseprojectid)
                {
                    return objIndustryProjectInfo;
                }
            }
            IndustryProjectInfo obj= new IndustryProjectDAL().GetIndustryProjectInfoByDatabaseprojectid(Databaseprojectid);

            if (obj != null)
            {
                if (IndustryProjectInfoStaticByDatabaseprojectid != null)
                    IndustryProjectInfoStaticByDatabaseprojectid.add(obj);
                return obj;
            }
            else
            {
                return new IndustryProjectInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByDatabaseprojectid
        // [start] CountByDatabaseprojectid
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 统计表t_industry_project 文化项目表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @param Databaseprojectid 项目ID
        * @return 数据量
        */
        public static int CountByDatabaseprojectid(int Databaseprojectid)
        {
            return new IndustryProjectDAL().CountByDatabaseprojectid(Databaseprojectid);
        }
        // [end]
        // [start] CountByDatabaseprojectid
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 统计表t_industry_project 文化项目表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @param Databaseprojectid 项目ID
        * @return 数据量
        */
        public static int CountByDatabaseprojectid(DataProvider dp, int Databaseprojectid)
        {
		IndustryProjectDAL dal = new IndustryProjectDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByDatabaseprojectid(Databaseprojectid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_industry_project 文化项目表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new IndustryProjectDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_industry_project 文化项目表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		IndustryProjectDAL dal = new IndustryProjectDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_project 文化项目表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryProjectInfoCollection GetListBy()
        {
            return new IndustryProjectDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_project 文化项目表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryProjectInfoCollection GetListBy(DataProvider dp )
        {
		IndustryProjectDAL dal = new IndustryProjectDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_project 文化项目表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryProjectInfoCollection GetListBy(String OrderBy)
        {
            return new IndustryProjectDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_project 文化项目表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryProjectInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		IndustryProjectDAL dal = new IndustryProjectDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_project 文化项目表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryProjectInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new IndustryProjectDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_project 文化项目表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new IndustryProjectDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_project 文化项目表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryProjectInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new IndustryProjectDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_project 文化项目表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new IndustryProjectDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_project 文化项目表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryProjectInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		IndustryProjectDAL dal = new IndustryProjectDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_project 文化项目表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		IndustryProjectDAL dal = new IndustryProjectDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_project 文化项目表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryProjectInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		IndustryProjectDAL dal = new IndustryProjectDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_project 文化项目表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		IndustryProjectDAL dal = new IndustryProjectDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetIndustryProjectInfoByDatabaseprojectid
        // [start] GetIndustryProjectInfoByDatabaseprojectid
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 获取表t_industry_project 文化项目表的对象<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @param Databaseprojectid 项目ID
        * @return IndustryProjectInfo对象实体
        */
        public static IndustryProjectInfo GetIndustryProjectInfoByDatabaseprojectid(int Databaseprojectid)
        {
            return new IndustryProjectDAL().GetIndustryProjectInfoByDatabaseprojectid(Databaseprojectid);
        }
        // [end]
        // [start] GetIndustryProjectInfoByDatabaseprojectid
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 获取表t_industry_project 文化项目表的对象<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @param Databaseprojectid 项目ID
        * @return IndustryProjectInfo对象实体
        */
        public static IndustryProjectInfo GetIndustryProjectInfoByDatabaseprojectid(DataProvider dp, int Databaseprojectid)
        {
		IndustryProjectDAL dal = new IndustryProjectDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetIndustryProjectInfoByDatabaseprojectid(Databaseprojectid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_industry_project 文化项目表中插入数据<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @param objIndustryProjectInfo IndustryProjectInfo对象 文化项目表
        */
  public static boolean Insert(IndustryProjectInfo objIndustryProjectInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objIndustryProjectInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_industry_project 文化项目表中插入数据<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @param objIndustryProjectInfo IndustryProjectInfo对象 文化项目表
        */
  public static boolean Insert(DataProvider dp, IndustryProjectInfo objIndustryProjectInfo)
	{
		IndustryProjectDAL dal = new IndustryProjectDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		int identity=dal.Insert(objIndustryProjectInfo);
		objIndustryProjectInfo.setDatabaseenterpriseid(identity);
		 setIndustryProjectStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_industry_project", "添加", objIndustryProjectInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByDatabaseprojectid
        // [start] UpdateByDatabaseprojectid
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 更新表t_industry_project 文化项目表中的内容<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @param objIndustryProjectInfo IndustryProjectInfo对象 文化项目表
        */
  public static boolean UpdateByDatabaseprojectid(IndustryProjectInfo objIndustryProjectInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByDatabaseprojectid(dp, objIndustryProjectInfo);
	}

	// [end]
        // [start] UpdateByDatabaseprojectid
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 更新表t_industry_project 文化项目表中的内容<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @param objIndustryProjectInfo IndustryProjectInfo对象 文化项目表
        */
  public static boolean UpdateByDatabaseprojectid(DataProvider dp, IndustryProjectInfo objIndustryProjectInfo)
	{
		IndustryProjectDAL dal = new IndustryProjectDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Databaseprojectid =  objIndustryProjectInfo.getDatabaseprojectid();//项目ID  数据类型:int
      IndustryProjectInfo objOld =  dal.GetIndustryProjectInfoByDatabaseprojectid(Databaseprojectid);// 读取实体信息
		dal.UpdateByDatabaseprojectid(objIndustryProjectInfo);
		setIndustryProjectStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objIndustryProjectInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objIndustryProjectInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_industry_project", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByDatabaseprojectid
        // [start] DeleteByDatabaseprojectid
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 删除数据表t_industry_project 文化项目表中的内容<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @param Databaseprojectid 项目ID
        */
	public static boolean DeleteByDatabaseprojectid(int Databaseprojectid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByDatabaseprojectid(dp, Databaseprojectid);
	}

	// [end]
        // [start] DeleteByDatabaseprojectid
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 删除数据表t_industry_project 文化项目表中的内容<br />
        * 开发者 贾军磊 2012年12月26日 10:59:01
        *
        * @param Databaseprojectid 项目ID
        */
	public static boolean DeleteByDatabaseprojectid(DataProvider dp, int Databaseprojectid)
	{
		IndustryProjectDAL dal = new IndustryProjectDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      IndustryProjectInfo objOld =  dal.GetIndustryProjectInfoByDatabaseprojectid(Databaseprojectid);// 读取实体信息
		dal.DeleteByDatabaseprojectid(Databaseprojectid);
		setIndustryProjectStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_industry_project", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}