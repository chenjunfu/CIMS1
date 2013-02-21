/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:29:50
   功能说明: 表t_industry_founsource 资金来源表的业务类IndustryFounsourceInfo的业务层基类
   表说明:资金来源表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表IndustryFounsource 资金来源表 的实体IndustryFounsourceInfo的数据操作类
 *
 */
public class IndustryFounsourceProviderBase
{
	// [start] 设置和获取静态属性列表 IndustryFounsourceStatic, 默认值:null
	// 设置和获取静态属性列表 IndustryFounsourceStatic, 默认值:null 开始
	private static IndustryFounsourceInfoCollection industryFounsourceStatic = null;
	/**
	* 获取 静态属性列表 IndustryFounsourceStatic, 默认值:null
	 *
	 * @return 静态属性列表 IndustryFounsourceStatic, 默认值:null
	 */
	public static IndustryFounsourceInfoCollection getIndustryFounsourceStatic()
	{
		if (industryFounsourceStatic == null)
		  industryFounsourceStatic = new IndustryFounsourceDAL().GetListBy();
		return industryFounsourceStatic;
	}
	/**
	 * 设置 静态属性列表 IndustryFounsourceStatic, 默认值:null
	 *
	 * @param sIndustryFounsourceStatic
	 *            静态属性列表 IndustryFounsourceStatic, 默认值:null
	 */
	public static void setIndustryFounsourceStatic(IndustryFounsourceInfoCollection sIndustryFounsourceStatic)
	{
		industryFounsourceStatic = sIndustryFounsourceStatic;
		setIndustryFounsourceInfoStaticByFoundsourceid (null);
	}
	// 设置和获取静态属性列表 IndustryFounsourceStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.IndustryFounsourceInfo objIndustryFounsourceInfo : getIndustryFounsourceStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objIndustryFounsourceInfo.getFoundsourceid(), objIndustryFounsourceInfo.getFoundsourcename()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetIndustryFounsourceInfoStaticByFoundsourceid
	// [start] 设置和获取静态属性列表 IndustryFounsourceInfoStaticByFoundsourceid, 默认值:null
	// 设置和获取静态属性列表 IndustryFounsourceInfoStaticByFoundsourceid, 默认值:null 开始
	private static IndustryFounsourceInfoCollection IndustryFounsourceInfoStaticByFoundsourceid = null;
	/**
	* 获取 静态属性列表 IndustryFounsourceInfoStaticByFoundsourceid, 默认值:null
	 *
	 * @return 静态属性列表 IndustryFounsourceInfoStaticByFoundsourceid, 默认值:null
	 */
	public static IndustryFounsourceInfoCollection getIndustryFounsourceInfoStaticByFoundsourceid()
	{
		return IndustryFounsourceInfoStaticByFoundsourceid;
	}
	/**
	 * 设置 静态属性列表 IndustryFounsourceInfoStaticByFoundsourceid, 默认值:null
	 *
	 * @param sIndustryFounsourceInfoStaticByFoundsourceid
	 *            静态属性列表 IndustryFounsourceInfoStaticByFoundsourceid, 默认值:null
	 */
	public static void setIndustryFounsourceInfoStaticByFoundsourceid(IndustryFounsourceInfoCollection sIndustryFounsourceInfoStaticByFoundsourceid)
	{
		IndustryFounsourceInfoStaticByFoundsourceid = sIndustryFounsourceInfoStaticByFoundsourceid;
	}
	// 设置和获取静态属性列表 IndustryFounsourceInfoStaticByFoundsourceid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 获取表t_industry_founsource 资金来源表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @param Foundsourceid 资金来源编号
        * @return IndustryFounsourceInfo对象实体
        */
        public static IndustryFounsourceInfo GetIndustryFounsourceInfoStaticByFoundsourceid(int Foundsourceid)
        {
            if (IndustryFounsourceInfoStaticByFoundsourceid == null)
                IndustryFounsourceInfoStaticByFoundsourceid = new IndustryFounsourceInfoCollection();
            int allcount = IndustryFounsourceInfoStaticByFoundsourceid.size();
            IndustryFounsourceInfo objIndustryFounsourceInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (IndustryFounsourceInfoStaticByFoundsourceid == null)
                    break;
                    objIndustryFounsourceInfo = IndustryFounsourceInfoStaticByFoundsourceid.get(i);
                if (objIndustryFounsourceInfo == null)
                    break;
                if (objIndustryFounsourceInfo.getFoundsourceid() == Foundsourceid)
                {
                    return objIndustryFounsourceInfo;
                }
            }
            IndustryFounsourceInfo obj= new IndustryFounsourceDAL().GetIndustryFounsourceInfoByFoundsourceid(Foundsourceid);

