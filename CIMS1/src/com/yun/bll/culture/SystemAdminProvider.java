/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:43:32
   功能说明: 表t_system_admin 系统人员表的业务类SystemAdminInfo的业务层
   表说明:系统人员表
======================================================================*/
package com.yun.bll.culture;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;
import com.yun.bll.culture.base.*;


/**
 * 表SystemAdmin系统人员表 的实体SystemAdminInfo的数据操作类
 * @author 贾军磊
 *
 */
public class SystemAdminProvider extends SystemAdminProviderBase
{
    // [start] GetListPagerByAdminname
    // [start] GetListPagerByAdminname
    /**
    * 根据 <br />
* AdminName Adminname 帐号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 14:40:14
    *
    * @param Adminname 帐号
    * @return 数据列表的强类型实体类
    */
	private static String SystemTree;
	private static int m = 0;
    public static SystemAdminInfoCollection GetListPagerByAdminname(String Adminname, int pageIndex, int pageSize)
    {
        return new SystemAdminDAL().GetListPagerByAdminname(Adminname,  pageIndex, pageSize);
    }
    
    /*     */   public static String getSystemTree(String target)
    /*     */   {
    /* 107 */     SystemTree = null; m = 0;
    /* 108 */     if (SystemTree == null) {
    /* 109 */       StringBuilder sbStr = new StringBuilder(1024);
    /* 110 */       //sbStr.append("Tree[0]  = \"1|0|郑州市文化管理单位|\";\n");
    /* 111 */       SystemSectorInfoCollection SystemSectorInfoCollection = SystemSectorProvider.GetListPagerBy("SectorID", 1, 100);
    /* 112 */       if (SystemSectorInfoCollection.size() > 0) {
    /* 113 */         int i = 1;
    /* 114 */         for (SystemSectorInfo objSystemSector : SystemSectorInfoCollection) {
    /* 115 */           sbStr.append("Tree[" + i + "]  = \"00" + objSystemSector.getSectordatabaseid() + "|0|" + objSystemSector.getSectorname() + "|javascript:ItemCommandEditSector(" + objSystemSector.getSectordatabaseid() + ");|javascript:delSector(" + objSystemSector.getSectordatabaseid() + ");\";\n");
    /* 116 */           if (m == 0)
    /* 117 */             getSystemTree(sbStr, SystemSectorInfoCollection, objSystemSector, SystemSectorInfoCollection.size(),target);
    /*     */           else {
    /* 119 */             getSystemTree(sbStr, SystemSectorInfoCollection, objSystemSector, m,target);
    /*     */           }
    /* 121 */           i++;
    /*     */         }
    /*     */       }
    /* 124 */       SystemTree = sbStr.toString();
    /*     */     }
    /* 126 */     return SystemTree;
    /*     */   }
    /*     */ 
    			//获得用户
    			public static void getSystemTree(StringBuilder sbStr, SystemSectorInfoCollection SystemSectorInfoCollection, SystemSectorInfo objSystemSectorInfo, int i,String target) {
    	/* 130 */     SystemAdminInfoCollection SystemAdminInfoCollection = GetListPagerBySectorid(objSystemSectorInfo.getSectordatabaseid(), 1, 100);
    	/* 131 */     int j = i + 1;
    	/* 132 */     if (SystemAdminInfoCollection.size() > 0)
    	/* 133 */       for (SystemAdminInfo objSystemAdminInfo : SystemAdminInfoCollection) {
    						if(objSystemAdminInfo.getIsUse()==1||target.equals("personnel"))
    						{
    		/* 134 */         sbStr.append("Tree[" + j + "]  = \"200" + objSystemAdminInfo.getDatabaseadminid() + "|00" + objSystemSectorInfo.getSectordatabaseid() + "|" + objSystemAdminInfo.getTruename() + "|javascript:ItemCommandEditAdmin(" + objSystemAdminInfo.getDatabaseadminid() + ");|javascript:delAdmin(" + objSystemAdminInfo.getDatabaseadminid() + ");\";\n");
    		/* 135 */         m = j;
    		/* 136 */         j++;
    						}
    	/*     */       }
    	/*     */   }
    // [end]
    // [start] GetListPagerByAdminname
    /**
    * 根据 <br />
* AdminName Adminname 帐号<br />
统计表t_system_admin 系统人员表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 14:40:14
    *
    * @param Adminname 帐号
    * @return 数据总量
    */
    public static int GetListPagerByAdminname(String Adminname)
    {
        return new SystemAdminDAL().GetListPagerByAdminname(Adminname);
    }
    // [end]
    // [start] GetListPagerByAdminname
    /**
    * 根据 <br />
* AdminName Adminname 帐号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 14:40:14
    *
    * @param Adminname 帐号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListPagerByAdminname(String Adminname,  String OrderBy, int pageIndex, int pageSize)
    {
        return new SystemAdminDAL().GetListPagerByAdminname(Adminname,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByAdminname
    /**
    * 根据 <br />
* AdminName Adminname 帐号<br />
统计表t_system_admin 系统人员表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 14:40:14
    *
    * @param Adminname 帐号
    * @return 数据总量
    */
    public static int GetListPagerByAdminname(String Adminname, String OrderBy)
    {
        return new SystemAdminDAL().GetListPagerByAdminname(Adminname,  OrderBy);
    }
    // [end]
    // [start] GetListPagerByAdminname
    /**
    * 根据 <br />
* AdminName Adminname 帐号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 14:40:14
    *
    * @param Adminname 帐号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListPagerByAdminname(DataProvider dp,String Adminname, int pageIndex, int pageSize)
    {
	SystemAdminDAL dal = new SystemAdminDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByAdminname(Adminname,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByAdminname
    /**
    * 根据 <br />
* AdminName Adminname 帐号<br />
统计表t_system_admin 系统人员表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 14:40:14
    *
    * @param Adminname 帐号
    * @return 数据总量
    */
    public static int GetListPagerByAdminname(DataProvider dp, String Adminname)
    {
	SystemAdminDAL dal = new SystemAdminDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByAdminname(Adminname);
    }
    // [end]
    // [start] GetListPagerByAdminname
    /**
    * 根据 <br />
* AdminName Adminname 帐号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 14:40:14
    *
    * @param Adminname 帐号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListPagerByAdminname(DataProvider dp, String Adminname,  String OrderBy, int pageIndex, int pageSize)
    {
	SystemAdminDAL dal = new SystemAdminDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByAdminname(Adminname,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerByAdminname
    /**
    * 根据 <br />
* AdminName Adminname 帐号<br />
统计表t_system_admin 系统人员表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 14:40:14
    *
    * @param Adminname 帐号
    * @return 数据总量
    */
    public static int GetListPagerByAdminname(DataProvider dp, String Adminname, String OrderBy)
    {
	SystemAdminDAL dal = new SystemAdminDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerByAdminname(Adminname,  OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListPagerBySectorid
    // [start] GetListPagerBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 14:49:04
    *
    * @param Sectorid 部门编号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListPagerBySectorid(int Sectorid, int pageIndex, int pageSize)
    {
        return new SystemAdminDAL().GetListPagerBySectorid(Sectorid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
统计表t_system_admin 系统人员表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 14:49:04
    *
    * @param Sectorid 部门编号
    * @return 数据总量
    */
    public static int GetListPagerBySectorid(int Sectorid)
    {
        return new SystemAdminDAL().GetListPagerBySectorid(Sectorid);
    }
    // [end]
    // [start] GetListPagerBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 14:49:04
    *
    * @param Sectorid 部门编号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListPagerBySectorid(int Sectorid,  String OrderBy, int pageIndex, int pageSize)
    {
        return new SystemAdminDAL().GetListPagerBySectorid(Sectorid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
统计表t_system_admin 系统人员表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 14:49:04
    *
    * @param Sectorid 部门编号
    * @return 数据总量
    */
    public static int GetListPagerBySectorid(int Sectorid, String OrderBy)
    {
        return new SystemAdminDAL().GetListPagerBySectorid(Sectorid,  OrderBy);
    }
    // [end]
    // [start] GetListPagerBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 14:49:04
    *
    * @param Sectorid 部门编号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListPagerBySectorid(DataProvider dp,int Sectorid, int pageIndex, int pageSize)
    {
	SystemAdminDAL dal = new SystemAdminDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerBySectorid(Sectorid,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
统计表t_system_admin 系统人员表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 14:49:04
    *
    * @param Sectorid 部门编号
    * @return 数据总量
    */
    public static int GetListPagerBySectorid(DataProvider dp, int Sectorid)
    {
	SystemAdminDAL dal = new SystemAdminDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerBySectorid(Sectorid);
    }
    // [end]
    // [start] GetListPagerBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 14:49:04
    *
    * @param Sectorid 部门编号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListPagerBySectorid(DataProvider dp, int Sectorid,  String OrderBy, int pageIndex, int pageSize)
    {
	SystemAdminDAL dal = new SystemAdminDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListPagerBySectorid(Sectorid,  OrderBy,  pageIndex, pageSize);
    }
    // [end]
    // [start] GetListPagerBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
统计表t_system_admin 系统人员表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 14:49:04
    *
    * @param Sectorid 部门编号
    * @return 数据总量
    */
    public static int GetListPagerBySectorid(DataProvider dp, int Sectorid, String OrderBy)
    {
	SystemAdminDAL dal = new SystemAdminDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
    return dal.GetListPagerBySectorid(Sectorid,  OrderBy);
    }
    // [end]
    // [start] GetListByRolesid
    // [start] GetListByRolesid
    /**
    * 根据 <br />
* RolesID Rolesid 角色编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 15:01:01
    *
    * @param Rolesid 角色编号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListByRolesid(int Rolesid)
    {
        return new SystemAdminDAL().GetListByRolesid(Rolesid);
    }
    // [end]
    // [start] GetListByRolesid
    /**
    * 根据 <br />
* RolesID Rolesid 角色编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 15:01:01
    *
    * @param Rolesid 角色编号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListByRolesid(DataProvider dp, int Rolesid)
    {
	SystemAdminDAL dal = new SystemAdminDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByRolesid(Rolesid);
    }
    // [end]
    // [start] GetListByRolesid
    /**
    * 根据 <br />
* RolesID Rolesid 角色编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 15:01:01
    *
    * @param Rolesid 角色编号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListByRolesid(int Rolesid, String OrderBy)
    {
        return new SystemAdminDAL().GetListByRolesid(Rolesid, OrderBy);
    }
    // [end]
    // [start] GetListByRolesid
    /**
    * 根据 <br />
* RolesID Rolesid 角色编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 15:01:01
    *
    * @param Rolesid 角色编号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListByRolesid(DataProvider dp, int Rolesid, String OrderBy)
    {
	SystemAdminDAL dal = new SystemAdminDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByRolesid(Rolesid, OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListByAdminid
    // [start] GetListByAdminid
    /**
    * 根据 <br />
* AdminID Adminid 人员编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2013年01月31日 17:44:49
    *
    * @param Adminid 人员编号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListByAdminid(int Adminid)
    {
        return new SystemAdminDAL().GetListByAdminid(Adminid);
    }
    // [end]
    // [start] GetListByAdminid
    /**
    * 根据 <br />
* AdminID Adminid 人员编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2013年01月31日 17:44:49
    *
    * @param Adminid 人员编号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListByAdminid(DataProvider dp, int Adminid)
    {
	SystemAdminDAL dal = new SystemAdminDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByAdminid(Adminid);
    }
    // [end]
    // [start] GetListByAdminid
    /**
    * 根据 <br />
* AdminID Adminid 人员编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2013年01月31日 17:44:49
    *
    * @param Adminid 人员编号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListByAdminid(int Adminid, String OrderBy)
    {
        return new SystemAdminDAL().GetListByAdminid(Adminid, OrderBy);
    }
    // [end]
    // [start] GetListByAdminid
    /**
    * 根据 <br />
* AdminID Adminid 人员编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2013年01月31日 17:44:49
    *
    * @param Adminid 人员编号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListByAdminid(DataProvider dp, int Adminid, String OrderBy)
    {
	SystemAdminDAL dal = new SystemAdminDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByAdminid(Adminid, OrderBy);
    }
    // [end]
    // [end]
    // [start] GetListByWorkno
    // [start] GetListByWorkno
    /**
    * 根据 <br />
* WorkNO Workno 工号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2013年01月31日 18:23:15
    *
    * @param Workno 工号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListByWorkno(String Workno)
    {
        return new SystemAdminDAL().GetListByWorkno(Workno);
    }
    // [end]
    // [start] GetListByWorkno
    /**
    * 根据 <br />
* WorkNO Workno 工号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2013年01月31日 18:23:15
    *
    * @param Workno 工号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListByWorkno(DataProvider dp, String Workno)
    {
	SystemAdminDAL dal = new SystemAdminDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByWorkno(Workno);
    }
    // [end]
    // [start] GetListByWorkno
    /**
    * 根据 <br />
* WorkNO Workno 工号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2013年01月31日 18:23:15
    *
    * @param Workno 工号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListByWorkno(String Workno, String OrderBy)
    {
        return new SystemAdminDAL().GetListByWorkno(Workno, OrderBy);
    }
    // [end]
    // [start] GetListByWorkno
    /**
    * 根据 <br />
* WorkNO Workno 工号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2013年01月31日 18:23:15
    *
    * @param Workno 工号
    * @return 数据列表的强类型实体类
    */
    public static SystemAdminInfoCollection GetListByWorkno(DataProvider dp, String Workno, String OrderBy)
    {
	SystemAdminDAL dal = new SystemAdminDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListByWorkno(Workno, OrderBy);
    }
    // [end]
    // [end]

    
    // [end]

	
}