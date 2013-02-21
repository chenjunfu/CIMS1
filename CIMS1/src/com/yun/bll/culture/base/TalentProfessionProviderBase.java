/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:33:03
   功能说明: 表t_talent_profession 人才所属行业的业务类TalentProfessionInfo的业务层基类
   表说明:人才所属行业
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表TalentProfession 人才所属行业 的实体TalentProfessionInfo的数据操作类
 *
 */
public class TalentProfessionProviderBase
{
	// [start] 设置和获取静态属性列表 TalentProfessionStatic, 默认值:null
	// 设置和获取静态属性列表 TalentProfessionStatic, 默认值:null 开始
	private static TalentProfessionInfoCollection talentProfessionStatic = null;
	/**
	* 获取 静态属性列表 TalentProfessionStatic, 默认值:null
	 *
	 * @return 静态属性列表 TalentProfessionStatic, 默认值:null
	 */
	public static TalentProfessionInfoCollection getTalentProfessionStatic()
	{
		if (talentProfessionStatic == null)
		  talentProfessionStatic = new TalentProfessionDAL().GetListBy();
		return talentProfessionStatic;
	}
	/**
	 * 设置 静态属性列表 TalentProfessionStatic, 默认值:null
	 *
	 * @param sTalentProfessionStatic
	 *            静态属性列表 TalentProfessionStatic, 默认值:null
	 */
	public static void setTalentProfessionStatic(TalentProfessionInfoCollection sTalentProfessionStatic)
	{
		talentProfessionStatic = sTalentProfessionStatic;
		setTalentProfessionInfoStaticByTalentprofessiondatabaseid (null);
	}
	// 设置和获取静态属性列表 TalentProfessionStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.TalentProfessionInfo objTalentProfessionInfo : getTalentProfessionStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objTalentProfessionInfo.getTalentprofessiondatabaseid(), objTalentProfessionInfo.getTalentprofessionname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetTalentProfessionInfoStaticByTalentprofessiondatabaseid
	// [start] 设置和获取静态属性列表 TalentProfessionInfoStaticByTalentprofessiondatabaseid, 默认值:null
	// 设置和获取静态属性列表 TalentProfessionInfoStaticByTalentprofessiondatabaseid, 默认值:null 开始
	private static TalentProfessionInfoCollection TalentProfessionInfoStaticByTalentprofessiondatabaseid = null;
	/**
	* 获取 静态属性列表 TalentProfessionInfoStaticByTalentprofessiondatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 TalentProfessionInfoStaticByTalentprofessiondatabaseid, 默认值:null
	 */
	public static TalentProfessionInfoCollection getTalentProfessionInfoStaticByTalentprofessiondatabaseid()
	{
		return TalentProfessionInfoStaticByTalentprofessiondatabaseid;
	}
	/**
	 * 设置 静态属性列表 TalentProfessionInfoStaticByTalentprofessiondatabaseid, 默认值:null
	 *
	 * @param sTalentProfessionInfoStaticByTalentprofessiondatabaseid
	 *            静态属性列表 TalentProfessionInfoStaticByTalentprofessiondatabaseid, 默认值:null
	 */
	public static void setTalentProfessionInfoStaticByTalentprofessiondatabaseid(TalentProfessionInfoCollection sTalentProfessionInfoStaticByTalentprofessiondatabaseid)
	{
		TalentProfessionInfoStaticByTalentprofessiondatabaseid = sTalentProfessionInfoStaticByTalentprofessiondatabaseid;
	}
	// 设置和获取静态属性列表 TalentProfessionInfoStaticByTalentprofessiondatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 获取表t_talent_profession 人才所属行业的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @param Talentprofessiondatabaseid TalentProfessiondatabaseID
        * @return TalentProfessionInfo对象实体
        */
        public static TalentProfessionInfo GetTalentProfessionInfoStaticByTalentprofessiondatabaseid(int Talentprofessiondatabaseid)
        {
            if (TalentProfessionInfoStaticByTalentprofessiondatabaseid == null)
                TalentProfessionInfoStaticByTalentprofessiondatabaseid = new TalentProfessionInfoCollection();
            int allcount = TalentProfessionInfoStaticByTalentprofessiondatabaseid.size();
            TalentProfessionInfo objTalentProfessionInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (TalentProfessionInfoStaticByTalentprofessiondatabaseid == null)
                    break;
                    objTalentProfessionInfo = TalentProfessionInfoStaticByTalentprofessiondatabaseid.get(i);
                if (objTalentProfessionInfo == null)
                    break;
                if (objTalentProfessionInfo.getTalentprofessiondatabaseid() == Talentprofessiondatabaseid)
                {
                    return objTalentProfessionInfo;
                }
            }
            TalentProfessionInfo obj= new TalentProfessionDAL().GetTalentProfessionInfoByTalentprofessiondatabaseid(Talentprofessiondatabaseid);

