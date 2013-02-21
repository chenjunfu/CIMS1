/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:31:36
   功能说明: 表t_roles_competence 角色权限表的业务类RolesCompetenceInfo的业务层基类
   表说明:角色权限表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表RolesCompetence 角色权限表 的实体RolesCompetenceInfo的数据操作类
 *
 */
public class RolesCompetenceProviderBase
{
	// [start] 设置和获取静态属性列表 RolesCompetenceStatic, 默认值:null
	// 设置和获取静态属性列表 RolesCompetenceStatic, 默认值:null 开始
	private static RolesCompetenceInfoCollection rolesCompetenceStatic = null;
	/**
	* 获取 静态属性列表 RolesCompetenceStatic, 默认值:null
	 *
	 * @return 静态属性列表 RolesCompetenceStatic, 默认值:null
	 */
	public static RolesCompetenceInfoCollection getRolesCompetenceStatic()
	{
		if (rolesCompetenceStatic == null)
		  rolesCompetenceStatic = new RolesCompetenceDAL().GetListBy();
		return rolesCompetenceStatic;
	}
	/**
	 * 设置 静态属性列表 RolesCompetenceStatic, 默认值:null
	 *
	 * @param sRolesCompetenceStatic
	 *            静态属性列表 RolesCompetenceStatic, 默认值:null
	 */
	public static void setRolesCompetenceStatic(RolesCompetenceInfoCollection sRolesCompetenceStatic)
	{
		rolesCompetenceStatic = sRolesCompetenceStatic;
		setRolesCompetenceInfoStaticByDatabaserosecompetenceid (null);
	}
	// 设置和获取静态属性列表 RolesCompetenceStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.RolesCompetenceInfo objRolesCompetenceInfo : getRolesCompetenceStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objRolesCompetenceInfo.getDatabaserosecompetenceid(), objRolesCompetenceInfo.getDatabaserosecompetenceid()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetRolesCompetenceInfoStaticByDatabaserosecompetenceid
	// [start] 设置和获取静态属性列表 RolesCompetenceInfoStaticByDatabaserosecompetenceid, 默认值:null
	// 设置和获取静态属性列表 RolesCompetenceInfoStaticByDatabaserosecompetenceid, 默认值:null 开始
	private static RolesCompetenceInfoCollection RolesCompetenceInfoStaticByDatabaserosecompetenceid = null;
	/**
	* 获取 静态属性列表 RolesCompetenceInfoStaticByDatabaserosecompetenceid, 默认值:null
	 *
	 * @return 静态属性列表 RolesCompetenceInfoStaticByDatabaserosecompetenceid, 默认值:null
	 */
	public static RolesCompetenceInfoCollection getRolesCompetenceInfoStaticByDatabaserosecompetenceid()
	{
		return RolesCompetenceInfoStaticByDatabaserosecompetenceid;
	}
	/**
	 * 设置 静态属性列表 RolesCompetenceInfoStaticByDatabaserosecompetenceid, 默认值:null
	 *
	 * @param sRolesCompetenceInfoStaticByDatabaserosecompetenceid
	 *            静态属性列表 RolesCompetenceInfoStaticByDatabaserosecompetenceid, 默认值:null
	 */
	public static void setRolesCompetenceInfoStaticByDatabaserosecompetenceid(RolesCompetenceInfoCollection sRolesCompetenceInfoStaticByDatabaserosecompetenceid)
	{
		RolesCompetenceInfoStaticByDatabaserosecompetenceid = sRolesCompetenceInfoStaticByDatabaserosecompetenceid;
	}
	// 设置和获取静态属性列表 RolesCompetenceInfoStaticByDatabaserosecompetenceid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 获取表t_roles_competence 角色权限表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @param Databaserosecompetenceid 角色权限ID
        * @return RolesCompetenceInfo对象实体
        */
        public static RolesCompetenceInfo GetRolesCompetenceInfoStaticByDatabaserosecompetenceid(int Databaserosecompetenceid)
        {
            if (RolesCompetenceInfoStaticByDatabaserosecompetenceid == null)
                RolesCompetenceInfoStaticByDatabaserosecompetenceid = new RolesCompetenceInfoCollection();
            int allcount = RolesCompetenceInfoStaticByDatabaserosecompetenceid.size();
            RolesCompetenceInfo objRolesCompetenceInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (RolesCompetenceInfoStaticByDatabaserosecompetenceid == null)
                    break;
                    objRolesCompetenceInfo = RolesCompetenceInfoStaticByDatabaserosecompetenceid.get(i);
                if (objRolesCompetenceInfo == null)
                    break;
                if (objRolesCompetenceInfo.getDatabaserosecompetenceid() == Databaserosecompetenceid)
                {
                    return objRolesCompetenceInfo;
                }
            }
            RolesCompetenceInfo obj= new RolesCompetenceDAL().GetRolesCompetenceInfoByDatabaserosecompetenceid(Databaserosecompetenceid);

