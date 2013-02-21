/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:31:04
   功能说明: 表t_profession 行业类别表的业务类ProfessionInfo的业务层基类
   表说明:行业类别表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Profession 行业类别表 的实体ProfessionInfo的数据操作类
 *
 */
public class ProfessionProviderBase
{
	// [start] 设置和获取静态属性列表 ProfessionStatic, 默认值:null
	// 设置和获取静态属性列表 ProfessionStatic, 默认值:null 开始
	private static ProfessionInfoCollection professionStatic = null;
	/**
	* 获取 静态属性列表 ProfessionStatic, 默认值:null
	 *
	 * @return 静态属性列表 ProfessionStatic, 默认值:null
	 */
	public static ProfessionInfoCollection getProfessionStatic()
	{
		if (professionStatic == null)
		  professionStatic = new ProfessionDAL().GetListBy();
		return professionStatic;
	}
	/**
	 * 设置 静态属性列表 ProfessionStatic, 默认值:null
	 *
	 * @param sProfessionStatic
	 *            静态属性列表 ProfessionStatic, 默认值:null
	 */
	public static void setProfessionStatic(ProfessionInfoCollection sProfessionStatic)
	{
		professionStatic = sProfessionStatic;
		setProfessionInfoStaticByBusinessdatabaseid (null);
	}
	// 设置和获取静态属性列表 ProfessionStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.ProfessionInfo objProfessionInfo : getProfessionStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objProfessionInfo.getBusinessdatabaseid(), objProfessionInfo.getBusinesstypename()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetProfessionInfoStaticByBusinessdatabaseid
	// [start] 设置和获取静态属性列表 ProfessionInfoStaticByBusinessdatabaseid, 默认值:null
	// 设置和获取静态属性列表 ProfessionInfoStaticByBusinessdatabaseid, 默认值:null 开始
	private static ProfessionInfoCollection ProfessionInfoStaticByBusinessdatabaseid = null;
	/**
	* 获取 静态属性列表 ProfessionInfoStaticByBusinessdatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 ProfessionInfoStaticByBusinessdatabaseid, 默认值:null
	 */
	public static ProfessionInfoCollection getProfessionInfoStaticByBusinessdatabaseid()
	{
		return ProfessionInfoStaticByBusinessdatabaseid;
	}
	/**
	 * 设置 静态属性列表 ProfessionInfoStaticByBusinessdatabaseid, 默认值:null
	 *
	 * @param sProfessionInfoStaticByBusinessdatabaseid
	 *            静态属性列表 ProfessionInfoStaticByBusinessdatabaseid, 默认值:null
	 */
	public static void setProfessionInfoStaticByBusinessdatabaseid(ProfessionInfoCollection sProfessionInfoStaticByBusinessdatabaseid)
	{
		ProfessionInfoStaticByBusinessdatabaseid = sProfessionInfoStaticByBusinessdatabaseid;
	}
	// 设置和获取静态属性列表 ProfessionInfoStaticByBusinessdatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 获取表t_profession 行业类别表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @param Businessdatabaseid 数据库ID
        * @return ProfessionInfo对象实体
        */
        public static ProfessionInfo GetProfessionInfoStaticByBusinessdatabaseid(int Businessdatabaseid)
        {
            if (ProfessionInfoStaticByBusinessdatabaseid == null)
                ProfessionInfoStaticByBusinessdatabaseid = new ProfessionInfoCollection();
            int allcount = ProfessionInfoStaticByBusinessdatabaseid.size();
            ProfessionInfo objProfessionInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (ProfessionInfoStaticByBusinessdatabaseid == null)
                    break;
                    objProfessionInfo = ProfessionInfoStaticByBusinessdatabaseid.get(i);
                if (objProfessionInfo == null)
                    break;
                if (objProfessionInfo.getBusinessdatabaseid() == Businessdatabaseid)
                {
                    return objProfessionInfo;
                }
            }
            ProfessionInfo obj= new ProfessionDAL().GetProfessionInfoByBusinessdatabaseid(Businessdatabaseid);

