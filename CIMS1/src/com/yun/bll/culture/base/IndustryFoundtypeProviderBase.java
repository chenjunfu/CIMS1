/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:29:33
   功能说明: 表t_industry_foundtype 资金类别表的业务类IndustryFoundtypeInfo的业务层基类
   表说明:资金类别表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表IndustryFoundtype 资金类别表 的实体IndustryFoundtypeInfo的数据操作类
 *
 */
public class IndustryFoundtypeProviderBase
{
	// [start] 设置和获取静态属性列表 IndustryFoundtypeStatic, 默认值:null
	// 设置和获取静态属性列表 IndustryFoundtypeStatic, 默认值:null 开始
	private static IndustryFoundtypeInfoCollection industryFoundtypeStatic = null;
	/**
	* 获取 静态属性列表 IndustryFoundtypeStatic, 默认值:null
	 *
	 * @return 静态属性列表 IndustryFoundtypeStatic, 默认值:null
	 */
	public static IndustryFoundtypeInfoCollection getIndustryFoundtypeStatic()
	{
		if (industryFoundtypeStatic == null)
		  industryFoundtypeStatic = new IndustryFoundtypeDAL().GetListBy();
		return industryFoundtypeStatic;
	}
	/**
	 * 设置 静态属性列表 IndustryFoundtypeStatic, 默认值:null
	 *
	 * @param sIndustryFoundtypeStatic
	 *            静态属性列表 IndustryFoundtypeStatic, 默认值:null
	 */
	public static void setIndustryFoundtypeStatic(IndustryFoundtypeInfoCollection sIndustryFoundtypeStatic)
	{
		industryFoundtypeStatic = sIndustryFoundtypeStatic;
		setIndustryFoundtypeInfoStaticByFundtypeid (null);
	}
	// 设置和获取静态属性列表 IndustryFoundtypeStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.IndustryFoundtypeInfo objIndustryFoundtypeInfo : getIndustryFoundtypeStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objIndustryFoundtypeInfo.getFundtypeid(), objIndustryFoundtypeInfo.getFundtypename()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetIndustryFoundtypeInfoStaticByFundtypeid
	// [start] 设置和获取静态属性列表 IndustryFoundtypeInfoStaticByFundtypeid, 默认值:null
	// 设置和获取静态属性列表 IndustryFoundtypeInfoStaticByFundtypeid, 默认值:null 开始
	private static IndustryFoundtypeInfoCollection IndustryFoundtypeInfoStaticByFundtypeid = null;
	/**
	* 获取 静态属性列表 IndustryFoundtypeInfoStaticByFundtypeid, 默认值:null
	 *
	 * @return 静态属性列表 IndustryFoundtypeInfoStaticByFundtypeid, 默认值:null
	 */
	public static IndustryFoundtypeInfoCollection getIndustryFoundtypeInfoStaticByFundtypeid()
	{
		return IndustryFoundtypeInfoStaticByFundtypeid;
	}
	/**
	 * 设置 静态属性列表 IndustryFoundtypeInfoStaticByFundtypeid, 默认值:null
	 *
	 * @param sIndustryFoundtypeInfoStaticByFundtypeid
	 *            静态属性列表 IndustryFoundtypeInfoStaticByFundtypeid, 默认值:null
	 */
	public static void setIndustryFoundtypeInfoStaticByFundtypeid(IndustryFoundtypeInfoCollection sIndustryFoundtypeInfoStaticByFundtypeid)
	{
		IndustryFoundtypeInfoStaticByFundtypeid = sIndustryFoundtypeInfoStaticByFundtypeid;
	}
	// 设置和获取静态属性列表 IndustryFoundtypeInfoStaticByFundtypeid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 获取表t_industry_foundtype 资金类别表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @param Fundtypeid 资金类别编号
        * @return IndustryFoundtypeInfo对象实体
        */
        public static IndustryFoundtypeInfo GetIndustryFoundtypeInfoStaticByFundtypeid(int Fundtypeid)
        {
            if (IndustryFoundtypeInfoStaticByFundtypeid == null)
                IndustryFoundtypeInfoStaticByFundtypeid = new IndustryFoundtypeInfoCollection();
            int allcount = IndustryFoundtypeInfoStaticByFundtypeid.size();
            IndustryFoundtypeInfo objIndustryFoundtypeInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (IndustryFoundtypeInfoStaticByFundtypeid == null)
                    break;
                    objIndustryFoundtypeInfo = IndustryFoundtypeInfoStaticByFundtypeid.get(i);
                if (objIndustryFoundtypeInfo == null)
                    break;
                if (objIndustryFoundtypeInfo.getFundtypeid() == Fundtypeid)
                {
                    return objIndustryFoundtypeInfo;
                }
            }
            IndustryFoundtypeInfo obj= new IndustryFoundtypeDAL().GetIndustryFoundtypeInfoByFundtypeid(Fundtypeid);

