
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:27:08
   功能说明: 表t_system_sector 部门表的实体类SystemSectorInfo的数据层基类
   表说明:部门表
======================================================================*/
package com.yun.sqlserverdal.culture;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.base.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


/**
 * 表 t_system_sector 部门表 的实体SystemSectorInfo的数据操作类
 * @author 贾军磊
 *
 */
public class SystemSectorDAL extends SystemSectorDALBase
{
  // [start] SystemSectorDAL
	public SystemSectorDAL()
	{
		super();
	}

	public SystemSectorDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]
	
    // [start] GetListBySectoridReturnSQL
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
返回表t_system_sector 部门表的数据列表<br />
    * 开发者 贾军磊 2013年02月01日 11:19:36
    * @param Sectorid 部门编号 
    * @return SQL语句 
    */
    public String GetListBySectoridReturnSQL(int Sectorid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.SystemSectorInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_system_sector]\n");
        boolean isWhere = true;

        //部门编号
        if (Sectorid != 0)
        {
            if (isWhere)
            {
                sbStr.append("		WHERE\n");
                isWhere = false;
            }
            else
            {
                sbStr.append("		 AND ");
            }
        sbStr.append("	 [SectorID] = ?\n");//-- 部门编号
        getDP().AddNewParameter("Sectorid",Sectorid ); // 部门编号
        }
        if (OrderBy.trim().length() > 0)
        {
        sbStr.append("	ORDER BY\n");
        sbStr.append(OrderBy);
        sbStr.append("\n");
        }
        else
        {
        sbStr.append("	ORDER BY\n");
        sbStr.append("		[SectordatabaseID] DESC \n");//部门编号
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
返回表t_system_sector 部门表的数据列表<br />
    * 开发者 贾军磊 2013年02月01日 11:19:36
    * @param Sectorid 部门编号 
    * @return 数据列表的强类型实体类 
    */
    public SystemSectorInfoCollection GetListBySectorid(int Sectorid, String OrderBy)
    {
        SystemSectorInfoCollection list = new SystemSectorInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.SystemSectorInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListBySectoridReturnSQL(Sectorid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new SystemSectorInfo(rs));
        }
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
        }
        getDP().Dispose();
        return list;
    }
    // [end]
    // [start] GetListBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
返回表t_system_sector 部门表的数据列表<br />
    * 开发者 贾军磊 2013年02月01日 11:19:36
    * @param Sectorid 部门编号 
    * @return 数据列表的强类型实体类 
    */
    public SystemSectorInfoCollection GetListBySectorid(int Sectorid)
    {
        return GetListBySectorid(Sectorid, "");
    }
    // [end]


}