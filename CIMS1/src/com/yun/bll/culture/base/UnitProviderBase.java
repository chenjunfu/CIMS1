/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:33:23
   功能说明: 表t_unit 单位信息的业务类UnitInfo的业务层基类
   表说明:单位信息
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Unit 单位信息 的实体UnitInfo的数据操作类
 *
 */
public class UnitProviderBase
{
	// [start] 设置和获取静态属性列表 UnitStatic, 默认值:null
	// 设置和获取静态属性列表 UnitStatic, 默认值:null 开始
	private static UnitInfoCollection unitStatic = null;
	/**
	* 获取 静态属性列表 UnitStatic, 默认值:null
	 *
	 * @return 静态属性列表 UnitStatic, 默认值:null
	 */
	public static UnitInfoCollection getUnitStatic()
	{
		if (unitStatic == null)
		  unitStatic = new UnitDAL().GetListBy();
		return unitStatic;
	}
	/**
	 * 设置 静态属性列表 UnitStatic, 默认值:null
	 *
	 * @param sUnitStatic
	 *            静态属性列表 UnitStatic, 默认值:null
	 */
	public static void setUnitStatic(UnitInfoCollection sUnitStatic)
	{
		unitStatic = sUnitStatic;
		setUnitInfoStaticByDatabaseunitid (null);
	}
	// 设置和获取静态属性列表 UnitStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.UnitInfo objUnitInfo : getUnitStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objUnitInfo.getDatabaseunitid(), objUnitInfo.getUnitname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetUnitInfoStaticByDatabaseunitid
	// [start] 设置和获取静态属性列表 UnitInfoStaticByDatabaseunitid, 默认值:null
	// 设置和获取静态属性列表 UnitInfoStaticByDatabaseunitid, 默认值:null 开始
	private static UnitInfoCollection UnitInfoStaticByDatabaseunitid = null;
	/**
	* 获取 静态属性列表 UnitInfoStaticByDatabaseunitid, 默认值:null
	 *
	 * @return 静态属性列表 UnitInfoStaticByDatabaseunitid, 默认值:null
	 */
	public static UnitInfoCollection getUnitInfoStaticByDatabaseunitid()
	{
		return UnitInfoStaticByDatabaseunitid;
	}
	/**
	 * 设置 静态属性列表 UnitInfoStaticByDatabaseunitid, 默认值:null
	 *
	 * @param sUnitInfoStaticByDatabaseunitid
	 *            静态属性列表 UnitInfoStaticByDatabaseunitid, 默认值:null
	 */
	public static void setUnitInfoStaticByDatabaseunitid(UnitInfoCollection sUnitInfoStaticByDatabaseunitid)
	{
		UnitInfoStaticByDatabaseunitid = sUnitInfoStaticByDatabaseunitid;
	}
	// 设置和获取静态属性列表 UnitInfoStaticByDatabaseunitid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 获取表t_unit 单位信息的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @param Databaseunitid 单位ID
        * @return UnitInfo对象实体
        */
        public static UnitInfo GetUnitInfoStaticByDatabaseunitid(int Databaseunitid)
        {
            if (UnitInfoStaticByDatabaseunitid == null)
                UnitInfoStaticByDatabaseunitid = new UnitInfoCollection();
            int allcount = UnitInfoStaticByDatabaseunitid.size();
            UnitInfo objUnitInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (UnitInfoStaticByDatabaseunitid == null)
                    break;
                    objUnitInfo = UnitInfoStaticByDatabaseunitid.get(i);
                if (objUnitInfo == null)
                    break;
                if (objUnitInfo.getDatabaseunitid() == Databaseunitid)
                {
                    return objUnitInfo;
                }
            }
            UnitInfo obj= new UnitDAL().GetUnitInfoByDatabaseunitid(Databaseunitid);

