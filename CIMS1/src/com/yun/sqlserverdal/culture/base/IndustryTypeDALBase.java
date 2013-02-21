﻿
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:23:52
   功能说明: 表t_industry_type 产业项目类别类别表的实体类IndustryTypeInfo的数据层基类
   表说明:产业项目类别类别表
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
 * 表 t_industry_type 产业项目类别类别表 的实体IndustryTypeInfo的数据操作类
 * @author 贾军磊
 *
 */
public class IndustryTypeDALBase
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
	public IndustryTypeDALBase()
	{

	}

	public IndustryTypeDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByIndustrydatabaseidReturnSQL
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 统计表t_industry_type 产业项目类别类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @param Industrydatabaseid IndustrydatabaseID 
        * @return SQL语句 
        */
        public String CountByIndustrydatabaseidReturnSQL(int Industrydatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_industry_type]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [IndustrydatabaseID] = ?\n");//-- IndustrydatabaseID
            getDP().AddNewParameter("Industrydatabaseid",Industrydatabaseid ); // IndustrydatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByIndustrydatabaseid
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 统计表t_industry_type 产业项目类别类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @param Industrydatabaseid IndustrydatabaseID 
        * @return 数据量 
        */
        public int CountByIndustrydatabaseid(int Industrydatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByIndustrydatabaseidReturnSQL(Industrydatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_industry_type 产业项目类别类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_industry_type]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_industry_type 产业项目类别类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
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
 返回表t_industry_type 产业项目类别类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.IndustryTypeInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_industry_type]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[IndustrydatabaseID] DESC \n");//IndustrydatabaseID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_type 产业项目类别类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @return 数据列表的强类型实体类 
        */
        public IndustryTypeInfoCollection GetListBy(String OrderBy)
        {
            IndustryTypeInfoCollection list = new IndustryTypeInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.IndustryTypeInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new IndustryTypeInfo(rs));
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
 返回表t_industry_type 产业项目类别类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @return 数据列表的强类型实体类 
        */
        public IndustryTypeInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetIndustryTypeInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_industry_type 产业项目类别类别表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_industry_type]\n");
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
                sbStr.append("		[IndustrydatabaseID] DESC \n");//IndustrydatabaseID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.IndustryTypeInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_industry_type]\n");
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
 返回表t_industry_type 产业项目类别类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @return 数据列表的强类型实体类 
        */
        public IndustryTypeInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            IndustryTypeInfoCollection list = new IndustryTypeInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.IndustryTypeInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new IndustryTypeInfo(rs));
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
 返回表t_industry_type 产业项目类别类别表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @return 数据列表的强类型实体类 
        */
        public IndustryTypeInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_type 产业项目类别类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
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
 统计表t_industry_type 产业项目类别类别表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetIndustryTypeInfoByIndustrydatabaseidReturnSQL
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 获取表t_industry_type 产业项目类别类别表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @param Industrydatabaseid IndustrydatabaseID 
        * @return SQL语句 
        */
        public String GetListByIndustrydatabaseidReturnSQL(int Industrydatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.IndustryTypeInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_industry_type]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [IndustrydatabaseID] = ?\n");//-- IndustrydatabaseID
            getDP().AddNewParameter("Industrydatabaseid",Industrydatabaseid ); // IndustrydatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] GetIndustryTypeInfoByIndustrydatabaseid
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 获取表t_industry_type 产业项目类别类别表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @param Industrydatabaseid IndustrydatabaseID 
        * @return IndustryTypeInfo对象实体 
        */
        public IndustryTypeInfo GetIndustryTypeInfoByIndustrydatabaseid(int Industrydatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByIndustrydatabaseidReturnSQL(Industrydatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                IndustryTypeInfo objIndustryTypeInfo = new IndustryTypeInfo(rs);
                getDP().Dispose();
                return objIndustryTypeInfo;
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
        * 向表t_industry_type 产业项目类别类别表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @param objIndustryTypeInfo IndustryTypeInfo对象 产业项目类别类别表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(IndustryTypeInfo objIndustryTypeInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_industry_type]\n");
            sbStr.append("(\n");
            sbStr.append("	[IndustryID],\n");//-- 产业项目类别编号
            sbStr.append("	[IndustryName]\n");//-- 产业项目类别名称
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 产业项目类别编号
            getDPUpdate().AddNewParameter("Industryid",objIndustryTypeInfo.getIndustryid()); // 
            sbStr.append("	?\n");//-- 产业项目类别名称
            getDPUpdate().AddNewParameter("Industryname",objIndustryTypeInfo.getIndustryname()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_industry_type 产业项目类别类别表中插入数据,返回IndustrydatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @param objIndustryTypeInfo IndustryTypeInfo对象 产业项目类别类别表 
        * @return 字段IndustryTypeID 
        */
        public int Insert(IndustryTypeInfo objIndustryTypeInfo)
        {
            getDPUpdate().ClearParameter();
            int Industrydatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objIndustryTypeInfo)));
            objIndustryTypeInfo.setIndustrydatabaseid(Industrydatabaseid);//IndustrydatabaseID  数据类型:int
            getDPUpdate().Dispose();
            return Industrydatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByIndustrydatabaseidReturnSQL
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 更新表t_industry_type 产业项目类别类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @param objIndustryTypeInfo IndustryTypeInfo对象 产业项目类别类别表 
        * @return SQL语句 
        */
        public String UpdateByIndustrydatabaseidReturnSQL(IndustryTypeInfo objIndustryTypeInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_industry_type]\n");
            sbStr.append("SET\n");
            sbStr.append("	[IndustryID] = ?,\n");//-- 产业项目类别编号
            getDPUpdate().AddNewParameter("Industryid",objIndustryTypeInfo.getIndustryid()); // 产业项目类别编号
            sbStr.append("	[IndustryName] = ?\n");//-- 产业项目类别名称
            getDPUpdate().AddNewParameter("Industryname",objIndustryTypeInfo.getIndustryname()); // 产业项目类别名称
            sbStr.append("WHERE\n");
            sbStr.append("	 [IndustrydatabaseID] = ?\n");//-- IndustrydatabaseID
            getDPUpdate().AddNewParameter("Industrydatabaseid",objIndustryTypeInfo.getIndustrydatabaseid() ); // IndustrydatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByIndustrydatabaseid
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 更新表t_industry_type 产业项目类别类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @param objIndustryTypeInfo IndustryTypeInfo对象 产业项目类别类别表 
        */
        public void UpdateByIndustrydatabaseid(IndustryTypeInfo objIndustryTypeInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByIndustrydatabaseidReturnSQL(objIndustryTypeInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByIndustrydatabaseidReturnSQL
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 删除数据表t_industry_type 产业项目类别类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @param Industrydatabaseid IndustrydatabaseID 
        * @return SQL语句 
        */
        public String DeleteByIndustrydatabaseidReturnSQL(int Industrydatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_industry_type]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [IndustrydatabaseID] = ?\n");//-- IndustrydatabaseID
            getDPUpdate().AddNewParameter("Industrydatabaseid",Industrydatabaseid ); // IndustrydatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByIndustrydatabaseid
        /**
        * 根据 <br />
    * IndustrydatabaseID Industrydatabaseid IndustrydatabaseID<br />
 删除数据表t_industry_type 产业项目类别类别表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:23:52
        * @param Industrydatabaseid IndustrydatabaseID 
        */
        public void DeleteByIndustrydatabaseid(int Industrydatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByIndustrydatabaseidReturnSQL(Industrydatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
