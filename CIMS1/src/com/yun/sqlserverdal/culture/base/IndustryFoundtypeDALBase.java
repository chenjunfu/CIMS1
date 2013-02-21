
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:23:21
   功能说明: 表t_industry_foundtype 资金类别表的实体类IndustryFoundtypeInfo的数据层基类
   表说明:资金类别表
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
 * 表 t_industry_foundtype 资金类别表 的实体IndustryFoundtypeInfo的数据操作类
 * @author 贾军磊
 *
 */
public class IndustryFoundtypeDALBase
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
	public IndustryFoundtypeDALBase()
	{

	}

	public IndustryFoundtypeDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByFundtypeidReturnSQL
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 统计表t_industry_foundtype 资金类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @param Fundtypeid 资金类别编号 
        * @return SQL语句 
        */
        public String CountByFundtypeidReturnSQL(int Fundtypeid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_industry_foundtype]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [FundTypeID] = ?\n");//-- 资金类别编号
            getDP().AddNewParameter("Fundtypeid",Fundtypeid ); // 资金类别编号
            return sbStr.toString();
        }
        // [end]
        // [start] CountByFundtypeid
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 统计表t_industry_foundtype 资金类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @param Fundtypeid 资金类别编号 
        * @return 数据量 
        */
        public int CountByFundtypeid(int Fundtypeid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByFundtypeidReturnSQL(Fundtypeid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_industry_foundtype 资金类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_industry_foundtype]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_industry_foundtype 资金类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
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
 返回表t_industry_foundtype 资金类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.IndustryFoundtypeInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_industry_foundtype]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[FundTypeID] DESC \n");//资金类别编号
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_foundtype 资金类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @return 数据列表的强类型实体类 
        */
        public IndustryFoundtypeInfoCollection GetListBy(String OrderBy)
        {
            IndustryFoundtypeInfoCollection list = new IndustryFoundtypeInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.IndustryFoundtypeInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new IndustryFoundtypeInfo(rs));
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
 返回表t_industry_foundtype 资金类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @return 数据列表的强类型实体类 
        */
        public IndustryFoundtypeInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetIndustryFoundtypeInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_industry_foundtype 资金类别表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_industry_foundtype]\n");
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
                sbStr.append("		[FundTypeID] DESC \n");//资金类别编号
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.IndustryFoundtypeInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_industry_foundtype]\n");
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
 返回表t_industry_foundtype 资金类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @return 数据列表的强类型实体类 
        */
        public IndustryFoundtypeInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            IndustryFoundtypeInfoCollection list = new IndustryFoundtypeInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.IndustryFoundtypeInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new IndustryFoundtypeInfo(rs));
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
 返回表t_industry_foundtype 资金类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @return 数据列表的强类型实体类 
        */
        public IndustryFoundtypeInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_foundtype 资金类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
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
 统计表t_industry_foundtype 资金类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetIndustryFoundtypeInfoByFundtypeidReturnSQL
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 获取表t_industry_foundtype 资金类别表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @param Fundtypeid 资金类别编号 
        * @return SQL语句 
        */
        public String GetListByFundtypeidReturnSQL(int Fundtypeid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.IndustryFoundtypeInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_industry_foundtype]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [FundTypeID] = ?\n");//-- 资金类别编号
            getDP().AddNewParameter("Fundtypeid",Fundtypeid ); // 资金类别编号
            return sbStr.toString();
        }
        // [end]
        // [start] GetIndustryFoundtypeInfoByFundtypeid
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 获取表t_industry_foundtype 资金类别表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @param Fundtypeid 资金类别编号 
        * @return IndustryFoundtypeInfo对象实体 
        */
        public IndustryFoundtypeInfo GetIndustryFoundtypeInfoByFundtypeid(int Fundtypeid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByFundtypeidReturnSQL(Fundtypeid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                IndustryFoundtypeInfo objIndustryFoundtypeInfo = new IndustryFoundtypeInfo(rs);
                getDP().Dispose();
                return objIndustryFoundtypeInfo;
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
        * 向表t_industry_foundtype 资金类别表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @param objIndustryFoundtypeInfo IndustryFoundtypeInfo对象 资金类别表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(IndustryFoundtypeInfo objIndustryFoundtypeInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_industry_foundtype]\n");
            sbStr.append("(\n");
            sbStr.append("	[FundTypeName],\n");//-- 资金类别名
            sbStr.append("	[Description]\n");//-- 描述
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 资金类别名
            getDPUpdate().AddNewParameter("Fundtypename",objIndustryFoundtypeInfo.getFundtypename()); // 
            sbStr.append("	?\n");//-- 描述
            getDPUpdate().AddNewParameter("Description",objIndustryFoundtypeInfo.getDescription()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_industry_foundtype 资金类别表中插入数据,返回FundTypeID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @param objIndustryFoundtypeInfo IndustryFoundtypeInfo对象 资金类别表 
        * @return 字段IndustryFoundtypeID 
        */
        public int Insert(IndustryFoundtypeInfo objIndustryFoundtypeInfo)
        {
            getDPUpdate().ClearParameter();
            int Fundtypeid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objIndustryFoundtypeInfo)));
            objIndustryFoundtypeInfo.setFundtypeid(Fundtypeid);//资金类别编号  数据类型:int
            getDPUpdate().Dispose();
            return Fundtypeid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByFundtypeidReturnSQL
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 更新表t_industry_foundtype 资金类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @param objIndustryFoundtypeInfo IndustryFoundtypeInfo对象 资金类别表 
        * @return SQL语句 
        */
        public String UpdateByFundtypeidReturnSQL(IndustryFoundtypeInfo objIndustryFoundtypeInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_industry_foundtype]\n");
            sbStr.append("SET\n");
            sbStr.append("	[FundTypeName] = ?,\n");//-- 资金类别名
            getDPUpdate().AddNewParameter("Fundtypename",objIndustryFoundtypeInfo.getFundtypename()); // 资金类别名
            sbStr.append("	[Description] = ?\n");//-- 描述
            getDPUpdate().AddNewParameter("Description",objIndustryFoundtypeInfo.getDescription()); // 描述
            sbStr.append("WHERE\n");
            sbStr.append("	 [FundTypeID] = ?\n");//-- 资金类别编号
            getDPUpdate().AddNewParameter("Fundtypeid",objIndustryFoundtypeInfo.getFundtypeid() ); // 资金类别编号
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByFundtypeid
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 更新表t_industry_foundtype 资金类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @param objIndustryFoundtypeInfo IndustryFoundtypeInfo对象 资金类别表 
        */
        public void UpdateByFundtypeid(IndustryFoundtypeInfo objIndustryFoundtypeInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByFundtypeidReturnSQL(objIndustryFoundtypeInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByFundtypeidReturnSQL
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 删除数据表t_industry_foundtype 资金类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @param Fundtypeid 资金类别编号 
        * @return SQL语句 
        */
        public String DeleteByFundtypeidReturnSQL(int Fundtypeid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_industry_foundtype]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [FundTypeID] = ?\n");//-- 资金类别编号
            getDPUpdate().AddNewParameter("Fundtypeid",Fundtypeid ); // 资金类别编号
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByFundtypeid
        /**
        * 根据 <br />
    * FundTypeID Fundtypeid 资金类别编号<br />
 删除数据表t_industry_foundtype 资金类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:21
        * @param Fundtypeid 资金类别编号 
        */
        public void DeleteByFundtypeid(int Fundtypeid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByFundtypeidReturnSQL(Fundtypeid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
