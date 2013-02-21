/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:30:27
   功能说明: 表t_nation 民族表的业务类NationInfo的业务层基类
   表说明:民族表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Nation 民族表 的实体NationInfo的数据操作类
 *
 */
public class NationProviderBase
{
	// [start] 设置和获取静态属性列表 NationStatic, 默认值:null
	// 设置和获取静态属性列表 NationStatic, 默认值:null 开始
	private static NationInfoCollection nationStatic = null;
	/**
	* 获取 静态属性列表 NationStatic, 默认值:null
	 *
	 * @return 静态属性列表 NationStatic, 默认值:null
	 */
	public static NationInfoCollection getNationStatic()
	{
		if (nationStatic == null)
		  nationStatic = new NationDAL().GetListBy();
		return nationStatic;
	}
	/**
	 * 设置 静态属性列表 NationStatic, 默认值:null
	 *
	 * @param sNationStatic
	 *            静态属性列表 NationStatic, 默认值:null
	 */
	public static void setNationStatic(NationInfoCollection sNationStatic)
	{
		nationStatic = sNationStatic;
		setNationInfoStaticByNationdatabaseid (null);
	}
	// 设置和获取静态属性列表 NationStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.NationInfo objNationInfo : getNationStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objNationInfo.getNationdatabaseid(), objNationInfo.getNationname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetNationInfoStaticByNationdatabaseid
	// [start] 设置和获取静态属性列表 NationInfoStaticByNationdatabaseid, 默认值:null
	// 设置和获取静态属性列表 NationInfoStaticByNationdatabaseid, 默认值:null 开始
	private static NationInfoCollection NationInfoStaticByNationdatabaseid = null;
	/**
	* 获取 静态属性列表 NationInfoStaticByNationdatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 NationInfoStaticByNationdatabaseid, 默认值:null
	 */
	public static NationInfoCollection getNationInfoStaticByNationdatabaseid()
	{
		return NationInfoStaticByNationdatabaseid;
	}
	/**
	 * 设置 静态属性列表 NationInfoStaticByNationdatabaseid, 默认值:null
	 *
	 * @param sNationInfoStaticByNationdatabaseid
	 *            静态属性列表 NationInfoStaticByNationdatabaseid, 默认值:null
	 */
	public static void setNationInfoStaticByNationdatabaseid(NationInfoCollection sNationInfoStaticByNationdatabaseid)
	{
		NationInfoStaticByNationdatabaseid = sNationInfoStaticByNationdatabaseid;
	}
	// 设置和获取静态属性列表 NationInfoStaticByNationdatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 获取表t_nation 民族表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @param Nationdatabaseid NationdatabaseID
        * @return NationInfo对象实体
        */
        public static NationInfo GetNationInfoStaticByNationdatabaseid(int Nationdatabaseid)
        {
            if (NationInfoStaticByNationdatabaseid == null)
                NationInfoStaticByNationdatabaseid = new NationInfoCollection();
            int allcount = NationInfoStaticByNationdatabaseid.size();
            NationInfo objNationInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (NationInfoStaticByNationdatabaseid == null)
                    break;
                    objNationInfo = NationInfoStaticByNationdatabaseid.get(i);
                if (objNationInfo == null)
                    break;
                if (objNationInfo.getNationdatabaseid() == Nationdatabaseid)
                {
                    return objNationInfo;
                }
            }
            NationInfo obj= new NationDAL().GetNationInfoByNationdatabaseid(Nationdatabaseid);

