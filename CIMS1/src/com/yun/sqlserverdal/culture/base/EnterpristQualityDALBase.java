
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:21:10
   功能说明: 表t_enterprist_quality 企业性质表的实体类EnterpristQualityInfo的数据层基类
   表说明:企业性质表
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
 * 表 t_enterprist_quality 企业性质表 的实体EnterpristQualityInfo的数据操作类
 * @author 贾军磊
 *
 */
public class EnterpristQualityDALBase
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
	public EnterpristQualityDALBase()
	{

	}

	public EnterpristQualityDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByQualitydatabaseidReturnSQL
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param Qualitydatabaseid 企业性质编号 
        * @return SQL语句 
        */
        public String CountByQualitydatabaseidReturnSQL(int Qualitydatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_enterprist_quality]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [QualitydatabaseID] = ?\n");//-- 企业性质编号
            getDP().AddNewParameter("Qualitydatabaseid",Qualitydatabaseid ); // 企业性质编号
            return sbStr.toString();
        }
        // [end]
        // [start] CountByQualitydatabaseid
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param Qualitydatabaseid 企业性质编号 
        * @return 数据量 
        */
        public int CountByQualitydatabaseid(int Qualitydatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByQualitydatabaseidReturnSQL(Qualitydatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_enterprist_quality]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
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
        // [start] CountByQualityidReturnSQL
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param Qualityid QualityID 
        * @return SQL语句 
        */
        public String CountByQualityidReturnSQL(String Qualityid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_enterprist_quality]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [QualityID] = ?\n");//-- QualityID
            getDP().AddNewParameter("Qualityid",Qualityid ); // QualityID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param Qualityid QualityID 
        * @return 数据量 
        */
        public int CountByQualityid(String Qualityid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByQualityidReturnSQL(Qualityid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.EnterpristQualityInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_enterprist_quality]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[QualitydatabaseID] DESC \n");//企业性质编号
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @return 数据列表的强类型实体类 
        */
        public EnterpristQualityInfoCollection GetListBy(String OrderBy)
        {
            EnterpristQualityInfoCollection list = new EnterpristQualityInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.EnterpristQualityInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new EnterpristQualityInfo(rs));
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
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @return 数据列表的强类型实体类 
        */
        public EnterpristQualityInfoCollection GetListBy()
        {
            return GetListBy("QualityID");
        }
        // [end]
        // [start] GetListByQualityidReturnSQL
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param Qualityid QualityID 
        * @return SQL语句 
        */
        public String GetListByQualityidReturnSQL(String Qualityid, String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.EnterpristQualityInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_enterprist_quality]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [QualityID] = ?\n");//-- QualityID
            getDP().AddNewParameter("Qualityid",Qualityid ); // QualityID
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[QualitydatabaseID] DESC \n");//企业性质编号
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param Qualityid QualityID 
        * @return 数据列表的强类型实体类 
        */
        public EnterpristQualityInfoCollection GetListByQualityid(String Qualityid, String OrderBy)
        {
            EnterpristQualityInfoCollection list = new EnterpristQualityInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.EnterpristQualityInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByQualityidReturnSQL(Qualityid, OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new EnterpristQualityInfo(rs));
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
        // [start] GetListByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param Qualityid QualityID 
        * @return 数据列表的强类型实体类 
        */
        public EnterpristQualityInfoCollection GetListByQualityid(String Qualityid)
        {
            return GetListByQualityid(Qualityid, "");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetEnterpristQualityInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_enterprist_quality 企业性质表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_enterprist_quality]\n");
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
                sbStr.append("		[QualitydatabaseID] DESC \n");//企业性质编号
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.EnterpristQualityInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_enterprist_quality]\n");
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
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @return 数据列表的强类型实体类 
        */
        public EnterpristQualityInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            EnterpristQualityInfoCollection list = new EnterpristQualityInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.EnterpristQualityInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new EnterpristQualityInfo(rs));
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
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @return 数据列表的强类型实体类 
        */
        public EnterpristQualityInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
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
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]
        // [start] GetEnterpristQualityInfoByQualityidReturnSQL
        /**
        * 根据 <br />
QualityID,QualityID 获取表t_enterprist_quality 企业性质表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param Qualityid QualityID 
        * @return SQL语句 
        */
        public String GetListPagerByQualityidReturnSQL(String Qualityid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_enterprist_quality]\n");
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
                sbStr.append("		[QualitydatabaseID] DESC \n");//企业性质编号
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.EnterpristQualityInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_enterprist_quality]\n");
            }

            sbStr.append("WHERE\n");
            sbStr.append("	 [QualityID] = ?\n");//-- QualityID
            getDP().AddNewParameter("Qualityid",Qualityid ); // QualityID

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
        // [start] GetListPagerByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param Qualityid QualityID 
        * @return 数据列表的强类型实体类 
        */
        public EnterpristQualityInfoCollection GetListPagerByQualityid(String Qualityid, String OrderBy,int pageIndex, int pageSize)
        {
            EnterpristQualityInfoCollection list = new EnterpristQualityInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.EnterpristQualityInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByQualityidReturnSQL(Qualityid,  OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new EnterpristQualityInfo(rs));
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
        // [start] GetListPagerByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 返回表t_enterprist_quality 企业性质表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param Qualityid QualityID 
        * @return 数据列表的强类型实体类 
        */
        public EnterpristQualityInfoCollection GetListPagerByQualityid(String Qualityid, int pageIndex, int pageSize)
        {
           return GetListPagerByQualityid(Qualityid, "",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param Qualityid QualityID 
        * @return 数据总量 
        */
        public int GetListPagerByQualityid(String Qualityid, String OrderBy)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByQualityidReturnSQL(Qualityid,  OrderBy, null, 0, 0,true)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] GetListPagerByQualityid
        /**
        * 根据 <br />
    * QualityID Qualityid QualityID<br />
 统计表t_enterprist_quality 企业性质表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param Qualityid QualityID 
        * @return 数据总量 
        */
        public int GetListPagerByQualityid(String Qualityid)
        {
            return GetListPagerByQualityid(Qualityid,  "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetEnterpristQualityInfoByQualitydatabaseidReturnSQL
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 获取表t_enterprist_quality 企业性质表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param Qualitydatabaseid 企业性质编号 
        * @return SQL语句 
        */
        public String GetListByQualitydatabaseidReturnSQL(int Qualitydatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.EnterpristQualityInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_enterprist_quality]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [QualitydatabaseID] = ?\n");//-- 企业性质编号
            getDP().AddNewParameter("Qualitydatabaseid",Qualitydatabaseid ); // 企业性质编号
            return sbStr.toString();
        }
        // [end]
        // [start] GetEnterpristQualityInfoByQualitydatabaseid
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 获取表t_enterprist_quality 企业性质表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param Qualitydatabaseid 企业性质编号 
        * @return EnterpristQualityInfo对象实体 
        */
        public EnterpristQualityInfo GetEnterpristQualityInfoByQualitydatabaseid(int Qualitydatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByQualitydatabaseidReturnSQL(Qualitydatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                EnterpristQualityInfo objEnterpristQualityInfo = new EnterpristQualityInfo(rs);
                getDP().Dispose();
                return objEnterpristQualityInfo;
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
        * 向表t_enterprist_quality 企业性质表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param objEnterpristQualityInfo EnterpristQualityInfo对象 企业性质表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(EnterpristQualityInfo objEnterpristQualityInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_enterprist_quality]\n");
            sbStr.append("(\n");
            sbStr.append("	[QualityID],\n");//-- QualityID
            sbStr.append("	[QualityName]\n");//-- 企业性质名称
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- QualityID
            getDPUpdate().AddNewParameter("Qualityid",objEnterpristQualityInfo.getQualityid()); // 
            sbStr.append("	?\n");//-- 企业性质名称
            getDPUpdate().AddNewParameter("Qualityname",objEnterpristQualityInfo.getQualityname()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_enterprist_quality 企业性质表中插入数据,返回QualitydatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param objEnterpristQualityInfo EnterpristQualityInfo对象 企业性质表 
        * @return 字段EnterpristQualityID 
        */
        public int Insert(EnterpristQualityInfo objEnterpristQualityInfo)
        {
            getDPUpdate().ClearParameter();
            int Qualitydatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objEnterpristQualityInfo)));
            objEnterpristQualityInfo.setQualitydatabaseid(Qualitydatabaseid);//企业性质编号  数据类型:int
            getDPUpdate().Dispose();
            return Qualitydatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByQualitydatabaseidReturnSQL
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 更新表t_enterprist_quality 企业性质表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param objEnterpristQualityInfo EnterpristQualityInfo对象 企业性质表 
        * @return SQL语句 
        */
        public String UpdateByQualitydatabaseidReturnSQL(EnterpristQualityInfo objEnterpristQualityInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_enterprist_quality]\n");
            sbStr.append("SET\n");
            sbStr.append("	[QualityID] = ?,\n");//-- QualityID
            getDPUpdate().AddNewParameter("Qualityid",objEnterpristQualityInfo.getQualityid()); // QualityID
            sbStr.append("	[QualityName] = ?\n");//-- 企业性质名称
            getDPUpdate().AddNewParameter("Qualityname",objEnterpristQualityInfo.getQualityname()); // 企业性质名称
            sbStr.append("WHERE\n");
            sbStr.append("	 [QualitydatabaseID] = ?\n");//-- 企业性质编号
            getDPUpdate().AddNewParameter("Qualitydatabaseid",objEnterpristQualityInfo.getQualitydatabaseid() ); // 企业性质编号
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByQualitydatabaseid
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 更新表t_enterprist_quality 企业性质表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param objEnterpristQualityInfo EnterpristQualityInfo对象 企业性质表 
        */
        public void UpdateByQualitydatabaseid(EnterpristQualityInfo objEnterpristQualityInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByQualitydatabaseidReturnSQL(objEnterpristQualityInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByQualitydatabaseidReturnSQL
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 删除数据表t_enterprist_quality 企业性质表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param Qualitydatabaseid 企业性质编号 
        * @return SQL语句 
        */
        public String DeleteByQualitydatabaseidReturnSQL(int Qualitydatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_enterprist_quality]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [QualitydatabaseID] = ?\n");//-- 企业性质编号
            getDPUpdate().AddNewParameter("Qualitydatabaseid",Qualitydatabaseid ); // 企业性质编号
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByQualitydatabaseid
        /**
        * 根据 <br />
    * QualitydatabaseID Qualitydatabaseid 企业性质编号<br />
 删除数据表t_enterprist_quality 企业性质表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:21:10
        * @param Qualitydatabaseid 企业性质编号 
        */
        public void DeleteByQualitydatabaseid(int Qualitydatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByQualitydatabaseidReturnSQL(Qualitydatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
