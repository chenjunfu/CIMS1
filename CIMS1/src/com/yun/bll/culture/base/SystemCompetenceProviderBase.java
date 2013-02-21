/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:32:13
   功能说明: 表t_system_competence 权限表的业务类SystemCompetenceInfo的业务层基类
   表说明:权限表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表SystemCompetence 权限表 的实体SystemCompetenceInfo的数据操作类
 *
 */
public class SystemCompetenceProviderBase
{
	// [start] 设置和获取静态属性列表 SystemCompetenceStatic, 默认值:null
	// 设置和获取静态属性列表 SystemCompetenceStatic, 默认值:null 开始
	private static SystemCompetenceInfoCollection systemCompetenceStatic = null;
	/**
	* 获取 静态属性列表 SystemCompetenceStatic, 默认值:null
	 *
	 * @return 静态属性列表 SystemCompetenceStatic, 默认值:null
	 */
	public static SystemCompetenceInfoCollection getSystemCompetenceStatic()
	{
		if (systemCompetenceStatic == null)
		  systemCompetenceStatic = new SystemCompetenceDAL().GetListBy();
		return systemCompetenceStatic;
	}
	/**
	 * 设置 静态属性列表 SystemCompetenceStatic, 默认值:null
	 *
	 * @param sSystemCompetenceStatic
	 *            静态属性列表 SystemCompetenceStatic, 默认值:null
	 */
	public static void setSystemCompetenceStatic(SystemCompetenceInfoCollection sSystemCompetenceStatic)
	{
		systemCompetenceStatic = sSystemCompetenceStatic;
		setSystemCompetenceInfoStaticByDatabasecompetenceid (null);
	}
	// 设置和获取静态属性列表 SystemCompetenceStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.SystemCompetenceInfo objSystemCompetenceInfo : getSystemCompetenceStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objSystemCompetenceInfo.getDatabasecompetenceid(), objSystemCompetenceInfo.getCompetencename()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetSystemCompetenceInfoStaticByDatabasecompetenceid
	// [start] 设置和获取静态属性列表 SystemCompetenceInfoStaticByDatabasecompetenceid, 默认值:null
	// 设置和获取静态属性列表 SystemCompetenceInfoStaticByDatabasecompetenceid, 默认值:null 开始
	private static SystemCompetenceInfoCollection SystemCompetenceInfoStaticByDatabasecompetenceid = null;
	/**
	* 获取 静态属性列表 SystemCompetenceInfoStaticByDatabasecompetenceid, 默认值:null
	 *
	 * @return 静态属性列表 SystemCompetenceInfoStaticByDatabasecompetenceid, 默认值:null
	 */
	public static SystemCompetenceInfoCollection getSystemCompetenceInfoStaticByDatabasecompetenceid()
	{
		return SystemCompetenceInfoStaticByDatabasecompetenceid;
	}
	/**
	 * 设置 静态属性列表 SystemCompetenceInfoStaticByDatabasecompetenceid, 默认值:null
	 *
	 * @param sSystemCompetenceInfoStaticByDatabasecompetenceid
	 *            静态属性列表 SystemCompetenceInfoStaticByDatabasecompetenceid, 默认值:null
	 */
	public static void setSystemCompetenceInfoStaticByDatabasecompetenceid(SystemCompetenceInfoCollection sSystemCompetenceInfoStaticByDatabasecompetenceid)
	{
		SystemCompetenceInfoStaticByDatabasecompetenceid = sSystemCompetenceInfoStaticByDatabasecompetenceid;
	}
	// 设置和获取静态属性列表 SystemCompetenceInfoStaticByDatabasecompetenceid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 获取表t_system_competence 权限表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @param Databasecompetenceid 权限ID
        * @return SystemCompetenceInfo对象实体
        */
        public static SystemCompetenceInfo GetSystemCompetenceInfoStaticByDatabasecompetenceid(int Databasecompetenceid)
        {
            if (SystemCompetenceInfoStaticByDatabasecompetenceid == null)
                SystemCompetenceInfoStaticByDatabasecompetenceid = new SystemCompetenceInfoCollection();
            int allcount = SystemCompetenceInfoStaticByDatabasecompetenceid.size();
            SystemCompetenceInfo objSystemCompetenceInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (SystemCompetenceInfoStaticByDatabasecompetenceid == null)
                    break;
                    objSystemCompetenceInfo = SystemCompetenceInfoStaticByDatabasecompetenceid.get(i);
                if (objSystemCompetenceInfo == null)
                    break;
                if (objSystemCompetenceInfo.getDatabasecompetenceid() == Databasecompetenceid)
                {
                    return objSystemCompetenceInfo;
                }
            }
            SystemCompetenceInfo obj= new SystemCompetenceDAL().GetSystemCompetenceInfoByDatabasecompetenceid(Databasecompetenceid);

