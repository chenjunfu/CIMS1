
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:17:31
   功能说明: 表t_age 年龄段表的实体类AgeInfo的数据层基类
   表说明:年龄段表
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
 * 表 t_age 年龄段表 的实体AgeInfo的数据操作类
 * @author 贾军磊
 *
 */
public class AgeDALBase
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
	public AgeDALBase()
	{

	}

	public AgeDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByAgedatabaseidReturnSQL
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param Agedatabaseid AgedatabaseID 
        * @return SQL语句 
        */
        public String CountByAgedatabaseidReturnSQL(int Agedatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_age]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [AgedatabaseID] = ?\n");//-- AgedatabaseID
            getDP().AddNewParameter("Agedatabaseid",Agedatabaseid ); // AgedatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByAgedatabaseid
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param Agedatabaseid AgedatabaseID 
        * @return 数据量 
        */
        public int CountByAgedatabaseid(int Agedatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByAgedatabaseidReturnSQL(Agedatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_age]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
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
        // [start] CountByAgeidReturnSQL
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param Ageid 年龄段编号 
        * @return SQL语句 
        */
        public String CountByAgeidReturnSQL(int Ageid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_age]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [AgeID] = ?\n");//-- 年龄段编号
            getDP().AddNewParameter("Ageid",Ageid ); // 年龄段编号
            return sbStr.toString();
        }
        // [end]
        // [start] CountByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param Ageid 年龄段编号 
        * @return 数据量 
        */
        public int CountByAgeid(int Ageid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByAgeidReturnSQL(Ageid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.AgeInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_age]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[AgedatabaseID] DESC \n");//AgedatabaseID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @return 数据列表的强类型实体类 
        */
        public AgeInfoCollection GetListBy(String OrderBy)
        {
            AgeInfoCollection list = new AgeInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.AgeInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new AgeInfo(rs));
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
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @return 数据列表的强类型实体类 
        */
        public AgeInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]
        // [start] GetListByAgeidReturnSQL
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param Ageid 年龄段编号 
        * @return SQL语句 
        */
        public String GetListByAgeidReturnSQL(int Ageid, String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.AgeInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_age]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [AgeID] = ?\n");//-- 年龄段编号
            getDP().AddNewParameter("Ageid",Ageid ); // 年龄段编号
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[AgedatabaseID] DESC \n");//AgedatabaseID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param Ageid 年龄段编号 
        * @return 数据列表的强类型实体类 
        */
        public AgeInfoCollection GetListByAgeid(int Ageid, String OrderBy)
        {
            AgeInfoCollection list = new AgeInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.AgeInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByAgeidReturnSQL(Ageid, OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new AgeInfo(rs));
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
        // [start] GetListByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param Ageid 年龄段编号 
        * @return 数据列表的强类型实体类 
        */
        public AgeInfoCollection GetListByAgeid(int Ageid)
        {
            return GetListByAgeid(Ageid, "");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetAgeInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_age 年龄段表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_age]\n");
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
                sbStr.append("		[AgedatabaseID] DESC \n");//AgedatabaseID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.AgeInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_age]\n");
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
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @return 数据列表的强类型实体类 
        */
        public AgeInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            AgeInfoCollection list = new AgeInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.AgeInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new AgeInfo(rs));
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
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @return 数据列表的强类型实体类 
        */
        public AgeInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
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
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]
        // [start] GetAgeInfoByAgeidReturnSQL
        /**
        * 根据 <br />
年龄段编号,AgeID 获取表t_age 年龄段表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param Ageid 年龄段编号 
        * @return SQL语句 
        */
        public String GetListPagerByAgeidReturnSQL(int Ageid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_age]\n");
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
                sbStr.append("		[AgedatabaseID] DESC \n");//AgedatabaseID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.AgeInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_age]\n");
            }

            sbStr.append("WHERE\n");
            sbStr.append("	 [AgeID] = ?\n");//-- 年龄段编号
            getDP().AddNewParameter("Ageid",Ageid ); // 年龄段编号

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
        // [start] GetListPagerByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param Ageid 年龄段编号 
        * @return 数据列表的强类型实体类 
        */
        public AgeInfoCollection GetListPagerByAgeid(int Ageid, String OrderBy,int pageIndex, int pageSize)
        {
            AgeInfoCollection list = new AgeInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.AgeInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByAgeidReturnSQL(Ageid,  OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new AgeInfo(rs));
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
        // [start] GetListPagerByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 返回表t_age 年龄段表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param Ageid 年龄段编号 
        * @return 数据列表的强类型实体类 
        */
        public AgeInfoCollection GetListPagerByAgeid(int Ageid, int pageIndex, int pageSize)
        {
           return GetListPagerByAgeid(Ageid, "",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param Ageid 年龄段编号 
        * @return 数据总量 
        */
        public int GetListPagerByAgeid(int Ageid, String OrderBy)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByAgeidReturnSQL(Ageid,  OrderBy, null, 0, 0,true)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] GetListPagerByAgeid
        /**
        * 根据 <br />
    * AgeID Ageid 年龄段编号<br />
 统计表t_age 年龄段表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param Ageid 年龄段编号 
        * @return 数据总量 
        */
        public int GetListPagerByAgeid(int Ageid)
        {
            return GetListPagerByAgeid(Ageid,  "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetAgeInfoByAgedatabaseidReturnSQL
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 获取表t_age 年龄段表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param Agedatabaseid AgedatabaseID 
        * @return SQL语句 
        */
        public String GetListByAgedatabaseidReturnSQL(int Agedatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.AgeInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_age]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [AgedatabaseID] = ?\n");//-- AgedatabaseID
            getDP().AddNewParameter("Agedatabaseid",Agedatabaseid ); // AgedatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] GetAgeInfoByAgedatabaseid
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 获取表t_age 年龄段表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param Agedatabaseid AgedatabaseID 
        * @return AgeInfo对象实体 
        */
        public AgeInfo GetAgeInfoByAgedatabaseid(int Agedatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByAgedatabaseidReturnSQL(Agedatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                AgeInfo objAgeInfo = new AgeInfo(rs);
                getDP().Dispose();
                return objAgeInfo;
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
        * 向表t_age 年龄段表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param objAgeInfo AgeInfo对象 年龄段表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(AgeInfo objAgeInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_age]\n");
            sbStr.append("(\n");
            sbStr.append("	[AgeID],\n");//-- 年龄段编号
            sbStr.append("	[AgeName]\n");//-- 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 年龄段编号
            getDPUpdate().AddNewParameter("Ageid",objAgeInfo.getAgeid()); // 
            sbStr.append("	?\n");//-- 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
            getDPUpdate().AddNewParameter("Agename",objAgeInfo.getAgename()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_age 年龄段表中插入数据,返回AgedatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param objAgeInfo AgeInfo对象 年龄段表 
        * @return 字段AgeID 
        */
        public int Insert(AgeInfo objAgeInfo)
        {
            getDPUpdate().ClearParameter();
            int Agedatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objAgeInfo)));
            objAgeInfo.setAgedatabaseid(Agedatabaseid);//AgedatabaseID  数据类型:int
            getDPUpdate().Dispose();
            return Agedatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByAgedatabaseidReturnSQL
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 更新表t_age 年龄段表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param objAgeInfo AgeInfo对象 年龄段表 
        * @return SQL语句 
        */
        public String UpdateByAgedatabaseidReturnSQL(AgeInfo objAgeInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_age]\n");
            sbStr.append("SET\n");
            sbStr.append("	[AgeID] = ?,\n");//-- 年龄段编号
            getDPUpdate().AddNewParameter("Ageid",objAgeInfo.getAgeid()); // 年龄段编号
            sbStr.append("	[AgeName] = ?\n");//-- 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
            getDPUpdate().AddNewParameter("Agename",objAgeInfo.getAgename()); // 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
            sbStr.append("WHERE\n");
            sbStr.append("	 [AgedatabaseID] = ?\n");//-- AgedatabaseID
            getDPUpdate().AddNewParameter("Agedatabaseid",objAgeInfo.getAgedatabaseid() ); // AgedatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByAgedatabaseid
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 更新表t_age 年龄段表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param objAgeInfo AgeInfo对象 年龄段表 
        */
        public void UpdateByAgedatabaseid(AgeInfo objAgeInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByAgedatabaseidReturnSQL(objAgeInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByAgedatabaseidReturnSQL
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 删除数据表t_age 年龄段表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param Agedatabaseid AgedatabaseID 
        * @return SQL语句 
        */
        public String DeleteByAgedatabaseidReturnSQL(int Agedatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_age]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [AgedatabaseID] = ?\n");//-- AgedatabaseID
            getDPUpdate().AddNewParameter("Agedatabaseid",Agedatabaseid ); // AgedatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByAgedatabaseid
        /**
        * 根据 <br />
    * AgedatabaseID Agedatabaseid AgedatabaseID<br />
 删除数据表t_age 年龄段表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:17:31
        * @param Agedatabaseid AgedatabaseID 
        */
        public void DeleteByAgedatabaseid(int Agedatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByAgedatabaseidReturnSQL(Agedatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
