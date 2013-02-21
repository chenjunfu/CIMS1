
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:24:38
   功能说明: 表t_people 人员表的实体类PeopleInfo的数据层基类
   表说明:人员表
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
 * 表 t_people 人员表 的实体PeopleInfo的数据操作类
 * @author 贾军磊
 *
 */
public class PeopleDALBase
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
	public PeopleDALBase()
	{

	}

	public PeopleDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByDatabasepeopleidReturnSQL
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 统计表t_people 人员表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @param Databasepeopleid 人员ID 
        * @return SQL语句 
        */
        public String CountByDatabasepeopleidReturnSQL(int Databasepeopleid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_people]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabasePeopleID] = ?\n");//-- 人员ID
            getDP().AddNewParameter("Databasepeopleid",Databasepeopleid ); // 人员ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByDatabasepeopleid
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 统计表t_people 人员表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @param Databasepeopleid 人员ID 
        * @return 数据量 
        */
        public int CountByDatabasepeopleid(int Databasepeopleid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDatabasepeopleidReturnSQL(Databasepeopleid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_people 人员表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_people]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_people 人员表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
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
 返回表t_people 人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.PeopleInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_people]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[DatabasePeopleID] DESC \n");//人员ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_people 人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @return 数据列表的强类型实体类 
        */
        public PeopleInfoCollection GetListBy(String OrderBy)
        {
            PeopleInfoCollection list = new PeopleInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.PeopleInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new PeopleInfo(rs));
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
 返回表t_people 人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @return 数据列表的强类型实体类 
        */
        public PeopleInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetPeopleInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_people 人员表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_people]\n");
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
                sbStr.append("		[DatabasePeopleID] DESC \n");//人员ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.PeopleInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_people]\n");
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
 返回表t_people 人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @return 数据列表的强类型实体类 
        */
        public PeopleInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            PeopleInfoCollection list = new PeopleInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.PeopleInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new PeopleInfo(rs));
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
 返回表t_people 人员表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @return 数据列表的强类型实体类 
        */
        public PeopleInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_people 人员表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
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
 统计表t_people 人员表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetPeopleInfoByDatabasepeopleidReturnSQL
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 获取表t_people 人员表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @param Databasepeopleid 人员ID 
        * @return SQL语句 
        */
        public String GetListByDatabasepeopleidReturnSQL(int Databasepeopleid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.PeopleInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_people]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabasePeopleID] = ?\n");//-- 人员ID
            getDP().AddNewParameter("Databasepeopleid",Databasepeopleid ); // 人员ID
            return sbStr.toString();
        }
        // [end]
        // [start] GetPeopleInfoByDatabasepeopleid
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 获取表t_people 人员表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @param Databasepeopleid 人员ID 
        * @return PeopleInfo对象实体 
        */
        public PeopleInfo GetPeopleInfoByDatabasepeopleid(int Databasepeopleid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByDatabasepeopleidReturnSQL(Databasepeopleid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                PeopleInfo objPeopleInfo = new PeopleInfo(rs);
                getDP().Dispose();
                return objPeopleInfo;
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
        * 向表t_people 人员表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @param objPeopleInfo PeopleInfo对象 人员表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(PeopleInfo objPeopleInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_people]\n");
            sbStr.append("(\n");
            sbStr.append("	[PeopleID],\n");//-- 人员编号
            sbStr.append("	[PeopleName],\n");//-- 姓名
            sbStr.append("	[DatabasePeoplesectorID],\n");//-- 所属部门
            sbStr.append("	[Sex],\n");//-- 性别：1-男、2-女
            sbStr.append("	[Adress],\n");//-- 办公地址
            sbStr.append("	[Phone],\n");//-- 电话
            sbStr.append("	[CellPhone]\n");//-- CellPhone
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 人员编号
            getDPUpdate().AddNewParameter("Peopleid",objPeopleInfo.getPeopleid()); // 
            sbStr.append("	?,\n");//-- 姓名
            getDPUpdate().AddNewParameter("Peoplename",objPeopleInfo.getPeoplename()); // 
            sbStr.append("	?,\n");//-- 所属部门
            getDPUpdate().AddNewParameter("Databasepeoplesectorid",objPeopleInfo.getDatabasepeoplesectorid()); // 
            sbStr.append("	?,\n");//-- 性别：1-男、2-女
            getDPUpdate().AddNewParameter("Sex",objPeopleInfo.getSex()); // 
            sbStr.append("	?,\n");//-- 办公地址
            getDPUpdate().AddNewParameter("Adress",objPeopleInfo.getAdress()); // 
            sbStr.append("	?,\n");//-- 电话
            getDPUpdate().AddNewParameter("Phone",objPeopleInfo.getPhone()); // 
            sbStr.append("	?\n");//-- CellPhone
            getDPUpdate().AddNewParameter("Cellphone",objPeopleInfo.getCellphone()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_people 人员表中插入数据,返回DatabasePeopleID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @param objPeopleInfo PeopleInfo对象 人员表 
        * @return 字段PeopleID 
        */
        public int Insert(PeopleInfo objPeopleInfo)
        {
            getDPUpdate().ClearParameter();
            int Databasepeopleid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objPeopleInfo)));
            objPeopleInfo.setDatabasepeopleid(Databasepeopleid);//人员ID  数据类型:int
            getDPUpdate().Dispose();
            return Databasepeopleid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByDatabasepeopleidReturnSQL
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 更新表t_people 人员表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @param objPeopleInfo PeopleInfo对象 人员表 
        * @return SQL语句 
        */
        public String UpdateByDatabasepeopleidReturnSQL(PeopleInfo objPeopleInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_people]\n");
            sbStr.append("SET\n");
            sbStr.append("	[PeopleID] = ?,\n");//-- 人员编号
            getDPUpdate().AddNewParameter("Peopleid",objPeopleInfo.getPeopleid()); // 人员编号
            sbStr.append("	[PeopleName] = ?,\n");//-- 姓名
            getDPUpdate().AddNewParameter("Peoplename",objPeopleInfo.getPeoplename()); // 姓名
            sbStr.append("	[DatabasePeoplesectorID] = ?,\n");//-- 所属部门
            getDPUpdate().AddNewParameter("Databasepeoplesectorid",objPeopleInfo.getDatabasepeoplesectorid()); // 所属部门
            sbStr.append("	[Sex] = ?,\n");//-- 性别：1-男、2-女
            getDPUpdate().AddNewParameter("Sex",objPeopleInfo.getSex()); // 性别：1-男、2-女
            sbStr.append("	[Adress] = ?,\n");//-- 办公地址
            getDPUpdate().AddNewParameter("Adress",objPeopleInfo.getAdress()); // 办公地址
            sbStr.append("	[Phone] = ?,\n");//-- 电话
            getDPUpdate().AddNewParameter("Phone",objPeopleInfo.getPhone()); // 电话
            sbStr.append("	[CellPhone] = ?\n");//-- CellPhone
            getDPUpdate().AddNewParameter("Cellphone",objPeopleInfo.getCellphone()); // CellPhone
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabasePeopleID] = ?\n");//-- 人员ID
            getDPUpdate().AddNewParameter("Databasepeopleid",objPeopleInfo.getDatabasepeopleid() ); // 人员ID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByDatabasepeopleid
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 更新表t_people 人员表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @param objPeopleInfo PeopleInfo对象 人员表 
        */
        public void UpdateByDatabasepeopleid(PeopleInfo objPeopleInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByDatabasepeopleidReturnSQL(objPeopleInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByDatabasepeopleidReturnSQL
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 删除数据表t_people 人员表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @param Databasepeopleid 人员ID 
        * @return SQL语句 
        */
        public String DeleteByDatabasepeopleidReturnSQL(int Databasepeopleid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_people]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabasePeopleID] = ?\n");//-- 人员ID
            getDPUpdate().AddNewParameter("Databasepeopleid",Databasepeopleid ); // 人员ID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByDatabasepeopleid
        /**
        * 根据 <br />
    * DatabasePeopleID Databasepeopleid 人员ID<br />
 删除数据表t_people 人员表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:38
        * @param Databasepeopleid 人员ID 
        */
        public void DeleteByDatabasepeopleid(int Databasepeopleid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByDatabasepeopleidReturnSQL(Databasepeopleid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
