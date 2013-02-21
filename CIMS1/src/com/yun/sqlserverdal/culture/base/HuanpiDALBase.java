
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:21:20
   功能说明: 表t_huanpi 的实体类HuanpiInfo的数据层基类
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
 * 表 t_huanpi  的实体HuanpiInfo的数据操作类
 * @author 贾军磊
 *
 */
public class HuanpiDALBase
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
	public HuanpiDALBase()
	{

	}

	public HuanpiDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByHuanpidatabaseidReturnSQL
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param Huanpidatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String CountByHuanpidatabaseidReturnSQL(int Huanpidatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_huanpi]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [HuanpidatabaseID] = ?\n");//-- 数据库ID
            getDP().AddNewParameter("Huanpidatabaseid",Huanpidatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByHuanpidatabaseid
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param Huanpidatabaseid 数据库ID 
        * @return 数据量 
        */
        public int CountByHuanpidatabaseid(int Huanpidatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByHuanpidatabaseidReturnSQL(Huanpidatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_huanpi]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
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
        // [start] CountByHuanpiidReturnSQL
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param Huanpiid 环境批复ID 
        * @return SQL语句 
        */
        public String CountByHuanpiidReturnSQL(int Huanpiid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_huanpi]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [HuanpiID] = ?\n");//-- 环境批复ID
            getDP().AddNewParameter("Huanpiid",Huanpiid ); // 环境批复ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param Huanpiid 环境批复ID 
        * @return 数据量 
        */
        public int CountByHuanpiid(int Huanpiid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByHuanpiidReturnSQL(Huanpiid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.HuanpiInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_huanpi]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[HuanpidatabaseID] DESC \n");//数据库ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @return 数据列表的强类型实体类 
        */
        public HuanpiInfoCollection GetListBy(String OrderBy)
        {
            HuanpiInfoCollection list = new HuanpiInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.HuanpiInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new HuanpiInfo(rs));
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
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @return 数据列表的强类型实体类 
        */
        public HuanpiInfoCollection GetListBy()
        {
            return GetListBy("HuanpiID");
        }
        // [end]
        // [start] GetListByHuanpiidReturnSQL
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param Huanpiid 环境批复ID 
        * @return SQL语句 
        */
        public String GetListByHuanpiidReturnSQL(int Huanpiid, String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.HuanpiInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_huanpi]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [HuanpiID] = ?\n");//-- 环境批复ID
            getDP().AddNewParameter("Huanpiid",Huanpiid ); // 环境批复ID
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[HuanpidatabaseID] DESC \n");//数据库ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param Huanpiid 环境批复ID 
        * @return 数据列表的强类型实体类 
        */
        public HuanpiInfoCollection GetListByHuanpiid(int Huanpiid, String OrderBy)
        {
            HuanpiInfoCollection list = new HuanpiInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.HuanpiInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByHuanpiidReturnSQL(Huanpiid, OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new HuanpiInfo(rs));
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
        // [start] GetListByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param Huanpiid 环境批复ID 
        * @return 数据列表的强类型实体类 
        */
        public HuanpiInfoCollection GetListByHuanpiid(int Huanpiid)
        {
            return GetListByHuanpiid(Huanpiid, "");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetHuanpiInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_huanpi 的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_huanpi]\n");
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
                sbStr.append("		[HuanpidatabaseID] DESC \n");//数据库ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.HuanpiInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_huanpi]\n");
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
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @return 数据列表的强类型实体类 
        */
        public HuanpiInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            HuanpiInfoCollection list = new HuanpiInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.HuanpiInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new HuanpiInfo(rs));
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
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @return 数据列表的强类型实体类 
        */
        public HuanpiInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
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
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]
        // [start] GetHuanpiInfoByHuanpiidReturnSQL
        /**
        * 根据 <br />
环境批复ID,HuanpiID 获取表t_huanpi 的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param Huanpiid 环境批复ID 
        * @return SQL语句 
        */
        public String GetListPagerByHuanpiidReturnSQL(int Huanpiid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_huanpi]\n");
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
                sbStr.append("		[HuanpidatabaseID] DESC \n");//数据库ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.HuanpiInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_huanpi]\n");
            }

            sbStr.append("WHERE\n");
            sbStr.append("	 [HuanpiID] = ?\n");//-- 环境批复ID
            getDP().AddNewParameter("Huanpiid",Huanpiid ); // 环境批复ID

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
        // [start] GetListPagerByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param Huanpiid 环境批复ID 
        * @return 数据列表的强类型实体类 
        */
        public HuanpiInfoCollection GetListPagerByHuanpiid(int Huanpiid, String OrderBy,int pageIndex, int pageSize)
        {
            HuanpiInfoCollection list = new HuanpiInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.HuanpiInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByHuanpiidReturnSQL(Huanpiid,  OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new HuanpiInfo(rs));
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
        // [start] GetListPagerByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 返回表t_huanpi 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param Huanpiid 环境批复ID 
        * @return 数据列表的强类型实体类 
        */
        public HuanpiInfoCollection GetListPagerByHuanpiid(int Huanpiid, int pageIndex, int pageSize)
        {
           return GetListPagerByHuanpiid(Huanpiid, "",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param Huanpiid 环境批复ID 
        * @return 数据总量 
        */
        public int GetListPagerByHuanpiid(int Huanpiid, String OrderBy)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByHuanpiidReturnSQL(Huanpiid,  OrderBy, null, 0, 0,true)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] GetListPagerByHuanpiid
        /**
        * 根据 <br />
    * HuanpiID Huanpiid 环境批复ID<br />
 统计表t_huanpi 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param Huanpiid 环境批复ID 
        * @return 数据总量 
        */
        public int GetListPagerByHuanpiid(int Huanpiid)
        {
            return GetListPagerByHuanpiid(Huanpiid,  "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetHuanpiInfoByHuanpidatabaseidReturnSQL
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 获取表t_huanpi 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param Huanpidatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String GetListByHuanpidatabaseidReturnSQL(int Huanpidatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.HuanpiInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_huanpi]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [HuanpidatabaseID] = ?\n");//-- 数据库ID
            getDP().AddNewParameter("Huanpidatabaseid",Huanpidatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] GetHuanpiInfoByHuanpidatabaseid
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 获取表t_huanpi 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param Huanpidatabaseid 数据库ID 
        * @return HuanpiInfo对象实体 
        */
        public HuanpiInfo GetHuanpiInfoByHuanpidatabaseid(int Huanpidatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByHuanpidatabaseidReturnSQL(Huanpidatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                HuanpiInfo objHuanpiInfo = new HuanpiInfo(rs);
                getDP().Dispose();
                return objHuanpiInfo;
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
        * 向表t_huanpi 中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param objHuanpiInfo HuanpiInfo对象  
        * @return SQL语句 
        */
        public String InsertReturnSQL(HuanpiInfo objHuanpiInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_huanpi]\n");
            sbStr.append("(\n");
            sbStr.append("	[HuanpiID],\n");//-- 环境批复ID
            sbStr.append("	[HuanpiName]\n");//-- HuanpiName
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 环境批复ID
            getDPUpdate().AddNewParameter("Huanpiid",objHuanpiInfo.getHuanpiid()); // 
            sbStr.append("	?\n");//-- HuanpiName
            getDPUpdate().AddNewParameter("Huanpiname",objHuanpiInfo.getHuanpiname()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_huanpi 中插入数据,返回HuanpidatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param objHuanpiInfo HuanpiInfo对象  
        * @return 字段HuanpiID 
        */
        public int Insert(HuanpiInfo objHuanpiInfo)
        {
            getDPUpdate().ClearParameter();
            int Huanpidatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objHuanpiInfo)));
            objHuanpiInfo.setHuanpidatabaseid(Huanpidatabaseid);//数据库ID  数据类型:int
            getDPUpdate().Dispose();
            return Huanpidatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByHuanpidatabaseidReturnSQL
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 更新表t_huanpi 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param objHuanpiInfo HuanpiInfo对象  
        * @return SQL语句 
        */
        public String UpdateByHuanpidatabaseidReturnSQL(HuanpiInfo objHuanpiInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_huanpi]\n");
            sbStr.append("SET\n");
            sbStr.append("	[HuanpiID] = ?,\n");//-- 环境批复ID
            getDPUpdate().AddNewParameter("Huanpiid",objHuanpiInfo.getHuanpiid()); // 环境批复ID
            sbStr.append("	[HuanpiName] = ?\n");//-- HuanpiName
            getDPUpdate().AddNewParameter("Huanpiname",objHuanpiInfo.getHuanpiname()); // HuanpiName
            sbStr.append("WHERE\n");
            sbStr.append("	 [HuanpidatabaseID] = ?\n");//-- 数据库ID
            getDPUpdate().AddNewParameter("Huanpidatabaseid",objHuanpiInfo.getHuanpidatabaseid() ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByHuanpidatabaseid
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 更新表t_huanpi 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param objHuanpiInfo HuanpiInfo对象  
        */
        public void UpdateByHuanpidatabaseid(HuanpiInfo objHuanpiInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByHuanpidatabaseidReturnSQL(objHuanpiInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByHuanpidatabaseidReturnSQL
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 删除数据表t_huanpi 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param Huanpidatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String DeleteByHuanpidatabaseidReturnSQL(int Huanpidatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_huanpi]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [HuanpidatabaseID] = ?\n");//-- 数据库ID
            getDPUpdate().AddNewParameter("Huanpidatabaseid",Huanpidatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByHuanpidatabaseid
        /**
        * 根据 <br />
    * HuanpidatabaseID Huanpidatabaseid 数据库ID<br />
 删除数据表t_huanpi 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:21:20
        * @param Huanpidatabaseid 数据库ID 
        */
        public void DeleteByHuanpidatabaseid(int Huanpidatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByHuanpidatabaseidReturnSQL(Huanpidatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
