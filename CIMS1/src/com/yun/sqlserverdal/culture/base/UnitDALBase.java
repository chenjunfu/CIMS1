
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:27:28
   功能说明: 表t_unit 单位信息的实体类UnitInfo的数据层基类
   表说明:单位信息
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
 * 表 t_unit 单位信息 的实体UnitInfo的数据操作类
 * @author 贾军磊
 *
 */
public class UnitDALBase
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
	public UnitDALBase()
	{

	}

	public UnitDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByDatabaseunitidReturnSQL
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 统计表t_unit 单位信息的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @param Databaseunitid 单位ID 
        * @return SQL语句 
        */
        public String CountByDatabaseunitidReturnSQL(int Databaseunitid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_unit]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseUnitID] = ?\n");//-- 单位ID
            getDP().AddNewParameter("Databaseunitid",Databaseunitid ); // 单位ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByDatabaseunitid
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 统计表t_unit 单位信息的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @param Databaseunitid 单位ID 
        * @return 数据量 
        */
        public int CountByDatabaseunitid(int Databaseunitid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDatabaseunitidReturnSQL(Databaseunitid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_unit 单位信息的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_unit]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_unit 单位信息的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
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
 返回表t_unit 单位信息的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.UnitInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_unit]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[DatabaseUnitID] DESC \n");//单位ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_unit 单位信息的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @return 数据列表的强类型实体类 
        */
        public UnitInfoCollection GetListBy(String OrderBy)
        {
            UnitInfoCollection list = new UnitInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.UnitInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new UnitInfo(rs));
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
 返回表t_unit 单位信息的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @return 数据列表的强类型实体类 
        */
        public UnitInfoCollection GetListBy()
        {
            return GetListBy("UnitID");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetUnitInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_unit 单位信息的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_unit]\n");
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
                sbStr.append("		[DatabaseUnitID] DESC \n");//单位ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.UnitInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_unit]\n");
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
 返回表t_unit 单位信息的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @return 数据列表的强类型实体类 
        */
        public UnitInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            UnitInfoCollection list = new UnitInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.UnitInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new UnitInfo(rs));
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
 返回表t_unit 单位信息的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @return 数据列表的强类型实体类 
        */
        public UnitInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_unit 单位信息的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
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
 统计表t_unit 单位信息的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetUnitInfoByDatabaseunitidReturnSQL
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 获取表t_unit 单位信息的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @param Databaseunitid 单位ID 
        * @return SQL语句 
        */
        public String GetListByDatabaseunitidReturnSQL(int Databaseunitid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.UnitInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_unit]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseUnitID] = ?\n");//-- 单位ID
            getDP().AddNewParameter("Databaseunitid",Databaseunitid ); // 单位ID
            return sbStr.toString();
        }
        // [end]
        // [start] GetUnitInfoByDatabaseunitid
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 获取表t_unit 单位信息的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @param Databaseunitid 单位ID 
        * @return UnitInfo对象实体 
        */
        public UnitInfo GetUnitInfoByDatabaseunitid(int Databaseunitid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByDatabaseunitidReturnSQL(Databaseunitid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                UnitInfo objUnitInfo = new UnitInfo(rs);
                getDP().Dispose();
                return objUnitInfo;
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
        * 向表t_unit 单位信息中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @param objUnitInfo UnitInfo对象 单位信息 
        * @return SQL语句 
        */
        public String InsertReturnSQL(UnitInfo objUnitInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_unit]\n");
            sbStr.append("(\n");
            sbStr.append("	[UnitID],\n");//-- 单位编号
            sbStr.append("	[UnitName],\n");//-- 单位名称
            sbStr.append("	[Adress],\n");//-- 单位地址
            sbStr.append("	[Phone]\n");//-- 联系电话
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 单位编号
            getDPUpdate().AddNewParameter("Unitid",objUnitInfo.getUnitid()); // 
            sbStr.append("	?,\n");//-- 单位名称
            getDPUpdate().AddNewParameter("Unitname",objUnitInfo.getUnitname()); // 
            sbStr.append("	?,\n");//-- 单位地址
            getDPUpdate().AddNewParameter("Adress",objUnitInfo.getAdress()); // 
            sbStr.append("	?\n");//-- 联系电话
            getDPUpdate().AddNewParameter("Phone",objUnitInfo.getPhone()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_unit 单位信息中插入数据,返回DatabaseUnitID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @param objUnitInfo UnitInfo对象 单位信息 
        * @return 字段UnitID 
        */
        public int Insert(UnitInfo objUnitInfo)
        {
            getDPUpdate().ClearParameter();
            int Databaseunitid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objUnitInfo)));
            objUnitInfo.setDatabaseunitid(Databaseunitid);//单位ID  数据类型:int
            getDPUpdate().Dispose();
            return Databaseunitid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByDatabaseunitidReturnSQL
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 更新表t_unit 单位信息中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @param objUnitInfo UnitInfo对象 单位信息 
        * @return SQL语句 
        */
        public String UpdateByDatabaseunitidReturnSQL(UnitInfo objUnitInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_unit]\n");
            sbStr.append("SET\n");
            sbStr.append("	[UnitID] = ?,\n");//-- 单位编号
            getDPUpdate().AddNewParameter("Unitid",objUnitInfo.getUnitid()); // 单位编号
            sbStr.append("	[UnitName] = ?,\n");//-- 单位名称
            getDPUpdate().AddNewParameter("Unitname",objUnitInfo.getUnitname()); // 单位名称
            sbStr.append("	[Adress] = ?,\n");//-- 单位地址
            getDPUpdate().AddNewParameter("Adress",objUnitInfo.getAdress()); // 单位地址
            sbStr.append("	[Phone] = ?\n");//-- 联系电话
            getDPUpdate().AddNewParameter("Phone",objUnitInfo.getPhone()); // 联系电话
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseUnitID] = ?\n");//-- 单位ID
            getDPUpdate().AddNewParameter("Databaseunitid",objUnitInfo.getDatabaseunitid() ); // 单位ID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByDatabaseunitid
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 更新表t_unit 单位信息中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @param objUnitInfo UnitInfo对象 单位信息 
        */
        public void UpdateByDatabaseunitid(UnitInfo objUnitInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByDatabaseunitidReturnSQL(objUnitInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByDatabaseunitidReturnSQL
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 删除数据表t_unit 单位信息中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @param Databaseunitid 单位ID 
        * @return SQL语句 
        */
        public String DeleteByDatabaseunitidReturnSQL(int Databaseunitid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_unit]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseUnitID] = ?\n");//-- 单位ID
            getDPUpdate().AddNewParameter("Databaseunitid",Databaseunitid ); // 单位ID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByDatabaseunitid
        /**
        * 根据 <br />
    * DatabaseUnitID Databaseunitid 单位ID<br />
 删除数据表t_unit 单位信息中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:28
        * @param Databaseunitid 单位ID 
        */
        public void DeleteByDatabaseunitid(int Databaseunitid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByDatabaseunitidReturnSQL(Databaseunitid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
