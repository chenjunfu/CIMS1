
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:20:23
   功能说明: 表t_education 学历表的实体类EducationInfo的数据层基类
   表说明:学历表
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
 * 表 t_education 学历表 的实体EducationInfo的数据操作类
 * @author 贾军磊
 *
 */
public class EducationDALBase
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
	public EducationDALBase()
	{

	}

	public EducationDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByEducationdatabaseidReturnSQL
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param Educationdatabaseid EducationdatabaseID 
        * @return SQL语句 
        */
        public String CountByEducationdatabaseidReturnSQL(int Educationdatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_education]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [EducationdatabaseID] = ?\n");//-- EducationdatabaseID
            getDP().AddNewParameter("Educationdatabaseid",Educationdatabaseid ); // EducationdatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByEducationdatabaseid
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param Educationdatabaseid EducationdatabaseID 
        * @return 数据量 
        */
        public int CountByEducationdatabaseid(int Educationdatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByEducationdatabaseidReturnSQL(Educationdatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_education]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
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
        // [start] CountByEducationidReturnSQL
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param Educationid 学历编号 
        * @return SQL语句 
        */
        public String CountByEducationidReturnSQL(int Educationid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_education]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [EducationID] = ?\n");//-- 学历编号
            getDP().AddNewParameter("Educationid",Educationid ); // 学历编号
            return sbStr.toString();
        }
        // [end]
        // [start] CountByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param Educationid 学历编号 
        * @return 数据量 
        */
        public int CountByEducationid(int Educationid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByEducationidReturnSQL(Educationid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.EducationInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_education]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[EducationdatabaseID] DESC \n");//EducationdatabaseID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @return 数据列表的强类型实体类 
        */
        public EducationInfoCollection GetListBy(String OrderBy)
        {
            EducationInfoCollection list = new EducationInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.EducationInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new EducationInfo(rs));
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
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @return 数据列表的强类型实体类 
        */
        public EducationInfoCollection GetListBy()
        {
            return GetListBy("EducationID");
        }
        // [end]
        // [start] GetListByEducationidReturnSQL
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param Educationid 学历编号 
        * @return SQL语句 
        */
        public String GetListByEducationidReturnSQL(int Educationid, String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.EducationInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_education]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [EducationID] = ?\n");//-- 学历编号
            getDP().AddNewParameter("Educationid",Educationid ); // 学历编号
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[EducationdatabaseID] DESC \n");//EducationdatabaseID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param Educationid 学历编号 
        * @return 数据列表的强类型实体类 
        */
        public EducationInfoCollection GetListByEducationid(int Educationid, String OrderBy)
        {
            EducationInfoCollection list = new EducationInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.EducationInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByEducationidReturnSQL(Educationid, OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new EducationInfo(rs));
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
        // [start] GetListByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param Educationid 学历编号 
        * @return 数据列表的强类型实体类 
        */
        public EducationInfoCollection GetListByEducationid(int Educationid)
        {
            return GetListByEducationid(Educationid, "");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetEducationInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_education 学历表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_education]\n");
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
                sbStr.append("		[EducationdatabaseID] DESC \n");//EducationdatabaseID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.EducationInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_education]\n");
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
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @return 数据列表的强类型实体类 
        */
        public EducationInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            EducationInfoCollection list = new EducationInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.EducationInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new EducationInfo(rs));
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
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @return 数据列表的强类型实体类 
        */
        public EducationInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
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
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]
        // [start] GetEducationInfoByEducationidReturnSQL
        /**
        * 根据 <br />
学历编号,EducationID 获取表t_education 学历表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param Educationid 学历编号 
        * @return SQL语句 
        */
        public String GetListPagerByEducationidReturnSQL(int Educationid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_education]\n");
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
                sbStr.append("		[EducationdatabaseID] DESC \n");//EducationdatabaseID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.EducationInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_education]\n");
            }

            sbStr.append("WHERE\n");
            sbStr.append("	 [EducationID] = ?\n");//-- 学历编号
            getDP().AddNewParameter("Educationid",Educationid ); // 学历编号

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
        // [start] GetListPagerByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param Educationid 学历编号 
        * @return 数据列表的强类型实体类 
        */
        public EducationInfoCollection GetListPagerByEducationid(int Educationid, String OrderBy,int pageIndex, int pageSize)
        {
            EducationInfoCollection list = new EducationInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.EducationInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByEducationidReturnSQL(Educationid,  OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new EducationInfo(rs));
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
        // [start] GetListPagerByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 返回表t_education 学历表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param Educationid 学历编号 
        * @return 数据列表的强类型实体类 
        */
        public EducationInfoCollection GetListPagerByEducationid(int Educationid, int pageIndex, int pageSize)
        {
           return GetListPagerByEducationid(Educationid, "",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param Educationid 学历编号 
        * @return 数据总量 
        */
        public int GetListPagerByEducationid(int Educationid, String OrderBy)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByEducationidReturnSQL(Educationid,  OrderBy, null, 0, 0,true)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] GetListPagerByEducationid
        /**
        * 根据 <br />
    * EducationID Educationid 学历编号<br />
 统计表t_education 学历表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param Educationid 学历编号 
        * @return 数据总量 
        */
        public int GetListPagerByEducationid(int Educationid)
        {
            return GetListPagerByEducationid(Educationid,  "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetEducationInfoByEducationdatabaseidReturnSQL
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 获取表t_education 学历表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param Educationdatabaseid EducationdatabaseID 
        * @return SQL语句 
        */
        public String GetListByEducationdatabaseidReturnSQL(int Educationdatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.EducationInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_education]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [EducationdatabaseID] = ?\n");//-- EducationdatabaseID
            getDP().AddNewParameter("Educationdatabaseid",Educationdatabaseid ); // EducationdatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] GetEducationInfoByEducationdatabaseid
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 获取表t_education 学历表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param Educationdatabaseid EducationdatabaseID 
        * @return EducationInfo对象实体 
        */
        public EducationInfo GetEducationInfoByEducationdatabaseid(int Educationdatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByEducationdatabaseidReturnSQL(Educationdatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                EducationInfo objEducationInfo = new EducationInfo(rs);
                getDP().Dispose();
                return objEducationInfo;
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
        * 向表t_education 学历表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param objEducationInfo EducationInfo对象 学历表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(EducationInfo objEducationInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_education]\n");
            sbStr.append("(\n");
            sbStr.append("	[EducationID],\n");//-- 学历编号
            sbStr.append("	[EducationName]\n");//-- 学历名称
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 学历编号
            getDPUpdate().AddNewParameter("Educationid",objEducationInfo.getEducationid()); // 
            sbStr.append("	?\n");//-- 学历名称
            getDPUpdate().AddNewParameter("Educationname",objEducationInfo.getEducationname()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_education 学历表中插入数据,返回EducationdatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param objEducationInfo EducationInfo对象 学历表 
        * @return 字段EducationID 
        */
        public int Insert(EducationInfo objEducationInfo)
        {
            getDPUpdate().ClearParameter();
            int Educationdatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objEducationInfo)));
            objEducationInfo.setEducationdatabaseid(Educationdatabaseid);//EducationdatabaseID  数据类型:int
            getDPUpdate().Dispose();
            return Educationdatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByEducationdatabaseidReturnSQL
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 更新表t_education 学历表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param objEducationInfo EducationInfo对象 学历表 
        * @return SQL语句 
        */
        public String UpdateByEducationdatabaseidReturnSQL(EducationInfo objEducationInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_education]\n");
            sbStr.append("SET\n");
            sbStr.append("	[EducationID] = ?,\n");//-- 学历编号
            getDPUpdate().AddNewParameter("Educationid",objEducationInfo.getEducationid()); // 学历编号
            sbStr.append("	[EducationName] = ?\n");//-- 学历名称
            getDPUpdate().AddNewParameter("Educationname",objEducationInfo.getEducationname()); // 学历名称
            sbStr.append("WHERE\n");
            sbStr.append("	 [EducationdatabaseID] = ?\n");//-- EducationdatabaseID
            getDPUpdate().AddNewParameter("Educationdatabaseid",objEducationInfo.getEducationdatabaseid() ); // EducationdatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByEducationdatabaseid
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 更新表t_education 学历表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param objEducationInfo EducationInfo对象 学历表 
        */
        public void UpdateByEducationdatabaseid(EducationInfo objEducationInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByEducationdatabaseidReturnSQL(objEducationInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByEducationdatabaseidReturnSQL
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 删除数据表t_education 学历表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param Educationdatabaseid EducationdatabaseID 
        * @return SQL语句 
        */
        public String DeleteByEducationdatabaseidReturnSQL(int Educationdatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_education]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [EducationdatabaseID] = ?\n");//-- EducationdatabaseID
            getDPUpdate().AddNewParameter("Educationdatabaseid",Educationdatabaseid ); // EducationdatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByEducationdatabaseid
        /**
        * 根据 <br />
    * EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
 删除数据表t_education 学历表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:20:23
        * @param Educationdatabaseid EducationdatabaseID 
        */
        public void DeleteByEducationdatabaseid(int Educationdatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByEducationdatabaseidReturnSQL(Educationdatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
