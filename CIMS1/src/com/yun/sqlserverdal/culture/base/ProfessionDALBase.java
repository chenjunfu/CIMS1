
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:25:17
   功能说明: 表t_profession 行业类别表的实体类ProfessionInfo的数据层基类
   表说明:行业类别表
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
 * 表 t_profession 行业类别表 的实体ProfessionInfo的数据操作类
 * @author 贾军磊
 *
 */
public class ProfessionDALBase
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
	public ProfessionDALBase()
	{

	}

	public ProfessionDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByBusinessdatabaseidReturnSQL
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 统计表t_profession 行业类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @param Businessdatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String CountByBusinessdatabaseidReturnSQL(int Businessdatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_profession]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [BusinessdatabaseID] = ?\n");//-- 数据库ID
            getDP().AddNewParameter("Businessdatabaseid",Businessdatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByBusinessdatabaseid
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 统计表t_profession 行业类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @param Businessdatabaseid 数据库ID 
        * @return 数据量 
        */
        public int CountByBusinessdatabaseid(int Businessdatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByBusinessdatabaseidReturnSQL(Businessdatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_profession 行业类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_profession]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_profession 行业类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
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
 返回表t_profession 行业类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.ProfessionInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_profession]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[BusinessdatabaseID] DESC \n");//数据库ID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_profession 行业类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @return 数据列表的强类型实体类 
        */
        public ProfessionInfoCollection GetListBy(String OrderBy)
        {
            ProfessionInfoCollection list = new ProfessionInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.ProfessionInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new ProfessionInfo(rs));
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
 返回表t_profession 行业类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @return 数据列表的强类型实体类 
        */
        public ProfessionInfoCollection GetListBy()
        {
            return GetListBy("BusinessTypeID");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetProfessionInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_profession 行业类别表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_profession]\n");
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
                sbStr.append("		[BusinessdatabaseID] DESC \n");//数据库ID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.ProfessionInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_profession]\n");
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
 返回表t_profession 行业类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @return 数据列表的强类型实体类 
        */
        public ProfessionInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            ProfessionInfoCollection list = new ProfessionInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.ProfessionInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new ProfessionInfo(rs));
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
 返回表t_profession 行业类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @return 数据列表的强类型实体类 
        */
        public ProfessionInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_profession 行业类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
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
 统计表t_profession 行业类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetProfessionInfoByBusinessdatabaseidReturnSQL
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 获取表t_profession 行业类别表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @param Businessdatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String GetListByBusinessdatabaseidReturnSQL(int Businessdatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.ProfessionInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_profession]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [BusinessdatabaseID] = ?\n");//-- 数据库ID
            getDP().AddNewParameter("Businessdatabaseid",Businessdatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] GetProfessionInfoByBusinessdatabaseid
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 获取表t_profession 行业类别表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @param Businessdatabaseid 数据库ID 
        * @return ProfessionInfo对象实体 
        */
        public ProfessionInfo GetProfessionInfoByBusinessdatabaseid(int Businessdatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByBusinessdatabaseidReturnSQL(Businessdatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                ProfessionInfo objProfessionInfo = new ProfessionInfo(rs);
                getDP().Dispose();
                return objProfessionInfo;
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
        * 向表t_profession 行业类别表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @param objProfessionInfo ProfessionInfo对象 行业类别表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(ProfessionInfo objProfessionInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_profession]\n");
            sbStr.append("(\n");
            sbStr.append("	[BusinessTypeID],\n");//-- 企业所属行业ID
            sbStr.append("	[BusinessTypeName]\n");//-- 企业行业类型名称
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 企业所属行业ID
            getDPUpdate().AddNewParameter("Businesstypeid",objProfessionInfo.getBusinesstypeid()); // 
            sbStr.append("	?\n");//-- 企业行业类型名称
            getDPUpdate().AddNewParameter("Businesstypename",objProfessionInfo.getBusinesstypename()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_profession 行业类别表中插入数据,返回BusinessdatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @param objProfessionInfo ProfessionInfo对象 行业类别表 
        * @return 字段ProfessionID 
        */
        public int Insert(ProfessionInfo objProfessionInfo)
        {
            getDPUpdate().ClearParameter();
            int Businessdatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objProfessionInfo)));
            objProfessionInfo.setBusinessdatabaseid(Businessdatabaseid);//数据库ID  数据类型:int
            getDPUpdate().Dispose();
            return Businessdatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByBusinessdatabaseidReturnSQL
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 更新表t_profession 行业类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @param objProfessionInfo ProfessionInfo对象 行业类别表 
        * @return SQL语句 
        */
        public String UpdateByBusinessdatabaseidReturnSQL(ProfessionInfo objProfessionInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_profession]\n");
            sbStr.append("SET\n");
            sbStr.append("	[BusinessTypeID] = ?,\n");//-- 企业所属行业ID
            getDPUpdate().AddNewParameter("Businesstypeid",objProfessionInfo.getBusinesstypeid()); // 企业所属行业ID
            sbStr.append("	[BusinessTypeName] = ?\n");//-- 企业行业类型名称
            getDPUpdate().AddNewParameter("Businesstypename",objProfessionInfo.getBusinesstypename()); // 企业行业类型名称
            sbStr.append("WHERE\n");
            sbStr.append("	 [BusinessdatabaseID] = ?\n");//-- 数据库ID
            getDPUpdate().AddNewParameter("Businessdatabaseid",objProfessionInfo.getBusinessdatabaseid() ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByBusinessdatabaseid
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 更新表t_profession 行业类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @param objProfessionInfo ProfessionInfo对象 行业类别表 
        */
        public void UpdateByBusinessdatabaseid(ProfessionInfo objProfessionInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByBusinessdatabaseidReturnSQL(objProfessionInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByBusinessdatabaseidReturnSQL
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 删除数据表t_profession 行业类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @param Businessdatabaseid 数据库ID 
        * @return SQL语句 
        */
        public String DeleteByBusinessdatabaseidReturnSQL(int Businessdatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_profession]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [BusinessdatabaseID] = ?\n");//-- 数据库ID
            getDPUpdate().AddNewParameter("Businessdatabaseid",Businessdatabaseid ); // 数据库ID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByBusinessdatabaseid
        /**
        * 根据 <br />
    * BusinessdatabaseID Businessdatabaseid 数据库ID<br />
 删除数据表t_profession 行业类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:17
        * @param Businessdatabaseid 数据库ID 
        */
        public void DeleteByBusinessdatabaseid(int Businessdatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByBusinessdatabaseidReturnSQL(Businessdatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
