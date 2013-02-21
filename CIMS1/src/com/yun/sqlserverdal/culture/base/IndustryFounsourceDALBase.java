
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:23:33
   功能说明: 表t_industry_founsource 资金来源表的实体类IndustryFounsourceInfo的数据层基类
   表说明:资金来源表
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
 * 表 t_industry_founsource 资金来源表 的实体IndustryFounsourceInfo的数据操作类
 * @author 贾军磊
 *
 */
public class IndustryFounsourceDALBase
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
	public IndustryFounsourceDALBase()
	{

	}

	public IndustryFounsourceDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByFoundsourceidReturnSQL
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 统计表t_industry_founsource 资金来源表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @param Foundsourceid 资金来源编号 
        * @return SQL语句 
        */
        public String CountByFoundsourceidReturnSQL(int Foundsourceid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_industry_founsource]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [FoundSourceID] = ?\n");//-- 资金来源编号
            getDP().AddNewParameter("Foundsourceid",Foundsourceid ); // 资金来源编号
            return sbStr.toString();
        }
        // [end]
        // [start] CountByFoundsourceid
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 统计表t_industry_founsource 资金来源表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @param Foundsourceid 资金来源编号 
        * @return 数据量 
        */
        public int CountByFoundsourceid(int Foundsourceid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByFoundsourceidReturnSQL(Foundsourceid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_industry_founsource 资金来源表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_industry_founsource]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_industry_founsource 资金来源表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
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
 返回表t_industry_founsource 资金来源表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.IndustryFounsourceInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_industry_founsource]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[FoundSourceID] DESC \n");//资金来源编号
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_founsource 资金来源表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @return 数据列表的强类型实体类 
        */
        public IndustryFounsourceInfoCollection GetListBy(String OrderBy)
        {
            IndustryFounsourceInfoCollection list = new IndustryFounsourceInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.IndustryFounsourceInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new IndustryFounsourceInfo(rs));
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
 返回表t_industry_founsource 资金来源表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @return 数据列表的强类型实体类 
        */
        public IndustryFounsourceInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetIndustryFounsourceInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_industry_founsource 资金来源表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_industry_founsource]\n");
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
                sbStr.append("		[FoundSourceID] DESC \n");//资金来源编号
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.IndustryFounsourceInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_industry_founsource]\n");
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
 返回表t_industry_founsource 资金来源表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @return 数据列表的强类型实体类 
        */
        public IndustryFounsourceInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            IndustryFounsourceInfoCollection list = new IndustryFounsourceInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.IndustryFounsourceInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new IndustryFounsourceInfo(rs));
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
 返回表t_industry_founsource 资金来源表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @return 数据列表的强类型实体类 
        */
        public IndustryFounsourceInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_founsource 资金来源表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
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
 统计表t_industry_founsource 资金来源表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetIndustryFounsourceInfoByFoundsourceidReturnSQL
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 获取表t_industry_founsource 资金来源表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @param Foundsourceid 资金来源编号 
        * @return SQL语句 
        */
        public String GetListByFoundsourceidReturnSQL(int Foundsourceid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.IndustryFounsourceInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_industry_founsource]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [FoundSourceID] = ?\n");//-- 资金来源编号
            getDP().AddNewParameter("Foundsourceid",Foundsourceid ); // 资金来源编号
            return sbStr.toString();
        }
        // [end]
        // [start] GetIndustryFounsourceInfoByFoundsourceid
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 获取表t_industry_founsource 资金来源表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @param Foundsourceid 资金来源编号 
        * @return IndustryFounsourceInfo对象实体 
        */
        public IndustryFounsourceInfo GetIndustryFounsourceInfoByFoundsourceid(int Foundsourceid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByFoundsourceidReturnSQL(Foundsourceid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                IndustryFounsourceInfo objIndustryFounsourceInfo = new IndustryFounsourceInfo(rs);
                getDP().Dispose();
                return objIndustryFounsourceInfo;
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
        * 向表t_industry_founsource 资金来源表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @param objIndustryFounsourceInfo IndustryFounsourceInfo对象 资金来源表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(IndustryFounsourceInfo objIndustryFounsourceInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_industry_founsource]\n");
            sbStr.append("(\n");
            sbStr.append("	[FoundSourceName],\n");//-- 资金来源名
            sbStr.append("	[Description]\n");//-- 描述
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 资金来源名
            getDPUpdate().AddNewParameter("Foundsourcename",objIndustryFounsourceInfo.getFoundsourcename()); // 
            sbStr.append("	?\n");//-- 描述
            getDPUpdate().AddNewParameter("Description",objIndustryFounsourceInfo.getDescription()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_industry_founsource 资金来源表中插入数据,返回FoundSourceID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @param objIndustryFounsourceInfo IndustryFounsourceInfo对象 资金来源表 
        * @return 字段IndustryFounsourceID 
        */
        public int Insert(IndustryFounsourceInfo objIndustryFounsourceInfo)
        {
            getDPUpdate().ClearParameter();
            int Foundsourceid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objIndustryFounsourceInfo)));
            objIndustryFounsourceInfo.setFoundsourceid(Foundsourceid);//资金来源编号  数据类型:int
            getDPUpdate().Dispose();
            return Foundsourceid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByFoundsourceidReturnSQL
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 更新表t_industry_founsource 资金来源表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @param objIndustryFounsourceInfo IndustryFounsourceInfo对象 资金来源表 
        * @return SQL语句 
        */
        public String UpdateByFoundsourceidReturnSQL(IndustryFounsourceInfo objIndustryFounsourceInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_industry_founsource]\n");
            sbStr.append("SET\n");
            sbStr.append("	[FoundSourceName] = ?,\n");//-- 资金来源名
            getDPUpdate().AddNewParameter("Foundsourcename",objIndustryFounsourceInfo.getFoundsourcename()); // 资金来源名
            sbStr.append("	[Description] = ?\n");//-- 描述
            getDPUpdate().AddNewParameter("Description",objIndustryFounsourceInfo.getDescription()); // 描述
            sbStr.append("WHERE\n");
            sbStr.append("	 [FoundSourceID] = ?\n");//-- 资金来源编号
            getDPUpdate().AddNewParameter("Foundsourceid",objIndustryFounsourceInfo.getFoundsourceid() ); // 资金来源编号
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByFoundsourceid
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 更新表t_industry_founsource 资金来源表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @param objIndustryFounsourceInfo IndustryFounsourceInfo对象 资金来源表 
        */
        public void UpdateByFoundsourceid(IndustryFounsourceInfo objIndustryFounsourceInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByFoundsourceidReturnSQL(objIndustryFounsourceInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByFoundsourceidReturnSQL
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 删除数据表t_industry_founsource 资金来源表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @param Foundsourceid 资金来源编号 
        * @return SQL语句 
        */
        public String DeleteByFoundsourceidReturnSQL(int Foundsourceid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_industry_founsource]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [FoundSourceID] = ?\n");//-- 资金来源编号
            getDPUpdate().AddNewParameter("Foundsourceid",Foundsourceid ); // 资金来源编号
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByFoundsourceid
        /**
        * 根据 <br />
    * FoundSourceID Foundsourceid 资金来源编号<br />
 删除数据表t_industry_founsource 资金来源表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:33
        * @param Foundsourceid 资金来源编号 
        */
        public void DeleteByFoundsourceid(int Foundsourceid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByFoundsourceidReturnSQL(Foundsourceid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
