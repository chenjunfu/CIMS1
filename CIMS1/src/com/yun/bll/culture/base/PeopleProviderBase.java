/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:30:37
   功能说明: 表t_people 人员表的业务类PeopleInfo的业务层基类
   表说明:人员表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表People 人员表 的实体PeopleInfo的数据操作类
 *
 */
public class PeopleProviderBase
{
	// [start] 设置和获取静态属性列表 PeopleStatic, 默认值:null
	// 设置和获取静态属性列表 PeopleStatic, 默认值:null 开始
	private static PeopleInfoCollection peopleStatic = null;
	/**
	* 获取 静态属性列表 PeopleStatic, 默认值:null
	 *
	 * @return 静态属性列表 PeopleStatic, 默认值:null
	 */
	public static PeopleInfoCollection getPeopleStatic()
	{
		if (peopleStatic == null)
		  peopleStatic = new PeopleDAL().GetListBy();
		return peopleStatic;
	}
	/**
	 * 设置 静态属性列表 PeopleStatic, 默认值:null
	 *
	 * @param sPeopleStatic
	 *            静态属性列表 PeopleStatic, 默认值:null
	 */
	public static void setPeopleStatic(PeopleInfoCollection sPeopleStatic)
	{
		peopleStatic = sPeopleStatic;
		setPeopleInfoStaticByDatabasepeopleid (null);
	}
	// 设置和获取静态属性列表 PeopleStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.PeopleInfo objPeopleInfo : getPeopleStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objPeopleInfo.getDatabasepeopleid(), objPeopleInfo.getPeoplename()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetPeopleInfoStaticByDatabasepeopleid
	// [start] 设置和获取静态属性列表 PeopleInfoStaticByDatabasepeopleid, 默认值:null
	// 设置和获取静态属性列表 PeopleInfoStaticByDatabasepeopleid, 默认值:null 开始
	private static PeopleInfoCollection PeopleInfoStaticByDatabasepeopleid = null;
	/**
	* 获取 静态属性列表 PeopleInfoStaticByDatabasepeopleid, 默认值:null
	 *
	 * @return 静态属性列表 PeopleInfoStaticByDatabasepeopleid, 默认值:null
	 */
	public static PeopleInfoCollection getPeopleInfoStaticByDatabasepeopleid()
	{
		return PeopleInfoStaticByDatabasepeopleid;
	}
	/**
	 * 设置 静态属性列表 PeopleInfoStaticByDatabasepeopleid, 默认值:null
	 *
	 * @param sPeopleInfoStaticByDatabasepeopleid
	 *            静态属性列表 PeopleInfoStaticByDatabasepeopleid, 默认值:null
	 */
	public static void setPeopleInfoStaticByDatabasepeopleid(PeopleInfoCollection sPeopleInfoStaticByDatabasepeopleid)
	{
		PeopleInfoStaticByDatabasepeopleid = sPeopleInfoStaticByDatabasepeopleid;
	}
	// 设置和获取静态属性列表 PeopleInfoStaticByDatabasepeopleid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 获取表t_people 人员表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @param Databasepeopleid 人员ID
        * @return PeopleInfo对象实体
        */
        public static PeopleInfo GetPeopleInfoStaticByDatabasepeopleid(int Databasepeopleid)
        {
            if (PeopleInfoStaticByDatabasepeopleid == null)
                PeopleInfoStaticByDatabasepeopleid = new PeopleInfoCollection();
            int allcount = PeopleInfoStaticByDatabasepeopleid.size();
            PeopleInfo objPeopleInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (PeopleInfoStaticByDatabasepeopleid == null)
                    break;
                    objPeopleInfo = PeopleInfoStaticByDatabasepeopleid.get(i);
                if (objPeopleInfo == null)
                    break;
                if (objPeopleInfo.getDatabasepeopleid() == Databasepeopleid)
                {
                    return objPeopleInfo;
                }
            }
            PeopleInfo obj= new PeopleDAL().GetPeopleInfoByDatabasepeopleid(Databasepeopleid);

