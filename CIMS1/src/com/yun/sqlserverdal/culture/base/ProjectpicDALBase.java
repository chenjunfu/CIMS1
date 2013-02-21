
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:25:25
   功能说明: 表t_projectpic 项目图片表的实体类ProjectpicInfo的数据层基类
   表说明:项目图片表
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
 * 表 t_projectpic 项目图片表 的实体ProjectpicInfo的数据操作类
 * @author 贾军磊
 *
 */
public class ProjectpicDALBase
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
	public ProjectpicDALBase()
	{

	}

	public ProjectpicDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByProjectpicidReturnSQL
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 统计表t_projectpic 项目图片表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @param Projectpicid 项目图片编号 
        * @return SQL语句 
        */
        public String CountByProjectpicidReturnSQL(int Projectpicid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_projectpic]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [ProjectPicID] = ?\n");//-- 项目图片编号
            getDP().AddNewParameter("Projectpicid",Projectpicid ); // 项目图片编号
            return sbStr.toString();
        }
        // [end]
        // [start] CountByProjectpicid
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 统计表t_projectpic 项目图片表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @param Projectpicid 项目图片编号 
        * @return 数据量 
        */
        public int CountByProjectpicid(int Projectpicid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByProjectpicidReturnSQL(Projectpicid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_projectpic 项目图片表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_projectpic]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_projectpic 项目图片表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
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
 返回表t_projectpic 项目图片表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.ProjectpicInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_projectpic]\n");
            if (OrderBy.trim().length() > 0)
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append(OrderBy);
            sbStr.append("\n");
            }
            else
            {
            sbStr.append("	ORDER BY\n");
            sbStr.append("		[ProjectPicID] DESC \n");//项目图片编号
            }
            return sbStr.toString();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_projectpic 项目图片表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @return 数据列表的强类型实体类 
        */
        public ProjectpicInfoCollection GetListBy(String OrderBy)
        {
            ProjectpicInfoCollection list = new ProjectpicInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.ProjectpicInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new ProjectpicInfo(rs));
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
 返回表t_projectpic 项目图片表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @return 数据列表的强类型实体类 
        */
        public ProjectpicInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetProjectpicInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_projectpic 项目图片表的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SET NOCOUNT ON\n");
            if (isCount)
            {
                sbStr.append("		SELECT COUNT(*) FROM [t_projectpic]\n");
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
                sbStr.append("		[ProjectPicID] DESC \n");//项目图片编号
            }
                sbStr.append("		) AS RowIndex,\n");
                if (ColumnNames == null)
                    ColumnNames = com.yun.entities.culture.ProjectpicInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
                sbStr.append("		FROM [t_projectpic]\n");
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
 返回表t_projectpic 项目图片表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @return 数据列表的强类型实体类 
        */
        public ProjectpicInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            ProjectpicInfoCollection list = new ProjectpicInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.ProjectpicInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                list.add(new ProjectpicInfo(rs));
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
 返回表t_projectpic 项目图片表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @return 数据列表的强类型实体类 
        */
        public ProjectpicInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_projectpic 项目图片表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
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
 统计表t_projectpic 项目图片表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetProjectpicInfoByProjectpicidReturnSQL
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 获取表t_projectpic 项目图片表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @param Projectpicid 项目图片编号 
        * @return SQL语句 
        */
        public String GetListByProjectpicidReturnSQL(int Projectpicid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.ProjectpicInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_projectpic]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [ProjectPicID] = ?\n");//-- 项目图片编号
            getDP().AddNewParameter("Projectpicid",Projectpicid ); // 项目图片编号
            return sbStr.toString();
        }
        // [end]
        // [start] GetProjectpicInfoByProjectpicid
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 获取表t_projectpic 项目图片表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @param Projectpicid 项目图片编号 
        * @return ProjectpicInfo对象实体 
        */
        public ProjectpicInfo GetProjectpicInfoByProjectpicid(int Projectpicid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByProjectpicidReturnSQL(Projectpicid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                ProjectpicInfo objProjectpicInfo = new ProjectpicInfo(rs);
                getDP().Dispose();
                return objProjectpicInfo;
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
        * 向表t_projectpic 项目图片表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @param objProjectpicInfo ProjectpicInfo对象 项目图片表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(ProjectpicInfo objProjectpicInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_projectpic]\n");
            sbStr.append("(\n");
            sbStr.append("	[DatabaseProjectID],\n");//-- 项目编号
            sbStr.append("	[Pic]\n");//-- 项目图片
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 项目编号
            getDPUpdate().AddNewParameter("Databaseprojectid",objProjectpicInfo.getDatabaseprojectid()); // 
            sbStr.append("	?\n");//-- 项目图片
            getDPUpdate().AddNewParameter("Pic",objProjectpicInfo.getPic()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_projectpic 项目图片表中插入数据,返回ProjectPicID字段内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @param objProjectpicInfo ProjectpicInfo对象 项目图片表 
        * @return 字段ProjectpicID 
        */
        public int Insert(ProjectpicInfo objProjectpicInfo)
        {
            getDPUpdate().ClearParameter();
            int Projectpicid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objProjectpicInfo)));
            objProjectpicInfo.setProjectpicid(Projectpicid);//项目图片编号  数据类型:int
            getDPUpdate().Dispose();
            return Projectpicid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByProjectpicidReturnSQL
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 更新表t_projectpic 项目图片表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @param objProjectpicInfo ProjectpicInfo对象 项目图片表 
        * @return SQL语句 
        */
        public String UpdateByProjectpicidReturnSQL(ProjectpicInfo objProjectpicInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_projectpic]\n");
            sbStr.append("SET\n");
            sbStr.append("	[DatabaseProjectID] = ?,\n");//-- 项目编号
            getDPUpdate().AddNewParameter("Databaseprojectid",objProjectpicInfo.getDatabaseprojectid()); // 项目编号
            sbStr.append("	[Pic] = ?\n");//-- 项目图片
            getDPUpdate().AddNewParameter("Pic",objProjectpicInfo.getPic()); // 项目图片
            sbStr.append("WHERE\n");
            sbStr.append("	 [ProjectPicID] = ?\n");//-- 项目图片编号
            getDPUpdate().AddNewParameter("Projectpicid",objProjectpicInfo.getProjectpicid() ); // 项目图片编号
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByProjectpicid
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 更新表t_projectpic 项目图片表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @param objProjectpicInfo ProjectpicInfo对象 项目图片表 
        */
        public void UpdateByProjectpicid(ProjectpicInfo objProjectpicInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByProjectpicidReturnSQL(objProjectpicInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByProjectpicidReturnSQL
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 删除数据表t_projectpic 项目图片表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @param Projectpicid 项目图片编号 
        * @return SQL语句 
        */
        public String DeleteByProjectpicidReturnSQL(int Projectpicid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_projectpic]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [ProjectPicID] = ?\n");//-- 项目图片编号
            getDPUpdate().AddNewParameter("Projectpicid",Projectpicid ); // 项目图片编号
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByProjectpicid
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 删除数据表t_projectpic 项目图片表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:25:25
        * @param Projectpicid 项目图片编号 
        */
        public void DeleteByProjectpicid(int Projectpicid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByProjectpicidReturnSQL(Projectpicid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
