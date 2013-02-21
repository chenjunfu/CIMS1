
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:27:24
   功能说明: 表t_tupi 的实体类TupiInfo的数据层基类
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
 * 表 t_tupi  的实体TupiInfo的数据操作类
 * @author 贾军磊
 *
 */
public class TupiDALBase
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
	public TupiDALBase()
	{

	}

	public TupiDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByTupidatabaseidReturnSQL
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param Tupidatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String CountByTupidatabaseidReturnSQL(int Tupidatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_tupi]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [TupidatabaseID] = ?\n");//-- 数据库ID
            getDP().AddNewParameter("Tupidatabaseid",Tupidatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByTupidatabaseid
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param Tupidatabaseid 数据库ID 
        * @return 数据量 
        */
        public int CountByTupidatabaseid(int Tupidatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByTupidatabaseidReturnSQL(Tupidatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_tupi]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
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
        // [start] CountByTupiidReturnSQL
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param Tupiid 土地批准ID 
        * @return SQL语句 
        */
        public String CountByTupiidReturnSQL(int Tupiid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_tupi]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [TupiID] = ?\n");//-- 土地批准ID
            getDP().AddNewParameter("Tupiid",Tupiid ); // 土地批准ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param Tupiid 土地批准ID 
        * @return 数据量 
        */
        public int CountByTupiid(int Tupiid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByTupiidReturnSQL(Tupiid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.TupiInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_tupi]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[TupidatabaseID] DESC \n");//数据库ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @return 数据列表的强类型实体类 
        */
        public TupiInfoCollection GetListBy(String OrderBy)
        {
            TupiInfoCollection list = new TupiInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.TupiInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new TupiInfo(rs));
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
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @return 数据列表的强类型实体类 
        */
        public TupiInfoCollection GetListBy()
        {
            return GetListBy("TupiID");
        }
        // [end]
        // [start] GetListByTupiidReturnSQL
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param Tupiid 土地批准ID 
        * @return SQL语句 
        */
        public String GetListByTupiidReturnSQL(int Tupiid, String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.TupiInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_tupi]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [TupiID] = ?\n");//-- 土地批准ID
            getDP().AddNewParameter("Tupiid",Tupiid ); // 土地批准ID
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[TupidatabaseID] DESC \n");//数据库ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param Tupiid 土地批准ID 
        * @return 数据列表的强类型实体类 
        */
        public TupiInfoCollection GetListByTupiid(int Tupiid, String OrderBy)
        {
            TupiInfoCollection list = new TupiInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.TupiInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByTupiidReturnSQL(Tupiid, OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new TupiInfo(rs));
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
        // [start] GetListByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param Tupiid 土地批准ID 
        * @return 数据列表的强类型实体类 
        */
        public TupiInfoCollection GetListByTupiid(int Tupiid)
        {
            return GetListByTupiid(Tupiid, "");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetTupiInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_tupi 的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_tupi]\n");
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
                sbStr.append("		[TupidatabaseID] DESC \n");//数据库ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.TupiInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_tupi]\n");
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
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @return 数据列表的强类型实体类 
        */
        public TupiInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            TupiInfoCollection list = new TupiInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.TupiInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new TupiInfo(rs));
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
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @return 数据列表的强类型实体类 
        */
        public TupiInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
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
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]
        // [start] GetTupiInfoByTupiidReturnSQL
        /**
        * 根据 <br />
土地批准ID,TupiID 获取表t_tupi 的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param Tupiid 土地批准ID 
        * @return SQL语句 
        */
        public String GetListPagerByTupiidReturnSQL(int Tupiid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_tupi]\n");
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
                sbStr.append("		[TupidatabaseID] DESC \n");//数据库ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.TupiInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_tupi]\n");
            }

            sbStr.append("WHERE\n");
            sbStr.append("	 [TupiID] = ?\n");//-- 土地批准ID
            getDP().AddNewParameter("Tupiid",Tupiid ); // 土地批准ID

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
        // [start] GetListPagerByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param Tupiid 土地批准ID 
        * @return 数据列表的强类型实体类 
        */
        public TupiInfoCollection GetListPagerByTupiid(int Tupiid, String OrderBy,int pageIndex, int pageSize)
        {
            TupiInfoCollection list = new TupiInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.TupiInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByTupiidReturnSQL(Tupiid,  OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new TupiInfo(rs));
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
        // [start] GetListPagerByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 返回表t_tupi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param Tupiid 土地批准ID 
        * @return 数据列表的强类型实体类 
        */
        public TupiInfoCollection GetListPagerByTupiid(int Tupiid, int pageIndex, int pageSize)
        {
           return GetListPagerByTupiid(Tupiid, "",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param Tupiid 土地批准ID 
        * @return 数据总量 
        */
        public int GetListPagerByTupiid(int Tupiid, String OrderBy)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByTupiidReturnSQL(Tupiid,  OrderBy, null, 0, 0,true)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] GetListPagerByTupiid
        /**
        * 根据 <br />
    * TupiID Tupiid 土地批准ID<br />
 统计表t_tupi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param Tupiid 土地批准ID 
        * @return 数据总量 
        */
        public int GetListPagerByTupiid(int Tupiid)
        {
            return GetListPagerByTupiid(Tupiid,  "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetTupiInfoByTupidatabaseidReturnSQL
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 获取表t_tupi 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param Tupidatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String GetListByTupidatabaseidReturnSQL(int Tupidatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.TupiInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_tupi]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [TupidatabaseID] = ?\n");//-- 数据库ID
            getDP().AddNewParameter("Tupidatabaseid",Tupidatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] GetTupiInfoByTupidatabaseid
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 获取表t_tupi 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param Tupidatabaseid 数据库ID 
        * @return TupiInfo对象实体 
        */
        public TupiInfo GetTupiInfoByTupidatabaseid(int Tupidatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByTupidatabaseidReturnSQL(Tupidatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                TupiInfo objTupiInfo = new TupiInfo(rs);
                getDP().Dispose();
                return objTupiInfo;
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
        * 向表t_tupi 中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param objTupiInfo TupiInfo对象  
        * @return SQL语句 
        */
        public String InsertReturnSQL(TupiInfo objTupiInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_tupi]\n");
            sbStr.append("(\n");
            sbStr.append("	[TupiID],\n");//-- 土地批准ID
            sbStr.append("	[TupiName]\n");//-- TupiName
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 土地批准ID
            getDPUpdate().AddNewParameter("Tupiid",objTupiInfo.getTupiid()); // 
            sbStr.append("	?\n");//-- TupiName
            getDPUpdate().AddNewParameter("Tupiname",objTupiInfo.getTupiname()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_tupi 中插入数据,返回TupidatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param objTupiInfo TupiInfo对象  
        * @return 字段TupiID 
        */
        public int Insert(TupiInfo objTupiInfo)
        {
            getDPUpdate().ClearParameter();
            int Tupidatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objTupiInfo)));
            objTupiInfo.setTupidatabaseid(Tupidatabaseid);//数据库ID  数据类型:int
            getDPUpdate().Dispose();
            return Tupidatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByTupidatabaseidReturnSQL
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 更新表t_tupi 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param objTupiInfo TupiInfo对象  
        * @return SQL语句 
        */
        public String UpdateByTupidatabaseidReturnSQL(TupiInfo objTupiInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_tupi]\n");
            sbStr.append("SET\n");
            sbStr.append("	[TupiID] = ?,\n");//-- 土地批准ID
            getDPUpdate().AddNewParameter("Tupiid",objTupiInfo.getTupiid()); // 土地批准ID
            sbStr.append("	[TupiName] = ?\n");//-- TupiName
            getDPUpdate().AddNewParameter("Tupiname",objTupiInfo.getTupiname()); // TupiName
            sbStr.append("WHERE\n");
            sbStr.append("	 [TupidatabaseID] = ?\n");//-- 数据库ID
            getDPUpdate().AddNewParameter("Tupidatabaseid",objTupiInfo.getTupidatabaseid() ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByTupidatabaseid
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 更新表t_tupi 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param objTupiInfo TupiInfo对象  
        */
        public void UpdateByTupidatabaseid(TupiInfo objTupiInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByTupidatabaseidReturnSQL(objTupiInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByTupidatabaseidReturnSQL
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 删除数据表t_tupi 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param Tupidatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String DeleteByTupidatabaseidReturnSQL(int Tupidatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_tupi]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [TupidatabaseID] = ?\n");//-- 数据库ID
            getDPUpdate().AddNewParameter("Tupidatabaseid",Tupidatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByTupidatabaseid
        /**
        * 根据 <br />
    * TupidatabaseID Tupidatabaseid 数据库ID<br />
 删除数据表t_tupi 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:24
        * @param Tupidatabaseid 数据库ID 
        */
        public void DeleteByTupidatabaseid(int Tupidatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByTupidatabaseidReturnSQL(Tupidatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