            if (obj != null)
            {
                if (IndustryFoundtypeInfoStaticByFundtypeid != null)
                    IndustryFoundtypeInfoStaticByFundtypeid.add(obj);
                return obj;
            }
            else
            {
                return new IndustryFoundtypeInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByFundtypeid
        // [start] CountByFundtypeid
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 统计表t_industry_foundtype 资金类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @param Fundtypeid 资金类别编号
        * @return 数据量
        */
        public static int CountByFundtypeid(int Fundtypeid)
        {
            return new IndustryFoundtypeDAL().CountByFundtypeid(Fundtypeid);
        }
        // [end]
        // [start] CountByFundtypeid
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 统计表t_industry_foundtype 资金类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @param Fundtypeid 资金类别编号
        * @return 数据量
        */
        public static int CountByFundtypeid(DataProvider dp, int Fundtypeid)
        {
		IndustryFoundtypeDAL dal = new IndustryFoundtypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByFundtypeid(Fundtypeid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_industry_foundtype 资金类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new IndustryFoundtypeDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_industry_foundtype 资金类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		IndustryFoundtypeDAL dal = new IndustryFoundtypeDAL();
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
 返回表t_industry_foundtype 资金类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryFoundtypeInfoCollection GetListBy()
        {
            return new IndustryFoundtypeDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_foundtype 资金类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryFoundtypeInfoCollection GetListBy(DataProvider dp )
        {
		IndustryFoundtypeDAL dal = new IndustryFoundtypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_foundtype 资金类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryFoundtypeInfoCollection GetListBy(String OrderBy)
        {
            return new IndustryFoundtypeDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_foundtype 资金类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryFoundtypeInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		IndustryFoundtypeDAL dal = new IndustryFoundtypeDAL();
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
 返回表t_industry_foundtype 资金类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryFoundtypeInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new IndustryFoundtypeDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_foundtype 资金类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new IndustryFoundtypeDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_foundtype 资金类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryFoundtypeInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new IndustryFoundtypeDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_foundtype 资金类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new IndustryFoundtypeDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_foundtype 资金类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryFoundtypeInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		IndustryFoundtypeDAL dal = new IndustryFoundtypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_foundtype 资金类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		IndustryFoundtypeDAL dal = new IndustryFoundtypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_foundtype 资金类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryFoundtypeInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		IndustryFoundtypeDAL dal = new IndustryFoundtypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_foundtype 资金类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		IndustryFoundtypeDAL dal = new IndustryFoundtypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetIndustryFoundtypeInfoByFundtypeid
        // [start] GetIndustryFoundtypeInfoByFundtypeid
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 获取表t_industry_foundtype 资金类别表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @param Fundtypeid 资金类别编号
        * @return IndustryFoundtypeInfo对象实体
        */
        public static IndustryFoundtypeInfo GetIndustryFoundtypeInfoByFundtypeid(int Fundtypeid)
        {
            return new IndustryFoundtypeDAL().GetIndustryFoundtypeInfoByFundtypeid(Fundtypeid);
        }
        // [end]
        // [start] GetIndustryFoundtypeInfoByFundtypeid
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 获取表t_industry_foundtype 资金类别表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @param Fundtypeid 资金类别编号
        * @return IndustryFoundtypeInfo对象实体
        */
        public static IndustryFoundtypeInfo GetIndustryFoundtypeInfoByFundtypeid(DataProvider dp, int Fundtypeid)
        {
		IndustryFoundtypeDAL dal = new IndustryFoundtypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetIndustryFoundtypeInfoByFundtypeid(Fundtypeid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_industry_foundtype 资金类别表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @param objIndustryFoundtypeInfo IndustryFoundtypeInfo对象 资金类别表
        */
  public static boolean Insert(IndustryFoundtypeInfo objIndustryFoundtypeInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objIndustryFoundtypeInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_industry_foundtype 资金类别表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @param objIndustryFoundtypeInfo IndustryFoundtypeInfo对象 资金类别表
        */
  public static boolean Insert(DataProvider dp, IndustryFoundtypeInfo objIndustryFoundtypeInfo)
	{
		IndustryFoundtypeDAL dal = new IndustryFoundtypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objIndustryFoundtypeInfo);
      setIndustryFoundtypeStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_industry_foundtype", "添加", objIndustryFoundtypeInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByFundtypeid
        // [start] UpdateByFundtypeid
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 更新表t_industry_foundtype 资金类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @param objIndustryFoundtypeInfo IndustryFoundtypeInfo对象 资金类别表
        */
  public static boolean UpdateByFundtypeid(IndustryFoundtypeInfo objIndustryFoundtypeInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByFundtypeid(dp, objIndustryFoundtypeInfo);
	}

	// [end]
        // [start] UpdateByFundtypeid
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 更新表t_industry_foundtype 资金类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @param objIndustryFoundtypeInfo IndustryFoundtypeInfo对象 资金类别表
        */
  public static boolean UpdateByFundtypeid(DataProvider dp, IndustryFoundtypeInfo objIndustryFoundtypeInfo)
	{
		IndustryFoundtypeDAL dal = new IndustryFoundtypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Fundtypeid =  objIndustryFoundtypeInfo.getFundtypeid();//资金类别编号  数据类型:int
      IndustryFoundtypeInfo objOld =  dal.GetIndustryFoundtypeInfoByFundtypeid(Fundtypeid);// 读取实体信息
		dal.UpdateByFundtypeid(objIndustryFoundtypeInfo);
		setIndustryFoundtypeStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objIndustryFoundtypeInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objIndustryFoundtypeInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_industry_foundtype", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByFundtypeid
        // [start] DeleteByFundtypeid
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 删除数据表t_industry_foundtype 资金类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @param Fundtypeid 资金类别编号
        */
	public static boolean DeleteByFundtypeid(int Fundtypeid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByFundtypeid(dp, Fundtypeid);
	}

	// [end]
        // [start] DeleteByFundtypeid
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 删除数据表t_industry_foundtype 资金类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:33
        *
        * @param Fundtypeid 资金类别编号
        */
	public static boolean DeleteByFundtypeid(DataProvider dp, int Fundtypeid)
	{
		IndustryFoundtypeDAL dal = new IndustryFoundtypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      IndustryFoundtypeInfo objOld =  dal.GetIndustryFoundtypeInfoByFundtypeid(Fundtypeid);// 读取实体信息
		dal.DeleteByFundtypeid(Fundtypeid);
		setIndustryFoundtypeStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_industry_foundtype", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}