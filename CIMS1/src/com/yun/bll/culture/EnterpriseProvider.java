/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:28:53
   功能说明: 表t_enterprise 企业信息表的业务类EnterpriseInfo的业务层
   表说明:企业信息表
======================================================================*/
package com.yun.bll.culture;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;
import com.yun.bll.culture.base.*;


/**
 * 表Enterprise企业信息表 的实体EnterpriseInfo的数据操作类
 * @author 贾军磊
 *
 */
public class EnterpriseProvider extends EnterpriseProviderBase
{
	
    // [start] GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid
    // [start] GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
* BusinessTypeID Businesstypeid 行业类型<br />
* LegalPerson Legalperson 法人<br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:31:25
    *
    * @param Enterprisename 企业名称
    * @param Businesstypeid 行业类型
    * @param Legalperson 法人
    * @param Regionid 所属区域
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(String Enterprisename, int Businesstypeid, String Legalperson, int Regionid, int pageIndex, int pageSize)
    {
        return new EnterpriseDAL().GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(Enterprisename, Businesstypeid, Legalperson, Regionid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
* BusinessTypeID Businesstypeid 行业类型<br />
* LegalPerson Legalperson 法人<br />
* RegionID Regionid 所属区域<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:31:25
    *
    * @param Enterprisename 企业名称
    * @param Businesstypeid 行业类型
    * @param Legalperson 法人
    * @param Regionid 所属区域
    * @return 数据总量
    */
    public static int GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(String Enterprisename, int Businesstypeid, String Legalperson, int Regionid)
    {
        return new EnterpriseDAL().GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(Enterprisename, Businesstypeid, Legalperson, Regionid);
    }
    // [end]
    // [start] GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
* BusinessTypeID Businesstypeid 行业类型<br />
* LegalPerson Legalperson 法人<br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:31:25
    *
    * @param Enterprisename 企业名称
    * @param Businesstypeid 行业类型
    * @param Legalperson 法人
    * @param Regionid 所属区域
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(String Enterprisename, int Businesstypeid, String Legalperson, int Regionid,  String OrderBy, int pageIndex, int pageSize)
    {

        return new EnterpriseDAL().GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(Enterprisename, Businesstypeid, Legalperson, Regionid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
* BusinessTypeID Businesstypeid 行业类型<br />
* LegalPerson Legalperson 法人<br />
* RegionID Regionid 所属区域<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:31:25
    *
    * @param Enterprisename 企业名称
    * @param Businesstypeid 行业类型
    * @param Legalperson 法人
    * @param Regionid 所属区域
    * @return 数据总量
    */
    public static int GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(String Enterprisename, int Businesstypeid, String Legalperson, int Regionid, String OrderBy)
    {
        return new EnterpriseDAL().GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(Enterprisename, Businesstypeid, Legalperson, Regionid,  OrderBy);
    }
    // [end]
    // [start] GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
* BusinessTypeID Businesstypeid 行业类型<br />
* LegalPerson Legalperson 法人<br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:31:25
    *
    * @param Enterprisename 企业名称
    * @param Businesstypeid 行业类型
    * @param Legalperson 法人
    * @param Regionid 所属区域
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(DataProvider dp,String Enterprisename, int Businesstypeid, String Legalperson, int Regionid, int pageIndex, int pageSize)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(Enterprisename, Businesstypeid, Legalperson, Regionid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
* BusinessTypeID Businesstypeid 行业类型<br />
* LegalPerson Legalperson 法人<br />
* RegionID Regionid 所属区域<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:31:25
    *
    * @param Enterprisename 企业名称
    * @param Businesstypeid 行业类型
    * @param Legalperson 法人
    * @param Regionid 所属区域
    * @return 数据总量
    */
    public static int GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(DataProvider dp, String Enterprisename, int Businesstypeid, String Legalperson, int Regionid)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(Enterprisename, Businesstypeid, Legalperson, Regionid);
    }
    // [end]
    // [start] GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
* BusinessTypeID Businesstypeid 行业类型<br />
* LegalPerson Legalperson 法人<br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:31:25
    *
    * @param Enterprisename 企业名称
    * @param Businesstypeid 行业类型
    * @param Legalperson 法人
    * @param Regionid 所属区域
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(DataProvider dp, String Enterprisename, int Businesstypeid, String Legalperson, int Regionid,  String OrderBy, int pageIndex, int pageSize)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(Enterprisename, Businesstypeid, Legalperson, Regionid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
* BusinessTypeID Businesstypeid 行业类型<br />
* LegalPerson Legalperson 法人<br />
* RegionID Regionid 所属区域<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:31:25
    *
    * @param Enterprisename 企业名称
    * @param Businesstypeid 行业类型
    * @param Legalperson 法人
    * @param Regionid 所属区域
    * @return 数据总量
    */
    public static int GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(DataProvider dp, String Enterprisename, int Businesstypeid, String Legalperson, int Regionid, String OrderBy)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(Enterprisename, Businesstypeid, Legalperson, Regionid,  OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListPagerByCreatetime
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:36:58
    *
    * @param Createtime 创立时间
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListPagerByCreatetime(Date Createtime1, Date Createtime2, int pageIndex, int pageSize)
    {
        return new EnterpriseDAL().GetListPagerByCreatetime(Createtime1, Createtime2,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:36:58
    *
    * @param Createtime 创立时间
    * @return 数据总量
    */
    public static int GetListPagerByCreatetime(Date Createtime1, Date Createtime2)
    {
        return new EnterpriseDAL().GetListPagerByCreatetime(Createtime1, Createtime2);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:36:58
    *
    * @param Createtime 创立时间
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListPagerByCreatetime(Date Createtime1, Date Createtime2,  String OrderBy, int pageIndex, int pageSize)
    {
        return new EnterpriseDAL().GetListPagerByCreatetime(Createtime1, Createtime2,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:36:58
    *
    * @param Createtime 创立时间
    * @return 数据总量
    */
    public static int GetListPagerByCreatetime(Date Createtime1, Date Createtime2, String OrderBy)
    {
        return new EnterpriseDAL().GetListPagerByCreatetime(Createtime1, Createtime2,  OrderBy);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:36:58
    *
    * @param Createtime 创立时间
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListPagerByCreatetime(DataProvider dp,Date Createtime1, Date Createtime2, int pageIndex, int pageSize)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetime(Createtime1, Createtime2,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:36:58
    *
    * @param Createtime 创立时间
    * @return 数据总量
    */
    public static int GetListPagerByCreatetime(DataProvider dp, Date Createtime1, Date Createtime2)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetime(Createtime1, Createtime2);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:36:58
    *
    * @param Createtime 创立时间
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListPagerByCreatetime(DataProvider dp, Date Createtime1, Date Createtime2,  String OrderBy, int pageIndex, int pageSize)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetime(Createtime1, Createtime2,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:36:58
    *
    * @param Createtime 创立时间
    * @return 数据总量
    */
    public static int GetListPagerByCreatetime(DataProvider dp, Date Createtime1, Date Createtime2, String OrderBy)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetime(Createtime1, Createtime2,  OrderBy);
    }
    // [end]
    // [start] GetListPagerByBusinesstypeidCreatetime
    // [start] GetListPagerByBusinesstypeidCreatetime
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
* CreateTime Createtime 创立时间<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:40:22
    *
    * @param Businesstypeid 行业类型
    * @param Createtime 创立时间
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListPagerByBusinesstypeidCreatetime(int Businesstypeid, Date Createtime1, Date Createtime2, int pageIndex, int pageSize)
    {
        return new EnterpriseDAL().GetListPagerByBusinesstypeidCreatetime(Businesstypeid, Createtime1, Createtime2,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByBusinesstypeidCreatetime
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
* CreateTime Createtime 创立时间<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:40:22
    *
    * @param Businesstypeid 行业类型
    * @param Createtime 创立时间
    * @return 数据总量
    */
    public static int GetListPagerByBusinesstypeidCreatetime(int Businesstypeid, Date Createtime1, Date Createtime2)
    {
        return new EnterpriseDAL().GetListPagerByBusinesstypeidCreatetime(Businesstypeid, Createtime1, Createtime2);
    }
    // [end]
    // [start] GetListPagerByBusinesstypeidCreatetime
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
* CreateTime Createtime 创立时间<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:40:22
    *
    * @param Businesstypeid 行业类型
    * @param Createtime 创立时间
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListPagerByBusinesstypeidCreatetime(int Businesstypeid, Date Createtime1, Date Createtime2,  String OrderBy, int pageIndex, int pageSize)
    {
        return new EnterpriseDAL().GetListPagerByBusinesstypeidCreatetime(Businesstypeid, Createtime1, Createtime2,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByBusinesstypeidCreatetime
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
* CreateTime Createtime 创立时间<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:40:22
    *
    * @param Businesstypeid 行业类型
    * @param Createtime 创立时间
    * @return 数据总量
    */
    public static int GetListPagerByBusinesstypeidCreatetime(int Businesstypeid, Date Createtime1, Date Createtime2, String OrderBy)
    {
        return new EnterpriseDAL().GetListPagerByBusinesstypeidCreatetime(Businesstypeid, Createtime1, Createtime2,  OrderBy);
    }
    // [end]
    // [start] GetListPagerByBusinesstypeidCreatetime
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
* CreateTime Createtime 创立时间<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:40:22
    *
    * @param Businesstypeid 行业类型
    * @param Createtime 创立时间
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListPagerByBusinesstypeidCreatetime(DataProvider dp,int Businesstypeid, Date Createtime1, Date Createtime2, int pageIndex, int pageSize)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByBusinesstypeidCreatetime(Businesstypeid, Createtime1, Createtime2,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByBusinesstypeidCreatetime
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
* CreateTime Createtime 创立时间<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:40:22
    *
    * @param Businesstypeid 行业类型
    * @param Createtime 创立时间
    * @return 数据总量
    */
    public static int GetListPagerByBusinesstypeidCreatetime(DataProvider dp, int Businesstypeid, Date Createtime1, Date Createtime2)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByBusinesstypeidCreatetime(Businesstypeid, Createtime1, Createtime2);
    }
    // [end]
    // [start] GetListPagerByBusinesstypeidCreatetime
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
* CreateTime Createtime 创立时间<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:40:22
    *
    * @param Businesstypeid 行业类型
    * @param Createtime 创立时间
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListPagerByBusinesstypeidCreatetime(DataProvider dp, int Businesstypeid, Date Createtime1, Date Createtime2,  String OrderBy, int pageIndex, int pageSize)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByBusinesstypeidCreatetime(Businesstypeid, Createtime1, Createtime2,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByBusinesstypeidCreatetime
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
* CreateTime Createtime 创立时间<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:40:22
    *
    * @param Businesstypeid 行业类型
    * @param Createtime 创立时间
    * @return 数据总量
    */
    public static int GetListPagerByBusinesstypeidCreatetime(DataProvider dp, int Businesstypeid, Date Createtime1, Date Createtime2, String OrderBy)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByBusinesstypeidCreatetime(Businesstypeid, Createtime1, Createtime2,  OrderBy);
    }
    // [end]
    // [end]

    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:46:22
    *
    * @param Createtime 创立时间
    * @param Regionid 所属区域
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListPagerByCreatetimeRegionid(Date Createtime1, Date Createtime2, int Regionid, int pageIndex, int pageSize)
    {
        return new EnterpriseDAL().GetListPagerByCreatetimeRegionid(Createtime1, Createtime2, Regionid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
* RegionID Regionid 所属区域<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:46:22
    *
    * @param Createtime 创立时间
    * @param Regionid 所属区域
    * @return 数据总量
    */
    public static int GetListPagerByCreatetimeRegionid(Date Createtime1, Date Createtime2, int Regionid)
    {
        return new EnterpriseDAL().GetListPagerByCreatetimeRegionid(Createtime1, Createtime2, Regionid);
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:46:22
    *
    * @param Createtime 创立时间
    * @param Regionid 所属区域
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListPagerByCreatetimeRegionid(Date Createtime1, Date Createtime2, int Regionid,  String OrderBy, int pageIndex, int pageSize)
    {
        return new EnterpriseDAL().GetListPagerByCreatetimeRegionid(Createtime1, Createtime2, Regionid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
* RegionID Regionid 所属区域<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:46:22
    *
    * @param Createtime 创立时间
    * @param Regionid 所属区域
    * @return 数据总量
    */
    public static int GetListPagerByCreatetimeRegionid(Date Createtime1, Date Createtime2, int Regionid, String OrderBy)
    {
        return new EnterpriseDAL().GetListPagerByCreatetimeRegionid(Createtime1, Createtime2, Regionid,  OrderBy);
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:46:22
    *
    * @param Createtime 创立时间
    * @param Regionid 所属区域
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListPagerByCreatetimeRegionid(DataProvider dp,Date Createtime1, Date Createtime2, int Regionid, int pageIndex, int pageSize)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetimeRegionid(Createtime1, Createtime2, Regionid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
* RegionID Regionid 所属区域<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:46:22
    *
    * @param Createtime 创立时间
    * @param Regionid 所属区域
    * @return 数据总量
    */
    public static int GetListPagerByCreatetimeRegionid(DataProvider dp, Date Createtime1, Date Createtime2, int Regionid)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetimeRegionid(Createtime1, Createtime2, Regionid);
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:46:22
    *
    * @param Createtime 创立时间
    * @param Regionid 所属区域
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListPagerByCreatetimeRegionid(DataProvider dp, Date Createtime1, Date Createtime2, int Regionid,  String OrderBy, int pageIndex, int pageSize)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetimeRegionid(Createtime1, Createtime2, Regionid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
* RegionID Regionid 所属区域<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:46:22
    *
    * @param Createtime 创立时间
    * @param Regionid 所属区域
    * @return 数据总量
    */
    public static int GetListPagerByCreatetimeRegionid(DataProvider dp, Date Createtime1, Date Createtime2, int Regionid, String OrderBy)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetimeRegionid(Createtime1, Createtime2, Regionid,  OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListByRegionid
    // [start] GetListByRegionid
    /**
    * 根据 <br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月15日 16:19:06
    *
    * @param Regionid 所属区域
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByRegionid(int Regionid)
    {
        return new EnterpriseDAL().GetListByRegionid(Regionid);
    }
    // [end]
    // [start] GetListByRegionid
    /**
    * 根据 <br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月15日 16:19:06
    *
    * @param Regionid 所属区域
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByRegionid(DataProvider dp, int Regionid)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByRegionid(Regionid);
    }
    // [end]
    // [start] GetListByRegionid
    /**
    * 根据 <br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月15日 16:19:06
    *
    * @param Regionid 所属区域
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByRegionid(int Regionid, String OrderBy)
    {
        return new EnterpriseDAL().GetListByRegionid(Regionid, OrderBy);
    }
    // [end]
    // [start] GetListByRegionid
    /**
    * 根据 <br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月15日 16:19:06
    *
    * @param Regionid 所属区域
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByRegionid(DataProvider dp, int Regionid, String OrderBy)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByRegionid(Regionid, OrderBy);
    }
    // [end]
    // [end]

    // [start] GetListByBusinesstypeid
    // [start] GetListByBusinesstypeid
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月15日 16:45:03
    *
    * @param Businesstypeid 行业类型
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByBusinesstypeid(int Businesstypeid)
    {
        return new EnterpriseDAL().GetListByBusinesstypeid(Businesstypeid);
    }
    // [end]
    // [start] GetListByBusinesstypeid
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月15日 16:45:03
    *
    * @param Businesstypeid 行业类型
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByBusinesstypeid(DataProvider dp, int Businesstypeid)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByBusinesstypeid(Businesstypeid);
    }
    // [end]
    // [start] GetListByBusinesstypeid
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月15日 16:45:03
    *
    * @param Businesstypeid 行业类型
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByBusinesstypeid(int Businesstypeid, String OrderBy)
    {
        return new EnterpriseDAL().GetListByBusinesstypeid(Businesstypeid, OrderBy);
    }
    // [end]
    // [start] GetListByBusinesstypeid
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月15日 16:45:03
    *
    * @param Businesstypeid 行业类型
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByBusinesstypeid(DataProvider dp, int Businesstypeid, String OrderBy)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByBusinesstypeid(Businesstypeid, OrderBy);
    }
    // [end]
    // [end]
    // [start] CountByEnterpriseid
    // [start] CountByEnterpriseid
    /**
    * 根据 <br />
* EnterpriseID Enterpriseid 企业编号<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2013年01月14日 16:08:29
    *
    * @param Enterpriseid 企业编号
    * @return 数据量
    */
    public static int CountByEnterpriseid(int Enterpriseid)
    {
        return new EnterpriseDAL().CountByEnterpriseid(Enterpriseid);
    }
    // [end]
    // [start] CountByEnterpriseid
    /**
    * 根据 <br />
* EnterpriseID Enterpriseid 企业编号<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2013年01月14日 16:08:29
    *
    * @param Enterpriseid 企业编号
    * @return 数据量
    */
    public static int CountByEnterpriseid(DataProvider dp, int Enterpriseid)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.CountByEnterpriseid(Enterpriseid);
    }
    // [end]
    // [end]
    // [start] GetListByEnterpriseid
    // [start] GetListByEnterpriseid
    /**
    * 根据 <br />
* EnterpriseID Enterpriseid 企业编号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 16:23:36
    *
    * @param Enterpriseid 企业编号
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByEnterpriseid(int Enterpriseid)
    {
        return new EnterpriseDAL().GetListByEnterpriseid(Enterpriseid);
    }
    // [end]
    // [start] GetListByEnterpriseid
    /**
    * 根据 <br />
* EnterpriseID Enterpriseid 企业编号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 16:23:36
    *
    * @param Enterpriseid 企业编号
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByEnterpriseid(DataProvider dp, int Enterpriseid)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByEnterpriseid(Enterpriseid);
    }
    // [end]
    // [start] GetListByEnterpriseid
    /**
    * 根据 <br />
* EnterpriseID Enterpriseid 企业编号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 16:23:36
    *
    * @param Enterpriseid 企业编号
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByEnterpriseid(int Enterpriseid, String OrderBy)
    {
        return new EnterpriseDAL().GetListByEnterpriseid(Enterpriseid, OrderBy);
    }
    // [end]
    // [start] GetListByEnterpriseid
    /**
    * 根据 <br />
* EnterpriseID Enterpriseid 企业编号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 16:23:36
    *
    * @param Enterpriseid 企业编号
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByEnterpriseid(DataProvider dp, int Enterpriseid, String OrderBy)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByEnterpriseid(Enterpriseid, OrderBy);
    }
    // [end]
    // [start] GetListByEnterprisename
    // [start] GetListByEnterprisename
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 16:31:30
    *
    * @param Enterprisename 企业名称
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByEnterprisename(String Enterprisename)
    {
        return new EnterpriseDAL().GetListByEnterprisename(Enterprisename);
    }
    // [end]
    // [start] GetListByEnterprisename
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 16:31:30
    *
    * @param Enterprisename 企业名称
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByEnterprisename(DataProvider dp, String Enterprisename)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByEnterprisename(Enterprisename);
    }
    // [end]
    // [start] GetListByEnterprisename
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 16:31:30
    *
    * @param Enterprisename 企业名称
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByEnterprisename(String Enterprisename, String OrderBy)
    {
        return new EnterpriseDAL().GetListByEnterprisename(Enterprisename, OrderBy);
    }
    // [end]
    // [start] GetListByEnterprisename
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 16:31:30
    *
    * @param Enterprisename 企业名称
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByEnterprisename(DataProvider dp, String Enterprisename, String OrderBy)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByEnterprisename(Enterprisename, OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListByEnterprisecode
    // [start] GetListByEnterprisecode
    /**
    * 根据 <br />
* EnterpriseCode Enterprisecode 工商登记号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月24日 10:25:04
    *
    * @param Enterprisecode 工商登记号
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByEnterprisecode(String Enterprisecode)
    {
        return new EnterpriseDAL().GetListByEnterprisecode(Enterprisecode);
    }
    // [end]
    // [start] GetListByEnterprisecode
    /**
    * 根据 <br />
* EnterpriseCode Enterprisecode 工商登记号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月24日 10:25:04
    *
    * @param Enterprisecode 工商登记号
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByEnterprisecode(DataProvider dp, String Enterprisecode)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByEnterprisecode(Enterprisecode);
    }
    // [end]
    // [start] GetListByEnterprisecode
    /**
    * 根据 <br />
* EnterpriseCode Enterprisecode 工商登记号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月24日 10:25:04
    *
    * @param Enterprisecode 工商登记号
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByEnterprisecode(String Enterprisecode, String OrderBy)
    {
        return new EnterpriseDAL().GetListByEnterprisecode(Enterprisecode, OrderBy);
    }
    // [end]
    // [start] GetListByEnterprisecode
    /**
    * 根据 <br />
* EnterpriseCode Enterprisecode 工商登记号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月24日 10:25:04
    *
    * @param Enterprisecode 工商登记号
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByEnterprisecode(DataProvider dp, String Enterprisecode, String OrderBy)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByEnterprisecode(Enterprisecode, OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListByPartentcode
    // [start] GetListByPartentcode
    /**
    * 根据 <br />
* PartentCode Partentcode 产品专利号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月24日 10:27:00
    *
    * @param Partentcode 产品专利号
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByPartentcode(String Partentcode)
    {
        return new EnterpriseDAL().GetListByPartentcode(Partentcode);
    }
    // [end]
    // [start] GetListByPartentcode
    /**
    * 根据 <br />
* PartentCode Partentcode 产品专利号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月24日 10:27:00
    *
    * @param Partentcode 产品专利号
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByPartentcode(DataProvider dp, String Partentcode)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByPartentcode(Partentcode);
    }
    // [end]
    // [start] GetListByPartentcode
    /**
    * 根据 <br />
* PartentCode Partentcode 产品专利号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月24日 10:27:00
    *
    * @param Partentcode 产品专利号
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByPartentcode(String Partentcode, String OrderBy)
    {
        return new EnterpriseDAL().GetListByPartentcode(Partentcode, OrderBy);
    }
    // [end]
    // [start] GetListByPartentcode
    /**
    * 根据 <br />
* PartentCode Partentcode 产品专利号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月24日 10:27:00
    *
    * @param Partentcode 产品专利号
    * @return 数据列表的强类型实体类
    */
    public static EnterpriseInfoCollection GetListByPartentcode(DataProvider dp, String Partentcode, String OrderBy)
    {
	EnterpriseDAL dal = new EnterpriseDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByPartentcode(Partentcode, OrderBy);
    }
    // [end]
    // [end]

    // [end]


}