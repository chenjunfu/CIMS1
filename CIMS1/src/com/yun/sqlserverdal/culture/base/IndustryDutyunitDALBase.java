
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:21:29
   功能说明: 表t_industry_dutyunit 主管单位表的实体类IndustryDutyunitInfo的数据层基类
   表说明:主管单位表
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
 * 表 t_industry_dutyunit 主管单位表 的实体IndustryDutyunitInfo的数据操作类
 * @author 贾军磊
 *
 */
public class IndustryDutyunitDALBase
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
	public IndustryDutyunitDALBase()
	{

	}

	public IndustryDutyunitDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByDutyunitidReturnSQL
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 统计表t_industry_dutyunit 主管单位表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @param Dutyunitid 责主管位编号 
        * @return SQL语句 
        */
        public String CountByDutyunitidReturnSQL(int Dutyunitid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_industry_dutyunit]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DutyUnitID] = ?\n");//-- 责主管位编号
            getDP().AddNewParameter("Dutyunitid",Dutyunitid ); // 责主管位编号
            return sbStr.toString();
        }
        // [end]
        // [start] CountByDutyunitid
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 统计表t_industry_dutyunit 主管单位表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @param Dutyunitid 责主管位编号 
        * @return 数据量 
        */
        public int CountByDutyunitid(int Dutyunitid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDutyunitidReturnSQL(Dutyunitid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_industry_dutyunit 主管单位表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_industry_dutyunit]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_industry_dutyunit 主管单位表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
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
 返回表t_industry_dutyunit 主管单位表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.IndustryDutyunitInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_industry_dutyunit]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[DutyUnitID] DESC \n");//责主管位编号
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_dutyunit 主管单位表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @return 数据列表的强类型实体类 
        */
        public IndustryDutyunitInfoCollection GetListBy(String OrderBy)
        {
            IndustryDutyunitInfoCollection list = new IndustryDutyunitInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.IndustryDutyunitInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new IndustryDutyunitInfo(rs));
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
 返回表t_industry_dutyunit 主管单位表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @return 数据列表的强类型实体类 
        */
        public IndustryDutyunitInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetIndustryDutyunitInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_industry_dutyunit 主管单位表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_industry_dutyunit]\n");
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
                sbStr.append("		[DutyUnitID] DESC \n");//责主管位编号
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.IndustryDutyunitInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_industry_dutyunit]\n");
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
 返回表t_industry_dutyunit 主管单位表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @return 数据列表的强类型实体类 
        */
        public IndustryDutyunitInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            IndustryDutyunitInfoCollection list = new IndustryDutyunitInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.IndustryDutyunitInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new IndustryDutyunitInfo(rs));
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
 返回表t_industry_dutyunit 主管单位表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @return 数据列表的强类型实体类 
        */
        public IndustryDutyunitInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_dutyunit 主管单位表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
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
 统计表t_industry_dutyunit 主管单位表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetIndustryDutyunitInfoByDutyunitidReturnSQL
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 获取表t_industry_dutyunit 主管单位表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @param Dutyunitid 责主管位编号 
        * @return SQL语句 
        */
        public String GetListByDutyunitidReturnSQL(int Dutyunitid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.IndustryDutyunitInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_industry_dutyunit]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DutyUnitID] = ?\n");//-- 责主管位编号
            getDP().AddNewParameter("Dutyunitid",Dutyunitid ); // 责主管位编号
            return sbStr.toString();
        }
        // [end]
        // [start] GetIndustryDutyunitInfoByDutyunitid
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 获取表t_industry_dutyunit 主管单位表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @param Dutyunitid 责主管位编号 
        * @return IndustryDutyunitInfo对象实体 
        */
        public IndustryDutyunitInfo GetIndustryDutyunitInfoByDutyunitid(int Dutyunitid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByDutyunitidReturnSQL(Dutyunitid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                IndustryDutyunitInfo objIndustryDutyunitInfo = new IndustryDutyunitInfo(rs);
                getDP().Dispose();
                return objIndustryDutyunitInfo;
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
        * 向表t_industry_dutyunit 主管单位表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @param objIndustryDutyunitInfo IndustryDutyunitInfo对象 主管单位表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(IndustryDutyunitInfo objIndustryDutyunitInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_industry_dutyunit]\n");
            sbStr.append("(\n");
            sbStr.append("	[DutyUnitName],\n");//-- 主管单位名
            sbStr.append("	[Linkman],\n");//-- 联系人
            sbStr.append("	[Telphone]\n");//-- 联系电话
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 主管单位名
            getDPUpdate().AddNewParameter("Dutyunitname",objIndustryDutyunitInfo.getDutyunitname()); // 
            sbStr.append("	?,\n");//-- 联系人
            getDPUpdate().AddNewParameter("Linkman",objIndustryDutyunitInfo.getLinkman()); // 
            sbStr.append("	?\n");//-- 联系电话
            getDPUpdate().AddNewParameter("Telphone",objIndustryDutyunitInfo.getTelphone()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_industry_dutyunit 主管单位表中插入数据,返回DutyUnitID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @param objIndustryDutyunitInfo IndustryDutyunitInfo对象 主管单位表 
        * @return 字段IndustryDutyunitID 
        */
        public int Insert(IndustryDutyunitInfo objIndustryDutyunitInfo)
        {
            getDPUpdate().ClearParameter();
            int Dutyunitid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objIndustryDutyunitInfo)));
            objIndustryDutyunitInfo.setDutyunitid(Dutyunitid);//责主管位编号  数据类型:int
            getDPUpdate().Dispose();
            return Dutyunitid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByDutyunitidReturnSQL
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 更新表t_industry_dutyunit 主管单位表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @param objIndustryDutyunitInfo IndustryDutyunitInfo对象 主管单位表 
        * @return SQL语句 
        */
        public String UpdateByDutyunitidReturnSQL(IndustryDutyunitInfo objIndustryDutyunitInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_industry_dutyunit]\n");
            sbStr.append("SET\n");
            sbStr.append("	[DutyUnitName] = ?,\n");//-- 主管单位名
            getDPUpdate().AddNewParameter("Dutyunitname",objIndustryDutyunitInfo.getDutyunitname()); // 主管单位名
            sbStr.append("	[Linkman] = ?,\n");//-- 联系人
            getDPUpdate().AddNewParameter("Linkman",objIndustryDutyunitInfo.getLinkman()); // 联系人
            sbStr.append("	[Telphone] = ?\n");//-- 联系电话
            getDPUpdate().AddNewParameter("Telphone",objIndustryDutyunitInfo.getTelphone()); // 联系电话
            sbStr.append("WHERE\n");
            sbStr.append("	 [DutyUnitID] = ?\n");//-- 责主管位编号
            getDPUpdate().AddNewParameter("Dutyunitid",objIndustryDutyunitInfo.getDutyunitid() ); // 责主管位编号
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByDutyunitid
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 更新表t_industry_dutyunit 主管单位表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @param objIndustryDutyunitInfo IndustryDutyunitInfo对象 主管单位表 
        */
        public void UpdateByDutyunitid(IndustryDutyunitInfo objIndustryDutyunitInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByDutyunitidReturnSQL(objIndustryDutyunitInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByDutyunitidReturnSQL
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 删除数据表t_industry_dutyunit 主管单位表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @param Dutyunitid 责主管位编号 
        * @return SQL语句 
        */
        public String DeleteByDutyunitidReturnSQL(int Dutyunitid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_industry_dutyunit]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DutyUnitID] = ?\n");//-- 责主管位编号
            getDPUpdate().AddNewParameter("Dutyunitid",Dutyunitid ); // 责主管位编号
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByDutyunitid
        /**
        * 根据 <br />
    * DutyUnitID Dutyunitid 责主管位编号<br />
 删除数据表t_industry_dutyunit 主管单位表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:21:29
        * @param Dutyunitid 责主管位编号 
        */
        public void DeleteByDutyunitid(int Dutyunitid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByDutyunitidReturnSQL(Dutyunitid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
