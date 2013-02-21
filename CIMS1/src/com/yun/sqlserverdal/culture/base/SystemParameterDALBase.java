
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:26:42
   功能说明: 表t_system_parameter 的实体类SystemParameterInfo的数据层基类
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
 * 表 t_system_parameter  的实体SystemParameterInfo的数据操作类
 * @author 贾军磊
 *
 */
public class SystemParameterDALBase
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
	public SystemParameterDALBase()
	{

	}

	public SystemParameterDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByDatabaseidReturnSQL
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 统计表t_system_parameter 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @param Databaseid DatabaseID 
        * @return SQL语句 
        */
        public String CountByDatabaseidReturnSQL(int Databaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_system_parameter]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseID] = ?\n");//-- DatabaseID
            getDP().AddNewParameter("Databaseid",Databaseid ); // DatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByDatabaseid
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 统计表t_system_parameter 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @param Databaseid DatabaseID 
        * @return 数据量 
        */
        public int CountByDatabaseid(int Databaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDatabaseidReturnSQL(Databaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_system_parameter 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_system_parameter]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_parameter 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
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
 返回表t_system_parameter 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.SystemParameterInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_system_parameter]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[DatabaseID] DESC \n");//DatabaseID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_parameter 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @return 数据列表的强类型实体类 
        */
        public SystemParameterInfoCollection GetListBy(String OrderBy)
        {
            SystemParameterInfoCollection list = new SystemParameterInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.SystemParameterInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new SystemParameterInfo(rs));
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
 返回表t_system_parameter 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @return 数据列表的强类型实体类 
        */
        public SystemParameterInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetSystemParameterInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_system_parameter 的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_system_parameter]\n");
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
                sbStr.append("		[DatabaseID] DESC \n");//DatabaseID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.SystemParameterInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_system_parameter]\n");
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
 返回表t_system_parameter 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @return 数据列表的强类型实体类 
        */
        public SystemParameterInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            SystemParameterInfoCollection list = new SystemParameterInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.SystemParameterInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new SystemParameterInfo(rs));
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
 返回表t_system_parameter 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @return 数据列表的强类型实体类 
        */
        public SystemParameterInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_parameter 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
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
 统计表t_system_parameter 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetSystemParameterInfoByDatabaseidReturnSQL
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 获取表t_system_parameter 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @param Databaseid DatabaseID 
        * @return SQL语句 
        */
        public String GetListByDatabaseidReturnSQL(int Databaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.SystemParameterInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_system_parameter]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseID] = ?\n");//-- DatabaseID
            getDP().AddNewParameter("Databaseid",Databaseid ); // DatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] GetSystemParameterInfoByDatabaseid
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 获取表t_system_parameter 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @param Databaseid DatabaseID 
        * @return SystemParameterInfo对象实体 
        */
        public SystemParameterInfo GetSystemParameterInfoByDatabaseid(int Databaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByDatabaseidReturnSQL(Databaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                SystemParameterInfo objSystemParameterInfo = new SystemParameterInfo(rs);
                getDP().Dispose();
                return objSystemParameterInfo;
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
        * 向表t_system_parameter 中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @param objSystemParameterInfo SystemParameterInfo对象  
        * @return SQL语句 
        */
        public String InsertReturnSQL(SystemParameterInfo objSystemParameterInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_system_parameter]\n");
            sbStr.append("(\n");
            sbStr.append("	[UnitName],\n");//-- UnitName
            sbStr.append("	[Dept],\n");//-- Dept
            sbStr.append("	[Address]\n");//-- Address
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- UnitName
            getDPUpdate().AddNewParameter("Unitname",objSystemParameterInfo.getUnitname()); // 
            sbStr.append("	?,\n");//-- Dept
            getDPUpdate().AddNewParameter("Dept",objSystemParameterInfo.getDept()); // 
            sbStr.append("	?\n");//-- Address
            getDPUpdate().AddNewParameter("Address",objSystemParameterInfo.getAddress()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_system_parameter 中插入数据,返回DatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @param objSystemParameterInfo SystemParameterInfo对象  
        * @return 字段SystemParameterID 
        */
        public int Insert(SystemParameterInfo objSystemParameterInfo)
        {
            getDPUpdate().ClearParameter();
            int Databaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objSystemParameterInfo)));
            objSystemParameterInfo.setDatabaseid(Databaseid);//DatabaseID  数据类型:int
            getDPUpdate().Dispose();
            return Databaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByDatabaseidReturnSQL
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 更新表t_system_parameter 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @param objSystemParameterInfo SystemParameterInfo对象  
        * @return SQL语句 
        */
        public String UpdateByDatabaseidReturnSQL(SystemParameterInfo objSystemParameterInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_system_parameter]\n");
            sbStr.append("SET\n");
            sbStr.append("	[UnitName] = ?,\n");//-- UnitName
            getDPUpdate().AddNewParameter("Unitname",objSystemParameterInfo.getUnitname()); // UnitName
            sbStr.append("	[Dept] = ?,\n");//-- Dept
            getDPUpdate().AddNewParameter("Dept",objSystemParameterInfo.getDept()); // Dept
            sbStr.append("	[Address] = ?\n");//-- Address
            getDPUpdate().AddNewParameter("Address",objSystemParameterInfo.getAddress()); // Address
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseID] = ?\n");//-- DatabaseID
            getDPUpdate().AddNewParameter("Databaseid",objSystemParameterInfo.getDatabaseid() ); // DatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByDatabaseid
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 更新表t_system_parameter 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @param objSystemParameterInfo SystemParameterInfo对象  
        */
        public void UpdateByDatabaseid(SystemParameterInfo objSystemParameterInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByDatabaseidReturnSQL(objSystemParameterInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByDatabaseidReturnSQL
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 删除数据表t_system_parameter 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @param Databaseid DatabaseID 
        * @return SQL语句 
        */
        public String DeleteByDatabaseidReturnSQL(int Databaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_system_parameter]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseID] = ?\n");//-- DatabaseID
            getDPUpdate().AddNewParameter("Databaseid",Databaseid ); // DatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByDatabaseid
        /**
        * 根据 <br />
    * DatabaseID Databaseid DatabaseID<br />
 删除数据表t_system_parameter 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:26:42
        * @param Databaseid DatabaseID 
        */
        public void DeleteByDatabaseid(int Databaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByDatabaseidReturnSQL(Databaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
