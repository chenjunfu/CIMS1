
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:24:10
   功能说明: 表t_nation 民族表的实体类NationInfo的数据层基类
   表说明:民族表
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
 * 表 t_nation 民族表 的实体NationInfo的数据操作类
 * @author 贾军磊
 *
 */
public class NationDALBase
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
	public NationDALBase()
	{

	}

	public NationDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByNationdatabaseidReturnSQL
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 统计表t_nation 民族表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @param Nationdatabaseid NationdatabaseID 
        * @return SQL语句 
        */
        public String CountByNationdatabaseidReturnSQL(int Nationdatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_nation]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [NationdatabaseID] = ?\n");//-- NationdatabaseID
            getDP().AddNewParameter("Nationdatabaseid",Nationdatabaseid ); // NationdatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByNationdatabaseid
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 统计表t_nation 民族表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @param Nationdatabaseid NationdatabaseID 
        * @return 数据量 
        */
        public int CountByNationdatabaseid(int Nationdatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByNationdatabaseidReturnSQL(Nationdatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_nation 民族表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_nation]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_nation 民族表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
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
 返回表t_nation 民族表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.NationInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_nation]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[NationdatabaseID] DESC \n");//NationdatabaseID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_nation 民族表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @return 数据列表的强类型实体类 
        */
        public NationInfoCollection GetListBy(String OrderBy)
        {
            NationInfoCollection list = new NationInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.NationInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new NationInfo(rs));
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
 返回表t_nation 民族表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @return 数据列表的强类型实体类 
        */
        public NationInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetNationInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_nation 民族表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_nation]\n");
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
                sbStr.append("		[NationdatabaseID] DESC \n");//NationdatabaseID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.NationInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_nation]\n");
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
 返回表t_nation 民族表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @return 数据列表的强类型实体类 
        */
        public NationInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            NationInfoCollection list = new NationInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.NationInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new NationInfo(rs));
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
 返回表t_nation 民族表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @return 数据列表的强类型实体类 
        */
        public NationInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_nation 民族表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
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
 统计表t_nation 民族表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetNationInfoByNationdatabaseidReturnSQL
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 获取表t_nation 民族表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @param Nationdatabaseid NationdatabaseID 
        * @return SQL语句 
        */
        public String GetListByNationdatabaseidReturnSQL(int Nationdatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.NationInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_nation]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [NationdatabaseID] = ?\n");//-- NationdatabaseID
            getDP().AddNewParameter("Nationdatabaseid",Nationdatabaseid ); // NationdatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] GetNationInfoByNationdatabaseid
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 获取表t_nation 民族表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @param Nationdatabaseid NationdatabaseID 
        * @return NationInfo对象实体 
        */
        public NationInfo GetNationInfoByNationdatabaseid(int Nationdatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByNationdatabaseidReturnSQL(Nationdatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                NationInfo objNationInfo = new NationInfo(rs);
                getDP().Dispose();
                return objNationInfo;
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
        * 向表t_nation 民族表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @param objNationInfo NationInfo对象 民族表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(NationInfo objNationInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_nation]\n");
            sbStr.append("(\n");
            sbStr.append("	[NationID],\n");//-- 民族编号
            sbStr.append("	[NationName]\n");//-- 民族名称
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 民族编号
            getDPUpdate().AddNewParameter("Nationid",objNationInfo.getNationid()); // 
            sbStr.append("	?\n");//-- 民族名称
            getDPUpdate().AddNewParameter("Nationname",objNationInfo.getNationname()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_nation 民族表中插入数据,返回NationdatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @param objNationInfo NationInfo对象 民族表 
        * @return 字段NationID 
        */
        public int Insert(NationInfo objNationInfo)
        {
            getDPUpdate().ClearParameter();
            int Nationdatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objNationInfo)));
            objNationInfo.setNationdatabaseid(Nationdatabaseid);//NationdatabaseID  数据类型:int
            getDPUpdate().Dispose();
            return Nationdatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByNationdatabaseidReturnSQL
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 更新表t_nation 民族表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @param objNationInfo NationInfo对象 民族表 
        * @return SQL语句 
        */
        public String UpdateByNationdatabaseidReturnSQL(NationInfo objNationInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_nation]\n");
            sbStr.append("SET\n");
            sbStr.append("	[NationID] = ?,\n");//-- 民族编号
            getDPUpdate().AddNewParameter("Nationid",objNationInfo.getNationid()); // 民族编号
            sbStr.append("	[NationName] = ?\n");//-- 民族名称
            getDPUpdate().AddNewParameter("Nationname",objNationInfo.getNationname()); // 民族名称
            sbStr.append("WHERE\n");
            sbStr.append("	 [NationdatabaseID] = ?\n");//-- NationdatabaseID
            getDPUpdate().AddNewParameter("Nationdatabaseid",objNationInfo.getNationdatabaseid() ); // NationdatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByNationdatabaseid
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 更新表t_nation 民族表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @param objNationInfo NationInfo对象 民族表 
        */
        public void UpdateByNationdatabaseid(NationInfo objNationInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByNationdatabaseidReturnSQL(objNationInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByNationdatabaseidReturnSQL
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 删除数据表t_nation 民族表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @param Nationdatabaseid NationdatabaseID 
        * @return SQL语句 
        */
        public String DeleteByNationdatabaseidReturnSQL(int Nationdatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_nation]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [NationdatabaseID] = ?\n");//-- NationdatabaseID
            getDPUpdate().AddNewParameter("Nationdatabaseid",Nationdatabaseid ); // NationdatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByNationdatabaseid
        /**
        * 根据 <br />
    * NationdatabaseID Nationdatabaseid NationdatabaseID<br />
 删除数据表t_nation 民族表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:24:10
        * @param Nationdatabaseid NationdatabaseID 
        */
        public void DeleteByNationdatabaseid(int Nationdatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByNationdatabaseidReturnSQL(Nationdatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
