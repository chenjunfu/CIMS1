/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:30:34
   功能说明: 表t_nation 民族表的业务类NationInfo的业务层
   表说明:民族表
======================================================================*/
package com.yun.bll.culture;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;
import com.yun.bll.culture.base.*;


/**
 * 表Nation民族表 的实体NationInfo的数据操作类
 * @author 贾军磊
 *
 */
public class NationProvider extends NationProviderBase
{
    // [start] GetListByNationid
    // [start] GetListByNationid
    /**
    * 根据 <br />
* NationID Nationid 民族编号<br />
返回表t_nation 民族表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 11:35:15
    *
    * @param Nationid 民族编号
    * @return 数据列表的强类型实体类
    */
    public static NationInfoCollection GetListByNationid(int Nationid)
    {
        return new NationDAL().GetListByNationid(Nationid);
    }
    // [end]
    // [start] GetListByNationid
    /**
    * 根据 <br />
* NationID Nationid 民族编号<br />
返回表t_nation 民族表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 11:35:15
    *
    * @param Nationid 民族编号
    * @return 数据列表的强类型实体类
    */
    public static NationInfoCollection GetListByNationid(DataProvider dp, int Nationid)
    {
	NationDAL dal = new NationDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByNationid(Nationid);
    }
    // [end]
    // [start] GetListByNationid
    /**
    * 根据 <br />
* NationID Nationid 民族编号<br />
返回表t_nation 民族表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 11:35:15
    *
    * @param Nationid 民族编号
    * @return 数据列表的强类型实体类
    */
    public static NationInfoCollection GetListByNationid(int Nationid, String OrderBy)
    {
        return new NationDAL().GetListByNationid(Nationid, OrderBy);
    }
    // [end]
    // [start] GetListByNationid
    /**
    * 根据 <br />
* NationID Nationid 民族编号<br />
返回表t_nation 民族表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 11:35:15
    *
    * @param Nationid 民族编号
    * @return 数据列表的强类型实体类
    */
    public static NationInfoCollection GetListByNationid(DataProvider dp, int Nationid, String OrderBy)
    {
	NationDAL dal = new NationDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByNationid(Nationid, OrderBy);
    }
    // [end]
    // [end]

}