/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:29:59
   功能说明: 表t_industry_type 产业项目类别类别表的业务类IndustryTypeInfo的业务层基类
   表说明:产业项目类别类别表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表IndustryType 产业项目类别类别表 的实体IndustryTypeInfo的数据操作类
 *
 */
public class IndustryTypeProviderBase
{
	// [start] 设置和获取静态属性列表 IndustryTypeStatic, 默认值:null
	// 设置和获取静态属性列表 IndustryTypeStatic, 默认值:null 开始
	private static IndustryTypeInfoCollection industryTypeStatic = null;
	/**
	* 获取 静态属性列表 IndustryTypeStatic, 默认值:null
	 *
	 * @return 静态属性列表 IndustryTypeStatic, 默认值:null
	 */
	public static IndustryTypeInfoCollection getIndustryTypeStatic()
	{
		if (industryTypeStatic == null)
		  industryTypeStatic = new IndustryTypeDAL().GetListBy();
		return industryTypeStatic;
	}
	/**
	 * 设置 静态属性列表 IndustryTypeStatic, 默认值:null
	 *
	 * @param sIndustryTypeStatic
	 *            静态属性列表 IndustryTypeStatic, 默认值:null
	 */
	public static void setIndustryTypeStatic(IndustryTypeInfoCollection sIndustryTypeStatic)
	{
		industryTypeStatic = sIndustryTypeStatic;
		setIndustryTypeInfoStaticByIndustrydatabaseid (null);
	}
	// 设置和获取静态属性列表 IndustryTypeStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.IndustryTypeInfo objIndustryTypeInfo : getIndustryTypeStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objIndustryTypeInfo.getIndustrydatabaseid(), objIndustryTypeInfo.getIndustryname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetIndustryTypeInfoStaticByIndustrydatabaseid
	// [start] 设置和获取静态属性列表 IndustryTypeInfoStaticByIndustrydatabaseid, 默认值:null
	// 设置和获取静态属性列表 IndustryTypeInfoStaticByIndustrydatabaseid, 默认值:null 开始
	private static IndustryTypeInfoCollection IndustryTypeInfoStaticByIndustrydatabaseid = null;
	/**
	* 获取 静态属性列表 IndustryTypeInfoStaticByIndustrydatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 IndustryTypeInfoStaticByIndustrydatabaseid, 默认值:null
	 */
	public static IndustryTypeInfoCollection getIndustryTypeInfoStaticByIndustrydatabaseid()
	{
		return IndustryTypeInfoStaticByIndustrydatabaseid;
	}
	/**
	 * 设置 静态属性列表 IndustryTypeInfoStaticByIndustrydatabaseid, 默认值:null
	 *
	 * @param sIndustryTypeInfoStaticByIndustrydatabaseid
	 *            静态属性列表 IndustryTypeInfoStaticByIndustrydatabaseid, 默认值:null
	 */
	public static void setIndustryTypeInfoStaticByIndustrydatabaseid(IndustryTypeInfoCollection sIndustryTypeInfoStaticByIndustrydatabaseid)
	{
		IndustryTypeInfoStaticByIndustrydatabaseid = sIndustryTypeInfoStaticByIndustrydatabaseid;
	}
	// 设置和获取静态属性列表 IndustryTypeInfoStaticByIndustrydatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 获取表t_industry_type 产业项目类别类别表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @param Industrydatabaseid IndustrydatabaseID
        * @return IndustryTypeInfo对象实体
        */
        public static IndustryTypeInfo GetIndustryTypeInfoStaticByIndustrydatabaseid(int Industrydatabaseid)
        {
            if (IndustryTypeInfoStaticByIndustrydatabaseid == null)
                IndustryTypeInfoStaticByIndustrydatabaseid = new IndustryTypeInfoCollection();
            int allcount = IndustryTypeInfoStaticByIndustrydatabaseid.size();
            IndustryTypeInfo objIndustryTypeInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (IndustryTypeInfoStaticByIndustrydatabaseid == null)
                    break;
                    objIndustryTypeInfo = IndustryTypeInfoStaticByIndustrydatabaseid.get(i);
                if (objIndustryTypeInfo == null)
                    break;
                if (objIndustryTypeInfo.getIndustrydatabaseid() == Industrydatabaseid)
                {
                    return objIndustryTypeInfo;
                }
            }
            IndustryTypeInfo obj= new IndustryTypeDAL().GetIndustryTypeInfoByIndustrydatabaseid(Industrydatabaseid);

