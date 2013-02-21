/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:30:57
   功能说明: 表t_post 职称表的业务类PostInfo的业务层
   表说明:职称表
======================================================================*/
package com.yun.bll.culture;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;
import com.yun.bll.culture.base.*;


/**
 * 表Post职称表 的实体PostInfo的数据操作类
 * @author 贾军磊
 *
 */
public class PostProvider extends PostProviderBase
{
    // [start] GetListByTitledatabaseid
    // [start] GetListByTitledatabaseid
    /**
    * 根据 <br />
* TitledatabaseID Titledatabaseid TitledatabaseID<br />
返回表t_post 职称表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:48:04
    *
    * @param Titledatabaseid TitledatabaseID
    * @return 数据列表的强类型实体类
    */
    public static PostInfoCollection GetListByTitledatabaseid(int Titledatabaseid)
    {
        return new PostDAL().GetListByTitledatabaseid(Titledatabaseid);
    }
    // [end]
    // [start] GetListByTitledatabaseid
    /**
    * 根据 <br />
* TitledatabaseID Titledatabaseid TitledatabaseID<br />
返回表t_post 职称表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:48:04
    *
    * @param Titledatabaseid TitledatabaseID
    * @return 数据列表的强类型实体类
    */
    public static PostInfoCollection GetListByTitledatabaseid(DataProvider dp, int Titledatabaseid)
    {
	PostDAL dal = new PostDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByTitledatabaseid(Titledatabaseid);
    }
    // [end]
    // [start] GetListByTitledatabaseid
    /**
    * 根据 <br />
* TitledatabaseID Titledatabaseid TitledatabaseID<br />
返回表t_post 职称表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:48:04
    *
    * @param Titledatabaseid TitledatabaseID
    * @return 数据列表的强类型实体类
    */
    public static PostInfoCollection GetListByTitledatabaseid(int Titledatabaseid, String OrderBy)
    {
        return new PostDAL().GetListByTitledatabaseid(Titledatabaseid, OrderBy);
    }
    // [end]
    // [start] GetListByTitledatabaseid
    /**
    * 根据 <br />
* TitledatabaseID Titledatabaseid TitledatabaseID<br />
返回表t_post 职称表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:48:04
    *
    * @param Titledatabaseid TitledatabaseID
    * @return 数据列表的强类型实体类
    */
    public static PostInfoCollection GetListByTitledatabaseid(DataProvider dp, int Titledatabaseid, String OrderBy)
    {
	PostDAL dal = new PostDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByTitledatabaseid(Titledatabaseid, OrderBy);
    }
    // [end]
    // [end]

}