
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:25:21
   功能说明: 表t_project_quality 项目性质的实体类ProjectQualityInfo的数据层基类
   表说明:项目性质
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
 * 表 t_project_quality 项目性质 的实体ProjectQualityInfo的数据操作类
 * @author 贾军磊
 *
 */
public class ProjectQualityDALBase
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
	public ProjectQualityDALBase()
	{

	}

	public ProjectQualityDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByProqulidatabaseidReturnSQL
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param Proqulidatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String CountByProqulidatabaseidReturnSQL(int Proqulidatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_project_quality]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [proqulidatabaseID] = ?\n");//-- 数据库ID
            getDP().AddNewParameter("Proqulidatabaseid",Proqulidatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByProqulidatabaseid
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param Proqulidatabaseid 数据库ID 
        * @return 数据量 
        */
        public int CountByProqulidatabaseid(int Proqulidatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByProqulidatabaseidReturnSQL(Proqulidatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_project_quality]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
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
        // [start] CountByProquliidReturnSQL
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param Proquliid 项目性质ID 
        * @return SQL语句 
        */
        public String CountByProquliidReturnSQL(int Proquliid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_project_quality]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [proquliID] = ?\n");//-- 项目性质ID
            getDP().AddNewParameter("Proquliid",Proquliid ); // 项目性质ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param Proquliid 项目性质ID 
        * @return 数据量 
        */
        public int CountByProquliid(int Proquliid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByProquliidReturnSQL(Proquliid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.ProjectQualityInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_project_quality]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[proqulidatabaseID] DESC \n");//数据库ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @return 数据列表的强类型实体类 
        */
        public ProjectQualityInfoCollection GetListBy(String OrderBy)
        {
            ProjectQualityInfoCollection list = new ProjectQualityInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.ProjectQualityInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new ProjectQualityInfo(rs));
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
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @return 数据列表的强类型实体类 
        */
        public ProjectQualityInfoCollection GetListBy()
        {
            return GetListBy("proquliID");
        }
        // [end]
        // [start] GetListByProquliidReturnSQL
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param Proquliid 项目性质ID 
        * @return SQL语句 
        */
        public String GetListByProquliidReturnSQL(int Proquliid, String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.ProjectQualityInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_project_quality]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [proquliID] = ?\n");//-- 项目性质ID
            getDP().AddNewParameter("Proquliid",Proquliid ); // 项目性质ID
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[proqulidatabaseID] DESC \n");//数据库ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param Proquliid 项目性质ID 
        * @return 数据列表的强类型实体类 
        */
        public ProjectQualityInfoCollection GetListByProquliid(int Proquliid, String OrderBy)
        {
            ProjectQualityInfoCollection list = new ProjectQualityInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.ProjectQualityInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByProquliidReturnSQL(Proquliid, OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new ProjectQualityInfo(rs));
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
        // [start] GetListByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param Proquliid 项目性质ID 
        * @return 数据列表的强类型实体类 
        */
        public ProjectQualityInfoCollection GetListByProquliid(int Proquliid)
        {
            return GetListByProquliid(Proquliid, "");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetProjectQualityInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_project_quality 项目性质的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_project_quality]\n");
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
                sbStr.append("		[proqulidatabaseID] DESC \n");//数据库ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.ProjectQualityInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_project_quality]\n");
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
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @return 数据列表的强类型实体类 
        */
        public ProjectQualityInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            ProjectQualityInfoCollection list = new ProjectQualityInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.ProjectQualityInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new ProjectQualityInfo(rs));
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
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @return 数据列表的强类型实体类 
        */
        public ProjectQualityInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
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
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]
        // [start] GetProjectQualityInfoByProquliidReturnSQL
        /**
        * 根据 <br />
项目性质ID,proquliID 获取表t_project_quality 项目性质的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param Proquliid 项目性质ID 
        * @return SQL语句 
        */
        public String GetListPagerByProquliidReturnSQL(int Proquliid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_project_quality]\n");
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
                sbStr.append("		[proqulidatabaseID] DESC \n");//数据库ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.ProjectQualityInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_project_quality]\n");
            }

            sbStr.append("WHERE\n");
            sbStr.append("	 [proquliID] = ?\n");//-- 项目性质ID
            getDP().AddNewParameter("Proquliid",Proquliid ); // 项目性质ID

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
        // [start] GetListPagerByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param Proquliid 项目性质ID 
        * @return 数据列表的强类型实体类 
        */
        public ProjectQualityInfoCollection GetListPagerByProquliid(int Proquliid, String OrderBy,int pageIndex, int pageSize)
        {
            ProjectQualityInfoCollection list = new ProjectQualityInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.ProjectQualityInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByProquliidReturnSQL(Proquliid,  OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new ProjectQualityInfo(rs));
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
        // [start] GetListPagerByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 返回表t_project_quality 项目性质的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param Proquliid 项目性质ID 
        * @return 数据列表的强类型实体类 
        */
        public ProjectQualityInfoCollection GetListPagerByProquliid(int Proquliid, int pageIndex, int pageSize)
        {
           return GetListPagerByProquliid(Proquliid, "",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param Proquliid 项目性质ID 
        * @return 数据总量 
        */
        public int GetListPagerByProquliid(int Proquliid, String OrderBy)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByProquliidReturnSQL(Proquliid,  OrderBy, null, 0, 0,true)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] GetListPagerByProquliid
        /**
        * 根据 <br />
    * proquliID Proquliid 项目性质ID<br />
 统计表t_project_quality 项目性质的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param Proquliid 项目性质ID 
        * @return 数据总量 
        */
        public int GetListPagerByProquliid(int Proquliid)
        {
            return GetListPagerByProquliid(Proquliid,  "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetProjectQualityInfoByProqulidatabaseidReturnSQL
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 获取表t_project_quality 项目性质的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param Proqulidatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String GetListByProqulidatabaseidReturnSQL(int Proqulidatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.ProjectQualityInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_project_quality]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [proqulidatabaseID] = ?\n");//-- 数据库ID
            getDP().AddNewParameter("Proqulidatabaseid",Proqulidatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] GetProjectQualityInfoByProqulidatabaseid
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 获取表t_project_quality 项目性质的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param Proqulidatabaseid 数据库ID 
        * @return ProjectQualityInfo对象实体 
        */
        public ProjectQualityInfo GetProjectQualityInfoByProqulidatabaseid(int Proqulidatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByProqulidatabaseidReturnSQL(Proqulidatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                ProjectQualityInfo objProjectQualityInfo = new ProjectQualityInfo(rs);
                getDP().Dispose();
                return objProjectQualityInfo;
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
        * 向表t_project_quality 项目性质中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param objProjectQualityInfo ProjectQualityInfo对象 项目性质 
        * @return SQL语句 
        */
        public String InsertReturnSQL(ProjectQualityInfo objProjectQualityInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_project_quality]\n");
            sbStr.append("(\n");
            sbStr.append("	[proquliID],\n");//-- 项目性质ID
            sbStr.append("	[proquliName]\n");//-- 项目性质Name
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 项目性质ID
            getDPUpdate().AddNewParameter("Proquliid",objProjectQualityInfo.getProquliid()); // 
            sbStr.append("	?\n");//-- 项目性质Name
            getDPUpdate().AddNewParameter("Proquliname",objProjectQualityInfo.getProquliname()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_project_quality 项目性质中插入数据,返回proqulidatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param objProjectQualityInfo ProjectQualityInfo对象 项目性质 
        * @return 字段ProjectQualityID 
        */
        public int Insert(ProjectQualityInfo objProjectQualityInfo)
        {
            getDPUpdate().ClearParameter();
            int Proqulidatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objProjectQualityInfo)));
            objProjectQualityInfo.setProqulidatabaseid(Proqulidatabaseid);//数据库ID  数据类型:int
            getDPUpdate().Dispose();
            return Proqulidatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByProqulidatabaseidReturnSQL
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 更新表t_project_quality 项目性质中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param objProjectQualityInfo ProjectQualityInfo对象 项目性质 
        * @return SQL语句 
        */
        public String UpdateByProqulidatabaseidReturnSQL(ProjectQualityInfo objProjectQualityInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_project_quality]\n");
            sbStr.append("SET\n");
            sbStr.append("	[proquliID] = ?,\n");//-- 项目性质ID
            getDPUpdate().AddNewParameter("Proquliid",objProjectQualityInfo.getProquliid()); // 项目性质ID
            sbStr.append("	[proquliName] = ?\n");//-- 项目性质Name
            getDPUpdate().AddNewParameter("Proquliname",objProjectQualityInfo.getProquliname()); // 项目性质Name
            sbStr.append("WHERE\n");
            sbStr.append("	 [proqulidatabaseID] = ?\n");//-- 数据库ID
            getDPUpdate().AddNewParameter("Proqulidatabaseid",objProjectQualityInfo.getProqulidatabaseid() ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByProqulidatabaseid
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 更新表t_project_quality 项目性质中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param objProjectQualityInfo ProjectQualityInfo对象 项目性质 
        */
        public void UpdateByProqulidatabaseid(ProjectQualityInfo objProjectQualityInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByProqulidatabaseidReturnSQL(objProjectQualityInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByProqulidatabaseidReturnSQL
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 删除数据表t_project_quality 项目性质中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param Proqulidatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String DeleteByProqulidatabaseidReturnSQL(int Proqulidatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_project_quality]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [proqulidatabaseID] = ?\n");//-- 数据库ID
            getDPUpdate().AddNewParameter("Proqulidatabaseid",Proqulidatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByProqulidatabaseid
        /**
        * 根据 <br />
    * proqulidatabaseID Proqulidatabaseid 数据库ID<br />
 删除数据表t_project_quality 项目性质中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:21
        * @param Proqulidatabaseid 数据库ID 
        */
        public void DeleteByProqulidatabaseid(int Proqulidatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByProqulidatabaseidReturnSQL(Proqulidatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
