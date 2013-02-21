/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:31:20
   功能说明: 表t_projectpic 项目图片表的业务类ProjectpicInfo的业务层
   表说明:项目图片表
======================================================================*/
package com.yun.bll.culture;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;
import com.yun.bll.culture.base.*;


/**
 * 表Projectpic项目图片表 的实体ProjectpicInfo的数据操作类
 * @author 贾军磊
 *
 */
public class ProjectpicProvider extends ProjectpicProviderBase
{
	
    // [start] GetListPagerByDatabaseprojectid
    // [start] GetListPagerByDatabaseprojectid
    /**
    * 根据 <br />
* DatabaseProjectID Databaseprojectid 项目编号<br />
返回表t_projectpic 项目图片表的数据列表<br />
    * 开发者 贾军磊 2012年12月22日 17:44:51
    *
    * @param Databaseprojectid 项目编号
    * @return 数据列表的强类型实体类
    */
    public static ProjectpicInfoCollection GetListPagerByDatabaseprojectid(int Databaseprojectid, int pageIndex, int pageSize)
    {
        return new ProjectpicDAL().GetListPagerByDatabaseprojectid(Databaseprojectid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByDatabaseprojectid
    /**
    * 根据 <br />
* DatabaseProjectID Databaseprojectid 项目编号<br />
统计表t_projectpic 项目图片表的数据量<br />
    * 开发者 贾军磊 2012年12月22日 17:44:51
    *
    * @param Databaseprojectid 项目编号
    * @return 数据总量
    */
    public static int GetListPagerByDatabaseprojectid(int Databaseprojectid)
    {
        return new ProjectpicDAL().GetListPagerByDatabaseprojectid(Databaseprojectid);
    }
    // [end]
    // [start] GetListPagerByDatabaseprojectid
    /**
    * 根据 <br />
* DatabaseProjectID Databaseprojectid 项目编号<br />
返回表t_projectpic 项目图片表的数据列表<br />
    * 开发者 贾军磊 2012年12月22日 17:44:51
    *
    * @param Databaseprojectid 项目编号
    * @return 数据列表的强类型实体类
    */
    public static ProjectpicInfoCollection GetListPagerByDatabaseprojectid(int Databaseprojectid,  String OrderBy, int pageIndex, int pageSize)
    {
        return new ProjectpicDAL().GetListPagerByDatabaseprojectid(Databaseprojectid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByDatabaseprojectid
    /**
    * 根据 <br />
* DatabaseProjectID Databaseprojectid 项目编号<br />
统计表t_projectpic 项目图片表的数据量<br />
    * 开发者 贾军磊 2012年12月22日 17:44:51
    *
    * @param Databaseprojectid 项目编号
    * @return 数据总量
    */
    public static int GetListPagerByDatabaseprojectid(int Databaseprojectid, String OrderBy)
    {
        return new ProjectpicDAL().GetListPagerByDatabaseprojectid(Databaseprojectid,  OrderBy);
    }
    // [end]
    // [start] GetListPagerByDatabaseprojectid
    /**
    * 根据 <br />
* DatabaseProjectID Databaseprojectid 项目编号<br />
返回表t_projectpic 项目图片表的数据列表<br />
    * 开发者 贾军磊 2012年12月22日 17:44:51
    *
    * @param Databaseprojectid 项目编号
    * @return 数据列表的强类型实体类
    */
    public static ProjectpicInfoCollection GetListPagerByDatabaseprojectid(DataProvider dp,int Databaseprojectid, int pageIndex, int pageSize)
    {
	ProjectpicDAL dal = new ProjectpicDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByDatabaseprojectid(Databaseprojectid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByDatabaseprojectid
    /**
    * 根据 <br />
* DatabaseProjectID Databaseprojectid 项目编号<br />
统计表t_projectpic 项目图片表的数据量<br />
    * 开发者 贾军磊 2012年12月22日 17:44:51
    *
    * @param Databaseprojectid 项目编号
    * @return 数据总量
    */
    public static int GetListPagerByDatabaseprojectid(DataProvider dp, int Databaseprojectid)
    {
	ProjectpicDAL dal = new ProjectpicDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByDatabaseprojectid(Databaseprojectid);
    }
    // [end]
    // [start] GetListPagerByDatabaseprojectid
    /**
    * 根据 <br />
* DatabaseProjectID Databaseprojectid 项目编号<br />
返回表t_projectpic 项目图片表的数据列表<br />
    * 开发者 贾军磊 2012年12月22日 17:44:51
    *
    * @param Databaseprojectid 项目编号
    * @return 数据列表的强类型实体类
    */
    public static ProjectpicInfoCollection GetListPagerByDatabaseprojectid(DataProvider dp, int Databaseprojectid,  String OrderBy, int pageIndex, int pageSize)
    {
	ProjectpicDAL dal = new ProjectpicDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByDatabaseprojectid(Databaseprojectid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByDatabaseprojectid
    /**
    * 根据 <br />
* DatabaseProjectID Databaseprojectid 项目编号<br />
统计表t_projectpic 项目图片表的数据量<br />
    * 开发者 贾军磊 2012年12月22日 17:44:51
    *
    * @param Databaseprojectid 项目编号
    * @return 数据总量
    */
    public static int GetListPagerByDatabaseprojectid(DataProvider dp, int Databaseprojectid, String OrderBy)
    {
	ProjectpicDAL dal = new ProjectpicDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByDatabaseprojectid(Databaseprojectid,  OrderBy);
    }
    // [end]
    // [end]

}