/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:32:55
   功能说明: 表t_talent 文化人才表的业务类TalentInfo的业务层
   表说明:文化人才表
======================================================================*/
package com.yun.bll.culture;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;
import com.yun.bll.culture.base.*;


/**
 * 表Talent文化人才表 的实体TalentInfo的数据操作类
 * @author 贾军磊
 *
 */
public class TalentProvider extends TalentProviderBase
{
	
    // [start] GetListPagerByTalentnameNationidEducationidMajoridPosttitleid
    // [start] GetListPagerByTalentnameNationidEducationidMajoridPosttitleid
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
* NationID Nationid 民族<br />
* EducationID Educationid 学历<br />
* MajorID Majorid 专业<br />
* PostTitleID Posttitleid 职称<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:59:36
    *
    * @param Talentname 姓名
    * @param Nationid 民族
    * @param Educationid 学历
    * @param Majorid 专业
    * @param Posttitleid 职称
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(String Talentname, int Nationid, int Educationid, int Majorid, int Posttitleid, int pageIndex, int pageSize)
    {
        return new TalentDAL().GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(Talentname, Nationid, Educationid, Majorid, Posttitleid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByTalentnameNationidEducationidMajoridPosttitleid
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
* NationID Nationid 民族<br />
* EducationID Educationid 学历<br />
* MajorID Majorid 专业<br />
* PostTitleID Posttitleid 职称<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:59:36
    *
    * @param Talentname 姓名
    * @param Nationid 民族
    * @param Educationid 学历
    * @param Majorid 专业
    * @param Posttitleid 职称
    * @return 数据总量
    */
    public static int GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(String Talentname, int Nationid, int Educationid, int Majorid, int Posttitleid)
    {
        return new TalentDAL().GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(Talentname, Nationid, Educationid, Majorid, Posttitleid);
    }
    // [end]
    // [start] GetListPagerByTalentnameNationidEducationidMajoridPosttitleid
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
* NationID Nationid 民族<br />
* EducationID Educationid 学历<br />
* MajorID Majorid 专业<br />
* PostTitleID Posttitleid 职称<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:59:36
    *
    * @param Talentname 姓名
    * @param Nationid 民族
    * @param Educationid 学历
    * @param Majorid 专业
    * @param Posttitleid 职称
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(String Talentname, int Nationid, int Educationid, int Majorid, int Posttitleid,  String OrderBy, int pageIndex, int pageSize)
    {
        return new TalentDAL().GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(Talentname, Nationid, Educationid, Majorid, Posttitleid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByTalentnameNationidEducationidMajoridPosttitleid
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
* NationID Nationid 民族<br />
* EducationID Educationid 学历<br />
* MajorID Majorid 专业<br />
* PostTitleID Posttitleid 职称<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:59:36
    *
    * @param Talentname 姓名
    * @param Nationid 民族
    * @param Educationid 学历
    * @param Majorid 专业
    * @param Posttitleid 职称
    * @return 数据总量
    */
    public static int GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(String Talentname, int Nationid, int Educationid, int Majorid, int Posttitleid, String OrderBy)
    {
        return new TalentDAL().GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(Talentname, Nationid, Educationid, Majorid, Posttitleid,  OrderBy);
    }
    // [end]
    // [start] GetListPagerByTalentnameNationidEducationidMajoridPosttitleid
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
* NationID Nationid 民族<br />
* EducationID Educationid 学历<br />
* MajorID Majorid 专业<br />
* PostTitleID Posttitleid 职称<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:59:36
    *
    * @param Talentname 姓名
    * @param Nationid 民族
    * @param Educationid 学历
    * @param Majorid 专业
    * @param Posttitleid 职称
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(DataProvider dp,String Talentname, int Nationid, int Educationid, int Majorid, int Posttitleid, int pageIndex, int pageSize)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(Talentname, Nationid, Educationid, Majorid, Posttitleid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByTalentnameNationidEducationidMajoridPosttitleid
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
* NationID Nationid 民族<br />
* EducationID Educationid 学历<br />
* MajorID Majorid 专业<br />
* PostTitleID Posttitleid 职称<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:59:36
    *
    * @param Talentname 姓名
    * @param Nationid 民族
    * @param Educationid 学历
    * @param Majorid 专业
    * @param Posttitleid 职称
    * @return 数据总量
    */
    public static int GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(DataProvider dp, String Talentname, int Nationid, int Educationid, int Majorid, int Posttitleid)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(Talentname, Nationid, Educationid, Majorid, Posttitleid);
    }
    // [end]
    // [start] GetListPagerByTalentnameNationidEducationidMajoridPosttitleid
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
* NationID Nationid 民族<br />
* EducationID Educationid 学历<br />
* MajorID Majorid 专业<br />
* PostTitleID Posttitleid 职称<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:59:36
    *
    * @param Talentname 姓名
    * @param Nationid 民族
    * @param Educationid 学历
    * @param Majorid 专业
    * @param Posttitleid 职称
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(DataProvider dp, String Talentname, int Nationid, int Educationid, int Majorid, int Posttitleid,  String OrderBy, int pageIndex, int pageSize)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(Talentname, Nationid, Educationid, Majorid, Posttitleid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByTalentnameNationidEducationidMajoridPosttitleid
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
* NationID Nationid 民族<br />
* EducationID Educationid 学历<br />
* MajorID Majorid 专业<br />
* PostTitleID Posttitleid 职称<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:59:36
    *
    * @param Talentname 姓名
    * @param Nationid 民族
    * @param Educationid 学历
    * @param Majorid 专业
    * @param Posttitleid 职称
    * @return 数据总量
    */
    public static int GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(DataProvider dp, String Talentname, int Nationid, int Educationid, int Majorid, int Posttitleid, String OrderBy)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(Talentname, Nationid, Educationid, Majorid, Posttitleid,  OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListPagerByLogintime
    // [start] GetListPagerByLogintime
    /**
    * 根据 <br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月10日 11:44:48
    *
    * @param Logintime 登录时间
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListPagerByLogintime(Date Logintime, int pageIndex, int pageSize)
    {
        return new TalentDAL().GetListPagerByLogintime(Logintime,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByLogintime
    /**
    * 根据 <br />
* LoginTime Logintime 登录时间<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月10日 11:44:48
    *
    * @param Logintime 登录时间
    * @return 数据总量
    */
    public static int GetListPagerByLogintime(Date Logintime)
    {
        return new TalentDAL().GetListPagerByLogintime(Logintime);
    }
    // [end]
    // [start] GetListPagerByLogintime
    /**
    * 根据 <br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月10日 11:44:48
    *
    * @param Logintime 登录时间
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListPagerByLogintime(Date Logintime,  String OrderBy, int pageIndex, int pageSize)
    {
        return new TalentDAL().GetListPagerByLogintime(Logintime,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByLogintime
    /**
    * 根据 <br />
* LoginTime Logintime 登录时间<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月10日 11:44:48
    *
    * @param Logintime 登录时间
    * @return 数据总量
    */
    public static int GetListPagerByLogintime(Date Logintime, String OrderBy)
    {
        return new TalentDAL().GetListPagerByLogintime(Logintime,  OrderBy);
    }
    // [end]
    // [start] GetListPagerByLogintime
    /**
    * 根据 <br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月10日 11:44:48
    *
    * @param Logintime 登录时间
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListPagerByLogintime(DataProvider dp,Date Logintime, int pageIndex, int pageSize)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByLogintime(Logintime,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByLogintime
    /**
    * 根据 <br />
* LoginTime Logintime 登录时间<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月10日 11:44:48
    *
    * @param Logintime 登录时间
    * @return 数据总量
    */
    public static int GetListPagerByLogintime(DataProvider dp, Date Logintime)
    {
    	TalentDAL dal = new TalentDAL();
    	dal.setDP(dp);
    	dal.setDPUpdate(dp);
        return dal.GetListPagerByLogintime(Logintime);
    }
    // [end]
    // [start] GetListPagerByLogintime
    /**
    * 根据 <br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月10日 11:44:48
    *
    * @param Logintime 登录时间
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListPagerByLogintime(DataProvider dp, Date Logintime,  String OrderBy, int pageIndex, int pageSize)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByLogintime(Logintime,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByLogintime
    /**
    * 根据 <br />
* LoginTime Logintime 登录时间<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月10日 11:44:48
    *
    * @param Logintime 登录时间
    * @return 数据总量
    */
    public static int GetListPagerByLogintime(DataProvider dp, Date Logintime, String OrderBy)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByLogintime(Logintime,  OrderBy);
    }
    // [end]
    
    // [start] GetListPagerByTalentprofessionid
    // [start] GetListPagerByTalentprofessionid
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月10日 14:16:53
    *
    * @param Talentprofessionid 人才所属行业
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListPagerByTalentprofessionid(int Talentprofessionid, int pageIndex, int pageSize)
    {
        return new TalentDAL().GetListPagerByTalentprofessionid(Talentprofessionid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByTalentprofessionid
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月10日 14:16:53
    *
    * @param Talentprofessionid 人才所属行业
    * @return 数据总量
    */
    public static int GetListPagerByTalentprofessionid(int Talentprofessionid)
    {
        return new TalentDAL().GetListPagerByTalentprofessionid(Talentprofessionid);
    }
    // [end]
    // [start] GetListPagerByTalentprofessionid
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月10日 14:16:53
    *
    * @param Talentprofessionid 人才所属行业
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListPagerByTalentprofessionid(int Talentprofessionid,  String OrderBy, int pageIndex, int pageSize)
    {
        return new TalentDAL().GetListPagerByTalentprofessionid(Talentprofessionid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByTalentprofessionid
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月10日 14:16:53
    *
    * @param Talentprofessionid 人才所属行业
    * @return 数据总量
    */
    public static int GetListPagerByTalentprofessionid(int Talentprofessionid, String OrderBy)
    {
        return new TalentDAL().GetListPagerByTalentprofessionid(Talentprofessionid,  OrderBy);
    }
    // [end]
    // [start] GetListPagerByTalentprofessionid
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月10日 14:16:53
    *
    * @param Talentprofessionid 人才所属行业
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListPagerByTalentprofessionid(DataProvider dp,int Talentprofessionid, int pageIndex, int pageSize)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByTalentprofessionid(Talentprofessionid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByTalentprofessionid
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月10日 14:16:53
    *
    * @param Talentprofessionid 人才所属行业
    * @return 数据总量
    */
    public static int GetListPagerByTalentprofessionid(DataProvider dp, int Talentprofessionid)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByTalentprofessionid(Talentprofessionid);
    }
    // [end]
    // [start] GetListPagerByTalentprofessionid
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月10日 14:16:53
    *
    * @param Talentprofessionid 人才所属行业
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListPagerByTalentprofessionid(DataProvider dp, int Talentprofessionid,  String OrderBy, int pageIndex, int pageSize)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByTalentprofessionid(Talentprofessionid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByTalentprofessionid
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月10日 14:16:53
    *
    * @param Talentprofessionid 人才所属行业
    * @return 数据总量
    */
    public static int GetListPagerByTalentprofessionid(DataProvider dp, int Talentprofessionid, String OrderBy)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByTalentprofessionid(Talentprofessionid,  OrderBy);
    }
    // [end]
    // [end]
    public static int CountByAgeRange(int MinAge,int MaxAge,Date end)
    {
    	int count=0;
    	TalentDAL dal=new TalentDAL();
    	count=dal.CountAgeByRange(MinAge, MaxAge,end);
    	return count;
    }

    // [end]
    // [start] GetListByEducationid
    // [start] GetListByEducationid
    /**
    * 根据 <br />
* EducationID Educationid 学历<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 09:48:18
    *
    * @param Educationid 学历
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByEducationid(int Educationid)
    {
        return new TalentDAL().GetListByEducationid(Educationid);
    }
    // [end]
    // [start] GetListByEducationid
    /**
    * 根据 <br />
* EducationID Educationid 学历<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 09:48:18
    *
    * @param Educationid 学历
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByEducationid(DataProvider dp, int Educationid)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByEducationid(Educationid);
    }
    // [end]
    // [start] GetListByEducationid
    /**
    * 根据 <br />
* EducationID Educationid 学历<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 09:48:18
    *
    * @param Educationid 学历
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByEducationid(int Educationid, String OrderBy)
    {
        return new TalentDAL().GetListByEducationid(Educationid, OrderBy);
    }
    // [end]
    // [start] GetListByEducationid
    /**
    * 根据 <br />
* EducationID Educationid 学历<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 09:48:18
    *
    * @param Educationid 学历
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByEducationid(DataProvider dp, int Educationid, String OrderBy)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByEducationid(Educationid, OrderBy);
    }
    // [end]
    
    
    
    // [start] GetListByPosttitleid
    // [start] GetListByPosttitleid
    /**
    * 根据 <br />
* PostTitleID Posttitleid 职称<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 09:59:19
    *
    * @param Posttitleid 职称
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByPosttitleid(int Posttitleid)
    {
        return new TalentDAL().GetListByPosttitleid(Posttitleid);
    }
    // [end]
    // [start] GetListByPosttitleid
    /**
    * 根据 <br />
* PostTitleID Posttitleid 职称<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 09:59:19
    *
    * @param Posttitleid 职称
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByPosttitleid(DataProvider dp, int Posttitleid)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByPosttitleid(Posttitleid);
    }
    // [end]
    // [start] GetListByPosttitleid
    /**
    * 根据 <br />
* PostTitleID Posttitleid 职称<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 09:59:19
    *
    * @param Posttitleid 职称
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByPosttitleid(int Posttitleid, String OrderBy)
    {
        return new TalentDAL().GetListByPosttitleid(Posttitleid, OrderBy);
    }
    // [end]
    // [start] GetListByPosttitleid
    /**
    * 根据 <br />
* PostTitleID Posttitleid 职称<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 09:59:19
    *
    * @param Posttitleid 职称
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByPosttitleid(DataProvider dp, int Posttitleid, String OrderBy)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByPosttitleid(Posttitleid, OrderBy);
    }
    // [end]
    // [end]

    // [start] GetListByTalentprofessionidLogintime
    // [start] GetListByTalentprofessionidLogintime
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:43:16
    *
    * @param Talentprofessionid 人才所属行业
    * @param Logintime 登录时间
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByTalentprofessionidLogintime(int Talentprofessionid, Date Logintime)
    {
        return new TalentDAL().GetListByTalentprofessionidLogintime(Talentprofessionid, Logintime);
    }
    // [end]
    // [start] GetListByTalentprofessionidLogintime
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:43:16
    *
    * @param Talentprofessionid 人才所属行业
    * @param Logintime 登录时间
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByTalentprofessionidLogintime(DataProvider dp, int Talentprofessionid, Date Logintime)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByTalentprofessionidLogintime(Talentprofessionid, Logintime);
    }
    // [end]
    // [start] GetListByTalentprofessionidLogintime
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:43:16
    *
    * @param Talentprofessionid 人才所属行业
    * @param Logintime 登录时间
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByTalentprofessionidLogintime(int Talentprofessionid, Date Logintime, String OrderBy)
    {
        return new TalentDAL().GetListByTalentprofessionidLogintime(Talentprofessionid, Logintime, OrderBy);
    }
    // [end]
    // [start] GetListByTalentprofessionidLogintime
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:43:16
    *
    * @param Talentprofessionid 人才所属行业
    * @param Logintime 登录时间
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByTalentprofessionidLogintime(DataProvider dp, int Talentprofessionid, Date Logintime, String OrderBy)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByTalentprofessionidLogintime(Talentprofessionid, Logintime, OrderBy);
    }
    // [end]
    // [end]

    // [end]
    // [start] GetListByEducationidLogintime
    // [start] GetListByEducationidLogintime
    /**
    * 根据 <br />
* EducationID Educationid 学历<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:49:07
    *
    * @param Educationid 学历
    * @param Logintime 登录时间
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByEducationidLogintime(int Educationid, Date Logintime)
    {
        return new TalentDAL().GetListByEducationidLogintime(Educationid, Logintime);
    }
    // [end]
    // [start] GetListByEducationidLogintime
    /**
    * 根据 <br />
* EducationID Educationid 学历<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:49:07
    *
    * @param Educationid 学历
    * @param Logintime 登录时间
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByEducationidLogintime(DataProvider dp, int Educationid, Date Logintime)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByEducationidLogintime(Educationid, Logintime);
    }
    // [end]
    // [start] GetListByEducationidLogintime
    /**
    * 根据 <br />
* EducationID Educationid 学历<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:49:07
    *
    * @param Educationid 学历
    * @param Logintime 登录时间
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByEducationidLogintime(int Educationid, Date Logintime, String OrderBy)
    {
        return new TalentDAL().GetListByEducationidLogintime(Educationid, Logintime, OrderBy);
    }
    // [end]
    // [start] GetListByEducationidLogintime
    /**
    * 根据 <br />
* EducationID Educationid 学历<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:49:07
    *
    * @param Educationid 学历
    * @param Logintime 登录时间
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByEducationidLogintime(DataProvider dp, int Educationid, Date Logintime, String OrderBy)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByEducationidLogintime(Educationid, Logintime, OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListByPosttitleidLogintime
    // [start] GetListByPosttitleidLogintime
    /**
    * 根据 <br />
* PostTitleID Posttitleid 职称<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:49:54
    *
    * @param Posttitleid 职称
    * @param Logintime 登录时间
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByPosttitleidLogintime(int Posttitleid, Date Logintime)
    {
        return new TalentDAL().GetListByPosttitleidLogintime(Posttitleid, Logintime);
    }
    // [end]
    // [start] GetListByPosttitleidLogintime
    /**
    * 根据 <br />
* PostTitleID Posttitleid 职称<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:49:54
    *
    * @param Posttitleid 职称
    * @param Logintime 登录时间
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByPosttitleidLogintime(DataProvider dp, int Posttitleid, Date Logintime)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByPosttitleidLogintime(Posttitleid, Logintime);
    }
    // [end]
    // [start] GetListByPosttitleidLogintime
    /**
    * 根据 <br />
* PostTitleID Posttitleid 职称<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:49:54
    *
    * @param Posttitleid 职称
    * @param Logintime 登录时间
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByPosttitleidLogintime(int Posttitleid, Date Logintime, String OrderBy)
    {
        return new TalentDAL().GetListByPosttitleidLogintime(Posttitleid, Logintime, OrderBy);
    }
    // [end]
    // [start] GetListByPosttitleidLogintime
    /**
    * 根据 <br />
* PostTitleID Posttitleid 职称<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:49:54
    *
    * @param Posttitleid 职称
    * @param Logintime 登录时间
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByPosttitleidLogintime(DataProvider dp, int Posttitleid, Date Logintime, String OrderBy)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByPosttitleidLogintime(Posttitleid, Logintime, OrderBy);
    }
    // [end]
    
    // [start] CountBy
    // [start] CountBy
    /**
    * 根据 <br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2013年01月14日 17:36:08
    *
    * @return 数据量
    */
    public static int CountBy()
    {
        return new TalentDAL().CountBy();
    }
    // [end]
    // [start] CountBy
    /**
    * 根据 <br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2013年01月14日 17:36:08
    *
    * @return 数据量
    */
    public static int CountBy(DataProvider dp )
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.CountBy();
    }
    // [end]
    // [end]

    // [start] CountByTalentid
    // [start] CountByTalentid
    /**
    * 根据 <br />
* TalentID Talentid 人才编号<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2013年01月15日 09:27:01
    *
    * @param Talentid 人才编号
    * @return 数据量
    */
    public static int CountByTalentid(int Talentid)
    {
        return new TalentDAL().CountByTalentid(Talentid);
    }
    // [end]
    // [start] CountByTalentid
    /**
    * 根据 <br />
* TalentID Talentid 人才编号<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2013年01月15日 09:27:01
    *
    * @param Talentid 人才编号
    * @return 数据量
    */
    public static int CountByTalentid(DataProvider dp, int Talentid)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.CountByTalentid(Talentid);
    }
    // [end]
    // [end]
    // [start] GetListByTalentid
    // [start] GetListByTalentid
    /**
    * 根据 <br />
* TalentID Talentid 人才编号<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2013年01月15日 10:31:28
    *
    * @param Talentid 人才编号
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByTalentid(int Talentid)
    {
        return new TalentDAL().GetListByTalentid(Talentid);
    }
    // [end]
    // [start] GetListByTalentid
    /**
    * 根据 <br />
* TalentID Talentid 人才编号<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2013年01月15日 10:31:28
    *
    * @param Talentid 人才编号
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByTalentid(DataProvider dp, int Talentid)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByTalentid(Talentid);
    }
    // [end]
    // [start] GetListByTalentid
    /**
    * 根据 <br />
* TalentID Talentid 人才编号<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2013年01月15日 10:31:28
    *
    * @param Talentid 人才编号
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByTalentid(int Talentid, String OrderBy)
    {
        return new TalentDAL().GetListByTalentid(Talentid, OrderBy);
    }
    // [end]
    // [start] GetListByTalentid
    /**
    * 根据 <br />
* TalentID Talentid 人才编号<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2013年01月15日 10:31:28
    *
    * @param Talentid 人才编号
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByTalentid(DataProvider dp, int Talentid, String OrderBy)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByTalentid(Talentid, OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListByTalentname
    // [start] GetListByTalentname
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 17:53:51
    *
    * @param Talentname 姓名
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByTalentname(String Talentname)
    {
        return new TalentDAL().GetListByTalentname(Talentname);
    }
    // [end]
    // [start] GetListByTalentname
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 17:53:51
    *
    * @param Talentname 姓名
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByTalentname(DataProvider dp, String Talentname)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByTalentname(Talentname);
    }
    // [end]
    // [start] GetListByTalentname
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 17:53:51
    *
    * @param Talentname 姓名
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByTalentname(String Talentname, String OrderBy)
    {
        return new TalentDAL().GetListByTalentname(Talentname, OrderBy);
    }
    // [end]
    // [start] GetListByTalentname
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 17:53:51
    *
    * @param Talentname 姓名
    * @return 数据列表的强类型实体类
    */
    public static TalentInfoCollection GetListByTalentname(DataProvider dp, String Talentname, String OrderBy)
    {
	TalentDAL dal = new TalentDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByTalentname(Talentname, OrderBy);
    }
    // [end]
    // [end]

    // [end]


}