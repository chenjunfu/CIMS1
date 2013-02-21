
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:27:16
   功能说明: 表t_talent_profession 人才所属行业的实体类TalentProfessionInfo的数据层基类
   表说明:人才所属行业
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
 * 表 t_talent_profession 人才所属行业 的实体TalentProfessionInfo的数据操作类
 * @author 贾军磊
 *
 */
public class TalentProfessionDALBase
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
	public TalentProfessionDALBase()
	{

	}

	public TalentProfessionDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByTalentprofessiondatabaseidReturnSQL
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 统计表t_talent_profession 人才所属行业的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @param Talentprofessiondatabaseid TalentProfessiondatabaseID 
        * @return SQL语句 
        */
        public String CountByTalentprofessiondatabaseidReturnSQL(int Talentprofessiondatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_talent_profession]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [TalentProfessiondatabaseID] = ?\n");//-- TalentProfessiondatabaseID
            getDP().AddNewParameter("Talentprofessiondatabaseid",Talentprofessiondatabaseid ); // TalentProfessiondatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByTalentprofessiondatabaseid
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 统计表t_talent_profession 人才所属行业的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @param Talentprofessiondatabaseid TalentProfessiondatabaseID 
        * @return 数据量 
        */
        public int CountByTalentprofessiondatabaseid(int Talentprofessiondatabaseid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByTalentprofessiondatabaseidReturnSQL(Talentprofessiondatabaseid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_talent_profession 人才所属行业的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_talent_profession]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_talent_profession 人才所属行业的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
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
 返回表t_talent_profession 人才所属行业的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.TalentProfessionInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_talent_profession]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[TalentProfessiondatabaseID] DESC \n");//TalentProfessiondatabaseID
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_talent_profession 人才所属行业的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @return 数据列表的强类型实体类 
        */
        public TalentProfessionInfoCollection GetListBy(String OrderBy)
        {
            TalentProfessionInfoCollection list = new TalentProfessionInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.TalentProfessionInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new TalentProfessionInfo(rs));
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
 返回表t_talent_profession 人才所属行业的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @return 数据列表的强类型实体类 
        */
        public TalentProfessionInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetTalentProfessionInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_talent_profession 人才所属行业的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_talent_profession]\n");
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
                sbStr.append("		[TalentProfessiondatabaseID] DESC \n");//TalentProfessiondatabaseID
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.TalentProfessionInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_talent_profession]\n");
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
 返回表t_talent_profession 人才所属行业的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @return 数据列表的强类型实体类 
        */
        public TalentProfessionInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            TalentProfessionInfoCollection list = new TalentProfessionInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.TalentProfessionInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new TalentProfessionInfo(rs));
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
 返回表t_talent_profession 人才所属行业的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @return 数据列表的强类型实体类 
        */
        public TalentProfessionInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_talent_profession 人才所属行业的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
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
 统计表t_talent_profession 人才所属行业的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetTalentProfessionInfoByTalentprofessiondatabaseidReturnSQL
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 获取表t_talent_profession 人才所属行业的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @param Talentprofessiondatabaseid TalentProfessiondatabaseID 
        * @return SQL语句 
        */
        public String GetListByTalentprofessiondatabaseidReturnSQL(int Talentprofessiondatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.TalentProfessionInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_talent_profession]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [TalentProfessiondatabaseID] = ?\n");//-- TalentProfessiondatabaseID
            getDP().AddNewParameter("Talentprofessiondatabaseid",Talentprofessiondatabaseid ); // TalentProfessiondatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] GetTalentProfessionInfoByTalentprofessiondatabaseid
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 获取表t_talent_profession 人才所属行业的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @param Talentprofessiondatabaseid TalentProfessiondatabaseID 
        * @return TalentProfessionInfo对象实体 
        */
        public TalentProfessionInfo GetTalentProfessionInfoByTalentprofessiondatabaseid(int Talentprofessiondatabaseid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByTalentprofessiondatabaseidReturnSQL(Talentprofessiondatabaseid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                TalentProfessionInfo objTalentProfessionInfo = new TalentProfessionInfo(rs);
                getDP().Dispose();
                return objTalentProfessionInfo;
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
        * 向表t_talent_profession 人才所属行业中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @param objTalentProfessionInfo TalentProfessionInfo对象 人才所属行业 
        * @return SQL语句 
        */
        public String InsertReturnSQL(TalentProfessionInfo objTalentProfessionInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_talent_profession]\n");
            sbStr.append("(\n");
            sbStr.append("	[TalentProfessionID],\n");//-- 人才所属行业
            sbStr.append("	[TalentProfessionName]\n");//-- 行业类型名称
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 人才所属行业
            getDPUpdate().AddNewParameter("Talentprofessionid",objTalentProfessionInfo.getTalentprofessionid()); // 
            sbStr.append("	?\n");//-- 行业类型名称
            getDPUpdate().AddNewParameter("Talentprofessionname",objTalentProfessionInfo.getTalentprofessionname()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_talent_profession 人才所属行业中插入数据,返回TalentProfessiondatabaseID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @param objTalentProfessionInfo TalentProfessionInfo对象 人才所属行业 
        * @return 字段TalentProfessionID 
        */
        public int Insert(TalentProfessionInfo objTalentProfessionInfo)
        {
            getDPUpdate().ClearParameter();
            int Talentprofessiondatabaseid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objTalentProfessionInfo)));
            objTalentProfessionInfo.setTalentprofessiondatabaseid(Talentprofessiondatabaseid);//TalentProfessiondatabaseID  数据类型:int
            getDPUpdate().Dispose();
            return Talentprofessiondatabaseid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByTalentprofessiondatabaseidReturnSQL
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 更新表t_talent_profession 人才所属行业中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @param objTalentProfessionInfo TalentProfessionInfo对象 人才所属行业 
        * @return SQL语句 
        */
        public String UpdateByTalentprofessiondatabaseidReturnSQL(TalentProfessionInfo objTalentProfessionInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_talent_profession]\n");
            sbStr.append("SET\n");
            sbStr.append("	[TalentProfessionID] = ?,\n");//-- 人才所属行业
            getDPUpdate().AddNewParameter("Talentprofessionid",objTalentProfessionInfo.getTalentprofessionid()); // 人才所属行业
            sbStr.append("	[TalentProfessionName] = ?\n");//-- 行业类型名称
            getDPUpdate().AddNewParameter("Talentprofessionname",objTalentProfessionInfo.getTalentprofessionname()); // 行业类型名称
            sbStr.append("WHERE\n");
            sbStr.append("	 [TalentProfessiondatabaseID] = ?\n");//-- TalentProfessiondatabaseID
            getDPUpdate().AddNewParameter("Talentprofessiondatabaseid",objTalentProfessionInfo.getTalentprofessiondatabaseid() ); // TalentProfessiondatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByTalentprofessiondatabaseid
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 更新表t_talent_profession 人才所属行业中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @param objTalentProfessionInfo TalentProfessionInfo对象 人才所属行业 
        */
        public void UpdateByTalentprofessiondatabaseid(TalentProfessionInfo objTalentProfessionInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByTalentprofessiondatabaseidReturnSQL(objTalentProfessionInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByTalentprofessiondatabaseidReturnSQL
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 删除数据表t_talent_profession 人才所属行业中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @param Talentprofessiondatabaseid TalentProfessiondatabaseID 
        * @return SQL语句 
        */
        public String DeleteByTalentprofessiondatabaseidReturnSQL(int Talentprofessiondatabaseid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_talent_profession]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [TalentProfessiondatabaseID] = ?\n");//-- TalentProfessiondatabaseID
            getDPUpdate().AddNewParameter("Talentprofessiondatabaseid",Talentprofessiondatabaseid ); // TalentProfessiondatabaseID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByTalentprofessiondatabaseid
        /**
        * 根据 <br />
    * TalentProfessiondatabaseID Talentprofessiondatabaseid TalentProfessiondatabaseID<br />
 删除数据表t_talent_profession 人才所属行业中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:27:16
        * @param Talentprofessiondatabaseid TalentProfessiondatabaseID 
        */
        public void DeleteByTalentprofessiondatabaseid(int Talentprofessiondatabaseid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByTalentprofessiondatabaseidReturnSQL(Talentprofessiondatabaseid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