            if (obj != null)
            {
                if (SystemCompetenceInfoStaticByDatabasecompetenceid != null)
                    SystemCompetenceInfoStaticByDatabasecompetenceid.add(obj);
                return obj;
            }
            else
            {
                return new SystemCompetenceInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByDatabasecompetenceid
        // [start] CountByDatabasecompetenceid
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 统计表t_system_competence 权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @param Databasecompetenceid 权限ID
        * @return 数据量
        */
        public static int CountByDatabasecompetenceid(int Databasecompetenceid)
        {
            return new SystemCompetenceDAL().CountByDatabasecompetenceid(Databasecompetenceid);
        }
        // [end]
        // [start] CountByDatabasecompetenceid
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 统计表t_system_competence 权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @param Databasecompetenceid 权限ID
        * @return 数据量
        */
        public static int CountByDatabasecompetenceid(DataProvider dp, int Databasecompetenceid)
        {
		SystemCompetenceDAL dal = new SystemCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByDatabasecompetenceid(Databasecompetenceid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_competence 权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new SystemCompetenceDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_competence 权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		SystemCompetenceDAL dal = new SystemCompetenceDAL();
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
 返回表t_system_competence 权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemCompetenceInfoCollection GetListBy()
        {
            return new SystemCompetenceDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_competence 权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemCompetenceInfoCollection GetListBy(DataProvider dp )
        {
		SystemCompetenceDAL dal = new SystemCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_competence 权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemCompetenceInfoCollection GetListBy(String OrderBy)
        {
            return new SystemCompetenceDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_competence 权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemCompetenceInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		SystemCompetenceDAL dal = new SystemCompetenceDAL();
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
 返回表t_system_competence 权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemCompetenceInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new SystemCompetenceDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_competence 权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new SystemCompetenceDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_competence 权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemCompetenceInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new SystemCompetenceDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_competence 权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new SystemCompetenceDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_competence 权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemCompetenceInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		SystemCompetenceDAL dal = new SystemCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_competence 权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		SystemCompetenceDAL dal = new SystemCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_competence 权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @return 数据列表的强类型实体类
        */
        public static SystemCompetenceInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		SystemCompetenceDAL dal = new SystemCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_competence 权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		SystemCompetenceDAL dal = new SystemCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetSystemCompetenceInfoByDatabasecompetenceid
        // [start] GetSystemCompetenceInfoByDatabasecompetenceid
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 获取表t_system_competence 权限表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @param Databasecompetenceid 权限ID
        * @return SystemCompetenceInfo对象实体
        */
        public static SystemCompetenceInfo GetSystemCompetenceInfoByDatabasecompetenceid(int Databasecompetenceid)
        {
            return new SystemCompetenceDAL().GetSystemCompetenceInfoByDatabasecompetenceid(Databasecompetenceid);
        }
        // [end]
        // [start] GetSystemCompetenceInfoByDatabasecompetenceid
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 获取表t_system_competence 权限表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @param Databasecompetenceid 权限ID
        * @return SystemCompetenceInfo对象实体
        */
        public static SystemCompetenceInfo GetSystemCompetenceInfoByDatabasecompetenceid(DataProvider dp, int Databasecompetenceid)
        {
		SystemCompetenceDAL dal = new SystemCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetSystemCompetenceInfoByDatabasecompetenceid(Databasecompetenceid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_system_competence 权限表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @param objSystemCompetenceInfo SystemCompetenceInfo对象 权限表
        */
  public static boolean Insert(SystemCompetenceInfo objSystemCompetenceInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objSystemCompetenceInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_system_competence 权限表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @param objSystemCompetenceInfo SystemCompetenceInfo对象 权限表
        */
  public static boolean Insert(DataProvider dp, SystemCompetenceInfo objSystemCompetenceInfo)
	{
		SystemCompetenceDAL dal = new SystemCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objSystemCompetenceInfo);
      setSystemCompetenceStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_system_competence", "添加", objSystemCompetenceInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByDatabasecompetenceid
        // [start] UpdateByDatabasecompetenceid
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 更新表t_system_competence 权限表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @param objSystemCompetenceInfo SystemCompetenceInfo对象 权限表
        */
  public static boolean UpdateByDatabasecompetenceid(SystemCompetenceInfo objSystemCompetenceInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByDatabasecompetenceid(dp, objSystemCompetenceInfo);
	}

	// [end]
        // [start] UpdateByDatabasecompetenceid
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 更新表t_system_competence 权限表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @param objSystemCompetenceInfo SystemCompetenceInfo对象 权限表
        */
  public static boolean UpdateByDatabasecompetenceid(DataProvider dp, SystemCompetenceInfo objSystemCompetenceInfo)
	{
		SystemCompetenceDAL dal = new SystemCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Databasecompetenceid =  objSystemCompetenceInfo.getDatabasecompetenceid();//权限ID  数据类型:int
      SystemCompetenceInfo objOld =  dal.GetSystemCompetenceInfoByDatabasecompetenceid(Databasecompetenceid);// 读取实体信息
		dal.UpdateByDatabasecompetenceid(objSystemCompetenceInfo);
		setSystemCompetenceStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objSystemCompetenceInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objSystemCompetenceInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_system_competence", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByDatabasecompetenceid
        // [start] DeleteByDatabasecompetenceid
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 删除数据表t_system_competence 权限表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @param Databasecompetenceid 权限ID
        */
	public static boolean DeleteByDatabasecompetenceid(int Databasecompetenceid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByDatabasecompetenceid(dp, Databasecompetenceid);
	}

	// [end]
        // [start] DeleteByDatabasecompetenceid
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 删除数据表t_system_competence 权限表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:32:13
        *
        * @param Databasecompetenceid 权限ID
        */
	public static boolean DeleteByDatabasecompetenceid(DataProvider dp, int Databasecompetenceid)
	{
		SystemCompetenceDAL dal = new SystemCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      SystemCompetenceInfo objOld =  dal.GetSystemCompetenceInfoByDatabasecompetenceid(Databasecompetenceid);// 读取实体信息
		dal.DeleteByDatabasecompetenceid(Databasecompetenceid);
		setSystemCompetenceStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_system_competence", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}