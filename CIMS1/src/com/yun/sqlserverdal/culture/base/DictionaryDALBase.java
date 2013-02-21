
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:20:15
   功能说明: 表t_dictionary 的实体类DictionaryInfo的数据层基类
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
 * 表 t_dictionary  的实体DictionaryInfo的数据操作类
 * @author 贾军磊
 *
 */
public class DictionaryDALBase
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
	public DictionaryDALBase()
	{

	}

	public DictionaryDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByDictionaryidReturnSQL
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 统计表t_dictionary 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @param Dictionaryid DictionaryId 
        * @return SQL语句 
        */
        public String CountByDictionaryidReturnSQL(int Dictionaryid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_dictionary]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DictionaryId] = ?\n");//-- DictionaryId
            getDP().AddNewParameter("Dictionaryid",Dictionaryid ); // DictionaryId
            return sbStr.toString();
        }
        // [end]
        // [start] CountByDictionaryid
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 统计表t_dictionary 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @param Dictionaryid DictionaryId 
        * @return 数据量 
        */
        public int CountByDictionaryid(int Dictionaryid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDictionaryidReturnSQL(Dictionaryid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_dictionary 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_dictionary]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_dictionary 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
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
 返回表t_dictionary 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.DictionaryInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_dictionary]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[DictionaryId] DESC \n");//DictionaryId
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_dictionary 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @return 数据列表的强类型实体类 
        */
        public DictionaryInfoCollection GetListBy(String OrderBy)
        {
            DictionaryInfoCollection list = new DictionaryInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.DictionaryInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new DictionaryInfo(rs));
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
 返回表t_dictionary 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @return 数据列表的强类型实体类 
        */
        public DictionaryInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetDictionaryInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_dictionary 的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_dictionary]\n");
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
                sbStr.append("		[DictionaryId] DESC \n");//DictionaryId
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.DictionaryInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_dictionary]\n");
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
 返回表t_dictionary 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @return 数据列表的强类型实体类 
        */
        public DictionaryInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            DictionaryInfoCollection list = new DictionaryInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.DictionaryInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new DictionaryInfo(rs));
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
 返回表t_dictionary 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @return 数据列表的强类型实体类 
        */
        public DictionaryInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_dictionary 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
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
 统计表t_dictionary 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetDictionaryInfoByDictionaryidReturnSQL
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 获取表t_dictionary 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @param Dictionaryid DictionaryId 
        * @return SQL语句 
        */
        public String GetListByDictionaryidReturnSQL(int Dictionaryid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.DictionaryInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_dictionary]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DictionaryId] = ?\n");//-- DictionaryId
            getDP().AddNewParameter("Dictionaryid",Dictionaryid ); // DictionaryId
            return sbStr.toString();
        }
        // [end]
        // [start] GetDictionaryInfoByDictionaryid
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 获取表t_dictionary 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @param Dictionaryid DictionaryId 
        * @return DictionaryInfo对象实体 
        */
        public DictionaryInfo GetDictionaryInfoByDictionaryid(int Dictionaryid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByDictionaryidReturnSQL(Dictionaryid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                DictionaryInfo objDictionaryInfo = new DictionaryInfo(rs);
                getDP().Dispose();
                return objDictionaryInfo;
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
        * 向表t_dictionary 中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @param objDictionaryInfo DictionaryInfo对象  
        * @return SQL语句 
        */
        public String InsertReturnSQL(DictionaryInfo objDictionaryInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_dictionary]\n");
            sbStr.append("(\n");
            sbStr.append("	[Name],\n");//-- 显示名称
            sbStr.append("	[TableName],\n");//-- 对应表名
            sbStr.append("	[IsUse]\n");//-- 是否启用
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 显示名称
            getDPUpdate().AddNewParameter("Name",objDictionaryInfo.getName()); // 
            sbStr.append("	?,\n");//-- 对应表名
            getDPUpdate().AddNewParameter("Tablename",objDictionaryInfo.getTablename()); // 
            sbStr.append("	?\n");//-- 是否启用
            getDPUpdate().AddNewParameter("Isuse",objDictionaryInfo.getIsuse()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_dictionary 中插入数据,返回DictionaryId字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @param objDictionaryInfo DictionaryInfo对象  
        * @return 字段DictionaryID 
        */
        public int Insert(DictionaryInfo objDictionaryInfo)
        {
            getDPUpdate().ClearParameter();
            int Dictionaryid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objDictionaryInfo)));
            objDictionaryInfo.setDictionaryid(Dictionaryid);//DictionaryId  数据类型:int
            getDPUpdate().Dispose();
            return Dictionaryid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByDictionaryidReturnSQL
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 更新表t_dictionary 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @param objDictionaryInfo DictionaryInfo对象  
        * @return SQL语句 
        */
        public String UpdateByDictionaryidReturnSQL(DictionaryInfo objDictionaryInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_dictionary]\n");
            sbStr.append("SET\n");
            sbStr.append("	[Name] = ?,\n");//-- 显示名称
            getDPUpdate().AddNewParameter("Name",objDictionaryInfo.getName()); // 显示名称
            sbStr.append("	[TableName] = ?,\n");//-- 对应表名
            getDPUpdate().AddNewParameter("Tablename",objDictionaryInfo.getTablename()); // 对应表名
            sbStr.append("	[IsUse] = ?\n");//-- 是否启用
            getDPUpdate().AddNewParameter("Isuse",objDictionaryInfo.getIsuse()); // 是否启用
            sbStr.append("WHERE\n");
            sbStr.append("	 [DictionaryId] = ?\n");//-- DictionaryId
            getDPUpdate().AddNewParameter("Dictionaryid",objDictionaryInfo.getDictionaryid() ); // DictionaryId
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByDictionaryid
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 更新表t_dictionary 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @param objDictionaryInfo DictionaryInfo对象  
        */
        public void UpdateByDictionaryid(DictionaryInfo objDictionaryInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByDictionaryidReturnSQL(objDictionaryInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByDictionaryidReturnSQL
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 删除数据表t_dictionary 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @param Dictionaryid DictionaryId 
        * @return SQL语句 
        */
        public String DeleteByDictionaryidReturnSQL(int Dictionaryid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_dictionary]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DictionaryId] = ?\n");//-- DictionaryId
            getDPUpdate().AddNewParameter("Dictionaryid",Dictionaryid ); // DictionaryId
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByDictionaryid
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 删除数据表t_dictionary 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:20:15
        * @param Dictionaryid DictionaryId 
        */
        public void DeleteByDictionaryid(int Dictionaryid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByDictionaryidReturnSQL(Dictionaryid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
