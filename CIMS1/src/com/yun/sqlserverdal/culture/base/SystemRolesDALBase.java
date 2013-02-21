
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月12日 14:18:49
   功能说明: 表t_system_roles 角色表的实体类SystemRolesInfo的数据层基类
   表说明:角色表
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
 * 表 t_system_roles 角色表 的实体SystemRolesInfo的数据操作类
 * @author 贾军磊
 *
 */
public class SystemRolesDALBase
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
	public SystemRolesDALBase()
	{

	}

	public SystemRolesDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByDatabaserolesidReturnSQL
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 统计表t_system_roles 角色表的数据量<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @param Databaserolesid DatabaseRolesID 
        * @return SQL语句 
        */
        public String CountByDatabaserolesidReturnSQL(int Databaserolesid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_system_roles]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseRolesID] = ?\n");//-- DatabaseRolesID
            getDP().AddNewParameter("Databaserolesid",Databaserolesid ); // DatabaseRolesID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByDatabaserolesid
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 统计表t_system_roles 角色表的数据量<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @param Databaserolesid DatabaseRolesID 
        * @return 数据量 
        */
        public int CountByDatabaserolesid(int Databaserolesid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDatabaserolesidReturnSQL(Databaserolesid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_system_roles 角色表的数据量<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_system_roles]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_roles 角色表的数据量<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
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
 返回表t_system_roles 角色表的数据列表<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.SystemRolesInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_system_roles]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[DatabaseRolesID] DESC \n");//DatabaseRolesID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_roles 角色表的数据列表<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @return 数据列表的强类型实体类 
        */
        public SystemRolesInfoCollection GetListBy(String OrderBy)
        {
            SystemRolesInfoCollection list = new SystemRolesInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.SystemRolesInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new SystemRolesInfo(rs));
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
 返回表t_system_roles 角色表的数据列表<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @return 数据列表的强类型实体类 
        */
        public SystemRolesInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetSystemRolesInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_system_roles 角色表的SQL语句
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_system_roles]\n");
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
                sbStr.append("		[DatabaseRolesID] DESC \n");//DatabaseRolesID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.SystemRolesInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_system_roles]\n");
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
 返回表t_system_roles 角色表的数据列表<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @return 数据列表的强类型实体类 
        */
        public SystemRolesInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            SystemRolesInfoCollection list = new SystemRolesInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.SystemRolesInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new SystemRolesInfo(rs));
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
 返回表t_system_roles 角色表的数据列表<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @return 数据列表的强类型实体类 
        */
        public SystemRolesInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_roles 角色表的数据量<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
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
 统计表t_system_roles 角色表的数据量<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetSystemRolesInfoByDatabaserolesidReturnSQL
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 获取表t_system_roles 角色表的对象<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @param Databaserolesid DatabaseRolesID 
        * @return SQL语句 
        */
        public String GetListByDatabaserolesidReturnSQL(int Databaserolesid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.SystemRolesInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_system_roles]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseRolesID] = ?\n");//-- DatabaseRolesID
            getDP().AddNewParameter("Databaserolesid",Databaserolesid ); // DatabaseRolesID
            return sbStr.toString();
        }
        // [end]
        // [start] GetSystemRolesInfoByDatabaserolesid
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 获取表t_system_roles 角色表的对象<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @param Databaserolesid DatabaseRolesID 
        * @return SystemRolesInfo对象实体 
        */
        public SystemRolesInfo GetSystemRolesInfoByDatabaserolesid(int Databaserolesid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByDatabaserolesidReturnSQL(Databaserolesid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                SystemRolesInfo objSystemRolesInfo = new SystemRolesInfo(rs);
                getDP().Dispose();
                return objSystemRolesInfo;
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
        * 向表t_system_roles 角色表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @param objSystemRolesInfo SystemRolesInfo对象 角色表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(SystemRolesInfo objSystemRolesInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_system_roles]\n");
            sbStr.append("(\n");
            sbStr.append("	[RolesID],\n");//-- 角色编号
            sbStr.append("	[RolesName],\n");//-- 角色名称
            sbStr.append("	[Description],\n");//-- 描述
            sbStr.append("	[Is_Use],\n");//-- 启用标志：1-启用、2-未启用
            sbStr.append("	[CompetenceID]\n");//-- 权限编号
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 角色编号
            getDPUpdate().AddNewParameter("Rolesid",objSystemRolesInfo.getRolesid()); // 
            sbStr.append("	?,\n");//-- 角色名称
            getDPUpdate().AddNewParameter("Rolesname",objSystemRolesInfo.getRolesname()); // 
            sbStr.append("	?,\n");//-- 描述
            getDPUpdate().AddNewParameter("Description",objSystemRolesInfo.getDescription()); // 
            sbStr.append("	?,\n");//-- 启用标志：1-启用、2-未启用
            getDPUpdate().AddNewParameter("IsUse",objSystemRolesInfo.getIsUse()); // 
            sbStr.append("	?\n");//-- 权限编号
            getDPUpdate().AddNewParameter("Competenceid",objSystemRolesInfo.getCompetenceid()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_system_roles 角色表中插入数据,返回DatabaseRolesID字段内容<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @param objSystemRolesInfo SystemRolesInfo对象 角色表 
        * @return 字段SystemRolesID 
        */
        public int Insert(SystemRolesInfo objSystemRolesInfo)
        {
            getDPUpdate().ClearParameter();
            int Databaserolesid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objSystemRolesInfo)));
            objSystemRolesInfo.setDatabaserolesid(Databaserolesid);//DatabaseRolesID  数据类型:int
            getDPUpdate().Dispose();
            return Databaserolesid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByDatabaserolesidReturnSQL
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 更新表t_system_roles 角色表中的内容<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @param objSystemRolesInfo SystemRolesInfo对象 角色表 
        * @return SQL语句 
        */
        public String UpdateByDatabaserolesidReturnSQL(SystemRolesInfo objSystemRolesInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_system_roles]\n");
            sbStr.append("SET\n");
            sbStr.append("	[RolesID] = ?,\n");//-- 角色编号
            getDPUpdate().AddNewParameter("Rolesid",objSystemRolesInfo.getRolesid()); // 角色编号
            sbStr.append("	[RolesName] = ?,\n");//-- 角色名称
            getDPUpdate().AddNewParameter("Rolesname",objSystemRolesInfo.getRolesname()); // 角色名称
            sbStr.append("	[Description] = ?,\n");//-- 描述
            getDPUpdate().AddNewParameter("Description",objSystemRolesInfo.getDescription()); // 描述
            sbStr.append("	[Is_Use] = ?,\n");//-- 启用标志：1-启用、2-未启用
            getDPUpdate().AddNewParameter("IsUse",objSystemRolesInfo.getIsUse()); // 启用标志：1-启用、2-未启用
            sbStr.append("	[CompetenceID] = ?\n");//-- 权限编号
            getDPUpdate().AddNewParameter("Competenceid",objSystemRolesInfo.getCompetenceid()); // 权限编号
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseRolesID] = ?\n");//-- DatabaseRolesID
            getDPUpdate().AddNewParameter("Databaserolesid",objSystemRolesInfo.getDatabaserolesid() ); // DatabaseRolesID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByDatabaserolesid
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 更新表t_system_roles 角色表中的内容<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @param objSystemRolesInfo SystemRolesInfo对象 角色表 
        */
        public void UpdateByDatabaserolesid(SystemRolesInfo objSystemRolesInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByDatabaserolesidReturnSQL(objSystemRolesInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByDatabaserolesidReturnSQL
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 删除数据表t_system_roles 角色表中的内容<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @param Databaserolesid DatabaseRolesID 
        * @return SQL语句 
        */
        public String DeleteByDatabaserolesidReturnSQL(int Databaserolesid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_system_roles]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseRolesID] = ?\n");//-- DatabaseRolesID
            getDPUpdate().AddNewParameter("Databaserolesid",Databaserolesid ); // DatabaseRolesID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByDatabaserolesid
        /**
        * 根据 <br />
    * DatabaseRolesID Databaserolesid DatabaseRolesID<br />
 删除数据表t_system_roles 角色表中的内容<br />
        * 开发者 贾军磊 2012年12月12日 14:18:49
        * @param Databaserolesid DatabaseRolesID 
        */
        public void DeleteByDatabaserolesid(int Databaserolesid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByDatabaserolesidReturnSQL(Databaserolesid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
