/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:28:26
   功能说明: 表t_degree 的业务类DegreeInfo的业务层
   表说明:
======================================================================*/
package com.yun.bll.culture;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;
import com.yun.bll.culture.base.*;


/**
 * 表Degree 的实体DegreeInfo的数据操作类
 * @author 贾军磊
 *
 */
public class DegreeProvider extends DegreeProviderBase
{
    // [start] CountByDegreeid
    // [start] CountByDegreeid
    /**
    * 根据 <br />
* DegreeID Degreeid DegreeID<br />
统计表t_degree 的数据量<br />
    * 开发者 贾军磊 2013年01月15日 14:31:51
    *
    * @param Degreeid DegreeID
    * @return 数据量
    */
    public static int CountByDegreeid(int Degreeid)
    {
        return new DegreeDAL().CountByDegreeid(Degreeid);
    }
    // [end]
    // [start] CountByDegreeid
    /**
    * 根据 <br />
* DegreeID Degreeid DegreeID<br />
统计表t_degree 的数据量<br />
    * 开发者 贾军磊 2013年01月15日 14:31:51
    *
    * @param Degreeid DegreeID
    * @return 数据量
    */
    public static int CountByDegreeid(DataProvider dp, int Degreeid)
    {
	DegreeDAL dal = new DegreeDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.CountByDegreeid(Degreeid);
    }
    // [end]
    // [end]

}