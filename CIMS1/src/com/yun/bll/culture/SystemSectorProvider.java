/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:32:46
   功能说明: 表t_system_sector 部门表的业务类SystemSectorInfo的业务层
   表说明:部门表
======================================================================*/
package com.yun.bll.culture;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;
import com.yun.bll.culture.base.*;


/**
 * 表SystemSector部门表 的实体SystemSectorInfo的数据操作类
 * @author 贾军磊
 *
 */
public class SystemSectorProvider extends SystemSectorProviderBase
{
	 private static String SystemTree;
	 /* 104 */   private static int m = 0;
	public static String getSystemTree()
	/*     */   {
	/* 107 */     SystemTree = null; m = 0;
	/* 108 */     if (SystemTree == null) {
	/* 109 */       StringBuilder sbStr = new StringBuilder(1024);
	/* 110 */       //sbStr.append("Tree[0]  = \"1|0|郑州市文化管理单位(部门)|\";\n");
	/* 111 */       SystemSectorInfoCollection SystemSectorInfoCollection = SystemSectorProvider.GetListPagerBy("SectorID", 1, 100);
	/* 112 */       if (SystemSectorInfoCollection.size() > 0) {
	/* 113 */         int i = 1;
	/* 114 */         for (SystemSectorInfo objSystemSector : SystemSectorInfoCollection) {
	/* 115 */           sbStr.append("Tree[" + i + "]  = \"00" + objSystemSector.getSectordatabaseid() + "|0|" + objSystemSector.getSectorname() + "|javascript:ItemCommandEditSector(" + objSystemSector.getSectordatabaseid() + ");|javascript:delSector(" + objSystemSector.getSectordatabaseid() + ");\";\n");
	/* 116 */         
	/* 121 */           i++;
	/*     */         }
	/*     */       }
	/* 124 */       SystemTree = sbStr.toString();
	/*     */     }
	/* 126 */     return SystemTree;
	/*     */   }
	
	
    // [start] GetListBySectorid
    // [start] GetListBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
返回表t_system_sector 部门表的数据列表<br />
    * 开发者 贾军磊 2013年02月01日 11:20:52
    *
    * @param Sectorid 部门编号
    * @return 数据列表的强类型实体类
    */
    public static SystemSectorInfoCollection GetListBySectorid(int Sectorid)
    {
        return new SystemSectorDAL().GetListBySectorid(Sectorid);
    }
    // [end]
    // [start] GetListBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
返回表t_system_sector 部门表的数据列表<br />
    * 开发者 贾军磊 2013年02月01日 11:20:52
    *
    * @param Sectorid 部门编号
    * @return 数据列表的强类型实体类
    */
    public static SystemSectorInfoCollection GetListBySectorid(DataProvider dp, int Sectorid)
    {
	SystemSectorDAL dal = new SystemSectorDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListBySectorid(Sectorid);
    }
    // [end]
    // [start] GetListBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
返回表t_system_sector 部门表的数据列表<br />
    * 开发者 贾军磊 2013年02月01日 11:20:52
    *
    * @param Sectorid 部门编号
    * @return 数据列表的强类型实体类
    */
    public static SystemSectorInfoCollection GetListBySectorid(int Sectorid, String OrderBy)
    {
        return new SystemSectorDAL().GetListBySectorid(Sectorid, OrderBy);
    }
    // [end]
    // [start] GetListBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
返回表t_system_sector 部门表的数据列表<br />
    * 开发者 贾军磊 2013年02月01日 11:20:52
    *
    * @param Sectorid 部门编号
    * @return 数据列表的强类型实体类
    */
    public static SystemSectorInfoCollection GetListBySectorid(DataProvider dp, int Sectorid, String OrderBy)
    {
	SystemSectorDAL dal = new SystemSectorDAL();
	dal.setDP(dp);
	dal.setDPUpdate(dp);
        return dal.GetListBySectorid(Sectorid, OrderBy);
    }
    // [end]
    // [end]

}