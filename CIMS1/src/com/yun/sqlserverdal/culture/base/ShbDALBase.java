
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:25:49
   功能说明: 表t_shb 的实体类ShbInfo的数据层基类
   表说明:
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
 * 表 t_shb  的实体ShbInfo的数据操作类
 * @author 贾军磊
 *
 */
public class ShbDALBase
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
	public ShbDALBase()
	{

	}

	public ShbDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByShbdatabaseidReturnSQL
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param Shbdatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String CountByShbdatabaseidReturnSQL(int Shbdatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_shb]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [shbdatabaseID] = ?\n");//-- 数据库ID
            getDP().AddNewParameter("Shbdatabaseid",Shbdatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByShbdatabaseid
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param Shbdatabaseid 数据库ID 
        * @return 数据量 
        */
        public int CountByShbdatabaseid(int Shbdatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByShbdatabaseidReturnSQL(Shbdatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_shb]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
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
        // [start] CountByShbidReturnSQL
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param Shbid 审核备ID 
        * @return SQL语句 
        */
        public String CountByShbidReturnSQL(int Shbid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_shb]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [shbID] = ?\n");//-- 审核备ID
            getDP().AddNewParameter("Shbid",Shbid ); // 审核备ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param Shbid 审核备ID 
        * @return 数据量 
        */
        public int CountByShbid(int Shbid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByShbidReturnSQL(Shbid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.ShbInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_shb]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[shbdatabaseID] DESC \n");//数据库ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @return 数据列表的强类型实体类 
        */
        public ShbInfoCollection GetListBy(String OrderBy)
        {
            ShbInfoCollection list = new ShbInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.ShbInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new ShbInfo(rs));
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
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @return 数据列表的强类型实体类 
        */
        public ShbInfoCollection GetListBy()
        {
            return GetListBy("shbID");
        }
        // [end]
        // [start] GetListByShbidReturnSQL
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param Shbid 审核备ID 
        * @return SQL语句 
        */
        public String GetListByShbidReturnSQL(int Shbid, String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.ShbInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_shb]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [shbID] = ?\n");//-- 审核备ID
            getDP().AddNewParameter("Shbid",Shbid ); // 审核备ID
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[shbdatabaseID] DESC \n");//数据库ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param Shbid 审核备ID 
        * @return 数据列表的强类型实体类 
        */
        public ShbInfoCollection GetListByShbid(int Shbid, String OrderBy)
        {
            ShbInfoCollection list = new ShbInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.ShbInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByShbidReturnSQL(Shbid, OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new ShbInfo(rs));
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
        // [start] GetListByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param Shbid 审核备ID 
        * @return 数据列表的强类型实体类 
        */
        public ShbInfoCollection GetListByShbid(int Shbid)
        {
            return GetListByShbid(Shbid, "");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetShbInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_shb 的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_shb]\n");
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
                sbStr.append("		[shbdatabaseID] DESC \n");//数据库ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.ShbInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_shb]\n");
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
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @return 数据列表的强类型实体类 
        */
        public ShbInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            ShbInfoCollection list = new ShbInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.ShbInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new ShbInfo(rs));
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
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @return 数据列表的强类型实体类 
        */
        public ShbInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
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
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]
        // [start] GetShbInfoByShbidReturnSQL
        /**
        * 根据 <br />
审核备ID,shbID 获取表t_shb 的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param Shbid 审核备ID 
        * @return SQL语句 
        */
        public String GetListPagerByShbidReturnSQL(int Shbid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_shb]\n");
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
                sbStr.append("		[shbdatabaseID] DESC \n");//数据库ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.ShbInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_shb]\n");
            }

            sbStr.append("WHERE\n");
            sbStr.append("	 [shbID] = ?\n");//-- 审核备ID
            getDP().AddNewParameter("Shbid",Shbid ); // 审核备ID

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
        // [start] GetListPagerByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param Shbid 审核备ID 
        * @return 数据列表的强类型实体类 
        */
        public ShbInfoCollection GetListPagerByShbid(int Shbid, String OrderBy,int pageIndex, int pageSize)
        {
            ShbInfoCollection list = new ShbInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.ShbInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByShbidReturnSQL(Shbid,  OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new ShbInfo(rs));
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
        // [start] GetListPagerByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 返回表t_shb 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param Shbid 审核备ID 
        * @return 数据列表的强类型实体类 
        */
        public ShbInfoCollection GetListPagerByShbid(int Shbid, int pageIndex, int pageSize)
        {
           return GetListPagerByShbid(Shbid, "",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param Shbid 审核备ID 
        * @return 数据总量 
        */
        public int GetListPagerByShbid(int Shbid, String OrderBy)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByShbidReturnSQL(Shbid,  OrderBy, null, 0, 0,true)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] GetListPagerByShbid
        /**
        * 根据 <br />
    * shbID Shbid 审核备ID<br />
 统计表t_shb 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param Shbid 审核备ID 
        * @return 数据总量 
        */
        public int GetListPagerByShbid(int Shbid)
        {
            return GetListPagerByShbid(Shbid,  "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetShbInfoByShbdatabaseidReturnSQL
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 获取表t_shb 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param Shbdatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String GetListByShbdatabaseidReturnSQL(int Shbdatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.ShbInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_shb]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [shbdatabaseID] = ?\n");//-- 数据库ID
            getDP().AddNewParameter("Shbdatabaseid",Shbdatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] GetShbInfoByShbdatabaseid
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 获取表t_shb 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param Shbdatabaseid 数据库ID 
        * @return ShbInfo对象实体 
        */
        public ShbInfo GetShbInfoByShbdatabaseid(int Shbdatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByShbdatabaseidReturnSQL(Shbdatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                ShbInfo objShbInfo = new ShbInfo(rs);
                getDP().Dispose();
                return objShbInfo;
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
        * 向表t_shb 中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param objShbInfo ShbInfo对象  
        * @return SQL语句 
        */
        public String InsertReturnSQL(ShbInfo objShbInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_shb]\n");
            sbStr.append("(\n");
            sbStr.append("	[shbID],\n");//-- 审核备ID
            sbStr.append("	[shbName]\n");//-- shbName
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 审核备ID
            getDPUpdate().AddNewParameter("Shbid",objShbInfo.getShbid()); // 
            sbStr.append("	?\n");//-- shbName
            getDPUpdate().AddNewParameter("Shbname",objShbInfo.getShbname()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_shb 中插入数据,返回shbdatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param objShbInfo ShbInfo对象  
        * @return 字段ShbID 
        */
        public int Insert(ShbInfo objShbInfo)
        {
            getDPUpdate().ClearParameter();
            int Shbdatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objShbInfo)));
            objShbInfo.setShbdatabaseid(Shbdatabaseid);//数据库ID  数据类型:int
            getDPUpdate().Dispose();
            return Shbdatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByShbdatabaseidReturnSQL
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 更新表t_shb 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param objShbInfo ShbInfo对象  
        * @return SQL语句 
        */
        public String UpdateByShbdatabaseidReturnSQL(ShbInfo objShbInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_shb]\n");
            sbStr.append("SET\n");
            sbStr.append("	[shbID] = ?,\n");//-- 审核备ID
            getDPUpdate().AddNewParameter("Shbid",objShbInfo.getShbid()); // 审核备ID
            sbStr.append("	[shbName] = ?\n");//-- shbName
            getDPUpdate().AddNewParameter("Shbname",objShbInfo.getShbname()); // shbName
            sbStr.append("WHERE\n");
            sbStr.append("	 [shbdatabaseID] = ?\n");//-- 数据库ID
            getDPUpdate().AddNewParameter("Shbdatabaseid",objShbInfo.getShbdatabaseid() ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByShbdatabaseid
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 更新表t_shb 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param objShbInfo ShbInfo对象  
        */
        public void UpdateByShbdatabaseid(ShbInfo objShbInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByShbdatabaseidReturnSQL(objShbInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByShbdatabaseidReturnSQL
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 删除数据表t_shb 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param Shbdatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String DeleteByShbdatabaseidReturnSQL(int Shbdatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_shb]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [shbdatabaseID] = ?\n");//-- 数据库ID
            getDPUpdate().AddNewParameter("Shbdatabaseid",Shbdatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByShbdatabaseid
        /**
        * 根据 <br />
    * shbdatabaseID Shbdatabaseid 数据库ID<br />
 删除数据表t_shb 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:49
        * @param Shbdatabaseid 数据库ID 
        */
        public void DeleteByShbdatabaseid(int Shbdatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByShbdatabaseidReturnSQL(Shbdatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