            if (obj != null)
            {
                if (RolesCompetenceInfoStaticByDatabaserosecompetenceid != null)
                    RolesCompetenceInfoStaticByDatabaserosecompetenceid.add(obj);
                return obj;
            }
            else
            {
                return new RolesCompetenceInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByDatabaserosecompetenceid
        // [start] CountByDatabaserosecompetenceid
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 统计表t_roles_competence 角色权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @param Databaserosecompetenceid 角色权限ID
        * @return 数据量
        */
        public static int CountByDatabaserosecompetenceid(int Databaserosecompetenceid)
        {
            return new RolesCompetenceDAL().CountByDatabaserosecompetenceid(Databaserosecompetenceid);
        }
        // [end]
        // [start] CountByDatabaserosecompetenceid
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 统计表t_roles_competence 角色权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @param Databaserosecompetenceid 角色权限ID
        * @return 数据量
        */
        public static int CountByDatabaserosecompetenceid(DataProvider dp, int Databaserosecompetenceid)
        {
		RolesCompetenceDAL dal = new RolesCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByDatabaserosecompetenceid(Databaserosecompetenceid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_roles_competence 角色权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new RolesCompetenceDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_roles_competence 角色权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		RolesCompetenceDAL dal = new RolesCompetenceDAL();
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
 返回表t_roles_competence 角色权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @return 数据列表的强类型实体类
        */
        public static RolesCompetenceInfoCollection GetListBy()
        {
            return new RolesCompetenceDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_roles_competence 角色权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @return 数据列表的强类型实体类
        */
        public static RolesCompetenceInfoCollection GetListBy(DataProvider dp )
        {
		RolesCompetenceDAL dal = new RolesCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_roles_competence 角色权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @return 数据列表的强类型实体类
        */
        public static RolesCompetenceInfoCollection GetListBy(String OrderBy)
        {
            return new RolesCompetenceDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_roles_competence 角色权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @return 数据列表的强类型实体类
        */
        public static RolesCompetenceInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		RolesCompetenceDAL dal = new RolesCompetenceDAL();
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
 返回表t_roles_competence 角色权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @return 数据列表的强类型实体类
        */
        public static RolesCompetenceInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new RolesCompetenceDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_roles_competence 角色权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new RolesCompetenceDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_roles_competence 角色权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @return 数据列表的强类型实体类
        */
        public static RolesCompetenceInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new RolesCompetenceDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_roles_competence 角色权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new RolesCompetenceDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_roles_competence 角色权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @return 数据列表的强类型实体类
        */
        public static RolesCompetenceInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		RolesCompetenceDAL dal = new RolesCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_roles_competence 角色权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		RolesCompetenceDAL dal = new RolesCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_roles_competence 角色权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @return 数据列表的强类型实体类
        */
        public static RolesCompetenceInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		RolesCompetenceDAL dal = new RolesCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_roles_competence 角色权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		RolesCompetenceDAL dal = new RolesCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetRolesCompetenceInfoByDatabaserosecompetenceid
        // [start] GetRolesCompetenceInfoByDatabaserosecompetenceid
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 获取表t_roles_competence 角色权限表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @param Databaserosecompetenceid 角色权限ID
        * @return RolesCompetenceInfo对象实体
        */
        public static RolesCompetenceInfo GetRolesCompetenceInfoByDatabaserosecompetenceid(int Databaserosecompetenceid)
        {
            return new RolesCompetenceDAL().GetRolesCompetenceInfoByDatabaserosecompetenceid(Databaserosecompetenceid);
        }
        // [end]
        // [start] GetRolesCompetenceInfoByDatabaserosecompetenceid
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 获取表t_roles_competence 角色权限表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @param Databaserosecompetenceid 角色权限ID
        * @return RolesCompetenceInfo对象实体
        */
        public static RolesCompetenceInfo GetRolesCompetenceInfoByDatabaserosecompetenceid(DataProvider dp, int Databaserosecompetenceid)
        {
		RolesCompetenceDAL dal = new RolesCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetRolesCompetenceInfoByDatabaserosecompetenceid(Databaserosecompetenceid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_roles_competence 角色权限表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @param objRolesCompetenceInfo RolesCompetenceInfo对象 角色权限表
        */
  public static boolean Insert(RolesCompetenceInfo objRolesCompetenceInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objRolesCompetenceInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_roles_competence 角色权限表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @param objRolesCompetenceInfo RolesCompetenceInfo对象 角色权限表
        */
  public static boolean Insert(DataProvider dp, RolesCompetenceInfo objRolesCompetenceInfo)
	{
		RolesCompetenceDAL dal = new RolesCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objRolesCompetenceInfo);
      setRolesCompetenceStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_roles_competence", "添加", objRolesCompetenceInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByDatabaserosecompetenceid
        // [start] UpdateByDatabaserosecompetenceid
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 更新表t_roles_competence 角色权限表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @param objRolesCompetenceInfo RolesCompetenceInfo对象 角色权限表
        */
  public static boolean UpdateByDatabaserosecompetenceid(RolesCompetenceInfo objRolesCompetenceInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByDatabaserosecompetenceid(dp, objRolesCompetenceInfo);
	}

	// [end]
        // [start] UpdateByDatabaserosecompetenceid
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 更新表t_roles_competence 角色权限表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @param objRolesCompetenceInfo RolesCompetenceInfo对象 角色权限表
        */
  public static boolean UpdateByDatabaserosecompetenceid(DataProvider dp, RolesCompetenceInfo objRolesCompetenceInfo)
	{
		RolesCompetenceDAL dal = new RolesCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Databaserosecompetenceid =  objRolesCompetenceInfo.getDatabaserosecompetenceid();//角色权限ID  数据类型:int
      RolesCompetenceInfo objOld =  dal.GetRolesCompetenceInfoByDatabaserosecompetenceid(Databaserosecompetenceid);// 读取实体信息
		dal.UpdateByDatabaserosecompetenceid(objRolesCompetenceInfo);
		setRolesCompetenceStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objRolesCompetenceInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objRolesCompetenceInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_roles_competence", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByDatabaserosecompetenceid
        // [start] DeleteByDatabaserosecompetenceid
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 删除数据表t_roles_competence 角色权限表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @param Databaserosecompetenceid 角色权限ID
        */
	public static boolean DeleteByDatabaserosecompetenceid(int Databaserosecompetenceid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByDatabaserosecompetenceid(dp, Databaserosecompetenceid);
	}

	// [end]
        // [start] DeleteByDatabaserosecompetenceid
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 删除数据表t_roles_competence 角色权限表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:36
        *
        * @param Databaserosecompetenceid 角色权限ID
        */
	public static boolean DeleteByDatabaserosecompetenceid(DataProvider dp, int Databaserosecompetenceid)
	{
		RolesCompetenceDAL dal = new RolesCompetenceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      RolesCompetenceInfo objOld =  dal.GetRolesCompetenceInfoByDatabaserosecompetenceid(Databaserosecompetenceid);// 读取实体信息
		dal.DeleteByDatabaserosecompetenceid(Databaserosecompetenceid);
		setRolesCompetenceStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_roles_competence", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}