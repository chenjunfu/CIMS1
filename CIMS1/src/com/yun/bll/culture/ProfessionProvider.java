/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:31:07
   功能说明: 表t_profession 行业类别表的业务类ProfessionInfo的业务层
   表说明:行业类别表
======================================================================*/
package com.yun.bll.culture;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;
import com.yun.bll.culture.base.*;


/**
 * 表Profession行业类别表 的实体ProfessionInfo的数据操作类
 * @author 贾军磊
 *
 */
public class ProfessionProvider extends ProfessionProviderBase
{
    // [start] GetListByBusinessdatabaseid
    // [start] GetListByBusinessdatabaseid
    /**
    * 根据 <br />
* BusinessdatabaseID Businessdatabaseid 数据库ID<br />
返回表t_profession 行业类别表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:38:36
    *
    * @param Businessdatabaseid 数据库ID
    * @return 数据列表的强类型实体类
    */
    public static ProfessionInfoCollection GetListByBusinessdatabaseid(int Businessdatabaseid)
    {
        return new ProfessionDAL().GetListByBusinessdatabaseid(Businessdatabaseid);
    }
    // [end]
    // [start] GetListByBusinessdatabaseid
    /**
    * 根据 <br />
* BusinessdatabaseID Businessdatabaseid 数据库ID<br />
返回表t_profession 行业类别表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:38:36
    *
    * @param Businessdatabaseid 数据库ID
    * @return 数据列表的强类型实体类
    */
    public static ProfessionInfoCollection GetListByBusinessdatabaseid(DataProvider dp, int Businessdatabaseid)
    {
	ProfessionDAL dal = new ProfessionDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByBusinessdatabaseid(Businessdatabaseid);
    }
    // [end]
    // [start] GetListByBusinessdatabaseid
    /**
    * 根据 <br />
* BusinessdatabaseID Businessdatabaseid 数据库ID<br />
返回表t_profession 行业类别表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:38:36
    *
    * @param Businessdatabaseid 数据库ID
    * @return 数据列表的强类型实体类
    */
    public static ProfessionInfoCollection GetListByBusinessdatabaseid(int Businessdatabaseid, String OrderBy)
    {
        return new ProfessionDAL().GetListByBusinessdatabaseid(Businessdatabaseid, OrderBy);
    }
    // [end]
    // [start] GetListByBusinessdatabaseid
    /**
    * 根据 <br />
* BusinessdatabaseID Businessdatabaseid 数据库ID<br />
返回表t_profession 行业类别表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:38:36
    *
    * @param Businessdatabaseid 数据库ID
    * @return 数据列表的强类型实体类
    */
    public static ProfessionInfoCollection GetListByBusinessdatabaseid(DataProvider dp, int Businessdatabaseid, String OrderBy)
    {
	ProfessionDAL dal = new ProfessionDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByBusinessdatabaseid(Businessdatabaseid, OrderBy);
    }
    // [end]
    // [start] GetListByBusinesstypeid
    // [start] GetListByBusinesstypeid
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 企业所属行业ID<br />
返回表t_profession 行业类别表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 09:45:03
    *
    * @param Businesstypeid 企业所属行业ID
    * @return 数据列表的强类型实体类
    */
    public static ProfessionInfoCollection GetListByBusinesstypeid(int Businesstypeid)
    {
        return new ProfessionDAL().GetListByBusinesstypeid(Businesstypeid);
    }
    // [end]
    // [start] GetListByBusinesstypeid
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 企业所属行业ID<br />
返回表t_profession 行业类别表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 09:45:03
    *
    * @param Businesstypeid 企业所属行业ID
    * @return 数据列表的强类型实体类
    */
    public static ProfessionInfoCollection GetListByBusinesstypeid(DataProvider dp, int Businesstypeid)
    {
	ProfessionDAL dal = new ProfessionDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByBusinesstypeid(Businesstypeid);
    }
    // [end]
    // [start] GetListByBusinesstypeid
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 企业所属行业ID<br />
返回表t_profession 行业类别表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 09:45:03
    *
    * @param Businesstypeid 企业所属行业ID
    * @return 数据列表的强类型实体类
    */
    public static ProfessionInfoCollection GetListByBusinesstypeid(int Businesstypeid, String OrderBy)
    {
        return new ProfessionDAL().GetListByBusinesstypeid(Businesstypeid, OrderBy);
    }
    // [end]
    // [start] GetListByBusinesstypeid
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 企业所属行业ID<br />
返回表t_profession 行业类别表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 09:45:03
    *
    * @param Businesstypeid 企业所属行业ID
    * @return 数据列表的强类型实体类
    */
    public static ProfessionInfoCollection GetListByBusinesstypeid(DataProvider dp, int Businesstypeid, String OrderBy)
    {
	ProfessionDAL dal = new ProfessionDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByBusinesstypeid(Businesstypeid, OrderBy);
    }
    // [end]
    // [end]

    // [end]

}