            if (obj != null)
            {
                if (TalentProfessionInfoStaticByTalentprofessiondatabaseid != null)
                    TalentProfessionInfoStaticByTalentprofessiondatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new TalentProfessionInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByTalentprofessiondatabaseid
        // [start] CountByTalentprofessiondatabaseid
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 统计表t_talent_profession 人才所属行业的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @param Talentprofessiondatabaseid TalentProfessiondatabaseID
        * @return 数据量
        */
        public static int CountByTalentprofessiondatabaseid(int Talentprofessiondatabaseid)
        {
            return new TalentProfessionDAL().CountByTalentprofessiondatabaseid(Talentprofessiondatabaseid);
        }
        // [end]
        // [start] CountByTalentprofessiondatabaseid
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 统计表t_talent_profession 人才所属行业的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @param Talentprofessiondatabaseid TalentProfessiondatabaseID
        * @return 数据量
        */
        public static int CountByTalentprofessiondatabaseid(DataProvider dp, int Talentprofessiondatabaseid)
        {
		TalentProfessionDAL dal = new TalentProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByTalentprofessiondatabaseid(Talentprofessiondatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_talent_profession 人才所属行业的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new TalentProfessionDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_talent_profession 人才所属行业的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		TalentProfessionDAL dal = new TalentProfessionDAL();
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
 返回表t_talent_profession 人才所属行业的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @return 数据列表的强类型实体类
        */
        public static TalentProfessionInfoCollection GetListBy()
        {
            return new TalentProfessionDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_talent_profession 人才所属行业的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @return 数据列表的强类型实体类
        */
        public static TalentProfessionInfoCollection GetListBy(DataProvider dp )
        {
		TalentProfessionDAL dal = new TalentProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_talent_profession 人才所属行业的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @return 数据列表的强类型实体类
        */
        public static TalentProfessionInfoCollection GetListBy(String OrderBy)
        {
            return new TalentProfessionDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_talent_profession 人才所属行业的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @return 数据列表的强类型实体类
        */
        public static TalentProfessionInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		TalentProfessionDAL dal = new TalentProfessionDAL();
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
 返回表t_talent_profession 人才所属行业的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @return 数据列表的强类型实体类
        */
        public static TalentProfessionInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new TalentProfessionDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_talent_profession 人才所属行业的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new TalentProfessionDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_talent_profession 人才所属行业的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @return 数据列表的强类型实体类
        */
        public static TalentProfessionInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new TalentProfessionDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_talent_profession 人才所属行业的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new TalentProfessionDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_talent_profession 人才所属行业的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @return 数据列表的强类型实体类
        */
        public static TalentProfessionInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		TalentProfessionDAL dal = new TalentProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_talent_profession 人才所属行业的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		TalentProfessionDAL dal = new TalentProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_talent_profession 人才所属行业的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @return 数据列表的强类型实体类
        */
        public static TalentProfessionInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		TalentProfessionDAL dal = new TalentProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_talent_profession 人才所属行业的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		TalentProfessionDAL dal = new TalentProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetTalentProfessionInfoByTalentprofessiondatabaseid
        // [start] GetTalentProfessionInfoByTalentprofessiondatabaseid
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 获取表t_talent_profession 人才所属行业的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @param Talentprofessiondatabaseid TalentProfessiondatabaseID
        * @return TalentProfessionInfo对象实体
        */
        public static TalentProfessionInfo GetTalentProfessionInfoByTalentprofessiondatabaseid(int Talentprofessiondatabaseid)
        {
            return new TalentProfessionDAL().GetTalentProfessionInfoByTalentprofessiondatabaseid(Talentprofessiondatabaseid);
        }
        // [end]
        // [start] GetTalentProfessionInfoByTalentprofessiondatabaseid
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 获取表t_talent_profession 人才所属行业的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @param Talentprofessiondatabaseid TalentProfessiondatabaseID
        * @return TalentProfessionInfo对象实体
        */
        public static TalentProfessionInfo GetTalentProfessionInfoByTalentprofessiondatabaseid(DataProvider dp, int Talentprofessiondatabaseid)
        {
		TalentProfessionDAL dal = new TalentProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetTalentProfessionInfoByTalentprofessiondatabaseid(Talentprofessiondatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_talent_profession 人才所属行业中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @param objTalentProfessionInfo TalentProfessionInfo对象 人才所属行业
        */
  public static boolean Insert(TalentProfessionInfo objTalentProfessionInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objTalentProfessionInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_talent_profession 人才所属行业中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @param objTalentProfessionInfo TalentProfessionInfo对象 人才所属行业
        */
  public static boolean Insert(DataProvider dp, TalentProfessionInfo objTalentProfessionInfo)
	{
		TalentProfessionDAL dal = new TalentProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objTalentProfessionInfo);
      setTalentProfessionStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_talent_profession", "添加", objTalentProfessionInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByTalentprofessiondatabaseid
        // [start] UpdateByTalentprofessiondatabaseid
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 更新表t_talent_profession 人才所属行业中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @param objTalentProfessionInfo TalentProfessionInfo对象 人才所属行业
        */
  public static boolean UpdateByTalentprofessiondatabaseid(TalentProfessionInfo objTalentProfessionInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByTalentprofessiondatabaseid(dp, objTalentProfessionInfo);
	}

	// [end]
        // [start] UpdateByTalentprofessiondatabaseid
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 更新表t_talent_profession 人才所属行业中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @param objTalentProfessionInfo TalentProfessionInfo对象 人才所属行业
        */
  public static boolean UpdateByTalentprofessiondatabaseid(DataProvider dp, TalentProfessionInfo objTalentProfessionInfo)
	{
		TalentProfessionDAL dal = new TalentProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Talentprofessiondatabaseid =  objTalentProfessionInfo.getTalentprofessiondatabaseid();//TalentProfessiondatabaseID  数据类型:int
      TalentProfessionInfo objOld =  dal.GetTalentProfessionInfoByTalentprofessiondatabaseid(Talentprofessiondatabaseid);// 读取实体信息
		dal.UpdateByTalentprofessiondatabaseid(objTalentProfessionInfo);
		setTalentProfessionStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objTalentProfessionInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objTalentProfessionInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_talent_profession", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByTalentprofessiondatabaseid
        // [start] DeleteByTalentprofessiondatabaseid
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 删除数据表t_talent_profession 人才所属行业中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @param Talentprofessiondatabaseid TalentProfessiondatabaseID
        */
	public static boolean DeleteByTalentprofessiondatabaseid(int Talentprofessiondatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByTalentprofessiondatabaseid(dp, Talentprofessiondatabaseid);
	}

	// [end]
        // [start] DeleteByTalentprofessiondatabaseid
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 删除数据表t_talent_profession 人才所属行业中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:33:03
        *
        * @param Talentprofessiondatabaseid TalentProfessiondatabaseID
        */
	public static boolean DeleteByTalentprofessiondatabaseid(DataProvider dp, int Talentprofessiondatabaseid)
	{
		TalentProfessionDAL dal = new TalentProfessionDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      TalentProfessionInfo objOld =  dal.GetTalentProfessionInfoByTalentprofessiondatabaseid(Talentprofessiondatabaseid);// 读取实体信息
		dal.DeleteByTalentprofessiondatabaseid(Talentprofessiondatabaseid);
		setTalentProfessionStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_talent_profession", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}