
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:25:30
   功能说明: 表t_regions 郑州市地区表的实体类RegionsInfo的数据层基类
   表说明:郑州市地区表
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
 * 表 t_regions 郑州市地区表 的实体RegionsInfo的数据操作类
 * @author 贾军磊
 *
 */
public class RegionsDALBase
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
	public RegionsDALBase()
	{

	}

	public RegionsDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByRegiondatabaseidReturnSQL
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param Regiondatabaseid RegiondatabaseID 
        * @return SQL语句 
        */
        public String CountByRegiondatabaseidReturnSQL(int Regiondatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_regions]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [RegiondatabaseID] = ?\n");//-- RegiondatabaseID
            getDP().AddNewParameter("Regiondatabaseid",Regiondatabaseid ); // RegiondatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByRegiondatabaseid
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param Regiondatabaseid RegiondatabaseID 
        * @return 数据量 
        */
        public int CountByRegiondatabaseid(int Regiondatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByRegiondatabaseidReturnSQL(Regiondatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_regions]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
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
        // [start] CountByRegionidReturnSQL
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param Regionid 城市编号 
        * @return SQL语句 
        */
        public String CountByRegionidReturnSQL(int Regionid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_regions]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [RegionID] = ?\n");//-- 城市编号
            getDP().AddNewParameter("Regionid",Regionid ); // 城市编号
            return sbStr.toString();
        }
        // [end]
        // [start] CountByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param Regionid 城市编号 
        * @return 数据量 
        */
        public int CountByRegionid(int Regionid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByRegionidReturnSQL(Regionid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.RegionsInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_regions]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[RegiondatabaseID] DESC \n");//RegiondatabaseID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @return 数据列表的强类型实体类 
        */
        public RegionsInfoCollection GetListBy(String OrderBy)
        {
            RegionsInfoCollection list = new RegionsInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.RegionsInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new RegionsInfo(rs));
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
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @return 数据列表的强类型实体类 
        */
        public RegionsInfoCollection GetListBy()
        {
            return GetListBy("RegionID");
        }
        // [end]
        // [start] GetListByRegionidReturnSQL
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param Regionid 城市编号 
        * @return SQL语句 
        */
        public String GetListByRegionidReturnSQL(int Regionid, String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.RegionsInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_regions]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [RegionID] = ?\n");//-- 城市编号
            getDP().AddNewParameter("Regionid",Regionid ); // 城市编号
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[RegiondatabaseID] DESC \n");//RegiondatabaseID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param Regionid 城市编号 
        * @return 数据列表的强类型实体类 
        */
        public RegionsInfoCollection GetListByRegionid(int Regionid, String OrderBy)
        {
            RegionsInfoCollection list = new RegionsInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.RegionsInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByRegionidReturnSQL(Regionid, OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new RegionsInfo(rs));
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
        // [start] GetListByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param Regionid 城市编号 
        * @return 数据列表的强类型实体类 
        */
        public RegionsInfoCollection GetListByRegionid(int Regionid)
        {
            return GetListByRegionid(Regionid, "");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetRegionsInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_regions 郑州市地区表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_regions]\n");
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
                sbStr.append("		[RegiondatabaseID] DESC \n");//RegiondatabaseID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.RegionsInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_regions]\n");
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
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @return 数据列表的强类型实体类 
        */
        public RegionsInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            RegionsInfoCollection list = new RegionsInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.RegionsInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new RegionsInfo(rs));
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
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @return 数据列表的强类型实体类 
        */
        public RegionsInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
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
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]
        // [start] GetRegionsInfoByRegionidReturnSQL
        /**
        * 根据 <br />
城市编号,RegionID 获取表t_regions 郑州市地区表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param Regionid 城市编号 
        * @return SQL语句 
        */
        public String GetListPagerByRegionidReturnSQL(int Regionid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_regions]\n");
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
                sbStr.append("		[RegiondatabaseID] DESC \n");//RegiondatabaseID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.RegionsInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_regions]\n");
            }

            sbStr.append("WHERE\n");
            sbStr.append("	 [RegionID] = ?\n");//-- 城市编号
            getDP().AddNewParameter("Regionid",Regionid ); // 城市编号

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
        // [start] GetListPagerByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param Regionid 城市编号 
        * @return 数据列表的强类型实体类 
        */
        public RegionsInfoCollection GetListPagerByRegionid(int Regionid, String OrderBy,int pageIndex, int pageSize)
        {
            RegionsInfoCollection list = new RegionsInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.RegionsInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByRegionidReturnSQL(Regionid,  OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new RegionsInfo(rs));
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
        // [start] GetListPagerByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 返回表t_regions 郑州市地区表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param Regionid 城市编号 
        * @return 数据列表的强类型实体类 
        */
        public RegionsInfoCollection GetListPagerByRegionid(int Regionid, int pageIndex, int pageSize)
        {
           return GetListPagerByRegionid(Regionid, "",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param Regionid 城市编号 
        * @return 数据总量 
        */
        public int GetListPagerByRegionid(int Regionid, String OrderBy)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByRegionidReturnSQL(Regionid,  OrderBy, null, 0, 0,true)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] GetListPagerByRegionid
        /**
        * 根据 <br />
    * RegionID Regionid 城市编号<br />
 统计表t_regions 郑州市地区表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param Regionid 城市编号 
        * @return 数据总量 
        */
        public int GetListPagerByRegionid(int Regionid)
        {
            return GetListPagerByRegionid(Regionid,  "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetRegionsInfoByRegiondatabaseidReturnSQL
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 获取表t_regions 郑州市地区表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param Regiondatabaseid RegiondatabaseID 
        * @return SQL语句 
        */
        public String GetListByRegiondatabaseidReturnSQL(int Regiondatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.RegionsInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_regions]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [RegiondatabaseID] = ?\n");//-- RegiondatabaseID
            getDP().AddNewParameter("Regiondatabaseid",Regiondatabaseid ); // RegiondatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] GetRegionsInfoByRegiondatabaseid
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 获取表t_regions 郑州市地区表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param Regiondatabaseid RegiondatabaseID 
        * @return RegionsInfo对象实体 
        */
        public RegionsInfo GetRegionsInfoByRegiondatabaseid(int Regiondatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByRegiondatabaseidReturnSQL(Regiondatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                RegionsInfo objRegionsInfo = new RegionsInfo(rs);
                getDP().Dispose();
                return objRegionsInfo;
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
        * 向表t_regions 郑州市地区表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param objRegionsInfo RegionsInfo对象 郑州市地区表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(RegionsInfo objRegionsInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_regions]\n");
            sbStr.append("(\n");
            sbStr.append("	[RegionID],\n");//-- 城市编号
            sbStr.append("	[RegionName],\n");//-- 城市名称
            sbStr.append("	[PartherRegionsID],\n");//-- 上级城市编号
            sbStr.append("	[Depth]\n");//-- 深度
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 城市编号
            getDPUpdate().AddNewParameter("Regionid",objRegionsInfo.getRegionid()); // 
            sbStr.append("	?,\n");//-- 城市名称
            getDPUpdate().AddNewParameter("Regionname",objRegionsInfo.getRegionname()); // 
            sbStr.append("	?,\n");//-- 上级城市编号
            getDPUpdate().AddNewParameter("Partherregionsid",objRegionsInfo.getPartherregionsid()); // 
            sbStr.append("	?\n");//-- 深度
            getDPUpdate().AddNewParameter("Depth",objRegionsInfo.getDepth()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_regions 郑州市地区表中插入数据,返回RegiondatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param objRegionsInfo RegionsInfo对象 郑州市地区表 
        * @return 字段RegionsID 
        */
        public int Insert(RegionsInfo objRegionsInfo)
        {
            getDPUpdate().ClearParameter();
            int Regiondatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objRegionsInfo)));
            objRegionsInfo.setRegiondatabaseid(Regiondatabaseid);//RegiondatabaseID  数据类型:int
            getDPUpdate().Dispose();
            return Regiondatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByRegiondatabaseidReturnSQL
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 更新表t_regions 郑州市地区表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param objRegionsInfo RegionsInfo对象 郑州市地区表 
        * @return SQL语句 
        */
        public String UpdateByRegiondatabaseidReturnSQL(RegionsInfo objRegionsInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_regions]\n");
            sbStr.append("SET\n");
            sbStr.append("	[RegionID] = ?,\n");//-- 城市编号
            getDPUpdate().AddNewParameter("Regionid",objRegionsInfo.getRegionid()); // 城市编号
            sbStr.append("	[RegionName] = ?,\n");//-- 城市名称
            getDPUpdate().AddNewParameter("Regionname",objRegionsInfo.getRegionname()); // 城市名称
            sbStr.append("	[PartherRegionsID] = ?,\n");//-- 上级城市编号
            getDPUpdate().AddNewParameter("Partherregionsid",objRegionsInfo.getPartherregionsid()); // 上级城市编号
            sbStr.append("	[Depth] = ?\n");//-- 深度
            getDPUpdate().AddNewParameter("Depth",objRegionsInfo.getDepth()); // 深度
            sbStr.append("WHERE\n");
            sbStr.append("	 [RegiondatabaseID] = ?\n");//-- RegiondatabaseID
            getDPUpdate().AddNewParameter("Regiondatabaseid",objRegionsInfo.getRegiondatabaseid() ); // RegiondatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByRegiondatabaseid
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 更新表t_regions 郑州市地区表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param objRegionsInfo RegionsInfo对象 郑州市地区表 
        */
        public void UpdateByRegiondatabaseid(RegionsInfo objRegionsInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByRegiondatabaseidReturnSQL(objRegionsInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByRegiondatabaseidReturnSQL
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 删除数据表t_regions 郑州市地区表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param Regiondatabaseid RegiondatabaseID 
        * @return SQL语句 
        */
        public String DeleteByRegiondatabaseidReturnSQL(int Regiondatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_regions]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [RegiondatabaseID] = ?\n");//-- RegiondatabaseID
            getDPUpdate().AddNewParameter("Regiondatabaseid",Regiondatabaseid ); // RegiondatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByRegiondatabaseid
        /**
        * 根据 <br />
    * RegiondatabaseID Regiondatabaseid RegiondatabaseID<br />
 删除数据表t_regions 郑州市地区表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:30
        * @param Regiondatabaseid RegiondatabaseID 
        */
        public void DeleteByRegiondatabaseid(int Regiondatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByRegiondatabaseidReturnSQL(Regiondatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
