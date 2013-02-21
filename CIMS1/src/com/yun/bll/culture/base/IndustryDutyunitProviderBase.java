/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:29:18
   功能说明: 表t_industry_dutyunit 主管单位表的业务类IndustryDutyunitInfo的业务层基类
   表说明:主管单位表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表IndustryDutyunit 主管单位表 的实体IndustryDutyunitInfo的数据操作类
 *
 */
public class IndustryDutyunitProviderBase
{
	// [start] 设置和获取静态属性列表 IndustryDutyunitStatic, 默认值:null
	// 设置和获取静态属性列表 IndustryDutyunitStatic, 默认值:null 开始
	private static IndustryDutyunitInfoCollection industryDutyunitStatic = null;
	/**
	* 获取 静态属性列表 IndustryDutyunitStatic, 默认值:null
	 *
	 * @return 静态属性列表 IndustryDutyunitStatic, 默认值:null
	 */
	public static IndustryDutyunitInfoCollection getIndustryDutyunitStatic()
	{
		if (industryDutyunitStatic == null)
		  industryDutyunitStatic = new IndustryDutyunitDAL().GetListBy();
		return industryDutyunitStatic;
	}
	/**
	 * 设置 静态属性列表 IndustryDutyunitStatic, 默认值:null
	 *
	 * @param sIndustryDutyunitStatic
	 *            静态属性列表 IndustryDutyunitStatic, 默认值:null
	 */
	public static void setIndustryDutyunitStatic(IndustryDutyunitInfoCollection sIndustryDutyunitStatic)
	{
		industryDutyunitStatic = sIndustryDutyunitStatic;
		setIndustryDutyunitInfoStaticByDutyunitid (null);
	}
	// 设置和获取静态属性列表 IndustryDutyunitStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.IndustryDutyunitInfo objIndustryDutyunitInfo : getIndustryDutyunitStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objIndustryDutyunitInfo.getDutyunitid(), objIndustryDutyunitInfo.getDutyunitname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetIndustryDutyunitInfoStaticByDutyunitid
	// [start] 设置和获取静态属性列表 IndustryDutyunitInfoStaticByDutyunitid, 默认值:null
	// 设置和获取静态属性列表 IndustryDutyunitInfoStaticByDutyunitid, 默认值:null 开始
	private static IndustryDutyunitInfoCollection IndustryDutyunitInfoStaticByDutyunitid = null;
	/**
	* 获取 静态属性列表 IndustryDutyunitInfoStaticByDutyunitid, 默认值:null
	 *
	 * @return 静态属性列表 IndustryDutyunitInfoStaticByDutyunitid, 默认值:null
	 */
	public static IndustryDutyunitInfoCollection getIndustryDutyunitInfoStaticByDutyunitid()
	{
		return IndustryDutyunitInfoStaticByDutyunitid;
	}
	/**
	 * 设置 静态属性列表 IndustryDutyunitInfoStaticByDutyunitid, 默认值:null
	 *
	 * @param sIndustryDutyunitInfoStaticByDutyunitid
	 *            静态属性列表 IndustryDutyunitInfoStaticByDutyunitid, 默认值:null
	 */
	public static void setIndustryDutyunitInfoStaticByDutyunitid(IndustryDutyunitInfoCollection sIndustryDutyunitInfoStaticByDutyunitid)
	{
		IndustryDutyunitInfoStaticByDutyunitid = sIndustryDutyunitInfoStaticByDutyunitid;
	}
	// 设置和获取静态属性列表 IndustryDutyunitInfoStaticByDutyunitid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 获取表t_industry_dutyunit 主管单位表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @param Dutyunitid 责主管位编号
        * @return IndustryDutyunitInfo对象实体
        */
        public static IndustryDutyunitInfo GetIndustryDutyunitInfoStaticByDutyunitid(int Dutyunitid)
        {
            if (IndustryDutyunitInfoStaticByDutyunitid == null)
                IndustryDutyunitInfoStaticByDutyunitid = new IndustryDutyunitInfoCollection();
            int allcount = IndustryDutyunitInfoStaticByDutyunitid.size();
            IndustryDutyunitInfo objIndustryDutyunitInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (IndustryDutyunitInfoStaticByDutyunitid == null)
                    break;
                    objIndustryDutyunitInfo = IndustryDutyunitInfoStaticByDutyunitid.get(i);
                if (objIndustryDutyunitInfo == null)
                    break;
                if (objIndustryDutyunitInfo.getDutyunitid() == Dutyunitid)
                {
                    return objIndustryDutyunitInfo;
                }
            }
            IndustryDutyunitInfo obj= new IndustryDutyunitDAL().GetIndustryDutyunitInfoByDutyunitid(Dutyunitid);