            if (obj != null)
            {
                if (PeopleInfoStaticByDatabasepeopleid != null)
                    PeopleInfoStaticByDatabasepeopleid.add(obj);
                return obj;
            }
            else
            {
                return new PeopleInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByDatabasepeopleid
        // [start] CountByDatabasepeopleid
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 统计表t_people 人员表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @param Databasepeopleid 人员ID
        * @return 数据量
        */
        public static int CountByDatabasepeopleid(int Databasepeopleid)
        {
            return new PeopleDAL().CountByDatabasepeopleid(Databasepeopleid);
        }
        // [end]
        // [start] CountByDatabasepeopleid
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 统计表t_people 人员表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @param Databasepeopleid 人员ID
        * @return 数据量
        */
        public static int CountByDatabasepeopleid(DataProvider dp, int Databasepeopleid)
        {
		PeopleDAL dal = new PeopleDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByDatabasepeopleid(Databasepeopleid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_people 人员表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new PeopleDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_people 人员表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		PeopleDAL dal = new PeopleDAL();
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
 返回表t_people 人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @return 数据列表的强类型实体类
        */
        public static PeopleInfoCollection GetListBy()
        {
            return new PeopleDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_people 人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @return 数据列表的强类型实体类
        */
        public static PeopleInfoCollection GetListBy(DataProvider dp )
        {
		PeopleDAL dal = new PeopleDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_people 人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @return 数据列表的强类型实体类
        */
        public static PeopleInfoCollection GetListBy(String OrderBy)
        {
            return new PeopleDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_people 人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @return 数据列表的强类型实体类
        */
        public static PeopleInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		PeopleDAL dal = new PeopleDAL();
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
 返回表t_people 人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @return 数据列表的强类型实体类
        */
        public static PeopleInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new PeopleDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_people 人员表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new PeopleDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_people 人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @return 数据列表的强类型实体类
        */
        public static PeopleInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new PeopleDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_people 人员表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new PeopleDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_people 人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @return 数据列表的强类型实体类
        */
        public static PeopleInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		PeopleDAL dal = new PeopleDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_people 人员表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		PeopleDAL dal = new PeopleDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_people 人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @return 数据列表的强类型实体类
        */
        public static PeopleInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		PeopleDAL dal = new PeopleDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_people 人员表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		PeopleDAL dal = new PeopleDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetPeopleInfoByDatabasepeopleid
        // [start] GetPeopleInfoByDatabasepeopleid
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 获取表t_people 人员表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @param Databasepeopleid 人员ID
        * @return PeopleInfo对象实体
        */
        public static PeopleInfo GetPeopleInfoByDatabasepeopleid(int Databasepeopleid)
        {
            return new PeopleDAL().GetPeopleInfoByDatabasepeopleid(Databasepeopleid);
        }
        // [end]
        // [start] GetPeopleInfoByDatabasepeopleid
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 获取表t_people 人员表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @param Databasepeopleid 人员ID
        * @return PeopleInfo对象实体
        */
        public static PeopleInfo GetPeopleInfoByDatabasepeopleid(DataProvider dp, int Databasepeopleid)
        {
		PeopleDAL dal = new PeopleDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetPeopleInfoByDatabasepeopleid(Databasepeopleid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_people 人员表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @param objPeopleInfo PeopleInfo对象 人员表
        */
  public static boolean Insert(PeopleInfo objPeopleInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objPeopleInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_people 人员表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @param objPeopleInfo PeopleInfo对象 人员表
        */
  public static boolean Insert(DataProvider dp, PeopleInfo objPeopleInfo)
	{
		PeopleDAL dal = new PeopleDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objPeopleInfo);
      setPeopleStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_people", "添加", objPeopleInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByDatabasepeopleid
        // [start] UpdateByDatabasepeopleid
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 更新表t_people 人员表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @param objPeopleInfo PeopleInfo对象 人员表
        */
  public static boolean UpdateByDatabasepeopleid(PeopleInfo objPeopleInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByDatabasepeopleid(dp, objPeopleInfo);
	}

	// [end]
        // [start] UpdateByDatabasepeopleid
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 更新表t_people 人员表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @param objPeopleInfo PeopleInfo对象 人员表
        */
  public static boolean UpdateByDatabasepeopleid(DataProvider dp, PeopleInfo objPeopleInfo)
	{
		PeopleDAL dal = new PeopleDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Databasepeopleid =  objPeopleInfo.getDatabasepeopleid();//人员ID  数据类型:int
      PeopleInfo objOld =  dal.GetPeopleInfoByDatabasepeopleid(Databasepeopleid);// 读取实体信息
		dal.UpdateByDatabasepeopleid(objPeopleInfo);
		setPeopleStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objPeopleInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objPeopleInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_people", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByDatabasepeopleid
        // [start] DeleteByDatabasepeopleid
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 删除数据表t_people 人员表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @param Databasepeopleid 人员ID
        */
	public static boolean DeleteByDatabasepeopleid(int Databasepeopleid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByDatabasepeopleid(dp, Databasepeopleid);
	}

	// [end]
        // [start] DeleteByDatabasepeopleid
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 删除数据表t_people 人员表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:37
        *
        * @param Databasepeopleid 人员ID
        */
	public static boolean DeleteByDatabasepeopleid(DataProvider dp, int Databasepeopleid)
	{
		PeopleDAL dal = new PeopleDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      PeopleInfo objOld =  dal.GetPeopleInfoByDatabasepeopleid(Databasepeopleid);// 读取实体信息
		dal.DeleteByDatabasepeopleid(Databasepeopleid);
		setPeopleStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_people", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}