
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:27:07
   功能说明: 表t_system_sector 部门表的实体类SystemSectorInfo的数据层基类
   表说明:部门表
======================================================================*/
package com.yun.sqlserverdal.culture.base;

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
public class SystemSectorDALBase
{
	// [start] 属性
	private String connectionString = null;
	private String dbUserName = null;
	private String dbPassWord = null;

	private String connectionStringUpdate = null;
	private String dbUserNameUpdate = null;
	private String dbPassWordUpdate = null;

	private DataProvider _dp;

	/**
	 *  数据库操作类
	 */
	public DataProvider getDP()
	{
		if (connectionString == null)
			connectionString = com.yun.configuration.WebConfig.getCultureBysqlserverdal();
		if (dbUserName == null)
			dbUserName = com.yun.configuration.WebConfig.getDbUserNameBysqlserverdal();
		if (dbPassWord == null)
			dbPassWord = com.yun.configuration.WebConfig.getDbPassWordBysqlserverdal();
		if (_dp == null || _dp.getIsDisposed())
			_dp = new DataProvider(connectionString, dbUserName, dbPassWord);
		return _dp;
	}

	public void setDP(DataProvider value)
	{
		_dp = value;
	}

	private DataProvider _dpUpdate;

	/**
	 *  数据库操作类
	 */
	public DataProvider getDPUpdate()
	{
		if (connectionStringUpdate == null)
			connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		if (dbUserNameUpdate == null)
			dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		if (dbPassWordUpdate == null)
			dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();
		if (_dpUpdate == null || _dpUpdate.getIsDisposed())
			_dpUpdate = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return _dpUpdate;
	}

	public void setDPUpdate(DataProvider value)
	{
		_dpUpdate = value;
	}

	// [end]

	// [start] 构造函数
	public SystemSectorDALBase()
	{

	}

	public SystemSectorDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		this.connectionString = connectionString;
		this.dbUserName = DbUserName;
		this.dbPassWord = DbPassWord;