            if (obj != null)
            {
                if (IndustryDutyunitInfoStaticByDutyunitid != null)
                    IndustryDutyunitInfoStaticByDutyunitid.add(obj);
                return obj;
            }
            else
            {
                return new IndustryDutyunitInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByDutyunitid
        // [start] CountByDutyunitid
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 统计表t_industry_dutyunit 主管单位表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @param Dutyunitid 责主管位编号
        * @return 数据量
        */
        public static int CountByDutyunitid(int Dutyunitid)
        {
            return new IndustryDutyunitDAL().CountByDutyunitid(Dutyunitid);
        }
        // [end]
        // [start] CountByDutyunitid
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 统计表t_industry_dutyunit 主管单位表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @param Dutyunitid 责主管位编号
        * @return 数据量
        */
        public static int CountByDutyunitid(DataProvider dp, int Dutyunitid)
        {
		IndustryDutyunitDAL dal = new IndustryDutyunitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByDutyunitid(Dutyunitid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_industry_dutyunit 主管单位表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new IndustryDutyunitDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_industry_dutyunit 主管单位表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		IndustryDutyunitDAL dal = new IndustryDutyunitDAL();
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
 返回表t_industry_dutyunit 主管单位表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryDutyunitInfoCollection GetListBy()
        {
            return new IndustryDutyunitDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_dutyunit 主管单位表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryDutyunitInfoCollection GetListBy(DataProvider dp )
        {
		IndustryDutyunitDAL dal = new IndustryDutyunitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_dutyunit 主管单位表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryDutyunitInfoCollection GetListBy(String OrderBy)
        {
            return new IndustryDutyunitDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_dutyunit 主管单位表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryDutyunitInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		IndustryDutyunitDAL dal = new IndustryDutyunitDAL();
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
 返回表t_industry_dutyunit 主管单位表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryDutyunitInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new IndustryDutyunitDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_dutyunit 主管单位表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new IndustryDutyunitDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_dutyunit 主管单位表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryDutyunitInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new IndustryDutyunitDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_dutyunit 主管单位表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new IndustryDutyunitDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_dutyunit 主管单位表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryDutyunitInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		IndustryDutyunitDAL dal = new IndustryDutyunitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_dutyunit 主管单位表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		IndustryDutyunitDAL dal = new IndustryDutyunitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_dutyunit 主管单位表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryDutyunitInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		IndustryDutyunitDAL dal = new IndustryDutyunitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_dutyunit 主管单位表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		IndustryDutyunitDAL dal = new IndustryDutyunitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetIndustryDutyunitInfoByDutyunitid
        // [start] GetIndustryDutyunitInfoByDutyunitid
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 获取表t_industry_dutyunit 主管单位表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @param Dutyunitid 责主管位编号
        * @return IndustryDutyunitInfo对象实体
        */
        public static IndustryDutyunitInfo GetIndustryDutyunitInfoByDutyunitid(int Dutyunitid)
        {
            return new IndustryDutyunitDAL().GetIndustryDutyunitInfoByDutyunitid(Dutyunitid);
        }
        // [end]
        // [start] GetIndustryDutyunitInfoByDutyunitid
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 获取表t_industry_dutyunit 主管单位表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @param Dutyunitid 责主管位编号
        * @return IndustryDutyunitInfo对象实体
        */
        public static IndustryDutyunitInfo GetIndustryDutyunitInfoByDutyunitid(DataProvider dp, int Dutyunitid)
        {
		IndustryDutyunitDAL dal = new IndustryDutyunitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetIndustryDutyunitInfoByDutyunitid(Dutyunitid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_industry_dutyunit 主管单位表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @param objIndustryDutyunitInfo IndustryDutyunitInfo对象 主管单位表
        */
  public static boolean Insert(IndustryDutyunitInfo objIndustryDutyunitInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objIndustryDutyunitInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_industry_dutyunit 主管单位表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @param objIndustryDutyunitInfo IndustryDutyunitInfo对象 主管单位表
        */
  public static boolean Insert(DataProvider dp, IndustryDutyunitInfo objIndustryDutyunitInfo)
	{
		IndustryDutyunitDAL dal = new IndustryDutyunitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objIndustryDutyunitInfo);
      setIndustryDutyunitStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_industry_dutyunit", "添加", objIndustryDutyunitInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByDutyunitid
        // [start] UpdateByDutyunitid
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 更新表t_industry_dutyunit 主管单位表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @param objIndustryDutyunitInfo IndustryDutyunitInfo对象 主管单位表
        */
  public static boolean UpdateByDutyunitid(IndustryDutyunitInfo objIndustryDutyunitInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByDutyunitid(dp, objIndustryDutyunitInfo);
	}

	// [end]
        // [start] UpdateByDutyunitid
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 更新表t_industry_dutyunit 主管单位表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @param objIndustryDutyunitInfo IndustryDutyunitInfo对象 主管单位表
        */
  public static boolean UpdateByDutyunitid(DataProvider dp, IndustryDutyunitInfo objIndustryDutyunitInfo)
	{
		IndustryDutyunitDAL dal = new IndustryDutyunitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Dutyunitid =  objIndustryDutyunitInfo.getDutyunitid();//责主管位编号  数据类型:int
      IndustryDutyunitInfo objOld =  dal.GetIndustryDutyunitInfoByDutyunitid(Dutyunitid);// 读取实体信息
		dal.UpdateByDutyunitid(objIndustryDutyunitInfo);
		setIndustryDutyunitStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objIndustryDutyunitInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objIndustryDutyunitInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_industry_dutyunit", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByDutyunitid
        // [start] DeleteByDutyunitid
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 删除数据表t_industry_dutyunit 主管单位表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @param Dutyunitid 责主管位编号
        */
	public static boolean DeleteByDutyunitid(int Dutyunitid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByDutyunitid(dp, Dutyunitid);
	}

	// [end]
        // [start] DeleteByDutyunitid
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 删除数据表t_industry_dutyunit 主管单位表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:18
        *
        * @param Dutyunitid 责主管位编号
        */
	public static boolean DeleteByDutyunitid(DataProvider dp, int Dutyunitid)
	{
		IndustryDutyunitDAL dal = new IndustryDutyunitDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      IndustryDutyunitInfo objOld =  dal.GetIndustryDutyunitInfoByDutyunitid(Dutyunitid);// 读取实体信息
		dal.DeleteByDutyunitid(Dutyunitid);
		setIndustryDutyunitStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_industry_dutyunit", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}