            if (obj != null)
            {
                if (IndustryFounsourceInfoStaticByFoundsourceid != null)
                    IndustryFounsourceInfoStaticByFoundsourceid.add(obj);
                return obj;
            }
            else
            {
                return new IndustryFounsourceInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByFoundsourceid
        // [start] CountByFoundsourceid
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 统计表t_industry_founsource 资金来源表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @param Foundsourceid 资金来源编号
        * @return 数据量
        */
        public static int CountByFoundsourceid(int Foundsourceid)
        {
            return new IndustryFounsourceDAL().CountByFoundsourceid(Foundsourceid);
        }
        // [end]
        // [start] CountByFoundsourceid
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 统计表t_industry_founsource 资金来源表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @param Foundsourceid 资金来源编号
        * @return 数据量
        */
        public static int CountByFoundsourceid(DataProvider dp, int Foundsourceid)
        {
		IndustryFounsourceDAL dal = new IndustryFounsourceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByFoundsourceid(Foundsourceid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_industry_founsource 资金来源表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new IndustryFounsourceDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_industry_founsource 资金来源表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		IndustryFounsourceDAL dal = new IndustryFounsourceDAL();
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
 返回表t_industry_founsource 资金来源表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryFounsourceInfoCollection GetListBy()
        {
            return new IndustryFounsourceDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_founsource 资金来源表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryFounsourceInfoCollection GetListBy(DataProvider dp )
        {
		IndustryFounsourceDAL dal = new IndustryFounsourceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_founsource 资金来源表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryFounsourceInfoCollection GetListBy(String OrderBy)
        {
            return new IndustryFounsourceDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_founsource 资金来源表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryFounsourceInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		IndustryFounsourceDAL dal = new IndustryFounsourceDAL();
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
 返回表t_industry_founsource 资金来源表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryFounsourceInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new IndustryFounsourceDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_founsource 资金来源表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new IndustryFounsourceDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_founsource 资金来源表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryFounsourceInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new IndustryFounsourceDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_founsource 资金来源表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new IndustryFounsourceDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_founsource 资金来源表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryFounsourceInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		IndustryFounsourceDAL dal = new IndustryFounsourceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_founsource 资金来源表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		IndustryFounsourceDAL dal = new IndustryFounsourceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_founsource 资金来源表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryFounsourceInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		IndustryFounsourceDAL dal = new IndustryFounsourceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_founsource 资金来源表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		IndustryFounsourceDAL dal = new IndustryFounsourceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetIndustryFounsourceInfoByFoundsourceid
        // [start] GetIndustryFounsourceInfoByFoundsourceid
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 获取表t_industry_founsource 资金来源表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @param Foundsourceid 资金来源编号
        * @return IndustryFounsourceInfo对象实体
        */
        public static IndustryFounsourceInfo GetIndustryFounsourceInfoByFoundsourceid(int Foundsourceid)
        {
            return new IndustryFounsourceDAL().GetIndustryFounsourceInfoByFoundsourceid(Foundsourceid);
        }
        // [end]
        // [start] GetIndustryFounsourceInfoByFoundsourceid
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 获取表t_industry_founsource 资金来源表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @param Foundsourceid 资金来源编号
        * @return IndustryFounsourceInfo对象实体
        */
        public static IndustryFounsourceInfo GetIndustryFounsourceInfoByFoundsourceid(DataProvider dp, int Foundsourceid)
        {
		IndustryFounsourceDAL dal = new IndustryFounsourceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetIndustryFounsourceInfoByFoundsourceid(Foundsourceid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_industry_founsource 资金来源表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @param objIndustryFounsourceInfo IndustryFounsourceInfo对象 资金来源表
        */
  public static boolean Insert(IndustryFounsourceInfo objIndustryFounsourceInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objIndustryFounsourceInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_industry_founsource 资金来源表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @param objIndustryFounsourceInfo IndustryFounsourceInfo对象 资金来源表
        */
  public static boolean Insert(DataProvider dp, IndustryFounsourceInfo objIndustryFounsourceInfo)
	{
		IndustryFounsourceDAL dal = new IndustryFounsourceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objIndustryFounsourceInfo);
      setIndustryFounsourceStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_industry_founsource", "添加", objIndustryFounsourceInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByFoundsourceid
        // [start] UpdateByFoundsourceid
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 更新表t_industry_founsource 资金来源表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @param objIndustryFounsourceInfo IndustryFounsourceInfo对象 资金来源表
        */
  public static boolean UpdateByFoundsourceid(IndustryFounsourceInfo objIndustryFounsourceInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByFoundsourceid(dp, objIndustryFounsourceInfo);
	}

	// [end]
        // [start] UpdateByFoundsourceid
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 更新表t_industry_founsource 资金来源表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @param objIndustryFounsourceInfo IndustryFounsourceInfo对象 资金来源表
        */
  public static boolean UpdateByFoundsourceid(DataProvider dp, IndustryFounsourceInfo objIndustryFounsourceInfo)
	{
		IndustryFounsourceDAL dal = new IndustryFounsourceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Foundsourceid =  objIndustryFounsourceInfo.getFoundsourceid();//资金来源编号  数据类型:int
      IndustryFounsourceInfo objOld =  dal.GetIndustryFounsourceInfoByFoundsourceid(Foundsourceid);// 读取实体信息
		dal.UpdateByFoundsourceid(objIndustryFounsourceInfo);
		setIndustryFounsourceStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objIndustryFounsourceInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objIndustryFounsourceInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_industry_founsource", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByFoundsourceid
        // [start] DeleteByFoundsourceid
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 删除数据表t_industry_founsource 资金来源表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @param Foundsourceid 资金来源编号
        */
	public static boolean DeleteByFoundsourceid(int Foundsourceid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByFoundsourceid(dp, Foundsourceid);
	}

	// [end]
        // [start] DeleteByFoundsourceid
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 删除数据表t_industry_founsource 资金来源表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:50
        *
        * @param Foundsourceid 资金来源编号
        */
	public static boolean DeleteByFoundsourceid(DataProvider dp, int Foundsourceid)
	{
		IndustryFounsourceDAL dal = new IndustryFounsourceDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      IndustryFounsourceInfo objOld =  dal.GetIndustryFounsourceInfoByFoundsourceid(Foundsourceid);// 读取实体信息
		dal.DeleteByFoundsourceid(Foundsourceid);
		setIndustryFounsourceStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_industry_founsource", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}