            if (obj != null)
            {
                if (ProfessionInfoStaticByBusinessdatabaseid != null)
                    ProfessionInfoStaticByBusinessdatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new ProfessionInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByBusinessdatabaseid
        // [start] CountByBusinessdatabaseid
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 统计表t_profession 行业类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @param Businessdatabaseid 数据库ID
        * @return 数据量
        */
        public static int CountByBusinessdatabaseid(int Businessdatabaseid)
        {
            return new ProfessionDAL().CountByBusinessdatabaseid(Businessdatabaseid);
        }
        // [end]
        // [start] CountByBusinessdatabaseid
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 统计表t_profession 行业类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @param Businessdatabaseid 数据库ID
        * @return 数据量
        */
        public static int CountByBusinessdatabaseid(DataProvider dp, int Businessdatabaseid)
        {
		ProfessionDAL dal = new ProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByBusinessdatabaseid(Businessdatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_profession 行业类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new ProfessionDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_profession 行业类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		ProfessionDAL dal = new ProfessionDAL();
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
 返回表t_profession 行业类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @return 数据列表的强类型实体类
        */
        public static ProfessionInfoCollection GetListBy()
        {
            return new ProfessionDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_profession 行业类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @return 数据列表的强类型实体类
        */
        public static ProfessionInfoCollection GetListBy(DataProvider dp )
        {
		ProfessionDAL dal = new ProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_profession 行业类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @return 数据列表的强类型实体类
        */
        public static ProfessionInfoCollection GetListBy(String OrderBy)
        {
            return new ProfessionDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_profession 行业类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @return 数据列表的强类型实体类
        */
        public static ProfessionInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		ProfessionDAL dal = new ProfessionDAL();
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
 返回表t_profession 行业类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @return 数据列表的强类型实体类
        */
        public static ProfessionInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new ProfessionDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_profession 行业类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new ProfessionDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_profession 行业类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @return 数据列表的强类型实体类
        */
        public static ProfessionInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new ProfessionDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_profession 行业类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new ProfessionDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_profession 行业类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @return 数据列表的强类型实体类
        */
        public static ProfessionInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		ProfessionDAL dal = new ProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_profession 行业类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		ProfessionDAL dal = new ProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_profession 行业类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @return 数据列表的强类型实体类
        */
        public static ProfessionInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		ProfessionDAL dal = new ProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_profession 行业类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		ProfessionDAL dal = new ProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetProfessionInfoByBusinessdatabaseid
        // [start] GetProfessionInfoByBusinessdatabaseid
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 获取表t_profession 行业类别表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @param Businessdatabaseid 数据库ID
        * @return ProfessionInfo对象实体
        */
        public static ProfessionInfo GetProfessionInfoByBusinessdatabaseid(int Businessdatabaseid)
        {
            return new ProfessionDAL().GetProfessionInfoByBusinessdatabaseid(Businessdatabaseid);
        }
        // [end]
        // [start] GetProfessionInfoByBusinessdatabaseid
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 获取表t_profession 行业类别表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @param Businessdatabaseid 数据库ID
        * @return ProfessionInfo对象实体
        */
        public static ProfessionInfo GetProfessionInfoByBusinessdatabaseid(DataProvider dp, int Businessdatabaseid)
        {
		ProfessionDAL dal = new ProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetProfessionInfoByBusinessdatabaseid(Businessdatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_profession 行业类别表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @param objProfessionInfo ProfessionInfo对象 行业类别表
        */
  public static boolean Insert(ProfessionInfo objProfessionInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objProfessionInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_profession 行业类别表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @param objProfessionInfo ProfessionInfo对象 行业类别表
        */
  public static boolean Insert(DataProvider dp, ProfessionInfo objProfessionInfo)
	{
		ProfessionDAL dal = new ProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objProfessionInfo);
      setProfessionStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_profession", "添加", objProfessionInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByBusinessdatabaseid
        // [start] UpdateByBusinessdatabaseid
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 更新表t_profession 行业类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @param objProfessionInfo ProfessionInfo对象 行业类别表
        */
  public static boolean UpdateByBusinessdatabaseid(ProfessionInfo objProfessionInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByBusinessdatabaseid(dp, objProfessionInfo);
	}

	// [end]
        // [start] UpdateByBusinessdatabaseid
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 更新表t_profession 行业类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @param objProfessionInfo ProfessionInfo对象 行业类别表
        */
  public static boolean UpdateByBusinessdatabaseid(DataProvider dp, ProfessionInfo objProfessionInfo)
	{
		ProfessionDAL dal = new ProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Businessdatabaseid =  objProfessionInfo.getBusinessdatabaseid();//数据库ID  数据类型:int
      ProfessionInfo objOld =  dal.GetProfessionInfoByBusinessdatabaseid(Businessdatabaseid);// 读取实体信息
		dal.UpdateByBusinessdatabaseid(objProfessionInfo);
		setProfessionStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objProfessionInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objProfessionInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_profession", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByBusinessdatabaseid
        // [start] DeleteByBusinessdatabaseid
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 删除数据表t_profession 行业类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @param Businessdatabaseid 数据库ID
        */
	public static boolean DeleteByBusinessdatabaseid(int Businessdatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByBusinessdatabaseid(dp, Businessdatabaseid);
	}

	// [end]
        // [start] DeleteByBusinessdatabaseid
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 删除数据表t_profession 行业类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:04
        *
        * @param Businessdatabaseid 数据库ID
        */
	public static boolean DeleteByBusinessdatabaseid(DataProvider dp, int Businessdatabaseid)
	{
		ProfessionDAL dal = new ProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      ProfessionInfo objOld =  dal.GetProfessionInfoByBusinessdatabaseid(Businessdatabaseid);// 读取实体信息
		dal.DeleteByBusinessdatabaseid(Businessdatabaseid);
		setProfessionStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_profession", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}