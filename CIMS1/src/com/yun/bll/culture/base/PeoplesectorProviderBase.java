/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:30:47
   功能说明: 表t_peoplesector 部门信息表的业务类PeoplesectorInfo的业务层基类
   表说明:部门信息表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Peoplesector 部门信息表 的实体PeoplesectorInfo的数据操作类
 *
 */
public class PeoplesectorProviderBase
{
	// [start] 设置和获取静态属性列表 PeoplesectorStatic, 默认值:null
	// 设置和获取静态属性列表 PeoplesectorStatic, 默认值:null 开始
	private static PeoplesectorInfoCollection peoplesectorStatic = null;
	/**
	* 获取 静态属性列表 PeoplesectorStatic, 默认值:null
	 *
	 * @return 静态属性列表 PeoplesectorStatic, 默认值:null
	 */
	public static PeoplesectorInfoCollection getPeoplesectorStatic()
	{
		if (peoplesectorStatic == null)
		  peoplesectorStatic = new PeoplesectorDAL().GetListBy();
		return peoplesectorStatic;
	}
	/**
	 * 设置 静态属性列表 PeoplesectorStatic, 默认值:null
	 *
	 * @param sPeoplesectorStatic
	 *            静态属性列表 PeoplesectorStatic, 默认值:null
	 */
	public static void setPeoplesectorStatic(PeoplesectorInfoCollection sPeoplesectorStatic)
	{
		peoplesectorStatic = sPeoplesectorStatic;
		setPeoplesectorInfoStaticByDatabasepeoplesectorid (null);
	}
	// 设置和获取静态属性列表 PeoplesectorStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.PeoplesectorInfo objPeoplesectorInfo : getPeoplesectorStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objPeoplesectorInfo.getDatabasepeoplesectorid(), objPeoplesectorInfo.getPeoplesectorname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetPeoplesectorInfoStaticByDatabasepeoplesectorid
	// [start] 设置和获取静态属性列表 PeoplesectorInfoStaticByDatabasepeoplesectorid, 默认值:null
	// 设置和获取静态属性列表 PeoplesectorInfoStaticByDatabasepeoplesectorid, 默认值:null 开始
	private static PeoplesectorInfoCollection PeoplesectorInfoStaticByDatabasepeoplesectorid = null;
	/**
	* 获取 静态属性列表 PeoplesectorInfoStaticByDatabasepeoplesectorid, 默认值:null
	 *
	 * @return 静态属性列表 PeoplesectorInfoStaticByDatabasepeoplesectorid, 默认值:null
	 */
	public static PeoplesectorInfoCollection getPeoplesectorInfoStaticByDatabasepeoplesectorid()
	{
		return PeoplesectorInfoStaticByDatabasepeoplesectorid;
	}
	/**
	 * 设置 静态属性列表 PeoplesectorInfoStaticByDatabasepeoplesectorid, 默认值:null
	 *
	 * @param sPeoplesectorInfoStaticByDatabasepeoplesectorid
	 *            静态属性列表 PeoplesectorInfoStaticByDatabasepeoplesectorid, 默认值:null
	 */
	public static void setPeoplesectorInfoStaticByDatabasepeoplesectorid(PeoplesectorInfoCollection sPeoplesectorInfoStaticByDatabasepeoplesectorid)
	{
		PeoplesectorInfoStaticByDatabasepeoplesectorid = sPeoplesectorInfoStaticByDatabasepeoplesectorid;
	}
	// 设置和获取静态属性列表 PeoplesectorInfoStaticByDatabasepeoplesectorid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 获取表t_peoplesector 部门信息表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @param Databasepeoplesectorid 部门ID
        * @return PeoplesectorInfo对象实体
        */
        public static PeoplesectorInfo GetPeoplesectorInfoStaticByDatabasepeoplesectorid(int Databasepeoplesectorid)
        {
            if (PeoplesectorInfoStaticByDatabasepeoplesectorid == null)
                PeoplesectorInfoStaticByDatabasepeoplesectorid = new PeoplesectorInfoCollection();
            int allcount = PeoplesectorInfoStaticByDatabasepeoplesectorid.size();
            PeoplesectorInfo objPeoplesectorInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (PeoplesectorInfoStaticByDatabasepeoplesectorid == null)
                    break;
                    objPeoplesectorInfo = PeoplesectorInfoStaticByDatabasepeoplesectorid.get(i);
                if (objPeoplesectorInfo == null)
                    break;
                if (objPeoplesectorInfo.getDatabasepeoplesectorid() == Databasepeoplesectorid)
                {
                    return objPeoplesectorInfo;
                }
            }
            PeoplesectorInfo obj= new PeoplesectorDAL().GetPeoplesectorInfoByDatabasepeoplesectorid(Databasepeoplesectorid);

