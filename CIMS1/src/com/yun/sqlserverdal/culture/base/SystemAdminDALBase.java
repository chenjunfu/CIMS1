
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月13日 09:49:50
   功能说明: 表t_system_admin 系统人员表的实体类SystemAdminInfo的数据层基类
   表说明:系统人员表
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
 * 表 t_system_admin 系统人员表 的实体SystemAdminInfo的数据操作类
 * @author 贾军磊
 *
 */
public class SystemAdminDALBase
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
	public SystemAdminDALBase()
	{

	}

	public SystemAdminDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByDatabaseadminidReturnSQL
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param Databaseadminid 人员ID 
        * @return SQL语句 
        */
        public String CountByDatabaseadminidReturnSQL(int Databaseadminid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_system_admin]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseAdminID] = ?\n");//-- 人员ID
            getDP().AddNewParameter("Databaseadminid",Databaseadminid ); // 人员ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByDatabaseadminid
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param Databaseadminid 人员ID 
        * @return 数据量 
        */
        public int CountByDatabaseadminid(int Databaseadminid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDatabaseadminidReturnSQL(Databaseadminid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_system_admin]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
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
        // [start] CountByAdminidReturnSQL
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param Adminid 人员编号 
        * @return SQL语句 
        */
        public String CountByAdminidReturnSQL(int Adminid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_system_admin]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [AdminID] = ?\n");//-- 人员编号
            getDP().AddNewParameter("Adminid",Adminid ); // 人员编号
            return sbStr.toString();
        }
        // [end]
        // [start] CountByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param Adminid 人员编号 
        * @return 数据量 
        */
        public int CountByAdminid(int Adminid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByAdminidReturnSQL(Adminid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
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
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @return 数据列表的强类型实体类 
        */
        public SystemAdminInfoCollection GetListBy(String OrderBy)
        {
            SystemAdminInfoCollection list = new SystemAdminInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.SystemAdminInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
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
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @return 数据列表的强类型实体类 
        */
        public SystemAdminInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]
        // [start] GetListByAdminidReturnSQL
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
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
            sbStr.append("WHERE\n");
            sbStr.append("	 [AdminID] = ?\n");//-- 人员编号
            getDP().AddNewParameter("Adminid",Adminid ); // 人员编号
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
        * 开发者 贾军磊 2012年12月13日 09:49:50
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
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param Adminid 人员编号 
        * @return 数据列表的强类型实体类 
        */
        public SystemAdminInfoCollection GetListByAdminid(int Adminid)
        {
            return GetListByAdminid(Adminid, "");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetSystemAdminInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_system_admin 系统人员表的SQL语句
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
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
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @return 数据列表的强类型实体类 
        */
        public SystemAdminInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            SystemAdminInfoCollection list = new SystemAdminInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.SystemAdminInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
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
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @return 数据列表的强类型实体类 
        */
        public SystemAdminInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
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
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]
        // [start] GetSystemAdminInfoByAdminidReturnSQL
        /**
        * 根据 <br />
人员编号,AdminID 获取表t_system_admin 系统人员表的SQL语句
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param Adminid 人员编号 
        * @return SQL语句 
        */
        public String GetListPagerByAdminidReturnSQL(int Adminid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
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

            sbStr.append("WHERE\n");
            sbStr.append("	 [AdminID] = ?\n");//-- 人员编号
            getDP().AddNewParameter("Adminid",Adminid ); // 人员编号

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
        // [start] GetListPagerByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param Adminid 人员编号 
        * @return 数据列表的强类型实体类 
        */
        public SystemAdminInfoCollection GetListPagerByAdminid(int Adminid, String OrderBy,int pageIndex, int pageSize)
        {
            SystemAdminInfoCollection list = new SystemAdminInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.SystemAdminInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByAdminidReturnSQL(Adminid,  OrderBy, columnNames, pageIndex, pageSize,false));
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
        // [start] GetListPagerByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 返回表t_system_admin 系统人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param Adminid 人员编号 
        * @return 数据列表的强类型实体类 
        */
        public SystemAdminInfoCollection GetListPagerByAdminid(int Adminid, int pageIndex, int pageSize)
        {
           return GetListPagerByAdminid(Adminid, "",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param Adminid 人员编号 
        * @return 数据总量 
        */
        public int GetListPagerByAdminid(int Adminid, String OrderBy)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByAdminidReturnSQL(Adminid,  OrderBy, null, 0, 0,true)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] GetListPagerByAdminid
        /**
        * 根据 <br />
    * AdminID Adminid 人员编号<br />
 统计表t_system_admin 系统人员表的数据量<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param Adminid 人员编号 
        * @return 数据总量 
        */
        public int GetListPagerByAdminid(int Adminid)
        {
            return GetListPagerByAdminid(Adminid,  "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetSystemAdminInfoByDatabaseadminidReturnSQL
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 获取表t_system_admin 系统人员表的对象<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param Databaseadminid 人员ID 
        * @return SQL语句 
        */
        public String GetListByDatabaseadminidReturnSQL(int Databaseadminid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.SystemAdminInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_system_admin]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseAdminID] = ?\n");//-- 人员ID
            getDP().AddNewParameter("Databaseadminid",Databaseadminid ); // 人员ID
            return sbStr.toString();
        }
        // [end]
        // [start] GetSystemAdminInfoByDatabaseadminid
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 获取表t_system_admin 系统人员表的对象<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param Databaseadminid 人员ID 
        * @return SystemAdminInfo对象实体 
        */
        public SystemAdminInfo GetSystemAdminInfoByDatabaseadminid(int Databaseadminid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByDatabaseadminidReturnSQL(Databaseadminid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                SystemAdminInfo objSystemAdminInfo = new SystemAdminInfo(rs);
                getDP().Dispose();
                return objSystemAdminInfo;
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
        * 向表t_system_admin 系统人员表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param objSystemAdminInfo SystemAdminInfo对象 系统人员表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(SystemAdminInfo objSystemAdminInfo)
        {	
        	
        	
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_system_admin]\n");
            sbStr.append("(\n");
            sbStr.append("	[AdminID],\n");//-- 人员编号
            sbStr.append("	[AdminName],\n");//-- 帐号
            sbStr.append("	[AdminPassWord],\n");//-- 密码
            sbStr.append("	[Sex],\n");//-- 性别：1-男、2-女
            sbStr.append("	[TrueName],\n");//-- 姓名
            sbStr.append("	[WorkNO],\n");//-- 工号
            sbStr.append("	[Email],\n");//-- 联系EMAIL
            sbStr.append("	[MovePhone],\n");//-- 移动电话
            sbStr.append("	[Phone],\n");//-- 电话
            sbStr.append("	[MSN],\n");//-- MSN
            sbStr.append("	[RolesID],\n");//-- 角色编号
            sbStr.append("	[SectorID],\n");//-- 部门编号
            sbStr.append("	[Description],\n");//-- 人员描述
            sbStr.append("	[Address],\n");//-- 通讯地址
            sbStr.append("	[Limit_Ip],\n");//-- 限定IP
            sbStr.append("	[Last_LoginTime],\n");//-- 最后登录时间
            sbStr.append("	[Last_LoginIp],\n");//-- 最后登录IP
            sbStr.append("	[Create_Time],\n");//-- 创建时间
            sbStr.append("	[Last_ModifyTime],\n");//-- 最后修改时间
            sbStr.append("	[Is_Use],\n");//-- 启用标志：1-启用、2-未启用
            sbStr.append("	[Is_Del],\n");//-- 是否删除：1-未删除、2-已删除
            sbStr.append("	[Competence]\n");//-- 拥有权限
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 人员编号
            getDPUpdate().AddNewParameter("Adminid",objSystemAdminInfo.getAdminid()); // 
            sbStr.append("	?,\n");//-- 帐号
            getDPUpdate().AddNewParameter("Adminname",objSystemAdminInfo.getAdminname()); // 
            sbStr.append("	?,\n");//-- 密码
            getDPUpdate().AddNewParameter("Adminpassword",objSystemAdminInfo.getAdminpassword()); // 
            sbStr.append("	?,\n");//-- 性别：1-男、2-女
            getDPUpdate().AddNewParameter("Sex",objSystemAdminInfo.getSex()); // 
            sbStr.append("	?,\n");//-- 姓名
            getDPUpdate().AddNewParameter("Truename",objSystemAdminInfo.getTruename()); // 
            sbStr.append("	?,\n");//-- 工号
            getDPUpdate().AddNewParameter("Workno",objSystemAdminInfo.getWorkno()); // 
            sbStr.append("	?,\n");//-- 联系EMAIL
            getDPUpdate().AddNewParameter("Email",objSystemAdminInfo.getEmail()); // 
            
            sbStr.append("	?,\n");//-- 移动电话
            getDPUpdate().AddNewParameter("Movephone",objSystemAdminInfo.getMovephone()); // 
            sbStr.append("	?,\n");//-- 电话
            getDPUpdate().AddNewParameter("Phone",objSystemAdminInfo.getPhone()); // 
            sbStr.append("	?,\n");//-- MSN
            getDPUpdate().AddNewParameter("Msn",objSystemAdminInfo.getMsn()); // 
            sbStr.append("	?,\n");//-- 角色编号
            getDPUpdate().AddNewParameter("Rolesid",objSystemAdminInfo.getRolesid()); // 
            sbStr.append("	?,\n");//-- 部门编号
            getDPUpdate().AddNewParameter("Sectorid",objSystemAdminInfo.getSectorid()); // 
            sbStr.append("	?,\n");//-- 人员描述
            getDPUpdate().AddNewParameter("Description",objSystemAdminInfo.getDescription()); // 
            sbStr.append("	?,\n");//-- 通讯地址
            getDPUpdate().AddNewParameter("Address",objSystemAdminInfo.getAddress()); // 
            sbStr.append("	?,\n");//-- 限定IP
            getDPUpdate().AddNewParameter("LimitIp",objSystemAdminInfo.getLimitIp()); // 
            sbStr.append("	?,\n");//-- 最后登录时间
            getDPUpdate().AddNewParameter("LastLogintime",objSystemAdminInfo.getLastLogintime()); // 
            sbStr.append("	?,\n");//-- 最后登录IP
            getDPUpdate().AddNewParameter("LastLoginip",objSystemAdminInfo.getLastLoginip()); // 
            sbStr.append("	?,\n");//-- 创建时间
            getDPUpdate().AddNewParameter("CreateTime",objSystemAdminInfo.getCreateTime()); // 
            sbStr.append("	?,\n");//-- 最后修改时间
            getDPUpdate().AddNewParameter("LastModifytime",objSystemAdminInfo.getLastModifytime()); // 
            sbStr.append("	?,\n");//-- 启用标志：1-启用、2-未启用
            getDPUpdate().AddNewParameter("IsUse",objSystemAdminInfo.getIsUse()); // 
            sbStr.append("	?,\n");//-- 是否删除：1-未删除、2-已删除
            getDPUpdate().AddNewParameter("IsDel",objSystemAdminInfo.getIsDel()); // 
            sbStr.append("	?\n");//-- 拥有权限
            getDPUpdate().AddNewParameter("Competence",objSystemAdminInfo.getCompetence()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_system_admin 系统人员表中插入数据,返回DatabaseAdminID字段内容<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param objSystemAdminInfo SystemAdminInfo对象 系统人员表 
        * @return 字段SystemAdminID 
        */
        public int Insert(SystemAdminInfo objSystemAdminInfo)
        {
            getDPUpdate().ClearParameter();
            int Databaseadminid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objSystemAdminInfo)));
            objSystemAdminInfo.setDatabaseadminid(Databaseadminid);//人员ID  数据类型:int
            getDPUpdate().Dispose();
            return Databaseadminid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByDatabaseadminidReturnSQL
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 更新表t_system_admin 系统人员表中的内容<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param objSystemAdminInfo SystemAdminInfo对象 系统人员表 
        * @return SQL语句 
        */
        public String UpdateByDatabaseadminidReturnSQL(SystemAdminInfo objSystemAdminInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_system_admin]\n");
            sbStr.append("SET\n");
            sbStr.append("	[AdminID] = ?,\n");//-- 人员编号
            getDPUpdate().AddNewParameter("Adminid",objSystemAdminInfo.getAdminid()); // 人员编号
            sbStr.append("	[AdminName] = ?,\n");//-- 帐号
            getDPUpdate().AddNewParameter("Adminname",objSystemAdminInfo.getAdminname()); // 帐号
            sbStr.append("	[AdminPassWord] = ?,\n");//-- 密码
            getDPUpdate().AddNewParameter("Adminpassword",objSystemAdminInfo.getAdminpassword()); // 密码
            sbStr.append("	[Sex] = ?,\n");//-- 性别：1-男、2-女
            getDPUpdate().AddNewParameter("Sex",objSystemAdminInfo.getSex()); // 性别：1-男、2-女
            sbStr.append("	[TrueName] = ?,\n");//-- 姓名
            getDPUpdate().AddNewParameter("Truename",objSystemAdminInfo.getTruename()); // 姓名
            sbStr.append("	[WorkNO] = ?,\n");//-- 工号
            getDPUpdate().AddNewParameter("Workno",objSystemAdminInfo.getWorkno()); // 工号
            sbStr.append("	[Email] = ?,\n");//-- 联系EMAIL
            getDPUpdate().AddNewParameter("Email",objSystemAdminInfo.getEmail()); // 联系EMAIL
            sbStr.append("	[MovePhone] = ?,\n");//-- 移动电话
            getDPUpdate().AddNewParameter("Movephone",objSystemAdminInfo.getMovephone()); // 移动电话
            sbStr.append("	[Phone] = ?,\n");//-- 电话
            getDPUpdate().AddNewParameter("Phone",objSystemAdminInfo.getPhone()); // 电话
            sbStr.append("	[MSN] = ?,\n");//-- MSN
            getDPUpdate().AddNewParameter("Msn",objSystemAdminInfo.getMsn()); // MSN
            sbStr.append("	[RolesID] = ?,\n");//-- 角色编号
            getDPUpdate().AddNewParameter("Rolesid",objSystemAdminInfo.getRolesid()); // 角色编号
            sbStr.append("	[SectorID] = ?,\n");//-- 部门编号
            getDPUpdate().AddNewParameter("Sectorid",objSystemAdminInfo.getSectorid()); // 部门编号
            sbStr.append("	[Description] = ?,\n");//-- 人员描述
            getDPUpdate().AddNewParameter("Description",objSystemAdminInfo.getDescription()); // 人员描述
            sbStr.append("	[Address] = ?,\n");//-- 通讯地址
            getDPUpdate().AddNewParameter("Address",objSystemAdminInfo.getAddress()); // 通讯地址
            sbStr.append("	[Limit_Ip] = ?,\n");//-- 限定IP
            getDPUpdate().AddNewParameter("LimitIp",objSystemAdminInfo.getLimitIp()); // 限定IP
            sbStr.append("	[Last_LoginTime] = ?,\n");//-- 最后登录时间
            getDPUpdate().AddNewParameter("LastLogintime",objSystemAdminInfo.getLastLogintime()); // 最后登录时间
            sbStr.append("	[Last_LoginIp] = ?,\n");//-- 最后登录IP
            getDPUpdate().AddNewParameter("LastLoginip",objSystemAdminInfo.getLastLoginip()); // 最后登录IP
            sbStr.append("	[Create_Time] = ?,\n");//-- 创建时间
            getDPUpdate().AddNewParameter("CreateTime",objSystemAdminInfo.getCreateTime()); // 创建时间
            sbStr.append("	[Last_ModifyTime] = ?,\n");//-- 最后修改时间
            getDPUpdate().AddNewParameter("LastModifytime",objSystemAdminInfo.getLastModifytime()); // 最后修改时间
            sbStr.append("	[Is_Use] = ?,\n");//-- 启用标志：1-启用、2-未启用
            getDPUpdate().AddNewParameter("IsUse",objSystemAdminInfo.getIsUse()); // 启用标志：1-启用、2-未启用
            sbStr.append("	[Is_Del] = ?,\n");//-- 是否删除：1-未删除、2-已删除
            getDPUpdate().AddNewParameter("IsDel",objSystemAdminInfo.getIsDel()); // 是否删除：1-未删除、2-已删除
            sbStr.append("	[Competence] = ?\n");//-- 拥有权限
            getDPUpdate().AddNewParameter("Competence",objSystemAdminInfo.getCompetence()); // 拥有权限
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseAdminID] = ?\n");//-- 人员ID
            getDPUpdate().AddNewParameter("Databaseadminid",objSystemAdminInfo.getDatabaseadminid() ); // 人员ID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByDatabaseadminid
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 更新表t_system_admin 系统人员表中的内容<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param objSystemAdminInfo SystemAdminInfo对象 系统人员表 
        */
        public void UpdateByDatabaseadminid(SystemAdminInfo objSystemAdminInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByDatabaseadminidReturnSQL(objSystemAdminInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByDatabaseadminidReturnSQL
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 删除数据表t_system_admin 系统人员表中的内容<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param Databaseadminid 人员ID 
        * @return SQL语句 
        */
        public String DeleteByDatabaseadminidReturnSQL(int Databaseadminid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_system_admin]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseAdminID] = ?\n");//-- 人员ID
            getDPUpdate().AddNewParameter("Databaseadminid",Databaseadminid ); // 人员ID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByDatabaseadminid
        /**
        * 根据 <br />
    * DatabaseAdminID Databaseadminid 人员ID<br />
 删除数据表t_system_admin 系统人员表中的内容<br />
        * 开发者 贾军磊 2012年12月13日 09:49:50
        * @param Databaseadminid 人员ID 
        */
        public void DeleteByDatabaseadminid(int Databaseadminid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByDatabaseadminidReturnSQL(Databaseadminid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
