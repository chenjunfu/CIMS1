/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:28:43
   功能说明: 表t_education 学历表的业务类EducationInfo的业务层基类
   表说明:学历表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Education 学历表 的实体EducationInfo的数据操作类
 *
 */
public class EducationProviderBase
{
	// [start] 设置和获取静态属性列表 EducationStatic, 默认值:null
	// 设置和获取静态属性列表 EducationStatic, 默认值:null 开始
	private static EducationInfoCollection educationStatic = null;
	/**
	* 获取 静态属性列表 EducationStatic, 默认值:null
	 *
	 * @return 静态属性列表 EducationStatic, 默认值:null
	 */
	public static EducationInfoCollection getEducationStatic()
	{
		if (educationStatic == null)
		  educationStatic = new EducationDAL().GetListBy();
		return educationStatic;
	}
	/**
	 * 设置 静态属性列表 EducationStatic, 默认值:null
	 *
	 * @param sEducationStatic
	 *            静态属性列表 EducationStatic, 默认值:null
	 */
	public static void setEducationStatic(EducationInfoCollection sEducationStatic)
	{
		educationStatic = sEducationStatic;
		setEducationInfoStaticByEducationdatabaseid (null);
	}
	// 设置和获取静态属性列表 EducationStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.EducationInfo objEducationInfo : getEducationStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objEducationInfo.getEducationdatabaseid(), objEducationInfo.getEducationname()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetEducationInfoStaticByEducationdatabaseid
	// [start] 设置和获取静态属性列表 EducationInfoStaticByEducationdatabaseid, 默认值:null
	// 设置和获取静态属性列表 EducationInfoStaticByEducationdatabaseid, 默认值:null 开始
	private static EducationInfoCollection EducationInfoStaticByEducationdatabaseid = null;
	/**
	* 获取 静态属性列表 EducationInfoStaticByEducationdatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 EducationInfoStaticByEducationdatabaseid, 默认值:null
	 */
	public static EducationInfoCollection getEducationInfoStaticByEducationdatabaseid()
	{
		return EducationInfoStaticByEducationdatabaseid;
	}
	/**
	 * 设置 静态属性列表 EducationInfoStaticByEducationdatabaseid, 默认值:null
	 *
	 * @param sEducationInfoStaticByEducationdatabaseid
	 *            静态属性列表 EducationInfoStaticByEducationdatabaseid, 默认值:null
	 */
	public static void setEducationInfoStaticByEducationdatabaseid(EducationInfoCollection sEducationInfoStaticByEducationdatabaseid)
	{
		EducationInfoStaticByEducationdatabaseid = sEducationInfoStaticByEducationdatabaseid;
	}
	// 设置和获取静态属性列表 EducationInfoStaticByEducationdatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 获取表t_education 学历表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationdatabaseid EducationdatabaseID
        * @return EducationInfo对象实体
        */
        public static EducationInfo GetEducationInfoStaticByEducationdatabaseid(int Educationdatabaseid)
        {
            if (EducationInfoStaticByEducationdatabaseid == null)
                EducationInfoStaticByEducationdatabaseid = new EducationInfoCollection();
            int allcount = EducationInfoStaticByEducationdatabaseid.size();
            EducationInfo objEducationInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (EducationInfoStaticByEducationdatabaseid == null)
                    break;
                    objEducationInfo = EducationInfoStaticByEducationdatabaseid.get(i);
                if (objEducationInfo == null)
                    break;
                if (objEducationInfo.getEducationdatabaseid() == Educationdatabaseid)
                {
                    return objEducationInfo;
                }
            }
            EducationInfo obj= new EducationDAL().GetEducationInfoByEducationdatabaseid(Educationdatabaseid);

