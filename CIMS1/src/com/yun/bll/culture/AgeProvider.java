/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:28:13
   功能说明: 表t_age 年龄段表的业务类AgeInfo的业务层
   表说明:年龄段表
======================================================================*/
package com.yun.bll.culture;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;
import com.yun.bll.culture.base.*;


/**
 * 表Age年龄段表 的实体AgeInfo的数据操作类
 * @author 贾军磊
 *
 */
public class AgeProvider extends AgeProviderBase
{
    // [start] GetListByAgedatabaseid
    // [start] GetListByAgedatabaseid
    /**
    * 根据 <br />
* AgedatabaseID Agedatabaseid AgedatabaseID<br />
返回表t_age 年龄段表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:42:45
    *
    * @param Agedatabaseid AgedatabaseID
    * @return 数据列表的强类型实体类
    */
    public static AgeInfoCollection GetListByAgedatabaseid(int Agedatabaseid)
    {
        return new AgeDAL().GetListByAgedatabaseid(Agedatabaseid);
    }
    // [end]
    // [start] GetListByAgedatabaseid
    /**
    * 根据 <br />
* AgedatabaseID Agedatabaseid AgedatabaseID<br />
返回表t_age 年龄段表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:42:45
    *
    * @param Agedatabaseid AgedatabaseID
    * @return 数据列表的强类型实体类
    */
    public static AgeInfoCollection GetListByAgedatabaseid(DataProvider dp, int Agedatabaseid)
    {
	AgeDAL dal = new AgeDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByAgedatabaseid(Agedatabaseid);
    }
    // [end]
    // [start] GetListByAgedatabaseid
    /**
    * 根据 <br />
* AgedatabaseID Agedatabaseid AgedatabaseID<br />
返回表t_age 年龄段表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:42:45
    *
    * @param Agedatabaseid AgedatabaseID
    * @return 数据列表的强类型实体类
    */
    public static AgeInfoCollection GetListByAgedatabaseid(int Agedatabaseid, String OrderBy)
    {
        return new AgeDAL().GetListByAgedatabaseid(Agedatabaseid, OrderBy);
    }
    // [end]
    // [start] GetListByAgedatabaseid
    /**
    * 根据 <br />
* AgedatabaseID Agedatabaseid AgedatabaseID<br />
返回表t_age 年龄段表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:42:45
    *
    * @param Agedatabaseid AgedatabaseID
    * @return 数据列表的强类型实体类
    */
    public static AgeInfoCollection GetListByAgedatabaseid(DataProvider dp, int Agedatabaseid, String OrderBy)
    {
	AgeDAL dal = new AgeDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByAgedatabaseid(Agedatabaseid, OrderBy);
    }
    // [end]
    // [end]

}