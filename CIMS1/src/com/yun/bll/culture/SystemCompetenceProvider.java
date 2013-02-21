/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:32:15
   功能说明: 表t_system_competence 权限表的业务类SystemCompetenceInfo的业务层
   表说明:权限表
======================================================================*/
package com.yun.bll.culture;

import java.util.*;

import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;
import com.yun.bll.culture.base.*;


/**
 * 表SystemCompetence权限表 的实体SystemCompetenceInfo的数据操作类
 * @author 贾军磊
 *
 */
public class SystemCompetenceProvider extends SystemCompetenceProviderBase
{
    // [start] GetListByCompetenceid
    // [start] GetListByCompetenceid
    /**
    * 根据 <br />
* CompetenceID Competenceid 权限编号<br />
返回表t_system_competence 权限表的数据列表<br />
    * 开发者 贾军磊 2012年12月12日 10:23:54
    *
    * @param Competenceid 权限编号
    * @return 数据列表的强类型实体类
    */
    public static SystemCompetenceInfoCollection GetListByCompetenceid(int Competenceid)
    {
        return new SystemCompetenceDAL().GetListByCompetenceid(Competenceid);
    }
    // [end]
    // [start] GetListByCompetenceid
    /**
    * 根据 <br />
* CompetenceID Competenceid 权限编号<br />
返回表t_system_competence 权限表的数据列表<br />
    * 开发者 贾军磊 2012年12月12日 10:23:54
    *
    * @param Competenceid 权限编号
    * @return 数据列表的强类型实体类
    */
    public static SystemCompetenceInfoCollection GetListByCompetenceid(DataProvider dp, int Competenceid)
    {
	SystemCompetenceDAL dal = new SystemCompetenceDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByCompetenceid(Competenceid);
    }
    // [end]
    // [start] GetListByCompetenceid
    /**
    * 根据 <br />
* CompetenceID Competenceid 权限编号<br />
返回表t_system_competence 权限表的数据列表<br />
    * 开发者 贾军磊 2012年12月12日 10:23:54
    *
    * @param Competenceid 权限编号
    * @return 数据列表的强类型实体类
    */
    public static SystemCompetenceInfoCollection GetListByCompetenceid(int Competenceid, String OrderBy)
    {
        return new SystemCompetenceDAL().GetListByCompetenceid(Competenceid, OrderBy);
    }
    // [end]
    // [start] GetListByCompetenceid
    /**
    * 根据 <br />
* CompetenceID Competenceid 权限编号<br />
返回表t_system_competence 权限表的数据列表<br />
    * 开发者 贾军磊 2012年12月12日 10:23:54
    *
    * @param Competenceid 权限编号
    * @return 数据列表的强类型实体类
    */
    public static SystemCompetenceInfoCollection GetListByCompetenceid(DataProvider dp, int Competenceid, String OrderBy)
    {
	SystemCompetenceDAL dal = new SystemCompetenceDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByCompetenceid(Competenceid, OrderBy);
    }

    // [end]
    // [end]

    
    private static SystemCompetenceInfoCollection systemcompetenceforenterprise=null;
    private static SystemCompetenceInfoCollection systemcompetenceforproject=null;
    private static SystemCompetenceInfoCollection systemcompetencefortalent=null;
    private static SystemCompetenceInfoCollection systemcompetenceforbaseinfo=null;
    private static SystemCompetenceInfoCollection systemcompetenceforsystem=null;
    static{
    	
    	systemcompetenceforenterprise=SystemCompetenceProvider.GetListByCompetenceid(1);
    	systemcompetenceforproject=SystemCompetenceProvider.GetListByCompetenceid(2);
    	systemcompetencefortalent=SystemCompetenceProvider.GetListByCompetenceid(3);
    	systemcompetenceforbaseinfo=SystemCompetenceProvider.GetListByCompetenceid(4);
    	systemcompetenceforsystem=SystemCompetenceProvider.GetListByCompetenceid(5);
    }
    public static SystemCompetenceInfoCollection getSystemcompetenceforenterprise() {
		return systemcompetenceforenterprise;
	}
	public static void setSystemcompetenceforenterprise(
			SystemCompetenceInfoCollection systemcompetenceforenterprise) {
		SystemCompetenceProvider.systemcompetenceforenterprise = systemcompetenceforenterprise;
	}
	public static SystemCompetenceInfoCollection getSystemcompetenceforproject() {
		return systemcompetenceforproject;
	}
	public static void setSystemcompetenceforproject(
			SystemCompetenceInfoCollection systemcompetenceforproject) {
		SystemCompetenceProvider.systemcompetenceforproject = systemcompetenceforproject;
	}
	public static SystemCompetenceInfoCollection getSystemcompetencefortalent() {
		return systemcompetencefortalent;
	}
	public static void setSystemcompetencefortalent(
			SystemCompetenceInfoCollection systemcompetencefortalent) {
		SystemCompetenceProvider.systemcompetencefortalent = systemcompetencefortalent;
	}
	public static SystemCompetenceInfoCollection getSystemcompetenceforbaseinfo() {
		return systemcompetenceforbaseinfo;
	}
	public static void setSystemcompetenceforbaseinfo(
			SystemCompetenceInfoCollection systemcompetenceforbaseinfo) {
		SystemCompetenceProvider.systemcompetenceforbaseinfo = systemcompetenceforbaseinfo;
	}
	public static SystemCompetenceInfoCollection getSystemcompetenceforsystem() {
		return systemcompetenceforsystem;
	}
	public static void setSystemcompetenceforsystem(
			SystemCompetenceInfoCollection systemcompetenceforsystem) {
		SystemCompetenceProvider.systemcompetenceforsystem = systemcompetenceforsystem;
	}

    
 
   
	
}