            if (obj != null)
            {
                if (EducationInfoStaticByEducationdatabaseid != null)
                    EducationInfoStaticByEducationdatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new EducationInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByEducationdatabaseid
        // [start] CountByEducationdatabaseid
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationdatabaseid EducationdatabaseID
        * @return 数据量
        */
        public static int CountByEducationdatabaseid(int Educationdatabaseid)
        {
            return new EducationDAL().CountByEducationdatabaseid(Educationdatabaseid);
        }
        // [end]
        // [start] CountByEducationdatabaseid
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationdatabaseid EducationdatabaseID
        * @return 数据量
        */
        public static int CountByEducationdatabaseid(DataProvider dp, int Educationdatabaseid)
        {
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByEducationdatabaseid(Educationdatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new EducationDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]
        // [start] CountByEducationid
        // [start] CountByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationid 学历编号
        * @return 数据量
        */
        public static int CountByEducationid(int Educationid)
        {
            return new EducationDAL().CountByEducationid(Educationid);
        }
        // [end]
        // [start] CountByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationid 学历编号
        * @return 数据量
        */
        public static int CountByEducationid(DataProvider dp, int Educationid)
        {
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByEducationid(Educationid);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @return 数据列表的强类型实体类
        */
        public static EducationInfoCollection GetListBy()
        {
            return new EducationDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @return 数据列表的强类型实体类
        */
        public static EducationInfoCollection GetListBy(DataProvider dp )
        {
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @return 数据列表的强类型实体类
        */
        public static EducationInfoCollection GetListBy(String OrderBy)
        {
            return new EducationDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @return 数据列表的强类型实体类
        */
        public static EducationInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListByEducationid
        // [start] GetListByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationid 学历编号
        * @return 数据列表的强类型实体类
        */
        public static EducationInfoCollection GetListByEducationid(int Educationid)
        {
            return new EducationDAL().GetListByEducationid(Educationid);
        }
        // [end]
        // [start] GetListByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationid 学历编号
        * @return 数据列表的强类型实体类
        */
        public static EducationInfoCollection GetListByEducationid(DataProvider dp, int Educationid)
        {
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByEducationid(Educationid);
        }
        // [end]
        // [start] GetListByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationid 学历编号
        * @return 数据列表的强类型实体类
        */
        public static EducationInfoCollection GetListByEducationid(int Educationid, String OrderBy)
        {
            return new EducationDAL().GetListByEducationid(Educationid, OrderBy);
        }
        // [end]
        // [start] GetListByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationid 学历编号
        * @return 数据列表的强类型实体类
        */
        public static EducationInfoCollection GetListByEducationid(DataProvider dp, int Educationid, String OrderBy)
        {
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByEducationid(Educationid, OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @return 数据列表的强类型实体类
        */
        public static EducationInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new EducationDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new EducationDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @return 数据列表的强类型实体类
        */
        public static EducationInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new EducationDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new EducationDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @return 数据列表的强类型实体类
        */
        public static EducationInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @return 数据列表的强类型实体类
        */
        public static EducationInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListPagerByEducationid
        // [start] GetListPagerByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationid 学历编号
        * @return 数据列表的强类型实体类
        */
        public static EducationInfoCollection GetListPagerByEducationid(int Educationid, int pageIndex, int pageSize)
        {
            return new EducationDAL().GetListPagerByEducationid(Educationid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationid 学历编号
        * @return 数据总量
        */
        public static int GetListPagerByEducationid(int Educationid)
        {
            return new EducationDAL().GetListPagerByEducationid(Educationid);
        }
        // [end]
        // [start] GetListPagerByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationid 学历编号
        * @return 数据列表的强类型实体类
        */
        public static EducationInfoCollection GetListPagerByEducationid(int Educationid,  String OrderBy, int pageIndex, int pageSize)
        {
            return new EducationDAL().GetListPagerByEducationid(Educationid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationid 学历编号
        * @return 数据总量
        */
        public static int GetListPagerByEducationid(int Educationid, String OrderBy)
        {
            return new EducationDAL().GetListPagerByEducationid(Educationid,  OrderBy);
        }
        // [end]
        // [start] GetListPagerByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationid 学历编号
        * @return 数据列表的强类型实体类
        */
        public static EducationInfoCollection GetListPagerByEducationid(DataProvider dp,int Educationid, int pageIndex, int pageSize)
        {
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByEducationid(Educationid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationid 学历编号
        * @return 数据总量
        */
        public static int GetListPagerByEducationid(DataProvider dp, int Educationid)
        {
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByEducationid(Educationid);
        }
        // [end]
        // [start] GetListPagerByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationid 学历编号
        * @return 数据列表的强类型实体类
        */
        public static EducationInfoCollection GetListPagerByEducationid(DataProvider dp, int Educationid,  String OrderBy, int pageIndex, int pageSize)
        {
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByEducationid(Educationid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationid 学历编号
        * @return 数据总量
        */
        public static int GetListPagerByEducationid(DataProvider dp, int Educationid, String OrderBy)
        {
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByEducationid(Educationid,  OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetEducationInfoByEducationdatabaseid
        // [start] GetEducationInfoByEducationdatabaseid
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 获取表t_education 学历表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationdatabaseid EducationdatabaseID
        * @return EducationInfo对象实体
        */
        public static EducationInfo GetEducationInfoByEducationdatabaseid(int Educationdatabaseid)
        {
            return new EducationDAL().GetEducationInfoByEducationdatabaseid(Educationdatabaseid);
        }
        // [end]
        // [start] GetEducationInfoByEducationdatabaseid
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 获取表t_education 学历表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationdatabaseid EducationdatabaseID
        * @return EducationInfo对象实体
        */
        public static EducationInfo GetEducationInfoByEducationdatabaseid(DataProvider dp, int Educationdatabaseid)
        {
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetEducationInfoByEducationdatabaseid(Educationdatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_education 学历表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param objEducationInfo EducationInfo对象 学历表
        */
  public static boolean Insert(EducationInfo objEducationInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objEducationInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_education 学历表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param objEducationInfo EducationInfo对象 学历表
        */
  public static boolean Insert(DataProvider dp, EducationInfo objEducationInfo)
	{
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objEducationInfo);
      setEducationStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_education", "添加", objEducationInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByEducationdatabaseid
        // [start] UpdateByEducationdatabaseid
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 更新表t_education 学历表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param objEducationInfo EducationInfo对象 学历表
        */
  public static boolean UpdateByEducationdatabaseid(EducationInfo objEducationInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByEducationdatabaseid(dp, objEducationInfo);
	}

	// [end]
        // [start] UpdateByEducationdatabaseid
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 更新表t_education 学历表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param objEducationInfo EducationInfo对象 学历表
        */
  public static boolean UpdateByEducationdatabaseid(DataProvider dp, EducationInfo objEducationInfo)
	{
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Educationdatabaseid =  objEducationInfo.getEducationdatabaseid();//EducationdatabaseID  数据类型:int
      EducationInfo objOld =  dal.GetEducationInfoByEducationdatabaseid(Educationdatabaseid);// 读取实体信息
		dal.UpdateByEducationdatabaseid(objEducationInfo);
		setEducationStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objEducationInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objEducationInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_education", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByEducationdatabaseid
        // [start] DeleteByEducationdatabaseid
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 删除数据表t_education 学历表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationdatabaseid EducationdatabaseID
        */
	public static boolean DeleteByEducationdatabaseid(int Educationdatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByEducationdatabaseid(dp, Educationdatabaseid);
	}

	// [end]
        // [start] DeleteByEducationdatabaseid
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 删除数据表t_education 学历表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:43
        *
        * @param Educationdatabaseid EducationdatabaseID
        */
	public static boolean DeleteByEducationdatabaseid(DataProvider dp, int Educationdatabaseid)
	{
		EducationDAL dal = new EducationDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      EducationInfo objOld =  dal.GetEducationInfoByEducationdatabaseid(Educationdatabaseid);// 读取实体信息
		dal.DeleteByEducationdatabaseid(Educationdatabaseid);
		setEducationStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_education", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}