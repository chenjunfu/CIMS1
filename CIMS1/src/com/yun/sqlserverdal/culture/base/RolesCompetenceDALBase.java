
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:25:39
   功能说明: 表t_roles_competence 角色权限表的实体类RolesCompetenceInfo的数据层基类
   表说明:角色权限表
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
 * 表 t_roles_competence 角色权限表 的实体RolesCompetenceInfo的数据操作类
 * @author 贾军磊
 *
 */
public class RolesCompetenceDALBase
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
	public RolesCompetenceDALBase()
	{

	}

	public RolesCompetenceDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByDatabaserosecompetenceidReturnSQL
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 统计表t_roles_competence 角色权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @param Databaserosecompetenceid 角色权限ID 
        * @return SQL语句 
        */
        public String CountByDatabaserosecompetenceidReturnSQL(int Databaserosecompetenceid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_roles_competence]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseRoseCompetenceID] = ?\n");//-- 角色权限ID
            getDP().AddNewParameter("Databaserosecompetenceid",Databaserosecompetenceid ); // 角色权限ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByDatabaserosecompetenceid
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 统计表t_roles_competence 角色权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @param Databaserosecompetenceid 角色权限ID 
        * @return 数据量 
        */
        public int CountByDatabaserosecompetenceid(int Databaserosecompetenceid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDatabaserosecompetenceidReturnSQL(Databaserosecompetenceid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_roles_competence 角色权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_roles_competence]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_roles_competence 角色权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
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
 返回表t_roles_competence 角色权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.RolesCompetenceInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_roles_competence]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[DatabaseRoseCompetenceID] DESC \n");//角色权限ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_roles_competence 角色权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @return 数据列表的强类型实体类 
        */
        public RolesCompetenceInfoCollection GetListBy(String OrderBy)
        {
            RolesCompetenceInfoCollection list = new RolesCompetenceInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.RolesCompetenceInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new RolesCompetenceInfo(rs));
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
 返回表t_roles_competence 角色权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @return 数据列表的强类型实体类 
        */
        public RolesCompetenceInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetRolesCompetenceInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_roles_competence 角色权限表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_roles_competence]\n");
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
                sbStr.append("		[DatabaseRoseCompetenceID] DESC \n");//角色权限ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.RolesCompetenceInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_roles_competence]\n");
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
 返回表t_roles_competence 角色权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @return 数据列表的强类型实体类 
        */
        public RolesCompetenceInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            RolesCompetenceInfoCollection list = new RolesCompetenceInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.RolesCompetenceInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new RolesCompetenceInfo(rs));
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
 返回表t_roles_competence 角色权限表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @return 数据列表的强类型实体类 
        */
        public RolesCompetenceInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_roles_competence 角色权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
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
 统计表t_roles_competence 角色权限表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetRolesCompetenceInfoByDatabaserosecompetenceidReturnSQL
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 获取表t_roles_competence 角色权限表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @param Databaserosecompetenceid 角色权限ID 
        * @return SQL语句 
        */
        public String GetListByDatabaserosecompetenceidReturnSQL(int Databaserosecompetenceid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.RolesCompetenceInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_roles_competence]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseRoseCompetenceID] = ?\n");//-- 角色权限ID
            getDP().AddNewParameter("Databaserosecompetenceid",Databaserosecompetenceid ); // 角色权限ID
            return sbStr.toString();
        }
        // [end]
        // [start] GetRolesCompetenceInfoByDatabaserosecompetenceid
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 获取表t_roles_competence 角色权限表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @param Databaserosecompetenceid 角色权限ID 
        * @return RolesCompetenceInfo对象实体 
        */
        public RolesCompetenceInfo GetRolesCompetenceInfoByDatabaserosecompetenceid(int Databaserosecompetenceid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByDatabaserosecompetenceidReturnSQL(Databaserosecompetenceid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                RolesCompetenceInfo objRolesCompetenceInfo = new RolesCompetenceInfo(rs);
                getDP().Dispose();
                return objRolesCompetenceInfo;
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
        * 向表t_roles_competence 角色权限表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @param objRolesCompetenceInfo RolesCompetenceInfo对象 角色权限表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(RolesCompetenceInfo objRolesCompetenceInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_roles_competence]\n");
            sbStr.append("(\n");
            sbStr.append("	[RolesID],\n");//-- 角色ID
            sbStr.append("	[CompetenceID]\n");//-- 权限编号
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 角色ID
            getDPUpdate().AddNewParameter("Rolesid",objRolesCompetenceInfo.getRolesid()); // 
            sbStr.append("	?\n");//-- 权限编号
            getDPUpdate().AddNewParameter("Competenceid",objRolesCompetenceInfo.getCompetenceid()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_roles_competence 角色权限表中插入数据,返回DatabaseRoseCompetenceID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @param objRolesCompetenceInfo RolesCompetenceInfo对象 角色权限表 
        * @return 字段RolesCompetenceID 
        */
        public int Insert(RolesCompetenceInfo objRolesCompetenceInfo)
        {
            getDPUpdate().ClearParameter();
            int Databaserosecompetenceid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objRolesCompetenceInfo)));
            objRolesCompetenceInfo.setDatabaserosecompetenceid(Databaserosecompetenceid);//角色权限ID  数据类型:int
            getDPUpdate().Dispose();
            return Databaserosecompetenceid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByDatabaserosecompetenceidReturnSQL
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 更新表t_roles_competence 角色权限表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @param objRolesCompetenceInfo RolesCompetenceInfo对象 角色权限表 
        * @return SQL语句 
        */
        public String UpdateByDatabaserosecompetenceidReturnSQL(RolesCompetenceInfo objRolesCompetenceInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_roles_competence]\n");
            sbStr.append("SET\n");
            sbStr.append("	[RolesID] = ?,\n");//-- 角色ID
            getDPUpdate().AddNewParameter("Rolesid",objRolesCompetenceInfo.getRolesid()); // 角色ID
            sbStr.append("	[CompetenceID] = ?\n");//-- 权限编号
            getDPUpdate().AddNewParameter("Competenceid",objRolesCompetenceInfo.getCompetenceid()); // 权限编号
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseRoseCompetenceID] = ?\n");//-- 角色权限ID
            getDPUpdate().AddNewParameter("Databaserosecompetenceid",objRolesCompetenceInfo.getDatabaserosecompetenceid() ); // 角色权限ID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByDatabaserosecompetenceid
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 更新表t_roles_competence 角色权限表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @param objRolesCompetenceInfo RolesCompetenceInfo对象 角色权限表 
        */
        public void UpdateByDatabaserosecompetenceid(RolesCompetenceInfo objRolesCompetenceInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByDatabaserosecompetenceidReturnSQL(objRolesCompetenceInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByDatabaserosecompetenceidReturnSQL
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 删除数据表t_roles_competence 角色权限表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @param Databaserosecompetenceid 角色权限ID 
        * @return SQL语句 
        */
        public String DeleteByDatabaserosecompetenceidReturnSQL(int Databaserosecompetenceid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_roles_competence]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseRoseCompetenceID] = ?\n");//-- 角色权限ID
            getDPUpdate().AddNewParameter("Databaserosecompetenceid",Databaserosecompetenceid ); // 角色权限ID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByDatabaserosecompetenceid
        /**
        * 根据 <br />
    * DatabaseRoseCompetenceID Databaserosecompetenceid 角色权限ID<br />
 删除数据表t_roles_competence 角色权限表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:39
        * @param Databaserosecompetenceid 角色权限ID 
        */
        public void DeleteByDatabaserosecompetenceid(int Databaserosecompetenceid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByDatabaserosecompetenceidReturnSQL(Databaserosecompetenceid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