            if (obj != null)
            {
                if (IndustryTypeInfoStaticByIndustrydatabaseid != null)
                    IndustryTypeInfoStaticByIndustrydatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new IndustryTypeInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByIndustrydatabaseid
        // [start] CountByIndustrydatabaseid
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 统计表t_industry_type 产业项目类别类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @param Industrydatabaseid IndustrydatabaseID
        * @return 数据量
        */
        public static int CountByIndustrydatabaseid(int Industrydatabaseid)
        {
            return new IndustryTypeDAL().CountByIndustrydatabaseid(Industrydatabaseid);
        }
        // [end]
        // [start] CountByIndustrydatabaseid
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 统计表t_industry_type 产业项目类别类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @param Industrydatabaseid IndustrydatabaseID
        * @return 数据量
        */
        public static int CountByIndustrydatabaseid(DataProvider dp, int Industrydatabaseid)
        {
		IndustryTypeDAL dal = new IndustryTypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByIndustrydatabaseid(Industrydatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_industry_type 产业项目类别类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new IndustryTypeDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_industry_type 产业项目类别类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		IndustryTypeDAL dal = new IndustryTypeDAL();
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
 返回表t_industry_type 产业项目类别类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryTypeInfoCollection GetListBy()
        {
            return new IndustryTypeDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_type 产业项目类别类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryTypeInfoCollection GetListBy(DataProvider dp )
        {
		IndustryTypeDAL dal = new IndustryTypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_type 产业项目类别类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryTypeInfoCollection GetListBy(String OrderBy)
        {
            return new IndustryTypeDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_type 产业项目类别类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryTypeInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		IndustryTypeDAL dal = new IndustryTypeDAL();
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
 返回表t_industry_type 产业项目类别类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryTypeInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new IndustryTypeDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_type 产业项目类别类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new IndustryTypeDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_type 产业项目类别类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryTypeInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new IndustryTypeDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_type 产业项目类别类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new IndustryTypeDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_type 产业项目类别类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryTypeInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		IndustryTypeDAL dal = new IndustryTypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_type 产业项目类别类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		IndustryTypeDAL dal = new IndustryTypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_type 产业项目类别类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @return 数据列表的强类型实体类
        */
        public static IndustryTypeInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		IndustryTypeDAL dal = new IndustryTypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_type 产业项目类别类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		IndustryTypeDAL dal = new IndustryTypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetIndustryTypeInfoByIndustrydatabaseid
        // [start] GetIndustryTypeInfoByIndustrydatabaseid
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 获取表t_industry_type 产业项目类别类别表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @param Industrydatabaseid IndustrydatabaseID
        * @return IndustryTypeInfo对象实体
        */
        public static IndustryTypeInfo GetIndustryTypeInfoByIndustrydatabaseid(int Industrydatabaseid)
        {
            return new IndustryTypeDAL().GetIndustryTypeInfoByIndustrydatabaseid(Industrydatabaseid);
        }
        // [end]
        // [start] GetIndustryTypeInfoByIndustrydatabaseid
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 获取表t_industry_type 产业项目类别类别表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @param Industrydatabaseid IndustrydatabaseID
        * @return IndustryTypeInfo对象实体
        */
        public static IndustryTypeInfo GetIndustryTypeInfoByIndustrydatabaseid(DataProvider dp, int Industrydatabaseid)
        {
		IndustryTypeDAL dal = new IndustryTypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetIndustryTypeInfoByIndustrydatabaseid(Industrydatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_industry_type 产业项目类别类别表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @param objIndustryTypeInfo IndustryTypeInfo对象 产业项目类别类别表
        */
  public static boolean Insert(IndustryTypeInfo objIndustryTypeInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objIndustryTypeInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_industry_type 产业项目类别类别表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @param objIndustryTypeInfo IndustryTypeInfo对象 产业项目类别类别表
        */
  public static boolean Insert(DataProvider dp, IndustryTypeInfo objIndustryTypeInfo)
	{
		IndustryTypeDAL dal = new IndustryTypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objIndustryTypeInfo);
      setIndustryTypeStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_industry_type", "添加", objIndustryTypeInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByIndustrydatabaseid
        // [start] UpdateByIndustrydatabaseid
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 更新表t_industry_type 产业项目类别类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @param objIndustryTypeInfo IndustryTypeInfo对象 产业项目类别类别表
        */
  public static boolean UpdateByIndustrydatabaseid(IndustryTypeInfo objIndustryTypeInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByIndustrydatabaseid(dp, objIndustryTypeInfo);
	}

	// [end]
        // [start] UpdateByIndustrydatabaseid
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 更新表t_industry_type 产业项目类别类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @param objIndustryTypeInfo IndustryTypeInfo对象 产业项目类别类别表
        */
  public static boolean UpdateByIndustrydatabaseid(DataProvider dp, IndustryTypeInfo objIndustryTypeInfo)
	{
		IndustryTypeDAL dal = new IndustryTypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Industrydatabaseid =  objIndustryTypeInfo.getIndustrydatabaseid();//IndustrydatabaseID  数据类型:int
      IndustryTypeInfo objOld =  dal.GetIndustryTypeInfoByIndustrydatabaseid(Industrydatabaseid);// 读取实体信息
		dal.UpdateByIndustrydatabaseid(objIndustryTypeInfo);
		setIndustryTypeStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objIndustryTypeInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objIndustryTypeInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_industry_type", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByIndustrydatabaseid
        // [start] DeleteByIndustrydatabaseid
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 删除数据表t_industry_type 产业项目类别类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @param Industrydatabaseid IndustrydatabaseID
        */
	public static boolean DeleteByIndustrydatabaseid(int Industrydatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByIndustrydatabaseid(dp, Industrydatabaseid);
	}

	// [end]
        // [start] DeleteByIndustrydatabaseid
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 删除数据表t_industry_type 产业项目类别类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:29:59
        *
        * @param Industrydatabaseid IndustrydatabaseID
        */
	public static boolean DeleteByIndustrydatabaseid(DataProvider dp, int Industrydatabaseid)
	{
		IndustryTypeDAL dal = new IndustryTypeDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      IndustryTypeInfo objOld =  dal.GetIndustryTypeInfoByIndustrydatabaseid(Industrydatabaseid);// 读取实体信息
		dal.DeleteByIndustrydatabaseid(Industrydatabaseid);
		setIndustryTypeStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_industry_type", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}