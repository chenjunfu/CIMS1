/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:28:45
   功能说明: 表t_education 学历表的业务类EducationInfo的业务层
   表说明:学历表
======================================================================*/
package com.yun.bll.culture;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;
import com.yun.bll.culture.base.*;


/**
 * 表Education学历表 的实体EducationInfo的数据操作类
 * @author 贾军磊
 *
 */
public class EducationProvider extends EducationProviderBase
{
    // [start] GetListByEducationdatabaseid
    // [start] GetListByEducationdatabaseid
    /**
    * 根据 <br />
* EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
返回表t_education 学历表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:45:11
    *
    * @param Educationdatabaseid EducationdatabaseID
    * @return 数据列表的强类型实体类
    */
    public static EducationInfoCollection GetListByEducationdatabaseid(int Educationdatabaseid)
    {
        return new EducationDAL().GetListByEducationdatabaseid(Educationdatabaseid);
    }
    // [end]
    // [start] GetListByEducationdatabaseid
    /**
    * 根据 <br />
* EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
返回表t_education 学历表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:45:11
    *
    * @param Educationdatabaseid EducationdatabaseID
    * @return 数据列表的强类型实体类
    */
    public static EducationInfoCollection GetListByEducationdatabaseid(DataProvider dp, int Educationdatabaseid)
    {
	EducationDAL dal = new EducationDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByEducationdatabaseid(Educationdatabaseid);
    }
    // [end]
    // [start] GetListByEducationdatabaseid
    /**
    * 根据 <br />
* EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
返回表t_education 学历表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:45:11
    *
    * @param Educationdatabaseid EducationdatabaseID
    * @return 数据列表的强类型实体类
    */
    public static EducationInfoCollection GetListByEducationdatabaseid(int Educationdatabaseid, String OrderBy)
    {
        return new EducationDAL().GetListByEducationdatabaseid(Educationdatabaseid, OrderBy);
    }
    // [end]
    // [start] GetListByEducationdatabaseid
    /**
    * 根据 <br />
* EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
返回表t_education 学历表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:45:11
    *
    * @param Educationdatabaseid EducationdatabaseID
    * @return 数据列表的强类型实体类
    */
    public static EducationInfoCollection GetListByEducationdatabaseid(DataProvider dp, int Educationdatabaseid, String OrderBy)
    {
	EducationDAL dal = new EducationDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByEducationdatabaseid(Educationdatabaseid, OrderBy);
    }
    // [end]
    // [end]

}