            if (obj != null)
            {
                if (PeoplesectorInfoStaticByDatabasepeoplesectorid != null)
                    PeoplesectorInfoStaticByDatabasepeoplesectorid.add(obj);
                return obj;
            }
            else
            {
                return new PeoplesectorInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByDatabasepeoplesectorid
        // [start] CountByDatabasepeoplesectorid
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 统计表t_peoplesector 部门信息表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @param Databasepeoplesectorid 部门ID
        * @return 数据量
        */
        public static int CountByDatabasepeoplesectorid(int Databasepeoplesectorid)
        {
            return new PeoplesectorDAL().CountByDatabasepeoplesectorid(Databasepeoplesectorid);
        }
        // [end]
        // [start] CountByDatabasepeoplesectorid
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 统计表t_peoplesector 部门信息表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @param Databasepeoplesectorid 部门ID
        * @return 数据量
        */
        public static int CountByDatabasepeoplesectorid(DataProvider dp, int Databasepeoplesectorid)
        {
		PeoplesectorDAL dal = new PeoplesectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByDatabasepeoplesectorid(Databasepeoplesectorid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_peoplesector 部门信息表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new PeoplesectorDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_peoplesector 部门信息表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		PeoplesectorDAL dal = new PeoplesectorDAL();
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
 返回表t_peoplesector 部门信息表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @return 数据列表的强类型实体类
        */
        public static PeoplesectorInfoCollection GetListBy()
        {
            return new PeoplesectorDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_peoplesector 部门信息表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @return 数据列表的强类型实体类
        */
        public static PeoplesectorInfoCollection GetListBy(DataProvider dp )
        {
		PeoplesectorDAL dal = new PeoplesectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_peoplesector 部门信息表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @return 数据列表的强类型实体类
        */
        public static PeoplesectorInfoCollection GetListBy(String OrderBy)
        {
            return new PeoplesectorDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_peoplesector 部门信息表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @return 数据列表的强类型实体类
        */
        public static PeoplesectorInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		PeoplesectorDAL dal = new PeoplesectorDAL();
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
 返回表t_peoplesector 部门信息表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @return 数据列表的强类型实体类
        */
        public static PeoplesectorInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new PeoplesectorDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_peoplesector 部门信息表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new PeoplesectorDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_peoplesector 部门信息表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @return 数据列表的强类型实体类
        */
        public static PeoplesectorInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new PeoplesectorDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_peoplesector 部门信息表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new PeoplesectorDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_peoplesector 部门信息表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @return 数据列表的强类型实体类
        */
        public static PeoplesectorInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		PeoplesectorDAL dal = new PeoplesectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_peoplesector 部门信息表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		PeoplesectorDAL dal = new PeoplesectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_peoplesector 部门信息表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @return 数据列表的强类型实体类
        */
        public static PeoplesectorInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		PeoplesectorDAL dal = new PeoplesectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_peoplesector 部门信息表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		PeoplesectorDAL dal = new PeoplesectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetPeoplesectorInfoByDatabasepeoplesectorid
        // [start] GetPeoplesectorInfoByDatabasepeoplesectorid
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 获取表t_peoplesector 部门信息表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @param Databasepeoplesectorid 部门ID
        * @return PeoplesectorInfo对象实体
        */
        public static PeoplesectorInfo GetPeoplesectorInfoByDatabasepeoplesectorid(int Databasepeoplesectorid)
        {
            return new PeoplesectorDAL().GetPeoplesectorInfoByDatabasepeoplesectorid(Databasepeoplesectorid);
        }
        // [end]
        // [start] GetPeoplesectorInfoByDatabasepeoplesectorid
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 获取表t_peoplesector 部门信息表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @param Databasepeoplesectorid 部门ID
        * @return PeoplesectorInfo对象实体
        */
        public static PeoplesectorInfo GetPeoplesectorInfoByDatabasepeoplesectorid(DataProvider dp, int Databasepeoplesectorid)
        {
		PeoplesectorDAL dal = new PeoplesectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetPeoplesectorInfoByDatabasepeoplesectorid(Databasepeoplesectorid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_peoplesector 部门信息表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @param objPeoplesectorInfo PeoplesectorInfo对象 部门信息表
        */
  public static boolean Insert(PeoplesectorInfo objPeoplesectorInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objPeoplesectorInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_peoplesector 部门信息表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @param objPeoplesectorInfo PeoplesectorInfo对象 部门信息表
        */
  public static boolean Insert(DataProvider dp, PeoplesectorInfo objPeoplesectorInfo)
	{
		PeoplesectorDAL dal = new PeoplesectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objPeoplesectorInfo);
      setPeoplesectorStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_peoplesector", "添加", objPeoplesectorInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByDatabasepeoplesectorid
        // [start] UpdateByDatabasepeoplesectorid
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 更新表t_peoplesector 部门信息表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @param objPeoplesectorInfo PeoplesectorInfo对象 部门信息表
        */
  public static boolean UpdateByDatabasepeoplesectorid(PeoplesectorInfo objPeoplesectorInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByDatabasepeoplesectorid(dp, objPeoplesectorInfo);
	}

	// [end]
        // [start] UpdateByDatabasepeoplesectorid
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 更新表t_peoplesector 部门信息表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @param objPeoplesectorInfo PeoplesectorInfo对象 部门信息表
        */
  public static boolean UpdateByDatabasepeoplesectorid(DataProvider dp, PeoplesectorInfo objPeoplesectorInfo)
	{
		PeoplesectorDAL dal = new PeoplesectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Databasepeoplesectorid =  objPeoplesectorInfo.getDatabasepeoplesectorid();//部门ID  数据类型:int
      PeoplesectorInfo objOld =  dal.GetPeoplesectorInfoByDatabasepeoplesectorid(Databasepeoplesectorid);// 读取实体信息
		dal.UpdateByDatabasepeoplesectorid(objPeoplesectorInfo);
		setPeoplesectorStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objPeoplesectorInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objPeoplesectorInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_peoplesector", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByDatabasepeoplesectorid
        // [start] DeleteByDatabasepeoplesectorid
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 删除数据表t_peoplesector 部门信息表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @param Databasepeoplesectorid 部门ID
        */
	public static boolean DeleteByDatabasepeoplesectorid(int Databasepeoplesectorid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByDatabasepeoplesectorid(dp, Databasepeoplesectorid);
	}

	// [end]
        // [start] DeleteByDatabasepeoplesectorid
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 删除数据表t_peoplesector 部门信息表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:47
        *
        * @param Databasepeoplesectorid 部门ID
        */
	public static boolean DeleteByDatabasepeoplesectorid(DataProvider dp, int Databasepeoplesectorid)
	{
		PeoplesectorDAL dal = new PeoplesectorDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      PeoplesectorInfo objOld =  dal.GetPeoplesectorInfoByDatabasepeoplesectorid(Databasepeoplesectorid);// 读取实体信息
		dal.DeleteByDatabasepeoplesectorid(Databasepeoplesectorid);
		setPeoplesectorStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_peoplesector", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}