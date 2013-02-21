
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:26:29
   功能说明: 表t_system_competence 权限表的实体类SystemCompetenceInfo的数据层基类
   表说明:权限表
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
 * 表 t_system_competence 权限表 的实体SystemCompetenceInfo的数据操作类
 * @author 贾军磊
 *
 */
public class SystemCompetenceDALBase
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
	public SystemCompetenceDALBase()
	{

	}

	public SystemCompetenceDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByDatabasecompetenceidReturnSQL
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 统计表t_system_competence 权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:29
        * @param Databasecompetenceid 权限ID 
        * @return SQL语句 
        */
        public String CountByDatabasecompetenceidReturnSQL(int Databasecompetenceid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_system_competence]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseCompetenceID] = ?\n");//-- 权限ID
            getDP().AddNewParameter("Databasecompetenceid",Databasecompetenceid ); // 权限ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByDatabasecompetenceid
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 统计表t_system_competence 权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:29
        * @param Databasecompetenceid 权限ID 
        * @return 数据量 
        */
        public int CountByDatabasecompetenceid(int Databasecompetenceid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDatabasecompetenceidReturnSQL(Databasecompetenceid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_system_competence 权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:29
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_system_competence]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_competence 权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:29
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

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_system_competence 权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:26:29
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.SystemCompetenceInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_system_competence]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[DatabaseCompetenceID] DESC \n");//权限ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_competence 权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:26:29
        * @return 数据列表的强类型实体类 
        */
        public SystemCompetenceInfoCollection GetListBy(String OrderBy)
        {
            SystemCompetenceInfoCollection list = new SystemCompetenceInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.SystemCompetenceInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new SystemCompetenceInfo(rs));
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
 返回表t_system_competence 权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:26:29
        * @return 数据列表的强类型实体类 
        */
        public SystemCompetenceInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetSystemCompetenceInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_system_competence 权限表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:26:30
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_system_competence]\n");
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
                sbStr.append("		[DatabaseCompetenceID] DESC \n");//权限ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.SystemCompetenceInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_system_competence]\n");
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
 返回表t_system_competence 权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:26:30
        * @return 数据列表的强类型实体类 
        */
        public SystemCompetenceInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            SystemCompetenceInfoCollection list = new SystemCompetenceInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.SystemCompetenceInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new SystemCompetenceInfo(rs));
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
 返回表t_system_competence 权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:26:30
        * @return 数据列表的强类型实体类 
        */
        public SystemCompetenceInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_competence 权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:30
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
 统计表t_system_competence 权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:30
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetSystemCompetenceInfoByDatabasecompetenceidReturnSQL
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 获取表t_system_competence 权限表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:26:30
        * @param Databasecompetenceid 权限ID 
        * @return SQL语句 
        */
        public String GetListByDatabasecompetenceidReturnSQL(int Databasecompetenceid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.SystemCompetenceInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_system_competence]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseCompetenceID] = ?\n");//-- 权限ID
            getDP().AddNewParameter("Databasecompetenceid",Databasecompetenceid ); // 权限ID
            return sbStr.toString();
        }
        // [end]
        // [start] GetSystemCompetenceInfoByDatabasecompetenceid
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 获取表t_system_competence 权限表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:26:30
        * @param Databasecompetenceid 权限ID 
        * @return SystemCompetenceInfo对象实体 
        */
        public SystemCompetenceInfo GetSystemCompetenceInfoByDatabasecompetenceid(int Databasecompetenceid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByDatabasecompetenceidReturnSQL(Databasecompetenceid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                SystemCompetenceInfo objSystemCompetenceInfo = new SystemCompetenceInfo(rs);
                getDP().Dispose();
                return objSystemCompetenceInfo;
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
        * 向表t_system_competence 权限表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:26:30
        * @param objSystemCompetenceInfo SystemCompetenceInfo对象 权限表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(SystemCompetenceInfo objSystemCompetenceInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_system_competence]\n");
            sbStr.append("(\n");
            sbStr.append("	[CompetenceID],\n");//-- 权限编号
            sbStr.append("	[CompetenceName],\n");//-- 权限名称
            sbStr.append("	[Description],\n");//-- 权限描述
            sbStr.append("	[Is_Use]\n");//-- 启用标志：1-启用、2-未启用
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 权限编号
            getDPUpdate().AddNewParameter("Competenceid",objSystemCompetenceInfo.getCompetenceid()); // 
            sbStr.append("	?,\n");//-- 权限名称
            getDPUpdate().AddNewParameter("Competencename",objSystemCompetenceInfo.getCompetencename()); // 
            sbStr.append("	?,\n");//-- 权限描述
            getDPUpdate().AddNewParameter("Description",objSystemCompetenceInfo.getDescription()); // 
            sbStr.append("	?\n");//-- 启用标志：1-启用、2-未启用
            getDPUpdate().AddNewParameter("IsUse",objSystemCompetenceInfo.getIsUse()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_system_competence 权限表中插入数据,返回DatabaseCompetenceID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:26:30
        * @param objSystemCompetenceInfo SystemCompetenceInfo对象 权限表 
        * @return 字段SystemCompetenceID 
        */
        public int Insert(SystemCompetenceInfo objSystemCompetenceInfo)
        {
            getDPUpdate().ClearParameter();
            int Databasecompetenceid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objSystemCompetenceInfo)));
            objSystemCompetenceInfo.setDatabasecompetenceid(Databasecompetenceid);//权限ID  数据类型:int
            getDPUpdate().Dispose();
            return Databasecompetenceid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByDatabasecompetenceidReturnSQL
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 更新表t_system_competence 权限表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:26:30
        * @param objSystemCompetenceInfo SystemCompetenceInfo对象 权限表 
        * @return SQL语句 
        */
        public String UpdateByDatabasecompetenceidReturnSQL(SystemCompetenceInfo objSystemCompetenceInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_system_competence]\n");
            sbStr.append("SET\n");
            sbStr.append("	[CompetenceID] = ?,\n");//-- 权限编号
            getDPUpdate().AddNewParameter("Competenceid",objSystemCompetenceInfo.getCompetenceid()); // 权限编号
            sbStr.append("	[CompetenceName] = ?,\n");//-- 权限名称
            getDPUpdate().AddNewParameter("Competencename",objSystemCompetenceInfo.getCompetencename()); // 权限名称
            sbStr.append("	[Description] = ?,\n");//-- 权限描述
            getDPUpdate().AddNewParameter("Description",objSystemCompetenceInfo.getDescription()); // 权限描述
            sbStr.append("	[Is_Use] = ?\n");//-- 启用标志：1-启用、2-未启用
            getDPUpdate().AddNewParameter("IsUse",objSystemCompetenceInfo.getIsUse()); // 启用标志：1-启用、2-未启用
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseCompetenceID] = ?\n");//-- 权限ID
            getDPUpdate().AddNewParameter("Databasecompetenceid",objSystemCompetenceInfo.getDatabasecompetenceid() ); // 权限ID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByDatabasecompetenceid
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 更新表t_system_competence 权限表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:26:30
        * @param objSystemCompetenceInfo SystemCompetenceInfo对象 权限表 
        */
        public void UpdateByDatabasecompetenceid(SystemCompetenceInfo objSystemCompetenceInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByDatabasecompetenceidReturnSQL(objSystemCompetenceInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByDatabasecompetenceidReturnSQL
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 删除数据表t_system_competence 权限表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:26:30
        * @param Databasecompetenceid 权限ID 
        * @return SQL语句 
        */
        public String DeleteByDatabasecompetenceidReturnSQL(int Databasecompetenceid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_system_competence]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseCompetenceID] = ?\n");//-- 权限ID
            getDPUpdate().AddNewParameter("Databasecompetenceid",Databasecompetenceid ); // 权限ID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByDatabasecompetenceid
        /**
        * 根据 <br />
    * DatabaseCompetenceID Databasecompetenceid 权限ID<br />
 删除数据表t_system_competence 权限表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:26:30
        * @param Databasecompetenceid 权限ID 
        */
        public void DeleteByDatabasecompetenceid(int Databasecompetenceid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByDatabasecompetenceidReturnSQL(Databasecompetenceid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
