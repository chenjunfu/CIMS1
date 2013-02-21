/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月26日 17:59:44
   功能说明: 表t_talent 文化人才表的业务类TalentInfo的业务层基类
   表说明:文化人才表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Talent 文化人才表 的实体TalentInfo的数据操作类
 *
 */
public class TalentProviderBase
{
	// [start] 设置和获取静态属性列表 TalentStatic, 默认值:null
	// 设置和获取静态属性列表 TalentStatic, 默认值:null 开始
	private static TalentInfoCollection talentStatic = null;
	/**
	* 获取 静态属性列表 TalentStatic, 默认值:null
	 *
	 * @return 静态属性列表 TalentStatic, 默认值:null
	 */
	public static TalentInfoCollection getTalentStatic()
	{
		if (talentStatic == null)
		  talentStatic = new TalentDAL().GetListBy();
		return talentStatic;
	}
	/**
	 * 设置 静态属性列表 TalentStatic, 默认值:null
	 *
	 * @param sTalentStatic
	 *            静态属性列表 TalentStatic, 默认值:null
	 */
	public static void setTalentStatic(TalentInfoCollection sTalentStatic)
	{
		talentStatic = sTalentStatic;
		setTalentInfoStaticByDatabasetalentid (null);
	}
	// 设置和获取静态属性列表 TalentStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.TalentInfo objTalentInfo : getTalentStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objTalentInfo.getDatabasetalentid(), objTalentInfo.getTalentname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetTalentInfoStaticByDatabasetalentid
	// [start] 设置和获取静态属性列表 TalentInfoStaticByDatabasetalentid, 默认值:null
	// 设置和获取静态属性列表 TalentInfoStaticByDatabasetalentid, 默认值:null 开始
	private static TalentInfoCollection TalentInfoStaticByDatabasetalentid = null;
	/**
	* 获取 静态属性列表 TalentInfoStaticByDatabasetalentid, 默认值:null
	 *
	 * @return 静态属性列表 TalentInfoStaticByDatabasetalentid, 默认值:null
	 */
	public static TalentInfoCollection getTalentInfoStaticByDatabasetalentid()
	{
		return TalentInfoStaticByDatabasetalentid;
	}
	/**
	 * 设置 静态属性列表 TalentInfoStaticByDatabasetalentid, 默认值:null
	 *
	 * @param sTalentInfoStaticByDatabasetalentid
	 *            静态属性列表 TalentInfoStaticByDatabasetalentid, 默认值:null
	 */
	public static void setTalentInfoStaticByDatabasetalentid(TalentInfoCollection sTalentInfoStaticByDatabasetalentid)
	{
		TalentInfoStaticByDatabasetalentid = sTalentInfoStaticByDatabasetalentid;
	}
	// 设置和获取静态属性列表 TalentInfoStaticByDatabasetalentid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 获取表t_talent 文化人才表的对象<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @param Databasetalentid databasetalentid
        * @return TalentInfo对象实体
        */
        public static TalentInfo GetTalentInfoStaticByDatabasetalentid(int Databasetalentid)
        {
            if (TalentInfoStaticByDatabasetalentid == null)
                TalentInfoStaticByDatabasetalentid = new TalentInfoCollection();
            int allcount = TalentInfoStaticByDatabasetalentid.size();
            TalentInfo objTalentInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (TalentInfoStaticByDatabasetalentid == null)
                    break;
                    objTalentInfo = TalentInfoStaticByDatabasetalentid.get(i);
                if (objTalentInfo == null)
                    break;
                if (objTalentInfo.getDatabasetalentid() == Databasetalentid)
                {
                    return objTalentInfo;
                }
            }
            TalentInfo obj= new TalentDAL().GetTalentInfoByDatabasetalentid(Databasetalentid);