            if (obj != null)
            {
                if (NationInfoStaticByNationdatabaseid != null)
                    NationInfoStaticByNationdatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new NationInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByNationdatabaseid
        // [start] CountByNationdatabaseid
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 统计表t_nation 民族表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @param Nationdatabaseid NationdatabaseID
        * @return 数据量
        */
        public static int CountByNationdatabaseid(int Nationdatabaseid)
        {
            return new NationDAL().CountByNationdatabaseid(Nationdatabaseid);
        }
        // [end]
        // [start] CountByNationdatabaseid
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 统计表t_nation 民族表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @param Nationdatabaseid NationdatabaseID
        * @return 数据量
        */
        public static int CountByNationdatabaseid(DataProvider dp, int Nationdatabaseid)
        {
		NationDAL dal = new NationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByNationdatabaseid(Nationdatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_nation 民族表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new NationDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_nation 民族表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		NationDAL dal = new NationDAL();
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
 返回表t_nation 民族表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @return 数据列表的强类型实体类
        */
        public static NationInfoCollection GetListBy()
        {
            return new NationDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_nation 民族表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @return 数据列表的强类型实体类
        */
        public static NationInfoCollection GetListBy(DataProvider dp )
        {
		NationDAL dal = new NationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_nation 民族表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @return 数据列表的强类型实体类
        */
        public static NationInfoCollection GetListBy(String OrderBy)
        {
            return new NationDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_nation 民族表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @return 数据列表的强类型实体类
        */
        public static NationInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		NationDAL dal = new NationDAL();
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
 返回表t_nation 民族表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @return 数据列表的强类型实体类
        */
        public static NationInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new NationDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_nation 民族表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new NationDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_nation 民族表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @return 数据列表的强类型实体类
        */
        public static NationInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new NationDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_nation 民族表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new NationDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_nation 民族表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @return 数据列表的强类型实体类
        */
        public static NationInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		NationDAL dal = new NationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_nation 民族表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		NationDAL dal = new NationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_nation 民族表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @return 数据列表的强类型实体类
        */
        public static NationInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		NationDAL dal = new NationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_nation 民族表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		NationDAL dal = new NationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetNationInfoByNationdatabaseid
        // [start] GetNationInfoByNationdatabaseid
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 获取表t_nation 民族表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @param Nationdatabaseid NationdatabaseID
        * @return NationInfo对象实体
        */
        public static NationInfo GetNationInfoByNationdatabaseid(int Nationdatabaseid)
        {
            return new NationDAL().GetNationInfoByNationdatabaseid(Nationdatabaseid);
        }
        // [end]
        // [start] GetNationInfoByNationdatabaseid
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 获取表t_nation 民族表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @param Nationdatabaseid NationdatabaseID
        * @return NationInfo对象实体
        */
        public static NationInfo GetNationInfoByNationdatabaseid(DataProvider dp, int Nationdatabaseid)
        {
		NationDAL dal = new NationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetNationInfoByNationdatabaseid(Nationdatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_nation 民族表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @param objNationInfo NationInfo对象 民族表
        */
  public static boolean Insert(NationInfo objNationInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objNationInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_nation 民族表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @param objNationInfo NationInfo对象 民族表
        */
  public static boolean Insert(DataProvider dp, NationInfo objNationInfo)
	{
		NationDAL dal = new NationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objNationInfo);
      setNationStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_nation", "添加", objNationInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByNationdatabaseid
        // [start] UpdateByNationdatabaseid
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 更新表t_nation 民族表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @param objNationInfo NationInfo对象 民族表
        */
  public static boolean UpdateByNationdatabaseid(NationInfo objNationInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByNationdatabaseid(dp, objNationInfo);
	}

	// [end]
        // [start] UpdateByNationdatabaseid
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 更新表t_nation 民族表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @param objNationInfo NationInfo对象 民族表
        */
  public static boolean UpdateByNationdatabaseid(DataProvider dp, NationInfo objNationInfo)
	{
		NationDAL dal = new NationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Nationdatabaseid =  objNationInfo.getNationdatabaseid();//NationdatabaseID  数据类型:int
      NationInfo objOld =  dal.GetNationInfoByNationdatabaseid(Nationdatabaseid);// 读取实体信息
		dal.UpdateByNationdatabaseid(objNationInfo);
		setNationStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objNationInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objNationInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_nation", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByNationdatabaseid
        // [start] DeleteByNationdatabaseid
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 删除数据表t_nation 民族表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @param Nationdatabaseid NationdatabaseID
        */
	public static boolean DeleteByNationdatabaseid(int Nationdatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByNationdatabaseid(dp, Nationdatabaseid);
	}

	// [end]
        // [start] DeleteByNationdatabaseid
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 删除数据表t_nation 民族表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:27
        *
        * @param Nationdatabaseid NationdatabaseID
        */
	public static boolean DeleteByNationdatabaseid(DataProvider dp, int Nationdatabaseid)
	{
		NationDAL dal = new NationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      NationInfo objOld =  dal.GetNationInfoByNationdatabaseid(Nationdatabaseid);// 读取实体信息
		dal.DeleteByNationdatabaseid(Nationdatabaseid);
		setNationStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_nation", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]
	
        // [end]

}