		this.connectionStringUpdate = connectionStringUpdate;
		this.dbUserNameUpdate = DbUserNameUpdate;
		this.dbPassWordUpdate = DbPassWordUpdate;

	}

	// [end]

        // [start] Count
        // [start] CountBySectordatabaseidReturnSQL
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param Sectordatabaseid 部门编号 
        * @return SQL语句 
        */
        public String CountBySectordatabaseidReturnSQL(int Sectordatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_system_sector]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [SectordatabaseID] = ?\n");//-- 部门编号
            getDP().AddNewParameter("Sectordatabaseid",Sectordatabaseid ); // 部门编号
            return sbStr.toString();
        }
        // [end]
        // [start] CountBySectordatabaseid
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param Sectordatabaseid 部门编号 
        * @return 数据量 
        */
        public int CountBySectordatabaseid(int Sectordatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountBySectordatabaseidReturnSQL(Sectordatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_system_sector]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @return 数据量 
        */
        public int CountBy()
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByReturnSQL()).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountBySectoridReturnSQL
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param Sectorid 部门编号 
        * @return SQL语句 
        */
        public String CountBySectoridReturnSQL(int Sectorid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_system_sector]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [SectorID] = ?\n");//-- 部门编号
            getDP().AddNewParameter("Sectorid",Sectorid ); // 部门编号
            return sbStr.toString();
        }
        // [end]
        // [start] CountBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param Sectorid 部门编号 
        * @return 数据量 
        */
        public int CountBySectorid(int Sectorid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountBySectoridReturnSQL(Sectorid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
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
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @return 数据列表的强类型实体类 
        */
        public SystemSectorInfoCollection GetListBy(String OrderBy)
        {
            SystemSectorInfoCollection list = new SystemSectorInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.SystemSectorInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
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
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @return 数据列表的强类型实体类 
        */
        public SystemSectorInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]
        // [start] GetListBySectoridReturnSQL
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
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
            sbStr.append("WHERE\n");
            sbStr.append("	 [SectorID] = ?\n");//-- 部门编号
            getDP().AddNewParameter("Sectorid",Sectorid ); // 部门编号
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
        * 开发者 贾军磊 2012年12月03日 13:27:07
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
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param Sectorid 部门编号 
        * @return 数据列表的强类型实体类 
        */
        public SystemSectorInfoCollection GetListBySectorid(int Sectorid)
        {
            return GetListBySectorid(Sectorid, "");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetSystemSectorInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_system_sector 部门表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_system_sector]\n");
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
                sbStr.append("		[SectordatabaseID] DESC \n");//部门编号
            }
                sbStr.append("		) AS RowIndex,\n");
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
                sbStr.append("		FROM [t_system_sector]\n");
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
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @return 数据列表的强类型实体类 
        */
        public SystemSectorInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            SystemSectorInfoCollection list = new SystemSectorInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.SystemSectorInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
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
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @return 数据列表的强类型实体类 
        */
        public SystemSectorInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @return 数据总量 
        */
        public int GetListPagerBy(String OrderBy)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByReturnSQL( OrderBy, null, 0, 0,true)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]
        // [start] GetSystemSectorInfoBySectoridReturnSQL
        /**
        * 根据 <br />
部门编号,SectorID 获取表t_system_sector 部门表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param Sectorid 部门编号 
        * @return SQL语句 
        */
        public String GetListPagerBySectoridReturnSQL(int Sectorid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_system_sector]\n");
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
                sbStr.append("		[SectordatabaseID] DESC \n");//部门编号
            }
                sbStr.append("		) AS RowIndex,\n");
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
                sbStr.append("		FROM [t_system_sector]\n");
            }

            sbStr.append("WHERE\n");
            sbStr.append("	 [SectorID] = ?\n");//-- 部门编号
            getDP().AddNewParameter("Sectorid",Sectorid ); // 部门编号

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
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param Sectorid 部门编号 
        * @return 数据列表的强类型实体类 
        */
        public SystemSectorInfoCollection GetListPagerBySectorid(int Sectorid, String OrderBy,int pageIndex, int pageSize)
        {
            SystemSectorInfoCollection list = new SystemSectorInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.SystemSectorInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerBySectoridReturnSQL(Sectorid,  OrderBy, columnNames, pageIndex, pageSize,false));
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
        // [start] GetListPagerBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 返回表t_system_sector 部门表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param Sectorid 部门编号 
        * @return 数据列表的强类型实体类 
        */
        public SystemSectorInfoCollection GetListPagerBySectorid(int Sectorid, int pageIndex, int pageSize)
        {
           return GetListPagerBySectorid(Sectorid, "",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBySectorid
        /**
        * 根据 <br />
    * SectorID Sectorid 部门编号<br />
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
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
 统计表t_system_sector 部门表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param Sectorid 部门编号 
        * @return 数据总量 
        */
        public int GetListPagerBySectorid(int Sectorid)
        {
            return GetListPagerBySectorid(Sectorid,  "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetSystemSectorInfoBySectordatabaseidReturnSQL
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 获取表t_system_sector 部门表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param Sectordatabaseid 部门编号 
        * @return SQL语句 
        */
        public String GetListBySectordatabaseidReturnSQL(int Sectordatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.SystemSectorInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_system_sector]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [SectordatabaseID] = ?\n");//-- 部门编号
            getDP().AddNewParameter("Sectordatabaseid",Sectordatabaseid ); // 部门编号
            return sbStr.toString();
        }
        // [end]
        // [start] GetSystemSectorInfoBySectordatabaseid
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 获取表t_system_sector 部门表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param Sectordatabaseid 部门编号 
        * @return SystemSectorInfo对象实体 
        */
        public SystemSectorInfo GetSystemSectorInfoBySectordatabaseid(int Sectordatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListBySectordatabaseidReturnSQL(Sectordatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                SystemSectorInfo objSystemSectorInfo = new SystemSectorInfo(rs);
                getDP().Dispose();
                return objSystemSectorInfo;
            }
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
            }
            getDP().Dispose();
            return null;
        }
        // [end]

        // [end]

        // [start] Insert
        // [start] InsertReturnSQL
        /**
        * 向表t_system_sector 部门表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param objSystemSectorInfo SystemSectorInfo对象 部门表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(SystemSectorInfo objSystemSectorInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_system_sector]\n");
            sbStr.append("(\n");
            sbStr.append("	[SectorID],\n");//-- 部门编号
            sbStr.append("	[SectorName],\n");//-- 部门名称
            sbStr.append("	[Description],\n");//-- 部门描述
            sbStr.append("	[Address],\n");//-- Address
            sbStr.append("	[Phone],\n");//-- Phone
            sbStr.append("	[Is_Use],\n");//-- 启用标志：1-启用、2-未启用
            sbStr.append("	[Is_Del],\n");//-- 是否删除：1-未删除、2-已删除
            sbStr.append("	[DatabaseUnitID],\n");//-- DatabaseUnitID
            sbStr.append("	[sorts]\n");//-- 排序
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 部门编号
            getDPUpdate().AddNewParameter("Sectorid",objSystemSectorInfo.getSectorid()); // 
            sbStr.append("	?,\n");//-- 部门名称
            getDPUpdate().AddNewParameter("Sectorname",objSystemSectorInfo.getSectorname()); // 
            sbStr.append("	?,\n");//-- 部门描述
            getDPUpdate().AddNewParameter("Description",objSystemSectorInfo.getDescription()); // 
            sbStr.append("	?,\n");//-- Address
            getDPUpdate().AddNewParameter("Address",objSystemSectorInfo.getAddress()); // 
            sbStr.append("	?,\n");//-- Phone
            getDPUpdate().AddNewParameter("Phone",objSystemSectorInfo.getPhone()); // 
            sbStr.append("	?,\n");//-- 启用标志：1-启用、2-未启用
            getDPUpdate().AddNewParameter("IsUse",objSystemSectorInfo.getIsUse()); // 
            sbStr.append("	?,\n");//-- 是否删除：1-未删除、2-已删除
            getDPUpdate().AddNewParameter("IsDel",objSystemSectorInfo.getIsDel()); // 
            sbStr.append("	?,\n");//-- DatabaseUnitID
            getDPUpdate().AddNewParameter("Databaseunitid",objSystemSectorInfo.getDatabaseunitid()); // 
            sbStr.append("	?\n");//-- 排序
            getDPUpdate().AddNewParameter("Sorts",objSystemSectorInfo.getSorts()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_system_sector 部门表中插入数据,返回SectordatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param objSystemSectorInfo SystemSectorInfo对象 部门表 
        * @return 字段SystemSectorID 
        */
        public int Insert(SystemSectorInfo objSystemSectorInfo)
        {
            getDPUpdate().ClearParameter();
            int Sectordatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objSystemSectorInfo)));
            objSystemSectorInfo.setSectordatabaseid(Sectordatabaseid);//部门编号  数据类型:int
            getDPUpdate().Dispose();
            return Sectordatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateBySectordatabaseidReturnSQL
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 更新表t_system_sector 部门表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param objSystemSectorInfo SystemSectorInfo对象 部门表 
        * @return SQL语句 
        */
        public String UpdateBySectordatabaseidReturnSQL(SystemSectorInfo objSystemSectorInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_system_sector]\n");
            sbStr.append("SET\n");
            sbStr.append("	[SectorID] = ?,\n");//-- 部门编号
            getDPUpdate().AddNewParameter("Sectorid",objSystemSectorInfo.getSectorid()); // 部门编号
            sbStr.append("	[SectorName] = ?,\n");//-- 部门名称
            getDPUpdate().AddNewParameter("Sectorname",objSystemSectorInfo.getSectorname()); // 部门名称
            sbStr.append("	[Description] = ?,\n");//-- 部门描述
            getDPUpdate().AddNewParameter("Description",objSystemSectorInfo.getDescription()); // 部门描述
            sbStr.append("	[Address] = ?,\n");//-- Address
            getDPUpdate().AddNewParameter("Address",objSystemSectorInfo.getAddress()); // Address
            sbStr.append("	[Phone] = ?,\n");//-- Phone
            getDPUpdate().AddNewParameter("Phone",objSystemSectorInfo.getPhone()); // Phone
            sbStr.append("	[Is_Use] = ?,\n");//-- 启用标志：1-启用、2-未启用
            getDPUpdate().AddNewParameter("IsUse",objSystemSectorInfo.getIsUse()); // 启用标志：1-启用、2-未启用
            sbStr.append("	[Is_Del] = ?,\n");//-- 是否删除：1-未删除、2-已删除
            getDPUpdate().AddNewParameter("IsDel",objSystemSectorInfo.getIsDel()); // 是否删除：1-未删除、2-已删除
            sbStr.append("	[DatabaseUnitID] = ?,\n");//-- DatabaseUnitID
            getDPUpdate().AddNewParameter("Databaseunitid",objSystemSectorInfo.getDatabaseunitid()); // DatabaseUnitID
            sbStr.append("	[sorts] = ?\n");//-- 排序
            getDPUpdate().AddNewParameter("Sorts",objSystemSectorInfo.getSorts()); // 排序
            sbStr.append("WHERE\n");
            sbStr.append("	 [SectordatabaseID] = ?\n");//-- 部门编号
            getDPUpdate().AddNewParameter("Sectordatabaseid",objSystemSectorInfo.getSectordatabaseid() ); // 部门编号
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateBySectordatabaseid
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 更新表t_system_sector 部门表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param objSystemSectorInfo SystemSectorInfo对象 部门表 
        */
        public void UpdateBySectordatabaseid(SystemSectorInfo objSystemSectorInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateBySectordatabaseidReturnSQL(objSystemSectorInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteBySectordatabaseidReturnSQL
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 删除数据表t_system_sector 部门表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param Sectordatabaseid 部门编号 
        * @return SQL语句 
        */
        public String DeleteBySectordatabaseidReturnSQL(int Sectordatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_system_sector]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [SectordatabaseID] = ?\n");//-- 部门编号
            getDPUpdate().AddNewParameter("Sectordatabaseid",Sectordatabaseid ); // 部门编号
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteBySectordatabaseid
        /**
        * 根据 <br />
    * SectordatabaseID Sectordatabaseid 部门编号<br />
 删除数据表t_system_sector 部门表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:07
        * @param Sectordatabaseid 部门编号 
        */
        public void DeleteBySectordatabaseid(int Sectordatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteBySectordatabaseidReturnSQL(Sectordatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
