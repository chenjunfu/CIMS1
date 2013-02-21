
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:23:57
   功能说明: 表t_major 专业表的实体类MajorInfo的数据层基类
   表说明:专业表
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
 * 表 t_major 专业表 的实体MajorInfo的数据操作类
 * @author 贾军磊
 *
 */
public class MajorDALBase
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
	public MajorDALBase()
	{

	}

	public MajorDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByMajordatabaseidReturnSQL
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param Majordatabaseid 专业数据库编号 
        * @return SQL语句 
        */
        public String CountByMajordatabaseidReturnSQL(int Majordatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_major]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [MajordatabaseID] = ?\n");//-- 专业数据库编号
            getDP().AddNewParameter("Majordatabaseid",Majordatabaseid ); // 专业数据库编号
            return sbStr.toString();
        }
        // [end]
        // [start] CountByMajordatabaseid
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param Majordatabaseid 专业数据库编号 
        * @return 数据量 
        */
        public int CountByMajordatabaseid(int Majordatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByMajordatabaseidReturnSQL(Majordatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_major]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
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
        // [start] CountByMajoridReturnSQL
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param Majorid 专业编号 
        * @return SQL语句 
        */
        public String CountByMajoridReturnSQL(int Majorid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_major]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [MajorID] = ?\n");//-- 专业编号
            getDP().AddNewParameter("Majorid",Majorid ); // 专业编号
            return sbStr.toString();
        }
        // [end]
        // [start] CountByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param Majorid 专业编号 
        * @return 数据量 
        */
        public int CountByMajorid(int Majorid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByMajoridReturnSQL(Majorid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.MajorInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_major]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[MajordatabaseID] DESC \n");//专业数据库编号
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @return 数据列表的强类型实体类 
        */
        public MajorInfoCollection GetListBy(String OrderBy)
        {
            MajorInfoCollection list = new MajorInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.MajorInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new MajorInfo(rs));
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
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @return 数据列表的强类型实体类 
        */
        public MajorInfoCollection GetListBy()
        {
            return GetListBy("MajorID");
        }
        // [end]
        // [start] GetListByMajoridReturnSQL
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param Majorid 专业编号 
        * @return SQL语句 
        */
        public String GetListByMajoridReturnSQL(int Majorid, String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.MajorInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_major]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [MajorID] = ?\n");//-- 专业编号
            getDP().AddNewParameter("Majorid",Majorid ); // 专业编号
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[MajordatabaseID] DESC \n");//专业数据库编号
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param Majorid 专业编号 
        * @return 数据列表的强类型实体类 
        */
        public MajorInfoCollection GetListByMajorid(int Majorid, String OrderBy)
        {
            MajorInfoCollection list = new MajorInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.MajorInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByMajoridReturnSQL(Majorid, OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new MajorInfo(rs));
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
        // [start] GetListByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param Majorid 专业编号 
        * @return 数据列表的强类型实体类 
        */
        public MajorInfoCollection GetListByMajorid(int Majorid)
        {
            return GetListByMajorid(Majorid, "");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetMajorInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_major 专业表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_major]\n");
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
                sbStr.append("		[MajordatabaseID] DESC \n");//专业数据库编号
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.MajorInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_major]\n");
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
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @return 数据列表的强类型实体类 
        */
        public MajorInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            MajorInfoCollection list = new MajorInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.MajorInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new MajorInfo(rs));
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
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @return 数据列表的强类型实体类 
        */
        public MajorInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
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
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]
        // [start] GetMajorInfoByMajoridReturnSQL
        /**
        * 根据 <br />
专业编号,MajorID 获取表t_major 专业表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param Majorid 专业编号 
        * @return SQL语句 
        */
        public String GetListPagerByMajoridReturnSQL(int Majorid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_major]\n");
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
                sbStr.append("		[MajordatabaseID] DESC \n");//专业数据库编号
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.MajorInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_major]\n");
            }

            sbStr.append("WHERE\n");
            sbStr.append("	 [MajorID] = ?\n");//-- 专业编号
            getDP().AddNewParameter("Majorid",Majorid ); // 专业编号

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
        // [start] GetListPagerByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param Majorid 专业编号 
        * @return 数据列表的强类型实体类 
        */
        public MajorInfoCollection GetListPagerByMajorid(int Majorid, String OrderBy,int pageIndex, int pageSize)
        {
            MajorInfoCollection list = new MajorInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.MajorInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByMajoridReturnSQL(Majorid,  OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new MajorInfo(rs));
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
        // [start] GetListPagerByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 返回表t_major 专业表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param Majorid 专业编号 
        * @return 数据列表的强类型实体类 
        */
        public MajorInfoCollection GetListPagerByMajorid(int Majorid, int pageIndex, int pageSize)
        {
           return GetListPagerByMajorid(Majorid, "",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param Majorid 专业编号 
        * @return 数据总量 
        */
        public int GetListPagerByMajorid(int Majorid, String OrderBy)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByMajoridReturnSQL(Majorid,  OrderBy, null, 0, 0,true)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] GetListPagerByMajorid
        /**
        * 根据 <br />
    * MajorID Majorid 专业编号<br />
 统计表t_major 专业表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param Majorid 专业编号 
        * @return 数据总量 
        */
        public int GetListPagerByMajorid(int Majorid)
        {
            return GetListPagerByMajorid(Majorid,  "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetMajorInfoByMajordatabaseidReturnSQL
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 获取表t_major 专业表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param Majordatabaseid 专业数据库编号 
        * @return SQL语句 
        */
        public String GetListByMajordatabaseidReturnSQL(int Majordatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.MajorInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_major]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [MajordatabaseID] = ?\n");//-- 专业数据库编号
            getDP().AddNewParameter("Majordatabaseid",Majordatabaseid ); // 专业数据库编号
            return sbStr.toString();
        }
        // [end]
        // [start] GetMajorInfoByMajordatabaseid
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 获取表t_major 专业表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param Majordatabaseid 专业数据库编号 
        * @return MajorInfo对象实体 
        */
        public MajorInfo GetMajorInfoByMajordatabaseid(int Majordatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByMajordatabaseidReturnSQL(Majordatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                MajorInfo objMajorInfo = new MajorInfo(rs);
                getDP().Dispose();
                return objMajorInfo;
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
        * 向表t_major 专业表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param objMajorInfo MajorInfo对象 专业表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(MajorInfo objMajorInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_major]\n");
            sbStr.append("(\n");
            sbStr.append("	[MajorID],\n");//-- 专业编号
            sbStr.append("	[MajorName]\n");//-- 专业名称
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 专业编号
            getDPUpdate().AddNewParameter("Majorid",objMajorInfo.getMajorid()); // 
            sbStr.append("	?\n");//-- 专业名称
            getDPUpdate().AddNewParameter("Majorname",objMajorInfo.getMajorname()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_major 专业表中插入数据,返回MajordatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param objMajorInfo MajorInfo对象 专业表 
        * @return 字段MajorID 
        */
        public int Insert(MajorInfo objMajorInfo)
        {
            getDPUpdate().ClearParameter();
            int Majordatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objMajorInfo)));
            objMajorInfo.setMajordatabaseid(Majordatabaseid);//专业数据库编号  数据类型:int
            getDPUpdate().Dispose();
            return Majordatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByMajordatabaseidReturnSQL
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 更新表t_major 专业表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param objMajorInfo MajorInfo对象 专业表 
        * @return SQL语句 
        */
        public String UpdateByMajordatabaseidReturnSQL(MajorInfo objMajorInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_major]\n");
            sbStr.append("SET\n");
            sbStr.append("	[MajorID] = ?,\n");//-- 专业编号
            getDPUpdate().AddNewParameter("Majorid",objMajorInfo.getMajorid()); // 专业编号
            sbStr.append("	[MajorName] = ?\n");//-- 专业名称
            getDPUpdate().AddNewParameter("Majorname",objMajorInfo.getMajorname()); // 专业名称
            sbStr.append("WHERE\n");
            sbStr.append("	 [MajordatabaseID] = ?\n");//-- 专业数据库编号
            getDPUpdate().AddNewParameter("Majordatabaseid",objMajorInfo.getMajordatabaseid() ); // 专业数据库编号
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByMajordatabaseid
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 更新表t_major 专业表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param objMajorInfo MajorInfo对象 专业表 
        */
        public void UpdateByMajordatabaseid(MajorInfo objMajorInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByMajordatabaseidReturnSQL(objMajorInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByMajordatabaseidReturnSQL
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 删除数据表t_major 专业表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param Majordatabaseid 专业数据库编号 
        * @return SQL语句 
        */
        public String DeleteByMajordatabaseidReturnSQL(int Majordatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_major]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [MajordatabaseID] = ?\n");//-- 专业数据库编号
            getDPUpdate().AddNewParameter("Majordatabaseid",Majordatabaseid ); // 专业数据库编号
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByMajordatabaseid
        /**
        * 根据 <br />
    * MajordatabaseID Majordatabaseid 专业数据库编号<br />
 删除数据表t_major 专业表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:57
        * @param Majordatabaseid 专业数据库编号 
        */
        public void DeleteByMajordatabaseid(int Majordatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByMajordatabaseidReturnSQL(Majordatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
