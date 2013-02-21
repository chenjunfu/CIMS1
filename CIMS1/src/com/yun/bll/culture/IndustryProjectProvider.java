/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:29:56
   功能说明: 表t_industry_project 文化项目表的业务类IndustryProjectInfo的业务层
   表说明:文化项目表
======================================================================*/
package com.yun.bll.culture;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;
import com.yun.bll.culture.base.*;


/**
 * 表IndustryProject文化项目表 的实体IndustryProjectInfo的数据操作类
 * @author 贾军磊
 *
 */
public class IndustryProjectProvider extends IndustryProjectProviderBase
{
    // [start] GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid
    // [start] GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
* DutyUnitID Dutyunitid 主管单位<br />
* IndustryID Industryid 产业类别<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 15:13:37
    *
    * @param Projectname 项目名称
    * @param Createtime 创建时间
    * @param Regionid 所属区域
    * @param Dutyunitid 主管单位
    * @param Industryid 产业类别
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(String Projectname, Date Createtime1, Date Createtime2, int Regionid, int Dutyunitid, int Industryid, int pageIndex, int pageSize)
    {
        return new IndustryProjectDAL().GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(Projectname, Createtime1, Createtime2, Regionid, Dutyunitid, Industryid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
* DutyUnitID Dutyunitid 主管单位<br />
* IndustryID Industryid 产业类别<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 15:13:37
    *
    * @param Projectname 项目名称
    * @param Createtime 创建时间
    * @param Regionid 所属区域
    * @param Dutyunitid 主管单位
    * @param Industryid 产业类别
    * @return 数据总量
    */
    public static int GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(String Projectname, Date Createtime1, Date Createtime2, int Regionid, int Dutyunitid, int Industryid)
    {
        return new IndustryProjectDAL().GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(Projectname, Createtime1, Createtime2, Regionid, Dutyunitid, Industryid);
    }
    // [end]
    // [start] GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
* DutyUnitID Dutyunitid 主管单位<br />
* IndustryID Industryid 产业类别<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 15:13:37
    *
    * @param Projectname 项目名称
    * @param Createtime 创建时间
    * @param Regionid 所属区域
    * @param Dutyunitid 主管单位
    * @param Industryid 产业类别
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(String Projectname, Date Createtime1, Date Createtime2, int Regionid, int Dutyunitid, int Industryid,  String OrderBy, int pageIndex, int pageSize)
    {
        return new IndustryProjectDAL().GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(Projectname, Createtime1, Createtime2, Regionid, Dutyunitid, Industryid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
* DutyUnitID Dutyunitid 主管单位<br />
* IndustryID Industryid 产业类别<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 15:13:37
    *
    * @param Projectname 项目名称
    * @param Createtime 创建时间
    * @param Regionid 所属区域
    * @param Dutyunitid 主管单位
    * @param Industryid 产业类别
    * @return 数据总量
    */
    public static int GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(String Projectname, Date Createtime1, Date Createtime2, int Regionid, int Dutyunitid, int Industryid, String OrderBy)
    {
        return new IndustryProjectDAL().GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(Projectname, Createtime1, Createtime2, Regionid, Dutyunitid, Industryid,  OrderBy);
    }
    // [end]
    // [start] GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
* DutyUnitID Dutyunitid 主管单位<br />
* IndustryID Industryid 产业类别<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 15:13:37
    *
    * @param Projectname 项目名称
    * @param Createtime 创建时间
    * @param Regionid 所属区域
    * @param Dutyunitid 主管单位
    * @param Industryid 产业类别
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(DataProvider dp,String Projectname, Date Createtime1, Date Createtime2, int Regionid, int Dutyunitid, int Industryid, int pageIndex, int pageSize)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(Projectname, Createtime1, Createtime2, Regionid, Dutyunitid, Industryid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
* DutyUnitID Dutyunitid 主管单位<br />
* IndustryID Industryid 产业类别<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 15:13:37
    *
    * @param Projectname 项目名称
    * @param Createtime 创建时间
    * @param Regionid 所属区域
    * @param Dutyunitid 主管单位
    * @param Industryid 产业类别
    * @return 数据总量
    */
    public static int GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(DataProvider dp, String Projectname, Date Createtime1, Date Createtime2, int Regionid, int Dutyunitid, int Industryid)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(Projectname, Createtime1, Createtime2, Regionid, Dutyunitid, Industryid);
    }
    // [end]
    // [start] GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
* DutyUnitID Dutyunitid 主管单位<br />
* IndustryID Industryid 产业类别<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 15:13:37
    *
    * @param Projectname 项目名称
    * @param Createtime 创建时间
    * @param Regionid 所属区域
    * @param Dutyunitid 主管单位
    * @param Industryid 产业类别
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(DataProvider dp, String Projectname, Date Createtime1, Date Createtime2, int Regionid, int Dutyunitid, int Industryid,  String OrderBy, int pageIndex, int pageSize)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(Projectname, Createtime1, Createtime2, Regionid, Dutyunitid, Industryid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
* DutyUnitID Dutyunitid 主管单位<br />
* IndustryID Industryid 产业类别<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 15:13:37
    *
    * @param Projectname 项目名称
    * @param Createtime 创建时间
    * @param Regionid 所属区域
    * @param Dutyunitid 主管单位
    * @param Industryid 产业类别
    * @return 数据总量
    */
    public static int GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(DataProvider dp, String Projectname, Date Createtime1, Date Createtime2, int Regionid, int Dutyunitid, int Industryid, String OrderBy)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(Projectname, Createtime1, Createtime2, Regionid, Dutyunitid, Industryid,  OrderBy);
    }
    // [end]
    
    // [end]
    // [end]
    // [start] GetListPagerByCreatetime
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 09:31:42
    *
    * @param Createtime 创建时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetime(Date Createtime, int pageIndex, int pageSize)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetime(Createtime,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 09:31:42
    *
    * @param Createtime 创建时间
    * @return 数据总量
    */
    public static int GetListPagerByCreatetime(Date Createtime)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetime(Createtime);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 09:31:42
    *
    * @param Createtime 创建时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetime(Date Createtime,  String OrderBy, int pageIndex, int pageSize)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetime(Createtime,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 09:31:42
    *
    * @param Createtime 创建时间
    * @return 数据总量
    */
    public static int GetListPagerByCreatetime(Date Createtime, String OrderBy)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetime(Createtime,  OrderBy);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 09:31:42
    *
    * @param Createtime 创建时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetime(DataProvider dp,Date Createtime, int pageIndex, int pageSize)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetime(Createtime,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 09:31:42
    *
    * @param Createtime 创建时间
    * @return 数据总量
    */
    public static int GetListPagerByCreatetime(DataProvider dp, Date Createtime)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetime(Createtime);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 09:31:42
    *
    * @param Createtime 创建时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetime(DataProvider dp, Date Createtime,  String OrderBy, int pageIndex, int pageSize)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetime(Createtime,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 09:31:42
    *
    * @param Createtime 创建时间
    * @return 数据总量
    */
    public static int GetListPagerByCreatetime(DataProvider dp, Date Createtime, String OrderBy)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetime(Createtime,  OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListPagerByCreatetime
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 12:46:31
    *
    * @param Createtime 创建时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetime(Date Createtime1, Date Createtime2, int pageIndex, int pageSize)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetime(Createtime1, Createtime2,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 12:46:31
    *
    * @param Createtime 创建时间
    * @return 数据总量
    */
    public static int GetListPagerByCreatetime(Date Createtime1, Date Createtime2)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetime(Createtime1, Createtime2);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 12:46:31
    *
    * @param Createtime 创建时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetime(Date Createtime1, Date Createtime2,  String OrderBy, int pageIndex, int pageSize)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetime(Createtime1, Createtime2,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 12:46:31
    *
    * @param Createtime 创建时间
    * @return 数据总量
    */
    public static int GetListPagerByCreatetime(Date Createtime1, Date Createtime2, String OrderBy)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetime(Createtime1, Createtime2,  OrderBy);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 12:46:31
    *
    * @param Createtime 创建时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetime(DataProvider dp,Date Createtime1, Date Createtime2, int pageIndex, int pageSize)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetime(Createtime1, Createtime2,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 12:46:31
    *
    * @param Createtime 创建时间
    * @return 数据总量
    */
    public static int GetListPagerByCreatetime(DataProvider dp, Date Createtime1, Date Createtime2)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetime(Createtime1, Createtime2);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 12:46:31
    *
    * @param Createtime 创建时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetime(DataProvider dp, Date Createtime1, Date Createtime2,  String OrderBy, int pageIndex, int pageSize)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetime(Createtime1, Createtime2,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 12:46:31
    *
    * @param Createtime 创建时间
    * @return 数据总量
    */
    public static int GetListPagerByCreatetime(DataProvider dp, Date Createtime1, Date Createtime2, String OrderBy)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetime(Createtime1, Createtime2,  OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListPagerByCompletetime
    // [start] GetListPagerByCreatetimeCompletetime
    // [start] GetListPagerByCreatetimeCompletetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* CompleteTime Completetime 完成时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 14:23:09
    *
    * @param Createtime 创建时间
    * @param Completetime 完成时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetimeCompletetime(Date Createtime1, Date Createtime2, Date Completetime, int pageIndex, int pageSize)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetimeCompletetime(Createtime1, Createtime2, Completetime,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeCompletetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* CompleteTime Completetime 完成时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 14:23:09
    *
    * @param Createtime 创建时间
    * @param Completetime 完成时间
    * @return 数据总量
    */
    public static int GetListPagerByCreatetimeCompletetime(Date Createtime1, Date Createtime2, Date Completetime)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetimeCompletetime(Createtime1, Createtime2, Completetime);
    }
    // [end]
    // [start] GetListPagerByCreatetimeCompletetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* CompleteTime Completetime 完成时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 14:23:09
    *
    * @param Createtime 创建时间
    * @param Completetime 完成时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetimeCompletetime(Date Createtime1, Date Createtime2, Date Completetime,  String OrderBy, int pageIndex, int pageSize)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetimeCompletetime(Createtime1, Createtime2, Completetime,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeCompletetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* CompleteTime Completetime 完成时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 14:23:09
    *
    * @param Createtime 创建时间
    * @param Completetime 完成时间
    * @return 数据总量
    */
    public static int GetListPagerByCreatetimeCompletetime(Date Createtime1, Date Createtime2, Date Completetime, String OrderBy)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetimeCompletetime(Createtime1, Createtime2, Completetime,  OrderBy);
    }
    // [end]
    // [start] GetListPagerByCreatetimeCompletetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* CompleteTime Completetime 完成时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 14:23:09
    *
    * @param Createtime 创建时间
    * @param Completetime 完成时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetimeCompletetime(DataProvider dp,Date Createtime1, Date Createtime2, Date Completetime, int pageIndex, int pageSize)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetimeCompletetime(Createtime1, Createtime2, Completetime,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeCompletetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* CompleteTime Completetime 完成时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 14:23:09
    *
    * @param Createtime 创建时间
    * @param Completetime 完成时间
    * @return 数据总量
    */
    public static int GetListPagerByCreatetimeCompletetime(DataProvider dp, Date Createtime1, Date Createtime2, Date Completetime)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetimeCompletetime(Createtime1, Createtime2, Completetime);
    }
    // [end]
    // [start] GetListPagerByCreatetimeCompletetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* CompleteTime Completetime 完成时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 14:23:09
    *
    * @param Createtime 创建时间
    * @param Completetime 完成时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetimeCompletetime(DataProvider dp, Date Createtime1, Date Createtime2, Date Completetime,  String OrderBy, int pageIndex, int pageSize)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetimeCompletetime(Createtime1, Createtime2, Completetime,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeCompletetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* CompleteTime Completetime 完成时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 14:23:09
    *
    * @param Createtime 创建时间
    * @param Completetime 完成时间
    * @return 数据总量
    */
    public static int GetListPagerByCreatetimeCompletetime(DataProvider dp, Date Createtime1, Date Createtime2, Date Completetime, String OrderBy)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetimeCompletetime(Createtime1, Createtime2, Completetime,  OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:33:28
    *
    * @param Createtime 创建时间
    * @param Regionid 所属区域
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetimeRegionid(Date Createtime, int Regionid, int pageIndex, int pageSize)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetimeRegionid(Createtime, Regionid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:33:28
    *
    * @param Createtime 创建时间
    * @param Regionid 所属区域
    * @return 数据总量
    */
    public static int GetListPagerByCreatetimeRegionid(Date Createtime, int Regionid)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetimeRegionid(Createtime, Regionid);
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:33:28
    *
    * @param Createtime 创建时间
    * @param Regionid 所属区域
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetimeRegionid(Date Createtime, int Regionid,  String OrderBy, int pageIndex, int pageSize)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetimeRegionid(Createtime, Regionid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:33:28
    *
    * @param Createtime 创建时间
    * @param Regionid 所属区域
    * @return 数据总量
    */
    public static int GetListPagerByCreatetimeRegionid(Date Createtime, int Regionid, String OrderBy)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetimeRegionid(Createtime, Regionid,  OrderBy);
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:33:28
    *
    * @param Createtime 创建时间
    * @param Regionid 所属区域
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetimeRegionid(DataProvider dp,Date Createtime, int Regionid, int pageIndex, int pageSize)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetimeRegionid(Createtime, Regionid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:33:28
    *
    * @param Createtime 创建时间
    * @param Regionid 所属区域
    * @return 数据总量
    */
    public static int GetListPagerByCreatetimeRegionid(DataProvider dp, Date Createtime, int Regionid)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetimeRegionid(Createtime, Regionid);
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:33:28
    *
    * @param Createtime 创建时间
    * @param Regionid 所属区域
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetimeRegionid(DataProvider dp, Date Createtime, int Regionid,  String OrderBy, int pageIndex, int pageSize)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetimeRegionid(Createtime, Regionid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:33:28
    *
    * @param Createtime 创建时间
    * @param Regionid 所属区域
    * @return 数据总量
    */
    public static int GetListPagerByCreatetimeRegionid(DataProvider dp, Date Createtime, int Regionid, String OrderBy)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetimeRegionid(Createtime, Regionid,  OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListPagerByCreatetimeIndustryid
    // [start] GetListPagerByCreatetimeIndustryid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* IndustryID Industryid 产业类别<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:41:14
    *
    * @param Createtime 创建时间
    * @param Industryid 产业类别
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetimeIndustryid(Date Createtime, int Industryid, int pageIndex, int pageSize)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetimeIndustryid(Createtime, Industryid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeIndustryid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* IndustryID Industryid 产业类别<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:41:14
    *
    * @param Createtime 创建时间
    * @param Industryid 产业类别
    * @return 数据总量
    */
    public static int GetListPagerByCreatetimeIndustryid(Date Createtime, int Industryid)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetimeIndustryid(Createtime, Industryid);
    }
    // [end]
    // [start] GetListPagerByCreatetimeIndustryid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* IndustryID Industryid 产业类别<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:41:14
    *
    * @param Createtime 创建时间
    * @param Industryid 产业类别
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetimeIndustryid(Date Createtime, int Industryid,  String OrderBy, int pageIndex, int pageSize)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetimeIndustryid(Createtime, Industryid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeIndustryid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* IndustryID Industryid 产业类别<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:41:14
    *
    * @param Createtime 创建时间
    * @param Industryid 产业类别
    * @return 数据总量
    */
    public static int GetListPagerByCreatetimeIndustryid(Date Createtime, int Industryid, String OrderBy)
    {
        return new IndustryProjectDAL().GetListPagerByCreatetimeIndustryid(Createtime, Industryid,  OrderBy);
    }
    // [end]
    // [start] GetListPagerByCreatetimeIndustryid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* IndustryID Industryid 产业类别<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:41:14
    *
    * @param Createtime 创建时间
    * @param Industryid 产业类别
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetimeIndustryid(DataProvider dp,Date Createtime, int Industryid, int pageIndex, int pageSize)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetimeIndustryid(Createtime, Industryid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeIndustryid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* IndustryID Industryid 产业类别<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:41:14
    *
    * @param Createtime 创建时间
    * @param Industryid 产业类别
    * @return 数据总量
    */
    public static int GetListPagerByCreatetimeIndustryid(DataProvider dp, Date Createtime, int Industryid)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetimeIndustryid(Createtime, Industryid);
    }
    // [end]
    // [start] GetListPagerByCreatetimeIndustryid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* IndustryID Industryid 产业类别<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:41:14
    *
    * @param Createtime 创建时间
    * @param Industryid 产业类别
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPagerByCreatetimeIndustryid(DataProvider dp, Date Createtime, int Industryid,  String OrderBy, int pageIndex, int pageSize)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetimeIndustryid(Createtime, Industryid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeIndustryid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* IndustryID Industryid 产业类别<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:41:14
    *
    * @param Createtime 创建时间
    * @param Industryid 产业类别
    * @return 数据总量
    */
    public static int GetListPagerByCreatetimeIndustryid(DataProvider dp, Date Createtime, int Industryid, String OrderBy)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByCreatetimeIndustryid(Createtime, Industryid,  OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListPager_lessthan_ByCreatetime
    // [start] GetListPager_lessthan_ByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:48:41
    *
    * @param Createtime 创建时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPager_lessthan_ByCreatetime(Date Createtime, int pageIndex, int pageSize)
    {
        return new IndustryProjectDAL().GetListPager_lessthan_ByCreatetime(Createtime,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPager_lessthan_ByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:48:41
    *
    * @param Createtime 创建时间
    * @return 数据总量
    */
    public static int GetListPager_lessthan_ByCreatetime(Date Createtime)
    {
        return new IndustryProjectDAL().GetListPager_lessthan_ByCreatetime(Createtime);
    }
    // [end]
    // [start] GetListPager_lessthan_ByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:48:41
    *
    * @param Createtime 创建时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPager_lessthan_ByCreatetime(Date Createtime,  String OrderBy, int pageIndex, int pageSize)
    {
        return new IndustryProjectDAL().GetListPager_lessthan_ByCreatetime(Createtime,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPager_lessthan_ByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:48:41
    *
    * @param Createtime 创建时间
    * @return 数据总量
    */
    public static int GetListPager_lessthan_ByCreatetime(Date Createtime, String OrderBy)
    {
        return new IndustryProjectDAL().GetListPager_lessthan_ByCreatetime(Createtime,  OrderBy);
    }
    // [end]
    // [start] GetListPager_lessthan_ByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:48:41
    *
    * @param Createtime 创建时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPager_lessthan_ByCreatetime(DataProvider dp,Date Createtime, int pageIndex, int pageSize)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPager_lessthan_ByCreatetime(Createtime,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPager_lessthan_ByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:48:41
    *
    * @param Createtime 创建时间
    * @return 数据总量
    */
    public static int GetListPager_lessthan_ByCreatetime(DataProvider dp, Date Createtime)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPager_lessthan_ByCreatetime(Createtime);
    }
    // [end]
    // [start] GetListPager_lessthan_ByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:48:41
    *
    * @param Createtime 创建时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListPager_lessthan_ByCreatetime(DataProvider dp, Date Createtime,  String OrderBy, int pageIndex, int pageSize)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPager_lessthan_ByCreatetime(Createtime,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPager_lessthan_ByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:48:41
    *
    * @param Createtime 创建时间
    * @return 数据总量
    */
    public static int GetListPager_lessthan_ByCreatetime(DataProvider dp, Date Createtime, String OrderBy)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPager_lessthan_ByCreatetime(Createtime,  OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListByCompletetime
    // [start] GetListByCompletetime
    /**
    * 根据 <br />
* CompleteTime Completetime 完成时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月26日 11:22:20
    *
    * @param Completetime 完成时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListByCompletetime(Date Completetime)
    {
        return new IndustryProjectDAL().GetListByCompletetime(Completetime);
    }
    // [end]
    // [start] GetListByCompletetime
    /**
    * 根据 <br />
* CompleteTime Completetime 完成时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月26日 11:22:20
    *
    * @param Completetime 完成时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListByCompletetime(DataProvider dp, Date Completetime)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByCompletetime(Completetime);
    }
    // [end]
    // [start] GetListByCompletetime
    /**
    * 根据 <br />
* CompleteTime Completetime 完成时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月26日 11:22:20
    *
    * @param Completetime 完成时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListByCompletetime(Date Completetime, String OrderBy)
    {
        return new IndustryProjectDAL().GetListByCompletetime(Completetime, OrderBy);
    }
    // [end]
    // [start] GetListByCompletetime
    /**
    * 根据 <br />
* CompleteTime Completetime 完成时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月26日 11:22:20
    *
    * @param Completetime 完成时间
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListByCompletetime(DataProvider dp, Date Completetime, String OrderBy)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByCompletetime(Completetime, OrderBy);
    }
    // [end]
    // [end]

    // [start] CountByRegionid
    // [start] CountByRegionid
    /**
    * 根据 <br />
* RegionID Regionid 所属区域<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月27日 17:46:13
    *
    * @param Regionid 所属区域
    * @return 数据量
    */
    public static int CountByRegionid(int Regionid)
    {
        return new IndustryProjectDAL().CountByRegionid(Regionid);
    }
    // [end]
    // [start] CountByRegionid
    /**
    * 根据 <br />
* RegionID Regionid 所属区域<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月27日 17:46:13
    *
    * @param Regionid 所属区域
    * @return 数据量
    */
    public static int CountByRegionid(DataProvider dp, int Regionid)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.CountByRegionid(Regionid);
    }
    // [end]
    // [end]
    
    // [start] CountByProjectid
    // [start] CountByProjectid
    /**
    * 根据 <br />
* ProjectID Projectid 项目编号<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2013年01月14日 17:31:40
    *
    * @param Projectid 项目编号
    * @return 数据量
    */
    public static int CountByProjectid(int Projectid)
    {
        return new IndustryProjectDAL().CountByProjectid(Projectid);
    }
    // [end]
    // [start] CountByProjectid
    /**
    * 根据 <br />
* ProjectID Projectid 项目编号<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2013年01月14日 17:31:40
    *
    * @param Projectid 项目编号
    * @return 数据量
    */
    public static int CountByProjectid(DataProvider dp, int Projectid)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.CountByProjectid(Projectid);
    }
    // [end]
    // [end]
    // [start] CountByDatabaseenterpriseid
    // [start] CountByDatabaseenterpriseid
    /**
    * 根据 <br />
* DatabaseEnterpriseID Databaseenterpriseid 经营单位<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2013年01月15日 11:42:08
    *
    * @param Databaseenterpriseid 经营单位
    * @return 数据量
    */
    public static int CountByDatabaseenterpriseid(int Databaseenterpriseid)
    {
        return new IndustryProjectDAL().CountByDatabaseenterpriseid(Databaseenterpriseid);
    }
    // [end]
    // [start] CountByDatabaseenterpriseid
    /**
    * 根据 <br />
* DatabaseEnterpriseID Databaseenterpriseid 经营单位<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2013年01月15日 11:42:08
    *
    * @param Databaseenterpriseid 经营单位
    * @return 数据量
    */
    public static int CountByDatabaseenterpriseid(DataProvider dp, int Databaseenterpriseid)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.CountByDatabaseenterpriseid(Databaseenterpriseid);
    }
    // [end]
    // [end]
    // [start] GetListByProjectid
    // [start] GetListByProjectid
    /**
    * 根据 <br />
* ProjectID Projectid 项目编号<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2013年01月15日 15:39:50
    *
    * @param Projectid 项目编号
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListByProjectid(int Projectid)
    {
        return new IndustryProjectDAL().GetListByProjectid(Projectid);
    }
    // [end]
    // [start] GetListByProjectid
    /**
    * 根据 <br />
* ProjectID Projectid 项目编号<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2013年01月15日 15:39:50
    *
    * @param Projectid 项目编号
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListByProjectid(DataProvider dp, int Projectid)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByProjectid(Projectid);
    }
    // [end]
    // [start] GetListByProjectid
    /**
    * 根据 <br />
* ProjectID Projectid 项目编号<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2013年01月15日 15:39:50
    *
    * @param Projectid 项目编号
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListByProjectid(int Projectid, String OrderBy)
    {
        return new IndustryProjectDAL().GetListByProjectid(Projectid, OrderBy);
    }
    // [end]
    // [start] GetListByProjectid
    /**
    * 根据 <br />
* ProjectID Projectid 项目编号<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2013年01月15日 15:39:50
    *
    * @param Projectid 项目编号
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListByProjectid(DataProvider dp, int Projectid, String OrderBy)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByProjectid(Projectid, OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListByProjectname
    // [start] GetListByProjectname
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 17:48:17
    *
    * @param Projectname 项目名称
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListByProjectname(String Projectname)
    {
        return new IndustryProjectDAL().GetListByProjectname(Projectname);
    }
    // [end]
    // [start] GetListByProjectname
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 17:48:17
    *
    * @param Projectname 项目名称
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListByProjectname(DataProvider dp, String Projectname)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByProjectname(Projectname);
    }
    // [end]
    // [start] GetListByProjectname
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 17:48:17
    *
    * @param Projectname 项目名称
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListByProjectname(String Projectname, String OrderBy)
    {
        return new IndustryProjectDAL().GetListByProjectname(Projectname, OrderBy);
    }
    // [end]
    // [start] GetListByProjectname
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 17:48:17
    *
    * @param Projectname 项目名称
    * @return 数据列表的强类型实体类
    */
    public static IndustryProjectInfoCollection GetListByProjectname(DataProvider dp, String Projectname, String OrderBy)
    {
	IndustryProjectDAL dal = new IndustryProjectDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByProjectname(Projectname, OrderBy);
    }
    // [end]
    // [end]

    // [end]

}