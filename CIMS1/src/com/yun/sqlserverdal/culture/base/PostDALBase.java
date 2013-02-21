
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:24:58
   功能说明: 表t_post 职称表的实体类PostInfo的数据层基类
   表说明:职称表
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
 * 表 t_post 职称表 的实体PostInfo的数据操作类
 * @author 贾军磊
 *
 */
public class PostDALBase
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
	public PostDALBase()
	{

	}

	public PostDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByTitledatabaseidReturnSQL
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param Titledatabaseid TitledatabaseID 
        * @return SQL语句 
        */
        public String CountByTitledatabaseidReturnSQL(int Titledatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_post]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [TitledatabaseID] = ?\n");//-- TitledatabaseID
            getDP().AddNewParameter("Titledatabaseid",Titledatabaseid ); // TitledatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByTitledatabaseid
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param Titledatabaseid TitledatabaseID 
        * @return 数据量 
        */
        public int CountByTitledatabaseid(int Titledatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByTitledatabaseidReturnSQL(Titledatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_post]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
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
        // [start] CountByTitleidReturnSQL
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param Titleid 职称编号 
        * @return SQL语句 
        */
        public String CountByTitleidReturnSQL(int Titleid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_post]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [TitleID] = ?\n");//-- 职称编号
            getDP().AddNewParameter("Titleid",Titleid ); // 职称编号
            return sbStr.toString();
        }
        // [end]
        // [start] CountByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param Titleid 职称编号 
        * @return 数据量 
        */
        public int CountByTitleid(int Titleid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByTitleidReturnSQL(Titleid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.PostInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_post]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[TitledatabaseID] DESC \n");//TitledatabaseID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @return 数据列表的强类型实体类 
        */
        public PostInfoCollection GetListBy(String OrderBy)
        {
            PostInfoCollection list = new PostInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.PostInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new PostInfo(rs));
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
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @return 数据列表的强类型实体类 
        */
        public PostInfoCollection GetListBy()
        {
            return GetListBy("TitleID");
        }
        // [end]
        // [start] GetListByTitleidReturnSQL
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param Titleid 职称编号 
        * @return SQL语句 
        */
        public String GetListByTitleidReturnSQL(int Titleid, String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.PostInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_post]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [TitleID] = ?\n");//-- 职称编号
            getDP().AddNewParameter("Titleid",Titleid ); // 职称编号
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[TitledatabaseID] DESC \n");//TitledatabaseID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param Titleid 职称编号 
        * @return 数据列表的强类型实体类 
        */
        public PostInfoCollection GetListByTitleid(int Titleid, String OrderBy)
        {
            PostInfoCollection list = new PostInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.PostInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByTitleidReturnSQL(Titleid, OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new PostInfo(rs));
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
        // [start] GetListByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param Titleid 职称编号 
        * @return 数据列表的强类型实体类 
        */
        public PostInfoCollection GetListByTitleid(int Titleid)
        {
            return GetListByTitleid(Titleid, "");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetPostInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_post 职称表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_post]\n");
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
                sbStr.append("		[TitledatabaseID] DESC \n");//TitledatabaseID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.PostInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_post]\n");
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
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @return 数据列表的强类型实体类 
        */
        public PostInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            PostInfoCollection list = new PostInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.PostInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new PostInfo(rs));
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
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @return 数据列表的强类型实体类 
        */
        public PostInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
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
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]
        // [start] GetPostInfoByTitleidReturnSQL
        /**
        * 根据 <br />
职称编号,TitleID 获取表t_post 职称表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param Titleid 职称编号 
        * @return SQL语句 
        */
        public String GetListPagerByTitleidReturnSQL(int Titleid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_post]\n");
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
                sbStr.append("		[TitledatabaseID] DESC \n");//TitledatabaseID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.PostInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_post]\n");
            }

            sbStr.append("WHERE\n");
            sbStr.append("	 [TitleID] = ?\n");//-- 职称编号
            getDP().AddNewParameter("Titleid",Titleid ); // 职称编号

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
        // [start] GetListPagerByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param Titleid 职称编号 
        * @return 数据列表的强类型实体类 
        */
        public PostInfoCollection GetListPagerByTitleid(int Titleid, String OrderBy,int pageIndex, int pageSize)
        {
            PostInfoCollection list = new PostInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.PostInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByTitleidReturnSQL(Titleid,  OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new PostInfo(rs));
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
        // [start] GetListPagerByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param Titleid 职称编号 
        * @return 数据列表的强类型实体类 
        */
        public PostInfoCollection GetListPagerByTitleid(int Titleid, int pageIndex, int pageSize)
        {
           return GetListPagerByTitleid(Titleid, "",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param Titleid 职称编号 
        * @return 数据总量 
        */
        public int GetListPagerByTitleid(int Titleid, String OrderBy)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByTitleidReturnSQL(Titleid,  OrderBy, null, 0, 0,true)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] GetListPagerByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param Titleid 职称编号 
        * @return 数据总量 
        */
        public int GetListPagerByTitleid(int Titleid)
        {
            return GetListPagerByTitleid(Titleid,  "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetPostInfoByTitledatabaseidReturnSQL
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 获取表t_post 职称表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param Titledatabaseid TitledatabaseID 
        * @return SQL语句 
        */
        public String GetListByTitledatabaseidReturnSQL(int Titledatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.PostInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_post]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [TitledatabaseID] = ?\n");//-- TitledatabaseID
            getDP().AddNewParameter("Titledatabaseid",Titledatabaseid ); // TitledatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] GetPostInfoByTitledatabaseid
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 获取表t_post 职称表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param Titledatabaseid TitledatabaseID 
        * @return PostInfo对象实体 
        */
        public PostInfo GetPostInfoByTitledatabaseid(int Titledatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByTitledatabaseidReturnSQL(Titledatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                PostInfo objPostInfo = new PostInfo(rs);
                getDP().Dispose();
                return objPostInfo;
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
        * 向表t_post 职称表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param objPostInfo PostInfo对象 职称表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(PostInfo objPostInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_post]\n");
            sbStr.append("(\n");
            sbStr.append("	[TitleID],\n");//-- 职称编号
            sbStr.append("	[TitleName],\n");//-- 职称名称
            sbStr.append("	[Description],\n");//-- 职称描述
            sbStr.append("	[FartherTitleID],\n");//-- 上级职称编号
            sbStr.append("	[Depth],\n");//-- 深度
            sbStr.append("	[Is_Del]\n");//-- 是否删除：1-未删除、2-已删除
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 职称编号
            getDPUpdate().AddNewParameter("Titleid",objPostInfo.getTitleid()); // 
            sbStr.append("	?,\n");//-- 职称名称
            getDPUpdate().AddNewParameter("Titlename",objPostInfo.getTitlename()); // 
            sbStr.append("	?,\n");//-- 职称描述
            getDPUpdate().AddNewParameter("Description",objPostInfo.getDescription()); // 
            sbStr.append("	?,\n");//-- 上级职称编号
            getDPUpdate().AddNewParameter("Farthertitleid",objPostInfo.getFarthertitleid()); // 
            sbStr.append("	?,\n");//-- 深度
            getDPUpdate().AddNewParameter("Depth",objPostInfo.getDepth()); // 
            sbStr.append("	?\n");//-- 是否删除：1-未删除、2-已删除
            getDPUpdate().AddNewParameter("IsDel",objPostInfo.getIsDel()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_post 职称表中插入数据,返回TitledatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param objPostInfo PostInfo对象 职称表 
        * @return 字段PostID 
        */
        public int Insert(PostInfo objPostInfo)
        {
            getDPUpdate().ClearParameter();
            int Titledatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objPostInfo)));
            objPostInfo.setTitledatabaseid(Titledatabaseid);//TitledatabaseID  数据类型:int
            getDPUpdate().Dispose();
            return Titledatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByTitledatabaseidReturnSQL
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 更新表t_post 职称表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param objPostInfo PostInfo对象 职称表 
        * @return SQL语句 
        */
        public String UpdateByTitledatabaseidReturnSQL(PostInfo objPostInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_post]\n");
            sbStr.append("SET\n");
            sbStr.append("	[TitleID] = ?,\n");//-- 职称编号
            getDPUpdate().AddNewParameter("Titleid",objPostInfo.getTitleid()); // 职称编号
            sbStr.append("	[TitleName] = ?,\n");//-- 职称名称
            getDPUpdate().AddNewParameter("Titlename",objPostInfo.getTitlename()); // 职称名称
            sbStr.append("	[Description] = ?,\n");//-- 职称描述
            getDPUpdate().AddNewParameter("Description",objPostInfo.getDescription()); // 职称描述
            sbStr.append("	[FartherTitleID] = ?,\n");//-- 上级职称编号
            getDPUpdate().AddNewParameter("Farthertitleid",objPostInfo.getFarthertitleid()); // 上级职称编号
            sbStr.append("	[Depth] = ?,\n");//-- 深度
            getDPUpdate().AddNewParameter("Depth",objPostInfo.getDepth()); // 深度
            sbStr.append("	[Is_Del] = ?\n");//-- 是否删除：1-未删除、2-已删除
            getDPUpdate().AddNewParameter("IsDel",objPostInfo.getIsDel()); // 是否删除：1-未删除、2-已删除
            sbStr.append("WHERE\n");
            sbStr.append("	 [TitledatabaseID] = ?\n");//-- TitledatabaseID
            getDPUpdate().AddNewParameter("Titledatabaseid",objPostInfo.getTitledatabaseid() ); // TitledatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByTitledatabaseid
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 更新表t_post 职称表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param objPostInfo PostInfo对象 职称表 
        */
        public void UpdateByTitledatabaseid(PostInfo objPostInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByTitledatabaseidReturnSQL(objPostInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByTitledatabaseidReturnSQL
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 删除数据表t_post 职称表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param Titledatabaseid TitledatabaseID 
        * @return SQL语句 
        */
        public String DeleteByTitledatabaseidReturnSQL(int Titledatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_post]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [TitledatabaseID] = ?\n");//-- TitledatabaseID
            getDPUpdate().AddNewParameter("Titledatabaseid",Titledatabaseid ); // TitledatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByTitledatabaseid
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 删除数据表t_post 职称表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:58
        * @param Titledatabaseid TitledatabaseID 
        */
        public void DeleteByTitledatabaseid(int Titledatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByTitledatabaseidReturnSQL(Titledatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
