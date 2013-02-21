
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:20:02
   功能说明: 表t_degree 的实体类DegreeInfo的数据层基类
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
 * 表 t_degree  的实体DegreeInfo的数据操作类
 * @author 贾军磊
 *
 */
public class DegreeDALBase
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
	public DegreeDALBase()
	{

	}

	public DegreeDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByDegreedatabaseidReturnSQL
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param Degreedatabaseid DegreedatabaseID 
        * @return SQL语句 
        */
        public String CountByDegreedatabaseidReturnSQL(int Degreedatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_degree]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DegreedatabaseID] = ?\n");//-- DegreedatabaseID
            getDP().AddNewParameter("Degreedatabaseid",Degreedatabaseid ); // DegreedatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByDegreedatabaseid
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param Degreedatabaseid DegreedatabaseID 
        * @return 数据量 
        */
        public int CountByDegreedatabaseid(int Degreedatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDegreedatabaseidReturnSQL(Degreedatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_degree]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
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
        // [start] CountByDegreeidReturnSQL
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param Degreeid DegreeID 
        * @return SQL语句 
        */
        public String CountByDegreeidReturnSQL(int Degreeid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_degree]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DegreeID] = ?\n");//-- DegreeID
            getDP().AddNewParameter("Degreeid",Degreeid ); // DegreeID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param Degreeid DegreeID 
        * @return 数据量 
        */
        public int CountByDegreeid(int Degreeid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDegreeidReturnSQL(Degreeid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.DegreeInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_degree]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[DegreedatabaseID] DESC \n");//DegreedatabaseID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @return 数据列表的强类型实体类 
        */
        public DegreeInfoCollection GetListBy(String OrderBy)
        {
            DegreeInfoCollection list = new DegreeInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.DegreeInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new DegreeInfo(rs));
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
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @return 数据列表的强类型实体类 
        */
        public DegreeInfoCollection GetListBy()
        {
            return GetListBy("DegreeID");
        }
        // [end]
        // [start] GetListByDegreeidReturnSQL
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param Degreeid DegreeID 
        * @return SQL语句 
        */
        public String GetListByDegreeidReturnSQL(int Degreeid, String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.DegreeInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_degree]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DegreeID] = ?\n");//-- DegreeID
            getDP().AddNewParameter("Degreeid",Degreeid ); // DegreeID
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[DegreedatabaseID] DESC \n");//DegreedatabaseID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param Degreeid DegreeID 
        * @return 数据列表的强类型实体类 
        */
        public DegreeInfoCollection GetListByDegreeid(int Degreeid, String OrderBy)
        {
            DegreeInfoCollection list = new DegreeInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.DegreeInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByDegreeidReturnSQL(Degreeid, OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new DegreeInfo(rs));
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
        // [start] GetListByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param Degreeid DegreeID 
        * @return 数据列表的强类型实体类 
        */
        public DegreeInfoCollection GetListByDegreeid(int Degreeid)
        {
            return GetListByDegreeid(Degreeid, "");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetDegreeInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_degree 的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_degree]\n");
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
                sbStr.append("		[DegreedatabaseID] DESC \n");//DegreedatabaseID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.DegreeInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_degree]\n");
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
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @return 数据列表的强类型实体类 
        */
        public DegreeInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            DegreeInfoCollection list = new DegreeInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.DegreeInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new DegreeInfo(rs));
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
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @return 数据列表的强类型实体类 
        */
        public DegreeInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
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
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]
        // [start] GetDegreeInfoByDegreeidReturnSQL
        /**
        * 根据 <br />
DegreeID,DegreeID 获取表t_degree 的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param Degreeid DegreeID 
        * @return SQL语句 
        */
        public String GetListPagerByDegreeidReturnSQL(int Degreeid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_degree]\n");
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
                sbStr.append("		[DegreedatabaseID] DESC \n");//DegreedatabaseID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.DegreeInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_degree]\n");
            }

            sbStr.append("WHERE\n");
            sbStr.append("	 [DegreeID] = ?\n");//-- DegreeID
            getDP().AddNewParameter("Degreeid",Degreeid ); // DegreeID

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
        // [start] GetListPagerByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param Degreeid DegreeID 
        * @return 数据列表的强类型实体类 
        */
        public DegreeInfoCollection GetListPagerByDegreeid(int Degreeid, String OrderBy,int pageIndex, int pageSize)
        {
            DegreeInfoCollection list = new DegreeInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.DegreeInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByDegreeidReturnSQL(Degreeid,  OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new DegreeInfo(rs));
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
        // [start] GetListPagerByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 返回表t_degree 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param Degreeid DegreeID 
        * @return 数据列表的强类型实体类 
        */
        public DegreeInfoCollection GetListPagerByDegreeid(int Degreeid, int pageIndex, int pageSize)
        {
           return GetListPagerByDegreeid(Degreeid, "",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param Degreeid DegreeID 
        * @return 数据总量 
        */
        public int GetListPagerByDegreeid(int Degreeid, String OrderBy)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByDegreeidReturnSQL(Degreeid,  OrderBy, null, 0, 0,true)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] GetListPagerByDegreeid
        /**
        * 根据 <br />
    * DegreeID Degreeid DegreeID<br />
 统计表t_degree 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param Degreeid DegreeID 
        * @return 数据总量 
        */
        public int GetListPagerByDegreeid(int Degreeid)
        {
            return GetListPagerByDegreeid(Degreeid,  "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetDegreeInfoByDegreedatabaseidReturnSQL
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 获取表t_degree 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param Degreedatabaseid DegreedatabaseID 
        * @return SQL语句 
        */
        public String GetListByDegreedatabaseidReturnSQL(int Degreedatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.DegreeInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_degree]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DegreedatabaseID] = ?\n");//-- DegreedatabaseID
            getDP().AddNewParameter("Degreedatabaseid",Degreedatabaseid ); // DegreedatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] GetDegreeInfoByDegreedatabaseid
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 获取表t_degree 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param Degreedatabaseid DegreedatabaseID 
        * @return DegreeInfo对象实体 
        */
        public DegreeInfo GetDegreeInfoByDegreedatabaseid(int Degreedatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByDegreedatabaseidReturnSQL(Degreedatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                DegreeInfo objDegreeInfo = new DegreeInfo(rs);
                getDP().Dispose();
                return objDegreeInfo;
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
        * 向表t_degree 中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param objDegreeInfo DegreeInfo对象  
        * @return SQL语句 
        */
        public String InsertReturnSQL(DegreeInfo objDegreeInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_degree]\n");
            sbStr.append("(\n");
            sbStr.append("	[DegreeID],\n");//-- DegreeID
            sbStr.append("	[DegreeName]\n");//-- DegreeName
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- DegreeID
            getDPUpdate().AddNewParameter("Degreeid",objDegreeInfo.getDegreeid()); // 
            sbStr.append("	?\n");//-- DegreeName
            getDPUpdate().AddNewParameter("Degreename",objDegreeInfo.getDegreename()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_degree 中插入数据,返回DegreedatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param objDegreeInfo DegreeInfo对象  
        * @return 字段DegreeID 
        */
        public int Insert(DegreeInfo objDegreeInfo)
        {
            getDPUpdate().ClearParameter();
            int Degreedatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objDegreeInfo)));
            objDegreeInfo.setDegreedatabaseid(Degreedatabaseid);//DegreedatabaseID  数据类型:int
            getDPUpdate().Dispose();
            return Degreedatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByDegreedatabaseidReturnSQL
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 更新表t_degree 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param objDegreeInfo DegreeInfo对象  
        * @return SQL语句 
        */
        public String UpdateByDegreedatabaseidReturnSQL(DegreeInfo objDegreeInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_degree]\n");
            sbStr.append("SET\n");
            sbStr.append("	[DegreeID] = ?,\n");//-- DegreeID
            getDPUpdate().AddNewParameter("Degreeid",objDegreeInfo.getDegreeid()); // DegreeID
            sbStr.append("	[DegreeName] = ?\n");//-- DegreeName
            getDPUpdate().AddNewParameter("Degreename",objDegreeInfo.getDegreename()); // DegreeName
            sbStr.append("WHERE\n");
            sbStr.append("	 [DegreedatabaseID] = ?\n");//-- DegreedatabaseID
            getDPUpdate().AddNewParameter("Degreedatabaseid",objDegreeInfo.getDegreedatabaseid() ); // DegreedatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByDegreedatabaseid
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 更新表t_degree 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param objDegreeInfo DegreeInfo对象  
        */
        public void UpdateByDegreedatabaseid(DegreeInfo objDegreeInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByDegreedatabaseidReturnSQL(objDegreeInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByDegreedatabaseidReturnSQL
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 删除数据表t_degree 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param Degreedatabaseid DegreedatabaseID 
        * @return SQL语句 
        */
        public String DeleteByDegreedatabaseidReturnSQL(int Degreedatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_degree]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DegreedatabaseID] = ?\n");//-- DegreedatabaseID
            getDPUpdate().AddNewParameter("Degreedatabaseid",Degreedatabaseid ); // DegreedatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByDegreedatabaseid
        /**
        * 根据 <br />
    * DegreedatabaseID Degreedatabaseid DegreedatabaseID<br />
 删除数据表t_degree 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:20:02
        * @param Degreedatabaseid DegreedatabaseID 
        */
        public void DeleteByDegreedatabaseid(int Degreedatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByDegreedatabaseidReturnSQL(Degreedatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
