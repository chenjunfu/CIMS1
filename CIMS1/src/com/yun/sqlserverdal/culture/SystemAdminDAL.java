
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 14:25:07
   功能说明: 表t_system_admin 系统人员表的实体类SystemAdminInfo的数据层基类
   表说明:系统人员表
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
 * 表 t_system_admin 系统人员表 的实体SystemAdminInfo的数据操作类
 * @author 贾军磊
 *
 */
public class SystemAdminDAL extends SystemAdminDALBase
{
  // [start] SystemAdminDAL
	public SystemAdminDAL()
	{
		super();
	}

	public SystemAdminDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
	
    // [start] GetSystemAdminInfoByAdminnameReturnSQL
    /**
    * 根据 <br />
帐号,AdminName 获取表t_system_admin 系统人员表的SQL语句
    * 开发者 贾军磊 2012年12月03日 14:39:31
    * @param Adminname 帐号 
    * @return SQL语句 
    */
    public String GetListPagerByAdminnameReturnSQL(String Adminname, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_system_admin]\n");
        }
        else
        {
            sbStr.append("	DECLARE @PageLowerBound int \n");//获得需要分页的低段数量
            sbStr.append("	DECLARE @PageUpperBound int \n");//获得需要分页的高端数量
            sbStr.append("	SET @PageLowerBound = ? * (?-1)\n");
        getDP().AddNewParameter("@PageSize", pageSize);
        getDP().AddNewParameter("@PageIndex", pageIndex);
            sbStr.append("	SET @PageUpperBound = @PageLowerBound + ?\n");
        getDP().AddNewParameter("@PageSize", pageSize);
            sbStr.append("	SELECT * FROM (\n");
            sbStr.append("		SELECT TOP (@PageUpperBound)\n");
            sbStr.append("		ROW_NUMBER() OVER (\n");
        if (OrderBy.trim().length() > 0)
        {
        sbStr.append("	ORDER BY\n");
        sbStr.append(OrderBy);
        sbStr.append("\n");
        }
        else
        {
            sbStr.append("		ORDER BY\n");
            sbStr.append("		[DatabaseAdminID] DESC \n");//人员ID
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.SystemAdminInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_system_admin]\n");
        }

        boolean isWhere = true;

        //帐号
        if (Adminname != null && Adminname.length() > 0)
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
        sbStr.append("	 [AdminName] = ?\n");//-- 帐号
        getDP().AddNewParameter("Adminname",Adminname ); // 帐号
        }

        if (!isCount)
        {

            sbStr.append("		) AS Pager\n");
            sbStr.append("	WHERE\n");
            sbStr.append("	Pager.RowIndex > @PageLowerBound\n");
            sbStr.append("	and Pager.RowIndex <= @PageUpperBound\n");
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListPagerByAdminname
    /**
    * 根据 <br />
* AdminName Adminname 帐号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 14:39:31
    * @param Adminname 帐号 
    * @return 数据列表的强类型实体类 
    */
    public SystemAdminInfoCollection GetListPagerByAdminname(String Adminname, String OrderBy,int pageIndex, int pageSize)
    {
        SystemAdminInfoCollection list = new SystemAdminInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.SystemAdminInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByAdminnameReturnSQL(Adminname,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {	
            list.add(new SystemAdminInfo(rs));
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
    // [start] GetListPagerByAdminname
    /**
    * 根据 <br />
* AdminName Adminname 帐号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 14:39:31
    * @param Adminname 帐号 
    * @return 数据列表的强类型实体类 
    */
    public SystemAdminInfoCollection GetListPagerByAdminname(String Adminname, int pageIndex, int pageSize)
    {
       return GetListPagerByAdminname(Adminname, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByAdminname
    /**
    * 根据 <br />
* AdminName Adminname 帐号<br />
统计表t_system_admin 系统人员表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 14:39:31
    * @param Adminname 帐号 
    * @return 数据总量 
    */
    public int GetListPagerByAdminname(String Adminname, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByAdminnameReturnSQL(Adminname,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerByAdminname
    /**
    * 根据 <br />
* AdminName Adminname 帐号<br />
统计表t_system_admin 系统人员表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 14:39:31
    * @param Adminname 帐号 
    * @return 数据总量 
    */
    public int GetListPagerByAdminname(String Adminname)
    {
        return GetListPagerByAdminname(Adminname,  "");
    }
    // [end]
    // [start] GetSystemAdminInfoBySectoridReturnSQL
    /**
    * 根据 <br />
部门编号,SectorID 获取表t_system_admin 系统人员表的SQL语句
    * 开发者 贾军磊 2012年12月03日 14:48:21
    * @param Sectorid 部门编号 
    * @return SQL语句 
    */
    public String GetListPagerBySectoridReturnSQL(int Sectorid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_system_admin]\n");
        }
        else
        {
            sbStr.append("	DECLARE @PageLowerBound int \n");//获得需要分页的低段数量
            sbStr.append("	DECLARE @PageUpperBound int \n");//获得需要分页的高端数量
            sbStr.append("	SET @PageLowerBound = ? * (?-1)\n");
        getDP().AddNewParameter("@PageSize", pageSize);
        getDP().AddNewParameter("@PageIndex", pageIndex);
            sbStr.append("	SET @PageUpperBound = @PageLowerBound + ?\n");
        getDP().AddNewParameter("@PageSize", pageSize);
            sbStr.append("	SELECT * FROM (\n");
            sbStr.append("		SELECT TOP (@PageUpperBound)\n");
            sbStr.append("		ROW_NUMBER() OVER (\n");
        if (OrderBy.trim().length() > 0)
        {
        sbStr.append("	ORDER BY\n");
        sbStr.append(OrderBy);
        sbStr.append("\n");
        }
        else
        {
            sbStr.append("		ORDER BY\n");
            sbStr.append("		[DatabaseAdminID] DESC \n");//人员ID
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.SystemAdminInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_system_admin]\n");
        }

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

        if (!isCount)
        {

            sbStr.append("		) AS Pager\n");
            sbStr.append("	WHERE\n");
            sbStr.append("	Pager.RowIndex > @PageLowerBound\n");
            sbStr.append("	and Pager.RowIndex <= @PageUpperBound\n");
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListPagerBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 14:48:21
    * @param Sectorid 部门编号 
    * @return 数据列表的强类型实体类 
    */
    public SystemAdminInfoCollection GetListPagerBySectorid(int Sectorid, String OrderBy,int pageIndex, int pageSize)
    {
        SystemAdminInfoCollection list = new SystemAdminInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.SystemAdminInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerBySectoridReturnSQL(Sectorid,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new SystemAdminInfo(rs));
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
    // [start] GetListPagerBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 14:48:21
    * @param Sectorid 部门编号 
    * @return 数据列表的强类型实体类 
    */
    public SystemAdminInfoCollection GetListPagerBySectorid(int Sectorid, int pageIndex, int pageSize)
    {
       return GetListPagerBySectorid(Sectorid, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
统计表t_system_admin 系统人员表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 14:48:21
    * @param Sectorid 部门编号 
    * @return 数据总量 
    */
    public int GetListPagerBySectorid(int Sectorid, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerBySectoridReturnSQL(Sectorid,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerBySectorid
    /**
    * 根据 <br />
* SectorID Sectorid 部门编号<br />
统计表t_system_admin 系统人员表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 14:48:21
    * @param Sectorid 部门编号 
    * @return 数据总量 
    */
    public int GetListPagerBySectorid(int Sectorid)
    {
        return GetListPagerBySectorid(Sectorid,  "");
    }
    // [end]
    
    // [start] GetListByRolesidReturnSQL
    /**
    * 根据 <br />
* RolesID Rolesid 角色编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 14:59:34
    * @param Rolesid 角色编号 
    * @return SQL语句 
    */
    public String GetListByRolesidReturnSQL(int Rolesid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.SystemAdminInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_system_admin]\n");
        boolean isWhere = true;

        //角色编号
        if (Rolesid != 0)
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
        sbStr.append("	 [RolesID] = ?\n");//-- 角色编号
        getDP().AddNewParameter("Rolesid",Rolesid ); // 角色编号
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
        sbStr.append("		[DatabaseAdminID] DESC \n");//人员ID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByRolesid
    /**
    * 根据 <br />
* RolesID Rolesid 角色编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 14:59:34
    * @param Rolesid 角色编号 
    * @return 数据列表的强类型实体类 
    */
    public SystemAdminInfoCollection GetListByRolesid(int Rolesid, String OrderBy)
    {
        SystemAdminInfoCollection list = new SystemAdminInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.SystemAdminInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByRolesidReturnSQL(Rolesid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new SystemAdminInfo(rs));
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
    // [start] GetListByRolesid
    /**
    * 根据 <br />
* RolesID Rolesid 角色编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 14:59:34
    * @param Rolesid 角色编号 
    * @return 数据列表的强类型实体类 
    */
    public SystemAdminInfoCollection GetListByRolesid(int Rolesid)
    {
        return GetListByRolesid(Rolesid, "");
    }
    // [end]

  // [end]
    
    // [start] GetListByAdminidReturnSQL
    /**
    * 根据 <br />
* AdminID Adminid 人员编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2013年01月31日 17:43:25
    * @param Adminid 人员编号 
    * @return SQL语句 
    */
    public String GetListByAdminidReturnSQL(int Adminid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.SystemAdminInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_system_admin]\n");
        boolean isWhere = true;

        //人员编号
        if (Adminid != 0)
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
        sbStr.append("	 [AdminID] = ?\n");//-- 人员编号
        getDP().AddNewParameter("Adminid",Adminid ); // 人员编号
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
        sbStr.append("		[DatabaseAdminID] DESC \n");//人员ID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByAdminid
    /**
    * 根据 <br />
* AdminID Adminid 人员编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2013年01月31日 17:43:25
    * @param Adminid 人员编号 
    * @return 数据列表的强类型实体类 
    */
    public SystemAdminInfoCollection GetListByAdminid(int Adminid, String OrderBy)
    {
        SystemAdminInfoCollection list = new SystemAdminInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.SystemAdminInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByAdminidReturnSQL(Adminid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new SystemAdminInfo(rs));
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
    // [start] GetListByAdminid
    /**
    * 根据 <br />
* AdminID Adminid 人员编号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2013年01月31日 17:43:25
    * @param Adminid 人员编号 
    * @return 数据列表的强类型实体类 
    */
    public SystemAdminInfoCollection GetListByAdminid(int Adminid)
    {
        return GetListByAdminid(Adminid, "");
    }
    // [end]
    // [start] GetListByWorknoReturnSQL
    /**
    * 根据 <br />
* WorkNO Workno 工号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2013年01月31日 18:22:48
    * @param Workno 工号 
    * @return SQL语句 
    */
    public String GetListByWorknoReturnSQL(String Workno, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.SystemAdminInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_system_admin]\n");
        boolean isWhere = true;

        //工号
        if (Workno != null && Workno.length() > 0)
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
	        sbStr.append("	 [WorkNO] = ?\n");//-- 工号
	        getDP().AddNewParameter("Workno",Workno ); // 工号
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
	        sbStr.append("		[DatabaseAdminID] DESC \n");//人员ID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByWorkno
    /**
    * 根据 <br />
* WorkNO Workno 工号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2013年01月31日 18:22:48
    * @param Workno 工号 
    * @return 数据列表的强类型实体类 
    */
    public SystemAdminInfoCollection GetListByWorkno(String Workno, String OrderBy)
    {
        SystemAdminInfoCollection list = new SystemAdminInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.SystemAdminInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByWorknoReturnSQL(Workno, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new SystemAdminInfo(rs));
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
    // [start] GetListByWorkno
    /**
    * 根据 <br />
* WorkNO Workno 工号<br />
返回表t_system_admin 系统人员表的数据列表<br />
    * 开发者 贾军磊 2013年01月31日 18:22:48
    * @param Workno 工号 
    * @return 数据列表的强类型实体类 
    */
    public SystemAdminInfoCollection GetListByWorkno(String Workno)
    {
        return GetListByWorkno(Workno, "");
    }
    // [end]


}