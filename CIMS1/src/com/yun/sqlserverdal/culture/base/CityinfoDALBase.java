
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:19:50
   功能说明: 表t_cityinfo 城市的实体类CityinfoInfo的数据层基类
   表说明:城市
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
 * 表 t_cityinfo 城市 的实体CityinfoInfo的数据操作类
 * @author 贾军磊
 *
 */
public class CityinfoDALBase
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
	public CityinfoDALBase()
	{

	}

	public CityinfoDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByCityidReturnSQL
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 统计表t_cityinfo 城市的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @param Cityid 城市id 
        * @return SQL语句 
        */
        public String CountByCityidReturnSQL(int Cityid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_cityinfo]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [N_CityID] = ?\n");//-- 城市id
            getDP().AddNewParameter("Cityid",Cityid ); // 城市id
            return sbStr.toString();
        }
        // [end]
        // [start] CountByCityid
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 统计表t_cityinfo 城市的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @param Cityid 城市id 
        * @return 数据量 
        */
        public int CountByCityid(int Cityid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByCityidReturnSQL(Cityid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_cityinfo 城市的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_cityinfo]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_cityinfo 城市的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
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
 返回表t_cityinfo 城市的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.CityinfoInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_cityinfo]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[N_CityID] DESC \n");//城市id
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_cityinfo 城市的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @return 数据列表的强类型实体类 
        */
        public CityinfoInfoCollection GetListBy(String OrderBy)
        {
            CityinfoInfoCollection list = new CityinfoInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.CityinfoInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new CityinfoInfo(rs));
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
 返回表t_cityinfo 城市的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @return 数据列表的强类型实体类 
        */
        public CityinfoInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetCityinfoInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_cityinfo 城市的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_cityinfo]\n");
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
                sbStr.append("		[N_CityID] DESC \n");//城市id
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.CityinfoInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_cityinfo]\n");
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
 返回表t_cityinfo 城市的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @return 数据列表的强类型实体类 
        */
        public CityinfoInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            CityinfoInfoCollection list = new CityinfoInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.CityinfoInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new CityinfoInfo(rs));
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
 返回表t_cityinfo 城市的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @return 数据列表的强类型实体类 
        */
        public CityinfoInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_cityinfo 城市的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
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
 统计表t_cityinfo 城市的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetCityinfoInfoByCityidReturnSQL
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 获取表t_cityinfo 城市的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @param Cityid 城市id 
        * @return SQL语句 
        */
        public String GetListByCityidReturnSQL(int Cityid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.CityinfoInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_cityinfo]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [N_CityID] = ?\n");//-- 城市id
            getDP().AddNewParameter("Cityid",Cityid ); // 城市id
            return sbStr.toString();
        }
        // [end]
        // [start] GetCityinfoInfoByCityid
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 获取表t_cityinfo 城市的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @param Cityid 城市id 
        * @return CityinfoInfo对象实体 
        */
        public CityinfoInfo GetCityinfoInfoByCityid(int Cityid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByCityidReturnSQL(Cityid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                CityinfoInfo objCityinfoInfo = new CityinfoInfo(rs);
                getDP().Dispose();
                return objCityinfoInfo;
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
        * 向表t_cityinfo 城市中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @param objCityinfoInfo CityinfoInfo对象 城市 
        * @return SQL语句 
        */
        public String InsertReturnSQL(CityinfoInfo objCityinfoInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_cityinfo]\n");
            sbStr.append("(\n");
            sbStr.append("	[N_ParentID],\n");//-- 父id
            sbStr.append("	[C_CityName],\n");//-- 城市名称
            sbStr.append("	[N_OrderID]\n");//-- 排序id
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 父id
            getDPUpdate().AddNewParameter("Parentid",objCityinfoInfo.getParentid()); // 
            sbStr.append("	?,\n");//-- 城市名称
            getDPUpdate().AddNewParameter("Cityname",objCityinfoInfo.getCityname()); // 
            sbStr.append("	?\n");//-- 排序id
            getDPUpdate().AddNewParameter("Orderid",objCityinfoInfo.getOrderid()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_cityinfo 城市中插入数据,返回N_CityID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @param objCityinfoInfo CityinfoInfo对象 城市 
        * @return 字段CityinfoID 
        */
        public int Insert(CityinfoInfo objCityinfoInfo)
        {
            getDPUpdate().ClearParameter();
            int Cityid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objCityinfoInfo)));
            objCityinfoInfo.setCityid(Cityid);//城市id  数据类型:int
            getDPUpdate().Dispose();
            return Cityid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByCityidReturnSQL
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 更新表t_cityinfo 城市中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @param objCityinfoInfo CityinfoInfo对象 城市 
        * @return SQL语句 
        */
        public String UpdateByCityidReturnSQL(CityinfoInfo objCityinfoInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_cityinfo]\n");
            sbStr.append("SET\n");
            sbStr.append("	[N_ParentID] = ?,\n");//-- 父id
            getDPUpdate().AddNewParameter("Parentid",objCityinfoInfo.getParentid()); // 父id
            sbStr.append("	[C_CityName] = ?,\n");//-- 城市名称
            getDPUpdate().AddNewParameter("Cityname",objCityinfoInfo.getCityname()); // 城市名称
            sbStr.append("	[N_OrderID] = ?\n");//-- 排序id
            getDPUpdate().AddNewParameter("Orderid",objCityinfoInfo.getOrderid()); // 排序id
            sbStr.append("WHERE\n");
            sbStr.append("	 [N_CityID] = ?\n");//-- 城市id
            getDPUpdate().AddNewParameter("Cityid",objCityinfoInfo.getCityid() ); // 城市id
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByCityid
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 更新表t_cityinfo 城市中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @param objCityinfoInfo CityinfoInfo对象 城市 
        */
        public void UpdateByCityid(CityinfoInfo objCityinfoInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByCityidReturnSQL(objCityinfoInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByCityidReturnSQL
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 删除数据表t_cityinfo 城市中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @param Cityid 城市id 
        * @return SQL语句 
        */
        public String DeleteByCityidReturnSQL(int Cityid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_cityinfo]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [N_CityID] = ?\n");//-- 城市id
            getDPUpdate().AddNewParameter("Cityid",Cityid ); // 城市id
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByCityid
        /**
        * 根据 <br />
    * N_CityID Cityid 城市id<br />
 删除数据表t_cityinfo 城市中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:19:50
        * @param Cityid 城市id 
        */
        public void DeleteByCityid(int Cityid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByCityidReturnSQL(Cityid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