            if (obj != null)
            {
                if (TalentInfoStaticByDatabasetalentid != null)
                    TalentInfoStaticByDatabasetalentid.add(obj);
                return obj;
            }
            else
            {
                return new TalentInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByDatabasetalentid
        // [start] CountByDatabasetalentid
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 统计表t_talent 文化人才表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @param Databasetalentid databasetalentid
        * @return 数据量
        */
        public static int CountByDatabasetalentid(int Databasetalentid)
        {
            return new TalentDAL().CountByDatabasetalentid(Databasetalentid);
        }
        // [end]
        // [start] CountByDatabasetalentid
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 统计表t_talent 文化人才表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @param Databasetalentid databasetalentid
        * @return 数据量
        */
        public static int CountByDatabasetalentid(DataProvider dp, int Databasetalentid)
        {
		TalentDAL dal = new TalentDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByDatabasetalentid(Databasetalentid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_talent 文化人才表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new TalentDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_talent 文化人才表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		TalentDAL dal = new TalentDAL();
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
 返回表t_talent 文化人才表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @return 数据列表的强类型实体类
        */
        public static TalentInfoCollection GetListBy()
        {
            return new TalentDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_talent 文化人才表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @return 数据列表的强类型实体类
        */
        public static TalentInfoCollection GetListBy(DataProvider dp )
        {
		TalentDAL dal = new TalentDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_talent 文化人才表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @return 数据列表的强类型实体类
        */
        public static TalentInfoCollection GetListBy(String OrderBy)
        {
            return new TalentDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_talent 文化人才表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @return 数据列表的强类型实体类
        */
        public static TalentInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		TalentDAL dal = new TalentDAL();
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
 返回表t_talent 文化人才表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @return 数据列表的强类型实体类
        */
        public static TalentInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new TalentDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_talent 文化人才表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new TalentDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_talent 文化人才表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @return 数据列表的强类型实体类
        */
        public static TalentInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new TalentDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_talent 文化人才表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new TalentDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_talent 文化人才表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @return 数据列表的强类型实体类
        */
        public static TalentInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		TalentDAL dal = new TalentDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_talent 文化人才表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		TalentDAL dal = new TalentDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_talent 文化人才表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @return 数据列表的强类型实体类
        */
        public static TalentInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		TalentDAL dal = new TalentDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_talent 文化人才表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		TalentDAL dal = new TalentDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetTalentInfoByDatabasetalentid
        // [start] GetTalentInfoByDatabasetalentid
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 获取表t_talent 文化人才表的对象<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @param Databasetalentid databasetalentid
        * @return TalentInfo对象实体
        */
        public static TalentInfo GetTalentInfoByDatabasetalentid(int Databasetalentid)
        {
            return new TalentDAL().GetTalentInfoByDatabasetalentid(Databasetalentid);
        }
        // [end]
        // [start] GetTalentInfoByDatabasetalentid
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 获取表t_talent 文化人才表的对象<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @param Databasetalentid databasetalentid
        * @return TalentInfo对象实体
        */
        public static TalentInfo GetTalentInfoByDatabasetalentid(DataProvider dp, int Databasetalentid)
        {
		TalentDAL dal = new TalentDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetTalentInfoByDatabasetalentid(Databasetalentid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_talent 文化人才表中插入数据<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @param objTalentInfo TalentInfo对象 文化人才表
        */
  public static boolean Insert(TalentInfo objTalentInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objTalentInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_talent 文化人才表中插入数据<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @param objTalentInfo TalentInfo对象 文化人才表
        */
  public static boolean Insert(DataProvider dp, TalentInfo objTalentInfo)
	{
		TalentDAL dal = new TalentDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objTalentInfo);
      setTalentStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_talent", "添加", objTalentInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByDatabasetalentid
        // [start] UpdateByDatabasetalentid
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 更新表t_talent 文化人才表中的内容<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @param objTalentInfo TalentInfo对象 文化人才表
        */
  public static boolean UpdateByDatabasetalentid(TalentInfo objTalentInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByDatabasetalentid(dp, objTalentInfo);
	}

	// [end]
        // [start] UpdateByDatabasetalentid
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 更新表t_talent 文化人才表中的内容<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @param objTalentInfo TalentInfo对象 文化人才表
        */
  public static boolean UpdateByDatabasetalentid(DataProvider dp, TalentInfo objTalentInfo)
	{
		TalentDAL dal = new TalentDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Databasetalentid =  objTalentInfo.getDatabasetalentid();//databasetalentid  数据类型:int
      TalentInfo objOld =  dal.GetTalentInfoByDatabasetalentid(Databasetalentid);// 读取实体信息
		dal.UpdateByDatabasetalentid(objTalentInfo);
		setTalentStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objTalentInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objTalentInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_talent", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByDatabasetalentid
        // [start] DeleteByDatabasetalentid
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 删除数据表t_talent 文化人才表中的内容<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @param Databasetalentid databasetalentid
        */
	public static boolean DeleteByDatabasetalentid(int Databasetalentid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByDatabasetalentid(dp, Databasetalentid);
	}

	// [end]
        // [start] DeleteByDatabasetalentid
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 删除数据表t_talent 文化人才表中的内容<br />
        * 开发者 贾军磊 2012年12月26日 17:59:44
        *
        * @param Databasetalentid databasetalentid
        */
	public static boolean DeleteByDatabasetalentid(DataProvider dp, int Databasetalentid)
	{
		TalentDAL dal = new TalentDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		
		TalentInfo objOld =  dal.GetTalentInfoByDatabasetalentid(Databasetalentid);// 读取实体信息
		dal.DeleteByDatabasetalentid(Databasetalentid);
		setTalentStatic(null);

		com.yun.common.TableLog.AddLog(dp, "t_talent", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}