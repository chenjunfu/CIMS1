
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:25:08
   功能说明: 表t_proadd 的实体类ProaddInfo的数据层基类
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
 * 表 t_proadd  的实体ProaddInfo的数据操作类
 * @author 贾军磊
 *
 */
public class ProaddDALBase
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
	public ProaddDALBase()
	{

	}

	public ProaddDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByProadddatabaseidReturnSQL
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param Proadddatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String CountByProadddatabaseidReturnSQL(int Proadddatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_proadd]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [ProadddatabaseID] = ?\n");//-- 数据库ID
            getDP().AddNewParameter("Proadddatabaseid",Proadddatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByProadddatabaseid
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param Proadddatabaseid 数据库ID 
        * @return 数据量 
        */
        public int CountByProadddatabaseid(int Proadddatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByProadddatabaseidReturnSQL(Proadddatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_proadd]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
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
        // [start] CountByProaddidReturnSQL
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param Proaddid 地址ID 
        * @return SQL语句 
        */
        public String CountByProaddidReturnSQL(int Proaddid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_proadd]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [ProaddID] = ?\n");//-- 地址ID
            getDP().AddNewParameter("Proaddid",Proaddid ); // 地址ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param Proaddid 地址ID 
        * @return 数据量 
        */
        public int CountByProaddid(int Proaddid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByProaddidReturnSQL(Proaddid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.ProaddInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_proadd]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[ProadddatabaseID] DESC \n");//数据库ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @return 数据列表的强类型实体类 
        */
        public ProaddInfoCollection GetListBy(String OrderBy)
        {
            ProaddInfoCollection list = new ProaddInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.ProaddInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new ProaddInfo(rs));
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
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @return 数据列表的强类型实体类 
        */
        public ProaddInfoCollection GetListBy()
        {
            return GetListBy("ProaddID");
        }
        // [end]
        // [start] GetListByProaddidReturnSQL
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param Proaddid 地址ID 
        * @return SQL语句 
        */
        public String GetListByProaddidReturnSQL(int Proaddid, String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.ProaddInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_proadd]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [ProaddID] = ?\n");//-- 地址ID
            getDP().AddNewParameter("Proaddid",Proaddid ); // 地址ID
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[ProadddatabaseID] DESC \n");//数据库ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param Proaddid 地址ID 
        * @return 数据列表的强类型实体类 
        */
        public ProaddInfoCollection GetListByProaddid(int Proaddid, String OrderBy)
        {
            ProaddInfoCollection list = new ProaddInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.ProaddInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByProaddidReturnSQL(Proaddid, OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new ProaddInfo(rs));
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
        // [start] GetListByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param Proaddid 地址ID 
        * @return 数据列表的强类型实体类 
        */
        public ProaddInfoCollection GetListByProaddid(int Proaddid)
        {
            return GetListByProaddid(Proaddid, "");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetProaddInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_proadd 的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_proadd]\n");
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
                sbStr.append("		[ProadddatabaseID] DESC \n");//数据库ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.ProaddInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_proadd]\n");
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
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @return 数据列表的强类型实体类 
        */
        public ProaddInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            ProaddInfoCollection list = new ProaddInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.ProaddInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new ProaddInfo(rs));
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
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @return 数据列表的强类型实体类 
        */
        public ProaddInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
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
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]
        // [start] GetProaddInfoByProaddidReturnSQL
        /**
        * 根据 <br />
地址ID,ProaddID 获取表t_proadd 的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param Proaddid 地址ID 
        * @return SQL语句 
        */
        public String GetListPagerByProaddidReturnSQL(int Proaddid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_proadd]\n");
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
                sbStr.append("		[ProadddatabaseID] DESC \n");//数据库ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.ProaddInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_proadd]\n");
            }

            sbStr.append("WHERE\n");
            sbStr.append("	 [ProaddID] = ?\n");//-- 地址ID
            getDP().AddNewParameter("Proaddid",Proaddid ); // 地址ID

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
        // [start] GetListPagerByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param Proaddid 地址ID 
        * @return 数据列表的强类型实体类 
        */
        public ProaddInfoCollection GetListPagerByProaddid(int Proaddid, String OrderBy,int pageIndex, int pageSize)
        {
            ProaddInfoCollection list = new ProaddInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.ProaddInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByProaddidReturnSQL(Proaddid,  OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new ProaddInfo(rs));
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
        // [start] GetListPagerByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 返回表t_proadd 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param Proaddid 地址ID 
        * @return 数据列表的强类型实体类 
        */
        public ProaddInfoCollection GetListPagerByProaddid(int Proaddid, int pageIndex, int pageSize)
        {
           return GetListPagerByProaddid(Proaddid, "",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param Proaddid 地址ID 
        * @return 数据总量 
        */
        public int GetListPagerByProaddid(int Proaddid, String OrderBy)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByProaddidReturnSQL(Proaddid,  OrderBy, null, 0, 0,true)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] GetListPagerByProaddid
        /**
        * 根据 <br />
    * ProaddID Proaddid 地址ID<br />
 统计表t_proadd 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param Proaddid 地址ID 
        * @return 数据总量 
        */
        public int GetListPagerByProaddid(int Proaddid)
        {
            return GetListPagerByProaddid(Proaddid,  "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetProaddInfoByProadddatabaseidReturnSQL
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 获取表t_proadd 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param Proadddatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String GetListByProadddatabaseidReturnSQL(int Proadddatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.ProaddInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_proadd]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [ProadddatabaseID] = ?\n");//-- 数据库ID
            getDP().AddNewParameter("Proadddatabaseid",Proadddatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] GetProaddInfoByProadddatabaseid
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 获取表t_proadd 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param Proadddatabaseid 数据库ID 
        * @return ProaddInfo对象实体 
        */
        public ProaddInfo GetProaddInfoByProadddatabaseid(int Proadddatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByProadddatabaseidReturnSQL(Proadddatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                ProaddInfo objProaddInfo = new ProaddInfo(rs);
                getDP().Dispose();
                return objProaddInfo;
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
        * 向表t_proadd 中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param objProaddInfo ProaddInfo对象  
        * @return SQL语句 
        */
        public String InsertReturnSQL(ProaddInfo objProaddInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_proadd]\n");
            sbStr.append("(\n");
            sbStr.append("	[ProaddID],\n");//-- 地址ID
            sbStr.append("	[ProaddName]\n");//-- 地址名称
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 地址ID
            getDPUpdate().AddNewParameter("Proaddid",objProaddInfo.getProaddid()); // 
            sbStr.append("	?\n");//-- 地址名称
            getDPUpdate().AddNewParameter("Proaddname",objProaddInfo.getProaddname()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_proadd 中插入数据,返回ProadddatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param objProaddInfo ProaddInfo对象  
        * @return 字段ProaddID 
        */
        public int Insert(ProaddInfo objProaddInfo)
        {
            getDPUpdate().ClearParameter();
            int Proadddatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objProaddInfo)));
            objProaddInfo.setProadddatabaseid(Proadddatabaseid);//数据库ID  数据类型:int
            getDPUpdate().Dispose();
            return Proadddatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByProadddatabaseidReturnSQL
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 更新表t_proadd 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param objProaddInfo ProaddInfo对象  
        * @return SQL语句 
        */
        public String UpdateByProadddatabaseidReturnSQL(ProaddInfo objProaddInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_proadd]\n");
            sbStr.append("SET\n");
            sbStr.append("	[ProaddID] = ?,\n");//-- 地址ID
            getDPUpdate().AddNewParameter("Proaddid",objProaddInfo.getProaddid()); // 地址ID
            sbStr.append("	[ProaddName] = ?\n");//-- 地址名称
            getDPUpdate().AddNewParameter("Proaddname",objProaddInfo.getProaddname()); // 地址名称
            sbStr.append("WHERE\n");
            sbStr.append("	 [ProadddatabaseID] = ?\n");//-- 数据库ID
            getDPUpdate().AddNewParameter("Proadddatabaseid",objProaddInfo.getProadddatabaseid() ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByProadddatabaseid
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 更新表t_proadd 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param objProaddInfo ProaddInfo对象  
        */
        public void UpdateByProadddatabaseid(ProaddInfo objProaddInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByProadddatabaseidReturnSQL(objProaddInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByProadddatabaseidReturnSQL
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 删除数据表t_proadd 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param Proadddatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String DeleteByProadddatabaseidReturnSQL(int Proadddatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_proadd]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [ProadddatabaseID] = ?\n");//-- 数据库ID
            getDPUpdate().AddNewParameter("Proadddatabaseid",Proadddatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByProadddatabaseid
        /**
        * 根据 <br />
    * ProadddatabaseID Proadddatabaseid 数据库ID<br />
 删除数据表t_proadd 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:08
        * @param Proadddatabaseid 数据库ID 
        */
        public void DeleteByProadddatabaseid(int Proadddatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByProadddatabaseidReturnSQL(Proadddatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