            if (obj != null)
            {
                if (UnitInfoStaticByDatabaseunitid != null)
                    UnitInfoStaticByDatabaseunitid.add(obj);
                return obj;
            }
            else
            {
                return new UnitInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByDatabaseunitid
        // [start] CountByDatabaseunitid
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 统计表t_unit 单位信息的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @param Databaseunitid 单位ID
        * @return 数据量
        */
        public static int CountByDatabaseunitid(int Databaseunitid)
        {
            return new UnitDAL().CountByDatabaseunitid(Databaseunitid);
        }
        // [end]
        // [start] CountByDatabaseunitid
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 统计表t_unit 单位信息的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @param Databaseunitid 单位ID
        * @return 数据量
        */
        public static int CountByDatabaseunitid(DataProvider dp, int Databaseunitid)
        {
		UnitDAL dal = new UnitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByDatabaseunitid(Databaseunitid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_unit 单位信息的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new UnitDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_unit 单位信息的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		UnitDAL dal = new UnitDAL();
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
 返回表t_unit 单位信息的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @return 数据列表的强类型实体类
        */
        public static UnitInfoCollection GetListBy()
        {
            return new UnitDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_unit 单位信息的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @return 数据列表的强类型实体类
        */
        public static UnitInfoCollection GetListBy(DataProvider dp )
        {
		UnitDAL dal = new UnitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_unit 单位信息的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @return 数据列表的强类型实体类
        */
        public static UnitInfoCollection GetListBy(String OrderBy)
        {
            return new UnitDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_unit 单位信息的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @return 数据列表的强类型实体类
        */
        public static UnitInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		UnitDAL dal = new UnitDAL();
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
 返回表t_unit 单位信息的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @return 数据列表的强类型实体类
        */
        public static UnitInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new UnitDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_unit 单位信息的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new UnitDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_unit 单位信息的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @return 数据列表的强类型实体类
        */
        public static UnitInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new UnitDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_unit 单位信息的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new UnitDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_unit 单位信息的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @return 数据列表的强类型实体类
        */
        public static UnitInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		UnitDAL dal = new UnitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_unit 单位信息的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		UnitDAL dal = new UnitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_unit 单位信息的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @return 数据列表的强类型实体类
        */
        public static UnitInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		UnitDAL dal = new UnitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_unit 单位信息的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		UnitDAL dal = new UnitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetUnitInfoByDatabaseunitid
        // [start] GetUnitInfoByDatabaseunitid
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 获取表t_unit 单位信息的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @param Databaseunitid 单位ID
        * @return UnitInfo对象实体
        */
        public static UnitInfo GetUnitInfoByDatabaseunitid(int Databaseunitid)
        {
            return new UnitDAL().GetUnitInfoByDatabaseunitid(Databaseunitid);
        }
        // [end]
        // [start] GetUnitInfoByDatabaseunitid
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 获取表t_unit 单位信息的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @param Databaseunitid 单位ID
        * @return UnitInfo对象实体
        */
        public static UnitInfo GetUnitInfoByDatabaseunitid(DataProvider dp, int Databaseunitid)
        {
		UnitDAL dal = new UnitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetUnitInfoByDatabaseunitid(Databaseunitid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_unit 单位信息中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @param objUnitInfo UnitInfo对象 单位信息
        */
  public static boolean Insert(UnitInfo objUnitInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objUnitInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_unit 单位信息中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @param objUnitInfo UnitInfo对象 单位信息
        */
  public static boolean Insert(DataProvider dp, UnitInfo objUnitInfo)
	{
		UnitDAL dal = new UnitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objUnitInfo);
      setUnitStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_unit", "添加", objUnitInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByDatabaseunitid
        // [start] UpdateByDatabaseunitid
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 更新表t_unit 单位信息中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @param objUnitInfo UnitInfo对象 单位信息
        */
  public static boolean UpdateByDatabaseunitid(UnitInfo objUnitInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByDatabaseunitid(dp, objUnitInfo);
	}

	// [end]
        // [start] UpdateByDatabaseunitid
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 更新表t_unit 单位信息中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @param objUnitInfo UnitInfo对象 单位信息
        */
  public static boolean UpdateByDatabaseunitid(DataProvider dp, UnitInfo objUnitInfo)
	{
		UnitDAL dal = new UnitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Databaseunitid =  objUnitInfo.getDatabaseunitid();//单位ID  数据类型:int
      UnitInfo objOld =  dal.GetUnitInfoByDatabaseunitid(Databaseunitid);// 读取实体信息
		dal.UpdateByDatabaseunitid(objUnitInfo);
		setUnitStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objUnitInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objUnitInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_unit", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByDatabaseunitid
        // [start] DeleteByDatabaseunitid
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 删除数据表t_unit 单位信息中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @param Databaseunitid 单位ID
        */
	public static boolean DeleteByDatabaseunitid(int Databaseunitid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByDatabaseunitid(dp, Databaseunitid);
	}

	// [end]
        // [start] DeleteByDatabaseunitid
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 删除数据表t_unit 单位信息中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:33:23
        *
        * @param Databaseunitid 单位ID
        */
	public static boolean DeleteByDatabaseunitid(DataProvider dp, int Databaseunitid)
	{
		UnitDAL dal = new UnitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      UnitInfo objOld =  dal.GetUnitInfoByDatabaseunitid(Databaseunitid);// 读取实体信息
		dal.DeleteByDatabaseunitid(Databaseunitid);
		setUnitStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_unit", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}