
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:26:14
   功能说明: 表t_system_admin_log 管理人员日志表的实体类SystemAdminLogInfo的数据层基类
   表说明:管理人员日志表
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
 * 表 t_system_admin_log 管理人员日志表 的实体SystemAdminLogInfo的数据操作类
 * @author 贾军磊
 *
 */
public class SystemAdminLogDALBase
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
	public SystemAdminLogDALBase()
	{

	}

	public SystemAdminLogDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByLogidReturnSQL
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 统计表t_system_admin_log 管理人员日志表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @param Logid 人员日志编号 
        * @return SQL语句 
        */
        public String CountByLogidReturnSQL(int Logid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_system_admin_log]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [LogID] = ?\n");//-- 人员日志编号
            getDP().AddNewParameter("Logid",Logid ); // 人员日志编号
            return sbStr.toString();
        }
        // [end]
        // [start] CountByLogid
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 统计表t_system_admin_log 管理人员日志表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @param Logid 人员日志编号 
        * @return 数据量 
        */
        public int CountByLogid(int Logid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByLogidReturnSQL(Logid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_system_admin_log 管理人员日志表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_system_admin_log]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_system_admin_log 管理人员日志表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
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
 返回表t_system_admin_log 管理人员日志表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.SystemAdminLogInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_system_admin_log]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[LogID] DESC \n");//人员日志编号
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_system_admin_log 管理人员日志表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @return 数据列表的强类型实体类 
        */
        public SystemAdminLogInfoCollection GetListBy(String OrderBy)
        {
            SystemAdminLogInfoCollection list = new SystemAdminLogInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.SystemAdminLogInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new SystemAdminLogInfo(rs));
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
 返回表t_system_admin_log 管理人员日志表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @return 数据列表的强类型实体类 
        */
        public SystemAdminLogInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetSystemAdminLogInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_system_admin_log 管理人员日志表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_system_admin_log]\n");
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
                sbStr.append("		[LogID] DESC \n");//人员日志编号
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.SystemAdminLogInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_system_admin_log]\n");
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
 返回表t_system_admin_log 管理人员日志表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @return 数据列表的强类型实体类 
        */
        public SystemAdminLogInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            SystemAdminLogInfoCollection list = new SystemAdminLogInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.SystemAdminLogInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new SystemAdminLogInfo(rs));
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
 返回表t_system_admin_log 管理人员日志表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @return 数据列表的强类型实体类 
        */
        public SystemAdminLogInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_system_admin_log 管理人员日志表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
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
 统计表t_system_admin_log 管理人员日志表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetSystemAdminLogInfoByLogidReturnSQL
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 获取表t_system_admin_log 管理人员日志表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @param Logid 人员日志编号 
        * @return SQL语句 
        */
        public String GetListByLogidReturnSQL(int Logid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.SystemAdminLogInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_system_admin_log]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [LogID] = ?\n");//-- 人员日志编号
            getDP().AddNewParameter("Logid",Logid ); // 人员日志编号
            return sbStr.toString();
        }
        // [end]
        // [start] GetSystemAdminLogInfoByLogid
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 获取表t_system_admin_log 管理人员日志表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @param Logid 人员日志编号 
        * @return SystemAdminLogInfo对象实体 
        */
        public SystemAdminLogInfo GetSystemAdminLogInfoByLogid(int Logid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByLogidReturnSQL(Logid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                SystemAdminLogInfo objSystemAdminLogInfo = new SystemAdminLogInfo(rs);
                getDP().Dispose();
                return objSystemAdminLogInfo;
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
        * 向表t_system_admin_log 管理人员日志表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @param objSystemAdminLogInfo SystemAdminLogInfo对象 管理人员日志表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(SystemAdminLogInfo objSystemAdminLogInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_system_admin_log]\n");
            sbStr.append("(\n");
            sbStr.append("	[AdminName],\n");//-- 帐号
            sbStr.append("	[Type],\n");//-- 日志类型：1-操作日志、2-登录日志
            sbStr.append("	[Content],\n");//-- 日志内容
            sbStr.append("	[AddTime],\n");//-- 日志时间
            sbStr.append("	[IP]\n");//-- 日志IP
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 帐号
            getDPUpdate().AddNewParameter("Adminname",objSystemAdminLogInfo.getAdminname()); // 
            sbStr.append("	?,\n");//-- 日志类型：1-操作日志、2-登录日志
            getDPUpdate().AddNewParameter("Type",objSystemAdminLogInfo.getType()); // 
            sbStr.append("	?,\n");//-- 日志内容
            getDPUpdate().AddNewParameter("Content",objSystemAdminLogInfo.getContent()); // 
            sbStr.append("	?,\n");//-- 日志时间
            getDPUpdate().AddNewParameter("Addtime",objSystemAdminLogInfo.getAddtime()); // 
            sbStr.append("	?\n");//-- 日志IP
            getDPUpdate().AddNewParameter("Ip",objSystemAdminLogInfo.getIp()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_system_admin_log 管理人员日志表中插入数据,返回LogID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @param objSystemAdminLogInfo SystemAdminLogInfo对象 管理人员日志表 
        * @return 字段SystemAdminLogID 
        */
        public int Insert(SystemAdminLogInfo objSystemAdminLogInfo)
        {
            getDPUpdate().ClearParameter();
            int Logid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objSystemAdminLogInfo)));
            objSystemAdminLogInfo.setLogid(Logid);//人员日志编号  数据类型:int
            getDPUpdate().Dispose();
            return Logid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByLogidReturnSQL
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 更新表t_system_admin_log 管理人员日志表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @param objSystemAdminLogInfo SystemAdminLogInfo对象 管理人员日志表 
        * @return SQL语句 
        */
        public String UpdateByLogidReturnSQL(SystemAdminLogInfo objSystemAdminLogInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_system_admin_log]\n");
            sbStr.append("SET\n");
            sbStr.append("	[AdminName] = ?,\n");//-- 帐号
            getDPUpdate().AddNewParameter("Adminname",objSystemAdminLogInfo.getAdminname()); // 帐号
            sbStr.append("	[Type] = ?,\n");//-- 日志类型：1-操作日志、2-登录日志
            getDPUpdate().AddNewParameter("Type",objSystemAdminLogInfo.getType()); // 日志类型：1-操作日志、2-登录日志
            sbStr.append("	[Content] = ?,\n");//-- 日志内容
            getDPUpdate().AddNewParameter("Content",objSystemAdminLogInfo.getContent()); // 日志内容
            sbStr.append("	[AddTime] = ?,\n");//-- 日志时间
            getDPUpdate().AddNewParameter("Addtime",objSystemAdminLogInfo.getAddtime()); // 日志时间
            sbStr.append("	[IP] = ?\n");//-- 日志IP
            getDPUpdate().AddNewParameter("Ip",objSystemAdminLogInfo.getIp()); // 日志IP
            sbStr.append("WHERE\n");
            sbStr.append("	 [LogID] = ?\n");//-- 人员日志编号
            getDPUpdate().AddNewParameter("Logid",objSystemAdminLogInfo.getLogid() ); // 人员日志编号
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByLogid
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 更新表t_system_admin_log 管理人员日志表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @param objSystemAdminLogInfo SystemAdminLogInfo对象 管理人员日志表 
        */
        public void UpdateByLogid(SystemAdminLogInfo objSystemAdminLogInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByLogidReturnSQL(objSystemAdminLogInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByLogidReturnSQL
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 删除数据表t_system_admin_log 管理人员日志表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @param Logid 人员日志编号 
        * @return SQL语句 
        */
        public String DeleteByLogidReturnSQL(int Logid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_system_admin_log]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [LogID] = ?\n");//-- 人员日志编号
            getDPUpdate().AddNewParameter("Logid",Logid ); // 人员日志编号
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByLogid
        /**
        * 根据 <br />
    * LogID Logid 人员日志编号<br />
 删除数据表t_system_admin_log 管理人员日志表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:26:14
        * @param Logid 人员日志编号 
        */
        public void DeleteByLogid(int Logid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByLogidReturnSQL(Logid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
