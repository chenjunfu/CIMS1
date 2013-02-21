
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:24:48
   功能说明: 表t_peoplesector 部门信息表的实体类PeoplesectorInfo的数据层基类
   表说明:部门信息表
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
 * 表 t_peoplesector 部门信息表 的实体PeoplesectorInfo的数据操作类
 * @author 贾军磊
 *
 */
public class PeoplesectorDALBase
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
	public PeoplesectorDALBase()
	{

	}

	public PeoplesectorDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByDatabasepeoplesectoridReturnSQL
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 统计表t_peoplesector 部门信息表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @param Databasepeoplesectorid 部门ID 
        * @return SQL语句 
        */
        public String CountByDatabasepeoplesectoridReturnSQL(int Databasepeoplesectorid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_peoplesector]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabasePeoplesectorID] = ?\n");//-- 部门ID
            getDP().AddNewParameter("Databasepeoplesectorid",Databasepeoplesectorid ); // 部门ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByDatabasepeoplesectorid
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 统计表t_peoplesector 部门信息表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @param Databasepeoplesectorid 部门ID 
        * @return 数据量 
        */
        public int CountByDatabasepeoplesectorid(int Databasepeoplesectorid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDatabasepeoplesectoridReturnSQL(Databasepeoplesectorid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_peoplesector 部门信息表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_peoplesector]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_peoplesector 部门信息表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
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
 返回表t_peoplesector 部门信息表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.PeoplesectorInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_peoplesector]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[DatabasePeoplesectorID] DESC \n");//部门ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_peoplesector 部门信息表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @return 数据列表的强类型实体类 
        */
        public PeoplesectorInfoCollection GetListBy(String OrderBy)
        {
            PeoplesectorInfoCollection list = new PeoplesectorInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.PeoplesectorInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new PeoplesectorInfo(rs));
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
 返回表t_peoplesector 部门信息表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @return 数据列表的强类型实体类 
        */
        public PeoplesectorInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetPeoplesectorInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_peoplesector 部门信息表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_peoplesector]\n");
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
                sbStr.append("		[DatabasePeoplesectorID] DESC \n");//部门ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.PeoplesectorInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_peoplesector]\n");
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
 返回表t_peoplesector 部门信息表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @return 数据列表的强类型实体类 
        */
        public PeoplesectorInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            PeoplesectorInfoCollection list = new PeoplesectorInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.PeoplesectorInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new PeoplesectorInfo(rs));
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
 返回表t_peoplesector 部门信息表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @return 数据列表的强类型实体类 
        */
        public PeoplesectorInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_peoplesector 部门信息表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
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
 统计表t_peoplesector 部门信息表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetPeoplesectorInfoByDatabasepeoplesectoridReturnSQL
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 获取表t_peoplesector 部门信息表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @param Databasepeoplesectorid 部门ID 
        * @return SQL语句 
        */
        public String GetListByDatabasepeoplesectoridReturnSQL(int Databasepeoplesectorid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.PeoplesectorInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_peoplesector]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabasePeoplesectorID] = ?\n");//-- 部门ID
            getDP().AddNewParameter("Databasepeoplesectorid",Databasepeoplesectorid ); // 部门ID
            return sbStr.toString();
        }
        // [end]
        // [start] GetPeoplesectorInfoByDatabasepeoplesectorid
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 获取表t_peoplesector 部门信息表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @param Databasepeoplesectorid 部门ID 
        * @return PeoplesectorInfo对象实体 
        */
        public PeoplesectorInfo GetPeoplesectorInfoByDatabasepeoplesectorid(int Databasepeoplesectorid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByDatabasepeoplesectoridReturnSQL(Databasepeoplesectorid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                PeoplesectorInfo objPeoplesectorInfo = new PeoplesectorInfo(rs);
                getDP().Dispose();
                return objPeoplesectorInfo;
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
        * 向表t_peoplesector 部门信息表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @param objPeoplesectorInfo PeoplesectorInfo对象 部门信息表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(PeoplesectorInfo objPeoplesectorInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_peoplesector]\n");
            sbStr.append("(\n");
            sbStr.append("	[PeopleSectorID],\n");//-- 部门编号
            sbStr.append("	[PeopleSectorName],\n");//-- 部门名称
            sbStr.append("	[Adress],\n");//-- 办公住址
            sbStr.append("	[Phone],\n");//-- 电话
            sbStr.append("	[DatabaseUnitID]\n");//-- 单位编号
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 部门编号
            getDPUpdate().AddNewParameter("Peoplesectorid",objPeoplesectorInfo.getPeoplesectorid()); // 
            sbStr.append("	?,\n");//-- 部门名称
            getDPUpdate().AddNewParameter("Peoplesectorname",objPeoplesectorInfo.getPeoplesectorname()); // 
            sbStr.append("	?,\n");//-- 办公住址
            getDPUpdate().AddNewParameter("Adress",objPeoplesectorInfo.getAdress()); // 
            sbStr.append("	?,\n");//-- 电话
            getDPUpdate().AddNewParameter("Phone",objPeoplesectorInfo.getPhone()); // 
            sbStr.append("	?\n");//-- 单位编号
            getDPUpdate().AddNewParameter("Databaseunitid",objPeoplesectorInfo.getDatabaseunitid()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_peoplesector 部门信息表中插入数据,返回DatabasePeoplesectorID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @param objPeoplesectorInfo PeoplesectorInfo对象 部门信息表 
        * @return 字段PeoplesectorID 
        */
        public int Insert(PeoplesectorInfo objPeoplesectorInfo)
        {
            getDPUpdate().ClearParameter();
            int Databasepeoplesectorid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objPeoplesectorInfo)));
            objPeoplesectorInfo.setDatabasepeoplesectorid(Databasepeoplesectorid);//部门ID  数据类型:int
            getDPUpdate().Dispose();
            return Databasepeoplesectorid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByDatabasepeoplesectoridReturnSQL
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 更新表t_peoplesector 部门信息表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @param objPeoplesectorInfo PeoplesectorInfo对象 部门信息表 
        * @return SQL语句 
        */
        public String UpdateByDatabasepeoplesectoridReturnSQL(PeoplesectorInfo objPeoplesectorInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_peoplesector]\n");
            sbStr.append("SET\n");
            sbStr.append("	[PeopleSectorID] = ?,\n");//-- 部门编号
            getDPUpdate().AddNewParameter("Peoplesectorid",objPeoplesectorInfo.getPeoplesectorid()); // 部门编号
            sbStr.append("	[PeopleSectorName] = ?,\n");//-- 部门名称
            getDPUpdate().AddNewParameter("Peoplesectorname",objPeoplesectorInfo.getPeoplesectorname()); // 部门名称
            sbStr.append("	[Adress] = ?,\n");//-- 办公住址
            getDPUpdate().AddNewParameter("Adress",objPeoplesectorInfo.getAdress()); // 办公住址
            sbStr.append("	[Phone] = ?,\n");//-- 电话
            getDPUpdate().AddNewParameter("Phone",objPeoplesectorInfo.getPhone()); // 电话
            sbStr.append("	[DatabaseUnitID] = ?\n");//-- 单位编号
            getDPUpdate().AddNewParameter("Databaseunitid",objPeoplesectorInfo.getDatabaseunitid()); // 单位编号
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabasePeoplesectorID] = ?\n");//-- 部门ID
            getDPUpdate().AddNewParameter("Databasepeoplesectorid",objPeoplesectorInfo.getDatabasepeoplesectorid() ); // 部门ID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByDatabasepeoplesectorid
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 更新表t_peoplesector 部门信息表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @param objPeoplesectorInfo PeoplesectorInfo对象 部门信息表 
        */
        public void UpdateByDatabasepeoplesectorid(PeoplesectorInfo objPeoplesectorInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByDatabasepeoplesectoridReturnSQL(objPeoplesectorInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByDatabasepeoplesectoridReturnSQL
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 删除数据表t_peoplesector 部门信息表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @param Databasepeoplesectorid 部门ID 
        * @return SQL语句 
        */
        public String DeleteByDatabasepeoplesectoridReturnSQL(int Databasepeoplesectorid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_peoplesector]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabasePeoplesectorID] = ?\n");//-- 部门ID
            getDPUpdate().AddNewParameter("Databasepeoplesectorid",Databasepeoplesectorid ); // 部门ID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByDatabasepeoplesectorid
        /**
        * 根据 <br />
    * DatabasePeoplesectorID Databasepeoplesectorid 部门ID<br />
 删除数据表t_peoplesector 部门信息表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:48
        * @param Databasepeoplesectorid 部门ID 
        */
        public void DeleteByDatabasepeoplesectorid(int Databasepeoplesectorid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByDatabasepeoplesectoridReturnSQL(Databasepeoplesectorid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
