
/*======================================================================
   开发者:贾军磊
   创建日期:2013年01月22日 13:52:24
   功能说明: 表t_enterprise 企业信息表的实体类EnterpriseInfo的数据层基类
   表说明:企业信息表
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
 * 表 t_enterprise 企业信息表 的实体EnterpriseInfo的数据操作类
 * @author 贾军磊
 *
 */
public class EnterpriseDALBase
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
	public EnterpriseDALBase()
	{

	}

	public EnterpriseDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByDatabaseenterpriseidReturnSQL
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param Databaseenterpriseid 企业ID 
        * @return SQL语句 
        */
        public String CountByDatabaseenterpriseidReturnSQL(int Databaseenterpriseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_enterprise]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseEnterpriseID] = ?\n");//-- 企业ID
            getDP().AddNewParameter("Databaseenterpriseid",Databaseenterpriseid ); // 企业ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByDatabaseenterpriseid
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param Databaseenterpriseid 企业ID 
        * @return 数据量 
        */
        public int CountByDatabaseenterpriseid(int Databaseenterpriseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDatabaseenterpriseidReturnSQL(Databaseenterpriseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_enterprise]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
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
        // [start] CountByEnterpriseidReturnSQL
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param Enterpriseid 企业编号 
        * @return SQL语句 
        */
        public String CountByEnterpriseidReturnSQL(int Enterpriseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_enterprise]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [EnterpriseID] = ?\n");//-- 企业编号
            getDP().AddNewParameter("Enterpriseid",Enterpriseid ); // 企业编号
            return sbStr.toString();
        }
        // [end]
        // [start] CountByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param Enterpriseid 企业编号 
        * @return 数据量 
        */
        public int CountByEnterpriseid(int Enterpriseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByEnterpriseidReturnSQL(Enterpriseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_enterprise]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[DatabaseEnterpriseID] DESC \n");//企业ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @return 数据列表的强类型实体类 
        */
        public EnterpriseInfoCollection GetListBy(String OrderBy)
        {
            EnterpriseInfoCollection list = new EnterpriseInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new EnterpriseInfo(rs));
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
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @return 数据列表的强类型实体类 
        */
        public EnterpriseInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]
        // [start] GetListByEnterpriseidReturnSQL
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param Enterpriseid 企业编号 
        * @return SQL语句 
        */
        public String GetListByEnterpriseidReturnSQL(int Enterpriseid, String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_enterprise]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [EnterpriseID] = ?\n");//-- 企业编号
            getDP().AddNewParameter("Enterpriseid",Enterpriseid ); // 企业编号
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[DatabaseEnterpriseID] DESC \n");//企业ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param Enterpriseid 企业编号 
        * @return 数据列表的强类型实体类 
        */
        public EnterpriseInfoCollection GetListByEnterpriseid(int Enterpriseid, String OrderBy)
        {
            EnterpriseInfoCollection list = new EnterpriseInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByEnterpriseidReturnSQL(Enterpriseid, OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new EnterpriseInfo(rs));
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
        // [start] GetListByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param Enterpriseid 企业编号 
        * @return 数据列表的强类型实体类 
        */
        public EnterpriseInfoCollection GetListByEnterpriseid(int Enterpriseid)
        {
            return GetListByEnterpriseid(Enterpriseid, "");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetEnterpriseInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_enterprise 企业信息表的SQL语句
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_enterprise]\n");
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
                sbStr.append("		[DatabaseEnterpriseID] DESC \n");//企业ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_enterprise]\n");
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
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @return 数据列表的强类型实体类 
        */
        public EnterpriseInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            EnterpriseInfoCollection list = new EnterpriseInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new EnterpriseInfo(rs));
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
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @return 数据列表的强类型实体类 
        */
        public EnterpriseInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
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
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]
        // [start] GetEnterpriseInfoByEnterpriseidReturnSQL
        /**
        * 根据 <br />
企业编号,EnterpriseID 获取表t_enterprise 企业信息表的SQL语句
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param Enterpriseid 企业编号 
        * @return SQL语句 
        */
        public String GetListPagerByEnterpriseidReturnSQL(int Enterpriseid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_enterprise]\n");
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
                sbStr.append("		[DatabaseEnterpriseID] DESC \n");//企业ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_enterprise]\n");
            }

            sbStr.append("WHERE\n");
            sbStr.append("	 [EnterpriseID] = ?\n");//-- 企业编号
            getDP().AddNewParameter("Enterpriseid",Enterpriseid ); // 企业编号

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
        // [start] GetListPagerByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param Enterpriseid 企业编号 
        * @return 数据列表的强类型实体类 
        */
        public EnterpriseInfoCollection GetListPagerByEnterpriseid(int Enterpriseid, String OrderBy,int pageIndex, int pageSize)
        {
            EnterpriseInfoCollection list = new EnterpriseInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByEnterpriseidReturnSQL(Enterpriseid,  OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new EnterpriseInfo(rs));
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
        // [start] GetListPagerByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 返回表t_enterprise 企业信息表的数据列表<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param Enterpriseid 企业编号 
        * @return 数据列表的强类型实体类 
        */
        public EnterpriseInfoCollection GetListPagerByEnterpriseid(int Enterpriseid, int pageIndex, int pageSize)
        {
           return GetListPagerByEnterpriseid(Enterpriseid, "",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param Enterpriseid 企业编号 
        * @return 数据总量 
        */
        public int GetListPagerByEnterpriseid(int Enterpriseid, String OrderBy)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByEnterpriseidReturnSQL(Enterpriseid,  OrderBy, null, 0, 0,true)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] GetListPagerByEnterpriseid
        /**
        * 根据 <br />
    * EnterpriseID Enterpriseid 企业编号<br />
 统计表t_enterprise 企业信息表的数据量<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param Enterpriseid 企业编号 
        * @return 数据总量 
        */
        public int GetListPagerByEnterpriseid(int Enterpriseid)
        {
            return GetListPagerByEnterpriseid(Enterpriseid,  "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetEnterpriseInfoByDatabaseenterpriseidReturnSQL
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 获取表t_enterprise 企业信息表的对象<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param Databaseenterpriseid 企业ID 
        * @return SQL语句 
        */
        public String GetListByDatabaseenterpriseidReturnSQL(int Databaseenterpriseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_enterprise]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseEnterpriseID] = ?\n");//-- 企业ID
            getDP().AddNewParameter("Databaseenterpriseid",Databaseenterpriseid ); // 企业ID
            return sbStr.toString();
        }
        // [end]
        // [start] GetEnterpriseInfoByDatabaseenterpriseid
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 获取表t_enterprise 企业信息表的对象<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param Databaseenterpriseid 企业ID 
        * @return EnterpriseInfo对象实体 
        */
        public EnterpriseInfo GetEnterpriseInfoByDatabaseenterpriseid(int Databaseenterpriseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByDatabaseenterpriseidReturnSQL(Databaseenterpriseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                EnterpriseInfo objEnterpriseInfo = new EnterpriseInfo(rs);
                getDP().Dispose();
                return objEnterpriseInfo;
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
        * 向表t_enterprise 企业信息表中插入数据,的SQL语句
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param objEnterpriseInfo EnterpriseInfo对象 企业信息表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(EnterpriseInfo objEnterpriseInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_enterprise]\n");
            sbStr.append("(\n");
            sbStr.append("	[EnterpriseID],\n");//-- 企业编号
            sbStr.append("	[EnterpriseName],\n");//-- 企业名称
            sbStr.append("	[BusinessTypeID],\n");//-- 行业类型
            sbStr.append("	[LegalPerson],\n");//-- 法人
            sbStr.append("	[CreateTime],\n");//-- 创立时间
            sbStr.append("	[RegionID],\n");//-- 所属区域
            sbStr.append("	[Address],\n");//-- 企业地址
            sbStr.append("	[EnterpriseCode],\n");//-- 工商登记号
            sbStr.append("	[PartentCode],\n");//-- 产品专利号
            sbStr.append("	[Scope],\n");//-- 经营范围
            sbStr.append("	[RegistAddress],\n");//-- 企业注册地址
            sbStr.append("	[RegistFund],\n");//-- 注册资金
            sbStr.append("	[Area],\n");//-- 占地面积
            sbStr.append("	[ToalInvest],\n");//-- 总投资
            sbStr.append("	[QualityID],\n");//-- 企业性质
            sbStr.append("	[EmployNumber],\n");//-- 就业人数
            sbStr.append("	[ProduceValue],\n");//-- 年产值
            sbStr.append("	[Profit],\n");//-- 利润
            sbStr.append("	[Feature],\n");//-- 产品特色
            sbStr.append("	[ObtainHonor],\n");//-- 获得荣誉
            sbStr.append("	[SocialBenefit],\n");//-- 社会效益
            sbStr.append("	[PeopleID1],\n");//-- 统计人员
            sbStr.append("	[PeopleID2],\n");//-- 填表人员
            sbStr.append("	[AdminID],\n");//-- 登录人员
            sbStr.append("	[SectorID],\n");//-- 部门编号
            sbStr.append("	[LoginTime],\n");//-- 登录时间
            sbStr.append("	[LinkPhone],\n");//-- 联系电话
            sbStr.append("	[contact]\n");//-- 联系人
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 企业编号
            getDPUpdate().AddNewParameter("Enterpriseid",objEnterpriseInfo.getEnterpriseid()); // 
            sbStr.append("	?,\n");//-- 企业名称
            getDPUpdate().AddNewParameter("Enterprisename",objEnterpriseInfo.getEnterprisename()); // 
            sbStr.append("	?,\n");//-- 行业类型
            getDPUpdate().AddNewParameter("Businesstypeid",objEnterpriseInfo.getBusinesstypeid()); // 
            sbStr.append("	?,\n");//-- 法人
            getDPUpdate().AddNewParameter("Legalperson",objEnterpriseInfo.getLegalperson()); // 
            sbStr.append("	?,\n");//-- 创立时间
            getDPUpdate().AddNewParameter("Createtime",objEnterpriseInfo.getCreatetime()); // 
            sbStr.append("	?,\n");//-- 所属区域
            getDPUpdate().AddNewParameter("Regionid",objEnterpriseInfo.getRegionid()); // 
            sbStr.append("	?,\n");//-- 企业地址
            getDPUpdate().AddNewParameter("Address",objEnterpriseInfo.getAddress()); // 
            sbStr.append("	?,\n");//-- 工商登记号
            getDPUpdate().AddNewParameter("Enterprisecode",objEnterpriseInfo.getEnterprisecode()); // 
            sbStr.append("	?,\n");//-- 产品专利号
            getDPUpdate().AddNewParameter("Partentcode",objEnterpriseInfo.getPartentcode()); // 
            sbStr.append("	?,\n");//-- 经营范围
            getDPUpdate().AddNewParameter("Scope",objEnterpriseInfo.getScope()); // 
            sbStr.append("	?,\n");//-- 企业注册地址
            getDPUpdate().AddNewParameter("Registaddress",objEnterpriseInfo.getRegistaddress()); // 
            sbStr.append("	?,\n");//-- 注册资金
            getDPUpdate().AddNewParameter("Registfund",objEnterpriseInfo.getRegistfund()); // 
            sbStr.append("	?,\n");//-- 占地面积
            getDPUpdate().AddNewParameter("Area",objEnterpriseInfo.getArea()); // 
            sbStr.append("	?,\n");//-- 总投资
            getDPUpdate().AddNewParameter("Toalinvest",objEnterpriseInfo.getToalinvest()); // 
            sbStr.append("	?,\n");//-- 企业性质
            getDPUpdate().AddNewParameter("Qualityid",objEnterpriseInfo.getQualityid()); // 
            sbStr.append("	?,\n");//-- 就业人数
            getDPUpdate().AddNewParameter("Employnumber",objEnterpriseInfo.getEmploynumber()); // 
            sbStr.append("	?,\n");//-- 年产值
            getDPUpdate().AddNewParameter("Producevalue",objEnterpriseInfo.getProducevalue()); // 
            sbStr.append("	?,\n");//-- 利润
            getDPUpdate().AddNewParameter("Profit",objEnterpriseInfo.getProfit()); // 
            sbStr.append("	?,\n");//-- 产品特色
            getDPUpdate().AddNewParameter("Feature",objEnterpriseInfo.getFeature()); // 
            sbStr.append("	?,\n");//-- 获得荣誉
            getDPUpdate().AddNewParameter("Obtainhonor",objEnterpriseInfo.getObtainhonor()); // 
            sbStr.append("	?,\n");//-- 社会效益
            getDPUpdate().AddNewParameter("Socialbenefit",objEnterpriseInfo.getSocialbenefit()); // 
            sbStr.append("	?,\n");//-- 统计人员
            getDPUpdate().AddNewParameter("Peopleid1",objEnterpriseInfo.getPeopleid1()); // 
            sbStr.append("	?,\n");//-- 填表人员
            getDPUpdate().AddNewParameter("Peopleid2",objEnterpriseInfo.getPeopleid2()); // 
            sbStr.append("	?,\n");//-- 登录人员
            getDPUpdate().AddNewParameter("Adminid",objEnterpriseInfo.getAdminid()); // 
            sbStr.append("	?,\n");//-- 部门编号
            getDPUpdate().AddNewParameter("Sectorid",objEnterpriseInfo.getSectorid()); // 
            sbStr.append("	?,\n");//-- 登录时间
            getDPUpdate().AddNewParameter("Logintime",objEnterpriseInfo.getLogintime()); // 
            sbStr.append("	?,\n");//-- 联系电话
            getDPUpdate().AddNewParameter("Linkphone",objEnterpriseInfo.getLinkphone()); // 
            sbStr.append("	?\n");//-- 联系人
            getDPUpdate().AddNewParameter("Contact",objEnterpriseInfo.getContact()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_enterprise 企业信息表中插入数据,返回DatabaseEnterpriseID字段内容<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param objEnterpriseInfo EnterpriseInfo对象 企业信息表 
        * @return 字段EnterpriseID 
        */
        public int Insert(EnterpriseInfo objEnterpriseInfo)
        {
            getDPUpdate().ClearParameter();
            int Databaseenterpriseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objEnterpriseInfo)));
            getDPUpdate().Dispose();
            objEnterpriseInfo.setDatabaseenterpriseid(Databaseenterpriseid);//企业ID  数据类型:int
            return Databaseenterpriseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByDatabaseenterpriseidReturnSQL
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 更新表t_enterprise 企业信息表中的内容<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param objEnterpriseInfo EnterpriseInfo对象 企业信息表 
        * @return SQL语句 
        */
        public String UpdateByDatabaseenterpriseidReturnSQL(EnterpriseInfo objEnterpriseInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_enterprise]\n");
            sbStr.append("SET\n");
            sbStr.append("	[EnterpriseID] = ?,\n");//-- 企业编号
            getDPUpdate().AddNewParameter("Enterpriseid",objEnterpriseInfo.getEnterpriseid()); // 企业编号
            sbStr.append("	[EnterpriseName] = ?,\n");//-- 企业名称
            getDPUpdate().AddNewParameter("Enterprisename",objEnterpriseInfo.getEnterprisename()); // 企业名称
            sbStr.append("	[BusinessTypeID] = ?,\n");//-- 行业类型
            getDPUpdate().AddNewParameter("Businesstypeid",objEnterpriseInfo.getBusinesstypeid()); // 行业类型
            sbStr.append("	[LegalPerson] = ?,\n");//-- 法人
            getDPUpdate().AddNewParameter("Legalperson",objEnterpriseInfo.getLegalperson()); // 法人
            sbStr.append("	[CreateTime] = ?,\n");//-- 创立时间
            getDPUpdate().AddNewParameter("Createtime",objEnterpriseInfo.getCreatetime()); // 创立时间
            sbStr.append("	[RegionID] = ?,\n");//-- 所属区域
            getDPUpdate().AddNewParameter("Regionid",objEnterpriseInfo.getRegionid()); // 所属区域
            sbStr.append("	[Address] = ?,\n");//-- 企业地址
            getDPUpdate().AddNewParameter("Address",objEnterpriseInfo.getAddress()); // 企业地址
            sbStr.append("	[EnterpriseCode] = ?,\n");//-- 工商登记号
            getDPUpdate().AddNewParameter("Enterprisecode",objEnterpriseInfo.getEnterprisecode()); // 工商登记号
            sbStr.append("	[PartentCode] = ?,\n");//-- 产品专利号
            getDPUpdate().AddNewParameter("Partentcode",objEnterpriseInfo.getPartentcode()); // 产品专利号
            sbStr.append("	[Scope] = ?,\n");//-- 经营范围
            getDPUpdate().AddNewParameter("Scope",objEnterpriseInfo.getScope()); // 经营范围
            sbStr.append("	[RegistAddress] = ?,\n");//-- 企业注册地址
            getDPUpdate().AddNewParameter("Registaddress",objEnterpriseInfo.getRegistaddress()); // 企业注册地址
            sbStr.append("	[RegistFund] = ?,\n");//-- 注册资金
            getDPUpdate().AddNewParameter("Registfund",objEnterpriseInfo.getRegistfund()); // 注册资金
            sbStr.append("	[Area] = ?,\n");//-- 占地面积
            getDPUpdate().AddNewParameter("Area",objEnterpriseInfo.getArea()); // 占地面积
            sbStr.append("	[ToalInvest] = ?,\n");//-- 总投资
            getDPUpdate().AddNewParameter("Toalinvest",objEnterpriseInfo.getToalinvest()); // 总投资
            sbStr.append("	[QualityID] = ?,\n");//-- 企业性质
            getDPUpdate().AddNewParameter("Qualityid",objEnterpriseInfo.getQualityid()); // 企业性质
            sbStr.append("	[EmployNumber] = ?,\n");//-- 就业人数
            getDPUpdate().AddNewParameter("Employnumber",objEnterpriseInfo.getEmploynumber()); // 就业人数
            sbStr.append("	[ProduceValue] = ?,\n");//-- 年产值
            getDPUpdate().AddNewParameter("Producevalue",objEnterpriseInfo.getProducevalue()); // 年产值
            sbStr.append("	[Profit] = ?,\n");//-- 利润
            getDPUpdate().AddNewParameter("Profit",objEnterpriseInfo.getProfit()); // 利润
            sbStr.append("	[Feature] = ?,\n");//-- 产品特色
            getDPUpdate().AddNewParameter("Feature",objEnterpriseInfo.getFeature()); // 产品特色
            sbStr.append("	[ObtainHonor] = ?,\n");//-- 获得荣誉
            getDPUpdate().AddNewParameter("Obtainhonor",objEnterpriseInfo.getObtainhonor()); // 获得荣誉
            sbStr.append("	[SocialBenefit] = ?,\n");//-- 社会效益
            getDPUpdate().AddNewParameter("Socialbenefit",objEnterpriseInfo.getSocialbenefit()); // 社会效益
            sbStr.append("	[PeopleID1] = ?,\n");//-- 统计人员
            getDPUpdate().AddNewParameter("Peopleid1",objEnterpriseInfo.getPeopleid1()); // 统计人员
            sbStr.append("	[PeopleID2] = ?,\n");//-- 填表人员
            getDPUpdate().AddNewParameter("Peopleid2",objEnterpriseInfo.getPeopleid2()); // 填表人员
            sbStr.append("	[AdminID] = ?,\n");//-- 登录人员
            getDPUpdate().AddNewParameter("Adminid",objEnterpriseInfo.getAdminid()); // 登录人员
            sbStr.append("	[SectorID] = ?,\n");//-- 部门编号
            getDPUpdate().AddNewParameter("Sectorid",objEnterpriseInfo.getSectorid()); // 部门编号
            sbStr.append("	[LoginTime] = ?,\n");//-- 登录时间
            getDPUpdate().AddNewParameter("Logintime",objEnterpriseInfo.getLogintime()); // 登录时间
            sbStr.append("	[LinkPhone] = ?,\n");//-- 联系电话
            getDPUpdate().AddNewParameter("Linkphone",objEnterpriseInfo.getLinkphone()); // 联系电话
            sbStr.append("	[contact] = ?\n");//-- 联系人
            getDPUpdate().AddNewParameter("Contact",objEnterpriseInfo.getContact()); // 联系人
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseEnterpriseID] = ?\n");//-- 企业ID
            getDPUpdate().AddNewParameter("Databaseenterpriseid",objEnterpriseInfo.getDatabaseenterpriseid() ); // 企业ID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByDatabaseenterpriseid
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 更新表t_enterprise 企业信息表中的内容<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param objEnterpriseInfo EnterpriseInfo对象 企业信息表 
        */
        public void UpdateByDatabaseenterpriseid(EnterpriseInfo objEnterpriseInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByDatabaseenterpriseidReturnSQL(objEnterpriseInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByDatabaseenterpriseidReturnSQL
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 删除数据表t_enterprise 企业信息表中的内容<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param Databaseenterpriseid 企业ID 
        * @return SQL语句 
        */
        public String DeleteByDatabaseenterpriseidReturnSQL(int Databaseenterpriseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_enterprise]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseEnterpriseID] = ?\n");//-- 企业ID
            getDPUpdate().AddNewParameter("Databaseenterpriseid",Databaseenterpriseid ); // 企业ID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByDatabaseenterpriseid
        /**
        * 根据 <br />
    * DatabaseEnterpriseID Databaseenterpriseid 企业ID<br />
 删除数据表t_enterprise 企业信息表中的内容<br />
        * 开发者 贾军磊 2013年01月22日 13:52:24
        * @param Databaseenterpriseid 企业ID 
        */
        public void DeleteByDatabaseenterpriseid(int Databaseenterpriseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByDatabaseenterpriseidReturnSQL(Databaseenterpriseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
